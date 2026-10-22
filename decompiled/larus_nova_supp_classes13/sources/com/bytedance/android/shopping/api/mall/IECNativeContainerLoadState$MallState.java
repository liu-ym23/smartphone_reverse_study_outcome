package com.bytedance.android.shopping.api.mall;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"com/bytedance/android/shopping/api/mall/IECNativeContainerLoadState$MallState", "", "Lcom/bytedance/android/shopping/api/mall/IECNativeContainerLoadState$MallState;", "INIT", "LOADING", "CACHE_RENDER", "FMP", "ERROR", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IECNativeContainerLoadState$MallState extends Enum<IECNativeContainerLoadState$MallState> {
    public static final IECNativeContainerLoadState$MallState CACHE_RENDER = null;
    public static final IECNativeContainerLoadState$MallState ERROR = null;
    public static final IECNativeContainerLoadState$MallState FMP = null;
    public static final IECNativeContainerLoadState$MallState INIT = null;
    public static final IECNativeContainerLoadState$MallState LOADING = null;
    public static final /* synthetic */ IECNativeContainerLoadState$MallState[] a = null;

    static {
        IECNativeContainerLoadState$MallState r1 = new IECNativeContainerLoadState$MallState("INIT", 0);
        INIT = r1;
        IECNativeContainerLoadState$MallState r2 = new IECNativeContainerLoadState$MallState("LOADING", 1);
        LOADING = r2;
        IECNativeContainerLoadState$MallState r3 = new IECNativeContainerLoadState$MallState("CACHE_RENDER", 2);
        CACHE_RENDER = r3;
        IECNativeContainerLoadState$MallState r4 = new IECNativeContainerLoadState$MallState("FMP", 3);
        FMP = r4;
        IECNativeContainerLoadState$MallState r5 = new IECNativeContainerLoadState$MallState("ERROR", 4);
        ERROR = r5;
        a = new IECNativeContainerLoadState$MallState[]{r1, r2, r3, r4, r5};
    }

    public static IECNativeContainerLoadState$MallState valueOf(String r1) {
        return (IECNativeContainerLoadState$MallState) r27.a.a(IECNativeContainerLoadState$MallState.class, r1);
    }

    public static IECNativeContainerLoadState$MallState[] values() {
        return (IECNativeContainerLoadState$MallState[]) a.clone();
    }

    public IECNativeContainerLoadState$MallState(String r1, int r2) {
        super(r1, r2);
    }
}
