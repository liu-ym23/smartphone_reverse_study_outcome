package com.bytedance.android.livesdk.livecommerce.define;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/define/PromotionUpdateQueryFromType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "FROM_CARD_WITH_LIST_CLOSE", "FROM_CARD_WITH_LIST_OPEN", "FROM_LIST_WITH_CARD_CLOSE", "FROM_LIST_WITH_CARD_OPEN", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PromotionUpdateQueryFromType extends Enum<PromotionUpdateQueryFromType> {
    public static final a Companion = null;
    public static final PromotionUpdateQueryFromType FROM_CARD_WITH_LIST_CLOSE = null;
    public static final PromotionUpdateQueryFromType FROM_CARD_WITH_LIST_OPEN = null;
    public static final PromotionUpdateQueryFromType FROM_LIST_WITH_CARD_CLOSE = null;
    public static final PromotionUpdateQueryFromType FROM_LIST_WITH_CARD_OPEN = null;
    public static final /* synthetic */ PromotionUpdateQueryFromType[] a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        PromotionUpdateQueryFromType r2 = new PromotionUpdateQueryFromType("FROM_CARD_WITH_LIST_CLOSE", 0, 1);
        FROM_CARD_WITH_LIST_CLOSE = r2;
        PromotionUpdateQueryFromType r3 = new PromotionUpdateQueryFromType("FROM_CARD_WITH_LIST_OPEN", 1, 2);
        FROM_CARD_WITH_LIST_OPEN = r3;
        PromotionUpdateQueryFromType r4 = new PromotionUpdateQueryFromType("FROM_LIST_WITH_CARD_CLOSE", 2, 3);
        FROM_LIST_WITH_CARD_CLOSE = r4;
        PromotionUpdateQueryFromType r5 = new PromotionUpdateQueryFromType("FROM_LIST_WITH_CARD_OPEN", 3, 4);
        FROM_LIST_WITH_CARD_OPEN = r5;
        a = new PromotionUpdateQueryFromType[]{r2, r3, r4, r5};
        Companion = new a();
    }

    public static PromotionUpdateQueryFromType valueOf(String r1) {
        return (PromotionUpdateQueryFromType) r27.a.a(PromotionUpdateQueryFromType.class, r1);
    }

    public static PromotionUpdateQueryFromType[] values() {
        return (PromotionUpdateQueryFromType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PromotionUpdateQueryFromType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
