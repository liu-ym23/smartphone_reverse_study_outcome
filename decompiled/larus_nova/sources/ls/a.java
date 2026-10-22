package ls;

import com.bytedance.android.gamecp.business.download.custommade.bean.CustomInstallInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f510486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CustomInstallInfo f510487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f510488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f510489e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f510485a, r101.f510485a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f510486b, r101.f510486b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f510487c, r101.f510487c) == true) goto L12;
        return false;
    L12:
        if (this.f510488d == r101.f510488d) goto L14;
        return false;
    L14:
        if (this.f510489e == r101.f510489e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f510485a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f510486b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        CustomInstallInfo r107 = this.f510487c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((((r106 + r101) * 31) + this.f510488d) * 31) + this.f510489e;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SessionInstallParams(pkgName=" + this.f510485a + ", downloadFilePath=" + this.f510486b + ", customInstallInfo=" + this.f510487c + ", progressData=" + this.f510488d + ", sessionId=" + this.f510489e + ")";
    }

    public a(String r100, String r101, CustomInstallInfo r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "pkgName");
        Intrinsics.checkNotNullParameter(r101, "downloadFilePath");
        this.f510485a = r100;
        this.f510486b = r101;
        this.f510487c = r102;
        this.f510488d = r103;
        this.f510489e = r104;
    }
}
