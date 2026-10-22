package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.core.n;
import io.ktor.utils.io.core.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f492033a = null;

    static {
        f492033a = new byte[0];
    }

    public static final void a(n r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "current");
        if (r101 != r100) goto L5;
        return;
    L5:
        int r102 = r101.f492022c;
        int r103 = r101.f492021b;
        if (r102 <= r103) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L12;
        r100.e(r101);
        return;
    L12:
        if ((r101.f492025f - r101.f492024e) >= 8) goto L23;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "current");
        a r105 = r101.i();
        if (r105 != null) goto L16;
        r100.h(r101);
        return;
    L16:
        int r106 = r101.f492022c - r101.f492021b;
        int r107 = Math.min(r106, 8 - (r101.f492025f - r101.f492024e));
        if (r105.f492023d >= r107) goto L19;
        r100.h(r101);
        return;
    L19:
        Intrinsics.checkNotNullParameter(r105, "<this>");
        r105.d(r105.f492021b - r107);
        if (r106 <= r107) goto L22;
        r101.f492024e = r101.f492025f;
        r100.f492041e = r101.f492022c;
        r100.t(r100.f492042f + ((long) r107));
        return;
    L22:
        r100.u(r105);
        r100.t(r100.f492042f - ((long) ((r105.f492022c - r105.f492021b) - r107)));
        r101.g();
        r101.k(r100.f492037a);
        return;
    L23:
        r100.f492040d = r103;
        return;
    L8:
        r104 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final a b(n r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "current");
        if (r101 == r100) goto L5;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "current");
        return r100.e(r101);
    L5:
        if (r100.f492040d == r100.f492041e) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L17;
        return null;
    L17:
        return (a) r100;
    L7:
        if (r100.f492042f != 0) goto L10;
        r102 = false;
        goto L11
    }

    public static final a c(q r100, int r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 == null) goto L6;
        r100.a();
    L6:
        return r100.j(r101);
    }
}
