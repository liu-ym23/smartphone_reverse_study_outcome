package com.bytedance.bmf_mods_api;

/* JADX INFO: loaded from: classes44.dex */
public interface DenoiseAPI {
    void Free();

    int[] GetReport();

    int GetResult();

    int Init(int r100, int r101, int r102, int r103, int r104, int r105, boolean r106, String r107, int r108, int r110, int r111, int r112, int r113);

    int Init(int r100, int r101, int r102, boolean r103, String r104, int r105, int r106, int r107, int r108);

    int ProcessOesTexture(int r100, int r101, int r102, float[] r103, int r104, boolean r105);

    int ProcessTexture(int r100, int r101, int r102, int r103, boolean r104);

    int ProcessTexture(int r100, boolean r101, int r102, int r103, float[] r104, int r105, boolean r106, int r107);
}
