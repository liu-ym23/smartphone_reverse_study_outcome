package com.facebook.imagepipeline.nativecode;

import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes23.dex */
public interface WebpTranscoder {
    boolean isWebpNativelySupported(ImageFormat r100);

    void transcodeWebpToJpeg(InputStream r100, OutputStream r101, int r102) throws IOException;

    void transcodeWebpToPng(InputStream r100, OutputStream r101) throws IOException;
}
