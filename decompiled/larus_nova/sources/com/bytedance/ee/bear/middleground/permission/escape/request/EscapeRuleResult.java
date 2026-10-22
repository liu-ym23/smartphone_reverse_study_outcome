package com.bytedance.ee.bear.middleground.permission.escape.request;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.escape.model.ApprovalDetail;
import com.bytedance.ee.bear.middleground.permission.escape.model.Reviewer;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003J[\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0002HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/request/EscapeRuleResult;", "Lcom/bytedance/ee/bear/contract/Result;", "", "isOpen", "", "approvalCode", "approvalDetail", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDetail;", "reviewers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/Reviewer;", "Lkotlin/collections/ArrayList;", "ccUsers", "<init>", "(ZLjava/lang/String;Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDetail;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "()Z", "getApprovalCode", "()Ljava/lang/String;", "getApprovalDetail", "()Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDetail;", "getReviewers", "()Ljava/util/ArrayList;", "getCcUsers", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EscapeRuleResult extends Result<String> {

    @SerializedName("approval_code")
    private final String approvalCode;

    @SerializedName("approval_detail")
    private final ApprovalDetail approvalDetail;

    @SerializedName("cc_users")
    private final ArrayList<Reviewer> ccUsers;

    @SerializedName("is_open")
    private final boolean isOpen;
    private final ArrayList<Reviewer> reviewers;

    public EscapeRuleResult() {
        this(false, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EscapeRuleResult copy$default(EscapeRuleResult r100, boolean r101, String r102, ApprovalDetail r103, ArrayList r104, ArrayList r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.isOpen;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.approvalCode;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.approvalDetail;
    L11:
        ApprovalDetail r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.reviewers;
    L14:
        ArrayList r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.ccUsers;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.isOpen;
    }

    public final String component2() {
        return this.approvalCode;
    }

    public final ApprovalDetail component3() {
        return this.approvalDetail;
    }

    public final ArrayList<Reviewer> component4() {
        return this.reviewers;
    }

    public final ArrayList<Reviewer> component5() {
        return this.ccUsers;
    }

    public final EscapeRuleResult copy(boolean r100, String r101, ApprovalDetail r110, ArrayList<Reviewer> r111, ArrayList<Reviewer> r112) {
        Intrinsics.checkNotNullParameter(r101, "approvalCode");
        Intrinsics.checkNotNullParameter(r110, "approvalDetail");
        Intrinsics.checkNotNullParameter(r111, "reviewers");
        Intrinsics.checkNotNullParameter(r112, "ccUsers");
        return new EscapeRuleResult(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EscapeRuleResult) == true) goto L8;
        return false;
    L8:
        EscapeRuleResult r101 = (EscapeRuleResult) r100;
        if (this.isOpen == r101.isOpen) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.approvalCode, r101.approvalCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.approvalDetail, r101.approvalDetail) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reviewers, r101.reviewers) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ccUsers, r101.ccUsers) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.isOpen == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((((r100 * 31) + this.approvalCode.hashCode()) * 31) + this.approvalDetail.hashCode()) * 31) + this.reviewers.hashCode()) * 31) + this.ccUsers.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "EscapeRuleResult(isOpen=" + this.isOpen + ", approvalCode=" + this.approvalCode + ", approvalDetail=" + this.approvalDetail + ", reviewers=" + this.reviewers + ", ccUsers=" + this.ccUsers + ')';
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

    public final boolean isOpen() {
        return this.isOpen;
    }

    public EscapeRuleResult(boolean r100, String r101, ApprovalDetail r102, ArrayList<Reviewer> r103, ArrayList<Reviewer> r104) {
        Intrinsics.checkNotNullParameter(r101, "approvalCode");
        Intrinsics.checkNotNullParameter(r102, "approvalDetail");
        Intrinsics.checkNotNullParameter(r103, "reviewers");
        Intrinsics.checkNotNullParameter(r104, "ccUsers");
        this.isOpen = r100;
        this.approvalCode = r101;
        this.approvalDetail = r102;
        this.reviewers = r103;
        this.ccUsers = r104;
    }

    public /* synthetic */ EscapeRuleResult(boolean r100, String r101, ApprovalDetail r102, ArrayList r103, ArrayList r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        boolean r111 = false;
    L7:
        if ((r105 & 2) == 0) goto L9;
        r101 = "";
    L9:
        String r106 = r101;
        if ((r105 & 4) == 0) goto L12;
        r102 = new ApprovalDetail(false, false, 3, null);
    L12:
        ApprovalDetail r107 = r102;
        if ((r105 & 8) == 0) goto L15;
        r103 = new ArrayList();
    L15:
        ArrayList r108 = r103;
        if ((r105 & 16) == 0) goto L18;
        r104 = new ArrayList();
    L18:
        boolean r109 = r111;
        this(r109, r106, r107, r108, r104);
        return;
    L5:
        r111 = r100;
        goto L7
    }
}
