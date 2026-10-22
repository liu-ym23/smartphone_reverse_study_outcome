package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f516749a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f516749a, ((b) r100).f516749a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Function0<Unit> r100 = this.f516749a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ComputeScrollParam(superMethod=" + this.f516749a + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516749a.invoke();
    }

    public b(Function0<Unit> r100) {
        this.f516749a = r100;
    }
}
