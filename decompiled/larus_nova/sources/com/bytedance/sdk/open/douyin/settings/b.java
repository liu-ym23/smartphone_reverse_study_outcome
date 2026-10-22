package com.bytedance.sdk.open.douyin.settings;

import android.os.SystemClock;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes22.dex */
public class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f269683f = "LockObject";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ConcurrentHashMap<String, b> f269684g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f269685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FileLock f269686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ReentrantLock f269687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RandomAccessFile f269688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f269689e;

    static {
        f269684g = new ConcurrentHashMap();
    }

    private b(File r100) {
        this.f269686b = null;
        this.f269687c = new ReentrantLock();
        this.f269688d = null;
        this.f269689e = 0;
        this.f269685a = r100;
    }

    public static b a(File r100) {
        b r101 = f269684g.get(r100.getAbsolutePath());
        if (r101 != null) goto L8;
        r101 = new b(r100);
        b r102 = f269684g.putIfAbsent(r100.getAbsolutePath(), r101);
        if (r102 == null) goto L8;
        return r102;
    L8:
        return r101;
    }

    public void a() {
        if (this.f269687c.isHeldByCurrentThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Check thread fail: not held by current thread");
    }

    public boolean a(long r100) {
        long r101 = SystemClock.elapsedRealtime();
        if (this.f269687c.tryLock(r100, TimeUnit.MILLISECONDS) == true) goto L8;
        return false;
    L8:
        if (this.f269687c.getHoldCount() == 1) goto L26;
    L20:
        long r102 = SystemClock.elapsedRealtime() - r101;
        if (r102 <= 200) goto L23;
        LogUtils.w(f269683f, new Object[]{"LockUseTooMuchTime=" + r102});
    L23:
        return true;
    L26:
    L18:
        this.f269687c.unlock();
        return false;
    L10:
        if (this.f269685a.exists() == true) goto L13;
        this.f269685a.createNewFile();     // Catch: Exception -> L18
    L13:
        if (this.f269685a.exists() == true) goto L16;
        this.f269687c.unlock();     // Catch: Exception -> L18
        return false;
    L16:
        RandomAccessFile r103 = new RandomAccessFile(this.f269685a, "rw");     // Catch: Exception -> L18
        this.f269688d = r103;     // Catch: Exception -> L18
        this.f269686b = r103.getChannel().lock();     // Catch: Exception -> L18
        this.f269689e = SystemClock.elapsedRealtime();     // Catch: Exception -> L18
        goto L20
    }

    public void b() {
        a();
        long r100 = SystemClock.elapsedRealtime() - this.f269689e;
        if (this.f269687c.getHoldCount() == 1) goto L21;
    L16:
        this.f269687c.unlock();
        if (r100 <= 500) goto L23;
        LogUtils.w(f269683f, new Object[]{"UseTooMuchTimeInLock=" + r100});
        return;
    L23:
        return;
    L21:
        FileLock r101 = this.f269686b;     // Catch: Throwable -> L12 Exception -> L20
        if (r101 == null) goto L8;
        r101.release();     // Catch: Throwable -> L12 Exception -> L20
    L8:
        RandomAccessFile r102 = this.f269688d;     // Catch: Throwable -> L12 Exception -> L20
        if (r102 == null) goto L15;
        r102.getChannel().close();     // Catch: Throwable -> L12 Exception -> L20
    L12:
        th = move-exception;
        this.f269686b = null;
        this.f269688d = null;
        throw th;
    L15:
        this.f269686b = null;
        this.f269688d = null;
        goto L16
    }
}
