package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSUtil;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSignature;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSSigner implements MessageSigner {
    private byte[][][] currentAuthPaths;
    private GMSSDigestProvider digestProvider;
    private GMSSParameters gmssPS;
    private GMSSRandom gmssRandom;
    private GMSSUtil gmssUtil;
    private int[] index;
    GMSSKeyParameters key;
    private int mdLength;
    private Digest messDigestOTS;
    private Digest messDigestTrees;
    private int numLayer;
    private WinternitzOTSignature ots;
    private byte[] pubKeyBytes;
    private SecureRandom random;
    private byte[][] subtreeRootSig;

    public GMSSSigner(GMSSDigestProvider r100) {
        this.gmssUtil = new GMSSUtil();
        this.digestProvider = r100;
        Digest r101 = r100.get();
        this.messDigestTrees = r101;
        this.messDigestOTS = r101;
        this.mdLength = r101.getDigestSize();
        this.gmssRandom = new GMSSRandom(this.messDigestTrees);
    }

    private void initSign() {
        this.messDigestTrees.reset();
        GMSSPrivateKeyParameters r100 = (GMSSPrivateKeyParameters) this.key;
        if (r100.isUsed() == true) goto L23;
        if (r100.getIndex(0) >= r100.getNumLeafs(0)) goto L21;
        GMSSParameters r101 = r100.getParameters();
        this.gmssPS = r101;
        this.numLayer = r101.getNumOfLayers();
        byte[] r102 = r100.getCurrentSeeds()[this.numLayer - 1];
        int r103 = this.mdLength;
        byte[] r104 = new byte[r103];
        byte[] r105 = new byte[r103];
        System.arraycopy(r102, 0, r105, 0, r103);
        this.ots = new WinternitzOTSignature(this.gmssRandom.nextSeed(r105), this.digestProvider.get(), this.gmssPS.getWinternitzParameter()[this.numLayer - 1]);
        byte[][][] r106 = r100.getCurrentAuthPaths();
        this.currentAuthPaths = new byte[this.numLayer][][];
        int r107 = 0;
    L7:
        int r108 = this.numLayer;
        if (r107 >= r108) goto L14;
        this.currentAuthPaths[r107] = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r106[r107].length, this.mdLength});
        int r109 = 0;
    L10:
        byte[][] r110 = r106[r107];
        if (r109 >= r110.length) goto L13;
        System.arraycopy(r110[r109], 0, this.currentAuthPaths[r107][r109], 0, this.mdLength);
        r109 = r109 + 1;
        goto L10
    L13:
        r107 = r107 + 1;
        goto L7
    L14:
        this.index = new int[r108];
        System.arraycopy(r100.getIndex(), 0, this.index, 0, this.numLayer);
        this.subtreeRootSig = new byte[this.numLayer - 1][];
        int r111 = 0;
    L16:
        if (r111 >= (this.numLayer - 1)) goto L18;
        byte[] r112 = r100.getSubtreeRootSig(r111);
        byte[][] r113 = this.subtreeRootSig;
        byte[] r114 = new byte[r112.length];
        r113[r111] = r114;
        System.arraycopy(r112, 0, r114, 0, r112.length);
        r111 = r111 + 1;
        goto L16
    L18:
        r100.markUsed();
        return;
    L21:
        throw new IllegalStateException("No more signatures can be generated");
    L23:
        throw new IllegalStateException("Private key already used");
    }

    private void initVerify() {
        this.messDigestTrees.reset();
        GMSSPublicKeyParameters r100 = (GMSSPublicKeyParameters) this.key;
        this.pubKeyBytes = r100.getPublicKey();
        GMSSParameters r101 = r100.getParameters();
        this.gmssPS = r101;
        this.numLayer = r101.getNumOfLayers();
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] r110) {
        byte[] r100 = new byte[this.mdLength];
        byte[] r111 = this.ots.getSignature(r110);
        byte[] r101 = this.gmssUtil.concatenateArray(this.currentAuthPaths[this.numLayer - 1]);
        byte[] r102 = this.gmssUtil.intToBytesLittleEndian(this.index[this.numLayer - 1]);
        int r103 = (r102.length + r111.length) + r101.length;
        byte[] r104 = new byte[r103];
        System.arraycopy(r102, 0, r104, 0, r102.length);
        System.arraycopy(r111, 0, r104, r102.length, r111.length);
        System.arraycopy(r101, 0, r104, r102.length + r111.length, r101.length);
        byte[] r112 = new byte[0];
        int r105 = (this.numLayer - 1) - 1;
    L3:
        if (r105 < 0) goto L5;
        byte[] r106 = this.gmssUtil.concatenateArray(this.currentAuthPaths[r105]);
        byte[] r107 = this.gmssUtil.intToBytesLittleEndian(this.index[r105]);
        int r108 = r112.length;
        byte[] r109 = new byte[r108];
        System.arraycopy(r112, 0, r109, 0, r112.length);
        r112 = new byte[((r107.length + r108) + this.subtreeRootSig[r105].length) + r106.length];
        System.arraycopy(r109, 0, r112, 0, r108);
        System.arraycopy(r107, 0, r112, r108, r107.length);
        byte[] r113 = this.subtreeRootSig[r105];
        System.arraycopy(r113, 0, r112, r107.length + r108, r113.length);
        System.arraycopy(r106, 0, r112, (r108 + r107.length) + this.subtreeRootSig[r105].length, r106.length);
        r105 = r105 - 1;
        goto L3
    L5:
        byte[] r114 = new byte[r112.length + r103];
        System.arraycopy(r104, 0, r114, 0, r103);
        System.arraycopy(r112, 0, r114, r103, r112.length);
        return r114;
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == true) goto L4;
        this.key = (GMSSPublicKeyParameters) r101;
        initVerify();
        return;
    L4:
        if ((r101 instanceof ParametersWithRandom) == false) goto L6;
        ParametersWithRandom r102 = (ParametersWithRandom) r101;
        this.random = r102.getRandom();
        this.key = (GMSSPrivateKeyParameters) r102.getParameters();
    L7:
        initSign();
        return;
    L6:
        this.random = CryptoServicesRegistrar.getSecureRandom();
        this.key = (GMSSPrivateKeyParameters) r101;
        goto L7
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] r110, byte[] r111) {
        this.messDigestOTS.reset();
        int r100 = this.numLayer - 1;
        int r101 = 0;
    L3:
        if (r100 < 0) goto L22;
        WinternitzOTSVerify r102 = new WinternitzOTSVerify(this.digestProvider.get(), this.gmssPS.getWinternitzParameter()[r100]);
        int r103 = r102.getSignatureLength();
        int r104 = this.gmssUtil.bytesToIntLittleEndian(r111, r101);
        int r105 = r101 + 4;
        byte[] r106 = new byte[r103];
        System.arraycopy(r111, r105, r106, 0, r103);
        r101 = r105 + r103;
        r110 = r102.Verify(r110, r106);
        if (r110 == null) goto L6;
        byte[][] r107 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.gmssPS.getHeightOfTrees()[r100], this.mdLength});
        int r108 = 0;
    L10:
        if (r108 >= r107.length) goto L12;
        System.arraycopy(r111, r101, r107[r108], 0, this.mdLength);
        r101 = r101 + this.mdLength;
        r108 = r108 + 1;
        goto L10
    L12:
        byte[] r109 = new byte[this.mdLength];
        int r112 = (1 << r107.length) + r104;
        int r113 = 0;
    L14:
        if (r113 >= r107.length) goto L20;
        int r114 = this.mdLength;
        int r115 = r114 << 1;
        byte[] r116 = new byte[r115];
        if ((r112 % 2) != 0) goto L18;
        System.arraycopy(r110, 0, r116, 0, r114);
        byte[] r117 = r107[r113];
        int r118 = this.mdLength;
        System.arraycopy(r117, 0, r116, r118, r118);
        r112 = r112 / 2;
    L19:
        this.messDigestTrees.update(r116, 0, r115);
        r110 = new byte[this.messDigestTrees.getDigestSize()];
        this.messDigestTrees.doFinal(r110, 0);
        r113 = r113 + 1;
        goto L14
    L18:
        System.arraycopy(r107[r113], 0, r116, 0, r114);
        System.arraycopy(r110, 0, r116, this.mdLength, r110.length);
        r112 = (r112 - 1) / 2;
        goto L19
    L20:
        r100 = r100 - 1;
        goto L3
    L6:
        System.err.println("OTS Public Key is null in GMSSSignature.verify");
        return false;
    L22:
        return Arrays.areEqual(this.pubKeyBytes, r110);
    }
}
