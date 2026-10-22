package org.bouncycastle.asn1.x509;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERUTCTime;

/* JADX INFO: loaded from: classes42.dex */
public class Time extends ASN1Object implements ASN1Choice {
    ASN1Primitive time;

    public Time(Date r100) {
        SimpleTimeZone r101 = new SimpleTimeZone(0, "Z");
        SimpleDateFormat r102 = new SimpleDateFormat("yyyyMMddHHmmss");
        r102.setTimeZone(r101);
        String r103 = r102.format(r100) + "Z";
        int r104 = CastIntegerProtector.parseInt(r103.substring(0, 4));
        if (r104 >= 1950) goto L5;
    L8:
        ASN1Primitive r105 = new DERGeneralizedTime(r103);
    L9:
        this.time = r105;
        return;
    L5:
        if (r104 > 2049) goto L8;
        r105 = new DERUTCTime(r103.substring(2));
        goto L9
    }

    public Time(Date r100, Locale r101) {
        SimpleTimeZone r102 = new SimpleTimeZone(0, "Z");
        SimpleDateFormat r103 = new SimpleDateFormat("yyyyMMddHHmmss", r101);
        r103.setTimeZone(r102);
        String r104 = r103.format(r100) + "Z";
        int r105 = CastIntegerProtector.parseInt(r104.substring(0, 4));
        if (r105 >= 1950) goto L5;
    L8:
        ASN1Primitive r106 = new DERGeneralizedTime(r104);
    L9:
        this.time = r106;
        return;
    L5:
        if (r105 > 2049) goto L8;
        r106 = new DERUTCTime(r104.substring(2));
        goto L9
    }

    public Time(ASN1Primitive r100) {
        if ((r100 instanceof ASN1UTCTime) == false) goto L5;
    L9:
        this.time = r100;
        return;
    L5:
        if ((r100 instanceof ASN1GeneralizedTime) == true) goto L9;
        throw new IllegalArgumentException("unknown object passed to Time");
    }

    public static Time getInstance(Object r100) {
        if (r100 == null) goto L17;
        if ((r100 instanceof Time) == true) goto L17;
        if ((r100 instanceof ASN1UTCTime) == false) goto L11;
        return new Time((ASN1UTCTime) r100);
    L11:
        if ((r100 instanceof ASN1GeneralizedTime) == false) goto L15;
        return new Time((ASN1GeneralizedTime) r100);
    L15:
        throw new IllegalArgumentException("unknown object in factory: ".concat(r100.getClass().getName()));
    L17:
        return (Time) r100;
    }

    public static Time getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(r100.getObject());
    }

    public Date getDate() {
        ASN1Primitive r100 = this.time;     // Catch: ParseException -> L8
        if ((r100 instanceof ASN1UTCTime) == false) goto L7;
        return ((ASN1UTCTime) r100).getAdjustedDate();
    L7:
        return ((ASN1GeneralizedTime) r100).getDate();
    L8:
        e = move-exception;
        throw new IllegalStateException("invalid date string: " + e.getMessage());
    }

    public String getTime() {
        ASN1Primitive r100 = this.time;
        if ((r100 instanceof ASN1UTCTime) == false) goto L7;
        return ((ASN1UTCTime) r100).getAdjustedTime();
    L7:
        return ((ASN1GeneralizedTime) r100).getTime();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.time;
    }

    public String toString() {
        return getTime();
    }
}
