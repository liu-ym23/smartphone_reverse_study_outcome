package com.bytedance.bmmt.video.memory;

import android.graphics.Matrix;
import android.opengl.EGLContext;
import com.bytedance.bmmt.video.PixelFormat;
import com.bytedance.bmmt.video.VideoRotation;
import com.bytedance.bmmt.video.VideoScaleFilter;

/* JADX INFO: loaded from: classes8.dex */
public interface BmmtVideoOpenGLMemoryInterface extends BmmtVideoMemoryInterface {
    Matrix getAndroidTextureMatrix();

    EGLContext getEGLContext();

    long getGLSync();

    long getNativeEGLContext();

    VideoRotation getRotation();

    VideoScaleFilter getScaleFilter();

    int getTextureId();

    float[] getTextureMatrix();

    PixelFormat getTextureTarget();

    int getUnScaledHeight();

    int getUnScaledWidth();
}
