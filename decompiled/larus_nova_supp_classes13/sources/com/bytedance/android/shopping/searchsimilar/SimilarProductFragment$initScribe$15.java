package com.bytedance.android.shopping.searchsimilar;

import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductState;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SimilarProductFragment$initScribe$15 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new SimilarProductFragment$initScribe$15();
    }

    public SimilarProductFragment$initScribe$15() {
        super(SimilarProductState.class, "isNoData", "isNoData()Z", 0);
    }

    public Object get(Object r1) {
        return Boolean.valueOf(((SimilarProductState) r1).h);
    }
}
