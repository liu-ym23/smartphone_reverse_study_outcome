package com.bytedance.lark.policy.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J5\u0010\u000e\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/lark/policy/model/PolicyData;", "", "policies", "", "", "Lcom/bytedance/lark/policy/model/Policy;", "policyType2combineAlgorithm", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "getPolicies", "()Ljava/util/Map;", "getPolicyType2combineAlgorithm", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    @SerializedName("policies")
    private final Map<String, n> policies;

    @SerializedName("policyType2combineAlgorithm")
    private final Map<String, String> policyType2combineAlgorithm;

    public o() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.policies, r101.policies) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.policyType2combineAlgorithm, r101.policyType2combineAlgorithm) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.policies.hashCode() * 31) + this.policyType2combineAlgorithm.hashCode();
    }

    public final String toString() {
        return "PolicyData(policies=" + this.policies + ", policyType2combineAlgorithm=" + this.policyType2combineAlgorithm + ')';
    }

    public final Map<String, n> a() {
        return this.policies;
    }

    public final Map<String, String> b() {
        return this.policyType2combineAlgorithm;
    }

    public /* synthetic */ o(int r100) {
        this(MapsKt.emptyMap(), MapsKt.emptyMap());
    }

    public o(Map<String, n> r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "policies");
        Intrinsics.checkNotNullParameter(r101, "policyType2combineAlgorithm");
        this.policies = r100;
        this.policyType2combineAlgorithm = r101;
    }
}
