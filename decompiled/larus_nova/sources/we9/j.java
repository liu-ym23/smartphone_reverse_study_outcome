package we9;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class j implements xe9.c, xe9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f559435a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f559435a, ((j) r100).f559435a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f559435a.hashCode();
    }

    public final String toString() {
        return "SwitchScene(extra=" + this.f559435a + ')';
    }

    public j(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        this.f559435a = r100;
    }
}
