package oq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f524895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f524896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f524897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f524898d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f524895a == r101.f524895a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f524896b, r101.f524896b) == true) goto L15;
        return false;
    L15:
        if (this.f524897c == r101.f524897c) goto L18;
        return false;
    L18:
        if (this.f524898d == r101.f524898d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f524895a * 31) + this.f524896b.hashCode()) * 31) + this.f524897c) * 31) + this.f524898d;
    }

    public final String toString() {
        return "InlineTokenRequest(trigger=" + this.f524895a + ", keyword=" + this.f524896b + ", triggerStart=" + this.f524897c + ", cursor=" + this.f524898d + ')';
    }

    public a(char r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "keyword");
        this.f524895a = r100;
        this.f524896b = r101;
        this.f524897c = r102;
        this.f524898d = r103;
    }
}
