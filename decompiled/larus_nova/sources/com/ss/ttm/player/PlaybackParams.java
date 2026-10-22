package com.ss.ttm.player;

/* JADX INFO: loaded from: classes40.dex */
public final class PlaybackParams {
    protected static final int DEFAULT_VALUE = -1;
    private int mAudioFallbackMode;
    private int mDescribeContents;
    private float mPitch;
    private float mSpeed;

    public PlaybackParams allowDefaults() {
        return this;
    }

    public PlaybackParams() {
        this.mDescribeContents = -1;
        this.mAudioFallbackMode = -1;
        this.mPitch = -1.0f;
        this.mSpeed = -1.0f;
    }

    public int describeContents() {
        return this.mDescribeContents;
    }

    public int getAudioFallbackMode() {
        return this.mAudioFallbackMode;
    }

    public float getPitch() {
        return this.mPitch;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public PlaybackParams setAudioFallbackMode(int r100) {
        this.mAudioFallbackMode = r100;
        return this;
    }

    public PlaybackParams setPitch(float r100) {
        this.mPitch = r100;
        return this;
    }

    public PlaybackParams setSpeed(float r100) {
        this.mSpeed = r100;
        return this;
    }
}
