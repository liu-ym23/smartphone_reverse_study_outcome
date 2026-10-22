package com.bytedance.android.shopping.store.home.view;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.shopping.store.home.entity.ShopCommitIMResponse;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ l a;

    public k(l r1) {
        this.a = r1;
    }

    public final void accept(Object r15) {
        ShopCommitIMResponse r16 = (ShopCommitIMResponse) r15;
        l r0 = this.a;
        s83.e r1 = r0.a;
        if (r1 == null) goto L8;
        Activity r4 = r0.b;
        View r5 = l.g(r0.c);
        String r6 = r0.d.getStoreParam().getShopId();
        if (r6 != null) goto L7;
        r6 = "";
    L7:
        r1.k(false, false, r4, r5, r6, r0.d.getStoreParam().getSecShopId(), r0.d.getStoreParam().getShareInfo().getShopLogo(), r0.d.getStoreParam().getShareInfo().getShopName(), r16.getMsgType(), r16.getContent(), null, null);
    L8:
        r0.d.doEventAction("share_store", new Pair[0]);
        r0.d.doEventAction("show_shop_qr_code", new Pair[]{TuplesKt.to("panel_style", "old")});
        s83.e r17 = r0.a;
        if (r17 == null) goto L11;
        r17.d(new tf3.k(null, r0.d.getStoreParam().getShopId(), 1), PinchEnterMethod.CLICK, r0.d.getStoreParam().getPageName());
    L11:
        boolean r18 = gm.a.a;
        gm.a.b("shop_share_shop", PostActionType.DO);
        int r19 = com.bytedance.android.ec.store.utils.h.a;
        com.bytedance.android.ec.store.utils.h.d(r0.d.getEntranceInfoJsonObject(), "share", "share_sign", r0.d.getAdParams(), "shop_window_ad");
    }
}
