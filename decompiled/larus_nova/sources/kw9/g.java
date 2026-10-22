package kw9;

import com.larus.bmhome.share.ShareScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShareScene f506452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.h f506453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final by7.e f506454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f506455e;

    public g() {
        this(null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f506451a, r101.f506451a) == true) goto L12;
        return false;
    L12:
        if (this.f506452b == r101.f506452b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506453c, r101.f506453c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506454d, r101.f506454d) == true) goto L21;
        return false;
    L21:
        if (this.f506455e == r101.f506455e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f506451a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f506452b.hashCode()) * 31;
        com.larus.bmhome.share.panel.h r104 = this.f506453c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        by7.e r107 = this.f506454d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        if (this.f506455e == false) goto L17;
        int r109 = 1231;
    L19:
        return r108 + r109;
    L17:
        r109 = 1237;
        goto L19
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SheetShareParams(token=" + this.f506451a + ", shareScene=" + this.f506452b + ", eventParam=" + this.f506453c + ", trackNode=" + this.f506454d + ", needChangeShareContent=" + this.f506455e + ')';
    }

    public g(String r100, com.larus.bmhome.share.panel.h r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        ShareScene r103 = ShareScene.SHEET;
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = null;
    L12:
        Intrinsics.checkNotNullParameter(r103, "shareScene");
        this.f506451a = r100;
        this.f506452b = r103;
        this.f506453c = r101;
        this.f506454d = null;
        this.f506455e = false;
        return;
    L8:
        r103 = null;
        goto L10
    }
}
