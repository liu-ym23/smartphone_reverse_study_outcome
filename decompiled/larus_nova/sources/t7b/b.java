package t7b;

import androidx.core.net.MailTo;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.commonmark.internal.n;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import v7b.b0;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements x7b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f544966a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f544967b = null;

    public static class a implements x7b.b {
        public a() {
        }

        @Override // x7b.b
        public final Set<Character> a() {
            Object[] r100 = {Character.valueOf(Typography.less)};
            HashSet r101 = new HashSet(1);
            Object r102 = r100[0];
            Objects.requireNonNull(r102);
            if (r101.add(r102) == false) goto L7;
            return Collections.unmodifiableSet(r101);
        L7:
            throw new IllegalArgumentException("duplicate element: " + r102);
        }

        @Override // x7b.b
        public final x7b.a create() {
            return new b();
        }
    }

    public b() {
    }

    static {
        f544966a = PatternProtector.compile("^[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*$");
        f544967b = PatternProtector.compile("^([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)$");
    }

    @Override // x7b.a
    public final h a(x7b.c r100) {
        x7b.e r101 = ((n) r100).f417248f;
        r101.g();
        x7b.d r102 = r101.k();
        if (r101.b(Typography.greater) <= 0) goto L14;
        w7b.g r103 = r101.c(r102, r101.k());
        String r104 = r103.a();
        r101.g();
        if (f544966a.matcher(r104).matches() == false) goto L8;
        String r105 = r104;
    L11:
        if (r105 == null) goto L14;
        v7b.n r106 = new v7b.n(r105, null);
        b0 r107 = new b0(r104);
        r107.n(r103.b());
        r106.e(r107);
        return new h(r106, r101.k());
    L8:
        if (f544967b.matcher(r104).matches() == false) goto L10;
        r105 = MailTo.MAILTO_SCHEME + r104;
        goto L11
    L10:
        r105 = null;
    L14:
        return null;
    }
}
