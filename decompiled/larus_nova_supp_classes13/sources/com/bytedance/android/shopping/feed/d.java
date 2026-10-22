package com.bytedance.android.shopping.feed;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.bytedance.android.shopping.feed.repository.api.InnerGuessULikeApi;
import com.bytedance.android.shopping.feed.utils.d0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.net.URLEncoder;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final MutableLiveData<InflowGuessFeedResponse> a;
    public final MutableLiveData<InflowGuessFeedResponse> b;
    public boolean c;
    public final AnchorV3Param d;

    public final void a() {
        if (this.c == true) goto L40;
        int r1 = ud3.f.a;
        String r2 = ud3.f.a(this.d.getRequestParam().getAggParams(), true, true);
        InnerGuessULikeApi.a.getClass();
        InnerGuessULikeApi r3 = InnerGuessULikeApi.a.a;
        if (r3 == null) goto L41;
        String r4 = this.d.getProductId();
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        String r9 = com.bytedance.android.shopping.feed.utils.g.a();
        int r12 = com.bytedance.android.shopping.feed.utils.b.a;
        String r13 = com.bytedance.android.shopping.feed.utils.b.d(this.d.getRequestParam().getMetaParam());
        if (r13 != null) goto L12;
        String r14 = "";
    L13:
        String r15 = this.d.getAuthorId();
        String r16 = this.d.getAuthorOpenId();
        ECAnchorV3ExtraData r17 = this.d.getAnchorV3ExtraData();
        if (r17 == null) goto L16;
        String r18 = r17.getShopId();
    L17:
        String r19 = this.d.getVideoId();
        String r110 = d0.a();
        ECLogExtraData r111 = this.d.getLogExtraData();
        if (r111 == null) goto L20;
        String r20 = r111.getEnterFrom();
    L21:
        Long r24 = this.d.getFirstCategoryId();
        String r25 = this.d.getFirstCategoryName();
        Long r23 = this.d.getFrontCategoryId();
        String r26 = this.d.getFrontCategoryName();
        if (r2 != null) goto L24;
        String r5 = null;
    L25:
        boolean r28 = this.d.getRequestParam().isAds();
        boolean r27 = this.d.getRequestParam().isStar();
        List r112 = this.d.getRequestParam().getGoodPriceParam();
        if (r112 == null) goto L31;
        String r113 = CollectionsKt.joinToString$default(r112, ",", null, null, 0, null, null, 62, null);
        if (r113 == null) goto L31;
        String r29 = r113;
    L32:
        Observable r6 = InnerGuessULikeApi.b.a(r3, r4, 0, 1, null, 0, r9, "", null, 0, r14, r15, r16, r18, r19, r110, r20, null, null, r23, r26, r24, r25, r5, r27, r28, r29, 197002);
        if (r6 == null) goto L42;
        Observable r7 = r6.subscribeOn(Schedulers.io());
        if (r7 == null) goto L43;
        Observable r8 = r7.observeOn(AndroidSchedulers.mainThread());
        if (r8 == null) goto L44;
        r8.subscribe(new b(this));
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L31:
        r29 = "";
        goto L32
    L24:
        r5 = URLEncoder.encode(r2, Charsets.UTF_8.name());
        goto L25
    L20:
        r20 = null;
        goto L21
    L16:
        r18 = null;
        goto L17
    L12:
        r14 = r13;
        goto L13
    L41:
        return;
    }

    public d(AnchorV3Param r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV3Param");
        this.d = r2;
        this.a = new MutableLiveData();
        this.b = new MutableLiveData();
    }
}
