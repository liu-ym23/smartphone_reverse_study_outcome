package com.bytedance.badger.collect.impl.interfaces;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ICommonConfig {
    String getDeviceId();

    Map<String, String> getRequestHeaderTag();

    int getSampleRate();

    void onEventDepend(String r100, JSONObject r101);
}
