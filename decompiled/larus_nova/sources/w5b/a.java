package w5b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f558383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558384b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f558383a == r101.f558383a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558384b, r101.f558384b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f558383a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f558384b;
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
        return "ChatCreatePageLinkResult(success=" + this.f558383a + ", errorMsg=" + this.f558384b + ')';
    }

    public a(boolean r100, String r101) {
        this.f558383a = r100;
        this.f558384b = r101;
    }
}
