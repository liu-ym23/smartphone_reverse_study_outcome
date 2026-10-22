package com.ss.bytertc.engine.video;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class VideoEncoderConfiguration {
    public VideoDimensions dimensions;
    public FrameRate frameRate;
    public int kBitrate;
    public int kMinBitrate;
    public OrientationMode orientationMode;

    public static final enum OrientationMode extends Enum<OrientationMode> {
        private static final /* synthetic */ OrientationMode[] $VALUES = null;
        public static final OrientationMode ORIENTATION_MODE_ADAPTIVE = null;
        public static final OrientationMode ORIENTATION_MODE_FIXED_LANDSCAPE = null;
        public static final OrientationMode ORIENTATION_MODE_FIXED_PORTRAIT = null;
        private int value;

        static {
            OrientationMode r100 = new OrientationMode("ORIENTATION_MODE_ADAPTIVE", 0, 0);
            ORIENTATION_MODE_ADAPTIVE = r100;
            OrientationMode r101 = new OrientationMode("ORIENTATION_MODE_FIXED_LANDSCAPE", 1, 1);
            ORIENTATION_MODE_FIXED_LANDSCAPE = r101;
            OrientationMode r102 = new OrientationMode("ORIENTATION_MODE_FIXED_PORTRAIT", 2, 2);
            ORIENTATION_MODE_FIXED_PORTRAIT = r102;
            $VALUES = new OrientationMode[]{r100, r101, r102};
        }

        public static OrientationMode[] values() {
            return (OrientationMode[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static OrientationMode valueOf(String r100) {
            return (OrientationMode) a.a(OrientationMode.class, r100);
        }

        private OrientationMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public String toString() {
        return "VideoEncoderConfiguration{dimensions=" + this.dimensions + ", frameRate=" + this.frameRate + ", bitrate=" + this.kBitrate + ", minBitrate=" + this.kMinBitrate + ", orienttationMode=" + this.orientationMode + '}';
    }

    public VideoEncoderConfiguration(VideoDimensions r100, FrameRate r101, int r102, int r103, OrientationMode r104) {
        this.dimensions = r100;
        this.frameRate = r101;
        this.kBitrate = r102;
        this.kMinBitrate = r103;
        this.orientationMode = r104;
    }
}
