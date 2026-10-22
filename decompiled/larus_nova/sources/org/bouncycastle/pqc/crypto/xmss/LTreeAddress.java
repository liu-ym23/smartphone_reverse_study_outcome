package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
final class LTreeAddress extends XMSSAddress {
    private static final int TYPE = 1;
    private final int lTreeAddress;
    private final int treeHeight;
    private final int treeIndex;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.LTreeAddress$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder extends XMSSAddress.Builder<Builder> {
        private int lTreeAddress;
        private int treeHeight;
        private int treeIndex;

        public Builder() {
            super(1);
            this.lTreeAddress = 0;
            this.treeHeight = 0;
            this.treeIndex = 0;
        }

        public static /* synthetic */ int access$000(Builder r100) {
            return r100.lTreeAddress;
        }

        public static /* synthetic */ int access$100(Builder r100) {
            return r100.treeHeight;
        }

        public static /* synthetic */ int access$200(Builder r100) {
            return r100.treeIndex;
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public XMSSAddress build() {
            return new LTreeAddress(this, null);
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public Builder getThis() {
            return this;
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public /* bridge */ /* synthetic */ XMSSAddress.Builder getThis() {
            return getThis();
        }

        public Builder withLTreeAddress(int r100) {
            this.lTreeAddress = r100;
            return this;
        }

        public Builder withTreeHeight(int r100) {
            this.treeHeight = r100;
            return this;
        }

        public Builder withTreeIndex(int r100) {
            this.treeIndex = r100;
            return this;
        }
    }

    private LTreeAddress(Builder r100) {
        super(r100);
        this.lTreeAddress = Builder.access$000(r100);
        this.treeHeight = Builder.access$100(r100);
        this.treeIndex = Builder.access$200(r100);
    }

    public /* synthetic */ LTreeAddress(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public int getLTreeAddress() {
        return this.lTreeAddress;
    }

    public int getTreeHeight() {
        return this.treeHeight;
    }

    public int getTreeIndex() {
        return this.treeIndex;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress
    public byte[] toByteArray() {
        byte[] r100 = super.toByteArray();
        Pack.intToBigEndian(this.lTreeAddress, r100, 16);
        Pack.intToBigEndian(this.treeHeight, r100, 20);
        Pack.intToBigEndian(this.treeIndex, r100, 24);
        return r100;
    }
}
