package androidx.camera.core;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ImageCaptureLatencyEstimate {
    public static final long UNDEFINED_CAPTURE_LATENCY = -1;
    public static final ImageCaptureLatencyEstimate UNDEFINED_IMAGE_CAPTURE_LATENCY = null;
    public static final long UNDEFINED_PROCESSING_LATENCY = -1;
    private final long mCaptureLatencyMillis;
    private final long mProcessingLatencyMillis;
    private final long mTotalCaptureLatencyMillis;

    private long computeTotalCaptureLatencyMillis(long r4, long r6) {
        if (r4 != (-1)) goto L5;
    L9:
        return -1;
    L5:
        if (r6 == (-1)) goto L9;
        return r4 + r6;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.mCaptureLatencyMillis), Long.valueOf(this.mProcessingLatencyMillis), Long.valueOf(this.mTotalCaptureLatencyMillis)});
    }

    static {
        UNDEFINED_IMAGE_CAPTURE_LATENCY = new ImageCaptureLatencyEstimate(-1, -1);
    }

    public String toString() {
        return "captureLatencyMillis=" + this.mCaptureLatencyMillis + ", processingLatencyMillis=" + this.mProcessingLatencyMillis + ", totalCaptureLatencyMillis=" + this.mTotalCaptureLatencyMillis;
    }

    public long getCaptureLatencyMillis() {
        return this.mCaptureLatencyMillis;
    }

    public long getProcessingLatencyMillis() {
        return this.mProcessingLatencyMillis;
    }

    public long getTotalCaptureLatencyMillis() {
        return this.mTotalCaptureLatencyMillis;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ImageCaptureLatencyEstimate) == true) goto L8;
        return false;
    L8:
        ImageCaptureLatencyEstimate r9 = (ImageCaptureLatencyEstimate) r8;
        if (this.mCaptureLatencyMillis == r9.getCaptureLatencyMillis()) goto L11;
    L15:
        return false;
    L11:
        if (this.mProcessingLatencyMillis != r9.getProcessingLatencyMillis()) goto L15;
        if (this.mTotalCaptureLatencyMillis != r9.getTotalCaptureLatencyMillis()) goto L15;
        return true;
    }

    public ImageCaptureLatencyEstimate(long r1, long r3) {
        this.mCaptureLatencyMillis = r1;
        this.mProcessingLatencyMillis = r3;
        this.mTotalCaptureLatencyMillis = computeTotalCaptureLatencyMillis(r1, r3);
    }
}
