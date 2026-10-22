package org.bouncycastle.pqc.crypto.xmss;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.StateAwareMessageSigner;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSMTSigner implements StateAwareMessageSigner {
    private boolean hasGenerated;
    private boolean initSign;
    private XMSSMTParameters params;
    private XMSSMTPrivateKeyParameters privateKey;
    private XMSSMTPublicKeyParameters publicKey;
    private WOTSPlus wotsPlus;
    private XMSSParameters xmssParams;

    public XMSSMTSigner() {
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
    public byte[] generateSignature(byte[] r110) {
        if (r110 == null) goto L49;
        if (this.initSign == false) goto L47;
        XMSSMTPrivateKeyParameters r100 = this.privateKey;
        if (r100 == null) goto L45;
        monitor-enter(r100);
    L41:
        th = move-exception;
        throw th;
    L10:
        if (this.privateKey.getUsagesRemaining() <= 0) goto L40;
        if (this.privateKey.getBDSState().isEmpty() == true) goto L38;
        BDSStateMap r101 = this.privateKey.getBDSState();     // Catch: Throwable -> L34
        long r102 = this.privateKey.getIndex();     // Catch: Throwable -> L34
        this.params.getHeight();     // Catch: Throwable -> L34
        int r103 = this.xmssParams.getHeight();     // Catch: Throwable -> L34
        if (this.privateKey.getUsagesRemaining() <= 0) goto L33;
        byte[] r104 = this.wotsPlus.getKhf().PRF(this.privateKey.getSecretKeyPRF(), XMSSUtil.toBytesBigEndian(r102, 32));     // Catch: Throwable -> L34
        byte[] r105 = this.wotsPlus.getKhf().HMsg(Arrays.concatenate(r104, this.privateKey.getRoot(), XMSSUtil.toBytesBigEndian(r102, this.params.getTreeDigestSize())), r110);     // Catch: Throwable -> L34
        this.hasGenerated = true;     // Catch: Throwable -> L34
        XMSSMTSignature r106 = new XMSSMTSignature.Builder(this.params).withIndex(r102).withRandom(r104).build();     // Catch: Throwable -> L34
        long r107 = XMSSUtil.getTreeIndex(r102, r103);     // Catch: Throwable -> L34
        int r111 = XMSSUtil.getLeafIndex(r102, r103);     // Catch: Throwable -> L34
        this.wotsPlus.importKeys(new byte[this.params.getTreeDigestSize()], this.privateKey.getPublicSeed());     // Catch: Throwable -> L34
        OTSHashAddress r112 = (OTSHashAddress) new OTSHashAddress.Builder().withTreeAddress(r107).withOTSAddress(r111).build();     // Catch: Throwable -> L34
        if (r101.get(0) == null) goto L18;
        if (r111 == 0) goto L18;
    L19:
        r106.getReducedSignatures().add(new XMSSReducedSignature.Builder(this.xmssParams).withWOTSPlusSignature(wotsSign(r105, r112)).withAuthPath(r101.get(0).getAuthenticationPath()).build());     // Catch: Throwable -> L34
        int r108 = 1;
    L21:
        if (r108 >= this.params.getLayers()) goto L28;
        XMSSNode r109 = r101.get(r108 - 1).getRoot();     // Catch: Throwable -> L34
        int r113 = XMSSUtil.getLeafIndex(r107, r103);     // Catch: Throwable -> L34
        r107 = XMSSUtil.getTreeIndex(r107, r103);     // Catch: Throwable -> L34
        OTSHashAddress r114 = (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r108).withTreeAddress(r107).withOTSAddress(r113).build();     // Catch: Throwable -> L34
        WOTSPlusSignature r115 = wotsSign(r109.getValue(), r114);     // Catch: Throwable -> L34
        if (r101.get(r108) != null) goto L25;
    L26:
        r101.put(r108, new BDS(this.xmssParams, this.privateKey.getPublicSeed(), this.privateKey.getSecretKeySeed(), r114));     // Catch: Throwable -> L34
    L27:
        r106.getReducedSignatures().add(new XMSSReducedSignature.Builder(this.xmssParams).withWOTSPlusSignature(r115).withAuthPath(r101.get(r108).getAuthenticationPath()).build());     // Catch: Throwable -> L34
        r108 = r108 + 1;     // Catch: Throwable -> L34
        goto L21
    L25:
        if (XMSSUtil.isNewBDSInitNeeded(r102, r103, r108) == false) goto L27;
    L28:
        byte[] r116 = r106.toByteArray();     // Catch: Throwable -> L34
        this.privateKey.rollKey();     // Catch: Throwable -> L41
        monitor-exit(r100);     // Catch: Throwable -> L41
        return r116;
    L18:
        r101.put(0, new BDS(this.xmssParams, this.privateKey.getPublicSeed(), this.privateKey.getSecretKeySeed(), r112));     // Catch: Throwable -> L34
        goto L19
    L33:
        throw new IllegalStateException("index out of bounds");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        this.privateKey.rollKey();     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L38:
        throw new IllegalStateException("not initialized");     // Catch: Throwable -> L41
    L40:
        throw new IllegalStateException("no usages of private key remaining");     // Catch: Throwable -> L41
    L45:
        throw new IllegalStateException("signing key no longer usable");
    L47:
        throw new IllegalStateException("signer not initialized for signature generation");
    L49:
        throw new NullPointerException("message == null");
    }

    @Override // org.bouncycastle.pqc.crypto.StateAwareMessageSigner
    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        if (this.hasGenerated == false) goto L6;
        XMSSMTPrivateKeyParameters r100 = this.privateKey;
        this.privateKey = null;
        return r100;
    L6:
        XMSSMTPrivateKeyParameters r101 = this.privateKey;
        if (r101 == null) goto L9;
        this.privateKey = r101.getNextKey();
    L9:
        return r101;
    }

    public long getUsagesRemaining() {
        return this.privateKey.getUsagesRemaining();
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public void init(boolean r100, CipherParameters r101) {
        if (r100 == false) goto L5;
        this.initSign = true;
        this.hasGenerated = false;
        XMSSMTPrivateKeyParameters r102 = (XMSSMTPrivateKeyParameters) r101;
        this.privateKey = r102;
        XMSSMTParameters r103 = r102.getParameters();
    L6:
        this.params = r103;
        this.xmssParams = r103.getXMSSParameters();
        this.wotsPlus = this.params.getWOTSPlus();
        return;
    L5:
        this.initSign = false;
        XMSSMTPublicKeyParameters r104 = (XMSSMTPublicKeyParameters) r101;
        this.publicKey = r104;
        r103 = r104.getParameters();
        goto L6
    }

    @Override // org.bouncycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] r110, byte[] r111) {
        if (r110 == null) goto L17;
        if (r111 == null) goto L15;
        if (this.publicKey == null) goto L13;
        XMSSMTSignature r112 = new XMSSMTSignature.Builder(this.params).withSignature(r111).build();
        byte[] r100 = Arrays.concatenate(r112.getRandom(), this.publicKey.getRoot(), XMSSUtil.toBytesBigEndian(r112.getIndex(), this.params.getTreeDigestSize()));
        byte[] r101 = this.wotsPlus.getKhf().HMsg(r100, r110);
        long r102 = r112.getIndex();
        int r113 = this.xmssParams.getHeight();
        long r103 = XMSSUtil.getTreeIndex(r102, r113);
        int r104 = XMSSUtil.getLeafIndex(r102, r113);
        this.wotsPlus.importKeys(new byte[this.params.getTreeDigestSize()], this.publicKey.getPublicSeed());
        OTSHashAddress r105 = (OTSHashAddress) new OTSHashAddress.Builder().withTreeAddress(r103).withOTSAddress(r104).build();
        XMSSReducedSignature r106 = (XMSSReducedSignature) ListProtector.get(r112.getReducedSignatures(), 0);
        XMSSNode r107 = XMSSVerifierUtil.getRootNodeFromSignature(this.wotsPlus, r113, r101, r106, r105, r104);
        int r108 = 1;
    L8:
        if (r108 >= this.params.getLayers()) goto L11;
        XMSSReducedSignature r109 = (XMSSReducedSignature) ListProtector.get(r112.getReducedSignatures(), r108);
        int r114 = XMSSUtil.getLeafIndex(r103, r113);
        long r115 = XMSSUtil.getTreeIndex(r103, r113);
        OTSHashAddress r116 = (OTSHashAddress) new OTSHashAddress.Builder().withLayerAddress(r108).withTreeAddress(r115).withOTSAddress(r114).build();
        r107 = XMSSVerifierUtil.getRootNodeFromSignature(this.wotsPlus, r113, r107.getValue(), r109, r116, r114);
        r108 = r108 + 1;
        r103 = r115;
        goto L8
    L11:
        return Arrays.constantTimeAreEqual(r107.getValue(), this.publicKey.getRoot());
    L13:
        throw new NullPointerException("publicKey == null");
    L15:
        throw new NullPointerException("signature == null");
    L17:
        throw new NullPointerException("message == null");
    }
}
