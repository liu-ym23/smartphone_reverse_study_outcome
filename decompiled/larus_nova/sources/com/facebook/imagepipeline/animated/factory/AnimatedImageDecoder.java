package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes23.dex */
public interface AnimatedImageDecoder {
    AnimatedImage decode(long r100, int r101);

    AnimatedImage decode(ByteBuffer r100);
}
