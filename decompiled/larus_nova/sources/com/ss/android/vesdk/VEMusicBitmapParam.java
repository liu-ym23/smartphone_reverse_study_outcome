package com.ss.android.vesdk;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes40.dex */
public class VEMusicBitmapParam {
    public int lineCnt;
    public Bitmap lyricsBitmap;

    public void recycleBitmap(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isRecycled() == true) goto L8;
        r100.recycle();
        return;
    }

    public VEMusicBitmapParam(Bitmap r100, int r101) {
        this.lyricsBitmap = r100;
        this.lineCnt = r101;
    }
}
