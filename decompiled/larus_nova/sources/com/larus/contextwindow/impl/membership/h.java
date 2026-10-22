package com.larus.contextwindow.impl.membership;

import com.larus.contextwindow.impl.membership.model.MembershipQuotaSummaryDto;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MembershipQuotaSummaryDto f330385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f330386b;

    public h() {
        MembershipQuotaSummaryDto r100 = null;
        this(r100, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f330385a, r101.f330385a) == true) goto L12;
        return false;
    L12:
        if (this.f330386b == r101.f330386b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        MembershipQuotaSummaryDto r100 = this.f330385a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f330386b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MembershipQuotaRepositoryState(successfulSummary=" + this.f330385a + ", refreshing=" + this.f330386b + ')';
    }

    public /* synthetic */ h(MembershipQuotaSummaryDto r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, false);
    }

    public h(MembershipQuotaSummaryDto r100, boolean r101) {
        this.f330385a = r100;
        this.f330386b = r101;
    }
}
