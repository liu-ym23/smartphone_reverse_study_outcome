package com.larus.bmhome.actionbar.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f295658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295659b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f295658a, r101.f295658a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295659b, r101.f295659b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f295658a.hashCode() * 31;
        String r101 = this.f295659b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ActionBarImgInspirePrompt(actualPrompt=" + this.f295658a + ", aspectRatioMessageText=" + this.f295659b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "actualPrompt");
        this.f295658a = r100;
        this.f295659b = r101;
    }
}
