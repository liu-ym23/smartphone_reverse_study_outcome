package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f253096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WorkspaceBitableMoveStatus f253097c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f253095a, r101.f253095a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253096b, r101.f253096b) == true) goto L15;
        return false;
    L15:
        if (this.f253097c == r101.f253097c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f253095a.hashCode() * 31) + this.f253096b.hashCode()) * 31) + this.f253097c.hashCode();
    }

    public final String toString() {
        return "BitableWorkspaceMoveResult(token=" + this.f253095a + ", msg=" + this.f253096b + ", moveResult=" + this.f253097c + ')';
    }

    public o(String r100, String r101, WorkspaceBitableMoveStatus r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "moveResult");
        this.f253095a = r100;
        this.f253096b = r101;
        this.f253097c = r102;
    }
}
