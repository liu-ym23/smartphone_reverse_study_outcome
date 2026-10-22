package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.EncodedImage;

/* JADX INFO: loaded from: classes23.dex */
public class DecodeException extends RuntimeException {
    private final EncodedImage mEncodedImage;

    public EncodedImage getEncodedImage() {
        return this.mEncodedImage;
    }

    public DecodeException(String r100, EncodedImage r101) {
        super(r100);
        this.mEncodedImage = r101;
    }

    public DecodeException(String r100, Throwable r101, EncodedImage r102) {
        super(r100, r101);
        this.mEncodedImage = r102;
    }
}
