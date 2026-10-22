package com.bytedance.realx.video;

import com.bytedance.realx.base.JniCommon;
import com.bytedance.realx.base.RefCountDelegate;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
public class JavaI420Buffer implements VideoFrame.I420Buffer {
    private final ByteBuffer dataU;
    private final ByteBuffer dataV;
    private final ByteBuffer dataY;
    private final int height;
    private final RefCountDelegate refCountDelegate;
    private final int strideU;
    private final int strideV;
    private final int strideY;
    private final int width;

    public static /* synthetic */ void a(ByteBuffer r100) {
        lambda$allocate$0(r100);
    }

    public static /* synthetic */ void b(ByteBuffer r100) {
        lambda$allocate$1(r100);
    }

    private static native void nativeCropAndScaleI420(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, int r106, int r107, int r108, int r109, ByteBuffer r110, int r111, ByteBuffer r112, int r113, ByteBuffer r114, int r115, int r116, int r117);

    private static native void nativeScaleAndFillI420(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, int r106, int r107, ByteBuffer r108, int r109, ByteBuffer r110, int r111, ByteBuffer r112, int r113, int r114, int r115, int r116, int r117);

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer copyData() {
        return null;
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer, com.bytedance.realx.video.VideoFrame.Buffer
    public final /* synthetic */ int getBufferType() {
        return VideoFrame.I420Buffer.CC.$default$getBufferType(this);
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public final /* synthetic */ VideoFrame.NV12Buffer toNV12() {
        return VideoFrame.Buffer.CC.$default$toNV12(this);
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        return this.dataU.slice();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        return this.dataV.slice();
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
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

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.strideU;
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.strideV;
    }

    @Override // com.bytedance.realx.video.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        retain();
        return this;
    }

    private static /* synthetic */ void lambda$allocate$0(ByteBuffer r100) {
        JniCommon.nativeFreeByteBuffer(r100);
    }

    private static /* synthetic */ void lambda$allocate$1(ByteBuffer r100) {
        JniCommon.nativeFreeByteBuffer(r100);
    }

    public static JavaI420Buffer allocate(int r110, int r111) {
        int r100 = (r111 + 1) / 2;
        int r112 = (r110 + 1) / 2;
        int r101 = r110 * r111;
        int r102 = r101 + 0;
        int r103 = r112 * r100;
        int r104 = r102 + r103;
        final ByteBuffer r105 = JniCommon.nativeAllocateByteBuffer(r101 + ((r112 * 2) * r100));
        if (r105 != null) goto L6;
        return null;
    L6:
        r105.position(0);
        r105.limit(r102);
        ByteBuffer r106 = r105.slice();
        r105.position(r102);
        r105.limit(r104);
        ByteBuffer r107 = r105.slice();
        r105.position(r104);
        r105.limit(r104 + r103);
        return new JavaI420Buffer(r110, r111, r106, r110, r107, r112, r105.slice(), r112, new n(r105));
    }

    public static JavaI420Buffer allocate(int r110, int r111, int r112, int r113) {
        int r100 = r112 / 2;
        int r101 = r112 * r113;
        int r102 = r101 + 0;
        int r103 = r100 * r113;
        int r104 = (r103 / 2) + r102;
        final ByteBuffer r114 = JniCommon.nativeAllocateByteBuffer(r101 + ((r100 * 2) * r113));
        if (r114 != null) goto L6;
        return null;
    L6:
        r114.position(0);
        r114.limit(r102);
        ByteBuffer r105 = r114.slice();
        r114.position(r102);
        r114.limit(r104);
        ByteBuffer r106 = r114.slice();
        r114.position(r104);
        r114.limit(r104 + r103);
        return new JavaI420Buffer(r110, r111, r105, r112, r106, r100, r114.slice(), r100, new m(r114));
    }

    private static void checkCapacity(ByteBuffer r100, int r101, int r102, int r103) {
        int r104 = (r103 * (r102 - 1)) + r101;
        if (r100.capacity() < r104) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Buffer must be at least " + r104 + " bytes, but was " + r100.capacity());
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer scaleAndFill(int r100, int r101, int r102, int r103) {
        return scaleAndFillI420(this, r100, r101, r102, r103);
    }

    public static VideoFrame.Buffer scaleAndFillI420(VideoFrame.I420Buffer r110, int r210, int r211, int r212, int r213) {
        JavaI420Buffer r100 = allocate(r210, r211);
        if (r100 != null) goto L6;
        return null;
    L6:
        nativeScaleAndFillI420(r110.getDataY(), r110.getStrideY(), r110.getDataU(), r110.getStrideU(), r110.getDataV(), r110.getStrideV(), r110.getWidth(), r110.getHeight(), r100.getDataY(), r100.getStrideY(), r100.getDataU(), r100.getStrideU(), r100.getDataV(), r100.getStrideV(), r210, r211, r212, r213);
        return r100;
    }

    @Override // com.bytedance.realx.video.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int r100, int r101, int r102, int r103, int r104, int r105) {
        return cropAndScaleI420(this, r100, r101, r102, r103, r104, r105);
    }

    public static VideoFrame.Buffer cropAndScaleI420(final VideoFrame.I420Buffer r110, int r210, int r211, int r212, int r213, int r214, int r215) {
        if (r212 != r214) goto L10;
        if (r213 != r215) goto L10;
        ByteBuffer r100 = r110.getDataY();
        ByteBuffer r101 = r110.getDataU();
        ByteBuffer r102 = r110.getDataV();
        r100.position(r210 + (r110.getStrideY() * r211));
        int r103 = r210 / 2;
        int r104 = r211 / 2;
        r101.position((r110.getStrideU() * r104) + r103);
        r102.position(r103 + (r104 * r110.getStrideV()));
        r110.retain();
        return wrap(r214, r215, r100.slice(), r110.getStrideY(), r101.slice(), r110.getStrideU(), r102.slice(), r110.getStrideV(), new o(r110));
    L10:
        JavaI420Buffer r111 = allocate(r214, r215);
        if (r111 != null) goto L14;
        return null;
    L14:
        nativeCropAndScaleI420(r110.getDataY(), r110.getStrideY(), r110.getDataU(), r110.getStrideU(), r110.getDataV(), r110.getStrideV(), r210, r211, r212, r213, r111.getDataY(), r111.getStrideY(), r111.getDataU(), r111.getStrideU(), r111.getDataV(), r111.getStrideV(), r214, r215);
        return r111;
    }

    private JavaI420Buffer(int r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, ByteBuffer r106, int r107, Runnable r108) {
        this.width = r100;
        this.height = r101;
        this.dataY = r102;
        this.dataU = r104;
        this.dataV = r106;
        this.strideY = r103;
        this.strideU = r105;
        this.strideV = r107;
        this.refCountDelegate = new RefCountDelegate(r108);
    }

    public static JavaI420Buffer wrap(int r110, int r111, ByteBuffer r112, int r113, ByteBuffer r114, int r115, ByteBuffer r116, int r117, Runnable r118) {
        if (r112 == null) goto L17;
        if (r114 == null) goto L17;
        if (r116 == null) goto L17;
        if (r112.isDirect() == false) goto L15;
        if (r114.isDirect() == false) goto L15;
        if (r116.isDirect() == false) goto L15;
        ByteBuffer r100 = r112.slice();
        ByteBuffer r101 = r114.slice();
        ByteBuffer r102 = r116.slice();
        int r103 = (r110 + 1) / 2;
        int r104 = r111 / 2;
        checkCapacity(r100, r110, r111, r113);
        checkCapacity(r101, r103, r104, r115);
        checkCapacity(r102, r103, r104, r117);
        return new JavaI420Buffer(r110, r111, r100, r113, r101, r115, r102, r117, r118);
    L15:
        throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
    L17:
        throw new IllegalArgumentException("Data buffers cannot be null.");
    }
}
