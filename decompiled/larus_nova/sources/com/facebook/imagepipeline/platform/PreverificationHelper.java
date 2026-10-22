package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
class PreverificationHelper {
    public PreverificationHelper() {
    }

    public boolean shouldUseHardwareBitmapConfig(Bitmap.Config r100) {
        if (r100 != Bitmap.Config.HARDWARE) goto L5;
        return true;
    L5:
        return false;
    }
}
