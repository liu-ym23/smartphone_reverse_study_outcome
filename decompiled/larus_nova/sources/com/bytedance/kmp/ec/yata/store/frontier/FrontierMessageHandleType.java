package com.bytedance.kmp.ec.yata.store.frontier;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/ec/yata/store/frontier/FrontierMessageHandleType;", "", "DISCARD", "CACHE", "CACHE_AND_CONSUME", "UPLINK", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final enum FrontierMessageHandleType extends Enum<FrontierMessageHandleType> {
    public static final FrontierMessageHandleType CACHE = null;
    public static final FrontierMessageHandleType CACHE_AND_CONSUME = null;
    public static final FrontierMessageHandleType DISCARD = null;
    public static final FrontierMessageHandleType UPLINK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FrontierMessageHandleType[] f251759a = null;

    public static FrontierMessageHandleType valueOf(String r100) {
        return (FrontierMessageHandleType) r27.a.a(FrontierMessageHandleType.class, r100);
    }

    public static FrontierMessageHandleType[] values() {
        return (FrontierMessageHandleType[]) f251759a.clone();
    }

    static {
        FrontierMessageHandleType r100 = new FrontierMessageHandleType("DISCARD", 0);
        DISCARD = r100;
        FrontierMessageHandleType r101 = new FrontierMessageHandleType("CACHE", 1);
        CACHE = r101;
        FrontierMessageHandleType r102 = new FrontierMessageHandleType("CACHE_AND_CONSUME", 2);
        CACHE_AND_CONSUME = r102;
        FrontierMessageHandleType r103 = new FrontierMessageHandleType("UPLINK", 3);
        UPLINK = r103;
        f251759a = new FrontierMessageHandleType[]{r100, r101, r102, r103};
    }

    public FrontierMessageHandleType(String r100, int r101) {
        super(r100, r101);
    }
}
