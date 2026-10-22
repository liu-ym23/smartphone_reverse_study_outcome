package com.bytedance.lark.policy.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/lark/policy/model/PolicyPair;", "", "id", "", "version", "policySetKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getVersion", "getPolicySetKey", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f253865id;

    @SerializedName("policySetKey")
    private final String policySetKey;

    @SerializedName("version")
    private final String version;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f253865id, r101.f253865id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.policySetKey, r101.policySetKey) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f253865id.hashCode() * 31) + this.version.hashCode()) * 31) + this.policySetKey.hashCode();
    }

    public final String toString() {
        return "PolicyPair(id=" + this.f253865id + ", version=" + this.version + ", policySetKey=" + this.policySetKey + ')';
    }

    public final String a() {
        return this.f253865id;
    }

    public final String b() {
        return this.version;
    }
}
