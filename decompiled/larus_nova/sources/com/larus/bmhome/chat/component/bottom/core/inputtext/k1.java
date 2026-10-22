package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f298765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f298766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f298767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MultiTypePanelTrigger f298768d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k1) == true) goto L8;
        return false;
    L8:
        k1 r101 = (k1) r100;
        if (this.f298765a == r101.f298765a) goto L12;
        return false;
    L12:
        if (this.f298766b == r101.f298766b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f298767c, r101.f298767c) == true) goto L18;
        return false;
    L18:
        if (this.f298768d == r101.f298768d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f298765a * 31) + this.f298766b) * 31) + this.f298767c.hashCode()) * 31) + this.f298768d.hashCode();
    }

    public final String toString() {
        return "MultiTypePanelQueryRange(start=" + this.f298765a + ", end=" + this.f298766b + ", query=" + this.f298767c + ", trigger=" + this.f298768d + ')';
    }

    public k1(int r100, int r101, String r102, MultiTypePanelTrigger r103) {
        Intrinsics.checkNotNullParameter(r102, "query");
        Intrinsics.checkNotNullParameter(r103, "trigger");
        this.f298765a = r100;
        this.f298766b = r101;
        this.f298767c = r102;
        this.f298768d = r103;
    }
}
