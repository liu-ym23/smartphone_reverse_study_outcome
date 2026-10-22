package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import java.text.ParseException;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSMT {
    private XMSSMTParameters params;
    private XMSSMTPrivateKeyParameters privateKey;
    private SecureRandom prng;
    private XMSSMTPublicKeyParameters publicKey;
    private XMSSParameters xmssParams;

    public XMSSMT(XMSSMTParameters r100, SecureRandom r101) {
        if (r100 == null) goto L7;
        this.params = r100;
        this.xmssParams = r100.getXMSSParameters();
        this.prng = r101;
        this.privateKey = new XMSSMTPrivateKeyParameters.Builder(r100).build();
        this.publicKey = new XMSSMTPublicKeyParameters.Builder(r100).build();
        return;
    L7:
        throw new NullPointerException("params == null");
    }

    private void importState(XMSSMTPrivateKeyParameters r100, XMSSMTPublicKeyParameters r101) {
        this.xmssParams.getWOTSPlus().importKeys(new byte[this.params.getTreeDigestSize()], this.privateKey.getPublicSeed());
        this.privateKey = r100;
        this.publicKey = r101;
    }

    public byte[] exportPrivateKey() {
        return this.privateKey.toByteArray();
    }

    public byte[] exportPublicKey() {
        return this.publicKey.toByteArray();
    }

    public void generateKeys() {
        XMSSMTKeyPairGenerator r100 = new XMSSMTKeyPairGenerator();
        r100.init(new XMSSMTKeyGenerationParameters(getParams(), this.prng));
        AsymmetricCipherKeyPair r101 = r100.generateKeyPair();
        this.privateKey = (XMSSMTPrivateKeyParameters) r101.getPrivate();
        XMSSMTPublicKeyParameters r102 = (XMSSMTPublicKeyParameters) r101.getPublic();
        this.publicKey = r102;
        importState(this.privateKey, r102);
    }

    public XMSSMTParameters getParams() {
        return this.params;
    }

    public byte[] getPublicSeed() {
        return this.privateKey.getPublicSeed();
    }

    public XMSSParameters getXMSS() {
        return this.xmssParams;
    }

    public void importState(byte[] r100, byte[] r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L15;
        XMSSMTPrivateKeyParameters r102 = new XMSSMTPrivateKeyParameters.Builder(this.params).withPrivateKey(r100).build();
        XMSSMTPublicKeyParameters r103 = new XMSSMTPublicKeyParameters.Builder(this.params).withPublicKey(r101).build();
        if (Arrays.areEqual(r102.getRoot(), r103.getRoot()) == false) goto L13;
        if (Arrays.areEqual(r102.getPublicSeed(), r103.getPublicSeed()) == false) goto L11;
        this.xmssParams.getWOTSPlus().importKeys(new byte[this.params.getTreeDigestSize()], r102.getPublicSeed());
        this.privateKey = r102;
        this.publicKey = r103;
        return;
    L11:
        throw new IllegalStateException("public seed of private key and public key do not match");
    L13:
        throw new IllegalStateException("root of private key and public key do not match");
    L15:
        throw new NullPointerException("publicKey == null");
    L17:
        throw new NullPointerException("privateKey == null");
    }

    public byte[] sign(byte[] r100) {
        if (r100 == null) goto L6;
        XMSSMTSigner r101 = new XMSSMTSigner();
        r101.init(true, this.privateKey);
        byte[] r102 = r101.generateSignature(r100);
        XMSSMTPrivateKeyParameters r103 = (XMSSMTPrivateKeyParameters) r101.getUpdatedPrivateKey();
        this.privateKey = r103;
        importState(r103, this.publicKey);
        return r102;
    L6:
        throw new NullPointerException("message == null");
    }

    public boolean verifySignature(byte[] r100, byte[] r101, byte[] r102) throws ParseException {
        if (r100 == null) goto L12;
        if (r101 == null) goto L10;
        if (r102 == null) goto L8;
        XMSSMTSigner r103 = new XMSSMTSigner();
        r103.init(false, new XMSSMTPublicKeyParameters.Builder(getParams()).withPublicKey(r102).build());
        return r103.verifySignature(r100, r101);
    L8:
        throw new NullPointerException("publicKey == null");
    L10:
        throw new NullPointerException("signature == null");
    L12:
        throw new NullPointerException("message == null");
    }
}
