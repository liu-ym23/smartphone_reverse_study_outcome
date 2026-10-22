package o58;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f522104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f522105b;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f522104a, r101.f522104a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522105b, r101.f522105b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.f522104a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f522105b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrClientRetryStrategy(disableRetryErrorCodeWithPrefixMatch=" + this.f522104a + ", enableRetryErrorCodeWithCompleteMatch=" + this.f522105b + ')';
    }

    public a(List<String> r100, List<String> r101) {
        this.f522104a = r100;
        this.f522105b = r101;
    }
}
