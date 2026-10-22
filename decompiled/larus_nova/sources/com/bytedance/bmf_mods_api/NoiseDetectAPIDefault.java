package com.bytedance.bmf_mods_api;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
class NoiseDetectAPIDefault implements NoiseDetectAPI {
    @Override // com.bytedance.bmf_mods_api.NoiseDetectAPI
    public void DownloadModel(Context r100, Map<String, String> r101) {
    }

    @Override // com.bytedance.bmf_mods_api.NoiseDetectAPI
    public void Free() {
    }

    @Override // com.bytedance.bmf_mods_api.NoiseDetectAPI
    public int Init(int r100, int r101, boolean r102, String r103) {
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.NoiseDetectAPI
    public float Process(int r100, int r101, int r102) {
        return 0.0f;
    }

    @Override // com.bytedance.bmf_mods_api.NoiseDetectAPI
    public void SetCallback(NoiseDetectCallbackAPI r100) {
    }

    public NoiseDetectAPIDefault() {
    }
}
