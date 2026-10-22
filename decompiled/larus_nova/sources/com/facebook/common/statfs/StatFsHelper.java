package com.facebook.common.statfs;

import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.Throwables;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class StatFsHelper {
    private static final long RESTAT_INTERVAL_MS = 0;
    private static StatFsHelper sStatsFsHelper;
    private final Lock lock;
    private volatile File mExternalPath;
    private volatile StatFs mExternalStatFs;
    private volatile boolean mInitialized;
    private volatile File mInternalPath;
    private volatile StatFs mInternalStatFs;
    private long mLastRestatTime;

    public static final enum StorageType extends Enum<StorageType> {
        private static final /* synthetic */ StorageType[] $VALUES = null;
        public static final StorageType EXTERNAL = null;
        public static final StorageType INTERNAL = null;

        static {
            StorageType r100 = new StorageType("INTERNAL", 0);
            INTERNAL = r100;
            StorageType r101 = new StorageType("EXTERNAL", 1);
            EXTERNAL = r101;
            $VALUES = new StorageType[]{r100, r101};
        }

        public static StorageType[] values() {
            return (StorageType[]) $VALUES.clone();
        }

        public static StorageType valueOf(String r100) {
            return (StorageType) Enum.valueOf(StorageType.class, r100);
        }

        private StorageType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        RESTAT_INTERVAL_MS = TimeUnit.MINUTES.toMillis(2);
    }

    private void ensureInitialized() {
        if (this.mInitialized == true) goto L5;
    L6:
        this.lock.lock();
    L18:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L8:
        if (this.mInitialized == true) goto L10;
    L11:
        this.mInternalPath = Environment.getDataDirectory();     // Catch: Throwable -> L18
        this.mExternalPath = Environment.getExternalStorageDirectory();     // Catch: ArrayIndexOutOfBoundsException -> L14 Throwable -> L18
    L15:
        updateStats();     // Catch: Throwable -> L18
        this.mInitialized = true;     // Catch: Throwable -> L18
    L16:
        this.lock.unlock();
        return;
    L14:
        FLog.e("StatFsHelper", "getExternalStorageDirectory return null");     // Catch: Throwable -> L18
        goto L15
    L10:
        if (this.mExternalPath != null) goto L16;
    L5:
        if (this.mExternalPath == null) goto L6;
    }

    public static synchronized StatFsHelper getInstance() {
        monitor-enter(StatFsHelper.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sStatsFsHelper != null) goto L7;
        sStatsFsHelper = new StatFsHelper();     // Catch: Throwable -> L10
    L7:
        StatFsHelper r100 = sStatsFsHelper;     // Catch: Throwable -> L10
        monitor-exit(StatFsHelper.class);
        return r100;
    }

    private void maybeUpdateStats() {
        if (this.lock.tryLock() == true) goto L12;
        return;
    L12:
    L8:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L5:
        if ((SystemClock.uptimeMillis() - this.mLastRestatTime) <= RESTAT_INTERVAL_MS) goto L7;
        updateStats();     // Catch: Throwable -> L8
    L7:
        this.lock.unlock();
    }

    private void updateStats() {
        this.mInternalStatFs = updateStatsHelper(this.mInternalStatFs, this.mInternalPath);
        this.mExternalStatFs = updateStatsHelper(this.mExternalStatFs, this.mExternalPath);
        this.mLastRestatTime = SystemClock.uptimeMillis();
    }

    public void resetStats() {
        if (this.lock.tryLock() == true) goto L10;
        return;
    L10:
        ensureInitialized();     // Catch: Throwable -> L6
        updateStats();     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public StatFsHelper() {
        this.mInternalStatFs = null;
        this.mExternalStatFs = null;
        this.mInitialized = false;
        this.lock = new ReentrantLock();
    }

    public static StatFs createStatFs(String r100) {
        return new StatFs(r100);
    }

    public long getAvailableStorageSpace(StorageType r100) {
        ensureInitialized();
        maybeUpdateStats();
        if (r100 != StorageType.INTERNAL) goto L5;
        StatFs r101 = this.mInternalStatFs;
    L6:
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.getBlockSizeLong() * r101.getAvailableBlocksLong();
    L5:
        r101 = this.mExternalStatFs;
        goto L6
    }

    public long getFreeStorageSpace(StorageType r100) {
        ensureInitialized();
        maybeUpdateStats();
        if (r100 != StorageType.INTERNAL) goto L5;
        StatFs r101 = this.mInternalStatFs;
    L6:
        if (r101 != null) goto L8;
        return -1;
    L8:
        return r101.getBlockSizeLong() * r101.getFreeBlocksLong();
    L5:
        r101 = this.mExternalStatFs;
        goto L6
    }

    public long getTotalStorageSpace(StorageType r100) {
        ensureInitialized();
        maybeUpdateStats();
        if (r100 != StorageType.INTERNAL) goto L5;
        StatFs r101 = this.mInternalStatFs;
    L6:
        if (r101 != null) goto L8;
        return -1;
    L8:
        return r101.getBlockSizeLong() * r101.getBlockCountLong();
    L5:
        r101 = this.mExternalStatFs;
        goto L6
    }

    private StatFs updateStatsHelper(@Nullable StatFs r100, @Nullable File r101) {
        StatFs r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.exists() == false) goto L19;
        if (r100 != null) goto L9;
        r100 = createStatFs(r101.getAbsolutePath());     // Catch: Throwable -> L11 IllegalArgumentException -> L15
    L10:
        r102 = r100;
        goto L20
    L18:
        return r102;
    L9:
        r100.restat(r101.getAbsolutePath());     // Catch: Throwable -> L11 IllegalArgumentException -> L15
    L11:
        th = move-exception;
        throw Throwables.propagate(th);
    L20:
        return r102;
    L19:
        return null;
    }

    public boolean testLowDiskSpace(StorageType r100, long r101) {
        ensureInitialized();
        long r102 = getAvailableStorageSpace(r100);
        if (r102 > 0) goto L5;
        return true;
    L5:
        if (r102 < r101) goto L10;
        return false;
    L10:
        return true;
    }
}
