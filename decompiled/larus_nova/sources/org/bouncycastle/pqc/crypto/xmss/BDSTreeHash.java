package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.Stack;

/* JADX INFO: loaded from: classes42.dex */
class BDSTreeHash implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private boolean finished;
    private int height;
    private final int initialHeight;
    private boolean initialized;
    private int nextIndex;
    private XMSSNode tailNode;

    public BDSTreeHash(int r100) {
        this.initialHeight = r100;
        this.initialized = false;
        this.finished = false;
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m10989clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public BDSTreeHash m10989clone() {
        BDSTreeHash r100 = new BDSTreeHash(this.initialHeight);
        r100.tailNode = this.tailNode;
        r100.height = this.height;
        r100.nextIndex = this.nextIndex;
        r100.initialized = this.initialized;
        r100.finished = this.finished;
        return r100;
    }

    public int getHeight() {
        if (this.initialized == true) goto L5;
        return Integer.MAX_VALUE;
    L5:
        if (this.finished == false) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return this.height;
    }

    public int getIndexLeaf() {
        return this.nextIndex;
    }

    public XMSSNode getTailNode() {
        return this.tailNode;
    }

    public void initialize(int r100) {
        this.tailNode = null;
        this.height = this.initialHeight;
        this.nextIndex = r100;
        this.initialized = true;
        this.finished = false;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public void setNode(XMSSNode r100) {
        this.tailNode = r100;
        int r101 = r100.getHeight();
        this.height = r101;
        if (r101 != this.initialHeight) goto L6;
        this.finished = true;
        return;
    }

    public void update(Stack<XMSSNode> r100, WOTSPlus r101, byte[] r102, byte[] r103, OTSHashAddress r104) {
        if (r104 == null) goto L30;
        if (this.finished == true) goto L28;
        if (this.initialized == false) goto L28;
        OTSHashAddress r105 = (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r104.getLayerAddress()).withTreeAddress(r104.getTreeAddress()).withOTSAddress(this.nextIndex).withChainAddress(r104.getChainAddress()).withHashAddress(r104.getHashAddress()).withKeyAndMask(r104.getKeyAndMask()).build();
        LTreeAddress r106 = (LTreeAddress) new LTreeAddress.Builder().withLayerAddress(r105.getLayerAddress()).withTreeAddress(r105.getTreeAddress()).withLTreeAddress(this.nextIndex).build();
        HashTreeAddress r107 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r105.getLayerAddress()).withTreeAddress(r105.getTreeAddress()).withTreeIndex(this.nextIndex).build();
        r101.importKeys(r101.getWOTSPlusSecretKey(r103, r105), r102);
        XMSSNode r108 = XMSSNodeUtil.lTree(r101, r101.getPublicKey(r105), r106);
    L9:
        if (r100.isEmpty() == true) goto L15;
        if (r100.peek().getHeight() != r108.getHeight()) goto L15;
        if (r100.peek().getHeight() == this.initialHeight) goto L15;
        HashTreeAddress r109 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r107.getLayerAddress()).withTreeAddress(r107.getTreeAddress()).withTreeHeight(r107.getTreeHeight()).withTreeIndex((r107.getTreeIndex() - 1) / 2).withKeyAndMask(r107.getKeyAndMask()).build();
        XMSSNode r110 = XMSSNodeUtil.randomizeHash(r101, r100.pop(), r108, r109);
        XMSSNode r111 = new XMSSNode(r110.getHeight() + 1, r110.getValue());
        r107 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r109.getLayerAddress()).withTreeAddress(r109.getTreeAddress()).withTreeHeight(r109.getTreeHeight() + 1).withTreeIndex(r109.getTreeIndex()).withKeyAndMask(r109.getKeyAndMask()).build();
        r108 = r111;
    L15:
        XMSSNode r112 = this.tailNode;
        if (r112 != null) goto L19;
        this.tailNode = r108;
    L23:
        if (this.tailNode.getHeight() != this.initialHeight) goto L25;
        this.finished = true;
        return;
    L25:
        this.height = r108.getHeight();
        this.nextIndex++;
        return;
    L19:
        if (r112.getHeight() != r108.getHeight()) goto L21;
        HashTreeAddress r113 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r107.getLayerAddress()).withTreeAddress(r107.getTreeAddress()).withTreeHeight(r107.getTreeHeight()).withTreeIndex((r107.getTreeIndex() - 1) / 2).withKeyAndMask(r107.getKeyAndMask()).build();
        r108 = new XMSSNode(this.tailNode.getHeight() + 1, XMSSNodeUtil.randomizeHash(r101, this.tailNode, r108, r113).getValue());
        this.tailNode = r108;
        HashTreeAddress r114 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r113.getLayerAddress()).withTreeAddress(r113.getTreeAddress()).withTreeHeight(r113.getTreeHeight() + 1).withTreeIndex(r113.getTreeIndex()).withKeyAndMask(r113.getKeyAndMask()).build();
        goto L23
    L21:
        r100.push(r108);
    L28:
        throw new IllegalStateException("finished or not initialized");
    L30:
        throw new NullPointerException("otsHashAddress == null");
    }
}
