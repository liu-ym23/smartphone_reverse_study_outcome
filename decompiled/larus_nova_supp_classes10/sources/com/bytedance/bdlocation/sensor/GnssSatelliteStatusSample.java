package com.bytedance.bdlocation.sensor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/bdlocation/sensor/GnssSatelliteStatusSample;", "", "timestampMs", "", "svid", "", "constellationType", "elevationDeg", "", "azimuthDeg", "usedInFix", "", "(JIIFFZ)V", "getAzimuthDeg", "()F", "getConstellationType", "()I", "getElevationDeg", "getSvid", "getTimestampMs", "()J", "getUsedInFix", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class GnssSatelliteStatusSample {
    private final float azimuthDeg;
    private final int constellationType;
    private final float elevationDeg;
    private final int svid;
    private final long timestampMs;
    private final boolean usedInFix;

    public static /* synthetic */ GnssSatelliteStatusSample copy$default(GnssSatelliteStatusSample r8, long r9, int r11, int r12, float r13, float r14, boolean r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r1 = r8.timestampMs;
    L7:
        if ((r16 & 2) == 0) goto L9;
        int r3 = r8.svid;
    L11:
        if ((r16 & 4) == 0) goto L13;
        int r4 = r8.constellationType;
    L15:
        if ((r16 & 8) == 0) goto L17;
        float r5 = r8.elevationDeg;
    L19:
        if ((r16 & 16) == 0) goto L21;
        float r6 = r8.azimuthDeg;
    L23:
        if ((r16 & 32) == 0) goto L25;
        boolean r7 = r8.usedInFix;
    L27:
        return r8.copy(r1, r3, r4, r5, r6, r7);
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final long component1() {
        return this.timestampMs;
    }

    public final int component2() {
        return this.svid;
    }

    public final int component3() {
        return this.constellationType;
    }

    public final float component4() {
        return this.elevationDeg;
    }

    public final float component5() {
        return this.azimuthDeg;
    }

    public final boolean component6() {
        return this.usedInFix;
    }

    public final GnssSatelliteStatusSample copy(long r10, int r12, int r13, float r14, float r15, boolean r16) {
        return new GnssSatelliteStatusSample(r10, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof GnssSatelliteStatusSample) == false) goto L18;
        GnssSatelliteStatusSample r7 = (GnssSatelliteStatusSample) r6;
        if (this.timestampMs == r7.timestampMs) goto L8;
        return false;
    L8:
        if (this.svid == r7.svid) goto L10;
        return false;
    L10:
        if (this.constellationType == r7.constellationType) goto L12;
        return false;
    L12:
        if (Float.compare(this.elevationDeg, r7.elevationDeg) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.azimuthDeg, r7.azimuthDeg) == 0) goto L16;
        return false;
    L16:
        if (this.usedInFix == r7.usedInFix) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public int hashCode() {
        long r0 = this.timestampMs;
        int r1 = ((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.svid) * 31) + this.constellationType) * 31) + Float.floatToIntBits(this.elevationDeg)) * 31) + Float.floatToIntBits(this.azimuthDeg)) * 31;
        boolean r2 = this.usedInFix;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r1 + r3;
    }

    public String toString() {
        return "GnssSatelliteStatusSample(timestampMs=" + this.timestampMs + ", svid=" + this.svid + ", constellationType=" + this.constellationType + ", elevationDeg=" + this.elevationDeg + ", azimuthDeg=" + this.azimuthDeg + ", usedInFix=" + this.usedInFix + ")";
    }

    public final float getAzimuthDeg() {
        return this.azimuthDeg;
    }

    public final int getConstellationType() {
        return this.constellationType;
    }

    public final float getElevationDeg() {
        return this.elevationDeg;
    }

    public final int getSvid() {
        return this.svid;
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final boolean getUsedInFix() {
        return this.usedInFix;
    }

    public GnssSatelliteStatusSample(long r1, int r3, int r4, float r5, float r6, boolean r7) {
        this.timestampMs = r1;
        this.svid = r3;
        this.constellationType = r4;
        this.elevationDeg = r5;
        this.azimuthDeg = r6;
        this.usedInFix = r7;
    }
}
