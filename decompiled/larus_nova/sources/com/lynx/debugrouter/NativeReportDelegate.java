package com.lynx.debugrouter;

import com.lynx.debugrouter.base.report.DebugRouterReportServiceUtil;
import com.lynx.debugrouter.log.LLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class NativeReportDelegate {
    private static final String TAG = "NativeReportDelegate";

    public NativeReportDelegate() {
    }

    private static JSONObject stringToJSONObject(String r100, String r101) {
        return new JSONObject(r101);
    L4:
        e = move-exception;
        LLog.e(TAG, "Failed to parse " + r100 + " JSON: " + e.getMessage());
        return new JSONObject();
    }

    public void report(String r100, String r101, String r102, String r103) {
        LLog.i(TAG, "report: " + r100 + ", " + r101 + ", " + r102 + ", " + r103);
        DebugRouterReportServiceUtil.report(r100, stringToJSONObject("category", r101), stringToJSONObject("metric", r102), stringToJSONObject("extra", r103));
    }
}
