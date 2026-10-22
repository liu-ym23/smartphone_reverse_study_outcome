package com.bytedance.android.shopping.collect.common.controller;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/collect/common/controller/CollectHandleEventOpportunity;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "RECEIVE_PRODUCTS_CLEAN_UP", "PAGE_APPEAR_START", "PAGE_APPEAR_RESUME", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CollectHandleEventOpportunity extends Enum<CollectHandleEventOpportunity> {
    public static final CollectHandleEventOpportunity PAGE_APPEAR_RESUME = null;
    public static final CollectHandleEventOpportunity PAGE_APPEAR_START = null;
    public static final CollectHandleEventOpportunity RECEIVE_PRODUCTS_CLEAN_UP = null;
    public static final /* synthetic */ CollectHandleEventOpportunity[] a = null;
    private final String value;

    static {
        CollectHandleEventOpportunity r1 = new CollectHandleEventOpportunity("RECEIVE_PRODUCTS_CLEAN_UP", 0, "receive_products_clean_up");
        RECEIVE_PRODUCTS_CLEAN_UP = r1;
        CollectHandleEventOpportunity r2 = new CollectHandleEventOpportunity("PAGE_APPEAR_START", 1, "page_appear_start");
        PAGE_APPEAR_START = r2;
        CollectHandleEventOpportunity r3 = new CollectHandleEventOpportunity("PAGE_APPEAR_RESUME", 2, "page_appear_resume");
        PAGE_APPEAR_RESUME = r3;
        a = new CollectHandleEventOpportunity[]{r1, r2, r3};
    }

    public static CollectHandleEventOpportunity valueOf(String r1) {
        return (CollectHandleEventOpportunity) a.a(CollectHandleEventOpportunity.class, r1);
    }

    public static CollectHandleEventOpportunity[] values() {
        return (CollectHandleEventOpportunity[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public CollectHandleEventOpportunity(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
