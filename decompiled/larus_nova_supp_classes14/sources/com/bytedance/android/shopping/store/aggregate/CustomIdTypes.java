package com.bytedance.android.shopping.store.aggregate;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/CustomIdTypes;", "", "", "type", "I", "getType", "()I", "CouponMetaId", "CategoryId", "NewDecorationCategory", "TargetProductId", "TargetCouponMetaId", "TargetPromotionId", "MaterialId", "ActivityId", "LiveAuthorId", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CustomIdTypes extends Enum<CustomIdTypes> {
    public static final CustomIdTypes ActivityId = null;
    public static final CustomIdTypes CategoryId = null;
    public static final CustomIdTypes CouponMetaId = null;
    public static final CustomIdTypes LiveAuthorId = null;
    public static final CustomIdTypes MaterialId = null;
    public static final CustomIdTypes NewDecorationCategory = null;
    public static final CustomIdTypes TargetCouponMetaId = null;
    public static final CustomIdTypes TargetProductId = null;
    public static final CustomIdTypes TargetPromotionId = null;
    public static final /* synthetic */ CustomIdTypes[] a = null;
    private final int type;

    public static CustomIdTypes valueOf(String r1) {
        return (CustomIdTypes) r27.a.a(CustomIdTypes.class, r1);
    }

    public static CustomIdTypes[] values() {
        return (CustomIdTypes[]) a.clone();
    }

    static {
        CustomIdTypes r2 = new CustomIdTypes("CouponMetaId", 0, 1);
        CouponMetaId = r2;
        CustomIdTypes r3 = new CustomIdTypes("CategoryId", 1, 2);
        CategoryId = r3;
        CustomIdTypes r4 = new CustomIdTypes("NewDecorationCategory", 2, 3);
        NewDecorationCategory = r4;
        CustomIdTypes r5 = new CustomIdTypes("TargetProductId", 3, 4);
        TargetProductId = r5;
        CustomIdTypes r6 = new CustomIdTypes("TargetCouponMetaId", 4, 5);
        TargetCouponMetaId = r6;
        CustomIdTypes r7 = new CustomIdTypes("TargetPromotionId", 5, 6);
        TargetPromotionId = r7;
        CustomIdTypes r8 = new CustomIdTypes("MaterialId", 6, 7);
        MaterialId = r8;
        CustomIdTypes r9 = new CustomIdTypes("ActivityId", 7, 8);
        ActivityId = r9;
        CustomIdTypes r10 = new CustomIdTypes("LiveAuthorId", 8, 9);
        LiveAuthorId = r10;
        a = new CustomIdTypes[]{r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final int getType() {
        return this.type;
    }

    public CustomIdTypes(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
