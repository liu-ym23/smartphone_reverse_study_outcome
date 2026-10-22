package com.huawei.hms.hwid;

import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AuthAccount;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f277509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f277510b;

    static {
        f277509a = new g();
    }

    public final AuthAccount b() {
        as.b("[AccountSDK]AccountAuthMemCache", "getSignInAccount start.", true);
        String r100 = this.f277510b.get("AccountAuth");     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return AuthAccount.fromJson(r100);
    L12:
        return null;
    L7:
        th = move-exception;
        as.d("[AccountSDK]AccountAuthMemCache", "getSignInAccount faild, exception:".concat(th.getClass().getSimpleName()), true);
        return null;
    }

    public void c() {
        this.f277510b.clear();
    }

    private g() {
        this.f277510b = new ConcurrentHashMap();
    }

    public static g a() {
        return f277509a;
    }

    public void a(AuthAccount r100, AccountAuthParams r101) {
        as.b("[AccountSDK]AccountAuthMemCache", "saveDefaultAccountSignInAccount start.", true);
        String r102 = null;
        if (r100 != null) goto L14;
        String r103 = null;
    L8:
        if (r101 == null) goto L10;
        r102 = r101.toJson();     // Catch: Throwable -> L5
    L10:
        a(r103, r102);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        as.d("[AccountSDK]AccountAuthMemCache", "store faild, exception:".concat(th.getClass().getSimpleName()), true);
        return;
    L14:
        r103 = r100.toJson();     // Catch: Throwable -> L5
        goto L8
    }

    private void a(String r100, String r101) {
        as.b("[AccountSDK]AccountAuthMemCache", "saveDefaultAccountSignInAccount start.", true);
        this.f277510b.remove("AccountAuth");
        this.f277510b.remove("AccountAuthParams");
        if (r100 == null) goto L5;
        this.f277510b.put("AccountAuth", r100);
    L5:
        if (r101 == null) goto L8;
        this.f277510b.put("AccountAuthParams", r101);
        return;
    }
}
