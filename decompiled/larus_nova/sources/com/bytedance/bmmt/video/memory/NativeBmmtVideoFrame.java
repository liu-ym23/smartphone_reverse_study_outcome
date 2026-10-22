package com.bytedance.bmmt.video.memory;

import com.bytedance.bmmt.video.ColorSpace;
import com.bytedance.bmmt.video.PixelFormat;
import com.bytedance.bmmt.video.VideoFrameHelperInterface;
import com.bytedance.bmmt.video.VideoRotation;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public class NativeBmmtVideoFrame implements BmmtVideoFrameInterface {
    private long nativeHandle;
    RefObject refCounted;

    public static /* synthetic */ void a(NativeBmmtVideoFrame r100) {
        r100.lambda$new$0();
    }

    private static native long nativeCreateVideoFrameFromByteMemory(long r100, int r101, int r102, PixelFormat r103, ByteBuffer[] r104, int[] r105, long r106, ByteBuffer r107, ColorSpace r110, VideoRotation r111);

    private static native long nativeCreateVideoFrameFromOpenGLMemory(long r100, long r101, long r102, ByteBuffer r103, ColorSpace r104, VideoRotation r105);

    private static native ColorSpace nativeGetColorSpace(long r100);

    private static native BmmtVideoMemoryInterface nativeGetFrameMemory(long r100);

    private static native int nativeGetHeight(long r100);

    private static native VideoRotation nativeGetRotation(long r100);

    private static native ByteBuffer nativeGetSupplementData(long r100);

    private static native long nativeGetTimestampNs(long r100);

    private static native long nativeGetTimestampUs(long r100);

    private static native int nativeGetWidth(long r100);

    private static native void nativeReleaseVideoFrame(long r100);

    private static native void nativeSetRotation(long r100, VideoRotation r101);

    private static native void nativeSetTimestampNs(long r100, long r101);

    private static native void nativeSetTimestampUs(long r100, long r101);

    private static native NativeBmmtVideoFrame nativeToI420(long r100);

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface, com.bytedance.bmmt.base.RefCounted
    public synchronized void release() {
        monitor-enter(this);
        this.refCounted.release();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface, com.bytedance.bmmt.base.RefCounted
    public synchronized void retain() {
        monitor-enter(this);
        this.refCounted.retain();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$0() {
        long r100 = this.nativeHandle;
        if (r100 == 0) goto L6;
        nativeReleaseVideoFrame(r100);
        this.nativeHandle = 0;
        return;
    }

    public boolean isNullPointer() {
        if (this.nativeHandle != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public BmmtVideoMemoryInterface getAndRetainVideoFrameMemory() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetFrameMemory(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public ColorSpace getColorSpace() {
        if (isNullPointer() == false) goto L7;
        return ColorSpace.kUnknown;
    L7:
        return nativeGetColorSpace(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public int getHeight() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetHeight(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public int getRotatedHeight() {
        if (isNullPointer() == false) goto L6;
        return 0;
    L6:
        int r100 = nativeGetWidth(this.nativeHandle);
        int r101 = nativeGetHeight(this.nativeHandle);
        if ((getRotation().value() % 180) != 0) goto L9;
        return r101;
    L9:
        return r100;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public int getRotatedWidth() {
        if (isNullPointer() == false) goto L6;
        return 0;
    L6:
        int r100 = nativeGetWidth(this.nativeHandle);
        int r101 = nativeGetHeight(this.nativeHandle);
        if ((getRotation().value() % 180) != 0) goto L9;
        return r100;
    L9:
        return r101;
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public VideoRotation getRotation() {
        if (isNullPointer() == false) goto L7;
        return VideoRotation.VIDEO_ROTATION_0;
    L7:
        return nativeGetRotation(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public ByteBuffer getSupplementData() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetSupplementData(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public long getTimestampNs() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetTimestampNs(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public long getTimestampUs() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetTimestampUs(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public int getWidth() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetWidth(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public BmmtVideoFrameInterface toI420() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeToI420(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    private NativeBmmtVideoFrame(long r100) {
        this.nativeHandle = r100;
        this.refCounted = new RefObject(new b(this));
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public void setRotation(VideoRotation r100) {
        if (isNullPointer() == false) goto L5;
        return;
    L5:
        nativeSetRotation(this.nativeHandle, r100);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public void setTimestampNs(long r100) {
        if (isNullPointer() == false) goto L5;
        return;
    L5:
        nativeSetTimestampNs(this.nativeHandle, r100);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface
    public void setTimestampUs(long r100) {
        if (isNullPointer() == false) goto L5;
        return;
    L5:
        nativeSetTimestampUs(this.nativeHandle, r100);
    }

    public static NativeBmmtVideoFrame createVideoFrame(NativeBmmtByteMemory r110, long r111, ByteBuffer r112, ColorSpace r113, VideoRotation r114) {
        return new NativeBmmtVideoFrame(nativeCreateVideoFrameFromByteMemory(r110.getNativeHandle(), r110.getWidth(), r110.getHeight(), r110.getPixelFormat(), r110.getPlaneDataArray(), r110.getPlaneLineSizeArray(), r111, r112, r113, r114));
    }

    public static NativeBmmtVideoFrame createVideoFrame(NativeBmmtOpenGLMemory r110, VideoFrameHelperInterface r111, long r112, ByteBuffer r113, ColorSpace r114) {
        if (r111 == null) goto L4;
        long r100 = r111.getNativeHandle();
    L5:
        long r101 = r110.getNativeHandle();
        return new NativeBmmtVideoFrame(nativeCreateVideoFrameFromOpenGLMemory(r101, r100, r112, r113, r114, r110.getRotation()));
    L4:
        r100 = 0;
        goto L5
    }
}
