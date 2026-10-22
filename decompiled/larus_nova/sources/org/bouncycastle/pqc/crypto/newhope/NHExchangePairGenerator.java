package org.bouncycastle.pqc.crypto.newhope;

import java.security.SecureRandom;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.ExchangePair;
import org.bouncycastle.pqc.crypto.ExchangePairGenerator;

/* JADX INFO: loaded from: classes42.dex */
public class NHExchangePairGenerator implements ExchangePairGenerator {
    private final SecureRandom random;

    public NHExchangePairGenerator(SecureRandom r100) {
        this.random = r100;
    }

    @Override // org.bouncycastle.pqc.crypto.ExchangePairGenerator
    public ExchangePair GenerateExchange(AsymmetricKeyParameter r100) {
        return generateExchange(r100);
    }

    @Override // org.bouncycastle.pqc.crypto.ExchangePairGenerator
    public ExchangePair generateExchange(AsymmetricKeyParameter r100) {
        byte[] r101 = new byte[32];
        byte[] r102 = new byte[2048];
        NewHope.sharedB(this.random, r101, r102, ((NHPublicKeyParameters) r100).pubData);
        return new ExchangePair(new NHPublicKeyParameters(r102), r101);
    }
}
