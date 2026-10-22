package com.bytedance.android.shopping.sku.inner.yata.abilities;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.biz.callback.h;
import com.bytedance.kmp.ec.yata.common.biz.callback.i;
import com.bytedance.kmp.ec.yata.common.biz.callback.j;
import com.bytedance.kmp.ec.yata.common.biz.callback.k;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.kmp.ec.yata.event.ability.uplink.response.UplinkFailedException;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import com.bytedance.kmp.ec.yata.store.core.YataStoreData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import v96.f;
import v96.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataProgressCallback implements f.a, com.bytedance.kmp.ec.yata.common.biz.callback.c, com.bytedance.kmp.ec.yata.common.biz.callback.f, com.bytedance.kmp.ec.yata.common.biz.callback.d {
    public final Lazy a;
    public final com.bytedance.android.shopping.sku.inner.container.b b;

    public final void a() {
    }

    public SkuYataProgressCallback(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.b = r2;
        this.a = LazyKt.lazy(new SkuYataProgressCallback$assembleDataController$2(this));
    }

    public final void b(i r2) {
        Intrinsics.checkNotNullParameter(r2, "requestModel");
        Intrinsics.checkNotNullParameter(r2, "requestModel");
    }

    public final void c(YataStoreData r3) {
        Intrinsics.checkNotNullParameter(r3, "storeData");
        aa6.a r4 = r3.c;
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.c("SkuYataProgressCallback", "onProtocolDispatchEnd(开始渲染)  source:" + r4.a);
    }

    public final void e(com.bytedance.kmp.ec.yata.common.biz.callback.a r4) {
        aa6.a.b.b r0 = aa6.a.b.b.b;
        Intrinsics.checkNotNullParameter(r0, "source");
        Intrinsics.checkNotNullParameter(r4, "model");
        SkuCommonLog.c("SkuYataProgressCallback", "onFetchBegin(开始Uplink请求)  source:uplink");
        if (Intrinsics.areEqual(r0, r0) == false) goto L6;
        this.b.EJ(r4);
        return;
    }

    @Deprecated(message = "老版的临时过渡的接口方法，SDK不再深度维护，最好不要使用")
    public final void l(com.bytedance.kmp.ec.yata.store.node.c r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r2, "node");
    }

    public final void f(YataStoreData r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "storeData");
        aa6.a r5 = r3.c;
        Lazy r6 = SkuCommonLog.a;
        SkuCommonLog.c("SkuYataProgressCallback", "onProtocolDispatchEnd(渲染结束)  source:" + r5.a);
        this.b.KJ();
        String r7 = r5.a;
        aa6.a.b.b r0 = aa6.a.b.b.b;
        if (Intrinsics.areEqual(r7, "uplink") == false) goto L5;
        com.bytedance.android.shopping.sku.common.utils.e.a r8 = com.bytedance.android.shopping.sku.common.utils.e.a;
        com.bytedance.android.shopping.sku.common.utils.e.b(new SkuYataProgressCallback$doClickAfterUplink$1(this));
    L5:
        String r9 = r5.a;
        aa6.a.b.a r1 = aa6.a.b.a.b;
        if (Intrinsics.areEqual(r9, "query") == false) goto L8;
    L9:
        AndroidYaTaInstance r10 = this.b.bV();
        Object r11 = null;
        if (r10 == null) goto L14;
        Map r12 = r10.j();
        if (r12 == null) goto L14;
        Object r13 = r12.get("track_common_info");
    L16:
        if ((r13 instanceof Map) == true) goto L18;
        r13 = null;
    L18:
        Map r14 = (Map) r13;
        if (r14 == null) goto L21;
        Object r15 = r14.get("bcm_event_track");
    L23:
        if ((r15 instanceof String) == false) goto L26;
        r11 = r15;
    L26:
        String r16 = (String) r11;
        if (r16 == null) goto L31;
        BtmSDK r17 = BtmSDK.INSTANCE;
        PageFinder r2 = PageFinder.via(this.b);
        BcmParams.Companion.getClass();
        r17.setBcmPageParams(r2, BcmParams.a.a(r16), true);
        return;
    L31:
        return;
    L21:
        r15 = null;
    L14:
        r13 = null;
        goto L16
    L8:
        if (Intrinsics.areEqual(r5.a, "uplink") == true) goto L9;
    }

    public final void g(com.bytedance.kmp.ec.yata.store.node.c r5, ga6.c r6) {
        Intrinsics.checkNotNullParameter(r5, "root");
        Intrinsics.checkNotNullParameter(r6, "config");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.e(r5, r6);
        String r7 = r6.a();
        if (r7 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        return;
    L11:
        AndroidYaTaInstance r9 = this.b.bV();
        Object r1 = "";
        Integer r2 = null;
        if (r9 == null) goto L17;
        String r3 = r6.a();
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        com.bytedance.kmp.ec.yata.store.node.c r10 = r9.o(r3);
    L18:
        if (r10 == null) goto L30;
        com.bytedance.kmp.ec.yata.store.node.e r11 = r10.b;
        if (r11 == null) goto L30;
        p r12 = r11.b;
        if (r12 == null) goto L30;
        Map r13 = r12.h();
        if (r13 == null) goto L30;
        Object r14 = r13.get("popup_code");
        if (r14 == null) goto L30;
        r1 = r14;
    L30:
        if (Intrinsics.areEqual(r1, "MINI_CART_POPUP") == true) goto L45;
        return;
    L45:
        ViewGroup r4 = this.b.cM();     // Catch: Throwable -> L39
        View r0 = r4.getChildAt(r4.getChildCount() - 1);     // Catch: Throwable -> L39
        if (r0 == null) goto L35;
        r2 = Integer.valueOf(r0.getMeasuredHeight());     // Catch: Throwable -> L39
    L35:
        if (r2 == null) goto L37;
        int r15 = r2.intValue();     // Catch: Throwable -> L39
    L40:
        int r16 = ((Number) r6.b("height", -1)).intValue();
        if (r16 <= 0) goto L43;
        r6.c("height", Integer.valueOf(r16 - r15));
    L43:
        r6.c("bottom_offset", Integer.valueOf(r15));
        return;
    L37:
        r15 = com.bytedance.android.shopping.extensions.b.b(52);     // Catch: Throwable -> L39
    L39:
        r15 = com.bytedance.android.shopping.extensions.b.b(52);
        goto L40
    L17:
        r10 = null;
        goto L18
    L5:
        if (r7.length() == 0) goto L8;
        r8 = false;
        goto L9
    }

    public final void h(i r8, j r9) {
        Intrinsics.checkNotNullParameter(r8, "requestModel");
        Intrinsics.checkNotNullParameter(r9, "result");
        SkuCommonLog.c("SkuYataProgressCallback", "onRequestEnd(request原子能力请求结束)");
        if (r9.a == true) goto L21;
        l r0 = r9.b;
        Object r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.a();
    L8:
        Map r3 = r9.c;
        if (r3 == null) goto L11;
        Object r4 = r3.get("status_code");
    L12:
        String r5 = String.valueOf(r4);
        Map r10 = r9.c;
        if (r10 == null) goto L15;
        r1 = r10.get("status_msg");
    L15:
        String r11 = String.valueOf(r1);
        mh3.a r6 = this.b.qn().getMonitorManager();
        if (r6 == null) goto L22;
        com.bytedance.android.shopping.sku.common.monitor.error.a r7 = r6.c;
        if (r7 == null) goto L23;
        JSONObject r12 = new JSONObject();
        r12.put("error_code", r5);
        r12.put("error_msg", r11);
        r12.put("trigger", r8.a);
        r12.put("log_id", r2);
        Unit r13 = Unit.INSTANCE;
        r7.a(SkuErrorMonitorType.YATA_REQUEST_ERROR, "code:" + r5 + "  msg:" + r11, r12);
        return;
    L23:
        return;
    L22:
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
        Object r15 = q.b(r14, Reflection.getOrCreateKotlinClass(String.class), "popup_code");
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
        AndroidYaTaInstance r18 = this.b.bV();
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
        if ((!r113.isEmpty()) == false) goto L56;
        Object r114 = r113.get("trigger_type");
        Object r0 = r113.get("match_vo");
        if ((r0 instanceof Map) == true) goto L41;
        r0 = null;
    L41:
        final Map r1 = (Map) r0;
        Object r115 = r113.get("extra");
        AndroidYaTaInstance r2 = this.b.bV();
        if (r2 == null) goto L44;
        List r3 = r2.q(new SkuYataProgressCallback$onClickMask$matchVONodes$1(r1));
    L45:
        AndroidYaTaInstance r4 = this.b.bV();
        if (r4 == null) goto L60;
        if (r3 == null) goto L61;
        Iterator r5 = r3.iterator();
    L50:
        if (r5.hasNext() == false) goto L62;
        com.bytedance.kmp.ec.yata.store.node.c r6 = (com.bytedance.kmp.ec.yata.store.node.c) r5.next();
        YataEventCenter r9 = r4.k();
        com.bytedance.kmp.ec.yata.event.common.e.a r7 = com.bytedance.kmp.ec.yata.event.common.e.a;
        String r8 = r6.getKey();
        String r10 = String.valueOf(r114);
        if ((r115 instanceof Map) == true) goto L54;
        Object r20 = null;
    L55:
        r9.d(r7.a(r4, null, r8, r10, (Map) r20, "SkuYataFragment_onClickMask"));
        goto L50
    L54:
        r20 = r115;
        goto L55
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L44:
        r3 = null;
        goto L45
    L56:
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

    public final void i(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.c(r2, r3, r4);
    }

    public final void k(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.d(r2, r3, r4);
    }

    public final void m(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.b(r2, r3, r4);
    }

    public final void j(aa6.a r1, Object r2, final com.bytedance.kmp.ec.yata.common.biz.callback.a r3, k r4, h r5, final com.bytedance.kmp.ec.yata.event.ability.uplink.b r6) {
        Intrinsics.checkNotNullParameter(r1, "source");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r5, "responseInfo");
        Lazy r7 = SkuCommonLog.a;
        SkuCommonLog.c("SkuYataProgressCallback", "onFetchEnd(结束Uplink请求)  source:" + r1.a);
        if (Intrinsics.areEqual(r1, aa6.a.b.b.b) == false) goto L27;
        final com.bytedance.android.shopping.sku.inner.repo.a r8 = null;
        if (Result.isFailure-impl(r2) == false) goto L7;
        Object r9 = null;
    L9:
        if ((r9 instanceof com.bytedance.kmp.ec.yata.common.protocol.data.e) == true) goto L11;
        r9 = null;
    L11:
        com.bytedance.kmp.ec.yata.common.protocol.data.e r10 = (com.bytedance.kmp.ec.yata.common.protocol.data.e) r9;
        if (r10 != null) goto L23;
        Throwable r11 = Result.exceptionOrNull-impl(r2);
        if ((r11 instanceof UplinkFailedException) == true) goto L16;
        r11 = null;
    L16:
        UplinkFailedException r12 = (UplinkFailedException) r11;
        if (r12 == null) goto L19;
        r10 = r12.getResponse();
    L21:
        if ((r10 instanceof com.bytedance.kmp.ec.yata.common.protocol.data.e) == true) goto L23;
        r10 = null;
        goto L23
    L19:
        r10 = null;
    L23:
        if (r10 == null) goto L25;
        r8 = ma3.c.b(r10);
    L25:
        SkuCommonLog.c(this.b.tag(), "onUplinkEnd");
        com.bytedance.android.shopping.sku.common.utils.e.a r13 = com.bytedance.android.shopping.sku.common.utils.e.a;
        com.bytedance.android.shopping.sku.common.utils.e.b(new SkuYataProgressCallback$onUplinkEnd$1(this, r8, r6, r3));
        return;
    L7:
        r9 = r2;
        goto L9
    }
}
