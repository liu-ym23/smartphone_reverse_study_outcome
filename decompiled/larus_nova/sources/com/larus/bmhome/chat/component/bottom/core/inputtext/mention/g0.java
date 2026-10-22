package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MentionPanelSection f298918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f298919b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (this.f298918a == r101.f298918a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f298919b, r101.f298919b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f298918a.hashCode() * 31) + this.f298919b.hashCode();
    }

    public final String toString() {
        return "MentionPanelRowAnchorKey(section=" + this.f298918a + ", id=" + this.f298919b + ')';
    }

    public g0(MentionPanelSection r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "section");
        Intrinsics.checkNotNullParameter(r101, "id");
        this.f298918a = r100;
        this.f298919b = r101;
    }
}
