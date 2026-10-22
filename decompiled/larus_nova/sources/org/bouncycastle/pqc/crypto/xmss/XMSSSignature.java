package org.bouncycastle.pqc.crypto.xmss;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSSignature extends XMSSReducedSignature implements Encodable {
    private final int index;
    private final byte[] random;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSSignature$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder extends XMSSReducedSignature.Builder {
        private int index;
        private final XMSSParameters params;
        private byte[] random;

        public Builder(XMSSParameters r100) {
            super(r100);
            this.index = 0;
            this.random = null;
            this.params = r100;
        }

        public static /* synthetic */ int access$000(Builder r100) {
            return r100.index;
        }

        public static /* synthetic */ byte[] access$100(Builder r100) {
            return r100.random;
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSReducedSignature.Builder
        public /* bridge */ /* synthetic */ XMSSReducedSignature build() {
            return build();
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSReducedSignature.Builder
        public XMSSSignature build() {
            return new XMSSSignature(this, null);
        }

        public Builder withIndex(int r100) {
            this.index = r100;
            return this;
        }

        public Builder withRandom(byte[] r100) {
            this.random = XMSSUtil.cloneArray(r100);
            return this;
        }

        public Builder withSignature(byte[] r100) {
            if (r100 == null) goto L6;
            int r101 = this.params.getTreeDigestSize();
            int r102 = this.params.getWOTSPlus().getParams().getLen();
            int r103 = this.params.getHeight() * r101;
            this.index = Pack.bigEndianToInt(r100, 0);
            this.random = XMSSUtil.extractBytesAtOffset(r100, 4, r101);
            withReducedSignature(XMSSUtil.extractBytesAtOffset(r100, 4 + r101, (r102 * r101) + r103));
            return this;
        L6:
            throw new NullPointerException("signature == null");
        }
    }

    private XMSSSignature(Builder r100) {
        super(r100);
        this.index = Builder.access$000(r100);
        int r101 = getParams().getTreeDigestSize();
        byte[] r102 = Builder.access$100(r100);
        if (r102 != null) goto L5;
        this.random = new byte[r101];
        return;
    L5:
        if (r102.length != r101) goto L8;
        this.random = r102;
        return;
    L8:
        throw new IllegalArgumentException("size of random needs to be equal to size of digest");
    }

    public /* synthetic */ XMSSSignature(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    public int getIndex() {
        return this.index;
    }

    public byte[] getRandom() {
        return XMSSUtil.cloneArray(this.random);
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSReducedSignature, org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        int r100 = getParams().getTreeDigestSize();
        int r101 = getParams().getWOTSPlus().getParams().getLen() * r100;
        int r102 = (r100 + 4) + r101;
        byte[] r103 = new byte[r102 + (getParams().getHeight() * r100)];
        int r104 = 0;
        Pack.intToBigEndian(this.index, r103, 0);
        XMSSUtil.copyBytesAtOffset(r103, this.random, 4);
        int r105 = 4 + r100;
        byte[][] r106 = getWOTSPlusSignature().toByteArray();
        int r107 = 0;
    L4:
        if (r107 >= r106.length) goto L7;
        XMSSUtil.copyBytesAtOffset(r103, r106[r107], r105);
        r105 = r105 + r100;
        r107 = r107 + 1;
    L7:
        if (r104 >= getAuthPath().size()) goto L9;
        XMSSUtil.copyBytesAtOffset(r103, ((XMSSNode) ListProtector.get(getAuthPath(), r104)).getValue(), r105);
        r105 = r105 + r100;
        r104 = r104 + 1;
        goto L7
    L9:
        return r103;
    }
}
