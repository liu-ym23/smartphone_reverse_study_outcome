package com.bytedance.bmf_mods_api;

/* JADX INFO: loaded from: classes44.dex */
public interface VideoSRLutDspAPI {
    void Free();

    int[] GetTextures();

    boolean Init(int r100, int r101, String r102);

    int Process();
}
