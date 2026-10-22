package com.bytedance.ee.bear.middleground.permission.escape.model;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import du5.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeApprovalInfo;", "Ljava/io/Serializable;", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "approvalList", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalList;", "<init>", "(Ljava/lang/String;ILcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalList;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getApprovalList", "()Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalList;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EscapeApprovalInfo implements Serializable {
    private final ApprovalList approvalList;
    private String token;
    private int type;

    public EscapeApprovalInfo() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ EscapeApprovalInfo copy$default(EscapeApprovalInfo r0, String r1, int r2, ApprovalList r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.token;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.approvalList;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.token;
    }

    public final int component2() {
        return this.type;
    }

    public final ApprovalList component3() {
        return this.approvalList;
    }

    public final EscapeApprovalInfo copy(String r2, int r3, ApprovalList r4) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "approvalList");
        return new EscapeApprovalInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EscapeApprovalInfo) == true) goto L8;
        return false;
    L8:
        EscapeApprovalInfo r6 = (EscapeApprovalInfo) r5;
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
        return false;
    L12:
        if (this.type == r6.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.approvalList, r6.approvalList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.token.hashCode() * 31) + this.type) * 31) + this.approvalList.hashCode();
    }

    public String toString() {
        return "EscapeApprovalInfo(token='$" + b.i(this.token) + "', type=" + this.type + ", approvalList=" + this.approvalList + ')';
    }

    public final ApprovalList getApprovalList() {
        return this.approvalList;
    }

    public final String getToken() {
        return this.token;
    }

    public final int getType() {
        return this.type;
    }

    public final void setToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.token = r2;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public EscapeApprovalInfo(String r2, int r3, ApprovalList r4) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "approvalList");
        this.token = r2;
        this.type = r3;
        this.approvalList = r4;
    }

    public /* synthetic */ EscapeApprovalInfo(String r1, int r2, ApprovalList r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = new ApprovalList(null, null, 3, null);
    L11:
        this(r1, r2, r3);
    }
}
