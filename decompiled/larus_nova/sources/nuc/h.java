package nuc;

import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class h extends l2<Boolean, boolean[], g> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f520697c = null;

    static {
        f520697c = new h();
    }

    @Override // nuc.l2
    public final boolean[] k() {
        return new boolean[0];
    }

    public h() {
        Intrinsics.checkNotNullParameter(BooleanCompanionObject.INSTANCE, "<this>");
        super(i.f520705a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        boolean[] r101 = (boolean[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.length;
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        boolean[] r101 = (boolean[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return new g(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, boolean[] r101, int r102) {
        boolean[] r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeBooleanElement(this.f520733b, r104, r103[r104]);
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        g r104 = (g) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        boolean r105 = r100.decodeBooleanElement(this.f520733b, r101);
        r104.getClass();
        j2.c(r104);
        boolean[] r106 = r104.f520677a;
        int r107 = r104.f520678b;
        r104.f520678b = r107 + 1;
        r106[r107] = r105;
    }
}
