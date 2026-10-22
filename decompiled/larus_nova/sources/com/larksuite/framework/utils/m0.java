package com.larksuite.framework.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.file.direct.DirectFileAccess;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.model.VideoRef;
import java.io.File;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Deprecated(message = "consider using InputStream and FD")
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f286043a = null;

    static {
        f286043a = CollectionsKt.listOf(new String[]{"content://downloads/public_downloads", "content://downloads/my_downloads", "content://downloads/all_downloads"});
    }

    public static boolean e(PolarisFileWrapper r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.exists() == false) goto L8;
        if (r100.canRead() == false) goto L8;
        return true;
    }

    public static PolarisFileWrapper d(String r100, boolean r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r101 == true) goto L9;
        return r102;
    L9:
        if (e(r102) == true) goto L11;
        return null;
    L11:
        return r102;
    }

    @Deprecated(message = "use InputStream or FD instead")
    @JvmStatic
    public static final PolarisFileWrapper b(Context r210, Uri r211, boolean r212) {
        PolarisFileWrapper r100 = null;
        if (r210 != null) goto L6;
        Log.e("UriCompatUtil", "context is null");
        return null;
    L6:
        if (r211 != null) goto L10;
        Log.e("UriCompatUtil", "uri is null");
        return null;
    L10:
        if (DocumentsContract.isDocumentUri(r210, r211) == false) goto L137;
        String r101 = r211.getAuthority();
        if (r101 == null) goto L137;
        int r102 = r101.hashCode();
        if (r102 == 320699453) goto L79;
        if (r102 == 596745902) goto L49;
        if (r102 != 1734583286) goto L137;
        if (r101.equals("com.android.providers.media.documents") == false) goto L137;
        String r110 = DocumentsContract.getDocumentId(r211);
        Intrinsics.checkNotNull(r110);
        List r103 = StringsKt.split$default(r110, new String[]{":"}, false, 0, 6, null);
        String r104 = (String) ListProtector.get(r103, 0);
        int r105 = r104.hashCode();
        if (r105 == 93166550) goto L40;
        if (r105 == 100313435) goto L36;
        if (r105 != 112202875) goto L42;
        if (r104.equals("video") == false) goto L42;
        Uri r106 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    L47:
        PolarisFileWrapper r107 = d(c(r210, r106, "_id=?", new String[]{(String) ListProtector.get(r103, 1)}), r212);
    L138:
        if (r107 == null) goto L140;
        return r107;
    L140:
        if (StringsKt.equals("content", r211.getScheme(), true) == true) goto L143;
    L163:
        PolarisFileWrapper r108 = null;
    L165:
        if (r108 == null) goto L167;
        return r108;
    L167:
        if (StringsKt.equals("file", r211.getScheme(), true) == false) goto L171;
        r100 = d(r211.getPath(), r212);
    L171:
        return r100;
    L143:
        if (Intrinsics.areEqual("com.google.android.apps.photos.content", r211.getAuthority()) == false) goto L145;
        r108 = d(r211.getLastPathSegment(), r212);
        goto L165
    L145:
        r108 = d(c(r210, r211, null, null), r212);
        if (r108 != null) goto L165;
        if (Intrinsics.areEqual(r210.getPackageName() + ".common.fileprovider", r211.getAuthority()) == false) goto L159;
        String r109 = StringsKt.removePrefix(String.valueOf(r211.getPath()), File.separator);
        if (StringsKt.startsWith$default(r109, "android_files", false, 2, null) == false) goto L156;
        String r111 = StringsKt.removePrefix(r109, "android_files");
        File r112 = DirectFileAccess.c(new DirectFileAccess.a(null, DirectFileAccess.StorageLocation.EXTERNAL, null, r210, VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS));
        if (r112 == null) goto L163;
        r108 = d(r112.getAbsolutePath() + r111, r212);
        goto L165
    L156:
        if (StringsKt.startsWith$default(r109, "external_files", false, 2, null) == false) goto L163;
        r108 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), StringsKt.removePrefix(r109, "external_files"));
        goto L165
    L159:
        if (Intrinsics.areEqual("com.android.fileexplorer.myprovider", r211.getAuthority()) == false) goto L163;
        String r113 = r211.getPath();
        if (r113 == null) goto L163;
        r108 = d(l.d(r210) + File.separator + r113, r212);
    L42:
        if (Build.VERSION.SDK_INT < 29) goto L44;
        r106 = MediaStore.Files.getContentUri("external");
    L45:
        Intrinsics.checkNotNull(r106);
        goto L47
    L44:
        r106 = MediaStore.Files.getContentUri("external");
        goto L45
    L36:
        if (r104.equals("image") == false) goto L42;
        r106 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        goto L47
    L40:
        if (r104.equals("audio") == false) goto L42;
        r106 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        goto L47
    L49:
        if (r101.equals("com.android.externalstorage.documents") == false) goto L137;
        String r114 = DocumentsContract.getDocumentId(r211);
        Intrinsics.checkNotNull(r114);
        List r115 = StringsKt.split$default(r114, new String[]{":"}, false, 0, 6, null);
        if (r115.size() <= 1) goto L137;
        String r116 = (String) ListProtector.get(r115, 0);
        String r117 = (String) ListProtector.get(r115, 1);
        if (StringsKt.equals(r116, "primary", true) == false) goto L57;
        PolarisFileWrapper r118 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), r117);
    L61:
        if (e(r118) == false) goto L63;
    L62:
        r107 = r118;
        goto L138
    L63:
        r118 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), r117);
        if (e(r118) == true) goto L62;
        if (r115.size() <= 2) goto L72;
        PolarisFileWrapper r119 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), r114.substring(StringsKt.indexOf$default(r114, ':', 0, false, 6, null) + 1));
        if (e(r119) == false) goto L72;
        Log.w("UriCompatUtil", "Illegal File Name Found");
    L71:
        r107 = r119;
    L72:
        Iterator r120 = CollectionsKt.listOf(new String[]{"SECONDARY_STORAGE", "EXTERNAL_STORAGE"}).iterator();
    L74:
        if (r120.hasNext() == false) goto L137;
        r119 = new PolarisFileWrapper((String) r120.next(), r117);
        if (e(r119) == false) goto L74;
    L57:
        if (StringsKt.equals(r116, "home", true) == false) goto L59;
        r118 = new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), r117);
        goto L61
    L59:
        r118 = null;
        goto L61
    L79:
        if (r101.equals("com.android.providers.downloads.documents") == false) goto L137;
        String r121 = DocumentsContract.getDocumentId(r211);
        BitSet r122 = f0.f285960a;
        if (r121 != null) goto L84;
    L93:
        boolean r123 = false;
    L94:
        if (r123 == false) goto L129;
        Intrinsics.checkNotNull(r121);
        long r124 = CastLongProtector.parseLong(r121);
        Cursor r125 = a(r210.getContentResolver(), r211, null, null, null);     // Catch: Exception -> L114
        Cursor r126 = r125;     // Catch: Throwable -> L107
        if (r126 != null) goto L100;
    L104:
        Unit r127 = Unit.INSTANCE;     // Catch: Throwable -> L107
        CloseableKt.closeFinally(r125, null);     // Catch: Exception -> L114
        goto L115
    L100:
        if (r126.moveToFirst() == false) goto L104;
        String r128 = r126.getString(r126.getColumnIndexOrThrow("_display_name"));     // Catch: Throwable -> L107
        CloseableKt.closeFinally(r125, null);     // Catch: Exception -> L114
    L116:
        if (r128 == null) goto L120;
        r107 = d(Uri.withAppendedPath(UriProtector.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()), r128).toString(), r212);
        if (e(r107) == false) goto L120;
    L121:
        if (r107 != null) goto L138;
        Iterator<T> r129 = f286043a.iterator();
    L125:
        if (r129.hasNext() == false) goto L137;
        PolarisFileWrapper r130 = d(c(r210, ContentUris.withAppendedId(UriProtector.parse((String) r129.next()), r124), null, null), r212);
        if (r130 == null) goto L125;
        r107 = r130;
    L120:
        r107 = null;
    L107:
        th = move-exception;
        throw th;     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        CloseableKt.closeFinally(r125, th);     // Catch: Exception -> L114
        throw th;     // Catch: Exception -> L114
    L115:
        r128 = null;
        goto L116
    L129:
        Intrinsics.checkNotNull(r121);
        if (StringsKt.startsWith$default(r121, "raw:", false, 2, null) == false) goto L133;
        r107 = d(StringsKt.replaceFirst$default(r121, "raw:", "", false, 4, null), r212);
        goto L138
    L133:
        if (StringsKt.startsWith$default(r121, "msf:", false, 2, null) == false) goto L137;
        if (Build.VERSION.SDK_INT < 29) goto L137;
        r107 = d(c(r210, MediaStore.Downloads.EXTERNAL_CONTENT_URI, "_id=?", new String[]{((String[]) StringsKt.split$default(r121, new String[]{":"}, false, 0, 6, null).toArray(new String[0]))[1]}), r212);
        goto L138
    L84:
        if (r121.length() == 0) goto L93;
        int r131 = r121.length();
        int r132 = 0;
    L87:
        if (r132 >= r131) goto L92;
        if (Character.isDigit(r121.codePointAt(r132)) == false) goto L93;
        r132 = r132 + 1;
        goto L87
    L92:
        r123 = true;
    L137:
        r107 = null;
        goto L138
    }

    public static String c(Context r100, Uri r101, String r102, String[] r103) {
        Cursor r104 = a(r100.getContentResolver(), r101, new String[]{"_data"}, r102, r103);     // Catch: RuntimeException -> L19 UnsupportedOperationException -> L29 SecurityException -> L31 IllegalArgumentException -> L37
        Cursor r105 = r104;     // Catch: Throwable -> L14
        if (r105 != null) goto L7;
    L11:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r104, null);     // Catch: RuntimeException -> L19 UnsupportedOperationException -> L29 SecurityException -> L31 IllegalArgumentException -> L37
    L39:
        return null;
    L7:
        if (r105.moveToFirst() == false) goto L11;
        String r107 = r105.getString(r105.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r104, null);     // Catch: RuntimeException -> L19 UnsupportedOperationException -> L29 SecurityException -> L31 IllegalArgumentException -> L37
        return r107;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: RuntimeException -> L19 UnsupportedOperationException -> L29 SecurityException -> L31 IllegalArgumentException -> L37
        throw th;     // Catch: RuntimeException -> L19 UnsupportedOperationException -> L29 SecurityException -> L31 IllegalArgumentException -> L37
    L37:
        e = move-exception;
        Log.e("UriCompatUtil", e);
    L31:
        Log.w("UriCompatUtil", "SecurityException for uri: " + r101);
        String r108 = r101.getPath();
        if (r108 != null) goto L35;
        return null;
    L35:
        if (StringsKt.startsWith$default(r108, "/storage/emulated/0", false, 2, null) == false) goto L39;
        return r108;
    L29:
        Log.w("UriCompatUtil", "UnsupportedOperationException for uri: " + r101);
        return null;
    L19:
        e = move-exception;
        StringBuilder r109 = new StringBuilder("getDataColumn failed by provider cursor runtime exception, ");
        StringBuilder r110 = new StringBuilder("scheme=");
        String r111 = r101.getScheme();
        String r112 = "";
        if (r111 != null) goto L23;
        r111 = "";
    L23:
        r110.append(r111);
        r110.append(", authority=");
        String r113 = r101.getAuthority();
        if (r113 == null) goto L27;
        r112 = r113;
    L27:
        r110.append(r112);
        r109.append(r110.toString());
        Log.e("UriCompatUtil", r109.toString(), e);
        return null;
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }
}
