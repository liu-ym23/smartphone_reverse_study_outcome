package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.product.OneFrameAsyncTask;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.product.presenter.utils.ECProductCardFunctionUtils;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.store.home.view.LottieAnimationViewWithPlayCount;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.router.hybridpage.slice.SliceProductCardData;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.slicecard.ShopSliceKey;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class ShopSlicedProductCardBasePresenter extends QFragmentPresenter implements View.OnClickListener {
    public final Map<String, Object> f;
    public final Map<String, Object> g;
    public final Set<String> h;
    public final Set<Map<String, String>> i;
    public final ConcurrentHashMap<String, List<Object>> j;
    public ShopSlcProductItemV2 k;
    public String l;
    public a m;
    public View n;
    public SliceProductCardData o;
    public com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c p;
    public boolean q;
    public boolean r;
    public final Lazy s;
    public final ArrayList<Runnable> t;
    public final Lazy u;
    public final com.bytedance.android.ecom.arch.slice.render.r v;
    public final LayoutTypes w;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ ShopSlicedProductCardBasePresenter a;

        public a(ShopSlicedProductCardBasePresenter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            final ShopSlcProductItemV2 r10 = this.a.k;
            if (r10 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("currentItem");
        L5:
            if (r10 == null) goto L7;
            final ShopSlicedProductCardBasePresenter r11 = this.a;
            r11.getClass();
            OneFrameAsyncTask.a(new d0(new ShopSlicedProductCardBasePresenter$onDisplay$runnable$1(r11, r10)));
        L7:
            ShopSlicedProductCardBasePresenter r12 = this.a;
            com.bytedance.android.ecom.arch.slice.render.r r13 = r12.v;
            if (r13 == null) goto L13;
            View r14 = r13.c;
            if (r14 == null) goto L14;
            r14.removeOnLayoutChangeListener(r12.m);
            return;
        L14:
            return;
        }
    }

    public final void c0() {
        com.bytedance.android.ecom.arch.slice.render.r r0 = this.v;
        if (r0 == null) goto L7;
        SlcTemplateContext r1 = r0.b;
        if (r1 == null) goto L7;
        r1.u(this.l);
    L7:
        a r2 = this.m;
        if (r2 == null) goto L15;
        com.bytedance.android.ecom.arch.slice.render.r r3 = this.v;
        if (r3 == null) goto L16;
        View r4 = r3.c;
        if (r4 == null) goto L17;
        r4.removeOnLayoutChangeListener(r2);
        return;
    L17:
        return;
    L16:
        return;
    }

    public final String e0() {
        ShopSlcProductItemV2 r0 = this.k;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L6:
        if (Intrinsics.areEqual(r0.g, "__GUESS_LIKE_PRODUCTS_CUR_STORE_SECTION__") == true) goto L28;
        ShopSlcProductItemV2 r1 = this.k;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L11:
        if (Intrinsics.areEqual(r1.g, "__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == true) goto L28;
        StringBuilder r2 = new StringBuilder();
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c r3 = this.p;
        if (r3 == null) goto L18;
        jm.a<LayoutTypes> r4 = r3.a();
        if (r4 == null) goto L18;
        LayoutTypes r5 = (LayoutTypes) r4.getValue();
    L20:
        if (r5 != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L22;
        String r6 = "a1.b6269.c2429.d00357";
    L23:
        r2.append(r6);
        r2.append("_i");
        ShopSlcProductItemV2 r7 = this.k;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L26:
        r2.append(r7.h);
        return r2.toString();
    L22:
        r6 = "a1.b6269.c2429.d3147";
    L18:
        r5 = null;
    L28:
        StringBuilder r8 = new StringBuilder("a1.b6269.c2429.d54148_i");
        ShopSlcProductItemV2 r9 = this.k;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L31:
        r8.append(r9.h + 1);
        return r8.toString();
    }

    public static final void d0(ShopSlicedProductCardBasePresenter r5) {
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c r0 = r5.p;
        if (r0 == null) goto L24;
        WeakReference<LottieAnimationViewWithPlayCount> r1 = r0.a.x.getCartAnimationView();
        if (r1 == null) goto L25;
        LottieAnimationViewWithPlayCount r2 = r1.get();
        if (r2 == null) goto L26;
        ShopSlcProductItemV2 r3 = r5.k;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L11:
        Boolean r4 = null;
        if (r3 == null) goto L16;
        List r6 = r3.o;
        if (r6 == null) goto L16;
        String r7 = (String) CollectionsKt.firstOrNull(r6);
    L17:
        if (r7 == null) goto L27;
        View r8 = r5.n;
        int r9 = ECProductCardFunctionUtils.a;
        Context r10 = r5.Y().c();
        if (r5.p == null) goto L22;
        r4 = Boolean.FALSE;
    L22:
        ECProductCardFunctionUtils.a(r10, r7, r8, r2, r4);
        return;
    L27:
        return;
    L16:
        r7 = null;
        goto L17
    L26:
        return;
    L25:
        return;
    }

    public final void b0(QModel r11) {
        String r1 = null;
        if ((r11 instanceof ShopSlcProductItemV2) == true) goto L5;
        QModel r0 = null;
    L7:
        if (((ShopSlcProductItemV2) r0) != null) goto L9;
        return;
    L9:
        final ShopSlcProductItemV2 r12 = (ShopSlcProductItemV2) r11;
        this.k = r12;
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.d r2 = (com.bytedance.android.shopping.store.router.hybridpage.presenter.product.d) this;
        SliceProductCardData r3 = r2.x.getSliceProductCardData();
        if (r3 != null) goto L12;
        r3 = new SliceProductCardData();
    L12:
        this.o = r3;
        this.p = new com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c(r2);
        ShopSlcProductItemV2 r4 = this.k;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L15:
        Object r5 = r4.c.get("slice_item_extra");
        if ((r5 instanceof Map) == true) goto L18;
        r5 = null;
    L18:
        Map r6 = (Map) r5;
        if (r6 == null) goto L21;
        Object r7 = r6.get("disable_na_track_show_product");
    L23:
        if ((r7 instanceof Boolean) == true) goto L25;
        r7 = null;
    L25:
        Boolean r8 = (Boolean) r7;
        if (r8 == null) goto L28;
        boolean r9 = r8.booleanValue();
    L29:
        this.q = r9;
        ShopSlcProductItemV2 r10 = this.k;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L32:
        Object r13 = r10.c.get("slice_item_extra");
        if ((r13 instanceof Map) == true) goto L35;
        r13 = null;
    L35:
        Map r14 = (Map) r13;
        if (r14 == null) goto L38;
        Object r15 = r14.get("disable_na_open_product_detail");
    L40:
        if ((r15 instanceof Boolean) == true) goto L42;
        r15 = null;
    L42:
        Boolean r16 = (Boolean) r15;
        if (r16 == null) goto L45;
        boolean r17 = r16.booleanValue();
    L46:
        this.r = r17;
        com.bytedance.android.ecom.arch.slice.render.r r18 = this.v;
        if (r18 == null) goto L49;
        r18.b((com.bytedance.android.ecom.arch.slice.render.b) this.u.getValue());
    L49:
        StringBuilder r19 = new StringBuilder();
        r19.append(ShopSliceUniqueId.SHOP_PRODUCT_CARD.getId());
        r19.append('_');
        if (r12 == null) goto L52;
        String r20 = r12.j;
    L53:
        r19.append(r20);
        r19.append('_');
        r19.append(r12.i);
        String r21 = r19.toString();
        this.l = r21;
        com.bytedance.android.ecom.arch.slice.render.r r22 = this.v;
        if (r22 == null) goto L58;
        SlcTemplateContext r23 = r22.b;
        if (r23 == null) goto L58;
        r23.s(r21, new ShopSlicedProductCardBasePresenter$onBind$$inlined$let$lambda$1(r12, this));
    L58:
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c r24 = this.p;
        if (r24 == null) goto L63;
        com.bytedance.android.shopping.store.slicecard.b r25 = r24.b();
        if (r25 == null) goto L63;
        Map<String, Object> r26 = r25.a();
    L64:
        r12.c(r26);
        com.bytedance.android.ecom.arch.slice.render.r r27 = this.v;
        if (r27 == null) goto L67;
        r27.a((Map) r12.w.getValue(), this.l);
    L67:
        a r110 = new a(this);
        this.m = r110;
        com.bytedance.android.ecom.arch.slice.render.r r28 = this.v;
        if (r28 == null) goto L70;
        View r29 = r28.c;
    L71:
        if (r29 == null) goto L81;
        r29.addOnLayoutChangeListener(r110);
        com.bytedance.android.ecom.arch.slice.render.r r111 = this.v;
        if (r111 == null) goto L79;
        SlcTemplateContext r112 = r111.b;
        if (r112 == null) goto L79;
        if (r112.w == null) goto L79;
        View r113 = SlcRenderContext.f(r29, ShopSliceKey.PRODUCT_COVER.getKey());
    L80:
        this.n = r113;
    L82:
        com.bytedance.android.ecom.arch.slice.render.r r114 = this.v;
        if (r114 == null) goto L87;
        View r30 = r114.c;
        if (r30 == null) goto L87;
        SlcRenderContext r115 = r114.b.w;
        String r31 = ShopSliceKey.PRODUCT_COVER.getKey();
        r115.getClass();
        this.n = SlcRenderContext.f(r30, r31);
    L88:
        ShopSlcProductItemV2 r116 = this.k;
        if (r116 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L91:
        if (r116 == null) goto L95;
        com.bytedance.android.ec.store.repository.vo.b r117 = r116.n;
        if (r117 == null) goto L95;
        Boolean r118 = r117.a;
    L97:
        if (Intrinsics.areEqual(r118, Boolean.FALSE) == false) goto L102;
        ShopSlcProductItemV2 r119 = this.k;
        if (r119 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L101:
        Intrinsics.checkNotNull(r119);
        Intrinsics.checkNotNullParameter(r119, "item");
        OneFrameAsyncTask.a(new c0(this, r119));
    L102:
        ShopSlcProductItemV2 r120 = this.k;
        if (r120 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L106:
        if (r120.s == 0) goto L118;
        HybridPageViewModel r121 = r2.x;
        if (r121 == null) goto L118;
        Pair[] r32 = new Pair[2];
        r32[0] = TuplesKt.to("module_name", CommentServiceId.HOT_SPOT);
        ShopSlcProductItemV2 r33 = this.k;
        if (r33 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L112:
        if (r33 == null) goto L114;
        r1 = r33.j;
    L114:
        if (r1 != null) goto L116;
        r1 = "";
    L116:
        r32[1] = TuplesKt.to("element_id", r1);
        r121.doEventAction("show_ecom_element", MapsKt.mutableMapOf(r32), new Pair[0]);
    L118:
        if (this.r == true) goto L122;
        if (r29 == null) goto L123;
        r29.setOnClickListener(this);
        return;
    L123:
        return;
    L122:
        return;
    L95:
        r118 = null;
    L87:
        this.n = null;
    L79:
        r113 = null;
        goto L80
    L81:
        this.n = null;
        goto L82
    L70:
        r29 = null;
    L63:
        r26 = null;
        goto L64
    L52:
        r20 = null;
        goto L53
    L45:
        r17 = false;
        goto L46
    L38:
        r15 = null;
        goto L40
    L28:
        r9 = false;
        goto L29
    L21:
        r7 = null;
        goto L23
    L5:
        r0 = r11;
        goto L7
    }

    public final String i0(ShopSlcProductItemV2 r3) {
        if (Intrinsics.areEqual(r3.g, "__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == false) goto L6;
        return "cross_recommend_product";
    L6:
        if (Intrinsics.areEqual(r3.g, "__GUESS_LIKE_PRODUCTS_CUR_STORE_SECTION__") == false) goto L8;
        return "102";
    L8:
        Boolean r4 = Boolean.TRUE;
        if (Intrinsics.areEqual(null, r4) == false) goto L12;
        return "live_product";
    L12:
        if (Intrinsics.areEqual(null, r4) == false) goto L14;
        return "living_product";
    L14:
        return CommentServiceId.HOT_SPOT;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r21) {
        if (this.r != true) goto L5;
        return;
    L5:
        ECShopABSettings.k.getClass();
        ECShopABSettings.h();
        BtmSDK r1 = BtmSDK.INSTANCE;
        String r3 = e0();
        PageFinder r4 = PageFinder.via(((QFragmentPresenter) this).e);
        BcmParams r5 = new BcmParams();
        r5.put("bst_group_type", "product");
        Unit r6 = Unit.INSTANCE;
        ShopSlcProductItemV2 r7 = this.k;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L8:
        String r2 = r1.createJumpSourceBtmToken(r3, r4, r5.merge((Map) r7.v.getValue()));
        SliceProductCardData r8 = this.o;
        String r9 = null;
        if (r8 == null) goto L11;
        String r10 = r8.getEcomEntranceFrom();
    L13:
        if (r10 != null) goto L15;
    L17:
        boolean r11 = false;
    L18:
        if (r11 == true) goto L22;
        r10 = null;
    L22:
        if (r10 != null) goto L38;
        SliceProductCardData r12 = this.o;
        if (r12 == null) goto L26;
        String r13 = r12.getPageName();
    L28:
        if (Intrinsics.areEqual(r13, "classification_secondary_page") == false) goto L30;
        r10 = "classification";
        goto L38
    L30:
        SliceProductCardData r14 = this.o;
        if (r14 == null) goto L37;
        ProductBasicRequestParam r15 = r14.getProductBasicRequestParam();
        if (r15 == null) goto L37;
        if (r15.isCustom() != true) goto L37;
        r10 = "featured";
    L37:
        r10 = "products";
        goto L38
    L26:
        r13 = null;
    L38:
        List r16 = com.bytedance.android.ec.store.utils.c.a;
        ShopSlcProductItemV2 r17 = this.k;
        if (r17 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L41:
        if (r17 == null) goto L43;
        String r18 = r17.j;
    L44:
        Intrinsics.checkNotNull(r18);
        com.bytedance.android.ec.store.utils.c.a(r18);
        com.bytedance.commerce.base.json.a[] r19 = new com.bytedance.commerce.base.json.a[20];
        SliceProductCardData r20 = this.o;
        if (r20 == null) goto L47;
        String r22 = r20.getShareContent();
    L48:
        String r110 = "";
        if (Intrinsics.areEqual(r22, "shop") == false) goto L51;
        String r23 = "share_alert";
    L57:
        r19[0] = JsonDslUtilKt.d("product_source_page", r23);
        r19[1] = JsonDslUtilKt.d("source_method", r10);
        SliceProductCardData r24 = this.o;
        if (r24 == null) goto L60;
        String r25 = r24.getPageName();
    L62:
        if (Intrinsics.areEqual(r25, "classification_secondary_page") == false) goto L67;
        StringBuilder r26 = new StringBuilder("_");
        ShopSlcProductItemV2 r27 = this.k;
        if (r27 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L66:
        r26.append(r27.h);
        String r28 = r26.toString();
    L68:
        r19[2] = JsonDslUtilKt.d("tab_label", r28);
        r19[3] = JsonDslUtilKt.d("category_id", "");
        r19[4] = JsonDslUtilKt.d("tab_type", "");
        r19[5] = JsonDslUtilKt.d("page_version", "");
        SliceProductCardData r29 = this.o;
        if (r29 == null) goto L71;
        String r30 = r29.getPageName();
    L72:
        if (r30 != null) goto L74;
        r30 = "";
    L74:
        r19[6] = JsonDslUtilKt.d("page_name", r30);
        SliceProductCardData r31 = this.o;
        if (r31 == null) goto L79;
        Integer r32 = r31.getFollowStatus();
        if (r32 == null) goto L79;
        String r33 = String.valueOf(r32.intValue());
    L80:
        if (r33 != null) goto L82;
        r33 = "";
    L82:
        r19[7] = JsonDslUtilKt.d("follow_status", r33);
        SliceProductCardData r34 = this.o;
        if (r34 == null) goto L85;
        String r35 = r34.getTempId();
    L86:
        if (r35 != null) goto L88;
        r35 = "";
    L88:
        r19[8] = JsonDslUtilKt.d("temp_id", r35);
        r19[9] = JsonDslUtilKt.d("store_type", "shop");
        SliceProductCardData r36 = this.o;
        if (r36 == null) goto L91;
        String r37 = r36.getStoreSourcePage();
    L92:
        if (r37 != null) goto L94;
        r37 = "";
    L94:
        r19[10] = JsonDslUtilKt.d("store_source_page", r37);
        SliceProductCardData r38 = this.o;
        if (r38 == null) goto L97;
        String r39 = r38.getStoreSourceMethod();
    L98:
        if (r39 != null) goto L100;
        r39 = "";
    L100:
        r19[11] = JsonDslUtilKt.d("store_source_method", r39);
        SliceProductCardData r40 = this.o;
        if (r40 == null) goto L103;
        String r41 = r40.getStoreGroupType();
    L104:
        if (r41 != null) goto L106;
        r41 = "";
    L106:
        r19[12] = JsonDslUtilKt.d("store_group_type", r41);
        SliceProductCardData r42 = this.o;
        if (r42 == null) goto L109;
        String r43 = r42.getLiveAnchorId();
    L110:
        if (r43 != null) goto L112;
        r43 = "";
    L112:
        r19[13] = JsonDslUtilKt.d("live_anchor_id", r43);
        SliceProductCardData r44 = this.o;
        if (r44 == null) goto L115;
        String r45 = r44.getPreProductId();
    L116:
        if (r45 != null) goto L118;
        r45 = "";
    L118:
        r19[14] = JsonDslUtilKt.d("pre_product_id", r45);
        SliceProductCardData r46 = this.o;
        if (r46 == null) goto L121;
        String r47 = r46.getPreRoomId();
    L122:
        if (r47 != null) goto L124;
        r47 = "";
    L124:
        r19[15] = JsonDslUtilKt.d("pre_room_id", r47);
        SliceProductCardData r48 = this.o;
        if (r48 == null) goto L127;
        String r49 = r48.getPreGroupId();
    L128:
        if (r49 == null) goto L131;
        r110 = r49;
    L131:
        r19[16] = JsonDslUtilKt.d("pre_group_id", r110);
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c r50 = this.p;
        if (r50 == null) goto L136;
        jm.a<LayoutTypes> r51 = r50.a();
        if (r51 == null) goto L136;
        LayoutTypes r52 = (LayoutTypes) r51.getValue();
    L137:
        if (r52 != null) goto L140;
    L141:
        String r53 = "double_product";
    L143:
        r19[17] = JsonDslUtilKt.d("product_form", r53);
        r19[18] = JsonDslUtilKt.d("content_source", "shop");
        r19[19] = JsonDslUtilKt.c("dismiss_live_strand", 1);
        JSONObject r111 = JsonDslUtilKt.a(r19);
        SliceProductCardData r54 = this.o;
        if (r54 == null) goto L156;
        ProductBasicRequestParam r55 = r54.getProductBasicRequestParam();
        if (r55 == null) goto L156;
        if (r55.isCustom() != true) goto L156;
        SliceProductCardData r56 = this.o;
        if (r56 == null) goto L154;
        ProductBasicRequestParam r57 = r56.getProductBasicRequestParam();
        if (r57 == null) goto L154;
        String r58 = r57.getMaterialId();
    L155:
        r111.accumulate("customer_id", r58);
    L154:
        r58 = null;
    L156:
        SliceProductCardData r59 = this.o;
        if (r59 != null) goto L159;
    L169:
        SliceProductCardData r60 = this.o;
        if (r60 == null) goto L172;
        String r61 = (String) r60.getPassThroughParam("icon_type");
    L173:
        r111.accumulate("icon_type", r61);
        ShopSlcProductItemV2 r62 = this.k;
        if (r62 != null) goto L176;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L176:
        Map<String, String> r63 = r62.f;
        if (r63 == null) goto L182;
        Iterator<Map.Entry<String, String>> r64 = r63.entrySet().iterator();
    L180:
        if (r64.hasNext() == false) goto L182;
        Map.Entry<String, String> r65 = r64.next();
        r111.put(r65.getKey(), r65.getValue());
    L182:
        SliceProductCardData r66 = this.o;
        if (r66 == null) goto L185;
        String r67 = (String) r66.getPassThroughParam("pass_through_api");
    L186:
        JSONObject r68 = com.bytedance.android.shopping.extensions.k.w(r67);
        if (r68 == null) goto L189;
        r111.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r68.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
    L189:
        int r69 = com.bytedance.android.ec.store.utils.b.a;
        ShopSlcProductItemV2 r70 = this.k;
        if (r70 != null) goto L192;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L192:
        if (r70 == null) goto L194;
        String r71 = r70.p;
    L195:
        String r112 = com.bytedance.android.ec.store.utils.b.a(r71, r2);
        if (r112 != null) goto L198;
        return;
    L198:
        hm.b r113 = hm.b.c;
        Context r114 = Y().c();
        SliceProductCardData r72 = this.o;
        if (r72 == null) goto L201;
        Integer r73 = r72.getFollowStatus();
    L202:
        String r115 = String.valueOf(r73);
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c r74 = this.p;
        if (r74 == null) goto L213;
        Map<String, Object> r75 = r74.a.x.getAdParams();
        if (r75 == null) goto L213;
        ShopSlcProductItemV2 r76 = this.k;
        if (r76 != null) goto L209;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L209:
        if (r76 == null) goto L211;
        String r77 = r76.j;
    L212:
        Intrinsics.checkNotNull(r77);
        r75.put("product_id", r77);
        Unit r78 = Unit.INSTANCE;
        Map<String, Object> r116 = r75;
    L214:
        ShopSlcProductItemV2 r79 = this.k;
        if (r79 != null) goto L217;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L217:
        com.bytedance.android.ec.store.common.starter.e.b(r113, r114, r112, r115, r111, r116, "", r79.q, 128);
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r80 = com.bytedance.android.shopping.store.lifecycle.a.a;
        SliceProductCardData r81 = this.o;
        if (r81 == null) goto L220;
        Long r82 = Long.valueOf(r81.getLifecycleMonitorId());
    L221:
        com.bytedance.android.shopping.store.lifecycle.m r83 = com.bytedance.android.shopping.store.lifecycle.a.a(r82);
        if (r83 == null) goto L227;
        ShopSlcProductItemV2 r84 = this.k;
        if (r84 != null) goto L226;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L226:
        com.bytedance.android.shopping.store.lifecycle.c.a.a(r83, "click_product", h0("click_product", r84), null, 4);
    L227:
        ShopSlcProductItemV2 r85 = this.k;
        if (r85 != null) goto L230;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L230:
        Map<String, String> r86 = h0("click_product", r85);
        if (r86 == null) goto L234;
        Map<String, Object> r87 = MapsKt.plus(MapsKt.plus(r86, this.f), this.g);
        if (r87 == null) goto L234;
    L235:
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.d r88 = (com.bytedance.android.shopping.store.router.hybridpage.presenter.product.d) this;
        HybridPageViewModel r89 = r88.x;
        if (r89 == null) goto L241;
        int r90 = com.bytedance.android.ec.store.window.f.a;
        View r91 = a0();
        String r117 = e0();
        ShopSlcProductItemV2 r118 = this.k;
        if (r118 != null) goto L240;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L240:
        com.bytedance.android.ec.store.window.f.b(r91, r117, r118, r87, r89);
    L241:
        ShopSlcProductItemV2 r92 = this.k;
        if (r92 != null) goto L245;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L245:
        if (Intrinsics.areEqual(r92.g, "__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == false) goto L249;
        HybridPageViewModel r93 = r88.x;
        if (r93 == null) goto L249;
        r93.doAnyEventActionWithBtm(e0(), PageFinder.via(((QFragmentPresenter) this).e), "click_ecom_component", MapsKt.mapOf(new Pair[]{TuplesKt.to("module_name", "cross_recommend_product"), TuplesKt.to("tab_name_second", "cross_recommend_product")}), new Pair[0]);
    L249:
        com.bytedance.android.ec.sdk.helper.c r94 = com.bytedance.android.ec.sdk.helper.c.a;
        StringBuilder r95 = new StringBuilder("[click product]productId:");
        ShopSlcProductItemV2 r96 = this.k;
        if (r96 != null) goto L252;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L252:
        if (r96 == null) goto L254;
        String r97 = r96.j;
    L255:
        r95.append(r97);
        r94.b("SHOP", r95.toString());
        StringBuilder r98 = new StringBuilder("[click product]secShopId:");
        SliceProductCardData r99 = this.o;
        if (r99 == null) goto L258;
        r9 = r99.getSecShopId();
    L258:
        r98.append(r9);
        r94.b("SHOP", r98.toString());
        return;
    L254:
        r97 = null;
    L234:
        r87 = this.f;
        goto L235
    L220:
        r82 = null;
        goto L221
    L211:
        r77 = null;
    L213:
        r116 = null;
        goto L214
    L201:
        r73 = null;
        goto L202
    L194:
        r71 = null;
        goto L195
    L185:
        r67 = null;
        goto L186
    L172:
        r61 = null;
        goto L173
    L159:
        if (r59.isEcShare() != true) goto L169;
        SliceProductCardData r100 = this.o;
        if (r100 == null) goto L163;
        String r101 = r100.getShareContent();
    L164:
        r111.accumulate("share_content", r101);
        SliceProductCardData r102 = this.o;
        if (r102 == null) goto L167;
        String r103 = r102.getShareObject();
    L168:
        r111.accumulate("share_object", r103);
        goto L169
    L167:
        r103 = null;
        goto L168
    L163:
        r101 = null;
        goto L164
    L140:
        if (b0.d[r52.ordinal()] != 1) goto L141;
        r53 = "single_product";
    L136:
        r52 = null;
        goto L137
    L127:
        r49 = null;
        goto L128
    L121:
        r47 = null;
        goto L122
    L115:
        r45 = null;
        goto L116
    L109:
        r43 = null;
        goto L110
    L103:
        r41 = null;
        goto L104
    L97:
        r39 = null;
        goto L98
    L91:
        r37 = null;
        goto L92
    L85:
        r35 = null;
    L79:
        r33 = null;
        goto L80
    L71:
        r30 = null;
        goto L72
    L67:
        r28 = "";
        goto L68
    L60:
        r25 = null;
        goto L62
    L51:
        SliceProductCardData r104 = this.o;
        if (r104 == null) goto L54;
        r23 = r104.getEntranceLocation();
    L55:
        if (r23 != null) goto L57;
        r23 = "";
        goto L57
    L54:
        r23 = null;
        goto L55
    L47:
        r22 = null;
        goto L48
    L43:
        r18 = null;
        goto L44
    L15:
        if ((!StringsKt.isBlank(r10)) != true) goto L17;
        r11 = true;
        goto L18
    L11:
        r10 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, String> h0(String r41, ShopSlcProductItemV2 r42) {
        SliceProductCardData r3 = this.o;
        if (r3 == null) goto L5;
        String r4 = r3.getEcomEntranceFrom();
    L6:
        int r5 = r41.hashCode();
        if (r5 == 1132134829) goto L100;
        if (r5 != 2022256952) goto L176;
        if (r41.equals("click_product") == false) goto L176;
        Map<String, String> r1 = com.bytedance.android.ec.store.product.presenter.utils.a.c(r42);
        Pair[] r6 = new Pair[24];
        if (this.p == null) goto L17;
        String r15 = String.valueOf(0);
        if (r15 == null) goto L17;
    L18:
        r6[0] = TuplesKt.to("shop_extra_status_type", r15);
        SliceProductCardData r12 = this.o;
        if (r12 == null) goto L21;
        String r13 = r12.getPageName();
    L23:
        if (Intrinsics.areEqual(r13, "classification_secondary_page") == false) goto L25;
        String r14 = "_" + r42.h;
    L26:
        r6[1] = TuplesKt.to("tab_label", r14);
        r6[2] = TuplesKt.to("category_id", null);
        r6[3] = TuplesKt.to("tab_type", null);
        r6[4] = TuplesKt.to("page_version", null);
        r6[5] = TuplesKt.to("ecom_entrance_form", r4);
        r6[6] = TuplesKt.to("brand_verified", "0");
        SliceProductCardData r7 = this.o;
        if (r7 == null) goto L29;
        String r8 = r7.getSearchParams();
    L30:
        r6[7] = TuplesKt.to("search_params", r8);
        SliceProductCardData r9 = this.o;
        if (r9 == null) goto L33;
        String r10 = r9.getPreProductId();
    L34:
        r6[8] = TuplesKt.to("pre_product_id", r10);
        SliceProductCardData r11 = this.o;
        if (r11 == null) goto L37;
        String r16 = r11.getPreRoomId();
    L38:
        r6[9] = TuplesKt.to("pre_room_id", r16);
        SliceProductCardData r17 = this.o;
        if (r17 == null) goto L41;
        String r18 = r17.getPreGroupId();
    L42:
        r6[10] = TuplesKt.to("pre_group_id", r18);
        r6[11] = TuplesKt.to("content_source", "shop");
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c r19 = this.p;
        if (r19 == null) goto L47;
        jm.a<LayoutTypes> r20 = r19.a();
        if (r20 == null) goto L47;
        LayoutTypes r21 = (LayoutTypes) r20.getValue();
    L48:
        if (r21 != null) goto L51;
    L52:
        Object r110 = "double_product";
    L55:
        r6[12] = TuplesKt.to("product_form", r110);
        r6[13] = TuplesKt.to("tab_name", r4);
        r6[14] = TuplesKt.to("tab_name_second", i0(r42));
        r6[15] = TuplesKt.to("is_discount_selected", "0");
        SliceProductCardData r22 = this.o;
        if (r22 != null) goto L58;
    L64:
        Object r23 = "";
        Pair r24 = TuplesKt.to(r23, r23);
    L65:
        r6[16] = r24;
        SliceProductCardData r25 = this.o;
        if (r25 != null) goto L68;
    L74:
        Pair r26 = TuplesKt.to(r23, r23);
    L75:
        r6[17] = r26;
        r6[18] = TuplesKt.to("btm_index", String.valueOf(r42.h + 1));
        r6[19] = TuplesKt.to("bst_group_type", "product");
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c r27 = this.p;
        if (r27 == null) goto L80;
        jm.a<Integer> r28 = r27.a.x.getProductViewsNum();
        if (r28 == null) goto L80;
        Integer r29 = (Integer) r28.getValue();
    L81:
        r6[20] = TuplesKt.to("product_view_num", String.valueOf(r29));
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c r30 = this.p;
        if (r30 == null) goto L86;
        jm.a<Integer> r31 = r30.a.x.getTotalProductNum();
        if (r31 == null) goto L86;
        Integer r32 = (Integer) r31.getValue();
    L87:
        r6[21] = TuplesKt.to("product_total_num", String.valueOf(r32));
        r6[22] = TuplesKt.to("product_click_index", String.valueOf(r42.i));
        r6[23] = TuplesKt.to("bst_tag", "bst_tag");
        r1.putAll(MapsKt.mapOf(r6));
        if (Intrinsics.areEqual(r42.g, "__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == false) goto L90;
        r1.put("module_name", "cross_recommend_product");
    L90:
        Iterator r2 = BtmSDK.INSTANCE.createReportParams(e0(), PageFinder.via(((QFragmentPresenter) this).e)).entrySet().iterator();
    L92:
        if (r2.hasNext() == false) goto L183;
        Map.Entry r33 = (Map.Entry) r2.next();
        Object r34 = r33.getKey();
        Object r35 = r33.getValue();
        if (r35 == null) goto L96;
        String r36 = r35.toString();
    L97:
        r1.put(r34, r36);
        goto L92
    L96:
        r36 = null;
        goto L97
    L183:
        return r1;
    L86:
        r32 = null;
    L80:
        r29 = null;
        goto L81
    L68:
        if (r25.isEcShare() != true) goto L74;
        SliceProductCardData r37 = this.o;
        if (r37 == null) goto L72;
        String r38 = r37.getShareObject();
    L73:
        r26 = TuplesKt.to("share_object", r38);
        goto L75
    L72:
        r38 = null;
        goto L73
    L58:
        if (r22.isEcShare() != true) goto L64;
        SliceProductCardData r39 = this.o;
        if (r39 == null) goto L62;
        String r40 = r39.getShareContent();
    L63:
        r24 = TuplesKt.to("share_content", r40);
        r23 = "";
        goto L65
    L62:
        r40 = null;
        goto L63
    L51:
        if (b0.b[r21.ordinal()] != 1) goto L52;
        r110 = "single_product";
    L47:
        r21 = null;
        goto L48
    L41:
        r18 = null;
        goto L42
    L37:
        r16 = null;
        goto L38
    L33:
        r10 = null;
        goto L34
    L29:
        r8 = null;
        goto L30
    L25:
        r14 = "";
        goto L26
    L21:
        r13 = null;
    L17:
        r15 = "";
    L176:
        return null;
    L100:
        if (r41.equals("show_product") == false) goto L176;
        Map<String, String> r43 = com.bytedance.android.ec.store.product.presenter.utils.a.c(r42);
        Pair[] r44 = new Pair[21];
        if (this.p == null) goto L105;
        String r45 = String.valueOf(0);
        if (r45 == null) goto L105;
    L106:
        r44[0] = TuplesKt.to("shop_extra_status_type", r45);
        SliceProductCardData r46 = this.o;
        if (r46 == null) goto L109;
        String r47 = r46.getPageName();
    L111:
        if (Intrinsics.areEqual(r47, "classification_secondary_page") == false) goto L113;
        String r48 = "_" + r42.h;
    L114:
        r44[1] = TuplesKt.to("tab_label", r48);
        r44[2] = TuplesKt.to("category_id", null);
        r44[3] = TuplesKt.to("tab_type", null);
        r44[4] = TuplesKt.to("page_version", null);
        r44[5] = TuplesKt.to("ecom_entrance_form", r4);
        SliceProductCardData r49 = this.o;
        if (r49 == null) goto L117;
        String r50 = r49.getPreProductId();
    L118:
        r44[6] = TuplesKt.to("pre_product_id", r50);
        SliceProductCardData r51 = this.o;
        if (r51 == null) goto L121;
        String r52 = r51.getPreRoomId();
    L122:
        r44[7] = TuplesKt.to("pre_room_id", r52);
        SliceProductCardData r53 = this.o;
        if (r53 == null) goto L125;
        String r54 = r53.getPreGroupId();
    L126:
        r44[8] = TuplesKt.to("pre_group_id", r54);
        r44[9] = TuplesKt.to("brand_verified", "0");
        SliceProductCardData r55 = this.o;
        if (r55 == null) goto L129;
        String r56 = r55.getSearchParams();
    L130:
        r44[10] = TuplesKt.to("search_params", r56);
        r44[11] = TuplesKt.to("content_source", "shop");
        com.bytedance.android.shopping.store.router.hybridpage.presenter.product.c r57 = this.p;
        if (r57 == null) goto L135;
        jm.a<LayoutTypes> r58 = r57.a();
        if (r58 == null) goto L135;
        LayoutTypes r59 = (LayoutTypes) r58.getValue();
    L136:
        if (r59 != null) goto L138;
        int r60 = 1;
    L140:
        Object r111 = "double_product";
    L143:
        r44[12] = TuplesKt.to("product_form", r111);
        r44[13] = TuplesKt.to("btm_index", String.valueOf(r42.h + r60));
        r44[14] = TuplesKt.to("tab_name", r4);
        r44[15] = TuplesKt.to("tab_name_second", i0(r42));
        r44[16] = TuplesKt.to("is_discount_selected", "0");
        SliceProductCardData r61 = this.o;
        if (r61 != null) goto L146;
    L152:
        Object r62 = "";
        Pair r63 = TuplesKt.to(r62, r62);
    L153:
        r44[17] = r63;
        SliceProductCardData r64 = this.o;
        if (r64 != null) goto L156;
    L162:
        Pair r65 = TuplesKt.to(r62, r62);
    L163:
        r44[18] = r65;
        r44[19] = TuplesKt.to("bst_group_type", "product");
        r44[20] = TuplesKt.to("bst_tag", "bst_tag");
        r43.putAll(MapsKt.mapOf(r44));
        if (Intrinsics.areEqual(r42.g, "__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == false) goto L166;
        r43.put("module_name", "cross_recommend_product");
    L166:
        Iterator r66 = BtmSDK.INSTANCE.createReportParams(e0(), PageFinder.via(((QFragmentPresenter) this).e)).entrySet().iterator();
    L168:
        if (r66.hasNext() == false) goto L184;
        Map.Entry r67 = (Map.Entry) r66.next();
        Object r68 = r67.getKey();
        Object r69 = r67.getValue();
        if (r69 == null) goto L172;
        String r70 = r69.toString();
    L173:
        r43.put(r68, r70);
        goto L168
    L172:
        r70 = null;
        goto L173
    L184:
        return r43;
    L156:
        if (r64.isEcShare() != true) goto L162;
        SliceProductCardData r71 = this.o;
        if (r71 == null) goto L160;
        String r72 = r71.getShareObject();
    L161:
        r65 = TuplesKt.to("share_object", r72);
        goto L163
    L160:
        r72 = null;
        goto L161
    L146:
        if (r61.isEcShare() != true) goto L152;
        SliceProductCardData r73 = this.o;
        if (r73 == null) goto L150;
        String r74 = r73.getShareContent();
    L151:
        r63 = TuplesKt.to("share_content", r74);
        r62 = "";
        goto L153
    L150:
        r74 = null;
        goto L151
    L138:
        r60 = 1;
        if (b0.c[r59.ordinal()] != 1) goto L140;
        r111 = "single_product";
    L135:
        r59 = null;
        goto L136
    L129:
        r56 = null;
        goto L130
    L125:
        r54 = null;
        goto L126
    L121:
        r52 = null;
        goto L122
    L117:
        r50 = null;
        goto L118
    L113:
        r48 = "";
        goto L114
    L109:
        r47 = null;
    L105:
        r45 = "";
        goto L106
    L5:
        r4 = null;
        goto L6
    }

    public ShopSlicedProductCardBasePresenter(Fragment r2, com.bytedance.android.ecom.arch.slice.render.r r3, LayoutTypes r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "layoutTypes");
        super(r2);
        this.v = r3;
        this.w = r4;
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = new LinkedHashSet();
        this.i = new LinkedHashSet();
        this.j = new ConcurrentHashMap();
        this.l = "";
        this.s = LazyKt.lazy(new ShopSlicedProductCardBasePresenter$productActionHandler$2(this, r2));
        this.t = new ArrayList();
        this.u = LazyKt.lazy(new ShopSlicedProductCardBasePresenter$slcActionHandler$2(this));
    }
}
