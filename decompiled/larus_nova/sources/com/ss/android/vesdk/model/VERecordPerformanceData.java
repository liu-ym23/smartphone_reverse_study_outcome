package com.ss.android.vesdk.model;

/* JADX INFO: loaded from: classes40.dex */
public class VERecordPerformanceData {
    public float cartonRate;
    public long concatAfterWriteFile;
    public long concatInit;
    public long concatPreProcess;
    public long concatWriteFile;
    public float fps;
    public int lagCount;
    public long lagMaxDuration;
    public long lagTotalDuration;
    public float previewCartonRate;
    public float previewDropFps;
    public float previewRenderFps;
    public float previewSlightlyCartonRate;
    public float previewSubRenderFps;
    public float previewSydneyCartonRate;
    public float slightlyCartonRate;
    public long startRecordAfterInit;
    public long startRecordBeforeInit;
    public long startRecordInit;
    public long stopRecordAfterUninit;
    public long stopRecordThreadExit;
    public long stopRecordUninit;
    public float sydneyCartonRate;

    public String toString() {
        return "VERecordPerformanceData{fps=" + this.fps + ", startRecordBeforeInit=" + this.startRecordBeforeInit + ", startRecordInit=" + this.startRecordInit + ", startRecordAfterInit=" + this.startRecordAfterInit + '}';
    }

    public VERecordPerformanceData() {
        this.fps = -1.0f;
        this.lagCount = -1;
        this.lagMaxDuration = -1;
        this.lagTotalDuration = -1;
        this.cartonRate = -1.0f;
        this.slightlyCartonRate = -1.0f;
        this.sydneyCartonRate = -1.0f;
        this.previewCartonRate = -1.0f;
        this.previewSlightlyCartonRate = -1.0f;
        this.previewSydneyCartonRate = -1.0f;
        this.startRecordBeforeInit = -1;
        this.startRecordInit = -1;
        this.startRecordAfterInit = -1;
        this.stopRecordThreadExit = -1;
        this.stopRecordUninit = -1;
        this.stopRecordAfterUninit = -1;
        this.concatInit = -1;
        this.concatPreProcess = -1;
        this.concatWriteFile = -1;
        this.concatAfterWriteFile = -1;
        this.previewRenderFps = 0.0f;
        this.previewSubRenderFps = 0.0f;
        this.previewDropFps = 0.0f;
    }
}
