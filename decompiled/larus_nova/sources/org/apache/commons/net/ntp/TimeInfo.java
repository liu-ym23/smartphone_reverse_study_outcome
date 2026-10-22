package org.apache.commons.net.ntp;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public class TimeInfo {
    private List<String> _comments;
    private Long _delay;
    private boolean _detailsComputed;
    private final NtpV3Packet _message;
    private Long _offset;
    private final long _returnTime;

    public void computeDetails() {
        if (this._detailsComputed == false) goto L5;
        return;
    L5:
        this._detailsComputed = true;
        if (this._comments != null) goto L8;
        this._comments = new ArrayList();
    L8:
        TimeStamp r100 = this._message.getOriginateTimeStamp();
        long r101 = r100.getTime();
        TimeStamp r102 = this._message.getReceiveTimeStamp();
        long r103 = r102.getTime();
        TimeStamp r104 = this._message.getTransmitTimeStamp();
        long r105 = r104.getTime();
        long r110 = 0;
        if (r100.ntpValue() != 0) goto L15;
        if (r104.ntpValue() == 0) goto L13;
        this._offset = Long.valueOf(r105 - this._returnTime);
        this._comments.add("Error: zero orig time -- cannot compute delay");
        return;
    L13:
        this._comments.add("Error: zero orig time -- cannot compute delay/offset");
        return;
    L15:
        if (r102.ntpValue() != 0) goto L17;
    L36:
        this._comments.add("Warning: zero rcvNtpTime or xmitNtpTime");
        long r111 = this._returnTime;
        if (r101 <= r111) goto L39;
        this._comments.add("Error: OrigTime > DestRcvTime");
    L41:
        if (r102.ntpValue() == 0) goto L44;
        this._offset = Long.valueOf(r103 - r101);
        return;
    L44:
        if (r104.ntpValue() == 0) goto L51;
        this._offset = Long.valueOf(r105 - this._returnTime);
        return;
    L51:
        return;
    L39:
        this._delay = Long.valueOf(r111 - r101);
        goto L41
    L17:
        if (r104.ntpValue() == 0) goto L36;
        long r112 = this._returnTime - r101;
        if (r105 >= r103) goto L22;
        this._comments.add("Error: xmitTime < rcvTime");
    L31:
        r110 = r112;
    L32:
        this._delay = Long.valueOf(r110);
        if (r101 <= this._returnTime) goto L35;
        this._comments.add("Error: OrigTime > DestRcvTime");
    L35:
        this._offset = Long.valueOf(((r103 - r101) + (r105 - this._returnTime)) / 2);
        return;
    L22:
        long r113 = r105 - r103;
        if (r113 > r112) goto L26;
        r110 = r112 - r113;
        goto L32
    L26:
        if ((r113 - r112) == 1) goto L28;
        this._comments.add("Warning: processing time > total network time");
        goto L31
    L28:
        if (r112 == 0) goto L31;
        this._comments.add("Info: processing time > total network time by 1 ms -> assume zero delay");
        goto L32
    }

    public int hashCode() {
        return (((int) this._returnTime) * 31) + this._message.hashCode();
    }

    public NtpV3Packet getMessage() {
        return this._message;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        TimeInfo r101 = (TimeInfo) r100;
        if (this._returnTime == r101._returnTime) goto L13;
    L15:
        return false;
    L13:
        if (this._message.equals(r101._message) == false) goto L15;
        return true;
    }

    public TimeInfo(NtpV3Packet r100, long r101, boolean r110) {
        this(r100, r101, null, r110);
    }

    public TimeInfo(NtpV3Packet r100, long r101, List<String> r102, boolean r103) {
        if (r100 == null) goto L9;
        this._returnTime = r101;
        this._message = r100;
        this._comments = r102;
        if (r103 == false) goto L10;
        computeDetails();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("message cannot be null");
    }
}
