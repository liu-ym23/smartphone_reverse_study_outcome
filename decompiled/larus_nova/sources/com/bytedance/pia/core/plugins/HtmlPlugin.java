package com.bytedance.pia.core.plugins;

import android.net.Uri;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.metrics.TraceEvent;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.j;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import o47.d;
import o47.f;
import q47.e;
import r47.b;
import s47.l;
import s47.n;

/* JADX INFO: loaded from: classes21.dex */
public class HtmlPlugin extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f266251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile e f266252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f266253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f266254f;

    @Override // s47.l
    public final String a() {
        return "html";
    }

    @Override // s47.l
    public final void b() {
        ThreadUtil.c(new b(this));
    }

    @Override // s47.l, l47.c
    public final void release() {
        this.f266251c.countDown();
    }

    public HtmlPlugin(n r100) {
        super(r100);
        this.f266251c = new CountDownLatch(1);
        this.f266253e = null;
        this.f266254f = false;
    }

    @Override // s47.l
    public final i47.e d(i47.d r100) {
        String r101 = j.g(r100.getUrl(), null);
        if (r101 != null) goto L5;
    L56:
        return null;
    L5:
        if (r101.equals(this.f540648b.f17560i) == false) goto L56;
        if (r100.isForMainFrame() == false) goto L56;
        boolean r102 = true;
        if (this.f266252d == null) goto L11;
        this.f540648b.f17573v.f266332n = 0;
    L57:
        com.bytedance.pia.core.utils.d.i("[HTML] Start intercepting main document.");     // Catch: Throwable -> L28
        com.bytedance.pia.core.tracing.d.a r103 = this.f540648b.f17572u.a(EventName.ResourceInterceptStart);     // Catch: Throwable -> L28
        r103.args.put("url", r100.getUrl());     // Catch: Throwable -> L28
        r103.a();     // Catch: Throwable -> L28
        Lazy<Settings> r104 = Settings.f266286f;     // Catch: Throwable -> L28
        this.f266251c.await(Settings.a.a().h(), TimeUnit.SECONDS);     // Catch: Throwable -> L28
        com.bytedance.pia.core.utils.d.i("[HTML] Finish waiting response.");     // Catch: Throwable -> L28
        d r105 = this.f266253e;     // Catch: Throwable -> L28
        if (r105 == null) goto L30;
        Boolean r106 = r105.f521972c.b();     // Catch: Throwable -> L28
        if (r106 == null) goto L30;
        if (r106.booleanValue() == true) goto L30;
        if (this.f266254f == true) goto L30;
        Uri r107 = this.f540648b.f17559h;     // Catch: Throwable -> L28
        d r108 = this.f266253e;     // Catch: Throwable -> L28
        Keva r109 = f.f521975a;     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r107, "uri");     // Catch: Throwable -> L28
        if (Settings.a.a().l() == false) goto L30;
        if (f.f521979e.get() == false) goto L30;
        f.g(r107, r108, true);     // Catch: Throwable -> L28
    L30:
        if (this.f266252d == null) goto L55;
        com.bytedance.pia.core.utils.d.j("[HTML] Finish intercepting main document. url: " + r100.getUrl().toString(), this.f540648b.f17557f);
        OnlineTracing r110 = this.f540648b.f17573v;
        Map<String, String> r111 = this.f266252d.f531662e;
        r110.getClass();
        if (r111 != null) goto L34;
    L36:
        r102 = false;
    L37:
        if (r102 == true) goto L39;
    L53:
        this.f540648b.f17573v.a("NTF");
        com.bytedance.pia.core.tracing.d.a r112 = this.f540648b.f17572u.a(EventName.ResourceInterceptEnd);
        r112.args.put("url", r100.getUrl());
        r112.a();
        return this.f266252d;
    L39:
        if (Intrinsics.areEqual(r111.get("x-pia-ssr-fallback"), "query") == false) goto L42;
        r110.f266331m = 11;
        goto L53
    L42:
        if (Intrinsics.areEqual(r111.get("x-pia-ssr-fallback"), "custom") == false) goto L45;
        r110.f266331m = 15;
        goto L53
    L45:
        if (Intrinsics.areEqual(r111.get("x-pia-ssr-fallback"), "header") == false) goto L48;
        r110.f266331m = 12;
        goto L53
    L48:
        if (Intrinsics.areEqual(r111.get("x-pia-ssr-fallback"), "error") == false) goto L51;
        r110.f266331m = 13;
        goto L53
    L51:
        if (Intrinsics.areEqual(r111.get("x-pia-ssr-fallback"), "middleware") == false) goto L53;
        r110.f266331m = 14;
        goto L53
    L34:
        if (r111.containsKey("x-pia-ssr-fallback") != true) goto L36;
    L55:
        this.f540648b.f17573v.f266328j = 6;
        goto L56
    L11:
        this.f540648b.f17573v.f266332n = 1;
        goto L57
    }

    public final void h(String r100, Throwable r101) {
        this.f266251c.countDown();
        this.f540648b.f17571t.a(TraceEvent.REQUEST_HTML_END, System.currentTimeMillis());
        this.f540648b.f17572u.a(EventName.HTMLResponseEnd).a();
        if (r101 == null) goto L6;
        String r102 = this.f540648b.f17557f;
        int r103 = com.bytedance.pia.core.utils.d.f266396a;
        Intrinsics.checkNotNullParameter("[Manifest] Request Manifest Error:", "message");
        com.bytedance.pia.core.utils.d.f("[Manifest] Request Manifest Error:", r101, r102, 8);
    L6:
        if (r100 == null) goto L8;
        this.f540648b.l("event-on-html-ready", new Object[]{r100});
        return;
    L8:
        this.f540648b.l("event-on-html-error", new Object[]{r101});
    }
}
