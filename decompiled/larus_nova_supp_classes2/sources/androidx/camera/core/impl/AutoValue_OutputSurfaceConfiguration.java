package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_OutputSurfaceConfiguration extends OutputSurfaceConfiguration {
    private final OutputSurface imageAnalysisOutputSurface;
    private final OutputSurface imageCaptureOutputSurface;
    private final OutputSurface postviewOutputSurface;
    private final OutputSurface previewOutputSurface;

    public int hashCode() {
        int r0 = (((this.previewOutputSurface.hashCode() ^ 1000003) * 1000003) ^ this.imageCaptureOutputSurface.hashCode()) * 1000003;
        OutputSurface r2 = this.imageAnalysisOutputSurface;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r1 = (r0 ^ r4) * 1000003;
        OutputSurface r5 = this.postviewOutputSurface;
        if (r5 == null) goto L11;
        r3 = r5.hashCode();
    L11:
        return r1 ^ r3;
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "OutputSurfaceConfiguration{previewOutputSurface=" + this.previewOutputSurface + ", imageCaptureOutputSurface=" + this.imageCaptureOutputSurface + ", imageAnalysisOutputSurface=" + this.imageAnalysisOutputSurface + ", postviewOutputSurface=" + this.postviewOutputSurface + "}";
    }

    @Override // androidx.camera.core.impl.OutputSurfaceConfiguration
    public OutputSurface getImageAnalysisOutputSurface() {
        return this.imageAnalysisOutputSurface;
    }

    @Override // androidx.camera.core.impl.OutputSurfaceConfiguration
    public OutputSurface getImageCaptureOutputSurface() {
        return this.imageCaptureOutputSurface;
    }

    @Override // androidx.camera.core.impl.OutputSurfaceConfiguration
    public OutputSurface getPostviewOutputSurface() {
        return this.postviewOutputSurface;
    }

    @Override // androidx.camera.core.impl.OutputSurfaceConfiguration
    public OutputSurface getPreviewOutputSurface() {
        return this.previewOutputSurface;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof OutputSurfaceConfiguration) == false) goto L28;
        OutputSurfaceConfiguration r6 = (OutputSurfaceConfiguration) r5;
        if (this.previewOutputSurface.equals(r6.getPreviewOutputSurface()) == true) goto L10;
    L26:
        return false;
    L10:
        if (this.imageCaptureOutputSurface.equals(r6.getImageCaptureOutputSurface()) == false) goto L26;
        OutputSurface r1 = this.imageAnalysisOutputSurface;
        if (r1 != null) goto L17;
        if (r6.getImageAnalysisOutputSurface() != null) goto L26;
    L18:
        OutputSurface r2 = this.postviewOutputSurface;
        if (r2 != null) goto L24;
        if (r6.getPostviewOutputSurface() != null) goto L26;
        return true;
    L24:
        if (r2.equals(r6.getPostviewOutputSurface()) == false) goto L26;
        return true;
    L17:
        if (r1.equals(r6.getImageAnalysisOutputSurface()) == false) goto L26;
    L28:
        return false;
    }

    public AutoValue_OutputSurfaceConfiguration(OutputSurface r1, OutputSurface r2, OutputSurface r3, OutputSurface r4) {
        if (r1 == null) goto L11;
        this.previewOutputSurface = r1;
        if (r2 == null) goto L9;
        this.imageCaptureOutputSurface = r2;
        this.imageAnalysisOutputSurface = r3;
        this.postviewOutputSurface = r4;
        return;
    L9:
        throw new NullPointerException("Null imageCaptureOutputSurface");
    L11:
        throw new NullPointerException("Null previewOutputSurface");
    }
}
