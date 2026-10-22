package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.core.util.Supplier;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class VideoEncoderConfigDefaultResolver implements Supplier<VideoEncoderConfig> {
    private static final String TAG = "VidEncCfgDefaultRslvr";
    private static final Range<Integer> VALID_FRAME_RATE_RANGE = null;
    private static final int VIDEO_BITRATE_BASE = 14000000;
    private static final int VIDEO_BIT_DEPTH_BASE = 8;
    private static final int VIDEO_FRAME_RATE_BASE = 30;
    static final int VIDEO_FRAME_RATE_FIXED_DEFAULT = 30;
    private static final Size VIDEO_SIZE_BASE = null;
    private final DynamicRange mDynamicRange;
    private final Range<Integer> mExpectedFrameRateRange;
    private final Timebase mInputTimebase;
    private final String mMimeType;
    private final Size mSurfaceSize;
    private final VideoSpec mVideoSpec;

    static {
        VIDEO_SIZE_BASE = new Size(1280, 720);
        VALID_FRAME_RATE_RANGE = new Range(1, 60);
    }

    private int resolveFrameRate() {
        Range<Integer> r0 = this.mExpectedFrameRateRange;
        Range<Integer> r1 = SurfaceRequest.FRAME_RATE_RANGE_UNSPECIFIED;
        if (Objects.equals(r0, r1) == true) goto L5;
        int r2 = ((Integer) VALID_FRAME_RATE_RANGE.clamp((Integer) this.mExpectedFrameRateRange.getUpper())).intValue();
    L6:
        Object[] r3 = new Object[2];
        r3[0] = Integer.valueOf(r2);
        if (Objects.equals(this.mExpectedFrameRateRange, r1) == false) goto L9;
        Object r4 = this.mExpectedFrameRateRange;
    L10:
        r3[1] = r4;
        Logger.d(TAG, String.format("Default resolved frame rate: %dfps. [Expected operating range: %s]", r3));
        return r2;
    L9:
        r4 = "<UNSPECIFIED>";
        goto L10
    L5:
        r2 = 30;
        goto L6
    }

    public VideoEncoderConfig get() {
        int r10 = resolveFrameRate();
        Logger.d(TAG, "Resolved VIDEO frame rate: " + r10 + "fps");
        Range<Integer> r9 = this.mVideoSpec.getBitrate();
        Logger.d(TAG, "Using fallback VIDEO bitrate");
        int r1 = this.mDynamicRange.getBitDepth();
        int r5 = this.mSurfaceSize.getWidth();
        Size r3 = VIDEO_SIZE_BASE;
        int r0 = VideoConfigUtil.scaleAndClampBitrate(VIDEO_BITRATE_BASE, r1, 8, r10, 30, r5, r3.getWidth(), this.mSurfaceSize.getHeight(), r3.getHeight(), r9);
        int r2 = DynamicRangeUtil.dynamicRangeToCodecProfileLevelForMime(this.mMimeType, this.mDynamicRange);
        return VideoEncoderConfig.builder().setMimeType(this.mMimeType).setInputTimebase(this.mInputTimebase).setResolution(this.mSurfaceSize).setBitrate(r0).setFrameRate(r10).setProfile(r2).setDataSpace(VideoConfigUtil.mimeAndProfileToEncoderDataSpace(this.mMimeType, r2)).build();
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m79get() {
        return get();
    }

    public VideoEncoderConfigDefaultResolver(String r1, Timebase r2, VideoSpec r3, Size r4, DynamicRange r5, Range<Integer> r6) {
        this.mMimeType = r1;
        this.mInputTimebase = r2;
        this.mVideoSpec = r3;
        this.mSurfaceSize = r4;
        this.mDynamicRange = r5;
        this.mExpectedFrameRateRange = r6;
    }
}
