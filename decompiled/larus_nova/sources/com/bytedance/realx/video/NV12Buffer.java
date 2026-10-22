package com.bytedance.realx.video;

import com.bytedance.realx.base.RefCountDelegate;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
public class NV12Buffer implements VideoFrame.NV12Buffer {
    private final ByteBuffer buffer;
    private final ByteBuffer dataUV;
    private final ByteBuffer dataY;
    private final int height;
    private final RefCountDelegate refCountDelegate;
    private final int sliceHeight;
    private final int stride;
    private final int strideUV;
    private final int strideY;
    private final int width;

    private static native void nativeCropAndScale(int r100, int r101, int r102, int r103, int r104, int r105, ByteBuffer r106, int r107, int r108, int r109, int r110, ByteBuffer r111, int r112, ByteBuffer r113, int r114, ByteBuffer r115, int r116);

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.NV12Buffer, com.bytedance.realx.video.VideoFrame.Buffer
    public int getBufferType() {
        return 1;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        int r100 = this.width;
        int r101 = this.height;
        return (VideoFrame.I420Buffer) cropAndScale(0, 0, r100, r101, r100, r101);
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
        this.refCountDelegate.release();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
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
        JavaI420Buffer r104 = JavaI420Buffer.allocate(r100, r101);
        if (r104 != null) goto L6;
        return null;
    L6:
        return r104;
    }

    public NV12Buffer(int r100, int r101, int r102, int r103, ByteBuffer r104, Runnable r105) {
        this.width = r100;
        this.height = r101;
        this.stride = r102;
        this.sliceHeight = r103;
        this.buffer = r104;
        this.strideY = r102;
        this.strideUV = r102;
        int r106 = (r102 * r101) + 0;
        r104.position(0);
        r104.limit(r106);
        this.dataY = r104.slice();
        r104.position(r106);
        r104.limit(r106 + (((r101 + 1) / 2) * r102));
        this.dataUV = r104.slice();
        this.refCountDelegate = new RefCountDelegate(r105);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int r210, int r211, int r212, int r213, int r214, int r215) {
        JavaI420Buffer r100 = JavaI420Buffer.allocate(r214, r215);
        if (r100 != null) goto L6;
        return null;
    L6:
        nativeCropAndScale(r210, r211, r212, r213, r214, r215, this.buffer, this.width, this.height, this.stride, this.sliceHeight, r100.getDataY(), r100.getStrideY(), r100.getDataU(), r100.getStrideU(), r100.getDataV(), r100.getStrideV());
        return r100;
    }
}
