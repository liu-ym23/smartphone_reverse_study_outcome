package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f508459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508460e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f508456a, r101.f508456a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508457b, r101.f508457b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508458c, r101.f508458c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508459d, r101.f508459d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508460e, r101.f508460e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508456a.hashCode() * 31;
        String r101 = this.f508457b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f508458c.hashCode()) * 31;
        String r105 = this.f508459d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f508460e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReportCreateNewFolderClickParam(module=" + this.f508456a + ", subModule=" + this.f508457b + ", click=" + this.f508458c + ", target=" + this.f508459d + ", parentToken=" + this.f508460e + ')';
    }

    public i(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, "click");
        this.f508456a = r100;
        this.f508457b = r101;
        this.f508458c = r102;
        this.f508459d = r103;
        this.f508460e = r104;
    }
}
