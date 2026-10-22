package vqc;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static void b(String r110, String r111) throws IOException {
        if (r110.equalsIgnoreCase(r111) == false) goto L5;
        return;
    L5:
        FileChannel r100 = null;
        FileChannel r112 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r110)).getChannel();     // Catch: Throwable -> L14
        r100 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r111)).getChannel();     // Catch: Throwable -> L12
        r112.transferTo(0, r112.size(), r100);     // Catch: Throwable -> L12
        r112.close();     // Catch: Throwable -> L12
        r112.close();
        if (r100 == null) goto L25;
        r100.close();
        return;
    L25:
        return;
    L12:
        th = th;
        FileChannel r101 = r100;
        r100 = r112;
        FileChannel r113 = r101;
    L16:
        if (r100 == null) goto L18;
        r100.close();
    L18:
        if (r113 == null) goto L20;
        r113.close();
    L20:
        throw th;
    L14:
        th = th;
        r113 = null;
        goto L16
    }

    public static String d(Context r100, Uri r101) {
        Uri r102 = null;
        if (DocumentsContract.isDocumentUri(r100, r101) == false) goto L33;
        if ("com.android.externalstorage.documents".equals(r101.getAuthority()) == false) goto L11;
        String[] r103 = DocumentsContract.getDocumentId(r101).split(":");
        if ("primary".equalsIgnoreCase(r103[0]) == true) goto L9;
    L44:
        return null;
    L9:
        return Environment.getExternalStorageDirectory() + HTTP.URL_DEFAULT + r103[1];
    L11:
        if ("com.android.providers.downloads.documents".equals(r101.getAuthority()) == false) goto L20;
        String r104 = DocumentsContract.getDocumentId(r101);
        if (TextUtils.isEmpty(r104) == true) goto L44;
        return c(r100, ContentUris.withAppendedId(UriProtector.parse("content://downloads/public_downloads"), CastLongProtector.valueOf(r104).longValue()), null, null);
    L16:
        e = move-exception;
        e.getMessage();
        return null;
    L20:
        if ("com.android.providers.media.documents".equals(r101.getAuthority()) == false) goto L44;
        String[] r105 = DocumentsContract.getDocumentId(r101).split(":");
        String r106 = r105[0];
        if ("image".equals(r106) == false) goto L25;
        r102 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L31:
        return c(r100, r102, "_id=?", new String[]{r105[1]});
    L25:
        if ("video".equals(r106) == false) goto L28;
        r102 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L31
    L28:
        if ("audio".equals(r106) == false) goto L31;
        r102 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        goto L31
    L33:
        if ("content".equalsIgnoreCase(r101.getScheme()) == false) goto L41;
        if ("com.google.android.apps.photos.content".equals(r101.getAuthority()) == false) goto L39;
        return r101.getLastPathSegment();
    L39:
        return c(r100, r101, null, null);
    L41:
        if ("file".equalsIgnoreCase(r101.getScheme()) == false) goto L44;
        return r101.getPath();
    }

    public static String c(Context r100, Uri r101, String r102, String[] r103) {
        Cursor r104 = null;
        Cursor r105 = a(r100.getContentResolver(), r101, new String[]{"_data"}, r102, r103);     // Catch: Throwable -> L14 IllegalArgumentException -> L16
        if (r105 != null) goto L27;
    L12:
        if (r105 != null) goto L20;
    L21:
        return null;
    L20:
        r105.close();
        goto L21
    L27:
    L10:
        IllegalArgumentException e100 = e;
    L18:
        String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", new Object[]{e100.getMessage()});     // Catch: Throwable -> L22
        if (r105 == null) goto L21;
    L22:
        th = move-exception;
        r104 = r105;
        th = th;
    L24:
        if (r104 == null) goto L26;
        r104.close();
    L26:
        throw th;
    L6:
        if (r105.moveToFirst() == false) goto L12;
        String r106 = r105.getString(r105.getColumnIndexOrThrow("_data"));     // Catch: IllegalArgumentException -> L10 Throwable -> L22
        r105.close();
        return r106;
    L16:
        e = move-exception;
        e100 = e;
        r105 = null;
    L14:
        th = th;
        goto L24
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
