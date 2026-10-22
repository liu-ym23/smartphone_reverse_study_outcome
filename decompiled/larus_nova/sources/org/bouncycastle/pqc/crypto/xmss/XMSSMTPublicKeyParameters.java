package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSMTPublicKeyParameters extends XMSSMTKeyParameters implements XMSSStoreableObjectInterface, Encodable {
    private final int oid;
    private final XMSSMTParameters params;
    private final byte[] publicSeed;
    private final byte[] root;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final XMSSMTParameters params;
        private byte[] publicKey;
        private byte[] publicSeed;
        private byte[] root;

        public Builder(XMSSMTParameters r100) {
            this.root = null;
            this.publicSeed = null;
            this.publicKey = null;
            this.params = r100;
        }

        public static /* synthetic */ XMSSMTParameters access$000(Builder r100) {
            return r100.params;
        }

        public static /* synthetic */ byte[] access$100(Builder r100) {
            return r100.publicKey;
        }

        public static /* synthetic */ byte[] access$200(Builder r100) {
            return r100.root;
        }

        public static /* synthetic */ byte[] access$300(Builder r100) {
            return r100.publicSeed;
        }

        public XMSSMTPublicKeyParameters build() {
            return new XMSSMTPublicKeyParameters(this, null);
        }

        public Builder withPublicKey(byte[] r100) {
            this.publicKey = XMSSUtil.cloneArray(r100);
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
    }

    private XMSSMTPublicKeyParameters(Builder r100) {
        super(false, Builder.access$000(r100).getTreeDigest());
        XMSSMTParameters r101 = Builder.access$000(r100);
        this.params = r101;
        if (r101 == null) goto L36;
        int r102 = r101.getTreeDigestSize();
        byte[] r103 = Builder.access$100(r100);
        if (r103 == null) goto L15;
        if (r103.length != (r102 + r102)) goto L10;
        this.oid = 0;
        this.root = XMSSUtil.extractBytesAtOffset(r103, 0, r102);
        this.publicSeed = XMSSUtil.extractBytesAtOffset(r103, r102 + 0, r102);
        return;
    L10:
        if (r103.length != ((r102 + 4) + r102)) goto L13;
        this.oid = Pack.bigEndianToInt(r103, 0);
        this.root = XMSSUtil.extractBytesAtOffset(r103, 4, r102);
        this.publicSeed = XMSSUtil.extractBytesAtOffset(r103, 4 + r102, r102);
        return;
    L13:
        throw new IllegalArgumentException("public key has wrong size");
    L15:
        if (r101.getOid() == null) goto L17;
        this.oid = r101.getOid().getOid();
    L18:
        byte[] r104 = Builder.access$200(r100);
        if (r104 != null) goto L21;
        this.root = new byte[r102];
    L26:
        byte[] r105 = Builder.access$300(r100);
        if (r105 != null) goto L29;
        this.publicSeed = new byte[r102];
        return;
    L29:
        if (r105.length != r102) goto L32;
        this.publicSeed = r105;
        return;
    L32:
        throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
    L21:
        if (r104.length != r102) goto L24;
        this.root = r104;
        goto L26
    L24:
        throw new IllegalArgumentException("length of root must be equal to length of digest");
    L17:
        this.oid = 0;
        goto L18
    L36:
        throw new NullPointerException("params == null");
    }

    public /* synthetic */ XMSSMTPublicKeyParameters(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return toByteArray();
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

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        int r100 = this.params.getTreeDigestSize();
        int r101 = this.oid;
        int r102 = 0;
        if (r101 == 0) goto L5;
        byte[] r103 = new byte[(r100 + 4) + r100];
        Pack.intToBigEndian(r101, r103, 0);
        r102 = 4;
    L6:
        XMSSUtil.copyBytesAtOffset(r103, this.root, r102);
        int r104 = r102 + r100;
        XMSSUtil.copyBytesAtOffset(r103, this.publicSeed, r104);
        return r103;
    L5:
        r103 = new byte[r100 + r100];
        goto L6
    }
}
