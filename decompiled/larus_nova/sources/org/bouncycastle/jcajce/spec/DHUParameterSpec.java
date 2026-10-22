package org.bouncycastle.jcajce.spec;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DHUParameterSpec implements AlgorithmParameterSpec {
    private final PrivateKey ephemeralPrivateKey;
    private final PublicKey ephemeralPublicKey;
    private final PublicKey otherPartyEphemeralKey;
    private final byte[] userKeyingMaterial;

    public DHUParameterSpec(KeyPair r100, PublicKey r101) {
        this(r100.getPublic(), r100.getPrivate(), r101, null);
    }

    public DHUParameterSpec(KeyPair r100, PublicKey r101, byte[] r102) {
        this(r100.getPublic(), r100.getPrivate(), r101, r102);
    }

    public DHUParameterSpec(PrivateKey r100, PublicKey r101) {
        this(null, r100, r101, null);
    }

    public DHUParameterSpec(PrivateKey r100, PublicKey r101, byte[] r102) {
        this(null, r100, r101, r102);
    }

    public DHUParameterSpec(PublicKey r100, PrivateKey r101, PublicKey r102) {
        this(r100, r101, r102, null);
    }

    public DHUParameterSpec(PublicKey r100, PrivateKey r101, PublicKey r102, byte[] r103) {
        if (r101 == null) goto L10;
        if (r102 == null) goto L8;
        this.ephemeralPublicKey = r100;
        this.ephemeralPrivateKey = r101;
        this.otherPartyEphemeralKey = r102;
        this.userKeyingMaterial = Arrays.clone(r103);
        return;
    L8:
        throw new IllegalArgumentException("other party ephemeral key cannot be null");
    L10:
        throw new IllegalArgumentException("ephemeral private key cannot be null");
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
