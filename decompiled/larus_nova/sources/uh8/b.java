package uh8;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.InputStream;
import java.security.MessageDigest;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f550108a = null;

    static {
        f550108a = new b();
    }

    public b() {
    }

    public static boolean d(PolarisFileWrapper r100) {
        if (r100.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        return true;
    }

    public static Uri f(String r100) {
        String r101 = StringsKt.trim(r100).toString();
        if (r101 != null) goto L5;
    L21:
        return null;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L21;
        if (StringsKt.startsWith$default(r101, "content://", false, 2, null) == true) goto L20;
        if (StringsKt.startsWith$default(r101, MSkiaImageRegionDecoder.FILE_PREFIX, false, 2, null) == true) goto L20;
        return Uri.fromFile(new PolarisFileWrapper(r101));
    L20:
        return UriProtector.parse(r101);
    L7:
        r102 = false;
        goto L8
    }

    public static InputStream e(Context r100, Uri r101) {
        String r102 = r101.getScheme();
        if (r102 == null) goto L23;
        int r103 = r102.hashCode();
        if (r103 == 0) goto L21;
        if (r103 == 3143036) goto L15;
        if (r103 == 951530617) goto L12;
    L27:
        return null;
    L12:
        if (r102.equals("content") == false) goto L27;
        return ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);
    L15:
        if (r102.equals("file") == false) goto L27;
        String r104 = r101.getPath();
        if (r104 == null) goto L27;
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r104));
    L30:
        return r105;
    L21:
        if (r102.equals("") == false) goto L27;
    L23:
        String r106 = r101.getPath();
        if (r106 == null) goto L27;
        r105 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r106));
        goto L30
    }

    public static boolean g(Bitmap r100, PolarisFileWrapper r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.getAbsolutePath() + DefaultDiskStorage.FileType.TEMP);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L19
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Throwable -> L19
        r100.compress(Bitmap.CompressFormat.JPEG, 85, r104);     // Catch: Throwable -> L14
    L6:
        CloseableKt.closeFinally(r104, null);     // Catch: Throwable -> L19
        if (r101.exists() == false) goto L9;
        r101.delete();     // Catch: Throwable -> L19
    L9:
        boolean r105 = r102.renameTo(r101);     // Catch: Throwable -> L19
        if (r105 == true) goto L12;
        r102.delete();     // Catch: Throwable -> L19
    L12:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r105));     // Catch: Throwable -> L19
    L22:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L24;
        r102.delete();
    L24:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L28;
        r106 = r107;
    L28:
        return ((Boolean) r106).booleanValue();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public static Bitmap b(Context r100, Uri r101, int r102) {
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        int r104 = 1;
        r103.inJustDecodeBounds = true;
        InputStream r105 = e(r100, r101);
        if (r105 == null) goto L12;
        BitmapFactory.decodeStream(r105, null, r103);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r105, null);
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    L12:
        if (r103.outWidth > 0) goto L14;
        return null;
    L14:
        if (r103.outHeight <= 0) goto L41;
        BitmapFactory.Options r106 = new BitmapFactory.Options();
        r106.inJustDecodeBounds = false;
        r106.inPreferredConfig = Bitmap.Config.RGB_565;
        b r107 = f550108a;
        int r108 = r103.outWidth;
        int r109 = r103.outHeight;
        r107.getClass();
    L18:
        if (Math.max(r108 / r104, r109 / r104) <= r102) goto L20;
        r104 = r104 * 2;
        goto L18
    L20:
        r106.inSampleSize = r104;
        InputStream r110 = e(r100, r101);
        if (r110 == null) goto L39;
        Bitmap r111 = BitmapFactory.decodeStream(r110, null, r106);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r110, null);
        return r111;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r110, th);
        throw th;
    L39:
        return null;
    L41:
        return null;
    }

    public static String c(b r100, Context r101, String r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = StringsKt.trim(r102).toString();
        if (r103 == null) goto L32;
        boolean r104 = true;
        if (r103.length() <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L34;
        Uri r106 = f(r103);
        if (r106 == null) goto L35;
        int r107 = 1440;
        Integer r108 = 1440;
        if (r108.intValue() > 0) goto L20;
        r104 = false;
    L20:
        if (r104 == true) goto L23;
        r108 = null;
    L23:
        if (r108 == null) goto L25;
        r107 = r108.intValue();
    L25:
        PolarisFileWrapper r109 = a(r101, r103, r106, r107);
        f550108a.getClass();
        if (d(r109) == true) goto L29;
        r109 = null;
    L29:
        if (r109 != null) goto L31;
        return null;
    L31:
        return r109.getAbsolutePath();
    L35:
        return null;
    L34:
        return null;
    L7:
        r105 = false;
        goto L8
    L32:
        return null;
    }

    public static PolarisFileWrapper a(Context r110, String r111, Uri r112, int r113) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110.getCacheDir(), "local_image_preview");
        r100.mkdirs();
        String r101 = r112.getScheme();
        if (r101 == null) goto L18;
        int r102 = r101.hashCode();
        if (r102 == 0) goto L16;
        if (r102 == 3143036) goto L10;
    L21:
        PolarisFileWrapper r103 = null;
    L22:
        long r104 = 0;
        if (r103 != null) goto L25;
    L30:
        long r105 = 0;
    L32:
        if (r103 == null) goto L40;
        if (r103.exists() == true) goto L37;
        r103 = null;
    L37:
        if (r103 == null) goto L40;
        long r106 = r103.length();
    L72:
        byte[] r107 = MessageDigest.getInstance("SHA-256").digest(CollectionsKt.joinToString$default(CollectionsKt.listOf(new Object[]{r111, Long.valueOf(r105), Long.valueOf(r106), Integer.valueOf(r113)}), "#", null, null, 0, null, null, 62, null).getBytes(Charsets.UTF_8));
        Intrinsics.checkNotNull(r107);
        return new PolarisFileWrapper(r100, "preview_" + ArraysKt.joinToString$default(r107, "", null, null, 0, null, new a(), 30, null) + ".jpg");
    L40:
        if (Intrinsics.areEqual(r112.getScheme(), "content") == true) goto L76;
    L71:
        r106 = r104;
        goto L72
    L76:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L65
        AssetFileDescriptor r114 = ContentResolverWrapper.openAssetFileDescriptor(r110.getContentResolver(), r112, "r");     // Catch: Throwable -> L65
        if (r114 != null) goto L74;
        long r109 = 0;
    L63:
        Object r115 = Result.m9449constructorimpl(Long.valueOf(r109));     // Catch: Throwable -> L65
    L68:
        if (Result.m9455isFailureimpl(r115) == false) goto L70;
        r115 = 0L;
    L70:
        r104 = ((Number) r115).longValue();
        goto L71
    L74:
        Long r116 = Long.valueOf(r114.getLength());     // Catch: Throwable -> L57
        if (r116.longValue() <= 0) goto L47;
        boolean r117 = true;
    L48:
        if (r117 == true) goto L51;
        r116 = null;
    L51:
        if (r116 == null) goto L54;
        r109 = r116.longValue();     // Catch: Throwable -> L57
    L55:
        CloseableKt.closeFinally(r114, null);     // Catch: Throwable -> L65
        goto L63
    L54:
        r109 = 0;
        goto L55
    L47:
        r117 = false;
    L57:
        th = move-exception;
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        CloseableKt.closeFinally(r114, th);     // Catch: Throwable -> L65
        throw th;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L68
    L25:
        if (r103.exists() == false) goto L27;
        PolarisFileWrapper r119 = r103;
    L28:
        if (r119 == null) goto L30;
        r105 = r119.lastModified();
        goto L32
    L27:
        r119 = null;
        goto L28
    L10:
        if (r101.equals("file") == false) goto L21;
        String r120 = r112.getPath();
        if (r120 == null) goto L21;
        r103 = new PolarisFileWrapper(r120);
        goto L22
    L16:
        if (r101.equals("") == false) goto L21;
    L18:
        String r121 = r112.getPath();
        if (r121 == null) goto L21;
        r103 = new PolarisFileWrapper(r121);
        goto L22
    }
}
