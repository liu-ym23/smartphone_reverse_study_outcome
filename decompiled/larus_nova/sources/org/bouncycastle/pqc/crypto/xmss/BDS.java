package org.bouncycastle.pqc.crypto.xmss;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public final class BDS implements Serializable {
    private static final long serialVersionUID = 1;
    private List<XMSSNode> authenticationPath;
    private int index;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f525592k;
    private Map<Integer, XMSSNode> keep;
    private transient int maxIndex;
    private Map<Integer, LinkedList<XMSSNode>> retain;
    private XMSSNode root;
    private Stack<XMSSNode> stack;
    private final List<BDSTreeHash> treeHashInstances;
    private final int treeHeight;
    private boolean used;
    private transient WOTSPlus wotsPlus;

    public BDS(BDS r100) {
        this.wotsPlus = new WOTSPlus(r100.wotsPlus.getParams());
        this.treeHeight = r100.treeHeight;
        this.f525592k = r100.f525592k;
        this.root = r100.root;
        ArrayList r101 = new ArrayList();
        this.authenticationPath = r101;
        r101.addAll(r100.authenticationPath);
        this.retain = new TreeMap();
        Iterator<Integer> r102 = r100.retain.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Integer r103 = r102.next();
        this.retain.put(r103, (LinkedList) r100.retain.get(r103).clone());
        goto L4
    L6:
        Stack<XMSSNode> r104 = new Stack();
        this.stack = r104;
        r104.addAll(r100.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> r105 = r100.treeHashInstances.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        this.treeHashInstances.add(r105.next().m10989clone());
        goto L8
    L10:
        this.keep = new TreeMap(r100.keep);
        this.index = r100.index;
        this.maxIndex = r100.maxIndex;
        this.used = r100.used;
    }

    private BDS(BDS r100, int r101, ASN1ObjectIdentifier r102) {
        this.wotsPlus = new WOTSPlus(new WOTSPlusParameters(r102));
        this.treeHeight = r100.treeHeight;
        this.f525592k = r100.f525592k;
        this.root = r100.root;
        ArrayList r103 = new ArrayList();
        this.authenticationPath = r103;
        r103.addAll(r100.authenticationPath);
        this.retain = new TreeMap();
        Iterator<Integer> r104 = r100.retain.keySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Integer r105 = r104.next();
        this.retain.put(r105, (LinkedList) r100.retain.get(r105).clone());
        goto L4
    L6:
        Stack<XMSSNode> r106 = new Stack();
        this.stack = r106;
        r106.addAll(r100.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> r107 = r100.treeHashInstances.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        this.treeHashInstances.add(r107.next().m10989clone());
        goto L8
    L10:
        this.keep = new TreeMap(r100.keep);
        this.index = r100.index;
        this.maxIndex = r101;
        this.used = r100.used;
        validate();
    }

    private BDS(BDS r100, ASN1ObjectIdentifier r101) {
        this.wotsPlus = new WOTSPlus(new WOTSPlusParameters(r101));
        this.treeHeight = r100.treeHeight;
        this.f525592k = r100.f525592k;
        this.root = r100.root;
        ArrayList r102 = new ArrayList();
        this.authenticationPath = r102;
        r102.addAll(r100.authenticationPath);
        this.retain = new TreeMap();
        Iterator<Integer> r103 = r100.retain.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Integer r104 = r103.next();
        this.retain.put(r104, (LinkedList) r100.retain.get(r104).clone());
        goto L4
    L6:
        Stack<XMSSNode> r105 = new Stack();
        this.stack = r105;
        r105.addAll(r100.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> r106 = r100.treeHashInstances.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        this.treeHashInstances.add(r106.next().m10989clone());
        goto L8
    L10:
        this.keep = new TreeMap(r100.keep);
        this.index = r100.index;
        this.maxIndex = r100.maxIndex;
        this.used = r100.used;
        validate();
    }

    private BDS(BDS r100, byte[] r101, byte[] r102, OTSHashAddress r103) {
        this.wotsPlus = new WOTSPlus(r100.wotsPlus.getParams());
        this.treeHeight = r100.treeHeight;
        this.f525592k = r100.f525592k;
        this.root = r100.root;
        ArrayList r104 = new ArrayList();
        this.authenticationPath = r104;
        r104.addAll(r100.authenticationPath);
        this.retain = new TreeMap();
        Iterator<Integer> r105 = r100.retain.keySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Integer r106 = r105.next();
        this.retain.put(r106, (LinkedList) r100.retain.get(r106).clone());
        goto L4
    L6:
        Stack<XMSSNode> r107 = new Stack();
        this.stack = r107;
        r107.addAll(r100.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> r108 = r100.treeHashInstances.iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        this.treeHashInstances.add(r108.next().m10989clone());
        goto L8
    L10:
        this.keep = new TreeMap(r100.keep);
        this.index = r100.index;
        this.maxIndex = r100.maxIndex;
        this.used = false;
        nextAuthenticationPath(r101, r102, r103);
    }

    private BDS(WOTSPlus r100, int r101, int r102, int r103) {
        this.wotsPlus = r100;
        this.treeHeight = r101;
        this.maxIndex = r103;
        this.f525592k = r102;
        if (r102 > r101) goto L14;
        if (r102 < 2) goto L14;
        int r104 = r101 - r102;
        if ((r104 % 2) != 0) goto L14;
        this.authenticationPath = new ArrayList();
        this.retain = new TreeMap();
        this.stack = new Stack();
        this.treeHashInstances = new ArrayList();
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L11;
        this.treeHashInstances.add(new BDSTreeHash(r105));
        r105 = r105 + 1;
        goto L9
    L11:
        this.keep = new TreeMap();
        this.index = 0;
        this.used = false;
        return;
    L14:
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    public BDS(XMSSParameters r100, int r101, int r102) {
        this(r100.getWOTSPlus(), r100.getHeight(), r100.getK(), r102);
        this.maxIndex = r101;
        this.index = r102;
        this.used = true;
    }

    public BDS(XMSSParameters r100, byte[] r101, byte[] r102, OTSHashAddress r103) {
        this(r100.getWOTSPlus(), r100.getHeight(), r100.getK(), (1 << r100.getHeight()) - 1);
        initialize(r101, r102, r103);
    }

    public BDS(XMSSParameters r100, byte[] r101, byte[] r102, OTSHashAddress r103, int r104) {
        this(r100.getWOTSPlus(), r100.getHeight(), r100.getK(), (1 << r100.getHeight()) - 1);
        initialize(r101, r102, r103);
    L4:
        if (this.index >= r104) goto L6;
        nextAuthenticationPath(r101, r102, r103);
        this.used = false;
        goto L4
    }

    private BDSTreeHash getBDSTreeHashInstanceForUpdate() {
        Iterator<BDSTreeHash> r100 = this.treeHashInstances.iterator();
        BDSTreeHash r101 = null;
    L4:
        if (r100.hasNext() == false) goto L20;
        BDSTreeHash r102 = r100.next();
        if (r102.isFinished() == true) goto L4;
        if (r102.isInitialized() == false) goto L4;
        if (r101 == null) goto L14;
        if (r102.getHeight() < r101.getHeight()) goto L14;
        if (r102.getHeight() != r101.getHeight()) goto L4;
        if (r102.getIndexLeaf() >= r101.getIndexLeaf()) goto L4;
    L14:
        r101 = r102;
        goto L4
    L20:
        return r101;
    }

    private void initialize(byte[] r110, byte[] r111, OTSHashAddress r112) {
        if (r112 == null) goto L35;
        LTreeAddress r100 = (LTreeAddress) new LTreeAddress.Builder().withLayerAddress(r112.getLayerAddress()).withTreeAddress(r112.getTreeAddress()).build();
        HashTreeAddress r101 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r112.getLayerAddress()).withTreeAddress(r112.getTreeAddress()).build();
        int r102 = 0;
    L5:
        if (r102 >= (1 << this.treeHeight)) goto L32;
        r112 = (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r112.getLayerAddress()).withTreeAddress(r112.getTreeAddress()).withOTSAddress(r102).withChainAddress(r112.getChainAddress()).withHashAddress(r112.getHashAddress()).withKeyAndMask(r112.getKeyAndMask()).build();
        WOTSPlus r103 = this.wotsPlus;
        r103.importKeys(r103.getWOTSPlusSecretKey(r111, r112), r110);
        WOTSPlusPublicKeyParameters r104 = this.wotsPlus.getPublicKey(r112);
        r100 = (LTreeAddress) new LTreeAddress.Builder().withLayerAddress(r100.getLayerAddress()).withTreeAddress(r100.getTreeAddress()).withLTreeAddress(r102).withTreeHeight(r100.getTreeHeight()).withTreeIndex(r100.getTreeIndex()).withKeyAndMask(r100.getKeyAndMask()).build();
        XMSSNode r105 = XMSSNodeUtil.lTree(this.wotsPlus, r104, r100);
        r101 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r101.getLayerAddress()).withTreeAddress(r101.getTreeAddress()).withTreeIndex(r102).withKeyAndMask(r101.getKeyAndMask()).build();
    L8:
        if (this.stack.isEmpty() == true) goto L31;
        if (this.stack.peek().getHeight() != r105.getHeight()) goto L31;
        int r106 = r102 / (1 << r105.getHeight());
        if (r106 != 1) goto L15;
        this.authenticationPath.add(r105);
    L15:
        if (r106 == 3) goto L17;
    L19:
        if (r106 < 3) goto L30;
        if ((r106 & 1) != 1) goto L30;
        if (r105.getHeight() < (this.treeHeight - this.f525592k)) goto L30;
        if (r105.getHeight() > (this.treeHeight - 2)) goto L30;
        if (this.retain.get(Integer.valueOf(r105.getHeight())) != null) goto L29;
        LinkedList<XMSSNode> r107 = new LinkedList();
        r107.add(r105);
        this.retain.put(Integer.valueOf(r105.getHeight()), r107);
        goto L30
    L29:
        this.retain.get(Integer.valueOf(r105.getHeight())).add(r105);
    L30:
        HashTreeAddress r108 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r101.getLayerAddress()).withTreeAddress(r101.getTreeAddress()).withTreeHeight(r101.getTreeHeight()).withTreeIndex((r101.getTreeIndex() - 1) / 2).withKeyAndMask(r101.getKeyAndMask()).build();
        XMSSNode r109 = XMSSNodeUtil.randomizeHash(this.wotsPlus, this.stack.pop(), r105, r108);
        XMSSNode r113 = new XMSSNode(r109.getHeight() + 1, r109.getValue());
        r101 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r108.getLayerAddress()).withTreeAddress(r108.getTreeAddress()).withTreeHeight(r108.getTreeHeight() + 1).withTreeIndex(r108.getTreeIndex()).withKeyAndMask(r108.getKeyAndMask()).build();
        r105 = r113;
        goto L8
    L17:
        if (r105.getHeight() >= (this.treeHeight - this.f525592k)) goto L19;
        ((BDSTreeHash) ListProtector.get(this.treeHashInstances, r105.getHeight())).setNode(r105);
    L31:
        this.stack.push(r105);
        r102 = r102 + 1;
        goto L5
    L32:
        this.root = this.stack.pop();
        return;
    L35:
        throw new NullPointerException("otsHashAddress == null");
    }

    private void nextAuthenticationPath(byte[] r110, byte[] r111, OTSHashAddress r112) {
        if (r112 == null) goto L41;
        if (this.used == true) goto L39;
        int r100 = this.index;
        if (r100 > (this.maxIndex - 1)) goto L37;
        int r101 = XMSSUtil.calculateTau(r100, this.treeHeight);
        if (((this.index >> (r101 + 1)) & 1) == 0) goto L10;
    L12:
        LTreeAddress r102 = (LTreeAddress) new LTreeAddress.Builder().withLayerAddress(r112.getLayerAddress()).withTreeAddress(r112.getTreeAddress()).build();
        HashTreeAddress r103 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r112.getLayerAddress()).withTreeAddress(r112.getTreeAddress()).build();
        int r104 = 0;
        if (r101 != 0) goto L15;
        r112 = (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r112.getLayerAddress()).withTreeAddress(r112.getTreeAddress()).withOTSAddress(this.index).withChainAddress(r112.getChainAddress()).withHashAddress(r112.getHashAddress()).withKeyAndMask(r112.getKeyAndMask()).build();
        WOTSPlus r105 = this.wotsPlus;
        r105.importKeys(r105.getWOTSPlusSecretKey(r111, r112), r110);
        ListProtector.set(this.authenticationPath, 0, XMSSNodeUtil.lTree(this.wotsPlus, this.wotsPlus.getPublicKey(r112), (LTreeAddress) new LTreeAddress.Builder().withLayerAddress(r102.getLayerAddress()).withTreeAddress(r102.getTreeAddress()).withLTreeAddress(this.index).withTreeHeight(r102.getTreeHeight()).withTreeIndex(r102.getTreeIndex()).withKeyAndMask(r102.getKeyAndMask()).build()));
    L29:
        if (r104 >= ((this.treeHeight - this.f525592k) >> 1)) goto L34;
        BDSTreeHash r106 = getBDSTreeHashInstanceForUpdate();
        if (r106 == null) goto L33;
        r106.update(this.stack, this.wotsPlus, r110, r111, r112);
    L33:
        r104 = r104 + 1;
        goto L29
    L34:
        this.index++;
        return;
    L15:
        int r107 = r101 - 1;
        HashTreeAddress r108 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r103.getLayerAddress()).withTreeAddress(r103.getTreeAddress()).withTreeHeight(r107).withTreeIndex(this.index >> r101).withKeyAndMask(r103.getKeyAndMask()).build();
        WOTSPlus r109 = this.wotsPlus;
        r109.importKeys(r109.getWOTSPlusSecretKey(r111, r112), r110);
        XMSSNode r113 = XMSSNodeUtil.randomizeHash(this.wotsPlus, (XMSSNode) ListProtector.get(this.authenticationPath, r107), this.keep.get(Integer.valueOf(r107)), r108);
        ListProtector.set(this.authenticationPath, r101, new XMSSNode(r113.getHeight() + 1, r113.getValue()));
        this.keep.remove(Integer.valueOf(r107));
        int r114 = 0;
    L16:
        if (r114 >= r101) goto L22;
        if (r114 >= (this.treeHeight - this.f525592k)) goto L20;
        List<XMSSNode> r115 = this.authenticationPath;
        XMSSNode r116 = ((BDSTreeHash) ListProtector.get(this.treeHashInstances, r114)).getTailNode();
    L21:
        ListProtector.set(r115, r114, r116);
        r114 = r114 + 1;
        goto L16
    L20:
        r115 = this.authenticationPath;
        r116 = this.retain.get(Integer.valueOf(r114)).removeFirst();
        goto L21
    L22:
        int r117 = Math.min(r101, this.treeHeight - this.f525592k);
        int r118 = 0;
    L23:
        if (r118 >= r117) goto L29;
        int r119 = (this.index + 1) + ((1 << r118) * 3);
        if (r119 >= (1 << this.treeHeight)) goto L27;
        ((BDSTreeHash) ListProtector.get(this.treeHashInstances, r118)).initialize(r119);
    L27:
        r118 = r118 + 1;
        goto L23
    L10:
        if (r101 >= (this.treeHeight - 1)) goto L12;
        this.keep.put(Integer.valueOf(r101), (XMSSNode) ListProtector.get(this.authenticationPath, r101));
        goto L12
    L37:
        throw new IllegalStateException("index out of bounds");
    L39:
        throw new IllegalStateException("index already used");
    L41:
        throw new NullPointerException("otsHashAddress == null");
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        if (r100.available() == 0) goto L5;
        int r101 = r100.readInt();
    L6:
        this.maxIndex = r101;
        int r102 = this.maxIndex;
        if (r102 > ((1 << this.treeHeight) - 1)) goto L14;
        if (this.index > (r102 + 1)) goto L14;
        if (r100.available() != 0) goto L14;
        return;
    L14:
        throw new IOException("inconsistent BDS data detected");
    L5:
        r101 = (1 << this.treeHeight) - 1;
        goto L6
    }

    private void validate() {
        if (this.authenticationPath == null) goto L26;
        if (this.retain == null) goto L24;
        if (this.stack == null) goto L22;
        if (this.treeHashInstances == null) goto L20;
        if (this.keep == null) goto L18;
        if (XMSSUtil.isIndexValid(this.treeHeight, this.index) == false) goto L16;
        return;
    L16:
        throw new IllegalStateException("index in BDS state out of bounds");
    L18:
        throw new IllegalStateException("keep == null");
    L20:
        throw new IllegalStateException("treeHashInstances == null");
    L22:
        throw new IllegalStateException("stack == null");
    L24:
        throw new IllegalStateException("retain == null");
    L26:
        throw new IllegalStateException("authenticationPath == null");
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeInt(this.maxIndex);
    }

    public List<XMSSNode> getAuthenticationPath() {
        ArrayList r100 = new ArrayList();
        Iterator<XMSSNode> r101 = this.authenticationPath.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add(r101.next());
        goto L4
    L6:
        return r100;
    }

    public int getIndex() {
        return this.index;
    }

    public int getMaxIndex() {
        return this.maxIndex;
    }

    public BDS getNextState(byte[] r100, byte[] r101, OTSHashAddress r102) {
        return new BDS(this, r100, r101, r102);
    }

    public XMSSNode getRoot() {
        return this.root;
    }

    public int getTreeHeight() {
        return this.treeHeight;
    }

    public boolean isUsed() {
        return this.used;
    }

    public void markUsed() {
        this.used = true;
    }

    public BDS withMaxIndex(int r100, ASN1ObjectIdentifier r101) {
        return new BDS(this, r100, r101);
    }

    public BDS withWOTSDigest(ASN1ObjectIdentifier r100) {
        return new BDS(this, r100);
    }
}
