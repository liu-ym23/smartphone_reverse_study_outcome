package com.bytedance.fresco.nativeheif;

import android.graphics.Bitmap;
import com.facebook.common.memory.Pool;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.FrescoSoLoader;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes19.dex */
public class Heif {
    private Heif() {
    }

    public static native byte[] decodeToBytevc1(byte[] r100, int r101);

    public static native int initBmfSr(int r100, int r101, int r102, String r103);

    public static native boolean isHeif(byte[] r100, int r101);

    private static native void nativeInit();

    public static native int[] parseSimpleMeta(byte[] r100, int r101);

    public static native int[] parseSimpleMeta(byte[] r100, int r101, boolean r102);

    public static native int[] parseSimpleMetaByNativePtr(long r100, int r101);

    public static native int[] parseThumbMeta(byte[] r100, int r101);

    public static native int[] parseThumbMetaByNativePtr(long r100, int r101);

    public static native Bitmap previewToRgbaBitmap(Pool<Bitmap> r100, byte[] r101, int r102, int r103, int r104, int[] r105);

    public static native void releaseBmfSr();

    public static native HeifData toRgb565(byte[] r100, boolean r101, int r102, boolean r103, int r104, int r105, int r106, int r107, int r108);

    public static native HeifData toRgb565(byte[] r100, boolean r101, int r102, boolean r103, int r104, boolean r105, int r106, boolean r107, int r108, int r109, int r110, int r111, int r112, int r113, boolean r114);

    public static native Bitmap toRgb565Bitmap(Pool<Bitmap> r100, ByteBuffer r101, boolean r102, int r103, boolean r104, int r105, int r106, int r107, int r108, int r109);

    public static native Bitmap toRgb565Bitmap(Pool<Bitmap> r100, ByteBuffer r101, boolean r102, int r103, boolean r104, int r105, boolean r106, int r107, boolean r108, int r109, int r110, int r111, int r112, int r113, int r114);

    public static native Bitmap toRgb565BitmapByNativePtr(Pool<Bitmap> r100, long r101, boolean r102, int r103, boolean r104, int r105, int r106, boolean r107, int r108, boolean r110, int r111, int r112, int r113, int r114, int r115, int r116, int[] r117);

    public static native Bitmap toRgb565BitmapOpt(Pool<Bitmap> r100, ByteBuffer r101, boolean r102, int r103, boolean r104, int r105, int r106, boolean r107, int r108, boolean r109, int r110, int r111, int r112, int r113, int r114, int r115, int[] r116);

    public static native HeifData toRgba(byte[] r100, boolean r101, int r102, boolean r103, int r104, int r105, int r106, int r107, int r108);

    public static native HeifData toRgba(byte[] r100, boolean r101, int r102, boolean r103, int r104, boolean r105, int r106, boolean r107, int r108, int r109, int r110, int r111, int r112, int r113, boolean r114);

    public static native Bitmap toRgbaBitmap(Pool<Bitmap> r100, ByteBuffer r101, boolean r102, int r103, boolean r104, int r105, int r106, int r107, int r108, int r109);

    public static native Bitmap toRgbaBitmap(Pool<Bitmap> r100, ByteBuffer r101, boolean r102, int r103, boolean r104, int r105, boolean r106, int r107, boolean r108, int r109, int r110, int r111, int r112, int r113, int r114);

    public static native Bitmap toRgbaBitmapByNativePtr(Pool<Bitmap> r100, long r101, boolean r102, int r103, boolean r104, int r105, int r106, boolean r107, int r108, boolean r110, int r111, int r112, int r113, int r114, int r115, int r116, int[] r117);

    public static native Bitmap toRgbaBitmapByNativePtrWithBmfSr(Pool<Bitmap> r100, long r101, boolean r102, int r103, boolean r104, int r105, int r106, boolean r107, int r108, boolean r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, String r211, int[] r212);

    public static native Bitmap toRgbaBitmapOpt(Pool<Bitmap> r100, ByteBuffer r101, boolean r102, int r103, boolean r104, int r105, int r106, boolean r107, int r108, boolean r109, int r110, int r111, int r112, int r113, int r114, int r115, int[] r116);

    public static native HeifData toRgbaExternBuffer(byte[] r100, boolean r101, int r102, byte[] r103, int r104, boolean r105, int r106, int r107, int r108, int r109, int r110);

    public static native HeifData toRgbaWithGainMap(ByteBuffer r100, int r101, int r102, boolean r103, int r104, int r105, int r106, int r107, int r108, int r109);

    public static native HeifData toThumbRgba(byte[] r100, int r101);

    public static native Bitmap toThumbRgbaBitmapByNativePtr(Pool<Bitmap> r100, long r101, boolean r102, int r103, int r104, int r105);

    static {
        FrescoSoLoader.loadLibrary("ttheif_dec");
        FrescoSoLoader.loadLibrary("bdheif");
        nativeInit();
    }

    public static void releaseBitmap(Pool<Bitmap> r100, Bitmap r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 == null) goto L6;
        r100.release(r101);
        return;
    L6:
        r101.recycle();
    }

    public static Bitmap toThumbRgbaBitmapByNativePtr(long r100, int r101, int r102, int r110) {
        return toThumbRgbaBitmapByNativePtr(r100, false, r101, r102, r110);
    }

    public static Bitmap createBitmap(Pool<Bitmap> r100, boolean r101, int r102, int r103, Bitmap.Config r104) throws Throwable {
        if (r101 == true) goto L13;
        if (r100 == null) goto L13;
        Bitmap r105 = r100.get(BitmapUtil.getSizeInByteForBitmap(r102, r103, r104));     // Catch: Throwable -> L10
        if (r105 == null) goto L9;
        r105.reconfigure(r102, r103, r104);     // Catch: Throwable -> L10
        return r105;
    L9:
        throw new NullPointerException("heif BitmapPool.get returned null");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return Bitmap.createBitmap(r102, r103, r104);
    }

    public static Bitmap previewToRgbaBitmap(byte[] r100, int r101, int r102, int r103, int[] r110) {
        return previewToRgbaBitmap(null, r100, r101, r102, r103, r110);
    }

    public static Bitmap toThumbRgbaBitmapByNativePtr(long r100, boolean r101, int r110, int r111, int r112) {
        return toThumbRgbaBitmapByNativePtr(null, r100, r101, r110, r111, r112);
    }

    public static Bitmap toThumbRgbaBitmapByNativePtr(Pool<Bitmap> r100, long r101, int r110, int r111, int r112) {
        return toThumbRgbaBitmapByNativePtr(r100, r101, false, r110, r111, r112);
    }

    public static HeifData toRgb565(byte[] r100, int r110, boolean r111, int r112, int r113, int r114, int r115, int r116) {
        return toRgb565(r100, false, r110, r111, r112, r113, r114, r115, r116);
    }

    public static Bitmap toRgb565Bitmap(ByteBuffer r100, int r110, boolean r111, int r112, int r113, int r114, int r115, int r116) {
        return toRgb565Bitmap(r100, false, r110, r111, r112, r113, r114, r115, r116);
    }

    public static HeifData toRgba(byte[] r100, int r110, boolean r111, int r112, int r113, int r114, int r115, int r116) {
        return toRgba(r100, false, r110, r111, r112, r113, r114, r115, r116);
    }

    public static Bitmap toRgbaBitmap(ByteBuffer r100, int r110, boolean r111, int r112, int r113, int r114, int r115, int r116) {
        return toRgbaBitmap(r100, false, r110, r111, r112, r113, r114, r115, r116);
    }

    public static Bitmap toRgb565Bitmap(Pool<Bitmap> r110, ByteBuffer r111, int r112, boolean r113, int r114, int r115, int r116, int r117, int r118) {
        return toRgb565Bitmap(r110, r111, false, r112, r113, r114, r115, r116, r117, r118);
    }

    public static Bitmap toRgbaBitmap(Pool<Bitmap> r110, ByteBuffer r111, int r112, boolean r113, int r114, int r115, int r116, int r117, int r118) {
        return toRgbaBitmap(r110, r111, false, r112, r113, r114, r115, r116, r117, r118);
    }

    public static Bitmap toRgb565Bitmap(ByteBuffer r110, boolean r111, int r112, boolean r113, int r114, int r115, int r116, int r117, int r118) {
        return toRgb565Bitmap(null, r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }

    public static Bitmap toRgbaBitmap(ByteBuffer r110, boolean r111, int r112, boolean r113, int r114, int r115, int r116, int r117, int r118) {
        return toRgbaBitmap(null, r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }

    public static HeifData toRgbaExternBuffer(byte[] r110, int r111, byte[] r112, int r113, boolean r114, int r115, int r116, int r117, int r118, int r210) {
        return toRgbaExternBuffer(r110, false, r111, r112, r113, r114, r115, r116, r117, r118, r210);
    }

    public static HeifData toRgb565(byte[] r110, int r111, boolean r112, int r113, boolean r114, int r210, int r211, int r212, int r213, int r214, int r215) {
        return toRgb565(r110, false, r111, false, 0, r112, r113, r114, r210, r211, r212, r213, r214, r215, false);
    }

    public static Bitmap toRgb565Bitmap(ByteBuffer r110, int r111, boolean r112, int r113, boolean r114, int r115, int r210, int r211, int r212, int r213, int r214) {
        return toRgb565Bitmap(r110, false, r111, false, 0, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public static HeifData toRgba(byte[] r110, int r111, boolean r112, int r113, boolean r114, int r210, int r211, int r212, int r213, int r214, int r215) {
        return toRgba(r110, false, r111, false, 0, r112, r113, r114, r210, r211, r212, r213, r214, r215, false);
    }

    public static Bitmap toRgbaBitmap(ByteBuffer r110, int r111, boolean r112, int r113, boolean r114, int r115, int r210, int r211, int r212, int r213, int r214) {
        return toRgbaBitmap(r110, false, r111, false, 0, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public static HeifData toRgb565(byte[] r110, boolean r111, int r112, boolean r113, int r114, boolean r210, int r211, int r212, int r213, int r214, int r215, int r216) {
        return toRgb565(r110, r111, r112, false, 0, r113, r114, r210, r211, r212, r213, r214, r215, r216, false);
    }

    public static Bitmap toRgb565Bitmap(Pool<Bitmap> r110, ByteBuffer r111, int r112, boolean r113, int r114, boolean r210, int r211, int r212, int r213, int r214, int r215, int r216) {
        return toRgb565Bitmap(r110, r111, false, r112, false, 0, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public static HeifData toRgba(byte[] r110, boolean r111, int r112, boolean r113, int r114, boolean r210, int r211, int r212, int r213, int r214, int r215, int r216) {
        return toRgba(r110, r111, r112, false, 0, r113, r114, r210, r211, r212, r213, r214, r215, r216, false);
    }

    public static Bitmap toRgbaBitmap(Pool<Bitmap> r110, ByteBuffer r111, int r112, boolean r113, int r114, boolean r210, int r211, int r212, int r213, int r214, int r215, int r216) {
        return toRgbaBitmap(r110, r111, false, r112, false, 0, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public static Bitmap toRgb565Bitmap(ByteBuffer r110, boolean r111, int r112, boolean r113, int r114, boolean r210, int r211, boolean r212, int r213, int r214, int r215, int r216, int r217, int r218) {
        return toRgb565Bitmap(null, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public static Bitmap toRgb565BitmapByNativePtr(long r110, int r111, boolean r210, int r211, int r212, boolean r213, int r214, boolean r215, int r216, int r217, int r218, int r219, int r310, int r311) {
        return toRgb565BitmapByNativePtr(r110, false, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, null);
    }

    public static Bitmap toRgb565BitmapOpt(ByteBuffer r110, int r111, boolean r112, int r113, int r210, boolean r211, int r212, boolean r213, int r214, int r215, int r216, int r217, int r218, int r219) {
        return toRgb565BitmapOpt(r110, false, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, null);
    }

    public static Bitmap toRgbaBitmap(ByteBuffer r110, boolean r111, int r112, boolean r113, int r114, boolean r210, int r211, boolean r212, int r213, int r214, int r215, int r216, int r217, int r218) {
        return toRgbaBitmap(null, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public static Bitmap toRgbaBitmapByNativePtr(long r110, int r111, boolean r210, int r211, int r212, boolean r213, int r214, boolean r215, int r216, int r217, int r218, int r219, int r310, int r311) {
        return toRgbaBitmapByNativePtr(r110, false, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, null);
    }

    public static Bitmap toRgbaBitmapOpt(ByteBuffer r110, int r111, boolean r112, int r113, int r210, boolean r211, int r212, boolean r213, int r214, int r215, int r216, int r217, int r218, int r219) {
        return toRgbaBitmapOpt(r110, false, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, null);
    }

    public static Bitmap toRgb565BitmapByNativePtr(Pool<Bitmap> r110, long r111, int r210, boolean r211, int r212, int r213, boolean r214, int r215, boolean r216, int r217, int r218, int r310, int r311, int r312, int r313) {
        return toRgb565BitmapByNativePtr(r110, r111, false, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, null);
    }

    public static Bitmap toRgb565BitmapOpt(Pool<Bitmap> r110, ByteBuffer r111, int r112, boolean r210, int r211, int r212, boolean r213, int r214, boolean r215, int r216, int r217, int r218, int r219, int r310, int r311) {
        return toRgb565BitmapOpt(r110, r111, false, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, null);
    }

    public static Bitmap toRgbaBitmapByNativePtr(Pool<Bitmap> r110, long r111, int r210, boolean r211, int r212, int r213, boolean r214, int r215, boolean r216, int r217, int r218, int r310, int r311, int r312, int r313) {
        return toRgbaBitmapByNativePtr(r110, r111, false, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, null);
    }

    public static Bitmap toRgbaBitmapOpt(Pool<Bitmap> r110, ByteBuffer r111, int r112, boolean r210, int r211, int r212, boolean r213, int r214, boolean r215, int r216, int r217, int r218, int r219, int r310, int r311) {
        return toRgbaBitmapOpt(r110, r111, false, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, null);
    }

    public static Bitmap toRgb565BitmapByNativePtr(long r110, boolean r210, int r211, boolean r212, int r213, int r214, boolean r215, int r216, boolean r217, int r218, int r219, int r310, int r311, int r312, int r313, int[] r314) {
        return toRgb565BitmapByNativePtr(null, r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public static Bitmap toRgb565BitmapOpt(ByteBuffer r110, boolean r111, int r112, boolean r210, int r211, int r212, boolean r213, int r214, boolean r215, int r216, int r217, int r218, int r219, int r310, int r311, int[] r312) {
        return toRgb565BitmapOpt(null, r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public static Bitmap toRgbaBitmapByNativePtr(long r110, boolean r210, int r211, boolean r212, int r213, int r214, boolean r215, int r216, boolean r217, int r218, int r219, int r310, int r311, int r312, int r313, int[] r314) {
        return toRgbaBitmapByNativePtr(null, r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public static Bitmap toRgbaBitmapOpt(ByteBuffer r110, boolean r111, int r112, boolean r210, int r211, int r212, boolean r213, int r214, boolean r215, int r216, int r217, int r218, int r219, int r310, int r311, int[] r312) {
        return toRgbaBitmapOpt(null, r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public static Bitmap toRgbaBitmapByNativePtrWithBmfSr(long r210, boolean r211, int r212, boolean r213, int r214, int r215, boolean r310, int r311, boolean r312, int r313, int r314, int r315, int r316, int r317, int r318, int r319, int r410, int r411, int r412, String r413, int[] r414) {
        return toRgbaBitmapByNativePtrWithBmfSr(null, r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
    }
}
