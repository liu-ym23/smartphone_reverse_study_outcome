package org.bouncycastle.asn1.x500.style;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public class BCStyle extends AbstractX500NameStyle {
    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY = null;
    public static final ASN1ObjectIdentifier C = null;
    public static final ASN1ObjectIdentifier CN = null;
    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP = null;
    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE = null;
    public static final ASN1ObjectIdentifier DATE_OF_BIRTH = null;
    public static final ASN1ObjectIdentifier DC = null;
    public static final ASN1ObjectIdentifier DESCRIPTION = null;
    public static final ASN1ObjectIdentifier DMD_NAME = null;
    public static final ASN1ObjectIdentifier DN_QUALIFIER = null;
    private static final Hashtable DefaultLookUp = null;
    private static final Hashtable DefaultSymbols = null;
    public static final ASN1ObjectIdentifier E = null;
    public static final ASN1ObjectIdentifier EmailAddress = null;
    public static final ASN1ObjectIdentifier GENDER = null;
    public static final ASN1ObjectIdentifier GENERATION = null;
    public static final ASN1ObjectIdentifier GIVENNAME = null;
    public static final ASN1ObjectIdentifier INITIALS = null;
    public static final X500NameStyle INSTANCE = null;
    public static final ASN1ObjectIdentifier L = null;
    public static final ASN1ObjectIdentifier NAME = null;
    public static final ASN1ObjectIdentifier NAME_AT_BIRTH = null;
    public static final ASN1ObjectIdentifier O = null;
    public static final ASN1ObjectIdentifier ORGANIZATION_IDENTIFIER = null;
    public static final ASN1ObjectIdentifier OU = null;
    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH = null;
    public static final ASN1ObjectIdentifier POSTAL_ADDRESS = null;
    public static final ASN1ObjectIdentifier POSTAL_CODE = null;
    public static final ASN1ObjectIdentifier PSEUDONYM = null;
    public static final ASN1ObjectIdentifier ROLE = null;
    public static final ASN1ObjectIdentifier SERIALNUMBER = null;
    public static final ASN1ObjectIdentifier SN = null;
    public static final ASN1ObjectIdentifier ST = null;
    public static final ASN1ObjectIdentifier STREET = null;
    public static final ASN1ObjectIdentifier SURNAME = null;
    public static final ASN1ObjectIdentifier T = null;
    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER = null;
    public static final ASN1ObjectIdentifier UID = null;
    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER = null;
    public static final ASN1ObjectIdentifier UnstructuredAddress = null;
    public static final ASN1ObjectIdentifier UnstructuredName = null;
    protected final Hashtable defaultLookUp;
    protected final Hashtable defaultSymbols;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("2.5.4.6").intern();
        C = r100;
        ASN1ObjectIdentifier r101 = new ASN1ObjectIdentifier("2.5.4.10").intern();
        O = r101;
        ASN1ObjectIdentifier r102 = new ASN1ObjectIdentifier("2.5.4.11").intern();
        OU = r102;
        ASN1ObjectIdentifier r103 = new ASN1ObjectIdentifier("2.5.4.12").intern();
        T = r103;
        ASN1ObjectIdentifier r104 = new ASN1ObjectIdentifier("2.5.4.3").intern();
        CN = r104;
        SN = new ASN1ObjectIdentifier("2.5.4.5").intern();
        ASN1ObjectIdentifier r105 = new ASN1ObjectIdentifier("2.5.4.9").intern();
        STREET = r105;
        ASN1ObjectIdentifier r106 = new ASN1ObjectIdentifier("2.5.4.5").intern();
        SERIALNUMBER = r106;
        ASN1ObjectIdentifier r107 = new ASN1ObjectIdentifier("2.5.4.7").intern();
        L = r107;
        ASN1ObjectIdentifier r108 = new ASN1ObjectIdentifier("2.5.4.8").intern();
        ST = r108;
        ASN1ObjectIdentifier r109 = new ASN1ObjectIdentifier("2.5.4.4").intern();
        SURNAME = r109;
        ASN1ObjectIdentifier r110 = new ASN1ObjectIdentifier("2.5.4.42").intern();
        GIVENNAME = r110;
        ASN1ObjectIdentifier r111 = new ASN1ObjectIdentifier("2.5.4.43").intern();
        INITIALS = r111;
        ASN1ObjectIdentifier r112 = new ASN1ObjectIdentifier("2.5.4.44").intern();
        GENERATION = r112;
        ASN1ObjectIdentifier r113 = new ASN1ObjectIdentifier("2.5.4.45").intern();
        UNIQUE_IDENTIFIER = r113;
        ASN1ObjectIdentifier r114 = new ASN1ObjectIdentifier("2.5.4.13").intern();
        DESCRIPTION = r114;
        ASN1ObjectIdentifier r115 = new ASN1ObjectIdentifier("2.5.4.15").intern();
        BUSINESS_CATEGORY = r115;
        ASN1ObjectIdentifier r116 = new ASN1ObjectIdentifier("2.5.4.17").intern();
        POSTAL_CODE = r116;
        ASN1ObjectIdentifier r117 = new ASN1ObjectIdentifier("2.5.4.46").intern();
        DN_QUALIFIER = r117;
        ASN1ObjectIdentifier r118 = new ASN1ObjectIdentifier("2.5.4.65").intern();
        PSEUDONYM = r118;
        ASN1ObjectIdentifier r119 = new ASN1ObjectIdentifier("2.5.4.72").intern();
        ROLE = r119;
        ASN1ObjectIdentifier r120 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1").intern();
        DATE_OF_BIRTH = r120;
        ASN1ObjectIdentifier r121 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2").intern();
        PLACE_OF_BIRTH = r121;
        ASN1ObjectIdentifier r122 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3").intern();
        GENDER = r122;
        ASN1ObjectIdentifier r123 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4").intern();
        COUNTRY_OF_CITIZENSHIP = r123;
        ASN1ObjectIdentifier r124 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5").intern();
        COUNTRY_OF_RESIDENCE = r124;
        ASN1ObjectIdentifier r125 = new ASN1ObjectIdentifier("1.3.36.8.3.14").intern();
        NAME_AT_BIRTH = r125;
        ASN1ObjectIdentifier r126 = new ASN1ObjectIdentifier("2.5.4.16").intern();
        POSTAL_ADDRESS = r126;
        DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54").intern();
        ASN1ObjectIdentifier r127 = X509ObjectIdentifiers.id_at_telephoneNumber;
        TELEPHONE_NUMBER = r127;
        ASN1ObjectIdentifier r128 = X509ObjectIdentifiers.id_at_name;
        NAME = r128;
        ASN1ObjectIdentifier r129 = X509ObjectIdentifiers.id_at_organizationIdentifier;
        ORGANIZATION_IDENTIFIER = r129;
        ASN1ObjectIdentifier r130 = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
        EmailAddress = r130;
        ASN1ObjectIdentifier r131 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
        UnstructuredName = r131;
        ASN1ObjectIdentifier r132 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
        UnstructuredAddress = r132;
        E = r130;
        ASN1ObjectIdentifier r133 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        DC = r133;
        ASN1ObjectIdentifier r134 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        UID = r134;
        Hashtable r135 = new Hashtable();
        DefaultSymbols = r135;
        Hashtable r136 = new Hashtable();
        DefaultLookUp = r136;
        r135.put(r100, "C");
        r135.put(r101, "O");
        r135.put(r103, ExifInterface.GPS_DIRECTION_TRUE);
        r135.put(r102, "OU");
        r135.put(r104, "CN");
        r135.put(r107, "L");
        r135.put(r108, "ST");
        r135.put(r106, "SERIALNUMBER");
        r135.put(r130, ExifInterface.LONGITUDE_EAST);
        r135.put(r133, "DC");
        r135.put(r134, "UID");
        r135.put(r105, "STREET");
        r135.put(r109, "SURNAME");
        r135.put(r110, "GIVENNAME");
        r135.put(r111, "INITIALS");
        r135.put(r112, "GENERATION");
        r135.put(r114, "DESCRIPTION");
        r135.put(r119, "ROLE");
        r135.put(r132, "unstructuredAddress");
        r135.put(r131, "unstructuredName");
        r135.put(r113, "UniqueIdentifier");
        r135.put(r117, "DN");
        r135.put(r118, "Pseudonym");
        r135.put(r126, "PostalAddress");
        r135.put(r125, "NameAtBirth");
        r135.put(r123, "CountryOfCitizenship");
        r135.put(r124, "CountryOfResidence");
        r135.put(r122, "Gender");
        r135.put(r121, "PlaceOfBirth");
        r135.put(r120, "DateOfBirth");
        r135.put(r116, "PostalCode");
        r135.put(r115, "BusinessCategory");
        r135.put(r127, "TelephoneNumber");
        r135.put(r128, "Name");
        r135.put(r129, "organizationIdentifier");
        r136.put("c", r100);
        r136.put("o", r101);
        r136.put("t", r103);
        r136.put("ou", r102);
        r136.put("cn", r104);
        r136.put("l", r107);
        r136.put(Segment.JsonKey.START, r108);
        r136.put("sn", r109);
        r136.put("serialnumber", r106);
        r136.put("street", r105);
        r136.put("emailaddress", r130);
        r136.put("dc", r133);
        r136.put("e", r130);
        r136.put("uid", r134);
        r136.put("surname", r109);
        r136.put("givenname", r110);
        r136.put("initials", r111);
        r136.put("generation", r112);
        r136.put("description", r114);
        r136.put("role", r119);
        r136.put("unstructuredaddress", r132);
        r136.put("unstructuredname", r131);
        r136.put("uniqueidentifier", r113);
        r136.put("dn", r117);
        r136.put("pseudonym", r118);
        r136.put("postaladdress", r126);
        r136.put("nameatbirth", r125);
        r136.put("countryofcitizenship", r123);
        r136.put("countryofresidence", r124);
        r136.put("gender", r122);
        r136.put("placeofbirth", r121);
        r136.put("dateofbirth", r120);
        r136.put("postalcode", r116);
        r136.put("businesscategory", r115);
        r136.put("telephonenumber", r127);
        r136.put("name", r128);
        r136.put("organizationidentifier", r129);
        INSTANCE = new BCStyle();
    }

    public BCStyle() {
        this.defaultSymbols = AbstractX500NameStyle.copyHashTable(DefaultSymbols);
        this.defaultLookUp = AbstractX500NameStyle.copyHashTable(DefaultLookUp);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public ASN1ObjectIdentifier attrNameToOID(String r100) {
        return IETFUtils.decodeAttrName(r100, this.defaultLookUp);
    }

    @Override // org.bouncycastle.asn1.x500.style.AbstractX500NameStyle
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier r100, String r101) {
        if (r100.equals(EmailAddress) == true) goto L25;
        if (r100.equals(DC) == true) goto L25;
        if (r100.equals(DATE_OF_BIRTH) == false) goto L12;
        return new ASN1GeneralizedTime(r101);
    L12:
        if (r100.equals(C) == true) goto L23;
        if (r100.equals(SN) == true) goto L23;
        if (r100.equals(DN_QUALIFIER) == true) goto L23;
        if (r100.equals(TELEPHONE_NUMBER) == true) goto L23;
        return super.encodeStringValue(r100, r101);
    L23:
        return new DERPrintableString(r101);
    L25:
        return new DERIA5String(r101);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public RDN[] fromString(String r100) {
        return IETFUtils.rDNsFromString(r100, this);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public String[] oidToAttrNames(ASN1ObjectIdentifier r100) {
        return IETFUtils.findAttrNamesForOID(r100, this.defaultLookUp);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public String oidToDisplayName(ASN1ObjectIdentifier r100) {
        return (String) DefaultSymbols.get(r100);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public String toString(X500Name r100) {
        StringBuffer r101 = new StringBuffer();
        RDN[] r102 = r100.getRDNs();
        boolean r103 = true;
        int r104 = 0;
    L4:
        if (r104 >= r102.length) goto L10;
        if (r103 == false) goto L7;
        r103 = false;
    L8:
        IETFUtils.appendRDN(r101, r102[r104], this.defaultSymbols);
        r104 = r104 + 1;
        goto L4
    L7:
        r101.append(',');
        goto L8
    L10:
        return r101.toString();
    }
}
