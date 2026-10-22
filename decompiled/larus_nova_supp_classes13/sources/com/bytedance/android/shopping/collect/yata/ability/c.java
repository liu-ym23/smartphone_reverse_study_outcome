package com.bytedance.android.shopping.collect.yata.ability;

import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.collect.container.CollectYataViewModel;
import com.bytedance.android.shopping.collect.custom_view.CollectGoodsGULView;
import com.bytedance.android.shopping.collect.custom_view.CollectGoodsLinkedScrollView;
import com.bytedance.android.shopping.collect.monitor.duration.CollectYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.collect.monitor.duration.CollectYataFirstScreenPoint;
import com.bytedance.android.shopping.collect.monitor.error.CollectErrorMonitorType;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.biz.callback.h;
import com.bytedance.kmp.ec.yata.common.biz.callback.i;
import com.bytedance.kmp.ec.yata.common.biz.callback.j;
import com.bytedance.kmp.ec.yata.common.biz.callback.k;
import com.bytedance.kmp.ec.yata.event.ability.uplink.response.UplinkFailedException;
import com.bytedance.kmp.ec.yata.store.core.YataStoreData;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v96.f;
import v96.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements f.a, com.bytedance.kmp.ec.yata.common.biz.callback.c, com.bytedance.kmp.ec.yata.common.biz.callback.f, com.bytedance.kmp.ec.yata.common.biz.callback.d {
    public final CollectYataFragment a;

    public final void a() {
    }

    public c(CollectYataFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void b(i r2) {
        Intrinsics.checkNotNullParameter(r2, "requestModel");
        Intrinsics.checkNotNullParameter(r2, "requestModel");
        this.a.getClass();
        CollectCommonLog.c("CollectYataFragmentPage", "onRequestStart");
    }

    public final void c(YataStoreData r3) {
        Intrinsics.checkNotNullParameter(r3, "storeData");
        aa6.a r4 = r3.c;
        Lazy r0 = CollectCommonLog.a;
        CollectCommonLog.c("CollectYataProgressCallback", "onProtocolDispatchEnd(开始渲染)  source:" + r4.a);
    }

    public final void e(com.bytedance.kmp.ec.yata.common.biz.callback.a r4) {
        aa6.a.b.b r0 = aa6.a.b.b.b;
        Intrinsics.checkNotNullParameter(r0, "source");
        Intrinsics.checkNotNullParameter(r4, "model");
        CollectCommonLog.c("CollectYataProgressCallback", "onFetchBegin(开始Uplink请求)  source:uplink");
        if (Intrinsics.areEqual(r0, r0) == false) goto L6;
        this.a.EJ(r4);
        return;
    }

    @Deprecated(message = "老版的临时过渡的接口方法，SDK不再深度维护，最好不要使用")
    public final void l(com.bytedance.kmp.ec.yata.store.node.c r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r2, "node");
    }

    public final void f(YataStoreData r11, Object r12) {
        Intrinsics.checkNotNullParameter(r11, "storeData");
        aa6.a r13 = r11.c;
        Lazy r14 = CollectCommonLog.a;
        CollectCommonLog.c("CollectYataProgressCallback", "onProtocolDispatchEnd(渲染结束)  source:" + r13.a);
        CollectYataFragment r15 = this.a;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r13, "source");
        kb3.a r1 = r15.n;
        CollectGoodsLinkedScrollView r2 = r15.S90();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r13, "source");
        com.bytedance.android.shopping.collect.util.e r3 = r1.c;
        Object r4 = null;
        if (r3 == null) goto L36;
        Intrinsics.checkNotNullParameter(r13, "source");
        String r0 = r13.a;
        aa6.a.b.a r8 = aa6.a.b.a.b;
        if ((!Intrinsics.areEqual(r0, "query")) == false) goto L9;
        String r5 = r13.a;
        aa6.a.b.b r9 = aa6.a.b.b.b;
        if ((!Intrinsics.areEqual(r5, "uplink")) == true) goto L36;
    L9:
        int r6 = com.bytedance.android.shopping.collect.util.e.e;
        Function0<AndroidYaTaInstance> r7 = r3.d;
        if (r7 == null) goto L12;
        AndroidYaTaInstance r10 = (AndroidYaTaInstance) r7.invoke();
    L14:
        if (com.bytedance.android.shopping.collect.util.e.a.a(r10) == false) goto L16;
    L23:
        Function0<AndroidYaTaInstance> r16 = r3.d;
        if (r16 == null) goto L26;
        AndroidYaTaInstance r17 = (AndroidYaTaInstance) r16.invoke();
    L28:
        if (com.bytedance.android.shopping.collect.util.e.a.a(r17) == false) goto L35;
        if (r2 == null) goto L33;
        CollectGoodsGULView r18 = r2.getGul();
        if (r18 == null) goto L33;
        r18.k();
    L33:
        if (r2 == null) goto L35;
        r2.requestLayout();
    L35:
        r3.b = false;
        goto L36
    L26:
        r17 = null;
        goto L28
    L16:
        if (r3.b == false) goto L23;
        if (r2 == null) goto L21;
        CollectGoodsGULView r19 = r2.getGul();
        if (r19 == null) goto L21;
        r19.l();
    L21:
        if (r2 == null) goto L35;
        r2.requestLayout();
        goto L35
    L12:
        r10 = null;
    L36:
        String r20 = r13.a;
        aa6.a.b.a r21 = aa6.a.b.a.b;
        if (Intrinsics.areEqual(r20, "query") == false) goto L65;
        r15.p = true;
        AndroidYaTaInstance r22 = r15.k;
        if (r22 == null) goto L41;
        Object r23 = r22.i("total_collection_count");
    L43:
        if ((r23 instanceof Integer) == true) goto L45;
        r23 = null;
    L45:
        Integer r24 = (Integer) r23;
        if (r24 == null) goto L48;
        int r25 = r24.intValue();
    L49:
        int r26 = tb3.a.a;
        CollectParams r27 = r15.o;
        CollectYataViewModel r28 = r15.V90();
        Intrinsics.checkNotNullParameter(r28, "viewModel");
        String r29 = "personal_homepage";
        if (r27 == null) goto L64;
        String r30 = r27.getPreviousPage();
        if (r30 != null) goto L54;
    L57:
        boolean r31 = true;
    L58:
        if (r31 == false) goto L60;
        String r32 = "personal_homepage";
    L61:
        if (r32 == null) goto L64;
        r29 = r32;
        goto L64
    L60:
        r32 = r27.getPreviousPage();
        goto L61
    L54:
        if (r30.length() == 0) goto L57;
        r31 = false;
    L64:
        r28.doEventAction("collect_list_page_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("product_num", Integer.valueOf(r25)), TuplesKt.to("previous_page", r29)}), "collect_list_page_show_from_query");
        tb3.a.a("end", MapsKt.emptyMap(), r15.V90());
        goto L65
    L48:
        r25 = 0;
        goto L49
    L41:
        r23 = null;
    L65:
        pb3.a r110 = r15.V90().getMonitorManager();
        if (r110 == null) goto L75;
        CollectYataFirstScreenDurationMonitor r111 = r110.b;
        if (r111 == null) goto L75;
        if (r111.d == true) goto L75;
        if (r111.e == true) goto L75;
        CollectYataFirstScreenDurationMonitor.a(r111, CollectYataFirstScreenPoint.RENDER_END);
        CollectYataFirstScreenDurationMonitor.a(r111, CollectYataFirstScreenPoint.END);
    L75:
        if (Intrinsics.areEqual(r13.a, "query") == true) goto L78;
        String r112 = r13.a;
        aa6.a.b.b r113 = aa6.a.b.b.b;
        if (Intrinsics.areEqual(r112, "uplink") == true) goto L78;
        return;
    L78:
        AndroidYaTaInstance r114 = this.a.k;
        if (r114 == null) goto L83;
        Map r115 = r114.j();
        if (r115 == null) goto L83;
        Object r116 = r115.get("track_common_info");
    L85:
        if ((r116 instanceof Map) == true) goto L87;
        r116 = null;
    L87:
        Map r117 = (Map) r116;
        if (r117 == null) goto L90;
        Object r118 = r117.get("bcm_event_track");
    L92:
        if ((r118 instanceof String) == false) goto L95;
        r4 = r118;
    L95:
        String r33 = (String) r4;
        if (r33 == null) goto L100;
        BtmSDK r119 = BtmSDK.INSTANCE;
        PageFinder r120 = PageFinder.via(this.a);
        BcmParams.Companion.getClass();
        r119.setBcmPageParams(r120, BcmParams.a.a(r33), true);
        return;
    L100:
        return;
    L90:
        r118 = null;
    L83:
        r116 = null;
        goto L85
    }

    public final void g(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.e(r2, r3);
    }

    public final void h(i r8, j r9) {
        Intrinsics.checkNotNullParameter(r8, "requestModel");
        Intrinsics.checkNotNullParameter(r9, "result");
        CollectCommonLog.c("CollectYataProgressCallback", "onRequestEnd(request原子能力请求结束)");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r9, "result");
        CollectCommonLog.c("CollectYataFragmentPage", "onRequestEnd");
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
        pb3.a r6 = this.a.V90().getMonitorManager();
        if (r6 == null) goto L22;
        com.bytedance.android.shopping.collect.monitor.error.a r7 = r6.c;
        if (r7 == null) goto L23;
        JSONObject r12 = new JSONObject();
        r12.put("error_code", r5);
        r12.put("error_msg", r11);
        r12.put("trigger", r8.a);
        r12.put("log_id", r2);
        Unit r13 = Unit.INSTANCE;
        r7.b(CollectErrorMonitorType.YATA_REQUEST_ERROR, "code:" + r5 + "  msg:" + r11, r12);
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

    public final void d(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.a(r2, r3, r4);
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

    public final void j(aa6.a r1, Object r2, com.bytedance.kmp.ec.yata.common.biz.callback.a r3, k r4, h r5, com.bytedance.kmp.ec.yata.event.ability.uplink.b r6) {
        Intrinsics.checkNotNullParameter(r1, "source");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r5, "responseInfo");
        Lazy r7 = CollectCommonLog.a;
        CollectCommonLog.c("CollectYataProgressCallback", "onFetchEnd(结束Uplink请求)  source:" + r1.a);
        if (Intrinsics.areEqual(r1, aa6.a.b.b.b) == false) goto L22;
        com.bytedance.kmp.ec.yata.common.protocol.data.e r8 = null;
        if (Result.isFailure-impl(r2) == false) goto L7;
        Object r9 = null;
    L9:
        if ((r9 instanceof com.bytedance.kmp.ec.yata.common.protocol.data.e) == true) goto L12;
        r9 = null;
    L12:
        if (((com.bytedance.kmp.ec.yata.common.protocol.data.e) r9) != null) goto L20;
        Throwable r10 = Result.exceptionOrNull-impl(r2);
        if ((r10 instanceof UplinkFailedException) == true) goto L16;
        r10 = null;
    L16:
        UplinkFailedException r11 = (UplinkFailedException) r10;
        if (r11 == null) goto L19;
        r8 = r11.getResponse();
    L19:
        boolean r12 = r8 instanceof com.bytedance.kmp.ec.yata.common.protocol.data.e;
    L20:
        this.a.W90(r3);
        return;
    L7:
        r9 = r2;
        goto L9
    }
}
