package pf9;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f528964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f528965b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f528964a, r101.f528964a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528965b, r101.f528965b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f528964a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f528965b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowLLMCommandReply(commandType=" + this.f528964a + ", commandParams=" + this.f528965b + ')';
    }

    public p(Long r100, Map<String, String> r101) {
        this.f528964a = r100;
        this.f528965b = r101;
    }
}
