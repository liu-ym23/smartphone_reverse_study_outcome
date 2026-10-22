package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSPrivateKeyParameters extends XMSSKeyParameters implements XMSSStoreableObjectInterface, Encodable {
    private volatile BDS bdsState;
    private final XMSSParameters params;
    private final byte[] publicSeed;
    private final byte[] root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private BDS bdsState;
        private int index;
        private int maxIndex;
        private final XMSSParameters params;
        private byte[] privateKey;
        private byte[] publicSeed;
        private byte[] root;
        private byte[] secretKeyPRF;
        private byte[] secretKeySeed;

        public Builder(XMSSParameters r100) {
            this.index = 0;
            this.maxIndex = -1;
            this.secretKeySeed = null;
            this.secretKeyPRF = null;
            this.publicSeed = null;
            this.root = null;
            this.bdsState = null;
            this.privateKey = null;
            this.params = r100;
        }

        public static /* synthetic */ XMSSParameters access$000(Builder r100) {
            return r100.params;
        }

        public static /* synthetic */ byte[] access$100(Builder r100) {
            return r100.privateKey;
        }

        public static /* synthetic */ byte[] access$200(Builder r100) {
            return r100.secretKeySeed;
        }

        public static /* synthetic */ byte[] access$300(Builder r100) {
            return r100.secretKeyPRF;
        }

        public static /* synthetic */ byte[] access$400(Builder r100) {
            return r100.publicSeed;
        }

        public static /* synthetic */ byte[] access$500(Builder r100) {
            return r100.root;
        }

        public static /* synthetic */ BDS access$600(Builder r100) {
            return r100.bdsState;
        }

        public static /* synthetic */ int access$700(Builder r100) {
            return r100.index;
        }

        public static /* synthetic */ int access$800(Builder r100) {
            return r100.maxIndex;
        }

        public XMSSPrivateKeyParameters build() {
            return new XMSSPrivateKeyParameters(this, null);
        }

        public Builder withBDSState(BDS r100) {
            this.bdsState = r100;
            return this;
        }

        public Builder withIndex(int r100) {
            this.index = r100;
            return this;
        }

        public Builder withMaxIndex(int r100) {
            this.maxIndex = r100;
            return this;
        }

        public Builder withPrivateKey(byte[] r100) {
            this.privateKey = XMSSUtil.cloneArray(r100);
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

    private XMSSPrivateKeyParameters(Builder r100) {
        super(true, Builder.access$000(r100).getTreeDigest());
        XMSSParameters r101 = Builder.access$000(r100);
        this.params = r101;
        if (r101 == null) goto L72;
        int r102 = r101.getTreeDigestSize();
        byte[] r103 = Builder.access$100(r100);
        if (r103 == null) goto L22;
        int r104 = r101.getHeight();
        int r105 = Pack.bigEndianToInt(r103, 0);
        if (XMSSUtil.isIndexValid(r104, r105) == false) goto L21;
        this.secretKeySeed = XMSSUtil.extractBytesAtOffset(r103, 4, r102);
        int r106 = 4 + r102;
        this.secretKeyPRF = XMSSUtil.extractBytesAtOffset(r103, r106, r102);
        int r107 = r106 + r102;
        this.publicSeed = XMSSUtil.extractBytesAtOffset(r103, r107, r102);
        int r108 = r107 + r102;
        this.root = XMSSUtil.extractBytesAtOffset(r103, r108, r102);
        int r109 = r108 + r102;
        BDS r110 = (BDS) XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset(r103, r109, r103.length - r109), BDS.class);     // Catch: ClassNotFoundException -> L14 IOException -> L17
        if (r110.getIndex() != r105) goto L13;
        this.bdsState = r110.withWOTSDigest(Builder.access$000(r100).getTreeDigestOID());     // Catch: ClassNotFoundException -> L14 IOException -> L17
        return;
    L13:
        throw new IllegalStateException("serialized BDS has wrong index");     // Catch: ClassNotFoundException -> L14 IOException -> L17
    L17:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L14:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L21:
        throw new IllegalArgumentException("index out of bounds");
    L22:
        byte[] r111 = Builder.access$200(r100);
        if (r111 != null) goto L25;
        this.secretKeySeed = new byte[r102];
    L30:
        byte[] r112 = Builder.access$300(r100);
        if (r112 != null) goto L33;
        this.secretKeyPRF = new byte[r102];
    L38:
        byte[] r113 = Builder.access$400(r100);
        if (r113 != null) goto L41;
        this.publicSeed = new byte[r102];
    L46:
        byte[] r114 = Builder.access$500(r100);
        if (r114 != null) goto L49;
        this.root = new byte[r102];
    L54:
        BDS r115 = Builder.access$600(r100);
        if (r115 == null) goto L58;
    L56:
        this.bdsState = r115;
        if (Builder.access$800(r100) >= 0) goto L66;
        return;
    L66:
        if (Builder.access$800(r100) != this.bdsState.getMaxIndex()) goto L69;
        return;
    L69:
        throw new IllegalArgumentException("maxIndex set but not reflected in state");
    L58:
        if (Builder.access$700(r100) >= ((1 << r101.getHeight()) - 2)) goto L62;
        if (r113 == null) goto L62;
        if (r111 == null) goto L62;
        r115 = new BDS(r101, r113, r111, (OTSHashAddress) new OTSHashAddress.Builder().build(), Builder.access$700(r100));
    L62:
        r115 = new BDS(r101, (1 << r101.getHeight()) - 1, Builder.access$700(r100));
        goto L56
    L49:
        if (r114.length != r102) goto L52;
        this.root = r114;
        goto L54
    L52:
        throw new IllegalArgumentException("size of root needs to be equal size of digest");
    L41:
        if (r113.length != r102) goto L44;
        this.publicSeed = r113;
        goto L46
    L44:
        throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
    L33:
        if (r112.length != r102) goto L36;
        this.secretKeyPRF = r112;
        goto L38
    L36:
        throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
    L25:
        if (r111.length != r102) goto L28;
        this.secretKeySeed = r111;
        goto L30
    L28:
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
    L72:
        throw new NullPointerException("params == null");
    }

    public /* synthetic */ XMSSPrivateKeyParameters(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    public XMSSPrivateKeyParameters extractKeyShard(int r100) {
        if (r100 < 1) goto L22;
        monitor-enter(this);
        long r101 = r100;
    L18:
        th = move-exception;
        throw th;
    L7:
        if (r101 > getUsagesRemaining()) goto L17;
        XMSSPrivateKeyParameters r102 = new Builder(this.params).withSecretKeySeed(this.secretKeySeed).withSecretKeyPRF(this.secretKeyPRF).withPublicSeed(this.publicSeed).withRoot(this.root).withIndex(getIndex()).withBDSState(this.bdsState.withMaxIndex((this.bdsState.getIndex() + r100) - 1, this.params.getTreeDigestOID())).build();     // Catch: Throwable -> L18
        if (r101 != getUsagesRemaining()) goto L11;
        this.bdsState = new BDS(this.params, this.bdsState.getMaxIndex(), getIndex() + r100);     // Catch: Throwable -> L18
    L14:
        monitor-exit(this);     // Catch: Throwable -> L18
        return r102;
    L11:
        OTSHashAddress r103 = (OTSHashAddress) new OTSHashAddress.Builder().build();     // Catch: Throwable -> L18
        int r104 = 0;
    L12:
        if (r104 == r100) goto L14;
        this.bdsState = this.bdsState.getNextState(this.publicSeed, this.secretKeySeed, r103);     // Catch: Throwable -> L18
        r104 = r104 + 1;     // Catch: Throwable -> L18
        goto L12
    L17:
        throw new IllegalArgumentException("usageCount exceeds usages remaining");     // Catch: Throwable -> L18
    L22:
        throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
    }

    public BDS getBDSState() {
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

    public int getIndex() {
        return this.bdsState.getIndex();
    }

    public XMSSPrivateKeyParameters getNextKey() {
        monitor-enter(this);
        XMSSPrivateKeyParameters r100 = extractKeyShard(1);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public XMSSParameters getParameters() {
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

    public XMSSPrivateKeyParameters rollKey() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.bdsState.getIndex() >= this.bdsState.getMaxIndex()) goto L7;
        BDS r100 = this.bdsState.getNextState(this.publicSeed, this.secretKeySeed, (OTSHashAddress) new OTSHashAddress.Builder().build());     // Catch: Throwable -> L10
    L6:
        this.bdsState = r100;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return this;
    L7:
        r100 = new BDS(this.params, this.bdsState.getMaxIndex(), this.bdsState.getMaxIndex() + 1);     // Catch: Throwable -> L10
        goto L6
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        monitor-enter(this);
        int r100 = this.params.getTreeDigestSize();     // Catch: Throwable -> L12
        byte[] r101 = new byte[(((r100 + 4) + r100) + r100) + r100];     // Catch: Throwable -> L12
        Pack.intToBigEndian(this.bdsState.getIndex(), r101, 0);     // Catch: Throwable -> L12
        XMSSUtil.copyBytesAtOffset(r101, this.secretKeySeed, 4);     // Catch: Throwable -> L12
        int r102 = 4 + r100;     // Catch: Throwable -> L12
        XMSSUtil.copyBytesAtOffset(r101, this.secretKeyPRF, r102);     // Catch: Throwable -> L12
        int r103 = r102 + r100;     // Catch: Throwable -> L12
        XMSSUtil.copyBytesAtOffset(r101, this.publicSeed, r103);     // Catch: Throwable -> L12
        XMSSUtil.copyBytesAtOffset(r101, this.root, r103 + r100);     // Catch: Throwable -> L12
        byte[] r104 = Arrays.concatenate(r101, XMSSUtil.serialize(this.bdsState));     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r104;
    L9:
        e = move-exception;
        throw new RuntimeException("error serializing bds state: " + e.getMessage());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
