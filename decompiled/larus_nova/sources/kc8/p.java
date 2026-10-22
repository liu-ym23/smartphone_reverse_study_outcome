package kc8;

import android.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f502539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f502540b;

    public /* synthetic */ p() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f502539a == r101.f502539a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502540b, r101.f502540b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f502539a * 31;
        Boolean r101 = this.f502540b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CotSearchUIConfig(rootBackgroundRes=" + this.f502539a + ", directRendFirstFrame=" + this.f502540b + ')';
    }

    public p(Boolean r100) {
        this.f502539a = R.color.transparent;
        this.f502540b = r100;
    }
}
