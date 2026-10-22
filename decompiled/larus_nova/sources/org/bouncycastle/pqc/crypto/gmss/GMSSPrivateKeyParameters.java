package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSignature;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSPrivateKeyParameters extends GMSSKeyParameters {
    private int[] K;
    private byte[][][] currentAuthPaths;
    private Vector[][] currentRetain;
    private byte[][] currentRootSig;
    private byte[][] currentSeeds;
    private Vector[] currentStack;
    private Treehash[][] currentTreehash;
    private GMSSDigestProvider digestProvider;
    private GMSSParameters gmssPS;
    private GMSSRandom gmssRandom;
    private int[] heightOfTrees;
    private int[] index;
    private byte[][][] keep;
    private int mdLength;
    private Digest messDigestTrees;
    private int[] minTreehash;
    private byte[][][] nextAuthPaths;
    private GMSSLeaf[] nextNextLeaf;
    private GMSSRootCalc[] nextNextRoot;
    private byte[][] nextNextSeeds;
    private Vector[][] nextRetain;
    private byte[][] nextRoot;
    private GMSSRootSig[] nextRootSig;
    private Vector[] nextStack;
    private Treehash[][] nextTreehash;
    private int numLayer;
    private int[] numLeafs;
    private int[] otsIndex;
    private GMSSLeaf[] upperLeaf;
    private GMSSLeaf[] upperTreehashLeaf;
    private boolean used;

    private GMSSPrivateKeyParameters(GMSSPrivateKeyParameters r100) {
        super(true, r100.getParameters());
        this.used = false;
        this.index = Arrays.clone(r100.index);
        this.currentSeeds = Arrays.clone(r100.currentSeeds);
        this.nextNextSeeds = Arrays.clone(r100.nextNextSeeds);
        this.currentAuthPaths = Arrays.clone(r100.currentAuthPaths);
        this.nextAuthPaths = Arrays.clone(r100.nextAuthPaths);
        this.currentTreehash = r100.currentTreehash;
        this.nextTreehash = r100.nextTreehash;
        this.currentStack = r100.currentStack;
        this.nextStack = r100.nextStack;
        this.currentRetain = r100.currentRetain;
        this.nextRetain = r100.nextRetain;
        this.keep = Arrays.clone(r100.keep);
        this.nextNextLeaf = r100.nextNextLeaf;
        this.upperLeaf = r100.upperLeaf;
        this.upperTreehashLeaf = r100.upperTreehashLeaf;
        this.minTreehash = r100.minTreehash;
        this.gmssPS = r100.gmssPS;
        this.nextRoot = Arrays.clone(r100.nextRoot);
        this.nextNextRoot = r100.nextNextRoot;
        this.currentRootSig = r100.currentRootSig;
        this.nextRootSig = r100.nextRootSig;
        this.digestProvider = r100.digestProvider;
        this.heightOfTrees = r100.heightOfTrees;
        this.otsIndex = r100.otsIndex;
        this.K = r100.K;
        this.numLayer = r100.numLayer;
        this.messDigestTrees = r100.messDigestTrees;
        this.mdLength = r100.mdLength;
        this.gmssRandom = r100.gmssRandom;
        this.numLeafs = r100.numLeafs;
    }

    public GMSSPrivateKeyParameters(int[] r110, byte[][] r111, byte[][] r112, byte[][][] r210, byte[][][] r211, byte[][][] r212, Treehash[][] r213, Treehash[][] r214, Vector[] r215, Vector[] r216, Vector[][] r217, Vector[][] r218, GMSSLeaf[] r219, GMSSLeaf[] r310, GMSSLeaf[] r311, int[] r312, byte[][] r313, GMSSRootCalc[] r314, byte[][] r315, GMSSRootSig[] r316, GMSSParameters r317, GMSSDigestProvider r318) {
        super(true, r317);
        this.used = false;
        Digest r113 = r318.get();
        this.messDigestTrees = r113;
        this.mdLength = r113.getDigestSize();
        this.gmssPS = r317;
        this.otsIndex = r317.getWinternitzParameter();
        this.K = r317.getK();
        this.heightOfTrees = r317.getHeightOfTrees();
        int r114 = this.gmssPS.getNumOfLayers();
        this.numLayer = r114;
        if (r110 != null) goto L8;
        this.index = new int[r114];
        int r100 = 0;
    L6:
        if (r100 >= this.numLayer) goto L9;
        this.index[r100] = 0;
        r100 = r100 + 1;
    L9:
        this.currentSeeds = r111;
        this.nextNextSeeds = r112;
        this.currentAuthPaths = Arrays.clone(r210);
        this.nextAuthPaths = r211;
        int r101 = 2;
        if (r212 != null) goto L15;
        this.keep = new byte[this.numLayer][][];
        int r102 = 0;
    L13:
        if (r102 >= this.numLayer) goto L16;
        this.keep[r102] = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{(int) Math.floor(this.heightOfTrees[r102] / r101), this.mdLength});
        r102 = r102 + 1;
        r101 = 2;
    L16:
        if (r215 != null) goto L21;
        this.currentStack = new Vector[this.numLayer];
        int r103 = 0;
    L19:
        if (r103 >= this.numLayer) goto L22;
        this.currentStack[r103] = new Vector();
        r103 = r103 + 1;
    L22:
        if (r216 != null) goto L27;
        int r104 = 1;
        this.nextStack = new Vector[this.numLayer - 1];
        int r105 = 0;
    L25:
        if (r105 >= (this.numLayer - r104)) goto L28;
        this.nextStack[r105] = new Vector();
        r105 = r105 + 1;
        r104 = 1;
    L28:
        this.currentTreehash = r213;
        this.nextTreehash = r214;
        this.currentRetain = r217;
        this.nextRetain = r218;
        this.nextRoot = r313;
        this.digestProvider = r318;
        if (r314 != null) goto L34;
        int r106 = 1;
        this.nextNextRoot = new GMSSRootCalc[this.numLayer - 1];
        int r107 = 0;
    L32:
        if (r107 >= (this.numLayer - r106)) goto L35;
        int r115 = r107 + 1;
        this.nextNextRoot[r107] = new GMSSRootCalc(this.heightOfTrees[r115], this.K[r115], this.digestProvider);
        r107 = r115;
        r106 = 1;
    L35:
        this.currentRootSig = r315;
        this.numLeafs = new int[this.numLayer];
        int r108 = 0;
    L37:
        if (r108 >= this.numLayer) goto L39;
        this.numLeafs[r108] = 1 << this.heightOfTrees[r108];
        r108 = r108 + 1;
        goto L37
    L39:
        this.gmssRandom = new GMSSRandom(this.messDigestTrees);
        int r109 = this.numLayer;
        if (r109 <= 1) goto L47;
        if (r219 != null) goto L46;
        this.nextNextLeaf = new GMSSLeaf[r109 - 2];
        int r116 = 0;
    L44:
        if (r116 >= (this.numLayer - 2)) goto L48;
        int r117 = r116 + 1;
        this.nextNextLeaf[r116] = new GMSSLeaf(r318.get(), this.otsIndex[r117], this.numLeafs[r116 + 2], this.nextNextSeeds[r116]);
        r116 = r117;
    L48:
        if (r310 != null) goto L53;
        int r118 = 1;
        this.upperLeaf = new GMSSLeaf[this.numLayer - 1];
        int r119 = 0;
    L51:
        if (r119 >= (this.numLayer - r118)) goto L54;
        int r120 = r119 + 1;
        this.upperLeaf[r119] = new GMSSLeaf(r318.get(), this.otsIndex[r119], this.numLeafs[r120], this.currentSeeds[r119]);
        r119 = r120;
        r118 = 1;
    L54:
        if (r311 != null) goto L59;
        int r121 = 1;
        this.upperTreehashLeaf = new GMSSLeaf[this.numLayer - 1];
        int r122 = 0;
    L57:
        if (r122 >= (this.numLayer - r121)) goto L60;
        int r123 = r122 + 1;
        this.upperTreehashLeaf[r122] = new GMSSLeaf(r318.get(), this.otsIndex[r122], this.numLeafs[r123]);
        r122 = r123;
        r121 = 1;
    L60:
        if (r312 != null) goto L65;
        int r124 = 1;
        this.minTreehash = new int[this.numLayer - 1];
        int r125 = 0;
    L63:
        if (r125 >= (this.numLayer - r124)) goto L66;
        this.minTreehash[r125] = -1;
        r125 = r125 + 1;
        r124 = 1;
    L66:
        int r126 = this.mdLength;
        byte[] r127 = new byte[r126];
        byte[] r128 = new byte[r126];
        if (r316 != null) goto L72;
        this.nextRootSig = new GMSSRootSig[this.numLayer - 1];
        int r129 = 0;
    L70:
        if (r129 >= (this.numLayer - 1)) goto L85;
        System.arraycopy(r111[r129], 0, r127, 0, this.mdLength);
        this.gmssRandom.nextSeed(r127);
        byte[] r130 = this.gmssRandom.nextSeed(r127);
        int r131 = r129 + 1;
        this.nextRootSig[r129] = new GMSSRootSig(r318.get(), this.otsIndex[r129], this.heightOfTrees[r131]);
        this.nextRootSig[r129].initSign(r130, r313[r129]);
        r129 = r131;
        goto L70
    L85:
        return;
    L72:
        this.nextRootSig = r316;
        return;
    L65:
        this.minTreehash = r312;
        goto L66
    L59:
        this.upperTreehashLeaf = r311;
        goto L60
    L53:
        this.upperLeaf = r310;
        goto L54
    L46:
        this.nextNextLeaf = r219;
        goto L48
    L47:
        this.nextNextLeaf = new GMSSLeaf[0];
        goto L48
    L34:
        this.nextNextRoot = r314;
        goto L35
    L27:
        this.nextStack = r216;
        goto L28
    L21:
        this.currentStack = r215;
        goto L22
    L15:
        this.keep = r212;
        goto L16
    L8:
        this.index = r110;
        goto L9
    }

    public GMSSPrivateKeyParameters(byte[][] r210, byte[][] r211, byte[][][] r212, byte[][][] r213, Treehash[][] r214, Treehash[][] r215, Vector[] r310, Vector[] r311, Vector[][] r312, Vector[][] r313, byte[][] r314, byte[][] r315, GMSSParameters r316, GMSSDigestProvider r317) {
        this(null, r210, r211, r212, r213, null, r214, r215, r310, r311, r312, r313, null, null, null, null, r314, null, r315, null, r316, r317);
    }

    private void computeAuthPaths(int r110) {
        int r100 = this.index[r110];
        int r101 = this.heightOfTrees[r110];
        int r102 = this.K[r110];
        int r103 = 0;
    L3:
        int r104 = r101 - r102;
        if (r103 >= r104) goto L6;
        this.currentTreehash[r110][r103].updateNextSeed(this.gmssRandom);
        r103 = r103 + 1;
        goto L3
    L6:
        int r105 = heightOfPhi(r100);
        byte[] r106 = new byte[this.mdLength];
        byte[] r107 = this.gmssRandom.nextSeed(this.currentSeeds[r110]);
        int r108 = 1;
        int r109 = (r100 >>> (r105 + 1)) & 1;
        int r111 = this.mdLength;
        byte[] r112 = new byte[r111];
        int r113 = r101 - 1;
        if (r105 >= r113) goto L10;
        if (r109 != 0) goto L10;
        System.arraycopy(this.currentAuthPaths[r110][r105], 0, r112, 0, r111);
    L10:
        int r114 = this.mdLength;
        byte[] r115 = new byte[r114];
        if (r105 == 0) goto L13;
        int r116 = r114 << 1;
        byte[] r117 = new byte[r116];
        int r118 = r105 - 1;
        System.arraycopy(this.currentAuthPaths[r110][r118], 0, r117, 0, r114);
        byte[] r119 = this.keep[r110][(int) Math.floor(r118 / 2)];
        int r120 = this.mdLength;
        System.arraycopy(r119, 0, r117, r120, r120);
        this.messDigestTrees.update(r117, 0, r116);
        this.currentAuthPaths[r110][r105] = new byte[this.messDigestTrees.getDigestSize()];
        this.messDigestTrees.doFinal(this.currentAuthPaths[r110][r105], 0);
        int r121 = 0;
    L18:
        if (r121 >= r105) goto L34;
        if (r121 < r104) goto L21;
    L24:
        if (r121 >= r113) goto L29;
        if (r121 < r104) goto L29;
        int r122 = r121 - r104;
        if (this.currentRetain[r110][r122].size() <= 0) goto L29;
        System.arraycopy(this.currentRetain[r110][r122].lastElement(), 0, this.currentAuthPaths[r110][r121], 0, this.mdLength);
        Vector r123 = this.currentRetain[r110][r122];
        r123.removeElementAt(r123.size() - 1);
    L29:
        if (r121 >= r104) goto L33;
        if ((((1 << r121) * 3) + r100) >= this.numLeafs[r110]) goto L33;
        this.currentTreehash[r110][r121].initialize();
    L33:
        r121 = r121 + 1;
        goto L18
    L21:
        if (this.currentTreehash[r110][r121].wasFinished() == false) goto L23;
        System.arraycopy(this.currentTreehash[r110][r121].getFirstNode(), 0, this.currentAuthPaths[r110][r121], 0, this.mdLength);
        this.currentTreehash[r110][r121].destroy();
        goto L24
    L23:
        System.err.println("Treehash (" + r110 + "," + r121 + ") not finished when needed in AuthPathComputation");
    L34:
        if (r105 >= r113) goto L38;
        if (r109 != 0) goto L38;
        System.arraycopy(r112, 0, this.keep[r110][(int) Math.floor(r105 / 2)], 0, this.mdLength);
    L38:
        if (r110 == (this.numLayer - 1)) goto L40;
        this.minTreehash[r110] = getMinTreehashIndex(r110);
        return;
    L40:
        if (r108 > (r104 / 2)) goto L61;
        int r124 = getMinTreehashIndex(r110);
        if (r124 < 0) goto L47;
        byte[] r125 = new byte[this.mdLength];     // Catch: Exception -> L45
        System.arraycopy(this.currentTreehash[r110][r124].getSeedActive(), 0, r125, 0, this.mdLength);     // Catch: Exception -> L45
        this.currentTreehash[r110][r124].update(this.gmssRandom, new WinternitzOTSignature(this.gmssRandom.nextSeed(r125), this.digestProvider.get(), this.otsIndex[r110]).getPublicKey());     // Catch: Exception -> L45
    L45:
        e = move-exception;
        System.out.println(e);
    L47:
        r108 = r108 + 1;
        goto L40
    L61:
        return;
    L13:
        if (r110 != (this.numLayer - 1)) goto L15;
        byte[] r126 = new WinternitzOTSignature(r107, this.digestProvider.get(), this.otsIndex[r110]).getPublicKey();
    L16:
        System.arraycopy(r126, 0, this.currentAuthPaths[r110][0], 0, this.mdLength);
        goto L34
    L15:
        byte[] r127 = new byte[r114];
        System.arraycopy(this.currentSeeds[r110], 0, r127, 0, r114);
        this.gmssRandom.nextSeed(r127);
        byte[] r128 = this.upperLeaf[r110].getLeaf();
        this.upperLeaf[r110].initLeafCalc(r127);
        r126 = r128;
        goto L16
    }

    private int getMinTreehashIndex(int r100) {
        int r101 = 0;
        int r102 = -1;
    L4:
        if (r101 >= (this.heightOfTrees[r100] - this.K[r100])) goto L15;
        if (this.currentTreehash[r100][r101].wasInitialized() == false) goto L14;
        if (this.currentTreehash[r100][r101].wasFinished() == true) goto L14;
        if (r102 != (-1)) goto L12;
    L13:
        r102 = r101;
        goto L14
    L12:
        if (this.currentTreehash[r100][r101].getLowestNodeHeight() < this.currentTreehash[r100][r102].getLowestNodeHeight()) goto L13;
    L14:
        r101 = r101 + 1;
        goto L4
    L15:
        return r102;
    }

    private int heightOfPhi(int r100) {
        if (r100 != 0) goto L5;
        return -1;
    L5:
        int r101 = 0;
        int r102 = 1;
    L7:
        if ((r100 % r102) != 0) goto L10;
        r102 = r102 * 2;
        r101 = r101 + 1;
        goto L7
    L10:
        return r101 - 1;
    }

    private void nextKey(int r100) {
        int r101 = this.numLayer;
        if (r100 != (r101 - 1)) goto L6;
        int[] r102 = this.index;
        r102[r100] = r102[r100] + 1;
    L6:
        if (this.index[r100] != this.numLeafs[r100]) goto L9;
        if (r101 == 1) goto L11;
        nextTree(r100);
        this.index[r100] = 0;
        return;
    L11:
        return;
    L9:
        updateKey(r100);
    }

    private void nextTree(int r100) {
        if (r100 <= 0) goto L42;
        int[] r101 = this.index;
        int r102 = r100 - 1;
        r101[r102] = r101[r102] + 1;
        int r103 = r100;
        boolean r104 = true;
    L4:
        r103 = r103 - 1;
        if (this.index[r103] >= this.numLeafs[r103]) goto L7;
        r104 = false;
    L7:
        if (r104 == false) goto L9;
        if (r103 > 0) goto L4;
    L9:
        if (r104 == true) goto L43;
        this.gmssRandom.nextSeed(this.currentSeeds[r100]);
        this.nextRootSig[r102].updateSign();
        if (r100 <= 1) goto L13;
        GMSSLeaf[] r105 = this.nextNextLeaf;
        int r106 = r102 - 1;
        r105[r106] = r105[r106].nextLeaf();
    L13:
        GMSSLeaf[] r107 = this.upperLeaf;
        r107[r102] = r107[r102].nextLeaf();
        if (this.minTreehash[r102] < 0) goto L20;
        GMSSLeaf[] r108 = this.upperTreehashLeaf;
        r108[r102] = r108[r102].nextLeaf();
        this.currentTreehash[r102][this.minTreehash[r102]].update(this.gmssRandom, this.upperTreehashLeaf[r102].getLeaf());     // Catch: Exception -> L18
        this.currentTreehash[r102][this.minTreehash[r102]].wasFinished();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        System.out.println(e);
    L20:
        updateNextNextAuthRoot(r100);
        this.currentRootSig[r102] = this.nextRootSig[r102].getSig();
        int r109 = 0;
    L22:
        if (r109 >= (this.heightOfTrees[r100] - this.K[r100])) goto L24;
        Treehash[] r110 = this.currentTreehash[r100];
        Treehash[][] r111 = this.nextTreehash;
        r110[r109] = r111[r102][r109];
        r111[r102][r109] = this.nextNextRoot[r102].getTreehash()[r109];
        r109 = r109 + 1;
        goto L22
    L24:
        int r112 = 0;
    L26:
        if (r112 >= this.heightOfTrees[r100]) goto L28;
        System.arraycopy(this.nextAuthPaths[r102][r112], 0, this.currentAuthPaths[r100][r112], 0, this.mdLength);
        System.arraycopy(this.nextNextRoot[r102].getAuthPath()[r112], 0, this.nextAuthPaths[r102][r112], 0, this.mdLength);
        r112 = r112 + 1;
        goto L26
    L28:
        int r113 = 0;
    L30:
        if (r113 >= (this.K[r100] - 1)) goto L32;
        Vector[] r114 = this.currentRetain[r100];
        Vector[][] r115 = this.nextRetain;
        r114[r113] = r115[r102][r113];
        r115[r102][r113] = this.nextNextRoot[r102].getRetain()[r113];
        r113 = r113 + 1;
        goto L30
    L32:
        Vector[] r116 = this.currentStack;
        Vector[] r117 = this.nextStack;
        r116[r100] = r117[r102];
        r117[r102] = this.nextNextRoot[r102].getStack();
        this.nextRoot[r102] = this.nextNextRoot[r102].getRoot();
        int r118 = this.mdLength;
        byte[] r119 = new byte[r118];
        byte[] r120 = new byte[r118];
        System.arraycopy(this.currentSeeds[r102], 0, r120, 0, r118);
        this.gmssRandom.nextSeed(r120);
        this.gmssRandom.nextSeed(r120);
        this.nextRootSig[r102].initSign(this.gmssRandom.nextSeed(r120), this.nextRoot[r102]);
        nextKey(r102);
        return;
    L43:
        return;
    }

    private void updateKey(int r100) {
        computeAuthPaths(r100);
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r100 <= 1) goto L7;
        GMSSLeaf[] r101 = this.nextNextLeaf;
        int r102 = (r100 - 1) - 1;
        r101[r102] = r101[r102].nextLeaf();
    L7:
        GMSSLeaf[] r103 = this.upperLeaf;
        int r104 = r100 - 1;
        r103[r104] = r103[r104].nextLeaf();
        int r105 = (int) Math.floor(((double) (getNumLeafs(r100) * 2)) / ((double) (this.heightOfTrees[r104] - this.K[r104])));
        int r106 = this.index[r100];
        if ((r106 % r105) != 1) goto L21;
        if (r106 > 1) goto L11;
    L17:
        this.minTreehash[r104] = getMinTreehashIndex(r104);
        int r107 = this.minTreehash[r104];
        if (r107 < 0) goto L23;
        this.upperTreehashLeaf[r104] = new GMSSLeaf(this.digestProvider.get(), this.otsIndex[r104], r105, this.currentTreehash[r104][r107].getSeedActive());
        GMSSLeaf[] r108 = this.upperTreehashLeaf;
        r108[r104] = r108[r104].nextLeaf();
    L23:
        this.nextRootSig[r104].updateSign();
        if (this.index[r100] != 1) goto L26;
        this.nextNextRoot[r104].initialize(new Vector());
    L26:
        updateNextNextAuthRoot(r100);
        return;
    L11:
        if (this.minTreehash[r104] < 0) goto L17;
        this.currentTreehash[r104][this.minTreehash[r104]].update(this.gmssRandom, this.upperTreehashLeaf[r104].getLeaf());     // Catch: Exception -> L15
        this.currentTreehash[r104][this.minTreehash[r104]].wasFinished();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        System.out.println(e);
        goto L17
    L21:
        if (this.minTreehash[r104] < 0) goto L23;
        GMSSLeaf[] r109 = this.upperTreehashLeaf;
        r109[r104] = r109[r104].nextLeaf();
        goto L23
    }

    private void updateNextNextAuthRoot(int r100) {
        byte[] r101 = new byte[this.mdLength];
        int r102 = r100 - 1;
        byte[] r103 = this.gmssRandom.nextSeed(this.nextNextSeeds[r102]);
        if (r100 != (this.numLayer - 1)) goto L5;
        this.nextNextRoot[r102].update(this.nextNextSeeds[r102], new WinternitzOTSignature(r103, this.digestProvider.get(), this.otsIndex[r100]).getPublicKey());
        return;
    L5:
        this.nextNextRoot[r102].update(this.nextNextSeeds[r102], this.nextNextLeaf[r102].getLeaf());
        this.nextNextLeaf[r102].initLeafCalc(this.nextNextSeeds[r102]);
    }

    public byte[][][] getCurrentAuthPaths() {
        return Arrays.clone(this.currentAuthPaths);
    }

    public byte[][] getCurrentSeeds() {
        return Arrays.clone(this.currentSeeds);
    }

    public int getIndex(int r100) {
        return this.index[r100];
    }

    public int[] getIndex() {
        return this.index;
    }

    public GMSSDigestProvider getName() {
        return this.digestProvider;
    }

    public int getNumLeafs(int r100) {
        return this.numLeafs[r100];
    }

    public byte[] getSubtreeRootSig(int r100) {
        return this.currentRootSig[r100];
    }

    public boolean isUsed() {
        return this.used;
    }

    public void markUsed() {
        this.used = true;
    }

    public GMSSPrivateKeyParameters nextKey() {
        GMSSPrivateKeyParameters r100 = new GMSSPrivateKeyParameters(this);
        r100.nextKey(this.gmssPS.getNumOfLayers() - 1);
        return r100;
    }
}
