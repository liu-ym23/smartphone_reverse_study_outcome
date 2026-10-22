package com.larus.account.saas.core.internal.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/larus/account/saas/core/internal/network/ProfileBriefResponse;", "", "userInfo", "Lcom/larus/account/saas/core/internal/network/NetworkUserInfo;", "(Lcom/larus/account/saas/core/internal/network/NetworkUserInfo;)V", "getUserInfo", "()Lcom/larus/account/saas/core/internal/network/NetworkUserInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "account-saas-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ProfileBriefResponse {

    @SerializedName("profile_brief")
    private final NetworkUserInfo userInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileBriefResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ProfileBriefResponse copy$default(ProfileBriefResponse r100, NetworkUserInfo r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.userInfo;
    L6:
        return r100.copy(r101);
    }

    public final NetworkUserInfo component1() {
        return this.userInfo;
    }

    public final ProfileBriefResponse copy(NetworkUserInfo r100) {
        return new ProfileBriefResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProfileBriefResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.userInfo, ((ProfileBriefResponse) r100).userInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        NetworkUserInfo r100 = this.userInfo;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ProfileBriefResponse(userInfo=" + this.userInfo + ')';
    }

    public final NetworkUserInfo getUserInfo() {
        return this.userInfo;
    }

    public ProfileBriefResponse(NetworkUserInfo r100) {
        this.userInfo = r100;
    }

    public /* synthetic */ ProfileBriefResponse(NetworkUserInfo r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
