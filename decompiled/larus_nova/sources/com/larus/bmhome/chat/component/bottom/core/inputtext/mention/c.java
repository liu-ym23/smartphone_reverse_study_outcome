package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qp8.c f298901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f298902b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f298901a, r101.f298901a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f298902b, r101.f298902b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f298901a.hashCode() * 31;
        List<String> r101 = this.f298902b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MentionContactEntry(contact=" + this.f298901a + ", titleHighlights=" + this.f298902b + ')';
    }

    public c(qp8.c r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "contact");
        this.f298901a = r100;
        this.f298902b = r101;
    }
}
