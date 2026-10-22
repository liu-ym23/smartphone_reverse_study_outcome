package com.ss.texturerender.producer;

import android.os.Handler;
import com.ss.texturerender.IFrameAvailableListener;
import com.ss.texturerender.effect.EffectTexture;

/* JADX INFO: loaded from: classes40.dex */
public interface IFrameProducer {
    EffectTexture getEffectTexture();

    int getProducerType();

    long getTimestamp();

    void getTransformMatrix(float[] r100);

    void release();

    void releaseOffScreenSurface();

    void setOnFrameAvailableListener(IFrameAvailableListener r100, Handler r101);

    void updateImage();

    void updateTexDimension(int r100, int r101);
}
