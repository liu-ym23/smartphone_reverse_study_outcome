package nuc;

import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class k0 extends l2<Float, float[], j0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k0 f520723c = null;

    static {
        f520723c = new k0();
    }

    @Override // nuc.l2
    public final float[] k() {
        return new float[0];
    }

    public k0() {
        Intrinsics.checkNotNullParameter(FloatCompanionObject.INSTANCE, "<this>");
        super(l0.f520731a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        float[] r101 = (float[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.length;
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        float[] r101 = (float[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return new j0(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, float[] r101, int r102) {
        float[] r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeFloatElement(this.f520733b, r104, r103[r104]);
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        j0 r104 = (j0) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        float r105 = r100.decodeFloatElement(this.f520733b, r101);
        r104.getClass();
        j2.c(r104);
        float[] r106 = r104.f520714a;
        int r107 = r104.f520715b;
        r104.f520715b = r107 + 1;
        r106[r107] = r105;
    }
}
