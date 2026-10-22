package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.p1;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.order.ECOrderTrackerData;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowProductForm;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowSourceMethod;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowStoreType;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.utils.k0;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel;
import com.bytedance.android.window.shop.router.WindowEntranceInfoScene;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yn.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowInnerFlowProductElementPresenter extends d<wp3.d> implements View.OnClickListener {
    public static final /* synthetic */ int t = 0;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public Disposable n;
    public final Lazy o;
    public wp3.d p;
    public final Lazy q;
    public final Function1<Integer, Unit> r;
    public final Function3<String, String, Long, Unit> s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void E() {
        this.p = null;
        Disposable r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        ((TextView) this.h.getValue()).setText("");
        ((PriceView) this.i.getValue()).setText("");
        ((TextView) this.j.getValue()).setText("");
        ((TextView) this.g.getValue()).setText("");
        ((SimpleDraweeView) this.k.getValue()).setActualImageResource(2131234952);
    }

    public final TextView F() {
        return (TextView) this.m.getValue();
    }

    public final ECWindowInnerFlowViewModel G() {
        return (ECWindowInnerFlowViewModel) this.q.getValue();
    }

    public ECWindowInnerFlowProductElementPresenter() {
        super(yp3.c.a);
        this.g = LazyKt.lazy(new ECWindowInnerFlowProductElementPresenter$productTitleView$2(this));
        this.h = LazyKt.lazy(new ECWindowInnerFlowProductElementPresenter$productSourceView$2(this));
        this.i = LazyKt.lazy(new ECWindowInnerFlowProductElementPresenter$priceView$2(this));
        this.j = LazyKt.lazy(new ECWindowInnerFlowProductElementPresenter$saleCountView$2(this));
        this.k = LazyKt.lazy(new ECWindowInnerFlowProductElementPresenter$productImageView$2(this));
        this.l = LazyKt.lazy(new ECWindowInnerFlowProductElementPresenter$addToCartView$2(this));
        this.m = LazyKt.lazy(new ECWindowInnerFlowProductElementPresenter$buyProductView$2(this));
        this.o = LazyKt.lazy(new ECWindowInnerFlowProductElementPresenter$prepareClickEventHelper$2(this));
        this.q = LazyKt.lazy(new ECWindowInnerFlowProductElementPresenter$viewModel$2(this));
        this.r = new ECWindowInnerFlowProductElementPresenter$addCartListener$1(this);
        this.s = ECWindowInnerFlowProductElementPresenter$cartListener$1.INSTANCE;
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void D(wp3.d r13) {
        wp3.d r14 = r13;
        this.p = r14;
        String r2 = null;
        if (r14 == null) goto L56;
        final WindowV2ProductItemVO r3 = r14.a;
        List r4 = r3.h;
        if ((!r4.isEmpty()) == false) goto L7;
        List r7 = r4;
    L8:
        if (r7 == null) goto L10;
        h0.f((SimpleDraweeView) this.k.getValue(), r7, G().getImageCallerContext(), Integer.valueOf(((SimpleDraweeView) this.k.getValue()).getWidth()), Integer.valueOf(((SimpleDraweeView) this.k.getValue()).getHeight()), 96);
    L10:
        Disposable r5 = this.n;
        if (r5 == null) goto L13;
        r5.dispose();
    L13:
        this.n = p1.d.d("ecom_shop_product_before", r3.s, r3.d, 3.0f, 14.0f, (TextView) this.g.getValue());
        ((PriceView) this.i.getValue()).C(new ECWindowInnerFlowProductElementPresenter$fillPriceInfo$1(r3));
        TextView r6 = (TextView) this.j.getValue();
        int r8 = k0.a;
        r6.setText(ag4.a.a(2131913980, CollectionsKt.listOf(k0.b(r3.l))));
        Long r9 = r14.a.c;
        if (r9 == null) goto L26;
        long r10 = r9.longValue();
        F().setText(r14.b.a);
        SourceType.Companion.getClass();
        if (SourceType.a.e(r10) == true) goto L25;
        com.bytedance.android.ec.window.base.repository.vo.b r11 = r14.a.z;
        if (r11 == null) goto L20;
        Boolean r12 = r11.a;
    L22:
        if (Intrinsics.areEqual(r12, Boolean.TRUE) == true) goto L25;
        ((ImageView) this.l.getValue()).setVisibility(0);
        F().setMinWidth(com.bytedance.android.shopping.extensions.b.b(68));
        TextView r15 = F();
        ViewGroup.LayoutParams r16 = F().getLayoutParams();
        r16.width = -2;
        Unit r17 = Unit.INSTANCE;
        r15.setLayoutParams(r16);
        goto L26
    L20:
        r12 = null;
    L25:
        ((ImageView) this.l.getValue()).setVisibility(8);
        F().setMinWidth(com.bytedance.android.shopping.extensions.b.b(68));
        TextView r18 = F();
        ViewGroup.LayoutParams r19 = F().getLayoutParams();
        r19.width = -2;
        Unit r20 = Unit.INSTANCE;
        r18.setLayoutParams(r19);
    L26:
        String r21 = r14.c;
        WindowV2ProductItemVO r22 = r14.a;
        Long r23 = r22.c;
        if (r23 == null) goto L53;
        long r24 = r23.longValue();
        WindowV2ProductItemDTO.a.getClass();
        if (r24 != SourceType.TAOBAO.getType()) goto L31;
    L36:
        boolean r25 = true;
    L37:
        if (r25 == false) goto L39;
    L50:
        boolean r26 = true;
    L51:
        if (r26 == false) goto L53;
        r21 = r22.g;
        goto L53
    L39:
        if (r24 != SourceType.JINGDONG.getType()) goto L41;
    L44:
        boolean r27 = true;
    L45:
        if (r27 == true) goto L50;
        SourceType.a r28 = SourceType.Companion;
        Long r29 = Long.valueOf(r24);
        r28.getClass();
        if ((!SourceType.a.a(r29)) == true) goto L50;
        r26 = false;
        goto L51
    L41:
        if (r24 == SourceType.KAOLA.getType()) goto L44;
        r27 = false;
        goto L45
    L31:
        if (r24 == SourceType.TAOBAO_PHONE.getType()) goto L36;
        if (r24 == SourceType.TAOBAO_COMMAND.getType()) goto L36;
        r25 = false;
    L53:
        ((TextView) this.h.getValue()).setText(r21);
        fo.b r30 = this.e;
        if (r30 == null) goto L56;
        String r110 = (String) r30.b(vp3.b.d, r14.a.a);
        goto L56
    L7:
        r7 = null;
    L56:
        Unit r111 = (Unit) this.o.getValue();
        Set<String> r112 = G().getFlyWeight().a;
        wp3.d r31 = this.p;
        if (r31 == null) goto L61;
        WindowV2ProductItemVO r32 = r31.a;
        if (r32 == null) goto L61;
        String r33 = r32.a;
    L62:
        String r34 = "";
        if (r33 != null) goto L66;
        r33 = "";
    L66:
        if (r112.add(r33) == false) goto L84;
        fo.b r113 = this.e;
        if (r113 == null) goto L85;
        Integer r114 = (Integer) r113.a(vp3.b.c);
        if (r114 == null) goto L86;
        int r115 = r114.intValue();
        int r35 = com.bytedance.android.window.shop.innerflow.a.a;
        ECWindowInnerFlowViewModel r36 = G();
        wp3.d r37 = this.p;
        if (r37 == null) goto L76;
        WindowV2ProductItemVO r38 = r37.a;
        if (r38 == null) goto L76;
        r2 = r38.a;
    L76:
        if (r2 == null) goto L79;
        r34 = r2;
    L79:
        int r116 = r115 + 1;
        String r0 = BtmSDK.INSTANCE.obtainEventBtmParams(new BtmItemBuilder("a1.b76473.c31643.d4283_i" + r116, Boolean.FALSE).withView(y()).build());
        Intrinsics.checkNotNullParameter(r36, "innerFlowViewModel");
        Intrinsics.checkNotNullParameter(r34, "productId");
        Intrinsics.checkNotNullParameter("product", "bstGroupType");
        Map r117 = com.bytedance.android.window.shop.innerflow.a.c(r36, r116, r34);
        r117.put("bst_group_type", "product");
        if (r0 == null) goto L82;
        r117.put("btm_id", r0);
    L82:
        r36.doEventAction("show_product", r117, new Pair[0]);
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L61:
        r33 = null;
        goto L62
    }

    public final void I(String r33) {
        wp3.d r2 = this.p;
        if (r2 != null) goto L5;
        return;
    L5:
        int r3 = com.bytedance.android.window.shop.innerflow.util.a.a;
        Context r5 = u().c();
        WindowV2ProductItemVO r4 = r2.a;
        int r6 = com.bytedance.android.window.shop.innerflow.a.a;
        ECWindowInnerFlowViewModel r7 = G();
        Intrinsics.checkNotNullParameter(r7, "innerFlowViewModel");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("bst_group_type", "product");
        r8.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r8.put("store_type", "window");
        r8.put("author_id", ECWindowInnerFlowViewModel.getParam$default(r7, "author_id", null, 2, null));
        r8.put("anchor_id", ECWindowInnerFlowViewModel.getParam$default(r7, "author_id", null, 2, null));
        JSONObject r9 = z1.g(ECWindowInnerFlowViewModel.getParam$default(r7, "pass_through_api", null, 2, null));
        if (r9 == null) goto L8;
        String r10 = r9.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    L10:
        if (r10 != null) goto L12;
        r10 = "";
    L12:
        r8.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r10);
        r8.put("product_source_page", ECWindowInnerFlowViewModel.getParam$default(r7, "product_source_page", null, 2, null));
        r8.put("store_source_page", ECWindowInnerFlowViewModel.getParam$default(r7, "store_source_page", null, 2, null));
        r8.put("store_source_method", ECWindowInnerFlowViewModel.getParam$default(r7, "store_source_method", null, 2, null));
        r8.put("store_group_type", ECWindowInnerFlowViewModel.getParam$default(r7, "store_group_type", null, 2, null));
        r8.put("flow_type", String.valueOf(r7.getInnerFlowParam().c));
        int r11 = r7.getInnerFlowParam().c;
        if (r11 == 0) goto L20;
        if (r11 == 1) goto L19;
        if (r11 == 5) goto L18;
        if (r11 == 6) goto L18;
        String r12 = "";
    L21:
        r8.put("source_method", r12);
        int r13 = r7.getInnerFlowParam().c;
        if (r13 == 5) goto L26;
        if (r13 == 6) goto L25;
        String r14 = "";
    L27:
        r8.put("tab_name_second", r14);
        r8.put("search_params", ECWindowInnerFlowViewModel.getParam$default(r7, "search_params", null, 2, null));
        Function1<String, String> r15 = new ECWindowInnerFlowProductElementPresenter$openProductDetail$1(this);
        String r16 = ECWindowInnerFlowViewModel.getParam$default(G(), "uid", null, 2, null);
        View r17 = y();
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r8, "entranceInfo");
        Intrinsics.checkNotNullParameter(r15, "valueProvider");
        Intrinsics.checkNotNullParameter(r16, "authorId");
        Intrinsics.checkNotNullParameter(r33, "btmId");
        Intrinsics.checkNotNullParameter(r17, "view");
        List r18 = com.bytedance.android.ec.window.base.utils.g.a;
        com.bytedance.android.ec.window.base.utils.g.a(r4.a);
        JSONObject r19 = new JSONObject();
        Iterator r20 = r8.entrySet().iterator();
    L28:
        boolean r110 = false;
        if (r20.hasNext() == false) goto L39;
        Map.Entry r111 = (Map.Entry) r20.next();
        String r21 = (String) r111.getKey();
        String r112 = (String) r111.getValue();
        if (r21.length() <= 0) goto L33;
        r110 = true;
    L33:
        if (r110 == false) goto L28;
        if (r112 != null) goto L36;
        String r0 = "";
    L37:
        r19.put(r21, r0);
        goto L28
    L36:
        r0 = r112;
        goto L37
    L39:
        String r1 = r4.b;
        if (r1 != null) goto L42;
        r1 = r4.a;
    L42:
        r19.put("promotion_id", r1);
        r19.put("which_account", r15.invoke("which_account"));
        if (k.c(r4.E) == false) goto L49;
        int r22 = zq3.f.a;
        String r23 = r4.E;
        Intrinsics.checkNotNull(r23);
        String r24 = zq3.f.c(r23, r33, PageFinder.via(r17), zq3.f.a(r16, r4));
        xn.b r25 = xn.b.f;
        String r26 = (String) r15.invoke("follow_status");
        xn.c.b(r19, l0.b(r5));
        r19.put("ecom_group_type", "product_card");
        Unit r27 = Unit.INSTANCE;
        Map r28 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("product_id", r4.a)});
        u r29 = r4.w;
        if (r29 == null) goto L47;
        String r113 = r29.i();
    L48:
        com.bytedance.android.ec.window.base.common.starter.f.b(r25, r5, r24, r26, r19, r28, r113);
        return;
    L47:
        r113 = null;
        goto L48
    L49:
        xn.b r30 = xn.b.f;
        String r114 = r4.b;
        if (r114 != null) goto L52;
    L59:
        r114 = r4.a;
    L60:
        String r115 = (String) r15.invoke("uid");
        String r116 = (String) r15.invoke("sec_uid");
        String r117 = r4.a;
        Integer r210 = StringsKt.toIntOrNull((String) r15.invoke("follow_status"));
        String r31 = (String) r15.invoke("which_account");
        String r118 = r19.toString();
        String r211 = (String) r15.invoke("search_params");
        JSONObject r32 = new JSONObject();
        r32.put("sec_author_id", r15.invoke("sec_uid"));
        JSONObject r34 = z1.g((String) r15.invoke("pass_through_api"));
        if (r34 == null) goto L63;
        String r35 = r34.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    L64:
        if (r35 != null) goto L66;
        String r119 = "";
    L67:
        r32.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r119);
        Unit r36 = Unit.INSTANCE;
        String r37 = (String) CollectionsKt.firstOrNull(r4.h);
        u r38 = r4.w;
        if (r38 == null) goto L70;
        String r212 = r38.i();
    L71:
        Long r39 = r4.c;
        if (r39 == null) goto L74;
        long r40 = r39.longValue();
    L75:
        long r310 = r40;
        String r213 = (String) r4.C.a(wn.a.y);
        String r214 = (String) r4.C.a(wn.a.z);
        BtmSDK r41 = BtmSDK.INSTANCE;
        PageFinder r42 = PageFinder.via(r17);
        int r120 = zq3.f.a;
        com.bytedance.android.ec.window.base.common.starter.f.a(r30, r5, r114, "store_page", null, r115, r116, r117, r210, "list_card", r31, r118, r211, r32, r37, false, r212, r310, null, r213, r214, r41.createJumpSourceBtmToken(r33, r42, zq3.f.a(r16, r4)), 194510848);
        return;
    L74:
        r40 = SourceType.UNKNOWN.getType();
        goto L75
    L70:
        r212 = null;
        goto L71
    L66:
        r119 = r35;
        goto L67
    L63:
        r35 = null;
        goto L64
    L52:
        if (r114.length() <= 0) goto L54;
        boolean r121 = true;
    L55:
        if (r121 == true) goto L58;
        r114 = null;
    L58:
        if (r114 != null) goto L60;
    L54:
        r121 = false;
        goto L55
    L25:
        r14 = "live_top_102";
        goto L27
    L26:
        r14 = "live_top_101";
    L18:
        r12 = "live_top";
        goto L21
    L19:
        r12 = "comment_cart_tag";
        goto L21
    L20:
        r12 = "product_card";
        goto L21
    L8:
        r10 = null;
        goto L10
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r32) {
        FragmentActivity r6 = "";
        int r9 = -1;
        if (Intrinsics.areEqual(r32, (ImageView) this.l.getValue()) == false) goto L26;
        PageFinder r1 = PageFinder.via(r32);
        wp3.d r2 = this.p;
        if (r2 == null) goto L77;
        fo.b r10 = this.e;
        if (r10 == null) goto L12;
        Integer r11 = (Integer) r10.a(vp3.b.c);
        if (r11 == null) goto L12;
        r9 = r11.intValue();
    L12:
        StringBuilder r12 = new StringBuilder("a1.b76473.c31643.d39004_i");
        int r13 = r9 + 1;
        r12.append(r13);
        BtmItemBuilder r14 = new BtmItemBuilder(r12.toString(), Boolean.FALSE);
        QContext r15 = u();
        FragmentActivity r16 = l0.c(r15.c());
        if ((r16 instanceof FragmentActivity) == true) goto L15;
        r16 = null;
    L15:
        if (r16 != null) goto L17;
        r16 = r15.a();
    L17:
        String r17 = BtmSDK.INSTANCE.obtainEventBtmParams(r14.withBtmPage(r16).build());
        int r18 = com.bytedance.android.window.shop.innerflow.a.a;
        ECWindowInnerFlowViewModel r19 = G();
        WindowV2ProductItemVO r110 = r2.a;
        Intrinsics.checkNotNullParameter(r19, "innerFlowViewModel");
        Intrinsics.checkNotNullParameter(r110, "product");
        Intrinsics.checkNotNullParameter(r1, "pageFinder");
        Intrinsics.checkNotNullParameter(r17, "btmId");
        BcmParams r8 = new BcmParams();
        r8.put("bst_group_type", "product");
        Unit r111 = Unit.INSTANCE;
        EcomBcmTracker.j(r1, r8);
        String r3 = String.valueOf(EcomBcmTracker.c(r1, cd.a.c(com.bytedance.android.window.shop.innerflow.a.a(r19))));
        Map r20 = com.bytedance.android.window.shop.innerflow.a.c(r19, r9, r110.a);
        r20.put("carrier_source", "store_page");
        FragmentActivity r21 = r110.b;
        if (r21 == null) goto L21;
        r6 = r21;
    L21:
        r20.put("commodity_id", r6);
        r20.put("entrance_info", r3);
        r20.put("btm_id", r17);
        r20.put("bst_group_type", "product");
        r19.doEventAction("click_add_to_cart", r20, new Pair[0]);
        xn.b r112 = xn.b.f;
        Activity r113 = l0.b(u().c());
        WindowV2ProductItemVO r4 = r2.a;
        ECWindowStoreType r5 = ECWindowStoreType.WINDOW;
        if (G().getInnerFlowParam().c != 1) goto L24;
        ECWindowSourceMethod r7 = ECWindowSourceMethod.COMMENT_CART_TAG;
    L25:
        Function1<Integer, Unit> r22 = this.r;
        Function3<String, String, Long, Unit> r23 = this.s;
        com.bytedance.android.btm.api.model.d r24 = new com.bytedance.android.btm.api.model.d();
        r24.a = "a1.b76473.c31643.d39004_i" + r13;
        r24.b = PageFinder.via(y());
        int r25 = zq3.f.a;
        r24.c = zq3.f.a(ECWindowInnerFlowViewModel.getParam$default(G(), "uid", null, 2, null), r2.a);
        r112.a(r113, r4, new com.bytedance.android.ec.window.base.common.starter.e(r5, r7, ECWindowProductForm.FLOW, ECWindowInnerFlowViewModel.getParam$default(G(), "uid", null, 2, null), ECWindowInnerFlowViewModel.getParam$default(G(), "sec_uid", null, 2, null), com.bytedance.android.window.shop.innerflow.a.a(G())), "a1.b76473.c31643.d39004_i" + r13, r22, r23, r24, WindowEntranceInfoScene.ENTER_PRODUCT_DETAIL);
        return;
    L24:
        r7 = ECWindowSourceMethod.PRODUCT_CARD;
        goto L25
    L77:
        return;
    L26:
        FragmentActivity r26 = null;
        if (Intrinsics.areEqual(r32, F()) == false) goto L53;
        wp3.d r27 = this.p;
        if (r27 == null) goto L78;
        Long r28 = r27.a.c;
        if (r28 == null) goto L73;
        long r29 = r28.longValue();
        SourceType.Companion.getClass();
        if (SourceType.a.e(r29) == false) goto L46;
        xn.b r30 = xn.b.f;
        QContext r31 = u();
        FragmentActivity r33 = l0.c(r31.c());
        if ((r33 instanceof FragmentActivity) == false) goto L39;
        r26 = r33;
    L39:
        if (r26 != null) goto L41;
        r26 = r31.a();
    L41:
        WindowV2ProductItemVO r34 = r27.a;
        String r35 = r27.b.b;
        r30.getClass();
        Intrinsics.checkNotNullParameter(r26, "activity");
        Intrinsics.checkNotNullParameter(r34, "promotion");
        Intrinsics.checkNotNullParameter(r35, "url");
        r30.d.getClass();
        Intrinsics.checkNotNullParameter(r26, "activity");
        Intrinsics.checkNotNullParameter(r34, "promotion");
        Intrinsics.checkNotNullParameter(r35, "url");
        ECOrderTrackerData r36 = new ECOrderTrackerData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, 262143, null);
        Long r37 = r34.c;
        if (r37 == null) goto L44;
        long r38 = r37.longValue();
    L45:
        String r39 = r34.b;
        vl.a r114 = new vl.a(String.valueOf(r34.c), r36.getVideoId(), r36.getSecAuthorId());
        vl.c r115 = new vl.c();
        r115.a = r36.getVideoId();
        r115.b = r36.getAuthorId();
        r115.c = r34.b;
        r115.d = String.valueOf(r34.c);
        r36.getFollowStatus();
        r115.e = r36.getSourcePage();
        r36.getSourcePage();
        r115.f = r36.getAdLogExtra();
        r115.g = r34.a;
        Unit r40 = Unit.INSTANCE;
        vl.b r41 = new vl.b(r38, r39, r35, null, null, r114, r115);
        boolean r42 = ECServiceManager.a;
        ((IEShoppingService) ECServiceManager.c(IEShoppingService.class)).openThirdPlatform(r26, r41);
        return;
    L44:
        r38 = SourceType.UNKNOWN.getType();
        goto L45
    L46:
        fo.b r43 = this.e;
        if (r43 == null) goto L51;
        Integer r44 = (Integer) r43.a(vp3.b.c);
        if (r44 == null) goto L51;
        r9 = r44.intValue();
    L51:
        int r45 = com.bytedance.android.window.shop.innerflow.a.a;
        ECWindowInnerFlowViewModel r46 = G();
        String r47 = r27.a.a;
        int r48 = r9 + 1;
        Intrinsics.checkNotNullParameter(r46, "innerFlowViewModel");
        Intrinsics.checkNotNullParameter(r47, "productId");
        Map r49 = com.bytedance.android.window.shop.innerflow.a.c(r46, r48, r47);
        r49.put("carrier_type", "full_screen_card");
        r49.put("btm_id", "a1.b76473.c31643.d50767_i" + r48);
        Unit r50 = Unit.INSTANCE;
        r46.doEventAction("click_product", r49, new Pair[0]);
        I("a1.b76473.c31643.d50767_i" + r48);
        return;
    L73:
        return;
    L78:
        return;
    L53:
        if (Intrinsics.areEqual(r32, y()) == false) goto L76;
        fo.b r51 = this.e;
        if (r51 == null) goto L59;
        Integer r52 = (Integer) r51.a(vp3.b.c);
        if (r52 == null) goto L59;
        r9 = r52.intValue();
    L59:
        StringBuilder r53 = new StringBuilder("a1.b76473.c31643.d4283_i");
        int r54 = r9 + 1;
        r53.append(r54);
        String r55 = r53.toString();
        I(r55);
        int r116 = com.bytedance.android.window.shop.innerflow.a.a;
        ECWindowInnerFlowViewModel r117 = G();
        wp3.d r118 = this.p;
        if (r118 == null) goto L64;
        WindowV2ProductItemVO r119 = r118.a;
        if (r119 == null) goto L64;
        r26 = r119.a;
    L64:
        if (r26 == null) goto L67;
        r6 = r26;
    L67:
        String r56 = BtmSDK.INSTANCE.obtainEventBtmParams(new BtmItemBuilder(r55, Boolean.TRUE).withView(y()).build());
        Intrinsics.checkNotNullParameter(r117, "innerFlowViewModel");
        Intrinsics.checkNotNullParameter(r6, "productId");
        Intrinsics.checkNotNullParameter("product", "bstGroupType");
        Map r57 = com.bytedance.android.window.shop.innerflow.a.c(r117, r54, r6);
        r57.put("bst_group_type", "product");
        if (r56 == null) goto L70;
        r57.put("btm_id", r56);
    L70:
        r117.doEventAction("click_product", r57, new Pair[0]);
        return;
    }
}
