package com.bytedance.services.slardar.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IConfigListener {
    void onReady();

    void onRefresh(JSONObject r100, boolean r101);
}
