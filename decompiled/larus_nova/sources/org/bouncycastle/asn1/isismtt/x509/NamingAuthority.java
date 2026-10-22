package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.bouncycastle.asn1.x500.DirectoryString;

/* JADX INFO: loaded from: classes42.dex */
public class NamingAuthority extends ASN1Object {
    public static final ASN1ObjectIdentifier id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern = null;
    private ASN1ObjectIdentifier namingAuthorityId;
    private DirectoryString namingAuthorityText;
    private String namingAuthorityUrl;

    static {
        id_isismtt_at_namingAuthorities_RechtWirtschaftSteuern = new ASN1ObjectIdentifier(ISISMTTObjectIdentifiers.id_isismtt_at_namingAuthorities + ".1");
    }

    public NamingAuthority(ASN1ObjectIdentifier r100, String r101, DirectoryString r102) {
        this.namingAuthorityId = r100;
        this.namingAuthorityUrl = r101;
        this.namingAuthorityText = r102;
    }

    private NamingAuthority(ASN1Sequence r100) {
        if (r100.size() > 3) goto L36;
        Enumeration r101 = r100.getObjects();
        if (r101.hasMoreElements() == false) goto L18;
        ASN1Encodable r102 = (ASN1Encodable) r101.nextElement();
        if ((r102 instanceof ASN1ObjectIdentifier) == false) goto L10;
        this.namingAuthorityId = (ASN1ObjectIdentifier) r102;
        goto L18
    L10:
        if ((r102 instanceof DERIA5String) == false) goto L13;
        this.namingAuthorityUrl = DERIA5String.getInstance(r102).getString();
        goto L18
    L13:
        if ((r102 instanceof ASN1String) == false) goto L16;
        this.namingAuthorityText = DirectoryString.getInstance(r102);
        goto L18
    L16:
        throw new IllegalArgumentException("Bad object encountered: " + r102.getClass());
    L18:
        if (r101.hasMoreElements() == false) goto L28;
        ASN1Encodable r103 = (ASN1Encodable) r101.nextElement();
        if ((r103 instanceof DERIA5String) == false) goto L23;
        this.namingAuthorityUrl = DERIA5String.getInstance(r103).getString();
        goto L28
    L23:
        if ((r103 instanceof ASN1String) == false) goto L26;
        this.namingAuthorityText = DirectoryString.getInstance(r103);
        goto L28
    L26:
        throw new IllegalArgumentException("Bad object encountered: " + r103.getClass());
    L28:
        if (r101.hasMoreElements() == false) goto L34;
        ASN1Encodable r104 = (ASN1Encodable) r101.nextElement();
        if ((r104 instanceof ASN1String) == false) goto L33;
        this.namingAuthorityText = DirectoryString.getInstance(r104);
        return;
    L33:
        throw new IllegalArgumentException("Bad object encountered: " + r104.getClass());
    L34:
        return;
    L36:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static NamingAuthority getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof NamingAuthority) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new NamingAuthority((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L13:
        return (NamingAuthority) r100;
    }

    public static NamingAuthority getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1ObjectIdentifier getNamingAuthorityId() {
        return this.namingAuthorityId;
    }

    public DirectoryString getNamingAuthorityText() {
        return this.namingAuthorityText;
    }

    public String getNamingAuthorityUrl() {
        return this.namingAuthorityUrl;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        ASN1ObjectIdentifier r101 = this.namingAuthorityId;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        String r102 = this.namingAuthorityUrl;
        if (r102 == null) goto L8;
        r100.add(new DERIA5String(r102, true));
    L8:
        DirectoryString r103 = this.namingAuthorityText;
        if (r103 == null) goto L12;
        r100.add(r103);
    L12:
        return new DERSequence(r100);
    }
}
