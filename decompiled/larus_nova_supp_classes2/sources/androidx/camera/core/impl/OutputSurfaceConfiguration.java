package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class OutputSurfaceConfiguration {
    public OutputSurfaceConfiguration() {
    }

    public abstract OutputSurface getImageAnalysisOutputSurface();

    public abstract OutputSurface getImageCaptureOutputSurface();

    public abstract OutputSurface getPostviewOutputSurface();

    public abstract OutputSurface getPreviewOutputSurface();

    public static OutputSurfaceConfiguration create(OutputSurface r1, OutputSurface r2, OutputSurface r3, OutputSurface r4) {
        return new AutoValue_OutputSurfaceConfiguration(r1, r2, r3, r4);
    }
}
