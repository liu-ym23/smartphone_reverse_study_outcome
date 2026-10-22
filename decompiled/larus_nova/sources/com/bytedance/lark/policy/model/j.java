package com.bytedance.lark.policy.model;

import com.bytedance.lark.policy.manager.FactorManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f253853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f253854b;

    public j() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f253853a, r101.f253853a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253854b, r101.f253854b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f253853a.hashCode() * 31) + this.f253854b.hashCode();
    }

    public final String toString() {
        return "GroupPolicyData(groupIdList=" + this.f253853a + ", policyMap=" + this.f253854b + ')';
    }

    public j(Object r100) {
        List<String> r101 = FactorManager.f253806a;
        LinkedHashMap r102 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "groupIdList");
        Intrinsics.checkNotNullParameter(r102, "policyMap");
        this.f253853a = r101;
        this.f253854b = r102;
    }
}
