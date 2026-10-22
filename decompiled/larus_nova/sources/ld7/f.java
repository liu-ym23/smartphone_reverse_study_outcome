package ld7;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<b>> f508735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, a> f508736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f508737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f508738d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f508735a, r101.f508735a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508736b, r101.f508736b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508737c, r101.f508737c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f508735a.hashCode() * 31) + this.f508736b.hashCode()) * 31) + this.f508737c.hashCode();
    }

    public final String toString() {
        return "ConfigWithSwitch(content=" + this.f508735a + ", contentV2=" + this.f508736b + ", settings=" + this.f508737c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Map<String, ? extends List<b>> r100, Map<String, a> r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "contentV2");
        Intrinsics.checkNotNullParameter(r102, "settings");
        this.f508735a = r100;
        this.f508736b = r101;
        this.f508737c = r102;
        this.f508738d = -1;
    }
}
