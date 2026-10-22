package oe4;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f522997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f522998c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f522996a, r101.f522996a) == true) goto L12;
        return false;
    L12:
        if (this.f522997b == r101.f522997b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f522998c, r101.f522998c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f522996a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f522997b) * 31;
        Map<String, Object> r104 = this.f522998c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CJPaySmartResult(output=" + this.f522996a + ", errorCode=" + this.f522997b + ", extra=" + this.f522998c + ')';
    }

    public d(String r100, int r101, Map<String, ? extends Object> r102) {
        this.f522996a = r100;
        this.f522997b = r101;
        this.f522998c = r102;
    }
}
