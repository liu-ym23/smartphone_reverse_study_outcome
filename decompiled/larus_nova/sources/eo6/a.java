package eo6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f473322b;

    public a() {
        this("", 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f473321a, r101.f473321a) == true) goto L12;
        return false;
    L12:
        if (this.f473322b == r101.f473322b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f473321a.hashCode() * 31) + this.f473322b;
    }

    public final String toString() {
        return "FooterCardInfo(cardKey=" + this.f473321a + ", cardPriority=" + this.f473322b + ')';
    }

    public a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "cardKey");
        this.f473321a = r100;
        this.f473322b = r101;
    }
}
