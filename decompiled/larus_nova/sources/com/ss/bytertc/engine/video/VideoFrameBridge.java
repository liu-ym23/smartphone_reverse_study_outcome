package com.ss.bytertc.engine.video;

import android.opengl.EGLContext;
import com.ss.bytertc.engine.data.CameraId;
import com.ss.bytertc.engine.data.VideoBufferType;
import com.ss.bytertc.engine.data.VideoContentType;
import com.ss.bytertc.engine.data.VideoFrameData;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.data.VideoRotation;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes40.dex */
public class VideoFrameBridge implements IVideoFrame {
    private CameraId mCameraId;
    private long mCaptureTimeStamp;
    private long mNativePtr;
    private final AtomicInteger mRefCount;
    private VideoFrameData mVfd;

    public static native void nativeAddRef(long r100);

    public static native long nativeCreateIVideoFrame(IVideoFrame r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, ByteBuffer[] r108, int[] r109, ByteBuffer r110, int r111, float[] r112, EGLContext r113, int r114);

    public static native long nativeCreateVideoFrameData(int r100, int r101, int r102, int r103, int r104, int r105, long r106, int r107, ByteBuffer[] r108, int[] r110, ByteBuffer r111, ByteBuffer r112, int r113, float[] r114, EGLContext r115);

    public static native long nativeReleaseRef(long r100);

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public void addRef() {
        if (this.mRefCount.getAndIncrement() < 1) goto L7;
        nativeAddRef(this.mNativePtr);
        return;
    L7:
        throw new ArithmeticException("addRef on an object that has already been destroyed.");
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public VideoBufferType bufferType() {
        return this.mVfd.bufferType;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public VideoContentType contentType() {
        return this.mVfd.contentType;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public EGLContext eglContext() {
        return this.mVfd.eglContext;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public FovVideoFrameInfo fovTileInfo() {
        return this.mVfd.fovTileInfo;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public int height() {
        return this.mVfd.height;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public int numberOfPlanes() {
        return this.mVfd.numberOfPlanes;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public VideoPixelFormat pixelFormat() {
        return this.mVfd.pixelFormat;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public long releaseRef() {
        if (this.mRefCount.getAndDecrement() < 1) goto L6;
        nativeReleaseRef(this.mNativePtr);
    L6:
        return this.mRefCount.get();
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public VideoRotation rotation() {
        return this.mVfd.rotation;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public ByteBuffer seiData() {
        return this.mVfd.seiData;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public int textureId() {
        return this.mVfd.textureId;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public float[] textureMatrix() {
        return this.mVfd.textureMatrix;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public long timestampUs() {
        return this.mVfd.timestampUs;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public int width() {
        return this.mVfd.width;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public CameraId cameraId() {
        return this.mCameraId;
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public long captureTimestampMs() {
        return this.mCaptureTimeStamp;
    }

    public static long ConvertJVideoFrameDataToVideoFrameData(VideoFrameData r110) {
        ByteBuffer[] r111 = new ByteBuffer[3];
        int r100 = 0;
    L4:
        if (r100 >= r110.numberOfPlanes) goto L6;
        r111[r100] = ensureDirectBuffer(r110.planeData[r100]);
        r100 = r100 + 1;
        goto L4
    L6:
        ByteBuffer r112 = ensureDirectBuffer(r110.seiData);
        ByteBuffer r113 = ensureDirectBuffer(r110.roiData);
        return nativeCreateVideoFrameData(r110.bufferType.value(), r110.pixelFormat.value(), r110.contentType.value(), r110.width, r110.height, r110.rotation.value(), r110.timestampUs, r110.numberOfPlanes, r111, r110.planeStride, r112, r113, r110.textureId, r110.textureMatrix, r110.eglContext);
    }

    public static long ConvertVideoFrameToIVideoFrame(IVideoFrame r110) {
        ByteBuffer[] r100 = new ByteBuffer[3];
        int[] r101 = new int[3];
        int r102 = 0;
    L4:
        if (r102 >= r110.numberOfPlanes()) goto L6;
        r100[r102] = ensureDirectBuffer(r110.planeData(r102));
        r101[r102] = r110.planeStride(r102);
        r102 = r102 + 1;
        goto L4
    L6:
        ByteBuffer r111 = ensureDirectBuffer(r110.seiData());
        return nativeCreateIVideoFrame(r110, r110.bufferType().value(), r110.pixelFormat().value(), r110.contentType().value(), r110.width(), r110.height(), r110.rotation().value(), r110.numberOfPlanes(), r100, r101, r111, r110.textureId(), r110.textureMatrix(), r110.eglContext(), r110.cameraId().value());
    }

    public static void addRefOfVideoFrame(IVideoFrame r100) {
        r100.addRef();
    }

    public static ByteBuffer ensureDirectBuffer(ByteBuffer r100) {
        if (r100 != null) goto L4;
    L8:
        return r100;
    L4:
        if (r100.isDirect() == true) goto L8;
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.remaining());
        r101.position(0);
        r101.put(r100);
        r101.rewind();
        return r101;
    }

    public static long releaseRefOfVideoFrame(IVideoFrame r100) {
        return r100.releaseRef();
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public ByteBuffer planeData(int r100) {
        VideoFrameData r101 = this.mVfd;
        if (r100 < r101.numberOfPlanes) goto L7;
        return null;
    L7:
        return r101.planeData[r100];
    }

    @Override // com.ss.bytertc.engine.video.IVideoFrame
    public int planeStride(int r100) {
        VideoFrameData r101 = this.mVfd;
        if (r100 < r101.numberOfPlanes) goto L7;
        return 0;
    L7:
        return r101.planeStride[r100];
    }

    public VideoFrameBridge(long r100, int r101, int r102, int r110, int r111, int r112, int r113, long r114, int r115, ByteBuffer[] r116, int[] r117, ByteBuffer r118, int r210, float[] r211, EGLContext r212, FovVideoFrameInfo r213, int r214) {
        this.mNativePtr = 0;
        this.mVfd = null;
        this.mCameraId = CameraId.CAMERA_ID_FRONT;
        this.mRefCount = new AtomicInteger(1);
        this.mCaptureTimeStamp = 0;
        this.mNativePtr = r100;
        VideoFrameData r103 = new VideoFrameData();
        this.mVfd = r103;
        r103.bufferType = VideoBufferType.fromId(r101);
        VideoFrameData r104 = this.mVfd;
        r104.pixelFormat = VideoPixelFormat.fromId(r102);
        VideoFrameData r105 = this.mVfd;
        r105.contentType = VideoContentType.fromId(r110);
        VideoFrameData r106 = this.mVfd;
        r106.width = r111;
        r106.height = r112;
        r106.rotation = VideoRotation.fromId(r113);
        VideoFrameData r107 = this.mVfd;
        r107.timestampUs = r114;
        r107.numberOfPlanes = r115;
        r107.planeData = r116;
        r107.planeStride = r117;
        r107.seiData = r118;
        r107.textureId = r210;
        r107.textureMatrix = r211;
        r107.eglContext = r212;
        r107.fovTileInfo = r213;
        this.mCameraId = CameraId.fromId(r214);
        nativeAddRef(this.mNativePtr);
    }

    public VideoFrameBridge(long r100, int r101, int r102, int r110, int r111, int r112, int r113, long r114, long r115, int r116, ByteBuffer[] r117, int[] r210, ByteBuffer r211, int r212, float[] r213, EGLContext r214, FovVideoFrameInfo r215, int r216) {
        this.mNativePtr = 0;
        this.mVfd = null;
        this.mCameraId = CameraId.CAMERA_ID_FRONT;
        this.mRefCount = new AtomicInteger(1);
        this.mCaptureTimeStamp = 0;
        this.mNativePtr = r100;
        VideoFrameData r103 = new VideoFrameData();
        this.mVfd = r103;
        r103.bufferType = VideoBufferType.fromId(r101);
        VideoFrameData r104 = this.mVfd;
        r104.pixelFormat = VideoPixelFormat.fromId(r102);
        VideoFrameData r105 = this.mVfd;
        r105.contentType = VideoContentType.fromId(r110);
        VideoFrameData r106 = this.mVfd;
        r106.width = r111;
        r106.height = r112;
        r106.rotation = VideoRotation.fromId(r113);
        VideoFrameData r107 = this.mVfd;
        r107.timestampUs = r114;
        r107.numberOfPlanes = r116;
        r107.planeData = r117;
        r107.planeStride = r210;
        r107.seiData = r211;
        r107.textureId = r212;
        r107.textureMatrix = r213;
        r107.eglContext = r214;
        r107.fovTileInfo = r215;
        this.mCameraId = CameraId.fromId(r216);
        this.mCaptureTimeStamp = r115;
        nativeAddRef(this.mNativePtr);
    }
}
