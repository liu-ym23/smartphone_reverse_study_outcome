package com.bytedance.android.shopping.feed.fragment;

import com.bytedance.android.shopping.feed.viewmodel.ProductFeedState;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ProductFeedContentFragment$initScribe$20 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ProductFeedContentFragment$initScribe$20();
    }

    public ProductFeedContentFragment$initScribe$20() {
        super(ProductFeedState.class, "goodPriceStrips", "getGoodPriceStrips()Ljava/util/List;", 0);
    }

    public Object get(Object r1) {
        return ((ProductFeedState) r1).p;
    }
}
