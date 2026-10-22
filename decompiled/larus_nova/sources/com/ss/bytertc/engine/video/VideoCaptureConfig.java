package com.ss.bytertc.engine.video;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class VideoCaptureConfig {
    public CapturePreference capturePreference;
    public int frameRate;
    public int height;
    public int width;

    public static final enum CapturePreference extends Enum<CapturePreference> {
        private static final /* synthetic */ CapturePreference[] $VALUES = null;
        public static final CapturePreference AUTO = null;
        public static final CapturePreference AUTO_PERFORMANCE = null;
        public static final CapturePreference MANUAL = null;
        private int value;

        static {
            CapturePreference r100 = new CapturePreference("AUTO", 0, 0);
            AUTO = r100;
            CapturePreference r101 = new CapturePreference("MANUAL", 1, 1);
            MANUAL = r101;
            CapturePreference r102 = new CapturePreference("AUTO_PERFORMANCE", 2, 2);
            AUTO_PERFORMANCE = r102;
            $VALUES = new CapturePreference[]{r100, r101, r102};
        }

        public static CapturePreference[] values() {
            return (CapturePreference[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static CapturePreference convertFromInt(int r100) {
            return values()[r100];
        }

        public static CapturePreference valueOf(String r100) {
            return (CapturePreference) a.a(CapturePreference.class, r100);
        }

        private CapturePreference(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public String toString() {
        return "VideoCaptureConfig{capturePreference=" + this.capturePreference + "width=" + this.width + ", height=" + this.height + ", frameRate=" + this.frameRate + '}';
    }

    public VideoCaptureConfig() {
        this.capturePreference = CapturePreference.AUTO;
    }

    public VideoCaptureConfig(int r100, int r101, int r102) {
        this.capturePreference = CapturePreference.AUTO;
        this.capturePreference = CapturePreference.MANUAL;
        this.width = r100;
        this.height = r101;
        this.frameRate = r102;
    }
}
