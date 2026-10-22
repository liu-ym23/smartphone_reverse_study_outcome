package com.bytedance.badger.collect.impl.monitor.pseudo;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.monitor.AbsMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public class MobileInitMonitor extends AbsMonitor {
    private String networkType;
    private String operatorName;
    private String uuid;

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public String getEventName() {
        return Constants.EventName.MOBILE_INIT;
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public void clear() {
        this.operatorName = "";
        this.networkType = "";
    }

    @Override // com.bytedance.badger.collect.impl.monitor.AbsMonitor
    public JSONObject getParams() throws Exception {
        JSONObject r100 = new JSONObject();
        r100.put("operatorName", this.operatorName);
        r100.put("networkType", this.networkType);
        r100.put("cdid", this.uuid);
        return r100;
    }

    public MobileInitMonitor() {
    }

    public void setNetworkType(String r100) {
        this.networkType = r100;
    }

    public void setOperatorName(String r100) {
        this.operatorName = r100;
    }

    public void setUUID(String r100) {
        this.uuid = r100;
    }
}
