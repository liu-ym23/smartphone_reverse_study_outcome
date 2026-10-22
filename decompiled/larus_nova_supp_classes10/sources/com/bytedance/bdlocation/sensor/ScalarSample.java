package com.bytedance.bdlocation.sensor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/bdlocation/sensor/ScalarSample;", "", "timestampMs", "", "value", "", "(JF)V", "getTimestampMs", "()J", "getValue", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class ScalarSample {
    private final long timestampMs;
    private final float value;

    public static /* synthetic */ ScalarSample copy$default(ScalarSample r0, long r1, float r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.timestampMs;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.value;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.timestampMs;
    }

    public final float component2() {
        return this.value;
    }

    public final ScalarSample copy(long r2, float r4) {
        return new ScalarSample(r2, r4);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof ScalarSample) == false) goto L10;
        ScalarSample r7 = (ScalarSample) r6;
        if (this.timestampMs == r7.timestampMs) goto L8;
        return false;
    L8:
        if (Float.compare(this.value, r7.value) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r0 = this.timestampMs;
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + Float.floatToIntBits(this.value);
    }

    public String toString() {
        return "ScalarSample(timestampMs=" + this.timestampMs + ", value=" + this.value + ")";
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final float getValue() {
        return this.value;
    }

    public ScalarSample(long r1, float r3) {
        this.timestampMs = r1;
        this.value = r3;
    }
}
