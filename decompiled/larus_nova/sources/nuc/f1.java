package nuc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
public final class f1 extends l2<Long, long[], e1> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f1 f520674c = null;

    static {
        f520674c = new f1();
    }

    @Override // nuc.l2
    public final long[] k() {
        return new long[0];
    }

    public f1() {
        Intrinsics.checkNotNullParameter(LongCompanionObject.INSTANCE, "<this>");
        super(g1.f520681a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        long[] r101 = (long[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.length;
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        long[] r101 = (long[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return new e1(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, long[] r101, int r102) {
        long[] r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeLongElement(this.f520733b, r104, r103[r104]);
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        e1 r104 = (e1) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        long r105 = r100.decodeLongElement(this.f520733b, r101);
        r104.getClass();
        j2.c(r104);
        long[] r106 = r104.f520666a;
        int r107 = r104.f520667b;
        r104.f520667b = r107 + 1;
        r106[r107] = r105;
    }
}
