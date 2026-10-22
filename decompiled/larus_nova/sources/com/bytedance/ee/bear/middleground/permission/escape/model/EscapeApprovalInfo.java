package com.bytedance.ee.bear.middleground.permission.escape.model;

import du5.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeApprovalInfo;", "Ljava/io/Serializable;", "token", "", "type", "", "approvalList", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalList;", "<init>", "(Ljava/lang/String;ILcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalList;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getApprovalList", "()Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalList;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EscapeApprovalInfo implements Serializable {
    private final ApprovalList approvalList;
    private String token;
    private int type;

    public EscapeApprovalInfo() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ EscapeApprovalInfo copy$default(EscapeApprovalInfo r100, String r101, int r102, ApprovalList r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.token;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.approvalList;
    L12:
        return r100.copy(r101, r102, r103);
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

    public final EscapeApprovalInfo copy(String r100, int r101, ApprovalList r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "approvalList");
        return new EscapeApprovalInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EscapeApprovalInfo) == true) goto L8;
        return false;
    L8:
        EscapeApprovalInfo r101 = (EscapeApprovalInfo) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.approvalList, r101.approvalList) == true) goto L17;
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

    public final void setToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.token = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public EscapeApprovalInfo(String r100, int r101, ApprovalList r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "approvalList");
        this.token = r100;
        this.type = r101;
        this.approvalList = r102;
    }

    public /* synthetic */ EscapeApprovalInfo(String r100, int r101, ApprovalList r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new ApprovalList(null, null, 3, null);
    L11:
        this(r100, r101, r102);
    }
}
