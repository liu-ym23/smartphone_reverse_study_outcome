package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.WeakHashMap;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public class LMSPrivateKeyParameters extends LMSKeyParameters implements LMSContextBasedSigner {
    private static CacheKey T1;
    private static CacheKey[] internedKeys;
    private final byte[] I;
    private final byte[] masterSecret;
    private final int maxCacheR;
    private final int maxQ;
    private final LMOtsParameters otsParameters;
    private final LMSigParameters parameters;
    private LMSPublicKeyParameters publicKey;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f525533q;
    private final Map<CacheKey, byte[]> tCache;
    private final Digest tDigest;

    public static class CacheKey {
        private final int index;

        public CacheKey(int r100) {
            this.index = r100;
        }

        public static /* synthetic */ int access$000(CacheKey r100) {
            return r100.index;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof CacheKey) == true) goto L5;
            return false;
        L5:
            if (((CacheKey) r100).index != this.index) goto L9;
            return true;
        L9:
            return false;
        }

        public int hashCode() {
            return this.index;
        }
    }

    static {
        CacheKey r100 = new CacheKey(1);
        T1 = r100;
        CacheKey[] r101 = new CacheKey[129];
        internedKeys = r101;
        r101[1] = r100;
        int r102 = 2;
    L3:
        CacheKey[] r103 = internedKeys;
        if (r102 >= r103.length) goto L6;
        r103[r102] = new CacheKey(r102);
        r102 = r102 + 1;
        goto L3
    }

    private LMSPrivateKeyParameters(LMSPrivateKeyParameters r100, int r101, int r102) {
        super(true);
        LMSigParameters r103 = r100.parameters;
        this.parameters = r103;
        this.otsParameters = r100.otsParameters;
        this.f525533q = r101;
        this.I = r100.I;
        this.maxQ = r102;
        this.masterSecret = r100.masterSecret;
        this.maxCacheR = 1 << r103.getH();
        this.tCache = r100.tCache;
        this.tDigest = DigestUtil.getDigest(r103.getDigestOID());
        this.publicKey = r100.publicKey;
    }

    public LMSPrivateKeyParameters(LMSigParameters r100, LMOtsParameters r101, int r102, byte[] r103, int r104, byte[] r105) {
        super(true);
        this.parameters = r100;
        this.otsParameters = r101;
        this.f525533q = r102;
        this.I = Arrays.clone(r103);
        this.maxQ = r104;
        this.masterSecret = Arrays.clone(r105);
        this.maxCacheR = 1 << (r100.getH() + 1);
        this.tCache = new WeakHashMap();
        this.tDigest = DigestUtil.getDigest(r100.getDigestOID());
    }

    private byte[] calcT(int r100) {
        int r101 = 1 << getSigParameters().getH();
        if (r100 < r101) goto L6;
        LmsUtils.byteArray(getI(), this.tDigest);
        LmsUtils.u32str(r100, this.tDigest);
        LmsUtils.u16str(-32126, this.tDigest);
        LmsUtils.byteArray(LM_OTS.lms_ots_generatePublicKey(getOtsParameters(), getI(), r100 - r101, getMasterSecret()), this.tDigest);
        byte[] r102 = new byte[this.tDigest.getDigestSize()];
        this.tDigest.doFinal(r102, 0);
        return r102;
    L6:
        int r103 = r100 * 2;
        byte[] r104 = findT(r103);
        byte[] r105 = findT(r103 + 1);
        LmsUtils.byteArray(getI(), this.tDigest);
        LmsUtils.u32str(r100, this.tDigest);
        LmsUtils.u16str(-31869, this.tDigest);
        LmsUtils.byteArray(r104, this.tDigest);
        LmsUtils.byteArray(r105, this.tDigest);
        byte[] r106 = new byte[this.tDigest.getDigestSize()];
        this.tDigest.doFinal(r106, 0);
        return r106;
    }

    private byte[] findT(CacheKey r100) {
        Map<CacheKey, byte[]> r101 = this.tCache;
        monitor-enter(r101);
        byte[] r102 = this.tCache.get(r100);     // Catch: Throwable -> L11
        if (r102 == null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return r102;
    L8:
        byte[] r103 = calcT(CacheKey.access$000(r100));     // Catch: Throwable -> L11
        this.tCache.put(r100, r103);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    public static LMSPrivateKeyParameters getInstance(Object r100) throws IOException {
        if ((r100 instanceof LMSPrivateKeyParameters) == false) goto L7;
        return (LMSPrivateKeyParameters) r100;
    L7:
        if ((r100 instanceof DataInputStream) == false) goto L23;
        DataInputStream r101 = (DataInputStream) r100;
        if (r101.readInt() != 0) goto L21;
        LMSigParameters r102 = LMSigParameters.getParametersForType(r101.readInt());
        LMOtsParameters r103 = LMOtsParameters.getParametersForType(r101.readInt());
        byte[] r104 = new byte[16];
        r101.readFully(r104);
        int r105 = r101.readInt();
        int r106 = r101.readInt();
        int r107 = r101.readInt();
        if (r107 < 0) goto L19;
        if (r107 > r101.available()) goto L17;
        byte[] r108 = new byte[r107];
        r101.readFully(r108);
        return new LMSPrivateKeyParameters(r102, r103, r105, r104, r106, r108);
    L17:
        throw new IOException("secret length exceeded " + r101.available());
    L19:
        throw new IllegalStateException("secret length less than zero");
    L21:
        throw new IllegalStateException("expected version 0 lms private key");
    L23:
        if ((r100 instanceof byte[]) == false) goto L36;
        DataInputStream r109 = null;
        DataInputStream r110 = new DataInputStream(new ByteArrayInputStream((byte[]) r100));     // Catch: Throwable -> L31
        LMSPrivateKeyParameters r111 = getInstance(r110);     // Catch: Throwable -> L29
        r110.close();
        return r111;
    L29:
        th = th;
        r109 = r110;
    L32:
        if (r109 == null) goto L34;
        r109.close();
    L34:
        throw th;
    L31:
        th = th;
        goto L32
    L36:
        if ((r100 instanceof InputStream) == false) goto L40;
        return getInstance(Streams.readAll((InputStream) r100));
    L40:
        throw new IllegalArgumentException("cannot parse " + r100);
    }

    public static LMSPrivateKeyParameters getInstance(byte[] r100, byte[] r101) throws IOException {
        LMSPrivateKeyParameters r102 = getInstance(r100);
        r102.publicKey = LMSPublicKeyParameters.getInstance(r101);
        return r102;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L45:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L45;
        LMSPrivateKeyParameters r101 = (LMSPrivateKeyParameters) r100;
        if (this.f525533q == r101.f525533q) goto L14;
        return false;
    L14:
        if (this.maxQ == r101.maxQ) goto L17;
        return false;
    L17:
        if (Arrays.areEqual(this.I, r101.I) == true) goto L19;
        return false;
    L19:
        LMSigParameters r102 = this.parameters;
        if (r102 == null) goto L25;
        if (r102.equals(r101.parameters) == false) goto L26;
    L27:
        LMOtsParameters r103 = this.otsParameters;
        if (r103 == null) goto L33;
        if (r103.equals(r101.otsParameters) == true) goto L36;
    L34:
        return false;
    L36:
        if (Arrays.areEqual(this.masterSecret, r101.masterSecret) == true) goto L38;
        return false;
    L38:
        LMSPublicKeyParameters r104 = this.publicKey;
        if (r104 == null) goto L44;
        LMSPublicKeyParameters r105 = r101.publicKey;
        if (r105 == null) goto L44;
        return r104.equals(r105);
    L44:
        return true;
    L33:
        if (r101.otsParameters == null) goto L36;
    L26:
        return false;
    L25:
        if (r101.parameters == null) goto L27;
        goto L26
    }

    public LMSPrivateKeyParameters extractKeyShard(int r100) {
        monitor-enter(this);
        int r101 = this.f525533q;     // Catch: Throwable -> L10
        if ((r101 + r100) >= this.maxQ) goto L9;
        LMSPrivateKeyParameters r102 = new LMSPrivateKeyParameters(this, r101, r101 + r100);     // Catch: Throwable -> L10
        this.f525533q += r100;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r102;
    L9:
        throw new IllegalArgumentException("usageCount exceeds usages remaining");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public byte[] findT(int r100) {
        if (r100 >= this.maxCacheR) goto L11;
        CacheKey[] r101 = internedKeys;
        if (r100 >= r101.length) goto L7;
        CacheKey r102 = r101[r100];
    L9:
        return findT(r102);
    L7:
        r102 = new CacheKey(r100);
        goto L9
    L11:
        return calcT(r100);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    public LMSContext generateLMSContext() {
        int r100 = getSigParameters().getH();
        int r101 = getIndex();
        LMOtsPrivateKey r102 = getNextOtsPrivateKey();
        int r103 = (1 << r100) + r101;
        byte[][] r104 = new byte[r100][];
        int r105 = 0;
    L3:
        if (r105 >= r100) goto L6;
        r104[r105] = findT((r103 / (1 << r105)) ^ 1);
        r105 = r105 + 1;
        goto L3
    L6:
        return r102.getSignatureContext(getSigParameters(), r104);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    public byte[] generateSignature(LMSContext r100) {
        return LMS.generateSign(r100).getEncoded();
    L4:
        e = move-exception;
        throw new IllegalStateException("unable to encode signature: " + e.getMessage(), e);
    }

    public LMOtsPrivateKey getCurrentOTSKey() {
        monitor-enter(this);
        int r100 = this.f525533q;     // Catch: Throwable -> L10
        if (r100 >= this.maxQ) goto L9;
        LMOtsPrivateKey r101 = new LMOtsPrivateKey(this.otsParameters, this.I, r100, this.masterSecret);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r101;
    L9:
        throw new ExhaustedPrivateKeyException("ots private keys expired");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSKeyParameters, org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return Composer.compose().u32str(0).u32str(this.parameters.getType()).u32str(this.otsParameters.getType()).bytes(this.I).u32str(this.f525533q).u32str(this.maxQ).u32str(this.masterSecret.length).bytes(this.masterSecret).build();
    }

    public byte[] getI() {
        return Arrays.clone(this.I);
    }

    public synchronized int getIndex() {
        monitor-enter(this);
        int r100 = this.f525533q;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public byte[] getMasterSecret() {
        return Arrays.clone(this.masterSecret);
    }

    public LMOtsPrivateKey getNextOtsPrivateKey() {
        monitor-enter(this);
        int r100 = this.f525533q;     // Catch: Throwable -> L10
        if (r100 >= this.maxQ) goto L9;
        LMOtsPrivateKey r101 = new LMOtsPrivateKey(this.otsParameters, this.I, r100, this.masterSecret);     // Catch: Throwable -> L10
        incIndex();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r101;
    L9:
        throw new ExhaustedPrivateKeyException("ots private key exhausted");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public LMOtsParameters getOtsParameters() {
        return this.otsParameters;
    }

    public LMSPublicKeyParameters getPublicKey() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.publicKey != null) goto L6;
        this.publicKey = new LMSPublicKeyParameters(this.parameters, this.otsParameters, findT(T1), this.I);     // Catch: Throwable -> L9
    L6:
        LMSPublicKeyParameters r100 = this.publicKey;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r100;
    }

    public LMSigParameters getSigParameters() {
        return this.parameters;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    public long getUsagesRemaining() {
        return this.maxQ - this.f525533q;
    }

    public int hashCode() {
        int r100 = ((this.f525533q * 31) + Arrays.hashCode(this.I)) * 31;
        LMSigParameters r101 = this.parameters;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        LMOtsParameters r105 = this.otsParameters;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((((r104 + r106) * 31) + this.maxQ) * 31) + Arrays.hashCode(this.masterSecret)) * 31;
        LMSPublicKeyParameters r108 = this.publicKey;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public synchronized void incIndex() {
        monitor-enter(this);
        this.f525533q++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
