package com.bytedance.android.livesdk.livecommerce.playback.main;

import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideNetServiceFactory;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.playback.interaction.ExplainPlaybackInteractionRequest;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import el2.l;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;
import si2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements h {
    public l a;

    public d() {
        this.a = ECLiveCommerceModel_ProvideNetServiceFactory.proxyProvideNetService(hh2.a.a().f);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.playback.main.h
    public final com.bytedance.android.livesdk.livecommerce.playback.interaction.a a(ExplainPlaybackInteractionRequest r6) {
        Intrinsics.checkNotNullParameter(r6, "requestParams");
        bj2.a.b("ExplainPlaybackRepository", "getCommentaryInteractionResponse");
        int r1 = ExplainPlaybackUtils.a;
        Intrinsics.checkNotNullParameter(r6, "requestParams");
        FilterNullArrayList<k> r0 = new FilterNullArrayList();
        hh2.g r2 = hh2.f.a.a;
        if (r2 == null) goto L7;
        Boolean r3 = r2.l();
        if (r3 == null) goto L7;
        boolean r4 = r3.booleanValue();
    L9:
        if (r4 == false) goto L11;
        r0.add(new k("author_id", BDLocationException.ERROR_TIMEOUT));
        r0.add(new k("author_open_id", r6.getAuthorId()));
    L12:
        r0.add(new k("promotion_id", r6.getPromotionId()));
        r0.add(new k("product_id", r6.getProductId()));
        r0.add(new k("room_id", r6.getRoomId()));
        r0.add(new k("shop_id", r6.getShopId()));
        r0.add(new k("author_id", r6.getAuthorId()));
        r0.add(new k("source_page", r6.getSourcePage()));
        l r7 = this.a;
        if (r7 == null) goto L18;
        Observable r8 = r7.b(si2.g.X, r0, com.bytedance.android.livesdk.livecommerce.playback.interaction.a.class, null);
        if (r8 != null) goto L17;
        return null;
    L17:
        return (com.bytedance.android.livesdk.livecommerce.playback.interaction.a) r8.blockingFirst();
    L18:
        return null;
    L11:
        r0.add(new k("author_id", r6.getAuthorId()));
    L7:
        r4 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.livecommerce.playback.main.h
    public final ol.a b(ExplainPlaybackRequest r5) {
        bj2.a.b("ExplainPlaybackRepository", "getPromotionCommentaryResponseV2");
        if (r5 != null) goto L5;
        return null;
    L5:
        FilterNullArrayList<k> r6 = ExplainPlaybackUtils.a(r5);
        l r1 = this.a;
        if (r1 == null) goto L11;
        Observable r7 = r1.a(si2.g.W, r6, ol.a.class, null);
        if (r7 != null) goto L10;
        return null;
    L10:
        return (ol.a) r7.blockingFirst();
    L11:
        return null;
    }
}
