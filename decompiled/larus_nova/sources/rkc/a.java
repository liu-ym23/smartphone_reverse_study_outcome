package rkc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538439a;

    public final int hashCode() {
        return this.f538439a.hashCode();
    }

    public final String toString() {
        return "OfficeSDKServiceKey(" + this.f538439a + ')';
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f538439a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((a) r100).f538439a, this.f538439a) == false) goto L7;
        return true;
    }
}
