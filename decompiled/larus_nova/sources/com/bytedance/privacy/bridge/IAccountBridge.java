package com.bytedance.privacy.bridge;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IAccountBridge {
    String onGetDeviceId();

    String onGetUDID();

    String onGetUserId();

    Map<String, String> onGetXttTokenMap();

    boolean onIsAccountLogin();

    void onTeaEvent(String r100, JSONObject r101);
}
