package org.bouncycastle.jcajce.spec;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class MQVParameterSpec implements AlgorithmParameterSpec {
    private final PrivateKey ephemeralPrivateKey;
    private final PublicKey ephemeralPublicKey;
    private final PublicKey otherPartyEphemeralKey;
    private final byte[] userKeyingMaterial;

    public MQVParameterSpec(KeyPair r100, PublicKey r101) {
        this(r100.getPublic(), r100.getPrivate(), r101, null);
    }

    public MQVParameterSpec(KeyPair r100, PublicKey r101, byte[] r102) {
        this(r100.getPublic(), r100.getPrivate(), r101, r102);
    }

    public MQVParameterSpec(PrivateKey r100, PublicKey r101) {
        this(null, r100, r101, null);
    }

    public MQVParameterSpec(PrivateKey r100, PublicKey r101, byte[] r102) {
        this(null, r100, r101, r102);
    }

    public MQVParameterSpec(PublicKey r100, PrivateKey r101, PublicKey r102) {
        this(r100, r101, r102, null);
    }

    public MQVParameterSpec(PublicKey r100, PrivateKey r101, PublicKey r102, byte[] r103) {
        this.ephemeralPublicKey = r100;
        this.ephemeralPrivateKey = r101;
        this.otherPartyEphemeralKey = r102;
        this.userKeyingMaterial = Arrays.clone(r103);
    }

    public PrivateKey getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    public PublicKey getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public PublicKey getOtherPartyEphemeralKey() {
        return this.otherPartyEphemeralKey;
    }

    public byte[] getUserKeyingMaterial() {
        return Arrays.clone(this.userKeyingMaterial);
    }
}
