package com.bytedance.bdlocation.sensor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/bdlocation/sensor/GnssSatelliteStatusSample;", "", "timestampMs", "", "svid", "", "constellationType", "elevationDeg", "", "azimuthDeg", "usedInFix", "", "(JIIFFZ)V", "getAzimuthDeg", "()F", "getConstellationType", "()I", "getElevationDeg", "getSvid", "getTimestampMs", "()J", "getUsedInFix", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class GnssSatelliteStatusSample {
    private final float azimuthDeg;
    private final int constellationType;
    private final float elevationDeg;
    private final int svid;
    private final long timestampMs;
    private final boolean usedInFix;

    public static /* synthetic */ GnssSatelliteStatusSample copy$default(GnssSatelliteStatusSample r100, long r101, int r110, int r111, float r112, float r113, boolean r114, int r115, Object r116) {
        if ((r115 & 1) == 0) goto L5;
        long r102 = r100.timestampMs;
    L7:
        if ((r115 & 2) == 0) goto L9;
        int r103 = r100.svid;
    L11:
        if ((r115 & 4) == 0) goto L13;
        int r104 = r100.constellationType;
    L15:
        if ((r115 & 8) == 0) goto L17;
        float r105 = r100.elevationDeg;
    L19:
        if ((r115 & 16) == 0) goto L21;
        float r106 = r100.azimuthDeg;
    L23:
        if ((r115 & 32) == 0) goto L25;
        boolean r107 = r100.usedInFix;
    L27:
        return r100.copy(r102, r103, r104, r105, r106, r107);
    L25:
        r107 = r114;
        goto L27
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
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

    public final GnssSatelliteStatusSample copy(long r110, int r111, int r112, float r113, float r114, boolean r115) {
        return new GnssSatelliteStatusSample(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GnssSatelliteStatusSample) == false) goto L18;
        GnssSatelliteStatusSample r101 = (GnssSatelliteStatusSample) r100;
        if (this.timestampMs == r101.timestampMs) goto L8;
        return false;
    L8:
        if (this.svid == r101.svid) goto L10;
        return false;
    L10:
        if (this.constellationType == r101.constellationType) goto L12;
        return false;
    L12:
        if (Float.compare(this.elevationDeg, r101.elevationDeg) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.azimuthDeg, r101.azimuthDeg) == 0) goto L16;
        return false;
    L16:
        if (this.usedInFix == r101.usedInFix) goto L28;
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
        long r100 = this.timestampMs;
        int r101 = ((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.svid) * 31) + this.constellationType) * 31) + Float.floatToIntBits(this.elevationDeg)) * 31) + Float.floatToIntBits(this.azimuthDeg)) * 31;
        boolean r102 = this.usedInFix;
        ?? r103 = r102;
        if (r102 == false) goto L6;
        r103 = 1;
    L6:
        return r101 + r103;
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

    public GnssSatelliteStatusSample(long r100, int r101, int r102, float r103, float r104, boolean r105) {
        this.timestampMs = r100;
        this.svid = r101;
        this.constellationType = r102;
        this.elevationDeg = r103;
        this.azimuthDeg = r104;
        this.usedInFix = r105;
    }
}
