package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class l0 {
    public static final Url a(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        g0 r101 = new g0(null);
        c(r101, r100);
        return r101.b();
    }

    public static final Url b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "urlString");
        Intrinsics.checkNotNullParameter(r100, "urlString");
        return i0.b(new g0(null), r100).b();
    }

    public static final void c(g0 r100, g0 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "url");
        r100.f(r101.f491862a);
        r100.e(r101.f491863b);
        r100.f491864c = r101.f491864c;
        r100.d(r101.f491869h);
        r100.f491866e = r101.f491866e;
        r100.f491867f = r101.f491867f;
        b0 r102 = d0.a();
        io.ktor.util.s.a(r102, r101.f491870i);
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.f491870i = r102;
        r100.f491871j = new m0(r102);
        String r103 = r101.f491868g;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r100.f491868g = r103;
        r100.f491865d = r101.f491865d;
    }
}
