package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i0 extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f464854c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f464853b, r101.f464853b) == true) goto L12;
        return false;
    L12:
        if (this.f464854c == r101.f464854c) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f464853b.hashCode() * 31;
        if (this.f464854c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MsgInstructionChosenChangedAction(widgetId=" + this.f464853b + ", isChosen=" + this.f464854c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464853b;
    }

    public i0(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("MsgInstructionChosenChangedAction");
        this.f464853b = r100;
        this.f464854c = r101;
    }
}
