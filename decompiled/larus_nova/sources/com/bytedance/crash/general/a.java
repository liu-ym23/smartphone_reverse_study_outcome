package com.bytedance.crash.general;

import android.content.Context;
import com.bytedance.crash.i;
import com.bytedance.crash.util.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f203200f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileWrapper f203201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f203202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppInfo f203203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RomInfo f203204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HardwareInfo f203205e;

    public static a a() {
        if (f203200f != null) goto L18;
        monitor-enter(a.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f203200f != null) goto L12;
        Context r100 = i.getContext();     // Catch: Throwable -> L14
        PolarisFileWrapper r101 = i.d();     // Catch: Throwable -> L14
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        f203200f = new a(r100, r101);     // Catch: Throwable -> L14
    L12:
        monitor-exit(a.class);     // Catch: Throwable -> L14
    L18:
        return f203200f;
    }

    public static boolean f() {
        String[] r100 = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        int r101 = 0;
    L4:
        if (r101 >= 11) goto L17;
        if (new PolarisFileWrapper(r100[r101]).exists() == false) goto L9;
        return true;
    L9:
        r101 = r101 + 1;
        goto L4
    L17:
        return false;
    }

    public final AppInfo b() {
        if (this.f203203c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f203203c != null) goto L8;
        this.f203203c = AppInfo.get(this.f203202b, this.f203201a);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f203203c;
    }

    public final HardwareInfo c() {
        if (this.f203205e != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f203205e != null) goto L8;
        this.f203205e = HardwareInfo.get(this.f203202b, this.f203201a);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f203205e;
    }

    public static long d() {
        a r100 = a();
        if (r100 != null) goto L5;
        return -1;
    L5:
        if (r100.f203205e != null) goto L16;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r100.f203205e != null) goto L10;
        r100.f203205e = HardwareInfo.get(r100.f203202b, r100.f203201a);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
    L16:
        return r100.f203205e.getJiffy();
    }

    public static long e(long r100) {
        a r101 = a();
        if (r101 != null) goto L5;
    L12:
        return 0;
    L5:
        if (r100 == 0) goto L7;
        AppInfo r102 = AppInfo.findAppInfo(r101.f203201a, r100);
        if (r102 == null) goto L12;
        return r102.mLastUpdateTime;
    L7:
        return r101.b().mLastUpdateTime;
    }

    public a(Context r100, PolarisFileWrapper r101) {
        this.f203201a = g.b(r101, "general");
        this.f203202b = r100;
    }

    public static void g(JSONObject r100, long r101) {
        a r102 = a();
        if (r102 == null) goto L13;
        AppInfo r103 = r102.b();
        if (r101 > 0) goto L7;
    L11:
        r103.putTo(r100);
        return;
    L7:
        if (r101 >= r103.mLastUpdateTime) goto L11;
        AppInfo r104 = AppInfo.findAppInfo(r102.f203201a, r101);
        if (r104 == null) goto L11;
        r103 = r104;
        goto L11
    }
}
