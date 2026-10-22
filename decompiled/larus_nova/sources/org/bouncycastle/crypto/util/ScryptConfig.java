package org.bouncycastle.crypto.util;

import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
public class ScryptConfig extends PBKDFConfig {
    private final int blockSize;
    private final int costParameter;
    private final int parallelizationParameter;
    private final int saltLength;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.util.ScryptConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final int blockSize;
        private final int costParameter;
        private final int parallelizationParameter;
        private int saltLength;

        public Builder(int r100, int r101, int r102) {
            this.saltLength = 16;
            if (r100 <= 1) goto L9;
            if (isPowerOf2(r100) == false) goto L9;
            this.costParameter = r100;
            this.blockSize = r101;
            this.parallelizationParameter = r102;
            return;
        L9:
            throw new IllegalArgumentException("Cost parameter N must be > 1 and a power of 2");
        }

        public static /* synthetic */ int access$100(Builder r100) {
            return r100.costParameter;
        }

        public static /* synthetic */ int access$200(Builder r100) {
            return r100.blockSize;
        }

        public static /* synthetic */ int access$300(Builder r100) {
            return r100.parallelizationParameter;
        }

        public static /* synthetic */ int access$400(Builder r100) {
            return r100.saltLength;
        }

        private static boolean isPowerOf2(int r100) {
            if ((r100 & (r100 - 1)) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public ScryptConfig build() {
            return new ScryptConfig(this, null);
        }

        public Builder withSaltLength(int r100) {
            this.saltLength = r100;
            return this;
        }
    }

    private ScryptConfig(Builder r100) {
        super(MiscObjectIdentifiers.id_scrypt);
        this.costParameter = Builder.access$100(r100);
        this.blockSize = Builder.access$200(r100);
        this.parallelizationParameter = Builder.access$300(r100);
        this.saltLength = Builder.access$400(r100);
    }

    public /* synthetic */ ScryptConfig(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public int getCostParameter() {
        return this.costParameter;
    }

    public int getParallelizationParameter() {
        return this.parallelizationParameter;
    }

    public int getSaltLength() {
        return this.saltLength;
    }
}
