package e19;

import android.graphics.Rect;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f470716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f470717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f470718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f470719e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f470715a, r101.f470715a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470716b, r101.f470716b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470717c, r101.f470717c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470718d, r101.f470718d) == true) goto L21;
        return false;
    L21:
        if (this.f470719e == r101.f470719e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f470715a.hashCode() * 31) + this.f470716b.hashCode()) * 31) + this.f470717c.hashCode()) * 31) + this.f470718d.hashCode()) * 31) + this.f470719e;
    }

    public final String toString() {
        return "FloatWindowHostInfo(hostId=" + this.f470715a + ", parent=" + this.f470716b + ", localBounds=" + this.f470717c + ", screenBounds=" + this.f470718d + ", orientation=" + this.f470719e + ')';
    }

    public b(String r100, ViewGroup r101, Rect r102, Rect r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "hostId");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "localBounds");
        Intrinsics.checkNotNullParameter(r103, "screenBounds");
        this.f470715a = r100;
        this.f470716b = r101;
        this.f470717c = r102;
        this.f470718d = r103;
        this.f470719e = r104;
    }
}
