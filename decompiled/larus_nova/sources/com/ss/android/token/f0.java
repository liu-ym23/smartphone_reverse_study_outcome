package com.ss.android.token;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f449738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Uri f449739b;

    public final void a() {
        update(d("clear_last_token", null));
    }

    public final String b() {
        Cursor r100 = query(d("get_last_same_user_token", null));
        if (r100 != null) goto L5;
    L8:
        if (r100 == null) goto L12;
        r100.close();
        return "";
    L12:
        return "";
    L5:
        if (r100.moveToFirst() == false) goto L8;
        return r100.getString(r100.getColumnIndexOrThrow("last_token"));
    }

    public final void e() {
        update(d("save_last_token", null));
    }

    public final e0 c() {
        Cursor r100 = query(d("get_token_object", null));
        String r101 = "";
        if (r100 != null) goto L5;
    L28:
        e0 r102 = new e0();
    L29:
        String r103 = r102.f449725a;
        if (TextUtils.isEmpty(r103) == true) goto L33;
        int r104 = bc7.a.f18591a;
        r101 = String.valueOf(bc7.a.a(r103.getBytes(), 0));
    L33:
        r102.f449729e = r101;
        if (r100 == null) goto L36;
        r100.close();
    L36:
        return r102;
    L5:
        if (r100.moveToFirst() == false) goto L28;
        String r105 = r100.getString(r100.getColumnIndexOrThrow("token"));
        String r106 = r100.getString(r100.getColumnIndexOrThrow("ts_sign"));
        String r107 = r100.getString(r100.getColumnIndexOrThrow("attest_ts_sign"));
        String r108 = r100.getString(r100.getColumnIndexOrThrow("token_encrypted"));
        String r109 = r100.getString(r100.getColumnIndexOrThrow("token_hash"));
        String r110 = r100.getString(r100.getColumnIndexOrThrow("track_data"));
        String r111 = r100.getString(r100.getColumnIndexOrThrow("token_tlb_tag"));
        int r112 = r100.getColumnIndex("is_login");
        if (r112 >= 0) goto L9;
    L11:
        int r113 = -1;
    L12:
        if (r110 != null) goto L14;
        r110 = "";
    L14:
        TicketTrackData.Serialized r114 = new TicketTrackData.Serialized(r110);
        if (r105 != null) goto L17;
        String r115 = "";
    L18:
        if (r106 != null) goto L20;
        String r116 = "";
    L21:
        if (r107 != null) goto L23;
        String r117 = "";
    L24:
        if (r111 != null) goto L26;
        String r118 = "";
    L27:
        r102 = new e0(r115, r116, r117, r114, r118, r113);
        r102.f449730f = r108;
        r102.f449729e = r109;
        goto L29
    L26:
        r118 = r111;
        goto L27
    L23:
        r117 = r107;
        goto L24
    L20:
        r116 = r106;
        goto L21
    L17:
        r115 = r105;
        goto L18
    L9:
        if (r100.isNull(r112) == true) goto L11;
        r113 = r100.getInt(r112);
        goto L12
    }

    public f0(Context r100) {
        this.f449738a = r100.getApplicationContext();
    }

    private Cursor query(Uri r110) {
        ContentResolver r100 = this.f449738a.getContentResolver();
        f06.c r101 = new f06.c();
        Object[] r111 = {r110, null, null, null, null};
        f06.b r112 = new f06.b();
        f06.d r113 = r101.b(240004, "android/content/ContentResolver", "query", r100, r111, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L5;
        r101.a(240004, "android/content/ContentResolver", "query", r100, r111, null, r112, false);
        return (Cursor) r113.f474983b;
    L5:
        Cursor r114 = r100.query(r110, null, null, null, null);
        r101.a(240004, "android/content/ContentResolver", "query", r100, r111, r114, r112, true);
        return r114;
    }

    private void update(Uri r210) {
        ContentResolver r100 = this.f449738a.getContentResolver();
        ContentValues r110 = new ContentValues();
        ArrayList r111 = new ArrayList();
        Object[] r112 = {r210, r110, null, null};
        f06.b r113 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(240018);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r114 = r102;
        int r103 = r114.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r114[r104];
        int r211 = r104;
        int r212 = r103;
        f06.a[] r213 = r114;
        f06.d r106 = r105.preInvoke(240018, "android/content/ContentResolver", "update", r100, r112, "int", r113);     // Catch: Exception -> L21
        if (r106.f474982a == true) goto L17;
        r111.add(r105);     // Catch: Exception -> L21
    L17:
        if (r106.f474982a == false) goto L19;
        ((Integer) r106.f474983b).intValue();
        return;
    L19:
        r100.update(r210, r110, null, null);
        return;
    L14:
        r104 = r211 + 1;
        r103 = r212;
        r114 = r213;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public final void f(e0 r100) {
        HashMap r101 = new HashMap();
        r101.put("token", r100.f449725a);
        r101.put("ts_sign", r100.f449726b);
        r101.put("attest_ts_sign", r100.f449727c);
        com.bytedance.sdk.account.utils.j<TicketTrackData> r102 = r100.f449728d;
        if (r102 == null) goto L6;
        r101.put("track_data", r102.a());
    L6:
        if (TextUtils.isEmpty(r100.f449729e) == true) goto L9;
        r101.put("token_hash", r100.f449729e);
    L9:
        if (TextUtils.isEmpty(r100.f449730f) == true) goto L11;
        r101.put("token_encrypted", r100.f449730f);
    L11:
        r101.put("token_tlb_tag", r100.f449731g);
        r101.put("is_login", String.valueOf(r100.f449732h));
        update(d("set_token_object", r101));
    }

    public final Uri d(String r100, Map<String, String> r101) {
        if (this.f449739b != null) goto L5;
        this.f449739b = UriProtector.parse("content://" + TokenObjectProvider.a(this.f449738a));
    L5:
        Uri.Builder r102 = this.f449739b.buildUpon().appendPath(r100);
        if (r101 == null) goto L14;
        HashMap r103 = (HashMap) r101;
        if (r103.isEmpty() == true) goto L14;
        Iterator r104 = r103.entrySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L14;
        Map.Entry r105 = (Map.Entry) r104.next();
        r102.appendQueryParameter((String) r105.getKey(), (String) r105.getValue());
    L14:
        return r102.build();
    }
}
