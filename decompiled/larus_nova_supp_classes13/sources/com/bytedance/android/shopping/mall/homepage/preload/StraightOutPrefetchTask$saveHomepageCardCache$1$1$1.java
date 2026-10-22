package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.ability.o0;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.loadview.LoadingStatusVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.model.BffBizInfo;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class StraightOutPrefetchTask$saveHomepageCardCache$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HomePageDTO $tmp;

    public StraightOutPrefetchTask$saveHomepageCardCache$1$1$1(HomePageDTO r1) {
        this.$tmp = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1429invoke() {
        Map r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to(ECHybridListItemType.HYBRID_LIST_TITLE, new o0(i93.a.class)), TuplesKt.to(ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_VIDEO_CARD, new o0(VideoCardData.class)), TuplesKt.to(ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_LIVE_CARD, new o0(LiveCardData.class)), TuplesKt.to(ECHybridListItemType.HYBRID_TYPE_FAV_LOADING_CARD, new o0(LoadingStatusVO.class)), TuplesKt.to(ECHybridListItemType.NATIVE_LIVE_BIG_CARD, new o0(LiveCardData.class)), TuplesKt.to(ECHybridListItemType.NATIVE_VIDEO_BIG_CARD, new o0(VideoCardData.class)), TuplesKt.to(ECHybridListItemType.NATIVE_HEADER_CHIP_AREA_CARD, new o0(HeaderCardData.class))});
        Iterator r1 = r0.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        ECHybridListItemType r3 = (ECHybridListItemType) r1.next();
        o0 r4 = (o0) r0.get(r3);
        if (r4 == null) goto L4;
        ECHybridListEngine.Companion r5 = ECHybridListEngine.x;
        int r6 = r3.getType();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "transformer");
        ECHybridListEngine.w.put(Integer.valueOf(r6), r4);
        goto L4
    L8:
        HomePageBffDTO r2 = this.$tmp.getBff();
        if (r2 == null) goto L25;
        ECHybridListDTO.a r7 = ECHybridListDTO.Companion;
        HomePageBffDTO r8 = this.$tmp.getBff();
        Intrinsics.checkNotNull(r8);
        ECHybridListDTO r9 = r8.getFeed();
        Intrinsics.checkNotNull(r9);
        HomePageDTO r10 = this.$tmp;
        if (r10 == null) goto L17;
        HomePageBffDTO r11 = r10.getBff();
        if (r11 == null) goto L17;
        BffBizInfo r12 = r11.getBizInfo();
        if (r12 == null) goto L17;
        String r13 = r12.getEcSceneId();
    L18:
        com.bytedance.android.ec.hybrid.list.entity.dto.a r14 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(1, r13, 190);
        r7.getClass();
        r2.setFeedVO(ECHybridListDTO.a.d(r9, true, r14));
        return;
    L17:
        r13 = null;
        goto L18
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1429invoke();
        return Unit.INSTANCE;
    }
}
