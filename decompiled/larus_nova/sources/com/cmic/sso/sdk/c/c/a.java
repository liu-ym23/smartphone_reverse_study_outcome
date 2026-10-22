package com.cmic.sso.sdk.c.c;

import android.os.SystemClock;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.c.b.f;
import com.cmic.sso.sdk.c.b.h;
import com.cmic.sso.sdk.e.i;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import com.cmic.sso.sdk.e.o;
import com.cmic.sso.sdk.e.q;
import com.ss.android.cert.manager.constants.EventConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f273432a;

    public static a a() {
        if (f273432a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f273432a != null) goto L9;
        f273432a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f273432a;
    }

    private a() {
    }

    public void a(com.cmic.sso.sdk.a r110, d r111) {
        int r100 = r110.c("networktype");
        h r101 = new h();
        r101.b("1.0");
        r101.c(AuthnHelper.SDK_VERSION);
        r101.d(r110.b("appid"));
        r101.e(r110.b(OnekeyLoginConstants.OPERATOR_TYPE));
        r101.f(r100 + "");
        r101.g(m.a());
        r101.h(m.b());
        r101.i(m.c());
        r101.j("0");
        r101.k("3.1");
        r101.l(q.b());
        r101.m(o.a());
        r101.o(r110.b("apppackage"));
        r101.p(r110.b("appsign"));
        r101.v(r110.b(OnekeyLoginConstants.CU_KEY_OPERATOR));
        r101.a(k.b("AID", ""));
        if (r110.c("logintype") != 3) goto L5;
    L12:
        r101.s(TeaEventTrack.ACTION_DRAMA_PRE);
    L13:
        q.a(r110, "scripAndTokenForHttpsV2");
        com.cmic.sso.sdk.a.a r102 = r110.b();
        if (r110.b("isCacheScrip", false) == false) goto L16;
    L26:
        r101.x(r110.b("phonescrip"));
        r101.n(r101.w(r110.b("appkey")));
        c r103 = new c("https://" + r102.a() + "/unisdk/rs/scripAndTokenForHttpsV2", r101, "POST", r110.b("traceId"));
        r103.a("defendEOF", "0");
    L27:
        r103.a("interfaceVersion", "3.1");
        r103.a("dnsParseResult", "1");
        a(r103, r111, r110);
        return;
    L16:
        if (r110.b("isGotScrip", false) == true) goto L26;
        e r104 = new e();
        r104.a(r110.a(com.cmic.sso.sdk.b.a.f273344a));
        r104.b(r110.a(com.cmic.sso.sdk.b.a.f273345b));
        r104.a(r101);
        r104.a(false);
        r110.a("isCloseIpv4", r102.h());
        r110.a("isCloseIpv6", r102.i());
        String r105 = "https://" + r102.b() + "/unisdk/rs/scripAndTokenForHttpsV2";
        if (r110.b("use2048PublicKey", false) == false) goto L21;
        com.cmic.sso.sdk.e.c.a("BaseRequest", "使用2对应的编码");
        r104.b("2");
        String r106 = i.a().b(r110.a(com.cmic.sso.sdk.b.a.f273344a));
    L22:
        r104.c(r106);
        r103 = new b(r105, r104, "POST", r110.b("traceId"));
        if (r100 != 3) goto L25;
        r103.a(true);
        r110.a("doNetworkSwitch", true);
        goto L27
    L25:
        r103.a(false);
        r110.a("doNetworkSwitch", false);
        goto L27
    L21:
        r106 = i.a().a(r110.a(com.cmic.sso.sdk.b.a.f273344a));
        goto L22
    L5:
        if (r110.b("isRisk", false) == true) goto L12;
        r101.y(r110.b("userCapaid"));
        if (r110.c("logintype") != 1) goto L10;
        r101.y("200");
    L11:
        r101.s("authz");
        goto L13
    L10:
        r101.y("50");
        goto L11
    }

    public void a(JSONObject r100, com.cmic.sso.sdk.a r101, d r102) {
        f r103 = new f();
        f.a r104 = new f.a();
        f.b r105 = new f.b();
        r105.e(q.b());
        r105.f(o.a());
        r105.b(EventConstant.Value.AUTH_VERSION_2);
        r105.c(r101.b("appid", ""));
        r105.d(r105.w(""));
        r104.a(r100);
        r103.a(r104);
        r103.a(r105);
        a(new c("https://" + r101.b().d() + "/log/logReport", r103, "POST", r101.b("traceId")), r102, r101);
    }

    public void a(boolean r100, com.cmic.sso.sdk.a r101, d r102) {
        com.cmic.sso.sdk.c.b.b r103 = new com.cmic.sso.sdk.c.b.b();
        r103.b("1.0");
        r103.c("Android");
        r103.d(k.b("AID", ""));
        if (r100 == false) goto L5;
        String r104 = "1";
    L6:
        r103.e(r104);
        r103.f(AuthnHelper.SDK_VERSION);
        r103.g(r101.b("appid"));
        r103.h(r103.w("iYm0HAnkxQtpvN44"));
        a(new c("https://" + r101.b().c() + "/client/uniConfig", r103, "POST", r101.b("traceId")), r102, r101);
        return;
    L5:
        r104 = "0";
        goto L6
    }

    private void a(final c r100, final d r101, final com.cmic.sso.sdk.a r102) {
        com.cmic.sso.sdk.c.a.d r103 = new com.cmic.sso.sdk.c.a.d();
        com.cmic.sso.sdk.c.a.c r104 = new com.cmic.sso.sdk.c.a.c();
        com.cmic.sso.sdk.c.a.a r105 = new com.cmic.sso.sdk.c.a.a();
        r103.a(r104);
        r104.a(r105);
        r100.a(SystemClock.elapsedRealtime());
        r103.a(r100, new AnonymousClass1(this, r102, r101, r100), r102);
    }
}
