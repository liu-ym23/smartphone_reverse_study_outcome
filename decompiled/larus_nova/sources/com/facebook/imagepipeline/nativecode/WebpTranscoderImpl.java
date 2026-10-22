package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes23.dex */
public class WebpTranscoderImpl implements WebpTranscoder {
    public WebpTranscoderImpl() {
    }

    private static native void nativeTranscodeWebpToJpeg(InputStream r100, OutputStream r101, int r102) throws IOException;

    private static native void nativeTranscodeWebpToPng(InputStream r100, OutputStream r101) throws IOException;

    @Override // com.facebook.imagepipeline.nativecode.WebpTranscoder
    public boolean isWebpNativelySupported(ImageFormat r100) {
        if (r100 != DefaultImageFormats.WEBP_SIMPLE) goto L7;
        return true;
    L7:
        if (r100 == DefaultImageFormats.WEBP_LOSSLESS) goto L20;
        if (r100 == DefaultImageFormats.WEBP_EXTENDED) goto L20;
        if (r100 == DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA) goto L20;
        if (r100 != DefaultImageFormats.WEBP_ANIMATED) goto L18;
        return false;
    L18:
        throw new IllegalArgumentException("Image format is not a WebP.");
    L20:
        return WebpSupportStatus.sIsExtendedWebpSupported;
    }

    @Override // com.facebook.imagepipeline.nativecode.WebpTranscoder
    public void transcodeWebpToPng(InputStream r100, OutputStream r101) throws IOException {
        StaticWebpNativeLoader.ensure();
        nativeTranscodeWebpToPng((InputStream) Preconditions.checkNotNull(r100), (OutputStream) Preconditions.checkNotNull(r101));
    }

    @Override // com.facebook.imagepipeline.nativecode.WebpTranscoder
    public void transcodeWebpToJpeg(InputStream r100, OutputStream r101, int r102) throws IOException {
        StaticWebpNativeLoader.ensure();
        nativeTranscodeWebpToJpeg((InputStream) Preconditions.checkNotNull(r100), (OutputStream) Preconditions.checkNotNull(r101), r102);
    }
}
