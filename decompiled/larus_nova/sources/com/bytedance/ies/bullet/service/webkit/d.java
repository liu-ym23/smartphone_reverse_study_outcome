package com.bytedance.ies.bullet.service.webkit;

import android.app.Application;
import android.content.Context;
import b36.f;
import b36.h;
import b36.i;
import b36.p;
import b36.s;
import com.bytedance.ies.bullet.kit.web.WebKitView;
import com.bytedance.ies.bullet.kit.web.impl.l;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.m;
import com.bytedance.ies.bullet.service.base.o;
import com.ivy.ivykit.plugin.impl.applet.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import iq7.g;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import q26.j;

/* JADX INFO: loaded from: classes19.dex */
public class d extends s26.a implements b36.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f248158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f248159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f248160d;

    public static final class a extends g.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f248161a;

        public a(d r100) {
            this.f248161a = r100;
        }

        @Override // iq7.g.d
        public final void a(g.a r100) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            i r101 = (i) this.f248161a.F0(i.class);
            if (r101 == null) goto L6;
            r101.I();
            return;
        }
    }

    public d() {
        this(null, 3);
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final boolean i0() {
        return this.f248159c.get();
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final m P() {
        return this.f248160d;
    }

    public h G0(s r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return new WebViewDelegate(this, r100);
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final o H(j r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new WebKitView(r100, this);
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final void u(j r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Application r101 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
        if (r101 == null) goto L6;
        H0(r101, this.f248160d);
        return;
    }

    public d(m r100, c r101) {
        this.f248158b = r101;
        this.f248159c = new AtomicBoolean(false);
        if (r100 != null) goto L5;
        r100 = new l();
    L5:
        this.f248160d = r100;
    }

    public final void H0(Context r100, m r101) {
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.j("initWebX: " + r100 + ", " + r101, LogLevel.I, "XWebKit");
        if (this.f248159c.get() == true) goto L21;
        this.f248159c.set(true);
        if (g.f495391g != null) goto L8;
        g.f495391g = r100.getApplicationContext();
        g.f495392h = new g.b();
    L8:
        g.b("webx_webkit", qq7.c.class, new a(this));
        i r103 = (i) F0(i.class);
        if (r103 == null) goto L12;
        r103.g();
    L12:
        if ((r101 instanceof b36.o) == true) goto L15;
        r101 = null;
    L15:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.web.WebKitServiceConfig");
        p r104 = ((b36.o) r101).f17190a;
        if (r104 == null) goto L22;
        Map<String, Map<Class<?>, Object>> r105 = x26.a.f562251a;
        f r106 = (f) x26.a.a(f.class);
        if (r106 == null) goto L23;
        r106.M(r100, r104);
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // b36.d
    public final o c(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new WebKitView(r101, this, r100);
    }

    @Override // b36.d
    public final void x0(Context r100, b36.o r101) {
        Intrinsics.checkNotNullParameter(r100, "application");
        m r102 = r101;
        if (r101 != null) goto L6;
        r102 = this.f248160d;
    L6:
        H0(r100, r102);
    }

    public /* synthetic */ d(e r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = null;
    L5:
        this(null, r100);
    }
}
