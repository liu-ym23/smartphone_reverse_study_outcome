package com.bytedance.ee.bear.drive.config.fg;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setCompatExts(List<String> r1) {
        this.compatExts = r1;
    }

    public void setCompatType(int r1) {
        this.compatType = r1;
    }

    public void setEnable(boolean r1) {
        this.enable = r1;
    }

    public void setMaxBitrate(long r1) {
        this.maxBitrate = r1;
    }

    public void setMaxFps(int r1) {
        this.maxFps = r1;
    }

    public DriveVideoPlayConfig(boolean r2, long r3, int r5) {
        ArrayList r0 = new ArrayList();
        this.compatExts = r0;
        this.enable = r2;
        this.maxBitrate = r3;
        this.maxFps = r5;
        r0.add("mp4");
    }
}
