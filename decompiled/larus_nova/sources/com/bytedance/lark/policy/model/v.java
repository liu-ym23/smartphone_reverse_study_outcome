package com.bytedance.lark.policy.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/lark/policy/model/Rule;", "", "condition", "Lcom/bytedance/lark/policy/model/Condition;", "decision", "Lcom/bytedance/lark/policy/model/Decision;", "<init>", "(Lcom/bytedance/lark/policy/model/Condition;Lcom/bytedance/lark/policy/model/Decision;)V", "getCondition", "()Lcom/bytedance/lark/policy/model/Condition;", "getDecision", "()Lcom/bytedance/lark/policy/model/Decision;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class v {

    @SerializedName("condition")
    private final d condition;

    @SerializedName("decision")
    private final f decision;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.condition, r101.condition) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.decision, r101.decision) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.condition.hashCode() * 31) + this.decision.hashCode();
    }

    public final String toString() {
        return "Rule(condition=" + this.condition + ", decision=" + this.decision + ')';
    }

    public final d a() {
        return this.condition;
    }

    public final f b() {
        return this.decision;
    }
}
