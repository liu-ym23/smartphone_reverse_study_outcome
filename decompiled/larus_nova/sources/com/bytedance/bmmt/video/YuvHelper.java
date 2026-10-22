package com.bytedance.bmmt.video;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public class YuvHelper {
    public YuvHelper() {
    }

    private static native void nativeCopyPlane(ByteBuffer r100, int r101, ByteBuffer r102, int r103, int r104, int r105);

    private static native void nativeI420Copy(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, ByteBuffer r106, int r107, ByteBuffer r108, int r109, ByteBuffer r110, int r111, int r112, int r113);

    private static native void nativeI420Rotate(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, ByteBuffer r106, int r107, ByteBuffer r108, int r109, ByteBuffer r110, int r111, int r112, int r113, int r114);

    private static native void nativeI420ToNV12(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, ByteBuffer r106, int r107, ByteBuffer r108, int r109, int r110, int r111);

    private static native void nativeNV12Copy(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, ByteBuffer r106, int r107, int r108, int r109);

    public static void copyPlane(ByteBuffer r100, int r101, ByteBuffer r102, int r103, int r104, int r105) {
        nativeCopyPlane(r100, r101, r102, r103, r104, r105);
    }

    public static void NV12Copy(ByteBuffer r100, int r110, ByteBuffer r111, int r112, ByteBuffer r113, int r114, int r115) {
        NV12Copy(r100, r110, r111, r112, r113, r114, r115, r114, r115);
    }

    public static void I420Copy(ByteBuffer r110, int r111, ByteBuffer r112, int r113, ByteBuffer r114, int r115, ByteBuffer r116, int r117, int r118) {
        I420Copy(r110, r111, r112, r113, r114, r115, r116, r117, r118, r117, r118);
    }

    public static void I420ToNV12(ByteBuffer r110, int r111, ByteBuffer r112, int r113, ByteBuffer r114, int r115, ByteBuffer r116, int r117, int r118) {
        I420ToNV12(r110, r111, r112, r113, r114, r115, r116, r117, r118, r117, r118);
    }

    public static void NV12Copy(ByteBuffer r110, int r111, ByteBuffer r112, int r113, ByteBuffer r114, int r115, int r116, int r117, int r118) {
        int r100 = (r117 + 1) / 2;
        int r101 = r117 * r118;
        int r102 = ((((r118 + 1) / 2) * r100) * 2) + r101;
        if (r114.capacity() < r102) goto L7;
        r114.position(0);
        ByteBuffer r103 = r114.slice();
        r114.position(r101);
        nativeNV12Copy(r110, r111, r112, r113, r103, r117, r114.slice(), r100 * 2, r115, r116);
        return;
    L7:
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + r102 + " was " + r114.capacity());
    }

    public static void I420Rotate(ByteBuffer r110, int r111, ByteBuffer r112, int r113, ByteBuffer r114, int r210, ByteBuffer r211, int r212, int r213, int r214) {
        int r100 = r214 % 180;
        if (r100 != 0) goto L5;
        int r101 = r212;
    L6:
        if (r100 != 0) goto L8;
        int r102 = r213;
    L9:
        int r103 = (r102 + 1) / 2;
        int r115 = (r101 + 1) / 2;
        int r104 = r102 * r101;
        int r105 = r103 * r115;
        int r106 = (r105 * 2) + r104;
        if (r211.capacity() < r106) goto L14;
        r211.position(0);
        ByteBuffer r107 = r211.slice();
        r211.position(r104);
        ByteBuffer r108 = r211.slice();
        r211.position(r105 + r104);
        nativeI420Rotate(r110, r111, r112, r113, r114, r210, r107, r101, r108, r115, r211.slice(), r115, r212, r213, r214);
        return;
    L14:
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + r106 + " was " + r211.capacity());
    L8:
        r102 = r212;
        goto L9
    L5:
        r101 = r213;
        goto L6
    }

    public static void I420Copy(ByteBuffer r110, int r111, ByteBuffer r112, int r113, ByteBuffer r114, int r115, ByteBuffer r210, int r211, int r212, int r213, int r214) {
        if (r110 == null) goto L14;
        if (r112 == null) goto L15;
        if (r114 == null) goto L16;
        if (r210 == null) goto L17;
        int r116 = (r213 + 1) / 2;
        int r100 = r213 * r214;
        int r101 = ((r214 + 1) / 2) * r116;
        int r102 = (r101 * 2) + r100;
        if (r210.capacity() < r102) goto L13;
        r210.position(0);
        ByteBuffer r103 = r210.slice();
        r210.position(r100);
        ByteBuffer r104 = r210.slice();
        r210.position(r101 + r100);
        nativeI420Copy(r110, r111, r112, r113, r114, r115, r103, r213, r104, r116, r210.slice(), r116, r211, r212);
        return;
    L13:
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + r102 + " was " + r210.capacity());
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public static void I420ToNV12(ByteBuffer r110, int r111, ByteBuffer r112, int r113, ByteBuffer r114, int r115, ByteBuffer r116, int r117, int r210, int r211, int r212) {
        int r100 = (r211 + 1) / 2;
        int r101 = r211 * r212;
        int r102 = ((((r212 + 1) / 2) * r100) * 2) + r101;
        if (r116.capacity() < r102) goto L7;
        r116.position(0);
        ByteBuffer r103 = r116.slice();
        r116.position(r101);
        nativeI420ToNV12(r110, r111, r112, r113, r114, r115, r103, r211, r116.slice(), r100 * 2, r117, r210);
        return;
    L7:
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + r102 + " was " + r116.capacity());
    }

    public static void I420ToNV12(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, ByteBuffer r106, int r107, ByteBuffer r108, int r109, int r110, int r111) {
        nativeI420ToNV12(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111);
    }

    public static void I420Copy(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, ByteBuffer r106, int r107, ByteBuffer r108, int r109, ByteBuffer r110, int r111, int r112, int r113) {
        nativeI420Copy(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113);
    }

    public static void I420Rotate(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, ByteBuffer r106, int r107, ByteBuffer r108, int r109, ByteBuffer r110, int r111, int r112, int r113, int r114) {
        nativeI420Rotate(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114);
    }
}
