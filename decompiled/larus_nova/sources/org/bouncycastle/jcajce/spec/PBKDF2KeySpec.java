package org.bouncycastle.jcajce.spec;

import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class PBKDF2KeySpec extends PBEKeySpec {
    private static final AlgorithmIdentifier defaultPRF = null;
    private AlgorithmIdentifier prf;

    static {
        defaultPRF = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, DERNull.INSTANCE);
    }

    public PBKDF2KeySpec(char[] r100, byte[] r101, int r102, int r103, AlgorithmIdentifier r104) {
        super(r100, r101, r102, r103);
        this.prf = r104;
    }

    public AlgorithmIdentifier getPrf() {
        return this.prf;
    }

    public boolean isDefaultPrf() {
        return defaultPRF.equals(this.prf);
    }
}
