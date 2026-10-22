package org.bouncycastle.asn1.eac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import kotlin.UByte;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class PackedDate {
    private byte[] time;

    public PackedDate(String r100) {
        this.time = convert(r100);
    }

    public PackedDate(Date r100) {
        SimpleDateFormat r101 = new SimpleDateFormat("yyMMdd'Z'");
        r101.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = convert(r101.format(r100));
    }

    public PackedDate(Date r100, Locale r101) {
        SimpleDateFormat r102 = new SimpleDateFormat("yyMMdd'Z'", r101);
        r102.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = convert(r102.format(r100));
    }

    public PackedDate(byte[] r100) {
        this.time = r100;
    }

    private byte[] convert(String r100) {
        char[] r101 = r100.toCharArray();
        byte[] r102 = new byte[6];
        int r103 = 0;
    L3:
        if (r103 == 6) goto L5;
        r102[r103] = (byte) (r101[r103] - '0');
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof PackedDate) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.time, ((PackedDate) r100).time);
    }

    public Date getDate() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20" + toString());
    }

    public byte[] getEncoding() {
        return Arrays.clone(this.time);
    }

    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    public String toString() {
        int r100 = this.time.length;
        char[] r101 = new char[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L6;
        r101[r102] = (char) ((this.time[r102] & UByte.MAX_VALUE) + 48);
        r102 = r102 + 1;
        goto L3
    L6:
        return new String(r101);
    }
}
