package org.bouncycastle.pqc.crypto.gmss;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.StateAwareMessageSigner;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSStateAwareSigner implements StateAwareMessageSigner {
    private final GMSSSigner gmssSigner;
    private GMSSPrivateKeyParameters key;

    public GMSSStateAwareSigner(Digest r100) {
        if ((r100 instanceof Memoable) == false) goto L7;
        final Memoable r101 = ((Memoable) r100).copy();
        this.gmssSigner = new GMSSSigner(new AnonymousClass1(this, r101));
        return;
    L7:
        throw new IllegalArgumentException("digest must implement Memoable");
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] r100) {
        if (this.key == null) goto L7;
        byte[] r101 = this.gmssSigner.generateSignature(r100);
        this.key = this.key.nextKey();
        return r101;
    L7:
        throw new IllegalStateException("signing key no longer usable");
    }

    @Override // org.bouncycastle.pqc.crypto.StateAwareMessageSigner
    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        GMSSPrivateKeyParameters r100 = this.key;
        this.key = null;
        return r100;
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == true) goto L4;
    L8:
        this.gmssSigner.init(r100, r101);
        return;
    L4:
        if ((r101 instanceof ParametersWithRandom) == false) goto L6;
        GMSSPrivateKeyParameters r102 = (GMSSPrivateKeyParameters) ((ParametersWithRandom) r101).getParameters();
    L7:
        this.key = r102;
        goto L8
    L6:
        r102 = (GMSSPrivateKeyParameters) r101;
        goto L7
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] r100, byte[] r101) {
        return this.gmssSigner.verifySignature(r100, r101);
    }
}
