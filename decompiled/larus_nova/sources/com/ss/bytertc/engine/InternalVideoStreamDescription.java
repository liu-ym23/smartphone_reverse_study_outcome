package com.ss.bytertc.engine;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class InternalVideoStreamDescription {
    public VideoEncoderPreference encodePreference;
    public int frameRate;
    public int height;
    public int maxKbps;
    public int minKbps;
    public int width;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.InternalVideoStreamDescription$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$CodecMode = null;
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference = null;
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$VideoCodecType = null;

        static {
            int[] r100 = new int[VideoStreamDescription.EncoderPreference.values().length];
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference = r100;
            r100[VideoStreamDescription.EncoderPreference.Disabled.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference[VideoStreamDescription.EncoderPreference.MaintainFramerate.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L36:
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference[VideoStreamDescription.EncoderPreference.MaintainQuality.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L46:
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference[VideoStreamDescription.EncoderPreference.Balance.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L9:
            int[] r101 = new int[VideoStreamDescription.VideoCodecType.values().length];
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$VideoCodecType = r101;
            r101[VideoStreamDescription.VideoCodecType.CODEC_TYPE_AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L32:
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$VideoCodecType[VideoStreamDescription.VideoCodecType.CODEC_TYPE_H264.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L34:
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$VideoCodecType[VideoStreamDescription.VideoCodecType.CODEC_TYPE_BYTEVC1.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L13:
            int[] r102 = new int[VideoStreamDescription.CodecMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$CodecMode = r102;
            r102[VideoStreamDescription.CodecMode.CODEC_MODE_AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L44:
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$CodecMode[VideoStreamDescription.CodecMode.CODEC_MODE_HARDWARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L28:
            $SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$CodecMode[VideoStreamDescription.CodecMode.CODEC_MODE_SOFTWARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public static final enum VideoCodecMode extends Enum<VideoCodecMode> {
        private static final /* synthetic */ VideoCodecMode[] $VALUES = null;
        public static final VideoCodecMode VIDEO_CODEC_MODE_AUTO = null;
        public static final VideoCodecMode VIDEO_CODEC_MODE_HARDWARE = null;
        public static final VideoCodecMode VIDEO_CODEC_MODE_SOFTWARE = null;
        private int value;

        static {
            VideoCodecMode r100 = new VideoCodecMode("VIDEO_CODEC_MODE_AUTO", 0, 0);
            VIDEO_CODEC_MODE_AUTO = r100;
            VideoCodecMode r101 = new VideoCodecMode("VIDEO_CODEC_MODE_HARDWARE", 1, 1);
            VIDEO_CODEC_MODE_HARDWARE = r101;
            VideoCodecMode r102 = new VideoCodecMode("VIDEO_CODEC_MODE_SOFTWARE", 2, 2);
            VIDEO_CODEC_MODE_SOFTWARE = r102;
            $VALUES = new VideoCodecMode[]{r100, r101, r102};
        }

        public static VideoCodecMode[] values() {
            return (VideoCodecMode[]) $VALUES.clone();
        }

        public int getIntValue() {
            return this.value;
        }

        public static VideoCodecMode valueOf(String r100) {
            return (VideoCodecMode) a.a(VideoCodecMode.class, r100);
        }

        private VideoCodecMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum VideoCodecType extends Enum<VideoCodecType> {
        private static final /* synthetic */ VideoCodecType[] $VALUES = null;
        public static final VideoCodecType VIDEO_CODEC_TYPE_AUTO = null;
        public static final VideoCodecType VIDEO_CODEC_TYPE_BYTEVC1 = null;
        public static final VideoCodecType VIDEO_CODEC_TYPE_H264 = null;
        private int value;

        static {
            VideoCodecType r100 = new VideoCodecType("VIDEO_CODEC_TYPE_AUTO", 0, 0);
            VIDEO_CODEC_TYPE_AUTO = r100;
            VideoCodecType r101 = new VideoCodecType("VIDEO_CODEC_TYPE_H264", 1, 1);
            VIDEO_CODEC_TYPE_H264 = r101;
            VideoCodecType r102 = new VideoCodecType("VIDEO_CODEC_TYPE_BYTEVC1", 2, 2);
            VIDEO_CODEC_TYPE_BYTEVC1 = r102;
            $VALUES = new VideoCodecType[]{r100, r101, r102};
        }

        public static VideoCodecType[] values() {
            return (VideoCodecType[]) $VALUES.clone();
        }

        public int getIntValue() {
            return this.value;
        }

        public static VideoCodecType valueOf(String r100) {
            return (VideoCodecType) a.a(VideoCodecType.class, r100);
        }

        private VideoCodecType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum VideoEncoderPreference extends Enum<VideoEncoderPreference> {
        private static final /* synthetic */ VideoEncoderPreference[] $VALUES = null;
        public static final VideoEncoderPreference VIDEO_ENCODER_PREFERENCE_BALANCE = null;
        public static final VideoEncoderPreference VIDEO_ENCODER_PREFERENCE_DISABLED = null;
        public static final VideoEncoderPreference VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE = null;
        public static final VideoEncoderPreference VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY = null;
        private int value;

        static {
            VideoEncoderPreference r100 = new VideoEncoderPreference("VIDEO_ENCODER_PREFERENCE_DISABLED", 0, 0);
            VIDEO_ENCODER_PREFERENCE_DISABLED = r100;
            VideoEncoderPreference r101 = new VideoEncoderPreference("VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE", 1, 1);
            VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE = r101;
            VideoEncoderPreference r102 = new VideoEncoderPreference("VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY", 2, 2);
            VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY = r102;
            VideoEncoderPreference r103 = new VideoEncoderPreference("VIDEO_ENCODER_PREFERENCE_BALANCE", 3, 3);
            VIDEO_ENCODER_PREFERENCE_BALANCE = r103;
            $VALUES = new VideoEncoderPreference[]{r100, r101, r102, r103};
        }

        public static VideoEncoderPreference[] values() {
            return (VideoEncoderPreference[]) $VALUES.clone();
        }

        public int getIntValue() {
            return this.value;
        }

        public static VideoEncoderPreference valueOf(String r100) {
            return (VideoEncoderPreference) a.a(VideoEncoderPreference.class, r100);
        }

        private VideoEncoderPreference(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public VideoEncoderPreference getEncoderPreference() {
        return this.encodePreference;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getHeight() {
        return this.height;
    }

    public int getMaxKBps() {
        return this.maxKbps;
    }

    public int getMinKBps() {
        return this.minKbps;
    }

    public int getWidth() {
        return this.width;
    }

    public InternalVideoStreamDescription(VideoStreamDescription r100) {
        this.minKbps = 0;
        this.encodePreference = VideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE;
        this.width = ((Integer) r100.videoSize.first).intValue();
        this.height = ((Integer) r100.videoSize.second).intValue();
        this.frameRate = r100.frameRate;
        this.maxKbps = r100.maxKbps;
        this.minKbps = r100.minKbps;
        this.encodePreference = ConvertEnumValue(r100.encodePreference);
    }

    private VideoEncoderPreference ConvertEnumValue(VideoStreamDescription.EncoderPreference r100) {
        VideoEncoderPreference r101 = VideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE;
        int r102 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$EncoderPreference[r100.ordinal()];
        if (r102 == 1) goto L14;
        if (r102 != 2) goto L7;
        return r101;
    L7:
        if (r102 == 3) goto L17;
        if (r102 == 4) goto L16;
        return r101;
    L16:
        return VideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_BALANCE;
    L17:
        return VideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY;
    L14:
        return VideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_DISABLED;
    }

    private VideoCodecMode ConvertEnumValue(VideoStreamDescription.CodecMode r100) {
        VideoCodecMode r101 = VideoCodecMode.VIDEO_CODEC_MODE_AUTO;
        int r102 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$CodecMode[r100.ordinal()];
        if (r102 == 1) goto L12;
        if (r102 == 2) goto L15;
        if (r102 == 3) goto L14;
        return VideoCodecMode.VIDEO_CODEC_MODE_AUTO;
    L14:
        return VideoCodecMode.VIDEO_CODEC_MODE_SOFTWARE;
    L15:
        return VideoCodecMode.VIDEO_CODEC_MODE_HARDWARE;
    L12:
        return VideoCodecMode.VIDEO_CODEC_MODE_AUTO;
    }

    private VideoCodecType ConvertEnumValue(VideoStreamDescription.VideoCodecType r100) {
        VideoCodecType r101 = VideoCodecType.VIDEO_CODEC_TYPE_AUTO;
        int r102 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$VideoStreamDescription$VideoCodecType[r100.ordinal()];
        if (r102 == 1) goto L12;
        if (r102 == 2) goto L15;
        if (r102 == 3) goto L14;
        return VideoCodecType.VIDEO_CODEC_TYPE_AUTO;
    L14:
        return VideoCodecType.VIDEO_CODEC_TYPE_BYTEVC1;
    L15:
        return VideoCodecType.VIDEO_CODEC_TYPE_H264;
    L12:
        return VideoCodecType.VIDEO_CODEC_TYPE_AUTO;
    }
}
