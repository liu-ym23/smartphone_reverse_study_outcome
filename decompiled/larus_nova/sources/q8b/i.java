package q8b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h<? super String> f532061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<? super String> f532062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h<? super Integer> f532063c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f532061a, r101.f532061a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f532062b, r101.f532062b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f532063c, r101.f532063c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f532061a.hashCode() * 31) + this.f532062b.hashCode()) * 31) + this.f532063c.hashCode();
    }

    public final String toString() {
        return "FilterRule(actionName=" + this.f532061a + ", policyType=" + this.f532062b + ", challengeType=" + this.f532063c + ')';
    }

    public i(h<? super String> r100, h<? super String> r101, h<? super Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "policyType");
        Intrinsics.checkNotNullParameter(r102, "challengeType");
        this.f532061a = r100;
        this.f532062b = r101;
        this.f532063c = r102;
    }

    public /* synthetic */ i(h r100, h r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = d.f532052c;
    L6:
        if ((r102 & 4) == 0) goto L8;
        d r103 = d.f532052c;
    L9:
        this(r100, r101, r103);
        return;
    L8:
        r103 = null;
        goto L9
    }
}
