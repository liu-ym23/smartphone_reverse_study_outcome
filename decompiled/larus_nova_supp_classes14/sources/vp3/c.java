package vp3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends d {
    public static final /* synthetic */ int k = 0;
    public wp3.b i;
    public wp3.f j;

    public static final class a {
    }

    static {
    }

    public c() {
        super(2);
    }

    @Override // vp3.d
    public final boolean c() {
        if (super.c() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.i != null) goto L9;
        if (this.j != null) goto L9;
        return true;
    }

    @Override // vp3.d, yp3.f
    public final <T> T b(yp3.e<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "elementKey");
        if (Intrinsics.areEqual(r3, yp3.b.a) == false) goto L9;
        Object r4 = this.i;
        if ((r4 instanceof Object) == true) goto L15;
        return null;
    L15:
        return (T) r4;
    L9:
        if (Intrinsics.areEqual(r3, yp3.d.a) == false) goto L14;
        r4 = this.j;
        if ((r4 instanceof Object) == true) goto L15;
        return null;
    L14:
        return (T) super.b(r3);
    }
}
