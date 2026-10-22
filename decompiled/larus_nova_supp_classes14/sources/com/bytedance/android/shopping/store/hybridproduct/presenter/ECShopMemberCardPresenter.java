package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.view.ECShopLabelTextView;
import com.bytedance.android.shopping.store.home.datasource.ECShopDataStorageForRemote;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.repository.vo.ShopRemoteStruct;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopMemberCardPresenter extends QFragmentPresenter {
    public final Lazy f;
    public final com.bytedance.android.ec.core.imagex.r g;
    public SimpleDraweeView h;
    public ECShopLabelTextView i;
    public ECShopLabelTextView j;
    public ECShopLabelTextView k;
    public ImageView l;
    public SimpleDraweeView m;
    public SimpleDraweeView n;
    public View o;
    public boolean p;
    public final ViewGroup q;

    public final ECShopHybridProductViewModel d0() {
        return (ECShopHybridProductViewModel) this.f.getValue();
    }

    public final void b0(QModel r15) {
        this.m = com.bytedance.android.ec.store.product.presenter.utils.f.a(Z().b(2131386249));
        this.h = com.bytedance.android.ec.store.product.presenter.utils.f.a(Z().b(2131386255));
        this.i = com.bytedance.android.ec.store.product.presenter.utils.f.a(Z().b(2131386258));
        this.j = com.bytedance.android.ec.store.product.presenter.utils.f.a(Z().b(2131386257));
        this.k = com.bytedance.android.ec.store.product.presenter.utils.f.a(Z().b(2131386251));
        this.l = (ImageView) com.bytedance.android.ec.store.product.presenter.utils.f.a(Z().b(2131386250));
        this.n = com.bytedance.android.ec.store.product.presenter.utils.f.a(Z().b(2131386252));
        this.o = com.bytedance.android.ec.store.product.presenter.utils.f.a(Z().b(2131386253));
        String r1 = null;
        if ((r15 instanceof uj3.d) == true) goto L5;
        r15 = null;
    L5:
        uj3.d r16 = (uj3.d) r15;
        int r0 = 8;
        if (r16 == null) goto L118;
        SimpleDraweeView r2 = this.h;
        if (r2 == null) goto L10;
        com.bytedance.android.ec.core.imagex.h0.d(r2, r16.f, this.g, null, null, null, null, 120);
    L10:
        ECShopLabelTextView r3 = this.i;
        if (r3 == null) goto L13;
        sj3.n r4 = r16.c;
        int r5 = ECShopLabelTextView.a;
        r3.a(r4, false);
    L13:
        ECShopLabelTextView r6 = this.j;
        boolean r7 = true;
        if (r6 != null) goto L16;
    L20:
        ECShopLabelTextView r8 = this.k;
        if (r8 == null) goto L27;
        sj3.d r9 = r16.g;
        if (r9 == null) goto L25;
        sj3.n r10 = r9.f();
    L26:
        int r11 = ECShopLabelTextView.a;
        r8.a(r10, false);
        goto L27
    L25:
        r10 = null;
    L27:
        ImageView r12 = this.l;
        if (r12 == null) goto L37;
        sj3.d r13 = r16.g;
        if (r13 == null) goto L32;
        Integer r14 = r13.a();
    L33:
        if (r14 == null) goto L35;
        int r17 = 0;
    L36:
        r12.setVisibility(r17);
        goto L37
    L35:
        r17 = 8;
        goto L36
    L32:
        r14 = null;
    L37:
        SimpleDraweeView r18 = this.m;
        if (r18 != null) goto L40;
    L44:
        a0().setOnClickListener(new l(this, r16));
        SimpleDraweeView r19 = this.n;
        if (r19 == null) goto L52;
        sj3.d r20 = r16.g;
        if (r20 == null) goto L49;
        ECUrlModel r21 = r20.b();
    L50:
        com.bytedance.android.ec.core.imagex.h0.d(r19, r21, this.g, null, null, null, null, 120);
        goto L52
    L49:
        r21 = null;
    L52:
        if (this.p == true) goto L54;
        d0().doAnyEventActionWithBtm("a1.b6269.c2429.d73420", PageFinder.via(a0()), "show_ecom_component", r16.h, new Pair[]{TuplesKt.to("tab_name", "products")});
        this.p = true;
    L54:
        Map<String, String> r22 = r16.j;
        if (r22 == null) goto L58;
        r1 = r22.get("ec_shop_product_card_opt");
    L58:
        if (Intrinsics.areEqual(r1, CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L71;
        ImageView r23 = this.l;
        if (r23 == null) goto L62;
        r23.setImageResource(2131234738);
    L62:
        View r24 = this.o;
        if (r24 == null) goto L65;
        r24.setBackgroundResource(2131243931);
    L65:
        View r25 = this.o;
        if (r25 == null) goto L68;
        d2.e(r25, com.bytedance.android.shopping.extensions.b.b(8));
    L68:
        View r26 = this.o;
        if (r26 == null) goto L80;
        wg.a.d(r26, com.bytedance.android.shopping.extensions.b.b(24));
    L80:
        Map<String, String> r110 = r16.i;
        if (r110 == null) goto L107;
        String r111 = r110.get("native_storage");
        if (r111 == null) goto L107;
        ShopRemoteStruct r112 = (ShopRemoteStruct) GsonProtectorUtils.fromJson(new Gson(), r111, new n().getType());
        String r27 = r112.getBusinessId();
        if (r27 != null) goto L88;
    L91:
        boolean r28 = true;
    L92:
        if (r28 == false) goto L94;
    L103:
        if (r7 == true) goto L107;
        ECShopDataStorageForRemote.b.c(r112.getActionType(), r112.getSecShopId(), r112.getUserId(), r112.getBusinessId(), r112.getData());
        a0().post(new m(this));
        goto L107
    L94:
        if (r112.getActionType() != 0) goto L96;
    L102:
        r7 = false;
        goto L103
    L96:
        if (r112.getActionType() == 1) goto L102;
        if (r112.getActionType() == 2) goto L102;
        if (r112.getActionType() == 3) goto L102;
    L88:
        if (StringsKt.isBlank(r27) == true) goto L91;
        r28 = false;
    L107:
        if (com.bytedance.android.shopping.store.utils.o.c == false) goto L120;
        SimpleDraweeView r113 = this.h;
        if (r113 == null) goto L112;
        r113.setVisibility(8);
    L112:
        if (((LayoutTypes) d0().getLayoutType().getValue()) == LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE) goto L115;
        r0 = 10;
    L115:
        ECShopLabelTextView r114 = this.i;
        if (r114 == null) goto L121;
        wg.a.f(r114, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r0)), com.bytedance.android.shopping.extensions.b.b(9), 0, com.bytedance.android.shopping.extensions.b.b(9));
        return;
    L121:
        return;
    L120:
        return;
    L71:
        ImageView r29 = this.l;
        if (r29 == null) goto L74;
        r29.setImageResource(2131234737);
    L74:
        View r30 = this.o;
        if (r30 == null) goto L77;
        r30.setBackgroundResource(2131243930);
    L77:
        View r31 = this.o;
        if (r31 == null) goto L80;
        wg.a.d(r31, com.bytedance.android.shopping.extensions.b.b(20));
        goto L80
    L40:
        if (((LayoutTypes) d0().getLayoutType().getValue()) != LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE) goto L42;
        ECUrlModel r32 = r16.b;
    L43:
        com.bytedance.android.ec.core.imagex.h0.d(r18, r32, this.g, null, null, null, null, 120);
        goto L44
    L42:
        r32 = r16.a;
        goto L43
    L16:
        if (((LayoutTypes) d0().getLayoutType().getValue()) != LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE) goto L18;
        sj3.n r33 = r16.e;
    L19:
        r6.a(r33, true);
        goto L20
    L18:
        r33 = r16.d;
        goto L19
    L118:
        a0().setVisibility(8);
        Unit r115 = Unit.INSTANCE;
    }

    public final void e0(sj3.d r10) {
        if (Intrinsics.areEqual(r10.c().get("coupon_range"), "products") == false) goto L5;
        String r11 = r10.c().get("product_tab_params");
        ECShopHybridProductViewModel.refreshByDiscountSelect$default(d0(), r11, null, 2, null);
        return;
    L5:
        ECToast.showToast$default(ECToast.INSTANCE, Y().c(), "优惠券全店可用", null, 4, null);
        d0().refreshAll();
    }

    public ECShopMemberCardPresenter(Fragment r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "rootViewGroup");
        super(r2);
        this.q = r3;
        this.f = LazyKt.lazy(new ECShopMemberCardPresenter$viewModel$2(this));
        int r4 = com.bytedance.android.ec.core.imagex.r.h;
        this.g = com.bytedance.android.ec.core.imagex.r.a.c("ec_shop_member_card_image");
    }
}
