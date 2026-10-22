package com.bytedance.lark.policy.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J;\u0010\u000f\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R(\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/lark/policy/model/TenantWithPolicyData;", "", "policyTypeTenants", "", "", "", "indexFactorDetail", "Lcom/bytedance/lark/policy/model/IndexFactorDetail;", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "getPolicyTypeTenants", "()Ljava/util/Map;", "getIndexFactorDetail", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class y {

    @SerializedName("indexFactorDetail")
    private final Map<String, l> indexFactorDetail;

    @SerializedName("policyTypeTenants")
    private final Map<String, List<String>> policyTypeTenants;

    public y() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.policyTypeTenants, r101.policyTypeTenants) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.indexFactorDetail, r101.indexFactorDetail) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.policyTypeTenants.hashCode() * 31) + this.indexFactorDetail.hashCode();
    }

    public final String toString() {
        return "TenantWithPolicyData(policyTypeTenants=" + this.policyTypeTenants + ", indexFactorDetail=" + this.indexFactorDetail + ')';
    }

    public final Map<String, l> a() {
        return this.indexFactorDetail;
    }

    public final Map<String, List<String>> b() {
        return this.policyTypeTenants;
    }

    public y(Object r100) {
        Map<String, List<String>> r101 = MapsKt.emptyMap();
        Map<String, l> r102 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r101, "policyTypeTenants");
        Intrinsics.checkNotNullParameter(r102, "indexFactorDetail");
        this.policyTypeTenants = r101;
        this.indexFactorDetail = r102;
    }
}
