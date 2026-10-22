package androidx.camera.video.internal.encoder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class VideoEncoderDataSpace {
    public static final VideoEncoderDataSpace ENCODER_DATA_SPACE_BT2020_HLG = null;
    public static final VideoEncoderDataSpace ENCODER_DATA_SPACE_BT2020_PQ = null;
    public static final VideoEncoderDataSpace ENCODER_DATA_SPACE_BT709 = null;
    public static final VideoEncoderDataSpace ENCODER_DATA_SPACE_UNSPECIFIED = null;
    public static final int VIDEO_COLOR_RANGE_UNSPECIFIED = 0;
    public static final int VIDEO_COLOR_STANDARD_UNSPECIFIED = 0;
    public static final int VIDEO_COLOR_TRANSFER_UNSPECIFIED = 0;

    static {
        ENCODER_DATA_SPACE_UNSPECIFIED = create(0, 0, 0);
        ENCODER_DATA_SPACE_BT709 = create(1, 3, 2);
        ENCODER_DATA_SPACE_BT2020_HLG = create(6, 7, 1);
        ENCODER_DATA_SPACE_BT2020_PQ = create(6, 6, 1);
    }

    public abstract int getRange();

    public abstract int getStandard();

    public abstract int getTransfer();

    public VideoEncoderDataSpace() {
    }

    public static VideoEncoderDataSpace create(int r1, int r2, int r3) {
        return new AutoValue_VideoEncoderDataSpace(r1, r2, r3);
    }
}
