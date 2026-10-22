package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f508495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f508498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f508499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508500f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f508495a, r101.f508495a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508496b, r101.f508496b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508497c, r101.f508497c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508498d, r101.f508498d) == true) goto L21;
        return false;
    L21:
        if (this.f508499e == r101.f508499e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508500f, r101.f508500f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f508495a.hashCode() * 31) + this.f508496b.hashCode()) * 31) + this.f508497c.hashCode()) * 31) + this.f508498d.hashCode()) * 31) + this.f508499e) * 31) + this.f508500f.hashCode();
    }

    public final String toString() {
        return "ReportMakeCopyParam(analyticService=" + this.f508495a + ", source=" + this.f508496b + ", module=" + this.f508497c + ", statusName=" + this.f508498d + ", fileType=" + this.f508499e + ", objToken=" + this.f508500f + ')';
    }

    public o(com.bytedance.ee.bear.contract.d r100, String r101, String r102, String r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r103, "statusName");
        Intrinsics.checkNotNullParameter(r105, "objToken");
        this.f508495a = r100;
        this.f508496b = r101;
        this.f508497c = r102;
        this.f508498d = r103;
        this.f508499e = r104;
        this.f508500f = r105;
    }
}
