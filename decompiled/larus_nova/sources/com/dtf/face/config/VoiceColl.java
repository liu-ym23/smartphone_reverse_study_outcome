package com.dtf.face.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.ttvideoengine.model.SubInfo;

/* JADX INFO: loaded from: classes22.dex */
public class VoiceColl {

    @JSONField(name = "channelNum")
    public int channelNum;

    @JSONField(name = "compression")
    public int compression;

    @JSONField(name = SubInfo.KEY_FORMAT)
    public String format;

    @JSONField(name = "maxKb")
    public int maxKB;

    @JSONField(name = "maxTime")
    public int maxTime;

    @JSONField(name = "minDb")
    public int minDb;

    @JSONField(name = "minTime")
    public int minTime;

    @JSONField(name = "sampleBit")
    public int sampleBit;

    @JSONField(name = "sampleFreq")
    public int sampleFreq;

    public VoiceColl() {
        this.sampleFreq = 16000;
        this.sampleBit = 16;
        this.channelNum = 1;
        this.format = "wav";
    }
}
