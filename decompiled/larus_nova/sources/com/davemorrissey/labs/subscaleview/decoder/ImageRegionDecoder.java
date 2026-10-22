package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

/* JADX INFO: loaded from: classes22.dex */
public interface ImageRegionDecoder {
    Bitmap decodeRegion(Rect r100, int r101);

    Point init(Context r100, Uri r101) throws Exception;

    boolean isReady();

    void recycle();
}
