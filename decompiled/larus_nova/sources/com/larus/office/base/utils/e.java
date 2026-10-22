package com.larus.office.base.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f361172a = null;

    static {
        f361172a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new d());
    }

    public static ContentResolver b() {
        return (ContentResolver) f361172a.getValue();
    }

    public static String c(String r110) {
        if (r110 != null) goto L5;
    L11:
        return null;
    L5:
        if (TextUtils.isEmpty(r110) == false) goto L7;
        return null;
    L7:
        int r100 = (int) Math.max(StringsKt.lastIndexOf$default(r110, '/', 0, false, 6, null), StringsKt.lastIndexOf$default(r110, '\\', 0, false, 6, null));
        if (r100 < 0) goto L11;
        return r110.substring(r100 + 1);
    }

    public static long d(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
    L21:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L4:
        if (Intrinsics.areEqual("content", r100.getScheme()) == false) goto L15;
        ContentResolver r101 = b();     // Catch: Exception -> L21
        Cursor r102 = a(r101, r100, new String[]{"_size"});     // Catch: Exception -> L21
        if (r102 != null) goto L8;
    L20:
        return -1;
    L8:
        if (r102.moveToFirst() == false) goto L13;
        int r103 = r102.getColumnIndex("_size");     // Catch: Exception -> L21
        if (r103 == (-1)) goto L13;
        long r104 = r102.getLong(r103);     // Catch: Exception -> L21
        r102.close();     // Catch: Exception -> L21
        return r104;
    L13:
        r102.close();     // Catch: Exception -> L21
        goto L20
    L15:
        if (Intrinsics.areEqual("file", r100.getScheme()) == false) goto L20;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r100.getPath());     // Catch: Exception -> L21
        if (r105.exists() == false) goto L20;
        return r105.length();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    public static Pair e(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        InputStream r100 = null;
        BitmapFactory.Options r101 = new BitmapFactory.Options();     // Catch: Throwable -> L33 Exception -> L35
        r101.inJustDecodeBounds = true;     // Catch: Throwable -> L33 Exception -> L35
        if (Intrinsics.areEqual("content", r110.getScheme()) == false) goto L30;
        InputStream r102 = ContentResolverWrapper.openInputStream(b(), r110);     // Catch: Throwable -> L33 Exception -> L35
        if (r102 == null) goto L13;
        BitmapFactory.decodeStream(r102, null, r101);     // Catch: Throwable -> L25 Exception -> L27
        Pair r111 = new Pair(Integer.valueOf(r101.outWidth), Integer.valueOf(r101.outHeight));     // Catch: Throwable -> L25 Exception -> L27
        r102.close();     // Catch: IOException -> L10
    L12:
        return r111;
    L10:
        e = move-exception;
        FLogger.f375446a.e("ImageUtil", "Close inputStream error: " + e);
        goto L12
    L13:
        FileInputStream r112 = (FileInputStream) ContentResolverWrapper.openInputStream(b(), r110);     // Catch: Throwable -> L25 Exception -> L27
        if (r112 != null) goto L72;
    L48:
        return null;
    L72:
        BitmapFactory.decodeFileDescriptor(r112.getFD(), null, r101);     // Catch: Throwable -> L21 Exception -> L23
        Pair r103 = new Pair(Integer.valueOf(r101.outWidth), Integer.valueOf(r101.outHeight));     // Catch: Throwable -> L21 Exception -> L23
        r112.close();     // Catch: IOException -> L18
    L20:
        return r103;
    L18:
        e = move-exception;
        FLogger.f375446a.e("ImageUtil", "Close fileInputStream error: " + e);
    L23:
        Exception e100 = e;
    L37:
        FLogger.f375446a.e("ImageUtil", "getImageDimensions error: " + e100);     // Catch: Throwable -> L21
        if (r102 != null) goto L64;
    L43:
        if (r112 == null) goto L48;
        r112.close();     // Catch: IOException -> L46
    L46:
        e = move-exception;
        FLogger.f375446a.e("ImageUtil", "Close fileInputStream error: " + e);
        goto L48
    L64:
        r102.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        FLogger.f375446a.e("ImageUtil", "Close inputStream error: " + e);
    L27:
        e = move-exception;
        e100 = e;
        r112 = null;
    L25:
        th = move-exception;
        th = th;
        r110 = null;
    L49:
        r100 = r102;
        Throwable r104 = th;
        ?? r105 = r110;
        th = r104;
    L50:
        if (r100 != null) goto L62;
    L55:
        if (r105 == 0) goto L77;
        r105.close();     // Catch: IOException -> L58
        throw th;
    L58:
        e = move-exception;
        FLogger.f375446a.e("ImageUtil", "Close fileInputStream error: " + e);
        throw th;
    L77:
        throw th;
    L62:
        r100.close();     // Catch: IOException -> L53
    L53:
        e = move-exception;
        FLogger.f375446a.e("ImageUtil", "Close inputStream error: " + e);
        goto L55
    L30:
        if (Intrinsics.areEqual("file", r110.getScheme()) == false) goto L48;
        BitmapFactory.decodeFile(r110.getPath(), r101);     // Catch: Throwable -> L33 Exception -> L35
        return new Pair(Integer.valueOf(r101.outWidth), Integer.valueOf(r101.outHeight));
    L21:
        th = th;
    L35:
        e = move-exception;
        e100 = e;
        r112 = null;
        r102 = null;
    L33:
        th = th;
        r105 = 0;
        goto L50
    }

    public static String f(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (Intrinsics.areEqual("content", r100.getScheme()) == false) goto L10;
        String r101 = b().getType(r100);
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101;
    L10:
        if (Intrinsics.areEqual("file", r100.getScheme()) == false) goto L19;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getPath());
        if (r102.exists() == false) goto L20;
        String r103 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(FilesKt.getExtension(r102));
        if (r103 != null) goto L17;
        return "";
    L17:
        return r103;
    L20:
        return "";
    L19:
        return "";
    }

    public static String g(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (Intrinsics.areEqual("content", r100.getScheme()) == false) goto L27;
        Cursor r101 = a(b(), r100, new String[]{"_display_name"});     // Catch: Exception -> L20
        Cursor r102 = r101;     // Catch: Throwable -> L15
        if (r102 != null) goto L8;
    L12:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r101, null);     // Catch: Exception -> L20
    L22:
        String r104 = r100.getPath();
        if (TextUtils.isEmpty(r104) == false) goto L25;
    L30:
        return null;
    L25:
        return c(r104);
    L8:
        if (r102.moveToFirst() == false) goto L12;
        String r105 = r102.getString(r102.getColumnIndexOrThrow("_display_name"));     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r101, null);     // Catch: Exception -> L20
        return r105;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);     // Catch: Exception -> L20
        throw th;     // Catch: Exception -> L20
    L20:
        e = move-exception;
        FLogger.f375446a.e("ImageUtil", "getPhotoNameFromUri error: " + e);
        goto L22
    L27:
        if (Intrinsics.areEqual("file", r100.getScheme()) == false) goto L30;
        return c(r100.getPath());
    }

    public static String h(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (Intrinsics.areEqual("content", r100.getScheme()) == false) goto L27;
        Cursor r101 = a(b(), r100, new String[]{"_data"});     // Catch: Exception -> L20
        Cursor r102 = r101;     // Catch: Throwable -> L15
        if (r102 != null) goto L8;
    L12:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r101, null);     // Catch: Exception -> L20
    L22:
        String r104 = r100.getPath();
        if (TextUtils.isEmpty(r104) == false) goto L25;
    L30:
        return null;
    L25:
        return c(r104);
    L8:
        if (r102.moveToFirst() == false) goto L12;
        String r105 = r102.getString(r102.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r101, null);     // Catch: Exception -> L20
        return r105;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);     // Catch: Exception -> L20
        throw th;     // Catch: Exception -> L20
    L20:
        e = move-exception;
        FLogger.f375446a.e("ImageUtil", "getPhotoNameFromUri error: " + e);
        goto L22
    L27:
        if (Intrinsics.areEqual("file", r100.getScheme()) == false) goto L30;
        return c(r100.getPath());
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }
}
