package org.bouncycastle.asn1.x500.style;

import androidx.autofill.HintConstants;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

/* JADX INFO: loaded from: classes42.dex */
public class RFC4519Style extends AbstractX500NameStyle {
    private static final Hashtable DefaultLookUp = null;
    private static final Hashtable DefaultSymbols = null;
    public static final X500NameStyle INSTANCE = null;
    public static final ASN1ObjectIdentifier businessCategory = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f525071c = null;

    /* JADX INFO: renamed from: cn, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f525072cn = null;

    /* JADX INFO: renamed from: dc, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f525073dc = null;
    public static final ASN1ObjectIdentifier description = null;
    public static final ASN1ObjectIdentifier destinationIndicator = null;
    public static final ASN1ObjectIdentifier distinguishedName = null;
    public static final ASN1ObjectIdentifier dnQualifier = null;
    public static final ASN1ObjectIdentifier enhancedSearchGuide = null;
    public static final ASN1ObjectIdentifier facsimileTelephoneNumber = null;
    public static final ASN1ObjectIdentifier generationQualifier = null;
    public static final ASN1ObjectIdentifier givenName = null;
    public static final ASN1ObjectIdentifier houseIdentifier = null;
    public static final ASN1ObjectIdentifier initials = null;
    public static final ASN1ObjectIdentifier internationalISDNNumber = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f525074l = null;
    public static final ASN1ObjectIdentifier member = null;
    public static final ASN1ObjectIdentifier name = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f525075o = null;

    /* JADX INFO: renamed from: ou, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f525076ou = null;
    public static final ASN1ObjectIdentifier owner = null;
    public static final ASN1ObjectIdentifier physicalDeliveryOfficeName = null;
    public static final ASN1ObjectIdentifier postOfficeBox = null;
    public static final ASN1ObjectIdentifier postalAddress = null;
    public static final ASN1ObjectIdentifier postalCode = null;
    public static final ASN1ObjectIdentifier preferredDeliveryMethod = null;
    public static final ASN1ObjectIdentifier registeredAddress = null;
    public static final ASN1ObjectIdentifier roleOccupant = null;
    public static final ASN1ObjectIdentifier searchGuide = null;
    public static final ASN1ObjectIdentifier seeAlso = null;
    public static final ASN1ObjectIdentifier serialNumber = null;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f525077sn = null;

    /* JADX INFO: renamed from: st, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f525078st = null;
    public static final ASN1ObjectIdentifier street = null;
    public static final ASN1ObjectIdentifier telephoneNumber = null;
    public static final ASN1ObjectIdentifier teletexTerminalIdentifier = null;
    public static final ASN1ObjectIdentifier telexNumber = null;
    public static final ASN1ObjectIdentifier title = null;
    public static final ASN1ObjectIdentifier uid = null;
    public static final ASN1ObjectIdentifier uniqueMember = null;
    public static final ASN1ObjectIdentifier userPassword = null;
    public static final ASN1ObjectIdentifier x121Address = null;
    public static final ASN1ObjectIdentifier x500UniqueIdentifier = null;
    protected final Hashtable defaultLookUp;
    protected final Hashtable defaultSymbols;

    static {
        ASN1ObjectIdentifier r100 = new ASN1ObjectIdentifier("2.5.4.15").intern();
        businessCategory = r100;
        ASN1ObjectIdentifier r101 = new ASN1ObjectIdentifier("2.5.4.6").intern();
        f525071c = r101;
        ASN1ObjectIdentifier r102 = new ASN1ObjectIdentifier("2.5.4.3").intern();
        f525072cn = r102;
        ASN1ObjectIdentifier r103 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25").intern();
        f525073dc = r103;
        ASN1ObjectIdentifier r104 = new ASN1ObjectIdentifier("2.5.4.13").intern();
        description = r104;
        ASN1ObjectIdentifier r105 = new ASN1ObjectIdentifier("2.5.4.27").intern();
        destinationIndicator = r105;
        ASN1ObjectIdentifier r106 = new ASN1ObjectIdentifier("2.5.4.49").intern();
        distinguishedName = r106;
        ASN1ObjectIdentifier r107 = new ASN1ObjectIdentifier("2.5.4.46").intern();
        dnQualifier = r107;
        ASN1ObjectIdentifier r108 = new ASN1ObjectIdentifier("2.5.4.47").intern();
        enhancedSearchGuide = r108;
        ASN1ObjectIdentifier r109 = new ASN1ObjectIdentifier("2.5.4.23").intern();
        facsimileTelephoneNumber = r109;
        ASN1ObjectIdentifier r110 = new ASN1ObjectIdentifier("2.5.4.44").intern();
        generationQualifier = r110;
        ASN1ObjectIdentifier r111 = new ASN1ObjectIdentifier("2.5.4.42").intern();
        givenName = r111;
        ASN1ObjectIdentifier r112 = new ASN1ObjectIdentifier("2.5.4.51").intern();
        houseIdentifier = r112;
        ASN1ObjectIdentifier r113 = new ASN1ObjectIdentifier("2.5.4.43").intern();
        initials = r113;
        ASN1ObjectIdentifier r114 = new ASN1ObjectIdentifier("2.5.4.25").intern();
        internationalISDNNumber = r114;
        ASN1ObjectIdentifier r115 = new ASN1ObjectIdentifier("2.5.4.7").intern();
        f525074l = r115;
        ASN1ObjectIdentifier r116 = new ASN1ObjectIdentifier("2.5.4.31").intern();
        member = r116;
        ASN1ObjectIdentifier r117 = new ASN1ObjectIdentifier("2.5.4.41").intern();
        name = r117;
        ASN1ObjectIdentifier r118 = new ASN1ObjectIdentifier("2.5.4.10").intern();
        f525075o = r118;
        ASN1ObjectIdentifier r119 = new ASN1ObjectIdentifier("2.5.4.11").intern();
        f525076ou = r119;
        ASN1ObjectIdentifier r120 = new ASN1ObjectIdentifier("2.5.4.32").intern();
        owner = r120;
        ASN1ObjectIdentifier r121 = new ASN1ObjectIdentifier("2.5.4.19").intern();
        physicalDeliveryOfficeName = r121;
        ASN1ObjectIdentifier r122 = new ASN1ObjectIdentifier("2.5.4.16").intern();
        postalAddress = r122;
        ASN1ObjectIdentifier r123 = new ASN1ObjectIdentifier("2.5.4.17").intern();
        postalCode = r123;
        ASN1ObjectIdentifier r124 = new ASN1ObjectIdentifier("2.5.4.18").intern();
        postOfficeBox = r124;
        ASN1ObjectIdentifier r125 = new ASN1ObjectIdentifier("2.5.4.28").intern();
        preferredDeliveryMethod = r125;
        ASN1ObjectIdentifier r126 = new ASN1ObjectIdentifier("2.5.4.26").intern();
        registeredAddress = r126;
        ASN1ObjectIdentifier r127 = new ASN1ObjectIdentifier("2.5.4.33").intern();
        roleOccupant = r127;
        ASN1ObjectIdentifier r128 = new ASN1ObjectIdentifier("2.5.4.14").intern();
        searchGuide = r128;
        ASN1ObjectIdentifier r129 = new ASN1ObjectIdentifier("2.5.4.34").intern();
        seeAlso = r129;
        ASN1ObjectIdentifier r130 = new ASN1ObjectIdentifier("2.5.4.5").intern();
        serialNumber = r130;
        ASN1ObjectIdentifier r131 = new ASN1ObjectIdentifier("2.5.4.4").intern();
        f525077sn = r131;
        ASN1ObjectIdentifier r132 = new ASN1ObjectIdentifier("2.5.4.8").intern();
        f525078st = r132;
        ASN1ObjectIdentifier r133 = new ASN1ObjectIdentifier("2.5.4.9").intern();
        street = r133;
        ASN1ObjectIdentifier r134 = new ASN1ObjectIdentifier("2.5.4.20").intern();
        telephoneNumber = r134;
        ASN1ObjectIdentifier r135 = new ASN1ObjectIdentifier("2.5.4.22").intern();
        teletexTerminalIdentifier = r135;
        ASN1ObjectIdentifier r136 = new ASN1ObjectIdentifier("2.5.4.21").intern();
        telexNumber = r136;
        ASN1ObjectIdentifier r137 = new ASN1ObjectIdentifier("2.5.4.12").intern();
        title = r137;
        ASN1ObjectIdentifier r138 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1").intern();
        uid = r138;
        ASN1ObjectIdentifier r139 = new ASN1ObjectIdentifier("2.5.4.50").intern();
        uniqueMember = r139;
        ASN1ObjectIdentifier r140 = new ASN1ObjectIdentifier("2.5.4.35").intern();
        userPassword = r140;
        ASN1ObjectIdentifier r141 = new ASN1ObjectIdentifier("2.5.4.24").intern();
        x121Address = r141;
        ASN1ObjectIdentifier r142 = new ASN1ObjectIdentifier("2.5.4.45").intern();
        x500UniqueIdentifier = r142;
        Hashtable r143 = new Hashtable();
        DefaultSymbols = r143;
        Hashtable r144 = new Hashtable();
        DefaultLookUp = r144;
        r143.put(r100, "businessCategory");
        r143.put(r101, "c");
        r143.put(r102, "cn");
        r143.put(r103, "dc");
        r143.put(r104, "description");
        r143.put(r105, "destinationIndicator");
        r143.put(r106, "distinguishedName");
        r143.put(r107, "dnQualifier");
        r143.put(r108, "enhancedSearchGuide");
        r143.put(r109, "facsimileTelephoneNumber");
        r143.put(r110, "generationQualifier");
        r143.put(r111, CommonConstant.KEY_GIVEN_NAME);
        r143.put(r112, "houseIdentifier");
        r143.put(r113, "initials");
        r143.put(r114, "internationalISDNNumber");
        r143.put(r115, "l");
        r143.put(r116, "member");
        r143.put(r117, "name");
        r143.put(r118, "o");
        r143.put(r119, "ou");
        r143.put(r120, "owner");
        r143.put(r121, "physicalDeliveryOfficeName");
        r143.put(r122, HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS);
        r143.put(r123, HintConstants.AUTOFILL_HINT_POSTAL_CODE);
        r143.put(r124, "postOfficeBox");
        r143.put(r125, "preferredDeliveryMethod");
        r143.put(r126, "registeredAddress");
        r143.put(r127, "roleOccupant");
        r143.put(r128, "searchGuide");
        r143.put(r129, "seeAlso");
        r143.put(r130, "serialNumber");
        r143.put(r131, "sn");
        r143.put(r132, Segment.JsonKey.START);
        r143.put(r133, "street");
        r143.put(r134, "telephoneNumber");
        r143.put(r135, "teletexTerminalIdentifier");
        r143.put(r136, "telexNumber");
        r143.put(r137, "title");
        r143.put(r138, "uid");
        r143.put(r139, "uniqueMember");
        r143.put(r140, "userPassword");
        r143.put(r141, "x121Address");
        r143.put(r142, "x500UniqueIdentifier");
        r144.put("businesscategory", r100);
        r144.put("c", r101);
        r144.put("cn", r102);
        r144.put("dc", r103);
        r144.put("description", r104);
        r144.put("destinationindicator", r105);
        r144.put("distinguishedname", r106);
        r144.put("dnqualifier", r107);
        r144.put("enhancedsearchguide", r108);
        r144.put("facsimiletelephonenumber", r109);
        r144.put("generationqualifier", r110);
        r144.put("givenname", r111);
        r144.put("houseidentifier", r112);
        r144.put("initials", r113);
        r144.put("internationalisdnnumber", r114);
        r144.put("l", r115);
        r144.put("member", r116);
        r144.put("name", r117);
        r144.put("o", r118);
        r144.put("ou", r119);
        r144.put("owner", r120);
        r144.put("physicaldeliveryofficename", r121);
        r144.put("postaladdress", r122);
        r144.put("postalcode", r123);
        r144.put("postofficebox", r124);
        r144.put("preferreddeliverymethod", r125);
        r144.put("registeredaddress", r126);
        r144.put("roleoccupant", r127);
        r144.put("searchguide", r128);
        r144.put("seealso", r129);
        r144.put("serialnumber", r130);
        r144.put("sn", r131);
        r144.put(Segment.JsonKey.START, r132);
        r144.put("street", r133);
        r144.put("telephonenumber", r134);
        r144.put("teletexterminalidentifier", r135);
        r144.put("telexnumber", r136);
        r144.put("title", r137);
        r144.put("uid", r138);
        r144.put("uniquemember", r139);
        r144.put("userpassword", r140);
        r144.put("x121address", r141);
        r144.put("x500uniqueidentifier", r142);
        INSTANCE = new RFC4519Style();
    }

    public RFC4519Style() {
        this.defaultSymbols = AbstractX500NameStyle.copyHashTable(DefaultSymbols);
        this.defaultLookUp = AbstractX500NameStyle.copyHashTable(DefaultLookUp);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public ASN1ObjectIdentifier attrNameToOID(String r100) {
        return IETFUtils.decodeAttrName(r100, this.defaultLookUp);
    }

    @Override // org.bouncycastle.asn1.x500.style.AbstractX500NameStyle
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier r100, String r101) {
        if (r100.equals(f525073dc) == false) goto L7;
        return new DERIA5String(r101);
    L7:
        if (r100.equals(f525071c) == true) goto L18;
        if (r100.equals(serialNumber) == true) goto L18;
        if (r100.equals(dnQualifier) == true) goto L18;
        if (r100.equals(telephoneNumber) == true) goto L18;
        return super.encodeStringValue(r100, r101);
    L18:
        return new DERPrintableString(r101);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public RDN[] fromString(String r100) {
        RDN[] r101 = IETFUtils.rDNsFromString(r100, this);
        int r102 = r101.length;
        RDN[] r103 = new RDN[r102];
        int r104 = 0;
    L4:
        if (r104 == r101.length) goto L6;
        r103[(r102 - r104) - 1] = r101[r104];
        r104 = r104 + 1;
        goto L4
    L6:
        return r103;
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
        int r104 = r102.length - 1;
    L3:
        if (r104 < 0) goto L9;
        if (r103 == false) goto L6;
        r103 = false;
    L7:
        IETFUtils.appendRDN(r101, r102[r104], this.defaultSymbols);
        r104 = r104 - 1;
        goto L3
    L6:
        r101.append(',');
        goto L7
    L9:
        return r101.toString();
    }
}
