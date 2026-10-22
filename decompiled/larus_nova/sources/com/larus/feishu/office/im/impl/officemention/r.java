package com.larus.feishu.office.im.impl.officemention;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f343259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f343260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f343261c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.f343259a == r101.f343259a) goto L12;
        return false;
    L12:
        if (this.f343260b == r101.f343260b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f343261c, r101.f343261c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f343259a * 31) + this.f343260b) * 31) + this.f343261c.hashCode();
    }

    public final String toString() {
        return "OfficeRichTextReplacementRange(start=" + this.f343259a + ", end=" + this.f343260b + ", replacementText=" + this.f343261c + ')';
    }

    public r(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "replacementText");
        this.f343259a = r100;
        this.f343260b = r101;
        this.f343261c = r102;
    }
}
