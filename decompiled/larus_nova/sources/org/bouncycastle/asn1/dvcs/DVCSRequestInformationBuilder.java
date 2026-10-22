package org.bouncycastle.asn1.dvcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class DVCSRequestInformationBuilder {
    private static final int DEFAULT_VERSION = 1;
    private static final int TAG_DATA_LOCATIONS = 3;
    private static final int TAG_DVCS = 2;
    private static final int TAG_EXTENSIONS = 4;
    private static final int TAG_REQUESTER = 0;
    private static final int TAG_REQUEST_POLICY = 1;
    private GeneralNames dataLocations;
    private GeneralNames dvcs;
    private Extensions extensions;
    private DVCSRequestInformation initialInfo;
    private BigInteger nonce;
    private PolicyInformation requestPolicy;
    private DVCSTime requestTime;
    private GeneralNames requester;
    private final ServiceType service;
    private int version;

    public DVCSRequestInformationBuilder(DVCSRequestInformation r100) {
        this.version = 1;
        this.initialInfo = r100;
        this.service = r100.getService();
        this.version = r100.getVersion();
        this.nonce = r100.getNonce();
        this.requestTime = r100.getRequestTime();
        this.requestPolicy = r100.getRequestPolicy();
        this.dvcs = r100.getDVCS();
        this.dataLocations = r100.getDataLocations();
    }

    public DVCSRequestInformationBuilder(ServiceType r100) {
        this.version = 1;
        this.service = r100;
    }

    public DVCSRequestInformation build() {
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
        return DVCSRequestInformation.getInstance(new DERSequence(r100));
    }

    public void setDVCS(GeneralName r100) {
        setDVCS(new GeneralNames(r100));
    }

    public void setDVCS(GeneralNames r100) {
        this.dvcs = r100;
    }

    public void setDataLocations(GeneralName r100) {
        setDataLocations(new GeneralNames(r100));
    }

    public void setDataLocations(GeneralNames r100) {
        this.dataLocations = r100;
    }

    public void setExtensions(Extensions r100) {
        if (this.initialInfo != null) goto L7;
        this.extensions = r100;
        return;
    L7:
        throw new IllegalStateException("cannot change extensions in existing DVCSRequestInformation");
    }

    public void setNonce(BigInteger r100) {
        DVCSRequestInformation r101 = this.initialInfo;
        if (r101 != null) goto L5;
    L8:
        this.nonce = r100;
        return;
    L5:
        if (r101.getNonce() != null) goto L7;
        this.nonce = r100;
        goto L8
    L7:
        byte[] r102 = this.initialInfo.getNonce().toByteArray();
        byte[] r103 = BigIntegers.asUnsignedByteArray(r100);
        byte[] r104 = new byte[r102.length + r103.length];
        System.arraycopy(r102, 0, r104, 0, r102.length);
        System.arraycopy(r103, 0, r104, r102.length, r103.length);
        this.nonce = new BigInteger(r104);
        goto L8
    }

    public void setRequestPolicy(PolicyInformation r100) {
        if (this.initialInfo != null) goto L7;
        this.requestPolicy = r100;
        return;
    L7:
        throw new IllegalStateException("cannot change request policy in existing DVCSRequestInformation");
    }

    public void setRequestTime(DVCSTime r100) {
        if (this.initialInfo != null) goto L7;
        this.requestTime = r100;
        return;
    L7:
        throw new IllegalStateException("cannot change request time in existing DVCSRequestInformation");
    }

    public void setRequester(GeneralName r100) {
        setRequester(new GeneralNames(r100));
    }

    public void setRequester(GeneralNames r100) {
        this.requester = r100;
    }

    public void setVersion(int r100) {
        if (this.initialInfo != null) goto L7;
        this.version = r100;
        return;
    L7:
        throw new IllegalStateException("cannot change version in existing DVCSRequestInformation");
    }
}
