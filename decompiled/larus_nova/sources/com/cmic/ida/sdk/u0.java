package com.cmic.ida.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cmic.ida.sdk.auth.GetScriptListener;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class u0 implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f273246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f273247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f273248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f273249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g f273250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GetScriptListener f273251f;

    public class a extends q0.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f273252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u0 f273253c;

        @Override // com.cmic.ida.sdk.q0.a
        public void a() {
            new m0().a(u0.a(this.f273253c), String.valueOf(this.f273252b), u0.b(this.f273253c));
        }

        public a(u0 r100, int r101) {
            this.f273253c = r100;
            this.f273252b = r101;
        }
    }

    public static /* synthetic */ void c(u0 r100) {
        r100.a();
    }

    public static /* synthetic */ void d(u0 r100, int r101, String r102, g r103) {
        r100.a(r101, r102, r103);
    }

    private /* synthetic */ void a() {
        a(new g(64), 200025, "登录超时");
    }

    public void b() {
        this.f273246a.postDelayed(new j1(this), this.f273247b);
    }

    public static /* synthetic */ Context a(u0 r100) {
        return r100.f273248c;
    }

    public static /* synthetic */ g b(u0 r100) {
        return r100.f273250e;
    }

    public void a(GetScriptListener r100) {
        this.f273251f = r100;
    }

    public u0(Context r100, int r101, g r102) {
        this.f273249d = false;
        this.f273248c = r100;
        this.f273246a = new Handler(r100.getMainLooper());
        this.f273247b = r101;
        this.f273250e = r102;
    }

    private /* synthetic */ void a(int r110, String r111, g r210) {
        if (r110 != 200) goto L5;
    L27:
        String r100 = r111;
    L29:
        if (r210 != null) goto L63;
    L33:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L60
        String r102 = r210.a("operType", "");     // Catch: Exception -> L60
        u.b("ResponseListenerWrapper", f0.b(r210.b("scripKey")) + "lyy");     // Catch: Exception -> L60
        if (r102.equals("2") == false) goto L37;
    L47:
        u.b("ResponseListenerWrapper", "异网取号结果");     // Catch: Exception -> L60
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L60
        r103.put("data", r100);     // Catch: Exception -> L60
        r103.put("traceId", this.f273250e.b("traceId"));     // Catch: Exception -> L60
        r103.put("resultCode", r110);     // Catch: Exception -> L60
        r103.put(SocialConstants.PARAM_APP_DESC, "成功");     // Catch: Exception -> L60
        r103.put("preGmType", "1");     // Catch: Exception -> L60
        if (r100.contains("103000") == false) goto L50;
    L54:
        r101.put("data", r103);     // Catch: Exception -> L60
    L55:
        r101.put("networktype", this.f273250e.a("networktype") + "");     // Catch: Exception -> L60
        JSONObject r104 = r101;
    L57:
        if (this.f273251f == null) goto L65;
        u.a("ResponseListenerWrapper", "callback listener");     // Catch: Exception -> L60
        this.f273251f.onGetScriptComplete(r104.toString());     // Catch: Exception -> L60
        return;
    L60:
        e = move-exception;
        e.printStackTrace();
        this.f273250e.a().A.add(e);
        return;
    L65:
        return;
    L50:
        if (r210.a("isReturnOaId", false) == false) goto L54;
        if (f0.b(r210.b("scripKey")) != 1) goto L54;
        u.a("isReturnOaId", r210.a("isReturnOaId", false) + n0.a("oaid", ""));     // Catch: Exception -> L60
        r103.put("oaid", n0.a("oaid", ""));     // Catch: Exception -> L60
        goto L54
    L37:
        if (r102.equals("3") == true) goto L47;
        u.b("ResponseListenerWrapper", "本网取号结果");     // Catch: Exception -> L60
        JSONObject r105 = new JSONObject(r100);     // Catch: Exception -> L60
        if (r100.contains("103000") == false) goto L42;
    L46:
        r105.put("preGmType", "1");     // Catch: Exception -> L60
        r101.put("data", r105);     // Catch: Exception -> L60
        goto L55
    L42:
        if (r210.a("isReturnOaId", false) == false) goto L46;
        if (f0.b(r210.b("scripKey")) != 1) goto L46;
        u.a("isReturnOaId", r210.a("isReturnOaId", false) + n0.a("oaid", ""));     // Catch: Exception -> L60
        r105.put("oaid", n0.a("oaid", ""));     // Catch: Exception -> L60
        goto L46
    L63:
        if (TextUtils.isEmpty(r210.a("funcType", "")) == true) goto L33;
        u.a("ResponseListenerWrapper", "funcType=" + r210.a("funcType", ""));     // Catch: Exception -> L60
        r104 = new JSONObject(r100);     // Catch: Exception -> L60
        goto L57
    L5:
        if (r110 != 102508) goto L7;
        String r106 = r110 + "";
        if (TextUtils.isEmpty(r111) == false) goto L25;
        String r112 = "数据网络切换失败";
    L26:
        r100 = com.cmic.ida.sdk.auth.a.a(r106, r112).toString();
        goto L29
    L25:
        r112 = r111;
        goto L26
    L7:
        if (r110 != 200010) goto L9;
        String r107 = r110 + "";
        if (TextUtils.isEmpty(r111) == false) goto L20;
        String r113 = "无法识别sim卡或没有sim卡";
    L21:
        r100 = com.cmic.ida.sdk.auth.a.a(r107, r113).toString();
        goto L29
    L20:
        r113 = r111;
        goto L21
    L9:
        if (r110 == 301) goto L27;
        if (r110 == 302) goto L27;
        String r108 = r110 + "";
        if (TextUtils.isEmpty(r111) == false) goto L15;
        String r114 = "网络异常";
    L16:
        r100 = com.cmic.ida.sdk.auth.a.a(r108, r114).toString();
        goto L29
    L15:
        r114 = r111;
        goto L16
    }

    @Override // com.cmic.ida.sdk.j0
    public void a(final g r100, final int r101, final String r102) {
        u.a("ResponseListenerWrapper", "onResponse code=" + r101);
        u.a("ResponseListenerWrapper", "onResponse body=" + r102);
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f273249d == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L8:
        this.f273249d = true;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        this.f273246a.removeCallbacksAndMessages(null);
        this.f273250e.b("systemEndTime", SystemClock.elapsedRealtime());
        this.f273250e.b("endtime", r0.a());
        this.f273246a.post(new k1(this, r101, r102, r100));
        q0.a(new a(this, r101));
    }
}
