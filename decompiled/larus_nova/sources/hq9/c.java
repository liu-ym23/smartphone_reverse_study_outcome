package hq9;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f486552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f486553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f486554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f486555e;

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f486551a == r101.f486551a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486552b, r101.f486552b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486553c, r101.f486553c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486554d, r101.f486554d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486555e, r101.f486555e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f486551a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((((r100 * 31) + this.f486552b.hashCode()) * 31) + this.f486553c.hashCode()) * 31) + this.f486554d.hashCode()) * 31;
        String r102 = this.f486555e;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "AboutAppDisplayConfig(enableFilter=" + this.f486551a + ", sectionAllowList=" + this.f486552b + ", itemAllowList=" + this.f486553c + ", itemLinkMap=" + this.f486554d + ", appDisplayName=" + this.f486555e + ')';
    }

    public c(Object r100) {
        Set<String> r101 = SetsKt.emptySet();
        Set<String> r102 = SetsKt.emptySet();
        Map<String, String> r103 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r101, "sectionAllowList");
        Intrinsics.checkNotNullParameter(r102, "itemAllowList");
        Intrinsics.checkNotNullParameter(r103, "itemLinkMap");
        this.f486551a = false;
        this.f486552b = r101;
        this.f486553c = r102;
        this.f486554d = r103;
        this.f486555e = null;
    }
}
