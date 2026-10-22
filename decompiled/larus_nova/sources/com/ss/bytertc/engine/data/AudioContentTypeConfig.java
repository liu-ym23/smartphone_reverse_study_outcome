package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class AudioContentTypeConfig {
    public boolean hasMediaPlayer;
    public boolean hasMic;
    public boolean hasScreenAudio;

    public String toString() {
        return "AudioContentTypeConfig{hasMic='" + this.hasMic + "', hasScreenAudio='" + this.hasScreenAudio + "', hasMediaPlayer='" + this.hasMediaPlayer + "'}";
    }

    public AudioContentTypeConfig() {
        this.hasMic = false;
        this.hasScreenAudio = false;
        this.hasMediaPlayer = false;
    }

    public AudioContentTypeConfig(boolean r100, boolean r101, boolean r102) {
        this.hasMic = r100;
        this.hasScreenAudio = r101;
        this.hasMediaPlayer = r102;
    }
}
