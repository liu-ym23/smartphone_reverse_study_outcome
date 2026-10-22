package org.bouncycastle.asn1.eac;

import java.io.IOException;
import java.util.Hashtable;
import kotlin.UByte;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class CertificateHolderAuthorization extends ASN1Object {
    static BidirectionalMap AuthorizationRole = null;
    public static final int CVCA = 192;
    public static final int DV_DOMESTIC = 128;
    public static final int DV_FOREIGN = 64;
    public static final int IS = 0;
    public static final int RADG3 = 1;
    public static final int RADG4 = 2;
    static Hashtable ReverseMap;
    static Hashtable RightsDecodeMap;
    public static final ASN1ObjectIdentifier id_role_EAC = null;
    ASN1ApplicationSpecific accessRights;
    ASN1ObjectIdentifier oid;

    static {
        id_role_EAC = EACObjectIdentifiers.bsi_de.branch("3.1.2.1");
        RightsDecodeMap = new Hashtable();
        AuthorizationRole = new BidirectionalMap();
        ReverseMap = new Hashtable();
        RightsDecodeMap.put(Integers.valueOf(2), "RADG4");
        RightsDecodeMap.put(Integers.valueOf(1), "RADG3");
        AuthorizationRole.put(Integers.valueOf(192), "CVCA");
        AuthorizationRole.put(Integers.valueOf(128), "DV_DOMESTIC");
        AuthorizationRole.put(Integers.valueOf(64), "DV_FOREIGN");
        AuthorizationRole.put(Integers.valueOf(0), "IS");
    }

    public CertificateHolderAuthorization(ASN1ApplicationSpecific r100) throws IOException {
        if (r100.getApplicationTag() != 76) goto L6;
        setPrivateData(new ASN1InputStream(r100.getContents()));
        return;
    }

    public CertificateHolderAuthorization(ASN1ObjectIdentifier r100, int r101) throws IOException {
        setOid(r100);
        setAccessRights((byte) r101);
    }

    public static int getFlag(String r100) {
        Integer r101 = (Integer) AuthorizationRole.getReverse(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        throw new IllegalArgumentException("Unknown value " + r100);
    }

    public static String getRoleDescription(int r100) {
        return (String) AuthorizationRole.get(Integers.valueOf(r100));
    }

    private void setAccessRights(byte r100) {
        this.accessRights = new DERApplicationSpecific(19, new byte[]{r100});
    }

    private void setOid(ASN1ObjectIdentifier r100) {
        this.oid = r100;
    }

    private void setPrivateData(ASN1InputStream r100) throws IOException {
        ASN1Primitive r101 = r100.readObject();
        if ((r101 instanceof ASN1ObjectIdentifier) == false) goto L11;
        this.oid = (ASN1ObjectIdentifier) r101;
        ASN1Primitive r102 = r100.readObject();
        if ((r102 instanceof ASN1ApplicationSpecific) == false) goto L9;
        this.accessRights = (ASN1ApplicationSpecific) r102;
        return;
    L9:
        throw new IllegalArgumentException("No access rights in CerticateHolderAuthorization");
    L11:
        throw new IllegalArgumentException("no Oid in CerticateHolderAuthorization");
    }

    public int getAccessRights() {
        return this.accessRights.getContents()[0] & UByte.MAX_VALUE;
    }

    public ASN1ObjectIdentifier getOid() {
        return this.oid;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.oid);
        r100.add(this.accessRights);
        return new DERApplicationSpecific(76, r100);
    }
}
