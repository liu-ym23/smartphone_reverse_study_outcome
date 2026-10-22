package org.bouncycastle.pqc.crypto.xmss;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes42.dex */
class XMSSVerifierUtil {
    public XMSSVerifierUtil() {
    }

    public static XMSSNode getRootNodeFromSignature(WOTSPlus r100, int r110, byte[] r111, XMSSReducedSignature r112, OTSHashAddress r113, int r114) {
        if (r111.length != r100.getParams().getTreeDigestSize()) goto L20;
        if (r112 == null) goto L18;
        if (r113 == null) goto L16;
        LTreeAddress r101 = (LTreeAddress) new LTreeAddress.Builder().withLayerAddress(r113.getLayerAddress()).withTreeAddress(r113.getTreeAddress()).withLTreeAddress(r113.getOTSAddress()).build();
        HashTreeAddress r102 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r113.getLayerAddress()).withTreeAddress(r113.getTreeAddress()).withTreeIndex(r113.getOTSAddress()).build();
        XMSSNode[] r103 = new XMSSNode[2];
        r103[0] = XMSSNodeUtil.lTree(r100, r100.getPublicKeyFromSignature(r111, r112.getWOTSPlusSignature(), r113), r101);
        int r115 = 0;
    L7:
        if (r115 >= r110) goto L14;
        HashTreeAddress r104 = (HashTreeAddress) new HashTreeAddress.Builder().withLayerAddress(r102.getLayerAddress()).withTreeAddress(r102.getTreeAddress()).withTreeHeight(r115).withTreeIndex(r102.getTreeIndex()).withKeyAndMask(r102.getKeyAndMask()).build();
        if ((Math.floor(r114 / (1 << r115)) % 2.0d) != AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        HashTreeAddress.Builder r105 = new HashTreeAddress.Builder();
        r102 = (HashTreeAddress) r105.withLayerAddress(r104.getLayerAddress()).withTreeAddress(r104.getTreeAddress()).withTreeHeight(r104.getTreeHeight()).withTreeIndex(r104.getTreeIndex() / 2).withKeyAndMask(r104.getKeyAndMask()).build();
        XMSSNode r106 = XMSSNodeUtil.randomizeHash(r100, r103[0], (XMSSNode) ListProtector.get(r112.getAuthPath(), r115), r102);
        r103[1] = r106;
        r103[1] = new XMSSNode(r106.getHeight() + 1, r103[1].getValue());
    L12:
        r103[0] = r103[1];
        r115 = r115 + 1;
        goto L7
    L11:
        r105 = new HashTreeAddress.Builder();
        r102 = (HashTreeAddress) r105.withLayerAddress(r104.getLayerAddress()).withTreeAddress(r104.getTreeAddress()).withTreeHeight(r104.getTreeHeight()).withTreeIndex((r104.getTreeIndex() - 1) / 2).withKeyAndMask(r104.getKeyAndMask()).build();
        XMSSNode r107 = XMSSNodeUtil.randomizeHash(r100, (XMSSNode) ListProtector.get(r112.getAuthPath(), r115), r103[0], r102);
        r103[1] = r107;
        r103[1] = new XMSSNode(r107.getHeight() + 1, r103[1].getValue());
        goto L12
    L14:
        return r103[0];
    L16:
        throw new NullPointerException("otsHashAddress == null");
    L18:
        throw new NullPointerException("signature == null");
    L20:
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }
}
