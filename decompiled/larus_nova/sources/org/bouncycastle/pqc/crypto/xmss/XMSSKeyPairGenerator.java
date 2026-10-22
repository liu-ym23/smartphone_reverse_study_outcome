package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private XMSSParameters params;
    private SecureRandom prng;

    public XMSSKeyPairGenerator() {
    }

    private XMSSPrivateKeyParameters generatePrivateKey(XMSSParameters r100, SecureRandom r101) {
        int r102 = r100.getTreeDigestSize();
        byte[] r103 = new byte[r102];
        r101.nextBytes(r103);
        byte[] r104 = new byte[r102];
        r101.nextBytes(r104);
        byte[] r105 = new byte[r102];
        r101.nextBytes(r105);
        return new XMSSPrivateKeyParameters.Builder(r100).withSecretKeySeed(r103).withSecretKeyPRF(r104).withPublicSeed(r105).withBDSState(new BDS(r100, r105, r103, (OTSHashAddress) new OTSHashAddress.Builder().build())).build();
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        XMSSPrivateKeyParameters r100 = generatePrivateKey(this.params, this.prng);
        XMSSNode r101 = r100.getBDSState().getRoot();
        XMSSPrivateKeyParameters r102 = new XMSSPrivateKeyParameters.Builder(this.params).withSecretKeySeed(r100.getSecretKeySeed()).withSecretKeyPRF(r100.getSecretKeyPRF()).withPublicSeed(r100.getPublicSeed()).withRoot(r101.getValue()).withBDSState(r100.getBDSState()).build();
        return new AsymmetricCipherKeyPair(new XMSSPublicKeyParameters.Builder(this.params).withRoot(r101.getValue()).withPublicSeed(r102.getPublicSeed()).build(), r102);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        XMSSKeyGenerationParameters r101 = (XMSSKeyGenerationParameters) r100;
        this.prng = r101.getRandom();
        this.params = r101.getParameters();
    }
}
