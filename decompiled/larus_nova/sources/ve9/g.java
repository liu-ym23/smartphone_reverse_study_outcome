package ve9;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f554467a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f554467a, ((g) r100).f554467a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f554467a.hashCode();
    }

    public final String toString() {
        return "FlowLinkSessionConfig(params=" + this.f554467a + ')';
    }

    public g(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f554467a = r100;
    }
}
