package ue8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j> f549809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f549810b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f549809a, r101.f549809a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549810b, r101.f549810b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f549809a.hashCode() * 31) + this.f549810b.hashCode();
    }

    public final String toString() {
        return "EvaluationResult(toExpose=" + this.f549809a + ", toDismiss=" + this.f549810b + ')';
    }

    public c(List<j> r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "toExpose");
        Intrinsics.checkNotNullParameter(r101, "toDismiss");
        this.f549809a = r100;
        this.f549810b = r101;
    }
}
