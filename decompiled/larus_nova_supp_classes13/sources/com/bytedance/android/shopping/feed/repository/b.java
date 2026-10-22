package com.bytedance.android.shopping.feed.repository;

import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ AnchorV3PromotionRequestParam a;
    public final /* synthetic */ String b;

    public b(AnchorV3PromotionRequestParam r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        PromotionPackResponse r5 = (PromotionPackResponse) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        AnchorV3Repository.a(AnchorV3Repository.g, this.a, this.b, r5);
        c.a(r5);
        return r5;
    }
}
