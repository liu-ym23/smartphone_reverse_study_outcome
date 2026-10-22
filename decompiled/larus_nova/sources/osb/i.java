package osb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f526602b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f526601a, r101.f526601a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f526602b, r101.f526602b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f526601a.hashCode() * 31) + this.f526602b.hashCode();
    }

    public final String toString() {
        return "Url(linkTitle=" + this.f526601a + ", linkUrl=" + this.f526602b + ')';
    }

    public i(String r100) {
        Intrinsics.checkNotNullParameter("", "linkTitle");
        Intrinsics.checkNotNullParameter(r100, "linkUrl");
        this.f526601a = "";
        this.f526602b = r100;
    }
}
