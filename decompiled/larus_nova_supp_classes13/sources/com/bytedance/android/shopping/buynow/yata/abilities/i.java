package com.bytedance.android.shopping.buynow.yata.abilities;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.controller.n;
import com.bytedance.android.shopping.buynow.controller.o;
import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ pa3.a b;

    public i(k r1, pa3.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        pa3.a r0 = this.b;
        if (r0 == null) goto L7;
        BuyNowFirstScreenMonitor r1 = r0.a;
        if (r1 == null) goto L7;
        r1.a(BuyNowFirstScreenNode.RENDER_END, System.currentTimeMillis());
    L7:
        pa3.a r2 = this.b;
        if (r2 == null) goto L12;
        BuyNowFirstScreenMonitor r3 = r2.a;
        if (r3 == null) goto L12;
        r3.a(BuyNowFirstScreenNode.STANDARD_RENDER_END, System.currentTimeMillis());
    L12:
        pa3.a r4 = this.b;
        if (r4 == null) goto L17;
        BuyNowFirstScreenMonitor r5 = r4.a;
        if (r5 == null) goto L17;
        r5.a(BuyNowFirstScreenNode.INTERACTIVE, System.currentTimeMillis());
    L17:
        pa3.a r6 = this.b;
        if (r6 == null) goto L22;
        BuyNowFirstScreenMonitor r7 = r6.a;
        if (r7 == null) goto L22;
        r7.a(BuyNowFirstScreenNode.END, System.currentTimeMillis());
    L22:
        BuyNowLog.d("BuyNowFragment", "firstscreen render finish");
        BuyNowFragment r8 = this.a.d;
        r8.getClass();
        if (ECAppInfoService.e.isLocalTest() == false) goto L48;
        nl.c r9 = r8.W90().getStaticState().a;
        String r10 = null;
        if (r9 == null) goto L27;
        String r11 = r9.getQueryParam("performance_test_id");
    L28:
        if (r11 == null) goto L48;
        pa3.a r12 = r8.w;
        if (r12 == null) goto L35;
        BuyNowFirstScreenMonitor r13 = r12.a;
        if (r13 == null) goto L35;
        ConcurrentHashMap<String, Long> r14 = r13.c;
        if (r14 == null) goto L35;
    L36:
        EventActionImpl r15 = new EventActionImpl();
        Pair[] r16 = new Pair[15];
        r16[0] = TuplesKt.to("type", "PERFORMANCE_TEST");
        int r17 = com.bytedance.android.shopping.buynow.utils.c.a;
        r16[1] = TuplesKt.to("btm", com.bytedance.android.shopping.buynow.utils.c.a(r8.W90().getStaticState().g));
        r16[2] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r16[3] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_ANDROID");
        if (r8.W90().getStaticState().b() == false) goto L39;
        String r18 = "pay_pad";
    L40:
        r16[4] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r18);
        r16[5] = TuplesKt.to("os", "android");
        nl.c r19 = r8.W90().getStaticState().a;
        if (r19 == null) goto L43;
        r10 = r19.getQueryParam("performance_test_id");
    L43:
        r16[6] = TuplesKt.to("taskId", r10);
        r16[7] = TuplesKt.to("preContainerTime", -1);
        BuyNowFirstScreenNode r20 = BuyNowFirstScreenNode.INTERACTIVE;
        long r21 = com.bytedance.android.shopping.extensions.k.h(r14.get(r20.getValue()));
        BuyNowFirstScreenNode r22 = BuyNowFirstScreenNode.CONTAINER_INIT_START;
        r16[8] = TuplesKt.to("ttiTime", Long.valueOf(r21 - com.bytedance.android.shopping.extensions.k.h(r14.get(r22.getValue()))));
        long r23 = com.bytedance.android.shopping.extensions.k.h(r14.get(r20.getValue()));
        BuyNowFirstScreenNode r24 = BuyNowFirstScreenNode.RENDER_END;
        r16[9] = TuplesKt.to("renderAfterTime", Long.valueOf(r23 - com.bytedance.android.shopping.extensions.k.h(r14.get(r24.getValue()))));
        r16[10] = TuplesKt.to("renderTime", Long.valueOf(com.bytedance.android.shopping.extensions.k.h(r14.get(r24.getValue())) - com.bytedance.android.shopping.extensions.k.h(r14.get(BuyNowFirstScreenNode.RENDER_START.getValue()))));
        long r25 = com.bytedance.android.shopping.extensions.k.h(r14.get(BuyNowFirstScreenNode.REQUEST_END.getValue()));
        BuyNowFirstScreenNode r26 = BuyNowFirstScreenNode.REQUEST_START;
        r16[11] = TuplesKt.to("requestTime", Long.valueOf(r25 - com.bytedance.android.shopping.extensions.k.h(r14.get(r26.getValue()))));
        BuyNowFirstScreenNode r27 = BuyNowFirstScreenNode.PAGE_START;
        r16[12] = TuplesKt.to("containerTime", Long.valueOf(com.bytedance.android.shopping.extensions.k.h(r14.get(r27.getValue())) - com.bytedance.android.shopping.extensions.k.h(r14.get(r22.getValue()))));
        r16[13] = TuplesKt.to("preRequestTime", Long.valueOf(com.bytedance.android.shopping.extensions.k.h(r14.get(r26.getValue())) - com.bytedance.android.shopping.extensions.k.h(r14.get(r27.getValue()))));
        LinkedHashMap r28 = new LinkedHashMap(MapsKt.mapCapacity(r14.size()));
        Iterator<T> r29 = r14.entrySet().iterator();
    L45:
        if (r29.hasNext() == false) goto L47;
        Map.Entry r30 = (Map.Entry) r29.next();
        r28.put((String) r30.getKey(), r30.getValue());
        goto L45
    L47:
        r16[14] = TuplesKt.to("fullInfo", new JSONObject(r28).toString());
        r15.doEventAction("ies_ecommerce_auto_perf_log", MapsKt.mapOf(r16));
        goto L48
    L39:
        r18 = "submit_orders";
    L35:
        r14 = new ConcurrentHashMap();
        goto L36
    L27:
        r11 = null;
    L48:
        BuyNowFragment r31 = this.a.d;
        r31.getClass();
        if (ECSettingKeys.l0().getBuynow_yata_check() == false) goto L52;
        Completable.fromAction(new com.bytedance.android.shopping.buynow.container.b(r31)).subscribeOn(Schedulers.computation()).subscribe();
    L52:
        if (r31.W90().getStaticState().c() == true) goto L64;
        BuyNowViewModel r32 = r31.W90();
        nl.c r33 = o.a;
        if (r32 == null) goto L57;
        o.a = r32.getStaticState().a;
        o.b = r32.getStaticState().c;
    L57:
        if (BuyNowPerformanceOpt.f() == false) goto L61;
        nl.c r34 = o.a;
        if (r34 == null) goto L65;
        r34.getQueryParam("schema_diff_id");
        return;
    L65:
        return;
    L61:
        Completable.fromAction(n.a).subscribeOn(Schedulers.computation()).subscribe();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
