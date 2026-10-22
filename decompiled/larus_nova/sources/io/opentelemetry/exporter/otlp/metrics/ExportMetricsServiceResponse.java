package io.opentelemetry.exporter.otlp.metrics;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
final enum ExportMetricsServiceResponse extends Enum<ExportMetricsServiceResponse> {
    public static final ExportMetricsServiceResponse INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExportMetricsServiceResponse[] f492703a = null;

    static {
        ExportMetricsServiceResponse r100 = new ExportMetricsServiceResponse();
        INSTANCE = r100;
        f492703a = new ExportMetricsServiceResponse[]{r100};
    }

    public ExportMetricsServiceResponse() {
        super("INSTANCE", 0);
    }

    public static ExportMetricsServiceResponse[] values() {
        return (ExportMetricsServiceResponse[]) f492703a.clone();
    }

    public static ExportMetricsServiceResponse valueOf(String r100) {
        return (ExportMetricsServiceResponse) a.a(ExportMetricsServiceResponse.class, r100);
    }
}
