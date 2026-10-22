package com.ss.android.ainote;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class l0 implements z7b.a {
    public l0() {
    }

    @Override // z7b.a
    public final int a() {
        return 2;
    }

    @Override // z7b.a
    public final char b() {
        return '~';
    }

    @Override // z7b.a
    public final char c() {
        return '~';
    }

    @Override // z7b.a
    public final int d(com.ss.android.lark.commonmark.internal.f r100, com.ss.android.lark.commonmark.internal.f r101) {
        if (r100.c() >= 2) goto L5;
    L17:
        return 0;
    L5:
        if (r101.c() < 2) goto L17;
        v7b.z r102 = new v7b.z();
        v7b.y r103 = new v7b.y();
        r103.b(r100.b(2));
        List<v7b.b0> r104 = r100.f417195a;
        v7b.b0 r105 = (v7b.b0) ListProtector.get(r104, r104.size() - 1);
        v7b.t r106 = new v7b.t(r105.f553572h, (v7b.b0) ListProtector.get(r101.f417195a, 0));
    L9:
        if (r106.hasNext() == false) goto L11;
        v7b.s r107 = (v7b.s) r106.next();
        r102.e(r107);
        r103.a(r107.j());
        goto L9
    L11:
        r103.b(r101.a(2));
        List<v7b.x> r108 = r103.f553581a;
        if (r108 != null) goto L15;
        r108 = Collections.emptyList();
    L15:
        r102.n(r108);
        r105.k(r102);
        return 2;
    }
}
