package org.bouncycastle.asn1.cmc;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class CertificationRequest extends ASN1Object {
    private static final ASN1Integer ZERO = null;
    private final CertificationRequestInfo certificationRequestInfo;
    private final DERBitString signature;
    private final AlgorithmIdentifier signatureAlgorithm;

    /* JADX INFO: renamed from: org.bouncycastle.asn1.cmc.CertificationRequest$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class CertificationRequestInfo extends ASN1Object {
        private final ASN1Set attributes;
        private final X500Name subject;
        private final ASN1Sequence subjectPublicKeyInfo;
        final /* synthetic */ CertificationRequest this$0;
        private final ASN1Integer version;

        private CertificationRequestInfo(CertificationRequest r100, ASN1Sequence r101) {
            this.this$0 = r100;
            if (r101.size() != 4) goto L15;
            this.version = ASN1Integer.getInstance(r101.getObjectAt(0));
            this.subject = X500Name.getInstance(r101.getObjectAt(1));
            ASN1Sequence r102 = ASN1Sequence.getInstance(r101.getObjectAt(2));
            this.subjectPublicKeyInfo = r102;
            if (r102.size() != 2) goto L13;
            ASN1TaggedObject r103 = (ASN1TaggedObject) r101.getObjectAt(3);
            if (r103.getTagNo() != 0) goto L11;
            this.attributes = ASN1Set.getInstance(r103, false);
            return;
        L11:
            throw new IllegalArgumentException("incorrect tag number on attributes for CertificationRequestInfo");
        L13:
            throw new IllegalArgumentException("incorrect subjectPublicKeyInfo size for CertificationRequestInfo");
        L15:
            throw new IllegalArgumentException("incorrect sequence size for CertificationRequestInfo");
        }

        public /* synthetic */ CertificationRequestInfo(CertificationRequest r100, ASN1Sequence r101, AnonymousClass1 r102) {
            this(r100, r101);
        }

        private CertificationRequestInfo(CertificationRequest r100, X500Name r101, AlgorithmIdentifier r102, DERBitString r103, ASN1Set r104) {
            this.this$0 = r100;
            this.version = CertificationRequest.access$600();
            this.subject = r101;
            this.subjectPublicKeyInfo = new DERSequence(new ASN1Encodable[]{r102, r103});
            this.attributes = r104;
        }

        public /* synthetic */ CertificationRequestInfo(CertificationRequest r100, X500Name r101, AlgorithmIdentifier r102, DERBitString r103, ASN1Set r104, AnonymousClass1 r105) {
            this(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ ASN1Integer access$200(CertificationRequestInfo r100) {
            return r100.getVersion();
        }

        public static /* synthetic */ X500Name access$300(CertificationRequestInfo r100) {
            return r100.getSubject();
        }

        public static /* synthetic */ ASN1Set access$400(CertificationRequestInfo r100) {
            return r100.getAttributes();
        }

        public static /* synthetic */ ASN1Sequence access$500(CertificationRequestInfo r100) {
            return r100.getSubjectPublicKeyInfo();
        }

        private ASN1Set getAttributes() {
            return this.attributes;
        }

        private X500Name getSubject() {
            return this.subject;
        }

        private ASN1Sequence getSubjectPublicKeyInfo() {
            return this.subjectPublicKeyInfo;
        }

        private ASN1Integer getVersion() {
            return this.version;
        }

        @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            ASN1EncodableVector r100 = new ASN1EncodableVector(4);
            r100.add(this.version);
            r100.add(this.subject);
            r100.add(this.subjectPublicKeyInfo);
            r100.add(new DERTaggedObject(false, 0, this.attributes));
            return new DERSequence(r100);
        }
    }

    static {
        ZERO = new ASN1Integer(0);
    }

    private CertificationRequest(ASN1Sequence r100) {
        if (r100.size() != 3) goto L7;
        this.certificationRequestInfo = new CertificationRequestInfo(this, ASN1Sequence.getInstance(r100.getObjectAt(0)), null);
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(1));
        this.signature = DERBitString.getInstance(r100.getObjectAt(2));
        return;
    L7:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public CertificationRequest(X500Name r100, AlgorithmIdentifier r110, DERBitString r111, ASN1Set r112, AlgorithmIdentifier r113, DERBitString r114) {
        this.certificationRequestInfo = new CertificationRequestInfo(this, r100, r110, r111, r112, null);
        this.signatureAlgorithm = r113;
        this.signature = r114;
    }

    public static /* synthetic */ ASN1Integer access$600() {
        return ZERO;
    }

    public static CertificationRequest getInstance(Object r100) {
        if ((r100 instanceof CertificationRequest) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertificationRequest(ASN1Sequence.getInstance(r100));
    L5:
        return (CertificationRequest) r100;
    }

    public ASN1Set getAttributes() {
        return CertificationRequestInfo.access$400(this.certificationRequestInfo);
    }

    public DERBitString getSignature() {
        return this.signature;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public X500Name getSubject() {
        return CertificationRequestInfo.access$300(this.certificationRequestInfo);
    }

    public DERBitString getSubjectPublicKey() {
        return DERBitString.getInstance(CertificationRequestInfo.access$500(this.certificationRequestInfo).getObjectAt(1));
    }

    public AlgorithmIdentifier getSubjectPublicKeyAlgorithm() {
        return AlgorithmIdentifier.getInstance(CertificationRequestInfo.access$500(this.certificationRequestInfo).getObjectAt(0));
    }

    public BigInteger getVersion() {
        return CertificationRequestInfo.access$200(this.certificationRequestInfo).getValue();
    }

    public ASN1Primitive parsePublicKey() throws IOException {
        return ASN1Primitive.fromByteArray(getSubjectPublicKey().getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.certificationRequestInfo);
        r100.add(this.signatureAlgorithm);
        r100.add(this.signature);
        return new DERSequence(r100);
    }
}
