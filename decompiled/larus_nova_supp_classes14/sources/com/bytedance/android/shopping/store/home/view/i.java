package com.bytedance.android.shopping.store.home.view;

import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.home.entity.ShopCommitIMResponse;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends PopupWindow implements View.OnClickListener {
    public static final String f = null;
    public ECStoreViewModel a;
    public l b;
    public int c;
    public final Activity d;
    public final View e;

    public static final class a {
    }

    static {
        Lazy r0 = ECAppInfoService.a;
        if (ECAppInfoService.k() == false) goto L5;
        String r1 = "sslocal://webcast_lynxview?type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_mall_awemelite%2Fhomepage%2Ftemplate.js%3Fenter_from%3Dpersonal_homepage%26origin_type%3D9902090000&page=ecom_mall&hide_nav_bar=1&hide_status_bar=0&status_bar_color=black&show_close=0&trans_status_bar=1&hide_loading=1&enable_share=0&web_bg_color=ffffff&show_back=0&inject_config_channel=ecom_mall_awemelite&inject_scene=default&enable_latch=1";
    L6:
        f = r1;
        return;
    L5:
        r1 = "sslocal://webcast_lynxview?type=fullscreen&url=https%3A%2F%2Flf-ecom-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fecom%2Flynx%2Fecom_mall%2Fhomepage%2Ftemplate.js%3Fenter_from%3Dpersonal_homepage%26origin_type%3D9902090000&page=ecom_mall&hide_nav_bar=1&hide_status_bar=0&status_bar_color=black&show_close=0&trans_status_bar=1&hide_loading=1&enable_share=0&show_back=0&web_bg_color=%23ffffffff&load_taro=0&top_level=1";
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        Intrinsics.checkNotNullParameter(r13, "v");
        int r0 = kn.a.a;
        if (kn.a.a(r13.getId()) == false) goto L5;
        return;
    L5:
        ECStoreViewModel r1 = this.a;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        if (r1.getStoreParam().isPreview() == false) goto L11;
        return;
    L11:
        int r2 = r13.getId();
        if (r2 != 2131371114) goto L18;
        l r14 = this.b;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("actionHelper");
    L16:
        r14.b();
    L63:
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        dismiss();
        return;
    L18:
        if (r2 != 2131371117) goto L23;
        l r3 = this.b;
        if (r3 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("actionHelper");
    L22:
        r3.c(r13);
        goto L63
    L23:
        String r4 = null;
        if (r2 != 2131371116) goto L40;
        l r15 = this.b;
        if (r15 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("actionHelper");
    L28:
        r15.d.setEnterOtherPageCollaspeHeader(true);
        com.bytedance.android.shopping.store.home.entity.n r5 = (com.bytedance.android.shopping.store.home.entity.n) r15.d.getHeaderArea().getValue();
        if (r5 == null) goto L63;
        com.bytedance.android.shopping.store.home.entity.g r6 = r5.e;
        if (r6 == null) goto L63;
        String r7 = r6.o;
        if (r7 == null) goto L63;
        if (a2.b(r7) == false) goto L37;
        r4 = r7;
    L37:
        if (r4 == null) goto L63;
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r15.b, r4);
        goto L63
    L40:
        if (r2 != 2131371113) goto L46;
        l r16 = this.b;
        if (r16 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("actionHelper");
    L44:
        r16.a();
        goto L63
    L46:
        if (r2 != 2131371119) goto L63;
        l r17 = this.b;
        if (r17 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("actionHelper");
    L50:
        r17.getClass();
        ECStoreApi.a.getClass();
        ECStoreApi r8 = ECStoreApi.a.a;
        if (r8 == null) goto L62;
        Pair[] r9 = new Pair[2];
        r9[0] = TuplesKt.to("sec_shop_id", r17.d.getStoreParam().getSecShopId());
        kc.a r10 = BtmSDK.getBcmChainByFinder$default(BtmSDK.INSTANCE, PageFinder.via(l.g(r17.c)), 0, false, 6, null);
        if (r10 == null) goto L55;
        r4 = r10.a().toString();
    L55:
        r9[1] = TuplesKt.to("bcm_chain", com.bytedance.android.shopping.extensions.k.j(r4));
        Observable<ShopCommitIMResponse> r11 = r8.getImCardInfo("commodity_msg_shop_store", com.bytedance.android.ec.hybrid.list.util.k.d(MapsKt.mutableMapOf(r9)));
        if (r11 == null) goto L62;
        Observable r12 = bg4.b.b(r11);
        if (r12 == null) goto L62;
        Disposable r18 = r12.subscribe(new k(r17));
        if (r18 == null) goto L62;
        com.bytedance.android.ec.core.async.a.a(r18, r17.d);
    L62:
        r17.d.doEventAction("click_share_entrance", new Pair[]{TuplesKt.to("click_area", "menu")});
        goto L63
    }

    public i(Activity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        super(r2);
        this.d = r2;
        this.e = r3;
    }
}
