package com.larus.agents.impl.experience;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<t> f286685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f286686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f286687c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f286685a, r101.f286685a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f286686b, r101.f286686b) == true) goto L15;
        return false;
    L15:
        if (this.f286687c == r101.f286687c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f286685a.hashCode() * 31;
        String r101 = this.f286686b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f286687c == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "WorkExperiencePage(items=" + this.f286685a + ", nextPageToken=" + this.f286686b + ", hasMore=" + this.f286687c + ')';
    }

    public s(List<t> r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f286685a = r100;
        this.f286686b = r101;
        this.f286687c = r102;
    }
}
