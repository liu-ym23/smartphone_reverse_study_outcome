package org.jsoup.nodes;

import org.jsoup.select.Elements;

/* JADX INFO: loaded from: classes42.dex */
public final class h extends Element {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Elements f525930k;

    @Override // org.jsoup.nodes.Element
    public final Element N() {
        return (h) super.N();
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public final Object clone() throws CloneNotSupportedException {
        return (h) super.N();
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public final j k() {
        return (h) super.N();
    }

    @Override // org.jsoup.nodes.j
    public final void B(j r100) {
        super.B(r100);
        this.f525930k.remove(r100);
    }

    public h(org.jsoup.parser.f r100, b r101) {
        super(r100, null, r101);
        this.f525930k = new Elements();
    }
}
