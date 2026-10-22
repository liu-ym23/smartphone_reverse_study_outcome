package com.bytedance.ee.bear.middleground.permission.escape.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDetail;", "Ljava/io/Serializable;", "isNeedApprove", "", "onlyCarbonCopy", "<init>", "(ZZ)V", "()Z", "getOnlyCarbonCopy", "toString", "", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApprovalDetail implements Serializable {

    @SerializedName("is_need_approve")
    private final boolean isNeedApprove;

    @SerializedName("only_carbon_copy")
    private final boolean onlyCarbonCopy;

    public ApprovalDetail() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ ApprovalDetail copy$default(ApprovalDetail r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isNeedApprove;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.onlyCarbonCopy;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isNeedApprove;
    }

    public final boolean component2() {
        return this.onlyCarbonCopy;
    }

    public final ApprovalDetail copy(boolean r100, boolean r101) {
        return new ApprovalDetail(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ApprovalDetail) == true) goto L8;
        return false;
    L8:
        ApprovalDetail r101 = (ApprovalDetail) r100;
        if (this.isNeedApprove == r101.isNeedApprove) goto L12;
        return false;
    L12:
        if (this.onlyCarbonCopy == r101.onlyCarbonCopy) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isNeedApprove == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.onlyCarbonCopy == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
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

    public ApprovalDetail(boolean r100, boolean r101) {
        this.isNeedApprove = r100;
        this.onlyCarbonCopy = r101;
    }

    public /* synthetic */ ApprovalDetail(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
