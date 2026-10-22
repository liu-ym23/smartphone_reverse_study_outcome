package com.bytedance.vcloud.networkpredictor;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class SpeedPredictorNotifyInfo {
    public long code;
    public ISpeedRecordOld mSpeedRecord;
    public Map<String, Integer> mStreamIdMediaTypeMap;
    public long parameter;
    public int what;

    public SpeedPredictorNotifyInfo() {
        this.what = -1;
        this.code = -1;
        this.parameter = -1;
        this.mSpeedRecord = null;
        this.mStreamIdMediaTypeMap = null;
    }

    public SpeedPredictorNotifyInfo(int r100, ISpeedRecordOld r101, HashMap<String, Integer> r102) {
        this.what = r100;
        this.code = -1;
        this.parameter = -1;
        this.mSpeedRecord = r101;
        this.mStreamIdMediaTypeMap = r102;
    }
}
