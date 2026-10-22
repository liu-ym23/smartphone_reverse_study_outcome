package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class SM2ParameterSpec implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private byte[] f525389id;

    public SM2ParameterSpec(byte[] r100) {
        if (r100 == null) goto L7;
        this.f525389id = Arrays.clone(r100);
        return;
    L7:
        throw new NullPointerException("id string cannot be null");
    }

    public byte[] getID() {
        return Arrays.clone(this.f525389id);
    }
}
