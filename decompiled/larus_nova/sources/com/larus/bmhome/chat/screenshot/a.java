package com.larus.bmhome.chat.screenshot;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.socialbase.downloader.constants.DBDefinition;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f308579a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f308580b = null;

    static {
        f308579a = new String[]{DBDefinition.ID, "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", LynxEventReporter.PROP_NAME_RELATIVE_PATH, "_data"};
        f308580b = new String[]{DBDefinition.ID, "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", "_data"};
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

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, Bundle r113) {
        f06.c r114 = new f06.c();
        Object[] r115 = {r111, r112, r113, null};
        f06.b r116 = new f06.b();
        f06.d r100 = r114.b(240004, "android/content/ContentResolver", "query", r110, r115, "android.database.Cursor", r116);
        if (r100.f474982a == false) goto L6;
        r114.a(240004, "android/content/ContentResolver", "query", r110, r115, null, r116, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, r112, r113, null);
        r114.a(240004, "android/content/ContentResolver", "query", r110, r115, r101, r116, true);
        return r101;
    }

    public static Cursor b(ContentResolver r110, Uri r111, String[] r112, String r113) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, r113};
        f06.b r114 = new f06.b();
        f06.d r115 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r114);
        if (r115.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r114, false);
        return (Cursor) r115.f474983b;
    L6:
        Cursor r116 = r110.query(r111, r112, null, null, r113);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r116, r114, true);
        return r116;
    }
}
