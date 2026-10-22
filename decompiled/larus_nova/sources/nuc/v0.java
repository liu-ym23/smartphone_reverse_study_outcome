package nuc;

import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class v0 extends l2<Integer, int[], u0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v0 f520787c = null;

    static {
        f520787c = new v0();
    }

    @Override // nuc.l2
    public final int[] k() {
        return new int[0];
    }

    public v0() {
        kuc.a.e(IntCompanionObject.INSTANCE);
        super(w0.f520792a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        int[] r101 = (int[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.length;
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        int[] r101 = (int[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return new u0(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, int[] r101, int r102) {
        int[] r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeIntElement(this.f520733b, r104, r103[r104]);
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        u0 r104 = (u0) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        int r105 = r100.decodeIntElement(this.f520733b, r101);
        r104.getClass();
        j2.c(r104);
        int[] r106 = r104.f520779a;
        int r107 = r104.f520780b;
        r104.f520780b = r107 + 1;
        r106[r107] = r105;
    }
}
