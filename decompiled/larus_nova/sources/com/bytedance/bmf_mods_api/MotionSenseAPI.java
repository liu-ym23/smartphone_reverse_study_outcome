package com.bytedance.bmf_mods_api;

/* JADX INFO: loaded from: classes44.dex */
public interface MotionSenseAPI {
    void Free();

    float[] GetResult();

    int Init(int r100, int r101, int r102, int r103, String r104, int r105, int r106);

    int Process(float r100, int r101, float[] r102, float[] r103, float[] r104, int[] r105, boolean r106, boolean r107);
}
