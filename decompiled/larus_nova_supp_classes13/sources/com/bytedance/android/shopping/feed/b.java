package com.bytedance.android.shopping.feed;

import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import com.bytedance.android.shopping.feed.model.GuessULikeAdData;
import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.bytedance.android.shopping.feed.repository.api.InnerGuessULikeApi;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Observer<InflowGuessFeedResponse> {
    public final /* synthetic */ d a;

    public final void onComplete() {
    }

    public b(d r1) {
        this.a = r1;
    }

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        d r0 = this.a;
        r0.c = false;
        r0.a.setValue(null);
        ECExceptionMonitor.e(r3);
    }

    public final void onNext(Object r20) {
        InflowGuessFeedResponse r1 = (InflowGuessFeedResponse) r20;
        Intrinsics.checkNotNullParameter(r1, "resp");
        this.a.getClass();
        rd3.a r2 = (rd3.a) CollectionsKt.firstOrNull(r1.getFeedItemAnchors());
        String r3 = null;
        if (r2 == null) goto L13;
        Promotion r4 = r2.f();
        if (r4 == null) goto L13;
        PromotionProductStruct r5 = r4.getPromotionInfo();
        if (r5 == null) goto L13;
        PromotionProductBaseStruct r6 = r5.getBaseInfo();
        if (r6 == null) goto L13;
        List r7 = r6.getImages();
        if (r7 == null) goto L13;
        ECUrlModel r8 = (ECUrlModel) CollectionsKt.firstOrNull(r7);
    L14:
        boolean r9 = true;
        if (r8 == null) goto L19;
        String r10 = r8.getFirstUrl();
        if (r10 == null) goto L19;
        r r11 = new r("ec_goods_feed", "ec_goods_feed_banner");
        List<String> r12 = ld3.c.c();
        Intrinsics.checkNotNullParameter(r12, "$this$isHitExp");
        r11.g("ec_goods_feed_enable_preconnect", Integer.valueOf(!r12.isEmpty() ? 1 : 0));
        Unit r13 = Unit.INSTANCE;
        ImageExtensionsKt.B(r10, r11, null, null, null, null, null, false, 192);
    L19:
        this.a.a.setValue(r1);
        AnchorV3PromotionRequestParam r14 = this.a.d.getRequestParam();
        Intrinsics.checkNotNullParameter(r14, "$this$isAdRequest");
        if (r14.getAggParams() != null) goto L23;
        r9 = false;
    L23:
        if (r9 == false) goto L32;
        int r15 = ud3.f.a;
        ud3.f.b(r1.getFeedItemAnchors().size());
        Iterator<T> r16 = r1.getFeedItemAnchors().iterator();
    L26:
        if (r16.hasNext() == false) goto L78;
        rd3.a r17 = (rd3.a) r16.next();
        int r18 = com.bytedance.android.shopping.feed.viewmodel.a.a;
        GuessULikeAdData r19 = r17.a();
        if (r19 == null) goto L30;
        String r21 = r19.getRawData();
    L31:
        r17.a = com.bytedance.android.shopping.feed.viewmodel.a.a(r21);
        goto L26
    L30:
        r21 = null;
        goto L31
    L78:
        return;
    L32:
        List<rd3.a> r22 = r1.getFeedItemAnchors();
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator<T> r24 = r22.iterator();
    L34:
        if (r24.hasNext() == false) goto L40;
        rd3.a r25 = (rd3.a) r24.next();
        StringBuilder r26 = new StringBuilder();
        r26.append(r25.getType());
        r26.append('_');
        Promotion r27 = r25.f();
        if (r27 == null) goto L38;
        String r28 = r27.getId();
    L39:
        r26.append(r28);
        r23.add(r26.toString());
        goto L34
    L38:
        r28 = null;
        goto L39
    L40:
        String r110 = com.bytedance.android.shopping.extensions.g.a(r23);
        d r29 = this.a;
        r29.getClass();
        InnerGuessULikeApi.a.getClass();
        InnerGuessULikeApi r30 = InnerGuessULikeApi.a.a;
        if (r30 == null) goto L64;
        String r31 = r29.d.getProductId();
        if (r31 != null) goto L45;
        String r32 = "";
    L46:
        String r33 = com.bytedance.android.shopping.feed.utils.g.a();
        int r34 = com.bytedance.android.shopping.feed.utils.b.a;
        String r35 = com.bytedance.android.shopping.feed.utils.b.d(r29.d.getRequestParam().getMetaParam());
        if (r35 != null) goto L49;
        String r36 = "";
    L50:
        String r37 = r29.d.getAuthorId();
        String r111 = r29.d.getAuthorOpenId();
        ECAnchorV3ExtraData r38 = r29.d.getAnchorV3ExtraData();
        if (r38 == null) goto L53;
        String r112 = r38.getShopId();
    L54:
        String r113 = r29.d.getVideoId();
        ECLogExtraData r39 = r29.d.getLogExtraData();
        if (r39 == null) goto L57;
        r3 = r39.getEnterFrom();
    L57:
        Observable r40 = InnerGuessULikeApi.b.b(r30, r32, r33, r36, r37, r111, r112, r113, r110, r3, 0, null, null, 934366);
        if (r40 == null) goto L64;
        Observable r41 = r40.subscribeOn(Schedulers.io());
        if (r41 == null) goto L64;
        Observable r42 = r41.observeOn(AndroidSchedulers.mainThread());
        if (r42 == null) goto L64;
        r42.subscribe(new c(r29));
        goto L64
    L53:
        r112 = null;
        goto L54
    L49:
        r36 = r35;
        goto L50
    L45:
        r32 = r31;
    L64:
        String r43 = this.a.d.getFullPageMonitorName();
        com.bytedance.android.ec.monitor.duration.i r44 = com.bytedance.android.ec.monitor.duration.i.a;
        com.bytedance.android.ec.monitor.duration.d r45 = r44.get(r43);
        if (r45 == null) goto L67;
        r45.a("guess_u_like_api_end");
    L67:
        com.bytedance.android.ec.monitor.duration.d r46 = r44.get(r43);
        if (r46 == null) goto L77;
        r46.a("guess_u_like_render_start");
        return;
    L77:
        return;
    L13:
        r8 = null;
        goto L14
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a.c = true;
    }
}
