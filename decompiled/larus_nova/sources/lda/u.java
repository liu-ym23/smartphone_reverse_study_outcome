package lda;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b0> f508836b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f508835a, r101.f508835a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508836b, r101.f508836b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f508835a.hashCode() * 31) + this.f508836b.hashCode();
    }

    public final String toString() {
        return "OmniRecordsChange(reason=" + this.f508835a + ", records=" + this.f508836b + ')';
    }

    public u(String r100, List<b0> r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Intrinsics.checkNotNullParameter(r101, "records");
        this.f508835a = r100;
        this.f508836b = r101;
    }
}
