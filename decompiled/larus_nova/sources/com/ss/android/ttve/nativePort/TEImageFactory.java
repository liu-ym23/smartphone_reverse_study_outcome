package com.ss.android.ttve.nativePort;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VEFileUtils;
import com.ss.android.vesdk.VELogUtil;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public class TEImageFactory {
    private static final String BITMAP = "bitmap";
    private static final int IMAGE_COLORSPACE_TYPE_DISPLAYP3 = 1;
    private static final int IMAGE_COLORSPACE_TYPE_SRGB = 0;
    private static final int IMAGE_COLORSPACE_TYPE_UNKNOWN = -1;
    private static final String TAG = "TEImageFactory";
    private static RandomAccessFile raf;

    public static class ImageInfo {
        Bitmap bitmap;
        String colorSpace;
        int height;
        String mimeType;
        int rotation;
        int width;

        public ImageInfo() {
            this.rotation = 0;
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public String getColorSpace() {
            return this.colorSpace;
        }

        public int getHeight() {
            return this.height;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public int getRotation() {
            return this.rotation;
        }

        public int getWidth() {
            return this.width;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap[] f449957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f449958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitmapFactory.Options f449959c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f449957a[0] = BitmapFactory.decodeFile(this.f449958b, this.f449959c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Bitmap[] r100, String r101, BitmapFactory.Options r102) {
            this.f449957a = r100;
            this.f449958b = r101;
            this.f449959c = r102;
        }
    }

    public TEImageFactory() {
    }

    private static boolean isDeviceOptOpen() {
        VEConfigCenter.ValuePkt r100 = VEConfigCenter.getInstance().getValue("ve_enable_schdule_device_capability_opt");
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getValue() != null) goto L7;
        return false;
    L7:
        if ((r100.getValue() instanceof Integer) == true) goto L9;
        return false;
    L9:
        if (((Integer) r100.getValue()).intValue() < 7) goto L15;
        return true;
    L15:
        return false;
    }

    public static void recycleBitmap(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isRecycled() == true) goto L8;
        r100.recycle();
        return;
    }

    private static Bitmap copyByDraw(Bitmap.Config r100, Bitmap r101) {
        Bitmap r102 = Bitmap.createBitmap(r101.getWidth(), r101.getHeight(), r100);
        new Canvas(r102).drawBitmap(r101, 0.0f, 0.0f, null);
        return r102;
    }

    public static ImageInfo decodeFile(ContentResolver r100, String r101) {
        return decodeFile(r100, r101, null, 0, 0, -1, null);
    }

    public static String getImageColorSpace(ContentResolver r100, String r101) {
        String r102 = "Unknown";
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return "Unknown";
    L5:
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        r103.inJustDecodeBounds = true;
        Bitmap r104 = decodeFileCompat(r100, r101, r103);
        ColorSpace r105 = r103.outColorSpace;
        if (r105 == null) goto L9;
        r102 = r105.getName();
    L9:
        if (isDeviceOptOpen() == false) goto L11;
        recycleBitmap(r104);
    L11:
        return r102;
    }

    public static ImageInfo getImageInfo(ContentResolver r110, String r111) {
        long r100 = System.currentTimeMillis();
        if (VEConfigCenter.getInstance().getValue("ve_enable_cache_file_info_opt", false).booleanValue() == false) goto L8;
        com.ss.android.ttve.nativePort.a r101 = com.ss.android.ttve.nativePort.a.C5448a.f449971a;
        if (r101.f449968a.containsKey(r111) == false) goto L8;
        VELogUtil.d(TAG, "getImageInfo cache cost = " + (System.currentTimeMillis() - r100) + ", filePath = " + VELogUtil.getSafeString(r111));
        return r101.f449968a.get(r111);
    L8:
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inJustDecodeBounds = true;
        Bitmap r112 = decodeFileCompat(r110, r111, r102);
        ImageInfo r103 = new ImageInfo();
        r103.width = r102.outWidth;
        r103.height = r102.outHeight;
        r103.mimeType = r102.outMimeType;
        if (Build.VERSION.SDK_INT < 26) goto L14;
        ColorSpace r104 = r102.outColorSpace;
        if (r104 == null) goto L14;
        r103.colorSpace = r104.getName();
    L15:
        VELogUtil.i(TAG, "getImageInfo colorSapce is " + r103.colorSpace + " ,width is " + r103.width + " ,height is " + r103.height + " ,mimeType is " + r103.mimeType);
        int r105 = r111.lastIndexOf(46);
        if (r105 >= 0) goto L18;
    L20:
        String r106 = null;
    L22:
        if (r103.mimeType == null) goto L30;
        if (r106 == null) goto L30;
        if (r106.equals("mpg") == false) goto L27;
    L28:
        r103.mimeType = null;
        goto L30
    L27:
        if (r106.equals("mpeg") == true) goto L28;
    L30:
        if (isDeviceOptOpen() == false) goto L32;
        recycleBitmap(r112);
    L32:
        VELogUtil.d(TAG, "getImageInfo cost = " + (System.currentTimeMillis() - r100) + ", filePath = " + VELogUtil.getSafeString(r111));
        com.ss.android.ttve.nativePort.a.C5448a.f449971a.f449968a.put(r111, r103);
        return r103;
    L18:
        if ((r105 + 1) >= r111.length()) goto L20;
        r106 = r111.substring(r111.lastIndexOf(46) + 1);
    L14:
        r103.colorSpace = "Unknown";
        goto L15
    }

    public static int getRotation(ContentResolver r100, String r101) {
        long r102 = System.currentTimeMillis();
        int r103 = 0;
        if (VEConfigCenter.getInstance().getValue("ve_enable_cache_file_info_opt", false).booleanValue() == false) goto L8;
        com.ss.android.ttve.nativePort.a r104 = com.ss.android.ttve.nativePort.a.C5448a.f449971a;
        if (r104.f449969b.containsKey(r101) == false) goto L8;
        VELogUtil.d(TAG, "getRotation cache cost = " + (System.currentTimeMillis() - r102) + ", filePath = " + r101);
        return r104.f449969b.get(r101).intValue();
    L8:
        ExifInterface r105 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        ParcelFileDescriptor r106 = null;
        r105 = null;
        if (VEFileUtils.isAndroidUriPath(r101) == false) goto L64;
        if (r100 != null) goto L67;
        VELogUtil.e(TAG, "contentResolver should not be null after Android Q");
        return 0;
    L67:
        ParcelFileDescriptor r107 = com_ss_android_ttve_nativePort_TEImageFactory_android_content_ContentResolver_openFileDescriptor(r100, UriProtector.parse(r101), "r");     // Catch: Throwable -> L36 Exception -> L38
        if (r107 != null) goto L69;
        if (r107 != null) goto L74;
    L25:
        return 0;
    L74:
        r107.close();     // Catch: IOException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L69:
    L34:
        e = e;
    L40:
        e.printStackTrace();     // Catch: Throwable -> L56
        if (r107 == null) goto L43;
        r107.close();     // Catch: IOException -> L32
    L66:
    L43:
        if (r105 == null) goto L55;
        int r108 = com_ss_android_ttve_nativePort_TEImageFactory_android_media_ExifInterface_getAttributeInt(r105, androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
        if (r108 != 3) goto L47;
        r103 = 180;
    L54:
        com.ss.android.ttve.nativePort.a.C5448a.f449971a.f449969b.put(r101, Integer.valueOf(r103));
        VELogUtil.d(TAG, "getRotation cost = " + (System.currentTimeMillis() - r102) + ", filePath = " + r101);
        goto L55
    L47:
        if (r108 != 6) goto L49;
        r103 = 90;
        goto L54
    L49:
        if (r108 != 8) goto L54;
        r103 = 270;
    L55:
        return r103;
    L56:
        th = th;
        r106 = r107;
    L58:
        if (r106 != null) goto L71;
    L63:
        throw th;
    L71:
        r106.close();     // Catch: IOException -> L61
    L61:
        e = move-exception;
        e.printStackTrace();
        goto L63
    L27:
        if (Build.VERSION.SDK_INT < 24) goto L30;
        r105 = new ExifInterface(r107.getFileDescriptor());     // Catch: Exception -> L34 Throwable -> L56
    L30:
        r107.close();     // Catch: IOException -> L32
        goto L66
    L32:
        e = move-exception;
        e.printStackTrace();
    L38:
        e = e;
        r107 = null;
    L36:
        th = th;
        goto L58
    L64:
        r105 = new ExifInterface(r101);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L43
    }

    private static ParcelFileDescriptor com_ss_android_ttve_nativePort_TEImageFactory_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r110, r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static int com_ss_android_ttve_nativePort_TEImageFactory_android_media_ExifInterface_getAttributeInt(ExifInterface r110, String r111, int r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210)};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.getAttributeInt(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Bitmap decodeFileCompat(ContentResolver r100, String r101, BitmapFactory.Options r102) {
        return decodeFileCompat(r100, r101, r102, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v9 */
    private static Bitmap decodeFileCompatBeforeQ(String r100, BitmapFactory.Options r101, Rect r102) {
        if (Build.MANUFACTURER.toLowerCase().contains("meizu") == false) goto L9;
        int r103 = Build.VERSION.SDK_INT;
        if (r103 != 24) goto L7;
    L8:
        ?? r104 = 1;
    L53:
        if (r104 == 0) goto L49;
        RandomAccessFile r105 = new RandomAccessFile(r100, "r");     // Catch: Throwable -> L23 FileNotFoundException -> L31
        Bitmap r106 = decodeImage(r102, null, r105.getFD(), r100, r101);     // Catch: Throwable -> L19 FileNotFoundException -> L21
        r105.close();     // Catch: IOException -> L16
    L18:
        return r106;
    L16:
        e = move-exception;
        VELogUtil.e(TAG, "mz raf close error " + e);
        goto L18
    L21:
        e = e;
    L33:
        VELogUtil.e(TAG, "mz decodeFileDescriptor error " + e);     // Catch: Throwable -> L41
        r104 = r105;
        if (r105 != null) goto L59;
    L52:
    L40:
        return null;
    L59:
        r105.close();     // Catch: IOException -> L37
        r104 = r105;
    L37:
        e = e;
        StringBuilder r107 = new StringBuilder("mz raf close error ");
    L39:
        r107.append(e);
        VELogUtil.e(TAG, r107.toString());
    L19:
        th = th;
    L25:
        VELogUtil.e(TAG, "mz decodeFileDescriptor error " + th);     // Catch: Throwable -> L41
        r104 = r105;
        if (r105 == null) goto L52;
        r105.close();     // Catch: IOException -> L29
        r104 = r105;
    L29:
        e = e;
        r107 = new StringBuilder("mz raf close error ");
        goto L39
    L31:
        e = e;
        r105 = null;
    L23:
        th = th;
        r105 = null;
        goto L25
    L49:
        return decodeImage(r102, null, null, r100, r101);
    L41:
        th = move-exception;
        if (r104 != 0) goto L50;
    L47:
        throw th;
    L50:
        r104.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        VELogUtil.e(TAG, "mz raf close error " + e);
        goto L47
    L7:
        if (r103 == 25) goto L8;
    L9:
        r104 = 0;
        goto L53
    }

    public static Bitmap decodeFileCompat(ContentResolver r100, String r101, BitmapFactory.Options r102, Rect r103) {
        if (VEFileUtils.isAndroidUriPath(r101) == true) goto L7;
        return decodeFileCompatBeforeQ(r101, r102, r103);
    L7:
        return decodeFileCompatAfterQ(r100, r101, r102, r103);
    }

    private static Bitmap decodeFileCompatAfterQ(ContentResolver r100, String r101, BitmapFactory.Options r102, Rect r103) {
        if (r100 != null) goto L48;
        VELogUtil.e(TAG, "contentResolver should not be null after Android Q");
        return null;
    L48:
        ParcelFileDescriptor r104 = com_ss_android_ttve_nativePort_TEImageFactory_android_content_ContentResolver_openFileDescriptor(r100, Uri.parse(r101), "r");     // Catch: Throwable -> L23
        if (r104 != null) goto L15;
        VELogUtil.e(TAG, "can not open file descriptor");     // Catch: Throwable -> L21
        if (r104 != null) goto L41;
    L14:
        return null;
    L41:
        r104.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L15:
        Bitmap r105 = decodeImage(r103, null, r104.getFileDescriptor(), r101, r102);     // Catch: Throwable -> L21
        r104.close();     // Catch: IOException -> L18
    L20:
        return r105;
    L18:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = th;
    L50:
        VELogUtil.e(TAG, "decodeFileCompatAfterQ exception!", th);     // Catch: Throwable -> L32
        if (r104 != null) goto L39;
    L31:
        return null;
    L39:
        r104.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
    L32:
        th = move-exception;
        if (r104 != null) goto L43;
    L38:
        throw th;
    L43:
        r104.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L23:
        th = th;
        r104 = null;
        goto L50
    }

    public static Bitmap decodeImage(Rect r100, Rect r101, FileDescriptor r102, String r103, BitmapFactory.Options r104) {
        if (r100 == null) goto L22;
        if (r102 == null) goto L12;
        Bitmap r105 = BitmapRegionDecoder.newInstance(r102, false).decodeRegion(r100, r104);     // Catch: Throwable -> L14
    L18:
        return r105;
    L12:
        r105 = BitmapRegionDecoder.newInstance(r103, false).decodeRegion(r100, r104);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        VELogUtil.e(TAG, "BitmapRegionDecoder filePath mode error " + th);
    L16:
        return null;
    L22:
        if (r102 == null) goto L6;
        Bitmap r106 = BitmapFactory.decodeFileDescriptor(r102, r101, r104);     // Catch: Throwable -> L8
    L21:
        return r106;
    L6:
        Bitmap[] r107 = new Bitmap[1];     // Catch: Throwable -> L8
        TEUtils.nativeTryExecute(new a(r107, r103, r104));     // Catch: Throwable -> L8
        r106 = r107[0];     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        VELogUtil.e(TAG, "BitmapRegionDecoder filePath mode error " + th);
        goto L16
    }

    public static ImageInfo decodeFile(ContentResolver r100, String r101, BitmapFactory.Options r102, int r110, int r111, int r112) {
        return decodeFile(r100, r101, r102, r110, r111, r112, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00a2 -> B:47:0x00a5). Please report as a decompilation issue!!! */
    public static int writeFrame2file(byte[] r100, int r101, int r102, int r103, int r104, String r105) {
        ByteBuffer r106 = ByteBuffer.wrap(r100);
        Bitmap r107 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        r107.copyPixelsFromBuffer(r106);
        VELogUtil.i(TAG, "writeFrameData2JPGFile path " + r105);
        PolarisFileWrapper r108 = new PolarisFileWrapper(r105);
        if (r108.exists() == false) goto L5;
        r108.delete();
    L5:
        PolarisFileOutputStreamWrapper r109 = null;
        r108.createNewFile();     // Catch: Throwable -> L29 Exception -> L31
        PolarisFileOutputStreamWrapper r110 = new PolarisFileOutputStreamWrapper(r108);     // Catch: Throwable -> L29 Exception -> L31
        if (r103 != 1) goto L14;
        r107.compress(Bitmap.CompressFormat.JPEG, r104, r110);     // Catch: Throwable -> L10 Exception -> L12
    L25:
        r110.flush();     // Catch: Throwable -> L10 Exception -> L12
        r107.recycle();
        r110.close();     // Catch: IOException -> L37
    L47:
        return 0;
    L14:
        if (r103 != 0) goto L17;
        r107.compress(Bitmap.CompressFormat.PNG, r104, r110);     // Catch: Throwable -> L10 Exception -> L12
        goto L25
    L17:
        if (r103 != 2) goto L24;
        Boolean r111 = VEConfigCenter.getInstance().getValue("ve_enable_android_webp_encode_opt", false);     // Catch: Throwable -> L10 Exception -> L12
        if (Build.VERSION.SDK_INT >= 30) goto L21;
    L23:
        r107.compress(Bitmap.CompressFormat.WEBP, r104, r110);     // Catch: Throwable -> L10 Exception -> L12
        goto L25
    L21:
        if (r111.booleanValue() == false) goto L23;
        r107.compress(Bitmap.CompressFormat.WEBP_LOSSY, r104, r110);     // Catch: Throwable -> L10 Exception -> L12
        goto L25
    L24:
        VELogUtil.i(TAG, "writeFrameData2JPGFile error type = " + r103);     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = e;
        r109 = r110;
    L32:
        e.printStackTrace();     // Catch: Throwable -> L29
        r107.recycle();
        if (r109 == null) goto L47;
        r109.close();     // Catch: IOException -> L37
    L10:
        th = th;
        r109 = r110;
    L40:
        r107.recycle();
        if (r109 != null) goto L53;
    L46:
        throw th;
    L53:
        r109.close();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        e.printStackTrace();
    L29:
        th = th;
    L31:
        e = e;
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L47
    }

    public static ImageInfo decodeFile(ContentResolver r100, String r101, BitmapFactory.Options r102, int r103, int r104, int r105, Rect r110) {
        if (r102 != null) goto L4;
        r102 = new BitmapFactory.Options();
    L4:
        boolean r106 = true;
        if (Build.VERSION.SDK_INT < 26) goto L9;
        if (r105 == 1) goto L8;
        r102.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        goto L9
    L8:
        r102.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
    L9:
        if (r103 <= 0) goto L25;
        if (r104 <= 0) goto L25;
        r102.inJustDecodeBounds = true;
        Bitmap r107 = decodeFileCompat(r100, r101, r102);
        if (VEConfigCenter.getInstance().getValue("ve_enable_img_downsample_calculate_opt", false).booleanValue() == false) goto L14;
    L17:
        if (r106 == true) goto L19;
        int r108 = TEJpegUtils.calBestSampleSize(r102.outWidth, r102.outHeight, r103, r104);
    L20:
        if (r108 <= 0) goto L22;
        r102.inSampleSize = r108;
    L22:
        r102.inJustDecodeBounds = false;
        if (isDeviceOptOpen() == false) goto L25;
        recycleBitmap(r107);
        goto L25
    L19:
        r108 = TEJpegUtils.calBestSampleSize2(r102.outWidth, r102.outHeight, r103, r104);
        goto L20
    L14:
        if (VEConfigCenter.getInstance().getValue("ve_enable_image_decode_sharpness_opt", false).booleanValue() == true) goto L17;
        r106 = false;
    L25:
        r102.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap r109 = decodeFileCompat(r100, r101, r102, r110);
        if (r109 != null) goto L29;
        VELogUtil.e(TAG, "bitmap is null");
        return null;
    L29:
        Bitmap.Config r111 = r109.getConfig();
        Bitmap.Config r112 = Bitmap.Config.ARGB_8888;
        if (r111 == r112) goto L32;
        Bitmap r113 = copyByDraw(r112, r109);
        recycleBitmap(r109);
        r109 = r113;
    L32:
        ImageInfo r114 = new ImageInfo();
        r114.width = r109.getWidth();
        r114.height = r109.getHeight();
        r114.bitmap = r109;
        r114.mimeType = "bitmap";
        r114.rotation = getRotation(r100, r101);
        return r114;
    }
}
