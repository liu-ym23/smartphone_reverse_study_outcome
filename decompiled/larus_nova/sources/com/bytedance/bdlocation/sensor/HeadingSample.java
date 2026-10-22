package com.bytedance.bdlocation.sensor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/bdlocation/sensor/HeadingSample;", "", "timestampMs", "", "headingDegrees", "", "(JF)V", "getHeadingDegrees", "()F", "getTimestampMs", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class HeadingSample {
    private final float headingDegrees;
    private final long timestampMs;

    public static /* synthetic */ HeadingSample copy$default(HeadingSample r100, long r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.timestampMs;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.headingDegrees;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.timestampMs;
    }

    public final float component2() {
        return this.headingDegrees;
    }

    public final HeadingSample copy(long r100, float r101) {
        return new HeadingSample(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeadingSample) == false) goto L10;
        HeadingSample r101 = (HeadingSample) r100;
        if (this.timestampMs == r101.timestampMs) goto L8;
        return false;
    L8:
        if (Float.compare(this.headingDegrees, r101.headingDegrees) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r100 = this.timestampMs;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + Float.floatToIntBits(this.headingDegrees);
    }

    public String toString() {
        return "HeadingSample(timestampMs=" + this.timestampMs + ", headingDegrees=" + this.headingDegrees + ")";
    }

    public final float getHeadingDegrees() {
        return this.headingDegrees;
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public HeadingSample(long r100, float r101) {
        this.timestampMs = r100;
        this.headingDegrees = r101;
    }
}
