package com.bytedance.lark.policy.model;

import com.bytedance.lark.policy.manager.FactorManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f253846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends List<String>> f253847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f253848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f253849d;

    public g() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f253846a, r101.f253846a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253847b, r101.f253847b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f253848c, r101.f253848c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253849d, r101.f253849d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f253846a.hashCode() * 31) + this.f253847b.hashCode()) * 31) + this.f253848c.hashCode()) * 31) + this.f253849d.hashCode();
    }

    public final String toString() {
        return "DeptPolicyData(userDeptIdsWithParent=" + this.f253846a + ", userDeptIDPaths=" + this.f253847b + ", policyMap=" + this.f253848c + ", rootDeptPolicyNode=" + this.f253849d + ')';
    }

    public g(Object r100) {
        List<String> r101 = FactorManager.f253806a;
        List<? extends List<String>> r102 = CollectionsKt.emptyList();
        LinkedHashMap r103 = new LinkedHashMap();
        h r104 = new h(null, 7);
        Intrinsics.checkNotNullParameter(r101, "userDeptIdsWithParent");
        Intrinsics.checkNotNullParameter(r102, "userDeptIDPaths");
        Intrinsics.checkNotNullParameter(r103, "policyMap");
        Intrinsics.checkNotNullParameter(r104, "rootDeptPolicyNode");
        this.f253846a = r101;
        this.f253847b = r102;
        this.f253848c = r103;
        this.f253849d = r104;
    }
}
