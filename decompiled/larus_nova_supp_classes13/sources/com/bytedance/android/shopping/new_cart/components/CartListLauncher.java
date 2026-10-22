package com.bytedance.android.shopping.new_cart.components;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.card_list.components.CardListLoadMoreComponent;
import com.bytedance.android.shopping.card_list.components.CardListQueryFetchComponent;
import com.bytedance.android.shopping.card_list.components.KitCartBackToTopBtnManageComponent;
import com.bytedance.android.shopping.card_list.container.CardListTemplateMgr;
import com.bytedance.android.shopping.card_list.container.init.BaseCartListLauncher;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.new_cart.container.CardListCartCustomWidget;
import com.bytedance.android.shopping.new_cart.container.CardListCartSliceRenderInfoManager;
import com.bytedance.android.shopping.new_cart.container.CartTemplateMgr;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartListLauncher extends BaseCartListLauncher {
    public static final /* synthetic */ int f = 0;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    public static final class Companion {
        public static void a() {
            com.bytedance.android.shopping.card_list.container.init.f.a r0 = com.bytedance.android.shopping.card_list.container.init.f.a;
            LauncherBizType r1 = LauncherBizType.CART;
            CartListLauncher$Companion$register$1 r2 = CartListLauncher$Companion$register$1.INSTANCE;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r2, "lambda");
            com.bytedance.android.shopping.card_list.container.init.c.a.put(r1, r2);
        }
    }

    static {
    }

    public CartListLauncher() {
        this.b = LazyKt.lazy(CartListLauncher$textPoolSize$2.INSTANCE);
        this.c = LazyKt.lazy(CartListLauncher$imagePoolSize$2.INSTANCE);
        this.d = LazyKt.lazy(CartListLauncher$viewPoolSize$2.INSTANCE);
        this.e = LazyKt.lazy(CartListLauncher$templateList$2.INSTANCE);
    }

    public static Map e(CardListObjectContainer r11) {
        Pair[] r0 = new Pair[9];
        com.bytedance.android.shopping.card_list.common_params.a r1 = r11.e;
        Intrinsics.checkNotNullParameter(r1, "$this$formatSelectedCartIds");
        r0[0] = TuplesKt.to("selected_cart_ids", CollectionsKt.joinToString$default(r1.e, ",", null, null, 0, null, null, 62, null));
        com.bytedance.android.shopping.card_list.common_params.a r2 = r11.e;
        Intrinsics.checkNotNullParameter(r2, "$this$formatSelectedShopIds");
        r0[1] = TuplesKt.to("selected_shop_ids", CollectionsKt.joinToString$default(r2.f, ",", null, null, 0, null, null, 62, null));
        r0[2] = TuplesKt.to("source_type", "104");
        r0[3] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r11.f.getPageName());
        r0[4] = TuplesKt.to("page_type", "YATA_Android");
        CardPassThroughData r3 = r11.e.a;
        String r4 = null;
        if (r3 == null) goto L7;
        CartPassThroughData r5 = r3.getCartSchemaData();
        if (r5 == null) goto L7;
        String r6 = r5.getTransparentParams();
    L8:
        r0[5] = TuplesKt.to("transparent_params", r6);
        r0[6] = TuplesKt.to("session_id", r11.e.i);
        r0[7] = TuplesKt.to("current_cart_height_percent", String.valueOf(r11.e.n));
        int r7 = com.bytedance.android.shopping.card_list.utils.h.a;
        CardPassThroughData r8 = r11.e.a;
        if (r8 == null) goto L11;
        r4 = r8.getSplitActivityScene();
    L11:
        r0[8] = TuplesKt.to("is_in_split_mode", String.valueOf(com.bytedance.android.shopping.card_list.utils.h.a(r4)));
        Map r9 = MapsKt.mutableMapOf(r0);
        Iterator r12 = ((LinkedHashMap) r11.e.b).entrySet().iterator();
    L13:
        if (r12.hasNext() == false) goto L17;
        Map.Entry r10 = (Map.Entry) r12.next();
        if (r10.getValue() == null) goto L13;
        r9.put(r10.getKey(), r10.getValue());
        goto L13
    L17:
        return r9;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.f
    public final void d(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        CardListTemplateMgr.INSTANCE.preload(r5, CartTemplateMgr.CHANNEL, "yata_cart", (Map) this.e.getValue());
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.BaseCartListLauncher, com.bytedance.android.shopping.card_list.container.init.f
    public final void a(final CardListObjectContainer r4, final View r5) {
        Intrinsics.checkNotNullParameter(r4, "objectContainer");
        Intrinsics.checkNotNullParameter(r5, "rootContainerView");
        super.a(r4, r5);
        r4.e(Reflection.getOrCreateKotlinClass(CardListQueryFetchComponent.class), Boolean.TRUE, new CartListLauncher$onLaunch$$inlined$apply$lambda$1(r4, this, r4, r5));
        KClass<? extends com.bytedance.android.shopping.card_list.components.a> r0 = Reflection.getOrCreateKotlinClass(KitCartBackToTopBtnManageComponent.class);
        Function0<KitCartBackToTopBtnManageComponent> r1 = new CartListLauncher$onLaunch$$inlined$apply$lambda$2(r4, this, r4, r5);
        Boolean r2 = Boolean.FALSE;
        r4.e(r0, r2, r1);
        r4.e(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.card_list.components.k.class), r2, new CartListLauncher$onLaunch$$inlined$apply$lambda$3(r4, this, r4, r5));
        r4.e(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.card_list.components.f.class), r2, new CartListLauncher$onLaunch$$inlined$apply$lambda$4(r4, this, r4, r5));
        r4.e(Reflection.getOrCreateKotlinClass(CardListLoadMoreComponent.class), r2, new CartListLauncher$onLaunch$1$5(r4));
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.BaseCartListLauncher, com.bytedance.android.shopping.card_list.container.init.f
    public final void b(CardPassThroughData r9, Function3<? super String, ? super String, ? super Map<String, String>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "passThroughData");
        Intrinsics.checkNotNullParameter(r10, "cb");
        CartPassThroughData r0 = r9.getCartSchemaData();
        IntRange r1 = new IntRange(1, 99);
        Integer r3 = null;
        if (r0 == null) goto L5;
        Integer r4 = Integer.valueOf(r0.getHeightPercent());
    L7:
        if (r4 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L15;
        if (r0 == null) goto L17;
        int r5 = r0.getHeightPercent();
    L16:
        r3 = Integer.valueOf(r5);
    L17:
        Pair[] r6 = new Pair[11];
        String r7 = "";
        if (r0 == null) goto L21;
        String r8 = r0.getCartIds();
        if (r8 == null) goto L21;
    L22:
        r6[0] = TuplesKt.to("selected_cart_ids", r8);
        if (r0 == null) goto L26;
        String r11 = r0.getShopIds();
        if (r11 == null) goto L26;
    L27:
        r6[1] = TuplesKt.to("selected_shop_ids", r11);
        r6[2] = TuplesKt.to("source_type", "104");
        r6[3] = TuplesKt.to("query_scene", "first_enter");
        r6[4] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_cart_page");
        String r12 = r9.getSessionId();
        if (r12 != null) goto L30;
        r12 = "";
    L30:
        r6[5] = TuplesKt.to("session_id", r12);
        r6[6] = TuplesKt.to("page_type", "YATA_Android");
        if (r0 == null) goto L34;
        String r13 = r0.getAnchorCartId();
        if (r13 == null) goto L34;
    L35:
        r6[7] = TuplesKt.to("anchor_cart_id", r13);
        if (r0 == null) goto L41;
        String r14 = r0.getTransparentParams();
        if (r14 == null) goto L41;
        r7 = r14;
    L41:
        r6[8] = TuplesKt.to("transparent_params", r7);
        r6[9] = TuplesKt.to("current_cart_height_percent", String.valueOf(r3));
        int r15 = com.bytedance.android.shopping.card_list.utils.h.a;
        r6[10] = TuplesKt.to("is_in_split_mode", String.valueOf(com.bytedance.android.shopping.card_list.utils.h.a(r9.getSplitActivityScene())));
        r10.invoke("cart/yata/query", OrderCommonApi.API_HOST, MapsKt.mapOf(r6));
        return;
    L34:
        r13 = "";
    L26:
        r11 = "";
    L21:
        r8 = "";
        goto L22
    L15:
        r5 = 100;
        goto L16
    L9:
        if (r1.contains(r4.intValue()) == false) goto L11;
        r2 = true;
        goto L12
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.BaseCartListLauncher, com.bytedance.android.shopping.card_list.container.init.f
    public final void c(CardListObjectContainer r12, com.bytedance.android.shopping.card_list.container.init.f.b r13, com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r14, Function2<? super com.bytedance.android.shopping.card_list.container.init.f.b, ? super com.bytedance.kmp.ec.yata.view.render.delegate.v2.a, Unit> r15) {
        Intrinsics.checkNotNullParameter(r12, "objectContainer");
        Intrinsics.checkNotNullParameter(r13, "sdkParams");
        Intrinsics.checkNotNullParameter(r15, "cb");
        AtomicBoolean r16 = CardListCartCustomWidget.a;
        CardListCartCustomWidget.a(((Number) this.b.getValue()).intValue(), ((Number) this.c.getValue()).intValue(), ((Number) this.d.getValue()).intValue());
        String r17 = null;
        if (r12.getContext() == null) goto L50;
        CardListCartSliceRenderInfoManager r18 = new CardListCartSliceRenderInfoManager();
        CardPassThroughData r3 = r12.e.a;
        if (r3 == null) goto L7;
        String r4 = r3.getSplitActivityScene();
    L8:
        Context r5 = r12.getContext();
        if (r5 == null) goto L50;
        int r6 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.e;
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r7 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.a.a(r5, "yata_cart");
        SlcRenderContext r8 = r7.b;
        if (r8 == null) goto L27;
        Boolean r9 = Boolean.valueOf(com.bytedance.android.shopping.card_list.utils.h.a(r4));
        com.bytedance.android.ecom.arch.slice.render.context.b.a r10 = com.bytedance.android.ecom.arch.slice.render.context.b.f;
        ECAppInfoService r11 = ECAppInfoService.e;
        Float r19 = r11.getCurrentFontScale();
        float r110 = 1.0f;
        if (r19 == null) goto L15;
        float r20 = r19.floatValue();
    L16:
        Float r21 = r11.getCurrentFontScale();
        if (r21 == null) goto L20;
        r110 = r21.floatValue();
    L20:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L25;
        nj.d r22 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r22 == null) goto L24;
        r22.getSpiltWidth();
        int r23 = 0;
    L26:
        r10.getClass();
        r8.f = com.bytedance.android.ecom.arch.slice.render.context.b.a.b(375.0f, r110, r20, r23);
        goto L27
    L24:
        r23 = 360;
        goto L26
    L25:
        r23 = -1;
        goto L26
    L15:
        r20 = 1.0f;
    L27:
        if (r8 == null) goto L29;
        r8.c0 = new eb3.a();
    L29:
        if (r8 == null) goto L31;
        r8.g = ECSettingKeys.p().k();
    L31:
        if (r8 == null) goto L33;
        r8.y = ECSettingKeys.p().j();
    L33:
        if (r8 == null) goto L35;
        r8.j = ECSettingKeys.p().f();
    L35:
        if (r8 == null) goto L37;
        r8.k = ECSettingKeys.p().e();
    L37:
        ECSettingKeys.j.getClass();
        if (ECSettingKeys.h().b() == true) goto L42;
        if (r8 == null) goto L42;
        r8.v = 0;
    L42:
        if (ECSettingKeys.h().e() == false) goto L45;
        if (r8 == null) goto L45;
        r8.o = new com.bytedance.android.shopping.new_cart.container.a(r18);
    L45:
        Float r111 = ECAppInfoService.e.getCurrentFontScale();
        if (r8 == null) goto L48;
        r8.p(MapsKt.mapOf(TuplesKt.to("large_font_scale", r111)));
    L48:
        if (r8 == null) goto L51;
        r8.p(MapsKt.mapOf(new Pair[]{TuplesKt.to("large_font_scale", r111), TuplesKt.to("split_mode_scene", r4)}));
    L51:
        Lazy r112 = ECAppInfoService.a;
        if (ECAppInfoService.m() == false) goto L61;
        CardPassThroughData r113 = r12.e.a;
        if (r113 == null) goto L59;
        CartPassThroughData r114 = r113.getCartSchemaData();
        if (r114 == null) goto L59;
        r17 = r114.getNewSourceType();
    L59:
        if (Intrinsics.areEqual(r17, "homepage_bottom_tab") == false) goto L61;
        String r115 = "a1.b98956";
    L62:
        Map r24 = (Map) this.e.getValue();
        Map r116 = MapsKt.mapOf(new Pair[]{TuplesKt.to("net_host", OrderCommonApi.API_HOST), TuplesKt.to("update_api", "cart/yata/update"), TuplesKt.to("extra_map", e(r12))});
        Intrinsics.checkNotNullParameter("yata_cart", "bizCode");
        Intrinsics.checkNotNullParameter(CartTemplateMgr.CHANNEL, "sliceTemplateChannel");
        Intrinsics.checkNotNullParameter(r116, "abilityParams");
        super.c(r12, new com.bytedance.android.shopping.card_list.container.init.f.b(r115, "yata_cart", CartTemplateMgr.CHANNEL, r24, r116), r7, r15);
        return;
    L61:
        r115 = "a1.b4001";
        goto L62
    L7:
        r4 = null;
    L50:
        r7 = null;
        goto L51
    }
}
