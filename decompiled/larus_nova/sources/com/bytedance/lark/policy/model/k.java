package com.bytedance.lark.policy.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/lark/policy/model/IPFactorsData;", "", "sourceIP", "", "sourceIPV4", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSourceIP", "()Ljava/lang/String;", "getSourceIPV4", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("SOURCE_IP")
    private final String sourceIP;

    @SerializedName("SOURCE_IP_V4")
    private final String sourceIPV4;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.sourceIP, r101.sourceIP) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceIPV4, r101.sourceIPV4) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.sourceIP.hashCode() * 31) + this.sourceIPV4.hashCode();
    }

    public final String toString() {
        return "IPFactorsData(sourceIP=" + this.sourceIP + ", sourceIPV4=" + this.sourceIPV4 + ')';
    }

    public final String a() {
        return this.sourceIP;
    }

    public final String b() {
        return this.sourceIPV4;
    }

    public k(int r100) {
        Intrinsics.checkNotNullParameter("-1", "sourceIP");
        Intrinsics.checkNotNullParameter("-1", "sourceIPV4");
        this.sourceIP = "-1";
        this.sourceIPV4 = "-1";
    }
}
