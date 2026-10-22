package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class RemoteAudioPropertiesInfo {
    public AudioPropertiesInfo audioPropertiesInfo;
    public RemoteStreamKey streamKey;

    public String toString() {
        return "RemoteAudioPropertiesInfo{user_id='" + this.streamKey.getUserId() + "'room_id='" + this.streamKey.getUserId() + "'stream_index='" + this.streamKey.getStreamIndex() + "'audioPropertiesInfo ['linear_volume='" + this.audioPropertiesInfo.linearVolume + "'nonlinear_volume='" + this.audioPropertiesInfo.nonlinearVolume + "']}";
    }

    public RemoteAudioPropertiesInfo(RemoteStreamKey r100, AudioPropertiesInfo r101) {
        this.streamKey = r100;
        this.audioPropertiesInfo = r101;
    }

    private static RemoteAudioPropertiesInfo create(String r100, String r101, int r102, int r103, int r104, float[] r105, int r106) {
        return new RemoteAudioPropertiesInfo(new RemoteStreamKey(r100, r101, StreamIndex.fromId(r102)), new AudioPropertiesInfo(r103, r104, r105, r106));
    }
}
