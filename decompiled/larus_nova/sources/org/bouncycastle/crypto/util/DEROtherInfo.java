package org.bouncycastle.crypto.util;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class DEROtherInfo {
    private final DERSequence sequence;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.util.DEROtherInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final AlgorithmIdentifier algorithmID;
        private final ASN1OctetString partyUVInfo;
        private final ASN1OctetString partyVInfo;
        private ASN1TaggedObject suppPrivInfo;
        private ASN1TaggedObject suppPubInfo;

        public Builder(AlgorithmIdentifier r100, byte[] r101, byte[] r102) {
            this.algorithmID = r100;
            this.partyUVInfo = DerUtil.getOctetString(r101);
            this.partyVInfo = DerUtil.getOctetString(r102);
        }

        public DEROtherInfo build() {
            ASN1EncodableVector r100 = new ASN1EncodableVector();
            r100.add(this.algorithmID);
            r100.add(this.partyUVInfo);
            r100.add(this.partyVInfo);
            ASN1TaggedObject r101 = this.suppPubInfo;
            if (r101 == null) goto L5;
            r100.add(r101);
        L5:
            ASN1TaggedObject r102 = this.suppPrivInfo;
            if (r102 == null) goto L9;
            r100.add(r102);
        L9:
            return new DEROtherInfo(new DERSequence(r100), null);
        }

        public Builder withSuppPrivInfo(byte[] r100) {
            this.suppPrivInfo = new DERTaggedObject(false, 1, DerUtil.getOctetString(r100));
            return this;
        }

        public Builder withSuppPubInfo(byte[] r100) {
            this.suppPubInfo = new DERTaggedObject(false, 0, DerUtil.getOctetString(r100));
            return this;
        }
    }

    private DEROtherInfo(DERSequence r100) {
        this.sequence = r100;
    }

    public /* synthetic */ DEROtherInfo(DERSequence r100, AnonymousClass1 r101) {
        this(r100);
    }

    public byte[] getEncoded() throws IOException {
        return this.sequence.getEncoded();
    }
}
