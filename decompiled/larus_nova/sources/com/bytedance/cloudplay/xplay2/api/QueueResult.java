package com.bytedance.cloudplay.xplay2.api;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/QueueResult;", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "", "estimatedWaitingTime", "actualWaitingTime", "(JJJ)V", "getActualWaitingTime", "()J", "getEstimatedWaitingTime", "getExpireTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "xplay2-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QueueResult {
    private final long actualWaitingTime;
    private final long estimatedWaitingTime;
    private final long expireTime;

    public static /* synthetic */ QueueResult copy$default(QueueResult r100, long r101, long r110, long r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.expireTime;
    L5:
        long r102 = r101;
        if ((r112 & 2) == 0) goto L8;
        r110 = r100.estimatedWaitingTime;
    L8:
        long r103 = r110;
        if ((r112 & 4) == 0) goto L12;
        r111 = r100.actualWaitingTime;
    L12:
        return r100.copy(r102, r103, r111);
    }

    public final long component1() {
        return this.expireTime;
    }

    public final long component2() {
        return this.estimatedWaitingTime;
    }

    public final long component3() {
        return this.actualWaitingTime;
    }

    public final QueueResult copy(long r100, long r110, long r111) {
        return new QueueResult(r100, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QueueResult) == true) goto L8;
        return false;
    L8:
        QueueResult r101 = (QueueResult) r100;
        if (this.expireTime == r101.expireTime) goto L12;
        return false;
    L12:
        if (this.estimatedWaitingTime == r101.estimatedWaitingTime) goto L15;
        return false;
    L15:
        if (this.actualWaitingTime == r101.actualWaitingTime) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r100 = this.expireTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.estimatedWaitingTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.actualWaitingTime;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public String toString() {
        return "QueueResult(expireTime=" + this.expireTime + ", estimatedWaitingTime=" + this.estimatedWaitingTime + ", actualWaitingTime=" + this.actualWaitingTime + ')';
    }

    public final long getActualWaitingTime() {
        return this.actualWaitingTime;
    }

    public final long getEstimatedWaitingTime() {
        return this.estimatedWaitingTime;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public QueueResult(long r100, long r101, long r102) {
        this.expireTime = r100;
        this.estimatedWaitingTime = r101;
        this.actualWaitingTime = r102;
    }
}
