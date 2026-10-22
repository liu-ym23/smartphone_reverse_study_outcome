package com.bytedance.bdp.bdpbase.core.preload;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public abstract class AbsBdpAppPreloadListener implements BdpAppPreloadListener {
    public AbsBdpAppPreloadListener() {
    }

    @Override // com.bytedance.bdp.bdpbase.core.preload.BdpAppPreloadListener
    public abstract void onPreloadFinish(int r100, String r101, JSONObject r102);

    @Override // com.bytedance.bdp.bdpbase.core.preload.BdpAppPreloadListener
    public void onPreloadPause(String r100) {
    }

    @Override // com.bytedance.bdp.bdpbase.core.preload.BdpAppPreloadListener
    public void onPreloadProgress(int r100) {
    }

    @Override // com.bytedance.bdp.bdpbase.core.preload.BdpAppPreloadListener
    public void onPreloadResume() {
    }

    @Override // com.bytedance.bdp.bdpbase.core.preload.BdpAppPreloadListener
    public void onPreloadStart() {
    }
}
