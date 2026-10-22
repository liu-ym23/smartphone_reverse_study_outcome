package gwc;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;
import org.jsoup.select.Elements;
import org.jsoup.select.c;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Element f483080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Elements f483081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f483082c;

    @Override // gwc.b
    public final void a(j r100, int r101) {
    }

    @Override // gwc.b
    public final void b(j r100, int r101) {
        if ((r100 instanceof Element) == false) goto L8;
        Element r102 = (Element) r100;
        if (this.f483082c.a(this.f483080a, r102) == false) goto L9;
        this.f483081b.add(r102);
        return;
    L9:
        return;
    }

    public a(Element r100, Elements r101, c r102) {
        this.f483080a = r100;
        this.f483081b = r101;
        this.f483082c = r102;
    }
}
