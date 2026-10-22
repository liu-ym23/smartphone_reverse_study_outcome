package lh7;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f509279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f509280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f509281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oh7.a f509282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final nh7.a f509283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<T, String> f509284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final mh7.a<T> f509285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f509286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f509287i;

    public b() {
        throw null;
    }

    public final boolean a(com.bytedance.timonbase.apicache.a r100) {
        mh7.a<T> r101 = this.f509285g;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = this.f509282d.a(this.f509283e, this.f509284f.invoke(r100));
        if (r102 == true) goto L10;
        this.f509281c++;
    L10:
        return r102;
    L5:
        if (r101.a(r100) == true) goto L7;
        return true;
    }

    public b(oh7.a r100, nh7.a r101, Function1 r102, mh7.a r103, boolean r104) {
        this.f509282d = r100;
        this.f509283e = r101;
        this.f509284f = r102;
        this.f509285g = r103;
        this.f509286h = r104;
        this.f509287i = "";
    }
}
