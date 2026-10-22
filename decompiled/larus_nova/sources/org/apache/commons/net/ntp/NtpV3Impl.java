package org.apache.commons.net.ntp;

import java.net.DatagramPacket;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
public class NtpV3Impl implements NtpV3Packet {
    private final byte[] buf;

    /* JADX INFO: renamed from: dp, reason: collision with root package name */
    private volatile DatagramPacket f525014dp;

    public static final int ui(byte r100) {
        return r100 & UByte.MAX_VALUE;
    }

    public static final long ul(byte r100) {
        return r100 & UByte.MAX_VALUE;
    }

    @Override // org.apache.commons.net.ntp.NtpV3Packet
    public synchronized DatagramPacket getDatagramPacket() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f525014dp != null) goto L6;
        byte[] r100 = this.buf;     // Catch: Throwable -> L9
        this.f525014dp = new DatagramPacket(r100, r100.length);     // Catch: Throwable -> L9
        this.f525014dp.setPort(123);     // Catch: Throwable -> L9
    L6:
        DatagramPacket r101 = this.f525014dp;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r101;
    }

    public int getRootDelay() {
        return getInt(4);
    }

    @Override // org.apache.commons.net.ntp.NtpV3Packet
    public String getType() {
        return "NTP";
    }

    private String idAsIPAddress() {
        return ui(this.buf[12]) + "." + ui(this.buf[13]) + "." + ui(this.buf[14]) + "." + ui(this.buf[15]);
    }

    private String idAsString() {
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
    L4:
        if (r101 > 3) goto L10;
        char r102 = (char) this.buf[r101 + 12];
        if (r102 == 0) goto L10;
        r100.append(r102);
        r101 = r101 + 1;
    L10:
        return r100.toString();
    }

    public int getMode() {
        return (ui(this.buf[0]) >> 0) & 7;
    }

    @Override // org.apache.commons.net.ntp.NtpV3Packet
    public TimeStamp getOriginateTimeStamp() {
        return getTimestamp(24);
    }

    public int getPoll() {
        return this.buf[2];
    }

    public int getPrecision() {
        return this.buf[3];
    }

    @Override // org.apache.commons.net.ntp.NtpV3Packet
    public TimeStamp getReceiveTimeStamp() {
        return getTimestamp(32);
    }

    public int getReferenceId() {
        return getInt(12);
    }

    public int getRootDispersion() {
        return getInt(8);
    }

    public int getStratum() {
        return ui(this.buf[1]);
    }

    @Override // org.apache.commons.net.ntp.NtpV3Packet
    public TimeStamp getTransmitTimeStamp() {
        return getTimestamp(40);
    }

    public int getVersion() {
        return (ui(this.buf[0]) >> 3) & 7;
    }

    public int hashCode() {
        return Arrays.hashCode(this.buf);
    }

    public String toString() {
        return "[version:" + getVersion() + ", mode:" + getMode() + ", poll:" + getPoll() + ", precision:" + getPrecision() + ", delay:" + getRootDelay() + ", dispersion(ms):" + getRootDispersionInMillisDouble() + ", id:" + getReferenceIdString() + ", xmitTime:" + getTransmitTimeStamp().toDateString() + " ]";
    }

    public NtpV3Impl() {
        this.buf = new byte[48];
    }

    private String idAsHex() {
        return Integer.toHexString(getReferenceId());
    }

    public String getReferenceIdString() {
        int r100 = getVersion();
        int r101 = getStratum();
        if (r100 == 3) goto L5;
        if (r100 == 4) goto L5;
    L13:
        if (r101 < 2) goto L17;
        return idAsIPAddress();
    L17:
        return idAsHex();
    L5:
        if (r101 == 0) goto L19;
        if (r101 == 1) goto L19;
        if (r100 != 4) goto L13;
        return idAsHex();
    L19:
        return idAsString();
    }

    public double getRootDispersionInMillisDouble() {
        return ((double) getRootDispersion()) / 65.536d;
    }

    private int getInt(int r100) {
        int r101 = ((ui(this.buf[r100]) << 24) | (ui(this.buf[r100 + 1]) << 16)) | (ui(this.buf[r100 + 2]) << 8);
        return ui(this.buf[r100 + 3]) | r101;
    }

    private long getLong(int r100) {
        return (((((((ul(this.buf[r100]) << 56) | (ul(this.buf[r100 + 1]) << 48)) | (ul(this.buf[r100 + 2]) << 40)) | (ul(this.buf[r100 + 3]) << 32)) | (ul(this.buf[r100 + 4]) << 24)) | (ul(this.buf[r100 + 5]) << 16)) | (ul(this.buf[r100 + 6]) << 8)) | ul(this.buf[r100 + 7]);
    }

    private TimeStamp getTimestamp(int r100) {
        return new TimeStamp(getLong(r100));
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Arrays.equals(this.buf, ((NtpV3Impl) r100).buf);
    }

    @Override // org.apache.commons.net.ntp.NtpV3Packet
    public void setMode(int r100) {
        byte[] r101 = this.buf;
        int r102 = r100 & 7;
        r101[0] = (byte) (r102 | (r101[0] & 248));
    }

    @Override // org.apache.commons.net.ntp.NtpV3Packet
    public void setTransmitTime(TimeStamp r100) {
        setTimestamp(40, r100);
    }

    @Override // org.apache.commons.net.ntp.NtpV3Packet
    public void setVersion(int r100) {
        byte[] r101 = this.buf;
        int r102 = (r100 & 7) << 3;
        r101[0] = (byte) (r102 | (r101[0] & 199));
    }

    private void setTimestamp(int r100, TimeStamp r101) {
        if (r101 != null) goto L4;
        long r102 = 0;
    L5:
        int r103 = 7;
    L6:
        if (r103 < 0) goto L8;
        this.buf[r100 + r103] = (byte) (255 & r102);
        r102 = r102 >>> 8;
        r103 = r103 - 1;
        goto L6
    L8:
        return;
    L4:
        r102 = r101.ntpValue();
        goto L5
    }
}
