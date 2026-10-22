package io.opentelemetry.sdk.trace;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public final class f implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f492751a = null;

    public f() {
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final boolean Q3() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final boolean U3() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final void Yl(g r100) {
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final void Zk(io.opentelemetry.context.b r100, h r101) {
    }

    public final String toString() {
        return "NoopSpanProcessor{}";
    }

    static {
        f492751a = new f();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        shutdown().c(TimeUnit.SECONDS);
    }

    @Override // io.opentelemetry.sdk.trace.q
    public final ltc.d shutdown() {
        return ltc.d.f510763d;
    }
}
