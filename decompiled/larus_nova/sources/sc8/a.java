package sc8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f541377a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f541377a, ((a) r100).f541377a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.f541377a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "BubbleBannerActionResult(params=" + this.f541377a + ')';
    }

    public a(Map<String, String> r100) {
        this.f541377a = r100;
    }
}
