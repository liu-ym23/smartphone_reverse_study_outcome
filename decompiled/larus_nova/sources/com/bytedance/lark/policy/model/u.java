package com.bytedance.lark.policy.model;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f253870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f253871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f253872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f253873d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f253870a, r101.f253870a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253871b, r101.f253871b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f253872c, r101.f253872c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253873d, r101.f253873d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f253870a.hashCode() * 31) + this.f253871b.hashCode()) * 31) + this.f253872c.hashCode()) * 31) + this.f253873d.hashCode();
    }

    public final String toString() {
        return "PriorityPolicyData(userPolicyData=" + this.f253870a + ", groupPolicyData=" + this.f253871b + ", deptPolicyData=" + this.f253872c + ", companyPolicyList=" + this.f253873d + ')';
    }

    public u(a0 r100, j r101, g r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "userPolicyData");
        Intrinsics.checkNotNullParameter(r101, "groupPolicyData");
        Intrinsics.checkNotNullParameter(r102, "deptPolicyData");
        Intrinsics.checkNotNullParameter(r103, "companyPolicyList");
        this.f253870a = r100;
        this.f253871b = r101;
        this.f253872c = r102;
        this.f253873d = r103;
    }
}
