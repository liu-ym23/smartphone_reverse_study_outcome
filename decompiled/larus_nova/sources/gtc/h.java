package gtc;

import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class h implements g.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f482722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends g.b> f482723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f482724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f482725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f482726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f482727f;

    @Override // gtc.g.b
    public final boolean d() {
        return true;
    }

    @Override // gtc.g.b
    public final int c() {
        return this.f482725d.length();
    }

    public final String toString() {
        return "SyntaxImpl{type='" + this.f482722a + "', children=" + this.f482723b + ", alias='" + this.f482724c + "', matchedString='" + this.f482725d + "', greedy=" + this.f482726e + ", tokenized=" + this.f482727f + '}';
    }

    @Override // gtc.g.d
    public final boolean a() {
        return this.f482726e;
    }

    @Override // gtc.g.d
    public final String alias() {
        return this.f482724c;
    }

    @Override // gtc.g.d
    public final List<? extends g.b> children() {
        return this.f482723b;
    }

    @Override // gtc.g.d
    public final String type() {
        return this.f482722a;
    }

    public h(String r100, List<? extends g.b> r101, String r102, String r103, boolean r104, boolean r105) {
        this.f482722a = r100;
        this.f482723b = r101;
        this.f482724c = r102;
        this.f482725d = r103;
        this.f482726e = r104;
        this.f482727f = r105;
    }
}
