package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.product.OneFrameAsyncTask;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.product.presenter.utils.ECProductCardFunctionUtils;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.view.LottieAnimationViewWithPlayCount;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.slicecard.ShopSliceKey;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopSlicedProductCardPresenterV2 extends QFragmentPresenter implements View.OnClickListener {
    public final Lazy f;
    public final Map<String, Object> g;
    public final Map<String, Object> h;
    public final Set<String> i;
    public final Set<Map<String, String>> j;
    public final ConcurrentHashMap<String, List<Object>> k;
    public ShopSlcProductItemV2 l;
    public String m;
    public a n;
    public View o;
    public final Lazy p;
    public final ArrayList<Runnable> q;
    public final Lazy r;
    public final com.bytedance.android.ecom.arch.slice.render.r s;
    public final LayoutTypes t;
    public final ECStoreViewModel u;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ ShopSlicedProductCardPresenterV2 a;

        public a(ShopSlicedProductCardPresenterV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            final ShopSlcProductItemV2 r10 = this.a.l;
            if (r10 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("currentItem");
        L5:
            if (r10 == null) goto L10;
            final ShopSlicedProductCardPresenterV2 r11 = this.a;
            r11.getClass();
            Function0<Unit> r12 = new ShopSlicedProductCardPresenterV2$onDisplay$runnable$1(r11, r10);
            if (r11.u.isChunkMerging() == false) goto L9;
            r11.q.add(new k0(r12));
            goto L10
        L9:
            OneFrameAsyncTask.a(new k0(r12));
        L10:
            ShopSlicedProductCardPresenterV2 r13 = this.a;
            com.bytedance.android.ecom.arch.slice.render.r r14 = r13.s;
            if (r14 == null) goto L16;
            View r15 = r14.c;
            if (r15 == null) goto L17;
            r15.removeOnLayoutChangeListener(r13.n);
            return;
        L17:
            return;
        }
    }

    public final ECShopHybridProductViewModel k0() {
        return (ECShopHybridProductViewModel) this.f.getValue();
    }

    public final void c0() {
        com.bytedance.android.ecom.arch.slice.render.r r0 = this.s;
        if (r0 == null) goto L7;
        SlcTemplateContext r1 = r0.b;
        if (r1 == null) goto L7;
        r1.u(this.m);
    L7:
        a r2 = this.n;
        if (r2 == null) goto L15;
        com.bytedance.android.ecom.arch.slice.render.r r3 = this.s;
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

    public final String h0() {
        ShopSlcProductItemV2 r0 = this.l;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L6:
        if (Intrinsics.areEqual(r0.g, "__GUESS_LIKE_PRODUCTS_CUR_STORE_SECTION__") == true) goto L28;
        ShopSlcProductItemV2 r1 = this.l;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L11:
        if (Intrinsics.areEqual(r1.g, "__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == true) goto L28;
        StringBuilder r2 = new StringBuilder();
        ECShopHybridProductViewModel r3 = k0();
        if (r3 == null) goto L18;
        jm.a<LayoutTypes> r4 = r3.getLayoutType();
        if (r4 == null) goto L18;
        LayoutTypes r5 = (LayoutTypes) r4.getValue();
    L20:
        if (r5 != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L22;
        String r6 = "a1.b6269.c2429.d00357";
    L23:
        r2.append(r6);
        r2.append("_i");
        ShopSlcProductItemV2 r7 = this.l;
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
        ShopSlcProductItemV2 r9 = this.l;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L31:
        r8.append(r9.h + 1);
        return r8.toString();
    }

    public static final void d0(ShopSlicedProductCardPresenterV2 r4) {
        ECShopHybridProductViewModel r0 = r4.k0();
        if (r0 == null) goto L20;
        WeakReference<LottieAnimationViewWithPlayCount> r1 = r0.getCartAnimationView();
        if (r1 == null) goto L21;
        LottieAnimationViewWithPlayCount r2 = r1.get();
        if (r2 == null) goto L22;
        ShopSlcProductItemV2 r3 = r4.l;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L11:
        if (r3 == null) goto L15;
        List r5 = r3.o;
        if (r5 == null) goto L15;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
    L16:
        if (r6 == null) goto L23;
        View r7 = r4.o;
        int r8 = ECProductCardFunctionUtils.a;
        ECProductCardFunctionUtils.a(r4.Y().c(), r6, r7, r2, Boolean.valueOf(r4.u.isBrandShopUpgrade()));
        return;
    L23:
        return;
    L15:
        r6 = null;
        goto L16
    L22:
        return;
    L21:
        return;
    }

    public final void b0(QModel r8) {
        String r1 = null;
        if ((r8 instanceof ShopSlcProductItemV2) == true) goto L5;
        QModel r0 = null;
    L7:
        if (((ShopSlcProductItemV2) r0) != null) goto L9;
        return;
    L9:
        final ShopSlcProductItemV2 r9 = (ShopSlcProductItemV2) r8;
        this.l = r9;
        com.bytedance.android.ecom.arch.slice.render.r r2 = this.s;
        if (r2 == null) goto L12;
        r2.b((ShopSlicedProductCardPresenterV2$slcActionHandler$2.a) this.r.getValue());
    L12:
        StringBuilder r3 = new StringBuilder();
        r3.append(ShopSliceUniqueId.SHOP_PRODUCT_CARD.getId());
        r3.append('_');
        if (r9 == null) goto L15;
        String r4 = r9.j;
    L16:
        r3.append(r4);
        r3.append('_');
        r3.append(r9.i);
        String r5 = r3.toString();
        this.m = r5;
        com.bytedance.android.ecom.arch.slice.render.r r6 = this.s;
        if (r6 == null) goto L21;
        SlcTemplateContext r7 = r6.b;
        if (r7 == null) goto L21;
        r7.s(r5, new ShopSlicedProductCardPresenterV2$onBind$$inlined$let$lambda$1(r9, this));
    L21:
        r9.c(this.u.getSliceService().a());
        com.bytedance.android.ecom.arch.slice.render.r r10 = this.s;
        if (r10 == null) goto L24;
        r10.a((Map) r9.w.getValue(), this.m);
    L24:
        a r11 = new a(this);
        this.n = r11;
        com.bytedance.android.ecom.arch.slice.render.r r12 = this.s;
        if (r12 == null) goto L27;
        View r13 = r12.c;
    L28:
        if (r13 == null) goto L38;
        r13.addOnLayoutChangeListener(r11);
        com.bytedance.android.ecom.arch.slice.render.r r14 = this.s;
        if (r14 == null) goto L36;
        SlcTemplateContext r15 = r14.b;
        if (r15 == null) goto L36;
        if (r15.w == null) goto L36;
        View r16 = SlcRenderContext.f(r13, ShopSliceKey.PRODUCT_COVER.getKey());
    L37:
        this.o = r16;
    L39:
        com.bytedance.android.ecom.arch.slice.render.r r17 = this.s;
        if (r17 == null) goto L44;
        View r18 = r17.c;
        if (r18 == null) goto L44;
        SlcRenderContext r19 = r17.b.w;
        String r20 = ShopSliceKey.PRODUCT_COVER.getKey();
        r19.getClass();
        this.o = SlcRenderContext.f(r18, r20);
    L45:
        ShopSlcProductItemV2 r21 = this.l;
        if (r21 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L48:
        if (r21 == null) goto L52;
        com.bytedance.android.ec.store.repository.vo.b r22 = r21.n;
        if (r22 == null) goto L52;
        Boolean r23 = r22.a;
    L54:
        if (Intrinsics.areEqual(r23, Boolean.FALSE) == false) goto L59;
        ShopSlcProductItemV2 r24 = this.l;
        if (r24 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L58:
        Intrinsics.checkNotNull(r24);
        Intrinsics.checkNotNullParameter(r24, "item");
        OneFrameAsyncTask.a(new j0(this, r24));
    L59:
        ShopSlcProductItemV2 r25 = this.l;
        if (r25 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L63:
        if (r25.s == 0) goto L74;
        ECShopHybridProductViewModel r26 = k0();
        if (r26 == null) goto L74;
        Pair[] r27 = new Pair[2];
        r27[0] = TuplesKt.to("module_name", CommentServiceId.HOT_SPOT);
        ShopSlcProductItemV2 r28 = this.l;
        if (r28 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L69:
        if (r28 == null) goto L71;
        r1 = r28.j;
    L71:
        if (r1 != null) goto L73;
        r1 = "";
    L73:
        r27[1] = TuplesKt.to("element_id", r1);
        r26.doEventAction("show_ecom_element", MapsKt.mutableMapOf(r27), new Pair[0]);
    L74:
        if (r13 == null) goto L76;
        r13.setOnClickListener(this);
    L76:
        com.bytedance.android.ec.core.arch.event.c.a(this.u, Reflection.getOrCreateKotlinClass(kj3.a.class), Dispatchers.getMain(), new ShopSlicedProductCardPresenterV2$onBind$2(this));
        return;
    L52:
        r23 = null;
    L44:
        this.o = null;
    L36:
        r16 = null;
        goto L37
    L38:
        this.o = null;
        goto L39
    L27:
        r13 = null;
        goto L28
    L15:
        r4 = null;
        goto L16
    L5:
        r0 = r8;
        goto L7
    }

    public final String j0(ShopSlcProductItemV2 r9) {
        ECShopHybridProductViewModel r0 = k0();
        Boolean r3 = null;
        if (r0 == null) goto L19;
        List<com.bytedance.android.ec.store.repository.dto.g> r1 = r0.getPickTypes();
        if (r1 == null) goto L19;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        Object r4 = r2.next();
        if (((com.bytedance.android.ec.store.repository.dto.g) r4).a() != 1) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L8;
    L16:
        com.bytedance.android.ec.store.repository.dto.g r6 = (com.bytedance.android.ec.store.repository.dto.g) r4;
        if (r6 == null) goto L19;
        Boolean r7 = Boolean.valueOf(r6.b());
    L20:
        ECShopHybridProductViewModel r8 = k0();
        if (r8 == null) goto L38;
        List<com.bytedance.android.ec.store.repository.dto.g> r10 = r8.getPickTypes();
        if (r10 == null) goto L38;
        Iterator<T> r11 = r10.iterator();
    L26:
        if (r11.hasNext() == false) goto L33;
        Object r12 = r11.next();
        if (((com.bytedance.android.ec.store.repository.dto.g) r12).a() != 2) goto L30;
        boolean r13 = true;
    L31:
        if (r13 == false) goto L26;
    L34:
        com.bytedance.android.ec.store.repository.dto.g r14 = (com.bytedance.android.ec.store.repository.dto.g) r12;
        if (r14 == null) goto L38;
        r3 = Boolean.valueOf(r14.b());
        goto L38
    L30:
        r13 = false;
        goto L31
    L33:
        r12 = null;
    L38:
        if (Intrinsics.areEqual(r9.g, "__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == false) goto L41;
        return "cross_recommend_product";
    L41:
        if (Intrinsics.areEqual(r9.g, "__GUESS_LIKE_PRODUCTS_CUR_STORE_SECTION__") == false) goto L43;
        return "102";
    L43:
        Boolean r15 = Boolean.TRUE;
        if (Intrinsics.areEqual(r7, r15) == false) goto L47;
        return "live_product";
    L47:
        if (Intrinsics.areEqual(r3, r15) == false) goto L49;
        return "living_product";
    L49:
        return CommentServiceId.HOT_SPOT;
    L12:
        r5 = false;
        goto L13
    L15:
        r4 = null;
    L19:
        r7 = null;
        goto L20
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r19) {
        ECShopABSettings.k.getClass();
        if (ECShopABSettings.h() == true) goto L5;
    L7:
        ECShopHybridProductViewModel r1 = k0();
        String r3 = null;
        if (r1 == null) goto L29;
        ShopSlcProductItemV2 r6 = this.l;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L12:
        com.bytedance.android.ec.store.setting.f r7 = ECStoreSettings.a();
        if (r7 == null) goto L15;
        boolean r8 = r7.a();
    L16:
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        Intrinsics.checkNotNullParameter(r6, "itemVO");
        if (r8 == true) goto L19;
        dm.a.a("prefetchShopHybridInsertion").i("prefetchShopHybridInsertion disable");
        goto L29
    L19:
        String r9 = r6.j;
        if (r9 != null) goto L22;
    L25:
        boolean r10 = true;
    L26:
        if (r10 == false) goto L28;
        dm.a.a("prefetchShopHybridInsertion").i("prefetchShopHybridInsertion productId is null");
        goto L29
    L28:
        com.bytedance.android.shopping.store.hybridproduct.module.x r11 = new com.bytedance.android.shopping.store.hybridproduct.module.x(r1);
        String r2 = r6.j;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "currentProductId");
        r11.a.prefetchInsertData(r2);
        goto L29
    L22:
        if (r9.length() == 0) goto L25;
        r10 = false;
        goto L26
    L15:
        r8 = false;
    L29:
        BtmSDK r4 = BtmSDK.INSTANCE;
        String r12 = h0();
        PageFinder r13 = PageFinder.via(((QFragmentPresenter) this).e);
        BcmParams r14 = new BcmParams();
        r14.put("bst_group_type", "product");
        Unit r15 = Unit.INSTANCE;
        ShopSlcProductItemV2 r16 = this.l;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L32:
        String r5 = r4.createJumpSourceBtmToken(r12, r13, r14.merge((Map) r16.v.getValue()));
        ECShopHybridProductViewModel r17 = k0();
        if (r17 == null) goto L35;
        ECStoreParam r18 = r17.getStoreParam();
    L36:
        int r20 = ECSdk.a;
        IAdapterService r21 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r21 == null) goto L41;
        wu1.a r22 = r21.getECLiveStateController();
        if (r22 == null) goto L41;
        r22.e();
    L41:
        ECStoreViewModel r23 = this.u;
        if (r23 == null) goto L46;
        im.b r24 = r23.getLiveManager();
        if (r24 == null) goto L46;
        r24.j();
    L46:
        List r25 = com.bytedance.android.ec.store.utils.c.a;
        ShopSlcProductItemV2 r26 = this.l;
        if (r26 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L49:
        if (r26 == null) goto L51;
        String r27 = r26.j;
    L52:
        Intrinsics.checkNotNull(r27);
        com.bytedance.android.ec.store.utils.c.a(r27);
        Set<String> r28 = com.bytedance.android.shopping.store.utils.s.a;
        ShopSlcProductItemV2 r29 = this.l;
        if (r29 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L55:
        ECShopHybridProductViewModel r30 = k0();
        if (r30 == null) goto L58;
        String r31 = r30.getEcomEntranceFrom();
    L59:
        com.bytedance.android.shopping.store.utils.q r32 = e0(r29, r31);
        ShopSlcProductItemV2 r33 = this.l;
        if (r33 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L62:
        JSONObject r110 = com.bytedance.android.shopping.store.utils.s.d(r32, r33.f);
        ECShopHybridProductViewModel r34 = k0();
        if (r34 == null) goto L67;
        ECStoreParam r35 = r34.getStoreParam();
        if (r35 == null) goto L67;
        String r36 = r35.getPageName();
    L69:
        if (Intrinsics.areEqual(r36, "classification_secondary_page") == false) goto L74;
        StringBuilder r37 = new StringBuilder("_");
        ShopSlcProductItemV2 r38 = this.l;
        if (r38 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L73:
        r37.append(r38.h);
        String r39 = r37.toString();
    L75:
        r110.put("tab_label", r39);
        int r40 = com.bytedance.android.ec.store.utils.b.a;
        ShopSlcProductItemV2 r41 = this.l;
        if (r41 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L78:
        if (r41 == null) goto L80;
        String r42 = r41.p;
    L81:
        String r111 = com.bytedance.android.ec.store.utils.b.a(r42, r5);
        if (r111 != null) goto L84;
        return;
    L84:
        hm.b r43 = hm.b.c;
        Context r112 = Y().c();
        if (r18 == null) goto L87;
        Integer r44 = r18.getFollowStatus();
    L88:
        String r113 = String.valueOf(r44);
        ECStoreViewModel r45 = this.u;
        if (r45 == null) goto L99;
        Map<String, Object> r46 = r45.getAdParams();
        if (r46 == null) goto L99;
        ShopSlcProductItemV2 r47 = this.l;
        if (r47 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L95:
        if (r47 == null) goto L97;
        String r48 = r47.j;
    L98:
        Intrinsics.checkNotNull(r48);
        r46.put("product_id", r48);
        Map<String, Object> r114 = r46;
    L100:
        IAdapterService r49 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r49 == null) goto L105;
        wu1.a r50 = r49.getECLiveStateController();
        if (r50 == null) goto L105;
        r50.e();
    L105:
        ShopSlcProductItemV2 r51 = this.l;
        if (r51 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L108:
        com.bytedance.android.ec.store.common.starter.e.b(r43, r112, r111, r113, r110, r114, null, r51.q, 128);
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r52 = com.bytedance.android.shopping.store.lifecycle.a.a;
        ECShopHybridProductViewModel r53 = k0();
        if (r53 == null) goto L113;
        ECStoreParam r54 = r53.getStoreParam();
        if (r54 == null) goto L113;
        Long r55 = Long.valueOf(r54.getLifecycleMonitorId());
    L114:
        com.bytedance.android.shopping.store.lifecycle.m r56 = com.bytedance.android.shopping.store.lifecycle.a.a(r55);
        if (r56 == null) goto L120;
        ShopSlcProductItemV2 r57 = this.l;
        if (r57 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L119:
        com.bytedance.android.shopping.store.lifecycle.c.a.a(r56, "click_product", i0("click_product", r57), null, 4);
    L120:
        ShopSlcProductItemV2 r58 = this.l;
        if (r58 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L123:
        Map<String, String> r59 = i0("click_product", r58);
        if (r59 == null) goto L127;
        Map<String, Object> r60 = MapsKt.plus(MapsKt.plus(r59, this.g), this.h);
        if (r60 == null) goto L127;
    L128:
        ECShopHybridProductViewModel r61 = k0();
        if (r61 == null) goto L134;
        int r62 = com.bytedance.android.ec.store.window.f.a;
        View r63 = a0();
        String r64 = h0();
        ShopSlcProductItemV2 r115 = this.l;
        if (r115 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L133:
        com.bytedance.android.ec.store.window.f.b(r63, r64, r115, r60, r61);
    L134:
        ShopSlcProductItemV2 r65 = this.l;
        if (r65 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L138:
        if (Intrinsics.areEqual(r65.g, "__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == false) goto L142;
        ECShopHybridProductViewModel r66 = k0();
        if (r66 == null) goto L142;
        r66.doAnyEventActionWithBtm(h0(), PageFinder.via(((QFragmentPresenter) this).e), "click_ecom_component", MapsKt.mapOf(new Pair[]{TuplesKt.to("module_name", "cross_recommend_product"), TuplesKt.to("tab_name_second", "cross_recommend_product")}), new Pair[0]);
    L142:
        com.bytedance.android.ec.sdk.helper.c r67 = com.bytedance.android.ec.sdk.helper.c.a;
        StringBuilder r68 = new StringBuilder("[click product]productId:");
        ShopSlcProductItemV2 r69 = this.l;
        if (r69 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L145:
        if (r69 == null) goto L147;
        String r70 = r69.j;
    L148:
        r68.append(r70);
        r67.b("SHOP", r68.toString());
        StringBuilder r71 = new StringBuilder("[click product]secShopId:");
        if (r18 == null) goto L151;
        r3 = r18.getSecShopId();
    L151:
        r71.append(r3);
        r67.b("SHOP", r71.toString());
        return;
    L147:
        r70 = null;
    L127:
        r60 = this.g;
    L113:
        r55 = null;
        goto L114
    L97:
        r48 = null;
    L99:
        r114 = null;
        goto L100
    L87:
        r44 = null;
        goto L88
    L80:
        r42 = null;
        goto L81
    L74:
        r39 = "";
    L67:
        r36 = null;
        goto L69
    L58:
        r31 = null;
        goto L59
    L51:
        r27 = null;
        goto L52
    L35:
        r18 = null;
        goto L36
    L5:
        if (this.u.isChunkMerging() != true) goto L7;
    }

    public final com.bytedance.android.shopping.store.utils.q e0(ShopSlcProductItemV2 r29, String r30) {
        ECShopHybridProductViewModel r0 = k0();
        if (r0 == null) goto L5;
        ECStoreParam r1 = r0.getStoreParam();
    L6:
        if (r1 == null) goto L8;
        ProductBasicRequestParam r2 = r1.getProductBasicRequestParam();
    L10:
        if (r1 == null) goto L12;
        String r5 = r1.getSearchParams();
    L13:
        if (r1 == null) goto L15;
        String r6 = r1.getPreProductId();
    L16:
        if (r1 == null) goto L18;
        String r7 = r1.getPreRoomId();
    L19:
        if (r1 == null) goto L21;
        String r8 = r1.getPreGroupId();
    L23:
        if (r1 != null) goto L25;
    L27:
        boolean r9 = false;
    L28:
        if (r1 == null) goto L30;
        String r10 = r1.getShareContent();
    L31:
        if (r1 == null) goto L33;
        String r11 = r1.getShareObject();
    L34:
        if (r1 == null) goto L36;
        String r12 = r1.getPageName();
    L37:
        if (r1 == null) goto L39;
        String r13 = r1.getEntranceLocation();
    L40:
        if (r1 == null) goto L42;
        Integer r14 = r1.getFollowStatus();
    L43:
        if (r1 == null) goto L45;
        String r15 = r1.getTempId();
    L46:
        if (r1 == null) goto L48;
        String r16 = r1.getStoreSourcePage();
    L49:
        if (r1 == null) goto L51;
        String r17 = r1.getStoreSourceMethod();
    L52:
        if (r1 == null) goto L54;
        String r18 = r1.getStoreGroupType();
    L55:
        if (r1 == null) goto L57;
        String r19 = r1.getLiveAnchorId();
    L58:
        ECShopHybridProductViewModel r20 = k0();
        if (r20 == null) goto L63;
        jm.a<LayoutTypes> r21 = r20.getLayoutType();
        if (r21 == null) goto L63;
        LayoutTypes r22 = (LayoutTypes) r21.getValue();
    L64:
        if (r22 != null) goto L67;
    L68:
        String r3 = "double_product";
    L69:
        String r23 = r3;
        String r24 = j0(r29);
        ECShopHybridProductViewModel r4 = k0();
        if (r4 != null) goto L74;
    L76:
        String r25 = "0";
    L77:
        if (r2 != null) goto L79;
    L81:
        boolean r26 = false;
    L82:
        if (r2 == null) goto L84;
        String r27 = r2.getMaterialId();
    L85:
        if (r1 == null) goto L87;
        String r28 = (String) r1.getPassThroughParam("icon_type");
    L88:
        if (r1 == null) goto L90;
        String r210 = (String) r1.getPassThroughParam("pass_through_api");
    L92:
        return new com.bytedance.android.shopping.store.utils.q(r30, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r23, r24, r25, r26, r27, r28, r210);
    L90:
        r210 = null;
        goto L92
    L87:
        r28 = null;
        goto L88
    L84:
        r27 = null;
        goto L85
    L79:
        if (r2.isCustom() != true) goto L81;
        r26 = true;
        goto L82
    L74:
        if (r4.hasDiscountSelected() != true) goto L76;
        r25 = CommentScene.COMMENTSCENE_NO_AWEME;
        goto L77
    L67:
        if (i0.b[r22.ordinal()] != 1) goto L68;
        r3 = "single_product";
    L63:
        r22 = null;
        goto L64
    L57:
        r19 = null;
        goto L58
    L54:
        r18 = null;
        goto L55
    L51:
        r17 = null;
        goto L52
    L48:
        r16 = null;
        goto L49
    L45:
        r15 = null;
        goto L46
    L42:
        r14 = null;
        goto L43
    L39:
        r13 = null;
        goto L40
    L36:
        r12 = null;
        goto L37
    L33:
        r11 = null;
        goto L34
    L30:
        r10 = null;
        goto L31
    L25:
        if (r1.isEcShare() != true) goto L27;
        r9 = true;
        goto L28
    L21:
        r8 = null;
        goto L23
    L18:
        r7 = null;
        goto L19
    L15:
        r6 = null;
        goto L16
    L12:
        r5 = null;
        goto L13
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final Map<String, String> i0(String r17, ShopSlcProductItemV2 r18) {
        ECShopHybridProductViewModel r3 = k0();
        Map<String, String> r4 = null;
        Integer r5 = null;
        r5 = null;
        r4 = null;
        r4 = null;
        if (r3 == null) goto L5;
        String r6 = r3.getEcomEntranceFrom();
    L6:
        Pair[] r7 = new Pair[2];
        String r8 = String.valueOf(this.u.getShopExtraStatusType());
        String r9 = "";
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        r7[0] = TuplesKt.to("shop_extra_status_type", r8);
        ECShopHybridProductViewModel r10 = k0();
        if (r10 == null) goto L14;
        ECStoreParam r11 = r10.getStoreParam();
        if (r11 == null) goto L14;
        String r12 = r11.getPageName();
    L16:
        if (Intrinsics.areEqual(r12, "classification_secondary_page") == false) goto L18;
        r9 = "_" + r18.h;
    L18:
        r7[1] = TuplesKt.to("tab_label", r9);
        Map<? extends String, ? extends String> r13 = MapsKt.mapOf(r7);
        com.bytedance.android.shopping.store.utils.q r14 = e0(r18, r6);
        int r15 = r17.hashCode();
        if (r15 == 1132134829) goto L40;
        if (r15 == 2022256952) goto L24;
    L44:
        return r4;
    L24:
        if (r17.equals("click_product") == false) goto L44;
        Set<String> r1 = com.bytedance.android.shopping.store.utils.s.a;
        Map<String, String> r2 = r18.f;
        String r16 = h0();
        int r19 = r18.h;
        PageFinder r20 = PageFinder.via(((QFragmentPresenter) this).e);
        ECShopHybridProductViewModel r21 = k0();
        if (r21 == null) goto L30;
        jm.a<Integer> r22 = r21.getProductViewsNum();
        if (r22 == null) goto L30;
        Integer r110 = (Integer) r22.getValue();
    L31:
        ECShopHybridProductViewModel r23 = k0();
        if (r23 == null) goto L36;
        jm.a<Integer> r24 = r23.getTotalProductNum();
        if (r24 == null) goto L36;
        r5 = (Integer) r24.getValue();
    L36:
        r4 = MapsKt.toMutableMap(com.bytedance.android.shopping.store.utils.s.b(r14, r16, r19, r20, r110, r5, Integer.valueOf(r18.i), com.bytedance.android.ec.store.product.presenter.utils.a.c(r18)));
        r4.putAll(r13);
        if (Intrinsics.areEqual(r18.g, "__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == false) goto L44;
        r4.put("module_name", "cross_recommend_product");
    L30:
        r110 = null;
        goto L31
    L40:
        if (r17.equals("show_product") == false) goto L44;
        Set<String> r25 = com.bytedance.android.shopping.store.utils.s.a;
        Map<String, String> r26 = r18.f;
        String r27 = h0();
        int r28 = r18.h;
        PageFinder r29 = PageFinder.via(((QFragmentPresenter) this).e);
        Map r30 = com.bytedance.android.ec.store.product.presenter.utils.a.c(r18);
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r27, "btm");
        Intrinsics.checkNotNullParameter(r29, "pageFinder");
        r4 = MapsKt.toMutableMap(com.bytedance.android.shopping.store.utils.s.a(r30, r14, r27, r28, r29));
        r4.putAll(r13);
        if (Intrinsics.areEqual(r18.g, "__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == false) goto L44;
        r4.put("module_name", "cross_recommend_product");
    L14:
        r12 = null;
        goto L16
    L5:
        r6 = null;
        goto L6
    }

    public ShopSlicedProductCardPresenterV2(final Fragment r2, com.bytedance.android.ecom.arch.slice.render.r r3, LayoutTypes r4, ECStoreViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "layoutTypes");
        Intrinsics.checkNotNullParameter(r5, "storeViewModel");
        super(r2);
        this.s = r3;
        this.t = r4;
        this.u = r5;
        this.f = LazyKt.lazy(new ShopSlicedProductCardPresenterV2$viewModel$2(this, r2));
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.i = new LinkedHashSet();
        this.j = new LinkedHashSet();
        this.k = new ConcurrentHashMap();
        this.m = "";
        this.p = LazyKt.lazy(new ShopSlicedProductCardPresenterV2$productActionHandler$2(this, r2));
        this.q = new ArrayList();
        this.r = LazyKt.lazy(new ShopSlicedProductCardPresenterV2$slcActionHandler$2(this));
    }
}
