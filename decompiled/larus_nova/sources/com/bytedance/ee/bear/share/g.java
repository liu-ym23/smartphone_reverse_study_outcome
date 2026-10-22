package com.bytedance.ee.bear.share;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f237120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f237121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f237122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f237123d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f237120a, r101.f237120a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f237121b, r101.f237121b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f237122c, r101.f237122c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f237123d, r101.f237123d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f237120a.hashCode() * 31) + this.f237121b.hashCode()) * 31;
        String r101 = this.f237122c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        File r105 = this.f237123d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareData(shareUrl=" + this.f237120a + ", shareTitle=" + this.f237121b + ", shareText=" + this.f237122c + ", shareImage=" + this.f237123d + ')';
    }

    public g(String r100, String r101, String r102, File r103) {
        Intrinsics.checkNotNullParameter(r100, "shareUrl");
        Intrinsics.checkNotNullParameter(r101, "shareTitle");
        this.f237120a = r100;
        this.f237121b = r101;
        this.f237122c = r102;
        this.f237123d = r103;
    }
}
