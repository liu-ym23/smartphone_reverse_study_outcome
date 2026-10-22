package com.bytedance.push.frontier;

import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum FrontierStrategy extends Enum<FrontierStrategy> {
    public static final FrontierStrategy STRATEGY_NOT_USE = null;
    public static final FrontierStrategy STRATEGY_USE_HOST = null;
    public static final FrontierStrategy STRATEGY_USE_SDK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FrontierStrategy[] f266869a = null;

    static {
        FrontierStrategy r100 = new FrontierStrategy("STRATEGY_NOT_USE", 0);
        STRATEGY_NOT_USE = r100;
        FrontierStrategy r101 = new FrontierStrategy("STRATEGY_USE_SDK", 1);
        STRATEGY_USE_SDK = r101;
        FrontierStrategy r102 = new FrontierStrategy("STRATEGY_USE_HOST", 2);
        STRATEGY_USE_HOST = r102;
        f266869a = new FrontierStrategy[]{r100, r101, r102};
    }

    public static FrontierStrategy[] values() {
        return (FrontierStrategy[]) f266869a.clone();
    }

    public static FrontierStrategy valueOf(String r100) {
        return (FrontierStrategy) a.a(FrontierStrategy.class, r100);
    }

    public FrontierStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
