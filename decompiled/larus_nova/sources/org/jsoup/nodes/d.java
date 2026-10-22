package org.jsoup.nodes;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public final class d extends i {
    @Override // org.jsoup.nodes.j
    public final String t() {
        return "#comment";
    }

    @Override // org.jsoup.nodes.j
    public final void w(Appendable r100, int r101, Document.OutputSettings r102) {
    }

    @Override // org.jsoup.nodes.j
    public final Object clone() throws CloneNotSupportedException {
        return (d) super.k();
    }

    @Override // org.jsoup.nodes.j
    public final j k() {
        return (d) super.k();
    }

    @Override // org.jsoup.nodes.j
    public final String toString() {
        return u();
    }

    public d(String r100) {
        this.f525931d = r100;
    }

    @Override // org.jsoup.nodes.j
    public final void v(Appendable r100, int r101, Document.OutputSettings r102) throws IOException {
        if (r102.f525897e == true) goto L5;
    L12:
        r100.append("<!--").append(F()).append("-->");
        return;
    L5:
        if (this.f525934b != 0) goto L12;
        j r103 = this.f525933a;
        if ((r103 instanceof Element) == false) goto L12;
        if (((Element) r103).f525906d.f526037d == false) goto L12;
        j.r(r100, r101, r102);
        goto L12
    }
}
