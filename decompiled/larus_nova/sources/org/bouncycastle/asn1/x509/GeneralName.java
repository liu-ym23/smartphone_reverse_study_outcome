package org.bouncycastle.asn1.x509;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.StringTokenizer;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.IPAddress;

/* JADX INFO: loaded from: classes42.dex */
public class GeneralName extends ASN1Object implements ASN1Choice {
    public static final int dNSName = 2;
    public static final int directoryName = 4;
    public static final int ediPartyName = 5;
    public static final int iPAddress = 7;
    public static final int otherName = 0;
    public static final int registeredID = 8;
    public static final int rfc822Name = 1;
    public static final int uniformResourceIdentifier = 6;
    public static final int x400Address = 3;
    private ASN1Encodable obj;
    private int tag;

    public GeneralName(int r100, String r101) {
        this.tag = r100;
        if (r100 != 1) goto L5;
    L24:
        ASN1Encodable r102 = new DERIA5String(r101);
    L25:
        this.obj = r102;
        return;
    L5:
        if (r100 == 2) goto L24;
        if (r100 == 6) goto L24;
        if (r100 != 8) goto L13;
        r102 = new ASN1ObjectIdentifier(r101);
        goto L25
    L13:
        if (r100 != 4) goto L16;
        r102 = new X500Name(r101);
        goto L25
    L16:
        if (r100 != 7) goto L23;
        byte[] r103 = toGeneralNameEncoding(r101);
        if (r103 == null) goto L21;
        this.obj = new DEROctetString(r103);
        return;
    L21:
        throw new IllegalArgumentException("IP Address is invalid");
    L23:
        throw new IllegalArgumentException("can't process String for tag: " + r100);
    }

    public GeneralName(int r100, ASN1Encodable r101) {
        this.obj = r101;
        this.tag = r100;
    }

    public GeneralName(X500Name r100) {
        this.obj = r100;
        this.tag = 4;
    }

    public GeneralName(X509Name r100) {
        this.obj = X500Name.getInstance(r100);
        this.tag = 4;
    }

    private void copyInts(int[] r100, byte[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 == r100.length) goto L6;
        int r104 = r103 * 2;
        int r105 = r100[r103];
        r101[r104 + r102] = (byte) (r105 >> 8);
        r101[(r104 + 1) + r102] = (byte) r105;
        r103 = r103 + 1;
        goto L4
    }

    public static GeneralName getInstance(Object r100) {
        if (r100 == null) goto L31;
        if ((r100 instanceof GeneralName) == true) goto L31;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L23;
        ASN1TaggedObject r101 = (ASN1TaggedObject) r100;
        int r102 = r101.getTagNo();
        switch(r102) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L19;
            case 3: goto L21;
            case 4: goto L17;
            case 5: goto L21;
            case 6: goto L19;
            case 7: goto L15;
            case 8: goto L13;
            default: goto L11;
        };
    L11:
        throw new IllegalArgumentException("unknown tag: " + r102);
    L13:
        return new GeneralName(r102, ASN1ObjectIdentifier.getInstance(r101, false));
    L15:
        return new GeneralName(r102, ASN1OctetString.getInstance(r101, false));
    L17:
        return new GeneralName(r102, X500Name.getInstance(r101, true));
    L19:
        return new GeneralName(r102, DERIA5String.getInstance(r101, false));
    L21:
        return new GeneralName(r102, ASN1Sequence.getInstance(r101, false));
    L23:
        if ((r100 instanceof byte[]) == false) goto L29;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L27:
        throw new IllegalArgumentException("unable to parse encoded general name");
    L29:
        throw new IllegalArgumentException("unknown object in getInstance: ".concat(r100.getClass().getName()));
    L31:
        return (GeneralName) r100;
    }

    public static GeneralName getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1TaggedObject.getInstance(r100, true));
    }

    private void parseIPv4(String r100, byte[] r101, int r102) {
        StringTokenizer r103 = new StringTokenizer(r100, "./");
        int r104 = 0;
    L4:
        if (r103.hasMoreTokens() == false) goto L6;
        int r105 = r104 + 1;
        r101[r104 + r102] = (byte) CastIntegerProtector.parseInt(r103.nextToken());
        r104 = r105;
        goto L4
    }

    private void parseIPv4Mask(String r100, byte[] r101, int r102) {
        int r103 = CastIntegerProtector.parseInt(r100);
        int r104 = 0;
    L3:
        if (r104 == r103) goto L5;
        int r105 = (r104 / 8) + r102;
        r101[r105] = (byte) (r101[r105] | (1 << (7 - (r104 % 8))));
        r104 = r104 + 1;
        goto L3
    }

    private int[] parseIPv6(String r110) {
        StringTokenizer r100 = new StringTokenizer(r110, ":", true);
        int[] r101 = new int[8];
        if (r110.charAt(0) == ':') goto L5;
    L7:
        int r111 = -1;
        int r102 = 0;
    L9:
        if (r100.hasMoreTokens() == false) goto L20;
        String r103 = r100.nextToken();
        if (r103.equals(":") == true) goto L12;
        if (r103.indexOf(46) < 0) goto L15;
        StringTokenizer r104 = new StringTokenizer(r103, ".");
        int r105 = r102 + 1;
        r101[r102] = (CastIntegerProtector.parseInt(r104.nextToken()) << 8) | CastIntegerProtector.parseInt(r104.nextToken());
        r102 = r105 + 1;
        int r106 = CastIntegerProtector.parseInt(r104.nextToken()) << 8;
        r101[r105] = CastIntegerProtector.parseInt(r104.nextToken()) | r106;
        goto L9
    L15:
        int r107 = r102 + 1;
        r101[r102] = CastIntegerProtector.parseInt(r103, 16);
        if (r100.hasMoreTokens() == false) goto L18;
        r100.nextToken();
    L18:
        r102 = r107;
        goto L9
    L12:
        r101[r102] = 0;
        int r112 = r102;
        r102 = r102 + 1;
        r111 = r112;
        goto L9
    L20:
        if (r102 == 8) goto L24;
        int r108 = r102 - r111;
        int r109 = 8 - r108;
        System.arraycopy(r101, r111, r101, r109, r108);
    L22:
        if (r111 == r109) goto L24;
        r101[r111] = 0;
        r111 = r111 + 1;
    L24:
        return r101;
    L5:
        if (r110.charAt(1) != ':') goto L7;
        r100.nextToken();
        goto L7
    }

    private int[] parseMask(String r100) {
        int[] r101 = new int[8];
        int r102 = CastIntegerProtector.parseInt(r100);
        int r103 = 0;
    L3:
        if (r103 == r102) goto L5;
        int r104 = r103 / 16;
        r101[r104] = r101[r104] | (1 << (15 - (r103 % 16)));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    private byte[] toGeneralNameEncoding(String r100) {
        if (IPAddress.isValidIPv6WithNetmask(r100) == false) goto L5;
    L23:
        int r101 = r100.indexOf(47);
        if (r101 >= 0) goto L27;
        byte[] r102 = new byte[16];
        copyInts(parseIPv6(r100), r102, 0);
        return r102;
    L27:
        byte[] r103 = new byte[32];
        copyInts(parseIPv6(r100.substring(0, r101)), r103, 0);
        String r104 = r100.substring(r101 + 1);
        if (r104.indexOf(58) <= 0) goto L30;
        int[] r105 = parseIPv6(r104);
    L31:
        copyInts(r105, r103, 16);
        return r103;
    L30:
        r105 = parseMask(r104);
        goto L31
    L5:
        if (IPAddress.isValidIPv6(r100) == true) goto L23;
        if (IPAddress.isValidIPv4WithNetmask(r100) == false) goto L10;
    L14:
        int r106 = r100.indexOf(47);
        if (r106 >= 0) goto L18;
        byte[] r107 = new byte[4];
        parseIPv4(r100, r107, 0);
        return r107;
    L18:
        byte[] r108 = new byte[8];
        parseIPv4(r100.substring(0, r106), r108, 0);
        String r109 = r100.substring(r106 + 1);
        if (r109.indexOf(46) <= 0) goto L21;
        parseIPv4(r109, r108, 4);
    L22:
        return r108;
    L21:
        parseIPv4Mask(r109, r108, 4);
        goto L22
    L10:
        if (IPAddress.isValidIPv4(r100) == true) goto L14;
        return null;
    }

    public ASN1Encodable getName() {
        return this.obj;
    }

    public int getTagNo() {
        return this.tag;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        int r100 = this.tag;
        if (r100 != 4) goto L5;
        boolean r101 = true;
    L7:
        return new DERTaggedObject(r101, r100, this.obj);
    L5:
        r101 = false;
        goto L7
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer();
        r100.append(this.tag);
        r100.append(": ");
        int r101 = this.tag;
        if (r101 != 1) goto L5;
    L12:
        String r102 = DERIA5String.getInstance(this.obj).getString();
    L13:
        r100.append(r102);
        return r100.toString();
    L5:
        if (r101 == 2) goto L12;
        if (r101 != 4) goto L9;
        r102 = X500Name.getInstance(this.obj).toString();
        goto L13
    L9:
        if (r101 == 6) goto L12;
        r102 = this.obj.toString();
        goto L13
    }
}
