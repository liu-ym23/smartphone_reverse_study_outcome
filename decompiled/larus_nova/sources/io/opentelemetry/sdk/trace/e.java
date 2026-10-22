package io.opentelemetry.sdk.trace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes41.dex */
public final class e implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q> f492747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<q> f492748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<q> f492749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f492750d;

    @Override // io.opentelemetry.sdk.trace.q
    public final boolean Q3() {
        return !this.f492748b.isEmpty();
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final boolean U3() {
        return !this.f492747a.isEmpty();
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final ltc.d shutdown() {
        if (this.f492750d.getAndSet(true) == true) goto L5;
        ArrayList r100 = new ArrayList(this.f492749c.size());
        Iterator<q> r101 = this.f492749c.iterator();
    L8:
        if (r101.hasNext() == false) goto L11;
        r100.add(r101.next().shutdown());
        goto L8
    L11:
        return ltc.d.d(r100);
    L5:
        return ltc.d.f510763d;
    }

    public final String toString() {
        return "MultiSpanProcessor{spanProcessorsStart=" + this.f492747a + ", spanProcessorsEnd=" + this.f492748b + ", spanProcessorsAll=" + this.f492749c + '}';
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        shutdown().c(TimeUnit.SECONDS);
    }

    public e(List<q> r100) {
        this.f492750d = new AtomicBoolean(false);
        this.f492749c = r100;
        ArrayList r101 = (ArrayList) r100;
        this.f492747a = new ArrayList(r101.size());
        this.f492748b = new ArrayList(r101.size());
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        q r103 = (q) r102.next();
        if (r103.U3() == false) goto L9;
        ((ArrayList) this.f492747a).add(r103);
    L9:
        if (r103.Q3() == false) goto L4;
        ((ArrayList) this.f492748b).add(r103);
        goto L4
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final void Yl(g r100) {
        Iterator r101 = ((ArrayList) this.f492748b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((q) r101.next()).Yl(r100);
        goto L4
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final void Zk(io.opentelemetry.context.b r100, h r101) {
        Iterator r102 = ((ArrayList) this.f492747a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((q) r102.next()).Zk(r100, r101);
        goto L4
    }
}
