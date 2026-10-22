package hn8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f486140a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f486140a, ((i) r100).f486140a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f486140a.hashCode();
    }

    public final String toString() {
        return "SearchListContainerOutput(callBackData=" + this.f486140a + ')';
    }

    public i(k r100) {
        Intrinsics.checkNotNullParameter(r100, "callBackData");
        this.f486140a = r100;
    }
}
