package com.bytedance.android.shopping.model.buynow;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/model/buynow/BuyNowPrefetchType;", "", "FIRST_SHOW", "CLICK", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowPrefetchType extends Enum<BuyNowPrefetchType> {
    public static final BuyNowPrefetchType CLICK = null;
    public static final BuyNowPrefetchType FIRST_SHOW = null;
    public static final /* synthetic */ BuyNowPrefetchType[] a = null;

    static {
        BuyNowPrefetchType r1 = new BuyNowPrefetchType("FIRST_SHOW", 0);
        FIRST_SHOW = r1;
        BuyNowPrefetchType r2 = new BuyNowPrefetchType("CLICK", 1);
        CLICK = r2;
        a = new BuyNowPrefetchType[]{r1, r2};
    }

    public static BuyNowPrefetchType valueOf(String r1) {
        return (BuyNowPrefetchType) a.a(BuyNowPrefetchType.class, r1);
    }

    public static BuyNowPrefetchType[] values() {
        return (BuyNowPrefetchType[]) a.clone();
    }

    public BuyNowPrefetchType(String r1, int r2) {
        super(r1, r2);
    }
}
