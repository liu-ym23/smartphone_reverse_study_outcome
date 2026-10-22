package androidx.camera.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_ImageReaderFormatRecommender_FormatCombo extends ImageReaderFormatRecommender.FormatCombo {
    private final int imageAnalysisFormat;
    private final int imageCaptureFormat;

    public int hashCode() {
        return ((this.imageCaptureFormat ^ 1000003) * 1000003) ^ this.imageAnalysisFormat;
    }

    public String toString() {
        return "FormatCombo{imageCaptureFormat=" + this.imageCaptureFormat + ", imageAnalysisFormat=" + this.imageAnalysisFormat + "}";
    }

    @Override // androidx.camera.core.ImageReaderFormatRecommender.FormatCombo
    public int imageAnalysisFormat() {
        return this.imageAnalysisFormat;
    }

    @Override // androidx.camera.core.ImageReaderFormatRecommender.FormatCombo
    public int imageCaptureFormat() {
        return this.imageCaptureFormat;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageReaderFormatRecommender.FormatCombo) == false) goto L14;
        ImageReaderFormatRecommender.FormatCombo r6 = (ImageReaderFormatRecommender.FormatCombo) r5;
        if (this.imageCaptureFormat == r6.imageCaptureFormat()) goto L10;
    L12:
        return false;
    L10:
        if (this.imageAnalysisFormat != r6.imageAnalysisFormat()) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_ImageReaderFormatRecommender_FormatCombo(int r1, int r2) {
        this.imageCaptureFormat = r1;
        this.imageAnalysisFormat = r2;
    }
}
