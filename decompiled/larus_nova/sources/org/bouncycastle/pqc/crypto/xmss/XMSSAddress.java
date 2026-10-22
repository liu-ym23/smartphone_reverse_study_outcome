package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public abstract class XMSSAddress {
    private final int keyAndMask;
    private final int layerAddress;
    private final long treeAddress;
    private final int type;

    public static abstract class Builder<T extends Builder> {
        private int keyAndMask;
        private int layerAddress;
        private long treeAddress;
        private final int type;

        public Builder(int r100) {
            this.layerAddress = 0;
            this.treeAddress = 0;
            this.keyAndMask = 0;
            this.type = r100;
        }

        public static /* synthetic */ int access$000(Builder r100) {
            return r100.layerAddress;
        }

        public static /* synthetic */ long access$100(Builder r100) {
            return r100.treeAddress;
        }

        public static /* synthetic */ int access$200(Builder r100) {
            return r100.type;
        }

        public static /* synthetic */ int access$300(Builder r100) {
            return r100.keyAndMask;
        }

        public abstract XMSSAddress build();

        public abstract T getThis();

        public T withKeyAndMask(int r100) {
            this.keyAndMask = r100;
            return (T) getThis();
        }

        public T withLayerAddress(int r100) {
            this.layerAddress = r100;
            return (T) getThis();
        }

        public T withTreeAddress(long r100) {
            this.treeAddress = r100;
            return (T) getThis();
        }
    }

    public XMSSAddress(Builder r100) {
        this.layerAddress = Builder.access$000(r100);
        this.treeAddress = Builder.access$100(r100);
        this.type = Builder.access$200(r100);
        this.keyAndMask = Builder.access$300(r100);
    }

    public final int getKeyAndMask() {
        return this.keyAndMask;
    }

    public final int getLayerAddress() {
        return this.layerAddress;
    }

    public final long getTreeAddress() {
        return this.treeAddress;
    }

    public final int getType() {
        return this.type;
    }

    public byte[] toByteArray() {
        byte[] r100 = new byte[32];
        Pack.intToBigEndian(this.layerAddress, r100, 0);
        Pack.longToBigEndian(this.treeAddress, r100, 4);
        Pack.intToBigEndian(this.type, r100, 12);
        Pack.intToBigEndian(this.keyAndMask, r100, 28);
        return r100;
    }
}
