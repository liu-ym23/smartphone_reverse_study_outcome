package com.dtf.toyger.base.algorithm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.ec.slice.SliceInitService;
import com.dtf.face.config.Upload;
import com.dtf.face.log.RecordService;
import hs7.a;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerCommonConfig {
    public String extraConfig;
    public int logLevel;
    public int productCode;
    public long useXNN;

    public ToygerCommonConfig() {
        this.logLevel = 0;
        this.productCode = 0;
        this.useXNN = 0;
        this.extraConfig = SliceInitService.DEFAULT_SWITCH;
    }

    public void parseConfig(Map<String, Object> r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L14;
    L16:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    L18:
        r101.put2("canContinueDetectAction", Boolean.FALSE);
        this.extraConfig = r101.toJSONString();
        return;
    L5:
        if (r100.containsKey("upload") == false) goto L14;
        Object r102 = r100.get("upload");     // Catch: Throwable -> L16
        if ((r102 instanceof Upload) == false) goto L14;
        if (((Upload) r102).captureConfig == null) goto L12;
        r101.put2("captureConfig", ((Upload) r102).captureConfig);     // Catch: Throwable -> L16
    L12:
        JSONObject r103 = (JSONObject) JSON.toJSON(r102);     // Catch: Throwable -> L16
        r103.remove("captureConfig");     // Catch: Throwable -> L16
        r101.put2("blobConfig", r103);     // Catch: Throwable -> L16
    L14:
        r101.put2("wlclientcfg", a.h().c().clientExtParams);     // Catch: Throwable -> L16
        goto L18
    }
}
