package com.bytedance.bdlocation.sensor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/bdlocation/sensor/AxisSample;", "", "timestampMs", "", "x", "", "y", "z", "(JFFF)V", "getTimestampMs", "()J", "getX", "()F", "getY", "getZ", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class AxisSample {
    private final long timestampMs;
    private final float x;
    private final float y;
    private final float z;

    public static /* synthetic */ AxisSample copy$default(AxisSample r6, long r7, float r9, float r10, float r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.timestampMs;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.x;
    L8:
        float r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.y;
    L11:
        float r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        r11 = r6.z;
    L15:
        return r6.copy(r1, r3, r4, r11);
    }

    public final long component1() {
        return this.timestampMs;
    }

    public final float component2() {
        return this.x;
    }

    public final float component3() {
        return this.y;
    }

    public final float component4() {
        return this.z;
    }

    public final AxisSample copy(long r8, float r10, float r11, float r12) {
        return new AxisSample(r8, r10, r11, r12);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof AxisSample) == false) goto L14;
        AxisSample r7 = (AxisSample) r6;
        if (this.timestampMs == r7.timestampMs) goto L8;
        return false;
    L8:
        if (Float.compare(this.x, r7.x) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.y, r7.y) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.z, r7.z) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        long r0 = this.timestampMs;
        return (((((((int) (r0 ^ (r0 >>> 32))) * 31) + Float.floatToIntBits(this.x)) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z);
    }

    public String toString() {
        return "AxisSample(timestampMs=" + this.timestampMs + ", x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final float getZ() {
        return this.z;
    }

    public AxisSample(long r1, float r3, float r4, float r5) {
        this.timestampMs = r1;
        this.x = r3;
        this.y = r4;
        this.z = r5;
    }
}
