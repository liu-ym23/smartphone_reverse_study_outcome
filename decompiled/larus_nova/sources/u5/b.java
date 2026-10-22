package u5;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f548754a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f548754a, ((b) r100).f548754a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f548754a.hashCode();
    }

    public final String toString() {
        return "UIOperationsWrapper(uiOperations=" + this.f548754a + ')';
    }

    public b(List<a> r100) {
        Intrinsics.checkNotNullParameter(r100, "uiOperations");
        this.f548754a = r100;
    }
}
