package com.bytedance.bdlocation.sensor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
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

    public static /* synthetic */ GnssMeasurementSample copy$default(GnssMeasurementSample r110, int r111, int r112, double r113, double r210, double r211, float r212, long r213, long r214, int r310, int r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        int r100 = r110.svid;
    L7:
        if ((r312 & 2) == 0) goto L9;
        int r101 = r110.constellationType;
    L11:
        if ((r312 & 4) == 0) goto L13;
        double r102 = r110.pseudorangeM;
    L15:
        if ((r312 & 8) == 0) goto L17;
        double r103 = r110.carrierPhaseCycles;
    L19:
        if ((r312 & 16) == 0) goto L21;
        double r104 = r110.dopplerHz;
    L23:
        if ((r312 & 32) == 0) goto L25;
        float r114 = r110.cn0Dbhz;
    L27:
        if ((r312 & 64) == 0) goto L29;
        long r115 = r110.gnssTimeNs;
    L31:
        if ((r312 & 128) == 0) goto L33;
        long r116 = r110.systemTimeNs;
    L35:
        if ((r312 & 256) == 0) goto L37;
        int r117 = r110.signalSyncState;
    L39:
        if ((r312 & 512) == 0) goto L41;
        int r105 = r110.adrState;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r114, r115, r116, r117, r105);
    L41:
        r105 = r311;
        goto L43
    L37:
        r117 = r310;
        goto L39
    L33:
        r116 = r214;
        goto L35
    L29:
        r115 = r213;
        goto L31
    L25:
        r114 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
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

    public final GnssMeasurementSample copy(int r110, int r111, double r210, double r211, double r212, float r213, long r214, long r215, int r310, int r311) {
        return new GnssMeasurementSample(r110, r111, r210, r211, r212, r213, r214, r215, r310, r311);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GnssMeasurementSample) == false) goto L26;
        GnssMeasurementSample r101 = (GnssMeasurementSample) r100;
        if (this.svid == r101.svid) goto L8;
        return false;
    L8:
        if (this.constellationType == r101.constellationType) goto L10;
        return false;
    L10:
        if (Double.compare(this.pseudorangeM, r101.pseudorangeM) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.carrierPhaseCycles, r101.carrierPhaseCycles) == 0) goto L14;
        return false;
    L14:
        if (Double.compare(this.dopplerHz, r101.dopplerHz) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.cn0Dbhz, r101.cn0Dbhz) == 0) goto L18;
        return false;
    L18:
        if (this.gnssTimeNs == r101.gnssTimeNs) goto L20;
        return false;
    L20:
        if (this.systemTimeNs == r101.systemTimeNs) goto L22;
        return false;
    L22:
        if (this.signalSyncState == r101.signalSyncState) goto L24;
        return false;
    L24:
        if (this.adrState == r101.adrState) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r100 = ((this.svid * 31) + this.constellationType) * 31;
        long r101 = Double.doubleToLongBits(this.pseudorangeM);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.carrierPhaseCycles);
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = Double.doubleToLongBits(this.dopplerHz);
        int r106 = (((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + Float.floatToIntBits(this.cn0Dbhz)) * 31;
        long r107 = this.gnssTimeNs;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.systemTimeNs;
        return ((((r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31) + this.signalSyncState) * 31) + this.adrState;
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

    public GnssMeasurementSample(int r100, int r101, double r102, double r103, double r104, float r105, long r110, long r111, int r112, int r113) {
        this.svid = r100;
        this.constellationType = r101;
        this.pseudorangeM = r102;
        this.carrierPhaseCycles = r103;
        this.dopplerHz = r104;
        this.cn0Dbhz = r105;
        this.gnssTimeNs = r110;
        this.systemTimeNs = r111;
        this.signalSyncState = r112;
        this.adrState = r113;
    }
}
