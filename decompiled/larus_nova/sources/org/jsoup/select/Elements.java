package org.jsoup.select;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import org.jsoup.helper.ValidationException;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.h;
import org.jsoup.nodes.j;
import org.jsoup.nodes.k;
import org.jsoup.nodes.m;

/* JADX INFO: loaded from: classes42.dex */
public class Elements extends ArrayList<Element> {
    public Elements next() {
        return c(null, true, false);
    }

    public Elements nextAll() {
        return c(null, true, true);
    }

    public Elements prev() {
        return c(null, false, false);
    }

    public Elements prevAll() {
        return c(null, false, true);
    }

    @Override // java.util.ArrayList
    public Elements clone() {
        Elements r100 = new Elements(size());
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add(r101.next().N());
        goto L4
    L6:
        return r100;
    }

    public List<org.jsoup.nodes.d> comments() {
        return a(org.jsoup.nodes.d.class);
    }

    public List<org.jsoup.nodes.e> dataNodes() {
        return a(org.jsoup.nodes.e.class);
    }

    public List<String> eachText() {
        ArrayList r100 = new ArrayList(size());
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Element r102 = r101.next();
        if (r102.S() == false) goto L4;
        r100.add(r102.a0());
        goto L4
    L8:
        return r100;
    }

    public List<h> forms() {
        ArrayList r100 = new ArrayList();
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Element r102 = r101.next();
        if ((r102 instanceof h) == false) goto L4;
        r100.add((h) r102);
        goto L4
    L8:
        return r100;
    }

    public Elements parents() {
        LinkedHashSet r100 = new LinkedHashSet();
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Element r102 = r101.next();
        r102.getClass();
        Elements r103 = new Elements();
        Element.F(r102, r103);
        r100.addAll(r103);
        goto L4
    L7:
        return new Elements(r100);
    }

    public List<m> textNodes() {
        return a(m.class);
    }

    public Elements empty() {
        Iterator<Element> r100 = iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().f525908f.clear();
        goto L4
    L6:
        return this;
    }

    @Nullable
    public Element first() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return get(0);
    }

    public boolean hasText() {
        Iterator<Element> r100 = iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (r100.next().S() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public String html() {
        StringBuilder r100 = fwc.b.b();
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Element r102 = r101.next();
        if (r100.length() == 0) goto L8;
        r100.append("\n");
    L8:
        r100.append(r102.T());
        goto L4
    L10:
        return fwc.b.g(r100);
    }

    @Nullable
    public Element last() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return get(size() - 1);
    }

    public String outerHtml() {
        StringBuilder r100 = fwc.b.b();
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Element r102 = r101.next();
        if (r100.length() == 0) goto L8;
        r100.append("\n");
    L8:
        r100.append(r102.u());
        goto L4
    L10:
        return fwc.b.g(r100);
    }

    public Elements remove() {
        Iterator<Element> r100 = iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().A();
        goto L4
    L6:
        return this;
    }

    public String text() {
        StringBuilder r100 = fwc.b.b();
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Element r102 = r101.next();
        if (r100.length() == 0) goto L8;
        r100.append(" ");
    L8:
        r100.append(r102.a0());
        goto L4
    L10:
        return fwc.b.g(r100);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return outerHtml();
    }

    public Elements unwrap() {
        Iterator<Element> r100 = iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Element r101 = r100.next();
        ewc.b.d(r101.f525933a);
        if (r101.i() == 0) goto L9;
        j r102 = (j) ListProtector.get(r101.n(), 0);
    L9:
        r101.f525933a.b(r101.f525934b, (j[]) r101.n().toArray(new j[0]));
        r101.A();
        goto L4
    L10:
        return this;
    }

    public String val() {
        if (size() <= 0) goto L9;
        Element r100 = first();
        if (r100.f525906d.f526035b.equals("textarea") == false) goto L8;
        return r100.a0();
    L8:
        return r100.d("value");
    L9:
        return "";
    }

    public Elements() {
    }

    @Override // java.util.ArrayList
    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    public Elements(Element... r100) {
        super(Arrays.asList(r100));
    }

    public final <T extends j> List<T> a(Class<T> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Element> r102 = iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Element r103 = r102.next();
        int r104 = 0;
    L7:
        if (r104 >= r103.i()) goto L4;
        j r105 = r103.h(r104);
        if (r100.isInstance(r105) == false) goto L11;
        r101.add(r100.cast(r105));
    L11:
        r104 = r104 + 1;
        goto L7
    L12:
        return r101;
    }

    public Elements addClass(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Element r102 = r101.next();
        r102.getClass();
        ewc.b.d(r100);
        Set<String> r103 = r102.L();
        r103.add(r100);
        r102.M(r103);
        goto L4
    L6:
        return this;
    }

    public Elements after(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Element r102 = r101.next();
        r102.c(r102.f525934b + 1, r100);
        goto L4
    L6:
        return this;
    }

    public Elements append(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Element r102 = r101.next();
        r102.getClass();
        ewc.b.d(r100);
        int r103 = 0;
        j[] r104 = (j[]) k.a(r102).a(r100, r102, r102.g()).toArray(new j[0]);
        List<j> r105 = r102.n();
        int r106 = r104.length;
    L6:
        if (r103 >= r106) goto L4;
        j r107 = r104[r103];
        r107.getClass();
        j r108 = r107.f525933a;
        if (r108 == null) goto L10;
        r108.B(r107);
    L10:
        r107.f525933a = r102;
        r105.add(r107);
        r107.f525934b = r105.size() - 1;
        r103 = r103 + 1;
        goto L6
    L11:
        return this;
    }

    public String attr(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Element r102 = r101.next();
        if (r102.p(r100) == false) goto L4;
        return r102.d(r100);
    L9:
        return "";
    }

    public Elements before(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Element r102 = r101.next();
        r102.c(r102.f525934b, r100);
        goto L4
    L6:
        return this;
    }

    public List<String> eachAttr(String r100) {
        ArrayList r101 = new ArrayList(size());
        Iterator<Element> r102 = iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Element r103 = r102.next();
        if (r103.p(r100) == false) goto L4;
        r101.add(r103.d(r100));
        goto L4
    L8:
        return r101;
    }

    public Elements eq(int r100) {
        if (size() <= r100) goto L6;
        return new Elements(new Element[]{get(r100)});
    L6:
        return new Elements();
    }

    public Elements filter(NodeFilter r100) {
        int r101 = d.f526106a;
        ewc.b.d(r100);
        Iterator<Element> r102 = iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        if (d.a(r100, r102.next()) != NodeFilter.FilterResult.STOP) goto L4;
    L7:
        return this;
    }

    public boolean hasAttr(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().p(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public boolean hasClass(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().R(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public Elements html(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Element r102 = r101.next();
        r102.f525908f.clear();
        ewc.b.d(r100);
        int r103 = 0;
        j[] r104 = (j[]) k.a(r102).a(r100, r102, r102.g()).toArray(new j[0]);
        List<j> r105 = r102.n();
        int r106 = r104.length;
    L6:
        if (r103 >= r106) goto L4;
        j r107 = r104[r103];
        r107.getClass();
        j r108 = r107.f525933a;
        if (r108 == null) goto L10;
        r108.B(r107);
    L10:
        r107.f525933a = r102;
        r105.add(r107);
        r107.f525934b = r105.size() - 1;
        r103 = r103 + 1;
        goto L6
    L11:
        return this;
    }

    public boolean is(String r100) {
        c r101 = e.j(r100);
        Iterator<Element> r102 = iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r102.next().W(r101) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public Elements next(String r100) {
        return c(r100, true, false);
    }

    public Elements nextAll(String r100) {
        return c(r100, true, true);
    }

    public Elements not(String r100) {
        Elements r101 = Selector.a(r100, this);
        Elements r102 = new Elements();
        Iterator<Element> r103 = iterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        Element r104 = r103.next();
        Iterator<Element> r105 = r101.iterator();
    L6:
        boolean r106 = false;
        if (r105.hasNext() == false) goto L13;
        Element r107 = r105.next();
        r104.getClass();
        if (r104 != r107) goto L11;
        r106 = true;
    L11:
        if (r106 == false) goto L6;
        r106 = true;
    L13:
        if (r106 == true) goto L4;
        r102.add(r104);
        goto L4
    L15:
        return r102;
    }

    public Elements prepend(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Element r102 = r101.next();
        r102.getClass();
        ewc.b.d(r100);
        r102.b(0, (j[]) k.a(r102).a(r100, r102, r102.g()).toArray(new j[0]));
        goto L4
    L6:
        return this;
    }

    public Elements prev(String r100) {
        return c(r100, false, false);
    }

    public Elements prevAll(String r100) {
        return c(r100, false, true);
    }

    public Elements removeAttr(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Element r102 = r101.next();
        r102.getClass();
        ewc.b.d(r100);
        if (r102.q() == false) goto L4;
        org.jsoup.nodes.b r103 = r102.f();
        int r104 = r103.i(r100);
        if (r104 == (-1)) goto L4;
        r103.m(r104);
        goto L4
    L10:
        return this;
    }

    public Elements removeClass(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Element r102 = r101.next();
        r102.getClass();
        ewc.b.d(r100);
        Set<String> r103 = r102.L();
        r103.remove(r100);
        r102.M(r103);
        goto L4
    L6:
        return this;
    }

    public Elements select(String r100) {
        return Selector.a(r100, this);
    }

    public Elements tagName(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        Element r102 = r101.next();
        r102.getClass();
        if (r100 == null) goto L11;
        if (r100.length() == 0) goto L11;
        r102.f525906d = org.jsoup.parser.f.a(r100, k.a(r102).f526026c);
    L11:
        throw new ValidationException(String.format("The '%s' parameter must not be empty.", new Object[]{"tagName"}));
    L12:
        return this;
    }

    public Elements toggleClass(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Element r102 = r101.next();
        r102.getClass();
        ewc.b.d(r100);
        Set<String> r103 = r102.L();
        if (r103.contains(r100) == false) goto L8;
        r103.remove(r100);
    L9:
        r102.M(r103);
        goto L4
    L8:
        r103.add(r100);
        goto L9
    L10:
        return this;
    }

    public Elements traverse(gwc.b r100) {
        int r101 = d.f526106a;
        ewc.b.d(r100);
        Iterator<Element> r102 = iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        d.b(r100, r102.next());
        goto L4
    L6:
        return this;
    }

    public Elements val(String r100) {
        Iterator<Element> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Element r102 = r101.next();
        if (r102.f525906d.f526035b.equals("textarea") == true) goto L7;
        r102.e("value", r100);
        goto L4
    L7:
        r102.b0(r100);
        goto L4
    L9:
        return this;
    }

    public Elements wrap(String r110) {
        ewc.b.b(r110);
        Iterator<Element> r100 = iterator();
    L4:
        if (r100.hasNext() == false) goto L33;
        Element r101 = r100.next();
        r101.getClass();
        ewc.b.b(r110);
        j r102 = r101.f525933a;
        if (r102 != null) goto L8;
    L10:
        Element r103 = r101;
    L11:
        List<j> r104 = k.a(r101).a(r110, r103, r101.g());
        j r105 = (j) ListProtector.get(r104, 0);
        if ((r105 instanceof Element) == false) goto L4;
        Element r106 = (Element) r105;
        Element r107 = j.o(r106);
        j r108 = r101.f525933a;
        if (r108 == null) goto L17;
        r108.C(r101, r106);
    L17:
        j[] r109 = {r101};
        List<j> r111 = r107.n();
        j r112 = r109[0];
        r112.getClass();
        j r113 = r112.f525933a;
        if (r113 == null) goto L20;
        r113.B(r112);
    L20:
        r112.f525933a = r107;
        r111.add(r112);
        r112.f525934b = r111.size() - 1;
        if (r104.size() <= 0) goto L4;
        int r114 = 0;
    L24:
        if (r114 >= r104.size()) goto L4;
        j r115 = (j) ListProtector.get(r104, r114);
        if (r106 == r115) goto L32;
        j r116 = r115.f525933a;
        if (r116 == null) goto L31;
        r116.B(r115);
    L31:
        ewc.b.d(r106.f525933a);
        r106.f525933a.b(r106.f525934b + 1, new j[]{r115});
    L32:
        r114 = r114 + 1;
        goto L24
    L8:
        if ((r102 instanceof Element) == false) goto L10;
        r103 = (Element) r102;
        goto L11
    L33:
        return this;
    }

    public Elements(int r100) {
        super(r100);
    }

    public Elements(Collection<Element> r100) {
        super(r100);
    }

    public Elements(List<Element> r100) {
        super(r100);
    }

    public Elements attr(String r100, String r101) {
        Iterator<Element> r102 = iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().e(r100, r101);
        goto L4
    L6:
        return this;
    }

    public final Elements c(@Nullable String r100, boolean r101, boolean r102) {
        Elements r103 = new Elements();
        if (r100 == null) goto L5;
        c r104 = e.j(r100);
    L6:
        Iterator<Element> r105 = iterator();
    L8:
        if (r105.hasNext() == false) goto L28;
        Element r106 = r105.next();
    L10:
        if (r101 == false) goto L18;
        j r107 = r106.f525933a;
        if (r107 == null) goto L17;
        List<Element> r108 = ((Element) r107).J();
        int r109 = Element.U(r106, r108) + 1;
        if (r108.size() <= r109) goto L17;
        r106 = (Element) ListProtector.get(r108, r109);
    L19:
        if (r106 == null) goto L8;
        if (r104 != null) goto L24;
        r103.add(r106);
    L26:
        if (r102 == true) goto L10;
    L24:
        if (r106.W(r104) == false) goto L26;
        r103.add(r106);
    L17:
        r106 = null;
        goto L19
    L18:
        r106 = r106.Y();
        goto L19
    L28:
        return r103;
    L5:
        r104 = null;
        goto L6
    }
}
