package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.EphemeralKeyPair;
import org.bouncycastle.crypto.KeyEncoder;

/* JADX INFO: loaded from: classes42.dex */
public class EphemeralKeyPairGenerator {

    /* JADX INFO: renamed from: gen, reason: collision with root package name */
    private AsymmetricCipherKeyPairGenerator f525211gen;
    private KeyEncoder keyEncoder;

    public EphemeralKeyPairGenerator(AsymmetricCipherKeyPairGenerator r100, KeyEncoder r101) {
        this.f525211gen = r100;
        this.keyEncoder = r101;
    }

    public EphemeralKeyPair generate() {
        return new EphemeralKeyPair(this.f525211gen.generateKeyPair(), this.keyEncoder);
    }
}
