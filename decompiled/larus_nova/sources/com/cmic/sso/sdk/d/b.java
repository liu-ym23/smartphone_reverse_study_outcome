package com.cmic.sso.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.f;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.cmic.sso.sdk.a f273487a;

    public b() {
    }

    private void a(JSONObject r100) {
        com.cmic.sso.sdk.c.c.a.a().a(r100, this.f273487a, new AnonymousClass1(this));
    }

    public static /* synthetic */ com.cmic.sso.sdk.a a(b r100) {
        return r100.f273487a;
    }

    private static void a(a r100, com.cmic.sso.sdk.a r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r100.b(r101.b("appid", ""));
        r100.e(m.a());
        r100.h(r101.b("interfaceType", ""));
        r100.g(r101.b("interfaceCode", ""));
        r100.f(r101.b("interfaceElasped", ""));
        r100.k(r101.b("timeOut"));
        r100.r(r101.b("traceId"));
        r100.m(r101.b("simCardNum"));
        r100.n(r101.b(OnekeyLoginConstants.OPERATOR_TYPE));
        r100.o(m.b());
        r100.p(m.c());
        r100.v(String.valueOf(r101.b("networktype", 0)));
        r100.s(r101.b("starttime"));
        r100.t(r101.b("endtime"));
        r100.l(String.valueOf(r101.b("systemEndTime", 0) - r101.b("systemStartTime", 0)));
        r100.c(r101.b("imsiState"));
        r100.x(k.b("AID", ""));
        r100.y(r101.b(OnekeyLoginConstants.OPERATOR_TYPE));
        r100.z(r101.b("scripType"));
        r100.A(r101.b("networkTypeByAPI"));
        c.a("SendLog", "traceId" + r101.b("traceId"));
        return;
    L8:
        return;
    }

    private void a(JSONObject r100, com.cmic.sso.sdk.a r101) {
        this.f273487a = r101;
        a(r100);
    }

    public void a(Context r110, String r111, com.cmic.sso.sdk.a r112) {
        String r100 = "";
        a r101 = r112.a();     // Catch: Exception -> L28
        String r102 = f.b(r110);     // Catch: Exception -> L28
        r101.d(r111);     // Catch: Exception -> L28
        r101.u(r112.b("loginMethod", ""));     // Catch: Exception -> L28
        if (r112.b("isCacheScrip", false) == false) goto L6;
        r101.q("scrip");     // Catch: Exception -> L28
    L7:
        r101.i(f.a(r110));     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r102) == true) goto L11;
        r100 = r102;
    L11:
        r101.j(r100);     // Catch: Exception -> L28
        a(r101, r112);     // Catch: Exception -> L28
        if (r101.f273461a.size() <= 0) goto L21;
        JSONArray r113 = new JSONArray();     // Catch: Exception -> L28
        Iterator<Throwable> r114 = r101.f273461a.iterator();     // Catch: Exception -> L28
    L15:
        if (r114.hasNext() == false) goto L20;
        Throwable r103 = r114.next();     // Catch: Exception -> L28
        StringBuffer r104 = new StringBuffer();     // Catch: Exception -> L28
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L28
        StackTraceElement[] r106 = r103.getStackTrace();     // Catch: Exception -> L28
        int r107 = r106.length;     // Catch: Exception -> L28
        int r108 = 0;
    L17:
        if (r108 >= r107) goto L19;
        StackTraceElement r109 = r106[r108];     // Catch: Exception -> L28
        r104.append("\n");     // Catch: Exception -> L28
        r104.append(r109.toString());     // Catch: Exception -> L28
        r108 = r108 + 1;     // Catch: Exception -> L28
        goto L17
    L19:
        r105.put("message", r103.toString());     // Catch: Exception -> L28
        r105.put("stack", r104.toString());     // Catch: Exception -> L28
        r113.put(r105);     // Catch: Exception -> L28
        goto L15
    L20:
        r101.f273461a.clear();     // Catch: Exception -> L28
    L22:
        if (r113 != null) goto L24;
    L26:
        c.a("SendLog", "登录日志");     // Catch: Exception -> L28
        a(r101.b(), r112);     // Catch: Exception -> L28
        return;
    L24:
        if (r113.length() <= 0) goto L26;
        r101.a(r113);     // Catch: Exception -> L28
        goto L26
    L21:
        r113 = null;
        goto L22
    L6:
        r101.q("pgw");     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    }
}
