package com.ss.bytertc.engine.adapter;

import com.bytedance.realx.video.JavaI420Buffer;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.engine.mediaio.CountDownLatchI420Buffer;
import com.ss.bytertc.engine.utils.LogUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public class VideoFrameConverter {
    private static int MAX_BYTE_BUFFER_POOL_SIZE = 2;
    private static final String TAG = "VideoFrameConverter";
    private int abandonFrameCount;
    private ArrayList<ByteBufferHolder> byteBufferPool;
    private ByteBuffer[] byteBuffers;
    private boolean isBufferDirect;
    final int[] steps;
    final int[] strides;

    public static class ByteBufferHolder {
        private ByteBuffer byteBuffer;
        private volatile boolean isPending;

        public byte[] getArray() {
            ByteBuffer r100 = this.byteBuffer;
            if (r100 == null) goto L12;
            r100.clear();
            if (this.byteBuffer.hasArray() == true) goto L7;
        L10:
            int r101 = this.byteBuffer.remaining();
            byte[] r102 = new byte[r101];
            this.byteBuffer.get(r102, 0, r101);
            return r102;
        L7:
            if (this.byteBuffer.arrayOffset() != 0) goto L10;
            return this.byteBuffer.array();
        L12:
            return null;
        }

        public ByteBuffer getByteBuffer() {
            ByteBuffer r100 = this.byteBuffer;
            if (r100 == null) goto L6;
            r100.clear();
        L6:
            return this.byteBuffer;
        }

        public ByteBufferHolder() {
            this.isPending = false;
        }

        public boolean isPending() {
            return this.isPending;
        }

        public static /* synthetic */ ByteBuffer access$000(ByteBufferHolder r100) {
            return r100.byteBuffer;
        }

        public static /* synthetic */ boolean access$200(ByteBufferHolder r100) {
            return r100.isPending;
        }

        private void setByteBuffer(ByteBuffer r100) {
            this.byteBuffer = r100;
        }

        public void setPending(boolean r100) {
            this.isPending = r100;
        }

        public static /* synthetic */ void access$100(ByteBufferHolder r100, ByteBuffer r101) {
            r100.setByteBuffer(r101);
        }
    }

    public static class I420BufferWrapper {
        private VideoFrame.I420Buffer i420Buffer;
        private boolean needManualRelease;

        public void release() {
            VideoFrame.I420Buffer r100 = this.i420Buffer;
            if ((r100 instanceof JavaI420Buffer) == true) goto L5;
            return;
        L5:
            if (this.needManualRelease == false) goto L9;
            r100.release();
            return;
        }

        public VideoFrame.I420Buffer getBuffer() {
            return this.i420Buffer;
        }

        public I420BufferWrapper(VideoFrame r100) {
            if ((r100.getBuffer() instanceof JavaI420Buffer) == false) goto L5;
            this.i420Buffer = (JavaI420Buffer) r100.getBuffer();
            this.needManualRelease = false;
            return;
        L5:
            this.i420Buffer = r100.getBuffer().toI420();
            this.needManualRelease = true;
            r100.getBuffer().release();
        }
    }

    public VideoFrameConverter() {
        this(false);
    }

    public static /* synthetic */ void a(ByteBufferHolder r100) {
        lambda$convertToJavaI420Buffer$1(r100);
    }

    public static /* synthetic */ void b(ByteBufferHolder r100) {
        lambda$convertToJavaI420Buffer$0(r100);
    }

    public static /* synthetic */ void c(ByteBufferHolder r100) {
        lambda$convertToJavaI420Buffer$3(r100);
    }

    public static /* synthetic */ void d(ByteBufferHolder r100) {
        lambda$convertToJavaI420Buffer$2(r100);
    }

    private ByteBufferHolder getPendingBuffer() {
        Iterator<ByteBufferHolder> r100 = this.byteBufferPool.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        ByteBufferHolder r101 = r100.next();
        if (ByteBufferHolder.access$200(r101) == true) goto L4;
        r101.setPending(true);
        return r101;
    L9:
        return null;
    }

    public VideoFrameConverter(boolean r100) {
        this.byteBuffers = new ByteBuffer[3];
        this.strides = new int[3];
        this.steps = new int[2];
        this.byteBufferPool = new ArrayList();
        int r101 = 0;
        this.abandonFrameCount = 0;
    L4:
        if (r101 >= MAX_BYTE_BUFFER_POOL_SIZE) goto L6;
        ByteBufferHolder r102 = new ByteBufferHolder();
        this.byteBufferPool.add(r102);
        r101 = r101 + 1;
        goto L4
    L6:
        this.isBufferDirect = r100;
    }

    private static /* synthetic */ void lambda$convertToJavaI420Buffer$0(ByteBufferHolder r100) {
        r100.setPending(false);
    }

    private static /* synthetic */ void lambda$convertToJavaI420Buffer$1(ByteBufferHolder r100) {
        r100.setPending(false);
    }

    private static /* synthetic */ void lambda$convertToJavaI420Buffer$2(ByteBufferHolder r100) {
        r100.setPending(false);
    }

    private static /* synthetic */ void lambda$convertToJavaI420Buffer$3(ByteBufferHolder r100) {
        r100.setPending(false);
    }

    public ByteBufferHolder convert2YUV(VideoFrame r110) {
        ByteBufferHolder r111 = getPendingBuffer();
        if (r111 != null) goto L5;
        return null;
    L5:
        int r100 = r110.getBuffer().getWidth();
        int r101 = r110.getBuffer().getHeight();
        I420BufferWrapper r112 = new I420BufferWrapper(r110);
        VideoFrame.I420Buffer r113 = r112.getBuffer();
        boolean r114 = convertRawYUV2ByteHolder(r111, r113.getDataY(), r113.getDataU(), r113.getDataV(), r113.getStrideY(), r113.getStrideU(), r113.getStrideV(), r100, r101);
        r112.release();
        if (r114 == true) goto L8;
        return null;
    L8:
        return r111;
    }

    public void checkReuseByteBuffer(int r100, ByteBufferHolder r101) {
        if (r101.getByteBuffer() == null) goto L7;
        if (r101.getByteBuffer().capacity() < r100) goto L7;
        return;
    L7:
        if (this.isBufferDirect == false) goto L9;
        ByteBuffer r102 = ByteBuffer.allocateDirect(r100);
    L10:
        r102.order(ByteOrder.nativeOrder());
        ByteBufferHolder.access$100(r101, r102);
        return;
    L9:
        r102 = ByteBuffer.allocate(r100);
        goto L10
    }

    public VideoFrame.I420Buffer convertToJavaI420Buffer(ByteBuffer r110, int r111, int r112, boolean r113) {
        if (r110 != null) goto L5;
        return null;
    L5:
        final ByteBufferHolder r100 = getPendingBuffer();
        if (r100 != null) goto L11;
        int r101 = this.abandonFrameCount + 1;
        this.abandonFrameCount = r101;
        if (r101 < 60) goto L10;
        LogUtil.e(TAG, "drop frame > 60 !!! please check Buffer for release");
        this.abandonFrameCount = 0;
    L10:
        return null;
    L11:
        this.abandonFrameCount = 0;
        int r102 = (r112 + 1) / 2;
        int r103 = (r111 + 1) / 2;
        int r104 = r111 * r112;
        int r105 = ((r103 * 2) * r102) + r104;
        checkReuseByteBuffer(r105, r100);
        ByteBuffer r106 = r100.getByteBuffer();
        r110.position(0);
        r106.position(0);
        if (r110.limit() <= r105) goto L14;
        r110.limit(r105);
    L14:
        r106.limit(r105);
        r106.put(r110);
        int r107 = r104 + 0;
        int r108 = r102 * r103;
        int r109 = r107 + r108;
        r106.position(0);
        r106.limit(r107);
        ByteBuffer r114 = r106.slice();
        r106.position(r107);
        r106.limit(r109);
        ByteBuffer r115 = r106.slice();
        r106.position(r109);
        r106.limit(r109 + r108);
        ByteBuffer r116 = r106.slice();
        if (r113 == false) goto L19;
        return CountDownLatchI420Buffer.wrap(r111, r112, r114, r111, r115, r103, r116, r103, new a(r100));
    L19:
        return JavaI420Buffer.wrap(r111, r112, r114, r111, r115, r103, r116, r103, new b(r100));
    }

    public VideoFrame.I420Buffer convertToJavaI420Buffer(byte[] r110, int r111, int r112, boolean r113) {
        if (r110 != null) goto L5;
        return null;
    L5:
        final ByteBufferHolder r100 = getPendingBuffer();
        if (r100 != null) goto L11;
        int r101 = this.abandonFrameCount + 1;
        this.abandonFrameCount = r101;
        if (r101 < 60) goto L10;
        LogUtil.e(TAG, "drop frame > 60 !!! please check Buffer for release ");
        this.abandonFrameCount = 0;
    L10:
        return null;
    L11:
        this.abandonFrameCount = 0;
        int r102 = (r112 + 1) / 2;
        int r103 = (r111 + 1) / 2;
        int r104 = r111 * r112;
        int r105 = ((r103 * 2) * r102) + r104;
        checkReuseByteBuffer(r105, r100);
        ByteBuffer r106 = r100.getByteBuffer();
        r106.position(0);
        r106.limit(r105);
        r106.put(r110, 0, Math.min(r110.length, r105));
        int r107 = r104 + 0;
        int r108 = r102 * r103;
        int r109 = r107 + r108;
        r106.position(0);
        r106.limit(r107);
        ByteBuffer r114 = r106.slice();
        r106.position(r107);
        r106.limit(r109);
        ByteBuffer r115 = r106.slice();
        r106.position(r109);
        r106.limit(r109 + r108);
        ByteBuffer r116 = r106.slice();
        if (r113 == false) goto L16;
        return CountDownLatchI420Buffer.wrap(r111, r112, r114, r111, r115, r103, r116, r103, new c(r100));
    L16:
        return JavaI420Buffer.wrap(r111, r112, r114, r111, r115, r103, r116, r103, new d(r100));
    }

    public ByteBuffer convertRawYUV2ByteArray(byte[] r110, byte[] r111, byte[] r112, int r113, int r114, int r115, int r116, int r117) {
        ByteBuffer r100 = ByteBuffer.allocateDirect(r110.length);
        r100.order(ByteOrder.nativeOrder());
        r100.put(r110);
        r100.position(0);
        ByteBuffer r101 = ByteBuffer.allocateDirect(r111.length);
        r101.order(ByteOrder.nativeOrder());
        r101.put(r111);
        r101.position(0);
        ByteBuffer r102 = ByteBuffer.allocateDirect(r112.length);
        r102.order(ByteOrder.nativeOrder());
        r102.put(r112);
        r102.position(0);
        ByteBuffer r118 = ByteBuffer.allocate((r116 * r117) + ((((r116 + 1) / 2) * 2) * r116));
        r118.clear();
        convertRawYUV2ByteArray(r118.array(), r100, r101, r102, r113, r114, r115, r116, r117);
        return r118;
    }

    private boolean convertRawYUV2ByteArray(byte[] r100, ByteBuffer r101, ByteBuffer r102, ByteBuffer r103, int r104, int r105, int r106, int r110, int r111) {
        int[] r107 = this.strides;
        r107[0] = r104;
        r107[1] = r105;
        r107[2] = r106;
        int[] r108 = this.steps;
        r108[0] = r110;
        int r109 = (r110 + 1) / 2;
        r108[1] = r109;
        int r112 = (r110 * r111) + ((r109 * 2) * r111);
        r101.clear();
        r102.clear();
        r103.clear();
        if (r100 != null) goto L5;
    L29:
        return false;
    L5:
        if (r112 > r100.length) goto L29;
        ByteBuffer[] r113 = this.byteBuffers;
        r113[0] = r101;
        r113[1] = r102;
        r113[2] = r103;
        int r114 = 0;
        int r115 = 0;
    L8:
        ByteBuffer[] r116 = this.byteBuffers;
        if (r114 >= r116.length) goto L27;
        ByteBuffer r117 = r116[r114];
        int r118 = this.strides[r114];
        int[] r119 = this.steps;
        if (r114 != 0) goto L13;
        int r120 = r119[0];
    L14:
        int r121 = r118 - r120;
        if (r118 != r120) goto L18;
        int r122 = r117.remaining();
        r117.get(r100, r115, r122);
        r115 = r115 + r122;
    L26:
        r114 = r114 + 1;
    L18:
        if (r117.hasRemaining() == false) goto L26;
        if ((r117.position() + r120) > r117.capacity()) goto L26;
        r117.get(r100, r115, r120);
        r115 = r115 + r120;
        int r123 = r117.position() + r121;
        if (r117.hasRemaining() == false) goto L26;
        if (r123 > r117.capacity()) goto L26;
        r117.position(r123);
        goto L18
    L13:
        r120 = r119[1];
        goto L14
    L27:
        r116[0] = null;
        r116[1] = null;
        r116[2] = null;
        return true;
    }

    private boolean convertRawYUV2ByteBuffer(ByteBuffer r100, ByteBuffer r101, ByteBuffer r102, ByteBuffer r103, int r104, int r105, int r106, int r110, int r111) {
        int[] r107 = this.strides;
        r107[0] = r104;
        r107[1] = r105;
        r107[2] = r106;
        int[] r108 = this.steps;
        r108[0] = r110;
        int r109 = (r110 + 1) / 2;
        r108[1] = r109;
        int r112 = (r110 * r111) + ((r109 * 2) * r111);
        r101.clear();
        r102.clear();
        r103.clear();
        if (r100 != null) goto L5;
    L27:
        return false;
    L5:
        if (r112 > r100.capacity()) goto L27;
        r100.clear();
        ByteBuffer[] r113 = this.byteBuffers;
        r113[0] = r101;
        r113[1] = r102;
        r113[2] = r103;
        int r114 = 0;
    L8:
        ByteBuffer[] r115 = this.byteBuffers;
        if (r114 >= r115.length) goto L25;
        ByteBuffer r116 = r115[r114];
        int r117 = this.strides[r114];
        int[] r118 = this.steps;
        if (r114 != 0) goto L13;
        int r119 = r118[0];
    L14:
        int r120 = r117 - r119;
        if (r117 != r119) goto L18;
        r100.put(r116);
    L24:
        r114 = r114 + 1;
    L18:
        if (r116.hasRemaining() == false) goto L24;
        if ((r116.position() + r119) > r116.capacity()) goto L24;
        r116.limit(r116.position() + r119);
        r100.put(r116);
        int r121 = r116.position() + r120;
        if (r121 > r116.capacity()) goto L24;
        r116.limit(r116.capacity());
        r116.position(r121);
        goto L18
    L13:
        r119 = r118[1];
        goto L14
    L25:
        r115[0] = null;
        r115[1] = null;
        r115[2] = null;
        return true;
    }

    public boolean convertRawYUV2ByteHolder(ByteBufferHolder r110, ByteBuffer r111, ByteBuffer r112, ByteBuffer r113, int r114, int r115, int r116, int r117, int r210) {
        checkReuseByteBuffer((r117 * r210) + ((((r117 + 1) / 2) * 2) * r210), r110);
        return convertRawYUV2ByteBuffer(ByteBufferHolder.access$000(r110), r111, r112, r113, r114, r115, r116, r117, r210);
    }
}
