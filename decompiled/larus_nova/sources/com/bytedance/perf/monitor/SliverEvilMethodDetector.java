package com.bytedance.perf.monitor;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes21.dex */
public class SliverEvilMethodDetector {
    private static final String TAG = "EvilMethod_Detector";
    private static a mPluginInfoCallBack;
    private static JSONArray pluginInfo;

    public interface a {
    }

    public static void setPluginInfoCallback(a r100) {
    }

    public SliverEvilMethodDetector() {
    }

    public static void setPluginInfo(JSONArray r100) {
        pluginInfo = r100;
    }
}
