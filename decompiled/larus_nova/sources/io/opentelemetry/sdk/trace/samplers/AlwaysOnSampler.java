package io.opentelemetry.sdk.trace.samplers;

import io.opentelemetry.api.trace.SpanKind;
import itc.g;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
final enum AlwaysOnSampler extends Enum<AlwaysOnSampler> implements e {
    public static final AlwaysOnSampler INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlwaysOnSampler[] f492804a = null;

    @Override // io.opentelemetry.sdk.trace.samplers.e
    public String getDescription() {
        return "AlwaysOnSampler";
    }

    static {
        AlwaysOnSampler r100 = new AlwaysOnSampler();
        INSTANCE = r100;
        f492804a = new AlwaysOnSampler[]{r100};
    }

    public AlwaysOnSampler() {
        super("INSTANCE", 0);
    }

    public static AlwaysOnSampler[] values() {
        return (AlwaysOnSampler[]) f492804a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return getDescription();
    }

    public static AlwaysOnSampler valueOf(String r100) {
        return (AlwaysOnSampler) r27.a.a(AlwaysOnSampler.class, r100);
    }

    @Override // io.opentelemetry.sdk.trace.samplers.e
    public f shouldSample(io.opentelemetry.context.b r100, String r101, String r102, SpanKind r103, g r104, List<Object> r105) {
        return b.f492808a;
    }
}
