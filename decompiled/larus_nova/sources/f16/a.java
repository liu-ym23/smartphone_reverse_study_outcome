package f16;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f06.c;
import f06.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f475058a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f475059b = null;

    static {
        f475058a = new String[]{DBDefinition.ID, "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", LynxEventReporter.PROP_NAME_RELATIVE_PATH, "_data", "datetaken", "orientation"};
        f475059b = new String[]{DBDefinition.ID, "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", "_data", "datetaken", "orientation"};
    }

    public static Bundle c() {
        Bundle r100 = new Bundle();
        if (Build.VERSION.SDK_INT < 29) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100.putString("android:query-arg-sql-selection", null);
        r100.putStringArray("android:query-arg-sql-selection-args", null);
        r100.putString("android:query-arg-sql-sort-order", "_id DESC");
    L8:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public static List d(Context r210) {
        ArrayList r100 = new ArrayList();
        Uri r101 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor r102 = null;
        int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L59
        if (r103 < 30) goto L7;
        boolean r104 = true;
    L8:
        String[] r105 = f475058a;
        if (r104 == false) goto L11;
        r102 = a(r210.getContentResolver(), r101, r105, c());     // Catch: Throwable -> L59
    L17:
        if (r102 != null) goto L21;
        if (r102 == null) goto L20;
        r102.close();
    L20:
        return r100;
    L21:
        int r106 = r102.getColumnIndexOrThrow(DBDefinition.ID);     // Catch: Throwable -> L59
        int r107 = r102.getColumnIndexOrThrow("_display_name");     // Catch: Throwable -> L59
        int r110 = r102.getColumnIndexOrThrow("date_modified");     // Catch: Throwable -> L59
        int r108 = r102.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L59
        int r111 = r102.getColumnIndexOrThrow("mime_type");     // Catch: Throwable -> L59
        int r112 = r102.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L59
        int r113 = r102.getColumnIndexOrThrow("width");     // Catch: Throwable -> L59
        int r114 = r102.getColumnIndexOrThrow("height");     // Catch: Throwable -> L59
        int r115 = r102.getColumnIndexOrThrow("datetaken");     // Catch: Throwable -> L59
        int r109 = r102.getColumnIndexOrThrow("orientation");     // Catch: Throwable -> L59
        if (r103 < 29) goto L24;
        boolean r116 = true;
    L25:
        if (r116 == false) goto L27;
        int r117 = r102.getColumnIndexOrThrow(LynxEventReporter.PROP_NAME_RELATIVE_PATH);     // Catch: Throwable -> L59
    L28:
        int r118 = r102.getColumnIndexOrThrow("_data");     // Catch: Throwable -> L59
        StringBuilder r119 = new StringBuilder();     // Catch: Throwable -> L59
        ArrayList r120 = r100;
        r119.append(Environment.getExternalStorageDirectory().getPath());     // Catch: Throwable -> L59
        r119.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L59
        int r121 = r119.toString().length();     // Catch: Throwable -> L59
    L29:
        if (r102.moveToNext() == false) goto L57;
        b r122 = new b();     // Catch: Throwable -> L59
        int r211 = r121;
        Uri r123 = r101;
        long r124 = r102.getLong(r106);     // Catch: Throwable -> L59
        r122.f475060a = r124;     // Catch: Throwable -> L59
        int r125 = r106;
        r122.f475061b = r102.getString(r107);     // Catch: Throwable -> L59
        r122.f475062c = r102.getLong(r110);     // Catch: Throwable -> L59
        r122.f475063d = r102.getLong(r108);     // Catch: Throwable -> L59
        r122.f475064e = r102.getString(r111);     // Catch: Throwable -> L59
        r122.f475065f = r102.getLong(r112);     // Catch: Throwable -> L59
        r122.f475066g = r102.getInt(r113);     // Catch: Throwable -> L59
        r122.f475067h = r102.getInt(r114);     // Catch: Throwable -> L59
        r122.f475070k = r102.getLong(r115);     // Catch: Throwable -> L59
        r122.f475071l = r102.getInt(r109);     // Catch: Throwable -> L59
        if (Build.VERSION.SDK_INT < 29) goto L35;
        boolean r126 = true;
    L37:
        if (r126 == false) goto L51;
        String r127 = r102.getString(r117);     // Catch: Throwable -> L59
        if (r127 != null) goto L48;
        String r128 = r102.getString(r118);     // Catch: Throwable -> L59
        String r129 = File.separator;     // Catch: Throwable -> L59
        int r212 = r117;
        int r130 = r128.lastIndexOf(r129);     // Catch: Throwable -> L59
        int r213 = r109;
        StringBuilder r131 = new StringBuilder();     // Catch: IndexOutOfBoundsException -> L46 Throwable -> L59
        int r214 = r107;
        int r132 = r211;
        r131.append(r128.substring(r132, r130));     // Catch: IndexOutOfBoundsException -> L63 Throwable -> L59
        r131.append(r129);     // Catch: IndexOutOfBoundsException -> L63 Throwable -> L59
        String r133 = r131.toString();     // Catch: IndexOutOfBoundsException -> L63 Throwable -> L59
    L50:
        r122.f475069j = r133;     // Catch: Throwable -> L59
    L55:
        r122.f475068i = ContentUris.withAppendedId(r123, r124);     // Catch: Throwable -> L59
        ArrayList r134 = r120;
        r134.add(r122);     // Catch: Throwable -> L59
        r120 = r134;
        r106 = r125;
        r117 = r212;
        r109 = r213;
        r101 = r123;
        r121 = r132;
        r107 = r214;
    L47:
        r122.f475069j = "";     // Catch: Throwable -> L59
    L49:
        r133 = r127;
    L46:
        r214 = r107;
        r132 = r211;
        goto L47
    L48:
        r212 = r117;
        r213 = r109;
        r214 = r107;
        r132 = r211;
        goto L49
    L51:
        r212 = r117;
        r213 = r109;
        r214 = r107;
        r132 = r211;
        String r135 = r102.getString(r118);     // Catch: Throwable -> L59
        String r136 = File.separator;     // Catch: Throwable -> L59
        r122.f475069j = r135.substring(r132, r135.lastIndexOf(r136)) + r136;     // Catch: IndexOutOfBoundsException -> L54 Throwable -> L59
    L54:
        r122.f475069j = "";     // Catch: Throwable -> L59
        goto L55
    L35:
        r126 = false;
        goto L37
    L57:
        ArrayList r137 = r120;
        r102.close();
        return r137;
    L27:
        r117 = 0;
        goto L28
    L24:
        r116 = false;
        goto L25
    L11:
        if (r103 < 29) goto L13;
        boolean r138 = true;
    L14:
        if (r138 == false) goto L16;
        r102 = b(r210.getContentResolver(), r101, r105, "date_added");     // Catch: Throwable -> L59
        goto L17
    L16:
        r102 = b(r210.getContentResolver(), r101, f475059b, "date_added");     // Catch: Throwable -> L59
        goto L17
    L13:
        r138 = false;
        goto L14
    L7:
        r104 = false;
    L59:
        th = move-exception;
        if (r102 == null) goto L62;
        r102.close();
    L62:
        throw th;
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, Bundle r113) {
        c r114 = new c();
        Object[] r115 = {r111, r112, r113, null};
        f06.b r116 = new f06.b();
        d r100 = r114.b(240004, "android/content/ContentResolver", "query", r110, r115, "android.database.Cursor", r116);
        if (r100.f474982a == false) goto L6;
        r114.a(240004, "android/content/ContentResolver", "query", r110, r115, null, r116, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, r112, r113, null);
        r114.a(240004, "android/content/ContentResolver", "query", r110, r115, r101, r116, true);
        return r101;
    }

    public static Cursor b(ContentResolver r110, Uri r111, String[] r112, String r113) {
        c r100 = new c();
        Object[] r101 = {r111, r112, null, null, r113};
        f06.b r114 = new f06.b();
        d r115 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r114);
        if (r115.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r114, false);
        return (Cursor) r115.f474983b;
    L6:
        Cursor r116 = r110.query(r111, r112, null, null, r113);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r116, r114, true);
        return r116;
    }
}
