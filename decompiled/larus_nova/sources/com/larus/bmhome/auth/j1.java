package com.larus.bmhome.auth;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0004\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/auth/UserLaunchCoreRequest;", "", "userLandingTag", "", "isFirstColdStart", "", "coldStartTimestampMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)V", "getUserLandingTag", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getColdStartTimestampMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/larus/bmhome/auth/UserLaunchCoreRequest;", "equals", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j1 {

    @SerializedName("cold_start_timestamp_ms")
    private final Long coldStartTimestampMs;

    @SerializedName("is_first_cold_start")
    private final Boolean isFirstColdStart;

    @SerializedName("user_landing_tag")
    private final String userLandingTag;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r101 = (j1) r100;
        if (Intrinsics.areEqual(this.userLandingTag, r101.userLandingTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isFirstColdStart, r101.isFirstColdStart) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.coldStartTimestampMs, r101.coldStartTimestampMs) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.userLandingTag;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isFirstColdStart;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.coldStartTimestampMs;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserLaunchCoreRequest(userLandingTag=" + this.userLandingTag + ", isFirstColdStart=" + this.isFirstColdStart + ", coldStartTimestampMs=" + this.coldStartTimestampMs + ')';
    }

    public j1() {
        this.userLandingTag = null;
        this.isFirstColdStart = null;
        this.coldStartTimestampMs = null;
    }
}
