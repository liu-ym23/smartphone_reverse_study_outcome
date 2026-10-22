package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.aa;

/* JADX INFO: loaded from: classes41.dex */
public class c extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f462223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f462225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f462226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f462227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f462228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f462229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f462230h;

    public final void f() {
        this.f462228f = null;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "BaseAppCommand";
    }

    public final int e() {
        return this.f462227e;
    }

    public final String g() {
        return this.f462223a;
    }

    public final int a(Context r100) {
        if (this.f462226d != (-1)) goto L14;
        String r101 = this.f462224b;
        if (TextUtils.isEmpty(r101) == false) goto L10;
        com.vivo.push.util.t.a("BaseAppCommand", "pkg name is null");
        r101 = a();
        if (TextUtils.isEmpty(r101) == false) goto L10;
        com.vivo.push.util.t.a("BaseAppCommand", "src is null");
        return -1;
    L10:
        this.f462226d = aa.b(r100, r101);
        if (TextUtils.isEmpty(this.f462228f) == true) goto L14;
        this.f462226d = 2;
    L14:
        return this.f462226d;
    }

    public final void b(int r100) {
        this.f462227e = r100;
    }

    @Override // com.vivo.push.v
    public void c(com.vivo.push.d r100) {
        r100.a("req_id", this.f462223a);
        r100.a("package_name", this.f462224b);
        r100.a("sdk_version", 356);
        r100.a("PUSH_APP_STATUS", this.f462226d);
        if (TextUtils.isEmpty(this.f462228f) == true) goto L5;
        r100.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f462228f);
    L5:
        r100.a("BaseAppCommand.EXTRA_APPID", this.f462230h);
        r100.a("BaseAppCommand.EXTRA_APPKEY", this.f462229g);
    }

    @Override // com.vivo.push.v
    public void d(com.vivo.push.d r100) {
        this.f462223a = r100.a("req_id");
        this.f462224b = r100.a("package_name");
        this.f462225c = r100.b("sdk_version", 0);
        this.f462226d = r100.b("PUSH_APP_STATUS", 0);
        this.f462228f = r100.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        this.f462230h = r100.a("BaseAppCommand.EXTRA_APPID");
        this.f462229g = r100.a("BaseAppCommand.EXTRA_APPKEY");
    }

    public final void b(String r100) {
        this.f462223a = r100;
    }

    public final void c(String r100) {
        this.f462230h = r100;
    }

    public final void d(String r100) {
        this.f462229g = r100;
    }

    public c(int r100, String r101) {
        super(r100);
        this.f462225c = -1;
        this.f462226d = -1;
        this.f462223a = null;
        this.f462224b = r101;
    }
}
