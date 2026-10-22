package com.larus.im.internal.legacy;

import androidx.camera.video.AudioStats;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes29.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f348766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f348767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f348768c = null;

    public static boolean a() {
        ouc.i r100 = (ouc.i) com.larus.im.internal.delegate.y0.i().e("flow_im_sdk_mechanism_config", new ouc.d0(MapsKt.emptyMap()), false).get("new_ab_link_validation_report_rate");     // Catch: Throwable -> L9
        if (r100 == null) goto L11;
        Double r101 = ouc.k.i(ouc.k.o(r100));     // Catch: Throwable -> L9
        if (r101 == null) goto L11;
        double r102 = r101.doubleValue();     // Catch: Throwable -> L9
    L13:
        if (Double.isNaN(r102) == false) goto L15;
        return false;
    L15:
        if (r102 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L18;
        return false;
    L18:
        if (r102 < 1.0d) goto L21;
        return true;
    L21:
        if (Random.Default.nextDouble() >= r102) goto L27;
        return true;
    L27:
        return false;
    L11:
        r102 = 0.0d;
    L9:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("FlowSettingsDelegate", "newABLinkValidationReportRate(): err=" + th.getMessage());
        goto L11
    }

    static {
        f348768c = new Object();
    }

    public static void b(int r110, String r111, Function0 r112) {
        long r100 = System.nanoTime();
        Object r113 = r112.invoke();     // Catch: Throwable -> L11
        long r114 = System.nanoTime() - r100;     // Catch: Throwable -> L11
        double r115 = r114 / 1000000.0d;     // Catch: Throwable -> L11
        com.larus.im.internal.delegate.a.f348188b.i("IMABExperimentReadCostTracker", "read config round=" + r110 + ", key=" + r111 + ", costNs=" + r114 + ", costMs=" + r115 + ", value=" + r113);     // Catch: Throwable -> L11
        com.larus.im.internal.delegate.d1 r101 = com.larus.im.internal.delegate.d1.f348206b;     // Catch: Throwable -> L11
        ouc.e0 r116 = new ouc.e0();     // Catch: Throwable -> L11
        if (r113 == null) goto L6;
        String r117 = r113.toString();     // Catch: Throwable -> L11
    L7:
        if (r117 != null) goto L9;
        r117 = "";
    L9:
        ouc.j.c(r116, "value", r117);     // Catch: Throwable -> L11
        ouc.j.c(r116, "exp_key", r111);     // Catch: Throwable -> L11
        ouc.j.b(r116, "duration_ms", Double.valueOf(r115));     // Catch: Throwable -> L11
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r101.a("flow_ab_experiment_get_value_status", r116.a());     // Catch: Throwable -> L11
        return;
    L6:
        r117 = null;
    L11:
        th = move-exception;
        long r102 = System.nanoTime() - r100;
        com.larus.im.internal.delegate.a.f348188b.e("IMABExperimentReadCostTracker", "read config failed, round=" + r110 + ", key=" + r111 + ", costNs=" + r102 + ", costMs=" + (r102 / 1000000.0d) + ", error=" + th);
    }
}
