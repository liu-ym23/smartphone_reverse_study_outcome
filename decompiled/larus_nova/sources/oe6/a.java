package oe6;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/lark/policy/model/calculate/EvaluateInfo;", "", "evaluateUk", "", "policySetKeys", "", "operateTime", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getEvaluateUk", "()Ljava/lang/String;", "getPolicySetKeys", "()Ljava/util/List;", "getOperateTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("evaluateUk")
    private final String evaluateUk;

    @SerializedName("operateTime")
    private final String operateTime;

    @SerializedName("policySetKeys")
    private final List<String> policySetKeys;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.evaluateUk, r101.evaluateUk) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.policySetKeys, r101.policySetKeys) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.operateTime, r101.operateTime) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.evaluateUk.hashCode() * 31) + this.policySetKeys.hashCode()) * 31;
        String r101 = this.operateTime;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "EvaluateInfo(evaluateUk=" + this.evaluateUk + ", policySetKeys=" + this.policySetKeys + ", operateTime=" + this.operateTime + ')';
    }

    public final String a() {
        return this.evaluateUk;
    }

    public a(String r100, List<String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "evaluateUk");
        Intrinsics.checkNotNullParameter(r101, "policySetKeys");
        this.evaluateUk = r100;
        this.policySetKeys = r101;
        this.operateTime = r102;
    }
}
