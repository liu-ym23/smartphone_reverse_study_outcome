package com.bytedance.android.shopping.buynow.starter;

import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.buynow.data.remote.LogPB;
import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.bytedance.android.shopping.utils.s;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Observer<SsResponse<String>> {
    public final /* synthetic */ BuyNowStarter a;
    public final /* synthetic */ boolean b;

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onError(Throwable r14) {
        Intrinsics.checkNotNullParameter(r14, "e");
        BuyNowStarter r0 = this.a;
        r0.u(new d(r0.n, null, new ma3.b(null, 6), this.b, r14, s.a(r14), 0, false, false, 384));
    }

    public final void onNext(Object r18) {
        SsResponse r1 = (SsResponse) r18;
        Intrinsics.checkNotNullParameter(r1, "retrofitResponse");
        long r2 = System.currentTimeMillis();
        pa3.a r4 = this.a.b;
        if (r4 == null) goto L7;
        BuyNowFirstScreenMonitor r5 = r4.a;
        if (r5 == null) goto L7;
        r5.a(BuyNowFirstScreenNode.NATIVE_NET_END, r2);
    L7:
        pa3.a r6 = this.a.b;
        if (r6 == null) goto L12;
        BuyNowFirstScreenMonitor r7 = r6.a;
        if (r7 == null) goto L12;
        r7.a(BuyNowFirstScreenNode.PARSE_RESPONSE_START, System.currentTimeMillis());
    L12:
        ma3.b r8 = (ma3.b) GsonProtectorUtils.fromJson(u0.c(), (String) r1.body(), ma3.b.class);
        pa3.a r9 = this.a.b;
        if (r9 == null) goto L17;
        BuyNowFirstScreenMonitor r10 = r9.a;
        if (r10 == null) goto L17;
        r10.a(BuyNowFirstScreenNode.PARSE_RESPONSE_END, System.currentTimeMillis());
    L17:
        LogPB r11 = r8.h();
        if (r11 == null) goto L30;
        Map<String, Long> r12 = r11.getServerTiming();
        if (r12 == null) goto L30;
        Iterator<Map.Entry<String, Long>> r13 = r12.entrySet().iterator();
    L23:
        if (r13.hasNext() == false) goto L30;
        Map.Entry<String, Long> r14 = r13.next();
        pa3.a r15 = this.a.b;
        if (r15 == null) goto L23;
        BuyNowFirstScreenMonitor r16 = r15.a;
        if (r16 == null) goto L23;
        String r17 = r14.getKey();
        long r19 = com.bytedance.android.shopping.extensions.k.h(r14.getValue());
        Intrinsics.checkNotNullParameter(r17, "node");
        r16.c(r17, r19);
    L30:
        if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r8) == false) goto L32;
        ra3.b.a("/order/yata/confirmOrderRender", r1, r2);
    L32:
        final String r3 = ma3.l.a(r1);
        pa3.a r20 = this.a.b;
        if (r20 == null) goto L37;
        BuyNowFirstScreenMonitor r21 = r20.a;
        if (r21 == null) goto L37;
        r21.a(BuyNowFirstScreenNode.REQUEST_END, System.currentTimeMillis());
    L37:
        pa3.a r22 = this.a.b;
        if (r22 == null) goto L42;
        BuyNowFirstScreenMonitor r23 = r22.a;
        if (r23 == null) goto L42;
        r23.a(BuyNowFirstScreenNode.RENDER_START, System.currentTimeMillis());
    L42:
        pa3.a r24 = this.a.b;
        if (r24 == null) goto L47;
        BuyNowFirstScreenMonitor r25 = r24.a;
        if (r25 == null) goto L47;
        r25.a(BuyNowFirstScreenNode.STANDARD_RENDER_START, System.currentTimeMillis());
    L47:
        BuyNowStarter r26 = this.a;
        r26.u(new d(r26.n, r3, r8, this.b, null, null, ((String) r1.body()).length(), false, false, 400));
        pa3.a r27 = this.a.b;
        if (r27 == null) goto L52;
        BuyNowFirstScreenMonitor r28 = r27.a;
        if (r28 == null) goto L52;
        BuyNowFirstScreenMonitor.b(r28, BuyNowFirstScreenNode.FETCH_END);
    L52:
        Map r29 = ECParamTrackerCenter.a;
        com.bytedance.android.ec.core.monitor.param.a r30 = ECParamTrackerCenter.c(this.a.n);
        if (r30 == null) goto L63;
        r30.l("/order/yata/confirmOrderRender", new BuyNowStarter$loadBuyNowRenderData$2$onNext$2(r3));
        return;
    }

    public h(BuyNowStarter r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
