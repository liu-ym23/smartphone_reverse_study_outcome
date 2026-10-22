package com.mammon.audiosdk.structures;

import com.mammon.audiosdk.enums.SAMICoreDataType;

/* JADX INFO: loaded from: classes4.dex */
public class SAMICoreBlock {
    public Object[] audioData;
    public SAMICoreDataType dataType;
    public String extra;
    public int numberAudioData;
    public Object userContext;

    public int getDataType() {
        return this.dataType.getValue();
    }

    public SAMICoreBlock() {
        this.numberAudioData = 1;
    }

    public void setDataType(int r100) {
        this.dataType = SAMICoreDataType.fromInt(r100);
    }
}
