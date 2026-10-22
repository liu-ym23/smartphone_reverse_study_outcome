package com.bytedance.bmf_mods_api;

import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes44.dex */
public interface ColorHistAPI {
    void Free();

    JsonObject GetResult();

    int Init(int r100, int r101, int r102, int r103, int r104);

    int ProcessOesTexture(int r100, int r101, int r102, float[] r103, long r104);

    int ProcessTexture(int r100, int r101, int r102, long r103);

    int ResetStatus();
}
