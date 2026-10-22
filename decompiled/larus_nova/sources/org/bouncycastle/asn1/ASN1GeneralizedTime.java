package org.bouncycastle.asn1;

import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1GeneralizedTime extends ASN1Primitive {
    protected byte[] time;

    public ASN1GeneralizedTime(String r100) {
        this.time = Strings.toByteArray(r100);
        getDate();     // Catch: ParseException -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalArgumentException("invalid date string: " + e.getMessage());
    }

    public ASN1GeneralizedTime(Date r100) {
        SimpleDateFormat r101 = new SimpleDateFormat("yyyyMMddHHmmss'Z'", DateUtil.EN_Locale);
        r101.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(r101.format(r100));
    }

    public ASN1GeneralizedTime(Date r100, Locale r101) {
        SimpleDateFormat r102 = new SimpleDateFormat("yyyyMMddHHmmss'Z'", r101);
        r102.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(r102.format(r100));
    }

    public ASN1GeneralizedTime(byte[] r100) {
        if (r100.length < 4) goto L16;
        this.time = r100;
        if (isDigit(0) == false) goto L14;
        if (isDigit(1) == false) goto L14;
        if (isDigit(2) == false) goto L14;
        if (isDigit(3) == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
    L16:
        throw new IllegalArgumentException("GeneralizedTime string too short");
    }

    private SimpleDateFormat calculateGMTDateFormat() {
        if (hasFractionalSeconds() == false) goto L6;
        SimpleDateFormat r100 = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
    L12:
        r100.setTimeZone(new SimpleTimeZone(0, "Z"));
        return r100;
    L6:
        if (hasSeconds() == false) goto L9;
        r100 = new SimpleDateFormat("yyyyMMddHHmmssz");
        goto L12
    L9:
        if (hasMinutes() == false) goto L11;
        r100 = new SimpleDateFormat("yyyyMMddHHmmz");
        goto L12
    L11:
        r100 = new SimpleDateFormat("yyyyMMddHHz");
        goto L12
    }

    private String calculateGMTOffset(String r110) {
        TimeZone r100 = TimeZone.getDefault();
        int r101 = r100.getRawOffset();
        if (r101 >= 0) goto L5;
        r101 = -r101;
        String r102 = "-";
    L6:
        int r103 = r101 / BaseConstants.Time.HOUR;
        int r104 = (r101 - (((r103 * 60) * 60) * 1000)) / 60000;
        if (r100.useDaylightTime() == false) goto L20;
        if (hasFractionalSeconds() == false) goto L13;
        r110 = pruneFractionalSeconds(r110);     // Catch: ParseException -> L21
    L13:
        if (r100.inDaylightTime(calculateGMTDateFormat().parse(r110 + "GMT" + r102 + convert(r103) + ":" + convert(r104))) == false) goto L20;
        if (r102.equals(Marker.ANY_NON_NULL_MARKER) == false) goto L17;
        int r111 = 1;
    L18:
        r103 = r103 + r111;
        goto L20
    L17:
        r111 = -1;
    L20:
        return "GMT" + r102 + convert(r103) + ":" + convert(r104);
    L5:
        r102 = Marker.ANY_NON_NULL_MARKER;
        goto L6
    }

    private String convert(int r100) {
        if (r100 >= 10) goto L7;
        return "0" + r100;
    L7:
        return Integer.toString(r100);
    }

    public static ASN1GeneralizedTime getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof ASN1GeneralizedTime) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return (ASN1GeneralizedTime) ASN1Primitive.fromByteArray((byte[]) r100);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L14:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (ASN1GeneralizedTime) r100;
    }

    public static ASN1GeneralizedTime getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof ASN1GeneralizedTime) == true) goto L10;
        return new ASN1GeneralizedTime(ASN1OctetString.getInstance(r102).getOctets());
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

    private String pruneFractionalSeconds(String r100) {
        String r101 = r100.substring(14);
        int r102 = 1;
    L4:
        if (r102 >= r101.length()) goto L11;
        char r103 = r101.charAt(r102);
        if ('0' > r103) goto L11;
        if (r103 > '9') goto L11;
        r102 = r102 + 1;
    L11:
        int r104 = r102 - 1;
        if (r104 <= 3) goto L15;
        String r105 = r101.substring(0, 4) + r101.substring(r102);
        StringBuilder r106 = new StringBuilder();
    L14:
        r106.append(r100.substring(0, 14));
        r106.append(r105);
        return r106.toString();
    L15:
        if (r104 != 1) goto L18;
        r105 = r101.substring(0, r102) + CustomAlbumViewModel.DEFAULT_TAB_ID + r101.substring(r102);
        r106 = new StringBuilder();
        goto L14
    L18:
        if (r104 != 2) goto L24;
        r105 = r101.substring(0, r102) + "0" + r101.substring(r102);
        r106 = new StringBuilder();
        goto L14
    L24:
        return r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1GeneralizedTime) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.time, ((ASN1GeneralizedTime) r100).time);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 24, this.time);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int r100 = this.time.length;
        return (StreamUtil.calculateBodyLength(r100) + 1) + r100;
    }

    public Date getDate() throws ParseException {
        String r100 = Strings.fromByteArray(this.time);
        if (r100.endsWith("Z") == false) goto L16;
        if (hasFractionalSeconds() == false) goto L8;
        SimpleDateFormat r101 = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
    L14:
        r101.setTimeZone(new SimpleTimeZone(0, "Z"));
    L34:
        if (hasFractionalSeconds() == false) goto L37;
        r100 = pruneFractionalSeconds(r100);
    L37:
        return DateUtil.epochAdjust(r101.parse(r100));
    L8:
        if (hasSeconds() == false) goto L11;
        r101 = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        goto L14
    L11:
        if (hasMinutes() == false) goto L13;
        r101 = new SimpleDateFormat("yyyyMMddHHmm'Z'");
        goto L14
    L13:
        r101 = new SimpleDateFormat("yyyyMMddHH'Z'");
        goto L14
    L16:
        if (r100.indexOf(45) <= 0) goto L18;
    L32:
        r100 = getTime();
        r101 = calculateGMTDateFormat();
        goto L34
    L18:
        if (r100.indexOf(43) > 0) goto L32;
        if (hasFractionalSeconds() == false) goto L25;
        SimpleDateFormat r102 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
    L23:
        r101 = r102;
        r101.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        goto L34
    L25:
        if (hasSeconds() == false) goto L28;
        r102 = new SimpleDateFormat("yyyyMMddHHmmss");
        goto L23
    L28:
        if (hasMinutes() == false) goto L30;
        r102 = new SimpleDateFormat("yyyyMMddHHmm");
        goto L23
    L30:
        r102 = new SimpleDateFormat("yyyyMMddHH");
        goto L23
    }

    public String getTime() {
        String r100 = Strings.fromByteArray(this.time);
        if (r100.charAt(r100.length() - 1) == 'Z') goto L5;
        int r101 = r100.length() - 6;
        char r102 = r100.charAt(r101);
        if (r102 == '-') goto L10;
        if (r102 == '+') goto L10;
    L12:
        int r103 = r100.length() - 5;
        char r104 = r100.charAt(r103);
        if (r104 == '-') goto L24;
        if (r104 == '+') goto L24;
        int r105 = r100.length() - 3;
        char r106 = r100.charAt(r105);
        if (r106 == '-') goto L23;
        if (r106 == '+') goto L23;
        return r100 + calculateGMTOffset(r100);
    L23:
        return r100.substring(0, r105) + "GMT" + r100.substring(r105) + ":00";
    L24:
        StringBuilder r107 = new StringBuilder();
        r107.append(r100.substring(0, r103));
        r107.append("GMT");
        int r108 = r103 + 3;
        r107.append(r100.substring(r103, r108));
        r107.append(":");
        r107.append(r100.substring(r108));
        return r107.toString();
    L10:
        if (r100.indexOf("GMT") != (r101 - 3)) goto L12;
        return r100;
    L5:
        return r100.substring(0, r100.length() - 1) + "GMT+00:00";
    }

    public String getTimeString() {
        return Strings.fromByteArray(this.time);
    }

    public boolean hasFractionalSeconds() {
        int r100 = 0;
    L3:
        byte[] r101 = this.time;
        if (r100 == r101.length) goto L12;
        if (r101[r100] != 46) goto L11;
        if (r100 != 14) goto L11;
        return true;
    L11:
        r100 = r100 + 1;
        goto L3
    L12:
        return false;
    }

    public boolean hasMinutes() {
        if (isDigit(10) == true) goto L5;
    L7:
        return false;
    L5:
        if (isDigit(11) == false) goto L7;
        return true;
    }

    public boolean hasSeconds() {
        if (isDigit(12) == true) goto L5;
    L7:
        return false;
    L5:
        if (isDigit(13) == false) goto L7;
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERGeneralizedTime(this.time);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DERGeneralizedTime(this.time);
    }
}
