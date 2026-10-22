package com.bytedance.apm.agent.helper;

import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.agent.v2.InstructOperationSwitch;
import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class PageShowCallback {
    public PageShowCallback() {
    }

    public static void onPageShowHideAction(Object r3, boolean r4) {
        if (InstructOperationSwitch.sUiSwitch == true) goto L6;
        return;
    L6:
        if ((r3 instanceof String) == false) goto L8;
        String r0 = (String) r3;
    L9:
        JSONObject r1 = new JSONObject();
        if ((r3 instanceof IPageMonitor) == false) goto L15;
        r1.put("label", ((IPageMonitor) r3).getMonitorLabel());     // Catch: Exception -> L14
    L15:
        if (r4 == false) goto L17;
        String r5 = "page_show";
    L18:
        if (r4 == false) goto L20;
        ApmDelegate.g.a.a().getClass();
    L20:
        MonitorTool.monitorUIAction(r5, r0, r1);
        return;
    L17:
        r5 = "page_hide";
        goto L18
    L8:
        r0 = r3.getClass().getName();
        goto L9
    }
}
