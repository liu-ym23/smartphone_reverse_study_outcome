package com.bytedance.ee.plugin.common.pdftron;

import android.graphics.Bitmap;
import com.bytedance.ee.plugin.common.pdftron.wrapper.Page;

/* JADX INFO: loaded from: classes19.dex */
public interface IPDFDrawWrapper {
    void destroy();

    Bitmap requestBitmap(Page r100, int r101, int r102, Bitmap.Config r103) throws Throwable;

    void setDrawAnnotations(boolean r100);

    void setImageSize(int r100, int r101, boolean r102);

    void setPageTransparent(boolean r100);
}
