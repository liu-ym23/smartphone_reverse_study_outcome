package w7b;

import com.ss.android.lark.commonmark.internal.h;
import com.ss.android.lark.commonmark.internal.m;
import com.ss.android.lark.commonmark.internal.n;
import com.ss.android.lark.commonmark.internal.o;
import com.ss.android.lark.commonmark.parser.IncludeSourceSpans;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<y7b.e> f558594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<x7b.b> f558595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<z7b.a> f558596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f558597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<e> f558598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IncludeSourceSpans f558599f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<y7b.e> f558600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<x7b.b> f558601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<z7b.a> f558602c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<e> f558603d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Set<Class<? extends v7b.a>> f558604e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public IncludeSourceSpans f558605f;

        public a() {
            this.f558600a = new ArrayList();
            this.f558601b = new ArrayList();
            this.f558602c = new ArrayList();
            this.f558603d = new ArrayList();
            this.f558604e = h.f417203s;
            this.f558605f = IncludeSourceSpans.NONE;
        }

        public final void a(e r100) {
            Objects.requireNonNull(r100, "postProcessor must not be null");
            ((ArrayList) this.f558603d).add(r100);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [w7b.c] */
    public d(a r100) {
        List<y7b.e> r101 = r100.f558600a;
        Set<Class<? extends v7b.a>> r102 = r100.f558604e;
        Set<Class<? extends v7b.a>> r103 = h.f417203s;
        ArrayList r104 = new ArrayList();
        r104.addAll(r101);
        Iterator<Class<? extends v7b.a>> r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Class<? extends v7b.a> r106 = r105.next();
        r104.add(h.f417204t.get(r106));
        goto L4
    L6:
        this.f558594a = r104;
        this.f558597d = new c();
        this.f558598e = r100.f558603d;
        List<x7b.b> r107 = r100.f558601b;
        this.f558595b = r107;
        List<z7b.a> r108 = r100.f558602c;
        this.f558596c = r108;
        this.f558599f = r100.f558605f;
        new n(new m(r107, r108, new o()));
    }

    public final s a(String r100) {
        Objects.requireNonNull(r100, "input must not be null");
        h r101 = new h(this.f558594a, this.f558597d, this.f558595b, this.f558596c, this.f558599f);
        int r102 = 0;
    L3:
        int r103 = r100.length();
        int r104 = r102;
    L5:
        if (r104 >= r103) goto L10;
        char r105 = r100.charAt(r104);
        if (r105 == '\n') goto L11;
        if (r105 == '\r') goto L11;
        r104 = r104 + 1;
    L11:
        if (r104 == (-1)) goto L20;
        r101.i(r100.substring(r102, r104));
        r102 = r104 + 1;
        if (r102 >= r100.length()) goto L3;
        if (r100.charAt(r104) != '\r') goto L3;
        if (r100.charAt(r102) != '\n') goto L3;
        r102 = r104 + 2;
        goto L3
    L20:
        if (r100.isEmpty() == true) goto L25;
        if (r102 != 0) goto L23;
    L24:
        r101.i(r100.substring(r102));
        goto L25
    L23:
        if (r102 < r100.length()) goto L24;
    L25:
        r101.f(((ArrayList) r101.f417221q).size());
        m r106 = new m(r101.f417216l, r101.f417217m, r101.f417220p);
        ((c) r101.f417215k).getClass();
        n r107 = new n(r106);
        Iterator r108 = ((ArrayList) r101.f417222r).iterator();
    L27:
        if (r108.hasNext() == false) goto L29;
        ((y7b.d) r108.next()).d(r107);
        goto L27
    L29:
        s r109 = r101.f417219o.f417202a;
        Iterator r110 = ((ArrayList) this.f558598e).iterator();
    L31:
        if (r110.hasNext() == false) goto L33;
        r109 = ((e) r110.next()).a(r109);
        goto L31
    L33:
        return r109;
    L10:
        r104 = -1;
        goto L11
    }
}
