package jl8;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f499555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f499556b;

    public g() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f499555a, r101.f499555a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499556b, r101.f499556b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Function0<Unit> r100 = this.f499555a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function0<Unit> r104 = this.f499556b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GenericToolViewOutput(onShow=" + this.f499555a + ", onClick=" + this.f499556b + ')';
    }

    public g(Function0<Unit> r100, Function0<Unit> r101) {
        this.f499555a = r100;
        this.f499556b = r101;
    }
}
