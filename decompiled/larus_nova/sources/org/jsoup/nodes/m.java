package org.jsoup.nodes;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public class m extends i {
    @Override // org.jsoup.nodes.j
    public String t() {
        return "#text";
    }

    @Override // org.jsoup.nodes.j
    public void w(Appendable r100, int r101, Document.OutputSettings r102) {
    }

    public m H() {
        return (m) super.k();
    }

    @Override // org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return H();
    }

    @Override // org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ j k() {
        return H();
    }

    @Override // org.jsoup.nodes.j
    public final String toString() {
        return u();
    }

    public m(String r100) {
        this.f525931d = r100;
    }

    public static boolean I(StringBuilder r100) {
        if (r100.length() != 0) goto L5;
    L7:
        return false;
    L5:
        if (r100.charAt(r100.length() - 1) != ' ') goto L7;
        return true;
    }

    @Override // org.jsoup.nodes.j
    public void v(Appendable r110, int r111, Document.OutputSettings r112) throws IOException {
        boolean r100 = r112.f525897e;
        j r101 = this.f525933a;
        boolean r102 = r101 instanceof Element;
        if (r102 == false) goto L5;
        Element r103 = (Element) r101;
    L6:
        boolean r104 = true;
        boolean r105 = false;
        if (r100 == false) goto L20;
        List<Element> r106 = Element.f525903h;
        if (r102 == false) goto L17;
        Element r107 = (Element) r101;
        int r108 = 0;
    L12:
        if (r107.f525906d.f526040g == true) goto L13;
        r107 = (Element) r107.f525933a;
        r108 = r108 + 1;
        if (r108 >= 6) goto L17;
        if (r107 != null) goto L12;
    L13:
        boolean r109 = true;
    L18:
        if (r109 == true) goto L20;
        boolean r113 = true;
    L21:
        if (r113 == true) goto L23;
        boolean r114 = false;
    L63:
        Entities.b(r110, F(), r112, false, r113, r114, r105);
        return;
    L23:
        if (this.f525934b != 0) goto L28;
        if (r103 == null) goto L28;
        if (r103.f525906d.f526036c == false) goto L28;
    L29:
        boolean r115 = true;
    L32:
        if (s() != null) goto L37;
        if (r103 == null) goto L37;
        if (r103.f525906d.f526036c == false) goto L37;
        boolean r116 = true;
    L38:
        j r117 = s();
        if ((r117 instanceof Element) == false) goto L43;
        if (((Element) r117).Z(r112) == false) goto L43;
    L48:
        if (r104 == false) goto L53;
        if (fwc.b.d(F()) == false) goto L53;
        return;
    L53:
        if (this.f525934b != 0) goto L61;
        if (r103 == null) goto L61;
        if (r103.f525906d.f526037d == false) goto L61;
        if (fwc.b.d(F()) == true) goto L61;
        j.r(r110, r111, r112);
    L61:
        r114 = r115;
        r105 = r116;
    L43:
        if ((r117 instanceof m) == true) goto L45;
    L47:
        r104 = false;
        goto L48
    L45:
        if (fwc.b.d(((m) r117).F()) == false) goto L47;
    L37:
        r116 = false;
    L28:
        if ((this.f525933a instanceof Document) == true) goto L29;
        r115 = false;
    L17:
        r109 = false;
    L20:
        r113 = false;
        goto L21
    L5:
        r103 = null;
        goto L6
    }
}
