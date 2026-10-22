package io.opentelemetry.sdk.trace;

import java.io.Closeable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes41.dex */
public final class m implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f492783c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f492784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.opentelemetry.sdk.internal.d<k> f492785b;

    static {
        f492783c = Logger.getLogger(m.class.getName());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f492784a.f492802i == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        f492783c.log(Level.INFO, "Calling shutdown() multiple times.");
        ltc.d r101 = ltc.d.f510763d;
    L17:
        r101.c(TimeUnit.SECONDS);
        return;
    L8:
        s r102 = this.f492784a;
        Object r103 = r102.f492794a;
        monitor-enter(r103);
    L19:
        th = move-exception;
        throw th;
    L11:
        if (r102.f492802i == null) goto L15;
        r101 = r102.f492802i;     // Catch: Throwable -> L19
        monitor-exit(r103);     // Catch: Throwable -> L19
    L22:
        goto L17
    L15:
        r102.f492802i = r102.f492801h.shutdown();     // Catch: Throwable -> L19
        r101 = r102.f492802i;     // Catch: Throwable -> L19
        monitor-exit(r103);     // Catch: Throwable -> L19
        goto L22
    L5:
        r100 = false;
        goto L6
    }

    public final String toString() {
        return "SdkTracerProvider{clock=" + this.f492784a.f492795b + ", idGenerator=" + this.f492784a.f492796c + ", resource=" + this.f492784a.f492798e + ", spanLimitsSupplier=" + this.f492784a.f492799f.get() + ", sampler=" + this.f492784a.f492800g + ", spanProcessor=" + this.f492784a.f492801h + '}';
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [io.opentelemetry.sdk.trace.l] */
    public m(ltc.f r100, d r110, mtc.c r111, n r112, io.opentelemetry.sdk.trace.samplers.c r113, List r114) {
        this.f492784a = new s(r100, r110, r111, r112, r113, r114);
        this.f492785b = new io.opentelemetry.sdk.internal.d(new l(this));
    }
}
