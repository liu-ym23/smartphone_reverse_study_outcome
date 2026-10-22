package ib8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f489044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489045b;

    public /* synthetic */ e0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f489044a, r101.f489044a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489045b, r101.f489045b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f489044a.hashCode() * 31;
        String r101 = this.f489045b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FoldStateTransition(animationData=" + this.f489044a + ", clickPositionForMob=" + this.f489045b + ')';
    }

    public e0(c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "animationData");
        this.f489044a = r100;
        this.f489045b = r101;
    }
}
