package dw8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f470345e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f470341a, r101.f470341a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470342b, r101.f470342b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470343c, r101.f470343c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470344d, r101.f470344d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f470345e, r101.f470345e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f470341a.hashCode() * 31) + this.f470342b.hashCode()) * 31) + this.f470343c.hashCode()) * 31) + this.f470344d.hashCode()) * 31) + this.f470345e.hashCode();
    }

    public final String toString() {
        return "AIChatActionBarItem(id=" + this.f470341a + ", title=" + this.f470342b + ", iconUrl=" + this.f470343c + ", darkModeIconUrl=" + this.f470344d + ", behavior=" + this.f470345e + ')';
    }

    public f(String r100, String r101, String r102, String r103, c r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "iconUrl");
        Intrinsics.checkNotNullParameter(r103, "darkModeIconUrl");
        Intrinsics.checkNotNullParameter(r104, "behavior");
        this.f470341a = r100;
        this.f470342b = r101;
        this.f470343c = r102;
        this.f470344d = r103;
        this.f470345e = r104;
    }
}
