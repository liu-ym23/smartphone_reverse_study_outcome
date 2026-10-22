package ti4;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<DATA> f546061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f546062b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f546061a, r101.f546061a) == true) goto L12;
        return false;
    L12:
        if (this.f546062b == r101.f546062b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f546061a.hashCode() * 31;
        if (this.f546062b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ConfirmInfo(list=" + this.f546061a + ", isFromConfirmButton=" + this.f546062b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends DATA> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f546061a = r100;
        this.f546062b = r101;
    }
}
