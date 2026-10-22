package com.bytedance.sdk.account.impl;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.android.token.TTTokenMonitor;
import com.ss.android.token.TokenFactory;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile h0 f268998d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f268999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f269000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0 f269001c;

    public h0(j r100) {
        this.f268999a = r100;
    }

    public final void a(i0 r100) {
        if (r100 == null) goto L11;
        JSONObject r101 = new JSONObject();
        r101.put("logId", r100.f269006d);     // Catch: JSONException -> L6
        r101.put(SpeechEngineDefines.PARAMS_KEY_PROTOCOL_TYPE_INT, r100.f269004b);     // Catch: JSONException -> L6
        r101.put("is_login", this.f268999a.isLogin());     // Catch: JSONException -> L6
        r101.put("user_id", this.f268999a.getUserId());     // Catch: JSONException -> L6
        com.bytedance.sdk.account.monitor.a.a("passport_receive_frontier_message", r101);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final synchronized void b(String r100) {
        monitor-enter(this);
        i0 r101 = i0.a(r100);     // Catch: Throwable -> L32
        a(r101);     // Catch: Throwable -> L32
        if (this.f269000b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f268999a.isLogin() == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (r101 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        if (r101.f269007e == false) goto L18;
        monitor-exit(this);
        return;
    L18:
        com.ss.android.account.k.d().d();     // Catch: Throwable -> L32
        if (r101.f269005c == this.f268999a.getUserId()) goto L23;
        monitor-exit(this);
        return;
    L23:
        this.f269001c = r101;     // Catch: Throwable -> L32
        if (com.ss.android.token.p.f449778b == false) goto L29;
        TokenFactory r102 = TokenFactory.j();     // Catch: Throwable -> L32
        if (TokenFactory.F == true) goto L28;
        r102.getClass();     // Catch: Throwable -> L32
        goto L29
    L28:
        r102.f449670j.removeMessages(1000);     // Catch: Throwable -> L32
    L29:
        this.f269000b = true;     // Catch: Throwable -> L32
        boolean r103 = com.ss.android.token.p.f449777a;     // Catch: Throwable -> L32
        String r104 = TokenFactory.j().n(false, "frontier");     // Catch: Throwable -> L32
        g0 r105 = new g0(this, r104);     // Catch: Throwable -> L32
        rb7.l.p(this.f268999a.L0, r104, r105).m();     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L32:
        th = move-exception;
        throw th;
    }

    public final void c(boolean r100, String r101, List<com.ss.android.token.o> r102) {
        if (r100 == true) goto L5;
        this.f269001c = null;
    L25:
        if (com.ss.android.token.p.f449778b == false) goto L30;
        TokenFactory r103 = TokenFactory.j();
        if (TokenFactory.F == true) goto L29;
        r103.getClass();
        goto L30
    L29:
        r103.f449670j.sendEmptyMessageDelayed(1000, r103.f449668h.f449773g);
    L30:
        this.f269000b = false;
        return;
    L5:
        if (com.ss.android.token.p.f449778b == false) goto L25;
        TokenFactory r104 = TokenFactory.j();
        r104.getClass();
        TTTokenMonitor.j(r101, r102, true);
        if (TokenFactory.F == false) goto L25;
        if (r104.f449675o.a() == null) goto L25;
        if (r104.f449675o.a().isLogin() == false) goto L25;
        r104.f449664d.getClass();
        String r105 = com.ss.android.token.r.d();
        r104.g();
        TTTokenMonitor.b("session_drop", r105);
        if (f268998d == null) goto L18;
        i0 r106 = f268998d.f269001c;
        if (r106 == null) goto L18;
    L20:
        if (r104.f449675o.a() == null) goto L22;
        Long r107 = Long.valueOf(r104.f449675o.a().getUserId());
        r104.f449675o.a().a(true);
        TTTokenMonitor.o(r107, 0L, TTTokenMonitor.a(r101), "session_drop");
    L22:
        com.ss.android.token.d r108 = new com.ss.android.token.d("frontier");
        r108.f449723a = r106;
        g.a().c("frontier", null, r108, null);
    L18:
        r106 = null;
        goto L20
    }
}
