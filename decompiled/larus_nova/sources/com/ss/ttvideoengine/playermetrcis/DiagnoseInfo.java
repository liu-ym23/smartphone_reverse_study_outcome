package com.ss.ttvideoengine.playermetrcis;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes34.dex */
public class DiagnoseInfo {
    public long mCiticalTime;
    public double mCpuUsage;
    public long mEmergencyTime;
    public int mMemUsage;
    public int mPowerUsage;
    public long mPowerUsageTime;

    public DiagnoseInfo() {
        this.mCpuUsage = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mMemUsage = 0;
        this.mPowerUsage = 0;
        this.mPowerUsageTime = 0;
        this.mCiticalTime = 0;
        this.mEmergencyTime = 0;
    }
}
