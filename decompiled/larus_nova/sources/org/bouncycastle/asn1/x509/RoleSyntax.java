package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class RoleSyntax extends ASN1Object {
    private GeneralNames roleAuthority;
    private GeneralName roleName;

    public RoleSyntax(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this(new GeneralName(6, r100));
    }

    private RoleSyntax(ASN1Sequence r100) {
        if (r100.size() < 1) goto L19;
        if (r100.size() > 2) goto L19;
        int r101 = 0;
    L8:
        if (r101 == r100.size()) goto L17;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r100.getObjectAt(r101));
        int r103 = r102.getTagNo();
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        this.roleName = GeneralName.getInstance(r102, true);
    L16:
        r101 = r101 + 1;
        goto L8
    L14:
        throw new IllegalArgumentException("Unknown tag in RoleSyntax");
    L15:
        this.roleAuthority = GeneralNames.getInstance(r102, false);
        goto L16
    L17:
        return;
    L19:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public RoleSyntax(GeneralName r100) {
        this(null, r100);
    }

    public RoleSyntax(GeneralNames r100, GeneralName r101) {
        if (r101 == null) goto L11;
        if (r101.getTagNo() != 6) goto L11;
        if (((ASN1String) r101.getName()).getString().equals("") == true) goto L11;
        this.roleAuthority = r100;
        this.roleName = r101;
        return;
    L11:
        throw new IllegalArgumentException("the role name MUST be non empty and MUST use the URI option of GeneralName");
    }

    public static RoleSyntax getInstance(Object r100) {
        if ((r100 instanceof RoleSyntax) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RoleSyntax(ASN1Sequence.getInstance(r100));
    L5:
        return (RoleSyntax) r100;
    }

    public GeneralNames getRoleAuthority() {
        return this.roleAuthority;
    }

    public String[] getRoleAuthorityAsString() {
        GeneralNames r100 = this.roleAuthority;
        int r101 = 0;
        if (r100 == null) goto L5;
        GeneralName[] r102 = r100.getNames();
        String[] r103 = new String[r102.length];
    L8:
        if (r101 >= r102.length) goto L14;
        ASN1Encodable r104 = r102[r101].getName();
        if ((r104 instanceof ASN1String) == false) goto L12;
        r103[r101] = ((ASN1String) r104).getString();
    L13:
        r101 = r101 + 1;
        goto L8
    L12:
        r103[r101] = r104.toString();
        goto L13
    L14:
        return r103;
    L5:
        return new String[0];
    }

    public GeneralName getRoleName() {
        return this.roleName;
    }

    public String getRoleNameAsString() {
        return ((ASN1String) this.roleName.getName()).getString();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        GeneralNames r101 = this.roleAuthority;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, r101));
    L5:
        r100.add(new DERTaggedObject(true, 1, this.roleName));
        return new DERSequence(r100);
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("Name: " + getRoleNameAsString() + " - Auth: ");
        GeneralNames r101 = this.roleAuthority;
        if (r101 != null) goto L5;
    L12:
        r100.append("N/A");
    L14:
        return r100.toString();
    L5:
        if (r101.getNames().length == 0) goto L12;
        String[] r102 = getRoleAuthorityAsString();
        r100.append('[');
        r100.append(r102[0]);
        int r103 = 1;
    L9:
        if (r103 >= r102.length) goto L11;
        r100.append(", ");
        r100.append(r102[r103]);
        r103 = r103 + 1;
        goto L9
    L11:
        r100.append(']');
        goto L14
    }
}
