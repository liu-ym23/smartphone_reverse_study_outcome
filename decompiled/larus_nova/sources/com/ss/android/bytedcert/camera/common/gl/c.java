package com.ss.android.bytedcert.camera.common.gl;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements ImageDecoder.OnHeaderDecodedListener {
    public c() {
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public final void onHeaderDecoded(ImageDecoder r100, ImageDecoder.ImageInfo r101, ImageDecoder.Source r102) {
        r100.setAllocator(1);
        r100.setMutableRequired(false);
        r100.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));     // Catch: Throwable -> L5
        return;
    }
}
