package com.bytedance.ee.bear.middleground.permission.escape.request;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.escape.model.ApprovalDetail;
import com.bytedance.ee.bear.middleground.permission.escape.model.Reviewer;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public static /* synthetic */ EscapeRuleResult copy$default(EscapeRuleResult r3, boolean r4, String r5, ApprovalDetail r6, ArrayList r7, ArrayList r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.isOpen;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.approvalCode;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.approvalDetail;
    L11:
        ApprovalDetail r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.reviewers;
    L14:
        ArrayList r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.ccUsers;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
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

    public final EscapeRuleResult copy(boolean r8, String r9, ApprovalDetail r10, ArrayList<Reviewer> r11, ArrayList<Reviewer> r12) {
        Intrinsics.checkNotNullParameter(r9, "approvalCode");
        Intrinsics.checkNotNullParameter(r10, "approvalDetail");
        Intrinsics.checkNotNullParameter(r11, "reviewers");
        Intrinsics.checkNotNullParameter(r12, "ccUsers");
        return new EscapeRuleResult(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EscapeRuleResult) == true) goto L8;
        return false;
    L8:
        EscapeRuleResult r6 = (EscapeRuleResult) r5;
        if (this.isOpen == r6.isOpen) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.approvalCode, r6.approvalCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.approvalDetail, r6.approvalDetail) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reviewers, r6.reviewers) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ccUsers, r6.ccUsers) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.isOpen == false) goto L5;
        int r0 = 1231;
    L7:
        return (((((((r0 * 31) + this.approvalCode.hashCode()) * 31) + this.approvalDetail.hashCode()) * 31) + this.reviewers.hashCode()) * 31) + this.ccUsers.hashCode();
    L5:
        r0 = 1237;
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

    public EscapeRuleResult(boolean r2, String r3, ApprovalDetail r4, ArrayList<Reviewer> r5, ArrayList<Reviewer> r6) {
        Intrinsics.checkNotNullParameter(r3, "approvalCode");
        Intrinsics.checkNotNullParameter(r4, "approvalDetail");
        Intrinsics.checkNotNullParameter(r5, "reviewers");
        Intrinsics.checkNotNullParameter(r6, "ccUsers");
        this.isOpen = r2;
        this.approvalCode = r3;
        this.approvalDetail = r4;
        this.reviewers = r5;
        this.ccUsers = r6;
    }

    public /* synthetic */ EscapeRuleResult(boolean r4, String r5, ApprovalDetail r6, ArrayList r7, ArrayList r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        boolean r11 = false;
    L7:
        if ((r9 & 2) == 0) goto L9;
        r5 = "";
    L9:
        String r1 = r5;
        if ((r9 & 4) == 0) goto L12;
        r6 = new ApprovalDetail(false, false, 3, null);
    L12:
        ApprovalDetail r0 = r6;
        if ((r9 & 8) == 0) goto L15;
        r7 = new ArrayList();
    L15:
        ArrayList r2 = r7;
        if ((r9 & 16) == 0) goto L18;
        r8 = new ArrayList();
    L18:
        boolean r12 = r11;
        this(r12, r1, r0, r2, r8);
        return;
    L5:
        r11 = r4;
        goto L7
    }
}
