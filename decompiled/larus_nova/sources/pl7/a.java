package pl7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f529761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f529762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f529763c;

    /* JADX INFO: renamed from: pl7.a$a, reason: collision with other inner class name */
    public static final class C7210a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L17:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f529761a, r101.f529761a) == false) goto L16;
        if (this.f529762b != r101.f529762b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L16;
        if (Intrinsics.areEqual(this.f529763c, r101.f529763c) == false) goto L16;
    L11:
        r102 = false;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f529761a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f529762b) * 31;
        String r104 = this.f529763c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BackToPageParams(pageId=" + this.f529761a + ", enterFromMode=" + this.f529762b + ", enterFrom=" + this.f529763c + ")";
    }

    public a(String r100, int r101, String r102) {
        this.f529761a = r100;
        this.f529762b = r101;
        this.f529763c = r102;
    }
}
