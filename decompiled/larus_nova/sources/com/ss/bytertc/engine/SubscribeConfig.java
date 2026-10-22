package com.ss.bytertc.engine;

import com.alipay.sdk.m.u.i;
import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class SubscribeConfig {
    public int framerate;
    public boolean isScreen;
    public boolean subAudio;
    public int subHeight;
    public boolean subVideo;
    public int subVideoIndex;
    public int subWidth;
    public SVCLayer svcLayer;
    public int videoIndex;

    public static final enum SVCLayer extends Enum<SVCLayer> {
        private static final /* synthetic */ SVCLayer[] $VALUES = null;
        public static final SVCLayer BASE = null;
        public static final SVCLayer DEFAULT = null;
        public static final SVCLayer HIGH = null;
        public static final SVCLayer MAIN = null;
        private int value;

        static {
            SVCLayer r100 = new SVCLayer("DEFAULT", 0, 0);
            DEFAULT = r100;
            SVCLayer r101 = new SVCLayer("BASE", 1, 1);
            BASE = r101;
            SVCLayer r102 = new SVCLayer(AccountType.MAIN, 2, 2);
            MAIN = r102;
            SVCLayer r103 = new SVCLayer("HIGH", 3, 3);
            HIGH = r103;
            $VALUES = new SVCLayer[]{r100, r101, r102, r103};
        }

        public static SVCLayer[] values() {
            return (SVCLayer[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static SVCLayer convertFromInt(int r100) {
            return values()[r100];
        }

        public static SVCLayer valueOf(String r100) {
            return (SVCLayer) a.a(SVCLayer.class, r100);
        }

        private SVCLayer(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public String toString() {
        return "SubscribeConfig{isScreen=" + this.isScreen + ", subVideo=" + this.subVideo + ", subAudio=" + this.subAudio + ", videoIndex=" + this.videoIndex + ", svcLayer=" + this.svcLayer + ", sub_width=" + this.subWidth + ", sub_height=" + this.subHeight + ", sub_video_index=" + this.subVideoIndex + i.f25855d;
    }

    public SubscribeConfig() {
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
        this.svcLayer = SVCLayer.DEFAULT;
        this.framerate = 0;
    }

    public SubscribeConfig(SubscribeConfig r100) {
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
        this.svcLayer = SVCLayer.DEFAULT;
        this.framerate = 0;
        if (r100 == null) goto L6;
        this.isScreen = r100.isScreen;
        this.subVideo = r100.subVideo;
        this.subAudio = r100.subAudio;
        this.videoIndex = r100.videoIndex;
        this.svcLayer = r100.svcLayer;
        this.subWidth = r100.subWidth;
        this.subHeight = r100.subHeight;
        this.subVideoIndex = r100.subVideoIndex;
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L27:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L27;
        SubscribeConfig r101 = (SubscribeConfig) r100;
        if (this.isScreen == r101.isScreen) goto L13;
    L25:
        return false;
    L13:
        if (this.subVideo != r101.subVideo) goto L25;
        if (this.subAudio != r101.subAudio) goto L25;
        if (this.videoIndex != r101.videoIndex) goto L25;
        if (this.svcLayer != r101.svcLayer) goto L25;
        if (this.subWidth != r101.subWidth) goto L25;
        if (this.subHeight != r101.subHeight) goto L25;
        return true;
    }

    public SubscribeConfig(boolean r100, boolean r101, boolean r102, int r103) {
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
        SVCLayer r104 = SVCLayer.DEFAULT;
        this.framerate = 0;
        this.isScreen = r100;
        this.subVideo = r101;
        this.subAudio = r102;
        this.videoIndex = r103;
        this.svcLayer = r104;
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
    }

    public SubscribeConfig(boolean r100, boolean r101, boolean r102, int r103, int r104) {
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
        this.svcLayer = SVCLayer.DEFAULT;
        this.framerate = 0;
        this.isScreen = r100;
        this.subVideo = r101;
        this.subAudio = r102;
        this.videoIndex = r103;
        this.svcLayer = SVCLayer.convertFromInt(r104);
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
    }

    public SubscribeConfig(boolean r100, boolean r101, boolean r102, int r103, int r104, int r105, int r106, int r110) {
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
        this.svcLayer = SVCLayer.DEFAULT;
        this.framerate = 0;
        this.isScreen = r100;
        this.subVideo = r101;
        this.subAudio = r102;
        this.videoIndex = r103;
        this.svcLayer = SVCLayer.convertFromInt(r104);
        this.subWidth = r105;
        this.subHeight = r106;
        this.subVideoIndex = r110;
    }

    private static SubscribeConfig create(boolean r110, boolean r111, boolean r112, int r113, int r114, int r115, int r116, int r117) {
        return new SubscribeConfig(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
