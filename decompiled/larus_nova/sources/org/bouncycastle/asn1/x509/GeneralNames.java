package org.bouncycastle.asn1.x509;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class GeneralNames extends ASN1Object {
    private final GeneralName[] names;

    private GeneralNames(ASN1Sequence r100) {
        this.names = new GeneralName[r100.size()];
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L6;
        this.names[r101] = GeneralName.getInstance(r100.getObjectAt(r101));
        r101 = r101 + 1;
        goto L4
    }

    public GeneralNames(GeneralName r100) {
        this.names = new GeneralName[]{r100};
    }

    public GeneralNames(GeneralName[] r100) {
        this.names = copy(r100);
    }

    private static GeneralName[] copy(GeneralName[] r100) {
        GeneralName[] r101 = new GeneralName[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static GeneralNames fromExtensions(Extensions r100, ASN1ObjectIdentifier r101) {
        return getInstance(Extensions.getExtensionParsedValue(r100, r101));
    }

    public static GeneralNames getInstance(Object r100) {
        if ((r100 instanceof GeneralNames) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GeneralNames(ASN1Sequence.getInstance(r100));
    L5:
        return (GeneralNames) r100;
    }

    public static GeneralNames getInstance(ASN1TaggedObject r100, boolean r101) {
        return new GeneralNames(ASN1Sequence.getInstance(r100, r101));
    }

    public GeneralName[] getNames() {
        return copy(this.names);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.names);
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("GeneralNames:");
        String r101 = Strings.lineSeparator();
        r100.append(r101);
        int r102 = 0;
    L4:
        if (r102 == this.names.length) goto L7;
        r100.append(LineContent.FOUR_SPACE);
        r100.append(this.names[r102]);
        r100.append(r101);
        r102 = r102 + 1;
        goto L4
    L7:
        return r100.toString();
    }
}
