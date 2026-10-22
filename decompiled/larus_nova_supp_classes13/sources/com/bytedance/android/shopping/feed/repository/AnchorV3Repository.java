package com.bytedance.android.shopping.feed.repository;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.jedi.model.combine.Combine;
import com.bytedance.jedi.model.combine.CombineExtensionsKt;
import com.bytedance.jedi.model.combine.Strategies;
import com.bytedance.jedi.model.repository.Repository;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorV3Repository extends Repository {
    public static final d b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final AnchorV3Repository g = null;

    static {
        g = new AnchorV3Repository();
        b = new d();
        c = LazyKt.lazy(AnchorV3Repository$promotionFetcher$2.INSTANCE);
        d = LazyKt.lazy(AnchorV3Repository$autoApplyCouponFetcher$2.INSTANCE);
        e = LazyKt.lazy(AnchorV3Repository$reportCpsTrackFetcher$2.INSTANCE);
        f = LazyKt.lazy(AnchorV3Repository$searchSuggestWordFetcher$2.INSTANCE);
    }

    public AnchorV3Repository() {
    }

    public static Observable b(AnchorV3Repository r2, AnchorV3PromotionRequestParam r3, String r4) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "requestParam");
        d r5 = b;
        if (r5.i(r3) == null) goto L5;
        com.bytedance.android.shopping.monitor.d r6 = com.bytedance.android.shopping.monitor.d.h;
        return ((ud3.a) c.getValue()).a(r3).subscribeOn(Schedulers.io()).map(new a(r3, r4));
    L5:
        com.bytedance.android.shopping.monitor.d r0 = com.bytedance.android.shopping.monitor.d.h;
        Combine r7 = CombineExtensionsKt.a((ud3.a) c.getValue(), r5);
        Strategies.a.getClass();
        Function2 r1 = Strategies.a();
        Intrinsics.checkNotNullParameter(r1, "strategy");
        return new Combine.applyStrategy.1(r1, r7).a(r3).subscribeOn(Schedulers.io()).map(new b(r3, r4));
    }

    public static final void a(AnchorV3Repository r0, AnchorV3PromotionRequestParam r1, String r2, PromotionPackResponse r3) {
        r0.getClass();
        if (r3.isValid() == false) goto L16;
        List r4 = r3.getPromotions();
        if (r4 == null) goto L11;
        PromotionProductStruct r5 = (PromotionProductStruct) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L11;
        PromotionProductBaseStruct r6 = r5.getBaseInfo();
        if (r6 == null) goto L11;
        String r7 = r6.getPromotionId();
    L13:
        if (Intrinsics.areEqual(r2, r7) == false) goto L17;
        b.c(r1, r3);
        return;
    L17:
        return;
    L11:
        r7 = null;
        goto L13
    }
}
