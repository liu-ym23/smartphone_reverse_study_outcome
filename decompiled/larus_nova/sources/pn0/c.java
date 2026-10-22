package pn0;

import com.obric.sva.sdk.data.ISmModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f529898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f529899l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f529900m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f529901n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<Integer> f529902o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f529903p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d.a f529904q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f529905r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<Integer> f529906s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Long f529907t;

    public c() {
        throw null;
    }

    @Override // pn0.d
    public final String toString() {
        return "{uiLayout = " + this.f529898k + ", windowCount = " + this.f529899l + ", orientation = " + this.f529900m + ", isStatusBarVisible = " + this.f529901n + ", playMode = " + this.f529902o + ", isAnchor = " + this.f529903p + '}';
    }

    @Override // pn0.d
    public final boolean a() {
        return this.f529905r;
    }

    @Override // pn0.d
    public final int b() {
        return this.f529900m;
    }

    @Override // pn0.d
    public final List<Integer> c() {
        return this.f529902o;
    }

    @Override // pn0.d
    public final Long d() {
        return this.f529907t;
    }

    @Override // pn0.d
    public final d.a e() {
        return this.f529904q;
    }

    @Override // pn0.d
    public final List<Integer> f() {
        return this.f529906s;
    }

    @Override // pn0.d
    public final int g() {
        return this.f529898k;
    }

    @Override // pn0.d
    public final boolean h() {
        return this.f529903p;
    }

    @Override // pn0.d
    public final boolean i() {
        return this.f529901n;
    }

    public c(int r210, int r211, int r212, boolean r213, boolean r214, i r310, boolean r311, List r312, Long r313, Object r314, int r315) {
        if ((r315 & 4) == 0) goto L5;
        int r110 = 0;
    L7:
        if ((r315 & 8) == 0) goto L9;
        boolean r111 = true;
    L11:
        if ((r315 & 32) == 0) goto L13;
        boolean r112 = false;
    L15:
        if ((r315 & 128) == 0) goto L17;
        d.a r113 = new d.a(new StringBuilder());
    L19:
        if ((r315 & 256) == 0) goto L21;
        boolean r100 = false;
    L23:
        if ((r315 & 512) == 0) goto L25;
        List r101 = null;
    L27:
        if ((r315 & 1024) == 0) goto L29;
        Long r102 = null;
    L30:
        Intrinsics.checkNotNullParameter(r113, "traceInfo");
        super(r210, r110, r111, null, r112, r113, r100, null, null, r314, ISmModel.VERSION_0300);
        this.f529898k = r210;
        this.f529899l = r211;
        this.f529900m = r110;
        this.f529901n = r111;
        this.f529902o = null;
        this.f529903p = r112;
        this.f529904q = r113;
        this.f529905r = r100;
        this.f529906s = r101;
        this.f529907t = r102;
        return;
    L29:
        r102 = r313;
        goto L30
    L25:
        r101 = r312;
        goto L27
    L21:
        r100 = r311;
        goto L23
    L17:
        r113 = null;
        goto L19
    L13:
        r112 = r214;
        goto L15
    L9:
        r111 = r213;
        goto L11
    L5:
        r110 = r212;
        goto L7
    }
}
