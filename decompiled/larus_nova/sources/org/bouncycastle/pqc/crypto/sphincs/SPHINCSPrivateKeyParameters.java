package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class SPHINCSPrivateKeyParameters extends SPHINCSKeyParameters {
    private final byte[] keyData;

    public SPHINCSPrivateKeyParameters(byte[] r100) {
        super(true, null);
        this.keyData = Arrays.clone(r100);
    }

    public SPHINCSPrivateKeyParameters(byte[] r100, String r101) {
        super(true, r101);
        this.keyData = Arrays.clone(r100);
    }

    public byte[] getKeyData() {
        return Arrays.clone(this.keyData);
    }
}
