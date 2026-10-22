package com.facebook.webpsupport;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.downloadlib.constants.MimeType;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class WebpBitmapFactoryImpl implements WebpBitmapFactory {
    private static final int HEADER_SIZE = 20;
    public static final boolean IN_BITMAP_SUPPORTED = false;
    private static final int IN_TEMP_BUFFER_SIZE = 8192;
    private static BitmapCreator mBitmapCreator;
    private static WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;

    static {
        IN_BITMAP_SUPPORTED = true;
    }

    public WebpBitmapFactoryImpl() {
    }

    private static native Bitmap nativeDecodeByteArray(byte[] r100, int r101, int r102, BitmapFactory.Options r103, float r104, byte[] r105);

    private static native Bitmap nativeDecodeStream(InputStream r100, BitmapFactory.Options r101, float r102, byte[] r103);

    private static native long nativeSeek(FileDescriptor r100, long r101, boolean r102);

    public static DisplayMetrics INVOKEVIRTUAL_com_facebook_webpsupport_WebpBitmapFactoryImpl_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private static byte[] getInTempStorageFromOptions(@Nullable BitmapFactory.Options r100) {
        if (r100 == null) goto L7;
        byte[] r101 = r100.inTempStorage;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new byte[8192];
    }

    private static float getScaleFromOptions(BitmapFactory.Options r100) {
        float r101 = 1.0f;
        if (r100 == null) goto L15;
        int r102 = r100.inSampleSize;
        if (r102 <= 1) goto L8;
        r101 = 1.0f / r102;
    L8:
        if (r100.inScaled == false) goto L16;
        int r103 = r100.inDensity;
        int r104 = r100.inTargetDensity;
        int r105 = r100.inScreenDensity;
        if (r103 == 0) goto L17;
        if (r104 == 0) goto L18;
        if (r103 != r105) goto L14;
        return r101;
    L14:
        return r104 / r103;
    L18:
        return r101;
    L17:
        return r101;
    L16:
        return r101;
    L15:
        return 1.0f;
    }

    public static Bitmap hookDecodeFile(String r100) {
        return hookDecodeFile(r100, null);
    }

    public static Bitmap hookDecodeFileDescriptor(FileDescriptor r100) {
        return hookDecodeFileDescriptor(r100, null, null);
    }

    public static Bitmap hookDecodeStream(InputStream r100) {
        return hookDecodeStream(r100, null, null);
    }

    private static Bitmap originalDecodeFile(String r100) {
        return BitmapFactory.decodeFile(r100);
    }

    private static Bitmap originalDecodeFileDescriptor(FileDescriptor r100) {
        return BitmapFactory.decodeFileDescriptor(r100);
    }

    private static Bitmap originalDecodeStream(InputStream r100) {
        return BitmapFactory.decodeStream(r100);
    }

    private static void sendWebpErrorLog(String r100) {
        WebpBitmapFactory.WebpErrorLogger r101 = mWebpErrorLogger;
        if (r101 == null) goto L6;
        r101.onWebpErrorLog(r100, "decoding_failure");
        return;
    }

    private static void setPaddingDefaultValues(@Nullable Rect r100) {
        if (r100 == null) goto L5;
        r100.top = -1;
        r100.left = -1;
        r100.bottom = -1;
        r100.right = -1;
        return;
    }

    private static boolean shouldPremultiply(BitmapFactory.Options r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        return r100.inPremultiplied;
    }

    private static InputStream wrapToMarkSupportedStream(InputStream r100) {
        if (r100.markSupported() == false) goto L5;
        return r100;
    L5:
        return new BufferedInputStream(r100, 20);
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public void setBitmapCreator(BitmapCreator r100) {
        mBitmapCreator = r100;
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public void setWebpErrorLogger(WebpBitmapFactory.WebpErrorLogger r100) {
        mWebpErrorLogger = r100;
    }

    private static byte[] getWebpHeader(InputStream r100, BitmapFactory.Options r101) {
        r100.mark(20);
        if (r101 == null) goto L9;
        byte[] r102 = r101.inTempStorage;
        if (r102 == null) goto L9;
        if (r102.length < 20) goto L9;
    L15:
        r100.read(r102, 0, 20);     // Catch: IOException -> L13
        r100.reset();     // Catch: IOException -> L13
        return r102;
    L13:
        return null;
    L9:
        r102 = new byte[20];
        goto L15
    }

    public static Bitmap hookDecodeFile(String r100, BitmapFactory.Options r101) {
        Bitmap r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L16
        r102 = hookDecodeStream(r103, null, r101);     // Catch: Throwable -> L7
        r103.close();     // Catch: Exception -> L16
        goto L15
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: Exception -> L16
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L16
    L15:
        return r102;
    }

    public static Bitmap hookDecodeResource(Resources r100, int r101) {
        return hookDecodeResource(r100, r101, null);
    }

    private static Bitmap originalDecodeFile(String r100, BitmapFactory.Options r101) {
        return BitmapFactory.decodeFile(r100, r101);
    }

    private static Bitmap originalDecodeResource(Resources r100, int r101) {
        return BitmapFactory.decodeResource(r100, r101);
    }

    private static void setDensityFromOptions(Bitmap r100, BitmapFactory.Options r101) {
        if (r100 == null) goto L28;
        if (r101 == null) goto L34;
        int r102 = r101.inDensity;
        if (r102 == 0) goto L18;
        r100.setDensity(r102);
        int r103 = r101.inTargetDensity;
        if (r103 == 0) goto L16;
        if (r102 != r103) goto L11;
        return;
    L11:
        if (r102 != r101.inScreenDensity) goto L14;
        return;
    L14:
        if (r101.inScaled == false) goto L29;
        r100.setDensity(r103);
        return;
    L29:
        return;
    L16:
        return;
    L18:
        if (IN_BITMAP_SUPPORTED == true) goto L20;
        return;
    L20:
        if (r101.inBitmap == null) goto L32;
        int r104 = INVOKEVIRTUAL_com_facebook_webpsupport_WebpBitmapFactoryImpl_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).densityDpi;
        if (r104 == 0) goto L24;
        r100.setDensity(r104);
        return;
    L24:
        r100.setDensity(160);
        return;
    L32:
        return;
    L34:
        return;
    }

    private static void setWebpBitmapOptions(Bitmap r100, BitmapFactory.Options r101) {
        setDensityFromOptions(r100, r101);
        if (r101 == null) goto L6;
        r101.outMimeType = MimeType.WEBP;
        return;
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public Bitmap decodeFile(String r100, BitmapFactory.Options r101) {
        return hookDecodeFile(r100, r101);
    }

    private static Bitmap createBitmap(int r100, int r101, BitmapFactory.Options r102) {
        if (IN_BITMAP_SUPPORTED == false) goto L12;
        if (r102 == null) goto L12;
        Bitmap r103 = r102.inBitmap;
        if (r103 == null) goto L12;
        if (r103.isMutable() == false) goto L12;
        return r102.inBitmap;
    L12:
        return mBitmapCreator.createNakedBitmap(r100, r101, Bitmap.Config.ARGB_8888);
    }

    public static Bitmap hookDecodeByteArray(byte[] r100, int r101, int r102) {
        return hookDecodeByteArray(r100, r101, r102, null);
    }

    public static Bitmap hookDecodeFileDescriptor(FileDescriptor r100, Rect r101, BitmapFactory.Options r102) {
        StaticWebpNativeLoader.ensure();
        long r103 = nativeSeek(r100, 0, false);
        if (r103 == (-1)) goto L21;
        InputStream r104 = wrapToMarkSupportedStream(new PolarisFileInputStreamWrapper(r100));
        byte[] r105 = getWebpHeader(r104, r102);     // Catch: Throwable -> L18
        if (WebpSupportStatus.sIsWebpSupportRequired == true) goto L8;
    L13:
        nativeSeek(r100, r103, true);     // Catch: Throwable -> L18
        Bitmap r106 = originalDecodeFileDescriptor(r100, r101, r102);     // Catch: Throwable -> L18
        if (r106 != null) goto L26;
        sendWebpErrorLog("webp_direct_decode_fd_failed_on_no_webp");     // Catch: Throwable -> L18
    L26:
        r104.close();     // Catch: Throwable -> L23
        return r106;
    L31:
        return r106;
    L8:
        if (WebpSupportStatus.isWebpHeader(r105, 0, 20) == false) goto L13;
        r106 = nativeDecodeStream(r104, r102, getScaleFromOptions(r102), getInTempStorageFromOptions(r102));     // Catch: Throwable -> L18
        if (r106 != null) goto L12;
        sendWebpErrorLog("webp_direct_decode_fd");     // Catch: Throwable -> L18
    L12:
        setPaddingDefaultValues(r101);     // Catch: Throwable -> L18
        setWebpBitmapOptions(r106, r102);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L24
    L20:
        throw th;
    L21:
        Bitmap r107 = hookDecodeStream(new PolarisFileInputStreamWrapper(r100), r101, r102);
        setPaddingDefaultValues(r101);
        return r107;
    }

    public static Bitmap hookDecodeResource(Resources r100, int r101, BitmapFactory.Options r102) {
        TypedValue r103 = new TypedValue();
        Bitmap r104 = null;
        InputStream r105 = r100.openRawResource(r101, r103);     // Catch: Exception -> L17
        r104 = hookDecodeResourceStream(r100, r103, r105, null, r102);     // Catch: Throwable -> L8
        if (r105 == null) goto L19;
        r105.close();     // Catch: Exception -> L17
        goto L19
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r105 != null) goto L32;
    L16:
        throw th;     // Catch: Exception -> L17
    L32:
        r105.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L17
    L19:
        if (IN_BITMAP_SUPPORTED == false) goto L27;
        if (r104 != null) goto L27;
        if (r102 == null) goto L27;
        if (r102.inBitmap == null) goto L27;
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    L27:
        return r104;
    }

    public static Bitmap hookDecodeStream(InputStream r100, Rect r101, BitmapFactory.Options r102) {
        StaticWebpNativeLoader.ensure();
        InputStream r103 = wrapToMarkSupportedStream(r100);
        byte[] r104 = getWebpHeader(r103, r102);
        if (WebpSupportStatus.sIsWebpSupportRequired == true) goto L7;
        if (Build.VERSION.SDK_INT == 28) goto L7;
    L14:
        Bitmap r105 = originalDecodeStream(r103, r101, r102);
        if (r105 != null) goto L17;
        sendWebpErrorLog("webp_direct_decode_stream_failed_on_no_webp");
    L17:
        return r105;
    L7:
        if (WebpSupportStatus.isWebpHeader(r104, 0, 20) == false) goto L14;
        if (r102.inPreferredConfig != Bitmap.Config.ARGB_8888) goto L14;
        r105 = nativeDecodeStream(r103, r102, getScaleFromOptions(r102), getInTempStorageFromOptions(r102));
        if (r105 != null) goto L13;
        sendWebpErrorLog("webp_direct_decode_stream");
    L13:
        setWebpBitmapOptions(r105, r102);
        setPaddingDefaultValues(r101);
        goto L17
    }

    private static Bitmap originalDecodeByteArray(byte[] r100, int r101, int r102) {
        return BitmapFactory.decodeByteArray(r100, r101, r102);
    }

    private static Bitmap originalDecodeFileDescriptor(FileDescriptor r100, Rect r101, BitmapFactory.Options r102) {
        return BitmapFactory.decodeFileDescriptor(r100, r101, r102);
    }

    private static Bitmap originalDecodeResource(Resources r100, int r101, BitmapFactory.Options r102) {
        return BitmapFactory.decodeResource(r100, r101, r102);
    }

    private static Bitmap originalDecodeStream(InputStream r100, Rect r101, BitmapFactory.Options r102) {
        return BitmapFactory.decodeStream(r100, r101, r102);
    }

    private static void setBitmapSize(@Nullable BitmapFactory.Options r100, int r101, int r102) {
        if (r100 == null) goto L5;
        r100.outWidth = r101;
        r100.outHeight = r102;
        return;
    }

    private static boolean setOutDimensions(BitmapFactory.Options r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.inJustDecodeBounds == false) goto L9;
        r100.outWidth = r101;
        r100.outHeight = r102;
        return true;
    L9:
        return false;
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public Bitmap decodeFileDescriptor(FileDescriptor r100, Rect r101, BitmapFactory.Options r102) {
        return hookDecodeFileDescriptor(r100, r101, r102);
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public Bitmap decodeStream(InputStream r100, Rect r101, BitmapFactory.Options r102) {
        return hookDecodeStream(r100, r101, r102);
    }

    public static Bitmap hookDecodeByteArray(byte[] r100, int r101, int r102, BitmapFactory.Options r110) {
        StaticWebpNativeLoader.ensure();
        if (WebpSupportStatus.sIsWebpSupportRequired == true) goto L5;
    L10:
        Bitmap r103 = originalDecodeByteArray(r100, r101, r102, r110);
        if (r103 != null) goto L13;
        sendWebpErrorLog("webp_direct_decode_array_failed_on_no_webp");
    L13:
        return r103;
    L5:
        if (WebpSupportStatus.isWebpHeader(r100, r101, r102) == false) goto L10;
        r103 = nativeDecodeByteArray(r100, r101, r102, r110, getScaleFromOptions(r110), getInTempStorageFromOptions(r110));
        if (r103 != null) goto L9;
        sendWebpErrorLog("webp_direct_decode_array");
    L9:
        setWebpBitmapOptions(r103, r110);
        goto L13
    }

    private static Bitmap originalDecodeByteArray(byte[] r100, int r101, int r102, BitmapFactory.Options r103) {
        return BitmapFactory.decodeByteArray(r100, r101, r102, r103);
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public Bitmap decodeByteArray(byte[] r100, int r101, int r102, BitmapFactory.Options r103) {
        return hookDecodeByteArray(r100, r101, r102, r103);
    }

    public static Bitmap hookDecodeResourceStream(Resources r100, TypedValue r101, InputStream r102, Rect r103, BitmapFactory.Options r104) {
        if (r104 != null) goto L5;
        r104 = new BitmapFactory.Options();
    L5:
        if (r104.inDensity != 0) goto L14;
        if (r101 == null) goto L14;
        int r105 = r101.density;
        if (r105 != 0) goto L11;
        r104.inDensity = 160;
        goto L14
    L11:
        if (r105 == 65535) goto L14;
        r104.inDensity = r105;
    L14:
        if (r104.inTargetDensity != 0) goto L18;
        if (r100 == null) goto L18;
        r104.inTargetDensity = INVOKEVIRTUAL_com_facebook_webpsupport_WebpBitmapFactoryImpl_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100).densityDpi;
    L18:
        return hookDecodeStream(r102, r103, r104);
    }

    private static Bitmap originalDecodeResourceStream(Resources r100, TypedValue r101, InputStream r102, Rect r103, BitmapFactory.Options r104) {
        return BitmapFactory.decodeResourceStream(r100, r101, r102, r103, r104);
    }
}
