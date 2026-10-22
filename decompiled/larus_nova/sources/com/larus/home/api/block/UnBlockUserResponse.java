package com.larus.home.api.block;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/larus/home/api/block/UnBlockUserResponse;", "", "unblockUserId", "", "<init>", "(Ljava/lang/String;)V", "getUnblockUserId", "()Ljava/lang/String;", "setUnblockUserId", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnBlockUserResponse {
    private transient String unblockUserId;

    /* JADX WARN: Multi-variable type inference failed */
    public UnBlockUserResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UnBlockUserResponse copy$default(UnBlockUserResponse r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.unblockUserId;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.unblockUserId;
    }

    public final UnBlockUserResponse copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "unblockUserId");
        return new UnBlockUserResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UnBlockUserResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.unblockUserId, ((UnBlockUserResponse) r100).unblockUserId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.unblockUserId.hashCode();
    }

    public String toString() {
        return "UnBlockUserResponse(unblockUserId=" + this.unblockUserId + ')';
    }

    public final String getUnblockUserId() {
        return this.unblockUserId;
    }

    public UnBlockUserResponse(String r100) {
        Intrinsics.checkNotNullParameter(r100, "unblockUserId");
        this.unblockUserId = r100;
    }

    public final void setUnblockUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.unblockUserId = r100;
    }

    public /* synthetic */ UnBlockUserResponse(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
