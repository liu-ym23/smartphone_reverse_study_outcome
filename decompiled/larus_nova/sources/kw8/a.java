package kw8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f506406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f506407b;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f506406a, r101.f506406a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506407b, r101.f506407b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        b r100 = this.f506406a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        b r104 = this.f506407b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "HtmlCssStyle(lightTheme=" + this.f506406a + ", darkTheme=" + this.f506407b + ')';
    }

    public a(b r100, b r101) {
        this.f506406a = r100;
        this.f506407b = r101;
    }
}
