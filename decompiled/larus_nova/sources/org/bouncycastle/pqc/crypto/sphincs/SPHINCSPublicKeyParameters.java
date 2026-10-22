package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class SPHINCSPublicKeyParameters extends SPHINCSKeyParameters {
    private final byte[] keyData;

    public SPHINCSPublicKeyParameters(byte[] r100) {
        super(false, null);
        this.keyData = Arrays.clone(r100);
    }

    public SPHINCSPublicKeyParameters(byte[] r100, String r101) {
        super(false, r101);
        this.keyData = Arrays.clone(r100);
    }

    public byte[] getKeyData() {
        return Arrays.clone(this.keyData);
    }
}
