package gtc;

import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f482714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g.f> f482715b;

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        j.a(r100, new j.a(), this);
        return r100.toString();
    }

    @Override // gtc.g.a
    public final List<g.f> a() {
        return this.f482715b;
    }

    @Override // gtc.g.a
    public final String name() {
        return this.f482714a;
    }

    public c(String r100, List<g.f> r101) {
        this.f482714a = r100;
        this.f482715b = r101;
    }
}
