package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.arch.core.util.Function;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.utils.CodecUtil;
import androidx.camera.video.internal.workaround.VideoEncoderInfoWrapper;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class VideoEncoderInfoImpl extends EncoderInfoImpl implements VideoEncoderInfo {
    public static final Function<VideoEncoderConfig, VideoEncoderInfo> FINDER = null;
    private static final String TAG = "VideoEncoderInfoImpl";
    private final MediaCodecInfo.VideoCapabilities mVideoCapabilities;

    public static /* synthetic */ VideoEncoderInfo a(VideoEncoderConfig r0) {
        return lambda$static$0(r0);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean canSwapWidthHeight() {
        return true;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public final /* synthetic */ boolean isSizeSupportedAllowSwapping(int r1, int r2) {
        return VideoEncoderInfo.CC.$default$isSizeSupportedAllowSwapping(this, r1, r2);
    }

    static {
        FINDER = new r0();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.mVideoCapabilities.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedBitrateRange() {
        return this.mVideoCapabilities.getBitrateRange();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeights() {
        return this.mVideoCapabilities.getSupportedHeights();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidths() {
        return this.mVideoCapabilities.getSupportedWidths();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.mVideoCapabilities.getWidthAlignment();
    }

    public static VideoEncoderInfoImpl from(VideoEncoderConfig r2) throws InvalidConfigException {
        return new VideoEncoderInfoImpl(CodecUtil.findCodecAndGetCodecInfo(r2), r2.getMimeType());
    }

    private static /* synthetic */ VideoEncoderInfo lambda$static$0(VideoEncoderConfig r3) {
        return VideoEncoderInfoWrapper.from(from(r3), null);
    L5:
        e = move-exception;
        Logger.w(TAG, "Unable to find a VideoEncoderInfoImpl", e);
        return null;
    }

    private static IllegalArgumentException toIllegalArgumentException(Throwable r1) {
        if ((r1 instanceof IllegalArgumentException) == false) goto L7;
        return (IllegalArgumentException) r1;
    L7:
        return new IllegalArgumentException(r1);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedHeightsFor(int r2) {
        return this.mVideoCapabilities.getSupportedHeightsFor(r2);
    L4:
        th = move-exception;
        throw toIllegalArgumentException(th);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public Range<Integer> getSupportedWidthsFor(int r2) {
        return this.mVideoCapabilities.getSupportedWidthsFor(r2);
    L4:
        th = move-exception;
        throw toIllegalArgumentException(th);
    }

    public VideoEncoderInfoImpl(MediaCodecInfo r1, String r2) throws InvalidConfigException {
        super(r1, r2);
        MediaCodecInfo.VideoCapabilities r3 = this.mCodecCapabilities.getVideoCapabilities();
        Objects.requireNonNull(r3);
        this.mVideoCapabilities = r3;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int r2, int r3) {
        return this.mVideoCapabilities.isSizeSupported(r2, r3);
    }
}
