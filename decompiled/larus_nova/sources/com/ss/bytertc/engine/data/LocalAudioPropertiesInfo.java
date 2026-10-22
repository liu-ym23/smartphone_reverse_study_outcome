package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class LocalAudioPropertiesInfo {
    public AudioPropertiesInfo audioPropertiesInfo;
    public StreamIndex streamIndex;

    public String toString() {
        return "LocalAudioPropertiesInfo{streamIndex='" + this.streamIndex + "'audioPropertiesInfo='" + this.audioPropertiesInfo.toString() + "'}";
    }

    public LocalAudioPropertiesInfo(StreamIndex r100, AudioPropertiesInfo r101) {
        this.streamIndex = r100;
        this.audioPropertiesInfo = r101;
    }

    private static LocalAudioPropertiesInfo create(int r100, int r101, int r102, float[] r103, int r104, double r105) {
        AudioPropertiesInfo r106 = new AudioPropertiesInfo(r101, r102, r103, r104);
        r106.voicePitch = r105;
        return new LocalAudioPropertiesInfo(StreamIndex.fromId(r100), r106);
    }
}
