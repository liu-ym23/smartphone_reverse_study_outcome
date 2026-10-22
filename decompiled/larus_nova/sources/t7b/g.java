package t7b;

import com.ss.android.lark.commonmark.internal.n;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.text.Typography;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import v7b.k;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements x7b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a8b.a f544974a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a8b.a f544975b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a8b.a f544976c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a8b.a f544977d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a8b.a f544978e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a8b.a f544979f = null;

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
            return new g();
        }
    }

    public g() {
    }

    static {
        a8b.a.C0027a r100 = a8b.a.a();
        r100.b('A', Matrix.MATRIX_TYPE_ZERO);
        r100.b('a', 'z');
        a8b.a r101 = new a8b.a(r100);
        f544974a = r101;
        f544975b = r101;
        a8b.a.C0027a r102 = r101.b();
        r102.b('0', '9');
        r102.a('-');
        f544976c = new a8b.a(r102);
        a8b.a.C0027a r103 = r101.b();
        r103.a('_');
        r103.a(':');
        a8b.a r104 = new a8b.a(r103);
        f544977d = r104;
        a8b.a.C0027a r105 = r104.b();
        r105.b('0', '9');
        r105.a('.');
        r105.a('-');
        f544978e = new a8b.a(r105);
        a8b.a.C0027a r106 = a8b.a.a();
        r106.a(' ');
        r106.a('\t');
        r106.a('\n');
        r106.a(11);
        r106.a('\f');
        r106.a('\r');
        r106.a(Typography.quote);
        r106.a('\'');
        r106.a(com.alipay.sdk.m.n.a.f25612h);
        r106.a(Typography.less);
        r106.a(Typography.greater);
        r106.a('`');
        f544979f = new a8b.a(r106);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0099 -> B:40:0x009b). Please report as a decompilation issue!!! */
    @Override // x7b.a
    public final h a(x7b.c r110) {
        x7b.e r111 = ((n) r110).f417248f;
        x7b.d r100 = r111.k();
        r111.g();
        char r101 = r111.j();
        a8b.a r102 = f544975b;
        boolean r103 = false;
        if (r102.f2208a.get(r101) == false) goto L46;
        r111.g();
        r111.e(f544976c);
        if (r111.m() < 1) goto L7;
        x7b.d r104 = r100;
        x7b.e r105 = r111;
    L40:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L42;
        if (r111.e(f544977d) < 1) goto L42;
        r111.e(f544978e);
        if (r111.m() < 1) goto L15;
        r106 = true;
    L17:
        if (r111.h(com.alipay.sdk.m.n.a.f25612h) == false) goto L9;
        r111.m();
        char r107 = r111.j();
        if (r107 != '\'') goto L25;
        r111.g();
        if (r111.b('\'') < 0) goto L43;
        r111.g();
    L39:
        if (r111.m() >= 1) goto L40;
        r106 = false;
    L43:
        if (r103 == true) goto L45;
        return null;
    L45:
        return b(r104, r105);
    L25:
        if (r107 != '\"') goto L30;
        r111.g();
        if (r111.b(Typography.quote) < 0) goto L43;
        r111.g();
        goto L39
    L30:
        a8b.a r108 = f544979f;
        int r109 = 0;
    L31:
        char r112 = r111.j();
        if (r112 == 0) goto L33;
        if (r108.f2208a.get(r112) == true) goto L36;
        r109 = r109 + 1;
        r111.g();
    L36:
        if (r109 > 0) goto L39;
    L33:
        r109 = -1;
        goto L36
    L15:
        r106 = false;
    L42:
        r111.h('/');
        r103 = r111.h(Typography.greater);
        goto L43
    L7:
        r104 = r100;
        r105 = r111;
        r106 = false;
        goto L9
    L46:
        if (r101 != '/') goto L54;
        r111.g();
        if (r111.e(r102) < 1) goto L50;
        r111.e(f544976c);
        r111.m();
        r103 = r111.h(Typography.greater);
    L50:
        if (r103 == true) goto L52;
        return null;
    L52:
        return b(r100, r111);
    L54:
        if (r101 != '?') goto L65;
        r111.g();
    L57:
        if (r111.b('?') <= 0) goto L61;
        r111.g();
        if (r111.h(Typography.greater) == false) goto L57;
        r103 = true;
    L61:
        if (r103 == true) goto L63;
        return null;
    L63:
        return b(r100, r111);
    L65:
        if (r101 != '!') goto L135;
        r111.g();
        char r113 = r111.j();
        if (r113 != '-') goto L87;
        r111.g();
        if (r111.h('-') == true) goto L72;
    L83:
        if (r103 == true) goto L85;
        return null;
    L85:
        return b(r100, r111);
    L72:
        if (r111.h(Typography.greater) == false) goto L74;
    L82:
        r103 = true;
        goto L83
    L74:
        if (r111.i("->") == true) goto L82;
    L77:
        if (r111.b('-') < 0) goto L83;
        if (r111.i("-->") == true) goto L82;
        r111.g();
        goto L77
    L87:
        if (r113 != '[') goto L99;
        r111.g();
        if (r111.i("CDATA[") == true) goto L91;
    L96:
        if (r103 == true) goto L98;
        return null;
    L98:
        return b(r100, r111);
    L91:
        if (r111.b(']') < 0) goto L96;
        if (r111.i("]]>") == true) goto L94;
        r111.g();
        goto L91
    L94:
        r103 = true;
        goto L96
    L99:
        a8b.a r114 = f544974a;
        if (r114.f2208a.get(r113) == false) goto L138;
        r111.e(r114);
        if (r111.m() > 0) goto L105;
    L107:
        if (r103 == true) goto L109;
        return null;
    L109:
        return b(r100, r111);
    L105:
        if (r111.b(Typography.greater) < 0) goto L107;
        r111.g();
        r103 = true;
        goto L107
    L138:
        return null;
    L135:
        return null;
    }

    public static h b(x7b.d r100, x7b.e r101) {
        String r102 = r101.c(r100, r101.k()).a();
        k r103 = new k();
        r103.f553558j = r102;
        return new h(r103, r101.k());
    }
}
