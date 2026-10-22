package org.bouncycastle.pqc.crypto.sphincs;

import com.bytedance.bmf_mods.common.ErrorCode;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class SPHINCS256KeyGenerationParameters extends KeyGenerationParameters {
    private final Digest treeDigest;

    public SPHINCS256KeyGenerationParameters(SecureRandom r100, Digest r101) {
        super(r100, ErrorCode.EXECUTE_HYDRA_FAILED);
        this.treeDigest = r101;
    }

    public Digest getTreeDigest() {
        return this.treeDigest;
    }
}
