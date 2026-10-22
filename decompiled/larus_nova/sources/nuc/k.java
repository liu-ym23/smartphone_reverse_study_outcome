package nuc;

import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class k extends l2<Byte, byte[], j> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f520722c = null;

    static {
        f520722c = new k();
    }

    @Override // nuc.l2
    public final byte[] k() {
        return new byte[0];
    }

    public k() {
        Intrinsics.checkNotNullParameter(ByteCompanionObject.INSTANCE, "<this>");
        super(l.f520729a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        byte[] r101 = (byte[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.length;
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        byte[] r101 = (byte[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return new j(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, byte[] r101, int r102) {
        byte[] r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeByteElement(this.f520733b, r104, r103[r104]);
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        j r104 = (j) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        byte r105 = r100.decodeByteElement(this.f520733b, r101);
        r104.getClass();
        j2.c(r104);
        byte[] r106 = r104.f520712a;
        int r107 = r104.f520713b;
        r104.f520713b = r107 + 1;
        r106[r107] = r105;
    }
}
