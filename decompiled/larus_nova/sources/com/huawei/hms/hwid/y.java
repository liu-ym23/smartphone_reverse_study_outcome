package com.huawei.hms.hwid;

import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final y f277521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f277522b;

    public final AuthHuaweiId b() {
        String r100 = this.f277522b.get("HuaweiIdAccount");     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return AuthHuaweiId.fromJson(r100);
    L12:
        return null;
    L7:
        th = move-exception;
        as.d("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "getHuaweiSignInAccount faild, exception:".concat(th.getClass().getSimpleName()), true);
        return null;
    }

    static {
        f277521a = new y();
    }

    public void c() {
        this.f277522b.clear();
    }

    private y() {
        this.f277522b = new ConcurrentHashMap();
    }

    public static y a() {
        return f277521a;
    }

    public void a(AuthHuaweiId r100, HuaweiIdAuthParams r101) {
        as.b("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "saveDefaultHuaweiIdSignInAccount start.", true);
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
        as.d("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "store faild, exception:".concat(th.getClass().getSimpleName()), true);
        return;
    L14:
        r103 = r100.toJson();     // Catch: Throwable -> L5
        goto L8
    }

    private void a(String r100, String r101) {
        as.b("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "saveDefaultHuaweiIdSignInAccount start.", true);
        this.f277522b.remove("HuaweiIdAccount");
        this.f277522b.remove("HuaweiIdAuthParams");
        if (r100 == null) goto L5;
        this.f277522b.put("HuaweiIdAccount", r100);
    L5:
        if (r101 == null) goto L8;
        this.f277522b.put("HuaweiIdAuthParams", r101);
        return;
    }
}
