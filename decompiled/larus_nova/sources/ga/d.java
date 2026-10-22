package ga;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f480538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f480539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f480540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f480541d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f480538a, r101.f480538a) == true) goto L12;
        return false;
    L12:
        if (this.f480539b == r101.f480539b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f480540c, r101.f480540c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f480541d, r101.f480541d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f480538a.hashCode() * 31;
        if (this.f480539b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f480540c;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return ((r102 + r104) * 31) + Float.floatToIntBits(this.f480541d);
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskConfig(businessName=" + this.f480538a + ", sync=" + this.f480539b + ", entrance=" + this.f480540c + ", pendingTimeout=" + this.f480541d + ')';
    }

    public d() {
        Intrinsics.checkNotNullParameter("caijing_half_blank_detection", "businessName");
        this.f480538a = "caijing_half_blank_detection";
        this.f480539b = false;
        this.f480540c = null;
        this.f480541d = 5.0f;
    }
}
