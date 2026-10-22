package com.ss.android.lark.officesdk.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/api/OfficeSDKHostSession;", "", "hostUserId", "", "sessionKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getHostUserId", "()Ljava/lang/String;", "getSessionKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSDKHostSession {
    private final String hostUserId;
    private final String sessionKey;

    public static /* synthetic */ OfficeSDKHostSession copy$default(OfficeSDKHostSession r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.hostUserId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.sessionKey;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.hostUserId;
    }

    public final String component2() {
        return this.sessionKey;
    }

    public final OfficeSDKHostSession copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "hostUserId");
        Intrinsics.checkNotNullParameter(r101, "sessionKey");
        return new OfficeSDKHostSession(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSDKHostSession) == true) goto L8;
        return false;
    L8:
        OfficeSDKHostSession r101 = (OfficeSDKHostSession) r100;
        if (Intrinsics.areEqual(this.hostUserId, r101.hostUserId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionKey, r101.sessionKey) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.hostUserId.hashCode() * 31) + this.sessionKey.hashCode();
    }

    public String toString() {
        return "OfficeSDKHostSession(hostUserId=" + this.hostUserId + ", sessionKey=" + this.sessionKey + ')';
    }

    public final String getHostUserId() {
        return this.hostUserId;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public OfficeSDKHostSession(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "hostUserId");
        Intrinsics.checkNotNullParameter(r101, "sessionKey");
        this.hostUserId = r100;
        this.sessionKey = r101;
    }
}
