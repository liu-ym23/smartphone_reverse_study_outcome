package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class IESParameterSpec implements AlgorithmParameterSpec {
    private int cipherKeySize;
    private byte[] derivation;
    private byte[] encoding;
    private int macKeySize;
    private byte[] nonce;
    private boolean usePointCompression;

    public IESParameterSpec(byte[] r100, byte[] r101, int r110) {
        this(r100, r101, r110, -1, null, false);
    }

    public IESParameterSpec(byte[] r100, byte[] r101, int r110, int r111, byte[] r112) {
        this(r100, r101, r110, r111, r112, false);
    }

    public IESParameterSpec(byte[] r100, byte[] r101, int r102, int r103, byte[] r104, boolean r110) {
        if (r100 == null) goto L5;
        byte[] r105 = new byte[r100.length];
        this.derivation = r105;
        System.arraycopy(r100, 0, r105, 0, r100.length);
    L6:
        if (r101 == null) goto L8;
        byte[] r106 = new byte[r101.length];
        this.encoding = r106;
        System.arraycopy(r101, 0, r106, 0, r101.length);
    L9:
        this.macKeySize = r102;
        this.cipherKeySize = r103;
        this.nonce = Arrays.clone(r104);
        this.usePointCompression = r110;
        return;
    L8:
        this.encoding = null;
        goto L9
    L5:
        this.derivation = null;
        goto L6
    }

    public int getCipherKeySize() {
        return this.cipherKeySize;
    }

    public byte[] getDerivationV() {
        return Arrays.clone(this.derivation);
    }

    public byte[] getEncodingV() {
        return Arrays.clone(this.encoding);
    }

    public int getMacKeySize() {
        return this.macKeySize;
    }

    public byte[] getNonce() {
        return Arrays.clone(this.nonce);
    }

    public boolean getPointCompression() {
        return this.usePointCompression;
    }

    public void setPointCompression(boolean r100) {
        this.usePointCompression = r100;
    }
}
