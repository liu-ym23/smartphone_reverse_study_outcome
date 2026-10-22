package com.bytedance.android.shopping.buynow.starter;

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
public final class i implements Observer<SsResponse<String>> {
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

    public final void onNext(Object r15) {
        SsResponse r16 = (SsResponse) r15;
        Intrinsics.checkNotNullParameter(r16, "retrofitResponse");
        long r0 = System.currentTimeMillis();
        pa3.a r2 = this.a.b;
        if (r2 == null) goto L7;
        BuyNowFirstScreenMonitor r3 = r2.a;
        if (r3 == null) goto L7;
        r3.a(BuyNowFirstScreenNode.NATIVE_NET_END, r0);
    L7:
        pa3.a r4 = this.a.b;
        if (r4 == null) goto L12;
        BuyNowFirstScreenMonitor r5 = r4.a;
        if (r5 == null) goto L12;
        r5.a(BuyNowFirstScreenNode.PARSE_RESPONSE_START, System.currentTimeMillis());
    L12:
        ma3.b r6 = (ma3.b) GsonProtectorUtils.fromJson(u0.c(), (String) r16.body(), ma3.b.class);
        pa3.a r7 = this.a.b;
        if (r7 == null) goto L17;
        BuyNowFirstScreenMonitor r8 = r7.a;
        if (r8 == null) goto L17;
        r8.a(BuyNowFirstScreenNode.PARSE_RESPONSE_END, System.currentTimeMillis());
    L17:
        LogPB r9 = r6.h();
        if (r9 == null) goto L30;
        Map<String, Long> r10 = r9.getServerTiming();
        if (r10 == null) goto L30;
        Iterator<Map.Entry<String, Long>> r11 = r10.entrySet().iterator();
    L23:
        if (r11.hasNext() == false) goto L30;
        Map.Entry<String, Long> r12 = r11.next();
        pa3.a r13 = this.a.b;
        if (r13 == null) goto L23;
        BuyNowFirstScreenMonitor r14 = r13.a;
        if (r14 == null) goto L23;
        String r17 = r12.getKey();
        long r18 = com.bytedance.android.shopping.extensions.k.h(r12.getValue());
        Intrinsics.checkNotNullParameter(r17, "node");
        r14.c(r17, r18);
    L30:
        if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r6) == false) goto L32;
        ra3.b.a("/order/yata/getPayMethod", r16, r0);
    L32:
        String r19 = ma3.l.a(r16);
        pa3.a r1 = this.a.b;
        if (r1 == null) goto L37;
        BuyNowFirstScreenMonitor r20 = r1.a;
        if (r20 == null) goto L37;
        r20.a(BuyNowFirstScreenNode.REQUEST_END, System.currentTimeMillis());
    L37:
        pa3.a r21 = this.a.b;
        if (r21 == null) goto L42;
        BuyNowFirstScreenMonitor r22 = r21.a;
        if (r22 == null) goto L42;
        r22.a(BuyNowFirstScreenNode.RENDER_START, System.currentTimeMillis());
    L42:
        pa3.a r23 = this.a.b;
        if (r23 == null) goto L47;
        BuyNowFirstScreenMonitor r24 = r23.a;
        if (r24 == null) goto L47;
        r24.a(BuyNowFirstScreenNode.STANDARD_RENDER_START, System.currentTimeMillis());
    L47:
        BuyNowStarter r25 = this.a;
        r25.u(new d(r25.n, r19, r6, this.b, null, null, ((String) r16.body()).length(), false, false, 400));
        pa3.a r110 = this.a.b;
        if (r110 == null) goto L60;
        BuyNowFirstScreenMonitor r111 = r110.a;
        if (r111 == null) goto L61;
        BuyNowFirstScreenMonitor.b(r111, BuyNowFirstScreenNode.FETCH_END);
        return;
    L61:
        return;
    }

    public i(BuyNowStarter r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
