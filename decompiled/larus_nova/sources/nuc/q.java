package nuc;

import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class q extends l2<Character, char[], p> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f520757c = null;

    static {
        f520757c = new q();
    }

    @Override // nuc.l2
    public final char[] k() {
        return new char[0];
    }

    public q() {
        Intrinsics.checkNotNullParameter(CharCompanionObject.INSTANCE, "<this>");
        super(r.f520761a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        char[] r101 = (char[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.length;
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        char[] r101 = (char[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return new p(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, char[] r101, int r102) {
        char[] r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeCharElement(this.f520733b, r104, r103[r104]);
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        p r104 = (p) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        char r105 = r100.decodeCharElement(this.f520733b, r101);
        r104.getClass();
        j2.c(r104);
        char[] r106 = r104.f520749a;
        int r107 = r104.f520750b;
        r104.f520750b = r107 + 1;
        r106[r107] = r105;
    }
}
