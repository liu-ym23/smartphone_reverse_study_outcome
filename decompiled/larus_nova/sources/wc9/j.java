package wc9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<l> f559241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f559242b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f559241a, r101.f559241a) == true) goto L12;
        return false;
    L12:
        if (this.f559242b == r101.f559242b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<l> r100 = this.f559241a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f559242b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationPagingDataNew(data=" + this.f559241a + ", done=" + this.f559242b + ')';
    }

    public j(List<l> r100, boolean r101) {
        this.f559241a = r100;
        this.f559242b = r101;
    }
}
