package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;

/* JADX INFO: loaded from: classes31.dex */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f461769c;
    public static SLog instance;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f461770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Tracer f461771b;

    public static File a() {
        String r100 = c.f461801d;
        d.c r101 = d.b.b();     // Catch: Throwable -> L13
        if (r101 != null) goto L6;
    L8:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L18;
        return new PolarisFileWrapper(Environment.getExternalStorageDirectory(), r100);
    L18:
        return new PolarisFileWrapper(com.tencent.open.utils.g.c(), r100);
    L6:
        if (r101.c() <= c.f461803f) goto L8;
        r102 = true;
    L13:
        th = move-exception;
        e(TAG, "getLogFilePath:", th);
        return null;
    }

    private void d() {
        this.f461770a = new a(new b(a(), c.f461810m, c.f461804g, c.f461805h, c.f461800c, c.f461806i, 10, c.f461802e, c.f461811n));
    }

    public static SLog getInstance() {
        if (instance != null) goto L15;
        monitor-enter(SLog.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        SLog r100 = new SLog();     // Catch: Throwable -> L11
        instance = r100;     // Catch: Throwable -> L11
        r100.d();     // Catch: Throwable -> L11
        f461769c = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(SLog.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public static void release() {
        monitor-enter(SLog.class);
        getInstance().b();     // Catch: Throwable -> L9
        if (instance == null) goto L7;
        instance = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(SLog.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void b() {
        a r100 = this.f461770a;
        if (r100 == null) goto L6;
        r100.a();
        this.f461770a.b();
        this.f461770a = null;
        return;
    }

    public void c() {
        a r100 = this.f461770a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public static void flushLogs() {
        getInstance().c();
    }

    private SLog() {
    }

    private String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        if (d.a(r100) == false) goto L10;
        return "xxxxxx";
    L10:
        return r100;
    }

    public void setCustomLogger(Tracer r100) {
        this.f461771b = r100;
    }

    public static final void d(String r100, String r101) {
        getInstance().a(2, r100, r101, null);
    }

    public static final void e(String r100, String r101) {
        getInstance().a(16, r100, r101, null);
    }

    public static final void i(String r100, String r101) {
        getInstance().a(4, r100, r101, null);
    }

    public static final void u(String r100, String r101) {
        getInstance().a(32, r100, r101, null);
    }

    public static final void v(String r100, String r101) {
        getInstance().a(1, r100, r101, null);
    }

    public static final void w(String r100, String r101) {
        getInstance().a(8, r100, r101, null);
    }

    public static final void d(String r100, String r101, Throwable r102) {
        getInstance().a(2, r100, r101, r102);
    }

    public static final void e(String r100, String r101, Throwable r102) {
        getInstance().a(16, r100, r101, r102);
    }

    public static final void i(String r100, String r101, Throwable r102) {
        getInstance().a(4, r100, r101, r102);
    }

    public static final void u(String r100, String r101, Throwable r102) {
        getInstance().a(32, r100, r101, r102);
    }

    public static final void v(String r100, String r101, Throwable r102) {
        getInstance().a(1, r100, r101, r102);
    }

    public static final void w(String r100, String r101, Throwable r102) {
        getInstance().a(8, r100, r101, r102);
    }

    public void a(int r110, String r111, String r112, Throwable r113) {
        if (f461769c == false) goto L11;
        String r100 = com.tencent.open.utils.g.b();
        if (TextUtils.isEmpty(r100) == true) goto L11;
        String r101 = r100 + " SDK_VERSION:3.5.11.lite";
        if (this.f461770a != null) goto L10;
        return;
    L10:
        e.f461816a.a(32, ThreadMethodProxy.currentThread(), System.currentTimeMillis(), TAG, r101, null);
        this.f461770a.a(32, ThreadMethodProxy.currentThread(), System.currentTimeMillis(), TAG, r101, null);
        f461769c = false;
    L11:
        e.f461816a.a(r110, ThreadMethodProxy.currentThread(), System.currentTimeMillis(), r111, r112, r113);
        if (d.a.a(c.f461799b, r110) == false) goto L17;
        a r102 = this.f461770a;
        if (r102 != null) goto L16;
        return;
    L16:
        r102.a(r110, ThreadMethodProxy.currentThread(), System.currentTimeMillis(), r111, r112, r113);
    L17:
        Tracer r103 = this.f461771b;
        if (r103 == null) goto L24;
        r103.a(r110, ThreadMethodProxy.currentThread(), System.currentTimeMillis(), r111, a(r112), r113);     // Catch: Exception -> L21
        return;
    L25:
        return;
    }
}
