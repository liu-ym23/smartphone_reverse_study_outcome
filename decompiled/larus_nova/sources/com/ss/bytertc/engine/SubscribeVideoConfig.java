package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class SubscribeVideoConfig {
    private int priority;
    private int videoIndex;

    public String toString() {
        return "SubscribeVideoConfig{videoIndex=" + this.videoIndex + ", priority=" + this.priority + '}';
    }

    public int getPriority() {
        return this.priority;
    }

    public int getVideoIndex() {
        return this.videoIndex;
    }

    public SubscribeVideoConfig(int r100, int r101) {
        this.videoIndex = r100;
        this.priority = r101;
    }
}
