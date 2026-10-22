package org.bouncycastle.pqc.crypto.sphincs;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SPHINCS256Signer implements MessageSigner {
    private final HashFunctions hashFunctions;
    private byte[] keyData;

    public SPHINCS256Signer(Digest r100, Digest r101) {
        if (r100.getDigestSize() != 32) goto L11;
        if (r101.getDigestSize() != 64) goto L9;
        this.hashFunctions = new HashFunctions(r100, r101);
        return;
    L9:
        throw new IllegalArgumentException("2n-digest needs to produce 64 bytes of output");
    L11:
        throw new IllegalArgumentException("n-digest needs to produce 32 bytes of output");
    }

    public static void compute_authpath_wots(HashFunctions r210, byte[] r211, byte[] r212, int r213, Tree.leafaddr r214, byte[] r215, byte[] r216, int r217) {
        Tree.leafaddr r100 = new Tree.leafaddr(r214);
        byte[] r101 = new byte[2048];
        byte[] r102 = new byte[1024];
        byte[] r110 = new byte[68608];
        r100.subleaf = 0;
    L3:
        long r103 = r100.subleaf;
        if (r103 >= 32) goto L6;
        Seed.get_seed(r210, r102, (int) (r103 * 32), r215, r100);
        r100.subleaf++;
        goto L3
    L6:
        Wots r111 = new Wots();
        r100.subleaf = 0;
    L7:
        long r104 = r100.subleaf;
        if (r104 >= 32) goto L10;
        r111.wots_pkgen(r210, r110, (int) ((67 * r104) * 32), r102, (int) (r104 * 32), r216, 0);
        r100.subleaf++;
        goto L7
    L10:
        r100.subleaf = 0;
    L11:
        long r105 = r100.subleaf;
        if (r105 >= 32) goto L14;
        Tree.l_tree(r210, r101, (int) ((r105 * 32) + 1024), r110, (int) ((r105 * 67) * 32), r216, 0);
        r100.subleaf++;
        goto L11
    L14:
        int r112 = 32;
        int r113 = 0;
    L15:
        if (r112 <= 0) goto L20;
        int r114 = 0;
    L17:
        if (r114 >= r112) goto L19;
        r210.hash_2n_n_mask(r101, ((r112 >>> 1) * 32) + ((r114 >>> 1) * 32), r101, (r112 * 32) + (r114 * 32), r216, ((r113 + 7) * 2) * 32);
        r114 = r114 + 2;
        goto L17
    L19:
        r113 = r113 + 1;
        r112 = r112 >>> 1;
        goto L15
    L20:
        int r106 = (int) r214.subleaf;
        int r107 = 0;
    L21:
        if (r107 >= r217) goto L23;
        System.arraycopy(r101, ((32 >>> r107) * 32) + (((r106 >>> r107) ^ 1) * 32), r212, r213 + (r107 * 32), 32);
        r107 = r107 + 1;
        goto L21
    L23:
        System.arraycopy(r101, 32, r211, 0, 32);
    }

    public static void validate_authpath(HashFunctions r110, byte[] r111, byte[] r112, int r113, byte[] r114, int r115, byte[] r116, int r210) {
        byte[] r100 = new byte[64];
        if ((r113 & 1) == 0) goto L10;
        int r101 = 0;
    L5:
        if (r101 >= 32) goto L7;
        r100[r101 + 32] = r112[r101];
        r101 = r101 + 1;
        goto L5
    L7:
        int r102 = 0;
    L8:
        if (r102 >= 32) goto L16;
        r100[r102] = r114[r115 + r102];
        r102 = r102 + 1;
    L16:
        int r117 = r115 + 32;
        int r118 = 0;
        int r103 = r113;
    L18:
        if (r118 >= (r210 - 1)) goto L28;
        int r119 = r103 >>> 1;
        if ((r119 & 1) == 0) goto L24;
        r110.hash_2n_n_mask(r100, 32, r100, 0, r116, ((r118 + 7) * 2) * 32);
        int r104 = 0;
    L22:
        if (r104 >= 32) goto L27;
        r100[r104] = r114[r117 + r104];
        r104 = r104 + 1;
    L27:
        r117 = r117 + 32;
        r118 = r118 + 1;
        r103 = r119;
        goto L18
    L24:
        r110.hash_2n_n_mask(r100, 0, r100, 0, r116, ((r118 + 7) * 2) * 32);
        int r105 = 0;
    L25:
        if (r105 >= 32) goto L27;
        r100[r105 + 32] = r114[r117 + r105];
        r105 = r105 + 1;
        goto L25
    L28:
        r110.hash_2n_n_mask(r111, 0, r100, 0, r116, (((r210 + 7) - 1) * 2) * 32);
        return;
    L10:
        int r106 = 0;
    L11:
        if (r106 >= 32) goto L13;
        r100[r106] = r112[r106];
        r106 = r106 + 1;
        goto L11
    L13:
        int r107 = 0;
    L14:
        if (r107 >= 32) goto L16;
        r100[r107 + 32] = r114[r115 + r107];
        r107 = r107 + 1;
        goto L14
    }

    private void zerobytes(byte[] r100, int r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 == r102) goto L5;
        r100[r101 + r103] = 0;
        r103 = r103 + 1;
        goto L3
    }

    public byte[] crypto_sign(HashFunctions r210, byte[] r211, byte[] r310) {
        byte[] r110 = new byte[41000];
        byte[] r111 = new byte[32];
        byte[] r112 = new byte[64];
        long[] r100 = new long[8];
        byte[] r101 = new byte[32];
        byte[] r102 = new byte[32];
        byte[] r103 = new byte[1024];
        byte[] r104 = new byte[DownloadErrorCode.ERROR_MAX_BYTE_LIMIT];
        int r105 = 0;
    L3:
        if (r105 >= 1088) goto L5;
        r104[r105] = r310[r105];
        r105 = r105 + 1;
        goto L3
    L5:
        System.arraycopy(r104, 1056, r110, 40968, 32);
        Digest r106 = r210.getMessageHash();
        byte[] r113 = new byte[r106.getDigestSize()];
        r106.update(r110, 40968, 32);
        r106.update(r211, 0, r211.length);
        r106.doFinal(r113, 0);
        zerobytes(r110, 40968, 32);
        int r107 = 0;
    L7:
        if (r107 == 8) goto L9;
        r100[r107] = Pack.littleEndianToLong(r113, r107 * 8);
        r107 = r107 + 1;
        goto L7
    L9:
        long r114 = r100[0] & 1152921504606846975L;
        System.arraycopy(r113, 16, r111, 0, 32);
        System.arraycopy(r111, 0, r110, 39912, 32);
        Tree.leafaddr r108 = new Tree.leafaddr();
        r108.level = 11;
        r108.subtree = 0;
        r108.subleaf = 0;
        System.arraycopy(r104, 32, r110, 39944, 1024);
        Tree.treehash(r210, r110, 40968, 5, r104, r108, r110, 39944);
        Digest r109 = r210.getMessageHash();
        r109.update(r110, 39912, DownloadErrorCode.ERROR_MAX_BYTE_LIMIT);
        r109.update(r211, 0, r211.length);
        r109.doFinal(r112, 0);
        Tree.leafaddr r115 = new Tree.leafaddr();
        int r116 = 12;
        r115.level = 12;
        r115.subleaf = (int) (r114 & 31);
        r115.subtree = r114 >>> 5;
        int r117 = 0;
    L10:
        if (r117 >= 32) goto L12;
        r110[r117] = r111[r117];
        r117 = r117 + 1;
        goto L10
    L12:
        byte[] r118 = r103;
        System.arraycopy(r104, 32, r118, 0, 1024);
        int r119 = 0;
    L13:
        if (r119 >= 8) goto L15;
        r110[32 + r119] = (byte) ((r114 >>> (r119 * 8)) & 255);
        r119 = r119 + 1;
        goto L13
    L15:
        Seed.get_seed(r210, r102, 0, r104, r115);
        new Horst();
        byte[] r212 = r104;
        int r120 = 40 + Horst.horst_sign(r210, r110, 40, r101, r102, r118, r112);
        Wots r121 = new Wots();
        int r122 = r120;
        int r123 = 0;
    L16:
        if (r123 >= r116) goto L18;
        r115.level = r123;
        byte[] r124 = r212;
        Seed.get_seed(r210, r102, 0, r124, r115);
        int r125 = r122;
        int r126 = r122;
        byte[] r127 = r118;
        r121.wots_sign(r210, r110, r125, r101, r102, r127);
        int r128 = r126 + 2144;
        compute_authpath_wots(r210, r101, r110, r128, r115, r124, r127, 5);
        r122 = r128 + 160;
        long r129 = r115.subtree;
        r115.subleaf = (int) (r129 & 31);
        r115.subtree = r129 >>> 5;
        r123 = r123 + 1;
        r212 = r124;
        r118 = r118;
        r116 = 12;
        goto L16
    L18:
        zerobytes(r212, 0, DownloadErrorCode.ERROR_MAX_BYTE_LIMIT);
        return r110;
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] r100) {
        return crypto_sign(this.hashFunctions, r100, this.keyData);
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == true) goto L4;
        this.keyData = ((SPHINCSPublicKeyParameters) r101).getKeyData();
        return;
    L4:
        if ((r101 instanceof ParametersWithRandom) == false) goto L6;
        this.keyData = ((SPHINCSPrivateKeyParameters) ((ParametersWithRandom) r101).getParameters()).getKeyData();
        return;
    L6:
        this.keyData = ((SPHINCSPrivateKeyParameters) r101).getKeyData();
    }

    public boolean verify(HashFunctions r210, byte[] r211, byte[] r212, byte[] r213) {
        byte[] r110 = new byte[2144];
        byte[] r111 = new byte[32];
        byte[] r112 = new byte[32];
        byte[] r113 = new byte[41000];
        byte[] r114 = new byte[1056];
        if (r212.length != 41000) goto L26;
        byte[] r100 = new byte[64];
        int r101 = 0;
    L5:
        if (r101 >= 1056) goto L7;
        r114[r101] = r213[r101];
        r101 = r101 + 1;
        goto L5
    L7:
        byte[] r102 = new byte[32];
        int r103 = 0;
    L8:
        if (r103 >= 32) goto L10;
        r102[r103] = r212[r103];
        r103 = r103 + 1;
        goto L8
    L10:
        System.arraycopy(r212, 0, r113, 0, 41000);
        Digest r104 = r210.getMessageHash();
        r104.update(r102, 0, 32);
        r104.update(r114, 0, 1056);
        r104.update(r211, 0, r211.length);
        r104.doFinal(r100, 0);
        long r105 = 0;
        int r106 = 0;
    L12:
        if (r106 >= 8) goto L14;
        r105 = r105 ^ (((long) (r113[32 + r106] & UByte.MAX_VALUE)) << (r106 * 8));
        r106 = r106 + 1;
        goto L12
    L14:
        new Horst();
        Horst.horst_verify(r210, r112, r113, 40, r114, r100);
        Wots r214 = new Wots();
        int r107 = 0;
        int r108 = 13352;
    L16:
        if (r107 >= 12) goto L18;
        int r215 = r107;
        byte[] r216 = r114;
        r214.wots_verify(r210, r110, r113, r108, r112, r114);
        int r109 = r108 + 2144;
        Tree.l_tree(r210, r111, 0, r110, 0, r216, 0);
        int r115 = (int) (31 & r105);
        byte[] r116 = r113;
        validate_authpath(r210, r112, r111, r115, r116, r109, r216, 5);
        r105 = r105 >> 5;
        r108 = r109 + 160;
        r107 = r215 + 1;
        r113 = r116;
        r114 = r216;
        goto L16
    L18:
        byte[] r217 = r114;
        boolean r117 = true;
        int r118 = 0;
    L19:
        if (r118 >= 32) goto L24;
        if (r112[r118] == r217[r118 + 1024]) goto L23;
        r117 = false;
    L23:
        r118 = r118 + 1;
        goto L19
    L24:
        return r117;
    L26:
        throw new IllegalArgumentException("signature wrong size");
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] r100, byte[] r101) {
        return verify(this.hashFunctions, r100, r101, this.keyData);
    }
}
