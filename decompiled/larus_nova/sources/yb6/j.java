package yb6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f567098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f567099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f567100c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L12;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f567098a, r101.f567098a) == true) goto L8;
        return false;
    L8:
        if (this.f567099b == r101.f567099b) goto L10;
        return false;
    L10:
        if (this.f567100c == r101.f567100c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Object r100 = this.f567098a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((r101 * 31) + this.f567099b) * 31) + this.f567100c;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "RemoteView(view=" + this.f567098a + ", width=" + this.f567099b + ", height=" + this.f567100c + ")";
    }

    public j(Object r100, int r101, int r102) {
        this.f567098a = r100;
        this.f567099b = r101;
        this.f567100c = r102;
    }
}
