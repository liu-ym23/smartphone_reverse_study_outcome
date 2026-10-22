package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class NHPrivateKeyParameters extends AsymmetricKeyParameter {
    final short[] secData;

    public NHPrivateKeyParameters(short[] r100) {
        super(true);
        this.secData = Arrays.clone(r100);
    }

    public short[] getSecData() {
        return Arrays.clone(this.secData);
    }
}
