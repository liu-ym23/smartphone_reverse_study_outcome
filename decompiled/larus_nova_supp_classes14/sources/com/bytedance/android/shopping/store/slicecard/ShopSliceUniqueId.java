package com.bytedance.android.shopping.store.slicecard;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/store/slicecard/ShopSliceUniqueId;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "SHOP_PRODUCT_CARD", "SHOP_PRODUCT_TAB_FILTER", "SHOP_PROFILE", "SHOP_PROFILE_CONCISE", "SHOP_INNER_FLOW_TOP_BAR", "SHOP_TOP_BAR", "SEARCH_RESULT_PAGE", "CLASSIFICATION_SECOND_PAGE", "HYBRID_PAGE_GENERAL_CARD", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopSliceUniqueId extends Enum<ShopSliceUniqueId> {
    public static final ShopSliceUniqueId CLASSIFICATION_SECOND_PAGE = null;
    public static final ShopSliceUniqueId HYBRID_PAGE_GENERAL_CARD = null;
    public static final ShopSliceUniqueId SEARCH_RESULT_PAGE = null;
    public static final ShopSliceUniqueId SHOP_INNER_FLOW_TOP_BAR = null;
    public static final ShopSliceUniqueId SHOP_PRODUCT_CARD = null;
    public static final ShopSliceUniqueId SHOP_PRODUCT_TAB_FILTER = null;
    public static final ShopSliceUniqueId SHOP_PROFILE = null;
    public static final ShopSliceUniqueId SHOP_PROFILE_CONCISE = null;
    public static final ShopSliceUniqueId SHOP_TOP_BAR = null;
    public static final /* synthetic */ ShopSliceUniqueId[] a = null;
    private final String id;

    public static ShopSliceUniqueId valueOf(String r1) {
        return (ShopSliceUniqueId) r27.a.a(ShopSliceUniqueId.class, r1);
    }

    public static ShopSliceUniqueId[] values() {
        return (ShopSliceUniqueId[]) a.clone();
    }

    static {
        ShopSliceUniqueId r1 = new ShopSliceUniqueId("SHOP_PRODUCT_CARD", 0, "shop_product_card");
        SHOP_PRODUCT_CARD = r1;
        ShopSliceUniqueId r2 = new ShopSliceUniqueId("SHOP_PRODUCT_TAB_FILTER", 1, "shop_product_tab_filter");
        SHOP_PRODUCT_TAB_FILTER = r2;
        ShopSliceUniqueId r3 = new ShopSliceUniqueId("SHOP_PROFILE", 2, "shop_profile");
        SHOP_PROFILE = r3;
        ShopSliceUniqueId r4 = new ShopSliceUniqueId("SHOP_PROFILE_CONCISE", 3, "shop_profile_concise");
        SHOP_PROFILE_CONCISE = r4;
        ShopSliceUniqueId r5 = new ShopSliceUniqueId("SHOP_INNER_FLOW_TOP_BAR", 4, "inner_flow_top_bar");
        SHOP_INNER_FLOW_TOP_BAR = r5;
        ShopSliceUniqueId r6 = new ShopSliceUniqueId("SHOP_TOP_BAR", 5, "shop_top_bar");
        SHOP_TOP_BAR = r6;
        ShopSliceUniqueId r7 = new ShopSliceUniqueId("SEARCH_RESULT_PAGE", 6, "shop_search_result_page");
        SEARCH_RESULT_PAGE = r7;
        ShopSliceUniqueId r8 = new ShopSliceUniqueId("CLASSIFICATION_SECOND_PAGE", 7, "cate_second_page");
        CLASSIFICATION_SECOND_PAGE = r8;
        ShopSliceUniqueId r9 = new ShopSliceUniqueId("HYBRID_PAGE_GENERAL_CARD", 8, "hybrid_page_general_card");
        HYBRID_PAGE_GENERAL_CARD = r9;
        a = new ShopSliceUniqueId[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public final String getId() {
        return this.id;
    }

    public ShopSliceUniqueId(String r1, int r2, String r3) {
        super(r1, r2);
        this.id = r3;
    }
}
