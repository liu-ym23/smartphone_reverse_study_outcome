package w78;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558574b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f558573a, r101.f558573a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558574b, r101.f558574b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f558573a.hashCode() * 31) + this.f558574b.hashCode();
    }

    public final String toString() {
        return "SamiTokenData(key=" + this.f558573a + ", token=" + this.f558574b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "token");
        this.f558573a = r100;
        this.f558574b = r101;
    }
}
