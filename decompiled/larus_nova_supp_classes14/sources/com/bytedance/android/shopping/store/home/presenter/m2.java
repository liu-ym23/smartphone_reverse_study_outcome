package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.shopping.store.home.entity.ShopCommitIMResponse;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m2<T> implements Consumer {
    public final /* synthetic */ ECShopTopBarBackPresenterV2 a;

    public m2(ECShopTopBarBackPresenterV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r15) {
        ShopCommitIMResponse r16 = (ShopCommitIMResponse) r15;
        ECShopTopBarBackPresenterV2 r0 = this.a;
        r0.getClass();
        Activity r1 = CommonUtils.a();
        if (r1 != null) goto L5;
        r1 = r0.X();
    L5:
        Activity r4 = r1;
        s83.e r2 = r0.u;
        if (r2 == null) goto L11;
        View r5 = r0.y();
        String r3 = r0.T().getStoreParam().getShopId();
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r2.k(false, false, r4, r5, r3, r0.T().getStoreParam().getSecShopId(), r0.T().getStoreParam().getShareInfo().getShopLogo(), r0.T().getStoreParam().getShareInfo().getShopName(), r16.getMsgType(), r16.getContent(), null, null);
    L11:
        r0.T().doEventAction("share_store", new Pair[0]);
        r0.T().doEventAction("show_shop_qr_code", new Pair[]{TuplesKt.to("panel_style", "old")});
        s83.e r17 = r0.u;
        if (r17 == null) goto L14;
        r17.d(new tf3.k(null, r0.T().getStoreParam().getShopId(), 1), PinchEnterMethod.CLICK, r0.T().getStoreParam().getPageName());
    L14:
        boolean r18 = gm.a.a;
        gm.a.b("shop_share_shop", PostActionType.DO);
        int r19 = com.bytedance.android.ec.store.utils.h.a;
        com.bytedance.android.ec.store.utils.h.d(r0.T().getEntranceInfoJsonObject(), "share", "share_sign", r0.T().getAdParams(), "shop_window_ad");
    }
}
