package io.opentelemetry.sdk.trace.samplers;

import itc.g;

/* JADX INFO: loaded from: classes41.dex */
public abstract class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f492808a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f492809b = null;

    public b() {
    }

    public abstract g a();

    public abstract SamplingDecision b();

    static {
        SamplingDecision r100 = SamplingDecision.RECORD_AND_SAMPLE;
        itc.b r101 = itc.b.f495767d;
        f492808a = new a(r100, r101);
        f492809b = new a(SamplingDecision.DROP, r101);
        new a(SamplingDecision.RECORD_ONLY, r101);
    }
}
