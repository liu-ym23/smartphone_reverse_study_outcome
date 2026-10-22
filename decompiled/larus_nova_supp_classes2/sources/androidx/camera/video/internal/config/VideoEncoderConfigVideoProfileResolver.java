package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.core.util.Supplier;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class VideoEncoderConfigVideoProfileResolver implements Supplier<VideoEncoderConfig> {
    private static final String TAG = "VidEncVdPrflRslvr";
    private final DynamicRange mDynamicRange;
    private final Range<Integer> mExpectedFrameRateRange;
    private final Timebase mInputTimebase;
    private final String mMimeType;
    private final Size mSurfaceSize;
    private final EncoderProfilesProxy.VideoProfileProxy mVideoProfile;
    private final VideoSpec mVideoSpec;

    private int resolveFrameRate() {
        int r0 = this.mVideoProfile.getFrameRate();
        Range<Integer> r1 = this.mExpectedFrameRateRange;
        Range<Integer> r2 = SurfaceRequest.FRAME_RATE_RANGE_UNSPECIFIED;
        if (Objects.equals(r1, r2) == true) goto L5;
        int r3 = ((Integer) this.mExpectedFrameRateRange.clamp(Integer.valueOf(r0))).intValue();
    L6:
        Object[] r4 = new Object[3];
        r4[0] = Integer.valueOf(r3);
        r4[1] = Integer.valueOf(r0);
        if (Objects.equals(this.mExpectedFrameRateRange, r2) == false) goto L9;
        Object r5 = this.mExpectedFrameRateRange;
    L10:
        r4[2] = r5;
        Logger.d(TAG, String.format("Resolved frame rate %dfps [Video profile frame rate: %dfps, Expected operating range: %s]", r4));
        return r3;
    L9:
        r5 = "<UNSPECIFIED>";
        goto L10
    L5:
        r3 = r0;
        goto L6
    }

    public VideoEncoderConfig get() {
        int r10 = resolveFrameRate();
        Logger.d(TAG, "Resolved VIDEO frame rate: " + r10 + "fps");
        Range<Integer> r9 = this.mVideoSpec.getBitrate();
        Logger.d(TAG, "Using resolved VIDEO bitrate from EncoderProfiles");
        int r0 = VideoConfigUtil.scaleAndClampBitrate(this.mVideoProfile.getBitrate(), this.mDynamicRange.getBitDepth(), this.mVideoProfile.getBitDepth(), r10, this.mVideoProfile.getFrameRate(), this.mSurfaceSize.getWidth(), this.mVideoProfile.getWidth(), this.mSurfaceSize.getHeight(), this.mVideoProfile.getHeight(), r9);
        int r1 = this.mVideoProfile.getProfile();
        return VideoEncoderConfig.builder().setMimeType(this.mMimeType).setInputTimebase(this.mInputTimebase).setResolution(this.mSurfaceSize).setBitrate(r0).setFrameRate(r10).setProfile(r1).setDataSpace(VideoConfigUtil.mimeAndProfileToEncoderDataSpace(this.mMimeType, r1)).build();
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m80get() {
        return get();
    }

    public VideoEncoderConfigVideoProfileResolver(String r1, Timebase r2, VideoSpec r3, Size r4, EncoderProfilesProxy.VideoProfileProxy r5, DynamicRange r6, Range<Integer> r7) {
        this.mMimeType = r1;
        this.mInputTimebase = r2;
        this.mVideoSpec = r3;
        this.mSurfaceSize = r4;
        this.mVideoProfile = r5;
        this.mDynamicRange = r6;
        this.mExpectedFrameRateRange = r7;
    }
}
