package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
final class OTSHashAddress extends XMSSAddress {
    private static final int TYPE = 0;
    private final int chainAddress;
    private final int hashAddress;
    private final int otsAddress;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.OTSHashAddress$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder extends XMSSAddress.Builder<Builder> {
        private int chainAddress;
        private int hashAddress;
        private int otsAddress;

        public Builder() {
            super(0);
            this.otsAddress = 0;
            this.chainAddress = 0;
            this.hashAddress = 0;
        }

        public static /* synthetic */ int access$000(Builder r100) {
            return r100.otsAddress;
        }

        public static /* synthetic */ int access$100(Builder r100) {
            return r100.chainAddress;
        }

        public static /* synthetic */ int access$200(Builder r100) {
            return r100.hashAddress;
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public XMSSAddress build() {
            return new OTSHashAddress(this, null);
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public Builder getThis() {
            return this;
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public /* bridge */ /* synthetic */ XMSSAddress.Builder getThis() {
            return getThis();
        }

        public Builder withChainAddress(int r100) {
            this.chainAddress = r100;
            return this;
        }

        public Builder withHashAddress(int r100) {
            this.hashAddress = r100;
            return this;
        }

        public Builder withOTSAddress(int r100) {
            this.otsAddress = r100;
            return this;
        }
    }

    private OTSHashAddress(Builder r100) {
        super(r100);
        this.otsAddress = Builder.access$000(r100);
        this.chainAddress = Builder.access$100(r100);
        this.hashAddress = Builder.access$200(r100);
    }

    public /* synthetic */ OTSHashAddress(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public int getChainAddress() {
        return this.chainAddress;
    }

    public int getHashAddress() {
        return this.hashAddress;
    }

    public int getOTSAddress() {
        return this.otsAddress;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress
    public byte[] toByteArray() {
        byte[] r100 = super.toByteArray();
        Pack.intToBigEndian(this.otsAddress, r100, 16);
        Pack.intToBigEndian(this.chainAddress, r100, 20);
        Pack.intToBigEndian(this.hashAddress, r100, 24);
        return r100;
    }
}
