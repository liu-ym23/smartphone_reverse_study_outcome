package com.bytedance.crash.monitor;

import com.bytedance.crash.m0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final m0 f203264p = null;

    @Override // com.bytedance.crash.monitor.f
    public Map<String, Object> c() {
        return null;
    }

    static {
        f203264p = new m0();
    }

    public a() {
        super(f203264p);
    }

    @Override // com.bytedance.crash.monitor.f
    public final fh4.f e() {
        fh4.f r100 = j.c();
        r100.f477020d = this;
        return r100;
    }

    public final c r(long r100) {
        CacheManager r101 = this.f203275m;
        if (r101.f203261f != null) goto L6;
        r101.f203261f = CacheManager.CachedVersion.getCurrent(r101.f203256a);
    L6:
        return r101.f203261f.getAfter(r101.f203256a, r100);
    }

    public a(String r110, String r111, long r112) {
        super(f203264p, r110, r111, r112);
        com.bytedance.crash.i.f(r112, 0, 0, r111);
    }
}
