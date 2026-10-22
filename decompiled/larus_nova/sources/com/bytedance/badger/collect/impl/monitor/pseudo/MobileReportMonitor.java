package com.bytedance.badger.collect.impl.monitor.pseudo;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.monitor.AbsMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public class MobileReportMonitor extends AbsMonitor {
    private String data;
    private String errorMsg;
    private long finishTime;
    private String logId;
    private boolean result;
    private long startTime;
    private String uuid;

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public String getEventName() {
        return Constants.EventName.MOBILE_REPORT;
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public void clear() {
        this.data = "";
        this.result = false;
        this.startTime = 0;
        this.finishTime = 0;
        this.errorMsg = "";
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public JSONObject getParams() throws Exception {
        JSONObject r100 = new JSONObject();
        long r101 = this.finishTime - this.startTime;
        if (r101 >= 0) goto L6;
        r101 = -1;
    L6:
        r100.put("duration", r101);
        r100.put("result", this.result);
        r100.put("errorMsg", this.errorMsg);
        r100.put("data", this.data);
        r100.put("logId", this.logId);
        return r100;
    }

    public void setFinishTime() {
        this.finishTime = System.currentTimeMillis();
    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public MobileReportMonitor() {
    }

    public void setData(String r100) {
        this.data = r100;
    }

    public void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public void setLogId(String r100) {
        this.logId = r100;
    }

    public void setResult(boolean r100) {
        this.result = r100;
    }

    public void setUUID(String r100) {
        this.uuid = r100;
    }
}
