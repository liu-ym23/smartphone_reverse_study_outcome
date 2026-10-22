package com.bytedance.bdlocation.entity.gis;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class EncryptedBDGisResult {

    @SerializedName("data")
    public String data;

    @SerializedName("err_no")
    public int errorCode;

    @SerializedName(LocationMonitorConst.ERR_MSG)
    public String errorMessage;

    @SerializedName("err_tip")
    public String errorTips;

    public EncryptedBDGisResult() {
    }
}
