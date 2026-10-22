package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f508566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f508569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f508570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508571f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f508566a, r101.f508566a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508567b, r101.f508567b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508568c, r101.f508568c) == true) goto L18;
        return false;
    L18:
        if (this.f508569d == r101.f508569d) goto L21;
        return false;
    L21:
        if (this.f508570e == r101.f508570e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508571f, r101.f508571f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f508566a.hashCode() * 31) + this.f508567b.hashCode()) * 31) + this.f508568c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f508569d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f508570e == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.f508571f.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ReportSetShareFolderHiddenParam(analyticService=" + this.f508566a + ", source=" + this.f508567b + ", module=" + this.f508568c + ", success=" + this.f508569d + ", isHidden=" + this.f508570e + ", objToken=" + this.f508571f + ')';
    }

    public u(com.bytedance.ee.bear.contract.d r100, String r101, String r102, boolean r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r105, "objToken");
        this.f508566a = r100;
        this.f508567b = r101;
        this.f508568c = r102;
        this.f508569d = r103;
        this.f508570e = r104;
        this.f508571f = r105;
    }
}
