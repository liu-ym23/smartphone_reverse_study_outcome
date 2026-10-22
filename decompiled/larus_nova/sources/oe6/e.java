package oe6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/lark/policy/model/calculate/PolicyInfo;", "", "policyID", "", "policyName", "version", "isExecuted", "", "ruleGroupResult", "Lcom/bytedance/lark/policy/model/calculate/RuleGroupResult;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/bytedance/lark/policy/model/calculate/RuleGroupResult;)V", "getPolicyID", "()Ljava/lang/String;", "getPolicyName", "getVersion", "()Z", "getRuleGroupResult", "()Lcom/bytedance/lark/policy/model/calculate/RuleGroupResult;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("isExecuted")
    private final boolean isExecuted;

    @SerializedName("policyID")
    private final String policyID;

    @SerializedName("policyName")
    private final String policyName;

    @SerializedName("ruleGroupResult")
    private final g ruleGroupResult;

    @SerializedName("version")
    private final String version;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.policyID, r101.policyID) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.policyName, r101.policyName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L18;
        return false;
    L18:
        if (this.isExecuted == r101.isExecuted) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ruleGroupResult, r101.ruleGroupResult) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.policyID.hashCode() * 31) + this.policyName.hashCode()) * 31) + this.version.hashCode()) * 31;
        if (this.isExecuted == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        g r103 = this.ruleGroupResult;
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
        return "PolicyInfo(policyID=" + this.policyID + ", policyName=" + this.policyName + ", version=" + this.version + ", isExecuted=" + this.isExecuted + ", ruleGroupResult=" + this.ruleGroupResult + ')';
    }

    public e(String r100, String r101, String r102, g r103) {
        Intrinsics.checkNotNullParameter(r100, "policyID");
        Intrinsics.checkNotNullParameter(r101, "policyName");
        Intrinsics.checkNotNullParameter(r102, "version");
        this.policyID = r100;
        this.policyName = r101;
        this.version = r102;
        this.isExecuted = true;
        this.ruleGroupResult = r103;
    }
}
