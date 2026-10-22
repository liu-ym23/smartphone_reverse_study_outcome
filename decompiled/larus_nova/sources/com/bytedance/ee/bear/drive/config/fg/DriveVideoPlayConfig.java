package com.bytedance.ee.bear.drive.config.fg;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class DriveVideoPlayConfig implements NonProguard {
    public static final int COMPAT_TYPE_EXO_LAYER = 1;
    public static final int COMPAT_TYPE_SHOW_FAILED = 0;
    public static final long DEFAULT_BITRATE = 5242880;
    public static final int DEFAULT_FPS = 88;
    private List<String> compatExts;
    private int compatType;
    private boolean enable;
    private long maxBitrate;
    private int maxFps;

    public String toString() {
        return "DriveVideoPlayConfig{enable=" + this.enable + ", maxBitrate=" + this.maxBitrate + ", maxFps=" + this.maxFps + ", compatType=" + this.compatType + ", compatExts=" + this.compatExts + '}';
    }

    public DriveVideoPlayConfig() {
        this.compatExts = new ArrayList();
    }

    public List<String> getCompatExts() {
        return this.compatExts;
    }

    public int getCompatType() {
        return this.compatType;
    }

    public long getMaxBitrate() {
        return this.maxBitrate;
    }

    public int getMaxFps() {
        return this.maxFps;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setCompatExts(List<String> r100) {
        this.compatExts = r100;
    }

    public void setCompatType(int r100) {
        this.compatType = r100;
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public void setMaxBitrate(long r100) {
        this.maxBitrate = r100;
    }

    public void setMaxFps(int r100) {
        this.maxFps = r100;
    }

    public DriveVideoPlayConfig(boolean r100, long r101, int r102) {
        ArrayList r103 = new ArrayList();
        this.compatExts = r103;
        this.enable = r100;
        this.maxBitrate = r101;
        this.maxFps = r102;
        r103.add("mp4");
    }
}
