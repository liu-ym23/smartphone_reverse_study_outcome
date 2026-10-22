package com.bytedance.ee.bear.drive.biz.preview.vc.audio;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setCurrentTime(double r1) {
        this.currentTime = r1;
    }

    public void setFullscreen(boolean r1) {
        this.isFullscreen = r1;
    }

    public void setPlaybackRate(int r1) {
        this.playbackRate = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }
}
