package m7c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f512432b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f512431a, r101.f512431a) == true) goto L12;
        return false;
    L12:
        if (this.f512432b == r101.f512432b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f512431a.hashCode() * 31;
        if (this.f512432b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "TitleClickData(sectionGuid=" + this.f512431a + ", isExpand=" + this.f512432b + ')';
    }

    public m(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionGuid");
        this.f512431a = r100;
        this.f512432b = r101;
    }
}
