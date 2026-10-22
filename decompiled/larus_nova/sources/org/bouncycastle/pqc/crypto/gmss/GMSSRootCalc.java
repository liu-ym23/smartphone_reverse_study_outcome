package org.bouncycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.encoders.Hex;
import tb2.c;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSRootCalc {
    private byte[][] AuthPath;
    private int K;
    private GMSSDigestProvider digestProvider;
    private int heightOfNextSeed;
    private Vector heightOfNodes;
    private int heightOfTree;
    private int[] index;
    private int indexForNextSeed;
    private boolean isFinished;
    private boolean isInitialized;
    private int mdLength;
    private Digest messDigestTree;
    private Vector[] retain;
    private byte[] root;
    private Vector tailStack;
    private Treehash[] treehash;

    public GMSSRootCalc(int r100, int r101, GMSSDigestProvider r102) {
        this.heightOfTree = r100;
        this.digestProvider = r102;
        Digest r103 = r102.get();
        this.messDigestTree = r103;
        int r104 = r103.getDigestSize();
        this.mdLength = r104;
        this.K = r101;
        this.index = new int[r100];
        int[] r105 = {r100, r104};
        int r106 = 0;
        this.AuthPath = (byte[][]) Array.newInstance(Byte.TYPE, r105);
        this.root = new byte[this.mdLength];
        this.retain = new Vector[this.K - 1];
    L4:
        if (r106 >= (r101 - 1)) goto L6;
        this.retain[r106] = new Vector();
        r106 = r106 + 1;
        goto L4
    }

    public byte[][] getAuthPath() {
        return GMSSUtils.clone(this.AuthPath);
    }

    public Vector[] getRetain() {
        return GMSSUtils.clone(this.retain);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.root);
    }

    public Vector getStack() {
        Vector r100 = new Vector();
        Enumeration r101 = this.tailStack.elements();
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        r100.addElement(r101.nextElement());
        goto L4
    L6:
        return r100;
    }

    public byte[][] getStatByte() {
        Vector r100 = this.tailStack;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        byte[][] r103 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{(this.heightOfTree + 1) + r102, 64});
        r103[0] = this.root;
        int r104 = 0;
    L8:
        if (r104 >= this.heightOfTree) goto L10;
        int r105 = r104 + 1;
        r103[r105] = this.AuthPath[r104];
        r104 = r105;
    L10:
        if (r101 >= r102) goto L12;
        r103[(this.heightOfTree + 1) + r101] = (byte[]) this.tailStack.elementAt(r101);
        r101 = r101 + 1;
        goto L10
    L12:
        return r103;
    L5:
        r102 = r100.size();
        goto L6
    }

    public int[] getStatInt() {
        Vector r100 = this.tailStack;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = this.heightOfTree;
        int[] r104 = new int[(r103 + 8) + r102];
        r104[0] = r103;
        r104[1] = this.mdLength;
        r104[2] = this.K;
        r104[3] = this.indexForNextSeed;
        r104[4] = this.heightOfNextSeed;
        if (this.isFinished == false) goto L9;
        r104[5] = 1;
    L11:
        if (this.isInitialized == false) goto L13;
        r104[6] = 1;
    L14:
        r104[7] = r102;
        int r105 = 0;
    L16:
        if (r105 >= this.heightOfTree) goto L18;
        r104[r105 + 8] = this.index[r105];
        r105 = r105 + 1;
    L18:
        if (r101 >= r102) goto L20;
        r104[(this.heightOfTree + 8) + r101] = ((Integer) this.heightOfNodes.elementAt(r101)).intValue();
        r101 = r101 + 1;
        goto L18
    L20:
        return r104;
    L13:
        r104[6] = 0;
        goto L14
    L9:
        r104[5] = 0;
        goto L11
    L5:
        r102 = r100.size();
        goto L6
    }

    public Treehash[] getTreehash() {
        return GMSSUtils.clone(this.treehash);
    }

    public void initialize(Vector r100) {
        this.treehash = new Treehash[this.heightOfTree - this.K];
        int r101 = 0;
    L3:
        int r102 = this.heightOfTree;
        if (r101 >= (r102 - this.K)) goto L6;
        this.treehash[r101] = new Treehash(r100, r101, this.digestProvider.get());
        r101 = r101 + 1;
        goto L3
    L6:
        this.index = new int[r102];
        this.AuthPath = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r102, this.mdLength});
        this.root = new byte[this.mdLength];
        this.tailStack = new Vector();
        this.heightOfNodes = new Vector();
        this.isInitialized = true;
        this.isFinished = false;
        int r103 = 0;
    L8:
        if (r103 >= this.heightOfTree) goto L10;
        this.index[r103] = -1;
        r103 = r103 + 1;
        goto L8
    L10:
        this.retain = new Vector[this.K - 1];
        int r104 = 0;
    L12:
        if (r104 >= (this.K - 1)) goto L14;
        this.retain[r104] = new Vector();
        r104 = r104 + 1;
        goto L12
    L14:
        this.indexForNextSeed = 3;
        this.heightOfNextSeed = 0;
    }

    public void initializeTreehashSeed(byte[] r100, int r101) {
        this.treehash[r101].initializeSeed(r100);
    }

    public String toString() {
        Vector r100 = this.tailStack;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        String r103 = "";
        int r104 = 0;
    L8:
        if (r104 >= ((this.heightOfTree + 8) + r102)) goto L11;
        r103 = r103 + getStatInt()[r104] + " ";
        r104 = r104 + 1;
    L11:
        if (r101 >= ((this.heightOfTree + 1) + r102)) goto L14;
        r103 = r103 + new String(Hex.encode(getStatByte()[r101])) + " ";
        r101 = r101 + 1;
        goto L11
    L14:
        return r103 + c.DEFAULT_TEXT + this.digestProvider.get().getDigestSize();
    L5:
        r102 = r100.size();
        goto L6
    }

    public void update(byte[] r110) {
        if (this.isFinished == false) goto L7;
        System.out.print("Too much updates for Tree!!");
        return;
    L7:
        if (this.isInitialized == true) goto L10;
        System.err.println("GMSSRootCalc not initialized!");
        return;
    L10:
        int[] r100 = this.index;
        int r101 = r100[0] + 1;
        r100[0] = r101;
        if (r101 != 1) goto L13;
        System.arraycopy(r110, 0, this.AuthPath[0], 0, this.mdLength);
    L17:
        int r102 = this.index[0];
        if (((r102 - 3) % 2) != 0) goto L24;
        if (r102 < 3) goto L24;
        if (this.heightOfTree != this.K) goto L24;
        this.retain[0].insertElementAt(r110, 0);
    L24:
        if (this.index[0] != 0) goto L26;
        this.tailStack.addElement(r110);
        this.heightOfNodes.addElement(Integers.valueOf(0));
        return;
    L26:
        int r103 = this.mdLength;
        byte[] r104 = new byte[r103];
        int r105 = r103 << 1;
        byte[] r106 = new byte[r105];
        System.arraycopy(r110, 0, r104, 0, r103);
        int r111 = 0;
    L28:
        if (this.tailStack.size() <= 0) goto L47;
        if (r111 != ((Integer) this.heightOfNodes.lastElement()).intValue()) goto L47;
        System.arraycopy(this.tailStack.lastElement(), 0, r106, 0, this.mdLength);
        Vector r107 = this.tailStack;
        r107.removeElementAt(r107.size() - 1);
        Vector r108 = this.heightOfNodes;
        r108.removeElementAt(r108.size() - 1);
        int r109 = this.mdLength;
        System.arraycopy(r104, 0, r106, r109, r109);
        this.messDigestTree.update(r106, 0, r105);
        r104 = new byte[this.messDigestTree.getDigestSize()];
        this.messDigestTree.doFinal(r104, 0);
        r111 = r111 + 1;
        if (r111 >= this.heightOfTree) goto L28;
        int[] r112 = this.index;
        int r113 = r112[r111] + 1;
        r112[r111] = r113;
        if (r113 != 1) goto L37;
        System.arraycopy(r104, 0, this.AuthPath[r111], 0, this.mdLength);
    L37:
        if (r111 >= (this.heightOfTree - this.K)) goto L38;
        if (this.index[r111] != 3) goto L28;
        this.treehash[r111].setFirstNode(r104);
        goto L28
    L38:
        if (r111 != 0) goto L40;
        System.out.println("M���P");
    L40:
        int r114 = this.index[r111];
        if (((r114 - 3) % 2) != 0) goto L28;
        if (r114 < 3) goto L28;
        this.retain[r111 - (this.heightOfTree - this.K)].insertElementAt(r104, 0);
    L47:
        this.tailStack.addElement(r104);
        this.heightOfNodes.addElement(Integers.valueOf(r111));
        if (r111 != this.heightOfTree) goto L67;
        this.isFinished = true;
        this.isInitialized = false;
        this.root = (byte[]) this.tailStack.lastElement();
        return;
    L67:
        return;
    L13:
        if (r101 != 3) goto L17;
        if (this.heightOfTree <= this.K) goto L17;
        this.treehash[0].setFirstNode(r110);
        goto L17
    }

    public void update(byte[] r100, byte[] r101) {
        int r102 = this.heightOfNextSeed;
        if (r102 < (this.heightOfTree - this.K)) goto L5;
    L7:
        update(r101);
        return;
    L5:
        if ((this.indexForNextSeed - 2) != this.index[0]) goto L7;
        initializeTreehashSeed(r100, r102);
        this.heightOfNextSeed++;
        this.indexForNextSeed *= 2;
        goto L7
    }

    public boolean wasFinished() {
        return this.isFinished;
    }

    public boolean wasInitialized() {
        return this.isInitialized;
    }
}
