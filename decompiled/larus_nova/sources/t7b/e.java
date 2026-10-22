package t7b;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.List;
import v7b.a0;
import v7b.b0;
import v7b.s;
import v7b.t;
import v7b.x;
import v7b.y;

/* JADX INFO: loaded from: classes35.dex */
public abstract class e implements z7b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f544969a;

    @Override // z7b.a
    public final int a() {
        return 1;
    }

    @Override // z7b.a
    public final char b() {
        return this.f544969a;
    }

    @Override // z7b.a
    public final char c() {
        return this.f544969a;
    }

    public e(char r100) {
        this.f544969a = r100;
    }

    @Override // z7b.a
    public final int d(com.ss.android.lark.commonmark.internal.f r100, com.ss.android.lark.commonmark.internal.f r101) {
        if (r100.f417199e == false) goto L5;
    L6:
        int r102 = r101.f417197c;
        if ((r102 % 3) != 0) goto L9;
    L11:
        int r103 = 2;
        if (r100.c() >= 2) goto L14;
    L16:
        s r104 = new v7b.f(String.valueOf(this.f544969a));
        r103 = 1;
    L17:
        y r105 = new y();
        r105.b(r100.b(r103));
        List<b0> r106 = r100.f417195a;
        b0 r107 = (b0) ListProtector.get(r106, r106.size() - 1);
        t r108 = new t(r107.f553572h, (b0) ListProtector.get(r101.f417195a, 0));
    L19:
        if (r108.hasNext() == false) goto L21;
        s r109 = (s) r108.next();
        r104.e(r109);
        r105.a(r109.j());
        goto L19
    L21:
        r105.b(r101.a(r103));
        List<x> r110 = r105.f553581a;
        if (r110 != null) goto L25;
        r110 = Collections.emptyList();
    L25:
        r104.n(r110);
        r107.k(r104);
        return r103;
    L14:
        if (r101.c() < 2) goto L16;
        r104 = new a0(String.valueOf(this.f544969a) + this.f544969a);
        goto L17
    L9:
        if (((r100.f417197c + r102) % 3) != 0) goto L11;
        return 0;
    L5:
        if (r101.f417198d == false) goto L11;
        goto L6
    }
}
