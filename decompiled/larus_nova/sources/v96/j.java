package v96;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f553803b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f553802a, r101.f553802a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553803b, r101.f553803b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f553802a.hashCode() * 31;
        Map<String, Object> r101 = this.f553803b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "YataApi(api=" + this.f553802a + ", extraParams=" + this.f553803b + ')';
    }

    public j(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "api");
        this.f553802a = r100;
        this.f553803b = r101;
    }
}
