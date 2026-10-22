package com.bytedance.realx.video;

import com.bytedance.realx.base.RefCountDelegate;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
public class NV21Buffer implements VideoFrame.Buffer {
    private final byte[] data;
    private final int height;
    private final RefCountDelegate refCountDelegate;
    private final int stride;
    private final int width;

    private static native void nativeCropAndScale(int r100, int r101, int r102, int r103, int r104, int r105, byte[] r106, int r107, int r108, ByteBuffer r109, int r110, ByteBuffer r111, int r112, ByteBuffer r113, int r114);

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getBufferType() {
        return 2;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        int r100 = this.stride;
        int r101 = this.height;
        return (VideoFrame.I420Buffer) cropAndScale(0, 0, r100, r101, r100, r101);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public final /* synthetic */ VideoFrame.NV12Buffer toNV12() {
        return VideoFrame.Buffer.CC.$default$toNV12(this);
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

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    public NV21Buffer(byte[] r100, int r101, int r102, Runnable r103) {
        this.data = r100;
        this.width = r101;
        this.stride = r101;
        this.height = r102;
        this.refCountDelegate = new RefCountDelegate(r103);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int r100, int r101, int r102, int r103) {
        JavaI420Buffer r104 = JavaI420Buffer.allocate(r100, r101);
        if (r104 != null) goto L6;
        return null;
    L6:
        return r104;
    }

    public NV21Buffer(byte[] r100, int r101, int r102, int r103, Runnable r104) {
        this.data = r100;
        this.stride = r101;
        this.width = r102;
        this.height = r103;
        this.refCountDelegate = new RefCountDelegate(r104);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int r110, int r111, int r210, int r211, int r212, int r213) {
        JavaI420Buffer r100 = JavaI420Buffer.allocate(r212, r213);
        if (r100 != null) goto L6;
        return null;
    L6:
        nativeCropAndScale(r110, r111, r210, r211, r212, r213, this.data, this.stride, this.height, r100.getDataY(), r100.getStrideY(), r100.getDataU(), r100.getStrideU(), r100.getDataV(), r100.getStrideV());
        return r100;
    }
}
