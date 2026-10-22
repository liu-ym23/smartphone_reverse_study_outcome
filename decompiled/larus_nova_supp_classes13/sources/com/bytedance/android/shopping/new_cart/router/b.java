package com.bytedance.android.shopping.new_cart.router;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.new_cart.container.NewCartActivity;
import com.bytedance.android.shopping.new_cart.monitor.ECCartMonitorReporter;
import com.bytedance.android.shopping.new_cart.monitor.ECCartMonitorReporter$ttnetExtraInfoMap$1;
import com.bytedance.android.shopping.new_cart.repo.CartRepository;
import com.bytedance.kmp.ec.yata.common.perf.AbsPerfMonitor;
import com.bytedance.kmp.ec.yata.common.perf.d;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Observer<SsResponse<String>> {
    public final /* synthetic */ NewCartStarter a;

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public b(NewCartStarter r1) {
        this.a = r1;
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        NewCartStarter.a(this.a, r2);
        int r0 = com.bytedance.android.shopping.new_cart.monitor.a.a;
        String r3 = r2.getMessage();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        com.bytedance.android.shopping.new_cart.monitor.a.d(-1, r3);
    }

    public final void onNext(Object r11) {
        SsResponse<String> r12 = (SsResponse) r11;
        Intrinsics.checkNotNullParameter(r12, "o");
        NewCartStarter r0 = this.a;
        r0.n.a(r0.o, r0.m, NewCartStarter$queryData$3$onNext$1.INSTANCE);
        int r1 = ECCartMonitorReporter.d;
        ECCartMonitorReporter r2 = ECCartMonitorReporter.a.a();
        String r3 = this.a.l;
        com.bytedance.kmp.ec.yata.common.perf.c r4 = NewCartActivity.G;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "node");
        d r5 = r2.c.get(r3);
        if (r5 == null) goto L5;
        AbsPerfMonitor.c(r5, r4);
    L5:
        ECCartMonitorReporter.a.a().f(this.a.l, NewCartActivity.H);
        Map<String, Map<String, Long>> r6 = yf3.b.a;     // Catch: Throwable -> L11
        yf3.b.a(this.a.s, "DeserializedStart");     // Catch: Throwable -> L11
        e r7 = CartRepository.INSTANCE.transformToDTO(r12);     // Catch: Throwable -> L11
        yf3.b.a(this.a.s, "DeserializedEnd");     // Catch: Throwable -> L9
        Throwable th = null;
    L14:
        int r8 = ECCartMonitorReporter.d;
        ECCartMonitorReporter r9 = ECCartMonitorReporter.a.a();
        String r10 = this.a.l;
        com.bytedance.kmp.ec.yata.common.perf.c r13 = NewCartActivity.H;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r13, "node");
        d r14 = r9.c.get(r10);
        if (r14 == null) goto L17;
        AbsPerfMonitor.c(r14, r13);
    L17:
        ECCartMonitorReporter r15 = ECCartMonitorReporter.a.a();
        String r16 = this.a.k;
        Object r17 = r12.raw().getExtraInfo();
        if ((r7 instanceof wf3.a) == true) goto L20;
        e r18 = null;
    L21:
        wf3.a r19 = (wf3.a) r18;
        if (r19 == null) goto L24;
        hd3.d r20 = r19.j();
    L25:
        r15.getClass();
        if (r16 == null) goto L35;
        if (r20 != null) goto L31;
        if (r17 == null) goto L35;
    L31:
        ECCartMonitorReporter$ttnetExtraInfoMap$1 r21 = r15.a;
        monitor-enter(r21);
        r15.a.put(r16, new com.bytedance.android.shopping.new_cart.monitor.b(r17, r20));     // Catch: Throwable -> L64
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L64
        monitor-exit(r21);
    L64:
        th = move-exception;
        throw th;
    L35:
        ECCartMonitorReporter r23 = ECCartMonitorReporter.a.a();
        String r24 = this.a.k;
        r23.getClass();
        ECCartMonitorReporter.d(r24, "request_end");
        if (r7 != null) goto L38;
    L40:
        int r110 = com.bytedance.android.shopping.new_cart.monitor.a.a;
        if (r7 == null) goto L45;
        Integer r111 = r7.a();
        if (r111 == null) goto L45;
        int r112 = r111.intValue();
    L46:
        if (r7 == null) goto L49;
        String r25 = r7.b();
        if (r25 == null) goto L49;
    L50:
        com.bytedance.android.shopping.new_cart.monitor.a.d(r112, r25);
        bg3.a r113 = com.bytedance.android.shopping.new_cart.utils.a.a;
        if (r7 == null) goto L53;
        Integer r26 = r7.a();
    L54:
        com.bytedance.android.shopping.new_cart.utils.a.j("PREFETCH-RESP-ERROR", String.valueOf(r26), null, 4);
    L55:
        if (r7 == null) goto L57;
        s0.b(new a(this.a.s, r7));
    L57:
        if (th == null) goto L59;
        NewCartStarter.a(this.a, th);
    L59:
        if (r7 != null) goto L62;
        if (th != null) goto L62;
        com.bytedance.android.shopping.new_cart.utils.a.j("QUERY-RES-ERR-NULL", "", null, 12);
        NewCartStarter.a(this.a, new Exception("response and err is null in cart starter"));
    L62:
        NewCartStarter r114 = this.a;
        r114.n.a(r114.o, r114.m, NewCartStarter$queryData$3$onNext$4.INSTANCE);
        return;
    L53:
        r26 = null;
    L49:
        r25 = "";
    L45:
        r112 = 0;
        goto L46
    L38:
        if (f.d(r7) != true) goto L40;
        ECCartMonitorReporter r27 = ECCartMonitorReporter.a.a();
        String r28 = this.a.k;
        r27.getClass();
        ECCartMonitorReporter.d(r28, "render_start");
        CartRepository.INSTANCE.setResponse((String) r12.body(), this.a.a);
        goto L55
    L24:
        r20 = null;
        goto L25
    L20:
        r18 = r7;
    L9:
        th = th;
    L13:
        com.bytedance.android.shopping.new_cart.utils.a.j("DownLinkDataResponse-deserializes-fromJson-ERROR", "", null, 12);
    L11:
        th = move-exception;
        th = th;
        r7 = null;
        goto L13
    }
}
