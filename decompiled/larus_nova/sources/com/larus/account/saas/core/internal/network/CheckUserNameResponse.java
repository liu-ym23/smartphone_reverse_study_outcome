package com.larus.account.saas.core.internal.network;

import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/larus/account/saas/core/internal/network/CheckUserNameResponse;", "", "userName", "", "isUnique", "", "(Ljava/lang/String;Z)V", "()Z", "getUserName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "account-saas-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CheckUserNameResponse {

    @SerializedName("is_unique")
    private final boolean isUnique;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final String userName;

    /* JADX WARN: Multi-variable type inference failed */
    public CheckUserNameResponse() {
        String r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CheckUserNameResponse copy$default(CheckUserNameResponse r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.userName;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isUnique;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.userName;
    }

    public final boolean component2() {
        return this.isUnique;
    }

    public final CheckUserNameResponse copy(String r100, boolean r101) {
        return new CheckUserNameResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CheckUserNameResponse) == true) goto L8;
        return false;
    L8:
        CheckUserNameResponse r101 = (CheckUserNameResponse) r100;
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L12;
        return false;
    L12:
        if (this.isUnique == r101.isUnique) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        String r100 = this.userName;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.isUnique;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CheckUserNameResponse(userName=" + this.userName + ", isUnique=" + this.isUnique + ')';
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean isUnique() {
        return this.isUnique;
    }

    public CheckUserNameResponse(String r100, boolean r101) {
        this.userName = r100;
        this.isUnique = r101;
    }

    public /* synthetic */ CheckUserNameResponse(String r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
