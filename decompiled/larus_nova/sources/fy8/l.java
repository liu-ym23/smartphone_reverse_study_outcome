package fy8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f479322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f479323b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f479322a == r101.f479322a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479323b, r101.f479323b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f479322a * 31) + this.f479323b.hashCode();
    }

    public final String toString() {
        return "InstructionInitConfig(canvasType=" + this.f479322a + ", traceMap=" + this.f479323b + ')';
    }

    public l(int r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "traceMap");
        this.f479322a = r100;
        this.f479323b = r101;
    }
}
