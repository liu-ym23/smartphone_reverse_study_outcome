package t7b;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.ss.android.lark.commonmark.internal.n;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.text.Typography;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import v7b.b0;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements x7b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a8b.a f544970a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a8b.a f544971b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a8b.a f544972c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a8b.a f544973d = null;

    public static class a implements x7b.b {
        public a() {
        }

        @Override // x7b.b
        public final Set<Character> a() {
            Object[] r100 = {Character.valueOf(Typography.amp)};
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
            return new f();
        }
    }

    public f() {
    }

    static {
        a8b.a.C0027a r100 = a8b.a.a();
        r100.b('0', '9');
        r100.b('A', 'F');
        r100.b('a', 'f');
        f544970a = new a8b.a(r100);
        a8b.a.C0027a r101 = a8b.a.a();
        r101.b('0', '9');
        f544971b = new a8b.a(r101);
        a8b.a.C0027a r102 = a8b.a.a();
        r102.b('A', Matrix.MATRIX_TYPE_ZERO);
        r102.b('a', 'z');
        a8b.a r103 = new a8b.a(r102);
        f544972c = r103;
        a8b.a.C0027a r104 = r103.b();
        r104.b('0', '9');
        f544973d = new a8b.a(r104);
    }

    @Override // x7b.a
    public final h a(x7b.c r100) {
        x7b.e r101 = ((n) r100).f417248f;
        x7b.d r102 = r101.k();
        r101.g();
        char r103 = r101.j();
        if (r103 != '#') goto L26;
        r101.g();
        if (r101.h(Permission.EXECUTE) == false) goto L7;
    L17:
        int r104 = r101.e(f544970a);
        if (1 <= r104) goto L20;
        return null;
    L20:
        if (r104 <= 6) goto L22;
        return null;
    L22:
        if (r101.h(';') == true) goto L24;
        return null;
    L24:
        return b(r101, r102);
    L7:
        if (r101.h('X') == true) goto L17;
        int r105 = r101.e(f544971b);
        if (1 <= r105) goto L12;
        return null;
    L12:
        if (r105 <= 7) goto L14;
        return null;
    L14:
        if (r101.h(';') == true) goto L16;
        return null;
    L16:
        return b(r101, r102);
    L26:
        if (f544972c.f2208a.get(r103) == false) goto L38;
        r101.e(f544973d);
        if (r101.h(';') == true) goto L30;
        return null;
    L30:
        return b(r101, r102);
    L38:
        return null;
    }

    public static h b(x7b.e r100, x7b.d r101) {
        return new h(new b0(u7b.b.a(r100.c(r101, r100.k()).a())), r100.k());
    }
}
