package com.bytedance.bmf_mods_api;

/* JADX INFO: loaded from: classes44.dex */
public interface VideoBrightAPI {
    void Free();

    int GetStatus();

    boolean Init(int r100, int r101, int r102, int r103);

    int Process(int r100, int r101, int r102, int r103, long r104);

    void SetCallback(VideoBrightCallbackAPI r100);
}
