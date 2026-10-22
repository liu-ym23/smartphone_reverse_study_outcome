package com.bytedance.bdlocation.network.response;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class LocationResp {

    @SerializedName("data")
    public String data;

    @SerializedName("err_no")
    public int resultCode;

    @SerializedName(LocationMonitorConst.ERR_MSG)
    public String resultMsg;

    @SerializedName("err_tip")
    public String resultTip;
    public String submitLogId;

    public LocationResp() {
    }

    public String toMonitorString() {
        return "LocationResp { resultCode = " + this.resultCode + ", resultMsg = '" + this.resultMsg + "', resultTip = '" + this.resultTip + "', submitLogId = '" + this.submitLogId + "' }";
    }

    public String toString() {
        return "LocationResp{resultCode=" + this.resultCode + ", resultMsg='" + this.resultMsg + "', resultTip='" + this.resultTip + "', data='" + this.data + "', submitLogId='" + this.submitLogId + "'}";
    }
}
