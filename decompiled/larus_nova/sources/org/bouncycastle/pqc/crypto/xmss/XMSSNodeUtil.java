package org.bouncycastle.pqc.crypto.xmss;

/* JADX INFO: loaded from: classes42.dex */
class XMSSNodeUtil {
    public XMSSNodeUtil() {
    }

    public static XMSSNode lTree(WOTSPlus r100, WOTSPlusPublicKeyParameters r101, LTreeAddress r110) {
        if (r101 == null) goto L24;
        if (r110 == null) goto L22;
        int r102 = r100.getParams().getLen();
        byte[][] r103 = r101.toByteArray();
        XMSSNode[] r104 = new XMSSNode[r103.length];
        int r105 = 0;
    L6:
        if (r105 >= r103.length) goto L8;
        r104[r105] = new XMSSNode(0, r103[r105]);
        r105 = r105 + 1;
        goto L6
    L8:
        LTreeAddress.Builder r106 = new LTreeAddress.Builder().withLayerAddress(r110.getLayerAddress()).withTreeAddress(r110.getTreeAddress()).withLTreeAddress(r110.getLTreeAddress()).withTreeHeight(0).withTreeIndex(r110.getTreeIndex()).withKeyAndMask(r110.getKeyAndMask());
    L9:
        LTreeAddress r107 = (LTreeAddress) r106.build();
        if (r102 <= 1) goto L20;
        int r108 = 0;
    L12:
        double r109 = r102 / 2;
        if (r108 >= ((int) Math.floor(r109))) goto L16;
        r107 = (LTreeAddress) new LTreeAddress.Builder().withLayerAddress(r107.getLayerAddress()).withTreeAddress(r107.getTreeAddress()).withLTreeAddress(r107.getLTreeAddress()).withTreeHeight(r107.getTreeHeight()).withTreeIndex(r108).withKeyAndMask(r107.getKeyAndMask()).build();
        int r111 = r108 * 2;
        r104[r108] = randomizeHash(r100, r104[r111], r104[r111 + 1], r107);
        r108 = r108 + 1;
        goto L12
    L16:
        if ((r102 % 2) != 1) goto L18;
        r104[(int) Math.floor(r109)] = r104[r102 - 1];
    L18:
        r102 = (int) Math.ceil(((double) r102) / 2.0d);
        r106 = new LTreeAddress.Builder().withLayerAddress(r107.getLayerAddress()).withTreeAddress(r107.getTreeAddress()).withLTreeAddress(r107.getLTreeAddress()).withTreeHeight(r107.getTreeHeight() + 1).withTreeIndex(r107.getTreeIndex()).withKeyAndMask(r107.getKeyAndMask());
        goto L9
    L20:
        return r104[0];
    L22:
        throw new NullPointerException("address == null");
    L24:
        throw new NullPointerException("publicKey == null");
    }

    public static XMSSNode randomizeHash(WOTSPlus r100, XMSSNode r101, XMSSNode r110, XMSSAddress r111) {
        if (r101 == null) goto L39;
        if (r110 == null) goto L37;
        if (r101.getHeight() != r110.getHeight()) goto L35;
        if (r111 == null) goto L33;
        byte[] r102 = r100.getPublicSeed();
        int r103 = 0;
        if ((r111 instanceof LTreeAddress) == false) goto L11;
        LTreeAddress r112 = (LTreeAddress) r111;
        r111 = (LTreeAddress) new LTreeAddress.Builder().withLayerAddress(r112.getLayerAddress()).withTreeAddress(r112.getTreeAddress()).withLTreeAddress(r112.getLTreeAddress()).withTreeHeight(r112.getTreeHeight()).withTreeIndex(r112.getTreeIndex()).withKeyAndMask(0).build();
    L13:
        byte[] r104 = r100.getKhf().PRF(r102, r111.toByteArray());
        if ((r111 instanceof LTreeAddress) == false) goto L17;
        LTreeAddress r113 = (LTreeAddress) r111;
        r111 = (LTreeAddress) new LTreeAddress.Builder().withLayerAddress(r113.getLayerAddress()).withTreeAddress(r113.getTreeAddress()).withLTreeAddress(r113.getLTreeAddress()).withTreeHeight(r113.getTreeHeight()).withTreeIndex(r113.getTreeIndex()).withKeyAndMask(1).build();
    L19:
        byte[] r105 = r100.getKhf().PRF(r102, r111.toByteArray());
        if ((r111 instanceof LTreeAddress) == false) goto L23;
        LTreeAddress r114 = (LTreeAddress) r111;
        r111 = (LTreeAddress) new LTreeAddress.Builder().withLayerAddress(r114.getLayerAddress()).withTreeAddress(r114.getTreeAddress()).withLTreeAddress(r114.getLTreeAddress()).withTreeHeight(r114.getTreeHeight()).withTreeIndex(r114.getTreeIndex()).withKeyAndMask(2).build();
    L25:
        byte[] r115 = r100.getKhf().PRF(r102, r111.toByteArray());
        int r106 = r100.getParams().getTreeDigestSize();
        byte[] r107 = new byte[r106 * 2];
        int r108 = 0;
    L26:
        if (r108 >= r106) goto L28;
        r107[r108] = (byte) (r101.getValue()[r108] ^ r105[r108]);
        r108 = r108 + 1;
    L28:
        if (r103 >= r106) goto L30;
        r107[r103 + r106] = (byte) (r110.getValue()[r103] ^ r115[r103]);
        r103 = r103 + 1;
        goto L28
    L30:
        byte[] r109 = r100.getKhf().H(r104, r107);
        return new XMSSNode(r101.getHeight(), r109);
    L23:
        if ((r111 instanceof HashTreeAddress) == false) goto L25;
        HashTreeAddress r116 = (HashTreeAddress) r111;
        r111 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r116.getLayerAddress()).withTreeAddress(r116.getTreeAddress()).withTreeHeight(r116.getTreeHeight()).withTreeIndex(r116.getTreeIndex()).withKeyAndMask(2).build();
        goto L25
    L17:
        if ((r111 instanceof HashTreeAddress) == false) goto L19;
        HashTreeAddress r117 = (HashTreeAddress) r111;
        r111 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r117.getLayerAddress()).withTreeAddress(r117.getTreeAddress()).withTreeHeight(r117.getTreeHeight()).withTreeIndex(r117.getTreeIndex()).withKeyAndMask(1).build();
        goto L19
    L11:
        if ((r111 instanceof HashTreeAddress) == false) goto L13;
        HashTreeAddress r118 = (HashTreeAddress) r111;
        r111 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r118.getLayerAddress()).withTreeAddress(r118.getTreeAddress()).withTreeHeight(r118.getTreeHeight()).withTreeIndex(r118.getTreeIndex()).withKeyAndMask(0).build();
        goto L13
    L33:
        throw new NullPointerException("address == null");
    L35:
        throw new IllegalStateException("height of both nodes must be equal");
    L37:
        throw new NullPointerException("right == null");
    L39:
        throw new NullPointerException("left == null");
    }
}
