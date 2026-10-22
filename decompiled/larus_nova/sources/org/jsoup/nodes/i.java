package org.jsoup.nodes;

import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public abstract class i extends j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f525931d;

    @Override // org.jsoup.nodes.j
    public final int i() {
        return 0;
    }

    @Override // org.jsoup.nodes.j
    public final j m() {
        return this;
    }

    public final void G() {
        Object r100 = this.f525931d;
        if ((r100 instanceof b) == true) goto L8;
        b r101 = new b();
        this.f525931d = r101;
        if (r100 == null) goto L9;
        r101.k(t(), (String) r100);
        return;
    L9:
        return;
    }

    @Override // org.jsoup.nodes.j
    public final String g() {
        j r100 = this.f525933a;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        return "";
    L10:
        return r100.g();
    L5:
        r101 = false;
        goto L6
    }

    @Override // org.jsoup.nodes.j
    public final boolean q() {
        return this.f525931d instanceof b;
    }

    public final String F() {
        return d(t());
    }

    @Override // org.jsoup.nodes.j
    public final b f() {
        G();
        return (b) this.f525931d;
    }

    public i() {
    }

    @Override // org.jsoup.nodes.j
    public final List<j> n() {
        return j.f525932c;
    }

    @Override // org.jsoup.nodes.j
    public final String a(String r100) {
        G();
        return super.a(r100);
    }

    @Override // org.jsoup.nodes.j
    public final String d(String r100) {
        if ((this.f525931d instanceof b) == true) goto L10;
        if (t().equals(r100) == true) goto L11;
        return "";
    L11:
        return (String) this.f525931d;
    L10:
        return super.d(r100);
    }

    @Override // org.jsoup.nodes.j
    public final j l(j r100) {
        i r101 = (i) super.l(r100);
        Object r102 = this.f525931d;
        if ((r102 instanceof b) == false) goto L5;
        r101.f525931d = ((b) r102).d();
    L5:
        return r101;
    }

    @Override // org.jsoup.nodes.j
    public final void e(String r100, String r101) {
        if ((this.f525931d instanceof b) == false) goto L5;
    L7:
        G();
        super.e(r100, r101);
        return;
    L5:
        if (r100.equals("#doctype") == false) goto L7;
        this.f525931d = r101;
    }
}
