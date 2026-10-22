package org.apache.commons.net.ntp;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.dora.impl.ota.g2.j0;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes42.dex */
public class TimeStamp implements Serializable, Comparable<TimeStamp> {
    public static final String NTP_DATE_FORMAT = "EEE, MMM dd yyyy HH:mm:ss.SSS";
    protected static final long msb0baseTime = 2085978496000L;
    protected static final long msb1baseTime = -2208988800000L;
    private static final long serialVersionUID = 8139806907588338737L;
    private final long ntpTime;
    private DateFormat simpleFormatter;
    private DateFormat utcFormatter;

    public Date getDate() {
        return new Date(getTime(this.ntpTime));
    }

    public long getFraction() {
        return this.ntpTime & BodyPartID.bodyIdMax;
    }

    public long getSeconds() {
        return (this.ntpTime >>> 32) & BodyPartID.bodyIdMax;
    }

    public long getTime() {
        return getTime(this.ntpTime);
    }

    public int hashCode() {
        long r100 = this.ntpTime;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public String toDateString() {
        if (this.simpleFormatter != null) goto L5;
        SimpleDateFormat r100 = new SimpleDateFormat(NTP_DATE_FORMAT, Locale.US);
        this.simpleFormatter = r100;
        r100.setTimeZone(TimeZone.getDefault());
    L5:
        Date r101 = getDate();
        return this.simpleFormatter.format(r101);
    }

    public String toString() {
        return toString(this.ntpTime);
    }

    public String toUTCString() {
        if (this.utcFormatter != null) goto L5;
        SimpleDateFormat r100 = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss.SSS 'UTC'", Locale.US);
        this.utcFormatter = r100;
        r100.setTimeZone(TimeZone.getTimeZone("UTC"));
    L5:
        Date r101 = getDate();
        return this.utcFormatter.format(r101);
    }

    public static TimeStamp getCurrentTime() {
        return getNtpTime(System.currentTimeMillis());
    }

    public long ntpValue() {
        return this.ntpTime;
    }

    public TimeStamp(Date r100) {
        if (r100 != null) goto L5;
        long r101 = 0;
    L6:
        this.ntpTime = r101;
        return;
    L5:
        r101 = toNtpTime(r100.getTime());
        goto L6
    }

    public static long decodeNtpHexString(String r100) throws NumberFormatException {
        if (r100 == null) goto L14;
        int r101 = r100.indexOf(46);
        if (r101 != (-1)) goto L12;
        if (r100.length() != 0) goto L10;
        return 0;
    L10:
        return CastLongProtector.parseLong(r100, 16) << 32;
    L12:
        return (CastLongProtector.parseLong(r100.substring(0, r101), 16) << 32) | CastLongProtector.parseLong(r100.substring(r101 + 1), 16);
    L14:
        throw new NumberFormatException("null");
    }

    public static TimeStamp getNtpTime(long r100) {
        return new TimeStamp(toNtpTime(r100));
    }

    public static long getTime(long r100) {
        long r101 = (r100 >>> 32) & BodyPartID.bodyIdMax;
        long r102 = Math.round(((r100 & BodyPartID.bodyIdMax) * 1000.0d) / 4.294967296E9d);
        if ((j0.G2_OTA_SPACE_RESERVE_BYTES & r101) != 0) goto L7;
        long r103 = msb0baseTime;
    L6:
        return ((r101 * 1000) + r103) + r102;
    L7:
        r103 = msb1baseTime;
        goto L6
    }

    public static TimeStamp parseNtpString(String r100) throws NumberFormatException {
        return new TimeStamp(decodeNtpHexString(r100));
    }

    public static long toNtpTime(long r100) {
        long r101 = msb0baseTime;
        if (r100 >= msb0baseTime) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r101 = msb1baseTime;
    L8:
        long r103 = r100 - r101;
        long r104 = r103 / 1000;
        long r105 = ((r103 % 1000) * 4294967296L) / 1000;
        if (r102 == false) goto L12;
        r104 = r104 | j0.G2_OTA_SPACE_RESERVE_BYTES;
    L12:
        return r105 | (r104 << 32);
    L5:
        r102 = false;
        goto L6
    }

    public static String toString(long r100) {
        StringBuilder r101 = new StringBuilder();
        appendHexString(r101, (r100 >>> 32) & BodyPartID.bodyIdMax);
        r101.append('.');
        appendHexString(r101, r100 & BodyPartID.bodyIdMax);
        return r101.toString();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(TimeStamp r100) {
        long r101 = this.ntpTime;
        long r102 = r100.ntpTime;
        if (r101 >= r102) goto L5;
        return -1;
    L5:
        if (r101 != r102) goto L7;
        return 0;
    L7:
        return 1;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof TimeStamp) == true) goto L5;
        return false;
    L5:
        if (this.ntpTime != ((TimeStamp) r100).ntpValue()) goto L9;
        return true;
    L9:
        return false;
    }

    public TimeStamp(String r100) throws NumberFormatException {
        this.ntpTime = decodeNtpHexString(r100);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(TimeStamp r100) {
        return compareTo2(r100);
    }

    public TimeStamp(long r100) {
        this.ntpTime = r100;
    }

    private static void appendHexString(StringBuilder r100, long r101) {
        String r102 = Long.toHexString(r101);
        int r103 = r102.length();
    L4:
        if (r103 >= 8) goto L6;
        r100.append('0');
        r103 = r103 + 1;
        goto L4
    L6:
        r100.append(r102);
    }
}
