package com.bytedance.bmf_mods_api;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes44.dex */
public interface VideoSuperResolutionAPI {
    void Free();

    int GetQueuingTaskNum();

    int Init(int r100, int r101, int r102, int r103, String r104, String r105);

    int Init(int r100, int r101, int r102, int r103, String r104, String r105, String r106);

    int Init(int r100, int r101, int r102, int r103, String r104, String r105, String r106, int r107, int r108);

    int Init(int r100, int r101, int r102, int r103, String r104, String r105, String r106, int r107, int r108, int r110);

    Bitmap ProcessBitmap(Bitmap r100, int r101, int r102) throws BmfException;

    Bitmap ProcessMultiScaleBitmap(Bitmap r100, int r101, int r102) throws BmfException;

    int ProcessOesTexture(int r100, int r101, int r102, float[] r103);

    int ProcessOesTexture(int r100, int r101, int r102, float[] r103, int r104, int r105, int r106, int r107, int r108, long r110);

    int ProcessOesTexture(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106);

    int ProcessTexture(int r100, int r101, int r102);

    int ProcessTexture(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, long r108);

    int ProcessYuv420p(long r100, long r101, long r102, int r103, int r104, int r105, int r110);
}
