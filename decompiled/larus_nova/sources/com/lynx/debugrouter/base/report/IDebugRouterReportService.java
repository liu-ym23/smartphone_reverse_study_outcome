package com.lynx.debugrouter.base.report;

import com.lynx.debugrouter.base.service.IRouterServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public interface IDebugRouterReportService extends IRouterServiceProvider {
    void init(DebugRouterMetaInfo r100);

    void report(String r100, JSONObject r101, JSONObject r102, JSONObject r103);
}
