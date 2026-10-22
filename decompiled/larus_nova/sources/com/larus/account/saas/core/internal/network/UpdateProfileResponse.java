package com.larus.account.saas.core.internal.network;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/larus/account/saas/core/internal/network/UpdateProfileResponse;", "", "userID", "", "(Ljava/lang/String;)V", "getUserID", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "account-saas-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UpdateProfileResponse {

    @SerializedName(PickerReporterConstants.KEY.ENTITY_ID)
    private final String userID;

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateProfileResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UpdateProfileResponse copy$default(UpdateProfileResponse r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.userID;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.userID;
    }

    public final UpdateProfileResponse copy(String r100) {
        return new UpdateProfileResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateProfileResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.userID, ((UpdateProfileResponse) r100).userID) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r100 = this.userID;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "UpdateProfileResponse(userID=" + this.userID + ')';
    }

    public final String getUserID() {
        return this.userID;
    }

    public UpdateProfileResponse(String r100) {
        this.userID = r100;
    }

    public /* synthetic */ UpdateProfileResponse(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
