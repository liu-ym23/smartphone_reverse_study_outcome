package com.larus.bmhome.chat.list.cell.spacer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f305899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f305900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f305901c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f305899a, r101.f305899a) == true) goto L12;
        return false;
    L12:
        if (this.f305900b == r101.f305900b) goto L15;
        return false;
    L15:
        if (this.f305901c == r101.f305901c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f305899a.hashCode() * 31;
        long r101 = this.f305900b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f305901c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "SpacerAnimationSpec(id=" + this.f305899a + ", startedAtMs=" + this.f305900b + ", durationMs=" + this.f305901c + ')';
    }

    public a(String r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f305899a = r100;
        this.f305900b = r101;
        this.f305901c = r102;
    }
}
