package uq9;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f551334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f551335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f551336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f551337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f551338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f551339f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f551334a, r101.f551334a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f551335b, r101.f551335b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f551336c, r101.f551336c) == true) goto L18;
        return false;
    L18:
        if (this.f551337d == r101.f551337d) goto L21;
        return false;
    L21:
        if (this.f551338e == r101.f551338e) goto L24;
        return false;
    L24:
        if (this.f551339f == r101.f551339f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f551334a.hashCode() * 31) + this.f551335b.hashCode()) * 31) + this.f551336c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f551337d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f551338e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f551339f == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ECBindDouYinParams(activity=" + this.f551334a + ", sourcePage=" + this.f551335b + ", sourceMethod=" + this.f551336c + ", bindPanelCancelButtonVisible=" + this.f551337d + ", ignoreNotifyPopup=" + this.f551338e + ", isMiniApplication=" + this.f551339f + ')';
    }

    public final FragmentActivity getActivity() {
        return this.f551334a;
    }

    public d(FragmentActivity r100, String r101, String r102, boolean r103, boolean r104, boolean r105, int r106) {
        if ((r106 & 8) == 0) goto L6;
        r103 = true;
    L6:
        if ((r106 & 16) == 0) goto L9;
        r104 = false;
    L9:
        if ((r106 & 32) == 0) goto L11;
        r105 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "sourcePage");
        Intrinsics.checkNotNullParameter(r102, "sourceMethod");
        this.f551334a = r100;
        this.f551335b = r101;
        this.f551336c = r102;
        this.f551337d = r103;
        this.f551338e = r104;
        this.f551339f = r105;
    }
}
