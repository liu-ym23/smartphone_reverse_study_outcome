package org.bouncycastle.asn1.icao;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class LDSSecurityObject extends ASN1Object implements ICAOObjectIdentifiers {
    public static final int ub_DataGroups = 16;
    private DataGroupHash[] datagroupHash;
    private AlgorithmIdentifier digestAlgorithmIdentifier;
    private ASN1Integer version;
    private LDSVersionInfo versionInfo;

    private LDSSecurityObject(ASN1Sequence r100) {
        this.version = new ASN1Integer(0);
        if (r100 == null) goto L15;
        if (r100.size() == 0) goto L15;
        Enumeration r101 = r100.getObjects();
        this.version = ASN1Integer.getInstance(r101.nextElement());
        this.digestAlgorithmIdentifier = AlgorithmIdentifier.getInstance(r101.nextElement());
        ASN1Sequence r102 = ASN1Sequence.getInstance(r101.nextElement());
        if (this.version.intValueExact() != 1) goto L9;
        this.versionInfo = LDSVersionInfo.getInstance(r101.nextElement());
    L9:
        checkDatagroupHashSeqSize(r102.size());
        this.datagroupHash = new DataGroupHash[r102.size()];
        int r103 = 0;
    L11:
        if (r103 >= r102.size()) goto L13;
        this.datagroupHash[r103] = DataGroupHash.getInstance(r102.getObjectAt(r103));
        r103 = r103 + 1;
        goto L11
    L13:
        return;
    L15:
        throw new IllegalArgumentException("null or empty sequence passed.");
    }

    public LDSSecurityObject(AlgorithmIdentifier r100, DataGroupHash[] r101) {
        this.version = new ASN1Integer(0);
        this.version = new ASN1Integer(0);
        this.digestAlgorithmIdentifier = r100;
        this.datagroupHash = copy(r101);
        checkDatagroupHashSeqSize(r101.length);
    }

    public LDSSecurityObject(AlgorithmIdentifier r100, DataGroupHash[] r101, LDSVersionInfo r102) {
        this.version = new ASN1Integer(0);
        this.version = new ASN1Integer(1);
        this.digestAlgorithmIdentifier = r100;
        this.datagroupHash = copy(r101);
        this.versionInfo = r102;
        checkDatagroupHashSeqSize(r101.length);
    }

    private void checkDatagroupHashSeqSize(int r100) {
        if (r100 < 2) goto L8;
        if (r100 > 16) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("wrong size in DataGroupHashValues : not in (2..16)");
    }

    private DataGroupHash[] copy(DataGroupHash[] r100) {
        int r101 = r100.length;
        DataGroupHash[] r102 = new DataGroupHash[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    public static LDSSecurityObject getInstance(Object r100) {
        if ((r100 instanceof LDSSecurityObject) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new LDSSecurityObject(ASN1Sequence.getInstance(r100));
    L5:
        return (LDSSecurityObject) r100;
    }

    public DataGroupHash[] getDatagroupHash() {
        return copy(this.datagroupHash);
    }

    public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
        return this.digestAlgorithmIdentifier;
    }

    public int getVersion() {
        return this.version.intValueExact();
    }

    public LDSVersionInfo getVersionInfo() {
        return this.versionInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.version);
        r100.add(this.digestAlgorithmIdentifier);
        r100.add(new DERSequence(this.datagroupHash));
        LDSVersionInfo r101 = this.versionInfo;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
