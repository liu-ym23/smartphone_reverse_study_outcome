package com.bytedance.android.shopping.orderlist.list.network;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.FirstScreenPoint;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.bytedance.android.shopping.orderlist.common.utils.n;
import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListRequestViewModel$doChunkRequest$2$1 implements com.bytedance.android.chunkstreamprediction.network.a<com.bytedance.kmp.ec.yata.common.protocol.data.e> {
    public final /* synthetic */ d a;

    public static final class a implements Runnable {
        public final /* synthetic */ OrderListRequestViewModel$doChunkRequest$2$1 a;

        public a(OrderListRequestViewModel$doChunkRequest$2$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OrderListRequestViewModel r0 = this.a.a.a;     // Catch: Throwable -> L12
            OrderListViewModel r2 = r0.d;     // Catch: Throwable -> L12
            if (r2 == null) goto L7;
            com.bytedance.android.shopping.orderlist.list.viewmodel.a r3 = r2.getStaticState();     // Catch: Throwable -> L12
            if (r3 == null) goto L7;
            com.bytedance.kmp.ec.yata.common.protocol.data.e r4 = r3.u;     // Catch: Throwable -> L12
        L8:
            com.bytedance.android.shopping.orderlist.list.network.a r1 = new com.bytedance.android.shopping.orderlist.list.network.a(true, false, r4);     // Catch: Throwable -> L12
            r0.n = r1;     // Catch: Throwable -> L12
            Function1<? super com.bytedance.android.shopping.orderlist.list.network.a, Unit> r5 = r0.p;     // Catch: Throwable -> L12
            if (r5 == null) goto L15;
            Unit r6 = (Unit) r5.invoke(r1);     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L7:
            r4 = null;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ OrderListRequestViewModel$doChunkRequest$2$1 a;

        public b(OrderListRequestViewModel$doChunkRequest$2$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OrderListRequestViewModel r0 = this.a.a.a;     // Catch: Throwable -> L6
            com.bytedance.android.shopping.orderlist.list.network.a r1 = new com.bytedance.android.shopping.orderlist.list.network.a(true, 5);     // Catch: Throwable -> L6
            r0.n = r1;     // Catch: Throwable -> L6
            Function1<? super com.bytedance.android.shopping.orderlist.list.network.a, Unit> r2 = r0.p;     // Catch: Throwable -> L6
            if (r2 == null) goto L9;
            Unit r3 = (Unit) r2.invoke(r1);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void onComplete() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRequestViewModel", OrderListRequestViewModel$doChunkRequest$2$1$onComplete$1.INSTANCE);
        OrderListViewModel r1 = this.a.a.d;
        if (r1 == null) goto L7;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r2 = r1.getStaticState();
        if (r2 == null) goto L7;
        r2.t = false;
    L7:
        new Handler(Looper.getMainLooper()).post(new a(this));
    }

    public OrderListRequestViewModel$doChunkRequest$2$1(d r1) {
        this.a = r1;
    }

    public final void onFailed(final Throwable r3) {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.b("OrderListRequestViewModel", new OrderListRequestViewModel$doChunkRequest$2$1$onFailed$1(r3));
        d r4 = this.a;
        OrderListRequestViewModel r1 = r4.a;
        if (r1.q == true) goto L5;
        r1.b(r4.d, false);
    L5:
        new Handler(Looper.getMainLooper()).post(new b(this));
    }

    public final void onNext(Object r12) {
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r13 = (com.bytedance.kmp.ec.yata.common.protocol.data.e) r12;
        Intrinsics.checkNotNullParameter(r13, "downResponse");
        this.a.a.q = gg3.a.a(r13);
        boolean r1 = false;
        if (r13.g() != null) goto L5;
        int r0 = n.a;
        n.a(r13.b(), false, false);
        Lazy r14 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRequestViewModel", OrderListRequestViewModel$doChunkRequest$2$1$onNext$1.INSTANCE);
        return;
    L5:
        Lazy r2 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRequestViewModel", new OrderListRequestViewModel$doChunkRequest$2$1$onNext$2(r13));
        if (this.a.a.q == true) goto L8;
    L24:
        OrderListViewModel r3 = this.a.a.d;
        Integer r4 = null;
        if (r3 == null) goto L58;
        final OrderListTracker r5 = r3.getTracker();
        if (r5 == null) goto L58;
        OrderListRequestViewModel r6 = this.a.a;
        if (r6.q == false) goto L41;
        OrderListViewModel r7 = r6.d;
        if (r7 == null) goto L35;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r8 = r7.getStaticState();
        if (r8 == null) goto L35;
        r8.t = true;
    L35:
        OrderListViewModel r9 = this.a.a.d;
        if (r9 == null) goto L40;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r10 = r9.getStaticState();
        if (r10 == null) goto L40;
        r10.s = true;
    L40:
        r5.g("first_chunk_duration", Long.valueOf(System.currentTimeMillis() - this.a.b));
    L51:
        r5.g("error_msg", k.j(r13.b()));
        r5.g("success", Integer.valueOf(com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r13) ? 1 : 0));
        r5.g("received_count", Integer.valueOf(k.r(String.valueOf(r5.d.get("received_count")), 0) + 1));
        OrderListViewModel r11 = this.a.a.d;
        if (r11 == null) goto L56;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r15 = r11.getStaticState();
        if (r15 == null) goto L56;
        Integer r16 = r15.l;
    L57:
        r5.g("tab_id", Integer.valueOf(k.f(r16)));
        m.a r17 = m.a;
        m.b(new OrderListRequestViewModel$doChunkRequest$2$1$onNext$$inlined$apply$lambda$1(r5, this, r13));
    L56:
        r16 = null;
        goto L57
    L41:
        long r18 = System.currentTimeMillis();
        r5.g("second_chunk_duration", Long.valueOf((r18 - this.a.b) - k.y(String.valueOf(r5.d.get("first_chunk_duration")), 0)));
        r5.g("chunk_request_total_time", Long.valueOf(r18 - this.a.b));
        OrderListViewModel r19 = this.a.a.d;
        if (r19 == null) goto L46;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r20 = r19.getStaticState();
        if (r20 == null) goto L46;
        r20.t = false;
    L46:
        OrderListViewModel r21 = this.a.a.d;
        if (r21 == null) goto L51;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r22 = r21.getStaticState();
        if (r22 == null) goto L51;
        r22.u = r13;
    L58:
        d r23 = this.a;
        com.bytedance.android.shopping.orderlist.list.tab.a r24 = r23.c;
        Integer r25 = r24.a;
        int r26 = r24.b;
        OrderListViewModel r27 = r23.a.d;
        if (r27 == null) goto L63;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r28 = r27.getStaticState();
        if (r28 == null) goto L63;
        Integer r29 = r28.k;
    L64:
        OrderListViewModel r30 = this.a.a.d;
        if (r30 == null) goto L70;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r31 = r30.getStaticState();
        if (r31 == null) goto L70;
        r4 = r31.l;
    L70:
        if (Intrinsics.areEqual(r29, r25) == false) goto L76;
        if (r4 == null) goto L76;
        if (r4.intValue() != r26) goto L76;
        r1 = true;
    L76:
        boolean r32 = this.a.a.q;
        if (r32 == true) goto L81;
        if (r4 == null) goto L81;
        if (r1 == true) goto L81;
        return;
    L81:
        new Handler(Looper.getMainLooper()).post(new c(this, r13, r32));
        return;
    L63:
        r29 = null;
        goto L64
    L8:
        if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r13) == false) goto L24;
        ig3.a r33 = this.a.a.g;
        if (r33 == null) goto L14;
        OrderCommonFirstScreenMonitor r34 = r33.a;
        if (r34 == null) goto L14;
        r34.a(FirstScreenPoint.REQUEST_END);
    L14:
        ig3.a r35 = this.a.a.g;
        if (r35 == null) goto L19;
        OrderCommonFirstScreenMonitor r36 = r35.a;
        if (r36 == null) goto L19;
        r36.a(FirstScreenPoint.FETCH_END);
    L19:
        ig3.a r37 = this.a.a.g;
        if (r37 == null) goto L24;
        OrderCommonFirstScreenMonitor r38 = r37.a;
        if (r38 == null) goto L24;
        r38.a(FirstScreenPoint.RENDER_START);
        goto L24
    }
}
