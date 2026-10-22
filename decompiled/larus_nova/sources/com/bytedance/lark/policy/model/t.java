package com.bytedance.lark.policy.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/lark/policy/model/PolicyPairResponse;", "", "policyPairs", "", "Lcom/bytedance/lark/policy/model/PolicyPair;", "policyType2combineAlgorithm", "", "", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getPolicyPairs", "()Ljava/util/List;", "getPolicyType2combineAlgorithm", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t {

    @SerializedName("policyPairs")
    private final List<s> policyPairs;

    @SerializedName("policyType2CombineAlgorithmMap")
    private final Map<String, String> policyType2combineAlgorithm;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.policyPairs, r101.policyPairs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.policyType2combineAlgorithm, r101.policyType2combineAlgorithm) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.policyPairs.hashCode() * 31) + this.policyType2combineAlgorithm.hashCode();
    }

    public final String toString() {
        return "PolicyPairResponse(policyPairs=" + this.policyPairs + ", policyType2combineAlgorithm=" + this.policyType2combineAlgorithm + ')';
    }

    public t() {
        List<s> r100 = CollectionsKt.emptyList();
        Map<String, String> r101 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r100, "policyPairs");
        Intrinsics.checkNotNullParameter(r101, "policyType2combineAlgorithm");
        this.policyPairs = r100;
        this.policyType2combineAlgorithm = r101;
    }

    public final List<s> a() {
        return this.policyPairs;
    }

    public final Map<String, String> b() {
        return this.policyType2combineAlgorithm;
    }
}
