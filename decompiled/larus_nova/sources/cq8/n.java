package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f464903c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f464902b, r101.f464902b) == true) goto L12;
        return false;
    L12:
        if (this.f464903c == r101.f464903c) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f464902b.hashCode() * 31;
        long r101 = this.f464903c;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "DropdownSelectAction(widgetId=" + this.f464902b + ", optionId=" + this.f464903c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464902b;
    }

    public n(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("DropdownSelectAction");
        this.f464902b = r100;
        this.f464903c = r101;
    }
}
