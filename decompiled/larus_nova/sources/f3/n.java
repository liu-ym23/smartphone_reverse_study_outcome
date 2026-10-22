package f3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f475323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f475325c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f475323a == r101.f475323a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475324b, r101.f475324b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f475325c, r101.f475325c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f475323a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f475324b.hashCode()) * 31) + this.f475325c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "ParamFieldModel(required=" + this.f475323a + ", keyPath=" + this.f475324b + ", defaultValue=" + this.f475325c + ')';
    }

    public n() {
        this(false, "", new j(0));
    }

    public n(boolean r100, String r101, j r102) {
        Intrinsics.checkNotNullParameter(r101, "keyPath");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        this.f475323a = r100;
        this.f475324b = r101;
        this.f475325c = r102;
    }
}
