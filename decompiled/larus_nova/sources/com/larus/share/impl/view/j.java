package com.larus.share.impl.view;

import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f368840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<jr9.a> f368841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.b f368842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.e f368843d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f368840a, r101.f368840a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f368841b, r101.f368841b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f368842c, r101.f368842c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f368843d, r101.f368843d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f368840a.hashCode() * 31;
        List<jr9.a> r101 = this.f368841b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f368842c.hashCode()) * 31) + this.f368843d.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "LongImageShareContext(fragmentActivity=" + this.f368840a + ", shareItems=" + this.f368841b + ", shareContent=" + this.f368842c + ", shareParams=" + this.f368843d + ')';
    }

    public j(FragmentActivity r100, List<jr9.a> r101, com.larus.bmhome.share.panel.b r102, com.larus.bmhome.share.panel.e r103) {
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r102, "shareContent");
        Intrinsics.checkNotNullParameter(r103, "shareParams");
        this.f368840a = r100;
        this.f368841b = r101;
        this.f368842c = r102;
        this.f368843d = r103;
    }
}
