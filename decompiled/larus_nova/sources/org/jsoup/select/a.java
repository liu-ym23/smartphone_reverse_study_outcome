package org.jsoup.select;

import javax.annotation.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements NodeFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Element f526079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Element f526080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f526081c;

    public a(c r100) {
        this.f526079a = null;
        this.f526080b = null;
        this.f526081c = r100;
    }

    @Nullable
    public final Element a(Element r100, Element r101) {
        this.f526079a = r100;
        this.f526080b = null;
        d.a(this, r101);
        return this.f526080b;
    }
}
