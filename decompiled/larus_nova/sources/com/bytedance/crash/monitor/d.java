package com.bytedance.crash.monitor;

import android.text.TextUtils;
import com.bytedance.crash.m0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d extends f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ArrayList<d> f203274o = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CacheManager f203275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c f203276n;

    /* JADX INFO: loaded from: classes15.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f203277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f203278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f203279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f203280d;

        @Override // java.lang.Runnable
        public final void run() {
            this.f203280d.f203275m.h(this.f203277a);     // Catch: Throwable -> L4
            this.f203280d.f203275m.i(this.f203278b, 0, 0, this.f203279c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100, String r101, long r102, String r103) {
            this.f203280d = r100;
            this.f203277a = r101;
            this.f203278b = r102;
            this.f203279c = r103;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f203281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f203282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f203283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f203284d;

        @Override // java.lang.Runnable
        public final void run() {
            this.f203284d.f203275m.h(this.f203281a);     // Catch: Throwable -> L4
            this.f203284d.f203275m.i(this.f203282b, 0, 0, this.f203283c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(d r100, String r101, long r102, String r103) {
            this.f203284d = r100;
            this.f203281a = r101;
            this.f203282b = r102;
            this.f203283c = r103;
        }
    }

    static {
        f203274o = new ArrayList();
    }

    @Override // com.bytedance.crash.monitor.f
    public String a() {
        if (this.f203292d == null) goto L6;
        return this.f203292d;
    L6:
        return this.f203275m.b(0);
    }

    @Override // com.bytedance.crash.monitor.f
    public String b() {
        if (this.f203295g != null) goto L7;
        CacheManager r100 = this.f203275m;
        return r100.c(".chn").getBefore(r100.f203256a, ".chn", 0);
    L7:
        return this.f203295g;
    }

    @Override // com.bytedance.crash.monitor.f
    public long g() {
        if (this.f203293e == 0) goto L6;
        return this.f203293e;
    L6:
        return this.f203275m.g(0);
    }

    @Override // com.bytedance.crash.monitor.f
    public c h() {
        c r100 = this.f203276n;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.f203296h != null) goto L8;
    L10:
        CacheManager r101 = this.f203275m;
        if (r101.f203261f != null) goto L13;
        r101.f203261f = CacheManager.CachedVersion.getCurrent(r101.f203256a);
    L13:
        c r102 = r101.f203261f.getBefore(r101.f203256a, 0);
        if (r102 != null) goto L16;
        r102 = new c(0, 0, 0, "0");
    L16:
        this.f203276n = r102;
    L18:
        return this.f203276n;
    L8:
        if (this.f203297i == 0) goto L10;
        this.f203276n = new c(this.f203297i, this.f203299k, this.f203298j, this.f203296h);
        goto L18
    }

    @Override // com.bytedance.crash.monitor.f
    public long f() {
        return h().f203271b;
    }

    @Override // com.bytedance.crash.monitor.f
    public long i() {
        return h().f203270a;
    }

    @Override // com.bytedance.crash.monitor.f
    public String j() {
        return h().f203273d;
    }

    public long m() {
        return h().f203272c;
    }

    public d(m0 r100) {
        super(r100);
        f203274o.add(this);
        this.f203275m = new CacheManager(com.bytedance.crash.i.d());
    }

    @Override // com.bytedance.crash.monitor.f
    public String d(String r100) {
        if (TextUtils.isEmpty(this.f203294f) == false) goto L5;
        String r101 = this.f203275m.e(0);
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return r100;
    L9:
        return r101;
    L5:
        return this.f203294f;
    }

    public final String l(long r100) {
        CacheManager r101 = this.f203275m;
        return r101.c(".chn").getBefore(r101.f203256a, ".chn", r100);
    }

    public final c n(long r100) {
        CacheManager r101 = this.f203275m;
        if (r101.f203261f != null) goto L6;
        r101.f203261f = CacheManager.CachedVersion.getCurrent(r101.f203256a);
    L6:
        return r101.f203261f.getBefore(r101.f203256a, r100);
    }

    public final void o(String r100) {
        this.f203295g = r100;
        CacheManager r101 = this.f203275m;
        r101.c(".chn").update(r101.f203256a, ".chn", r100);
    }

    public final void p(String r100) {
        this.f203294f = r100;
        CacheManager r101 = this.f203275m;
        r101.c(".did").update(r101.f203256a, ".did", r100);
    }

    public final void q(long r100) {
        this.f203293e = r100;
        CacheManager r101 = this.f203275m;
        r101.c(".uid").update(r101.f203256a, ".uid", String.valueOf(r100));
    }

    public d(String r110, String r111, long r112) {
        super(r110, r111, r112, 0);
        f203274o.add(this);
        CacheManager r100 = new CacheManager(com.bytedance.crash.i.d(), r110);
        this.f203275m = r100;
        wh4.b r101 = wh4.b.f559649f;
        if (ThreadMethodProxy.currentThread() != wh4.b.d()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r100.h(r110);
        r100.i(r112, 0, 0, r111);
        return;
    L8:
        wh4.b.post(new b(this, r110, r112, r111));
        return;
    L5:
        r102 = false;
        goto L6
    }

    public d(m0 r110, String r111, String r210, long r211) {
        super(r110, r111, r210, r211, 0);
        f203274o.add(this);
        CacheManager r100 = new CacheManager(com.bytedance.crash.i.d(), r111);
        this.f203275m = r100;
        wh4.b r101 = wh4.b.f559649f;
        if (ThreadMethodProxy.currentThread() != wh4.b.d()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r100.h(r111);
        r100.i(r211, 0, 0, r210);
        return;
    L8:
        wh4.b.post(new a(this, r111, r211, r210));
        return;
    L5:
        r102 = false;
        goto L6
    }
}
