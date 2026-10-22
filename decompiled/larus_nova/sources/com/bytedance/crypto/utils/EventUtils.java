package com.bytedance.crypto.utils;

import com.bytedance.crypto.bridge.IEventBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class EventUtils {
    private static IEventBridge mEventBridge;

    public EventUtils() {
    }

    public static void init(IEventBridge r100) {
        mEventBridge = r100;
    }

    public static void onEvent(String r100, JSONObject r101) {
        IEventBridge r102 = mEventBridge;
        if (r102 == null) goto L6;
        r102.onEvent(r100, r101);
        return;
    }
}
