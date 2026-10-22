package com.cmic.ida.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f273163a;

    public class a implements h0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m0 f273164a;

        public a(m0 r100) {
            this.f273164a = r100;
        }

        @Override // com.cmic.ida.sdk.h0
        public void a(String r100, String r101, JSONObject r102) {
            HashMap r103 = new HashMap();
            if (r100.equals("103000") == false) goto L6;
            r103.put("logFailTimes", 0);
            r103.put("logCloseTime", 0L);
        L6:
            n0.a(r103);
        }
    }

    public m0() {
    }

    private void a(JSONObject r100) {
        e.a().a(r100, this.f273163a, new a(this));
    }

    private static void a(s r100, g r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r100.f(r101.a("appId", ""));
        r100.g(p0.b());
        r100.l(r101.a("interfaceType", ""));
        r100.j(r101.a("interfaceCode", ""));
        r100.k(r101.a("interfaceElasped", ""));
        r100.z(r101.b("timeOut"));
        r100.A(r101.b("traceId"));
        r100.x(r101.b("simCardNum"));
        r100.p(r101.b(OnekeyLoginConstants.OPERATOR_TYPE));
        r100.q(p0.c());
        r100.r(p0.a());
        r100.n(String.valueOf(r101.a("networktype", 0)));
        r100.s(r101.b("starttime"));
        r100.u(r101.b("endtime"));
        r100.h(String.valueOf(r101.a("systemEndTime", 0) - r101.a("systemStartTime", 0)));
        r100.i(r101.b("imsiState"));
        r100.c(n0.a("AID", ""));
        r100.y(r101.b(OnekeyLoginConstants.OPERATOR_TYPE));
        r100.w(r101.b("scripType"));
        r100.o(r101.b("networkTypeByAPI"));
        u.b("SendLog", "traceId" + r101.b("traceId"));
        return;
    L8:
        return;
    }

    public void a(JSONObject r100, g r101) {
        this.f273163a = r101;
        a(r100);
    }

    public void a(Context r110, String r111, g r112) {
        String r100 = "";
        s r101 = r112.a();     // Catch: Exception -> L28
        String r102 = d0.d(r110);     // Catch: Exception -> L28
        r101.v(r111);     // Catch: Exception -> L28
        r101.t(r112.a("loginMethod", ""));     // Catch: Exception -> L28
        if (r112.a("isCacheScrip", false) == false) goto L6;
        r101.m("scrip");     // Catch: Exception -> L28
    L7:
        r101.d(d0.a(r110));     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r102) == true) goto L11;
        r100 = r102;
    L11:
        r101.e(r100);     // Catch: Exception -> L28
        a(r101, r112);     // Catch: Exception -> L28
        if (r101.A.size() <= 0) goto L21;
        JSONArray r113 = new JSONArray();     // Catch: Exception -> L28
        Iterator<Throwable> r114 = r101.A.iterator();     // Catch: Exception -> L28
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
        r101.A.clear();     // Catch: Exception -> L28
    L22:
        if (r113 != null) goto L24;
    L26:
        u.b("SendLog", "登录日志");     // Catch: Exception -> L28
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
        r101.m("pgw");     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    }
}
