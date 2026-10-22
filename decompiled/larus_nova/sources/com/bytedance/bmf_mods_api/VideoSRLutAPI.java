package com.bytedance.bmf_mods_api;

/* JADX INFO: loaded from: classes44.dex */
public interface VideoSRLutAPI {
    int AsyncProcess(int r100, int r101, int r102, int r103, boolean r104);

    int AsyncWait();

    int ClearClBuffer();

    void Free();

    boolean GlSrInit(String r100, int r101, boolean r102, int r103, int r104);

    boolean Init(int r100);

    boolean Init(String r100, int r101, boolean r102, int r103, int r104);

    boolean Init(String r100, int r101, boolean r102, int r103, int r104, String r105);

    int Process(int r100, int r101, int r102, int r103, boolean r104);

    int Process(long r100, long r101, long r102, int r103, int r104, int r105, int r110);
}
