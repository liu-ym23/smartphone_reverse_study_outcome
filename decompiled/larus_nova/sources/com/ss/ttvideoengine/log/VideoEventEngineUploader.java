package com.ss.ttvideoengine.log;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface VideoEventEngineUploader {
    void onEvent(String r100, JSONObject r101);

    void onEventV2(String r100, JSONObject r101);
}
