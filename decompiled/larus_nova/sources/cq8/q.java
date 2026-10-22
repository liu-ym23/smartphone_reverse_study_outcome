package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f464932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f464933d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f464931b, r101.f464931b) == true) goto L12;
        return false;
    L12:
        if (this.f464932c == r101.f464932c) goto L15;
        return false;
    L15:
        if (this.f464933d == r101.f464933d) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f464931b.hashCode() * 31;
        long r101 = this.f464932c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.f464933d == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 + r103;
    L5:
        r103 = 1237;
        goto L7
    }

    public final String toString() {
        return "ImageListSelectAction(widgetId=" + this.f464931b + ", optionId=" + this.f464932c + ", isDeselect=" + this.f464933d + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464931b;
    }

    public q(String r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("ImageListSelectAction");
        this.f464931b = r100;
        this.f464932c = r101;
        this.f464933d = r102;
    }
}
