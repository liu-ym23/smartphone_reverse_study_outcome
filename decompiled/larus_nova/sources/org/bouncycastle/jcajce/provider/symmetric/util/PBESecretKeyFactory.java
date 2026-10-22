package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class PBESecretKeyFactory extends BaseSecretKeyFactory {
    private int digest;
    private boolean forCipher;
    private int ivSize;
    private int keySize;
    private int scheme;

    public PBESecretKeyFactory(String r100, ASN1ObjectIdentifier r101, boolean r102, int r103, int r104, int r105, int r106) {
        super(r100, r101);
        this.forCipher = r102;
        this.scheme = r103;
        this.digest = r104;
        this.keySize = r105;
        this.ivSize = r106;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
    public SecretKey engineGenerateSecret(KeySpec r110) throws InvalidKeySpecException {
        if ((r110 instanceof PBEKeySpec) == false) goto L15;
        PBEKeySpec r100 = (PBEKeySpec) r110;
        if (r100.getSalt() != null) goto L9;
        return new BCPBEKey(this.algName, this.algOid, this.scheme, this.digest, this.keySize, this.ivSize, r100, null);
    L9:
        if (this.forCipher == false) goto L11;
        CipherParameters r111 = PBE.Util.makePBEParameters(r100, this.scheme, this.digest, this.keySize, this.ivSize);
    L12:
        String r101 = this.algName;
        ASN1ObjectIdentifier r102 = this.algOid;
        int r103 = this.scheme;
        int r104 = this.digest;
        int r105 = this.keySize;
        int r106 = this.ivSize;
        return new BCPBEKey(r101, r102, r103, r104, r105, r106, r100, r111);
    L11:
        r111 = PBE.Util.makePBEMacParameters(r100, this.scheme, this.digest, this.keySize);
        goto L12
    L15:
        throw new InvalidKeySpecException("Invalid KeySpec");
    }
}
