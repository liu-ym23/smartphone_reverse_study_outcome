package com.bytedance.android.shopping.store.slicecard;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/store/slicecard/ShopSliceKey;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "PRODUCT_COVER", "SHOP_LOGO", "SHOP_NAME", "FOLLOW_BUTTON", "SHARE_BUTTON", "SLICE_INFO", "SHOP_SEARCH", "SHORT_TERM_INDICATORS", "LONG_TERM_INDICATORS", "SPLIT_CLOSE_BUTTON", "SWITCH_LAYOUT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopSliceKey extends Enum<ShopSliceKey> {
    public static final ShopSliceKey FOLLOW_BUTTON = null;
    public static final ShopSliceKey LONG_TERM_INDICATORS = null;
    public static final ShopSliceKey PRODUCT_COVER = null;
    public static final ShopSliceKey SHARE_BUTTON = null;
    public static final ShopSliceKey SHOP_LOGO = null;
    public static final ShopSliceKey SHOP_NAME = null;
    public static final ShopSliceKey SHOP_SEARCH = null;
    public static final ShopSliceKey SHORT_TERM_INDICATORS = null;
    public static final ShopSliceKey SLICE_INFO = null;
    public static final ShopSliceKey SPLIT_CLOSE_BUTTON = null;
    public static final ShopSliceKey SWITCH_LAYOUT = null;
    public static final /* synthetic */ ShopSliceKey[] a = null;
    private final String key;

    public static ShopSliceKey valueOf(String r1) {
        return (ShopSliceKey) r27.a.a(ShopSliceKey.class, r1);
    }

    public static ShopSliceKey[] values() {
        return (ShopSliceKey[]) a.clone();
    }

    static {
        ShopSliceKey r1 = new ShopSliceKey("PRODUCT_COVER", 0, "product_cover");
        PRODUCT_COVER = r1;
        ShopSliceKey r2 = new ShopSliceKey("SHOP_LOGO", 1, "shop_logo");
        SHOP_LOGO = r2;
        ShopSliceKey r3 = new ShopSliceKey("SHOP_NAME", 2, "shop_name");
        SHOP_NAME = r3;
        ShopSliceKey r4 = new ShopSliceKey("FOLLOW_BUTTON", 3, "follow_button");
        FOLLOW_BUTTON = r4;
        ShopSliceKey r5 = new ShopSliceKey("SHARE_BUTTON", 4, "share_button");
        SHARE_BUTTON = r5;
        ShopSliceKey r6 = new ShopSliceKey("SLICE_INFO", 5, "top_slice_info");
        SLICE_INFO = r6;
        ShopSliceKey r7 = new ShopSliceKey("SHOP_SEARCH", 6, "shop_search");
        SHOP_SEARCH = r7;
        ShopSliceKey r8 = new ShopSliceKey("SHORT_TERM_INDICATORS", 7, "short_term_indicators");
        SHORT_TERM_INDICATORS = r8;
        ShopSliceKey r9 = new ShopSliceKey("LONG_TERM_INDICATORS", 8, "long_term_indicators");
        LONG_TERM_INDICATORS = r9;
        ShopSliceKey r10 = new ShopSliceKey("SPLIT_CLOSE_BUTTON", 9, "split_close_button");
        SPLIT_CLOSE_BUTTON = r10;
        ShopSliceKey r11 = new ShopSliceKey("SWITCH_LAYOUT", 10, "switch_layout");
        SWITCH_LAYOUT = r11;
        a = new ShopSliceKey[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
    }

    public final String getKey() {
        return this.key;
    }

    public ShopSliceKey(String r1, int r2, String r3) {
        super(r1, r2);
        this.key = r3;
    }
}
