package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.bmhome.chat.component.bottom.core.inputtext.d0 f298904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f298905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f298906c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c1) == true) goto L8;
        return false;
    L8:
        c1 r101 = (c1) r100;
        if (Intrinsics.areEqual(this.f298904a, r101.f298904a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f298905b, r101.f298905b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f298906c, r101.f298906c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f298904a.hashCode() * 31;
        List<String> r101 = this.f298905b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f298906c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MentionSearchEntry(reference=" + this.f298904a + ", titleHighlights=" + this.f298905b + ", accessTimeSec=" + this.f298906c + ')';
    }

    public c1(com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r100, List<String> r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "reference");
        this.f298904a = r100;
        this.f298905b = r101;
        this.f298906c = r102;
    }

    public /* synthetic */ c1(com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r100, List r101, Long r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
