package org.bouncycastle.pqc.crypto.gmss;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.encoders.Hex;
import tb2.c;

/* JADX INFO: loaded from: classes42.dex */
public class Treehash {
    private byte[] firstNode;
    private int firstNodeHeight;
    private Vector heightOfNodes;
    private boolean isFinished;
    private boolean isInitialized;
    private int maxHeight;
    private Digest messDigestTree;
    private byte[] seedActive;
    private boolean seedInitialized;
    private byte[] seedNext;
    private int tailLength;
    private Vector tailStack;

    public Treehash(Vector r100, int r101, Digest r102) {
        this.tailStack = r100;
        this.maxHeight = r101;
        this.firstNode = null;
        this.isInitialized = false;
        this.isFinished = false;
        this.seedInitialized = false;
        this.messDigestTree = r102;
        this.seedNext = new byte[r102.getDigestSize()];
        this.seedActive = new byte[this.messDigestTree.getDigestSize()];
    }

    public Treehash(Digest r100, byte[][] r101, int[] r102) {
        this.messDigestTree = r100;
        int r103 = 0;
        this.maxHeight = r102[0];
        this.tailLength = r102[1];
        this.firstNodeHeight = r102[2];
        if (r102[3] != 1) goto L5;
        this.isFinished = true;
    L7:
        if (r102[4] != 1) goto L9;
        this.isInitialized = true;
    L11:
        if (r102[5] != 1) goto L13;
        this.seedInitialized = true;
    L14:
        this.heightOfNodes = new Vector();
        int r104 = 0;
    L16:
        if (r104 >= this.tailLength) goto L18;
        this.heightOfNodes.addElement(Integers.valueOf(r102[r104 + 6]));
        r104 = r104 + 1;
        goto L16
    L18:
        this.firstNode = r101[0];
        this.seedActive = r101[1];
        this.seedNext = r101[2];
        this.tailStack = new Vector();
    L20:
        if (r103 >= this.tailLength) goto L22;
        this.tailStack.addElement(r101[r103 + 3]);
        r103 = r103 + 1;
        goto L20
    L22:
        return;
    L13:
        this.seedInitialized = false;
        goto L14
    L9:
        this.isInitialized = false;
        goto L11
    L5:
        this.isFinished = false;
        goto L7
    }

    public void destroy() {
        this.isInitialized = false;
        this.isFinished = false;
        this.firstNode = null;
        this.tailLength = 0;
        this.firstNodeHeight = -1;
    }

    public byte[] getFirstNode() {
        return this.firstNode;
    }

    public int getFirstNodeHeight() {
        if (this.firstNode != null) goto L7;
        return this.maxHeight;
    L7:
        return this.firstNodeHeight;
    }

    public int getLowestNodeHeight() {
        if (this.firstNode != null) goto L7;
        return this.maxHeight;
    L7:
        if (this.tailLength != 0) goto L11;
        return this.firstNodeHeight;
    L11:
        return Math.min(this.firstNodeHeight, ((Integer) this.heightOfNodes.lastElement()).intValue());
    }

    public byte[] getSeedActive() {
        return this.seedActive;
    }

    public byte[][] getStatByte() {
        int r100 = 0;
        byte[][] r101 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{this.tailLength + 3, this.messDigestTree.getDigestSize()});
        r101[0] = this.firstNode;
        r101[1] = this.seedActive;
        r101[2] = this.seedNext;
    L4:
        if (r100 >= this.tailLength) goto L6;
        r101[r100 + 3] = (byte[]) this.tailStack.elementAt(r100);
        r100 = r100 + 1;
        goto L4
    L6:
        return r101;
    }

    public int[] getStatInt() {
        int r100 = this.tailLength;
        int[] r101 = new int[r100 + 6];
        int r102 = 0;
        r101[0] = this.maxHeight;
        r101[1] = r100;
        r101[2] = this.firstNodeHeight;
        if (this.isFinished == false) goto L5;
        r101[3] = 1;
    L7:
        if (this.isInitialized == false) goto L9;
        r101[4] = 1;
    L11:
        if (this.seedInitialized == false) goto L13;
        r101[5] = 1;
    L15:
        if (r102 >= this.tailLength) goto L17;
        r101[r102 + 6] = ((Integer) this.heightOfNodes.elementAt(r102)).intValue();
        r102 = r102 + 1;
        goto L15
    L17:
        return r101;
    L13:
        r101[5] = 0;
        goto L15
    L9:
        r101[4] = 0;
        goto L11
    L5:
        r101[3] = 0;
        goto L7
    }

    public Vector getTailStack() {
        return this.tailStack;
    }

    public void initialize() {
        if (this.seedInitialized == false) goto L7;
        this.heightOfNodes = new Vector();
        this.tailLength = 0;
        this.firstNode = null;
        this.firstNodeHeight = -1;
        this.isInitialized = true;
        System.arraycopy(this.seedNext, 0, this.seedActive, 0, this.messDigestTree.getDigestSize());
        return;
    L7:
        throw new IllegalStateException("Seed " + this.maxHeight + " not initialized");
    }

    public void initializeSeed(byte[] r100) {
        System.arraycopy(r100, 0, this.seedNext, 0, this.messDigestTree.getDigestSize());
        this.seedInitialized = true;
    }

    public void setFirstNode(byte[] r100) {
        if (this.isInitialized == true) goto L5;
        initialize();
    L5:
        this.firstNode = r100;
        this.firstNodeHeight = this.maxHeight;
        this.isFinished = true;
    }

    public String toString() {
        String r100 = "Treehash    : ";
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= (this.tailLength + 6)) goto L7;
        r100 = r100 + getStatInt()[r102] + " ";
        r102 = r102 + 1;
    L7:
        if (r101 >= (this.tailLength + 3)) goto L14;
        if (getStatByte()[r101] == null) goto L11;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append(new String(Hex.encode(getStatByte()[r101])));
        r103.append(" ");
    L12:
        r100 = r103.toString();
        r101 = r101 + 1;
        goto L7
    L11:
        r103 = new StringBuilder();
        r103.append(r100);
        r103.append("null ");
        goto L12
    L14:
        return r100 + c.DEFAULT_TEXT + this.messDigestTree.getDigestSize();
    }

    public void update(GMSSRandom r100, byte[] r101) {
        if (this.isFinished == false) goto L8;
        PrintStream r102 = System.err;
        String r103 = "No more update possible for treehash instance!";
    L5:
        r102.println(r103);
        return;
    L8:
        if (this.isInitialized == true) goto L10;
        r102 = System.err;
        r103 = "Treehash instance not initialized before update";
        goto L5
    L10:
        byte[] r104 = new byte[this.messDigestTree.getDigestSize()];
        r100.nextSeed(this.seedActive);
        if (this.firstNode != null) goto L13;
        this.firstNode = r101;
        this.firstNodeHeight = 0;
    L23:
        if (this.firstNodeHeight != this.maxHeight) goto L28;
        this.isFinished = true;
        return;
    L28:
        return;
    L13:
        int r105 = 0;
    L15:
        if (this.tailLength <= 0) goto L19;
        if (r105 != ((Integer) this.heightOfNodes.lastElement()).intValue()) goto L19;
        int r106 = this.messDigestTree.getDigestSize() << 1;
        byte[] r107 = new byte[r106];
        System.arraycopy(this.tailStack.lastElement(), 0, r107, 0, this.messDigestTree.getDigestSize());
        Vector r108 = this.tailStack;
        r108.removeElementAt(r108.size() - 1);
        Vector r109 = this.heightOfNodes;
        r109.removeElementAt(r109.size() - 1);
        System.arraycopy(r101, 0, r107, this.messDigestTree.getDigestSize(), this.messDigestTree.getDigestSize());
        this.messDigestTree.update(r107, 0, r106);
        r101 = new byte[this.messDigestTree.getDigestSize()];
        this.messDigestTree.doFinal(r101, 0);
        r105 = r105 + 1;
        this.tailLength--;
    L19:
        this.tailStack.addElement(r101);
        this.heightOfNodes.addElement(Integers.valueOf(r105));
        this.tailLength++;
        if (((Integer) this.heightOfNodes.lastElement()).intValue() != this.firstNodeHeight) goto L23;
        int r110 = this.messDigestTree.getDigestSize() << 1;
        byte[] r111 = new byte[r110];
        System.arraycopy(this.firstNode, 0, r111, 0, this.messDigestTree.getDigestSize());
        System.arraycopy(this.tailStack.lastElement(), 0, r111, this.messDigestTree.getDigestSize(), this.messDigestTree.getDigestSize());
        Vector r112 = this.tailStack;
        r112.removeElementAt(r112.size() - 1);
        Vector r113 = this.heightOfNodes;
        r113.removeElementAt(r113.size() - 1);
        this.messDigestTree.update(r111, 0, r110);
        byte[] r114 = new byte[this.messDigestTree.getDigestSize()];
        this.firstNode = r114;
        this.messDigestTree.doFinal(r114, 0);
        this.firstNodeHeight++;
        this.tailLength = 0;
        goto L23
    }

    public void updateNextSeed(GMSSRandom r100) {
        r100.nextSeed(this.seedNext);
    }

    public boolean wasFinished() {
        return this.isFinished;
    }

    public boolean wasInitialized() {
        return this.isInitialized;
    }
}
