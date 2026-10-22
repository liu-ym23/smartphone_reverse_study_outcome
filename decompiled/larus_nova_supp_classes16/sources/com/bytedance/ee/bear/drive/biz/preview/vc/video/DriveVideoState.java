package com.bytedance.ee.bear.drive.biz.preview.vc.video;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveVideoState implements NonProguard {
    private float currentTime;
    private boolean isFullscreen;
    private int playbackRate;
    private String recordId;
    private int status;

    public DriveVideoState() {
    }

    public String toString() {
        return "DriveVideoState{status=" + this.status + ", isFullscreen=" + this.isFullscreen + ", playbackRate=" + this.playbackRate + ", currentTime=" + this.currentTime + '}';
    }

    public float getCurrentTime() {
        return this.currentTime;
    }

    public int getPlaybackRate() {
        return this.playbackRate;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isFullscreen() {
        return this.isFullscreen;
    }

    public void setCurrentTime(float r1) {
        this.currentTime = r1;
    }

    public void setFullscreen(boolean r1) {
        this.isFullscreen = r1;
    }

    public void setPlaybackRate(int r1) {
        this.playbackRate = r1;
    }

    public void setRecordId(String r1) {
        this.recordId = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }
}
