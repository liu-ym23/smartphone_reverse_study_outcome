package kw9;

import com.larus.bmhome.share.ShareScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShareScene f506481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.h f506482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final by7.e f506483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f506484e;

    public j() {
        this(null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f506480a, r101.f506480a) == true) goto L12;
        return false;
    L12:
        if (this.f506481b == r101.f506481b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506482c, r101.f506482c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506483d, r101.f506483d) == true) goto L21;
        return false;
    L21:
        if (this.f506484e == r101.f506484e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f506480a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f506481b.hashCode()) * 31;
        com.larus.bmhome.share.panel.h r104 = this.f506482c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        by7.e r107 = this.f506483d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        if (this.f506484e == false) goto L17;
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
        return "SlideShareParams(token=" + this.f506480a + ", shareScene=" + this.f506481b + ", eventParam=" + this.f506482c + ", trackNode=" + this.f506483d + ", needChangeShareContent=" + this.f506484e + ')';
    }

    public j(String r100, com.larus.bmhome.share.panel.h r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        ShareScene r103 = ShareScene.SLIDES;
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = null;
    L12:
        Intrinsics.checkNotNullParameter(r103, "shareScene");
        this.f506480a = r100;
        this.f506481b = r103;
        this.f506482c = r101;
        this.f506483d = null;
        this.f506484e = false;
        return;
    L8:
        r103 = null;
        goto L10
    }
}
