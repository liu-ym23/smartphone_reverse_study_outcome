package com.bytedance.bmf_mods_api;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public interface NoiseDetectAPI {
    void DownloadModel(Context r100, Map<String, String> r101);

    void Free();

    int Init(int r100, int r101, boolean r102, String r103);

    float Process(int r100, int r101, int r102);

    void SetCallback(NoiseDetectCallbackAPI r100);
}
