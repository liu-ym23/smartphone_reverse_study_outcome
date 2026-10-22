package t7b;

import com.ss.android.lark.commonmark.internal.n;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import v7b.b0;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements x7b.a {

    public static class a implements x7b.b {
        public a() {
        }

        @Override // x7b.b
        public final Set<Character> a() {
            HashSet r100 = new HashSet(1);
            Object r101 = new Object[]{'`'}[0];
            Objects.requireNonNull(r101);
            if (r100.add(r101) == false) goto L7;
            return Collections.unmodifiableSet(r100);
        L7:
            throw new IllegalArgumentException("duplicate element: " + r101);
        }

        @Override // x7b.b
        public final x7b.a create() {
            return new d();
        }
    }

    public d() {
    }

    @Override // x7b.a
    public final h a(x7b.c r100) {
        x7b.e r101 = ((n) r100).f417248f;
        x7b.d r102 = r101.k();
        int r103 = r101.f('`');
        x7b.d r104 = r101.k();
    L4:
        if (r101.b('`') <= 0) goto L27;
        x7b.d r105 = r101.k();
        if (r101.f('`') != r103) goto L4;
        v7b.d r106 = new v7b.d();
        String r107 = r101.c(r104, r105).a().replace('\n', ' ');
        if (r107.length() < 3) goto L24;
        boolean r108 = false;
        if (r107.charAt(0) != ' ') goto L24;
        if (r107.charAt(r107.length() - 1) != ' ') goto L24;
        int r109 = r107.length();
        int r110 = 0;
    L14:
        if (r110 >= r109) goto L19;
        if (r107.charAt(r110) != ' ') goto L20;
        r110 = r110 + 1;
    L20:
        if (r110 == r109) goto L22;
        r108 = true;
    L22:
        if (r108 == false) goto L24;
        r107 = r107.substring(1, r107.length() - 1);
        goto L24
    L19:
        r110 = r109;
    L24:
        r106.f553550j = r107;
        return new h(r106, r101.k());
    L27:
        return new h(new b0(r101.c(r102, r104).a()), r104);
    }
}
