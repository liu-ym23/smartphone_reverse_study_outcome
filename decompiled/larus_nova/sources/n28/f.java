package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f516754a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f516754a, ((f) r100).f516754a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Function0<Unit> r100 = this.f516754a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "OnAttachedToWindowParam(superMethod=" + this.f516754a + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516754a.invoke();
    }

    public f(Function0<Unit> r100) {
        this.f516754a = r100;
    }
}
