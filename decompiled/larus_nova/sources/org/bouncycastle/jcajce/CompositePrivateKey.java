package org.bouncycastle.jcajce;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class CompositePrivateKey implements PrivateKey {
    private final List<PrivateKey> keys;

    public CompositePrivateKey(PrivateKey... r100) {
        if (r100 == null) goto L13;
        if (r100.length == 0) goto L13;
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = 0;
    L8:
        if (r102 == r100.length) goto L10;
        r101.add(r100[r102]);
        r102 = r102 + 1;
        goto L8
    L10:
        this.keys = Collections.unmodifiableList(r101);
        return;
    L13:
        throw new IllegalArgumentException("at least one public key must be provided");
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof CompositePrivateKey) == true) goto L8;
        return false;
    L8:
        return this.keys.equals(((CompositePrivateKey) r100).keys);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "Composite";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        int r101 = 0;
    L4:
        if (r101 == this.keys.size()) goto L11;
        r100.add(PrivateKeyInfo.getInstance(((PrivateKey) ListProtector.get(this.keys, r101)).getEncoded()));
        r101 = r101 + 1;
        goto L4
    L11:
        return new PrivateKeyInfo(new AlgorithmIdentifier(MiscObjectIdentifiers.id_alg_composite), new DERSequence(r100)).getEncoded(ASN1Encoding.DER);
    L8:
        e = move-exception;
        throw new IllegalStateException("unable to encode composite key: " + e.getMessage());
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public List<PrivateKey> getPrivateKeys() {
        return this.keys;
    }

    public int hashCode() {
        return this.keys.hashCode();
    }
}
