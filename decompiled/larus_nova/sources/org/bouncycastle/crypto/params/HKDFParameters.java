package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class HKDFParameters implements DerivationParameters {
    private final byte[] ikm;
    private final byte[] info;
    private final byte[] salt;
    private final boolean skipExpand;

    private HKDFParameters(byte[] r100, boolean r101, byte[] r102, byte[] r103) {
        if (r100 == null) goto L16;
        this.ikm = Arrays.clone(r100);
        this.skipExpand = r101;
        if (r102 != null) goto L7;
    L10:
        this.salt = null;
    L11:
        if (r103 != null) goto L13;
        this.info = new byte[0];
        return;
    L13:
        this.info = Arrays.clone(r103);
        return;
    L7:
        if (r102.length == 0) goto L10;
        this.salt = Arrays.clone(r102);
        goto L11
    L16:
        throw new IllegalArgumentException("IKM (input keying material) should not be null");
    }

    public HKDFParameters(byte[] r100, byte[] r101, byte[] r102) {
        this(r100, false, r101, r102);
    }

    public static HKDFParameters defaultParameters(byte[] r100) {
        return new HKDFParameters(r100, false, null, null);
    }

    public static HKDFParameters skipExtractParameters(byte[] r100, byte[] r101) {
        return new HKDFParameters(r100, true, null, r101);
    }

    public byte[] getIKM() {
        return Arrays.clone(this.ikm);
    }

    public byte[] getInfo() {
        return Arrays.clone(this.info);
    }

    public byte[] getSalt() {
        return Arrays.clone(this.salt);
    }

    public boolean skipExtract() {
        return this.skipExpand;
    }
}
