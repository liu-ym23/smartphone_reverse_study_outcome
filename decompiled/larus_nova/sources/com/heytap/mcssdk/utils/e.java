package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.heytap.mcssdk.PushService;

/* JADX INFO: loaded from: classes23.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f276424a = "shared_msg_sdk";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f276425b = "hasDefaultChannelCreated";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f276426c = "decryptTag";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f276427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SharedPreferences f276428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f276429f;

    /* JADX INFO: renamed from: com.heytap.mcssdk.utils.e$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static e f276430a;

        static {
            f276430a = new e(null);
        }

        private a() {
        }
    }

    private e() {
        this.f276429f = new Object();
        Context r100 = PushService.getInstance().getContext();
        if (r100 == null) goto L5;
        this.f276427d = a(r100);
    L5:
        Context r101 = this.f276427d;
        if (r101 == null) goto L9;
        this.f276428e = r101.getSharedPreferences(f276424a, 0);
        return;
    }

    public /* synthetic */ e(AnonymousClass1 r100) {
        this();
    }

    private Context a(Context r100) {
        boolean r101 = com.heytap.mcssdk.utils.a.a();
        d.b("fbeVersion is " + r101);
        if (r101 == false) goto L9;
        if (Build.VERSION.SDK_INT < 24) goto L9;
        return r100.createDeviceProtectedStorageContext();
    L9:
        return r100.getApplicationContext();
    }

    public static e c() {
        return a.f276430a;
    }

    private SharedPreferences d() {
        SharedPreferences r100 = this.f276428e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Object r101 = this.f276429f;
        monitor-enter(r101);
        SharedPreferences r102 = this.f276428e;     // Catch: Throwable -> L16
        if (r102 != null) goto L14;
        Context r103 = this.f276427d;     // Catch: Throwable -> L16
        if (r103 == null) goto L14;
        SharedPreferences r104 = r103.getSharedPreferences(f276424a, 0);     // Catch: Throwable -> L16
        this.f276428e = r104;     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        return r104;
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return r102;
    L16:
        th = move-exception;
        throw th;
    }

    public void a(String r100) {
        SharedPreferences r101 = d();
        if (r101 == null) goto L6;
        r101.edit().putString(f276426c, r100).commit();
        return;
    }

    public void a(boolean r100) {
        SharedPreferences r101 = d();
        if (r101 == null) goto L6;
        r101.edit().putBoolean(f276425b, r100).commit();
        return;
    }

    public boolean a() {
        SharedPreferences r100 = d();
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.getBoolean(f276425b, false);
    }

    public String b() {
        SharedPreferences r100 = d();
        if (r100 != null) goto L5;
        return "DES";
    L5:
        return r100.getString(f276426c, "DES");
    }
}
