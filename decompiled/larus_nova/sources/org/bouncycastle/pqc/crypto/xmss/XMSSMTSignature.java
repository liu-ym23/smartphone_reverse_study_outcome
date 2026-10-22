package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSMTSignature implements XMSSStoreableObjectInterface, Encodable {
    private final long index;
    private final XMSSMTParameters params;
    private final byte[] random;
    private final List<XMSSReducedSignature> reducedSignatures;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSMTSignature$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private long index;
        private final XMSSMTParameters params;
        private byte[] random;
        private List<XMSSReducedSignature> reducedSignatures;
        private byte[] signature;

        public Builder(XMSSMTParameters r100) {
            this.index = 0;
            this.random = null;
            this.reducedSignatures = null;
            this.signature = null;
            this.params = r100;
        }

        public static /* synthetic */ XMSSMTParameters access$000(Builder r100) {
            return r100.params;
        }

        public static /* synthetic */ byte[] access$100(Builder r100) {
            return r100.signature;
        }

        public static /* synthetic */ long access$200(Builder r100) {
            return r100.index;
        }

        public static /* synthetic */ byte[] access$300(Builder r100) {
            return r100.random;
        }

        public static /* synthetic */ List access$400(Builder r100) {
            return r100.reducedSignatures;
        }

        public XMSSMTSignature build() {
            return new XMSSMTSignature(this, null);
        }

        public Builder withIndex(long r100) {
            this.index = r100;
            return this;
        }

        public Builder withRandom(byte[] r100) {
            this.random = XMSSUtil.cloneArray(r100);
            return this;
        }

        public Builder withReducedSignatures(List<XMSSReducedSignature> r100) {
            this.reducedSignatures = r100;
            return this;
        }

        public Builder withSignature(byte[] r100) {
            this.signature = Arrays.clone(r100);
            return this;
        }
    }

    private XMSSMTSignature(Builder r100) {
        XMSSMTParameters r101 = Builder.access$000(r100);
        this.params = r101;
        if (r101 == null) goto L33;
        int r102 = r101.getTreeDigestSize();
        byte[] r103 = Builder.access$100(r100);
        if (r103 == null) goto L18;
        int r104 = r101.getWOTSPlus().getParams().getLen();
        int r105 = (int) Math.ceil(((double) r101.getHeight()) / 8.0d);
        int r106 = ((r101.getHeight() / r101.getLayers()) + r104) * r102;
        int r107 = r105 + r102;
        int r108 = r107 + (r101.getLayers() * r106);
        if (r103.length != r108) goto L17;
        long r109 = XMSSUtil.bytesToXBigEndian(r103, 0, r105);
        this.index = r109;
        if (XMSSUtil.isIndexValid(r101.getHeight(), r109) == false) goto L15;
        int r110 = r105 + 0;
        this.random = XMSSUtil.extractBytesAtOffset(r103, r110, r102);
        int r111 = r110 + r102;
        this.reducedSignatures = new ArrayList();
    L12:
        if (r111 >= r103.length) goto L35;
        XMSSReducedSignature r112 = new XMSSReducedSignature.Builder(this.params.getXMSSParameters()).withReducedSignature(XMSSUtil.extractBytesAtOffset(r103, r111, r106)).build();
        this.reducedSignatures.add(r112);
        r111 = r111 + r106;
        goto L12
    L35:
        return;
    L15:
        throw new IllegalArgumentException("index out of bounds");
    L17:
        throw new IllegalArgumentException("signature has wrong size");
    L18:
        this.index = Builder.access$200(r100);
        byte[] r113 = Builder.access$300(r100);
        if (r113 != null) goto L21;
        this.random = new byte[r102];
    L26:
        List<XMSSReducedSignature> r114 = Builder.access$400(r100);
        if (r114 != null) goto L30;
        r114 = new ArrayList();
    L30:
        this.reducedSignatures = r114;
        return;
    L21:
        if (r113.length != r102) goto L24;
        this.random = r113;
        goto L26
    L24:
        throw new IllegalArgumentException("size of random needs to be equal to size of digest");
    L33:
        throw new NullPointerException("params == null");
    }

    public /* synthetic */ XMSSMTSignature(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    public long getIndex() {
        return this.index;
    }

    public byte[] getRandom() {
        return XMSSUtil.cloneArray(this.random);
    }

    public List<XMSSReducedSignature> getReducedSignatures() {
        return this.reducedSignatures;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        int r100 = this.params.getTreeDigestSize();
        int r101 = this.params.getWOTSPlus().getParams().getLen();
        int r102 = (int) Math.ceil(((double) this.params.getHeight()) / 8.0d);
        int r103 = ((this.params.getHeight() / this.params.getLayers()) + r101) * r100;
        int r104 = r102 + r100;
        byte[] r105 = new byte[r104 + (this.params.getLayers() * r103)];
        XMSSUtil.copyBytesAtOffset(r105, XMSSUtil.toBytesBigEndian(this.index, r102), 0);
        int r106 = r102 + 0;
        XMSSUtil.copyBytesAtOffset(r105, this.random, r106);
        int r107 = r106 + r100;
        Iterator<XMSSReducedSignature> r108 = this.reducedSignatures.iterator();
    L4:
        if (r108.hasNext() == false) goto L6;
        XMSSUtil.copyBytesAtOffset(r105, r108.next().toByteArray(), r107);
        r107 = r107 + r103;
        goto L4
    L6:
        return r105;
    }
}
