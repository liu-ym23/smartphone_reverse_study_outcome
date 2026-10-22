package fl8;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f477747a;

    public e() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f477747a, ((e) r100).f477747a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Function0<Unit> r100 = this.f477747a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "FloatingThinkViewOutput(onClick=" + this.f477747a + ')';
    }

    public e(Function0<Unit> r100) {
        this.f477747a = r100;
    }
}
