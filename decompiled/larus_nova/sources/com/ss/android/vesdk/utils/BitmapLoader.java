package com.ss.android.vesdk.utils;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.ttve.nativePort.TEImageFactory;
import com.ss.android.vesdk.VEFileUtils;
import com.ss.android.vesdk.VELogUtil;
import f06.b;
import f06.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class BitmapLoader {
    public static final String TAG = "BitmapLoader";
    public static boolean isSampleSizeRound = false;
    public static int maxSide = 4096;

    public static final enum ImageRotation extends Enum<ImageRotation> {
        private static final /* synthetic */ ImageRotation[] $VALUES = null;
        public static final ImageRotation INVALID = null;
        public static final ImageRotation ROTATION_0 = null;
        public static final ImageRotation ROTATION_180 = null;
        public static final ImageRotation ROTATION_270 = null;
        public static final ImageRotation ROTATION_90 = null;
        private int value;

        private static /* synthetic */ ImageRotation[] $values() {
            return new ImageRotation[]{INVALID, ROTATION_0, ROTATION_90, ROTATION_180, ROTATION_270};
        }

        static {
            INVALID = new ImageRotation("INVALID", 0, -1);
            ROTATION_0 = new ImageRotation("ROTATION_0", 1, 0);
            ROTATION_90 = new ImageRotation("ROTATION_90", 2, 90);
            ROTATION_180 = new ImageRotation("ROTATION_180", 3, 180);
            ROTATION_270 = new ImageRotation("ROTATION_270", 4, 270);
            $VALUES = $values();
        }

        public static ImageRotation[] values() {
            return (ImageRotation[]) $VALUES.clone();
        }

        public int getRotation() {
            return this.value;
        }

        public static ImageRotation valueOf(String r100) {
            return (ImageRotation) a.a(ImageRotation.class, r100);
        }

        private ImageRotation(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public BitmapLoader() {
    }

    public static int UpAlignPo2(int r100, int r101) {
        return ((r100 + r101) - 1) & (~(r101 - 1));
    }

    private static Bitmap makeDimensionEven(Bitmap r100) {
        if (r100 != null) goto L24;
        return null;
    L24:
        int r101 = r100.getWidth();     // Catch: OutOfMemoryError -> L21
        int r102 = r100.getHeight();     // Catch: OutOfMemoryError -> L21
        boolean r103 = true;
        if ((r100.getWidth() & 1) != 1) goto L8;
        r101 = r100.getWidth() - 1;     // Catch: OutOfMemoryError -> L21
        boolean r104 = true;
    L10:
        if ((r100.getHeight() & 1) != 1) goto L12;
        r102 = r100.getHeight() - 1;     // Catch: OutOfMemoryError -> L21
    L13:
        if (r103 == true) goto L15;
        return r100;
    L15:
        if (r101 <= 0) goto L20;
        if (r102 <= 0) goto L20;
        Bitmap r105 = Bitmap.createBitmap(r100, 0, 0, r101, r102);     // Catch: OutOfMemoryError -> L21
        r100.recycle();     // Catch: OutOfMemoryError -> L21
        return r105;
    L20:
        return null;
    L12:
        r103 = r104;
        goto L13
    L8:
        r104 = false;
    L21:
        e = move-exception;
        e.getMessage();
        return null;
    }

    public static Point getPictureSize(ContentResolver r100, String r101) {
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inJustDecodeBounds = true;
        ParcelFileDescriptor r103 = null;
        if (VEFileUtils.isAndroidUriPath(r101) == true) goto L5;
        TEImageFactory.decodeImage(null, null, null, r101, r102);
    L37:
        return new Point(r102.outWidth, r102.outHeight);
    L5:
        Uri r104 = UriProtector.parse(r101);
        if (r100 != null) goto L9;
        VELogUtil.e(TAG, "contentResolver should not be null after Android Q");     // Catch: Throwable -> L24 FileNotFoundException -> L29
        return null;
    L9:
        ParcelFileDescriptor r105 = com_ss_android_vesdk_utils_BitmapLoader_android_content_ContentResolver_openFileDescriptor(r100, r104, "r");     // Catch: Throwable -> L24 FileNotFoundException -> L29
        if (r105 != null) goto L54;
        if (r105 != null) goto L50;
    L16:
        return null;
    L50:
        r105.close();     // Catch: IOException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L54:
        TEImageFactory.decodeImage(null, null, r105.getFileDescriptor(), r101, r102);     // Catch: Throwable -> L20 FileNotFoundException -> L22
        r105.close();     // Catch: IOException -> L34
    L47:
    L52:
        goto L37
    L22:
        e = move-exception;
        r103 = r105;
        e = e;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L38
        if (r103 == null) goto L52;
        r103.close();     // Catch: IOException -> L34
    L20:
        th = move-exception;
        r103 = r105;
        th = th;
    L25:
        VELogUtil.e(TAG, th.getMessage());     // Catch: Throwable -> L38
        if (r103 == null) goto L52;
        r103.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L38:
        th = move-exception;
        if (r103 != null) goto L45;
    L44:
        throw th;
    L45:
        r103.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
    L29:
        e = e;
    L24:
        th = th;
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    public static int getRotation(ParcelFileDescriptor r100, String r101) {
        ExifInterface r102 = null;
        if (VEFileUtils.isAndroidUriPath(r101) == false) goto L73;
        if (r100 != 0) goto L69;
        VELogUtil.e(TAG, "contentResolver should not be null after Android Q");
        return 0;
    L69:
        r100 = com_ss_android_vesdk_utils_BitmapLoader_android_content_ContentResolver_openFileDescriptor(r100, UriProtector.parse(r101), "r");     // Catch: Throwable -> L32 FileNotFoundException -> L38
        if (r100 != 0) goto L77;
        if (r100 != 0) goto L71;
    L19:
        return 0;
    L71:
        r100.close();     // Catch: IOException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L77:
    L30:
        e = e;
    L40:
        e.printStackTrace();     // Catch: Throwable -> L58
        if (r100 == 0) goto L68;
        r100.close();     // Catch: IOException -> L26
        r100 = r100;
    L65:
    L68:
    L43:
        if (r102 == null) goto L57;
        int r103 = com_ss_android_vesdk_utils_BitmapLoader_android_media_ExifInterface_getAttributeInt(r102, androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
        if (r103 != 3) goto L47;
        return 180;
    L47:
        if (r103 != 6) goto L49;
        return 90;
    L49:
        if (r103 == 8) goto L51;
        return 0;
    L51:
        return 270;
    L57:
        return 0;
    L28:
        th = th;
    L34:
        th.printStackTrace();     // Catch: Throwable -> L58
        if (r100 == 0) goto L68;
        r100.close();     // Catch: IOException -> L26
        r100 = r100;
        goto L65
    L21:
        if (Build.VERSION.SDK_INT < 24) goto L24;
        r102 = new ExifInterface(r100.getFileDescriptor());     // Catch: Throwable -> L28 FileNotFoundException -> L30
        goto L24
    L24:
        r100.close();     // Catch: IOException -> L26
        r100 = r100;
        goto L65
    L26:
        e = move-exception;
        e.printStackTrace();
    L38:
        e = e;
        r100 = 0;
    L32:
        th = th;
        r100 = 0;
    L58:
        th = move-exception;
        if (r100 != 0) goto L75;
    L64:
        throw th;
    L75:
        r100.close();     // Catch: IOException -> L62
    L62:
        e = move-exception;
        e.printStackTrace();
        goto L64
    L73:
        r102 = new ExifInterface(r101);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L43
    }

    private static ParcelFileDescriptor com_ss_android_vesdk_utils_BitmapLoader_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        b r112 = new b();
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
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
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
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static int com_ss_android_vesdk_utils_BitmapLoader_android_media_ExifInterface_getAttributeInt(ExifInterface r110, String r111, int r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210)};
        b r112 = new b();
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
        d r107 = r106.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r110, r101, "int", r112);     // Catch: Exception -> L22
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
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Bitmap loadBitmap(String r100, int r101, int r102) {
        return loadBitmap(r100, r101, r102, ImageRotation.INVALID, true);
    }

    private static int calculateInSampleSize(ContentResolver r100, String r101, int r102, int r103) {
        if (r102 == (-1)) goto L67;
        if (r103 == (-1)) goto L67;
        BitmapFactory.Options r104 = new BitmapFactory.Options();
        r104.inJustDecodeBounds = true;
        ParcelFileDescriptor r105 = null;
        if (VEFileUtils.isAndroidUriPath(r101) == true) goto L9;
        TEImageFactory.decodeImage(null, null, null, r101, r104);
    L40:
        int r106 = r104.outHeight;
        int r107 = r104.outWidth;
        if (r103 > r102) goto L44;
        r103 = r102;
        r102 = r103;
    L44:
        if (r106 <= r107) goto L46;
        r107 = r106;
        r106 = r107;
    L46:
        if (r106 > r102) goto L50;
        if (r107 > r103) goto L50;
        int r108 = 0;
    L59:
        return Math.max(1, r108);
    L50:
        float r109 = r107 / r103;
        float r110 = r106 / r102;
        if (isSampleSizeRound == false) goto L57;
        int r111 = Math.round(Math.max(r110, r109));
    L54:
        if ((Math.max(r107, r106) / r111) <= maxSide) goto L56;
        r111 = r111 * 2;
        goto L54
    L56:
        r108 = r111;
        goto L59
    L57:
        r108 = (int) Math.max(r110, r109);
        goto L59
    L9:
        Uri r112 = UriProtector.parse(r101);
        if (r100 != null) goto L13;
        VELogUtil.e(TAG, "contentResolver should not be null after Android Q");     // Catch: Throwable -> L28 FileNotFoundException -> L33
        return 1;
    L13:
        ParcelFileDescriptor r113 = com_ss_android_vesdk_utils_BitmapLoader_android_content_ContentResolver_openFileDescriptor(r100, r112, "r");     // Catch: Throwable -> L28 FileNotFoundException -> L33
        if (r113 != null) goto L77;
        if (r113 != null) goto L68;
    L20:
        return 1;
    L68:
        r113.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L77:
        TEImageFactory.decodeImage(null, null, r113.getFileDescriptor(), r101, r104);     // Catch: Throwable -> L24 FileNotFoundException -> L26
        r113.close();     // Catch: IOException -> L38
    L70:
    L73:
        goto L40
    L26:
        e = move-exception;
        r105 = r113;
        e = e;
    L34:
        e.printStackTrace();     // Catch: Throwable -> L60
        if (r105 == null) goto L73;
        r105.close();     // Catch: IOException -> L38
    L24:
        th = move-exception;
        r105 = r113;
        th = th;
    L29:
        th.getMessage();     // Catch: Throwable -> L60
        if (r105 == null) goto L73;
        r105.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L60:
        th = move-exception;
        if (r105 != null) goto L75;
    L66:
        throw th;
    L75:
        r105.close();     // Catch: IOException -> L64
    L64:
        e = move-exception;
        e.printStackTrace();
    L33:
        e = e;
    L28:
        th = th;
    L67:
        return 1;
    }

    public static Bitmap loadBitmapCompat(ContentResolver r100, String r101, int r102, int r103) {
        return loadBitmapCompat(r100, r101, r102, r103, ImageRotation.INVALID, true);
    }

    public static int[] calAutoScale(int r100, int r101, int r110, int r111, int r112) {
        int[] r102 = new int[2];
        if (r100 > 0) goto L7;
        if (r101 > 0) goto L7;
        boolean r103 = false;
    L9:
        if (r112 == 90) goto L11;
        if (r112 == 270) goto L11;
    L12:
        if (r103 == false) goto L20;
        if (r100 > 0) goto L16;
        r100 = (r101 * r110) / r111;
    L16:
        if (r101 > 0) goto L19;
        r101 = (r111 * r100) / r110;
    L19:
        r110 = UpAlignPo2(r100, 2);
        r111 = UpAlignPo2(r101, 2);
    L20:
        if (r112 == 90) goto L22;
        if (r112 == 270) goto L22;
    L23:
        r102[0] = r110;
        r102[1] = r111;
        return r102;
    L22:
        int r104 = r111;
        r111 = r110;
        r110 = r104;
    L11:
        r111 = r110;
        r110 = r111;
    L7:
        r103 = true;
        goto L9
    }

    public static Bitmap loadBitmap(String r100, int r101, int r102, ImageRotation r103, boolean r110) {
        return loadBitmap(r100, r101, r102, ImageRotation.INVALID, true, false);
    }

    public static Bitmap loadBitmap(String r100, int r101, int r102, ImageRotation r110, boolean r111, boolean r112) {
        return loadBitmap(r100, r101, r102, ImageRotation.INVALID, r111, r112, false);
    }

    public static Bitmap loadBitmapCompat(ContentResolver r100, String r101, int r102, int r110, ImageRotation r111, boolean r112) {
        return loadBitmapCompat(r100, r101, r102, r110, ImageRotation.INVALID, true, false);
    }

    public static Bitmap loadBitmap(String r110, int r111, int r112, ImageRotation r113, boolean r114, boolean r115, boolean r116) {
        int r100 = r111;
        int r101 = r112;
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        if (r100 <= 0) goto L51;
        if (r101 <= 0) goto L51;
        r102.inSampleSize = calculateInSampleSize(null, r110, r111, r112);
    L51:
        Bitmap r103 = TEImageFactory.decodeImage(null, null, null, r110, r102);     // Catch: Exception -> L48
        if (r103 != null) goto L12;
        return null;
    L12:
        if (r113 == ImageRotation.INVALID) goto L52;
        int r104 = r113.getRotation();     // Catch: Exception -> L48
    L31:
        if (r116 == false) goto L33;
        int[] r105 = calAutoScale(r111, r112, r103.getWidth(), r103.getHeight(), r104);     // Catch: Exception -> L48
        int r106 = r105[0];     // Catch: Exception -> L48
        r101 = r105[1];     // Catch: Exception -> L48
        r100 = r106;
    L33:
        if (r115 == false) goto L40;
        Bitmap r107 = Bitmap.createScaledBitmap(r103, r100, r101, true);     // Catch: Exception -> L48
        if (r107.sameAs(r103) == false) goto L37;
    L39:
        r103 = r107;
        goto L40
    L37:
        if (r103.isRecycled() == true) goto L39;
        r103.recycle();     // Catch: Exception -> L48
    L40:
        if (r104 == 0) goto L45;
        Matrix r117 = new Matrix();     // Catch: Exception -> L48
        r117.postRotate(r104);     // Catch: Exception -> L48
        Bitmap r108 = Bitmap.createBitmap(r103, 0, 0, r103.getWidth(), r103.getHeight(), r117, true);     // Catch: Exception -> L48
        if (r103.isRecycled() == true) goto L44;
        r103.recycle();     // Catch: Exception -> L48
    L44:
        r103 = r108;
    L45:
        if (r114 == true) goto L47;
        return r103;
    L47:
        return makeDimensionEven(r103);
    L52:
        ExifInterface r109 = new ExifInterface(r110);     // Catch: IOException -> L15 Exception -> L48
    L17:
        if (r109 == null) goto L28;
        int r118 = com_ss_android_vesdk_utils_BitmapLoader_android_media_ExifInterface_getAttributeInt(r109, androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);     // Catch: Exception -> L48
        if (r118 != 3) goto L21;
        r104 = 180;
        goto L31
    L21:
        if (r118 != 6) goto L23;
        r104 = 90;
        goto L31
    L23:
        if (r118 != 8) goto L28;
        r104 = 270;
    L28:
        r104 = 0;
        goto L31
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L48
        r109 = null;
    L48:
        e = move-exception;
        e.getMessage();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.net.Uri, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.os.ParcelFileDescriptor] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.os.ParcelFileDescriptor] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.os.ParcelFileDescriptor] */
    public static Bitmap loadBitmapCompat(ContentResolver r100, String r101, int r110, int r111, ImageRotation r112, boolean r113, boolean r114) {
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        if (VEFileUtils.isAndroidUriPath(r101) == false) goto L88;
        if (r110 <= 0) goto L9;
        if (r111 <= 0) goto L9;
        r102.inSampleSize = calculateInSampleSize(r100, r101, r110, r111);
    L9:
        if (r100 != null) goto L12;
        VELogUtil.e(TAG, "contentResolver should not be null after Android Q");
        return null;
    L12:
        ParcelFileDescriptor r103 = UriProtector.parse(r101);
        Objects.toString(r103);     // Catch: Throwable -> L30 FileNotFoundException -> L36
        r103 = com_ss_android_vesdk_utils_BitmapLoader_android_content_ContentResolver_openFileDescriptor(r100, r103, "r");     // Catch: Throwable -> L30 FileNotFoundException -> L36
        if (r103 != 0) goto L85;
        if (r103 != 0) goto L83;
    L20:
        return null;
    L83:
        r103.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L85:
        Bitmap r104 = TEImageFactory.decodeImage(null, null, r103.getFileDescriptor(), r101, r102);     // Catch: Throwable -> L26 FileNotFoundException -> L28
        r103.close();     // Catch: IOException -> L24
    L45:
        if (r104 == null) goto L47;
        if (r114 == false) goto L56;
        Bitmap r115 = Bitmap.createScaledBitmap(r104, r110, r111, true);
        if (r115.sameAs(r104) == false) goto L52;
    L54:
        r104 = r115;
        goto L56
    L52:
        if (r104.isRecycled() == true) goto L54;
        r104.recycle();
    L56:
        if (r112 != ImageRotation.INVALID) goto L58;
        int r105 = getRotation(r100, r101);
    L59:
        if (r105 == 0) goto L63;
        Matrix r106 = new Matrix();
        r106.postRotate(r105);
        Bitmap r107 = Bitmap.createBitmap(r104, 0, 0, r104.getWidth(), r104.getHeight(), r106, true);
        if (r104.isRecycled() == true) goto L64;
        r104.recycle();
    L64:
        if (r113 == true) goto L66;
        return r107;
    L66:
        return makeDimensionEven(r107);
    L63:
        r107 = r104;
        goto L64
    L58:
        r105 = r112.getRotation();
        goto L59
    L47:
        return null;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L28:
        e = e;
    L38:
        e.printStackTrace();     // Catch: Throwable -> L67
        if (r103 == 0) goto L44;
        r103.close();     // Catch: IOException -> L42
        r103 = r103;
    L80:
    L44:
        r104 = null;
    L26:
        th = th;
    L32:
        th.getMessage();     // Catch: Throwable -> L67
        if (r103 == 0) goto L44;
        r103.close();     // Catch: IOException -> L42
        r103 = r103;
        goto L80
    L67:
        th = move-exception;
        if (r103 != 0) goto L74;
    L73:
        throw th;
    L74:
        r103.close();     // Catch: IOException -> L71
    L71:
        e = move-exception;
        e.printStackTrace();
    L36:
        e = e;
        r103 = 0;
    L30:
        th = th;
        r103 = 0;
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L88:
        return loadBitmap(r101, r110, r111, r112, r113, r114);
    }
}
