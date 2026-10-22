package com.bytedance.ee.bear.drive.biz.preview.vc.audio;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class DriveAudioState implements NonProguard {
    private double currentTime;
    private boolean isFullscreen;
    private int playbackRate;
    private int status;

    public DriveAudioState() {
    }

    public String toString() {
        return "DriveAudioState{status=" + this.status + ", isFullscreen=" + this.isFullscreen + ", playbackRate=" + this.playbackRate + ", currentTime=" + this.currentTime + '}';
    }

    public double getCurrentTime() {
        return this.currentTime;
    }

    public int getPlaybackRate() {
        return this.playbackRate;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isFullscreen() {
        return this.isFullscreen;
    }

    public void setCurrentTime(double r100) {
        this.currentTime = r100;
    }

    public void setFullscreen(boolean r100) {
        this.isFullscreen = r100;
    }

    public void setPlaybackRate(int r100) {
        this.playbackRate = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }
}
