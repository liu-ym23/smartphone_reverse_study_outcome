package org.bouncycastle.asn1;

import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1UTCTime extends ASN1Primitive {
    private byte[] time;

    public ASN1UTCTime(String r100) {
        this.time = Strings.toByteArray(r100);
        getDate();     // Catch: ParseException -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalArgumentException("invalid date string: " + e.getMessage());
    }

    public ASN1UTCTime(Date r100) {
        SimpleDateFormat r101 = new SimpleDateFormat("yyMMddHHmmss'Z'", DateUtil.EN_Locale);
        r101.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(r101.format(r100));
    }

    public ASN1UTCTime(Date r100, Locale r101) {
        SimpleDateFormat r102 = new SimpleDateFormat("yyMMddHHmmss'Z'", r101);
        r102.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(r102.format(r100));
    }

    public ASN1UTCTime(byte[] r100) {
        if (r100.length < 2) goto L12;
        this.time = r100;
        if (isDigit(0) == false) goto L10;
        if (isDigit(1) == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("illegal characters in UTCTime string");
    L12:
        throw new IllegalArgumentException("UTCTime string too short");
    }

    public static ASN1UTCTime getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof ASN1UTCTime) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return (ASN1UTCTime) ASN1Primitive.fromByteArray((byte[]) r100);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L14:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (ASN1UTCTime) r100;
    }

    public static ASN1UTCTime getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof ASN1UTCTime) == true) goto L10;
        return new ASN1UTCTime(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    private boolean isDigit(int r100) {
        byte[] r101 = this.time;
        if (r101.length <= r100) goto L9;
        byte r102 = r101[r100];
        if (r102 < 48) goto L9;
        if (r102 > 57) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1UTCTime) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.time, ((ASN1UTCTime) r100).time);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 23, this.time);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int r100 = this.time.length;
        return (StreamUtil.calculateBodyLength(r100) + 1) + r100;
    }

    public Date getAdjustedDate() throws ParseException {
        SimpleDateFormat r100 = new SimpleDateFormat("yyyyMMddHHmmssz");
        r100.setTimeZone(new SimpleTimeZone(0, "Z"));
        return DateUtil.epochAdjust(r100.parse(getAdjustedTime()));
    }

    public String getAdjustedTime() {
        String r100 = getTime();
        if (r100.charAt(0) >= '5') goto L7;
        String r101 = "20";
    L6:
        return r101.concat(r100);
    L7:
        r101 = Constants.VIA_ACT_TYPE_NINETEEN;
        goto L6
    }

    public Date getDate() throws ParseException {
        return DateUtil.epochAdjust(new SimpleDateFormat("yyMMddHHmmssz").parse(getTime()));
    }

    public String getTime() {
        String r100 = Strings.fromByteArray(this.time);
        if (r100.indexOf(45) < 0) goto L5;
    L12:
        int r101 = r100.indexOf(45);
        if (r101 >= 0) goto L16;
        r101 = r100.indexOf(43);
    L16:
        if (r101 != (r100.length() - 3)) goto L19;
        r100 = r100.concat(CustomAlbumViewModel.DEFAULT_TAB_ID);
    L19:
        if (r101 != 10) goto L21;
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.substring(0, 10));
        r102.append("00GMT");
        r102.append(r100.substring(10, 13));
        r102.append(":");
        String r103 = r100.substring(13, 15);
    L9:
        r102.append(r103);
        return r102.toString();
    L21:
        r102 = new StringBuilder();
        r102.append(r100.substring(0, 12));
        r102.append("GMT");
        r102.append(r100.substring(12, 15));
        r102.append(":");
        r103 = r100.substring(15, 17);
        goto L9
    L5:
        if (r100.indexOf(43) >= 0) goto L12;
        if (r100.length() != 11) goto L11;
        r102 = new StringBuilder();
        r102.append(r100.substring(0, 10));
        r103 = "00GMT+00:00";
        goto L9
    L11:
        r102 = new StringBuilder();
        r102.append(r100.substring(0, 12));
        r103 = "GMT+00:00";
        goto L9
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return Strings.fromByteArray(this.time);
    }
}
