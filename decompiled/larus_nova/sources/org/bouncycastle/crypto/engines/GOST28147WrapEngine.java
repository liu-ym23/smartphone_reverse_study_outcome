package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.macs.GOST28147Mac;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GOST28147WrapEngine implements Wrapper {
    private GOST28147Engine cipher;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private GOST28147Mac f525183mac;

    public GOST28147WrapEngine() {
        this.cipher = new GOST28147Engine();
        this.f525183mac = new GOST28147Mac();
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return "GOST28147Wrap";
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        r101 = ((ParametersWithRandom) r101).getParameters();
    L5:
        ParametersWithUKM r102 = (ParametersWithUKM) r101;
        this.cipher.init(r100, r102.getParameters());
        this.f525183mac.init(new ParametersWithIV(r102.getParameters(), r102.getUKM()));
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] unwrap(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        int r103 = r102 - this.f525183mac.getMacSize();
        byte[] r104 = new byte[r103];
        this.cipher.processBlock(r100, r101, r104, 0);
        this.cipher.processBlock(r100, r101 + 8, r104, 8);
        this.cipher.processBlock(r100, r101 + 16, r104, 16);
        this.cipher.processBlock(r100, r101 + 24, r104, 24);
        byte[] r105 = new byte[this.f525183mac.getMacSize()];
        this.f525183mac.update(r104, 0, r103);
        this.f525183mac.doFinal(r105, 0);
        byte[] r106 = new byte[this.f525183mac.getMacSize()];
        System.arraycopy(r100, (r101 + r102) - 4, r106, 0, this.f525183mac.getMacSize());
        if (Arrays.constantTimeAreEqual(r105, r106) == false) goto L6;
        return r104;
    L6:
        throw new IllegalStateException("mac mismatch");
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] wrap(byte[] r100, int r101, int r102) {
        this.f525183mac.update(r100, r101, r102);
        byte[] r103 = new byte[this.f525183mac.getMacSize() + r102];
        this.cipher.processBlock(r100, r101, r103, 0);
        this.cipher.processBlock(r100, r101 + 8, r103, 8);
        this.cipher.processBlock(r100, r101 + 16, r103, 16);
        this.cipher.processBlock(r100, r101 + 24, r103, 24);
        this.f525183mac.doFinal(r103, r102);
        return r103;
    }
}
