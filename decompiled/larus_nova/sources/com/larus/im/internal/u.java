package com.larus.im.internal;

import com.larus.im.internal.delegate.y0;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import ouc.d0;

/* JADX INFO: loaded from: classes4.dex */
public final class u implements hd9.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f350517a = null;

    static {
        f350517a = new u();
    }

    public u() {
    }

    @Override // hd9.q
    public final boolean e() {
        return true;
    }

    @Override // hd9.q
    public final String a() {
        y0.r r100 = y0.f348465g;
        if (r100 != null) goto L13;
        r100 = new y0.r(0);
        d0 r101 = y0.i().e("database_settings", new d0(MapsKt.emptyMap()), true);     // Catch: Throwable -> L10
        wt7.c r102 = wt7.a.f561230a;     // Catch: Throwable -> L10
        String r103 = r101.toString();     // Catch: Throwable -> L10
        juc.d<y0.r> r104 = y0.r.Companion.serializer();     // Catch: Throwable -> L10
        r102.getClass();     // Catch: Throwable -> L10
        y0.r r105 = (y0.r) wt7.c.a(r103, r104);     // Catch: Throwable -> L10
        y0.f348465g = r105;     // Catch: Throwable -> L10
        if (r105 == null) goto L13;
        r100 = r105;
    L10:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("FlowSettingsDelegate", "getOmniDatabaseSettings(): err=" + th.getMessage());
    L13:
        return r100.f348601b;
    }

    @Override // hd9.q
    public final long c() {
        Lazy r100 = y0.f348459a;
        return ((Number) y0.f348471m.getValue()).longValue();
    }

    @Override // hd9.q
    public final boolean b() {
        return y0.d().F;
    }

    @Override // hd9.q
    public final int d() {
        return y0.d().f348541g;
    }

    @Override // hd9.q
    public final boolean f() {
        return y0.d().G;
    }
}
