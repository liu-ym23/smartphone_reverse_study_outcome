package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSMTKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private XMSSMTParameters params;
    private SecureRandom prng;
    private XMSSParameters xmssParams;

    public XMSSMTKeyPairGenerator() {
    }

    private XMSSMTPrivateKeyParameters generatePrivateKey(BDSStateMap r100) {
        int r101 = this.params.getTreeDigestSize();
        byte[] r102 = new byte[r101];
        this.prng.nextBytes(r102);
        byte[] r103 = new byte[r101];
        this.prng.nextBytes(r103);
        byte[] r104 = new byte[r101];
        this.prng.nextBytes(r104);
        return new XMSSMTPrivateKeyParameters.Builder(this.params).withSecretKeySeed(r102).withSecretKeyPRF(r103).withPublicSeed(r104).withBDSState(r100).build();
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        XMSSMTPrivateKeyParameters r100 = generatePrivateKey(new XMSSMTPrivateKeyParameters.Builder(this.params).build().getBDSState());
        this.xmssParams.getWOTSPlus().importKeys(new byte[this.params.getTreeDigestSize()], r100.getPublicSeed());
        int r101 = this.params.getLayers() - 1;
        BDS r102 = new BDS(this.xmssParams, r100.getPublicSeed(), r100.getSecretKeySeed(), (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r101).build());
        XMSSNode r103 = r102.getRoot();
        r100.getBDSState().put(r101, r102);
        XMSSMTPrivateKeyParameters r104 = new XMSSMTPrivateKeyParameters.Builder(this.params).withSecretKeySeed(r100.getSecretKeySeed()).withSecretKeyPRF(r100.getSecretKeyPRF()).withPublicSeed(r100.getPublicSeed()).withRoot(r103.getValue()).withBDSState(r100.getBDSState()).build();
        return new AsymmetricCipherKeyPair(new XMSSMTPublicKeyParameters.Builder(this.params).withRoot(r103.getValue()).withPublicSeed(r104.getPublicSeed()).build(), r104);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        XMSSMTKeyGenerationParameters r101 = (XMSSMTKeyGenerationParameters) r100;
        this.prng = r101.getRandom();
        XMSSMTParameters r102 = r101.getParameters();
        this.params = r102;
        this.xmssParams = r102.getXMSSParameters();
    }
}
