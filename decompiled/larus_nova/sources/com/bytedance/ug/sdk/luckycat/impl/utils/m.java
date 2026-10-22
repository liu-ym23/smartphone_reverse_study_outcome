package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f271521a = null;

    static {
        f271521a = Environment.DIRECTORY_DCIM;
    }

    public static void b(Uri r210, ContentResolver r211) {
        ContentValues r100 = new ContentValues();
        r100.put("is_pending", 0);
        ArrayList r101 = new ArrayList();
        Object[] r102 = {r210, r100, null, null};
        f06.b r110 = new f06.b();
        g06.a r103 = ApiHookConfig.f245611b.get(240018);
        if (r103 == null) goto L5;
        f06.a[] r104 = r103.f479473i;
    L6:
        f06.a[] r111 = r104;
        int r112 = r111.length;
        int r113 = 0;
    L8:
        if (r113 >= r112) goto L15;
        f06.a r105 = r111[r113];
        int r114 = r113;
        int r115 = r112;
        f06.a[] r212 = r111;
        f06.d r106 = r105.preInvoke(240018, "android/content/ContentResolver", "update", r211, r102, "int", r110);     // Catch: Exception -> L21
        if (r106.f474982a == true) goto L17;
        r101.add(r105);     // Catch: Exception -> L21
    L17:
        if (r106.f474982a == false) goto L19;
        ((Integer) r106.f474983b).intValue();
        return;
    L19:
        r211.update(r210, r100, null, null);
        return;
    L14:
        r113 = r114 + 1;
        r112 = r115;
        r111 = r212;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r104 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Uri c(ContentResolver r210, String r211) {
        ContentValues r100 = new ContentValues();
        r100.put("mime_type", "image/jpeg");
        long r101 = System.currentTimeMillis() / ((long) 1000);
        r100.put("date_added", Long.valueOf(r101));
        r100.put("date_modified", Long.valueOf(r101));
        String r102 = f271521a + "/Camera";
        r100.put("_display_name", r211);
        r100.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r102);
        r100.put("is_pending", 1);
        Uri r110 = MediaStore.Images.Media.getContentUri("external_primary");
        if (r210 == null) goto L24;
        ArrayList r111 = new ArrayList();
        Object[] r112 = {r110, r100};
        f06.b r113 = new f06.b();
        g06.a r103 = ApiHookConfig.f245611b.get(240017);
        if (r103 == null) goto L7;
        f06.a[] r104 = r103.f479473i;
    L8:
        f06.a[] r105 = r104;
        int r106 = r105.length;
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L17;
        f06.a r108 = r105[r107];
        int r114 = r107;
        int r212 = r106;
        f06.a[] r213 = r105;
        f06.d r109 = r108.preInvoke(240017, "android/content/ContentResolver", "insert", r210, r112, "android.net.Uri", r113);     // Catch: Exception -> L25
        if (r109.f474982a == true) goto L19;
        r111.add(r108);     // Catch: Exception -> L25
    L19:
        if (r109.f474982a == false) goto L21;
        Uri r115 = (Uri) r109.f474983b;
    L31:
        return r115;
    L21:
        r115 = r210.insert(r110, r100);
    L16:
        r107 = r114 + 1;
        r106 = r212;
        r105 = r213;
        goto L10
    L17:
        r109 = new f06.d(false, null);
        goto L19
    L7:
        r104 = ApiHookConfig.f245613d;
        goto L8
    L24:
        return null;
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

    public static Uri d(Context r100, String r101, byte[] r102) {
        int r103 = Build.VERSION.SDK_INT;
        Uri r104 = null;
        if (r103 >= 29) goto L6;
        a.c("MediaStoreUtils", "saveToAlbum, android版本低于10， " + r103);
        return null;
    L6:
        if (r100 != null) goto L23;
        ContentResolver r105 = null;
    L11:
        Uri r106 = c(r105, r101);     // Catch: Exception -> L8
        if (r106 == null) goto L20;
        if (r105 == null) goto L27;
        OutputStream r107 = ContentResolverWrapper.openOutputStream(r105, r106);     // Catch: Exception -> L18
        if (r107 == null) goto L28;
        r107.write(r102);     // Catch: Exception -> L18
        r107.flush();     // Catch: Exception -> L18
        r107.close();     // Catch: Exception -> L18
        b(r106, r105);     // Catch: Exception -> L18
        return r106;
    L28:
        return r106;
    L18:
        e = e;
        r104 = r106;
    L21:
        e.printStackTrace();
        return r104;
    L27:
        return r106;
    L20:
        return null;
    L8:
        e = e;
        goto L21
    L23:
        r105 = r100.getContentResolver();     // Catch: Exception -> L8
        goto L11
    }
}
