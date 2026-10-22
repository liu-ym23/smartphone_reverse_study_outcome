package com.ss.bytertc.engine;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class InternalVideoEncoderConfig {
    public InternalVideoEncoderPreference encodePreference;
    public int frameRate;
    public int height;
    public int maxBitrate;
    public int minBitrate;
    public int width;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.InternalVideoEncoderConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$CodecMode = null;
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$EncoderPreference = null;
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$VideoCodecType = null;

        static {
            int[] r100 = new int[VideoEncoderConfig.EncoderPreference.values().length];
            $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$EncoderPreference = r100;
            r100[VideoEncoderConfig.EncoderPreference.DISABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$EncoderPreference[VideoEncoderConfig.EncoderPreference.MAINTAIN_FRAMERATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L36:
            $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$EncoderPreference[VideoEncoderConfig.EncoderPreference.MAINTAIN_QUALITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L46:
            $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$EncoderPreference[VideoEncoderConfig.EncoderPreference.AUTO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L9:
            int[] r101 = new int[VideoEncoderConfig.VideoCodecType.values().length];
            $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$VideoCodecType = r101;
            r101[VideoEncoderConfig.VideoCodecType.CODEC_TYPE_AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L32:
            $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$VideoCodecType[VideoEncoderConfig.VideoCodecType.CODEC_TYPE_H264.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L34:
            $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$VideoCodecType[VideoEncoderConfig.VideoCodecType.CODEC_TYPE_BYTEVC1.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L13:
            int[] r102 = new int[VideoEncoderConfig.CodecMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$CodecMode = r102;
            r102[VideoEncoderConfig.CodecMode.CODEC_MODE_AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L44:
            $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$CodecMode[VideoEncoderConfig.CodecMode.CODEC_MODE_HARDWARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L28:
            $SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$CodecMode[VideoEncoderConfig.CodecMode.CODEC_MODE_SOFTWARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public static final enum InternalVideoCodecMode extends Enum<InternalVideoCodecMode> {
        private static final /* synthetic */ InternalVideoCodecMode[] $VALUES = null;
        public static final InternalVideoCodecMode VIDEO_CODEC_MODE_AUTO = null;
        public static final InternalVideoCodecMode VIDEO_CODEC_MODE_HARDWARE = null;
        public static final InternalVideoCodecMode VIDEO_CODEC_MODE_SOFTWARE = null;
        private int value;

        static {
            InternalVideoCodecMode r100 = new InternalVideoCodecMode("VIDEO_CODEC_MODE_AUTO", 0, 0);
            VIDEO_CODEC_MODE_AUTO = r100;
            InternalVideoCodecMode r101 = new InternalVideoCodecMode("VIDEO_CODEC_MODE_HARDWARE", 1, 1);
            VIDEO_CODEC_MODE_HARDWARE = r101;
            InternalVideoCodecMode r102 = new InternalVideoCodecMode("VIDEO_CODEC_MODE_SOFTWARE", 2, 2);
            VIDEO_CODEC_MODE_SOFTWARE = r102;
            $VALUES = new InternalVideoCodecMode[]{r100, r101, r102};
        }

        public static InternalVideoCodecMode[] values() {
            return (InternalVideoCodecMode[]) $VALUES.clone();
        }

        public int getIntValue() {
            return this.value;
        }

        public static InternalVideoCodecMode valueOf(String r100) {
            return (InternalVideoCodecMode) a.a(InternalVideoCodecMode.class, r100);
        }

        private InternalVideoCodecMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum InternalVideoCodecType extends Enum<InternalVideoCodecType> {
        private static final /* synthetic */ InternalVideoCodecType[] $VALUES = null;
        public static final InternalVideoCodecType VIDEO_CODEC_TYPE_AUTO = null;
        public static final InternalVideoCodecType VIDEO_CODEC_TYPE_BYTEVC1 = null;
        public static final InternalVideoCodecType VIDEO_CODEC_TYPE_H264 = null;
        private int value;

        static {
            InternalVideoCodecType r100 = new InternalVideoCodecType("VIDEO_CODEC_TYPE_AUTO", 0, 0);
            VIDEO_CODEC_TYPE_AUTO = r100;
            InternalVideoCodecType r101 = new InternalVideoCodecType("VIDEO_CODEC_TYPE_H264", 1, 1);
            VIDEO_CODEC_TYPE_H264 = r101;
            InternalVideoCodecType r102 = new InternalVideoCodecType("VIDEO_CODEC_TYPE_BYTEVC1", 2, 2);
            VIDEO_CODEC_TYPE_BYTEVC1 = r102;
            $VALUES = new InternalVideoCodecType[]{r100, r101, r102};
        }

        public static InternalVideoCodecType[] values() {
            return (InternalVideoCodecType[]) $VALUES.clone();
        }

        public int getIntValue() {
            return this.value;
        }

        public static InternalVideoCodecType valueOf(String r100) {
            return (InternalVideoCodecType) a.a(InternalVideoCodecType.class, r100);
        }

        private InternalVideoCodecType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum InternalVideoEncoderPreference extends Enum<InternalVideoEncoderPreference> {
        private static final /* synthetic */ InternalVideoEncoderPreference[] $VALUES = null;
        public static final InternalVideoEncoderPreference VIDEO_ENCODER_PREFERENCE_AUTO = null;
        public static final InternalVideoEncoderPreference VIDEO_ENCODER_PREFERENCE_DISABLED = null;
        public static final InternalVideoEncoderPreference VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE = null;
        public static final InternalVideoEncoderPreference VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY = null;
        private int value;

        static {
            InternalVideoEncoderPreference r100 = new InternalVideoEncoderPreference("VIDEO_ENCODER_PREFERENCE_DISABLED", 0, 0);
            VIDEO_ENCODER_PREFERENCE_DISABLED = r100;
            InternalVideoEncoderPreference r101 = new InternalVideoEncoderPreference("VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE", 1, 1);
            VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE = r101;
            InternalVideoEncoderPreference r102 = new InternalVideoEncoderPreference("VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY", 2, 2);
            VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY = r102;
            InternalVideoEncoderPreference r103 = new InternalVideoEncoderPreference("VIDEO_ENCODER_PREFERENCE_AUTO", 3, 3);
            VIDEO_ENCODER_PREFERENCE_AUTO = r103;
            $VALUES = new InternalVideoEncoderPreference[]{r100, r101, r102, r103};
        }

        public static InternalVideoEncoderPreference[] values() {
            return (InternalVideoEncoderPreference[]) $VALUES.clone();
        }

        public int getIntValue() {
            return this.value;
        }

        public static InternalVideoEncoderPreference valueOf(String r100) {
            return (InternalVideoEncoderPreference) a.a(InternalVideoEncoderPreference.class, r100);
        }

        private InternalVideoEncoderPreference(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public InternalVideoEncoderPreference getEncoderPreference() {
        return this.encodePreference;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getHeight() {
        return this.height;
    }

    public int getMaxKBps() {
        return this.maxBitrate;
    }

    public int getMinKBps() {
        return this.minBitrate;
    }

    public int getWidth() {
        return this.width;
    }

    public InternalVideoEncoderConfig(VideoEncoderConfig r100) {
        this.minBitrate = 0;
        this.encodePreference = InternalVideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE;
        this.width = r100.width;
        this.height = r100.height;
        this.frameRate = r100.frameRate;
        this.maxBitrate = r100.maxBitrate;
        this.minBitrate = r100.minBitrate;
        this.encodePreference = ConvertEnumValue(r100.encodePreference);
    }

    private InternalVideoEncoderPreference ConvertEnumValue(VideoEncoderConfig.EncoderPreference r100) {
        InternalVideoEncoderPreference r101 = InternalVideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_MAINTAIN_FRAMERATE;
        int r102 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$EncoderPreference[r100.ordinal()];
        if (r102 == 1) goto L14;
        if (r102 != 2) goto L7;
        return r101;
    L7:
        if (r102 == 3) goto L17;
        if (r102 == 4) goto L16;
        return r101;
    L16:
        return InternalVideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_AUTO;
    L17:
        return InternalVideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_MAINTAIN_QUALITY;
    L14:
        return InternalVideoEncoderPreference.VIDEO_ENCODER_PREFERENCE_DISABLED;
    }

    private InternalVideoCodecMode ConvertEnumValue(VideoEncoderConfig.CodecMode r100) {
        InternalVideoCodecMode r101 = InternalVideoCodecMode.VIDEO_CODEC_MODE_AUTO;
        int r102 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$CodecMode[r100.ordinal()];
        if (r102 == 1) goto L12;
        if (r102 == 2) goto L15;
        if (r102 == 3) goto L14;
        return InternalVideoCodecMode.VIDEO_CODEC_MODE_AUTO;
    L14:
        return InternalVideoCodecMode.VIDEO_CODEC_MODE_SOFTWARE;
    L15:
        return InternalVideoCodecMode.VIDEO_CODEC_MODE_HARDWARE;
    L12:
        return InternalVideoCodecMode.VIDEO_CODEC_MODE_AUTO;
    }

    private InternalVideoCodecType ConvertEnumValue(VideoEncoderConfig.VideoCodecType r100) {
        InternalVideoCodecType r101 = InternalVideoCodecType.VIDEO_CODEC_TYPE_AUTO;
        int r102 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$VideoEncoderConfig$VideoCodecType[r100.ordinal()];
        if (r102 == 1) goto L12;
        if (r102 == 2) goto L15;
        if (r102 == 3) goto L14;
        return InternalVideoCodecType.VIDEO_CODEC_TYPE_AUTO;
    L14:
        return InternalVideoCodecType.VIDEO_CODEC_TYPE_BYTEVC1;
    L15:
        return InternalVideoCodecType.VIDEO_CODEC_TYPE_H264;
    L12:
        return InternalVideoCodecType.VIDEO_CODEC_TYPE_AUTO;
    }
}
