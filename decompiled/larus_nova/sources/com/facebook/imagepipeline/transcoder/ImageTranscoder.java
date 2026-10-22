package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public interface ImageTranscoder {
    boolean canResize(EncodedImage r100, @Nullable RotationOptions r101, @Nullable ResizeOptions r102);

    boolean canTranscode(ImageFormat r100);

    String getIdentifier();

    ImageTranscodeResult transcode(EncodedImage r100, OutputStream r101, @Nullable RotationOptions r102, @Nullable ResizeOptions r103, @Nullable ImageFormat r104, @Nullable Integer r105) throws IOException;
}
