package gtc;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes41.dex */
public final class f implements g.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f482716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f482717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f482718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f482719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g.a f482720e;

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        j.b(r100, new j.a(), this);
        return r100.toString();
    }

    @Override // gtc.g.c
    public final boolean a() {
        return this.f482718c;
    }

    @Override // gtc.g.c
    public final String alias() {
        return this.f482719d;
    }

    @Override // gtc.g.c
    public final Pattern b() {
        return this.f482716a;
    }

    @Override // gtc.g.c
    public final boolean c() {
        return this.f482717b;
    }

    @Override // gtc.g.c
    public final g.a d() {
        return this.f482720e;
    }

    public f(Pattern r100, boolean r101, boolean r102, String r103, g.a r104) {
        this.f482716a = r100;
        this.f482717b = r101;
        this.f482718c = r102;
        this.f482719d = r103;
        this.f482720e = r104;
    }
}
