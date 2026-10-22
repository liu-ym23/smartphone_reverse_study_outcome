package com.bytedance.bdlocation.network.response;

import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.RegionCountry;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
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

    public LocInfoRspData(LocInfoRspData r100) {
        this.isIndoor = r100.isIndoor;
        this.isLocate = r100.isLocate;
        this.submitLogId = r100.submitLogId;
        this.location = r100.location;
        this.nextBleScanInterval = r100.nextBleScanInterval;
        this.submitBleNow = r100.submitBleNow;
        this.nextPollingUploadInterval = r100.nextPollingUploadInterval;
        this.regionCountry = r100.regionCountry;
        this.nextGPSScanInterval = r100.nextGPSScanInterval;
        this.disableUuidList = r100.disableUuidList;
        this.disablePollingUpload = r100.disablePollingUpload;
        this.isWifiRescan = r100.isWifiRescan;
        this.inOutDoorStatus = r100.inOutDoorStatus;
        this.inOutDoorConfidence = r100.inOutDoorConfidence;
        this.movingSceneWithAoiStatus = r100.movingSceneWithAoiStatus;
    }
}
