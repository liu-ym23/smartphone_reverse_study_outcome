package io.opentelemetry.exporter.otlp.trace;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
final enum ExportTraceServiceResponse extends Enum<ExportTraceServiceResponse> {
    public static final ExportTraceServiceResponse INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExportTraceServiceResponse[] f492704a = null;

    static {
        ExportTraceServiceResponse r100 = new ExportTraceServiceResponse();
        INSTANCE = r100;
        f492704a = new ExportTraceServiceResponse[]{r100};
    }

    public ExportTraceServiceResponse() {
        super("INSTANCE", 0);
    }

    public static ExportTraceServiceResponse[] values() {
        return (ExportTraceServiceResponse[]) f492704a.clone();
    }

    public static ExportTraceServiceResponse valueOf(String r100) {
        return (ExportTraceServiceResponse) a.a(ExportTraceServiceResponse.class, r100);
    }
}
