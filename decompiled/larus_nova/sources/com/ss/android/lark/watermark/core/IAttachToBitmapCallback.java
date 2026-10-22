package com.ss.android.lark.watermark.core;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes38.dex */
public interface IAttachToBitmapCallback {
    void onAttachFailed(Bitmap r100, String r101);

    void onAttachSuccess(Bitmap r100);
}
