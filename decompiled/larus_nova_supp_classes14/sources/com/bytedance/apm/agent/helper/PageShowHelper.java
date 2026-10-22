package com.bytedance.apm.agent.helper;

import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class PageShowHelper {
    public PageShowHelper() {
    }

    public static void onPageShowHideAction(Object r3, boolean r4) {
        if ((r3 instanceof String) == false) goto L5;
        String r0 = (String) r3;
    L6:
        JSONObject r1 = new JSONObject();
        if ((r3 instanceof IPageMonitor) == false) goto L12;
        r1.put("label", ((IPageMonitor) r3).getMonitorLabel());     // Catch: Exception -> L11
    L12:
        if (r4 == false) goto L14;
        String r5 = "page_show";
    L15:
        if (r4 == false) goto L17;
        ApmDelegate.g.a.a().getClass();
    L17:
        MonitorTool.monitorUIAction(r5, r0, r1);
        return;
    L14:
        r5 = "page_hide";
        goto L15
    L5:
        r0 = r3.getClass().getName();
        goto L6
    }
}
