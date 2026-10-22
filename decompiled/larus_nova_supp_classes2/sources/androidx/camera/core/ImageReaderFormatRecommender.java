package androidx.camera.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ImageReaderFormatRecommender {

    public static abstract class FormatCombo {
        public FormatCombo() {
        }

        public abstract int imageAnalysisFormat();

        public abstract int imageCaptureFormat();

        public static FormatCombo create(int r1, int r2) {
            return new AutoValue_ImageReaderFormatRecommender_FormatCombo(r1, r2);
        }
    }

    public static FormatCombo chooseCombo() {
        return FormatCombo.create(256, 35);
    }

    private ImageReaderFormatRecommender() {
    }
}
