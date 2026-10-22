package org.bouncycastle.jcajce.spec;

import java.security.spec.KeySpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class TLSKeyMaterialSpec implements KeySpec {
    public static final String KEY_EXPANSION = "key expansion";
    public static final String MASTER_SECRET = "master secret";
    private final String label;
    private final int length;
    private final byte[] secret;
    private final byte[] seed;

    public TLSKeyMaterialSpec(byte[] r100, String r101, int r102, byte[]... r103) {
        this.secret = Arrays.clone(r100);
        this.label = r101;
        this.length = r102;
        this.seed = Arrays.concatenate(r103);
    }

    public String getLabel() {
        return this.label;
    }

    public int getLength() {
        return this.length;
    }

    public byte[] getSecret() {
        return Arrays.clone(this.secret);
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }
}
