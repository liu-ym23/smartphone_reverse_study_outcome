package com.vivo.push.restructure.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.vivo.push.PushConfig;
import com.vivo.push.util.aa;
import com.vivo.push.util.g;
import com.vivo.push.util.t;
import com.vivo.push.util.z;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, c> f462474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private z f462476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile PushConfig f462477d;

    @Override // com.vivo.push.restructure.b.a
    public final int l() {
        return 31;
    }

    static {
        f462474a = new ConcurrentHashMap();
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a() {
        c r100 = f462474a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (r100 == null) goto L7;
        String r101 = r100.a();
        if (TextUtils.isEmpty(r101) == true) goto L7;
        return r101;
    L7:
        String r102 = this.f462476c.c();
        if (TextUtils.isEmpty(r102) == true) goto L12;
        if (r100 != null) goto L11;
        r100 = new c();
    L11:
        r100.a(r102);
        f462474a.put(com.vivo.push.restructure.a.a().b().getPackageName(), r100);
    L12:
        return r102;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b() {
        a("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String c() {
        c r100 = f462474a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (r100 == null) goto L7;
        String r101 = r100.b();
        if (TextUtils.isEmpty(r101) == true) goto L7;
        return r101;
    L7:
        String r102 = this.f462476c.d();
        if (TextUtils.isEmpty(r102) == true) goto L12;
        if (r100 != null) goto L11;
        r100 = new c();
    L11:
        r100.b(r102);
        f462474a.put(com.vivo.push.restructure.a.a().b().getPackageName(), r100);
    L12:
        return r102;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d() {
        b("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e() {
        this.f462476c.b();
        f462474a.clear();
    }

    @Override // com.vivo.push.restructure.b.a
    public final String f() {
        return this.f462476c.b("APP_TOKEN", null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final String g() {
        return this.f462476c.b("APP_TAGS", null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void h() {
        this.f462476c.c("APP_TAGS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String i() {
        return this.f462476c.b("APP_ALIAS", null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void j() {
        this.f462476c.c("APP_ALIAS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final PushConfig m() {
        if (this.f462477d != null) goto L5;
        boolean r100 = true;
        int r101 = this.f462476c.b("PUSH_CLIENT_CONFIG", 1);
        PushConfig.Builder r102 = new PushConfig.Builder();
        if ((r101 & 1) == 0) goto L9;
        boolean r103 = true;
    L10:
        PushConfig.Builder r104 = r102.agreePrivacyStatement(r103);
        if ((r101 & 2) != 0) goto L15;
        r100 = false;
    L15:
        return r104.openMultiUserMode(r100).build();
    L9:
        r103 = false;
        goto L10
    L5:
        return this.f462477d;
    }

    @Override // com.vivo.push.restructure.b.a
    public final String k() {
        com.vivo.push.model.a r100 = aa.a(com.vivo.push.restructure.a.a().b(), com.vivo.push.restructure.a.a().f());
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.c() == false) goto L8;
        return null;
    L8:
        return r100.a();
    }

    public d(z r100) {
        this.f462476c = r100;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(String r100) {
        this.f462476c.a("APP_APPID", r100);
        c r101 = f462474a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (r101 != null) goto L5;
        r101 = new c();
    L5:
        r101.a(r100);
        f462474a.put(com.vivo.push.restructure.a.a().b().getPackageName(), r101);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b(String r100) {
        this.f462476c.a("APP_APIKEY", r100);
        c r101 = f462474a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (r101 != null) goto L5;
        r101 = new c();
    L5:
        r101.b(r100);
        f462474a.put(com.vivo.push.restructure.a.a().b().getPackageName(), r101);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void c(String r100) {
        this.f462476c.a("APP_TOKEN", r100);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d(String r100) {
        this.f462476c.a("APP_TAGS", r100);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e(String r100) {
        this.f462476c.a("APP_ALIAS", r100);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(PushConfig r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f462477d = r100;
        Context r101 = com.vivo.push.restructure.a.a().b();
        boolean r102 = r100.isAgreePrivacyStatement();
        if (r100.isOpenMultiUser() == false) goto L7;
        int r103 = 2;
    L8:
        int r104 = (r102 ? 1 : 0) | r103;
        this.f462476c.a("PUSH_CLIENT_CONFIG", r104);
        g.a().execute(new e(this, r101, r100));
        return;
    L7:
        r103 = 0;
        goto L8
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a(Context r100, String r101) {
        if (TextUtils.isEmpty(this.f462475b) == true) goto L7;
        return this.f462475b;
    L7:
        if (r100 != null) goto L9;
    L16:
        t.a("PushRelyImpl", "getReceiverClassName() params error, context = " + r100 + ", action = " + r101);
        return "";
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        String r102 = r100.getPackageName();
        String r103 = a(r100, r102, r101);
        this.f462475b = r103;
        if (TextUtils.isEmpty(r103) == false) goto L15;
        t.d("PushRelyImpl", " reflectReceiver error: receiver for: " + r101 + " not found, package: " + r102);
    L15:
        return this.f462475b;
    }

    private static String a(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L26;
        Intent r103 = new Intent(r102);
        r103.setPackage(r101);
        PackageManager r104 = r100.getPackageManager();     // Catch: Exception -> L17
        if (r104 != null) goto L11;
        return null;
    L11:
        List<ResolveInfo> r105 = r104.queryBroadcastReceivers(r103, 64);     // Catch: Exception -> L17
        if (r105 != null) goto L14;
        return null;
    L14:
        if (r105.size() <= 0) goto L24;
        return ((ResolveInfo) ListProtector.get(r105, 0)).activityInfo.name;
    L24:
        return null;
    L17:
        e = move-exception;
        t.a("PushRelyImpl", "error  " + e.getMessage());
        return null;
    L26:
        return null;
    }
}
