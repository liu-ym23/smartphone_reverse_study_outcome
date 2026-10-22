package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class NHPublicKeyParameters extends AsymmetricKeyParameter {
    final byte[] pubData;

    public NHPublicKeyParameters(byte[] r100) {
        super(false);
        this.pubData = Arrays.clone(r100);
    }

    public byte[] getPubData() {
        return Arrays.clone(this.pubData);
    }
}
