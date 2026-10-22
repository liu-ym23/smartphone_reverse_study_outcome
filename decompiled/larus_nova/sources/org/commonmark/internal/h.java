package org.commonmark.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes5.dex */
public final class h implements wvc.g {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set<Class<? extends Block>> f525688p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Map<Class<? extends Block>, wvc.e> f525689q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f525690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f525691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f525692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f525693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f525694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f525695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f525696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f525697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<wvc.e> f525698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final vvc.c f525699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<xvc.a> f525700k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g f525701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, LinkReferenceDefinition> f525702m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<wvc.d> f525703n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Set<wvc.d> f525704o;

    /* JADX INFO: loaded from: classes42.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wvc.d f525705a;

        public final CharSequence a() {
            wvc.d r100 = this.f525705a;
            if ((r100 instanceof q) == false) goto L8;
            StringBuilder r101 = ((q) r100).f525754b.f525652b;
            if (r101.length() != 0) goto L7;
            return null;
        L7:
            return r101;
        L8:
            return null;
        }

        public a(wvc.d r100) {
            this.f525705a = r100;
        }
    }

    static {
        f525688p = new LinkedHashSet(Arrays.asList(new Class[]{BlockQuote.class, Heading.class, FencedCodeBlock.class, HtmlBlock.class, ThematicBreak.class, ListBlock.class, IndentedCodeBlock.class}));
        HashMap r100 = new HashMap();
        r100.put(BlockQuote.class, new c.a());
        r100.put(Heading.class, new j.a());
        r100.put(FencedCodeBlock.class, new i.a());
        r100.put(HtmlBlock.class, new k.a());
        r100.put(ThematicBreak.class, new s.a());
        r100.put(ListBlock.class, new o.a());
        r100.put(IndentedCodeBlock.class, new l.a());
        f525689q = Collections.unmodifiableMap(r100);
    }

    public final void c() {
        if (this.f525693d == false) goto L8;
        int r100 = this.f525691b + 1;
        CharSequence r101 = this.f525690a;
        CharSequence r102 = r101.subSequence(r100, r101.length());
        int r103 = 4 - (this.f525692c % 4);
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
    L9:
        h().d(r106);
        return;
    L8:
        CharSequence r107 = this.f525690a;
        r106 = r107.subSequence(this.f525691b, r107.length());
        goto L9
    }

    public final void d() {
        if (this.f525690a.charAt(this.f525691b) != '\t') goto L5;
        this.f525691b++;
        int r100 = this.f525692c;
        this.f525692c = r100 + (4 - (r100 % 4));
        return;
    L5:
        this.f525691b++;
        this.f525692c++;
    }

    public final void g() {
        int r100 = this.f525691b;
        int r101 = this.f525692c;
        this.f525697h = true;
        int r102 = this.f525690a.length();
    L3:
        if (r100 >= r102) goto L11;
        char r103 = this.f525690a.charAt(r100);
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
        this.f525697h = false;
    L11:
        this.f525694e = r100;
        this.f525695f = r101;
        this.f525696g = r101 - this.f525692c;
    }

    public final wvc.d h() {
        List<wvc.d> r100 = this.f525703n;
        return (wvc.d) ListProtector.get(r100, ((ArrayList) r100).size() - 1);
    }

    public final void a(wvc.d r100) {
    L3:
        if (h().e(r100.a()) == true) goto L5;
        e(h());
        goto L3
    L5:
        h().a().b(r100.a());
        ((ArrayList) this.f525703n).add(r100);
        this.f525704o.add(r100);
    }

    public final void b(q r100) {
        LinkReferenceDefinitionParser r101 = r100.f525754b;
        r101.a();
        Iterator r102 = ((ArrayList) r101.f525653c).iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        LinkReferenceDefinition r103 = (LinkReferenceDefinition) r102.next();
        Paragraph r104 = r100.f525753a;
        r104.getClass();
        r103.g();
        uvc.b r105 = r104.f551903d;
        r103.f551903d = r105;
        if (r105 == null) goto L8;
        r105.f551904e = r103;
    L8:
        r103.f551904e = r104;
        r104.f551903d = r103;
        uvc.b r106 = r104.f551900a;
        r103.f551900a = r106;
        if (r103.f551903d != null) goto L11;
        r106.f551901b = r103;
    L11:
        String r107 = r103.f525775h;
        if (this.f525702m.containsKey(r107) == true) goto L4;
        this.f525702m.put(r107, r103);
        goto L4
    }

    public final void e(wvc.d r100) {
        if (h() != r100) goto L6;
        List<wvc.d> r101 = this.f525703n;
        ListProtector.remove(r101, ((ArrayList) r101).size() - 1);
    L6:
        if ((r100 instanceof q) == false) goto L8;
        b((q) r100);
    L8:
        r100.c();
    }

    public final void f(List<wvc.d> r100) {
        ArrayList r101 = (ArrayList) r100;
        int r102 = r101.size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L6;
        e((wvc.d) ListProtector.get(r101, r102));
        goto L3
    }

    public final void i(CharSequence r110) {
        String r111 = (String) r110;
        int r100 = r111.length();
        StringBuilder r101 = null;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L12;
        char r103 = r111.charAt(r102);
        if (r103 == 0) goto L8;
        if (r101 == null) goto L11;
        r101.append(r103);
    L11:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r101 != null) goto L10;
        r101 = new StringBuilder(r100);
        r101.append(r111, 0, r102);
    L10:
        r101.append(65533);
        goto L11
    L12:
        if (r101 == null) goto L14;
        r111 = r101.toString();
    L14:
        this.f525690a = r111;
        this.f525691b = 0;
        this.f525692c = 0;
        this.f525693d = false;
        ArrayList r112 = (ArrayList) this.f525703n;
        Iterator r113 = r112.subList(1, r112.size()).iterator();
        int r104 = 1;
    L16:
        if (r113.hasNext() == false) goto L30;
        wvc.d r105 = (wvc.d) r113.next();
        g();
        wvc.c r106 = r105.f(this);
        if ((r106 instanceof b) == false) goto L30;
        b r107 = (b) r106;
        if (r107.f525666c == true) goto L21;
        int r108 = r107.f525664a;
        if (r108 == (-1)) goto L26;
        k(r108);
    L29:
        r104 = r104 + 1;
        goto L16
    L26:
        int r109 = r107.f525665b;
        if (r109 == (-1)) goto L29;
        j(r109);
        goto L29
    L21:
        e(r105);
        return;
    L30:
        ArrayList r114 = (ArrayList) this.f525703n;
        ArrayList r115 = new ArrayList(r114.subList(r104, r114.size()));
        wvc.d r116 = (wvc.d) ListProtector.get(this.f525703n, r104 - 1);
        boolean r117 = r115.isEmpty();
        if ((r116.a() instanceof Paragraph) == false) goto L33;
    L36:
        boolean r118 = true;
    L37:
        if (r118 == false) goto L72;
        g();
        if (this.f525697h == true) goto L71;
        if (this.f525696g < 4) goto L43;
    L45:
        a r119 = new a(r116);
        Iterator<wvc.e> r120 = this.f525698i.iterator();
    L47:
        if (r120.hasNext() == false) goto L51;
        wvc.f r121 = r120.next().a(this, r119);
        if ((r121 instanceof d) == false) goto L47;
        d r122 = (d) r121;
    L52:
        if (r122 == null) goto L53;
        if (r117 == true) goto L56;
        f(r115);
        r117 = true;
    L56:
        int r123 = r122.f525669b;
        if (r123 == (-1)) goto L59;
        k(r123);
    L63:
        if (r122.f525671d == false) goto L68;
        wvc.d r124 = h();
        List<wvc.d> r125 = this.f525703n;
        ListProtector.remove(r125, ((ArrayList) r125).size() - 1);
        this.f525704o.remove(r124);
        if ((r124 instanceof q) == false) goto L67;
        b((q) r124);
    L67:
        r124.a().g();
    L68:
        wvc.d[] r126 = r122.f525668a;
        int r127 = r126.length;
        int r128 = 0;
    L69:
        if (r128 >= r127) goto L37;
        r116 = r126[r128];
        a(r116);
        r118 = r116.isContainer();
        r128 = r128 + 1;
        goto L69
    L59:
        int r129 = r122.f525670c;
        if (r129 == (-1)) goto L63;
        j(r129);
        goto L63
    L53:
        k(this.f525694e);
        goto L72
    L51:
        r122 = null;
        goto L52
    L43:
        if (Character.isLetter(Character.codePointAt(this.f525690a, this.f525694e)) == false) goto L45;
    L71:
        k(this.f525694e);
    L72:
        if (r117 == false) goto L74;
    L78:
        if (r117 == true) goto L81;
        f(r115);
    L81:
        if (r116.isContainer() == true) goto L84;
        c();
        return;
    L84:
        if (this.f525697h == true) goto L110;
        a(new q(0));
        c();
        return;
    L110:
        return;
    L74:
        if (this.f525697h == true) goto L78;
        if (h().b() == false) goto L78;
        c();
        return;
    L33:
        if (r116.isContainer() == true) goto L36;
        r118 = false;
        goto L37
    }

    public final void j(int r100) {
        int r101 = this.f525695f;
        if (r100 < r101) goto L5;
        this.f525691b = this.f525694e;
        this.f525692c = r101;
    L5:
        int r102 = this.f525690a.length();
    L6:
        int r103 = this.f525692c;
        if (r103 >= r100) goto L11;
        if (this.f525691b == r102) goto L11;
        d();
    L11:
        if (r103 <= r100) goto L13;
        this.f525691b--;
        this.f525692c = r100;
        this.f525693d = true;
        return;
    L13:
        this.f525693d = false;
    }

    public final void k(int r100) {
        int r101 = this.f525694e;
        if (r100 < r101) goto L5;
        this.f525691b = r101;
        this.f525692c = this.f525695f;
    L5:
        int r102 = this.f525690a.length();
    L6:
        int r103 = this.f525691b;
        if (r103 >= r100) goto L10;
        if (r103 == r102) goto L10;
        d();
    L10:
        this.f525693d = false;
    }

    public h(List r100, vvc.c r101, List r102) {
        this.f525691b = 0;
        this.f525692c = 0;
        this.f525694e = 0;
        this.f525695f = 0;
        this.f525696g = 0;
        this.f525702m = new LinkedHashMap();
        ArrayList r103 = new ArrayList();
        this.f525703n = r103;
        LinkedHashSet r104 = new LinkedHashSet();
        this.f525704o = r104;
        this.f525698i = r100;
        this.f525699j = r101;
        this.f525700k = r102;
        g r105 = new g();
        this.f525701l = r105;
        r103.add(r105);
        r104.add(r105);
    }
}
