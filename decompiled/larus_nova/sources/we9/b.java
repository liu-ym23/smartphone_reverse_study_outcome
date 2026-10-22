package we9;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements xe9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f559412a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f559412a, ((b) r100).f559412a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f559412a.hashCode();
    }

    public final String toString() {
        return "ClientSync(extra=" + this.f559412a + ')';
    }

    public b(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        this.f559412a = r100;
    }
}
