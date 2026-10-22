package com.bytedance.android.window.shop.widget;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/widget/FallbackStrategy;", "", "REPLACE", "REMOVE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FallbackStrategy extends Enum<FallbackStrategy> {
    public static final FallbackStrategy REMOVE = null;
    public static final FallbackStrategy REPLACE = null;
    public static final /* synthetic */ FallbackStrategy[] a = null;

    static {
        FallbackStrategy r1 = new FallbackStrategy("REPLACE", 0);
        REPLACE = r1;
        FallbackStrategy r2 = new FallbackStrategy("REMOVE", 1);
        REMOVE = r2;
        a = new FallbackStrategy[]{r1, r2};
    }

    public static FallbackStrategy valueOf(String r1) {
        return (FallbackStrategy) r27.a.a(FallbackStrategy.class, r1);
    }

    public static FallbackStrategy[] values() {
        return (FallbackStrategy[]) a.clone();
    }

    public FallbackStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
