package org.bouncycastle.pqc.crypto.xmss;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSReducedSignature implements XMSSStoreableObjectInterface {
    private final List<XMSSNode> authPath;
    private final XMSSParameters params;
    private final WOTSPlusSignature wotsPlusSignature;

    public static class Builder {
        private List<XMSSNode> authPath;
        private final XMSSParameters params;
        private byte[] reducedSignature;
        private WOTSPlusSignature wotsPlusSignature;

        public Builder(XMSSParameters r100) {
            this.wotsPlusSignature = null;
            this.authPath = null;
            this.reducedSignature = null;
            this.params = r100;
        }

        public static /* synthetic */ XMSSParameters access$000(Builder r100) {
            return r100.params;
        }

        public static /* synthetic */ byte[] access$100(Builder r100) {
            return r100.reducedSignature;
        }

        public static /* synthetic */ WOTSPlusSignature access$200(Builder r100) {
            return r100.wotsPlusSignature;
        }

        public static /* synthetic */ List access$300(Builder r100) {
            return r100.authPath;
        }

        public XMSSReducedSignature build() {
            return new XMSSReducedSignature(this);
        }

        public Builder withAuthPath(List<XMSSNode> r100) {
            this.authPath = r100;
            return this;
        }

        public Builder withReducedSignature(byte[] r100) {
            this.reducedSignature = XMSSUtil.cloneArray(r100);
            return this;
        }

        public Builder withWOTSPlusSignature(WOTSPlusSignature r100) {
            this.wotsPlusSignature = r100;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.util.List<org.bouncycastle.pqc.crypto.xmss.XMSSNode>] */
    public XMSSReducedSignature(Builder r100) {
        XMSSParameters r101 = Builder.access$000(r100);
        this.params = r101;
        if (r101 == null) goto L31;
        int r102 = r101.getTreeDigestSize();
        int r103 = r101.getWOTSPlus().getParams().getLen();
        int r104 = r101.getHeight();
        byte[] r105 = Builder.access$100(r100);
        int r106 = 0;
        if (r105 != null) goto L7;
        WOTSPlusSignature r107 = Builder.access$200(r100);
        if (r107 != null) goto L20;
        r107 = new WOTSPlusSignature(r101.getWOTSPlus().getParams(), (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r103, r102}));
    L20:
        this.wotsPlusSignature = r107;
        ?? r108 = Builder.access$300(r100);
        if (r108 != 0) goto L23;
        r108 = new ArrayList();
    L28:
        this.authPath = r108;
        return;
    L23:
        if (r108.size() == r104) goto L28;
        throw new IllegalArgumentException("size of authPath needs to be equal to height of tree");
    L7:
        if (r105.length != ((r103 * r102) + (r104 * r102))) goto L15;
        byte[][] r109 = new byte[r103][];
        int r110 = 0;
        int r111 = 0;
    L9:
        if (r110 >= r103) goto L11;
        r109[r110] = XMSSUtil.extractBytesAtOffset(r105, r111, r102);
        r111 = r111 + r102;
        r110 = r110 + 1;
        goto L9
    L11:
        this.wotsPlusSignature = new WOTSPlusSignature(this.params.getWOTSPlus().getParams(), r109);
        r108 = new ArrayList();
    L12:
        if (r106 >= r104) goto L28;
        r108.add(new XMSSNode(r106, XMSSUtil.extractBytesAtOffset(r105, r111, r102)));
        r111 = r111 + r102;
        r106 = r106 + 1;
        goto L12
    L15:
        throw new IllegalArgumentException("signature has wrong size");
    L31:
        throw new NullPointerException("params == null");
    }

    public List<XMSSNode> getAuthPath() {
        return this.authPath;
    }

    public XMSSParameters getParams() {
        return this.params;
    }

    public WOTSPlusSignature getWOTSPlusSignature() {
        return this.wotsPlusSignature;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        int r100 = this.params.getTreeDigestSize();
        byte[] r101 = new byte[(this.params.getWOTSPlus().getParams().getLen() * r100) + (this.params.getHeight() * r100)];
        byte[][] r102 = this.wotsPlusSignature.toByteArray();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r102.length) goto L7;
        XMSSUtil.copyBytesAtOffset(r101, r102[r104], r105);
        r105 = r105 + r100;
        r104 = r104 + 1;
    L7:
        if (r103 >= this.authPath.size()) goto L9;
        XMSSUtil.copyBytesAtOffset(r101, ((XMSSNode) ListProtector.get(this.authPath, r103)).getValue(), r105);
        r105 = r105 + r100;
        r103 = r103 + 1;
        goto L7
    L9:
        return r101;
    }
}
