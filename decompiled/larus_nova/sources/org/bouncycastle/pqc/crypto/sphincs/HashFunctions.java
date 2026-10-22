package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
class HashFunctions {
    private static final byte[] hashc = null;
    private final Digest dig256;
    private final Digest dig512;
    private final Permute perm;

    static {
        hashc = Strings.toByteArray("expand 32-byte to 64-byte state!");
    }

    public HashFunctions(Digest r100) {
        this(r100, null);
    }

    public HashFunctions(Digest r100, Digest r101) {
        this.perm = new Permute();
        this.dig256 = r100;
        this.dig512 = r101;
    }

    public Digest getMessageHash() {
        return this.dig512;
    }

    public int hash_2n_n(byte[] r100, int r101, byte[] r102, int r110) {
        byte[] r103 = new byte[64];
        int r104 = 0;
    L4:
        if (r104 >= 32) goto L6;
        r103[r104] = r102[r110 + r104];
        r103[r104 + 32] = hashc[r104];
        r104 = r104 + 1;
        goto L4
    L6:
        this.perm.chacha_permute(r103, r103);
        int r105 = 0;
    L7:
        if (r105 >= 32) goto L9;
        r103[r105] = (byte) (r103[r105] ^ r102[(r110 + r105) + 32]);
        r105 = r105 + 1;
        goto L7
    L9:
        this.perm.chacha_permute(r103, r103);
        int r106 = 0;
    L10:
        if (r106 >= 32) goto L12;
        r100[r101 + r106] = r103[r106];
        r106 = r106 + 1;
        goto L10
    L12:
        return 0;
    }

    public int hash_2n_n_mask(byte[] r100, int r101, byte[] r102, int r110, byte[] r111, int r112) {
        byte[] r103 = new byte[64];
        int r104 = 0;
    L3:
        if (r104 >= 64) goto L6;
        r103[r104] = (byte) (r102[r110 + r104] ^ r111[r112 + r104]);
        r104 = r104 + 1;
        goto L3
    L6:
        return hash_2n_n(r100, r101, r103, 0);
    }

    public int hash_n_n(byte[] r100, int r101, byte[] r102, int r103) {
        byte[] r104 = new byte[64];
        int r105 = 0;
    L4:
        if (r105 >= 32) goto L6;
        r104[r105] = r102[r103 + r105];
        r104[r105 + 32] = hashc[r105];
        r105 = r105 + 1;
        goto L4
    L6:
        this.perm.chacha_permute(r104, r104);
        int r106 = 0;
    L7:
        if (r106 >= 32) goto L9;
        r100[r101 + r106] = r104[r106];
        r106 = r106 + 1;
        goto L7
    L9:
        return 0;
    }

    public int hash_n_n_mask(byte[] r100, int r101, byte[] r102, int r110, byte[] r111, int r112) {
        byte[] r103 = new byte[32];
        int r104 = 0;
    L3:
        if (r104 >= 32) goto L6;
        r103[r104] = (byte) (r102[r110 + r104] ^ r111[r112 + r104]);
        r104 = r104 + 1;
        goto L3
    L6:
        return hash_n_n(r100, r101, r103, 0);
    }

    public int varlen_hash(byte[] r100, int r101, byte[] r102, int r103) {
        this.dig256.update(r102, 0, r103);
        this.dig256.doFinal(r100, r101);
        return 0;
    }
}
