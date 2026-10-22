package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class am implements ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile am f463134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ah f239a;

    private String a(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100;
    }

    public void a() {
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a */
    public String mo8804a() {
        return a(this.f239a.mo8804a());
    }

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a */
    public boolean mo8805a() {
        return this.f239a.mo8805a();
    }

    private am(Context r100) {
        this.f239a = al.a(r100);
        this.f238a = al.f463133a;
        com.xiaomi.channel.commonutils.logger.b.m8718a("create id manager is: " + this.f238a);
    }

    public void a(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = b();
        if (TextUtils.isEmpty(r101) == true) goto L7;
        r100.put("udid", r101);
    L7:
        String r102 = mo8804a();
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r100.put("oaid", r102);
    L10:
        String r103 = c();
        if (TextUtils.isEmpty(r103) == true) goto L13;
        r100.put("vaid", r103);
    L13:
        String r104 = d();
        if (TextUtils.isEmpty(r104) == true) goto L16;
        r100.put("aaid", r104);
    L16:
        r100.put("oaid_type", String.valueOf(this.f238a));
    }

    public static am a(Context r100) {
        if (f463134a != null) goto L15;
        monitor-enter(am.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463134a != null) goto L9;
        f463134a = new am(r100.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(am.class);     // Catch: Throwable -> L11
    L15:
        return f463134a;
    }
}
