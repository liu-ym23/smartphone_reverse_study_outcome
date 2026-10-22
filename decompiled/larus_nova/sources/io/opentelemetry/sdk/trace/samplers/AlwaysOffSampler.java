package io.opentelemetry.sdk.trace.samplers;

import io.opentelemetry.api.trace.SpanKind;
import itc.g;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
final enum AlwaysOffSampler extends Enum<AlwaysOffSampler> implements e {
    public static final AlwaysOffSampler INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlwaysOffSampler[] f492803a = null;

    @Override // io.opentelemetry.sdk.trace.samplers.e
    public String getDescription() {
        return "AlwaysOffSampler";
    }

    static {
        AlwaysOffSampler r100 = new AlwaysOffSampler();
        INSTANCE = r100;
        f492803a = new AlwaysOffSampler[]{r100};
    }

    public AlwaysOffSampler() {
        super("INSTANCE", 0);
    }

    public static AlwaysOffSampler[] values() {
        return (AlwaysOffSampler[]) f492803a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return getDescription();
    }

    public static AlwaysOffSampler valueOf(String r100) {
        return (AlwaysOffSampler) r27.a.a(AlwaysOffSampler.class, r100);
    }

    @Override // io.opentelemetry.sdk.trace.samplers.e
    public f shouldSample(io.opentelemetry.context.b r100, String r101, String r102, SpanKind r103, g r104, List<Object> r105) {
        return b.f492809b;
    }
}
