package com.ss.bytertc.engine.mediaio;

import com.bytedance.realx.video.JavaI420Buffer;
import com.bytedance.realx.video.VideoFrame;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import ujc.a;

/* JADX INFO: loaded from: classes40.dex */
public class CountDownLatchI420Buffer implements VideoFrame.I420Buffer {
    private final JavaI420Buffer buffer;
    private final CountDownLatch mCountDownLatch;
    private Runnable mCustomReleaseCallback;

    public static /* synthetic */ void a(CountDownLatchI420Buffer r100, Runnable r101) {
        r100.lambda$new$0(r101);
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer, com.bytedance.realx.video.VideoFrame.Buffer
    public final /* synthetic */ int getBufferType() {
        return VideoFrame.I420Buffer.CC.$default$getBufferType(this);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public final /* synthetic */ VideoFrame.NV12Buffer toNV12() {
        return VideoFrame.Buffer.CC.$default$toNV12(this);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return this.buffer.copyData();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        return this.buffer.getDataU();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        return this.buffer.getDataV();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public ByteBuffer getDataY() {
        return this.buffer.getDataY();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getHeight() {
        return this.buffer.getHeight();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.buffer.getStrideU();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.buffer.getStrideV();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.buffer.getStrideY();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return this.buffer.getWidth();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void release() {
        this.buffer.release();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        this.buffer.retain();
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        return this.buffer.toI420();
    }

    public CountDownLatch getLatch() {
        return this.mCountDownLatch;
    }

    private /* synthetic */ void lambda$new$0(Runnable r100) {
        this.mCountDownLatch.countDown();
        if (this.mCustomReleaseCallback == null) goto L6;
        r100.run();
        return;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int r100, int r101, int r102, int r103) {
        return this.buffer.scaleAndFill(r100, r101, r102, r103);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int r100, int r101, int r110, int r111, int r112, int r113) {
        return this.buffer.cropAndScale(r100, r101, r110, r111, r112, r113);
    }

    private CountDownLatchI420Buffer(int r110, int r111, ByteBuffer r112, int r113, ByteBuffer r114, int r115, ByteBuffer r210, int r211, final Runnable r212) {
        this.mCountDownLatch = new CountDownLatch(1);
        this.mCustomReleaseCallback = r212;
        this.buffer = JavaI420Buffer.wrap(r110, r111, r112, r113, r114, r115, r210, r211, new a(this, r212));
    }

    public static CountDownLatchI420Buffer wrap(int r110, int r111, ByteBuffer r112, int r113, ByteBuffer r114, int r115, ByteBuffer r116, int r117, Runnable r118) {
        return new CountDownLatchI420Buffer(r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }
}
