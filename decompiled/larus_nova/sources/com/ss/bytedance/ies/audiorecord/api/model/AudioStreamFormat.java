package com.ss.bytedance.ies.audiorecord.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0003R&\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR&\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR&\u0010\u0011\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/bytedance/ies/audiorecord/api/model/AudioStreamFormat;", "", "sampleRate", "", "channelNum", "codecType", "bitRateBps", "(IIII)V", "<set-?>", "getBitRateBps", "()I", "setBitRateBps", "(I)V", "getChannelNum", "setChannelNum", "getCodecType", "setCodecType", "frameSizeMs", "getFrameSizeMs", "setFrameSizeMs", "getSampleRate", "setSampleRate", "create", "audiorecord-api-0.0.0.2-alpha.93@aar_release"}, k = 1, mv = {1, 1, 16})
public final class AudioStreamFormat {
    private int bitRateBps;
    private int channelNum;
    private int codecType;
    private int frameSizeMs;
    private int sampleRate;

    public final int getBitRateBps() {
        return this.bitRateBps;
    }

    public final int getChannelNum() {
        return this.channelNum;
    }

    public final int getCodecType() {
        return this.codecType;
    }

    public final int getFrameSizeMs() {
        return this.frameSizeMs;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public final void setBitRateBps(int r100) {
        this.bitRateBps = r100;
    }

    public final void setChannelNum(int r100) {
        this.channelNum = r100;
    }

    public final void setCodecType(int r100) {
        this.codecType = r100;
    }

    public final void setFrameSizeMs(int r100) {
        this.frameSizeMs = r100;
    }

    public final void setSampleRate(int r100) {
        this.sampleRate = r100;
    }

    public AudioStreamFormat(int r100, int r101, int r102, int r103) {
        this.frameSizeMs = 20;
        this.sampleRate = r100;
        this.channelNum = r101;
        this.codecType = r102;
        this.bitRateBps = r103;
    }

    private final AudioStreamFormat create(int r100, int r101, int r102, int r103) {
        return new AudioStreamFormat(r100, r101, r102, r103);
    }
}
