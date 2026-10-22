package wc9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f559233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f559234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f559235c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f559233a, r101.f559233a) == true) goto L12;
        return false;
    L12:
        if (this.f559234b == r101.f559234b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f559235c, r101.f559235c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f559233a.hashCode() * 31;
        if (this.f559234b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        f r103 = this.f559235c;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ConversationListResponse(result=" + this.f559233a + ", hasMore=" + this.f559234b + ", nextAnchor=" + this.f559235c + ')';
    }

    public h(List<e> r100, boolean r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f559233a = r100;
        this.f559234b = r101;
        this.f559235c = r102;
    }
}
