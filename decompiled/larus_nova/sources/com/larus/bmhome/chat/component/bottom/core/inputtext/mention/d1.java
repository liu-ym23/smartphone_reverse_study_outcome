package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f298908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f298909b;

    public d1() {
        this(false, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r101 = (d1) r100;
        if (this.f298908a == r101.f298908a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f298909b, r101.f298909b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f298908a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f298909b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "MentionSearchPageInfo(hasMore=" + this.f298908a + ", nextCursor=" + this.f298909b + ')';
    }

    public final boolean a() {
        if (this.f298908a == false) goto L14;
        String r100 = this.f298909b;
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (StringsKt.isBlank(r100) == true) goto L10;
        r101 = false;
        goto L11
    L14:
        return false;
    }

    public d1(boolean r100, String r101) {
        this.f298908a = r100;
        this.f298909b = r101;
    }
}
