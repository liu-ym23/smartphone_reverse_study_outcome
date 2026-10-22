package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_SupportedSurfaceCombination_FeatureSettings extends SupportedSurfaceCombination.FeatureSettings {
    private final int cameraMode;
    private final boolean previewStabilizationOn;
    private final int requiredMaxBitDepth;
    private final boolean ultraHdrOn;

    public int hashCode() {
        int r0 = (((this.cameraMode ^ 1000003) * 1000003) ^ this.requiredMaxBitDepth) * 1000003;
        int r3 = 1231;
        if (this.previewStabilizationOn == false) goto L5;
        int r2 = 1231;
    L6:
        int r1 = (r0 ^ r2) * 1000003;
        if (this.ultraHdrOn == true) goto L11;
        r3 = 1237;
    L11:
        return r1 ^ r3;
    L5:
        r2 = 1237;
        goto L6
    }

    public String toString() {
        return "FeatureSettings{cameraMode=" + this.cameraMode + ", requiredMaxBitDepth=" + this.requiredMaxBitDepth + ", previewStabilizationOn=" + this.previewStabilizationOn + ", ultraHdrOn=" + this.ultraHdrOn + "}";
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public int getCameraMode() {
        return this.cameraMode;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public int getRequiredMaxBitDepth() {
        return this.requiredMaxBitDepth;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public boolean isPreviewStabilizationOn() {
        return this.previewStabilizationOn;
    }

    @Override // androidx.camera.camera2.internal.SupportedSurfaceCombination.FeatureSettings
    public boolean isUltraHdrOn() {
        return this.ultraHdrOn;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SupportedSurfaceCombination.FeatureSettings) == false) goto L18;
        SupportedSurfaceCombination.FeatureSettings r6 = (SupportedSurfaceCombination.FeatureSettings) r5;
        if (this.cameraMode == r6.getCameraMode()) goto L10;
    L16:
        return false;
    L10:
        if (this.requiredMaxBitDepth != r6.getRequiredMaxBitDepth()) goto L16;
        if (this.previewStabilizationOn != r6.isPreviewStabilizationOn()) goto L16;
        if (this.ultraHdrOn != r6.isUltraHdrOn()) goto L16;
        return true;
    L18:
        return false;
    }

    public AutoValue_SupportedSurfaceCombination_FeatureSettings(int r1, int r2, boolean r3, boolean r4) {
        this.cameraMode = r1;
        this.requiredMaxBitDepth = r2;
        this.previewStabilizationOn = r3;
        this.ultraHdrOn = r4;
    }
}
