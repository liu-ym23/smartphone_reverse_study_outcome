package com.ss.bytertc.engine.data;

import android.opengl.EGLContext;
import com.ss.bytertc.engine.video.FovVideoFrameInfo;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class VideoFrameData {
    public VideoBufferType bufferType;
    public VideoContentType contentType;
    public EGLContext eglContext;
    public FovVideoFrameInfo fovTileInfo;
    public int height;
    public int numberOfPlanes;
    public VideoPixelFormat pixelFormat;
    public ByteBuffer[] planeData;
    public int[] planeStride;
    public ByteBuffer roiData;
    public VideoRotation rotation;
    public ByteBuffer seiData;
    public int textureId;
    public float[] textureMatrix;
    public long timestampUs;
    public int width;

    public VideoFrameData() {
        this.bufferType = VideoBufferType.RAW_MEMORY;
        this.pixelFormat = VideoPixelFormat.UNKNOWN;
        this.contentType = VideoContentType.NORMAL_FRAME;
        this.rotation = VideoRotation.VIDEO_ROTATION_0;
    }
}
