package xs8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565032b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f565031a, r101.f565031a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565032b, r101.f565032b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f565031a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f565032b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "SummarySegment(title=" + this.f565031a + ", value=" + this.f565032b + ')';
    }

    public m(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f565031a = r100;
        this.f565032b = r101;
    }
}
