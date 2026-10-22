package com.bytedance.android.livesdk.livecommerce.network.response;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionHeaderStoreEntranceType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "DEFAULT", "FUSION", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PromotionHeaderStoreEntranceType extends Enum<PromotionHeaderStoreEntranceType> {
    public static final PromotionHeaderStoreEntranceType DEFAULT = null;
    public static final PromotionHeaderStoreEntranceType FUSION = null;
    public static final /* synthetic */ PromotionHeaderStoreEntranceType[] a = null;
    private final String value;

    static {
        PromotionHeaderStoreEntranceType r1 = new PromotionHeaderStoreEntranceType("DEFAULT", 0, "live_cart");
        DEFAULT = r1;
        PromotionHeaderStoreEntranceType r2 = new PromotionHeaderStoreEntranceType("FUSION", 1, "live_cart_fusion");
        FUSION = r2;
        a = new PromotionHeaderStoreEntranceType[]{r1, r2};
    }

    public static PromotionHeaderStoreEntranceType valueOf(String r1) {
        return (PromotionHeaderStoreEntranceType) a.a(PromotionHeaderStoreEntranceType.class, r1);
    }

    public static PromotionHeaderStoreEntranceType[] values() {
        return (PromotionHeaderStoreEntranceType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public PromotionHeaderStoreEntranceType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
