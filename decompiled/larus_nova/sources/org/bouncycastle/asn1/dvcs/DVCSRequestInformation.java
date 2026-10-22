package org.bouncycastle.asn1.dvcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.PolicyInformation;

/* JADX INFO: loaded from: classes42.dex */
public class DVCSRequestInformation extends ASN1Object {
    private static final int DEFAULT_VERSION = 1;
    private static final int TAG_DATA_LOCATIONS = 3;
    private static final int TAG_DVCS = 2;
    private static final int TAG_EXTENSIONS = 4;
    private static final int TAG_REQUESTER = 0;
    private static final int TAG_REQUEST_POLICY = 1;
    private GeneralNames dataLocations;
    private GeneralNames dvcs;
    private Extensions extensions;
    private BigInteger nonce;
    private PolicyInformation requestPolicy;
    private DVCSTime requestTime;
    private GeneralNames requester;
    private ServiceType service;
    private int version;

    private DVCSRequestInformation(ASN1Sequence r100) {
        this.version = 1;
        if ((r100.getObjectAt(0) instanceof ASN1Integer) == false) goto L5;
        this.version = ASN1Integer.getInstance(r100.getObjectAt(0)).intValueExact();
        int r101 = 1;
    L6:
        int r102 = r101 + 1;
        this.service = ServiceType.getInstance(r100.getObjectAt(r101));
    L8:
        if (r102 >= r100.size()) goto L34;
        ASN1Encodable r103 = r100.getObjectAt(r102);
        if ((r103 instanceof ASN1Integer) == false) goto L13;
        this.nonce = ASN1Integer.getInstance(r103).getValue();
    L33:
        r102 = r102 + 1;
        goto L8
    L13:
        if ((r103 instanceof ASN1GeneralizedTime) == false) goto L16;
    L14:
        this.requestTime = DVCSTime.getInstance(r103);
        goto L33
    L16:
        if ((r103 instanceof ASN1TaggedObject) == false) goto L14;
        ASN1TaggedObject r104 = ASN1TaggedObject.getInstance(r103);
        int r105 = r104.getTagNo();
        if (r105 == 0) goto L32;
        if (r105 != 1) goto L21;
        this.requestPolicy = PolicyInformation.getInstance(ASN1Sequence.getInstance(r104, false));
        goto L33
    L21:
        if (r105 != 2) goto L23;
        this.dvcs = GeneralNames.getInstance(r104, false);
        goto L33
    L23:
        if (r105 != 3) goto L25;
        this.dataLocations = GeneralNames.getInstance(r104, false);
        goto L33
    L25:
        if (r105 != 4) goto L28;
        this.extensions = Extensions.getInstance(r104, false);
        goto L33
    L28:
        throw new IllegalArgumentException("unknown tag number encountered: " + r105);
    L32:
        this.requester = GeneralNames.getInstance(r104, false);
        goto L33
    L34:
        return;
    L5:
        this.version = 1;
        r101 = 0;
        goto L6
    }

    public static DVCSRequestInformation getInstance(Object r100) {
        if ((r100 instanceof DVCSRequestInformation) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new DVCSRequestInformation(ASN1Sequence.getInstance(r100));
    L5:
        return (DVCSRequestInformation) r100;
    }

    public static DVCSRequestInformation getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public GeneralNames getDVCS() {
        return this.dvcs;
    }

    public GeneralNames getDataLocations() {
        return this.dataLocations;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public BigInteger getNonce() {
        return this.nonce;
    }

    public PolicyInformation getRequestPolicy() {
        return this.requestPolicy;
    }

    public DVCSTime getRequestTime() {
        return this.requestTime;
    }

    public GeneralNames getRequester() {
        return this.requester;
    }

    public ServiceType getService() {
        return this.service;
    }

    public int getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(9);
        int r101 = this.version;
        if (r101 == 1) goto L5;
        r100.add(new ASN1Integer(r101));
    L5:
        r100.add(this.service);
        BigInteger r102 = this.nonce;
        if (r102 == null) goto L8;
        r100.add(new ASN1Integer(r102));
    L8:
        DVCSTime r103 = this.requestTime;
        if (r103 == null) goto L11;
        r100.add(r103);
    L11:
        int[] r104 = {0, 1, 2, 3, 4};
        ASN1Encodable[] r105 = {this.requester, this.requestPolicy, this.dvcs, this.dataLocations, this.extensions};
        int r106 = 0;
    L12:
        if (r106 >= 5) goto L18;
        int r107 = r104[r106];
        ASN1Encodable r108 = r105[r106];
        if (r108 == null) goto L16;
        r100.add(new DERTaggedObject(false, r107, r108));
    L16:
        r106 = r106 + 1;
        goto L12
    L18:
        return new DERSequence(r100);
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("DVCSRequestInformation {\n");
        if (this.version == 1) goto L5;
        r100.append("version: " + this.version + "\n");
    L5:
        r100.append("service: " + this.service + "\n");
        if (this.nonce == null) goto L9;
        r100.append("nonce: " + this.nonce + "\n");
    L9:
        if (this.requestTime == null) goto L12;
        r100.append("requestTime: " + this.requestTime + "\n");
    L12:
        if (this.requester == null) goto L15;
        r100.append("requester: " + this.requester + "\n");
    L15:
        if (this.requestPolicy == null) goto L18;
        r100.append("requestPolicy: " + this.requestPolicy + "\n");
    L18:
        if (this.dvcs == null) goto L21;
        r100.append("dvcs: " + this.dvcs + "\n");
    L21:
        if (this.dataLocations == null) goto L24;
        r100.append("dataLocations: " + this.dataLocations + "\n");
    L24:
        if (this.extensions == null) goto L26;
        r100.append("extensions: " + this.extensions + "\n");
    L26:
        r100.append("}\n");
        return r100.toString();
    }
}
