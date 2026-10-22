package com.bytedance.bmf_mods_api;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public interface VqscoreLiveAPI {
    void DownloadModel(Context r100, Map<String, String> r101);

    void Free();

    String GetDownloadedModelPath();

    int Init(int r100, int r101, int r102, int r103, boolean r104, String r105, int r106);

    int Init(int r100, int r101, boolean r102, String r103);

    int Init(int r100, int r101, boolean r102, String r103, int r104);

    int Init(int r100, boolean r101);

    float Process(int r100, int r101, int r102);

    int ProcessAsync(int r100, int r101, int r102, long r103);

    int ProcessOesAsync(int r100, int r101, int r102, float[] r103, long r104);

    void SetCallback(VqscoreLiveCallbackAPI r100);

    void SetDownloadCallback(VqscoreLiveCallbackAPI r100);

    void SetProcessCallback(VqscoreProcessCallbackAPI r100);
}
