package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile i f203217g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f203218h = "default";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f203219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f203220j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f203221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f203222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Application f203223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f203224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f203225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f203226f;

    public static i a() {
        if (f203217g != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f203217g != null) goto L9;
        f203217g = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f203217g;
    }

    public static String c() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(d(), FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);
        if (r100.exists() == true) goto L6;
        com.bytedance.crash.util.g.c(r100);
    L6:
        return r100.getAbsolutePath();
    }

    public i() {
        this.f203224d = System.currentTimeMillis();
        this.f203226f = SystemClock.uptimeMillis();
        long r100 = SystemClock.elapsedRealtime();
        this.f203225e = r100;
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.f203224d -= r100 - Process.getStartElapsedRealtime();
        return;
    }

    public static long b() {
        return a().f203224d;
    }

    public static PolarisFileWrapper d() {
        return a().f203222b;
    }

    public static Context getContext() {
        return a().f203221a;
    }

    public static PolarisFileWrapper e(Context r100) {
        PolarisFileWrapper r101 = d();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return com.bytedance.crash.util.g.b(r100.getFilesDir(), "npth");
    }

    public static void g(Context r100) {
        if (r100 == null) goto L33;
        i r101 = a();
        if (r101.f203223c != null) goto L10;
        if ((r100 instanceof Application) == false) goto L8;
        r101.f203223c = (Application) r100;
        goto L10
    L8:
        r101.f203223c = (Application) r100.getApplicationContext();
    L10:
        if (r101.f203221a != null) goto L21;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L13:
        if (r101.f203221a != null) goto L15;
        r101.f203221a = r100;     // Catch: Throwable -> L17
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L17
    L21:
        if (r101.f203222b != null) goto L31;
        monitor-enter(r101);
    L28:
        th = move-exception;
        throw th;
    L24:
        if (r101.f203222b != null) goto L26;
        r101.f203222b = com.bytedance.crash.util.g.b(r100.getFilesDir(), "npth");     // Catch: Throwable -> L28
    L26:
        monitor-exit(r101);     // Catch: Throwable -> L28
        return;
    L31:
        return;
    L33:
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static void f(long r100, long r101, long r102, String r103) {
        if (f203220j == null) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
    L11:
        String r104 = null;
    L12:
        f203220j = r104;
        if (r104 == null) goto L20;
        NativeBridge.U(r104);
        return;
    L20:
        return;
    L7:
        if (TextUtils.isEmpty(r103) == true) goto L11;
        JSONObject r105 = new JSONObject();
        r105.put("version_code", r100);     // Catch: Throwable -> L16
        r105.put("update_version_code", r101);     // Catch: Throwable -> L16
        r105.put("version_name", r103);     // Catch: Throwable -> L16
        r105.put("manifest_version_code", r102);     // Catch: Throwable -> L16
        r104 = r105.toString();     // Catch: Throwable -> L16
        goto L12
    }
}
