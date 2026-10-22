package com.bytedance.bmf_mods_api;

import android.content.Context;

/* JADX INFO: loaded from: classes44.dex */
class ByteStreamHDDefault implements ByteStreamHDAPI {
    public ByteStreamHDDefault() {
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public void DownloadModel(Context r100, ByteStreamHDConfig r101) {
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public void Free() {
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public int GetResult() {
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public int Init(int r100, int r101, int r102, int r103, int r104, String r105, String r106, ByteStreamHDConfig r107) {
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public int ProcessTexture(int r100, boolean r101, int r102, int r103, float[] r104, int r105, boolean r106, int r107, int r108) {
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public void SetDownloadCallback(ByteStreamHDCallbackAPI r100) {
    }

    @Override // com.bytedance.bmf_mods_api.ByteStreamHDAPI
    public ByteStreamHDInfo GetReport() {
        return new ByteStreamHDInfo();
    }
}
