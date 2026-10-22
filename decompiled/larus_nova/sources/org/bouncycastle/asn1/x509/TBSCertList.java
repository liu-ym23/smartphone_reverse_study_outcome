package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;

/* JADX INFO: loaded from: classes42.dex */
public class TBSCertList extends ASN1Object {
    Extensions crlExtensions;
    X500Name issuer;
    Time nextUpdate;
    ASN1Sequence revokedCertificates;
    AlgorithmIdentifier signature;
    Time thisUpdate;
    ASN1Integer version;

    /* JADX INFO: renamed from: org.bouncycastle.asn1.x509.TBSCertList$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CRLEntry extends ASN1Object {
        Extensions crlEntryExtensions;
        ASN1Sequence seq;

        private CRLEntry(ASN1Sequence r100) {
            if (r100.size() < 2) goto L9;
            if (r100.size() > 3) goto L9;
            this.seq = r100;
            return;
        L9:
            throw new IllegalArgumentException("Bad sequence size: " + r100.size());
        }

        public static CRLEntry getInstance(Object r100) {
            if ((r100 instanceof CRLEntry) == true) goto L5;
            if (r100 != null) goto L8;
            return null;
        L8:
            return new CRLEntry(ASN1Sequence.getInstance(r100));
        L5:
            return (CRLEntry) r100;
        }

        public Extensions getExtensions() {
            if (this.crlEntryExtensions != null) goto L8;
            if (this.seq.size() != 3) goto L8;
            this.crlEntryExtensions = Extensions.getInstance(this.seq.getObjectAt(2));
        L8:
            return this.crlEntryExtensions;
        }

        public Time getRevocationDate() {
            return Time.getInstance(this.seq.getObjectAt(1));
        }

        public ASN1Integer getUserCertificate() {
            return ASN1Integer.getInstance(this.seq.getObjectAt(0));
        }

        public boolean hasExtensions() {
            if (this.seq.size() != 3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            return this.seq;
        }
    }

    public class EmptyEnumeration implements Enumeration {
        final /* synthetic */ TBSCertList this$0;

        private EmptyEnumeration(TBSCertList r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ EmptyEnumeration(TBSCertList r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            throw new NoSuchElementException("Empty Enumeration");
        }
    }

    public class RevokedCertificatesEnumeration implements Enumeration {

        /* JADX INFO: renamed from: en, reason: collision with root package name */
        private final Enumeration f525084en;
        final /* synthetic */ TBSCertList this$0;

        public RevokedCertificatesEnumeration(TBSCertList r100, Enumeration r101) {
            this.this$0 = r100;
            this.f525084en = r101;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f525084en.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return CRLEntry.getInstance(this.f525084en.nextElement());
        }
    }

    public TBSCertList(ASN1Sequence r100) {
        if (r100.size() < 3) goto L31;
        if (r100.size() > 7) goto L31;
        int r101 = 0;
        if ((r100.getObjectAt(0) instanceof ASN1Integer) == false) goto L9;
        this.version = ASN1Integer.getInstance(r100.getObjectAt(0));
        r101 = 1;
    L10:
        int r102 = r101 + 1;
        this.signature = AlgorithmIdentifier.getInstance(r100.getObjectAt(r101));
        int r103 = r102 + 1;
        this.issuer = X500Name.getInstance(r100.getObjectAt(r102));
        int r104 = r103 + 1;
        this.thisUpdate = Time.getInstance(r100.getObjectAt(r103));
        if (r104 >= r100.size()) goto L20;
        if ((r100.getObjectAt(r104) instanceof ASN1UTCTime) == false) goto L15;
    L18:
        this.nextUpdate = Time.getInstance(r100.getObjectAt(r104));
        r104 = r104 + 1;
        goto L20
    L15:
        if ((r100.getObjectAt(r104) instanceof ASN1GeneralizedTime) == true) goto L18;
        if ((r100.getObjectAt(r104) instanceof Time) == true) goto L18;
    L20:
        if (r104 >= r100.size()) goto L25;
        if ((r100.getObjectAt(r104) instanceof ASN1TaggedObject) == true) goto L25;
        this.revokedCertificates = ASN1Sequence.getInstance(r100.getObjectAt(r104));
        r104 = r104 + 1;
    L25:
        if (r104 < r100.size()) goto L27;
        return;
    L27:
        if ((r100.getObjectAt(r104) instanceof ASN1TaggedObject) == false) goto L33;
        this.crlExtensions = Extensions.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) r100.getObjectAt(r104), true));
        return;
    L33:
        return;
    L9:
        this.version = null;
    L31:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static TBSCertList getInstance(Object r100) {
        if ((r100 instanceof TBSCertList) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TBSCertList(ASN1Sequence.getInstance(r100));
    L5:
        return (TBSCertList) r100;
    }

    public static TBSCertList getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public Extensions getExtensions() {
        return this.crlExtensions;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public Time getNextUpdate() {
        return this.nextUpdate;
    }

    public Enumeration getRevokedCertificateEnumeration() {
        ASN1Sequence r100 = this.revokedCertificates;
        if (r100 != null) goto L7;
        return new EmptyEnumeration(this, null);
    L7:
        return new RevokedCertificatesEnumeration(this, r100.getObjects());
    }

    public CRLEntry[] getRevokedCertificates() {
        ASN1Sequence r100 = this.revokedCertificates;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.size();
        CRLEntry[] r103 = new CRLEntry[r102];
    L7:
        if (r101 >= r102) goto L9;
        r103[r101] = CRLEntry.getInstance(this.revokedCertificates.getObjectAt(r101));
        r101 = r101 + 1;
        goto L7
    L9:
        return r103;
    L5:
        return new CRLEntry[0];
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public Time getThisUpdate() {
        return this.thisUpdate;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public int getVersionNumber() {
        ASN1Integer r100 = this.version;
        if (r100 != null) goto L6;
        return 1;
    L6:
        return r100.intValueExact() + 1;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(7);
        ASN1Integer r101 = this.version;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        r100.add(this.signature);
        r100.add(this.issuer);
        r100.add(this.thisUpdate);
        Time r102 = this.nextUpdate;
        if (r102 == null) goto L8;
        r100.add(r102);
    L8:
        ASN1Sequence r103 = this.revokedCertificates;
        if (r103 == null) goto L11;
        r100.add(r103);
    L11:
        Extensions r104 = this.crlExtensions;
        if (r104 == null) goto L15;
        r100.add(new DERTaggedObject(0, r104));
    L15:
        return new DERSequence(r100);
    }
}
