package jb8;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f498021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f498022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f498023c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f498021a == r101.f498021a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f498022b, r101.f498022b) == true) goto L15;
        return false;
    L15:
        if (this.f498023c == r101.f498023c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f498021a * 31) + this.f498022b.hashCode()) * 31) + this.f498023c;
    }

    public final String toString() {
        return "SubViewInfo(priority=" + this.f498021a + ", view=" + this.f498022b + ", viewId=" + this.f498023c + ')';
    }

    public e(int r100, View r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "view");
        this.f498021a = r100;
        this.f498022b = r101;
        this.f498023c = r102;
    }
}
