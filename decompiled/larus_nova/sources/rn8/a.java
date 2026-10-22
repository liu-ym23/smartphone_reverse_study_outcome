package rn8;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pair<Integer, Integer> f538693a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f538693a, ((a) r100).f538693a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Pair<Integer, Integer> r100 = this.f538693a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "SplitLineViewInput(topAndBottomMarginPair=" + this.f538693a + ')';
    }

    public a(Pair<Integer, Integer> r100) {
        this.f538693a = r100;
    }
}
