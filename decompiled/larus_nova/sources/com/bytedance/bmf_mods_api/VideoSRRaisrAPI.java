package com.bytedance.bmf_mods_api;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes44.dex */
public interface VideoSRRaisrAPI {
    void Free();

    boolean Init(String r100, int r101, boolean r102, int r103, int r104);

    boolean Init(String r100, int r101, boolean r102, int r103, int r104, int r105);

    int OesProcess(int r100, int r101, int r102, int r103, float[] r104, boolean r105);

    int Process(int r100, int r101, int r102, int r103, boolean r104);

    Bitmap Process(Bitmap r100, int r101, int r102, boolean r103);
}
