package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;

/* JADX INFO: loaded from: classes41.dex */
public class cv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f463309a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f343a = true;

    private static int a(boolean r100) {
        if (r100 == false) goto L5;
        return 1;
    L5:
        return 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static ct m8927a(Context r100) {
        SharedPreferences r101 = m8926a(r100);
        ct r102 = new ct();
        r102.a(r101.getInt("off_up_count", 0));
        r102.b(r101.getInt("off_down_count", 0));
        r102.c(r101.getInt("off_ping_count", 0));
        r102.d(r101.getInt("off_pong_count", 0));
        r102.a(r101.getLong("off_duration", 0));
        r102.e(r101.getInt("on_up_count", 0));
        r102.f(r101.getInt("on_down_count", 0));
        r102.g(r101.getInt("on_ping_count", 0));
        r102.h(r101.getInt("on_pong_count", 0));
        r102.b(r101.getLong("on_duration", 0));
        r102.c(r101.getLong(ILoadStallMonitor.START_TIME, 0));
        r102.d(r101.getLong("end_time", 0));
        r102.i(r101.getInt("xmsf_vc", 0));
        r102.j(r101.getInt("android_vc", 0));
        return r102;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m8928a(Context r100) {
        boolean r101 = false;
        if (f343a == false) goto L13;
        f343a = false;
        SharedPreferences r102 = m8926a(r100);
        int r103 = r102.getInt("xmsf_vc", 0);
        int r104 = r102.getInt("android_vc", 0);
        if (r103 == 0) goto L13;
        if (r104 == 0) goto L13;
        if (r103 == a(r100)) goto L11;
    L12:
        r101 = true;
        goto L13
    L11:
        if (r104 != Build.VERSION.SDK_INT) goto L12;
    L13:
        cs.a("isVcChanged = " + r101);
        return r101;
    }

    private static int a(Context r100) {
        if (f463309a > 0) goto L6;
        f463309a = j.b(r100);
    L6:
        return f463309a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m8926a(Context r100) {
        return r100.getSharedPreferences("sp_power_stats", 0);
    }

    private static void a(Context r100, long r101, int r102) {
        cs.a("upload");
        ct r103 = m8927a(r100);
        new cu().a(r100, r103);
        b(r100, r101, r102);
    }

    private static void b(Context r100, long r101, int r102) {
        cs.a(BasicTestActionHandler.TEST_ACTION_RESET);
        m8926a(r100).edit().clear().putLong(ILoadStallMonitor.START_TIME, r101).putInt("current_screen_state", r102).putLong("current_screen_state_start_time", r101).putInt("xmsf_vc", a(r100)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    public static void c(final Context r100, final long r101, final boolean r102) {
        ad.a(r100).a(new AnonymousClass3(r100, r101, r102));
    }

    public static void d(final Context r100, final long r101, final boolean r102) {
        ad.a(r100).a(new AnonymousClass4(r100, r101, r102));
    }

    public static /* synthetic */ void e(Context r100, long r101, boolean r102) {
        i(r100, r101, r102);
    }

    public static /* synthetic */ void f(Context r100, long r101, boolean r102) {
        j(r100, r101, r102);
    }

    public static /* synthetic */ void g(Context r100, long r101, boolean r102) {
        k(r100, r101, r102);
    }

    public static /* synthetic */ void h(Context r100, long r101, boolean r102) {
        l(r100, r101, r102);
    }

    private static synchronized void i(Context r100, long r110, boolean r111) {
        monitor-enter(cv.class);
        cs.a("recordSendMsg start");     // Catch: Throwable -> L14
        int r101 = a(r111);     // Catch: Throwable -> L14
        SharedPreferences r112 = m8926a(r100);     // Catch: Throwable -> L14
        long r102 = r112.getLong(ILoadStallMonitor.START_TIME, 0);     // Catch: Throwable -> L14
        if (r102 > 0) goto L8;
        a(r100, r112, r110, r101);     // Catch: Throwable -> L14
    L8:
        if (r101 != 1) goto L10;
        int r103 = r112.getInt("on_up_count", 0) + 1;     // Catch: Throwable -> L14
        r112.edit().putInt("on_up_count", r103).apply();     // Catch: Throwable -> L14
    L11:
        a(r100, r102, r110, r103, r101);     // Catch: Throwable -> L14
        cs.a("recordSendMsg complete");     // Catch: Throwable -> L14
        monitor-exit(cv.class);
        return;
    L10:
        r103 = r112.getInt("off_up_count", 0) + 1;     // Catch: Throwable -> L14
        r112.edit().putInt("off_up_count", r103).apply();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private static synchronized void j(Context r100, long r110, boolean r111) {
        monitor-enter(cv.class);
        cs.a("recordReceiveMsg start");     // Catch: Throwable -> L14
        int r101 = a(r111);     // Catch: Throwable -> L14
        SharedPreferences r112 = m8926a(r100);     // Catch: Throwable -> L14
        long r102 = r112.getLong(ILoadStallMonitor.START_TIME, 0);     // Catch: Throwable -> L14
        if (r102 > 0) goto L8;
        a(r100, r112, r110, r101);     // Catch: Throwable -> L14
    L8:
        if (r101 != 1) goto L10;
        int r103 = r112.getInt("on_down_count", 0) + 1;     // Catch: Throwable -> L14
        r112.edit().putInt("on_down_count", r103).apply();     // Catch: Throwable -> L14
    L11:
        a(r100, r102, r110, r103, r101);     // Catch: Throwable -> L14
        cs.a("recordReceiveMsg complete");     // Catch: Throwable -> L14
        monitor-exit(cv.class);
        return;
    L10:
        r103 = r112.getInt("off_down_count", 0) + 1;     // Catch: Throwable -> L14
        r112.edit().putInt("off_down_count", r103).apply();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private static synchronized void k(Context r100, long r110, boolean r111) {
        monitor-enter(cv.class);
        cs.a("recordPing start");     // Catch: Throwable -> L14
        int r101 = a(r111);     // Catch: Throwable -> L14
        SharedPreferences r112 = m8926a(r100);     // Catch: Throwable -> L14
        long r102 = r112.getLong(ILoadStallMonitor.START_TIME, 0);     // Catch: Throwable -> L14
        if (r102 > 0) goto L8;
        a(r100, r112, r110, r101);     // Catch: Throwable -> L14
    L8:
        if (r101 != 1) goto L10;
        int r103 = r112.getInt("on_ping_count", 0) + 1;     // Catch: Throwable -> L14
        r112.edit().putInt("on_ping_count", r103).apply();     // Catch: Throwable -> L14
    L11:
        a(r100, r102, r110, r103, r101);     // Catch: Throwable -> L14
        cs.a("recordPing complete");     // Catch: Throwable -> L14
        monitor-exit(cv.class);
        return;
    L10:
        r103 = r112.getInt("off_ping_count", 0) + 1;     // Catch: Throwable -> L14
        r112.edit().putInt("off_ping_count", r103).apply();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private static synchronized void l(Context r100, long r110, boolean r111) {
        monitor-enter(cv.class);
        cs.a("recordPong start");     // Catch: Throwable -> L14
        int r101 = a(r111);     // Catch: Throwable -> L14
        SharedPreferences r112 = m8926a(r100);     // Catch: Throwable -> L14
        long r102 = r112.getLong(ILoadStallMonitor.START_TIME, 0);     // Catch: Throwable -> L14
        if (r102 > 0) goto L8;
        a(r100, r112, r110, r101);     // Catch: Throwable -> L14
    L8:
        if (r101 != 1) goto L10;
        int r103 = r112.getInt("on_pong_count", 0) + 1;     // Catch: Throwable -> L14
        r112.edit().putInt("on_pong_count", r103).apply();     // Catch: Throwable -> L14
    L11:
        a(r100, r102, r110, r103, r101);     // Catch: Throwable -> L14
        cs.a("recordPong complete");     // Catch: Throwable -> L14
        monitor-exit(cv.class);
        return;
    L10:
        r103 = r112.getInt("off_pong_count", 0) + 1;     // Catch: Throwable -> L14
        r112.edit().putInt("off_pong_count", r103).apply();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static void a(final Context r100, final long r101, final boolean r102) {
        ad.a(r100).a(new AnonymousClass1(r100, r101, r102));
    }

    public static void b(final Context r100, final long r101, final boolean r102) {
        ad.a(r100).a(new AnonymousClass2(r100, r101, r102));
    }

    private static void a(Context r100, SharedPreferences r101, long r102, int r103) {
        cs.a("recordInit");
        r101.edit().putLong(ILoadStallMonitor.START_TIME, r102).putInt("current_screen_state", r103).putLong("current_screen_state_start_time", r102).putInt("xmsf_vc", a(r100)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context r100, long r101, long r102, int r103, int r104) {
        if (r101 > 0) goto L5;
        return;
    L5:
        if (m8928a(r100) == false) goto L7;
    L10:
        m8926a(r100).edit().putLong("end_time", r102).apply();
        a(r100, r102, r104);
        return;
    L7:
        if (r103 >= 1073741823) goto L10;
        if ((r102 - r101) >= 86400000) goto L10;
    }
}
