package com.bytedance.bdlocation.sensor;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001a¨\u00060"}, d2 = {"Lcom/bytedance/bdlocation/sensor/GnssMeasurementSample;", "", "svid", "", "constellationType", "pseudorangeM", "", "carrierPhaseCycles", "dopplerHz", "cn0Dbhz", "", "gnssTimeNs", "", "systemTimeNs", "signalSyncState", "adrState", "(IIDDDFJJII)V", "getAdrState", "()I", "getCarrierPhaseCycles", "()D", "getCn0Dbhz", "()F", "getConstellationType", "getDopplerHz", "getGnssTimeNs", "()J", "getPseudorangeM", "getSignalSyncState", "getSvid", "getSystemTimeNs", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class GnssMeasurementSample {
    private final int adrState;
    private final double carrierPhaseCycles;
    private final float cn0Dbhz;
    private final int constellationType;
    private final double dopplerHz;
    private final long gnssTimeNs;
    private final double pseudorangeM;
    private final int signalSyncState;
    private final int svid;
    private final long systemTimeNs;

    public static /* synthetic */ GnssMeasurementSample copy$default(GnssMeasurementSample r16, int r17, int r18, double r19, double r21, double r23, float r25, long r26, long r28, int r30, int r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        int r2 = r16.svid;
    L7:
        if ((r32 & 2) == 0) goto L9;
        int r3 = r16.constellationType;
    L11:
        if ((r32 & 4) == 0) goto L13;
        double r4 = r16.pseudorangeM;
    L15:
        if ((r32 & 8) == 0) goto L17;
        double r6 = r16.carrierPhaseCycles;
    L19:
        if ((r32 & 16) == 0) goto L21;
        double r8 = r16.dopplerHz;
    L23:
        if ((r32 & 32) == 0) goto L25;
        float r10 = r16.cn0Dbhz;
    L27:
        if ((r32 & 64) == 0) goto L29;
        long r11 = r16.gnssTimeNs;
    L31:
        if ((r32 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        long r13 = r16.systemTimeNs;
    L35:
        if ((r32 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        int r15 = r16.signalSyncState;
    L39:
        if ((r32 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        int r1 = r16.adrState;
    L43:
        return r16.copy(r2, r3, r4, r6, r8, r10, r11, r13, r15, r1);
    L41:
        r1 = r31;
        goto L43
    L37:
        r15 = r30;
        goto L39
    L33:
        r13 = r28;
        goto L35
    L29:
        r11 = r26;
        goto L31
    L25:
        r10 = r25;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final int component1() {
        return this.svid;
    }

    public final int component10() {
        return this.adrState;
    }

    public final int component2() {
        return this.constellationType;
    }

    public final double component3() {
        return this.pseudorangeM;
    }

    public final double component4() {
        return this.carrierPhaseCycles;
    }

    public final double component5() {
        return this.dopplerHz;
    }

    public final float component6() {
        return this.cn0Dbhz;
    }

    public final long component7() {
        return this.gnssTimeNs;
    }

    public final long component8() {
        return this.systemTimeNs;
    }

    public final int component9() {
        return this.signalSyncState;
    }

    public final GnssMeasurementSample copy(int r18, int r19, double r20, double r22, double r24, float r26, long r27, long r29, int r31, int r32) {
        return new GnssMeasurementSample(r18, r19, r20, r22, r24, r26, r27, r29, r31, r32);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof GnssMeasurementSample) == false) goto L26;
        GnssMeasurementSample r7 = (GnssMeasurementSample) r6;
        if (this.svid == r7.svid) goto L8;
        return false;
    L8:
        if (this.constellationType == r7.constellationType) goto L10;
        return false;
    L10:
        if (Double.compare(this.pseudorangeM, r7.pseudorangeM) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.carrierPhaseCycles, r7.carrierPhaseCycles) == 0) goto L14;
        return false;
    L14:
        if (Double.compare(this.dopplerHz, r7.dopplerHz) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.cn0Dbhz, r7.cn0Dbhz) == 0) goto L18;
        return false;
    L18:
        if (this.gnssTimeNs == r7.gnssTimeNs) goto L20;
        return false;
    L20:
        if (this.systemTimeNs == r7.systemTimeNs) goto L22;
        return false;
    L22:
        if (this.signalSyncState == r7.signalSyncState) goto L24;
        return false;
    L24:
        if (this.adrState == r7.adrState) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = ((this.svid * 31) + this.constellationType) * 31;
        long r1 = Double.doubleToLongBits(this.pseudorangeM);
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = Double.doubleToLongBits(this.carrierPhaseCycles);
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = Double.doubleToLongBits(this.dopplerHz);
        int r6 = (((r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31) + Float.floatToIntBits(this.cn0Dbhz)) * 31;
        long r7 = this.gnssTimeNs;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.systemTimeNs;
        return ((((r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31) + this.signalSyncState) * 31) + this.adrState;
    }

    public String toString() {
        return "GnssMeasurementSample(svid=" + this.svid + ", constellationType=" + this.constellationType + ", pseudorangeM=" + this.pseudorangeM + ", carrierPhaseCycles=" + this.carrierPhaseCycles + ", dopplerHz=" + this.dopplerHz + ", cn0Dbhz=" + this.cn0Dbhz + ", gnssTimeNs=" + this.gnssTimeNs + ", systemTimeNs=" + this.systemTimeNs + ", signalSyncState=" + this.signalSyncState + ", adrState=" + this.adrState + ")";
    }

    public final int getAdrState() {
        return this.adrState;
    }

    public final double getCarrierPhaseCycles() {
        return this.carrierPhaseCycles;
    }

    public final float getCn0Dbhz() {
        return this.cn0Dbhz;
    }

    public final int getConstellationType() {
        return this.constellationType;
    }

    public final double getDopplerHz() {
        return this.dopplerHz;
    }

    public final long getGnssTimeNs() {
        return this.gnssTimeNs;
    }

    public final double getPseudorangeM() {
        return this.pseudorangeM;
    }

    public final int getSignalSyncState() {
        return this.signalSyncState;
    }

    public final int getSvid() {
        return this.svid;
    }

    public final long getSystemTimeNs() {
        return this.systemTimeNs;
    }

    public GnssMeasurementSample(int r1, int r2, double r3, double r5, double r7, float r9, long r10, long r12, int r14, int r15) {
        this.svid = r1;
        this.constellationType = r2;
        this.pseudorangeM = r3;
        this.carrierPhaseCycles = r5;
        this.dopplerHz = r7;
        this.cn0Dbhz = r9;
        this.gnssTimeNs = r10;
        this.systemTimeNs = r12;
        this.signalSyncState = r14;
        this.adrState = r15;
    }
}
