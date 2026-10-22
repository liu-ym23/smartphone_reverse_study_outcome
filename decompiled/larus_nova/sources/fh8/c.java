package fh8;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f477069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f477070b;

    public c() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f477069a, r101.f477069a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f477070b, r101.f477070b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        d r100 = this.f477069a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function0<Unit> r104 = this.f477070b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeepThinkCoordinator(deepThinkFoldStatusManager=" + this.f477069a + ", requestExpandDeepThinkArea=" + this.f477070b + ')';
    }

    public /* synthetic */ c(d r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null);
    }

    public c(d r100, Function0<Unit> r101) {
        this.f477069a = r100;
        this.f477070b = r101;
    }
}
