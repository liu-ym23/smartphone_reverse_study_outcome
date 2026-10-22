package org.jsoup.select;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: loaded from: classes42.dex */
public abstract class c {

    public static final class a extends c {
        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return true;
        }

        public final String toString() {
            return "*";
        }

        public a() {
        }
    }

    public static final class a0 extends d0 {
        public a0() {
            super(0, 1);
        }

        @Override // org.jsoup.select.c.q
        public final String toString() {
            return ":last-of-type";
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526084a;

        public final String toString() {
            return String.format("[%s]", new Object[]{this.f526084a});
        }

        public b(String r100) {
            this.f526084a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return r101.p(this.f526084a);
        }
    }

    public static final class b0 extends q {
        @Override // org.jsoup.select.c.q
        public final String c() {
            return "nth-child";
        }

        @Override // org.jsoup.select.c.q
        public final int b(Element r100) {
            return r100.Q() + 1;
        }

        public b0(int r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: renamed from: org.jsoup.select.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC7096c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f526086b;

        public AbstractC7096c(String r100, String r101, boolean r102) {
            ewc.b.b(r100);
            ewc.b.b(r101);
            this.f526085a = fwc.a.b(r100);
            if (r101.startsWith("'") == false) goto L7;
            if (r101.endsWith("'") == false) goto L7;
        L10:
            boolean r103 = true;
        L12:
            if (r103 == false) goto L14;
            r101 = r101.substring(1, r101.length() - 1);
        L14:
            if (r102 == false) goto L16;
            String r104 = fwc.a.b(r101);
        L19:
            this.f526086b = r104;
            return;
        L16:
            if (r103 == false) goto L18;
            r104 = fwc.a.a(r101);
            goto L19
        L18:
            r104 = fwc.a.b(r101);
        L7:
            if (r101.startsWith("\"") == true) goto L9;
        L11:
            r103 = false;
            goto L12
        L9:
            if (r101.endsWith("\"") == false) goto L11;
            goto L10
        }
    }

    public static final class c0 extends q {
        @Override // org.jsoup.select.c.q
        public final String c() {
            return "nth-last-child";
        }

        @Override // org.jsoup.select.c.q
        public final int b(Element r100) {
            Element r101 = (Element) r100.f525933a;
            if (r101 != null) goto L7;
            return 0;
        L7:
            return r101.K().size() - r100.Q();
        }

        public c0(int r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526087a;

        public final String toString() {
            return String.format("[^%s]", new Object[]{this.f526087a});
        }

        public d(String r100) {
            ewc.b.b(r100);
            this.f526087a = fwc.a.a(r100);
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            org.jsoup.nodes.b r102 = r101.f();
            r102.getClass();
            ArrayList r103 = new ArrayList(r102.f525924a);
            int r104 = 0;
        L4:
            if (r104 >= r102.f525924a) goto L10;
            if (org.jsoup.nodes.b.j(r102.f525925b[r104]) == true) goto L9;
            r103.add(new org.jsoup.nodes.a(r102.f525925b[r104], (String) r102.f525926c[r104], r102));
        L9:
            r104 = r104 + 1;
            goto L4
        L10:
            Iterator r105 = Collections.unmodifiableList(r103).iterator();
        L12:
            if (r105.hasNext() == false) goto L17;
            if (fwc.a.a(((org.jsoup.nodes.a) r105.next()).f525921a).startsWith(this.f526087a) == false) goto L12;
            return true;
        L17:
            return false;
        }
    }

    public static class d0 extends q {
        @Override // org.jsoup.select.c.q
        public final String c() {
            return "nth-last-of-type";
        }

        @Override // org.jsoup.select.c.q
        public final int b(Element r100) {
            Element r101 = (Element) r100.f525933a;
            int r102 = 0;
            if (r101 != null) goto L5;
            return 0;
        L5:
            Elements r103 = r101.K();
            int r104 = r100.Q();
        L7:
            if (r104 >= r103.size()) goto L12;
            if (r103.get(r104).f525906d.equals(r100.f525906d) == false) goto L11;
            r102 = r102 + 1;
        L11:
            r104 = r104 + 1;
            goto L7
        L12:
            return r102;
        }

        public d0(int r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class e extends AbstractC7096c {
        public final String toString() {
            return String.format("[%s=%s]", new Object[]{this.f526085a, this.f526086b});
        }

        public e(String r100, String r101) {
            super(r100, r101, true);
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r101.p(this.f526085a) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f526086b.equalsIgnoreCase(r101.d(this.f526085a).trim()) == false) goto L7;
            return true;
        }
    }

    public static class e0 extends q {
        @Override // org.jsoup.select.c.q
        public final String c() {
            return "nth-of-type";
        }

        @Override // org.jsoup.select.c.q
        public final int b(Element r100) {
            Element r101 = (Element) r100.f525933a;
            int r102 = 0;
            if (r101 != null) goto L5;
            return 0;
        L5:
            Iterator<Element> r103 = r101.K().iterator();
        L7:
            if (r103.hasNext() == false) goto L12;
            Element r104 = r103.next();
            if (r104.f525906d.equals(r100.f525906d) == false) goto L11;
            r102 = r102 + 1;
        L11:
            if (r104 != r100) goto L7;
        L12:
            return r102;
        }

        public e0(int r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class f extends AbstractC7096c {
        public final String toString() {
            return String.format("[%s*=%s]", new Object[]{this.f526085a, this.f526086b});
        }

        public f(String r100, String r101) {
            super(r100, r101, true);
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r101.p(this.f526085a) == true) goto L5;
        L7:
            return false;
        L5:
            if (fwc.a.a(r101.d(this.f526085a)).contains(this.f526086b) == false) goto L7;
            return true;
        }
    }

    public static final class f0 extends c {
        public final String toString() {
            return ":only-child";
        }

        public f0() {
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            org.jsoup.nodes.j r102 = r101.f525933a;
            Element r103 = (Element) r102;
            if (r103 != null) goto L5;
            return false;
        L5:
            if ((r103 instanceof Document) == true) goto L25;
            if (r102 != null) goto L8;
            Elements r104 = new Elements(0);
        L16:
            if (r104.isEmpty() == false) goto L26;
            return true;
        L26:
            return false;
        L8:
            List<Element> r105 = ((Element) r102).J();
            Elements r106 = new Elements(r105.size() - 1);
            Iterator<Element> r107 = r105.iterator();
        L10:
            if (r107.hasNext() == false) goto L14;
            Element r108 = r107.next();
            if (r108 == r101) goto L10;
            r106.add(r108);
            goto L10
        L14:
            r104 = r106;
            goto L16
        L25:
            return false;
        }
    }

    public static final class g extends AbstractC7096c {
        public final String toString() {
            return String.format("[%s$=%s]", new Object[]{this.f526085a, this.f526086b});
        }

        public g(String r100, String r101) {
            super(r100, r101, false);
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r101.p(this.f526085a) == true) goto L5;
        L7:
            return false;
        L5:
            if (fwc.a.a(r101.d(this.f526085a)).endsWith(this.f526086b) == false) goto L7;
            return true;
        }
    }

    public static final class g0 extends c {
        public final String toString() {
            return ":only-of-type";
        }

        public g0() {
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            Element r102 = (Element) r101.f525933a;
            if (r102 != null) goto L5;
            return false;
        L5:
            if ((r102 instanceof Document) == true) goto L24;
            Iterator<Element> r103 = r102.K().iterator();
            int r104 = 0;
        L9:
            if (r103.hasNext() == false) goto L14;
            if (r103.next().f525906d.equals(r101.f525906d) == false) goto L9;
            r104 = r104 + 1;
            goto L9
        L14:
            if (r104 != 1) goto L23;
            return true;
        L23:
            return false;
        L24:
            return false;
        }
    }

    public static final class h extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Pattern f526089b;

        public final String toString() {
            return String.format("[%s~=%s]", new Object[]{this.f526088a, this.f526089b.toString()});
        }

        public h(String r100, Pattern r101) {
            this.f526088a = fwc.a.b(r100);
            this.f526089b = r101;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r101.p(this.f526088a) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f526089b.matcher(r101.d(this.f526088a)).find() == false) goto L7;
            return true;
        }
    }

    public static final class h0 extends c {
        public final String toString() {
            return ":root";
        }

        public h0() {
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if ((r100 instanceof Document) == false) goto L5;
            r100 = (Element) ListProtector.get(r100.J(), 0);
        L5:
            if (r101 != r100) goto L8;
            return true;
        L8:
            return false;
        }
    }

    public static final class i extends AbstractC7096c {
        public final String toString() {
            return String.format("[%s!=%s]", new Object[]{this.f526085a, this.f526086b});
        }

        public i(String r100, String r101) {
            super(r100, r101, true);
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return !this.f526086b.equalsIgnoreCase(r101.d(this.f526085a));
        }
    }

    public static final class i0 extends c {
        public final String toString() {
            return ":matchText";
        }

        public i0() {
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if ((r101 instanceof org.jsoup.nodes.l) == false) goto L6;
            return true;
        L6:
            r101.getClass();
            ArrayList r102 = new ArrayList();
            Iterator<org.jsoup.nodes.j> r103 = r101.f525908f.iterator();
        L8:
            if (r103.hasNext() == false) goto L12;
            org.jsoup.nodes.j r104 = r103.next();
            if ((r104 instanceof org.jsoup.nodes.m) == false) goto L8;
            r102.add((org.jsoup.nodes.m) r104);
            goto L8
        L12:
            Iterator r105 = Collections.unmodifiableList(r102).iterator();
        L14:
            if (r105.hasNext() == false) goto L16;
            org.jsoup.nodes.m r106 = (org.jsoup.nodes.m) r105.next();
            org.jsoup.nodes.l r107 = new org.jsoup.nodes.l(org.jsoup.parser.f.a(r101.f525906d.f526034a, org.jsoup.parser.d.f526021d), r101.g(), r101.f());
            r106.getClass();
            ewc.b.d(r106.f525933a);
            r106.f525933a.C(r106, r107);
            r107.G(r106);
            goto L14
        L16:
            return false;
        }
    }

    public static final class j extends AbstractC7096c {
        public final String toString() {
            return String.format("[%s^=%s]", new Object[]{this.f526085a, this.f526086b});
        }

        public j(String r100, String r101) {
            super(r100, r101, false);
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r101.p(this.f526085a) == true) goto L5;
        L7:
            return false;
        L5:
            if (fwc.a.a(r101.d(this.f526085a)).startsWith(this.f526086b) == false) goto L7;
            return true;
        }
    }

    public static final class j0 extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Pattern f526090a;

        public final String toString() {
            return String.format(":matches(%s)", new Object[]{this.f526090a});
        }

        public j0(Pattern r100) {
            this.f526090a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return this.f526090a.matcher(r101.a0()).find();
        }
    }

    public static final class k extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526091a;

        public final String toString() {
            return String.format(".%s", new Object[]{this.f526091a});
        }

        public k(String r100) {
            this.f526091a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return r101.R(this.f526091a);
        }
    }

    public static final class k0 extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Pattern f526092a;

        public final String toString() {
            return String.format(":matchesOwn(%s)", new Object[]{this.f526092a});
        }

        public k0(Pattern r100) {
            this.f526092a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return this.f526092a.matcher(r101.X()).find();
        }
    }

    public static final class l extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526093a;

        public final String toString() {
            return String.format(":containsData(%s)", new Object[]{this.f526093a});
        }

        public l(String r100) {
            this.f526093a = fwc.a.a(r100);
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return fwc.a.a(r101.O()).contains(this.f526093a);
        }
    }

    public static final class l0 extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Pattern f526094a;

        public final String toString() {
            return String.format(":matchesWholeOwnText(%s)", new Object[]{this.f526094a});
        }

        public l0(Pattern r100) {
            this.f526094a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return this.f526094a.matcher(r101.c0()).find();
        }
    }

    public static final class m extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526095a;

        public final String toString() {
            return String.format(":containsOwn(%s)", new Object[]{this.f526095a});
        }

        public m(String r100) {
            StringBuilder r101 = fwc.b.b();
            fwc.b.a(r101, r100, false);
            this.f526095a = fwc.a.a(fwc.b.g(r101));
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return fwc.a.a(r101.X()).contains(this.f526095a);
        }
    }

    public static final class m0 extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Pattern f526096a;

        public final String toString() {
            return String.format(":matchesWholeText(%s)", new Object[]{this.f526096a});
        }

        public m0(Pattern r100) {
            this.f526096a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            Pattern r102 = this.f526096a;
            r101.getClass();
            StringBuilder r103 = fwc.b.b();
            org.jsoup.select.d.b(new org.jsoup.nodes.g(r103), r101);
            return r102.matcher(fwc.b.g(r103)).find();
        }
    }

    public static final class n extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526097a;

        public final String toString() {
            return String.format(":contains(%s)", new Object[]{this.f526097a});
        }

        public n(String r100) {
            StringBuilder r101 = fwc.b.b();
            fwc.b.a(r101, r100, false);
            this.f526097a = fwc.a.a(fwc.b.g(r101));
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return fwc.a.a(r101.a0()).contains(this.f526097a);
        }
    }

    public static final class n0 extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526098a;

        public final String toString() {
            return String.format("%s", new Object[]{this.f526098a});
        }

        public n0(String r100) {
            this.f526098a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return r101.f525906d.f526035b.equals(this.f526098a);
        }
    }

    public static final class o extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526099a;

        public final String toString() {
            return String.format(":containsWholeOwnText(%s)", new Object[]{this.f526099a});
        }

        public o(String r100) {
            this.f526099a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return r101.c0().contains(this.f526099a);
        }
    }

    public static final class o0 extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526100a;

        public final String toString() {
            return String.format("%s", new Object[]{this.f526100a});
        }

        public o0(String r100) {
            this.f526100a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return r101.f525906d.f526035b.endsWith(this.f526100a);
        }
    }

    public static final class p extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526101a;

        public final String toString() {
            return String.format(":containsWholeText(%s)", new Object[]{this.f526101a});
        }

        public p(String r100) {
            this.f526101a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            r101.getClass();
            StringBuilder r102 = fwc.b.b();
            org.jsoup.select.d.b(new org.jsoup.nodes.g(r102), r101);
            return fwc.b.g(r102).contains(this.f526101a);
        }
    }

    public static abstract class q extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f526102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f526103b;

        public abstract int b(Element r100);

        public abstract String c();

        public String toString() {
            if (this.f526102a != 0) goto L7;
            return String.format(":%s(%d)", new Object[]{c(), Integer.valueOf(this.f526103b)});
        L7:
            if (this.f526103b != 0) goto L11;
            return String.format(":%s(%dn)", new Object[]{c(), Integer.valueOf(this.f526102a)});
        L11:
            return String.format(":%s(%dn%+d)", new Object[]{c(), Integer.valueOf(this.f526102a), Integer.valueOf(this.f526103b)});
        }

        public q(int r100, int r101) {
            this.f526102a = r100;
            this.f526103b = r101;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            Element r102 = (Element) r101.f525933a;
            if (r102 != null) goto L5;
            return false;
        L5:
            if ((r102 instanceof Document) == true) goto L23;
            int r103 = b(r101);
            int r104 = this.f526102a;
            if (r104 == 0) goto L10;
            int r105 = r103 - this.f526103b;
            if ((r105 * r104) >= 0) goto L16;
            return false;
        L16:
            if ((r105 % r104) != 0) goto L22;
            return true;
        L22:
            return false;
        L10:
            if (r103 != this.f526103b) goto L19;
            return true;
        L19:
            return false;
        L23:
            return false;
        }
    }

    public static final class r extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f526104a;

        public final String toString() {
            return String.format("#%s", new Object[]{this.f526104a});
        }

        public r(String r100) {
            this.f526104a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            String r102 = this.f526104a;
            org.jsoup.nodes.b r103 = r101.f525909g;
            if (r103 == null) goto L5;
            String r104 = r103.f("id");
        L7:
            return r102.equals(r104);
        L5:
            r104 = "";
            goto L7
        }
    }

    public static final class s extends t {
        public final String toString() {
            return String.format(":eq(%d)", new Object[]{Integer.valueOf(this.f526105a)});
        }

        public s(int r100) {
            super(r100);
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r101.Q() != this.f526105a) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static abstract class t extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f526105a;

        public t(int r100) {
            this.f526105a = r100;
        }
    }

    public static final class u extends t {
        public final String toString() {
            return String.format(":gt(%d)", new Object[]{Integer.valueOf(this.f526105a)});
        }

        public u(int r100) {
            super(r100);
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r101.Q() <= this.f526105a) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class v extends t {
        public final String toString() {
            return String.format(":lt(%d)", new Object[]{Integer.valueOf(this.f526105a)});
        }

        public v(int r100) {
            super(r100);
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r100 != r101) goto L4;
        L6:
            return false;
        L4:
            if (r101.Q() >= this.f526105a) goto L6;
            return true;
        }
    }

    public static final class w extends c {
        public final String toString() {
            return ":empty";
        }

        public w() {
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            Iterator<org.jsoup.nodes.j> r102 = r101.j().iterator();
        L4:
            if (r102.hasNext() == false) goto L11;
            org.jsoup.nodes.j r103 = r102.next();
            if ((r103 instanceof org.jsoup.nodes.d) == true) goto L4;
            if ((r103 instanceof org.jsoup.nodes.f) == true) goto L4;
            return false;
        L11:
            return true;
        }
    }

    public static final class x extends c {
        public final String toString() {
            return ":first-child";
        }

        public x() {
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            Element r102 = (Element) r101.f525933a;
            if (r102 != null) goto L5;
        L9:
            return false;
        L5:
            if ((r102 instanceof Document) == true) goto L9;
            if (r101.Q() != 0) goto L9;
            return true;
        }
    }

    public static final class y extends e0 {
        public y() {
            super(0, 1);
        }

        @Override // org.jsoup.select.c.q
        public final String toString() {
            return ":first-of-type";
        }
    }

    public static final class z extends c {
        public final String toString() {
            return ":last-child";
        }

        public z() {
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            Element r102 = (Element) r101.f525933a;
            if (r102 != null) goto L5;
        L9:
            return false;
        L5:
            if ((r102 instanceof Document) == true) goto L9;
            if (r101.Q() != (r102.K().size() - 1)) goto L9;
            return true;
        }
    }

    public abstract boolean a(Element r100, Element r101);

    public c() {
    }
}
