package com.bytedance.ee.bear.middleground.permission.escape.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDetail;", "Ljava/io/Serializable;", "isNeedApprove", "", "onlyCarbonCopy", "<init>", "(ZZ)V", "()Z", "getOnlyCarbonCopy", "toString", "", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApprovalDetail implements Serializable {

    @SerializedName("is_need_approve")
    private final boolean isNeedApprove;

    @SerializedName("only_carbon_copy")
    private final boolean onlyCarbonCopy;

    public ApprovalDetail() {
        boolean r2 = false;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ ApprovalDetail copy$default(ApprovalDetail r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.isNeedApprove;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.onlyCarbonCopy;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.isNeedApprove;
    }

    public final boolean component2() {
        return this.onlyCarbonCopy;
    }

    public final ApprovalDetail copy(boolean r2, boolean r3) {
        return new ApprovalDetail(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ApprovalDetail) == true) goto L8;
        return false;
    L8:
        ApprovalDetail r6 = (ApprovalDetail) r5;
        if (this.isNeedApprove == r6.isNeedApprove) goto L12;
        return false;
    L12:
        if (this.onlyCarbonCopy == r6.onlyCarbonCopy) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isNeedApprove == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.onlyCarbonCopy == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "ApprovalDetail(isNeedApprove=" + this.isNeedApprove + ", onlyCarbonCopy=" + this.onlyCarbonCopy + ')';
    }

    public final boolean getOnlyCarbonCopy() {
        return this.onlyCarbonCopy;
    }

    public final boolean isNeedApprove() {
        return this.isNeedApprove;
    }

    public ApprovalDetail(boolean r1, boolean r2) {
        this.isNeedApprove = r1;
        this.onlyCarbonCopy = r2;
    }

    public /* synthetic */ ApprovalDetail(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this(r2, r3);
    }
}
