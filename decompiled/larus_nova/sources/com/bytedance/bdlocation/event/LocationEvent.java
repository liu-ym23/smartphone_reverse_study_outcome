package com.bytedance.bdlocation.event;

import com.bytedance.bdlocation.client.BDLocationConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class LocationEvent {
    private static IEventManager sEventManager;

    public LocationEvent() {
    }

    public static void onRequestPermission() {
        onEventV3(LocationEventConst.EVENT_WHEN_IN_USE);
    }

    private static void onEventV3(String r100) {
        onEventV3(r100, null);
    }

    private static void onEventV3(String r100, JSONObject r101) {
        if (sEventManager != null) goto L5;
        sEventManager = BDLocationConfig.getEventManager();
    L5:
        IEventManager r102 = sEventManager;
        if (r102 == null) goto L9;
        r102.onEventV3(r100, r101);
        return;
    }
}
