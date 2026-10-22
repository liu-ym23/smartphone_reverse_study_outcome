package com.cmic.ida.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes22.dex */
public class w extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273260a;

    @Override // com.cmic.ida.sdk.z
    public String a() {
        Uri r100 = Uri.parse("content://com.meizu.flyme.openidsdk/");     // Catch: Throwable -> L12
        Cursor r101 = com_cmic_ida_sdk_w_android_content_ContentResolver_query(this.f273260a.getContentResolver(), r100, null, null, new String[]{"oaid"}, null);     // Catch: Throwable -> L12
        if (r101 == null) goto L15;
        r101.moveToFirst();     // Catch: Throwable -> L12
        int r102 = r101.getColumnIndex("value");     // Catch: Throwable -> L12
        if (r102 < 0) goto L8;
        String r103 = r101.getString(r102);     // Catch: Throwable -> L12
    L9:
        r101.close();     // Catch: Throwable -> L12
        return r103;
    L8:
        r103 = "";
        goto L9
    L15:
        return "";
    L16:
        return "";
    }

    public w(Context r100) {
        this.f273260a = r100;
    }

    private static Cursor com_cmic_ida_sdk_w_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
