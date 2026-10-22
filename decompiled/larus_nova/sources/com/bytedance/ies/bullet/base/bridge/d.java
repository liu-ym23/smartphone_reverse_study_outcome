package com.bytedance.ies.bullet.base.bridge;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements com.bytedance.sdk.xbridge.cn.auth.o {
    public d() {
    }

    public static w26.b c() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        w26.b r103 = r102.t();
        if (r103 == null) goto L9;
        return r103;
    L9:
        return new w26.b();
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.o
    public final boolean a() {
        return c().b();
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.o
    public final List<String> b() {
        return c().a();
    }
}
