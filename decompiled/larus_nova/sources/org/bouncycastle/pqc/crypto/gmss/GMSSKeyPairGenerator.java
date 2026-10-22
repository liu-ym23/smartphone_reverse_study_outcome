package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSignature;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.3";
    private int[] K;
    private byte[][] currentRootSigs;
    private byte[][] currentSeeds;
    private GMSSDigestProvider digestProvider;
    private GMSSParameters gmssPS;
    private GMSSKeyGenerationParameters gmssParams;
    private GMSSRandom gmssRandom;
    private int[] heightOfTrees;
    private boolean initialized;
    private int mdLength;
    private Digest messDigestTree;
    private byte[][] nextNextSeeds;
    private int numLayer;
    private int[] otsIndex;

    public GMSSKeyPairGenerator(GMSSDigestProvider r100) {
        this.initialized = false;
        this.digestProvider = r100;
        Digest r101 = r100.get();
        this.messDigestTree = r101;
        this.mdLength = r101.getDigestSize();
        this.gmssRandom = new GMSSRandom(this.messDigestTree);
    }

    private AsymmetricCipherKeyPair genKeyPair() {
        if (this.initialized == true) goto L5;
        initializeDefault();
    L5:
        int r100 = this.numLayer;
        byte[][][] r101 = new byte[r100][][];
        byte[][][] r102 = new byte[r100 - 1][][];
        Treehash[][] r103 = new Treehash[r100][];
        Treehash[][] r104 = new Treehash[r100 - 1][];
        Vector[] r105 = new Vector[r100];
        Vector[] r110 = new Vector[r100 - 1];
        Vector[][] r111 = new Vector[r100][];
        int r106 = 1;
        Vector[][] r112 = new Vector[r100 - 1][];
        int r107 = 0;
    L6:
        int r108 = this.numLayer;
        if (r107 >= r108) goto L15;
        r101[r107] = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.heightOfTrees[r107], this.mdLength});
        int r109 = this.heightOfTrees[r107];
        r103[r107] = new Treehash[r109 - this.K[r107]];
        if (r107 <= 0) goto L11;
        int r113 = r107 - 1;
        r102[r113] = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r109, this.mdLength});
        r104[r113] = new Treehash[this.heightOfTrees[r107] - this.K[r107]];
    L11:
        r105[r107] = new Vector();
        if (r107 <= 0) goto L14;
        r110[r107 - 1] = new Vector();
    L14:
        r107 = r107 + 1;
        goto L6
    L15:
        byte[][] r114 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r108, this.mdLength});
        byte[][] r115 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.numLayer - 1, this.mdLength});
        byte[][] r116 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.numLayer, this.mdLength});
        int r117 = 0;
    L16:
        int r118 = this.numLayer;
        if (r117 >= r118) goto L19;
        System.arraycopy(this.currentSeeds[r117], 0, r116[r117], 0, this.mdLength);
        r117 = r117 + 1;
        r106 = 1;
        goto L16
    L19:
        int[] r119 = new int[2];
        r119[r106] = this.mdLength;
        r119[0] = r118 - r106;
        this.currentRootSigs = (byte[][]) Array.newInstance(Byte.TYPE, r119);
        int r120 = this.numLayer - r106;
    L20:
        if (r120 < 0) goto L30;
        if (r120 != (this.numLayer - r106)) goto L24;
        GMSSRootCalc r121 = generateCurrentAuthpathAndRoot(null, r105[r120], r116[r120], r120);
    L25:
        int r122 = 0;
    L27:
        if (r122 >= this.heightOfTrees[r120]) goto L29;
        System.arraycopy(r121.getAuthPath()[r122], 0, r101[r120][r122], 0, this.mdLength);
        r122 = r122 + 1;
        r105 = r105;
        goto L27
    L29:
        r111[r120] = r121.getRetain();
        r103[r120] = r121.getTreehash();
        System.arraycopy(r121.getRoot(), 0, r114[r120], 0, this.mdLength);
        r120 = r120 - 1;
        r105 = r105;
        r106 = 1;
        goto L20
    L24:
        r121 = generateCurrentAuthpathAndRoot(r114[r120 + 1], r105[r120], r116[r120], r120);
        goto L25
    L30:
        Vector[] r123 = r105;
        int r124 = this.numLayer - 2;
    L31:
        if (r124 < 0) goto L38;
        int r125 = r124 + 1;
        GMSSRootCalc r126 = generateNextAuthpathAndRoot(r110[r124], r116[r125], r125);
        int r127 = 0;
    L34:
        if (r127 >= this.heightOfTrees[r125]) goto L36;
        System.arraycopy(r126.getAuthPath()[r127], 0, r102[r124][r127], 0, this.mdLength);
        r127 = r127 + 1;
        r111 = r111;
        goto L34
    L36:
        r112[r124] = r126.getRetain();
        r104[r124] = r126.getTreehash();
        System.arraycopy(r126.getRoot(), 0, r115[r124], 0, this.mdLength);
        System.arraycopy(r116[r125], 0, this.nextNextSeeds[r124], 0, this.mdLength);
        r124 = r124 - 1;
        r111 = r111;
        goto L31
    L38:
        return new AsymmetricCipherKeyPair(new GMSSPublicKeyParameters(r114[0], this.gmssPS), new GMSSPrivateKeyParameters(this.currentSeeds, this.nextNextSeeds, r101, r102, r103, r104, r123, r110, r111, r112, r115, this.currentRootSigs, this.gmssPS, this.digestProvider));
    }

    private GMSSRootCalc generateCurrentAuthpathAndRoot(byte[] r100, Vector r101, byte[] r110, int r111) {
        int r102 = this.mdLength;
        byte[] r103 = new byte[r102];
        byte[] r104 = new byte[r102];
        byte[] r105 = this.gmssRandom.nextSeed(r110);
        GMSSRootCalc r106 = new GMSSRootCalc(this.heightOfTrees[r111], this.K[r111], this.digestProvider);
        r106.initialize(r101);
        if (r111 != (this.numLayer - 1)) goto L5;
        byte[] r107 = new WinternitzOTSignature(r105, this.digestProvider.get(), this.otsIndex[r111]).getPublicKey();
    L6:
        r106.update(r107);
        int r108 = 3;
        int r109 = 0;
        int r112 = 1;
    L7:
        int r113 = this.heightOfTrees[r111];
        if (r112 >= (1 << r113)) goto L15;
        if (r112 != r108) goto L13;
        if (r109 >= (r113 - this.K[r111])) goto L13;
        r106.initializeTreehashSeed(r110, r109);
        r108 = r108 * 2;
        r109 = r109 + 1;
    L13:
        r106.update(new WinternitzOTSignature(this.gmssRandom.nextSeed(r110), this.digestProvider.get(), this.otsIndex[r111]).getPublicKey());
        r112 = r112 + 1;
        goto L7
    L15:
        if (r106.wasFinished() == false) goto L17;
        return r106;
    L17:
        System.err.println("Baum noch nicht fertig konstruiert!!!");
        return null;
    L5:
        WinternitzOTSignature r114 = new WinternitzOTSignature(r105, this.digestProvider.get(), this.otsIndex[r111]);
        this.currentRootSigs[r111] = r114.getSignature(r100);
        r107 = new WinternitzOTSVerify(this.digestProvider.get(), this.otsIndex[r111]).Verify(r100, this.currentRootSigs[r111]);
        goto L6
    }

    private GMSSRootCalc generateNextAuthpathAndRoot(Vector r100, byte[] r101, int r110) {
        byte[] r102 = new byte[this.numLayer];
        GMSSRootCalc r103 = new GMSSRootCalc(this.heightOfTrees[r110], this.K[r110], this.digestProvider);
        r103.initialize(r100);
        int r104 = 3;
        int r105 = 0;
        int r106 = 0;
    L3:
        int r107 = this.heightOfTrees[r110];
        if (r105 >= (1 << r107)) goto L11;
        if (r105 != r104) goto L9;
        if (r106 >= (r107 - this.K[r110])) goto L9;
        r103.initializeTreehashSeed(r101, r106);
        r104 = r104 * 2;
        r106 = r106 + 1;
    L9:
        r103.update(new WinternitzOTSignature(this.gmssRandom.nextSeed(r101), this.digestProvider.get(), this.otsIndex[r110]).getPublicKey());
        r105 = r105 + 1;
        goto L3
    L11:
        if (r103.wasFinished() == false) goto L13;
        return r103;
    L13:
        System.err.println("N�chster Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    private void initializeDefault() {
        initialize(new GMSSKeyGenerationParameters(null, new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{3, 3, 3, 3}, new int[]{2, 2, 2, 2})));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        initialize(r100);
    }

    public void initialize(int r100, SecureRandom r101) {
        if (r100 > 10) goto L6;
        GMSSKeyGenerationParameters r102 = new GMSSKeyGenerationParameters(r101, new GMSSParameters(1, new int[]{10}, new int[]{3}, new int[]{2}));
    L10:
        initialize(r102);
        return;
    L6:
        if (r100 > 20) goto L8;
        GMSSKeyGenerationParameters r103 = new GMSSKeyGenerationParameters(r101, new GMSSParameters(2, new int[]{10, 10}, new int[]{5, 4}, new int[]{2, 2}));
    L9:
        r102 = r103;
        goto L10
    L8:
        r103 = new GMSSKeyGenerationParameters(r101, new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{9, 9, 9, 3}, new int[]{2, 2, 2, 2}));
        goto L9
    }

    public void initialize(KeyGenerationParameters r100) {
        GMSSKeyGenerationParameters r101 = (GMSSKeyGenerationParameters) r100;
        this.gmssParams = r101;
        GMSSParameters r102 = new GMSSParameters(r101.getParameters().getNumOfLayers(), this.gmssParams.getParameters().getHeightOfTrees(), this.gmssParams.getParameters().getWinternitzParameter(), this.gmssParams.getParameters().getK());
        this.gmssPS = r102;
        this.numLayer = r102.getNumOfLayers();
        this.heightOfTrees = this.gmssPS.getHeightOfTrees();
        this.otsIndex = this.gmssPS.getWinternitzParameter();
        this.K = this.gmssPS.getK();
        int r103 = 0;
        this.currentSeeds = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.numLayer, this.mdLength});
        this.nextNextSeeds = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.numLayer - 1, this.mdLength});
        SecureRandom r104 = r100.getRandom();
    L4:
        if (r103 >= this.numLayer) goto L6;
        r104.nextBytes(this.currentSeeds[r103]);
        this.gmssRandom.nextSeed(this.currentSeeds[r103]);
        r103 = r103 + 1;
        goto L4
    L6:
        this.initialized = true;
    }
}
