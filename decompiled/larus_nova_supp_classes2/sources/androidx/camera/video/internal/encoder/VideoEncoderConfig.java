package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import android.util.Size;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class VideoEncoderConfig implements EncoderConfig {
    private static final int VIDEO_COLOR_FORMAT_DEFAULT = 2130708361;
    private static final int VIDEO_INTRA_FRAME_INTERVAL_DEFAULT = 1;

    public static abstract class Builder {
        public abstract VideoEncoderConfig build();

        public abstract Builder setBitrate(int r1);

        public abstract Builder setColorFormat(int r1);

        public abstract Builder setDataSpace(VideoEncoderDataSpace r1);

        public abstract Builder setFrameRate(int r1);

        public abstract Builder setIFrameInterval(int r1);

        public abstract Builder setInputTimebase(Timebase r1);

        public abstract Builder setMimeType(String r1);

        public abstract Builder setProfile(int r1);

        public abstract Builder setResolution(Size r1);

        public Builder() {
        }
    }

    public abstract int getBitrate();

    public abstract int getColorFormat();

    public abstract VideoEncoderDataSpace getDataSpace();

    public abstract int getFrameRate();

    public abstract int getIFrameInterval();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract Timebase getInputTimebase();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract String getMimeType();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract int getProfile();

    public abstract Size getResolution();

    public static Builder builder() {
        return new AutoValue_VideoEncoderConfig.Builder().setProfile(-1).setIFrameInterval(1).setColorFormat(VIDEO_COLOR_FORMAT_DEFAULT).setDataSpace(VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED);
    }

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public MediaFormat toMediaFormat() {
        Size r0 = getResolution();
        MediaFormat r1 = MediaFormat.createVideoFormat(getMimeType(), r0.getWidth(), r0.getHeight());
        r1.setInteger("color-format", getColorFormat());
        r1.setInteger("bitrate", getBitrate());
        r1.setInteger("frame-rate", getFrameRate());
        r1.setInteger("i-frame-interval", getIFrameInterval());
        if (getProfile() == (-1)) goto L5;
        r1.setInteger("profile", getProfile());
    L5:
        VideoEncoderDataSpace r2 = getDataSpace();
        if (r2.getStandard() == 0) goto L9;
        r1.setInteger("color-standard", r2.getStandard());
    L9:
        if (r2.getTransfer() == 0) goto L12;
        r1.setInteger("color-transfer", r2.getTransfer());
    L12:
        if (r2.getRange() == 0) goto L14;
        r1.setInteger("color-range", r2.getRange());
    L14:
        return r1;
    }

    public VideoEncoderConfig() {
    }
}
