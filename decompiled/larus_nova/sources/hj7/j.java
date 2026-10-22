package hj7;

import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.bytedance.ug.sdk.luckycat.impl.utils.LuckyCatUtils;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class j {
    public j() {
    }

    @BridgeMethod("luckycatSendCustomReport")
    public void sendCustomReport(@BridgeContext IBridgeContext r100, @BridgeParam("data") JSONObject r101) {
        r100.getWebView();
        LuckyCatUtils.c(r101);
        r100.callback(a.a(1, null, "success"));
    }

    @BridgeMethod("luckycatSendCustomReports")
    public void sendCustomReports(@BridgeContext IBridgeContext r100, @BridgeParam("reports") JSONArray r101) {
        int r102 = 0;
        if (r101 != null) goto L5;
    L19:
        r100.callback(a.a(0, null, "failed"));
        return;
    L5:
        if (r101.length() == 0) goto L19;
    L8:
        if (r102 >= r101.length()) goto L17;
        JSONObject r103 = r101.optJSONObject(r102);
        if (r103 == null) goto L16;
        JSONObject r104 = r103.optJSONObject("data");
        if (r104 == null) goto L16;
        r100.getWebView();
        LuckyCatUtils.c(r104);
    L16:
        r102 = r102 + 1;
        goto L8
    L17:
        r100.callback(a.a(1, null, "success"));
    }

    @BridgeMethod("luckycatSendLogV3s")
    public void sendEventLogs(@BridgeContext IBridgeContext r100, @BridgeParam("events") JSONArray r101) {
        if (r101 != null) goto L5;
    L17:
        r100.callback(a.a(0, null, "failed"));
        return;
    L5:
        if (r101.length() == 0) goto L17;
        int r102 = 0;
    L9:
        if (r102 >= r101.length()) goto L15;
        JSONObject r103 = r101.optJSONObject(r102);
        if (r103 == null) goto L14;
        com.bytedance.ug.sdk.luckycat.impl.model.d.a(r103.optString(ReportCardMonitorPlugin.EVENT_NAME), r103.optJSONObject("params"), false);
    L14:
        r102 = r102 + 1;
        goto L9
    L15:
        r100.callback(a.a(1, null, "success"));
    }

    @BridgeMethod("luckycatSendLogV3")
    public void sendEventLog(@BridgeContext IBridgeContext r100, @BridgeParam(ReportCardMonitorPlugin.EVENT_NAME) String r101, @BridgeParam("params") JSONObject r102) {
        com.bytedance.ug.sdk.luckycat.impl.model.d.a(r101, r102, false);
        r100.callback(a.a(1, null, "success"));
    }
}
