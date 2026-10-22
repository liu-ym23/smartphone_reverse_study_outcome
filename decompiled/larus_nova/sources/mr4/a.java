package mr4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f514980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f514981b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f514980a, r101.f514980a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514981b, r101.f514981b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f514980a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f514981b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SrcObjInfo(srcObjToken=" + this.f514980a + ", srcObjType=" + this.f514981b + ')';
    }

    public a(String r100, Integer r101) {
        this.f514980a = r100;
        this.f514981b = r101;
    }
}
