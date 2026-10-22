package com.bytedance.bmf_mods_api;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
class VqscoreLiveAPIDefault implements VqscoreLiveAPI {
    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public void DownloadModel(Context r100, Map<String, String> r101) {
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public void Free() {
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public String GetDownloadedModelPath() {
        return null;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int Init(int r100, int r101, int r102, int r103, boolean r104, String r105, int r106) {
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int Init(int r100, int r101, boolean r102, String r103) {
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int Init(int r100, int r101, boolean r102, String r103, int r104) {
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int Init(int r100, boolean r101) {
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public float Process(int r100, int r101, int r102) {
        return 0.0f;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int ProcessAsync(int r100, int r101, int r102, long r103) {
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int ProcessOesAsync(int r100, int r101, int r102, float[] r103, long r104) {
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public void SetCallback(VqscoreLiveCallbackAPI r100) {
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public void SetDownloadCallback(VqscoreLiveCallbackAPI r100) {
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public void SetProcessCallback(VqscoreProcessCallbackAPI r100) {
    }

    public VqscoreLiveAPIDefault() {
    }
}
