package com.bytedance.android.shopping.store.aggregate.viewmodel;

import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.utils.z;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Pair<String, String>[] a(ShopAggregateParam r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "storeParam");
        return z.a(r13.getStoreAccountParam().getUserId(), r13.getEnterFrom(), r13.getStoreSourcePage(), r13.getStoreSourceMethod(), r13.getStoreGroupType(), r13.getEntranceLocation(), r13.getPageName(), r13.getFollowStatus(), r13.isPreview(), r13.getTempId(), r14, new Pair[0]);
    }
}
