package com.bytedance.bdlocation.network.response;

import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.RegionCountry;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LocInfoRspData {

    @SerializedName("disable_polling_upload")
    public int disablePollingUpload;

    @SerializedName("disabled_uuid_list")
    public List<String> disableUuidList;

    @SerializedName("in_outdoor_confidence")
    public float inOutDoorConfidence;

    @SerializedName("in_outdoor_status")
    public int inOutDoorStatus;

    @SerializedName("is_indoor")
    public int isIndoor;

    @SerializedName("is_locate")
    public boolean isLocate;

    @SerializedName("is_wifi_rescan")
    public int isWifiRescan;

    @SerializedName("Location")
    public LocationResult location;

    @SerializedName("disable_locate_on_moving_only")
    public int movingSceneWithAoiStatus;

    @SerializedName("next_ble_scan_interval")
    public long nextBleScanInterval;

    @SerializedName("next_gps_scan_interval")
    public long nextGPSScanInterval;

    @SerializedName("next_polling_upload_interval")
    public long nextPollingUploadInterval;

    @SerializedName("Country")
    public RegionCountry regionCountry;

    @SerializedName(LocationExtraDataTraceLogger.SUBMIT_BLE_NOW)
    public boolean submitBleNow;
    public String submitLogId;

    public String toString() {
        return "LocInfoRspData{isIndoor=" + this.isIndoor + ", isLocate=" + this.isLocate + ", submitLogId='" + this.submitLogId + "', nextBleScanInterval=" + this.nextBleScanInterval + ", submitBleNow=" + this.submitBleNow + ", nextPollingUploadInterval=" + this.nextPollingUploadInterval + ", location=" + this.location + ", regionCountry=" + this.regionCountry + ", nextGPSScanInterval=" + this.nextGPSScanInterval + ", disableUuidList=" + this.disableUuidList + ", disablePollingUpload=" + this.disablePollingUpload + ", isRescanWifi=" + this.isWifiRescan + ", inOutDoorStatus=" + this.inOutDoorStatus + ", inOutDoorConfidence=" + this.inOutDoorConfidence + ", movingSceneWithAoiStatus=" + this.movingSceneWithAoiStatus + '}';
    }

    public LocInfoRspData(LocInfoRspData r3) {
        this.isIndoor = r3.isIndoor;
        this.isLocate = r3.isLocate;
        this.submitLogId = r3.submitLogId;
        this.location = r3.location;
        this.nextBleScanInterval = r3.nextBleScanInterval;
        this.submitBleNow = r3.submitBleNow;
        this.nextPollingUploadInterval = r3.nextPollingUploadInterval;
        this.regionCountry = r3.regionCountry;
        this.nextGPSScanInterval = r3.nextGPSScanInterval;
        this.disableUuidList = r3.disableUuidList;
        this.disablePollingUpload = r3.disablePollingUpload;
        this.isWifiRescan = r3.isWifiRescan;
        this.inOutDoorStatus = r3.inOutDoorStatus;
        this.inOutDoorConfidence = r3.inOutDoorConfidence;
        this.movingSceneWithAoiStatus = r3.movingSceneWithAoiStatus;
    }
}
