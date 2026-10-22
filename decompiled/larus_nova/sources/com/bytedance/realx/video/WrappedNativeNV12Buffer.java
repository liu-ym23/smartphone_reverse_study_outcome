package com.bytedance.realx.video;

import com.bytedance.realx.base.JniCommon;
import com.bytedance.realx.base.RXLogging;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
public class WrappedNativeNV12Buffer implements VideoFrame.NV12Buffer {
    private static final String TAG = "WrappedNativeNV12Buffer";
    private final ByteBuffer dataUV;
    private final ByteBuffer dataY;
    private final int height;
    private final long nativeBuffer;
    private final int strideUV;
    private final int strideY;
    private final int width;

    private static native void nativeNV12ToI420(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, ByteBuffer r106, int r107, ByteBuffer r108, int r109, int r110, int r111);

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.NV12Buffer, com.bytedance.realx.video.VideoFrame.Buffer
    public final /* synthetic */ int getBufferType() {
        return VideoFrame.NV12Buffer.CC.$default$getBufferType(this);
    }

    @Override // com.bytedance.realx.video.VideoFrame.NV12Buffer
    public ByteBuffer getDataUV() {
        return this.dataUV.slice();
    }

    @Override // com.bytedance.realx.video.VideoFrame.NV12Buffer
    public ByteBuffer getDataY() {
        return this.dataY.slice();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void release() {
        JniCommon.nativeReleaseRef(this.nativeBuffer);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        JniCommon.nativeAddRef(this.nativeBuffer);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        JavaI420Buffer r100 = JavaI420Buffer.allocate(this.width, this.height);
        if (r100 != null) goto L6;
        return null;
    L6:
        nativeNV12ToI420(this.dataY, this.strideY, this.dataUV, this.strideUV, r100.getDataY(), r100.getStrideY(), r100.getDataU(), r100.getStrideU(), r100.getDataV(), r100.getStrideV(), this.width, this.height);
        return r100;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // com.bytedance.realx.video.VideoFrame.NV12Buffer
    public int getStrideUV() {
        return this.strideUV;
    }

    @Override // com.bytedance.realx.video.VideoFrame.NV12Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.NV12Buffer toNV12() {
        retain();
        return this;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int r100, int r101, int r102, int r103) {
        RXLogging.e(TAG, "scaleAndFill has not been implemented, default return null");
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int r100, int r101, int r102, int r103, int r104, int r105) {
        RXLogging.e(TAG, "cropAndScale has not been implemented, default return null");
        return null;
    }

    public WrappedNativeNV12Buffer(int r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, long r106) {
        this.width = r100;
        this.height = r101;
        this.dataY = r102;
        this.strideY = r103;
        this.dataUV = r104;
        this.strideUV = r105;
        this.nativeBuffer = r106;
        retain();
    }
}
