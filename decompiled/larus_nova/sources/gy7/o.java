package gy7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f483345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f483346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f483347c;

    public o() {
        this(true, 0, "");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f483345a == r101.f483345a) goto L12;
        return false;
    L12:
        if (this.f483346b == r101.f483346b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f483347c, r101.f483347c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f483345a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f483346b) * 31) + this.f483347c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "TaskResult(succeed=" + this.f483345a + ", errorCode=" + this.f483346b + ", errorMessage=" + this.f483347c + ')';
    }

    public o(boolean r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        this.f483345a = r100;
        this.f483346b = r101;
        this.f483347c = r102;
    }
}
