package com.bytedance.android.shopping.feed.repository;

import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.jedi.model.ext.cache.guava.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends LruCache<AnchorV3PromotionRequestParam, PromotionPackResponse> {
    public d() {
    }

    public final /* bridge */ /* synthetic */ Object b(Object r1) {
        return i((AnchorV3PromotionRequestParam) r1);
    }

    public final PromotionPackResponse i(AnchorV3PromotionRequestParam r2) {
        Intrinsics.checkNotNullParameter(r2, "k");
        return (PromotionPackResponse) ((LruCache) this).b.a.getIfPresent(r2);
    }
}
