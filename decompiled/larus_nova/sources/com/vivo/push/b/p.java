package com.vivo.push.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.vivo.push.model.InsideNotificationItem;

/* JADX INFO: loaded from: classes41.dex */
public final class p extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f462247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f462249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f462250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InsideNotificationItem f462251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f462252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f462253g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Uri f462254h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f462255i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Bundle f462256j;

    public p() {
        super(5);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    public final Bundle l() {
        if (this.f462256j != null) goto L6;
        return null;
    L6:
        Bundle r100 = new Bundle(this.f462256j);
        r100.remove("command_type");     // Catch: Exception -> L9
        r100.remove("security_avoid_pull");     // Catch: Exception -> L9
        r100.remove("security_avoid_pull_rsa");     // Catch: Exception -> L9
        r100.remove("security_avoid_rsa_public_key");     // Catch: Exception -> L9
        r100.remove("security_avoid_rsa_public_key");     // Catch: Exception -> L9
        r100.remove("notify_action");     // Catch: Exception -> L9
        r100.remove("notify_componet_pkg");     // Catch: Exception -> L9
        r100.remove("notify_componet_class_name");     // Catch: Exception -> L9
        r100.remove("notification_v1");     // Catch: Exception -> L9
        r100.remove("command");     // Catch: Exception -> L9
        r100.remove("package_name");     // Catch: Exception -> L9
        r100.remove(com.alipay.sdk.m.p.e.f25671s);     // Catch: Exception -> L9
    L11:
        return r100;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public final String e() {
        return this.f462247a;
    }

    public final long f() {
        return this.f462250d;
    }

    public final InsideNotificationItem g() {
        return this.f462251e;
    }

    public final String h() {
        return this.f462252f;
    }

    public final String i() {
        return this.f462253g;
    }

    public final String j() {
        return this.f462255i;
    }

    public final Uri k() {
        return this.f462254h;
    }

    private static Uri e(String r100) {
        return UriProtector.parse(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final void a(Uri r100) {
        this.f462254h = r100;
    }

    public final void b(String r100) {
        this.f462252f = r100;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        r100.a("package_name", this.f462247a);
        r100.a("notify_id", this.f462250d);
        r100.a("notification_v1", com.vivo.push.util.u.b(this.f462251e));
        r100.a("open_pkg_name", this.f462248b);
        r100.a("open_pkg_name_encode", this.f462249c);
        r100.a("notify_action", this.f462252f);
        r100.a("notify_componet_pkg", this.f462253g);
        r100.a("notify_componet_class_name", this.f462255i);
        Uri r101 = this.f462254h;
        if (r101 == null) goto L6;
        r100.a("notify_uri_data", r101.toString());
        return;
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        this.f462247a = r100.a("package_name");
        this.f462250d = r100.b("notify_id", -1);
        this.f462248b = r100.a("open_pkg_name");
        this.f462249c = r100.b("open_pkg_name_encode");
        this.f462252f = r100.a("notify_action");
        this.f462253g = r100.a("notify_componet_pkg");
        this.f462255i = r100.a("notify_componet_class_name");
        String r101 = r100.a("notification_v1");
        if (TextUtils.isEmpty(r101) == true) goto L5;
        this.f462251e = com.vivo.push.util.u.a(r101);
    L5:
        InsideNotificationItem r102 = this.f462251e;
        if (r102 == null) goto L8;
        r102.setMsgId(this.f462250d);
    L8:
        String r103 = r100.a("notify_uri_data");
        if (TextUtils.isEmpty(r103) == true) goto L11;
        this.f462254h = e(r103);
    L11:
        this.f462256j = r100.b();
    }

    public final void c(String r100) {
        this.f462253g = r100;
    }

    public final void d(String r100) {
        this.f462255i = r100;
    }

    public p(String r100, long r101, InsideNotificationItem r102) {
        super(5);
        this.f462247a = r100;
        this.f462250d = r101;
        this.f462251e = r102;
    }
}
