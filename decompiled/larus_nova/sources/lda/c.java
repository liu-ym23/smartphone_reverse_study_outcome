package lda;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508800a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f508800a, ((c) r100).f508800a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f508800a.hashCode();
    }

    public final String toString() {
        return "OmniExecutionStep(description=" + this.f508800a + ')';
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "description");
        this.f508800a = r100;
    }
}
