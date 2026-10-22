package com.bytedance.crash.monitor;

import com.bytedance.crash.i;
import com.bytedance.crash.m0;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class a extends d {
    public static final m0 p = null;

    @Override // com.bytedance.crash.monitor.f
    public Map<String, Object> c() {
        return null;
    }

    static {
        p = new m0();
    }

    public a() {
        super(p);
    }

    @Override // com.bytedance.crash.monitor.f
    public final fh4.f e() {
        fh4.f r0 = j.c();
        r0.d = this;
        return r0;
    }

    public final c r(long r3) {
        CacheManager r0 = this.m;
        if (r0.f != null) goto L6;
        r0.f = CacheManager.CachedVersion.getCurrent(r0.a);
    L6:
        return r0.f.getAfter(r0.a, r3);
    }

    public a(String r10, String r11, long r12) {
        super(p, r10, r11, r12);
        i.f(r12, 0, 0, r11);
    }
}
