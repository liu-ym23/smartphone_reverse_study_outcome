package com.ss.bytertc.engine.data;

import android.view.View;

/* JADX INFO: loaded from: classes40.dex */
public class EchoTestConfig {
    public int audioReportInterval;
    public boolean enableAudio;
    public boolean enableVideo;
    public String roomId;
    public String token;
    public String uid;
    public View view;

    public String toString() {
        return "EchoTestConfig{view='" + this.view + "'uid='" + this.uid + "', roomId='" + this.roomId + "', token='" + this.token + "', enableAudio='" + this.enableAudio + "', enableVideo='" + this.enableVideo + "', audioReportInterval='" + this.audioReportInterval + "'}";
    }

    public int getAudioReportInterval() {
        return this.audioReportInterval;
    }

    public boolean getEchoEnabledAudio() {
        return this.enableAudio;
    }

    public boolean getEchoEnabledVideo() {
        return this.enableVideo;
    }

    public View getEchoRenderView() {
        return this.view;
    }

    public String getEchoRoomId() {
        return this.roomId;
    }

    public String getEchoToken() {
        return this.token;
    }

    public String getEchoUid() {
        return this.uid;
    }

    public EchoTestConfig(View r100, String r101, String r102, String r103, boolean r104, boolean r105, int r106) {
        this.view = r100;
        this.uid = r101;
        this.roomId = r102;
        this.token = r103;
        this.enableAudio = r104;
        this.enableVideo = r105;
        this.audioReportInterval = r106;
    }
}
