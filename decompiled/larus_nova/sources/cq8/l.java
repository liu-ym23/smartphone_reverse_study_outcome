package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f464878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f464879d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f464877b, r101.f464877b) == true) goto L12;
        return false;
    L12:
        if (this.f464878c == r101.f464878c) goto L15;
        return false;
    L15:
        if (this.f464879d == r101.f464879d) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f464877b.hashCode() * 31) + this.f464878c) * 31;
        long r101 = this.f464879d;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "DropdownListSelectAction(widgetId=" + this.f464877b + ", dropdownId=" + this.f464878c + ", optionId=" + this.f464879d + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464877b;
    }

    public l(String r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("DropdownListSelectAction");
        this.f464877b = r100;
        this.f464878c = r101;
        this.f464879d = r102;
    }
}
