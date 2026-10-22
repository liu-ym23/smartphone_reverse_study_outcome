package hda;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f484685c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f484683a, r101.f484683a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484684b, r101.f484684b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f484685c, r101.f484685c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f484683a.hashCode() * 31) + this.f484684b.hashCode()) * 31;
        String r101 = this.f484685c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MemoryReviewImageRef(label=" + this.f484683a + ", uri=" + this.f484684b + ", caption=" + this.f484685c + ')';
    }

    public h0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "uri");
        this.f484683a = r100;
        this.f484684b = r101;
        this.f484685c = r102;
    }
}
