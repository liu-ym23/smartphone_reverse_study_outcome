package org.jsoup.nodes;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public final class e extends i {
    @Override // org.jsoup.nodes.j
    public final String t() {
        return "#data";
    }

    @Override // org.jsoup.nodes.j
    public final void w(Appendable r100, int r101, Document.OutputSettings r102) {
    }

    @Override // org.jsoup.nodes.j
    public final Object clone() throws CloneNotSupportedException {
        return (e) super.k();
    }

    @Override // org.jsoup.nodes.j
    public final j k() {
        return (e) super.k();
    }

    @Override // org.jsoup.nodes.j
    public final String toString() {
        return u();
    }

    public e(String r100) {
        this.f525931d = r100;
    }

    @Override // org.jsoup.nodes.j
    public final void v(Appendable r100, int r101, Document.OutputSettings r102) throws IOException {
        r100.append(F());
    }
}
