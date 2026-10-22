package io.opentelemetry.sdk.trace;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final io.opentelemetry.sdk.trace.samplers.c f492786g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q> f492787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ltc.f f492788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f492789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final mtc.c f492790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f492791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.opentelemetry.sdk.trace.samplers.c f492792f;

    static {
        f492786g = new io.opentelemetry.sdk.trace.samplers.c(io.opentelemetry.sdk.trace.samplers.d.a());
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [io.opentelemetry.sdk.trace.n] */
    public o() {
        this.f492787a = new ArrayList();
        this.f492788b = ltc.f.f510769a;
        this.f492789c = RandomIdGenerator.INSTANCE;
        this.f492790d = mtc.c.f515706d;
        this.f492791e = new n();
        this.f492792f = f492786g;
    }
}
