package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.shopfeed.ECShopInnerFlowShareHelper;
import com.bytedance.android.shopping.store.shopfeed.ShopFeedParam;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopFlowTopBarPresenter extends com.bytedance.android.shopping.store.shopfeed.presenter.a {
    public final Lazy f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ECShopFlowTopBarPresenter a;

        public a(ECShopFlowTopBarPresenter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            ECShopFlowTopBarPresenter r9 = this.a;
            ShopFeedParam r0 = ((ECShopFeedViewModel) r9.f.getValue()).getShopFeedParam();
            JSONObject r1 = new JSONObject();
            r1.putOpt("is_ec_shopping", 0);
            String r2 = r1.toString();
            Uri.Builder r3 = UriProtector.parse("sslocal://goods/store/search").buildUpon();
            if (r0 == null) goto L5;
            String r4 = r0.getSecShopId();
        L6:
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            Uri.Builder r5 = r3.appendQueryParameter("sec_shop_id", r4).appendQueryParameter("is_search", CommentScene.COMMENTSCENE_NO_AWEME).appendQueryParameter("share_params", r2);
            Activity r6 = l0.b(r9.u().c());
            if (r6 == null) goto L11;
            String r7 = hm.c.e(r6);
        L12:
            String r10 = r5.appendQueryParameter("entrance_info", r7).build().toString();
            Activity r11 = l0.b(r9.u().c());
            if (r11 == null) goto L15;
            p r12 = p.a;
            int r13 = com.bytedance.android.ec.store.utils.b.a;
            r12.d(com.bytedance.android.ec.store.utils.b.b(r10, "a1.b19332", PageFinder.via(r9.e), null), r11);
        L15:
            ((ECShopFeedViewModel) r9.f.getValue()).doAnyEventAction("enter_search", null, new Pair[]{TuplesKt.to("enter_from", "inner_flow_page"), TuplesKt.to("btm_id", "a1.b19332")});
            return;
        L11:
            r7 = null;
            goto L12
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ECShopFlowTopBarPresenter a;

        public b(ECShopFlowTopBarPresenter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ECShopInnerFlowShareHelper r3 = ((ECShopFeedViewModel) this.a.f.getValue()).getShareHelper();
            if (r3 == null) goto L6;
            int r0 = com.bytedance.android.shopping.store.home.d.f;
            r3.f(null);
            return;
        }
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.presenter.a
    public final int E() {
        return ExtensionsKt.a(11);
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.presenter.a
    public final int F() {
        return ExtensionsKt.a(53);
    }

    public ECShopFlowTopBarPresenter(final Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ECShopFlowTopBarPresenter$viewModel$2(this, r2));
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.presenter.a
    public final void A(QModel r3) {
        super.A(r3);
        ShopFeedParam r4 = ((ECShopFeedViewModel) this.f.getValue()).getShopFeedParam();
        Object r0 = null;
        if (r4 == null) goto L5;
        String r5 = r4.getPaginationParams();
    L6:
        JSONObject r6 = com.bytedance.android.ec.hybrid.list.util.k.c(r5);
        if (r6 == null) goto L10;
        r0 = r6.opt("tab_type");
    L10:
        if (Intrinsics.areEqual(r0, Integer.valueOf(TabEnum.SHOP_COMBINATION_INNER_FLOW_PAGE.getType())) == false) goto L18;
        View r7 = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131386235));
        if (r7 == null) goto L14;
        r7.setVisibility(0);
        r7.setOnClickListener(new a(this));
    L14:
        View r8 = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131386236));
        if (r8 == null) goto L19;
        r8.setVisibility(0);
        r8.setOnClickListener(new b(this));
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
