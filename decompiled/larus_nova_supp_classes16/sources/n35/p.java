package n35;

import android.util.Pair;
import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
import k25.e0;
import k25.m0;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ m a;
    public final /* synthetic */ m0 b;
    public final /* synthetic */ tb5.m c;
    public final /* synthetic */ OfflineTransferModel d;
    public final /* synthetic */ long e;

    public p(m r1, m0 r2, tb5.m r3, OfflineTransferModel r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r26) {
        String r0 = (String) r26;
        m r2 = this.a;
        m0 r3 = this.b;
        tb5.m r4 = this.c;
        OfflineTransferModel r5 = this.d;
        long r6 = this.e;
        r2.getClass();
        long r12 = System.currentTimeMillis();
    L30:
        e = move-exception;
        if (r2.g == false) goto L37;
        if (r5.isCheckError() == false) goto L37;
        tt5.a.k(r2.b, "db operation error & data import , save file");
        e0.m().b.f(r3, false);
    L37:
        if (r5.isCheckError() == true) goto L39;
    L42:
        d25.d.g("unkonw error " + e.getMessage(), r4);
        tt5.a.e(r2.b, "addDataToStorage: ", e, false);
        iu5.d.a(r2.b, e);
        return;
    L39:
        if (r2.e != 1) goto L41;
        AtomicBoolean r1 = a05.c.r;
        goto L42
    L41:
        AtomicBoolean r7 = a05.c.r;
        goto L42
    L4:
        if (r2.e == 1) goto L28;
        Object r14 = r2.d.a(r3, r2.f);     // Catch: Exception -> L30
        monitor-enter(r14);     // Catch: Exception -> L30
        m0 r8 = e0.m().C(r3.k, r3.b, 0);     // Catch: Throwable -> L25
        long r18 = System.currentTimeMillis();     // Catch: Throwable -> L25
        int r9 = r8.a;     // Catch: Throwable -> L25
        if (r9 <= 0) goto L13;
        r3.a = r9;     // Catch: Throwable -> L25
        r3.o = r8.o;     // Catch: Throwable -> L25
        r3.s = r8.s;     // Catch: Throwable -> L25
        String r10 = "SetDataHandler ret <= 0   ret: ";
        long r11 = e0.m().H(r3);     // Catch: Throwable -> L25
        if (r11 > 0) goto L12;
        tt5.a.h(r2.b, "updateResourceData fail! ret = " + r11);     // Catch: Throwable -> L25
        Pair<Long, String> r13 = e0.m().w(r3);     // Catch: Throwable -> L25
        long r16 = ((Number) r13.first).longValue();     // Catch: Throwable -> L25
        Object r17 = r13.second;     // Catch: Throwable -> L25
    L14:
        Object r19 = r17;
        r11 = r16;
    L15:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r14);     // Catch: Exception -> L30
        long r111 = System.currentTimeMillis();     // Catch: Exception -> L30
        String r112 = r10;
        tt5.a.h(r2.b, "addDataToStorage()... key = " + du5.b.k(r3.b) + " dataType = " + r3.v + " ret = " + r11 + " cost1 = " + (r12 - r6) + " cost2 = " + (r18 - r12) + " cost3 = " + (r111 - r18));     // Catch: Exception -> L30
        if (r11 > 0) goto L20;
        d25.d.g("insert error " + ((String) r19), r4);     // Catch: Exception -> L30
        throw new RuntimeException(r112 + r11);     // Catch: Exception -> L30
    L20:
        if (r5.isCheckError() == false) goto L22;
        AtomicBoolean r20 = a05.c.r;     // Catch: Exception -> L30
    L22:
        d25.d.h("", r4);     // Catch: Exception -> L30
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new n(r2, r3), new o(r2));     // Catch: Exception -> L30
        return;
    L12:
        r19 = "";
        goto L15
    L13:
        r10 = "SetDataHandler ret <= 0   ret: ";
        r3.s = "webview";     // Catch: Throwable -> L25
        Pair<Long, String> r21 = e0.m().w(r3);     // Catch: Throwable -> L25
        r16 = ((Number) r21.first).longValue();     // Catch: Throwable -> L25
        r17 = r21.second;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Exception -> L30
    L28:
        tt5.a.d(r2.b, "addDataToStorage mock error ");     // Catch: Exception -> L30
        throw new NullPointerException("mock addData error");     // Catch: Exception -> L30
    }
}
