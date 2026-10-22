package com.bytedance.android.shopping.buynow.eventcenter;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.CarModelSelectInfo;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.shopping.anchorv4.event.c;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.controller.CheckPayStatusController;
import com.bytedance.android.shopping.buynow.eventcenter.handle.SelfJsBridgeFunction;
import com.bytedance.android.shopping.buynow.eventcenter.handle.SelfScrollToBottomFunction;
import com.bytedance.android.shopping.buynow.eventcenter.handle.d0;
import com.bytedance.android.shopping.buynow.eventcenter.handle.e0;
import com.bytedance.android.shopping.buynow.eventcenter.handle.f;
import com.bytedance.android.shopping.buynow.eventcenter.handle.f0;
import com.bytedance.android.shopping.buynow.eventcenter.handle.g0;
import com.bytedance.android.shopping.buynow.eventcenter.handle.q;
import com.bytedance.android.shopping.buynow.eventcenter.handle.r;
import com.bytedance.android.shopping.buynow.eventcenter.handle.s;
import com.bytedance.android.shopping.buynow.eventcenter.handle.t;
import com.bytedance.android.shopping.buynow.eventcenter.handle.u;
import com.bytedance.android.shopping.buynow.eventcenter.handle.v;
import com.bytedance.android.shopping.buynow.eventcenter.handle.w;
import com.bytedance.android.shopping.buynow.eventcenter.handle.x;
import com.bytedance.android.shopping.buynow.eventcenter.handle.y;
import com.bytedance.android.shopping.buynow.eventcenter.handle.z;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.sku.common.controller.SkuHandleEventOpportunity;
import com.bytedance.android.shopping.yata.business.function.d;
import com.bytedance.android.shopping.yata.business.function.e;
import com.bytedance.android.shopping.yata.business.function.g;
import com.bytedance.android.shopping.yata.business.function.h;
import com.bytedance.android.shopping.yata.business.function.i;
import com.bytedance.android.shopping.yata.business.function.k;
import com.bytedance.android.shopping.yata.business.function.l;
import com.bytedance.android.shopping.yata.business.function.m;
import com.bytedance.android.shopping.yata.business.function.n;
import com.bytedance.android.shopping.yata.business.function.o;
import com.bytedance.android.shopping.yata.business.function.p;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final Map<String, j> a;
    public final Activity b;
    public final BuyNowFragment c;
    public final RecyclerView d;
    public final LinearLayout e;
    public final BuyNowViewModel f;
    public final AndroidYaTaInstance g;
    public final CheckPayStatusController h;
    public final pa3.a i;
    public final Map<String, RecyclerView> j;
    public final Context k;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.buynow.eventcenter.a$a, reason: collision with other inner class name */
    public static final class C0027a implements com.bytedance.android.shopping.sku.common.jsb.a {
        public final /* synthetic */ a a;

        @Override // com.bytedance.android.shopping.sku.common.jsb.a
        public final void b(String r1) {
        }

        @Override // com.bytedance.android.shopping.sku.common.jsb.a
        public final void c(ProductSelectPoiInfo r1) {
        }

        @Override // com.bytedance.android.shopping.sku.common.jsb.a
        public final void d() {
            this.a.f.getSkuService().v(SkuHandleEventOpportunity.CLOTHES_SIZE_ASSISTANT, null);
        }

        public C0027a(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.sku.common.jsb.a
        public final void a(CarModelSelectInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "carInfo");
            Intrinsics.checkNotNullParameter(r2, "carInfo");
        }

        @Override // com.bytedance.android.shopping.sku.common.jsb.a
        public final void e(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r2, "params");
        }

        @Override // com.bytedance.android.shopping.sku.common.jsb.a
        public final void f(com.bytedance.android.shopping.sku.common.jsb.b r2) {
            Intrinsics.checkNotNullParameter(r2, "nextPageEventData");
            Intrinsics.checkNotNullParameter(r2, "nextPageEventData");
        }

        @Override // com.bytedance.android.shopping.sku.common.jsb.a
        public final void g(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r2, "params");
        }
    }

    public final void a() {
        s0.c(this);
        boolean r2 = false;
        Iterator r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to("ecom.continue.check.jump", new BuyNowEventCenter$registerJsEvents$eventMap$1(this)), TuplesKt.to("ecom.continue_pay.dismiss", new BuyNowEventCenter$registerJsEvents$eventMap$2(this)), TuplesKt.to("buynow_trade_event", new BuyNowEventCenter$registerJsEvents$eventMap$3(this)), TuplesKt.to("buynow_trade_event_async", new BuyNowEventCenter$registerJsEvents$eventMap$4(this)), TuplesKt.to("buynow_trade_track_proxy", new BuyNowEventCenter$registerJsEvents$eventMap$5(this)), TuplesKt.to("H5_visibilityChange", new BuyNowEventCenter$registerJsEvents$eventMap$6(this))}).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        c r4 = new c((String) r1.getKey(), (Function1) r1.getValue());
        b r3 = new b(r4);
        ((HashMap) this.a).put(r4.a, r3);
        ECLiveHybridUtil.m(r4.a, r3);
        goto L4
    L6:
        AndroidYaTaInstance r9 = this.g;
        String r5 = null;
        if (r9 == null) goto L9;
        Activity r6 = this.b;
        BuyNowFragment r10 = this.c;
        com.bytedance.android.shopping.buynow.yata.abilities.a r7 = new com.bytedance.android.shopping.buynow.yata.abilities.a(r6, r10, this.f, r9, r10);
    L10:
        com.bytedance.android.shopping.buynow.viewmodel.a r8 = this.f.getStaticState();
        int r11 = ja3.a.a;
        Intrinsics.checkNotNullParameter(r8, "staticState");
        nl.c r12 = r8.a;
        if (r12 == null) goto L14;
        r5 = r12.getQueryParam("use_new_self_event");
    L14:
        if (Intrinsics.areEqual(r5, "1") == false) goto L17;
    L20:
        r2 = true;
    L22:
        if (r2 == false) goto L27;
        AndroidYaTaInstance r13 = this.g;
        if (r13 == null) goto L54;
        if (r7 == null) goto L54;
        int r14 = jl3.a.a;
        Intrinsics.checkNotNullParameter(r13, "yataInstance");
        Intrinsics.checkNotNullParameter(r7, "abilities");
        r13.B("selfDelay", new com.bytedance.android.shopping.yata.business.function.c(r7));
        r13.B("selfLoading", new d(r7));
        r13.B("selfQuitPage", new h(r7));
        r13.B("selfScrollItemToPosition", new l(r7));
        r13.B("selfScrollToPosition", new n(r7));
        r13.B("selfOpenDialog", new g(r7));
        r13.B("selfCloseDialog", new com.bytedance.android.shopping.yata.business.function.a(r7));
        r13.B("selfRegexCheck", new com.bytedance.android.shopping.yata.business.function.j(r7));
        r13.B("selfMultiRegexCheck", new e(r7));
        r13.B("selfSendEvent", new o(r7));
        r13.B("selfReadFieldAndTrigger", new i(r7));
        r13.B("selfTTPay", new p(r7));
    L54:
        AndroidYaTaInstance r15 = this.g;
        if (r15 == null) goto L57;
        r15.B("selfScrollToBottom", new SelfScrollToBottomFunction(this.f, this.j, this.d));
    L57:
        AndroidYaTaInstance r16 = this.g;
        if (r16 == null) goto L60;
        r16.B("selfScrollItemToCenter", new x(this.f));
    L60:
        AndroidYaTaInstance r17 = this.g;
        if (r17 == null) goto L63;
        r17.B("selfSubmit", new z(this.b, this.g, this.h.g, this.c, this.f, this.i));
    L63:
        AndroidYaTaInstance r18 = this.g;
        if (r18 == null) goto L66;
        r18.B("selfPayAndCheck", new q(this.f, this.b, this.h, this.i));
    L66:
        AndroidYaTaInstance r19 = this.g;
        if (r19 == null) goto L69;
        r19.B("selfCheckPayStatus", new com.bytedance.android.shopping.buynow.eventcenter.handle.d(this.f, this.b, this.h));
    L69:
        AndroidYaTaInstance r20 = this.g;
        if (r20 == null) goto L72;
        r20.B("selfJSBridge", new SelfJsBridgeFunction(this.b, this.f));
    L72:
        AndroidYaTaInstance r21 = this.g;
        if (r21 == null) goto L75;
        r21.B("selfValidate", new g0(this.g, this.f));
    L75:
        AndroidYaTaInstance r22 = this.g;
        if (r22 == null) goto L78;
        r22.B("selfSubmitBtnClick", new y(this.i));
    L78:
        AndroidYaTaInstance r23 = this.g;
        if (r23 == null) goto L81;
        r23.B("selfTracker", new f0(this.f));
    L81:
        AndroidYaTaInstance r24 = this.g;
        if (r24 == null) goto L84;
        r24.B("selfToggleSubmit", new e0(this.g, this.f));
    L84:
        AndroidYaTaInstance r25 = this.g;
        if (r25 == null) goto L87;
        r25.B("selfDouyinVerify", new com.bytedance.android.shopping.buynow.eventcenter.handle.i(this.b));
    L87:
        AndroidYaTaInstance r26 = this.g;
        if (r26 == null) goto L90;
        r26.B("selfFaceAuth", new com.bytedance.android.shopping.buynow.eventcenter.handle.j(this.b));
    L90:
        AndroidYaTaInstance r27 = this.g;
        if (r27 == null) goto L93;
        r27.B("selfPublishEvent", new r(this.f));
    L93:
        AndroidYaTaInstance r28 = this.g;
        if (r28 == null) goto L96;
        r28.B("selfOpenSchema", new com.bytedance.android.shopping.buynow.eventcenter.handle.p(this.b, this.f, this.c));
    L96:
        AndroidYaTaInstance r29 = this.g;
        if (r29 == null) goto L99;
        r29.B("selfSaveRenderNode", new w(this.f));
    L99:
        AndroidYaTaInstance r30 = this.g;
        if (r30 == null) goto L102;
        r30.B("selfAppletBack", new com.bytedance.android.shopping.buynow.eventcenter.handle.c());
    L102:
        AndroidYaTaInstance r31 = this.g;
        if (r31 == null) goto L105;
        r31.B("selfOpenMore", new com.bytedance.android.shopping.buynow.eventcenter.handle.o(this.k));
    L105:
        AndroidYaTaInstance r32 = this.g;
        if (r32 == null) goto L108;
        r32.B("selfQuitApplet", new s());
    L108:
        if (r7 == null) goto L121;
        AndroidYaTaInstance r33 = this.g;
        if (r33 == null) goto L112;
        r33.B("selfTransformLocation", new com.bytedance.android.shopping.yata.business.function.q(r7));
    L112:
        AndroidYaTaInstance r34 = this.g;
        if (r34 == null) goto L115;
        r34.B("selfScrollComponentToPosition", new k(r7));
    L115:
        AndroidYaTaInstance r35 = this.g;
        if (r35 == null) goto L118;
        r35.B("selfCrossTrigger", new com.bytedance.android.shopping.yata.business.function.b(r7));
    L118:
        AndroidYaTaInstance r36 = this.g;
        if (r36 == null) goto L121;
        r36.B("selfScrollOverKeyboard", new m(r7));
    L121:
        AndroidYaTaInstance r37 = this.g;
        if (r37 == null) goto L124;
        r37.B("selfOpenMaskLayer", new com.bytedance.android.shopping.buynow.eventcenter.handle.n(this.c.v));
    L124:
        AndroidYaTaInstance r38 = this.g;
        if (r38 == null) goto L127;
        r38.B("selfCloseMaskLayer", new f(this.c.v));
    L127:
        AndroidYaTaInstance r39 = this.g;
        if (r39 == null) goto L130;
        r39.B("selfCalCurSkuIdToUpdate", new com.bytedance.android.shopping.buynow.ultimate.func.b(this.f, this.c));
        r39.B("selfChangeBuyNum", new com.bytedance.android.shopping.buynow.ultimate.func.c(this.f, this.c));
        r39.B("selfOpenCoupon", new com.bytedance.android.shopping.buynow.ultimate.func.g(this.c));
        r39.B("selfOpenDetail", new com.bytedance.android.shopping.buynow.ultimate.func.h(this.c));
        r39.B("selfOpenSkuSchema", new com.bytedance.android.shopping.buynow.ultimate.func.i(this.c));
        r39.B("selfPreviewImg", new com.bytedance.android.shopping.buynow.ultimate.func.j(this.c, this.g));
        r39.B("selfToast", new com.bytedance.android.shopping.buynow.ultimate.func.n(this.f));
        r39.B("selfAddCurVersion", new com.bytedance.android.shopping.buynow.ultimate.func.a(this.f));
        r39.B("selfHandleEventWhenAppear", new com.bytedance.android.shopping.buynow.ultimate.func.f(this.f));
        r39.B("selfUpdateStatusInfo", new com.bytedance.android.shopping.buynow.ultimate.func.q(this.c));
        r39.B("selfUpdateSkipTriggers", new com.bytedance.android.shopping.buynow.ultimate.func.p(this.f));
        r39.B("selfUpdateCommonEventParams", new com.bytedance.android.shopping.buynow.ultimate.func.o(this.f));
        r39.B("selfSaveSpecShowMode", new com.bytedance.android.shopping.buynow.ultimate.func.l(this.c));
        r39.B("selfScrollToView", new com.bytedance.android.shopping.buynow.ultimate.func.m(this.c));
        r39.B("selfDoNothing", new com.bytedance.android.shopping.buynow.ultimate.func.d());
        r39.B("selfExposePayCashierBar", new com.bytedance.android.shopping.buynow.ultimate.func.e(this.c, this.g, this.e));
        r39.B("selfSaveBizFields", new com.bytedance.android.shopping.buynow.ultimate.func.k(this.c));
    L130:
        this.f.getSkuService().w(this.c, new C0027a(this));
        return;
    L27:
        AndroidYaTaInstance r40 = this.g;
        if (r40 == null) goto L30;
        r40.B("selfDelay", new com.bytedance.android.shopping.buynow.eventcenter.handle.g(this.h.h, this.f));
    L30:
        AndroidYaTaInstance r41 = this.g;
        if (r41 == null) goto L33;
        r41.B("selfLoading", new com.bytedance.android.shopping.buynow.eventcenter.handle.k(this.h.g));
    L33:
        AndroidYaTaInstance r42 = this.g;
        if (r42 == null) goto L36;
        r42.B("selfQuitPage", new t(this.c));
    L36:
        AndroidYaTaInstance r43 = this.g;
        if (r43 == null) goto L39;
        r43.B("selfOpenDialog", new com.bytedance.android.shopping.buynow.eventcenter.handle.m(this.c.s));
    L39:
        AndroidYaTaInstance r44 = this.g;
        if (r44 == null) goto L42;
        r44.B("selfCloseDialog", new com.bytedance.android.shopping.buynow.eventcenter.handle.e(this.c.s));
    L42:
        AndroidYaTaInstance r45 = this.g;
        if (r45 == null) goto L45;
        r45.B("selfRegexCheck", new v(this.g, this.f));
    L45:
        AndroidYaTaInstance r46 = this.g;
        if (r46 == null) goto L48;
        r46.B("selfMultiRegexCheck", new com.bytedance.android.shopping.buynow.eventcenter.handle.l(this.g, this.f));
    L48:
        AndroidYaTaInstance r47 = this.g;
        if (r47 == null) goto L51;
        r47.B("selfTTPay", new d0(this.b, this.f));
    L51:
        AndroidYaTaInstance r48 = this.g;
        if (r48 == null) goto L54;
        r48.B("selfReadFieldAndTrigger", new u(this.g, this.f));
        goto L54
    L17:
        if (r8.c() == false) goto L22;
        if (ECSettingKeys.k() != 1) goto L22;
    L9:
        r7 = null;
        goto L10
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceiveTopFragmentStatusChanged(hl.w r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        throw null;
    }

    public a(FragmentActivity r2, BuyNowFragment r3, RecyclerView r4, LinearLayout r5, BuyNowViewModel r6, AndroidYaTaInstance r7, CheckPayStatusController r8, pa3.a r9, Map r10, Context r11) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "bodyContainer");
        Intrinsics.checkNotNullParameter(r5, "footerContainer");
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        Intrinsics.checkNotNullParameter(r8, "checkPayStatusController");
        Intrinsics.checkNotNullParameter(r10, "popupBodyMap");
        Intrinsics.checkNotNullParameter(r11, "context");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.a = new HashMap(2);
        new HashMap(2);
    }
}
