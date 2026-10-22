package org.bouncycastle.pqc.crypto.sphincs;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class SPHINCS256KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SecureRandom random;
    private Digest treeDigest;

    public SPHINCS256KeyPairGenerator() {
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        Tree.leafaddr r100 = new Tree.leafaddr();
        byte[] r101 = new byte[DownloadErrorCode.ERROR_MAX_BYTE_LIMIT];
        this.random.nextBytes(r101);
        byte[] r102 = new byte[1056];
        System.arraycopy(r101, 32, r102, 0, 1024);
        r100.level = 11;
        r100.subtree = 0;
        r100.subleaf = 0;
        Tree.treehash(new HashFunctions(this.treeDigest), r102, 1024, 5, r101, r100, r102, 0);
        return new AsymmetricCipherKeyPair(new SPHINCSPublicKeyParameters(r102, this.treeDigest.getAlgorithmName()), new SPHINCSPrivateKeyParameters(r101, this.treeDigest.getAlgorithmName()));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        this.random = r100.getRandom();
        this.treeDigest = ((SPHINCS256KeyGenerationParameters) r100).getTreeDigest();
    }
}
