package t7b;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.commonmark.internal.n;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import v7b.b0;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements x7b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f544968a = null;

    public static class a implements x7b.b {
        public a() {
        }

        @Override // x7b.b
        public final Set<Character> a() {
            HashSet r100 = new HashSet(1);
            Object r101 = new Object[]{'\\'}[0];
            Objects.requireNonNull(r101);
            if (r100.add(r101) == false) goto L7;
            return Collections.unmodifiableSet(r100);
        L7:
            throw new IllegalArgumentException("duplicate element: " + r101);
        }

        @Override // x7b.b
        public final x7b.a create() {
            return new c();
        }
    }

    public c() {
    }

    static {
        f544968a = PatternProtector.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
    }

    @Override // x7b.a
    public final h a(x7b.c r100) {
        x7b.e r101 = ((n) r100).f417248f;
        r101.g();
        char r102 = r101.j();
        if (r102 != '\n') goto L7;
        r101.g();
        return new h(new v7b.h(), r101.k());
    L7:
        if (f544968a.matcher(String.valueOf(r102)).matches() == false) goto L11;
        r101.g();
        return new h(new b0(String.valueOf(r102)), r101.k());
    L11:
        return new h(new b0("\\"), r101.k());
    }
}
