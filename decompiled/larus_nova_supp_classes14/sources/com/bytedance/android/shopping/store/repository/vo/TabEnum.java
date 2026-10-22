package com.bytedance.android.shopping.store.repository.vo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b \b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/store/repository/vo/TabEnum;", "", "", "type", "I", "getType", "()I", "SELECTION_TAB", "CATEGORY_TAB", "PRODUCT_TAB", "PRODUCT_NESTED_TAB", "BIGSALE_TAB", "ISV_TAB", "MEMBER_TAB", "ISV_PLUS_TAB", "CUSTOM_SERVICE_TAB", "MOMENTS_TAB", "NEW_PRODUCT", "ACTIVITY_TAB", "LIST_TAB", "MIXED_SELECTION_TAB", "STRATEGY_SELECTION_TAB", "CONFIGURED_SELECTION_TAB", "CENTER_PROFILE_TAB", "HOMEPAGE_TAB", "SHEET_TAB", "BIGSALE_TAB_WHITE", "LIVE_TAB", "SHOP_INNER_FLOW_PAGE", "SHOP_FLOW_PAGE", "SHOP_MOMENT_FLOW_PAGE", "SHOP_COMBINATION_INNER_FLOW_PAGE", "PRODUCT_SHEET_TAB", "PRODUCT_WHITE_BRAND", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabEnum extends Enum<TabEnum> {
    public static final TabEnum ACTIVITY_TAB = null;
    public static final TabEnum BIGSALE_TAB = null;
    public static final TabEnum BIGSALE_TAB_WHITE = null;
    public static final TabEnum CATEGORY_TAB = null;
    public static final TabEnum CENTER_PROFILE_TAB = null;
    public static final TabEnum CONFIGURED_SELECTION_TAB = null;
    public static final TabEnum CUSTOM_SERVICE_TAB = null;
    public static final TabEnum HOMEPAGE_TAB = null;
    public static final TabEnum ISV_PLUS_TAB = null;
    public static final TabEnum ISV_TAB = null;
    public static final TabEnum LIST_TAB = null;
    public static final TabEnum LIVE_TAB = null;
    public static final TabEnum MEMBER_TAB = null;
    public static final TabEnum MIXED_SELECTION_TAB = null;
    public static final TabEnum MOMENTS_TAB = null;
    public static final TabEnum NEW_PRODUCT = null;
    public static final TabEnum PRODUCT_NESTED_TAB = null;
    public static final TabEnum PRODUCT_SHEET_TAB = null;
    public static final TabEnum PRODUCT_TAB = null;
    public static final TabEnum PRODUCT_WHITE_BRAND = null;
    public static final TabEnum SELECTION_TAB = null;
    public static final TabEnum SHEET_TAB = null;
    public static final TabEnum SHOP_COMBINATION_INNER_FLOW_PAGE = null;
    public static final TabEnum SHOP_FLOW_PAGE = null;
    public static final TabEnum SHOP_INNER_FLOW_PAGE = null;
    public static final TabEnum SHOP_MOMENT_FLOW_PAGE = null;
    public static final TabEnum STRATEGY_SELECTION_TAB = null;
    public static final /* synthetic */ TabEnum[] a = null;
    private final int type;

    public static TabEnum valueOf(String r1) {
        return (TabEnum) a.a(TabEnum.class, r1);
    }

    public static TabEnum[] values() {
        return (TabEnum[]) a.clone();
    }

    static {
        TabEnum r1 = new TabEnum("SELECTION_TAB", 0, 1);
        SELECTION_TAB = r1;
        TabEnum r2 = new TabEnum("CATEGORY_TAB", 1, 2);
        CATEGORY_TAB = r2;
        TabEnum r3 = new TabEnum("PRODUCT_TAB", 2, 3);
        PRODUCT_TAB = r3;
        TabEnum r4 = new TabEnum("PRODUCT_NESTED_TAB", 3, 10);
        PRODUCT_NESTED_TAB = r4;
        TabEnum r5 = new TabEnum("BIGSALE_TAB", 4, 4);
        BIGSALE_TAB = r5;
        TabEnum r6 = new TabEnum("ISV_TAB", 5, 5);
        ISV_TAB = r6;
        TabEnum r7 = new TabEnum("MEMBER_TAB", 6, 6);
        MEMBER_TAB = r7;
        TabEnum r8 = new TabEnum("ISV_PLUS_TAB", 7, 7);
        ISV_PLUS_TAB = r8;
        TabEnum r9 = new TabEnum("CUSTOM_SERVICE_TAB", 8, 8);
        CUSTOM_SERVICE_TAB = r9;
        TabEnum r10 = new TabEnum("MOMENTS_TAB", 9, 9);
        MOMENTS_TAB = r10;
        TabEnum r11 = new TabEnum("NEW_PRODUCT", 10, 11);
        NEW_PRODUCT = r11;
        TabEnum r12 = new TabEnum("ACTIVITY_TAB", 11, 12);
        ACTIVITY_TAB = r12;
        TabEnum r13 = new TabEnum("LIST_TAB", 12, 13);
        LIST_TAB = r13;
        TabEnum r14 = new TabEnum("MIXED_SELECTION_TAB", 13, 14);
        MIXED_SELECTION_TAB = r14;
        TabEnum r15 = new TabEnum("STRATEGY_SELECTION_TAB", 14, 15);
        STRATEGY_SELECTION_TAB = r15;
        TabEnum r16 = new TabEnum("CONFIGURED_SELECTION_TAB", 15, 16);
        CONFIGURED_SELECTION_TAB = r16;
        TabEnum r17 = new TabEnum("CENTER_PROFILE_TAB", 16, 17);
        CENTER_PROFILE_TAB = r17;
        TabEnum r18 = new TabEnum("HOMEPAGE_TAB", 17, 100);
        HOMEPAGE_TAB = r18;
        TabEnum r19 = new TabEnum("SHEET_TAB", 18, 18);
        SHEET_TAB = r19;
        TabEnum r20 = new TabEnum("BIGSALE_TAB_WHITE", 19, 21);
        BIGSALE_TAB_WHITE = r20;
        TabEnum r21 = new TabEnum("LIVE_TAB", 20, 25);
        LIVE_TAB = r21;
        TabEnum r22 = new TabEnum("SHOP_INNER_FLOW_PAGE", 21, 299);
        SHOP_INNER_FLOW_PAGE = r22;
        TabEnum r23 = new TabEnum("SHOP_FLOW_PAGE", 22, 201);
        SHOP_FLOW_PAGE = r23;
        TabEnum r24 = new TabEnum("SHOP_MOMENT_FLOW_PAGE", 23, 202);
        SHOP_MOMENT_FLOW_PAGE = r24;
        TabEnum r25 = new TabEnum("SHOP_COMBINATION_INNER_FLOW_PAGE", 24, 203);
        SHOP_COMBINATION_INNER_FLOW_PAGE = r25;
        TabEnum r26 = new TabEnum("PRODUCT_SHEET_TAB", 25, 300);
        PRODUCT_SHEET_TAB = r26;
        TabEnum r27 = new TabEnum("PRODUCT_WHITE_BRAND", 26, 301);
        PRODUCT_WHITE_BRAND = r27;
        a = new TabEnum[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
    }

    public final int getType() {
        return this.type;
    }

    public TabEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
