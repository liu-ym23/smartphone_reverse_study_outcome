package com.bytedance.ee.bear.middleground.permission.escape.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003JQ\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDef;", "Ljava/io/Serializable;", "approvalCode", "", "approvalDetail", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDetail;", "reviewers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/Reviewer;", "Lkotlin/collections/ArrayList;", "ccUsers", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDetail;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getApprovalCode", "()Ljava/lang/String;", "getApprovalDetail", "()Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDetail;", "getReviewers", "()Ljava/util/ArrayList;", "getCcUsers", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApprovalDef implements Serializable {

    @SerializedName("approval_code")
    private final String approvalCode;

    @SerializedName("approval_detail")
    private final ApprovalDetail approvalDetail;

    @SerializedName("cc_users")
    private final ArrayList<Reviewer> ccUsers;
    private final ArrayList<Reviewer> reviewers;

    public ApprovalDef() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApprovalDef copy$default(ApprovalDef r100, String r101, ApprovalDetail r102, ArrayList r103, ArrayList r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.approvalCode;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.approvalDetail;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.reviewers;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ccUsers;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.approvalCode;
    }

    public final ApprovalDetail component2() {
        return this.approvalDetail;
    }

    public final ArrayList<Reviewer> component3() {
        return this.reviewers;
    }

    public final ArrayList<Reviewer> component4() {
        return this.ccUsers;
    }

    public final ApprovalDef copy(String r100, ApprovalDetail r101, ArrayList<Reviewer> r102, ArrayList<Reviewer> r103) {
        Intrinsics.checkNotNullParameter(r100, "approvalCode");
        Intrinsics.checkNotNullParameter(r101, "approvalDetail");
        Intrinsics.checkNotNullParameter(r102, "reviewers");
        Intrinsics.checkNotNullParameter(r103, "ccUsers");
        return new ApprovalDef(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ApprovalDef) == true) goto L8;
        return false;
    L8:
        ApprovalDef r101 = (ApprovalDef) r100;
        if (Intrinsics.areEqual(this.approvalCode, r101.approvalCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.approvalDetail, r101.approvalDetail) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.reviewers, r101.reviewers) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ccUsers, r101.ccUsers) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.approvalCode.hashCode() * 31) + this.approvalDetail.hashCode()) * 31) + this.reviewers.hashCode()) * 31) + this.ccUsers.hashCode();
    }

    public String toString() {
        return "ApprovalDef(approvalCode='" + this.approvalCode + "', approvalDetail=" + this.approvalDetail + ", reviewers=" + this.reviewers.size() + ", ccUsers=" + this.ccUsers.size() + ')';
    }

    public final String getApprovalCode() {
        return this.approvalCode;
    }

    public final ApprovalDetail getApprovalDetail() {
        return this.approvalDetail;
    }

    public final ArrayList<Reviewer> getCcUsers() {
        return this.ccUsers;
    }

    public final ArrayList<Reviewer> getReviewers() {
        return this.reviewers;
    }

    public ApprovalDef(String r100, ApprovalDetail r101, ArrayList<Reviewer> r102, ArrayList<Reviewer> r103) {
        Intrinsics.checkNotNullParameter(r100, "approvalCode");
        Intrinsics.checkNotNullParameter(r101, "approvalDetail");
        Intrinsics.checkNotNullParameter(r102, "reviewers");
        Intrinsics.checkNotNullParameter(r103, "ccUsers");
        this.approvalCode = r100;
        this.approvalDetail = r101;
        this.reviewers = r102;
        this.ccUsers = r103;
    }

    public /* synthetic */ ApprovalDef(String r100, ApprovalDetail r101, ArrayList r102, ArrayList r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = new ApprovalDetail(false, false, 3, null);
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = new ArrayList();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = new ArrayList();
    L14:
        this(r100, r101, r102, r103);
    }
}
