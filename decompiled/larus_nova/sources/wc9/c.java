package wc9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<q> f559194b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f559193a, r101.f559193a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559194b, r101.f559194b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f559193a.hashCode() * 31) + this.f559194b.hashCode();
    }

    public final String toString() {
        return "ConvParticipantRequest(conversationId=" + this.f559193a + ", participants=" + this.f559194b + ')';
    }

    public c(String r100, List<q> r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "participants");
        this.f559193a = r100;
        this.f559194b = r101;
    }
}
