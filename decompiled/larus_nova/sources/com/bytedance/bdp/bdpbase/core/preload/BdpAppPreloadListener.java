package com.bytedance.bdp.bdpbase.core.preload;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public interface BdpAppPreloadListener {
    void onPreloadFinish(int r100, String r101, JSONObject r102);

    void onPreloadPause(String r100);

    void onPreloadProgress(int r100);

    void onPreloadResume();

    void onPreloadStart();
}
