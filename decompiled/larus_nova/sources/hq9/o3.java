package hq9;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f486736b;

    public o3() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o3) == true) goto L8;
        return false;
    L8:
        o3 r101 = (o3) r100;
        if (this.f486735a == r101.f486735a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486736b, r101.f486736b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f486735a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f486736b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeTaskSettingsDisplayConfig(enableFilter=" + this.f486735a + ", itemAllowList=" + this.f486736b + ')';
    }

    public o3(Object r100) {
        Set<String> r101 = SetsKt.emptySet();
        Intrinsics.checkNotNullParameter(r101, "itemAllowList");
        this.f486735a = false;
        this.f486736b = r101;
    }
}
