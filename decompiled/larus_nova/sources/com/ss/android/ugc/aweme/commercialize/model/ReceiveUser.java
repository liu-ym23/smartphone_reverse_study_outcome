package com.ss.android.ugc.aweme.commercialize.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/commercialize/model/ReceiveUser;", "Ljava/io/Serializable;", "userId", "", "receiveTime", "", "useStatus", "", "(JILjava/lang/String;)V", "getReceiveTime", "()I", "getUseStatus", "()Ljava/lang/String;", "getUserId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ReceiveUser implements Serializable {

    @SerializedName("ReceiveTime")
    private final int receiveTime;

    @SerializedName("UseStatus")
    private final String useStatus;

    @SerializedName("UserID")
    private final long userId;

    public static /* synthetic */ ReceiveUser copy$default(ReceiveUser r100, long r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.userId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.receiveTime;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.useStatus;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final long component1() {
        return this.userId;
    }

    public final int component2() {
        return this.receiveTime;
    }

    public final String component3() {
        return this.useStatus;
    }

    public final ReceiveUser copy(long r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "useStatus");
        return new ReceiveUser(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReceiveUser) == true) goto L8;
        return false;
    L8:
        ReceiveUser r101 = (ReceiveUser) r100;
        if (this.userId == r101.userId) goto L12;
        return false;
    L12:
        if (this.receiveTime == r101.receiveTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.useStatus, r101.useStatus) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r100 = this.userId;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.receiveTime) * 31) + this.useStatus.hashCode();
    }

    public String toString() {
        return "ReceiveUser(userId=" + this.userId + ", receiveTime=" + this.receiveTime + ", useStatus=" + this.useStatus + ')';
    }

    public final int getReceiveTime() {
        return this.receiveTime;
    }

    public final String getUseStatus() {
        return this.useStatus;
    }

    public final long getUserId() {
        return this.userId;
    }

    public ReceiveUser(long r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "useStatus");
        this.userId = r100;
        this.receiveTime = r101;
        this.useStatus = r102;
    }
}
