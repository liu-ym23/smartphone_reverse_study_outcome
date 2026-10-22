package org.bouncycastle.asn1.x500.style;

import com.alipay.sdk.m.n.a;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERUniversalString;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;
import tb2.c;

/* JADX INFO: loaded from: classes42.dex */
public class IETFUtils {
    public IETFUtils() {
    }

    public static void appendRDN(StringBuffer r100, RDN r101, Hashtable r102) {
        if (r101.isMultiValued() == false) goto L12;
        AttributeTypeAndValue[] r103 = r101.getTypesAndValues();
        boolean r104 = true;
        int r105 = 0;
    L6:
        if (r105 == r103.length) goto L19;
        if (r104 == false) goto L9;
        r104 = false;
    L10:
        appendTypeAndValue(r100, r103[r105], r102);
        r105 = r105 + 1;
        goto L6
    L9:
        r100.append('+');
        goto L10
    L19:
        return;
    L12:
        if (r101.getFirst() == null) goto L18;
        appendTypeAndValue(r100, r101.getFirst(), r102);
        return;
    }

    public static void appendTypeAndValue(StringBuffer r100, AttributeTypeAndValue r101, Hashtable r102) {
        String r103 = (String) r102.get(r101.getType());
        if (r103 != null) goto L6;
        r103 = r101.getType().getId();
    L6:
        r100.append(r103);
        r100.append(a.f25612h);
        r100.append(valueToString(r101.getValue()));
    }

    private static boolean atvAreEqual(AttributeTypeAndValue r100, AttributeTypeAndValue r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        if (r100.getType().equals(r101.getType()) == true) goto L13;
        return false;
    L13:
        if (canonicalString(r100.getValue()).equals(canonicalString(r101.getValue())) == true) goto L15;
        return false;
    L15:
        return true;
    L16:
        return false;
    }

    public static String canonicalString(ASN1Encodable r100) {
        return canonicalize(valueToString(r100));
    }

    public static String canonicalize(String r100) {
        int r101 = 0;
        if (r100.length() > 0) goto L5;
    L9:
        String r102 = Strings.toLowerCase(r100);
        int r103 = r102.length();
        if (r103 >= 2) goto L12;
        return r102;
    L12:
        int r104 = r103 - 1;
    L14:
        if (r101 >= r104) goto L20;
        if (r102.charAt(r101) != '\\') goto L20;
        if (r102.charAt(r101 + 1) != ' ') goto L20;
        r101 = r101 + 2;
    L20:
        int r105 = r101 + 1;
        int r106 = r104;
    L21:
        if (r106 <= r105) goto L27;
        if (r102.charAt(r106 - 1) != '\\') goto L27;
        if (r102.charAt(r106) != ' ') goto L27;
        r106 = r106 - 2;
    L27:
        if (r101 > 0) goto L29;
        if (r106 < r104) goto L29;
    L31:
        return stripInternalSpaces(r102);
    L29:
        r102 = r102.substring(r101, r106 + 1);
        goto L31
    L5:
        if (r100.charAt(0) != '#') goto L9;
        ASN1Encodable r107 = decodeObject(r100);
        if ((r107 instanceof ASN1String) == false) goto L9;
        r100 = ((ASN1String) r107).getString();
        goto L9
    }

    private static int convertHex(char r100) {
        if ('0' > r100) goto L9;
        if (r100 > '9') goto L9;
        return r100 - '0';
    L9:
        if ('a' <= r100) goto L11;
    L15:
        int r101 = r100 - 'A';
    L14:
        return r101 + 10;
    L11:
        if (r100 > 'f') goto L15;
        r101 = r100 - 'a';
        goto L14
    }

    public static ASN1ObjectIdentifier decodeAttrName(String r100, Hashtable r101) {
        if (Strings.toUpperCase(r100).startsWith("OID.") == false) goto L7;
        return new ASN1ObjectIdentifier(r100.substring(4));
    L7:
        if (r100.charAt(0) >= '0') goto L9;
    L12:
        ASN1ObjectIdentifier r102 = (ASN1ObjectIdentifier) r101.get(Strings.toLowerCase(r100));
        if (r102 == null) goto L16;
        return r102;
    L16:
        throw new IllegalArgumentException("Unknown object id - " + r100 + " - passed to distinguished name");
    L9:
        if (r100.charAt(0) > '9') goto L12;
        return new ASN1ObjectIdentifier(r100);
    }

    private static ASN1Primitive decodeObject(String r100) {
        return ASN1Primitive.fromByteArray(Hex.decodeStrict(r100, 1, r100.length() - 1));
    L4:
        e = move-exception;
        throw new IllegalStateException("unknown encoding in name: " + e);
    }

    public static String[] findAttrNamesForOID(ASN1ObjectIdentifier r100, Hashtable r101) {
        Enumeration r102 = r101.elements();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r102.hasMoreElements() == false) goto L8;
        if (r100.equals(r102.nextElement()) == false) goto L4;
        r104 = r104 + 1;
        goto L4
    L8:
        String[] r105 = new String[r104];
        Enumeration r106 = r101.keys();
    L10:
        if (r106.hasMoreElements() == false) goto L14;
        String r107 = (String) r106.nextElement();
        if (r100.equals(r101.get(r107)) == false) goto L10;
        r105[r103] = r107;
        r103 = r103 + 1;
        goto L10
    L14:
        return r105;
    }

    private static boolean isHexDigit(char r100) {
        if ('0' > r100) goto L7;
        if (r100 > '9') goto L7;
    L14:
        return true;
    L7:
        if ('a' > r100) goto L11;
        if (r100 <= 'f') goto L14;
    L11:
        if ('A' <= r100) goto L13;
    L15:
        return false;
    L13:
        if (r100 > 'F') goto L15;
        goto L14
    }

    public static boolean rDNAreEqual(RDN r100, RDN r101) {
        if (r100.size() == r101.size()) goto L5;
        return false;
    L5:
        AttributeTypeAndValue[] r102 = r100.getTypesAndValues();
        AttributeTypeAndValue[] r103 = r101.getTypesAndValues();
        if (r102.length == r103.length) goto L8;
        return false;
    L8:
        int r104 = 0;
    L10:
        if (r104 == r102.length) goto L15;
        if (atvAreEqual(r102[r104], r103[r104]) == false) goto L13;
        r104 = r104 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    public static RDN[] rDNsFromString(String r100, X500NameStyle r110) {
        X500NameTokenizer r101 = new X500NameTokenizer(r100);
        X500NameBuilder r102 = new X500NameBuilder(r110);
    L4:
        if (r101.hasMoreTokens() == false) goto L29;
        String r103 = r101.nextToken();
        if (r103.indexOf(43) > 0) goto L7;
        X500NameTokenizer r104 = new X500NameTokenizer(r103, a.f25612h);
        String r105 = r104.nextToken();
        if (r104.hasMoreTokens() == false) goto L27;
        String r106 = r104.nextToken();
        r102.addRDN(r110.attrNameToOID(r105.trim()), unescape(r106));
        goto L4
    L27:
        throw new IllegalArgumentException("badly formatted directory string");
    L7:
        X500NameTokenizer r107 = new X500NameTokenizer(r103, '+');
        X500NameTokenizer r108 = new X500NameTokenizer(r107.nextToken(), a.f25612h);
        String r109 = r108.nextToken();
        if (r108.hasMoreTokens() == false) goto L22;
        String r111 = r108.nextToken();
        ASN1ObjectIdentifier r112 = r110.attrNameToOID(r109.trim());
        if (r107.hasMoreTokens() == true) goto L11;
        r102.addRDN(r112, unescape(r111));
        goto L4
    L11:
        Vector r113 = new Vector();
        Vector r114 = new Vector();
    L12:
        r113.addElement(r112);
        r114.addElement(unescape(r111));
        if (r107.hasMoreTokens() == false) goto L19;
        X500NameTokenizer r115 = new X500NameTokenizer(r107.nextToken(), a.f25612h);
        String r116 = r115.nextToken();
        if (r115.hasMoreTokens() == false) goto L18;
        r111 = r115.nextToken();
        r112 = r110.attrNameToOID(r116.trim());
        goto L12
    L18:
        throw new IllegalArgumentException("badly formatted directory string");
    L19:
        r102.addMultiValuedRDN(toOIDArray(r113), toValueArray(r114));
        goto L4
    L22:
        throw new IllegalArgumentException("badly formatted directory string");
    L29:
        return r102.build().getRDNs();
    }

    public static String stripInternalSpaces(String r100) {
        if (r100.indexOf(c.DEFAULT_TEXT) >= 0) goto L5;
        return r100;
    L5:
        StringBuffer r101 = new StringBuffer();
        char r102 = r100.charAt(0);
        r101.append(r102);
        int r103 = 1;
    L7:
        if (r103 >= r100.length()) goto L14;
        char r104 = r100.charAt(r103);
        if (r102 != ' ') goto L11;
        if (r104 != ' ') goto L11;
    L12:
        r103 = r103 + 1;
    L11:
        r101.append(r104);
        r102 = r104;
        goto L12
    L14:
        return r101.toString();
    }

    private static ASN1ObjectIdentifier[] toOIDArray(Vector r100) {
        int r101 = r100.size();
        ASN1ObjectIdentifier[] r102 = new ASN1ObjectIdentifier[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = (ASN1ObjectIdentifier) r100.elementAt(r103);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    private static String[] toValueArray(Vector r100) {
        int r101 = r100.size();
        String[] r102 = new String[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = (String) r100.elementAt(r103);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    private static String unescape(String r110) {
        if (r110.length() == 0) goto L51;
        if (r110.indexOf(92) < 0) goto L7;
    L9:
        char[] r100 = r110.toCharArray();
        StringBuffer r101 = new StringBuffer(r110.length());
        if (r100[0] == '\\') goto L12;
    L14:
        int r102 = 0;
    L15:
        boolean r103 = false;
        int r104 = 0;
        boolean r105 = false;
        boolean r106 = false;
        char r111 = 0;
    L17:
        if (r102 == r100.length) goto L42;
        char r112 = r100[r102];
        if (r112 == ' ') goto L21;
        r106 = true;
    L21:
        if (r112 != '\"') goto L25;
        if (r103 == true) goto L39;
        r105 = !r105;
    L24:
        r103 = false;
    L40:
        r102 = r102 + 1;
    L39:
        r101.append(r112);
        goto L24
    L25:
        if (r112 != '\\') goto L29;
        if (r103 == true) goto L29;
        if (r105 == true) goto L29;
        r104 = r101.length();
        r103 = true;
    L29:
        if (r112 != ' ') goto L33;
        if (r103 == true) goto L33;
        if (r106 == false) goto L40;
    L33:
        if (r103 == false) goto L39;
        if (isHexDigit(r112) == false) goto L39;
        if (r111 == 0) goto L38;
        r101.append((char) ((convertHex(r111) * 16) + convertHex(r112)));
        r103 = false;
        r111 = 0;
        goto L40
    L38:
        r111 = r112;
        goto L40
    L42:
        if (r101.length() <= 0) goto L49;
    L44:
        if (r101.charAt(r101.length() - 1) != ' ') goto L49;
        if (r104 == (r101.length() - 1)) goto L49;
        r101.setLength(r101.length() - 1);
    L49:
        return r101.toString();
    L12:
        if (r100[1] != '#') goto L14;
        r101.append("\\#");
        r102 = 2;
        goto L15
    L7:
        if (r110.indexOf(34) >= 0) goto L9;
    L51:
        return r110.trim();
    }

    public static ASN1Encodable valueFromHexString(String r100, int r101) throws IOException {
        int r102 = (r100.length() - r101) / 2;
        byte[] r103 = new byte[r102];
        int r104 = 0;
    L3:
        if (r104 == r102) goto L6;
        int r105 = (r104 * 2) + r101;
        char r106 = r100.charAt(r105);
        char r107 = r100.charAt(r105 + 1);
        int r108 = convertHex(r106) << 4;
        r103[r104] = (byte) (convertHex(r107) | r108);
        r104 = r104 + 1;
        goto L3
    L6:
        return ASN1Primitive.fromByteArray(r103);
    }

    public static String valueToString(ASN1Encodable r100) {
        StringBuffer r101 = new StringBuffer();
        int r102 = 0;
        if ((r100 instanceof ASN1String) == true) goto L5;
    L49:
        r101.append('#');     // Catch: IOException -> L47
        r101.append(Hex.toHexString(r100.toASN1Primitive().getEncoded(ASN1Encoding.DER)));     // Catch: IOException -> L47
    L13:
        int r103 = r101.length();
        int r104 = 2;
        if (r101.length() >= 2) goto L16;
    L20:
        r104 = 0;
    L22:
        if (r104 == r103) goto L34;
        char r105 = r101.charAt(r104);
        if (r105 == '\"') goto L32;
        if (r105 == '\\') goto L32;
        if (r105 == '+') goto L32;
        if (r105 == ',') goto L32;
        switch(r105) {
            case 59: goto L32;
            case 60: goto L32;
            case 61: goto L32;
            case 62: goto L32;
            default: goto L31;
        };
    L31:
        r104 = r104 + 1;
    L32:
        r101.insert(r104, "\\");
        r104 = r104 + 2;
        r103 = r103 + 1;
        goto L22
    L34:
        if (r101.length() > 0) goto L36;
    L40:
        int r106 = r101.length() - 1;
    L41:
        if (r106 < 0) goto L46;
        if (r101.charAt(r106) != ' ') goto L46;
        r101.insert(r106, '\\');
        r106 = r106 - 1;
    L46:
        return r101.toString();
    L36:
        if (r101.length() <= r102) goto L40;
        if (r101.charAt(r102) != ' ') goto L40;
        r101.insert(r102, "\\");
        r102 = r102 + 2;
        goto L36
    L16:
        if (r101.charAt(0) != '\\') goto L20;
        if (r101.charAt(1) != '#') goto L20;
    L48:
        throw new IllegalArgumentException("Other value has no encoded form");
    L5:
        if ((r100 instanceof DERUniversalString) == true) goto L49;
        String r107 = ((ASN1String) r100).getString();
        if (r107.length() > 0) goto L9;
    L11:
        r101.append(r107);
        goto L13
    L9:
        if (r107.charAt(0) != '#') goto L11;
        r101.append('\\');
        goto L11
    }
}
