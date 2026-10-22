package ld7;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f508763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String[]> f508764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f508765c;

    public p() {
        this(false, false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f508763a == r101.f508763a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508764b, r101.f508764b) == true) goto L15;
        return false;
    L15:
        if (this.f508765c == r101.f508765c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f508763a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f508764b.hashCode()) * 31;
        if (this.f508765c == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "WebAuthStrategyConfig(enableJSBAuthV3=" + this.f508763a + ", privateDomains=" + this.f508764b + ", enableAutoMatchUrl=" + this.f508765c + ')';
    }

    public p(boolean r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        Map<String, String[]> r103 = MapsKt.emptyMap();
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = false;
    L12:
        Intrinsics.checkNotNullParameter(r103, "privateDomains");
        this.f508763a = r100;
        this.f508764b = r103;
        this.f508765c = r101;
        return;
    L8:
        r103 = null;
        goto L10
    }
}
