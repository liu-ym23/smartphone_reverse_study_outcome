package com.bytedance.ee.bear;

import com.hihonor.honorid.core.data.UserInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/DocFreshInfo;", "Ljava/io/Serializable;", "freshState", "", UserInfo.UPDATE_TIME, "operatorId", "", "deadlineTime", "", "feedBackNum", "maxExpiredShowNum", "<init>", "(IILjava/lang/String;JII)V", "getFreshState", "()I", "setFreshState", "(I)V", "getUpdateTime", "getOperatorId", "()Ljava/lang/String;", "getDeadlineTime", "()J", "getFeedBackNum", "getMaxExpiredShowNum", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocFreshInfo implements Serializable {
    private final long deadlineTime;
    private final int feedBackNum;
    private int freshState;
    private final int maxExpiredShowNum;
    private final String operatorId;
    private final int updateTime;

    public DocFreshInfo() {
        this(0, 0, null, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ DocFreshInfo copy$default(DocFreshInfo r100, int r101, int r102, String r103, long r104, int r110, int r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.freshState;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.updateTime;
    L8:
        int r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.operatorId;
    L11:
        String r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r104 = r100.deadlineTime;
    L14:
        long r106 = r104;
        if ((r112 & 16) == 0) goto L17;
        r110 = r100.feedBackNum;
    L17:
        int r107 = r110;
        if ((r112 & 32) == 0) goto L20;
        r111 = r100.maxExpiredShowNum;
    L20:
        int r108 = r101;
        return r100.copy(r108, r114, r105, r106, r107, r111);
    }

    public final int component1() {
        return this.freshState;
    }

    public final int component2() {
        return this.updateTime;
    }

    public final String component3() {
        return this.operatorId;
    }

    public final long component4() {
        return this.deadlineTime;
    }

    public final int component5() {
        return this.feedBackNum;
    }

    public final int component6() {
        return this.maxExpiredShowNum;
    }

    public final DocFreshInfo copy(int r110, int r111, String r112, long r113, int r114, int r115) {
        Intrinsics.checkNotNullParameter(r112, "operatorId");
        return new DocFreshInfo(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocFreshInfo) == true) goto L8;
        return false;
    L8:
        DocFreshInfo r101 = (DocFreshInfo) r100;
        if (this.freshState == r101.freshState) goto L12;
        return false;
    L12:
        if (this.updateTime == r101.updateTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.operatorId, r101.operatorId) == true) goto L18;
        return false;
    L18:
        if (this.deadlineTime == r101.deadlineTime) goto L21;
        return false;
    L21:
        if (this.feedBackNum == r101.feedBackNum) goto L24;
        return false;
    L24:
        if (this.maxExpiredShowNum == r101.maxExpiredShowNum) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.freshState * 31) + this.updateTime) * 31) + this.operatorId.hashCode()) * 31;
        long r101 = this.deadlineTime;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.feedBackNum) * 31) + this.maxExpiredShowNum;
    }

    public String toString() {
        return "DocFreshInfo(freshState=" + this.freshState + ", updateTime=" + this.updateTime + ", operatorId=" + this.operatorId + ", deadlineTime=" + this.deadlineTime + ", feedBackNum=" + this.feedBackNum + ", maxExpiredShowNum=" + this.maxExpiredShowNum + ')';
    }

    public final long getDeadlineTime() {
        return this.deadlineTime;
    }

    public final int getFeedBackNum() {
        return this.feedBackNum;
    }

    public final int getFreshState() {
        return this.freshState;
    }

    public final int getMaxExpiredShowNum() {
        return this.maxExpiredShowNum;
    }

    public final String getOperatorId() {
        return this.operatorId;
    }

    public final int getUpdateTime() {
        return this.updateTime;
    }

    public final void setFreshState(int r100) {
        this.freshState = r100;
    }

    public DocFreshInfo(int r100, int r101, String r102, long r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r102, "operatorId");
        this.freshState = r100;
        this.updateTime = r101;
        this.operatorId = r102;
        this.deadlineTime = r103;
        this.feedBackNum = r104;
        this.maxExpiredShowNum = r105;
    }

    public /* synthetic */ DocFreshInfo(int r100, int r101, String r102, long r103, int r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        int r104 = -1;
        if ((r112 & 2) == 0) goto L8;
        int r114 = -1;
    L10:
        if ((r112 & 4) == 0) goto L12;
        r102 = "";
    L12:
        String r105 = r102;
        if ((r112 & 8) == 0) goto L15;
        r103 = -1;
    L15:
        long r106 = r103;
        if ((r112 & 16) != 0) goto L20;
        r104 = r110;
    L20:
        if ((r112 & 32) == 0) goto L22;
        int r107 = Integer.MAX_VALUE;
    L23:
        this(r100, r114, r105, r106, r104, r107);
        return;
    L22:
        r107 = r111;
        goto L23
    L8:
        r114 = r101;
        goto L10
    }
}
