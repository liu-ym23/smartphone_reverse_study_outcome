package com.ss.ttvideoengine.strategrycenter;

/* JADX INFO: loaded from: classes35.dex */
public class PlayerInfo {
    private float mFrameRate;
    private int mPlaybackPos;
    private float mPlaybackSpeed;

    public PlayerInfo() {
    }

    public float getFrameRate() {
        return this.mFrameRate;
    }

    public int getPlaybackPos() {
        return this.mPlaybackPos;
    }

    public float getPlaybackSpeed() {
        return this.mPlaybackSpeed;
    }

    public void setFrameRate(float r100) {
        this.mFrameRate = r100;
    }

    public void setPlaybackPos(int r100) {
        this.mPlaybackPos = r100;
    }

    public void setPlaybackSpeed(float r100) {
        this.mPlaybackSpeed = r100;
    }
}
