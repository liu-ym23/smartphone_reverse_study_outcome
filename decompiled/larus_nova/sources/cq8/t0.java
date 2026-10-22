package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class t0 extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f464959c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (Intrinsics.areEqual(this.f464958b, r101.f464958b) == true) goto L12;
        return false;
    L12:
        if (this.f464959c == r101.f464959c) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f464958b.hashCode() * 31) + this.f464959c;
    }

    public final String toString() {
        return "TextListSelectAction(widgetId=" + this.f464958b + ", optionId=" + this.f464959c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464958b;
    }

    public t0(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("TextListSelectAction");
        this.f464958b = r100;
        this.f464959c = r101;
    }
}
