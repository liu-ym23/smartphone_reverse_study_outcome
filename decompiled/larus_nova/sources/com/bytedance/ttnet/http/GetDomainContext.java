package com.bytedance.ttnet.http;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class GetDomainContext {
    public boolean addCommonParam;
    public String errMsg;
    public String localSign;
    public String logid;
    public long queryTime;
    public String rawSign;
    public String ssSign;
    public int status;
    public String tncAbTest;
    public String tncCanary;
    public String tncConfigId;
    public String tncControl;
    public String tncEtag;
    public String tncQueryRegion;
    public String url;
    public boolean useHttps;

    public JSONObject toJson() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("status", this.status);
        r100.put("url", this.url);
        r100.put("query_time", this.queryTime);
        if (this.useHttps == true) goto L6;
        r100.put("raw_sign", this.rawSign);
        r100.put("ss_sign", this.ssSign);
        r100.put("local_sign", this.localSign);
    L6:
        if (StringUtils.isEmpty(this.errMsg) == true) goto L8;
        r100.put(LocationMonitorConst.ERR_MSG, this.errMsg);
    L8:
        return r100;
    }

    public GetDomainContext() {
        this.errMsg = "";
        this.addCommonParam = true;
    }
}
