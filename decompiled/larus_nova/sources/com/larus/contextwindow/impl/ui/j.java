package com.larus.contextwindow.impl.ui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<z29.b> f330478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f330479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f330480c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f330478a, r101.f330478a) == true) goto L12;
        return false;
    L12:
        if (this.f330479b == r101.f330479b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f330480c, r101.f330480c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f330478a.hashCode() * 31;
        if (this.f330479b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        Long r103 = this.f330480c;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MembershipQuotaPanelState(rows=" + this.f330478a + ", isRefreshing=" + this.f330479b + ", refreshAtMillis=" + this.f330480c + ')';
    }

    public j(List<z29.b> r100, boolean r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "rows");
        this.f330478a = r100;
        this.f330479b = r101;
        this.f330480c = r102;
    }
}
