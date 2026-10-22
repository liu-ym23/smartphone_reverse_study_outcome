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

/* JADX INFO: loaded from: classes18.dex */
public final class f implements g.c<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f560201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f560202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<a> f560203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ul5.a f560204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f560205e;

    @Override // onb.g.c
    public final void a() {
        tt5.a.h("JSModelService-Docs", "JSModelService hashcode: " + hashCode() + " jsClient connected");
        Set<a> r100 = this.f560203c;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.f560203c);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((a) r102.next()).a();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // onb.g.c
    public final void disconnect() {
        tt5.a.h("JSModelService-Docs", "JSModelService hashcode: " + hashCode() + " jsClient disconnected");
        Set<a> r100 = this.f560203c;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.f560203c);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((a) r102.next()).disconnect();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // onb.g.c
    public final void b(onb.b r110) {
        i r111 = (i) r110;
        long r100 = SystemClock.elapsedRealtimeNanos();
        long r101 = System.nanoTime();
        long r102 = System.currentTimeMillis();
        if ((r111 instanceof vl5.f) == false) goto L6;
        tt5.a.b("JSModelService-Docs", "elapsedRealtimeNanos: " + (SystemClock.elapsedRealtimeNanos() - r100) + " ns, nanoTime: " + (System.nanoTime() - r101) + " ns, currentTimeMillis: " + (System.currentTimeMillis() - r102) + " ms");
        this.f560204d.c((vl5.f) r111);
        return;
    L6:
        if ((r111 instanceof vl5.c) == false) goto L13;
        vl5.c r103 = (vl5.c) r111;
        if (r103.f555677c == false) goto L10;
        this.f560204d.a(r111.f555679a);
        return;
    L10:
        this.f560204d.b(r103);
        return;
    }

    public final void d(String r100) {
        vl5.e r101 = new vl5.e();
        Intrinsics.checkNotNullParameter(r100, "message");
        r101.f555678c = r100;
        r101.f524405b = -1;
        r101.f524404a = -1;
        k r102 = this.f560202b;
        r102.getClass();
        new onb.i(r102, r101).d(new d());
    }

    public final Flowable c(final vl5.b r100, final String r101, long r102) {
        if (this.f560201a == false) goto L5;
        tt5.a.b("JSModelService-Docs", "sendDocRequest, message: " + r101);
    L5:
        Intrinsics.checkNotNullParameter(r101, "message");
        r100.f555678c = r101;
        r100.f524405b = -1;
        r100.f524404a = r102;
        return Flowable.create(new b(this, r100, r101), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.c()).observeOn(fo5.d.d());
    }

    public f(Application r100, com.bytedance.ee.bear.contract.d r101, String r102, String r103, r r110) {
        boolean r104 = true;
        this.f560203c = new HashSet(1);
        k.a r105 = new k.a();
        r105.f524431b = r100;
        ml5.b r106 = new ml5.b("debug_config");
        if (DevEnvUtil.isDebugMode(r100) == true) goto L5;
    L7:
        r104 = false;
    L8:
        r105.f524430a = r104;
        r105.f524432c = r102;
        r105.f524433d = new vl5.g();
        r105.f524434e = new vl5.d();
        r105.f524435f = new c(this);
        r105.f524436g = r103;
        this.f560202b = new k(r105);
        this.f560204d = r110;
        this.f560205e = r101;
        this.f560201a = DevEnvUtil.isDebugMode(r100);
        return;
    L5:
        if (((Boolean) r106.a("rn_debug", Boolean.FALSE)).booleanValue() == false) goto L7;
        goto L7
    }
}
