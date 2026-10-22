package vp9;

import com.facebook.drawee.generic.RoundingParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RoundingParams f556680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f556681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f556682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f556683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f556684e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f556680a, r101.f556680a) == true) goto L12;
        return false;
    L12:
        if (this.f556681b == r101.f556681b) goto L15;
        return false;
    L15:
        if (this.f556682c == r101.f556682c) goto L18;
        return false;
    L18:
        if (this.f556683d == r101.f556683d) goto L21;
        return false;
    L21:
        if (this.f556684e == r101.f556684e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f556680a.hashCode() * 31) + this.f556681b) * 31;
        int r101 = 1231;
        if (this.f556682c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f556683d) * 31;
        if (this.f556684e == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MediaListStateData(cornerRadius=" + this.f556680a + ", lastCornersRadius=" + this.f556681b + ", isSelectable=" + this.f556682c + ", selectViewType=" + this.f556683d + ", useCompactSelectionHitTarget=" + this.f556684e + ')';
    }

    public m(RoundingParams r100, int r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "cornerRadius");
        this.f556680a = r100;
        this.f556681b = r101;
        this.f556682c = true;
        this.f556683d = r102;
        this.f556684e = r103;
    }
}
