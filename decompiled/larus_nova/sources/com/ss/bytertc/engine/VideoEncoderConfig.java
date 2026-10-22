package com.ss.bytertc.engine;

import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.ttm.player.MediaPlayer;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class VideoEncoderConfig {
    public static final VideoDimensions VD_120x120 = null;
    public static final VideoDimensions VD_1280x720 = null;
    public static final VideoDimensions VD_160x120 = null;
    public static final VideoDimensions VD_180x180 = null;
    public static final VideoDimensions VD_1920x1080 = null;
    public static final VideoDimensions VD_240x180 = null;
    public static final VideoDimensions VD_240x240 = null;
    public static final VideoDimensions VD_2540x1440 = null;
    public static final VideoDimensions VD_320x180 = null;
    public static final VideoDimensions VD_320x240 = null;
    public static final VideoDimensions VD_360x360 = null;
    public static final VideoDimensions VD_3840x2160 = null;
    public static final VideoDimensions VD_424x240 = null;
    public static final VideoDimensions VD_480x360 = null;
    public static final VideoDimensions VD_480x480 = null;
    public static final VideoDimensions VD_640x360 = null;
    public static final VideoDimensions VD_640x480 = null;
    public static final VideoDimensions VD_840x480 = null;
    public static final VideoDimensions VD_960x540 = null;
    public static final VideoDimensions VD_960x720 = null;
    public EncoderPreference encodePreference;
    public int frameRate;
    public int height;
    public int maxBitrate;
    public int minBitrate;
    public int width;

    public static final enum CodecMode extends Enum<CodecMode> {
        private static final /* synthetic */ CodecMode[] $VALUES = null;
        public static final CodecMode CODEC_MODE_AUTO = null;
        public static final CodecMode CODEC_MODE_HARDWARE = null;
        public static final CodecMode CODEC_MODE_SOFTWARE = null;
        private int value;

        static {
            CodecMode r100 = new CodecMode("CODEC_MODE_AUTO", 0, 0);
            CODEC_MODE_AUTO = r100;
            CodecMode r101 = new CodecMode("CODEC_MODE_HARDWARE", 1, 1);
            CODEC_MODE_HARDWARE = r101;
            CodecMode r102 = new CodecMode("CODEC_MODE_SOFTWARE", 2, 2);
            CODEC_MODE_SOFTWARE = r102;
            $VALUES = new CodecMode[]{r100, r101, r102};
        }

        public static CodecMode[] values() {
            return (CodecMode[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static CodecMode convertFromInt(int r100) {
            return values()[r100];
        }

        public static CodecMode valueOf(String r100) {
            return (CodecMode) a.a(CodecMode.class, r100);
        }

        private CodecMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum EncoderPreference extends Enum<EncoderPreference> {
        private static final /* synthetic */ EncoderPreference[] $VALUES = null;
        public static final EncoderPreference AUTO = null;
        public static final EncoderPreference DISABLED = null;
        public static final EncoderPreference MAINTAIN_FRAMERATE = null;
        public static final EncoderPreference MAINTAIN_QUALITY = null;
        private int value;

        static {
            EncoderPreference r100 = new EncoderPreference("DISABLED", 0, 0);
            DISABLED = r100;
            EncoderPreference r101 = new EncoderPreference("MAINTAIN_FRAMERATE", 1, 1);
            MAINTAIN_FRAMERATE = r101;
            EncoderPreference r102 = new EncoderPreference("MAINTAIN_QUALITY", 2, 2);
            MAINTAIN_QUALITY = r102;
            EncoderPreference r103 = new EncoderPreference("AUTO", 3, 3);
            AUTO = r103;
            $VALUES = new EncoderPreference[]{r100, r101, r102, r103};
        }

        public static EncoderPreference[] values() {
            return (EncoderPreference[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static EncoderPreference convertFromInt(int r100) {
            return values()[r100];
        }

        public static EncoderPreference valueOf(String r100) {
            return (EncoderPreference) a.a(EncoderPreference.class, r100);
        }

        private EncoderPreference(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum FrameRate extends Enum<FrameRate> {
        private static final /* synthetic */ FrameRate[] $VALUES = null;
        public static final FrameRate FRAME_RATE_FPS_1 = null;
        public static final FrameRate FRAME_RATE_FPS_10 = null;
        public static final FrameRate FRAME_RATE_FPS_15 = null;
        public static final FrameRate FRAME_RATE_FPS_24 = null;
        public static final FrameRate FRAME_RATE_FPS_30 = null;
        public static final FrameRate FRAME_RATE_FPS_60 = null;
        public static final FrameRate FRAME_RATE_FPS_7 = null;
        private int value;

        static {
            FrameRate r100 = new FrameRate("FRAME_RATE_FPS_1", 0, 1);
            FRAME_RATE_FPS_1 = r100;
            FrameRate r101 = new FrameRate("FRAME_RATE_FPS_7", 1, 7);
            FRAME_RATE_FPS_7 = r101;
            FrameRate r102 = new FrameRate("FRAME_RATE_FPS_10", 2, 10);
            FRAME_RATE_FPS_10 = r102;
            FrameRate r103 = new FrameRate("FRAME_RATE_FPS_15", 3, 15);
            FRAME_RATE_FPS_15 = r103;
            FrameRate r104 = new FrameRate("FRAME_RATE_FPS_24", 4, 24);
            FRAME_RATE_FPS_24 = r104;
            FrameRate r105 = new FrameRate("FRAME_RATE_FPS_30", 5, 30);
            FRAME_RATE_FPS_30 = r105;
            FrameRate r110 = new FrameRate("FRAME_RATE_FPS_60", 6, 60);
            FRAME_RATE_FPS_60 = r110;
            $VALUES = new FrameRate[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static FrameRate[] values() {
            return (FrameRate[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static FrameRate valueOf(String r100) {
            return (FrameRate) a.a(FrameRate.class, r100);
        }

        private FrameRate(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum VideoCodecType extends Enum<VideoCodecType> {
        private static final /* synthetic */ VideoCodecType[] $VALUES = null;
        public static final VideoCodecType CODEC_TYPE_AUTO = null;
        public static final VideoCodecType CODEC_TYPE_BYTEVC1 = null;
        public static final VideoCodecType CODEC_TYPE_H264 = null;
        private int value;

        static {
            VideoCodecType r100 = new VideoCodecType("CODEC_TYPE_AUTO", 0, 0);
            CODEC_TYPE_AUTO = r100;
            VideoCodecType r101 = new VideoCodecType("CODEC_TYPE_H264", 1, 1);
            CODEC_TYPE_H264 = r101;
            VideoCodecType r102 = new VideoCodecType("CODEC_TYPE_BYTEVC1", 2, 2);
            CODEC_TYPE_BYTEVC1 = r102;
            $VALUES = new VideoCodecType[]{r100, r101, r102};
        }

        public static VideoCodecType[] values() {
            return (VideoCodecType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static VideoCodecType convertFromInt(int r100) {
            return values()[r100];
        }

        public static VideoCodecType valueOf(String r100) {
            return (VideoCodecType) a.a(VideoCodecType.class, r100);
        }

        private VideoCodecType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class VideoDimensions {
        public int height;
        public int width;

        public VideoDimensions() {
            this.width = 0;
            this.height = 0;
        }

        public VideoDimensions(int r100, int r101) {
            this.width = r100;
            this.height = r101;
        }
    }

    public boolean isValid() {
        return true;
    }

    static {
        VD_120x120 = new VideoDimensions(120, 120);
        VD_160x120 = new VideoDimensions(160, 120);
        VD_180x180 = new VideoDimensions(180, 180);
        VD_240x180 = new VideoDimensions(240, 180);
        VD_320x180 = new VideoDimensions(320, 180);
        VD_240x240 = new VideoDimensions(240, 240);
        VD_320x240 = new VideoDimensions(320, 240);
        VD_424x240 = new VideoDimensions(424, 240);
        VD_360x360 = new VideoDimensions(360, 360);
        VD_480x360 = new VideoDimensions(480, 360);
        VD_640x360 = new VideoDimensions(640, 360);
        VD_480x480 = new VideoDimensions(480, 480);
        VD_640x480 = new VideoDimensions(640, 480);
        VD_840x480 = new VideoDimensions(MediaPlayer.MEDIA_PLAYER_OPTION_RTM_DATA_ICE_CONNECT_START_TIME, 480);
        VD_960x540 = new VideoDimensions(960, 540);
        VD_960x720 = new VideoDimensions(960, 720);
        VD_1280x720 = new VideoDimensions(1280, 720);
        VD_1920x1080 = new VideoDimensions(TECameraUtils.CAPTURE_NORMAL, 1080);
        VD_2540x1440 = new VideoDimensions(2540, 1440);
        VD_3840x2160 = new VideoDimensions(3840, 2160);
    }

    public String toString() {
        return "VideoEncoderConfig{width=" + this.width + "height=" + this.height + ", frameRate=" + this.frameRate + ", maxBitrate=" + this.maxBitrate + ", minBitrate=" + this.minBitrate + ", encodePreference=" + this.encodePreference + '}';
    }

    public VideoEncoderConfig() {
        this.maxBitrate = -1;
        this.minBitrate = 0;
        this.encodePreference = EncoderPreference.MAINTAIN_FRAMERATE;
    }

    public VideoEncoderConfig(int r100, int r101, int r102, int r103, int r104) {
        this.maxBitrate = -1;
        this.minBitrate = 0;
        this.encodePreference = EncoderPreference.MAINTAIN_FRAMERATE;
        this.width = r100;
        this.height = r101;
        this.frameRate = r102;
        this.maxBitrate = r103;
        this.minBitrate = r104;
    }

    private static VideoEncoderConfig create(int r100, int r101, int r102, int r110, int r111) {
        return new VideoEncoderConfig(r100, r101, r102, r110, r111);
    }

    public VideoEncoderConfig(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        this.maxBitrate = -1;
        this.minBitrate = 0;
        this.encodePreference = EncoderPreference.MAINTAIN_FRAMERATE;
        this.width = r100;
        this.height = r101;
        this.frameRate = r102;
        this.maxBitrate = r103;
        this.minBitrate = r104;
        this.encodePreference = EncoderPreference.convertFromInt(r107);
    }
}
