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
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qt9.c5;
import qt9.e0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f487150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f487151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f487152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f487153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f487154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f487155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f487156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static float f487157h;

    static {
        f487150a = new a();
    }

    public a() {
    }

    public static void a(Context r100) {
        if (f487151b == false) goto L5;
        return;
    L5:
        monitor-enter(a.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (f487151b == false) goto L26;
    L17:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(a.class);
        return;
    L26:
        System.currentTimeMillis();     // Catch: Throwable -> L11
        SharedPreferences r102 = r100.getSharedPreferences("cold_boot_setting_repo", 0);     // Catch: Throwable -> L11
        f487152c = r102.getInt("anr_main_thread_opt_strategy", 0);     // Catch: Throwable -> L11
        f487153d = r102.getBoolean("remove_gc_waiting_enable", false);     // Catch: Throwable -> L11
        f487154e = r102.getBoolean("class_visible_opt_enable", false);     // Catch: Throwable -> L11
        f487155f = r102.getInt("class_visible_opt_max", 0);     // Catch: Throwable -> L11
        f487156g = r102.getBoolean("class_visible_opt_use_membarrier", false);     // Catch: Throwable -> L11
        f487157h = r102.getFloat("young_gc_adjustment", 0.0f);     // Catch: Throwable -> L11
        System.currentTimeMillis();     // Catch: Throwable -> L11
    L13:
        f487151b = true;     // Catch: Throwable -> L20
        goto L17
    L11:
        th = move-exception;
        th.toString();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        f487151b = true;     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    }

    public static int b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        a(r100);
        return f487152c;
    }

    public static void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FLogger.f375446a.i("ColdBootSettings", "updateColdBootSettingRepo start ---->");
        SharedPreferences.Editor r101 = r100.getSharedPreferences("cold_boot_setting_repo", 0).edit();     // Catch: Throwable -> L5
        e10 r102 = e10.f368561a;     // Catch: Throwable -> L5
        int r103 = l0.f375430a;     // Catch: Throwable -> L5
        r101.putInt("anr_main_thread_opt_strategy", ((Number) l0.a(0, new mg())).intValue());     // Catch: Throwable -> L5
        r101.putBoolean("remove_gc_waiting_enable", ((Boolean) l0.a(Boolean.FALSE, new lm())).booleanValue());     // Catch: Throwable -> L5
        e0 r104 = (e0) l0.a(new e0(false, 0, false), new ve());     // Catch: Throwable -> L5
        r101.putBoolean("class_visible_opt_enable", r104.a());     // Catch: Throwable -> L5
        r101.putInt("class_visible_opt_max", r104.b());     // Catch: Throwable -> L5
        r101.putBoolean("class_visible_opt_use_membarrier", r104.c());     // Catch: Throwable -> L5
        r101.putFloat("young_gc_adjustment", ((c5) l0.a(new c5(0.0f), new o5())).a());     // Catch: Throwable -> L5
        r101.apply();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.toString();
    }
}
