package gtc;

import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class k implements g.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f482730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g.c> f482731b;

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        j.c(r100, new j.a(), this);
        return r100.toString();
    }

    @Override // gtc.g.f
    public final List<g.c> a() {
        return this.f482731b;
    }

    @Override // gtc.g.f
    public final String name() {
        return this.f482730a;
    }

    public k(String r100, List<g.c> r101) {
        this.f482730a = r100;
        this.f482731b = r101;
    }
}
