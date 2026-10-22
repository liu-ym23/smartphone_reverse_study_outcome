package com.bytedance.crypto.obfuscated;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes15.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile j f204263a;

    public j() {
    }

    public static j a() {
        if (f204263a != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f204263a != null) goto L9;
        f204263a = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f204263a;
    }

    public a a(Context r100, i r101, Bundle r110) {
        l r102 = l.a(r100);
        r102.getClass();
        if (TextUtils.isEmpty(r101.f204250a) == true) goto L46;
        i r111 = r102.f204266a.a(r101.f204250a, r102.f204267b.getPackageName());
        if (r111 != null) goto L8;
    L11:
        boolean r112 = false;
    L12:
        if (r112 == false) goto L16;
        a r103 = new a(-7, r101.f204250a);
    L47:
        return r103;
    L16:
        if (TextUtils.isEmpty(r101.f204255f) == true) goto L18;
    L22:
        i r113 = l.a(r101);
        String r104 = System.currentTimeMillis() + "";
        r113.f204261l = r104;
        r113.f204262m = r104;
        if (TextUtils.isEmpty(r113.f204255f) == true) goto L32;
        if (r113.f204255f.length() > 4096) goto L49;
        byte[] r105 = m.a(r102.f204267b, p.a(r102.f204267b, "secret_enc_key"), 1, r113.f204255f.getBytes());
        if (r105.length != 0) goto L30;
        r103 = new a(-4, r113.f204250a);
        goto L47
    L30:
        r113.f204255f = o.a(r105);
        goto L32
    L49:
        return new a(-2, r101.f204250a);
    L32:
        if (TextUtils.isEmpty(r113.f204254e) == true) goto L41;
        Context r106 = r102.f204267b;
        SecretKeySpec r107 = p.f204270a;
        if (r107 != null) goto L37;
        r107 = p.a(r106, "private_enc_key");
        p.f204270a = r107;
    L37:
        byte[] r108 = m.a(r102.f204267b, r107, 1, r113.f204254e.getBytes());
        if (r108.length != 0) goto L40;
        r103 = new a(-4, r113.f204250a);
        goto L47
    L40:
        r113.f204254e = o.a(r108);
    L41:
        k r109 = r102.f204266a;
        String r114 = r102.f204267b.getPackageName();
        r109.getClass();
        SQLiteDatabase r115 = r109.getWritableDatabase();
        ContentValues r116 = new ContentValues();
        r116.put("alias", r113.f204250a);
        r116.put("pkg_name", r114);
        r116.put("public_data", r113.f204253d);
        r116.put("private_data", r113.f204254e);
        r116.put("secret_data", r113.f204255f);
        r116.put("data_type", r113.f204251b);
        r116.put("associate", r113.f204252c);
        r116.put("access_limit", "");
        r116.put("auth_limit", "");
        r116.put("sync_limit", 0);
        r116.put("search_info", r113.f204257h);
        r116.put("ext_info", r113.f204256g);
        r116.put("create_time", r113.f204261l);
        r116.put("latest_time", r113.f204262m);
        r116.put("global_id", "");
        r116.put("status", 0);
        r116.put("sync_status", 0);
        if (r115.insert("secret_item", null, r116) >= 0) goto L45;
        return new a(-6, "insert data fail");
    L45:
        return new a(0, r113.f204250a);
    L18:
        if (TextUtils.isEmpty(r101.f204254e) == false) goto L22;
        if (TextUtils.isEmpty(r101.f204253d) == false) goto L22;
        return new a(-2, r101.f204250a);
    L8:
        if (TextUtils.isEmpty(r111.f204250a) == true) goto L11;
        r112 = true;
        goto L12
    L46:
        return new a(-2, "");
    }

    public h a(Context r100, String r101, Bundle r102) {
        l r103 = l.a(r100);
        r103.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L37;
        int r104 = r102.getInt("query_mode", 2);
        if (r104 != 2) goto L27;
        i r105 = r103.f204266a.a(r101, r103.f204267b.getPackageName());
        if (r105 != null) goto L11;
        return new h(-5, new ArrayList());
    L11:
        if (TextUtils.isEmpty(r105.f204255f) == true) goto L17;
        SecretKeySpec r106 = p.a(r103.f204267b, "secret_enc_key");
        byte[] r107 = o.a(r105.f204255f);
        byte[] r108 = m.a(r103.f204267b, r106, 2, r107);
        if (r108.length == 0) goto L39;
        r105.f204255f = new String(r108);
        goto L17
    L39:
        return new h(-4, new ArrayList());
    L17:
        if (TextUtils.isEmpty(r105.f204254e) == true) goto L26;
        Context r109 = r103.f204267b;
        SecretKeySpec r110 = p.f204270a;
        if (r110 != null) goto L22;
        r110 = p.a(r109, "private_enc_key");
        p.f204270a = r110;
    L22:
        byte[] r111 = o.a(r105.f204254e);
        byte[] r112 = m.a(r103.f204267b, r110, 2, r111);
        if (r112.length == 0) goto L40;
        r105.f204254e = new String(r112);
        goto L26
    L40:
        return new h(-4, new ArrayList());
    L26:
        ArrayList r113 = new ArrayList();
        r113.add(r105);
        return new h(0, r113);
    L27:
        if (r104 != 0) goto L29;
    L32:
        i r114 = r103.f204266a.a(r101, r103.f204267b.getPackageName());
        if (r114 == null) goto L43;
        ArrayList r115 = new ArrayList();
        r115.add(r114);
        return new h(0, r115);
    L43:
        return new h(-5, new ArrayList());
    L29:
        if (r104 == 1) goto L32;
        return new h(-100, new ArrayList());
    L37:
        return new h(-2, new ArrayList());
    }

    public int b(Context r100, i r101, Bundle r102) {
        l r103 = l.a(r100);
        r103.getClass();
        if (TextUtils.isEmpty(r101.f204250a) == false) goto L6;
        return -2;
    L6:
        if (TextUtils.isEmpty(r101.f204255f) == true) goto L8;
    L20:
        i r104 = l.a(r101);
        String r105 = r104.f204250a;
        r104.f204262m = System.currentTimeMillis() + "";
        if (TextUtils.isEmpty(r104.f204255f) == true) goto L30;
        if (r104.f204255f.length() > 4096) goto L72;
        byte[] r106 = m.a(r103.f204267b, p.a(r103.f204267b, "secret_enc_key"), 1, r104.f204255f.getBytes());
        if (r106.length == 0) goto L68;
        r104.f204255f = o.a(r106);
    L68:
        return -4;
    L72:
        return -2;
    L30:
        if (TextUtils.isEmpty(r104.f204254e) == true) goto L39;
        Context r107 = r103.f204267b;
        SecretKeySpec r108 = p.f204270a;
        if (r108 != null) goto L35;
        r108 = p.a(r107, "private_enc_key");
        p.f204270a = r108;
    L35:
        byte[] r109 = m.a(r103.f204267b, r108, 1, r104.f204254e.getBytes());
        if (r109.length == 0) goto L68;
        r104.f204254e = o.a(r109);
    L39:
        k r110 = r103.f204266a;
        String r111 = r103.f204267b.getPackageName();
        r110.getClass();
        SQLiteDatabase r112 = r110.getWritableDatabase();
        ContentValues r113 = new ContentValues();
        if (TextUtils.isEmpty(r104.f204253d) == true) goto L43;
        r113.put("public_data", r104.f204253d);
    L43:
        if (TextUtils.isEmpty(r104.f204254e) == true) goto L46;
        r113.put("private_data", r104.f204254e);
    L46:
        if (TextUtils.isEmpty(r104.f204255f) == true) goto L49;
        r113.put("secret_data", r104.f204255f);
    L49:
        if (TextUtils.isEmpty(r104.f204251b) == true) goto L52;
        r113.put("data_type", r104.f204251b);
    L52:
        if (TextUtils.isEmpty(r104.f204252c) == true) goto L55;
        r113.put("associate", r104.f204252c);
    L55:
        if (TextUtils.isEmpty(r104.f204256g) == true) goto L58;
        r113.put("ext_info", r104.f204256g);
    L58:
        if (TextUtils.isEmpty(r104.f204257h) == true) goto L61;
        r113.put("search_info", r104.f204257h);
    L61:
        if (TextUtils.isEmpty(r104.f204262m) == true) goto L64;
        r113.put("latest_time", r104.f204262m);
    L64:
        if (r112.update("secret_item", r113, "alias =? AND pkg_name =? ", new String[]{r104.f204250a, r111}) != 1) goto L69;
        return 0;
    L69:
        return -6;
    L8:
        if (TextUtils.isEmpty(r101.f204254e) == false) goto L20;
        if (TextUtils.isEmpty(r101.f204253d) == false) goto L20;
        if (TextUtils.isEmpty(r101.f204256g) == false) goto L20;
        if (TextUtils.isEmpty(r101.f204257h) == false) goto L20;
        if (TextUtils.isEmpty(r101.f204251b) == false) goto L20;
        if (TextUtils.isEmpty(r101.f204252c) == false) goto L20;
        return -2;
    }
}
