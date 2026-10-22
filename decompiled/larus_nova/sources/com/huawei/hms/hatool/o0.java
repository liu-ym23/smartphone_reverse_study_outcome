package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* JADX INFO: loaded from: classes23.dex */
public class o0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static o0 f277415c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277417b;

    public o0() {
    }

    private String a(String r100) {
        if (f() == false) goto L5;
        String r101 = AesGcmKS.decrypt("analytics_keystore", r100);
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L16;
        v.c("hmsSdk", "deCrypt work key first");
        r101 = n.a(r100, e());
        if (TextUtils.isEmpty(r101) == false) goto L14;
        r101 = EncryptUtil.generateSecureRandomStr(16);
        c(b(r101));
        if (f() == false) goto L16;
    L12:
        x.c();
        goto L16
    L14:
        if (f() == false) goto L16;
        c(b(r101));
    L16:
        return r101;
    L5:
        r101 = "";
        goto L7
    }

    private String b(String r100) {
        if (f() == false) goto L7;
        return AesGcmKS.encrypt("analytics_keystore", r100);
    L7:
        return n.b(r100, e());
    }

    private String c() {
        String r100 = d.a(q0.i(), "Privacy_MY", "PrivacyData", "");
        if (TextUtils.isEmpty(r100) == false) goto L7;
        String r101 = EncryptUtil.generateSecureRandomStr(16);
        c(b(r101));
        return r101;
    L7:
        return a(r100);
    }

    private boolean c(String r100) {
        v.c("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        v.c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
        return false;
    L6:
        d.b(q0.i(), "Privacy_MY", "PrivacyData", r100);
        d.b(q0.i(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    public static o0 d() {
        if (f277415c != null) goto L6;
        g();
    L6:
        return f277415c;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f277417b) == false) goto L6;
        this.f277417b = new x().a();
    L6:
        return this.f277417b;
    }

    private boolean f() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }

    private static synchronized void g() {
        monitor-enter(o0.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f277415c != null) goto L7;
        f277415c = new o0();     // Catch: Throwable -> L9
    L7:
        monitor-exit(o0.class);
    }

    public String a() {
        if (TextUtils.isEmpty(this.f277416a) == false) goto L6;
        this.f277416a = c();
    L6:
        return this.f277416a;
    }

    public void b() {
        String r100 = EncryptUtil.generateSecureRandomStr(16);
        if (c(b(r100)) == false) goto L6;
        this.f277416a = r100;
        return;
    }
}
