package com.bytedance.bmf_mods_api;

/* JADX INFO: loaded from: classes44.dex */
public interface TdiLiteStrategyAPI {
    void Free();

    int GetResult(float[] r100);

    int Init(int r100, int r101, int r102, int r103, String r104, String r105, String r106, int r107);

    int Process(double[] r100, double[] r101, double[] r102, double[] r103, int r104, int r105);
}
