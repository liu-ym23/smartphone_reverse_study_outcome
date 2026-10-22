package u5;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f548756b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f548755a, r101.f548755a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548756b, r101.f548756b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f548755a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f548756b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "UIUOperationsPluginParams(cardId=" + this.f548755a + ", uiOperations=" + this.f548756b + ')';
    }

    public c(String r100, List<a> r101) {
        Intrinsics.checkNotNullParameter(r101, "uiOperations");
        this.f548755a = r100;
        this.f548756b = r101;
    }
}
