package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class AudioEncodeConfig {
    public int channelNum;
    public int codecType;
    public int encBitrate;
    public int encMode;
    public int packetSize;
    public int sampleRate;
    public int useDtx;
    public int useInbandfec;

    public String toString() {
        return "AudioEncodeConfig{codecType='" + this.codecType + "'encMode='" + this.encMode + "', channelNum='" + this.channelNum + "', encBitrate='" + this.encBitrate + "', useDtx='" + this.useDtx + "', useInbandfec='" + this.useInbandfec + "', sampleRate='" + this.sampleRate + "', packetSize='" + this.packetSize + "'}";
    }

    public AudioEncodeConfig() {
        this.codecType = -1;
        this.encMode = -1;
        this.channelNum = -1;
        this.encBitrate = -1;
        this.useDtx = -1;
        this.useInbandfec = -1;
        this.sampleRate = -1;
        this.packetSize = -1;
    }

    public AudioEncodeConfig(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        this.codecType = r100;
        this.encMode = r101;
        this.channelNum = r102;
        this.encBitrate = r103;
        this.useDtx = r104;
        this.useInbandfec = r105;
        this.sampleRate = r106;
        this.packetSize = r107;
    }
}
