package com.bytedance.common.jato;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JatoFeatureReporter {
    public static boolean isEnabled() {
        JatoXLConfig r100 = JatoXL.getConfig();
        if (r100 == null) goto L5;
        r100.getReporter();
    L5:
        return false;
    }

    public static JSONObject putExtra(JSONObject r100, String r101, Object r102) {
        return r100.put(r101, r102);
    L7:
        return r100;
    }

    public static void reportResult(String r100, int r101, long r102, JSONObject r103) {
        JatoXL.getConfig().getReporter();
    }
}
