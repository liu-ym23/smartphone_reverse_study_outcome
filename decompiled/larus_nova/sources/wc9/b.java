package wc9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f559192a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f559192a, ((b) r100).f559192a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f559192a.hashCode();
    }

    public final String toString() {
        return "BatchGetResponse(convParticipantList=" + this.f559192a + ')';
    }

    public b(List<d> r100) {
        Intrinsics.checkNotNullParameter(r100, "convParticipantList");
        this.f559192a = r100;
    }
}
