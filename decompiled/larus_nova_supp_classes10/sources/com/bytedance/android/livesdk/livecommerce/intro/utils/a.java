package com.bytedance.android.livesdk.livecommerce.intro.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[IntroAuctionAtmosphereHelper.CountState.values().length];
        a = r0;
        IntroAuctionAtmosphereHelper.CountState r1 = IntroAuctionAtmosphereHelper.CountState.FINISHED;
        r0[r1.ordinal()] = 1;
        IntroAuctionAtmosphereHelper.CountState r2 = IntroAuctionAtmosphereHelper.CountState.IN_PROGRESS;
        r0[r2.ordinal()] = 2;
        IntroAuctionAtmosphereHelper.CountState r4 = IntroAuctionAtmosphereHelper.CountState.NOT_START;
        r0[r4.ordinal()] = 3;
        int[] r3 = new int[IntroAuctionAtmosphereHelper.CountState.values().length];
        b = r3;
        r3[r4.ordinal()] = 1;
        r3[r1.ordinal()] = 2;
        r3[r2.ordinal()] = 3;
    }
}
