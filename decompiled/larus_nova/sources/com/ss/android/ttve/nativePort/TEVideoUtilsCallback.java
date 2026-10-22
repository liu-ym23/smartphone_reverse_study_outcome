package com.ss.android.ttve.nativePort;

import com.ss.android.vesdk.VEFrameAvailableListener;
import com.ss.android.vesdk.l0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes38.dex */
public class TEVideoUtilsCallback {
    private l0 frameDataListener;
    private VEFrameAvailableListener frameListener;

    public TEVideoUtilsCallback() {
    }

    public VEFrameAvailableListener getFrameAvailableListener() {
        return this.frameListener;
    }

    public static ByteBuffer allocateBuffer(int r100) {
        return ByteBuffer.allocateDirect(r100).order(ByteOrder.LITTLE_ENDIAN);
    }

    public void setFrameDataListener(Object r100) {
        this.frameDataListener = (l0) r100;
    }

    public void setListener(Object r100) {
        this.frameListener = (VEFrameAvailableListener) r100;
    }

    public static ByteBuffer allocateFrame(int r100, int r101) {
        return ByteBuffer.allocateDirect((r100 * r101) * 4).order(ByteOrder.LITTLE_ENDIAN);
    }

    public boolean onFrameAvailable(ByteBuffer r100, int r101, int r102, int r103) {
        VEFrameAvailableListener r104 = this.frameListener;
        if (r104 != null) goto L5;
    L7:
        return false;
    L5:
        if (r104.processFrame(r100, r101, r102, r103) == false) goto L7;
        return true;
    }

    public static boolean onFrameAvailable(Object r100, ByteBuffer r101, int r102, int r103, int r104) {
        if ((r100 instanceof TEVideoUtilsCallback) == false) goto L12;
        TEVideoUtilsCallback r105 = (TEVideoUtilsCallback) r100;
        if (r105 == null) goto L13;
        VEFrameAvailableListener r106 = r105.frameListener;
        if (r106 != null) goto L9;
        return false;
    L9:
        if (r106.processFrame(r101, r102, r103, r104) == false) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public static boolean onFrameAvailable2(Object r100, byte[] r101, int r102, int r103, int r104) {
        if ((r100 instanceof TEVideoUtilsCallback) == false) goto L12;
        TEVideoUtilsCallback r105 = (TEVideoUtilsCallback) r100;
        if (r105 == null) goto L13;
        VEFrameAvailableListener r106 = r105.frameListener;
        if (r106 != null) goto L9;
        return false;
    L9:
        if (r106.processFrame(ByteBuffer.wrap(r101), r102, r103, r104) == false) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public static boolean onFrameDataAvailable(Object r100, ByteBuffer r101, int r102, int r103, int r104, int r105) {
        if ((r100 instanceof TEVideoUtilsCallback) == false) goto L11;
        TEVideoUtilsCallback r106 = (TEVideoUtilsCallback) r100;
        if (r106 == null) goto L11;
        l0 r107 = r106.frameDataListener;
        if (r107 == null) goto L11;
        if (r107.a() == false) goto L11;
        return true;
    L11:
        return false;
    }
}
