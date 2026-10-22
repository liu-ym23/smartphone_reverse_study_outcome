package org.apache.commons.lang3.time;

import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes42.dex */
class GmtTimeZone extends TimeZone {
    static final long serialVersionUID = 1;
    private final int offset;
    private final String zoneId;

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date r100) {
        return false;
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return false;
    }

    public String toString() {
        return "[GmtTimeZone id=\"" + this.zoneId + "\",offset=" + this.offset + ']';
    }

    @Override // java.util.TimeZone
    public String getID() {
        return this.zoneId;
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.offset;
    }

    public int hashCode() {
        return this.offset;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GmtTimeZone) == true) goto L6;
        return false;
    L6:
        if (this.zoneId != ((GmtTimeZone) r100).zoneId) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int r100) {
        throw new UnsupportedOperationException();
    }

    private static StringBuilder twoDigits(StringBuilder r100, int r101) {
        r100.append((char) ((r101 / 10) + 48));
        r100.append((char) ((r101 % 10) + 48));
        return r100;
    }

    public GmtTimeZone(boolean r100, int r101, int r102) {
        if (r101 >= 24) goto L18;
        if (r102 >= 60) goto L16;
        int r103 = ((r101 * 60) + r102) * 60000;
        if (r100 == false) goto L9;
        r103 = -r103;
    L9:
        this.offset = r103;
        StringBuilder r104 = new StringBuilder(9);
        r104.append("GMT");
        if (r100 == false) goto L12;
        char r105 = '-';
    L13:
        r104.append(r105);
        StringBuilder r106 = twoDigits(r104, r101);
        r106.append(':');
        this.zoneId = twoDigits(r106, r102).toString();
        return;
    L12:
        r105 = '+';
        goto L13
    L16:
        throw new IllegalArgumentException(r102 + " minutes out of range");
    L18:
        throw new IllegalArgumentException(r101 + " hours out of range");
    }

    @Override // java.util.TimeZone
    public int getOffset(int r100, int r101, int r102, int r103, int r104, int r105) {
        return this.offset;
    }
}
