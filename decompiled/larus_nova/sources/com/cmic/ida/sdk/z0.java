package com.cmic.ida.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes22.dex */
public class z0 extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273270a;

    @Override // com.cmic.ida.sdk.z
    public String a() {
        Uri r100 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        ContentResolver r101 = this.f273270a.getContentResolver();
        String r102 = "";
        if (r101 != null) goto L5;
        return "";
    L5:
        Cursor r103 = com_cmic_ida_sdk_z0_android_content_ContentResolver_query(r101, r100, null, null, null, null);
        if (r103 == null) goto L11;
        r103.moveToNext();
        int r104 = r103.getColumnIndex("value");
        if (r104 < 0) goto L10;
        r102 = r103.getString(r104);
    L10:
        r103.close();
    L11:
        return r102;
    }

    public z0(Context r100) {
        this.f273270a = r100;
    }

    private static Cursor com_cmic_ida_sdk_z0_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
