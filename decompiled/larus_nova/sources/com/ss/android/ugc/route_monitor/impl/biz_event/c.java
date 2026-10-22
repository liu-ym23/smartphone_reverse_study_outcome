package com.ss.android.ugc.route_monitor.impl.biz_event;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class c {
    public final String toString() {
        JSONObject r100 = new JSONObject();
        r100.put(ReportCardMonitorPlugin.EVENT_NAME, null);
        r100.put("event_data", null);
        r100.put(BdpAppEventConstant.PARAMS_TIMESTAMP, 0);
        return r100.toString();
    }
}
