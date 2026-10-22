package org.bouncycastle.pqc.crypto.lms;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public class HSSPrivateKeyParameters extends LMSKeyParameters implements LMSContextBasedSigner {
    private long index;
    private final long indexLimit;
    private final boolean isShard;
    private List<LMSPrivateKeyParameters> keys;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f525524l;
    private HSSPublicKeyParameters publicKey;
    private List<LMSSignature> sig;

    public HSSPrivateKeyParameters(int r100, List<LMSPrivateKeyParameters> r101, List<LMSSignature> r102, long r103, long r104) {
        super(true);
        this.index = 0;
        this.f525524l = r100;
        this.keys = Collections.unmodifiableList(r101);
        this.sig = Collections.unmodifiableList(r102);
        this.index = r103;
        this.indexLimit = r104;
        this.isShard = false;
        resetKeyToIndex();
    }

    private HSSPrivateKeyParameters(int r100, List<LMSPrivateKeyParameters> r101, List<LMSSignature> r102, long r103, long r104, boolean r110) {
        super(true);
        this.index = 0;
        this.f525524l = r100;
        this.keys = Collections.unmodifiableList(r101);
        this.sig = Collections.unmodifiableList(r102);
        this.index = r103;
        this.indexLimit = r104;
        this.isShard = r110;
    }

    public static HSSPrivateKeyParameters getInstance(Object r110) throws IOException {
        if ((r110 instanceof HSSPrivateKeyParameters) == false) goto L7;
        return (HSSPrivateKeyParameters) r110;
    L7:
        if ((r110 instanceof DataInputStream) == false) goto L21;
        DataInputStream r100 = (DataInputStream) r110;
        if (r100.readInt() != 0) goto L19;
        int r101 = r100.readInt();
        long r102 = r100.readLong();
        long r103 = r100.readLong();
        boolean r111 = r100.readBoolean();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        int r106 = 0;
        int r107 = 0;
    L11:
        if (r107 >= r101) goto L14;
        r104.add(LMSPrivateKeyParameters.getInstance(r110));
        r107 = r107 + 1;
    L14:
        if (r106 >= (r101 - 1)) goto L17;
        r105.add(LMSSignature.getInstance(r110));
        r106 = r106 + 1;
        goto L14
    L17:
        return new HSSPrivateKeyParameters(r101, r104, r105, r102, r103, r111);
    L19:
        throw new IllegalStateException("unknown version for hss private key");
    L21:
        if ((r110 instanceof byte[]) == false) goto L34;
        DataInputStream r108 = null;
        DataInputStream r109 = new DataInputStream(new ByteArrayInputStream((byte[]) r110));     // Catch: Throwable -> L29
        HSSPrivateKeyParameters r112 = getInstance(r109);     // Catch: Throwable -> L27
        r109.close();
        return r112;
    L27:
        th = th;
        r108 = r109;
    L30:
        if (r108 == null) goto L32;
        r108.close();
    L32:
        throw th;
    L29:
        th = th;
        goto L30
    L34:
        if ((r110 instanceof InputStream) == false) goto L38;
        return getInstance(Streams.readAll((InputStream) r110));
    L38:
        throw new IllegalArgumentException("cannot parse " + r110);
    }

    public static HSSPrivateKeyParameters getInstance(byte[] r100, byte[] r101) throws IOException {
        HSSPrivateKeyParameters r102 = getInstance(r100);
        r102.publicKey = HSSPublicKeyParameters.getInstance(r101);
        return r102;
    }

    private static HSSPrivateKeyParameters makeCopy(HSSPrivateKeyParameters r100) {
        return getInstance(r100.getEncoded());
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public Object clone() throws CloneNotSupportedException {
        return makeCopy(this);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L27:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L27;
        HSSPrivateKeyParameters r101 = (HSSPrivateKeyParameters) r100;
        if (this.f525524l == r101.f525524l) goto L14;
        return false;
    L14:
        if (this.isShard == r101.isShard) goto L17;
        return false;
    L17:
        if (this.indexLimit == r101.indexLimit) goto L20;
        return false;
    L20:
        if (this.index == r101.index) goto L23;
        return false;
    L23:
        if (this.keys.equals(r101.keys) == true) goto L26;
        return false;
    L26:
        return this.sig.equals(r101.sig);
    }

    public HSSPrivateKeyParameters extractKeyShard(int r110) {
        monitor-enter(this);
        long r100 = r110;
        if (getUsagesRemaining() < r100) goto L9;
        long r101 = this.index;     // Catch: Throwable -> L10
        this.index = r100 + r101;     // Catch: Throwable -> L10
        ArrayList r102 = new ArrayList(getKeys());     // Catch: Throwable -> L10
        ArrayList r103 = new ArrayList(getSig());     // Catch: Throwable -> L10
        HSSPrivateKeyParameters r111 = makeCopy(new HSSPrivateKeyParameters(this.f525524l, r102, r103, r101, r101 + r100, true));     // Catch: Throwable -> L10
        resetKeyToIndex();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r111;
    L9:
        throw new IllegalArgumentException("usageCount exceeds usages remaining in current leaf");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    public LMSContext generateLMSContext() {
        int r100 = getL();
        monitor-enter(this);
        HSS.rangeTestKeys(this);     // Catch: Throwable -> L11
        List<LMSPrivateKeyParameters> r101 = getKeys();     // Catch: Throwable -> L11
        List<LMSSignature> r102 = getSig();     // Catch: Throwable -> L11
        int r103 = r100 - 1;     // Catch: Throwable -> L11
        LMSPrivateKeyParameters r104 = getKeys().get(r103);     // Catch: Throwable -> L11
        LMSSignedPubKey[] r105 = new LMSSignedPubKey[r103];     // Catch: Throwable -> L11
        int r106 = 0;
    L5:
        if (r106 >= r103) goto L7;
        int r107 = r106 + 1;     // Catch: Throwable -> L11
        r105[r106] = new LMSSignedPubKey(r102.get(r106), r101.get(r107).getPublicKey());     // Catch: Throwable -> L11
        r106 = r107;
        goto L5
    L7:
        incIndex();     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r104.generateLMSContext().withSignedPublicKeys(r105);
    L11:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    public byte[] generateSignature(LMSContext r100) {
        return HSS.generateSignature(getL(), r100).getEncoded();
    L4:
        e = move-exception;
        throw new IllegalStateException("unable to encode signature: " + e.getMessage(), e);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSKeyParameters, org.bouncycastle.util.Encodable
    public synchronized byte[] getEncoded() throws IOException {
        monitor-enter(this);
        Composer r100 = Composer.compose().u32str(0).u32str(this.f525524l).u64str(this.index).u64str(this.indexLimit).bool(this.isShard);     // Catch: Throwable -> L14
        Iterator<LMSPrivateKeyParameters> r101 = this.keys.iterator();     // Catch: Throwable -> L14
    L5:
        if (r101.hasNext() == false) goto L7;
        r100.bytes(r101.next());     // Catch: Throwable -> L14
        goto L5
    L7:
        Iterator<LMSSignature> r102 = this.sig.iterator();     // Catch: Throwable -> L14
    L9:
        if (r102.hasNext() == false) goto L11;
        r100.bytes(r102.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        byte[] r103 = r100.build();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r103;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized long getIndex() {
        monitor-enter(this);
        long r100 = this.index;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public long getIndexLimit() {
        return this.indexLimit;
    }

    public synchronized List<LMSPrivateKeyParameters> getKeys() {
        monitor-enter(this);
        List<LMSPrivateKeyParameters> r100 = this.keys;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public int getL() {
        return this.f525524l;
    }

    public synchronized LMSParameters[] getLMSParameters() {
        monitor-enter(this);
        int r100 = this.keys.size();     // Catch: Throwable -> L9
        LMSParameters[] r101 = new LMSParameters[r100];     // Catch: Throwable -> L9
        int r102 = 0;
    L4:
        if (r102 >= r100) goto L7;
        LMSPrivateKeyParameters r103 = (LMSPrivateKeyParameters) ListProtector.get(this.keys, r102);     // Catch: Throwable -> L9
        r101[r102] = new LMSParameters(r103.getSigParameters(), r103.getOtsParameters());     // Catch: Throwable -> L9
        r102 = r102 + 1;
        goto L4
    L7:
        monitor-exit(this);
        return r101;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized HSSPublicKeyParameters getPublicKey() {
        monitor-enter(this);
        HSSPublicKeyParameters r100 = new HSSPublicKeyParameters(this.f525524l, getRootKey().getPublicKey());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public LMSPrivateKeyParameters getRootKey() {
        return (LMSPrivateKeyParameters) ListProtector.get(this.keys, 0);
    }

    public synchronized List<LMSSignature> getSig() {
        monitor-enter(this);
        List<LMSSignature> r100 = this.sig;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner
    public long getUsagesRemaining() {
        return this.indexLimit - this.index;
    }

    public int hashCode() {
        int r100 = ((((((this.f525524l * 31) + (this.isShard ? 1 : 0)) * 31) + this.keys.hashCode()) * 31) + this.sig.hashCode()) * 31;
        long r101 = this.indexLimit;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.index;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public synchronized void incIndex() {
        monitor-enter(this);
        this.index++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean isShard() {
        return this.isShard;
    }

    public void replaceConsumedKey(int r100) {
        int r101 = r100 - 1;
        SeedDerive r102 = ((LMSPrivateKeyParameters) ListProtector.get(this.keys, r101)).getCurrentOTSKey().getDerivationFunction();
        r102.setJ(-2);
        byte[] r103 = new byte[32];
        r102.deriveSeed(r103, true);
        byte[] r104 = new byte[32];
        r102.deriveSeed(r104, false);
        byte[] r105 = new byte[16];
        System.arraycopy(r104, 0, r105, 0, 16);
        ArrayList r106 = new ArrayList(this.keys);
        LMSPrivateKeyParameters r107 = (LMSPrivateKeyParameters) ListProtector.get(this.keys, r100);
        ListProtector.set(r106, r100, LMS.generateKeys(r107.getSigParameters(), r107.getOtsParameters(), 0, r105, r103));
        ArrayList r108 = new ArrayList(this.sig);
        ListProtector.set(r108, r101, LMS.generateSign((LMSPrivateKeyParameters) ListProtector.get(r106, r101), ((LMSPrivateKeyParameters) ListProtector.get(r106, r100)).getPublicKey().toByteArray()));
        this.keys = Collections.unmodifiableList(r106);
        this.sig = Collections.unmodifiableList(r108);
    }

    public void resetKeyToIndex() {
        List<LMSPrivateKeyParameters> r100 = getKeys();
        int r101 = r100.size();
        long[] r102 = new long[r101];
        long r103 = getIndex();
        int r104 = r100.size() - 1;
    L3:
        if (r104 < 0) goto L5;
        LMSigParameters r105 = ((LMSPrivateKeyParameters) ListProtector.get(r100, r104)).getSigParameters();
        r102[r104] = ((long) ((1 << r105.getH()) - 1)) & r103;
        r103 = r103 >>> r105.getH();
        r104 = r104 - 1;
        goto L3
    L5:
        LMSPrivateKeyParameters[] r106 = (LMSPrivateKeyParameters[]) r100.toArray(new LMSPrivateKeyParameters[r100.size()]);
        List<LMSSignature> r107 = this.sig;
        LMSSignature[] r108 = (LMSSignature[]) r107.toArray(new LMSSignature[r107.size()]);
        LMSPrivateKeyParameters r109 = getRootKey();
        if ((r106[0].getIndex() - 1) == r102[0]) goto L8;
        r106[0] = LMS.generateKeys(r109.getSigParameters(), r109.getOtsParameters(), (int) r102[0], r109.getI(), r109.getMasterSecret());
        boolean r110 = true;
    L9:
        int r111 = 1;
    L10:
        if (r111 >= r101) goto L32;
        int r112 = r111 - 1;
        LMSPrivateKeyParameters r113 = r106[r112];
        byte[] r114 = new byte[16];
        byte[] r115 = new byte[32];
        SeedDerive r116 = new SeedDerive(r113.getI(), r113.getMasterSecret(), DigestUtil.getDigest(r113.getOtsParameters().getDigestOID()));
        r116.setQ((int) r102[r112]);
        r116.setJ(-2);
        r116.deriveSeed(r115, true);
        byte[] r117 = new byte[32];
        boolean r118 = false;
        r116.deriveSeed(r117, false);
        System.arraycopy(r117, 0, r114, 0, 16);
        if (r111 >= (r101 - 1)) goto L17;
        if (r102[r111] != (r106[r111].getIndex() - 1)) goto L21;
    L18:
        r118 = true;
    L21:
        if (Arrays.areEqual(r114, r106[r111].getI()) == true) goto L23;
    L25:
        boolean r119 = false;
    L26:
        if (r119 == true) goto L29;
        LMSPrivateKeyParameters r120 = LMS.generateKeys(((LMSPrivateKeyParameters) ListProtector.get(r100, r111)).getSigParameters(), ((LMSPrivateKeyParameters) ListProtector.get(r100, r111)).getOtsParameters(), (int) r102[r111], r114, r115);
        r106[r111] = r120;
        r108[r112] = LMS.generateSign(r106[r112], r120.getPublicKey().toByteArray());
    L28:
        r110 = true;
    L31:
        r111 = r111 + 1;
        goto L10
    L29:
        if (r118 == true) goto L31;
        r106[r111] = LMS.generateKeys(((LMSPrivateKeyParameters) ListProtector.get(r100, r111)).getSigParameters(), ((LMSPrivateKeyParameters) ListProtector.get(r100, r111)).getOtsParameters(), (int) r102[r111], r114, r115);
        goto L28
    L23:
        if (Arrays.areEqual(r115, r106[r111].getMasterSecret()) == false) goto L25;
        r119 = true;
        goto L26
    L17:
        if (r102[r111] == r106[r111].getIndex()) goto L18;
        r118 = false;
        goto L21
    L32:
        if (r110 == false) goto L39;
        updateHierarchy(r106, r108);
        return;
    L39:
        return;
    L8:
        r110 = false;
        goto L9
    }

    public void updateHierarchy(LMSPrivateKeyParameters[] r100, LMSSignature[] r101) {
        monitor-enter(this);
        this.keys = Collections.unmodifiableList(java.util.Arrays.asList(r100));     // Catch: Throwable -> L6
        this.sig = Collections.unmodifiableList(java.util.Arrays.asList(r101));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
