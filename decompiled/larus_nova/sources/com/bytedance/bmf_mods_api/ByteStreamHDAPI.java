package com.bytedance.bmf_mods_api;

import android.content.Context;

/* JADX INFO: loaded from: classes44.dex */
public interface ByteStreamHDAPI {
    void DownloadModel(Context r100, ByteStreamHDConfig r101);

    void Free();

    ByteStreamHDInfo GetReport();

    int GetResult();

    int Init(int r100, int r101, int r102, int r103, int r104, String r105, String r106, ByteStreamHDConfig r107);

    int ProcessTexture(int r100, boolean r101, int r102, int r103, float[] r104, int r105, boolean r106, int r107, int r108);

    void SetDownloadCallback(ByteStreamHDCallbackAPI r100);
}
