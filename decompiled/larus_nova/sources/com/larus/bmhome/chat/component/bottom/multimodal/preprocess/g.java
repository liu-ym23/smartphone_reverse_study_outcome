package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.image.entity.LoadParams;
import ic8.m0;
import ic8.n0;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import v19.m5;

/* JADX INFO: loaded from: classes25.dex */
public final class g extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LocalTakePictureImpl f299944d;

    public static final class a {
    }

    static {
    }

    public g() {
        this.f299944d = new LocalTakePictureImpl();
    }

    public static boolean j(String r100) {
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r100));
        int r102 = r101.available();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r101.close();     // Catch: Throwable -> L5
    L6:
        FLogger.f375446a.i("SendResourcePreprocessManager_CameraImgProcessor", "[checkFileSize] size:" + r102);
        if (r102 < 204800) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean k(String r100) {
        BitmapFactory.Options r101 = new BitmapFactory.Options();
        r101.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r100, r101);
        String r102 = r101.outMimeType;
        FLogger.f375446a.i("SendResourcePreprocessManager_CameraImgProcessor", "[checkImageType] type:" + r102);
        Intrinsics.checkNotNull(r102);
        return x.a(r102);
    }

    public static m0 m(String r110) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110);
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);
        long r102 = r101.available();     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r101, null);
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        r103.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r110, r103);
        String r104 = r103.outMimeType;
        String r105 = r100.getName();
        Regex r106 = j.f299948a;
        return new m0(r110, r105, r102, r104, null, null, j.a(r100.getName(), r104), 12272);
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }

    public final Float n(String r100) {
        int r101 = 1;
        ExifInterface r102 = new ExifInterface(r100);     // Catch: Throwable -> L5
        this.f299943c = r102;     // Catch: Throwable -> L5
        r101 = r102.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);     // Catch: Throwable -> L5
    L8:
        if (r101 == 3) goto L17;
        if (r101 == 6) goto L22;
        if (r101 == 8) goto L21;
        return null;
    L21:
        return Float.valueOf(270.0f);
    L22:
        return Float.valueOf(90.0f);
    L17:
        return Float.valueOf(180.0f);
    L5:
        th = move-exception;
        FLogger.f375446a.e("SendResourcePreprocessManager_CameraImgProcessor", "[getImgOrientation] err: " + th);
        goto L8
    }

    public final String q(String r110, ns8.b r111) {
        String r112 = SendResourcePreprocessManager.h(false, LoadParams.ImageFormat.JPEG, false, r111, null, r110, 20);
        x.b(r112);
        FLogger r100 = FLogger.f375446a;
        r100.i("SendResourcePreprocessManager_CameraImgProcessor", "[tryRenameOriginalTmpImg] outPath:".concat(r112));
        Float r101 = n(r110);
        if (r101 != null) goto L36;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r110);
        PolarisFileWrapper r113 = new PolarisFileWrapper(r112);
        boolean r103 = r102.renameTo(r113);
        r100.i("SendResourcePreprocessManager_CameraImgProcessor", "[renameFile] renameFile, renamed:" + r103);
        if (r103 == true) goto L30;
        boolean r104 = false;
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r102);     // Catch: IOException -> L28
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r113);     // Catch: Throwable -> L23
        byte[] r114 = new byte[1024];     // Catch: Throwable -> L18
    L11:
        int r107 = r105.read(r114);     // Catch: Throwable -> L18
        if (r107 <= 0) goto L14;
        r106.write(r114, 0, r107);     // Catch: Throwable -> L18
        goto L11
    L14:
        r102.delete();     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r106, null);     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r105, null);     // Catch: IOException -> L28
        goto L30
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: IOException -> L28
        throw th;     // Catch: IOException -> L28
    L28:
        e = move-exception;
        FLogger.f375446a.e("SendResourcePreprocessManager_CameraImgProcessor", "[renameFile] " + e);
    L31:
        FLogger.f375446a.i("SendResourcePreprocessManager_CameraImgProcessor", "[tryRenameOriginalTmpImg] tryRenameOriginalTmpImg just rename, result:" + r104);
        if (r104 == true) goto L82;
        m5.b(r112);
        return null;
    L82:
        return r112;
    L30:
        r104 = true;
        goto L31
    L36:
        Matrix r115 = new Matrix();
        r115.postRotate(r101.floatValue());
        r100.i("SendResourcePreprocessManager_CameraImgProcessor", " [tryRenameOriginalTmpImg] tryRenameOriginalTmpImg not to rotate degree:" + r101);
        Bitmap r108 = BitmapFactory.decodeFile(r110);     // Catch: Throwable -> L44
        Bitmap r109 = Bitmap.createBitmap(r108, 0, 0, r108.getWidth(), r108.getHeight(), r115, true);     // Catch: Throwable -> L44
        PolarisFileOutputStreamWrapper r116 = new PolarisFileOutputStreamWrapper(r112);     // Catch: Throwable -> L44
        r109.compress(Bitmap.CompressFormat.JPEG, 100, r116);     // Catch: Throwable -> L42
        r116.flush();     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r116, "<this>");
        r116.close();     // Catch: Throwable -> L58
    L41:
        m5.b(r110);
        return r112;
    L42:
        th = th;
    L76:
        FLogger.f375446a.e("SendResourcePreprocessManager_CameraImgProcessor", "[tryRenameOriginalTmpImg] tryRenameOriginalTmpImg fix degree er: " + th);     // Catch: Throwable -> L52
        m5.b(r112);     // Catch: Throwable -> L52
        if (r116 == null) goto L50;
        Intrinsics.checkNotNullParameter(r116, "<this>");
        r116.close();     // Catch: Throwable -> L59
    L50:
        m5.b(r110);
        return null;
    L52:
        th = move-exception;
        if (r116 == null) goto L56;
        Intrinsics.checkNotNullParameter(r116, "<this>");
        r116.close();     // Catch: Throwable -> L60
    L56:
        m5.b(r110);
        throw th;
    L44:
        th = th;
        r116 = null;
        goto L76
    }

    public final String o(String r210, ns8.a r211, ns8.b r212) {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L47
        if (j(r210) == true) goto L6;
    L44:
        String r102 = null;
    L45:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L47
    L49:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L53;
        FLogger.f375446a.e("SendResourcePreprocessManager_CameraImgProcessor", "[tryCompress] err: " + r104);
    L53:
        if (Result.m9455isFailureimpl(r103) == true) goto L57;
        r100 = r103;
    L57:
        return (String) r100;
    L6:
        if (k(r210) == false) goto L44;
        if (r211 == null) goto L11;
        Bitmap.CompressFormat r105 = r211.f520346d;     // Catch: Throwable -> L47
        if (r105 == null) goto L11;
    L12:
        Bitmap r106 = p(r210, r211, r212);     // Catch: Throwable -> L47
        boolean r107 = true;
        int r110 = 100;
        IntRange r108 = new IntRange(1, 100);     // Catch: Throwable -> L47
        if (r211 == null) goto L15;
        Integer r111 = r211.f520345c;     // Catch: Throwable -> L47
    L17:
        if (r111 != null) goto L19;
    L21:
        boolean r109 = false;
    L22:
        if (r109 == false) goto L27;
        if (r211 == null) goto L35;
        Integer r112 = r211.f520345c;     // Catch: Throwable -> L47
        if (r112 == null) goto L35;
        r110 = r112.intValue();     // Catch: Throwable -> L47
    L35:
        String r113 = i.a(r105);     // Catch: Throwable -> L47
        r102 = SendResourcePreprocessManager.h(false, r113, false, r212, null, r210, 20);     // Catch: Throwable -> L47
        x.b(r102);     // Catch: Throwable -> L47
        FLogger r114 = FLogger.f375446a;     // Catch: Throwable -> L47
        r114.i("SendResourcePreprocessManager_CameraImgProcessor", "[tryCompress] outPath:".concat(r102));     // Catch: Throwable -> L47
        if (r(r106, r102, r110, r105) == true) goto L45;
        if (z2.f365865a.enableImagePreprocessCacheFallback() == false) goto L44;
        r102 = SendResourcePreprocessManager.g(false, r113);     // Catch: Throwable -> L47
        x.b(r102);     // Catch: Throwable -> L47
        r114.w("SendResourcePreprocessManager_CameraImgProcessor", "[tryCompress] retry compress to cache outPath:".concat(r102));     // Catch: Throwable -> L47
        if (r(r106, r102, r110, r105) == false) goto L44;
    L27:
        z2 r115 = z2.f365865a;     // Catch: Throwable -> L47
        int r116 = r115.imageUploadOptConfig().f486802d;     // Catch: Throwable -> L47
        if (1 <= r116) goto L30;
    L32:
        r107 = false;
    L33:
        if (r107 == false) goto L35;
        r110 = r115.imageUploadOptConfig().f486802d;     // Catch: Throwable -> L47
        goto L35
    L30:
        if (r116 >= 101) goto L32;
    L19:
        if (r108.contains(r111.intValue()) == false) goto L21;
        r109 = true;
        goto L22
    L15:
        r111 = null;
    L11:
        r105 = Bitmap.CompressFormat.JPEG;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    }

    public final Bitmap p(String r100, ns8.a r101, ns8.b r110) {
        Bitmap r102 = BitmapFactory.decodeFile(r100);
        Float r103 = n(r100);
        if (r103 == null) goto L5;
        float r104 = r103.floatValue();
    L6:
        boolean r105 = false;
        if (r101 == null) goto L11;
        Integer r106 = r101.f520343a;
        if (r106 == null) goto L11;
        int r107 = r106.intValue();
    L13:
        if (r107 > 0) goto L15;
        float r108 = 1.0f;
    L30:
        float r111 = f.a(r108, r110);
        if (r104 != 0.0f) goto L33;
        boolean r109 = true;
    L35:
        if (r109 == true) goto L37;
    L42:
        Matrix r112 = new Matrix();
        r112.postRotate(r104);
        r112.postScale(r111, r111);
        FLogger r113 = FLogger.f375446a;
        StringBuilder r114 = new StringBuilder("[tryFixImgDegreeForCompress] not to rotate degree:");
        r114.append(r104);
        r114.append(", optShortSize: ");
        if (r101 == null) goto L45;
        Integer r115 = r101.f520343a;
    L46:
        r114.append(r115);
        r113.i("SendResourcePreprocessManager_CameraImgProcessor", r114.toString());
        return Bitmap.createBitmap(r102, 0, 0, r102.getWidth(), r102.getHeight(), r112, true);
    L45:
        r115 = null;
        goto L46
    L37:
        if (r111 != 1.0f) goto L39;
        r105 = true;
    L39:
        if (r105 == false) goto L42;
        FLogger.f375446a.i("SendResourcePreprocessManager_CameraImgProcessor", "[tryFixImgDegreeForCompress] not to rotate");
        Intrinsics.checkNotNull(r102);
        return r102;
    L33:
        r109 = false;
        goto L35
    L15:
        if (r102.getWidth() >= r102.getHeight()) goto L22;
        if (r101 == null) goto L20;
        Integer r116 = r101.f520343a;
        if (r116 == null) goto L20;
        int r117 = r116.intValue();
    L21:
        float r118 = r117;
        int r119 = r102.getWidth();
    L28:
        r108 = r118 / r119;
    L20:
        r117 = 0;
        goto L21
    L22:
        if (r101 == null) goto L26;
        Integer r120 = r101.f520343a;
        if (r120 == null) goto L26;
        int r121 = r120.intValue();
    L27:
        r118 = r121;
        r119 = r102.getHeight();
    L26:
        r121 = 0;
    L11:
        r107 = 0;
        goto L13
    L5:
        r104 = 0.0f;
        goto L6
    }

    public final n0 l(String r110, boolean r111, ns8.a r112, ns8.b r113) {
        Intrinsics.checkNotNullParameter(r110, "tmpSrcPath");
        m0 r100 = m(r110);     // Catch: Exception -> L41
        boolean r101 = false;
        if (r113 != null) goto L6;
    L8:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L11;
        String r103 = null;
    L12:
        r100.f489227e = r103;     // Catch: Exception -> L41
        this.f299944d.k(r110, r103);     // Catch: Exception -> L41
        FLogger r104 = FLogger.f375446a;     // Catch: Exception -> L41
        r104.i("SendResourcePreprocessManager_CameraImgProcessor", "[execIncludeClone] exec compressPath:" + r103);     // Catch: Exception -> L41
        if (r103 != null) goto L15;
    L18:
        boolean r105 = true;
    L19:
        if (r105 == true) goto L31;
        m5.b(r110);     // Catch: Exception -> L41
        if (r111 == false) goto L23;
        ImFileUtil r114 = ImFileUtil.f314899a;     // Catch: Exception -> L41
        PolarisFileWrapper r115 = new PolarisFileWrapper(r103);     // Catch: Exception -> L41
        r114.getClass();     // Catch: Exception -> L41
        r100.f489228f = ImFileUtil.g(r115);     // Catch: Exception -> L41
    L23:
        if (r112 != null) goto L25;
    L27:
        if (r101 == false) goto L30;
        e.d(this.f299943c, r103);     // Catch: Exception -> L41
    L30:
        return new n0(r100, ProcessFileResultCode.PREPARE_COMPRESSED_SUCCESS);
    L25:
        if (r112.f520347e != true) goto L27;
        r101 = true;
        goto L27
    L31:
        String r116 = q(r110, r113);     // Catch: Exception -> L41
        r100.f489227e = r116;     // Catch: Exception -> L41
        this.f299944d.k(r110, r116);     // Catch: Exception -> L41
        if (o0.d(r116) == false) goto L35;
        if (r111 == false) goto L35;
        ImFileUtil r117 = ImFileUtil.f314899a;     // Catch: Exception -> L41
        PolarisFileWrapper r118 = new PolarisFileWrapper(r116);     // Catch: Exception -> L41
        r117.getClass();     // Catch: Exception -> L41
        r100.f489228f = ImFileUtil.g(r118);     // Catch: Exception -> L41
    L35:
        r104.i("SendResourcePreprocessManager_CameraImgProcessor", "[execIncludeClone] exec renamePath:" + r116);     // Catch: Exception -> L41
        if (o0.d(r116) == false) goto L38;
        ProcessFileResultCode r119 = ProcessFileResultCode.PREPARE_CLONE_SUCCESS;     // Catch: Exception -> L41
    L40:
        return new n0(r100, r119);
    L38:
        r119 = ProcessFileResultCode.PREPARE_CLONE_FAILED;     // Catch: Exception -> L41
        goto L40
    L15:
        if (r103.length() == 0) goto L18;
        r105 = false;
        goto L19
    L11:
        r103 = o(r110, r112, r113);     // Catch: Exception -> L41
        goto L12
    L6:
        if (r113.f520351a != true) goto L8;
        r102 = true;
    L41:
        e = move-exception;
        FLogger.f375446a.e("SendResourcePreprocessManager_CameraImgProcessor", "[execIncludeClone] exec error, msg: " + e.getMessage());
        return new n0(null, ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR);
    }

    public final boolean r(Bitmap r100, String r101, int r102, Bitmap.CompressFormat r110) {
        boolean r103 = true;
        boolean r104 = false;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
        e.b(r101);     // Catch: Throwable -> L18
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L18
        boolean r107 = g(r110);     // Catch: Throwable -> L16
        int r108 = i.b(r110, r102, r107);     // Catch: Throwable -> L16
        if (r107 == false) goto L7;
        int r111 = com.larus.image.loader.v.f350991a;     // Catch: Throwable -> L16
        boolean r109 = com.larus.image.loader.v.a(r100, r108, r106, f().g());     // Catch: Throwable -> L16
    L8:
        if (r109 == true) goto L10;
        FLogger.f375446a.e("SendResourcePreprocessManager_CameraImgProcessor", "[writeCompressedBitmap] compress failed, outPath:".concat(r101));     // Catch: Throwable -> L16
        boolean r112 = true;
    L39:
        Object r113 = Result.m9449constructorimpl(Boolean.valueOf(r104));     // Catch: Throwable -> L14
    L21:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L24;
        FLogger.f375446a.e("SendResourcePreprocessManager_CameraImgProcessor", "[writeCompressedBitmap] failed, outPath:" + r101 + ", err:" + r114);
    L25:
        if (r106 == null) goto L30;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        r106.close();     // Catch: Throwable -> L29
    L30:
        if (r103 == false) goto L32;
        m5.b(r101);
    L32:
        Boolean r115 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r113) == false) goto L36;
        r113 = r115;
    L36:
        return ((Boolean) r113).booleanValue();
    L24:
        r103 = r112;
    L14:
        Throwable th10 = th;
        r104 = r112;
    L20:
        Result.Companion r116 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r112 = r104;
        goto L21
    L10:
        r106.flush();     // Catch: Throwable -> L16
        r112 = false;
        r104 = true;
        goto L39
    L7:
        r109 = r100.compress(r110, r108, r106);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th10 = th;
    L18:
        th = move-exception;
        th10 = th;
        r106 = null;
        goto L20
    }
}
