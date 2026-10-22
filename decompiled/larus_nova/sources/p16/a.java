package p16;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527323a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f527323a, ((a) r100).f527323a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f527323a.hashCode();
    }

    public final String toString() {
        return "ForestSessionId(forestSessionId=" + this.f527323a + ')';
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "forestSessionId");
        this.f527323a = r100;
    }
}
