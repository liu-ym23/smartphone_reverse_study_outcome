package org.bouncycastle.asn1.util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1External;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.BERApplicationSpecific;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERGraphicString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERT61String;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERVideotexString;
import org.bouncycastle.asn1.DERVisibleString;
import org.bouncycastle.asn1.DLApplicationSpecific;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;
import tb2.c;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1Dump {
    private static final int SAMPLE_SIZE = 32;
    private static final String TAB = "    ";

    public ASN1Dump() {
    }

    public static void _dumpAsString(String r100, boolean r101, ASN1Primitive r102, StringBuffer r103) {
        String r104 = Strings.lineSeparator();
        if ((r102 instanceof ASN1Sequence) == false) goto L27;
        Enumeration r105 = ((ASN1Sequence) r102).getObjects();
        String r106 = r100 + "    ";
        r103.append(r100);
        if ((r102 instanceof BERSequence) == false) goto L9;
        String r107 = "BER Sequence";
    L7:
        r103.append(r107);
    L12:
        r103.append(r104);
    L14:
        if (r105.hasMoreElements() == false) goto L161;
        Object r108 = r105.nextElement();
        if (r108 == null) goto L25;
        if (r108.equals(DERNull.INSTANCE) == true) goto L25;
        if ((r108 instanceof ASN1Primitive) == false) goto L23;
        ASN1Primitive r109 = (ASN1Primitive) r108;
    L24:
        _dumpAsString(r106, r101, r109, r103);
        goto L14
    L23:
        r109 = ((ASN1Encodable) r108).toASN1Primitive();
    L25:
        r103.append(r106);
        r103.append("NULL");
        goto L12
    L161:
        return;
    L9:
        if ((r102 instanceof DERSequence) == false) goto L11;
        r107 = "DER Sequence";
        goto L7
    L11:
        r107 = "Sequence";
        goto L7
    L27:
        if ((r102 instanceof ASN1TaggedObject) == false) goto L37;
        String r110 = r100 + "    ";
        r103.append(r100);
        if ((r102 instanceof BERTaggedObject) == false) goto L31;
        String r111 = "BER Tagged [";
    L32:
        r103.append(r111);
        ASN1TaggedObject r112 = (ASN1TaggedObject) r102;
        r103.append(Integer.toString(r112.getTagNo()));
        r103.append(']');
        if (r112.isExplicit() == true) goto L35;
        r103.append(" IMPLICIT ");
    L35:
        r103.append(r104);
        _dumpAsString(r110, r101, r112.getObject(), r103);
        return;
    L31:
        r111 = "Tagged [";
        goto L32
    L37:
        if ((r102 instanceof ASN1Set) == false) goto L58;
        Enumeration r113 = ((ASN1Set) r102).getObjects();
        String r114 = r100 + "    ";
        r103.append(r100);
        if ((r102 instanceof BERSet) == false) goto L43;
        String r115 = "BER Set";
    L41:
        r103.append(r115);
    L46:
        r103.append(r104);
    L48:
        if (r113.hasMoreElements() == false) goto L162;
        Object r116 = r113.nextElement();
        if (r116 == null) goto L51;
        if ((r116 instanceof ASN1Primitive) == false) goto L55;
        ASN1Primitive r117 = (ASN1Primitive) r116;
    L56:
        _dumpAsString(r114, r101, r117, r103);
        goto L48
    L55:
        r117 = ((ASN1Encodable) r116).toASN1Primitive();
        goto L56
    L51:
        r103.append(r114);
        r103.append("NULL");
        goto L46
    L162:
        return;
    L43:
        if ((r102 instanceof DERSet) == false) goto L45;
        r115 = "DER Set";
        goto L41
    L45:
        r115 = "Set";
        goto L41
    L58:
        if ((r102 instanceof ASN1OctetString) == false) goto L68;
        ASN1OctetString r118 = (ASN1OctetString) r102;
        if ((r102 instanceof BEROctetString) == false) goto L62;
        StringBuilder r119 = new StringBuilder();
        r119.append(r100);
        r119.append("BER Constructed Octet String[");
        int r120 = r118.getOctets().length;
    L63:
        r119.append(r120);
        r119.append("] ");
        r103.append(r119.toString());
        if (r101 == false) goto L66;
        String r121 = dumpBinaryDataAsString(r100, r118.getOctets());
    L72:
        r103.append(r121);
        return;
    L66:
        r103.append(r104);
        return;
    L62:
        r119 = new StringBuilder();
        r119.append(r100);
        r119.append("DER Octet String[");
        r120 = r118.getOctets().length;
        goto L63
    L68:
        if ((r102 instanceof ASN1ObjectIdentifier) == false) goto L74;
        StringBuilder r122 = new StringBuilder();
        r122.append(r100);
        r122.append("ObjectIdentifier(");
        r122.append(((ASN1ObjectIdentifier) r102).getId());
    L70:
        r122.append(")");
    L71:
        r122.append(r104);
        r121 = r122.toString();
        goto L72
    L74:
        if ((r102 instanceof ASN1Boolean) == false) goto L77;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("Boolean(");
        r122.append(((ASN1Boolean) r102).isTrue());
        goto L70
    L77:
        if ((r102 instanceof ASN1Integer) == false) goto L81;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("Integer(");
        BigInteger r123 = ((ASN1Integer) r102).getValue();
    L79:
        r122.append(r123);
        goto L70
    L81:
        if ((r102 instanceof DERBitString) == false) goto L86;
        DERBitString r124 = (DERBitString) r102;
        r103.append(r100 + "DER Bit String[" + r124.getBytes().length + ", " + r124.getPadBits() + "] ");
        if (r101 == false) goto L66;
        r121 = dumpBinaryDataAsString(r100, r124.getBytes());
        goto L72
    L86:
        if ((r102 instanceof DERIA5String) == false) goto L90;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("IA5String(");
        String r125 = ((DERIA5String) r102).getString();
    L88:
        r122.append(r125);
        r122.append(") ");
        goto L71
    L90:
        if ((r102 instanceof DERUTF8String) == false) goto L93;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("UTF8String(");
        r125 = ((DERUTF8String) r102).getString();
        goto L88
    L93:
        if ((r102 instanceof DERPrintableString) == false) goto L96;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("PrintableString(");
        r125 = ((DERPrintableString) r102).getString();
        goto L88
    L96:
        if ((r102 instanceof DERVisibleString) == false) goto L99;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("VisibleString(");
        r125 = ((DERVisibleString) r102).getString();
        goto L88
    L99:
        if ((r102 instanceof DERBMPString) == false) goto L102;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("BMPString(");
        r125 = ((DERBMPString) r102).getString();
        goto L88
    L102:
        if ((r102 instanceof DERT61String) == false) goto L105;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("T61String(");
        r125 = ((DERT61String) r102).getString();
        goto L88
    L105:
        if ((r102 instanceof DERGraphicString) == false) goto L108;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("GraphicString(");
        r125 = ((DERGraphicString) r102).getString();
        goto L88
    L108:
        if ((r102 instanceof DERVideotexString) == false) goto L111;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("VideotexString(");
        r125 = ((DERVideotexString) r102).getString();
        goto L88
    L111:
        if ((r102 instanceof ASN1UTCTime) == false) goto L114;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("UTCTime(");
        r125 = ((ASN1UTCTime) r102).getTime();
        goto L88
    L114:
        if ((r102 instanceof ASN1GeneralizedTime) == false) goto L117;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("GeneralizedTime(");
        r125 = ((ASN1GeneralizedTime) r102).getTime();
        goto L88
    L117:
        if ((r102 instanceof BERApplicationSpecific) == false) goto L121;
        String r126 = ASN1Encoding.BER;
    L119:
        r121 = outputApplicationSpecific(r126, r100, r101, r102, r104);
        goto L72
    L121:
        if ((r102 instanceof DERApplicationSpecific) == false) goto L124;
        r126 = ASN1Encoding.DER;
        goto L119
    L124:
        if ((r102 instanceof DLApplicationSpecific) == false) goto L127;
        r126 = "";
        goto L119
    L127:
        if ((r102 instanceof ASN1Enumerated) == false) goto L130;
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append("DER Enumerated(");
        r123 = ((ASN1Enumerated) r102).getValue();
        goto L79
    L130:
        if ((r102 instanceof ASN1External) == false) goto L143;
        ASN1External r127 = (ASN1External) r102;
        r103.append(r100 + "External " + r104);
        StringBuilder r128 = new StringBuilder();
        r128.append(r100);
        r128.append("    ");
        String r129 = r128.toString();
        if (r127.getDirectReference() == null) goto L135;
        r103.append(r129 + "Direct Reference: " + r127.getDirectReference().getId() + r104);
    L135:
        if (r127.getIndirectReference() == null) goto L138;
        r103.append(r129 + "Indirect Reference: " + r127.getIndirectReference().toString() + r104);
    L138:
        if (r127.getDataValueDescriptor() == null) goto L140;
        _dumpAsString(r129, r101, r127.getDataValueDescriptor(), r103);
    L140:
        r103.append(r129 + "Encoding: " + r127.getEncoding() + r104);
        _dumpAsString(r129, r101, r127.getExternalContent(), r103);     // Catch: Throwable -> L145
        return;
    L145:
        th = move-exception;
        throw th;
    L143:
        r122 = new StringBuilder();
        r122.append(r100);
        r122.append(r102.toString());
        goto L71
    }

    private static String calculateAscString(byte[] r100, int r101, int r102) {
        StringBuffer r103 = new StringBuffer();
        int r104 = r101;
    L4:
        if (r104 == (r101 + r102)) goto L12;
        byte r105 = r100[r104];
        if (r105 < 32) goto L10;
        if (r105 > 126) goto L10;
        r103.append((char) r105);
    L10:
        r104 = r104 + 1;
        goto L4
    L12:
        return r103.toString();
    }

    public static String dumpAsString(Object r100) {
        return dumpAsString(r100, false);
    }

    public static String dumpAsString(Object r100, boolean r101) {
        StringBuffer r102 = new StringBuffer();
        if ((r100 instanceof ASN1Primitive) == false) goto L7;
        ASN1Primitive r103 = (ASN1Primitive) r100;
    L5:
        _dumpAsString("", r101, r103, r102);
        return r102.toString();
    L7:
        if ((r100 instanceof ASN1Encodable) == false) goto L12;
        r103 = ((ASN1Encodable) r100).toASN1Primitive();
        goto L5
    L12:
        return "unknown object type " + r100.toString();
    }

    private static String dumpBinaryDataAsString(String r100, byte[] r101) {
        String r102 = Strings.lineSeparator();
        StringBuffer r103 = new StringBuffer();
        String r104 = r100 + "    ";
        r103.append(r102);
        int r105 = 0;
    L4:
        if (r105 >= r101.length) goto L15;
        int r106 = r101.length - r105;
        r103.append(r104);
        if (r106 <= 32) goto L9;
        r103.append(Strings.fromByteArray(Hex.encode(r101, r105, 32)));
        r103.append("    ");
        String r107 = calculateAscString(r101, r105, 32);
    L8:
        r103.append(r107);
        r103.append(r102);
        r105 = r105 + 32;
        goto L4
    L9:
        r103.append(Strings.fromByteArray(Hex.encode(r101, r105, r101.length - r105)));
        int r108 = r101.length - r105;
    L10:
        if (r108 == 32) goto L12;
        r103.append(c.DEFAULT_TEXT);
        r108 = r108 + 1;
        goto L10
    L12:
        r103.append("    ");
        r107 = calculateAscString(r101, r105, r101.length - r105);
        goto L8
    L15:
        return r103.toString();
    }

    private static String outputApplicationSpecific(String r100, String r101, boolean r102, ASN1Primitive r103, String r104) {
        ASN1ApplicationSpecific r105 = ASN1ApplicationSpecific.getInstance(r103);
        StringBuffer r106 = new StringBuffer();
        if (r105.isConstructed() == false) goto L15;
        ASN1Sequence r107 = ASN1Sequence.getInstance(r105.getObject(16));     // Catch: IOException -> L10
        r106.append(r101 + r100 + " ApplicationSpecific[" + r105.getApplicationTag() + "]" + r104);     // Catch: IOException -> L10
        Enumeration r108 = r107.getObjects();     // Catch: IOException -> L10
    L7:
        if (r108.hasMoreElements() == false) goto L13;
        _dumpAsString(r101 + "    ", r102, (ASN1Primitive) r108.nextElement(), r106);     // Catch: IOException -> L10
    L13:
        return r106.toString();
    L10:
        e = move-exception;
        r106.append(e);
        goto L13
    L15:
        return r101 + r100 + " ApplicationSpecific[" + r105.getApplicationTag() + "] (" + Strings.fromByteArray(Hex.encode(r105.getContents())) + ")" + r104;
    }
}
