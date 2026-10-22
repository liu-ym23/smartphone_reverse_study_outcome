package nuc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
public final class t2 extends l2<Short, short[], s2> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t2 f520778c = null;

    static {
        f520778c = new t2();
    }

    @Override // nuc.l2
    public final short[] k() {
        return new short[0];
    }

    public t2() {
        Intrinsics.checkNotNullParameter(ShortCompanionObject.INSTANCE, "<this>");
        super(u2.f520784a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        short[] r101 = (short[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.length;
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        short[] r101 = (short[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return new s2(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, short[] r101, int r102) {
        short[] r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeShortElement(this.f520733b, r104, r103[r104]);
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        s2 r104 = (s2) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        short r105 = r100.decodeShortElement(this.f520733b, r101);
        r104.getClass();
        j2.c(r104);
        short[] r106 = r104.f520773a;
        int r107 = r104.f520774b;
        r104.f520774b = r107 + 1;
        r106[r107] = r105;
    }
}
