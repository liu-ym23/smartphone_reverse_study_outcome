package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.hybridproduct.dto.ShopCouponResponseDTO;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ ECShopMemberCardPresenter a;
    public final /* synthetic */ uj3.d b;

    public l(ECShopMemberCardPresenter r1, uj3.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        sj3.d r10 = this.b.g;
        String r0 = null;
        if (r10 == null) goto L5;
        Integer r11 = r10.a();
    L7:
        if (r11 != null) goto L10;
    L17:
        if (r11 != null) goto L20;
    L36:
        if (r11 != null) goto L39;
    L44:
        this.a.d0().doAnyEventActionWithBtm("a1.b6269.c2429.d73420", PageFinder.via(this.a.a0()), "click_ecom_component", this.b.h, new Pair[]{TuplesKt.to("tab_name", "products")});
        return;
    L39:
        if (r11.intValue() != 3) goto L44;
        ECShopMemberCardPresenter r12 = this.a;
        sj3.d r1 = this.b.g;
        if (r1 != null) goto L43;
        r12.getClass();
        goto L44
    L43:
        r12.e0(r1);
        goto L44
    L20:
        if (r11.intValue() != 2) goto L36;
        ECShopMemberCardPresenter r13 = this.a;
        sj3.d r2 = this.b.g;
        r13.getClass();
        if (r2 == null) goto L44;
        if (r2.d() == null) goto L44;
        ECStoreApi.a.getClass();
        ECStoreApi r3 = ECStoreApi.a.a;
        if (r3 == null) goto L44;
        Observable<ShopCouponResponseDTO> r4 = r3.applyCoupon(r2.d(), null, (String) r13.d0().getStoreParam().getPassThroughParam("pass_through_api"), "shop_member_card");
        if (r4 == null) goto L44;
        Observable r5 = bg4.b.b(r4);
        if (r5 == null) goto L44;
        Disposable r6 = r5.subscribe(new j(r13, r2), k.a);
        if (r6 == null) goto L44;
        com.bytedance.android.ec.core.async.a.a(r6, r13.d0());
        goto L44
    L10:
        if (r11.intValue() != 1) goto L17;
        ECShopMemberCardPresenter r14 = this.a;
        uj3.d r7 = this.b;
        if (r7 == null) goto L16;
        sj3.d r8 = r7.g;
        if (r8 == null) goto L16;
        r0 = r8.e();
    L16:
        r14.getClass();
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r14.Y().c(), com.bytedance.android.ec.store.utils.b.a(r0, BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b6269.c2429.d73420", PageFinder.via(((QFragmentPresenter) r14).e), null, 4, null)));
        goto L44
    L5:
        r11 = null;
        goto L7
    }
}
