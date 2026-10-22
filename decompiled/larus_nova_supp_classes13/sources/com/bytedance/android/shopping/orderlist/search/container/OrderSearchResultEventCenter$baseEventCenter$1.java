package com.bytedance.android.shopping.orderlist.search.container;

import android.view.View;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.orderlist.common.controller.OrderCommonScrollStrategyController;
import com.bytedance.android.shopping.orderlist.common.controller.o;
import com.bytedance.android.shopping.orderlist.common.controller.w;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.OrderSelfRegisterBridgeFunction$onExecuteAsync$1;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.j0;
import com.bytedance.android.shopping.orderlist.common.freq.OrderFreqControlManager;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.l;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderSearchResultEventCenter$baseEventCenter$1 implements com.bytedance.android.shopping.orderlist.common.eventcenter.core.a {
    public final /* synthetic */ OrderSearchResultEventCenter a;

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void B0() {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final OrderFreqControlManager C0() {
        return null;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final eg3.b H0() {
        return null;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void N0(String r1, String r2) {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final View T0() {
        return null;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void u0(int r1) {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void v0(int r1, boolean r2) {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void x0(String r1, o r2) {
        Intrinsics.checkNotNullParameter(r2, "chainEvent");
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void z0(com.bytedance.kmp.ec.yata.store.node.c r1) {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final c53.d D0() {
        return this.a.c;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final com.bytedance.android.shopping.orderlist.common.monitor.error.a E0() {
        return this.a.d.getTracker();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void F0() {
        this.a.c.H1().f();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final boolean G0() {
        return this.a.c.r;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final Map<String, Map<String, Object>> P0() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void Q0() {
        this.a.c.G1().g();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void R0() {
        this.a.c.finish();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final ig3.a S0() {
        Map<String, ig3.a> r0 = ig3.a.h;
        return ig3.a.C0206a.a(getCurrentSessionId());
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final SlcRenderContext f() {
        return this.a.c.o;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final String getCurrentSessionId() {
        return this.a.d.getStaticState().c;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void t0() {
        this.a.f.n();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void w0() {
        final OrderSearchRequestType r0 = OrderSearchRequestType.NORMAL;
        this.a.c.G1().j(r0, new OrderSearchResultEventCenter$baseEventCenter$1$operateSuccessToRefresh$1(this, r0), OrderSearchResultEventCenter$baseEventCenter$1$operateSuccessToRefresh$2.INSTANCE);
    }

    public OrderSearchResultEventCenter$baseEventCenter$1(OrderSearchResultEventCenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void A0(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "newData");
        this.a.d.updateSchemaMap(r2);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void I0(j0 r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        this.a.d.getStaticState().h = r2;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void J0(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        ((ArrayList) this.a.c.s).add(r2);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void K0(float r2) {
        this.a.f.m(r2);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void M0(JSONObject r14) {
        Intrinsics.checkNotNullParameter(r14, "param");
        String r0 = r14.optString("yata_session_id", "");
        boolean r3 = false;
        if (r0.length() != 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L11;
        OrderCommonErrorMonitorKt.a(this.a.d.getTracker(), "TRIGGER_SAVE_NODE_EVENT_ERROR", "OrderSearchEventCenter yata_session_id is empty", l.a(r14));
        return;
    L11:
        if ((!Intrinsics.areEqual(r0, this.a.d.getStaticState().c)) == false) goto L13;
        return;
    L13:
        String r1 = r14.optString("event_name");
        if (r1 != null) goto L16;
        String r10 = "";
    L18:
        if (r10.length() != 0) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L24;
        OrderCommonErrorMonitorKt.a(this.a.d.getTracker(), "TRIGGER_SAVE_NODE_EVENT_ERROR", "OrderSearchEventCenter event_name is empty", l.a(r14));
        return;
    L24:
        String r5 = com.bytedance.android.shopping.orderlist.common.controller.l.a;
        if (r5 != null) goto L27;
    L28:
        r3 = true;
    L29:
        if (r3 == false) goto L32;
        OrderCommonErrorMonitorKt.a(this.a.d.getTracker(), "TRIGGER_SAVE_NODE_EVENT_ERROR", "TAG node saved is empty", l.a(r14));
        return;
    L32:
        JSONObject r15 = r14.optJSONObject("event_params");
        if (r15 != null) goto L35;
        r15 = new JSONObject();
    L35:
        Map<String, Object> r16 = l.a(r15);
        Map<String, Object> r11 = com.bytedance.android.shopping.orderlist.common.controller.l.b;
        Iterator r17 = ((HashMap) r16).entrySet().iterator();
    L37:
        if (r17.hasNext() == false) goto L41;
        Map.Entry r6 = (Map.Entry) r17.next();
        if (r11 == null) goto L37;
        r11.put((String) r6.getKey(), r6.getValue());
        goto L37
    L41:
        AndroidYaTaInstance r18 = this.a.e;
        if (r18 == null) goto L52;
        YataEventCenter r19 = r18.k();
        if (r19 == null) goto L53;
        r19.d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.a.e, null, com.bytedance.android.shopping.orderlist.common.controller.l.a, r10, r11, "operateSuccessToYataEvent"));
        return;
    L53:
        return;
    L52:
        return;
    L27:
        if (r5.length() != 0) goto L29;
    L20:
        r4 = false;
        goto L21
    L16:
        r10 = r1;
        goto L18
    L5:
        r2 = false;
        goto L7
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void O0(JSONObject r9) {
        Intrinsics.checkNotNullParameter(r9, "param");
        if ((!Intrinsics.areEqual(r9.optString("sku_session_id"), this.a.d.getStaticState().c)) == false) goto L5;
        return;
    L5:
        Map<String, Object> r0 = com.bytedance.android.shopping.orderlist.common.controller.l.b;
        if (r0 == null) goto L8;
        Object r1 = r0.get("event_name");
    L9:
        String r5 = String.valueOf(r1);
        Intrinsics.checkNotNullParameter("listSkuPanelItemRefresh", "default");
        JSONObject r2 = r9.optJSONObject("response");
        if (r2 == null) goto L13;
        String r3 = r2.toString();
        if (r3 == null) goto L13;
    L14:
        r9.put("response", r3);
        AndroidYaTaInstance r4 = this.a.e;
        if (r4 == null) goto L20;
        YataEventCenter r6 = r4.k();
        if (r6 == null) goto L21;
        r6.d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.a.e, null, com.bytedance.android.shopping.orderlist.common.controller.l.a, r5, l.a(r9), "operateCartAdd"));
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r3 = "";
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void U0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bridgeName");
        j r0 = this.a.d.getStaticState().i.remove(r2);
        if (r0 == null) goto L6;
        ECLiveHybridUtil.p(r2, r0);
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void L0(String r2, w r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "scrollStrategy");
        ((OrderCommonScrollStrategyController) this.a.a.getValue()).a(r2, r3);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.core.a
    public final void y0(String r2, OrderSelfRegisterBridgeFunction$onExecuteAsync$1.a r3) {
        Intrinsics.checkNotNullParameter(r2, "bridgeName");
        Intrinsics.checkNotNullParameter(r3, "subscriber");
        this.a.d.getStaticState().i.put(r2, r3);
    }
}
