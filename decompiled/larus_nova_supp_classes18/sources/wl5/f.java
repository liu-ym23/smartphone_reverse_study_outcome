package wl5;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.ee.bear.rn.r;
import com.larksuite.framework.utils.DevEnvUtil;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import onb.g;
import onb.k;
import vl5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements g.c<i> {
    public final boolean a;
    public final k b;
    public final Set<a> c;
    public final ul5.a d;
    public final com.bytedance.ee.bear.contract.d e;

    public final void a() {
        tt5.a.h("JSModelService-Docs", "JSModelService hashcode: " + hashCode() + " jsClient connected");
        Set<a> r0 = this.c;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.c);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((a) r2.next()).a();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void disconnect() {
        tt5.a.h("JSModelService-Docs", "JSModelService hashcode: " + hashCode() + " jsClient disconnected");
        Set<a> r0 = this.c;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.c);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((a) r2.next()).disconnect();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void b(onb.b r15) {
        i r16 = (i) r15;
        long r0 = SystemClock.elapsedRealtimeNanos();
        long r2 = System.nanoTime();
        long r4 = System.currentTimeMillis();
        if ((r16 instanceof vl5.f) == false) goto L6;
        tt5.a.b("JSModelService-Docs", "elapsedRealtimeNanos: " + (SystemClock.elapsedRealtimeNanos() - r0) + " ns, nanoTime: " + (System.nanoTime() - r2) + " ns, currentTimeMillis: " + (System.currentTimeMillis() - r4) + " ms");
        this.d.c((vl5.f) r16);
        return;
    L6:
        if ((r16 instanceof vl5.c) == false) goto L13;
        vl5.c r1 = (vl5.c) r16;
        if (r1.c == false) goto L10;
        this.d.a(r16.a);
        return;
    L10:
        this.d.b(r1);
        return;
    }

    public final void d(String r4) {
        vl5.e r0 = new vl5.e();
        Intrinsics.checkNotNullParameter(r4, "message");
        r0.c = r4;
        ((onb.a) r0).b = -1;
        ((onb.a) r0).a = -1;
        k r5 = this.b;
        r5.getClass();
        new onb.i(r5, r0).d(new d());
    }

    public final Flowable c(final vl5.b r3, final String r4, long r5) {
        if (this.a == false) goto L5;
        tt5.a.b("JSModelService-Docs", "sendDocRequest, message: " + r4);
    L5:
        Intrinsics.checkNotNullParameter(r4, "message");
        r3.c = r4;
        ((onb.a) r3).b = -1;
        ((onb.a) r3).a = r5;
        return Flowable.create(new b(this, r3, r4), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.c()).observeOn(fo5.d.d());
    }

    public f(Application r6, com.bytedance.ee.bear.contract.d r7, String r8, String r9, r r10) {
        boolean r1 = true;
        this.c = new HashSet(1);
        k.a r0 = new k.a();
        r0.b = r6;
        ml5.b r2 = new ml5.b("debug_config");
        if (DevEnvUtil.isDebugMode(r6) == true) goto L5;
    L7:
        r1 = false;
    L8:
        r0.a = r1;
        r0.c = r8;
        r0.d = new vl5.g();
        r0.e = new vl5.d();
        r0.f = new c(this);
        r0.g = r9;
        this.b = new k(r0);
        this.d = r10;
        this.e = r7;
        this.a = DevEnvUtil.isDebugMode(r6);
        return;
    L5:
        if (((Boolean) r2.a("rn_debug", Boolean.FALSE)).booleanValue() == false) goto L7;
        goto L7
    }
}
