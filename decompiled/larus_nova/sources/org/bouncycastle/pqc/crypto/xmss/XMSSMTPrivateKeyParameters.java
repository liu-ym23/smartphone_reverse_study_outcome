package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSMTPrivateKeyParameters extends XMSSMTKeyParameters implements XMSSStoreableObjectInterface, Encodable {
    private volatile BDSStateMap bdsState;
    private volatile long index;
    private final XMSSMTParameters params;
    private final byte[] publicSeed;
    private final byte[] root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;
    private volatile boolean used;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private BDSStateMap bdsState;
        private long index;
        private long maxIndex;
        private final XMSSMTParameters params;
        private byte[] privateKey;
        private byte[] publicSeed;
        private byte[] root;
        private byte[] secretKeyPRF;
        private byte[] secretKeySeed;
        private XMSSParameters xmss;

        public Builder(XMSSMTParameters r100) {
            this.index = 0;
            this.maxIndex = -1;
            this.secretKeySeed = null;
            this.secretKeyPRF = null;
            this.publicSeed = null;
            this.root = null;
            this.bdsState = null;
            this.privateKey = null;
            this.xmss = null;
            this.params = r100;
        }

        public static /* synthetic */ XMSSMTParameters access$000(Builder r100) {
            return r100.params;
        }

        public static /* synthetic */ byte[] access$100(Builder r100) {
            return r100.privateKey;
        }

        public static /* synthetic */ XMSSParameters access$200(Builder r100) {
            return r100.xmss;
        }

        public static /* synthetic */ long access$300(Builder r100) {
            return r100.index;
        }

        public static /* synthetic */ byte[] access$400(Builder r100) {
            return r100.secretKeySeed;
        }

        public static /* synthetic */ byte[] access$500(Builder r100) {
            return r100.secretKeyPRF;
        }

        public static /* synthetic */ byte[] access$600(Builder r100) {
            return r100.publicSeed;
        }

        public static /* synthetic */ byte[] access$700(Builder r100) {
            return r100.root;
        }

        public static /* synthetic */ BDSStateMap access$800(Builder r100) {
            return r100.bdsState;
        }

        public static /* synthetic */ long access$900(Builder r100) {
            return r100.maxIndex;
        }

        public XMSSMTPrivateKeyParameters build() {
            return new XMSSMTPrivateKeyParameters(this, null);
        }

        public Builder withBDSState(BDSStateMap r100) {
            if (r100.getMaxIndex() != 0) goto L5;
            this.bdsState = new BDSStateMap(r100, (1 << this.params.getHeight()) - 1);
        L6:
            return this;
        L5:
            this.bdsState = r100;
            goto L6
        }

        public Builder withIndex(long r100) {
            this.index = r100;
            return this;
        }

        public Builder withMaxIndex(long r100) {
            this.maxIndex = r100;
            return this;
        }

        public Builder withPrivateKey(byte[] r100) {
            this.privateKey = XMSSUtil.cloneArray(r100);
            this.xmss = this.params.getXMSSParameters();
            return this;
        }

        public Builder withPublicSeed(byte[] r100) {
            this.publicSeed = XMSSUtil.cloneArray(r100);
            return this;
        }

        public Builder withRoot(byte[] r100) {
            this.root = XMSSUtil.cloneArray(r100);
            return this;
        }

        public Builder withSecretKeyPRF(byte[] r100) {
            this.secretKeyPRF = XMSSUtil.cloneArray(r100);
            return this;
        }

        public Builder withSecretKeySeed(byte[] r100) {
            this.secretKeySeed = XMSSUtil.cloneArray(r100);
            return this;
        }
    }

    private XMSSMTPrivateKeyParameters(Builder r100) {
        super(true, Builder.access$000(r100).getTreeDigest());
        XMSSMTParameters r101 = Builder.access$000(r100);
        this.params = r101;
        if (r101 == null) goto L73;
        int r102 = r101.getTreeDigestSize();
        byte[] r103 = Builder.access$100(r100);
        if (r103 != null) goto L7;
        this.index = Builder.access$300(r100);
        byte[] r104 = Builder.access$400(r100);
        if (r104 != null) goto L26;
        this.secretKeySeed = new byte[r102];
    L31:
        byte[] r105 = Builder.access$500(r100);
        if (r105 != null) goto L34;
        this.secretKeyPRF = new byte[r102];
    L39:
        byte[] r106 = Builder.access$600(r100);
        if (r106 != null) goto L42;
        this.publicSeed = new byte[r102];
    L47:
        byte[] r107 = Builder.access$700(r100);
        if (r107 != null) goto L50;
        this.root = new byte[r102];
    L55:
        BDSStateMap r108 = Builder.access$800(r100);
        if (r108 == null) goto L58;
    L57:
        this.bdsState = r108;
        if (Builder.access$900(r100) >= 0) goto L67;
        return;
    L67:
        if (Builder.access$900(r100) != this.bdsState.getMaxIndex()) goto L70;
        return;
    L70:
        throw new IllegalArgumentException("maxIndex set but not reflected in state");
    L58:
        long r109 = Builder.access$300(r100);
        if (XMSSUtil.isIndexValid(r101.getHeight(), r109) == false) goto L63;
        if (r106 == null) goto L63;
        if (r104 == null) goto L63;
        r108 = new BDSStateMap(r101, Builder.access$300(r100), r106, r104);
    L63:
        r108 = new BDSStateMap(Builder.access$900(r100) + 1);
        goto L57
    L50:
        if (r107.length != r102) goto L53;
        this.root = r107;
        goto L55
    L53:
        throw new IllegalArgumentException("size of root needs to be equal size of digest");
    L42:
        if (r106.length != r102) goto L45;
        this.publicSeed = r106;
        goto L47
    L45:
        throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
    L34:
        if (r105.length != r102) goto L37;
        this.secretKeyPRF = r105;
        goto L39
    L37:
        throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
    L26:
        if (r104.length != r102) goto L29;
        this.secretKeySeed = r104;
        goto L31
    L29:
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
    L7:
        if (Builder.access$200(r100) == null) goto L22;
        int r110 = r101.getHeight();
        int r111 = (r110 + 7) / 8;
        this.index = XMSSUtil.bytesToXBigEndian(r103, 0, r111);
        if (XMSSUtil.isIndexValid(r110, this.index) == false) goto L20;
        int r112 = r111 + 0;
        this.secretKeySeed = XMSSUtil.extractBytesAtOffset(r103, r112, r102);
        int r113 = r112 + r102;
        this.secretKeyPRF = XMSSUtil.extractBytesAtOffset(r103, r113, r102);
        int r114 = r113 + r102;
        this.publicSeed = XMSSUtil.extractBytesAtOffset(r103, r114, r102);
        int r115 = r114 + r102;
        this.root = XMSSUtil.extractBytesAtOffset(r103, r115, r102);
        int r116 = r115 + r102;
        this.bdsState = ((BDSStateMap) XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset(r103, r116, r103.length - r116), BDSStateMap.class)).withWOTSDigest(Builder.access$200(r100).getTreeDigestOID());     // Catch: ClassNotFoundException -> L13 IOException -> L16
    L76:
        return;
    L16:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L13:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L20:
        throw new IllegalArgumentException("index out of bounds");
    L22:
        throw new NullPointerException("xmss == null");
    L73:
        throw new NullPointerException("params == null");
    }

    public /* synthetic */ XMSSMTPrivateKeyParameters(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public XMSSMTPrivateKeyParameters extractKeyShard(int r100) {
        if (r100 < 1) goto L19;
        monitor-enter(this);
        long r101 = r100;
    L15:
        th = move-exception;
        throw th;
    L7:
        if (r101 > getUsagesRemaining()) goto L14;
        XMSSMTPrivateKeyParameters r102 = new Builder(this.params).withSecretKeySeed(this.secretKeySeed).withSecretKeyPRF(this.secretKeyPRF).withPublicSeed(this.publicSeed).withRoot(this.root).withIndex(getIndex()).withBDSState(new BDSStateMap(this.bdsState, (getIndex() + r101) - 1)).build();     // Catch: Throwable -> L15
        int r103 = 0;
    L9:
        if (r103 == r100) goto L11;
        rollKey();     // Catch: Throwable -> L15
        r103 = r103 + 1;     // Catch: Throwable -> L15
        goto L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L15
        return r102;
    L14:
        throw new IllegalArgumentException("usageCount exceeds usages remaining");     // Catch: Throwable -> L15
    L19:
        throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
    }

    public BDSStateMap getBDSState() {
        return this.bdsState;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        monitor-enter(this);
        byte[] r100 = toByteArray();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public long getIndex() {
        return this.index;
    }

    public XMSSMTPrivateKeyParameters getNextKey() {
        monitor-enter(this);
        XMSSMTPrivateKeyParameters r100 = extractKeyShard(1);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public XMSSMTParameters getParameters() {
        return this.params;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.publicSeed);
    }

    public byte[] getRoot() {
        return XMSSUtil.cloneArray(this.root);
    }

    public byte[] getSecretKeyPRF() {
        return XMSSUtil.cloneArray(this.secretKeyPRF);
    }

    public byte[] getSecretKeySeed() {
        return XMSSUtil.cloneArray(this.secretKeySeed);
    }

    public long getUsagesRemaining() {
        monitor-enter(this);
        long r100 = (this.bdsState.getMaxIndex() - getIndex()) + 1;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public XMSSMTPrivateKeyParameters rollKey() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (getIndex() >= this.bdsState.getMaxIndex()) goto L7;
        this.bdsState.updateState(this.params, this.index, this.publicSeed, this.secretKeySeed);     // Catch: Throwable -> L10
        this.index++;     // Catch: Throwable -> L10
    L6:
        this.used = false;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return this;
    L7:
        this.index = this.bdsState.getMaxIndex() + 1;     // Catch: Throwable -> L10
        this.bdsState = new BDSStateMap(this.bdsState.getMaxIndex());     // Catch: Throwable -> L10
        goto L6
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        monitor-enter(this);
        int r100 = this.params.getTreeDigestSize();     // Catch: Throwable -> L11
        int r101 = (this.params.getHeight() + 7) / 8;     // Catch: Throwable -> L11
        byte[] r102 = new byte[(((r101 + r100) + r100) + r100) + r100];     // Catch: Throwable -> L11
        XMSSUtil.copyBytesAtOffset(r102, XMSSUtil.toBytesBigEndian(this.index, r101), 0);     // Catch: Throwable -> L11
        int r103 = r101 + 0;     // Catch: Throwable -> L11
        XMSSUtil.copyBytesAtOffset(r102, this.secretKeySeed, r103);     // Catch: Throwable -> L11
        int r104 = r103 + r100;     // Catch: Throwable -> L11
        XMSSUtil.copyBytesAtOffset(r102, this.secretKeyPRF, r104);     // Catch: Throwable -> L11
        int r105 = r104 + r100;     // Catch: Throwable -> L11
        XMSSUtil.copyBytesAtOffset(r102, this.publicSeed, r105);     // Catch: Throwable -> L11
        XMSSUtil.copyBytesAtOffset(r102, this.root, r105 + r100);     // Catch: Throwable -> L11
        byte[] r106 = Arrays.concatenate(r102, XMSSUtil.serialize(this.bdsState));     // Catch: IOException -> L8 Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r106;
    L8:
        e = move-exception;
        throw new IllegalStateException("error serializing bds state: " + e.getMessage(), e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
