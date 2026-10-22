package wc9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f559191a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f559191a, ((a) r100).f559191a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f559191a.hashCode();
    }

    public final String toString() {
        return "BatchGetParticipantRequest(convParticipantList=" + this.f559191a + ')';
    }

    public a(List<c> r100) {
        Intrinsics.checkNotNullParameter(r100, "convParticipantList");
        this.f559191a = r100;
    }
}
