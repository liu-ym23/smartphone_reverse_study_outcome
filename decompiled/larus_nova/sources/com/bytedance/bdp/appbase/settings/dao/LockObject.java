package com.bytedance.bdp.appbase.settings.dao;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.bdp.appbase.base.monitor.BdpAppMonitor;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import g94.b;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/bdp/appbase/settings/dao/LockObject;", "", "", "timeout", "", "tryLock", "", "unlock", "checkThread", "Ljava/nio/channels/FileLock;", "fileLock", "Ljava/nio/channels/FileLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "threadLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/io/RandomAccessFile;", "raf", "Ljava/io/RandomAccessFile;", "obtainLockTimeStamp", "J", "Ljava/io/File;", "lockFile", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class LockObject {
    public static final a Companion = null;
    private static final String TAG = "LockObject";
    private static final ConcurrentHashMap<String, LockObject> lockMap = null;
    private FileLock fileLock;
    private final File lockFile;
    private long obtainLockTimeStamp;
    private RandomAccessFile raf;
    private final ReentrantLock threadLock;

    public static final class a {
        public a() {
        }

        public static LockObject a(File r100) {
            LockObject r101 = (LockObject) LockObject.access$getLockMap$cp().get(r100.getAbsolutePath());
            if (r101 != null) goto L8;
            LockObject r102 = new LockObject(r100, null);
            LockObject r103 = (LockObject) LockObject.access$getLockMap$cp().putIfAbsent(r100.getAbsolutePath(), r102);
            if (r103 != null) goto L7;
            return r102;
        L7:
            return r103;
        L8:
            return r101;
        }
    }

    static {
        Companion = new a();
        lockMap = new ConcurrentHashMap();
    }

    public final void checkThread() {
        if (this.threadLock.isHeldByCurrentThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Check thread fail: not held by current thread");
    }

    public final void unlock() {
        checkThread();
        long r100 = SystemClock.elapsedRealtime() - this.obtainLockTimeStamp;
        if (this.threadLock.getHoldCount() == 1) goto L25;
    L21:
        this.threadLock.unlock();
        if (r100 <= 500) goto L28;
        BdpAppMonitor.c("UseTooMuchTimeInLock: " + r100, Log.getStackTraceString(new Throwable()));
        return;
    L28:
        return;
    L25:
        FileLock r101 = this.fileLock;     // Catch: Throwable -> L14 Exception -> L16
        if (r101 == null) goto L8;
        r101.release();     // Catch: Throwable -> L14 Exception -> L16
    L8:
        RandomAccessFile r102 = this.raf;     // Catch: Throwable -> L14 Exception -> L16
        if (r102 == null) goto L18;
        FileChannel r103 = r102.getChannel();     // Catch: Throwable -> L14 Exception -> L16
        if (r103 == null) goto L18;
        r103.close();     // Catch: Throwable -> L14 Exception -> L16
    L18:
        this.fileLock = null;
        this.raf = null;
    L16:
        e = move-exception;
        BdpAppMonitor.c("ReleaseFileLock", Log.getStackTraceString(e));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.fileLock = null;
        this.raf = null;
        throw th;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getLockMap$cp() {
        return lockMap;
    }

    private LockObject(File r100) {
        this.lockFile = r100;
        this.threadLock = new ReentrantLock();
    }

    public final boolean tryLock(long r100) {
        long r101 = SystemClock.elapsedRealtime();
    L25:
        e = move-exception;
        BdpAppMonitor.c("GetThreadLockFailed: interrupted", Log.getStackTraceString(e));
        return false;
    L4:
        if (this.threadLock.tryLock(r100, TimeUnit.MILLISECONDS) == true) goto L8;
        BdpAppMonitor.c("GetLockWaitTimeout: " + r100, Log.getStackTraceString(new Throwable()));     // Catch: InterruptedException -> L25
        return false;
    L8:
        if (this.threadLock.getHoldCount() == 1) goto L30;
    L21:
        long r102 = SystemClock.elapsedRealtime() - r101;
        if (r102 <= 200) goto L24;
        BdpAppMonitor.c("LockUseTooMuchTime: " + r102, Log.getStackTraceString(new Throwable()));
    L24:
        return true;
    L30:
    L18:
        e = move-exception;
        this.threadLock.unlock();
        b.b(TAG, new Object[]{"LockFileLockFail", e});
        BdpAppMonitor.c("LockFileLockFail: " + this.lockFile.getAbsolutePath(), Log.getStackTraceString(e));
        return false;
    L10:
        if (this.lockFile.exists() == true) goto L13;
        this.lockFile.createNewFile();     // Catch: Exception -> L18
    L13:
        if (this.lockFile.exists() == true) goto L16;
        this.threadLock.unlock();     // Catch: Exception -> L18
        BdpAppMonitor.c("CreateLockFileFail: " + this.lockFile.getAbsolutePath(), Log.getStackTraceString(new Throwable()));     // Catch: Exception -> L18
        return false;
    L16:
        RandomAccessFile r103 = new RandomAccessFile(this.lockFile, "rw");     // Catch: Exception -> L18
        this.raf = r103;     // Catch: Exception -> L18
        this.fileLock = r103.getChannel().lock();     // Catch: Exception -> L18
        this.obtainLockTimeStamp = SystemClock.elapsedRealtime();     // Catch: Exception -> L18
        goto L21
    }

    public /* synthetic */ LockObject(File r100, DefaultConstructorMarker r101) {
        this(r100);
    }
}
