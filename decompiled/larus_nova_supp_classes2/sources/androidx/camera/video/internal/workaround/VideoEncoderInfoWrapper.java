package androidx.camera.video.internal.workaround;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.core.util.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class VideoEncoderInfoWrapper implements VideoEncoderInfo {
    private static final int HEIGHT_4KDCI = 2160;
    private static final String TAG = "VideoEncoderInfoWrapper";
    private static final int WIDTH_4KDCI = 4096;
    private final Set<Size> mExtraSupportedSizes;
    private final Range<Integer> mSupportedHeights;
    private final Range<Integer> mSupportedWidths;
    private final VideoEncoderInfo mVideoEncoderInfo;

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public final /* synthetic */ boolean isSizeSupportedAllowSwapping(int r1, int r2) {
        return VideoEncoderInfo.CC.$default$isSizeSupportedAllowSwapping(this, r1, r2);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean canSwapWidthHeight() {
        return this.mVideoEncoderInfo.canSwapWidthHeight();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.mVideoEncoderInfo.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    public String getName() {
        return this.mVideoEncoderInfo.getName();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedBitrateRange() {
        return this.mVideoEncoderInfo.getSupportedBitrateRange();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.mVideoEncoderInfo.getWidthAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeights() {
        return this.mSupportedHeights;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidths() {
        return this.mSupportedWidths;
    }

    private VideoEncoderInfoWrapper(VideoEncoderInfo r7) {
        HashSet r0 = new HashSet();
        this.mExtraSupportedSizes = r0;
        this.mVideoEncoderInfo = r7;
        int r1 = r7.getWidthAlignment();
        int r2 = ((int) Math.ceil(4096.0d / ((double) r1))) * r1;
        this.mSupportedWidths = Range.create(Integer.valueOf(r1), Integer.valueOf(r2));
        int r8 = r7.getHeightAlignment();
        int r3 = ((int) Math.ceil(2160.0d / ((double) r8))) * r8;
        this.mSupportedHeights = Range.create(Integer.valueOf(r8), Integer.valueOf(r3));
        r0.addAll(MediaCodecInfoReportIncorrectInfoQuirk.getExtraSupportedSizes());
    }

    private void addExtraSupportedSize(Size r2) {
        this.mExtraSupportedSizes.add(r2);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeightsFor(int r4) {
        if (this.mSupportedWidths.contains(Integer.valueOf(r4)) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "Not supported width: " + r4 + " which is not in " + this.mSupportedWidths + " or can not be divided by alignment " + this.mVideoEncoderInfo.getWidthAlignment());
        return this.mSupportedHeights;
    L5:
        if ((r4 % this.mVideoEncoderInfo.getWidthAlignment()) != 0) goto L7;
        r0 = true;
        goto L8
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidthsFor(int r4) {
        if (this.mSupportedHeights.contains(Integer.valueOf(r4)) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "Not supported height: " + r4 + " which is not in " + this.mSupportedHeights + " or can not be divided by alignment " + this.mVideoEncoderInfo.getHeightAlignment());
        return this.mSupportedWidths;
    L5:
        if ((r4 % this.mVideoEncoderInfo.getHeightAlignment()) != 0) goto L7;
        r0 = true;
        goto L8
    }

    public static VideoEncoderInfo from(VideoEncoderInfo r4, Size r5) {
        boolean r1 = false;
        if ((r4 instanceof VideoEncoderInfoWrapper) == false) goto L6;
    L12:
        if (r1 == false) goto L14;
        r4 = new VideoEncoderInfoWrapper(r4);
    L14:
        if (r5 != null) goto L16;
    L18:
        return r4;
    L16:
        if ((r4 instanceof VideoEncoderInfoWrapper) == false) goto L18;
        ((VideoEncoderInfoWrapper) r4).addExtraSupportedSize(r5);
        goto L18
    L6:
        if (DeviceQuirks.get(MediaCodecInfoReportIncorrectInfoQuirk.class) == null) goto L8;
    L7:
        r1 = true;
        goto L12
    L8:
        if (r5 == null) goto L12;
        if (r4.isSizeSupportedAllowSwapping(r5.getWidth(), r5.getHeight()) == true) goto L12;
        Logger.w(TAG, String.format("Detected that the device does not support a size %s that should be valid in widths/heights = %s/%s", new Object[]{r5, r4.getSupportedWidths(), r4.getSupportedHeights()}));
        goto L7
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int r5, int r6) {
        if (this.mVideoEncoderInfo.isSizeSupported(r5, r6) == false) goto L5;
        return true;
    L5:
        Iterator<Size> r0 = this.mExtraSupportedSizes.iterator();
    L7:
        if (r0.hasNext() == false) goto L14;
        Size r2 = r0.next();
        if (r2.getWidth() != r5) goto L7;
        if (r2.getHeight() != r6) goto L7;
        return true;
    L14:
        if (this.mSupportedWidths.contains(Integer.valueOf(r5)) == true) goto L16;
    L22:
        return false;
    L16:
        if (this.mSupportedHeights.contains(Integer.valueOf(r6)) == false) goto L22;
        if ((r5 % this.mVideoEncoderInfo.getWidthAlignment()) != 0) goto L22;
        if ((r6 % this.mVideoEncoderInfo.getHeightAlignment()) != 0) goto L22;
        return true;
    }
}
