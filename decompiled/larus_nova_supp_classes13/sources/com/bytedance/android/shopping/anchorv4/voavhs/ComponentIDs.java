package com.bytedance.android.shopping.anchorv4.voavhs;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/ComponentIDs;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "HEAD_SLIDES", "BASE_INFO", "LOGISTICS_AND_COUPON", "DELETED_PRODUCT_TIP", "COMMENTS", "SHOP_COUPONS", "CAR_ADDRESS", "AUCTION_FLOW", "OFFER_RECORDS", "SHOP_AND_STORE", "RECEIVING_NOTICE", "EP_COURSES", "EP_REGISTER", "EP_TEACHER", "SHOP_CONFIGURED_GOODS", "ABOVE_GUL", "KOL_EVALUATION", "COMBINE", "DETAIL_HEAD", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ComponentIDs extends Enum<ComponentIDs> {
    public static final ComponentIDs ABOVE_GUL = null;
    public static final ComponentIDs AUCTION_FLOW = null;
    public static final ComponentIDs BASE_INFO = null;
    public static final ComponentIDs CAR_ADDRESS = null;
    public static final ComponentIDs COMBINE = null;
    public static final ComponentIDs COMMENTS = null;
    public static final ComponentIDs DELETED_PRODUCT_TIP = null;
    public static final ComponentIDs DETAIL_HEAD = null;
    public static final ComponentIDs EP_COURSES = null;
    public static final ComponentIDs EP_REGISTER = null;
    public static final ComponentIDs EP_TEACHER = null;
    public static final ComponentIDs HEAD_SLIDES = null;
    public static final ComponentIDs KOL_EVALUATION = null;
    public static final ComponentIDs LOGISTICS_AND_COUPON = null;
    public static final ComponentIDs OFFER_RECORDS = null;
    public static final ComponentIDs RECEIVING_NOTICE = null;
    public static final ComponentIDs SHOP_AND_STORE = null;
    public static final ComponentIDs SHOP_CONFIGURED_GOODS = null;
    public static final ComponentIDs SHOP_COUPONS = null;
    public static final /* synthetic */ ComponentIDs[] a = null;
    private final String id;

    public static ComponentIDs valueOf(String r1) {
        return (ComponentIDs) r27.a.a(ComponentIDs.class, r1);
    }

    public static ComponentIDs[] values() {
        return (ComponentIDs[]) a.clone();
    }

    static {
        ComponentIDs r1 = new ComponentIDs("HEAD_SLIDES", 0, "id_head_view");
        HEAD_SLIDES = r1;
        ComponentIDs r2 = new ComponentIDs("BASE_INFO", 1, "id_base_info_view");
        BASE_INFO = r2;
        ComponentIDs r3 = new ComponentIDs("LOGISTICS_AND_COUPON", 2, "id_logistics_coupon_view");
        LOGISTICS_AND_COUPON = r3;
        ComponentIDs r4 = new ComponentIDs("DELETED_PRODUCT_TIP", 3, "id_deleted_product_tip");
        DELETED_PRODUCT_TIP = r4;
        ComponentIDs r5 = new ComponentIDs("COMMENTS", 4, "id_comments");
        COMMENTS = r5;
        ComponentIDs r6 = new ComponentIDs("SHOP_COUPONS", 5, "id_shop_coupons");
        SHOP_COUPONS = r6;
        ComponentIDs r7 = new ComponentIDs("CAR_ADDRESS", 6, "id_car_address");
        CAR_ADDRESS = r7;
        ComponentIDs r8 = new ComponentIDs("AUCTION_FLOW", 7, "id_process_flow");
        AUCTION_FLOW = r8;
        ComponentIDs r9 = new ComponentIDs("OFFER_RECORDS", 8, "id_offer_records");
        OFFER_RECORDS = r9;
        ComponentIDs r10 = new ComponentIDs("SHOP_AND_STORE", 9, "id_shop_and_store");
        SHOP_AND_STORE = r10;
        ComponentIDs r11 = new ComponentIDs("RECEIVING_NOTICE", 10, "id_hainan_tax");
        RECEIVING_NOTICE = r11;
        ComponentIDs r12 = new ComponentIDs("EP_COURSES", 11, "id_ep_courses");
        EP_COURSES = r12;
        ComponentIDs r13 = new ComponentIDs("EP_REGISTER", 12, "id_ep_register");
        EP_REGISTER = r13;
        ComponentIDs r14 = new ComponentIDs("EP_TEACHER", 13, "id_ep_teacher");
        EP_TEACHER = r14;
        ComponentIDs r15 = new ComponentIDs("SHOP_CONFIGURED_GOODS", 14, "id_shop_configured_goods");
        SHOP_CONFIGURED_GOODS = r15;
        ComponentIDs r16 = new ComponentIDs("ABOVE_GUL", 15, "id_above_gul");
        ABOVE_GUL = r16;
        ComponentIDs r17 = new ComponentIDs("KOL_EVALUATION", 16, "id_kol_evaluation");
        KOL_EVALUATION = r17;
        ComponentIDs r18 = new ComponentIDs("COMBINE", 17, "id_combine");
        COMBINE = r18;
        ComponentIDs r19 = new ComponentIDs("DETAIL_HEAD", 18, "id_detail_head");
        DETAIL_HEAD = r19;
        a = new ComponentIDs[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
    }

    public final String getId() {
        return this.id;
    }

    public ComponentIDs(String r1, int r2, String r3) {
        super(r1, r2);
        this.id = r3;
    }
}
