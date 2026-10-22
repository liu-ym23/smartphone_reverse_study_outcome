package io.opentelemetry.sdk.trace.samplers;

/* JADX INFO: loaded from: classes41.dex */
public final enum SamplingDecision extends Enum<SamplingDecision> {
    public static final SamplingDecision DROP = null;
    public static final SamplingDecision RECORD_AND_SAMPLE = null;
    public static final SamplingDecision RECORD_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SamplingDecision[] f492805a = null;

    static {
        SamplingDecision r100 = new SamplingDecision("DROP", 0);
        DROP = r100;
        SamplingDecision r101 = new SamplingDecision("RECORD_ONLY", 1);
        RECORD_ONLY = r101;
        SamplingDecision r102 = new SamplingDecision("RECORD_AND_SAMPLE", 2);
        RECORD_AND_SAMPLE = r102;
        f492805a = new SamplingDecision[]{r100, r101, r102};
    }

    public static SamplingDecision[] values() {
        return (SamplingDecision[]) f492805a.clone();
    }

    public static SamplingDecision valueOf(String r100) {
        return (SamplingDecision) r27.a.a(SamplingDecision.class, r100);
    }

    public SamplingDecision(String r100, int r101) {
        super(r100, r101);
    }
}
