package com.bytedance.lark.policy.model;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0011HÆ\u0003J\t\u00102\u001a\u00020\u0011HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u0097\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017¨\u0006;"}, d2 = {"Lcom/bytedance/lark/policy/model/Policy;", "", "id", "", "name", "tenantID", "type", "advice", FilterData.FilterSheetItem.Id.FILTER_CONDITION, "Lcom/bytedance/lark/policy/model/Condition;", "rules", "", "Lcom/bytedance/lark/policy/model/Rule;", "combineAlgorithm", "refFactors", "version", "createdAt", "", "updatedAt", "basedOn", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/lark/policy/model/Condition;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JJLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getTenantID", "getType", "getAdvice", "getFilterCondition", "()Lcom/bytedance/lark/policy/model/Condition;", "getRules", "()Ljava/util/List;", "getCombineAlgorithm", "getRefFactors", "getVersion", "getCreatedAt", "()J", "getUpdatedAt", "getBasedOn", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class n {

    @SerializedName("advice")
    private final String advice;

    @SerializedName("basedOn")
    private final String basedOn;

    @SerializedName("combineAlgorithm")
    private final String combineAlgorithm;

    @SerializedName("createdAt")
    private final long createdAt;

    @SerializedName(FilterData.FilterSheetItem.Id.FILTER_CONDITION)
    private final d filterCondition;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f253855id;

    @SerializedName("name")
    private final String name;

    @SerializedName("refFactors")
    private final List<String> refFactors;

    @SerializedName("rules")
    private final List<v> rules;

    @SerializedName("tenantID")
    private final String tenantID;

    @SerializedName("type")
    private final String type;

    @SerializedName("updatedAt")
    private final long updatedAt;

    @SerializedName("version")
    private final String version;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f253855id, r101.f253855id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tenantID, r101.tenantID) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.advice, r101.advice) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.filterCondition, r101.filterCondition) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.rules, r101.rules) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.combineAlgorithm, r101.combineAlgorithm) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.refFactors, r101.refFactors) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L39;
        return false;
    L39:
        if (this.createdAt == r101.createdAt) goto L42;
        return false;
    L42:
        if (this.updatedAt == r101.updatedAt) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.basedOn, r101.basedOn) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((this.f253855id.hashCode() * 31) + this.name.hashCode()) * 31) + this.tenantID.hashCode()) * 31) + this.type.hashCode()) * 31) + this.advice.hashCode()) * 31) + this.filterCondition.hashCode()) * 31) + this.rules.hashCode()) * 31) + this.combineAlgorithm.hashCode()) * 31) + this.refFactors.hashCode()) * 31) + this.version.hashCode()) * 31;
        long r101 = this.createdAt;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.updatedAt;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.basedOn.hashCode();
    }

    public final String toString() {
        return "Policy(id=" + this.f253855id + ", name=" + this.name + ", tenantID=" + this.tenantID + ", type=" + this.type + ", advice=" + this.advice + ", filterCondition=" + this.filterCondition + ", rules=" + this.rules + ", combineAlgorithm=" + this.combineAlgorithm + ", refFactors=" + this.refFactors + ", version=" + this.version + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", basedOn=" + this.basedOn + ')';
    }

    public final String a() {
        return this.combineAlgorithm;
    }

    public final d b() {
        return this.filterCondition;
    }

    public final String c() {
        return this.f253855id;
    }

    public final String d() {
        return this.name;
    }

    public final List<String> e() {
        return this.refFactors;
    }

    public final List<v> f() {
        return this.rules;
    }

    public final String g() {
        return this.version;
    }

    public final String getType() {
        return this.type;
    }
}
