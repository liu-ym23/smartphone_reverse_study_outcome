package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;

/* JADX INFO: loaded from: classes42.dex */
public abstract class f extends org.jsoup.select.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.jsoup.select.c f526114a;

    public static class a extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final org.jsoup.select.a f526115b;

        public final String toString() {
            return String.format(":has(%s)", new Object[]{this.f526114a});
        }

        public a(org.jsoup.select.c r100) {
            this.f526114a = r100;
            this.f526115b = new org.jsoup.select.a(r100);
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            int r102 = 0;
        L4:
            if (r102 >= r101.i()) goto L12;
            j r103 = r101.h(r102);
            if ((r103 instanceof Element) == false) goto L11;
            if (this.f526115b.a(r101, (Element) r103) == null) goto L11;
            return true;
        L11:
            r102 = r102 + 1;
            goto L4
        L12:
            return false;
        }
    }

    public static class b extends f {
        public final String toString() {
            return String.format("%s > ", new Object[]{this.f526114a});
        }

        public b(org.jsoup.select.c r100) {
            this.f526114a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r100 != r101) goto L5;
            return false;
        L5:
            Element r102 = (Element) r101.f525933a;
            if (r102 != null) goto L8;
            return false;
        L8:
            if (this.f526114a.a(r100, r102) == false) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public static class c extends f {
        public final String toString() {
            return String.format("%s + ", new Object[]{this.f526114a});
        }

        public c(org.jsoup.select.c r100) {
            this.f526114a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r100 != r101) goto L5;
            return false;
        L5:
            Element r102 = r101.Y();
            if (r102 != null) goto L8;
            return false;
        L8:
            if (this.f526114a.a(r100, r102) == false) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public static class d extends f {
        public final String toString() {
            return String.format(":not(%s)", new Object[]{this.f526114a});
        }

        public d(org.jsoup.select.c r100) {
            this.f526114a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            return !this.f526114a.a(r100, r101);
        }
    }

    public static class e extends f {
        public final String toString() {
            return String.format("%s ", new Object[]{this.f526114a});
        }

        public e(org.jsoup.select.c r100) {
            this.f526114a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r100 != r101) goto L5;
            return false;
        L5:
            Element r102 = (Element) r101.f525933a;
        L6:
            if (r102 == null) goto L14;
            if (this.f526114a.a(r100, r102) == true) goto L9;
            if (r102 == r100) goto L14;
            r102 = (Element) r102.f525933a;
            goto L6
        L9:
            return true;
        L14:
            return false;
        }
    }

    /* JADX INFO: renamed from: org.jsoup.select.f$f, reason: collision with other inner class name */
    public static class C7097f extends f {
        public final String toString() {
            return String.format("%s ~ ", new Object[]{this.f526114a});
        }

        public C7097f(org.jsoup.select.c r100) {
            this.f526114a = r100;
        }

        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r100 != r101) goto L5;
            return false;
        L5:
            Element r102 = r101.Y();
        L6:
            if (r102 == null) goto L12;
            if (this.f526114a.a(r100, r102) == true) goto L9;
            r102 = r102.Y();
            goto L6
        L9:
            return true;
        L12:
            return false;
        }
    }

    public static class g extends org.jsoup.select.c {
        @Override // org.jsoup.select.c
        public final boolean a(Element r100, Element r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        public g() {
        }
    }

    public f() {
    }
}
