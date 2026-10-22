package com.larus.account.bdauth.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J+\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/larus/account/bdauth/api/UserInfoRequest;", "", "userId", "", "visitLarkId", "from", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getVisitLarkId", "setVisitLarkId", "getFrom", "()I", "setFrom", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserInfoRequest {

    @SerializedName("from")
    private int from;

    @SerializedName("visit_id")
    private String userId;

    @SerializedName("visit_lark_id")
    private String visitLarkId;

    public UserInfoRequest() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ UserInfoRequest copy$default(UserInfoRequest r100, String r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.userId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.visitLarkId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.from;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.visitLarkId;
    }

    public final int component3() {
        return this.from;
    }

    public final UserInfoRequest copy(String r100, String r101, int r102) {
        return new UserInfoRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserInfoRequest) == true) goto L8;
        return false;
    L8:
        UserInfoRequest r101 = (UserInfoRequest) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.visitLarkId, r101.visitLarkId) == true) goto L15;
        return false;
    L15:
        if (this.from == r101.from) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.userId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.visitLarkId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.from;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UserInfoRequest(userId=" + this.userId + ", visitLarkId=" + this.visitLarkId + ", from=" + this.from + ')';
    }

    public final int getFrom() {
        return this.from;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVisitLarkId() {
        return this.visitLarkId;
    }

    public final void setFrom(int r100) {
        this.from = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }

    public final void setVisitLarkId(String r100) {
        this.visitLarkId = r100;
    }

    public UserInfoRequest(String r100, String r101, int r102) {
        this.userId = r100;
        this.visitLarkId = r101;
        this.from = r102;
    }

    public /* synthetic */ UserInfoRequest(String r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
