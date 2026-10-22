package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;
import org.bouncycastle.pqc.crypto.StateAwareMessageSigner;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSSigner implements StateAwareMessageSigner {
    private boolean hasGenerated;
    private boolean initSign;
    private KeyedHashFunctions khf;
    private XMSSParameters params;
    private XMSSPrivateKeyParameters privateKey;
    private XMSSPublicKeyParameters publicKey;
    private WOTSPlus wotsPlus;

    public XMSSSigner() {
    }

    private WOTSPlusSignature wotsSign(byte[] r100, OTSHashAddress r101) {
        if (r100.length != this.params.getTreeDigestSize()) goto L10;
        if (r101 == null) goto L8;
        WOTSPlus r102 = this.wotsPlus;
        r102.importKeys(r102.getWOTSPlusSecretKey(this.privateKey.getSecretKeySeed(), r101), this.privateKey.getPublicSeed());
        return this.wotsPlus.sign(r100, r101);
    L8:
        throw new NullPointerException("otsHashAddress == null");
    L10:
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] r100) {
        if (r100 == null) goto L31;
        if (this.initSign == false) goto L29;
        XMSSPrivateKeyParameters r101 = this.privateKey;
        if (r101 == null) goto L27;
        monitor-enter(r101);
    L23:
        th = move-exception;
        throw th;
    L9:
        if (this.privateKey.getUsagesRemaining() <= 0) goto L22;
        if (this.privateKey.getBDSState().getAuthenticationPath().isEmpty() == true) goto L20;
        int r102 = this.privateKey.getIndex();     // Catch: Throwable -> L16
        this.hasGenerated = true;     // Catch: Throwable -> L16
        long r103 = r102;
        byte[] r104 = this.khf.PRF(this.privateKey.getSecretKeyPRF(), XMSSUtil.toBytesBigEndian(r103, 32));     // Catch: Throwable -> L16
        byte[] r105 = new XMSSSignature.Builder(this.params).withIndex(r102).withRandom(r104).withWOTSPlusSignature(wotsSign(this.khf.HMsg(Arrays.concatenate(r104, this.privateKey.getRoot(), XMSSUtil.toBytesBigEndian(r103, this.params.getTreeDigestSize())), r100), (OTSHashAddress) new OTSHashAddress.Builder().withOTSAddress(r102).build())).withAuthPath(this.privateKey.getBDSState().getAuthenticationPath()).build().toByteArray();     // Catch: Throwable -> L16
        this.privateKey.getBDSState().markUsed();     // Catch: Throwable -> L23
        this.privateKey.rollKey();     // Catch: Throwable -> L23
        monitor-exit(r101);     // Catch: Throwable -> L23
        return r105;
    L16:
        th = move-exception;
        this.privateKey.getBDSState().markUsed();     // Catch: Throwable -> L23
        this.privateKey.rollKey();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L20:
        throw new IllegalStateException("not initialized");     // Catch: Throwable -> L23
    L22:
        throw new ExhaustedPrivateKeyException("no usages of private key remaining");     // Catch: Throwable -> L23
    L27:
        throw new IllegalStateException("signing key no longer usable");
    L29:
        throw new IllegalStateException("signer not initialized for signature generation");
    L31:
        throw new NullPointerException("message == null");
    }

    @Override // org.bouncycastle.pqc.crypto.StateAwareMessageSigner
    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        XMSSPrivateKeyParameters r100 = this.privateKey;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.hasGenerated == false) goto L9;
        XMSSPrivateKeyParameters r101 = this.privateKey;     // Catch: Throwable -> L14
        this.privateKey = null;     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L9:
        XMSSPrivateKeyParameters r102 = this.privateKey;     // Catch: Throwable -> L14
        if (r102 == null) goto L12;
        this.privateKey = r102.getNextKey();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r102;
    }

    public long getUsagesRemaining() {
        return this.privateKey.getUsagesRemaining();
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == false) goto L5;
        this.initSign = true;
        this.hasGenerated = false;
        XMSSPrivateKeyParameters r102 = (XMSSPrivateKeyParameters) r101;
        this.privateKey = r102;
        XMSSParameters r103 = r102.getParameters();
    L6:
        this.params = r103;
        WOTSPlus r104 = this.params.getWOTSPlus();
        this.wotsPlus = r104;
        this.khf = r104.getKhf();
        return;
    L5:
        this.initSign = false;
        XMSSPublicKeyParameters r105 = (XMSSPublicKeyParameters) r101;
        this.publicKey = r105;
        r103 = r105.getParameters();
        goto L6
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] r100, byte[] r101) {
        XMSSSignature r102 = new XMSSSignature.Builder(this.params).withSignature(r101).build();
        int r103 = r102.getIndex();
        this.wotsPlus.importKeys(new byte[this.params.getTreeDigestSize()], this.publicKey.getPublicSeed());
        long r104 = r103;
        byte[] r105 = this.khf.HMsg(Arrays.concatenate(r102.getRandom(), this.publicKey.getRoot(), XMSSUtil.toBytesBigEndian(r104, this.params.getTreeDigestSize())), r100);
        int r106 = this.params.getHeight();
        int r107 = XMSSUtil.getLeafIndex(r104, r106);
        return Arrays.constantTimeAreEqual(XMSSVerifierUtil.getRootNodeFromSignature(this.wotsPlus, r106, r105, r102, (OTSHashAddress) new OTSHashAddress.Builder().withOTSAddress(r103).build(), r107).getValue(), this.publicKey.getRoot());
    }
}
