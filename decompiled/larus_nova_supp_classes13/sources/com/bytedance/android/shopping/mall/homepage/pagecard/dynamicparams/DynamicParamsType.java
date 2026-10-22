package com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/pagecard/dynamicparams/DynamicParamsType;", "", "", "value", "I", "getValue", "()I", "API_PARAMS_WITH_TAB", "API_PARAMS", "COMMON_PARAMS", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DynamicParamsType extends Enum<DynamicParamsType> {
    public static final DynamicParamsType API_PARAMS = null;
    public static final DynamicParamsType API_PARAMS_WITH_TAB = null;
    public static final DynamicParamsType COMMON_PARAMS = null;
    public static final /* synthetic */ DynamicParamsType[] a = null;
    private final int value;

    static {
        DynamicParamsType r1 = new DynamicParamsType("API_PARAMS_WITH_TAB", 0, 0);
        API_PARAMS_WITH_TAB = r1;
        DynamicParamsType r2 = new DynamicParamsType("API_PARAMS", 1, 1);
        API_PARAMS = r2;
        DynamicParamsType r3 = new DynamicParamsType("COMMON_PARAMS", 2, 2);
        COMMON_PARAMS = r3;
        a = new DynamicParamsType[]{r1, r2, r3};
    }

    public static DynamicParamsType valueOf(String r1) {
        return (DynamicParamsType) r27.a.a(DynamicParamsType.class, r1);
    }

    public static DynamicParamsType[] values() {
        return (DynamicParamsType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public DynamicParamsType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
