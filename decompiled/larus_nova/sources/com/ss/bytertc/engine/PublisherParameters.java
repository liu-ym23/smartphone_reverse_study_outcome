package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class PublisherParameters {
    public int audioKBitrate;
    public int audiochannels;
    public int audiosamplerate;
    public int defaultLayout;
    public String extraInfo;
    public int framerate;
    public int height;
    public int kBitrate;
    public int lifecycle;
    public String mosaicStream;
    public boolean owner;
    public int width;

    public PublisherParameters() {
        this.owner = false;
        this.width = 360;
        this.height = 640;
        this.lifecycle = 1;
        this.defaultLayout = 1;
        this.framerate = 15;
        this.kBitrate = 500;
        this.audiosamplerate = 44100;
        this.audioKBitrate = 96;
        this.audiochannels = 1;
        this.extraInfo = null;
    }
}
