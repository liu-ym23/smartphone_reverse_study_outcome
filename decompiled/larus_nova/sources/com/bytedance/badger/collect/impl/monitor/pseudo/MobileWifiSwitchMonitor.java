package com.bytedance.badger.collect.impl.monitor.pseudo;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.monitor.AbsMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public class MobileWifiSwitchMonitor extends AbsMonitor {
    private boolean cellularToWifiResult;
    private String errorMsg;
    private long finishSwitchCellularTime;
    private long releaseCellularTime;
    private long startSwitchCellularTime;
    private String uuid;
    private boolean wifiToCellularResult;

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public void clear() {
        this.wifiToCellularResult = false;
        this.cellularToWifiResult = false;
        this.startSwitchCellularTime = 0;
        this.finishSwitchCellularTime = 0;
        this.releaseCellularTime = 0;
        this.errorMsg = "";
        this.uuid = "";
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public String getEventName() {
        return Constants.EventName.MOBILE_WIFI_SWITCH;
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public JSONObject getParams() throws Exception {
        JSONObject r100 = new JSONObject();
        r100.put("wifi_to_cellular_result", this.wifiToCellularResult);
        r100.put("cellular_to_wifi_result", this.cellularToWifiResult);
        r100.put("errorMsg", this.errorMsg);
        r100.put("start_switch_cellular_timestamp", this.startSwitchCellularTime);
        r100.put("finish_switch_cellular_timestamp", this.finishSwitchCellularTime);
        r100.put("release_cellular_timestamp", this.releaseCellularTime);
        long r101 = this.finishSwitchCellularTime;
        long r102 = this.startSwitchCellularTime;
        long r103 = r101 - r102;
        long r104 = this.releaseCellularTime;
        long r105 = r104 - r102;
        long r106 = r104 - r101;
        if (r103 >= 0) goto L6;
        r103 = -1;
    L6:
        r100.put("wifi_switch_cellular_duration", r103);
        if (r106 >= 0) goto L10;
        r106 = -1;
    L10:
        r100.put("network_duration", r106);
        if (r105 >= 0) goto L14;
        r105 = -1;
    L14:
        r100.put("duration", r105);
        r100.put("cdid", this.uuid);
        return r100;
    }

    public void setFinishTime() {
        this.finishSwitchCellularTime = System.currentTimeMillis();
    }

    public void setReleaseCellularTime() {
        this.releaseCellularTime = System.currentTimeMillis();
    }

    public void setStartTime() {
        this.startSwitchCellularTime = System.currentTimeMillis();
    }

    public MobileWifiSwitchMonitor() {
    }

    public void setCellularToWifiResult(boolean r100) {
        this.cellularToWifiResult = r100;
    }

    public void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public void setUUID(String r100) {
        this.uuid = r100;
    }

    public void setWifiToCellularResult(boolean r100) {
        this.wifiToCellularResult = r100;
    }
}
