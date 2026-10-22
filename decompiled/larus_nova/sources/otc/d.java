package otc;

import io.opentelemetry.sdk.trace.g;
import io.opentelemetry.sdk.trace.h;
import io.opentelemetry.sdk.trace.q;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import jtc.f;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f526714e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f526715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f526716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<ltc.d> f526717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f526718d;

    @Override // io.opentelemetry.sdk.trace.q
    public final boolean Q3() {
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final boolean U3() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final void Zk(io.opentelemetry.context.b r100, h r101) {
    }

    static {
        f526714e = Logger.getLogger(d.class.getName());
    }

    public final ltc.d a() {
        return ltc.d.d(this.f526717c);
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final ltc.d shutdown() {
        if (this.f526718d.getAndSet(true) == true) goto L5;
        final ltc.d r100 = new ltc.d();
        final ltc.d r101 = a();
        r101.f(new a(this, r101, r100));
        return r100;
    L5:
        return ltc.d.f510763d;
    }

    public final String toString() {
        return "SimpleSpanProcessor{spanExporter=" + this.f526715a + '}';
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        shutdown().c(TimeUnit.SECONDS);
    }

    public d(vx9.e r100) {
        this.f526717c = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f526718d = new AtomicBoolean(false);
        this.f526715a = r100;
        this.f526716b = true;
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final void Yl(g r100) {
        if (this.f526716b == false) goto L15;
        io.opentelemetry.api.internal.h r101 = (io.opentelemetry.api.internal.h) ((h) r100).f492754b;
        r101.getClass();
        boolean r102 = true;
        if ((((f) ((io.opentelemetry.api.internal.b) r101).f492666d).f500396b & 1) != 0) goto L8;
        r102 = false;
    L8:
        if (r102 == true) goto L15;
        return;
    L15:
        List r103 = Collections.singletonList(((h) r100).e());     // Catch: RuntimeException -> L12
        final ltc.d r104 = this.f526715a.Jd(r103);     // Catch: RuntimeException -> L12
        this.f526717c.add(r104);     // Catch: RuntimeException -> L12
        r104.f(new c(this, r104));     // Catch: RuntimeException -> L12
        return;
    L12:
        e = move-exception;
        f526714e.log(Level.WARNING, "Exporter threw an Exception", e);
    }
}
