package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ShortBufferException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.bouncycastle.pqc.crypto.ExchangePair;
import org.bouncycastle.pqc.crypto.newhope.NHAgreement;
import org.bouncycastle.pqc.crypto.newhope.NHExchangePairGenerator;
import org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class KeyAgreementSpi extends BaseAgreementSpi {
    private NHAgreement agreement;
    private NHExchangePairGenerator exchangePairGenerator;
    private BCNHPublicKey otherPartyKey;
    private byte[] shared;

    public KeyAgreementSpi() {
        super("NH", null);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi
    public byte[] calcSecret() {
        return engineGenerateSecret();
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key r100, boolean r101) throws InvalidKeyException, IllegalStateException {
        if (r101 == false) goto L10;
        BCNHPublicKey r102 = (BCNHPublicKey) r100;
        this.otherPartyKey = r102;
        NHExchangePairGenerator r103 = this.exchangePairGenerator;
        if (r103 == null) goto L7;
        ExchangePair r104 = r103.generateExchange((AsymmetricKeyParameter) r102.getKeyParams());
        this.shared = r104.getSharedValue();
        return new BCNHPublicKey((NHPublicKeyParameters) r104.getPublicKey());
    L7:
        this.shared = this.agreement.calculateAgreement(r102.getKeyParams());
        return null;
    L10:
        throw new IllegalStateException("NewHope can only be between two parties.");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] r100, int r101) throws IllegalStateException, ShortBufferException {
        byte[] r102 = this.shared;
        System.arraycopy(r102, 0, r100, r101, r102.length);
        Arrays.fill(this.shared, (byte) 0);
        return this.shared.length;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        byte[] r100 = Arrays.clone(this.shared);
        Arrays.fill(this.shared, (byte) 0);
        return r100;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key r100, SecureRandom r101) throws InvalidKeyException {
        if (r100 == null) goto L4;
        NHAgreement r102 = new NHAgreement();
        this.agreement = r102;
        r102.init(((BCNHPrivateKey) r100).getKeyParams());
        return;
    L4:
        this.exchangePairGenerator = new NHExchangePairGenerator(r101);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key r100, AlgorithmParameterSpec r101, SecureRandom r102) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("NewHope does not require parameters");
    }
}
