package kb8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f502266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f502268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f502269d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f502266a, r101.f502266a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502267b, r101.f502267b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502268c, r101.f502268c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502269d, r101.f502269d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f502266a.hashCode() * 31) + this.f502267b.hashCode()) * 31) + this.f502268c.hashCode()) * 31;
        String r101 = this.f502269d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ReferenceWrapper(reference=" + this.f502266a + ", uniqueExposeId=" + this.f502267b + ", cardId=" + this.f502268c + ", docId=" + this.f502269d + ')';
    }

    public u(Object r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "reference");
        Intrinsics.checkNotNullParameter(r101, "uniqueExposeId");
        Intrinsics.checkNotNullParameter(r102, "cardId");
        this.f502266a = r100;
        this.f502267b = r101;
        this.f502268c = r102;
        this.f502269d = r103;
    }
}
