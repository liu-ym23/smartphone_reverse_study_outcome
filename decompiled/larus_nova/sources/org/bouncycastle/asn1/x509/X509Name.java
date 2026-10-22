package org.bouncycastle.asn1.x509;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.n.a;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import kotlin.UByte;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERUniversalString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class X509Name extends ASN1Object {
    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY = null;
    public static final ASN1ObjectIdentifier C = null;
    public static final ASN1ObjectIdentifier CN = null;
    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP = null;
    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE = null;
    public static final ASN1ObjectIdentifier DATE_OF_BIRTH = null;
    public static final ASN1ObjectIdentifier DC = null;
    public static final ASN1ObjectIdentifier DMD_NAME = null;
    public static final ASN1ObjectIdentifier DN_QUALIFIER = null;
    public static final Hashtable DefaultLookUp = null;
    public static boolean DefaultReverse;
    public static final Hashtable DefaultSymbols = null;
    public static final ASN1ObjectIdentifier E = null;
    public static final ASN1ObjectIdentifier EmailAddress = null;
    private static final Boolean FALSE = null;
    public static final ASN1ObjectIdentifier GENDER = null;
    public static final ASN1ObjectIdentifier GENERATION = null;
    public static final ASN1ObjectIdentifier GIVENNAME = null;
    public static final ASN1ObjectIdentifier INITIALS = null;
    public static final ASN1ObjectIdentifier L = null;
    public static final ASN1ObjectIdentifier NAME = null;
    public static final ASN1ObjectIdentifier NAME_AT_BIRTH = null;
    public static final ASN1ObjectIdentifier O = null;
    public static final Hashtable OIDLookUp = null;
    public static final ASN1ObjectIdentifier OU = null;
    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH = null;
    public static final ASN1ObjectIdentifier POSTAL_ADDRESS = null;
    public static final ASN1ObjectIdentifier POSTAL_CODE = null;
    public static final ASN1ObjectIdentifier PSEUDONYM = null;
    public static final Hashtable RFC1779Symbols = null;
    public static final Hashtable RFC2253Symbols = null;
    public static final ASN1ObjectIdentifier SERIALNUMBER = null;
    public static final ASN1ObjectIdentifier SN = null;
    public static final ASN1ObjectIdentifier ST = null;
    public static final ASN1ObjectIdentifier STREET = null;
    public static final ASN1ObjectIdentifier SURNAME = null;
    public static final Hashtable SymbolLookUp = null;
    public static final ASN1ObjectIdentifier T = null;
    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER = null;
    private static final Boolean TRUE = null;
    public static final ASN1ObjectIdentifier UID = null;
    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER = null;
    public static final ASN1ObjectIdentifier UnstructuredAddress = null;
    public static final ASN1ObjectIdentifier UnstructuredName = null;
    private Vector added;
    private X509NameEntryConverter converter;
    private int hashCodeValue;
    private boolean isHashCodeCalculated;
    private Vector ordering;
    private ASN1Sequence seq;
    private Vector values;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("2.5.4.6");
        C = r100;
        ASN1ObjectIdentifier r101 = new ASN1ObjectIdentifier("2.5.4.10");
        O = r101;
        ASN1ObjectIdentifier r102 = new ASN1ObjectIdentifier("2.5.4.11");
        OU = r102;
        ASN1ObjectIdentifier r103 = new ASN1ObjectIdentifier("2.5.4.12");
        T = r103;
        ASN1ObjectIdentifier r104 = new ASN1ObjectIdentifier("2.5.4.3");
        CN = r104;
        ASN1ObjectIdentifier r105 = new ASN1ObjectIdentifier("2.5.4.5");
        SN = r105;
        ASN1ObjectIdentifier r106 = new ASN1ObjectIdentifier("2.5.4.9");
        STREET = r106;
        SERIALNUMBER = r105;
        ASN1ObjectIdentifier r107 = new ASN1ObjectIdentifier("2.5.4.7");
        L = r107;
        ASN1ObjectIdentifier r108 = new ASN1ObjectIdentifier("2.5.4.8");
        ST = r108;
        ASN1ObjectIdentifier r109 = new ASN1ObjectIdentifier("2.5.4.4");
        SURNAME = r109;
        ASN1ObjectIdentifier r110 = new ASN1ObjectIdentifier("2.5.4.42");
        GIVENNAME = r110;
        ASN1ObjectIdentifier r111 = new ASN1ObjectIdentifier("2.5.4.43");
        INITIALS = r111;
        ASN1ObjectIdentifier r112 = new ASN1ObjectIdentifier("2.5.4.44");
        GENERATION = r112;
        ASN1ObjectIdentifier r113 = new ASN1ObjectIdentifier("2.5.4.45");
        UNIQUE_IDENTIFIER = r113;
        ASN1ObjectIdentifier r114 = new ASN1ObjectIdentifier("2.5.4.15");
        BUSINESS_CATEGORY = r114;
        ASN1ObjectIdentifier r115 = new ASN1ObjectIdentifier("2.5.4.17");
        POSTAL_CODE = r115;
        ASN1ObjectIdentifier r116 = new ASN1ObjectIdentifier("2.5.4.46");
        DN_QUALIFIER = r116;
        ASN1ObjectIdentifier r117 = new ASN1ObjectIdentifier("2.5.4.65");
        PSEUDONYM = r117;
        ASN1ObjectIdentifier r118 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1");
        DATE_OF_BIRTH = r118;
        ASN1ObjectIdentifier r119 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2");
        PLACE_OF_BIRTH = r119;
        ASN1ObjectIdentifier r120 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3");
        GENDER = r120;
        ASN1ObjectIdentifier r121 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4");
        COUNTRY_OF_CITIZENSHIP = r121;
        ASN1ObjectIdentifier r122 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5");
        COUNTRY_OF_RESIDENCE = r122;
        ASN1ObjectIdentifier r123 = new ASN1ObjectIdentifier("1.3.36.8.3.14");
        NAME_AT_BIRTH = r123;
        ASN1ObjectIdentifier r124 = new ASN1ObjectIdentifier("2.5.4.16");
        POSTAL_ADDRESS = r124;
        DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54");
        ASN1ObjectIdentifier r125 = X509ObjectIdentifiers.id_at_telephoneNumber;
        TELEPHONE_NUMBER = r125;
        ASN1ObjectIdentifier r126 = X509ObjectIdentifiers.id_at_name;
        NAME = r126;
        ASN1ObjectIdentifier r127 = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
        EmailAddress = r127;
        ASN1ObjectIdentifier r128 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
        UnstructuredName = r128;
        ASN1ObjectIdentifier r129 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
        UnstructuredAddress = r129;
        E = r127;
        ASN1ObjectIdentifier r130 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        DC = r130;
        ASN1ObjectIdentifier r131 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        UID = r131;
        DefaultReverse = false;
        Hashtable r132 = new Hashtable();
        DefaultSymbols = r132;
        Hashtable r133 = new Hashtable();
        RFC2253Symbols = r133;
        Hashtable r134 = new Hashtable();
        RFC1779Symbols = r134;
        Hashtable r135 = new Hashtable();
        DefaultLookUp = r135;
        OIDLookUp = r132;
        SymbolLookUp = r135;
        TRUE = new Boolean(true);
        FALSE = new Boolean(false);
        r132.put(r100, "C");
        r132.put(r101, "O");
        r132.put(r103, ExifInterface.GPS_DIRECTION_TRUE);
        r132.put(r102, "OU");
        r132.put(r104, "CN");
        r132.put(r107, "L");
        r132.put(r108, "ST");
        r132.put(r105, "SERIALNUMBER");
        r132.put(r127, ExifInterface.LONGITUDE_EAST);
        r132.put(r130, "DC");
        r132.put(r131, "UID");
        r132.put(r106, "STREET");
        r132.put(r109, "SURNAME");
        r132.put(r110, "GIVENNAME");
        r132.put(r111, "INITIALS");
        r132.put(r112, "GENERATION");
        r132.put(r129, "unstructuredAddress");
        r132.put(r128, "unstructuredName");
        r132.put(r113, "UniqueIdentifier");
        r132.put(r116, "DN");
        r132.put(r117, "Pseudonym");
        r132.put(r124, "PostalAddress");
        r132.put(r123, "NameAtBirth");
        r132.put(r121, "CountryOfCitizenship");
        r132.put(r122, "CountryOfResidence");
        r132.put(r120, "Gender");
        r132.put(r119, "PlaceOfBirth");
        r132.put(r118, "DateOfBirth");
        r132.put(r115, "PostalCode");
        r132.put(r114, "BusinessCategory");
        r132.put(r125, "TelephoneNumber");
        r132.put(r126, "Name");
        r133.put(r100, "C");
        r133.put(r101, "O");
        r133.put(r102, "OU");
        r133.put(r104, "CN");
        r133.put(r107, "L");
        r133.put(r108, "ST");
        r133.put(r106, "STREET");
        r133.put(r130, "DC");
        r133.put(r131, "UID");
        r134.put(r100, "C");
        r134.put(r101, "O");
        r134.put(r102, "OU");
        r134.put(r104, "CN");
        r134.put(r107, "L");
        r134.put(r108, "ST");
        r134.put(r106, "STREET");
        r135.put("c", r100);
        r135.put("o", r101);
        r135.put("t", r103);
        r135.put("ou", r102);
        r135.put("cn", r104);
        r135.put("l", r107);
        r135.put(Segment.JsonKey.START, r108);
        r135.put("sn", r105);
        r135.put("serialnumber", r105);
        r135.put("street", r106);
        r135.put("emailaddress", r127);
        r135.put("dc", r130);
        r135.put("e", r127);
        r135.put("uid", r131);
        r135.put("surname", r109);
        r135.put("givenname", r110);
        r135.put("initials", r111);
        r135.put("generation", r112);
        r135.put("unstructuredaddress", r129);
        r135.put("unstructuredname", r128);
        r135.put("uniqueidentifier", r113);
        r135.put("dn", r116);
        r135.put("pseudonym", r117);
        r135.put("postaladdress", r124);
        r135.put("nameofbirth", r123);
        r135.put("countryofcitizenship", r121);
        r135.put("countryofresidence", r122);
        r135.put("gender", r120);
        r135.put("placeofbirth", r119);
        r135.put("dateofbirth", r118);
        r135.put("postalcode", r115);
        r135.put("businesscategory", r114);
        r135.put("telephonenumber", r125);
        r135.put("name", r126);
    }

    public X509Name() {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
    }

    public X509Name(String r100) {
        this(DefaultReverse, DefaultLookUp, r100);
    }

    public X509Name(String r100, X509NameEntryConverter r101) {
        this(DefaultReverse, DefaultLookUp, r100, r101);
    }

    public X509Name(Hashtable r100) {
        this(null, r100);
    }

    public X509Name(Vector r100, Hashtable r101) {
        this(r100, r101, new X509DefaultEntryConverter());
    }

    public X509Name(Vector r100, Hashtable r101, X509NameEntryConverter r102) {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
        this.converter = r102;
        int r103 = 0;
        if (r100 == null) goto L8;
        int r104 = 0;
    L6:
        if (r104 == r100.size()) goto L13;
        this.ordering.addElement(r100.elementAt(r104));
        this.added.addElement(FALSE);
        r104 = r104 + 1;
    L13:
        if (r103 == this.ordering.size()) goto L19;
        ASN1ObjectIdentifier r105 = (ASN1ObjectIdentifier) this.ordering.elementAt(r103);
        if (r101.get(r105) == null) goto L18;
        this.values.addElement(r101.get(r105));
        r103 = r103 + 1;
        goto L13
    L18:
        throw new IllegalArgumentException("No attribute for object id - " + r105.getId() + " - passed to distinguished name");
    L19:
        return;
    L8:
        Enumeration r106 = r101.keys();
    L10:
        if (r106.hasMoreElements() == false) goto L13;
        this.ordering.addElement(r106.nextElement());
        this.added.addElement(FALSE);
        goto L10
    }

    public X509Name(Vector r100, Vector r101) {
        this(r100, r101, new X509DefaultEntryConverter());
    }

    public X509Name(Vector r100, Vector r101, X509NameEntryConverter r102) {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
        this.converter = r102;
        if (r100.size() != r101.size()) goto L10;
        int r103 = 0;
    L6:
        if (r103 >= r100.size()) goto L8;
        this.ordering.addElement(r100.elementAt(r103));
        this.values.addElement(r101.elementAt(r103));
        this.added.addElement(FALSE);
        r103 = r103 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalArgumentException("oids vector must be same length as values.");
    }

    public X509Name(ASN1Sequence r100) {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
        this.seq = r100;
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L31;
        ASN1Set r102 = ASN1Set.getInstance(((ASN1Encodable) r101.nextElement()).toASN1Primitive());
        int r103 = 0;
    L7:
        if (r103 >= r102.size()) goto L4;
        ASN1Sequence r104 = ASN1Sequence.getInstance(r102.getObjectAt(r103).toASN1Primitive());
        if (r104.size() != 2) goto L30;
        this.ordering.addElement(ASN1ObjectIdentifier.getInstance(r104.getObjectAt(0)));
        ASN1Encodable r105 = r104.getObjectAt(1);
        if ((r105 instanceof ASN1String) == true) goto L13;
    L32:
        this.values.addElement("#" + bytesToString(Hex.encode(r105.toASN1Primitive().getEncoded(ASN1Encoding.DER))));     // Catch: IOException -> L27
    L22:
        Vector r106 = this.added;
        if (r103 == 0) goto L25;
        Boolean r107 = TRUE;
    L26:
        r106.addElement(r107);
        r103 = r103 + 1;
        goto L7
    L25:
        r107 = FALSE;
    L28:
        throw new IllegalArgumentException("cannot encode value");
    L13:
        if ((r105 instanceof DERUniversalString) == true) goto L32;
        String r108 = ((ASN1String) r105).getString();
        if (r108.length() > 0) goto L17;
    L19:
        Vector r109 = this.values;
    L20:
        r109.addElement(r108);
        goto L22
    L17:
        if (r108.charAt(0) != '#') goto L19;
        r109 = this.values;
        r108 = "\\".concat(r108);
        goto L20
    L30:
        throw new IllegalArgumentException("badly sized pair");
    }

    public X509Name(boolean r100, String r101) {
        this(r100, DefaultLookUp, r101);
    }

    public X509Name(boolean r100, String r101, X509NameEntryConverter r102) {
        this(r100, DefaultLookUp, r101, r102);
    }

    public X509Name(boolean r100, Hashtable r101, String r102) {
        this(r100, r101, r102, new X509DefaultEntryConverter());
    }

    public X509Name(boolean r100, Hashtable r101, String r102, X509NameEntryConverter r103) {
        this.converter = null;
        this.ordering = new Vector();
        this.values = new Vector();
        this.added = new Vector();
        this.converter = r103;
        X509NameTokenizer r104 = new X509NameTokenizer(r102);
    L4:
        if (r104.hasMoreTokens() == false) goto L12;
        String r105 = r104.nextToken();
        if (r105.indexOf(43) > 0) goto L7;
        addEntry(r101, r105, FALSE);
        goto L4
    L7:
        X509NameTokenizer r106 = new X509NameTokenizer(r105, '+');
        String r107 = r106.nextToken();
        Boolean r108 = FALSE;
    L8:
        addEntry(r101, r107, r108);
        if (r106.hasMoreTokens() == false) goto L4;
        r107 = r106.nextToken();
        r108 = TRUE;
        goto L8
    L12:
        if (r100 == false) goto L32;
        Vector r109 = new Vector();
        Vector r110 = new Vector();
        Vector r111 = new Vector();
        int r112 = 0;
        int r113 = 1;
    L15:
        if (r112 >= this.ordering.size()) goto L21;
        if (((Boolean) this.added.elementAt(r112)).booleanValue() == false) goto L19;
        r109.insertElementAt(this.ordering.elementAt(r112), r113);
        r110.insertElementAt(this.values.elementAt(r112), r113);
        r111.insertElementAt(this.added.elementAt(r112), r113);
        r113 = r113 + 1;
    L20:
        r112 = r112 + 1;
        goto L15
    L19:
        r109.insertElementAt(this.ordering.elementAt(r112), 0);
        r110.insertElementAt(this.values.elementAt(r112), 0);
        r111.insertElementAt(this.added.elementAt(r112), 0);
        r113 = 1;
        goto L20
    L21:
        this.ordering = r109;
        this.values = r110;
        this.added = r111;
        return;
    }

    private void addEntry(Hashtable r100, String r101, Boolean r102) {
        X509NameTokenizer r103 = new X509NameTokenizer(r101, a.f25612h);
        String r104 = r103.nextToken();
        if (r103.hasMoreTokens() == false) goto L7;
        String r105 = r103.nextToken();
        ASN1ObjectIdentifier r106 = decodeOID(r104, r100);
        this.ordering.addElement(r106);
        this.values.addElement(unescape(r105));
        this.added.addElement(r102);
        return;
    L7:
        throw new IllegalArgumentException("badly formatted directory string");
    }

    private void appendValue(StringBuffer r100, Hashtable r101, ASN1ObjectIdentifier r102, String r103) {
        String r104 = (String) r101.get(r102);
        if (r104 != null) goto L6;
        r104 = r102.getId();
    L6:
        r100.append(r104);
        r100.append(a.f25612h);
        int r105 = r100.length();
        r100.append(r103);
        int r106 = r100.length();
        if (r103.length() < 2) goto L14;
        if (r103.charAt(0) != '\\') goto L14;
        if (r103.charAt(1) != '#') goto L14;
        r105 = r105 + 2;
    L14:
        if (r105 >= r106) goto L18;
        if (r100.charAt(r105) != ' ') goto L18;
        r100.insert(r105, "\\");
        r105 = r105 + 2;
        r106 = r106 + 1;
    L18:
        r106 = r106 - 1;
        if (r106 <= r105) goto L23;
        if (r100.charAt(r106) != ' ') goto L23;
        r100.insert(r106, '\\');
    L23:
        if (r105 > r106) goto L34;
        char r107 = r100.charAt(r105);
        if (r107 == '\"') goto L33;
        if (r107 == '\\') goto L33;
        if (r107 == '+') goto L33;
        if (r107 == ',') goto L33;
        switch(r107) {
            case 59: goto L33;
            case 60: goto L33;
            case 61: goto L33;
            case 62: goto L33;
            default: goto L32;
        };
    L32:
        r105 = r105 + 1;
    L33:
        r100.insert(r105, "\\");
        r105 = r105 + 2;
        r106 = r106 + 1;
        goto L23
    }

    private String bytesToString(byte[] r100) {
        int r101 = r100.length;
        char[] r102 = new char[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L6;
        r102[r103] = (char) (r100[r103] & UByte.MAX_VALUE);
        r103 = r103 + 1;
        goto L3
    L6:
        return new String(r102);
    }

    private String canonicalize(String r100) {
        String r101 = Strings.toLowerCase(r100.trim());
        if (r101.length() > 0) goto L5;
        return r101;
    L5:
        if (r101.charAt(0) != '#') goto L11;
        ASN1Encodable r102 = decodeObject(r101);
        if ((r102 instanceof ASN1String) == true) goto L9;
        return r101;
    L9:
        return Strings.toLowerCase(((ASN1String) r102).getString().trim());
    L11:
        return r101;
    }

    private ASN1ObjectIdentifier decodeOID(String r100, Hashtable r101) {
        String r102 = r100.trim();
        if (Strings.toUpperCase(r102).startsWith("OID.") == false) goto L7;
        return new ASN1ObjectIdentifier(r102.substring(4));
    L7:
        if (r102.charAt(0) >= '0') goto L9;
    L12:
        ASN1ObjectIdentifier r103 = (ASN1ObjectIdentifier) r101.get(Strings.toLowerCase(r102));
        if (r103 == null) goto L16;
        return r103;
    L16:
        throw new IllegalArgumentException("Unknown object id - " + r102 + " - passed to distinguished name");
    L9:
        if (r102.charAt(0) > '9') goto L12;
        return new ASN1ObjectIdentifier(r102);
    }

    private ASN1Primitive decodeObject(String r100) {
        return ASN1Primitive.fromByteArray(Hex.decodeStrict(r100, 1, r100.length() - 1));
    L4:
        e = move-exception;
        throw new IllegalStateException("unknown encoding in name: " + e);
    }

    private boolean equivalentStrings(String r100, String r101) {
        String r102 = canonicalize(r100);
        String r103 = canonicalize(r101);
        if (r102.equals(r103) == false) goto L5;
        return true;
    L5:
        if (stripInternalSpaces(r102).equals(stripInternalSpaces(r103)) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static X509Name getInstance(Object r100) {
        if ((r100 instanceof X509Name) == false) goto L7;
        return (X509Name) r100;
    L7:
        if ((r100 instanceof X500Name) == true) goto L9;
        if (r100 != null) goto L12;
        return null;
    L12:
        return new X509Name(ASN1Sequence.getInstance(r100));
    L9:
        return new X509Name(ASN1Sequence.getInstance(((X500Name) r100).toASN1Primitive()));
    }

    public static X509Name getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    private String stripInternalSpaces(String r100) {
        StringBuffer r101 = new StringBuffer();
        if (r100.length() == 0) goto L13;
        char r102 = r100.charAt(0);
        r101.append(r102);
        int r103 = 1;
    L6:
        if (r103 >= r100.length()) goto L13;
        char r104 = r100.charAt(r103);
        if (r102 != ' ') goto L10;
        if (r104 != ' ') goto L10;
    L11:
        r103 = r103 + 1;
        r102 = r104;
    L10:
        r101.append(r104);
    L13:
        return r101.toString();
    }

    private String unescape(String r110) {
        if (r110.length() == 0) goto L45;
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
    L17:
        if (r102 == r100.length) goto L36;
        char r111 = r100[r102];
        if (r111 == ' ') goto L21;
        r106 = true;
    L21:
        if (r111 != '\"') goto L24;
        if (r103 == true) goto L32;
        r105 = !r105;
    L33:
        r103 = false;
    L34:
        r102 = r102 + 1;
    L32:
        r101.append(r111);
        goto L33
    L24:
        if (r111 != '\\') goto L28;
        if (r103 == true) goto L28;
        if (r105 == true) goto L28;
        r104 = r101.length();
        r103 = true;
    L28:
        if (r111 != ' ') goto L32;
        if (r103 == true) goto L32;
        if (r106 == true) goto L32;
    L36:
        if (r101.length() <= 0) goto L43;
    L38:
        if (r101.charAt(r101.length() - 1) != ' ') goto L43;
        if (r104 == (r101.length() - 1)) goto L43;
        r101.setLength(r101.length() - 1);
    L43:
        return r101.toString();
    L12:
        if (r100[1] != '#') goto L14;
        r101.append("\\#");
        r102 = 2;
        goto L15
    L7:
        if (r110.indexOf(34) >= 0) goto L9;
    L45:
        return r110.trim();
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean equals(Object r110) {
        if (r110 != this) goto L6;
        return true;
    L6:
        if ((r110 instanceof X509Name) == true) goto L11;
        if ((r110 instanceof ASN1Sequence) == true) goto L11;
        return false;
    L11:
        if (toASN1Primitive().equals(((ASN1Encodable) r110).toASN1Primitive()) == false) goto L39;
        return true;
    L39:
        X509Name r111 = getInstance(r110);     // Catch: IllegalArgumentException -> L38
        int r100 = this.ordering.size();
        if (r100 == r111.ordering.size()) goto L17;
        return false;
    L17:
        boolean[] r101 = new boolean[r100];
        if (this.ordering.elementAt(0).equals(r111.ordering.elementAt(0)) == false) goto L20;
        int r102 = r100;
        int r103 = 0;
        int r104 = 1;
    L21:
        if (r103 == r102) goto L37;
        ASN1ObjectIdentifier r105 = (ASN1ObjectIdentifier) this.ordering.elementAt(r103);
        String r106 = (String) this.values.elementAt(r103);
        int r107 = 0;
    L23:
        if (r107 >= r100) goto L33;
        if (r101[r107] == true) goto L32;
        if (r105.equals((ASN1ObjectIdentifier) r111.ordering.elementAt(r107)) == false) goto L32;
        if (equivalentStrings(r106, (String) r111.values.elementAt(r107)) == false) goto L32;
        r101[r107] = true;
        boolean r108 = true;
    L34:
        if (r108 == false) goto L35;
        r103 = r103 + r104;
        goto L21
    L35:
        return false;
    L32:
        r107 = r107 + 1;
        goto L23
    L33:
        r108 = false;
        goto L34
    L37:
        return true;
    L20:
        r103 = r100 - 1;
        r102 = -1;
        r104 = -1;
    L38:
        return false;
    }

    public boolean equals(Object r100, boolean r101) {
        if (r101 == true) goto L6;
        return equals(r100);
    L6:
        if (r100 != this) goto L9;
        return true;
    L9:
        if ((r100 instanceof X509Name) == false) goto L11;
    L13:
        ASN1Primitive r102 = ((ASN1Encodable) r100).toASN1Primitive();
        if (toASN1Primitive().equals(r102) == false) goto L31;
        return true;
    L31:
        X509Name r103 = getInstance(r100);     // Catch: IllegalArgumentException -> L30
        int r104 = this.ordering.size();
        if (r104 == r103.ordering.size()) goto L20;
        return false;
    L20:
        int r105 = 0;
    L21:
        if (r105 >= r104) goto L29;
        if (((ASN1ObjectIdentifier) this.ordering.elementAt(r105)).equals((ASN1ObjectIdentifier) r103.ordering.elementAt(r105)) == false) goto L28;
        if (equivalentStrings((String) this.values.elementAt(r105), (String) r103.values.elementAt(r105)) == false) goto L26;
        r105 = r105 + 1;
        goto L21
    L26:
        return false;
    L28:
        return false;
    L29:
        return true;
    L30:
        return false;
    L11:
        if ((r100 instanceof ASN1Sequence) == true) goto L13;
        return false;
    }

    public Vector getOIDs() {
        Vector r100 = new Vector();
        int r101 = 0;
    L4:
        if (r101 == this.ordering.size()) goto L6;
        r100.addElement(this.ordering.elementAt(r101));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public Vector getValues() {
        Vector r100 = new Vector();
        int r101 = 0;
    L4:
        if (r101 == this.values.size()) goto L6;
        r100.addElement(this.values.elementAt(r101));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public Vector getValues(ASN1ObjectIdentifier r100) {
        Vector r101 = new Vector();
        int r102 = 0;
    L4:
        if (r102 == this.values.size()) goto L16;
        if (this.ordering.elementAt(r102).equals(r100) == false) goto L15;
        String r103 = (String) this.values.elementAt(r102);
        if (r103.length() > 2) goto L10;
    L14:
        r101.addElement(r103);
        goto L15
    L10:
        if (r103.charAt(0) != '\\') goto L14;
        if (r103.charAt(1) != '#') goto L14;
        r103 = r103.substring(1);
    L15:
        r102 = r102 + 1;
        goto L4
    L16:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        if (this.isHashCodeCalculated == true) goto L5;
        this.isHashCodeCalculated = true;
        int r100 = 0;
    L8:
        if (r100 == this.ordering.size()) goto L11;
        String r101 = stripInternalSpaces(canonicalize((String) this.values.elementAt(r100)));
        int r102 = this.hashCodeValue ^ this.ordering.elementAt(r100).hashCode();
        this.hashCodeValue = r102;
        this.hashCodeValue = r101.hashCode() ^ r102;
        r100 = r100 + 1;
        goto L8
    L11:
        return this.hashCodeValue;
    L5:
        return this.hashCodeValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.seq != null) goto L17;
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        ASN1EncodableVector r101 = new ASN1EncodableVector();
        ASN1ObjectIdentifier r102 = null;
        int r103 = 0;
    L6:
        if (r103 == this.ordering.size()) goto L15;
        ASN1EncodableVector r104 = new ASN1EncodableVector(2);
        ASN1ObjectIdentifier r105 = (ASN1ObjectIdentifier) this.ordering.elementAt(r103);
        r104.add(r105);
        String r106 = (String) this.values.elementAt(r103);
        r104.add(this.converter.getConvertedValue(r105, r106));
        if (r102 != null) goto L10;
    L13:
        DERSequence r107 = new DERSequence(r104);
    L14:
        r101.add(r107);
        r103 = r103 + 1;
        r102 = r105;
        goto L6
    L10:
        if (((Boolean) this.added.elementAt(r103)).booleanValue() == true) goto L13;
        r100.add(new DERSet(r101));
        r101 = new ASN1EncodableVector();
        r107 = new DERSequence(r104);
        goto L14
    L15:
        r100.add(new DERSet(r101));
        this.seq = new DERSequence(r100);
    L17:
        return this.seq;
    }

    public String toString() {
        return toString(DefaultReverse, DefaultSymbols);
    }

    public String toString(boolean r100, Hashtable r101) {
        StringBuffer r102 = new StringBuffer();
        Vector r103 = new Vector();
        StringBuffer r104 = null;
        int r105 = 0;
    L4:
        if (r105 >= this.ordering.size()) goto L10;
        if (((Boolean) this.added.elementAt(r105)).booleanValue() == false) goto L8;
        r104.append('+');
        appendValue(r104, r101, (ASN1ObjectIdentifier) this.ordering.elementAt(r105), (String) this.values.elementAt(r105));
    L9:
        r105 = r105 + 1;
        goto L4
    L8:
        r104 = new StringBuffer();
        appendValue(r104, r101, (ASN1ObjectIdentifier) this.ordering.elementAt(r105), (String) this.values.elementAt(r105));
        r103.addElement(r104);
        goto L9
    L10:
        boolean r106 = true;
        if (r100 == false) goto L18;
        int r107 = r103.size() - 1;
    L13:
        if (r107 < 0) goto L26;
        if (r106 == false) goto L16;
        r106 = false;
    L17:
        r102.append(r103.elementAt(r107).toString());
        r107 = r107 - 1;
        goto L13
    L16:
        r102.append(',');
    L26:
        return r102.toString();
    L18:
        int r108 = 0;
    L20:
        if (r108 >= r103.size()) goto L26;
        if (r106 == false) goto L23;
        r106 = false;
    L24:
        r102.append(r103.elementAt(r108).toString());
        r108 = r108 + 1;
        goto L20
    L23:
        r102.append(',');
        goto L24
    }
}
