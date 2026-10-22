package org.bouncycastle.crypto.commitments;

import java.security.SecureRandom;
import org.bouncycastle.crypto.Commitment;
import org.bouncycastle.crypto.Committer;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class HashCommitter implements Committer {
    private final int byteLength;
    private final Digest digest;
    private final SecureRandom random;

    public HashCommitter(ExtendedDigest r100, SecureRandom r101) {
        this.digest = r100;
        this.byteLength = r100.getByteLength();
        this.random = r101;
    }

    private byte[] calculateCommitment(byte[] r100, byte[] r101) {
        byte[] r102 = new byte[this.digest.getDigestSize()];
        this.digest.update(r100, 0, r100.length);
        this.digest.update(r101, 0, r101.length);
        this.digest.doFinal(r102, 0);
        return r102;
    }

    @Override // org.bouncycastle.crypto.Committer
    public Commitment commit(byte[] r100) {
        int r101 = r100.length;
        int r102 = this.byteLength;
        if (r101 > (r102 / 2)) goto L7;
        byte[] r103 = new byte[r102 - r100.length];
        this.random.nextBytes(r103);
        return new Commitment(r103, calculateCommitment(r103, r100));
    L7:
        throw new DataLengthException("Message to be committed to too large for digest.");
    }

    @Override // org.bouncycastle.crypto.Committer
    public boolean isRevealed(Commitment r100, byte[] r101) {
        if ((r101.length + r100.getSecret().length) != this.byteLength) goto L7;
        byte[] r102 = calculateCommitment(r100.getSecret(), r101);
        return Arrays.constantTimeAreEqual(r100.getCommitment(), r102);
    L7:
        throw new DataLengthException("Message and witness secret lengths do not match.");
    }
}
