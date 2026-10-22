package com.bytedance.android.shopping.feed.enumeration;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/feed/enumeration/GoodPriceCardOrStripType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Companion", "a", "GOOD_PRICE_CARD_1", "GOOD_PRICE_CARD_2", "MAIN_PRODUCT_BAR", "FAVOURITE_BAR", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GoodPriceCardOrStripType extends Enum<GoodPriceCardOrStripType> {
    public static final a Companion = null;
    public static final GoodPriceCardOrStripType FAVOURITE_BAR = null;
    public static final GoodPriceCardOrStripType GOOD_PRICE_CARD_1 = null;
    public static final GoodPriceCardOrStripType GOOD_PRICE_CARD_2 = null;
    public static final GoodPriceCardOrStripType MAIN_PRODUCT_BAR = null;
    public static final /* synthetic */ GoodPriceCardOrStripType[] a = null;
    private final String type;

    public static final class a {
        public a() {
        }

        public static boolean a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "scene");
            return CollectionsKt.listOf(new String[]{GoodPriceCardOrStripType.GOOD_PRICE_CARD_1.getType(), GoodPriceCardOrStripType.GOOD_PRICE_CARD_2.getType()}).contains(r3);
        }
    }

    static {
        GoodPriceCardOrStripType r1 = new GoodPriceCardOrStripType("GOOD_PRICE_CARD_1", 0, "good_price_card_1");
        GOOD_PRICE_CARD_1 = r1;
        GoodPriceCardOrStripType r2 = new GoodPriceCardOrStripType("GOOD_PRICE_CARD_2", 1, "good_price_card_2");
        GOOD_PRICE_CARD_2 = r2;
        GoodPriceCardOrStripType r3 = new GoodPriceCardOrStripType("MAIN_PRODUCT_BAR", 2, "main_card_bar");
        MAIN_PRODUCT_BAR = r3;
        GoodPriceCardOrStripType r4 = new GoodPriceCardOrStripType("FAVOURITE_BAR", 3, "favourite_card_bar");
        FAVOURITE_BAR = r4;
        a = new GoodPriceCardOrStripType[]{r1, r2, r3, r4};
        Companion = new a();
    }

    public static GoodPriceCardOrStripType valueOf(String r1) {
        return (GoodPriceCardOrStripType) r27.a.a(GoodPriceCardOrStripType.class, r1);
    }

    public static GoodPriceCardOrStripType[] values() {
        return (GoodPriceCardOrStripType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public GoodPriceCardOrStripType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
