package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[HotAtmosphereHelperV2.CountState.values().length];
        a = r0;
        HotAtmosphereHelperV2.CountState r1 = HotAtmosphereHelperV2.CountState.FINISHED;
        r0[r1.ordinal()] = 1;
        HotAtmosphereHelperV2.CountState r2 = HotAtmosphereHelperV2.CountState.IN_PROGRESS;
        r0[r2.ordinal()] = 2;
        HotAtmosphereHelperV2.CountState r4 = HotAtmosphereHelperV2.CountState.NOT_START;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[HotAtmosphereHelperV2.CountState.values().length];
        b = r3;
        r3[r4.ordinal()] = 1;
        r3[r1.ordinal()] = 2;
        r3[r2.ordinal()] = 3;
    }
}
