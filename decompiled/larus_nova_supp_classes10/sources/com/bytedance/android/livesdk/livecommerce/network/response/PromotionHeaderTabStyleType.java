package com.bytedance.android.livesdk.livecommerce.network.response;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionHeaderTabStyleType;", "", "", "value", "I", "getValue", "()I", "DEFAULT", "NO_BORDER", "ROUND_RECT", "DESIGN_UPGRADE", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PromotionHeaderTabStyleType extends Enum<PromotionHeaderTabStyleType> {
    public static final PromotionHeaderTabStyleType DEFAULT = null;
    public static final PromotionHeaderTabStyleType DESIGN_UPGRADE = null;
    public static final PromotionHeaderTabStyleType NO_BORDER = null;
    public static final PromotionHeaderTabStyleType ROUND_RECT = null;
    public static final /* synthetic */ PromotionHeaderTabStyleType[] a = null;
    private final int value;

    static {
        PromotionHeaderTabStyleType r1 = new PromotionHeaderTabStyleType("DEFAULT", 0, 0);
        DEFAULT = r1;
        PromotionHeaderTabStyleType r2 = new PromotionHeaderTabStyleType("NO_BORDER", 1, 1);
        NO_BORDER = r2;
        PromotionHeaderTabStyleType r3 = new PromotionHeaderTabStyleType("ROUND_RECT", 2, 2);
        ROUND_RECT = r3;
        PromotionHeaderTabStyleType r4 = new PromotionHeaderTabStyleType("DESIGN_UPGRADE", 3, 3);
        DESIGN_UPGRADE = r4;
        a = new PromotionHeaderTabStyleType[]{r1, r2, r3, r4};
    }

    public static PromotionHeaderTabStyleType valueOf(String r1) {
        return (PromotionHeaderTabStyleType) a.a(PromotionHeaderTabStyleType.class, r1);
    }

    public static PromotionHeaderTabStyleType[] values() {
        return (PromotionHeaderTabStyleType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PromotionHeaderTabStyleType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
