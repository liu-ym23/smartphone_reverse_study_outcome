package tub;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f547642a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f547642a, ((c) r100).f547642a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f547642a.hashCode();
    }

    public final String toString() {
        return "RecordingPrioritySnapshot(activeInstances=" + this.f547642a + ')';
    }

    public c(List<d> r100) {
        Intrinsics.checkNotNullParameter(r100, "activeInstances");
        this.f547642a = r100;
    }
}
