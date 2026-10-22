package mpc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f514776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f514777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f514778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f514779d;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f514776a, r101.f514776a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514777b, r101.f514777b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f514778c, r101.f514778c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f514779d, r101.f514779d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f514776a.hashCode() * 31) + this.f514777b.hashCode()) * 31) + this.f514778c.hashCode()) * 31) + this.f514779d.hashCode();
    }

    public final String toString() {
        return "ForwardToDoubaoTrackParams(larkFirstScene=" + this.f514776a + ", larkSecondScene=" + this.f514777b + ", currentModule=" + this.f514778c + ", enterMethod=" + this.f514779d + ')';
    }

    public d(int r100) {
        Intrinsics.checkNotNullParameter("", "larkFirstScene");
        Intrinsics.checkNotNullParameter("", "larkSecondScene");
        Intrinsics.checkNotNullParameter("", "currentModule");
        Intrinsics.checkNotNullParameter("", "enterMethod");
        this.f514776a = "";
        this.f514777b = "";
        this.f514778c = "";
        this.f514779d = "";
    }
}
