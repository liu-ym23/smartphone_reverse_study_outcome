package androidx.camera.video.internal.encoder;

import android.util.Range;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface VideoEncoderInfo extends EncoderInfo {

    /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.VideoEncoderInfo$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isSizeSupportedAllowSwapping(VideoEncoderInfo r1, int r2, int r3) {
            if (r1.isSizeSupported(r2, r3) == false) goto L5;
        L10:
            return true;
        L5:
            if (r1.canSwapWidthHeight() == true) goto L7;
        L9:
            return false;
        L7:
            if (r1.isSizeSupported(r3, r2) == false) goto L9;
            goto L9
        }
    }

    boolean canSwapWidthHeight();

    int getHeightAlignment();

    Range<Integer> getSupportedBitrateRange();

    Range<Integer> getSupportedHeights();

    Range<Integer> getSupportedHeightsFor(int r1);

    Range<Integer> getSupportedWidths();

    Range<Integer> getSupportedWidthsFor(int r1);

    int getWidthAlignment();

    boolean isSizeSupported(int r1, int r2);

    boolean isSizeSupportedAllowSwapping(int r1, int r2);
}
