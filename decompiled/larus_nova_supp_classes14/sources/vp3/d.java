package vp3;

import kotlin.jvm.internal.Intrinsics;
import wp3.g;
import yp3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class d extends b {
    public g e;
    public wp3.e f;
    public wp3.d g;
    public wp3.a h;

    public boolean c() {
        if (this.e != null) goto L5;
    L9:
        return false;
    L5:
        if (this.f != null) goto L9;
        if (this.g != null) goto L9;
        return true;
    }

    public d(int r1) {
        super(r1);
    }

    public <T> T b(yp3.e<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "elementKey");
        if (Intrinsics.areEqual(r3, h.a) == false) goto L9;
        Object r4 = this.e;
        if ((r4 instanceof Object) == true) goto L22;
        return null;
    L22:
        return (T) r4;
    L9:
        if (Intrinsics.areEqual(r3, yp3.g.a) == false) goto L14;
        r4 = this.f;
        if ((r4 instanceof Object) == true) goto L22;
        return null;
    L14:
        if (Intrinsics.areEqual(r3, yp3.c.a) == false) goto L19;
        r4 = this.g;
        if ((r4 instanceof Object) == true) goto L22;
        return null;
    L19:
        if (Intrinsics.areEqual(r3, yp3.a.a) == false) goto L23;
        r4 = this.h;
        if ((r4 instanceof Object) == true) goto L22;
        return null;
    L23:
        return null;
    }
}
