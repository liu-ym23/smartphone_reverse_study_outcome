package com.bytedance.android.shopping.buynow.yata.abilities;

import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.data.model.PopupCode;
import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowTracker$onPopupShow$1;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import com.bytedance.kmp.ec.yata.store.core.YataStoreData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import ma3.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowYataPageCallbackImpl implements v96.f.a, com.bytedance.kmp.ec.yata.common.biz.callback.f, com.bytedance.kmp.ec.yata.common.biz.callback.c, com.bytedance.kmp.ec.yata.common.biz.callback.d {
    public final BuyNowFragment a;
    public final Lazy b;
    public final BuyNowFragment c;
    public final BuyNowViewModel d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        k r0 = (k) this.b.getValue();
        if (r0.b.get() == false) goto L6;
        return;
    L6:
        if (r0.e.getStaticState().c() == false) goto L22;
        Map<String, pa3.a> r1 = pa3.a.c;
        pa3.a r2 = pa3.a.C0222a.a(r0.e.getStaticState().b);
        if (r2 == null) goto L16;
        BuyNowFirstScreenMonitor r3 = r2.a;
        if (r3 == null) goto L16;
        ConcurrentHashMap<String, Long> r4 = r3.c;
        if (r4 == null) goto L16;
        if (r4.containsKey(BuyNowFirstScreenNode.RENDER_START.getValue()) != true) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == true) goto L22;
        if (r0.c.compareAndSet(false, true) == false) goto L25;
        pa3.a r6 = pa3.a.C0222a.a(r0.e.getStaticState().b);
        b r7 = new b(r0.a, new h(r6));
        Choreographer.getInstance().postFrameCallback(new j(r0, r7));
        return;
    L25:
        return;
    L16:
        r5 = false;
    L22:
        if (r0.b.compareAndSet(false, true) == false) goto L27;
        Map<String, pa3.a> r8 = pa3.a.c;
        pa3.a r9 = pa3.a.C0222a.a(r0.e.getStaticState().b);
        b r10 = new b(r0.a, new i(r0, r9));
        Choreographer.getInstance().postFrameCallback(new j(r0, r10));
        return;
    }

    public final void b(com.bytedance.kmp.ec.yata.common.biz.callback.i r2) {
        Intrinsics.checkNotNullParameter(r2, "requestModel");
        Intrinsics.checkNotNullParameter(r2, "requestModel");
    }

    public final void c(YataStoreData r2) {
        Intrinsics.checkNotNullParameter(r2, "storeData");
        final aa6.a r3 = r2.c;
        com.bytedance.android.shopping.buynow.utils.i.a r0 = com.bytedance.android.shopping.buynow.utils.i.a;
        com.bytedance.android.shopping.buynow.utils.i.a(new BuyNowYataPageCallbackImpl$onProtocolDispatchEnd$1(this, r3));
    }

    public final void e(final com.bytedance.kmp.ec.yata.common.biz.callback.a r3) {
        final aa6.a.b.b r0 = aa6.a.b.b.b;
        Intrinsics.checkNotNullParameter(r0, "source");
        Intrinsics.checkNotNullParameter(r3, "model");
        com.bytedance.android.shopping.buynow.utils.i.a r1 = com.bytedance.android.shopping.buynow.utils.i.a;
        com.bytedance.android.shopping.buynow.utils.i.a(new BuyNowYataPageCallbackImpl$onFetchBegin$1(this, r0, r3));
    }

    @Deprecated(message = "老版的临时过渡的接口方法，SDK不再深度维护，最好不要使用")
    public final void l(com.bytedance.kmp.ec.yata.store.node.c r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r2, "node");
    }

    public final void n(com.bytedance.kmp.ec.yata.common.protocol.data.e r8) {
        nl.c r0 = this.d.getStaticState().a;
        if (r0 == null) goto L5;
        nl.b r1 = r0.getCacheKey();
    L6:
        String r9 = u0.d(r8);
        int r6 = r9.length();
        com.bytedance.kmp.ec.yata.common.protocol.data.e r10 = (com.bytedance.kmp.ec.yata.common.protocol.data.e) u0.b(r9, com.bytedance.kmp.ec.yata.common.protocol.data.e.class);
        if (r10 == null) goto L10;
        ma3.b r2 = ma3.c.a(r10);
        Map<String, UltimateBuyCacheQueryHelper> r11 = UltimateBuyCacheHelper.b;
        UltimateBuyCacheHelper.f(r1, new q(r2, com.bytedance.kmp.ec.yata.common.protocol.data.f.b(r2), SystemClock.elapsedRealtime(), r6), false, true, 4);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public BuyNowYataPageCallbackImpl(BuyNowFragment r2, BuyNowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.c = r2;
        this.d = r3;
        this.a = r2;
        this.b = LazyKt.lazy(new BuyNowYataPageCallbackImpl$viewHolderCallback$2(this));
    }

    public final void f(YataStoreData r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "storeData");
        final aa6.a r3 = r1.c;
        com.bytedance.android.shopping.buynow.utils.i.a r4 = com.bytedance.android.shopping.buynow.utils.i.a;
        com.bytedance.android.shopping.buynow.utils.i.a(new BuyNowYataPageCallbackImpl$onProtocolReloadEnd$1(this, r3));
    }

    public final void g(com.bytedance.kmp.ec.yata.store.node.c r7, ga6.c r8) {
        Intrinsics.checkNotNullParameter(r7, "root");
        Intrinsics.checkNotNullParameter(r8, "config");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.e(r7, r8);
        String r9 = r8.a();
        if (r9 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
        return;
    L11:
        AndroidYaTaInstance r11 = this.d.getYataInstance();
        Object r0 = "";
        Integer r1 = null;
        if (r11 == null) goto L17;
        String r2 = r8.a();
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        com.bytedance.kmp.ec.yata.store.node.c r12 = r11.o(r2);
    L18:
        if (r12 == null) goto L30;
        com.bytedance.kmp.ec.yata.store.node.e r13 = r12.b;
        if (r13 == null) goto L30;
        p r14 = r13.b;
        if (r14 == null) goto L30;
        Map r15 = r14.h();
        if (r15 == null) goto L30;
        Object r16 = r15.get("popup_code");
        if (r16 == null) goto L30;
        r0 = r16;
    L30:
        if (Intrinsics.areEqual(r0, PopupCode.PRICE_DETAIL_CARD_POPUP) == false) goto L51;
        int r3 = ((Number) r8.b("height", -1)).intValue();
        if (r3 <= 0) goto L52;
        BuyNowFragment r4 = this.a;
        if ((r4 instanceof BuyNowFragment) == true) goto L37;
        r4 = null;
    L37:
        if (r4 != null) goto L50;
        int r17 = com.bytedance.android.shopping.extensions.b.b(64);
    L48:
        r8.c("height", Integer.valueOf(r3 - r17));
        r8.c("bottom_offset", Integer.valueOf(r17));
        return;
    L50:
        LinearLayout r5 = (LinearLayout) r4.S90(2131373142);     // Catch: Throwable -> L46
        View r18 = r5.getChildAt(r5.getChildCount() - 1);     // Catch: Throwable -> L46
        if (r18 == null) goto L42;
        r1 = Integer.valueOf(r18.getMeasuredHeight());     // Catch: Throwable -> L46
    L42:
        if (r1 == null) goto L44;
        r17 = r1.intValue();     // Catch: Throwable -> L46
        goto L48
    L44:
        r17 = com.bytedance.android.shopping.extensions.b.b(64);     // Catch: Throwable -> L46
    L46:
        r17 = com.bytedance.android.shopping.extensions.b.b(64);
        goto L48
    L52:
        return;
    L51:
        return;
    L17:
        r12 = null;
        goto L18
    L5:
        if (r9.length() == 0) goto L8;
        r10 = false;
        goto L9
    }

    public final void h(com.bytedance.kmp.ec.yata.common.biz.callback.i r6, com.bytedance.kmp.ec.yata.common.biz.callback.j r7) {
        Intrinsics.checkNotNullParameter(r6, "requestModel");
        Intrinsics.checkNotNullParameter(r7, "result");
        if (r7.a == true) goto L17;
        v96.l r0 = r7.b;
        Object r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.a();
    L8:
        Map r3 = r7.c;
        if (r3 == null) goto L11;
        Object r4 = r3.get("status_code");
    L12:
        String r5 = String.valueOf(r4);
        Map r8 = r7.c;
        if (r8 == null) goto L15;
        r1 = r8.get("status_msg");
    L15:
        String r9 = String.valueOf(r1);
        com.bytedance.android.shopping.buynow.monitor.error.a.b(this.d.getTracker(), "yata_request_error", "trigger:" + r6.a + "  code:" + r5 + "  msg:" + r9 + " logId:" + r2);
        return;
    L11:
        r4 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    }

    public final void d(com.bytedance.kmp.ec.yata.store.node.c r11, ga6.c r12, Map<String, ? extends View> r13) {
        Intrinsics.checkNotNullParameter(r11, "root");
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r13, "containerMap");
        p r14 = r11.b.b;
        if (r14 == null) goto L8;
        Object r15 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r14, Reflection.getOrCreateKotlinClass(String.class), "popup_code");
        if ((r15 instanceof String) == true) goto L7;
        r15 = null;
    L7:
        String r16 = (String) r15;
    L9:
        if (r16 != null) goto L12;
        r16 = "";
    L12:
        if (r16.length() != 0) goto L14;
        boolean r17 = true;
    L15:
        if (r17 == false) goto L17;
        return;
    L17:
        AndroidYaTaInstance r18 = this.d.getYataInstance();
        if (r18 == null) goto L20;
        Map r19 = r18.j();
    L21:
        if (r19 == null) goto L23;
        Object r110 = r19.get("popup_mask_click_events");
    L25:
        if ((r110 instanceof Map) == true) goto L27;
        r110 = null;
    L27:
        Map r111 = (Map) r110;
        if (r111 != null) goto L30;
        r111 = MapsKt.emptyMap();
    L30:
        Object r112 = r111.get(r16);
        if ((r112 instanceof Map) == true) goto L33;
        r112 = null;
    L33:
        Map r113 = (Map) r112;
        if (r113 != null) goto L37;
        r113 = MapsKt.emptyMap();
    L37:
        if ((!r113.isEmpty()) == false) goto L60;
        Object r114 = r113.get("trigger_type");
        Object r0 = r113.get("match_vo");
        if ((r0 instanceof Map) == true) goto L41;
        r0 = null;
    L41:
        final Map r1 = (Map) r0;
        Object r115 = r113.get("extra");
        AndroidYaTaInstance r2 = this.d.getYataInstance();
        if (r2 == null) goto L44;
        List r3 = r2.q(new BuyNowYataPageCallbackImpl$onClickMask$matchVONodes$1(r1));
    L45:
        AndroidYaTaInstance r4 = this.d.getYataInstance();
        if (r4 == null) goto L68;
        if (r3 == null) goto L69;
        Iterator r5 = r3.iterator();
    L50:
        if (r5.hasNext() == false) goto L70;
        com.bytedance.kmp.ec.yata.store.node.c r6 = (com.bytedance.kmp.ec.yata.store.node.c) r5.next();
        AndroidYaTaInstance r7 = this.d.getYataInstance();
        if (r7 == null) goto L50;
        YataEventCenter r9 = r7.k();
        if (r9 == null) goto L50;
        com.bytedance.kmp.ec.yata.event.common.e.a r8 = com.bytedance.kmp.ec.yata.event.common.e.a;
        String r10 = r6.getKey();
        String r20 = String.valueOf(r114);
        if ((r115 instanceof Map) == true) goto L58;
        Object r21 = null;
    L59:
        r9.d(r8.a(r4, null, r10, r20, (Map) r21, "BuyNowYataPageCallbackImpl_onClickMask"));
        goto L50
    L58:
        r21 = r115;
        goto L59
    L70:
        return;
    L69:
        return;
    L68:
        return;
    L44:
        r3 = null;
        goto L45
    L60:
        return;
    L23:
        r110 = null;
        goto L25
    L20:
        r19 = null;
        goto L21
    L14:
        r17 = false;
        goto L15
    L8:
        r16 = null;
        goto L9
    }

    public final void i(com.bytedance.kmp.ec.yata.store.node.c r7, ga6.c r8, Map<String, ? extends View> r9) {
        Intrinsics.checkNotNullParameter(r7, "root");
        Intrinsics.checkNotNullParameter(r8, "config");
        Intrinsics.checkNotNullParameter(r9, "containerMap");
        BuyNowFragment r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "root");
        Intrinsics.checkNotNullParameter(r9, "containerMap");
        Intrinsics.checkNotNullParameter(r7, "root");
        Intrinsics.checkNotNullParameter(r9, "containerMap");
        final com.bytedance.android.shopping.buynow.tracker.a r2 = r1.W90().getTracker();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "root");
        Intrinsics.checkNotNullParameter(r9, "containerMap");
        p r10 = r7.b.b;
        RecyclerView r3 = null;
        if (r10 == null) goto L8;
        Object r11 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r10, Reflection.getOrCreateKotlinClass(String.class), "popup_code");
        if ((r11 instanceof String) == true) goto L7;
        r11 = null;
    L7:
        String r12 = (String) r11;
    L10:
        if (Intrinsics.areEqual(r12, PopupCode.PAY_SWITCH_CARD_POPUP) == false) goto L17;
        View r13 = r9.get("body");
        if ((r13 instanceof RecyclerView) == true) goto L14;
        r13 = null;
    L14:
        RecyclerView r14 = (RecyclerView) r13;
        if (r14 == null) goto L17;
        r14.addOnScrollListener(new BuyNowTracker$onPopupShow$1(r2));
    L17:
        p r15 = r7.b.b;
        if (r15 == null) goto L23;
        Object r16 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r15, Reflection.getOrCreateKotlinClass(String.class), "popup_code");
        if ((r16 instanceof String) == true) goto L22;
        r16 = null;
    L22:
        String r17 = (String) r16;
    L24:
        if (r17 == null) goto L33;
        Map<String, RecyclerView> r18 = r1.t;
        View r19 = r9.get("body");
        if ((r19 instanceof RecyclerView) == true) goto L28;
        r19 = null;
    L28:
        RecyclerView r20 = (RecyclerView) r19;
        if (r20 == null) goto L31;
        r20.setClipToPadding(false);
        r20.setClipChildren(false);
        Unit r0 = Unit.INSTANCE;
        r3 = r20;
    L31:
        r18.put(r17, r3);
        return;
    L33:
        return;
    L23:
        r17 = null;
        goto L24
    L8:
        r12 = null;
        goto L10
    }

    public final void k(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.d(r2, r3, r4);
    }

    public final void m(com.bytedance.kmp.ec.yata.store.node.c r3, ga6.c r4, Map<String, ? extends View> r5) {
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "containerMap");
        BuyNowFragment r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r5, "containerMap");
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r5, "containerMap");
        p r6 = r3.b.b;
        Object r7 = null;
        if (r6 == null) goto L9;
        Object r8 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r6, Reflection.getOrCreateKotlinClass(String.class), "popup_code");
        if ((r8 instanceof String) == false) goto L8;
        r7 = r8;
    L8:
        r7 = (String) r7;
    L9:
        Map<String, RecyclerView> r9 = r1.t;
        if (r9 == null) goto L14;
        TypeIntrinsics.asMutableMap(r9).remove(r7);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public final void j(final aa6.a r3, final Object r4, com.bytedance.kmp.ec.yata.common.biz.callback.a r5, com.bytedance.kmp.ec.yata.common.biz.callback.k r6, com.bytedance.kmp.ec.yata.common.biz.callback.h r7, final com.bytedance.kmp.ec.yata.event.ability.uplink.b r8) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r5, "model");
        Intrinsics.checkNotNullParameter(r7, "responseInfo");
        com.bytedance.android.shopping.buynow.utils.i.a r9 = com.bytedance.android.shopping.buynow.utils.i.a;
        com.bytedance.android.shopping.buynow.utils.i.a(new BuyNowYataPageCallbackImpl$onFetchEnd$1(this, r3, r4, r8));
        int r10 = com.bytedance.android.shopping.yata.init.a.a;
        Object r11 = ECSettingKeys.f0().get("fix_skubuy_uplink_protocol_cache");
        Object r12 = null;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r13 = null;
        if ((r11 instanceof Boolean) == true) goto L5;
        r11 = null;
    L5:
        Boolean r14 = (Boolean) r11;
        if (r14 == null) goto L8;
        boolean r15 = r14.booleanValue();
    L9:
        if (r15 == false) goto L68;
        if (this.d.getStaticState().c() == true) goto L13;
        return;
    L13:
        if (Result.isSuccess-impl(r4) == true) goto L15;
        return;
    L15:
        if (r8.a != true) goto L89;
        com.bytedance.kmp.ec.yata.common.protocol.data.e r16 = r7.b;
        if (r16 == null) goto L19;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r17 = r16.g();
    L20:
        if (r17 == null) goto L90;
        AndroidYaTaInstance r18 = this.d.getYataInstance();
        if (r18 == null) goto L66;
        Intrinsics.checkNotNullParameter(r17, "downLinkData");
        aa6.b r19 = r18.r().a();
        if (r19 == null) goto L65;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Map r20 = r17.e();
        if (r20 == null) goto L29;
        Object r21 = r20.get("is_diff_cut");
    L31:
        if ((r21 instanceof Boolean) == false) goto L33;
        Boolean r22 = (Boolean) r21;
    L34:
        if (r22 == null) goto L36;
        boolean r23 = r22.booleanValue();
    L37:
        if (r23 == false) goto L65;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Map r24 = r17.e();
        if (r24 == null) goto L41;
        Object r25 = r24.get("cut_node_list");
    L43:
        if ((r25 instanceof List) == false) goto L45;
        List r26 = (List) r25;
    L46:
        if (r26 == null) goto L48;
        List r27 = CollectionsKt.filterNotNull(r26);
    L49:
        Map r28 = r17.getData();
        if (r28 == null) goto L53;
        Map r29 = MapsKt.toMutableMap(r28);
        if (r29 == null) goto L53;
    L54:
        if (r27 == null) goto L64;
        Iterator r30 = r27.iterator();
    L57:
        if (r30.hasNext() == false) goto L64;
        String r0 = (String) r30.next();
        Map r1 = r19.getData();
        if (r1 == null) goto L61;
        p r2 = (p) r1.get(r0);
    L62:
        if (r2 == null) goto L57;
        r29.put(r0, r2.c(1));
        goto L57
    L61:
        r2 = null;
    L64:
        r13 = com.bytedance.kmp.ec.yata.common.protocol.data.c.b(r17, null, r29, null, 507);
    L53:
        r29 = new LinkedHashMap();
        goto L54
    L48:
        r27 = null;
        goto L49
    L45:
        r26 = null;
        goto L46
    L41:
        r25 = null;
        goto L43
    L36:
        r23 = false;
        goto L37
    L33:
        r22 = null;
        goto L34
    L29:
        r21 = null;
    L65:
        r13 = r17;
    L66:
        n(new com.bytedance.kmp.ec.yata.common.protocol.data.e(r13));
        return;
    L90:
        return;
    L19:
        r17 = null;
        goto L20
    L89:
        return;
    L68:
        if (this.d.getStaticState().c() == true) goto L70;
        return;
    L70:
        if (Result.isSuccess-impl(r4) == true) goto L72;
        return;
    L72:
        if (Result.isFailure-impl(r4) == false) goto L75;
        r4 = null;
    L75:
        if ((r4 instanceof com.bytedance.kmp.ec.yata.common.protocol.data.e) == false) goto L78;
        r12 = r4;
    L78:
        com.bytedance.kmp.ec.yata.common.protocol.data.e r31 = (com.bytedance.kmp.ec.yata.common.protocol.data.e) r12;
        if (r31 == null) goto L94;
        n(r31);
        return;
    L94:
        return;
    L8:
        r15 = true;
        goto L9
    }
}
