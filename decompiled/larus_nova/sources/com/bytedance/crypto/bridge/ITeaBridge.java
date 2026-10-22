package com.bytedance.crypto.bridge;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public interface ITeaBridge {
    String onGetDeviceId();

    void onTeaEvent(String r100, JSONObject r101);
}
