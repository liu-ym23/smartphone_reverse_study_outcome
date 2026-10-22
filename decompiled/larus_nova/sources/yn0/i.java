package yn0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements l81.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f568505a = null;

    public i() {
    }

    static {
        f568505a = new i();
    }

    @Override // l81.i
    public final void a(d90.d r100, j70.f r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "elementType");
        if ((r100 instanceof d90.a) == true) goto L5;
        r100 = null;
    L5:
        d90.a r103 = (d90.a) r100;
        if (r103 == null) goto L9;
        d90.c.b(r103, r101, r102);
        return;
    }
}
