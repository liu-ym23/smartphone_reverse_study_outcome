package df;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f468105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f468106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f468107c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L12;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f468105a, r101.f468105a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468106b, r101.f468106b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468107c, r101.f468107c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f468105a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        View r104 = this.f468106b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f468107c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EnterCartRequired(cartUrl=" + this.f468105a + ", view=" + this.f468106b + ", btmId=" + this.f468107c + ")";
    }

    public j(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "cartUrl");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter("a1.b8094.c7963.d3567", "btmId");
        this.f468105a = r100;
        this.f468106b = r101;
        this.f468107c = "a1.b8094.c7963.d3567";
    }
}
