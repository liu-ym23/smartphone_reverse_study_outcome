package s59;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f540766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f540767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f540768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f540769e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f540765a, r101.f540765a) == true) goto L12;
        return false;
    L12:
        if (this.f540766b == r101.f540766b) goto L15;
        return false;
    L15:
        if (this.f540767c == r101.f540767c) goto L18;
        return false;
    L18:
        if (this.f540768d == r101.f540768d) goto L21;
        return false;
    L21:
        if (this.f540769e == r101.f540769e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f540765a.hashCode() * 31) + this.f540766b) * 31) + this.f540767c) * 31) + this.f540768d) * 31;
        if (this.f540769e == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraServiceNotificationItem(id=" + this.f540765a + ", titleResId=" + this.f540766b + ", subtitleResId=" + this.f540767c + ", iconResId=" + this.f540768d + ", isSelected=" + this.f540769e + ')';
    }

    public a(String r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f540765a = r100;
        this.f540766b = r101;
        this.f540767c = r102;
        this.f540768d = r103;
        this.f540769e = false;
    }
}
