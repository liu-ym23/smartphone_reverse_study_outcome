package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static e f277320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, Long> f277321c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277322a;

    static {
        f277321c = new HashMap();
    }

    public e() {
    }

    public static e a() {
        return b();
    }

    private static synchronized e b() {
        monitor-enter(e.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f277320b != null) goto L7;
        f277320b = new e();     // Catch: Throwable -> L10
    L7:
        e r100 = f277320b;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r100;
    }

    private void b(Context r100) {
        String r101 = o.d(r100);
        q0.a(r101);
        if (q1.b().a() == false) goto L10;
        String r102 = d.a(r100, "global_v2", Constants.PARAM_APP_VER, "");
        d.b(r100, "global_v2", Constants.PARAM_APP_VER, r101);
        q0.b(r102);
        if (TextUtils.isEmpty(r102) == false) goto L8;
        String r103 = "app ver is first save!";
    L11:
        v.c("hmsSdk", r103);
        return;
    L8:
        if (r102.equals(r101) == true) goto L13;
        v.c("hmsSdk", "the appVers are different!");
        a().a("", "alltype", r102);
        return;
    L13:
        return;
    L10:
        r103 = "userManager.isUserUnlocked() == false";
        goto L11
    }

    public void a(Context r100) {
        this.f277322a = r100;
        b(r100);
        s.c().b().h(o.a());
    }

    public void a(String r100, int r101) {
        if (this.f277322a != null) goto L6;
        v.e("hmsSdk", "onReport() null context or SDK was not init.");
        return;
    L6:
        v.a("hmsSdk", "onReport: Before calling runtaskhandler()");
        a(r100, n1.a(r101), q0.g());
    }

    public void a(String r110, int r111, String r112, JSONObject r113) {
        long r100 = System.currentTimeMillis();
        if (2 != r111) goto L5;
        r100 = n1.a("yyyy-MM-dd", r100);
    L5:
        String r101 = n1.a(r111);
        a0 r102 = new a0(r112, r113, r110, r101, r100);
        b0.c().a(r102);
    }

    public void a(String r100, int r110, String r111, JSONObject r112, long r113) {
        new i1(r100, n1.a(r110), r111, r112.toString(), r113).a();
    }

    public void a(String r100, String r110) {
        if (a1.a(r100, r110) == false) goto L8;
        long r101 = a1.j(r100, r110);
        long r102 = System.currentTimeMillis();
        if ((r102 - r101) <= 30000) goto L7;
        v.a("hmsSdk", "begin to call onReport!");
        a1.a(r100, r110, r102);
        a(r100, r110, q0.g());
        return;
    L7:
        v.f("hmsSdk", "autoReport timeout. interval < 30s ");
        return;
    L8:
        v.c("hmsSdk", "auto report is closed tag:" + r100);
    }

    public void a(String r100, String r101, String r102) {
        Context r103 = this.f277322a;
        if (r103 != null) goto L6;
        v.e("hmsSdk", "onReport() null context or SDK was not init.");
        return;
    L6:
        String r104 = r0.b(r103);
        if (a1.e(r100, r101) == false) goto L13;
        if ("WIFI".equals(r104) == true) goto L13;
        v.c("hmsSdk", "strNetworkType is :" + r104);
        return;
    L13:
        if ("unknown".equals(r104) == false) goto L15;
    L19:
        v.e("hmsSdk", "The network is bad.");
        return;
    L15:
        if ("none".equals(r104) == true) goto L19;
        if ("2G".equals(r104) == true) goto L19;
        b0.c().a(new v0(r100, r101, r102));
    }
}
