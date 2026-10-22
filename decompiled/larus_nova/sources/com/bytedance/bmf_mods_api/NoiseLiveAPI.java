package com.bytedance.bmf_mods_api;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public interface NoiseLiveAPI {
    void DownloadModel(Context r100, Map<String, String> r101);

    void Free();

    boolean Init(int r100);

    boolean Init(int r100, int r101);

    float Process(int r100, int r101, int r102);

    void SetCallback(NoiseLiveCallbackAPI r100);
}
