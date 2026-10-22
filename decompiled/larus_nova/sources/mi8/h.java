package mi8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f514125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f514126b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f514125a, r101.f514125a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514126b, r101.f514126b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f514125a.hashCode() * 31) + this.f514126b.hashCode();
    }

    public final String toString() {
        return "MoaGrantingPrepareRequest(schemaPayloads=" + this.f514125a + ", messageContext=" + this.f514126b + ')';
    }

    public h(List<String> r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaPayloads");
        Intrinsics.checkNotNullParameter(r101, "messageContext");
        this.f514125a = r100;
        this.f514126b = r101;
    }
}
