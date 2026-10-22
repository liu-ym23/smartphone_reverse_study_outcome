package com.bytedance.cloudplay.xplay2.api;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/QueueState;", "", "ranking", "", "rankTotal", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, "", "(IIJ)V", "getRankTotal", "()I", "getRanking", "getWaitTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "xplay2-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QueueState {
    private final int rankTotal;
    private final int ranking;
    private final long waitTime;

    public static /* synthetic */ QueueState copy$default(QueueState r100, int r101, int r102, long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.ranking;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.rankTotal;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.waitTime;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.ranking;
    }

    public final int component2() {
        return this.rankTotal;
    }

    public final long component3() {
        return this.waitTime;
    }

    public final QueueState copy(int r100, int r101, long r102) {
        return new QueueState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QueueState) == true) goto L8;
        return false;
    L8:
        QueueState r101 = (QueueState) r100;
        if (this.ranking == r101.ranking) goto L12;
        return false;
    L12:
        if (this.rankTotal == r101.rankTotal) goto L15;
        return false;
    L15:
        if (this.waitTime == r101.waitTime) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.ranking * 31) + this.rankTotal) * 31;
        long r101 = this.waitTime;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "QueueState(ranking=" + this.ranking + ", rankTotal=" + this.rankTotal + ", waitTime=" + this.waitTime + ')';
    }

    public final int getRankTotal() {
        return this.rankTotal;
    }

    public final int getRanking() {
        return this.ranking;
    }

    public final long getWaitTime() {
        return this.waitTime;
    }

    public QueueState(int r100, int r101, long r102) {
        this.ranking = r100;
        this.rankTotal = r101;
        this.waitTime = r102;
    }
}
