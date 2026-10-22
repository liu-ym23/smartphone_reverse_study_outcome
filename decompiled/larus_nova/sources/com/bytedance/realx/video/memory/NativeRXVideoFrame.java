package com.bytedance.realx.video.memory;

import com.bytedance.realx.video.RXColorSpace;
import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.RXVideoFrameHelperInterface;
import com.bytedance.realx.video.RXVideoRotation;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
public class NativeRXVideoFrame implements RXVideoFrameInterface {
    private long nativeHandle;
    RefObject refCounted;

    public static /* synthetic */ void a(NativeRXVideoFrame r100) {
        r100.lambda$new$0();
    }

    private static native long nativeCreateRXVideoFrameFromByteMemory(long r100, int r101, int r102, RXPixelFormat r103, ByteBuffer[] r104, int[] r105, long r106, ByteBuffer r107, RXColorSpace r110, RXVideoRotation r111);

    private static native long nativeCreateRXVideoFrameFromOpenGLMemory(long r100, long r101, long r102, ByteBuffer r103, RXColorSpace r104, RXVideoRotation r105);

    private static native RXColorSpace nativeGetColorSpace(long r100);

    private static native RXVideoMemoryInterface nativeGetFrameMemory(long r100);

    private static native RXVideoRotation nativeGetRotation(long r100);

    private static native ByteBuffer nativeGetSupplementData(long r100);

    private static native long nativeGetTimestampNs(long r100);

    private static native long nativeGetTimestampUs(long r100);

    private static native void nativeReleaseVideoFrame(long r100);

    private static native void nativeSetRotation(long r100, RXVideoRotation r101);

    private static native void nativeSetTimestampNs(long r100, long r101);

    private static native void nativeSetTimestampUs(long r100, long r101);

    private static native NativeRXVideoFrame nativeToI420(long r100);

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface, com.bytedance.realx.base.RefCounted
    public synchronized void release() {
        monitor-enter(this);
        this.refCounted.release();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface, com.bytedance.realx.base.RefCounted
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

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public RXVideoMemoryInterface getAndRetainVideoFrameMemory() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetFrameMemory(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public RXColorSpace getColorSpace() {
        if (isNullPointer() == false) goto L7;
        return RXColorSpace.kUnknown;
    L7:
        return nativeGetColorSpace(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public int getHeight() {
        RXVideoMemoryInterface r100 = getAndRetainVideoFrameMemory();
        if (r100 != null) goto L6;
        return 0;
    L6:
        int r101 = r100.getHeight();
        r100.release();
        return r101;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public int getRotatedHeight() {
        RXVideoMemoryInterface r100 = getAndRetainVideoFrameMemory();
        if (r100 != null) goto L6;
        return 0;
    L6:
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        r100.release();
        if ((getRotation().value() % 180) != 0) goto L9;
        return r102;
    L9:
        return r101;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public int getRotatedWidth() {
        RXVideoMemoryInterface r100 = getAndRetainVideoFrameMemory();
        if (r100 != null) goto L6;
        return 0;
    L6:
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        r100.release();
        if ((getRotation().value() % 180) != 0) goto L9;
        return r101;
    L9:
        return r102;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public RXVideoRotation getRotation() {
        if (isNullPointer() == false) goto L7;
        return RXVideoRotation.VIDEO_ROTATION_0;
    L7:
        return nativeGetRotation(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public ByteBuffer getSupplementData() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetSupplementData(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public long getTimestampNs() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetTimestampNs(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public long getTimestampUs() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetTimestampUs(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public int getWidth() {
        RXVideoMemoryInterface r100 = getAndRetainVideoFrameMemory();
        if (r100 != null) goto L6;
        return 0;
    L6:
        int r101 = r100.getWidth();
        r100.release();
        return r101;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public RXVideoFrameInterface toI420() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeToI420(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public long getNativeHandle() {
        return this.nativeHandle;
    }

    private NativeRXVideoFrame(long r100) {
        this.nativeHandle = r100;
        this.refCounted = new RefObject(new a(this));
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public void setRotation(RXVideoRotation r100) {
        if (isNullPointer() == false) goto L5;
        return;
    L5:
        nativeSetRotation(this.nativeHandle, r100);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public void setTimestampNs(long r100) {
        if (isNullPointer() == false) goto L5;
        return;
    L5:
        nativeSetTimestampNs(this.nativeHandle, r100);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoFrameInterface
    public void setTimestampUs(long r100) {
        if (isNullPointer() == false) goto L5;
        return;
    L5:
        nativeSetTimestampUs(this.nativeHandle, r100);
    }

    public static NativeRXVideoFrame createRXVideoFrame(NativeRXByteMemory r110, long r111, ByteBuffer r112, RXColorSpace r113, RXVideoRotation r114) {
        return new NativeRXVideoFrame(nativeCreateRXVideoFrameFromByteMemory(r110.getNativeHandle(), r110.getWidth(), r110.getHeight(), r110.getPixelFormat(), r110.getPlaneDataArray(), r110.getPlaneLineSizeArray(), r111, r112, r113, r114));
    }

    public static NativeRXVideoFrame createRXVideoFrame(NativeRXOpenGLMemory r110, RXVideoFrameHelperInterface r111, long r112, ByteBuffer r113, RXColorSpace r114) {
        if (r111 == null) goto L4;
        long r100 = r111.getNativeHandle();
    L5:
        long r101 = r110.getNativeHandle();
        return new NativeRXVideoFrame(nativeCreateRXVideoFrameFromOpenGLMemory(r101, r100, r112, r113, r114, r110.getRotation()));
    L4:
        r100 = 0;
        goto L5
    }
}
