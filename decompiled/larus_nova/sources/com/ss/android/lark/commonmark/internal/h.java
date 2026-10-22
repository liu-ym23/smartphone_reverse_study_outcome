package com.ss.android.lark.commonmark.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.commonmark.parser.IncludeSourceSpans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import v7b.d0;
import v7b.v;
import v7b.x;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements y7b.g {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Set<Class<? extends v7b.a>> f417203s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Map<Class<? extends v7b.a>, y7b.e> f417204t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w7b.f f417205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f417206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f417207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f417208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f417209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f417210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f417211g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f417212h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f417213i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<y7b.e> f417214j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final w7b.b f417215k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<x7b.b> f417216l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<z7b.a> f417217m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final IncludeSourceSpans f417218n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g f417219o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final o f417220p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<b> f417221q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<y7b.d> f417222r;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y7b.d f417223a;

        public a(y7b.d r100) {
            this.f417223a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y7b.d f417224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f417225b;

        public b(y7b.d r100, int r101) {
            this.f417224a = r100;
            this.f417225b = r101;
        }
    }

    static {
        int r110 = 0;
        Object[] r100 = {v7b.b.class, v7b.i.class, v7b.g.class, v7b.j.class, d0.class, v7b.p.class, v7b.m.class};
        ArrayList r101 = new ArrayList(7);
    L3:
        if (r110 >= 7) goto L5;
        Object r102 = r100[r110];
        Objects.requireNonNull(r102);
        r101.add(r102);
        r110 = r110 + 1;
        goto L3
    L5:
        f417203s = new LinkedHashSet(Collections.unmodifiableList(r101));
        HashMap r103 = new HashMap();
        r103.put(v7b.b.class, new c.a());
        r103.put(v7b.i.class, new j.a());
        r103.put(v7b.g.class, new i.a());
        r103.put(v7b.j.class, new k.a());
        r103.put(d0.class, new t.a());
        r103.put(v7b.p.class, new p.a());
        r103.put(v7b.m.class, new l.a());
        f417204t = Collections.unmodifiableMap(r103);
    }

    public final void c() {
        if (this.f417209e == false) goto L8;
        int r100 = this.f417207c + 1;
        CharSequence r101 = this.f417205a.f558606a;
        CharSequence r102 = r101.subSequence(r100, r101.length());
        int r103 = 4 - (this.f417208d % 4);
        StringBuilder r104 = new StringBuilder(r102.length() + r103);
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L7;
        r104.append(' ');
        r105 = r105 + 1;
        goto L5
    L7:
        r104.append(r102);
        CharSequence r106 = r104.toString();
    L13:
        if (this.f417218n != IncludeSourceSpans.BLOCKS_AND_INLINES) goto L15;
        x r107 = new x(this.f417206b, this.f417207c, r106.length());
    L16:
        h().e(new w7b.f(r106, r107));
        d();
        return;
    L15:
        r107 = null;
        goto L16
    L8:
        int r108 = this.f417207c;
        if (r108 != 0) goto L11;
        r106 = this.f417205a.f558606a;
        goto L13
    L11:
        CharSequence r109 = this.f417205a.f558606a;
        r106 = r109.subSequence(r108, r109.length());
        goto L13
    }

    public final void d() {
        if (this.f417218n == IncludeSourceSpans.NONE) goto L11;
        int r100 = 1;
    L6:
        if (r100 >= ((ArrayList) this.f417221q).size()) goto L15;
        b r101 = (b) ListProtector.get(this.f417221q, r100);
        int r102 = r101.f417225b;
        int r103 = this.f417205a.f558606a.length() - r102;
        if (r103 == 0) goto L10;
        r101.f417224a.f(new x(this.f417206b, r102, r103));
    L10:
        r100 = r100 + 1;
        goto L6
    L15:
        return;
    }

    public final void e() {
        char r100 = this.f417205a.f558606a.charAt(this.f417207c);
        this.f417207c++;
        if (r100 != '\t') goto L5;
        int r101 = this.f417208d;
        this.f417208d = r101 + (4 - (r101 % 4));
        return;
    L5:
        this.f417208d++;
    }

    public final void g() {
        int r100 = this.f417207c;
        int r101 = this.f417208d;
        this.f417213i = true;
        int r102 = this.f417205a.f558606a.length();
    L3:
        if (r100 >= r102) goto L11;
        char r103 = this.f417205a.f558606a.charAt(r100);
        if (r103 != '\t') goto L7;
        r100 = r100 + 1;
        r101 = r101 + (4 - (r101 % 4));
        goto L3
    L7:
        if (r103 != ' ') goto L8;
        r100 = r100 + 1;
        r101 = r101 + 1;
        goto L3
    L8:
        this.f417213i = false;
    L11:
        this.f417210f = r100;
        this.f417211g = r101;
        this.f417212h = r101 - this.f417208d;
    }

    public final y7b.d h() {
        List<b> r100 = this.f417221q;
        return ((b) ListProtector.get(r100, ((ArrayList) r100).size() - 1)).f417224a;
    }

    public final void a(b r100) {
    L3:
        if (h().g(r100.f417224a.a()) == true) goto L5;
        f(1);
        goto L3
    L5:
        h().a().e(r100.f417224a.a());
        ((ArrayList) this.f417221q).add(r100);
    }

    public final void b(r r100) {
        LinkReferenceDefinitionParser r101 = r100.f417269b;
        r101.a();
        Iterator r102 = ((ArrayList) r101.f417168c).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        v7b.o r103 = (v7b.o) r102.next();
        r100.f417268a.l(r103);
        o r104 = this.f417220p;
        r104.getClass();
        String r105 = u7b.a.a(r103.f553563j);
        if (r104.f417256a.containsKey(r105) == true) goto L4;
        r104.f417256a.put(r105, r103);
        goto L4
    }

    public final void f(int r100) {
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        List<b> r102 = this.f417221q;
        y7b.d r103 = ((b) ListProtector.remove(r102, ((ArrayList) r102).size() - 1)).f417224a;
        if ((r103 instanceof r) == false) goto L7;
        b((r) r103);
    L7:
        r103.c();
        ((ArrayList) this.f417222r).add(r103);
        r101 = r101 + 1;
        goto L3
    }

    public final void i(String r110) {
        this.f417206b++;
        this.f417207c = 0;
        this.f417208d = 0;
        this.f417209e = false;
        if (r110.indexOf(0) == (-1)) goto L7;
        r110 = r110.replace(0, 65533);
    L7:
        if (this.f417218n == IncludeSourceSpans.NONE) goto L9;
        x r100 = new x(this.f417206b, 0, r110.length());
    L10:
        this.f417205a = new w7b.f(r110, r100);
        int r111 = 1;
        int r101 = 1;
    L12:
        if (r111 >= ((ArrayList) this.f417221q).size()) goto L26;
        b r102 = (b) ListProtector.get(this.f417221q, r111);
        y7b.d r103 = r102.f417224a;
        g();
        y7b.c r104 = r103.h(this);
        if ((r104 instanceof com.ss.android.lark.commonmark.internal.b) == false) goto L26;
        com.ss.android.lark.commonmark.internal.b r105 = (com.ss.android.lark.commonmark.internal.b) r104;
        r102.f417225b = this.f417207c;
        if (r105.f417181c == true) goto L17;
        int r106 = r105.f417179a;
        if (r106 == (-1)) goto L22;
        k(r106);
    L25:
        r101 = r101 + 1;
        r111 = r111 + 1;
        goto L12
    L22:
        int r107 = r105.f417180b;
        if (r107 == (-1)) goto L25;
        j(r107);
        goto L25
    L17:
        d();
        f(((ArrayList) this.f417221q).size() - r111);
        return;
    L26:
        int r112 = ((ArrayList) this.f417221q).size() - r101;
        y7b.d r108 = ((b) ListProtector.get(this.f417221q, r101 - 1)).f417224a;
        int r109 = this.f417207c;
        if ((r108.a() instanceof v) == false) goto L29;
    L32:
        boolean r113 = true;
    L33:
        boolean r114 = false;
    L34:
        if (r113 == false) goto L75;
        r109 = this.f417207c;
        g();
        if (this.f417213i == true) goto L74;
        if (this.f417212h < 4) goto L40;
    L42:
        a r115 = new a(r108);
        Iterator<y7b.e> r116 = this.f417214j.iterator();
    L44:
        if (r116.hasNext() == false) goto L48;
        d r117 = r116.next().a(this, r115);
        if ((r117 instanceof d) == false) goto L44;
    L49:
        if (r117 == null) goto L50;
        int r118 = this.f417207c;
        if (r112 <= 0) goto L54;
        f(r112);
        r112 = 0;
    L54:
        int r119 = r117.f417184b;
        if (r119 == (-1)) goto L57;
        k(r119);
    L61:
        if (r117.f417186d == false) goto L66;
        List<b> r120 = this.f417221q;
        y7b.d r121 = ((b) ListProtector.remove(r120, ((ArrayList) r120).size() - 1)).f417224a;
        if ((r121 instanceof r) == false) goto L65;
        b((r) r121);
    L65:
        r121.c();
        r121.a().p();
        List<x> r122 = r121.a().j();
    L67:
        y7b.d[] r123 = r117.f417183a;
        int r124 = r123.length;
        int r125 = 0;
    L68:
        if (r125 >= r124) goto L73;
        r108 = r123[r125];
        a(new b(r108, r118));
        if (r122 == null) goto L72;
        r108.a().n(r122);
    L72:
        r113 = r108.isContainer();
        r125 = r125 + 1;
        goto L68
    L73:
        r114 = true;
        goto L34
    L66:
        r122 = null;
        goto L67
    L57:
        int r126 = r117.f417185c;
        if (r126 == (-1)) goto L61;
        j(r126);
        goto L61
    L50:
        k(this.f417210f);
        goto L75
    L48:
        r117 = null;
        goto L49
    L40:
        if (Character.isLetter(Character.codePointAt(this.f417205a.f558606a, this.f417210f)) == false) goto L42;
    L74:
        k(this.f417210f);
    L75:
        if (r114 == false) goto L77;
    L81:
        if (r112 <= 0) goto L84;
        f(r112);
    L84:
        if (r108.isContainer() == true) goto L87;
        c();
        return;
    L87:
        if (this.f417213i == true) goto L89;
        a(new b(new r(), r109));
        c();
        return;
    L89:
        d();
        return;
    L77:
        if (this.f417213i == true) goto L81;
        if (h().b() == false) goto L81;
        List<b> r127 = this.f417221q;
        ((b) ListProtector.get(r127, ((ArrayList) r127).size() - 1)).f417225b = r109;
        c();
        return;
    L29:
        if (r108.isContainer() == true) goto L32;
        r113 = false;
        goto L33
    L9:
        r100 = null;
        goto L10
    }

    public final void j(int r100) {
        int r101 = this.f417211g;
        if (r100 < r101) goto L5;
        this.f417207c = this.f417210f;
        this.f417208d = r101;
    L5:
        int r102 = this.f417205a.f558606a.length();
    L6:
        int r103 = this.f417208d;
        if (r103 >= r100) goto L11;
        if (this.f417207c == r102) goto L11;
        e();
    L11:
        if (r103 <= r100) goto L13;
        this.f417207c--;
        this.f417208d = r100;
        this.f417209e = true;
        return;
    L13:
        this.f417209e = false;
    }

    public final void k(int r100) {
        int r101 = this.f417210f;
        if (r100 < r101) goto L5;
        this.f417207c = r101;
        this.f417208d = this.f417211g;
    L5:
        int r102 = this.f417205a.f558606a.length();
    L6:
        int r103 = this.f417207c;
        if (r103 >= r100) goto L10;
        if (r103 == r102) goto L10;
        e();
    L10:
        this.f417209e = false;
    }

    public h(List r100, w7b.c r101, List r102, List r103, IncludeSourceSpans r104) {
        this.f417206b = -1;
        this.f417207c = 0;
        this.f417208d = 0;
        this.f417210f = 0;
        this.f417211g = 0;
        this.f417212h = 0;
        this.f417220p = new o();
        ArrayList r105 = new ArrayList();
        this.f417221q = r105;
        this.f417222r = new ArrayList();
        this.f417214j = r100;
        this.f417215k = r101;
        this.f417216l = r102;
        this.f417217m = r103;
        this.f417218n = r104;
        g r106 = new g();
        this.f417219o = r106;
        r105.add(new b(r106, 0));
    }
}
