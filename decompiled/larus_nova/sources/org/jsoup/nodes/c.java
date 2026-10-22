package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.UncheckedIOException;

/* JADX INFO: loaded from: classes42.dex */
public final class c extends m {
    @Override // org.jsoup.nodes.m, org.jsoup.nodes.j
    public final String t() {
        return "#cdata";
    }

    @Override // org.jsoup.nodes.m
    public final m H() {
        return (c) super.H();
    }

    @Override // org.jsoup.nodes.m, org.jsoup.nodes.j
    public final Object clone() throws CloneNotSupportedException {
        return (c) super.H();
    }

    @Override // org.jsoup.nodes.m, org.jsoup.nodes.j
    public final j k() {
        return (c) super.H();
    }

    public c(String r100) {
        super(r100);
    }

    @Override // org.jsoup.nodes.m, org.jsoup.nodes.j
    public final void v(Appendable r100, int r101, Document.OutputSettings r102) throws IOException {
        r100.append("<![CDATA[").append(F());
    }

    @Override // org.jsoup.nodes.m, org.jsoup.nodes.j
    public final void w(Appendable r100, int r101, Document.OutputSettings r102) {
        r100.append("]]>");     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new UncheckedIOException(e);
    }
}
