package com.cmic.ida.sdk;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.cert.manager.constants.EventConstant;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static e f273102b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f273103a;

    public class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f273104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h0 f273105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f273106c;

        @Override // com.cmic.ida.sdk.p
        public void a(n r100) {
            JSONObject r101 = new JSONObject(r100.a());     // Catch: Exception -> L9
            if (r101.has("resultcode") == false) goto L6;
            String r102 = JSONObjectProtectorUtils.getString(r101, "resultcode");     // Catch: Exception -> L9
        L7:
            y0.a(this.f273104a, r102);     // Catch: Exception -> L9
            this.f273105b.a(r102, r101.optString(SocialConstants.PARAM_APP_DESC), r101);     // Catch: Exception -> L9
            return;
        L6:
            r102 = JSONObjectProtectorUtils.getString(r101, "resultCode");     // Catch: Exception -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
            a(l.a(102223));
        }

        @Override // com.cmic.ida.sdk.p
        public void a(l r100) {
            y0.a(this.f273104a, String.valueOf(r100.a()));
            JSONObject r101 = com.cmic.ida.sdk.auth.a.a(String.valueOf(r100.a()), r100.b());
            this.f273105b.a(String.valueOf(r100.a()), r100.b(), r101);
        }

        public a(e r100, g r101, h0 r102) {
            this.f273106c = r100;
            this.f273104a = r101;
            this.f273105b = r102;
        }
    }

    public static e a() {
        if (f273102b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f273102b != null) goto L9;
        f273102b = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f273102b;
    }

    private e() {
        this.f273103a = "log2.cmpassport.com:9443";
    }

    private String b() {
        return this.f273103a;
    }

    public void a(JSONObject r100, g r101, h0 r102) {
        t r103 = new t();
        t.a r104 = new t.a();
        t.b r105 = new t.b();
        r105.d(y0.a());
        r105.f(r0.a());
        r105.g(EventConstant.Value.AUTH_VERSION_2);
        r105.c(r101.a("appId", ""));
        r105.e(r105.b(""));
        r104.a(r100);
        r103.a(r104);
        r103.a(r105);
        a(new m("https://" + b() + "/log/logReport", r103, "POST", r101.b("traceId")), r102, r101);
    }

    private void a(m r100, h0 r101, g r102) {
        new h().a(r100, new a(this, r102, r101), r102);
    }
}
