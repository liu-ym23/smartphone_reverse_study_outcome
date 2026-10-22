package kw9;

import com.larus.bmhome.share.ShareScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f506424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShareScene f506425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.h f506426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final by7.e f506427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f506428f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f506423a, r101.f506423a) == true) goto L12;
        return false;
    L12:
        if (this.f506424b == r101.f506424b) goto L15;
        return false;
    L15:
        if (this.f506425c == r101.f506425c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506426d, r101.f506426d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506427e, r101.f506427e) == true) goto L24;
        return false;
    L24:
        if (this.f506428f == r101.f506428f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f506423a.hashCode() * 31) + this.f506424b) * 31) + this.f506425c.hashCode()) * 31;
        com.larus.bmhome.share.panel.h r101 = this.f506426d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        by7.e r105 = this.f506427e;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        if (this.f506428f == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DriveShareParams(fileToken=" + this.f506423a + ", fileType=" + this.f506424b + ", shareScene=" + this.f506425c + ", eventParam=" + this.f506426d + ", trackNode=" + this.f506427e + ", needChangeShareContent=" + this.f506428f + ')';
    }

    public d(String r100, int r101, ShareScene r102, com.larus.bmhome.share.panel.h r103) {
        Intrinsics.checkNotNullParameter(r100, "fileToken");
        Intrinsics.checkNotNullParameter(r102, "shareScene");
        this.f506423a = r100;
        this.f506424b = r101;
        this.f506425c = r102;
        this.f506426d = r103;
        this.f506427e = null;
        this.f506428f = false;
    }
}
