package ht9;

import android.content.Context;
import android.content.SharedPreferences;
import com.larus.settings.value.e10;
import com.larus.settings.value.lm;
import com.larus.settings.value.mg;
import com.larus.settings.value.o5;
import com.larus.settings.value.ve;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qt9.c5;
import qt9.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final a a = null;
    public static volatile boolean b;
    public static int c;
    public static boolean d;
    public static boolean e;
    public static int f;
    public static boolean g;
    public static float h;

    static {
        a = new a();
    }

    public a() {
    }

    public static void a(Context r4) {
        if (b == false) goto L5;
        return;
    L5:
        monitor-enter(a.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (b == false) goto L26;
    L17:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(a.class);
        return;
    L26:
        System.currentTimeMillis();     // Catch: Throwable -> L11
        SharedPreferences r6 = r4.getSharedPreferences("cold_boot_setting_repo", 0);     // Catch: Throwable -> L11
        c = r6.getInt("anr_main_thread_opt_strategy", 0);     // Catch: Throwable -> L11
        d = r6.getBoolean("remove_gc_waiting_enable", false);     // Catch: Throwable -> L11
        e = r6.getBoolean("class_visible_opt_enable", false);     // Catch: Throwable -> L11
        f = r6.getInt("class_visible_opt_max", 0);     // Catch: Throwable -> L11
        g = r6.getBoolean("class_visible_opt_use_membarrier", false);     // Catch: Throwable -> L11
        h = r6.getFloat("young_gc_adjustment", 0.0f);     // Catch: Throwable -> L11
        System.currentTimeMillis();     // Catch: Throwable -> L11
    L13:
        b = true;     // Catch: Throwable -> L20
        goto L17
    L11:
        th = move-exception;
        th.toString();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        b = true;     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    }

    public static int b(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        a(r1);
        return c;
    }

    public static void c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        FLogger.a.i("ColdBootSettings", "updateColdBootSettingRepo start ---->");
        SharedPreferences.Editor r4 = r3.getSharedPreferences("cold_boot_setting_repo", 0).edit();     // Catch: Throwable -> L5
        e10 r0 = e10.a;     // Catch: Throwable -> L5
        int r1 = l0.a;     // Catch: Throwable -> L5
        r4.putInt("anr_main_thread_opt_strategy", ((Number) l0.a(0, new mg())).intValue());     // Catch: Throwable -> L5
        r4.putBoolean("remove_gc_waiting_enable", ((Boolean) l0.a(Boolean.FALSE, new lm())).booleanValue());     // Catch: Throwable -> L5
        e0 r2 = (e0) l0.a(new e0(false, 0, false), new ve());     // Catch: Throwable -> L5
        r4.putBoolean("class_visible_opt_enable", r2.a());     // Catch: Throwable -> L5
        r4.putInt("class_visible_opt_max", r2.b());     // Catch: Throwable -> L5
        r4.putBoolean("class_visible_opt_use_membarrier", r2.c());     // Catch: Throwable -> L5
        r4.putFloat("young_gc_adjustment", ((c5) l0.a(new c5(0.0f), new o5())).a());     // Catch: Throwable -> L5
        r4.apply();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.toString();
    }
}
