package id6;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.c;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f489337c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f489338b;

    static {
        f489337c = new b();
    }

    @Override // id6.a
    public final void Q2(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f489338b.Q2(r100, r101, r102);
    }

    @Override // id6.a
    public final void Y2(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f489338b.Y2(r100, r101, r102);
    }

    @Override // id6.a
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f489338b.e(r100, r101);
    }

    @Override // id6.a
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f489338b.w(r100, r101);
    }

    public b() {
        pd6.b r100 = c.f528682a;
        pd6.a r101 = c.a(Reflection.getOrCreateKotlinClass(a.class));
        Intrinsics.checkNotNull(r101);
        this.f489338b = (a) r101;
    }
}
