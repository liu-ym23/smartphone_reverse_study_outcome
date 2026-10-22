package com.bytedance.crash.monitor;

import android.text.TextUtils;
import com.bytedance.crash.i;
import com.bytedance.crash.m0;
import com.bytedance.mira.log.MiraMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import wh4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class d extends f {
    public static final ArrayList<d> o = null;
    public final CacheManager m;
    public c n;

    static {
        o = new ArrayList();
    }

    @Override // com.bytedance.crash.monitor.f
    public String a() {
        if (this.d == null) goto L6;
        return this.d;
    L6:
        return this.m.b(0);
    }

    @Override // com.bytedance.crash.monitor.f
    public String b() {
        if (this.g != null) goto L7;
        CacheManager r0 = this.m;
        return r0.c(".chn").getBefore(r0.a, ".chn", 0);
    L7:
        return this.g;
    }

    @Override // com.bytedance.crash.monitor.f
    public long g() {
        if (this.e == 0) goto L6;
        return this.e;
    L6:
        return this.m.g(0);
    }

    @Override // com.bytedance.crash.monitor.f
    public c h() {
        c r0 = this.n;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.h != null) goto L8;
    L10:
        CacheManager r1 = this.m;
        if (r1.f != null) goto L13;
        r1.f = CacheManager.CachedVersion.getCurrent(r1.a);
    L13:
        c r2 = r1.f.getBefore(r1.a, 0);
        if (r2 != null) goto L16;
        r2 = new c(0, 0, 0, MiraMonitor.VALUE_DEFAULT);
    L16:
        this.n = r2;
    L18:
        return this.n;
    L8:
        if (this.i == 0) goto L10;
        this.n = new c(this.i, this.k, this.j, this.h);
        goto L18
    }

    @Override // com.bytedance.crash.monitor.f
    public long f() {
        return h().b;
    }

    @Override // com.bytedance.crash.monitor.f
    public long i() {
        return h().a;
    }

    @Override // com.bytedance.crash.monitor.f
    public String j() {
        return h().d;
    }

    public long m() {
        return h().c;
    }

    public d(m0 r2) {
        super(r2);
        o.add(this);
        this.m = new CacheManager(i.d());
    }

    @Override // com.bytedance.crash.monitor.f
    public String d(String r4) {
        if (TextUtils.isEmpty(this.f) == false) goto L5;
        String r0 = this.m.e(0);
        if (TextUtils.isEmpty(r0) == false) goto L9;
        return r4;
    L9:
        return r0;
    L5:
        return this.f;
    }

    public final String l(long r4) {
        CacheManager r0 = this.m;
        return r0.c(".chn").getBefore(r0.a, ".chn", r4);
    }

    public final c n(long r3) {
        CacheManager r0 = this.m;
        if (r0.f != null) goto L6;
        r0.f = CacheManager.CachedVersion.getCurrent(r0.a);
    L6:
        return r0.f.getBefore(r0.a, r3);
    }

    public final void o(String r4) {
        this.g = r4;
        CacheManager r0 = this.m;
        r0.c(".chn").update(r0.a, ".chn", r4);
    }

    public final void p(String r4) {
        this.f = r4;
        CacheManager r0 = this.m;
        r0.c(".did").update(r0.a, ".did", r4);
    }

    public final void q(long r4) {
        this.e = r4;
        CacheManager r0 = this.m;
        r0.c(".uid").update(r0.a, ".uid", String.valueOf(r4));
    }

    public d(String r17, String r18, long r19) {
        super(r17, r18, r19, 0);
        o.add(this);
        CacheManager r0 = new CacheManager(i.d(), r17);
        this.m = r0;
        b r1 = b.f;
        if (ThreadMethodProxy.currentThread() != b.d()) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r0.h(r17);
        r0.i(r19, 0, 0, r18);
        return;
    L8:
        b.post(new b(this, r17, r19, r18));
        return;
    L5:
        r2 = false;
        goto L6
    }

    public d(m0 r18, String r19, String r20, long r21) {
        super(r18, r19, r20, r21, 0);
        o.add(this);
        CacheManager r0 = new CacheManager(i.d(), r19);
        this.m = r0;
        b r1 = b.f;
        if (ThreadMethodProxy.currentThread() != b.d()) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r0.h(r19);
        r0.i(r21, 0, 0, r20);
        return;
    L8:
        b.post(new a(this, r19, r21, r20));
        return;
    L5:
        r2 = false;
        goto L6
    }
}
