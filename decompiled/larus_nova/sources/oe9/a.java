package oe9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f523021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f523022b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f523021a == r101.f523021a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f523022b, r101.f523022b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f523021a * 31;
        String r101 = this.f523022b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AVError(code=" + this.f523021a + ", msg=" + this.f523022b + ')';
    }

    @Override // oe9.c
    public final String getMsg() {
        return this.f523022b;
    }

    public a(int r100, String r101) {
        this.f523021a = r100;
        this.f523022b = r101;
    }
}
