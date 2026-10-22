package com.ss.bytertc.engine;

import android.util.Pair;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class VideoStreamDescription {
    public EncoderPreference encodePreference;
    public int frameRate;
    public int maxKbps;
    public int minKbps;
    public Pair<Integer, Integer> videoSize;

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
        public static final EncoderPreference Balance = null;
        public static final EncoderPreference Disabled = null;
        public static final EncoderPreference MaintainFramerate = null;
        public static final EncoderPreference MaintainQuality = null;
        private int value;

        static {
            EncoderPreference r100 = new EncoderPreference("Disabled", 0, 0);
            Disabled = r100;
            EncoderPreference r101 = new EncoderPreference("MaintainFramerate", 1, 1);
            MaintainFramerate = r101;
            EncoderPreference r102 = new EncoderPreference("MaintainQuality", 2, 2);
            MaintainQuality = r102;
            EncoderPreference r103 = new EncoderPreference("Balance", 3, 3);
            Balance = r103;
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

    public boolean isValid() {
        Pair<Integer, Integer> r100 = this.videoSize;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (((Integer) r100.first).intValue() > 0) goto L7;
        return false;
    L7:
        if (((Integer) this.videoSize.second).intValue() > 0) goto L9;
        return false;
    L9:
        if (this.frameRate <= 0) goto L22;
        int r101 = this.maxKbps;
        if (r101 > 0) goto L13;
        return true;
    L13:
        if (this.minKbps > r101) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    }

    public String toString() {
        return "VideoStreamDescription{videoSize=" + this.videoSize + ", frameRate=" + this.frameRate + ", maxKbps=" + this.maxKbps + ", minKbps=" + this.minKbps + ", encodePreference=" + this.encodePreference + '}';
    }

    public VideoStreamDescription() {
        this.minKbps = 0;
        this.encodePreference = EncoderPreference.MaintainFramerate;
    }

    public VideoStreamDescription(int r100, int r101, int r102, int r103, int r104) {
        this.minKbps = 0;
        this.encodePreference = EncoderPreference.MaintainFramerate;
        this.videoSize = new Pair(Integer.valueOf(r100), Integer.valueOf(r101));
        this.frameRate = r102;
        this.maxKbps = r103;
        this.minKbps = r104;
    }

    private static VideoStreamDescription create(int r100, int r101, int r102, int r110, int r111) {
        return new VideoStreamDescription(r100, r101, r102, r110, r111);
    }

    public VideoStreamDescription(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        this.minKbps = 0;
        this.encodePreference = EncoderPreference.MaintainFramerate;
        this.videoSize = new Pair(Integer.valueOf(r100), Integer.valueOf(r101));
        this.frameRate = r102;
        this.maxKbps = r103;
        this.minKbps = r104;
        this.encodePreference = EncoderPreference.convertFromInt(r107);
    }
}
