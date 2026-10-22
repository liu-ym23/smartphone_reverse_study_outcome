package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f299145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<be8.b> f299146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f299147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f299148d;

    public q1() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q1) == true) goto L8;
        return false;
    L8:
        q1 r101 = (q1) r100;
        if (Intrinsics.areEqual(this.f299145a, r101.f299145a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f299146b, r101.f299146b) == true) goto L15;
        return false;
    L15:
        if (this.f299147c == r101.f299147c) goto L18;
        return false;
    L18:
        if (this.f299148d == r101.f299148d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f299145a.hashCode() * 31) + this.f299146b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f299147c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f299148d == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SkillPanelGroup(title=" + this.f299145a + ", skills=" + this.f299146b + ", isRecommended=" + this.f299147c + ", isRecentlyUsed=" + this.f299148d + ')';
    }

    public q1(String r100, List r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = false;
    L8:
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "skills");
        this.f299145a = r100;
        this.f299146b = r101;
        this.f299147c = r102;
        this.f299148d = r103;
    }
}
