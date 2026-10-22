package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import java.text.ParseException;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class XMSS {
    private final XMSSParameters params;
    private XMSSPrivateKeyParameters privateKey;
    private SecureRandom prng;
    private XMSSPublicKeyParameters publicKey;
    private WOTSPlus wotsPlus;

    public XMSS(XMSSParameters r100, SecureRandom r101) {
        if (r100 == null) goto L7;
        this.params = r100;
        this.wotsPlus = r100.getWOTSPlus();
        this.prng = r101;
        return;
    L7:
        throw new NullPointerException("params == null");
    }

    public XMSSPrivateKeyParameters exportPrivateKey() {
        return this.privateKey;
    }

    public XMSSPublicKeyParameters exportPublicKey() {
        return this.publicKey;
    }

    public void generateKeys() {
        XMSSKeyPairGenerator r100 = new XMSSKeyPairGenerator();
        r100.init(new XMSSKeyGenerationParameters(getParams(), this.prng));
        AsymmetricCipherKeyPair r101 = r100.generateKeyPair();
        this.privateKey = (XMSSPrivateKeyParameters) r101.getPrivate();
        this.publicKey = (XMSSPublicKeyParameters) r101.getPublic();
        this.wotsPlus.importKeys(new byte[this.params.getTreeDigestSize()], this.privateKey.getPublicSeed());
    }

    public int getIndex() {
        return this.privateKey.getIndex();
    }

    public XMSSParameters getParams() {
        return this.params;
    }

    public XMSSPrivateKeyParameters getPrivateKey() {
        return this.privateKey;
    }

    public byte[] getPublicSeed() {
        return this.privateKey.getPublicSeed();
    }

    public byte[] getRoot() {
        return this.privateKey.getRoot();
    }

    public WOTSPlus getWOTSPlus() {
        return this.wotsPlus;
    }

    public void importState(XMSSPrivateKeyParameters r100, XMSSPublicKeyParameters r101) {
        if (Arrays.areEqual(r100.getRoot(), r101.getRoot()) == false) goto L11;
        if (Arrays.areEqual(r100.getPublicSeed(), r101.getPublicSeed()) == false) goto L9;
        this.privateKey = r100;
        this.publicKey = r101;
        this.wotsPlus.importKeys(new byte[this.params.getTreeDigestSize()], this.privateKey.getPublicSeed());
        return;
    L9:
        throw new IllegalStateException("public seed of private key and public key do not match");
    L11:
        throw new IllegalStateException("root of private key and public key do not match");
    }

    public void importState(byte[] r100, byte[] r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L15;
        XMSSPrivateKeyParameters r102 = new XMSSPrivateKeyParameters.Builder(this.params).withPrivateKey(r100).build();
        XMSSPublicKeyParameters r103 = new XMSSPublicKeyParameters.Builder(this.params).withPublicKey(r101).build();
        if (Arrays.areEqual(r102.getRoot(), r103.getRoot()) == false) goto L13;
        if (Arrays.areEqual(r102.getPublicSeed(), r103.getPublicSeed()) == false) goto L11;
        this.privateKey = r102;
        this.publicKey = r103;
        this.wotsPlus.importKeys(new byte[this.params.getTreeDigestSize()], this.privateKey.getPublicSeed());
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

    public void setIndex(int r100) {
        this.privateKey = new XMSSPrivateKeyParameters.Builder(this.params).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(this.privateKey.getPublicSeed()).withRoot(this.privateKey.getRoot()).withBDSState(this.privateKey.getBDSState()).build();
    }

    public void setPublicSeed(byte[] r100) {
        this.privateKey = new XMSSPrivateKeyParameters.Builder(this.params).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(r100).withRoot(getRoot()).withBDSState(this.privateKey.getBDSState()).build();
        this.publicKey = new XMSSPublicKeyParameters.Builder(this.params).withRoot(getRoot()).withPublicSeed(r100).build();
        this.wotsPlus.importKeys(new byte[this.params.getTreeDigestSize()], r100);
    }

    public void setRoot(byte[] r100) {
        this.privateKey = new XMSSPrivateKeyParameters.Builder(this.params).withSecretKeySeed(this.privateKey.getSecretKeySeed()).withSecretKeyPRF(this.privateKey.getSecretKeyPRF()).withPublicSeed(getPublicSeed()).withRoot(r100).withBDSState(this.privateKey.getBDSState()).build();
        this.publicKey = new XMSSPublicKeyParameters.Builder(this.params).withRoot(r100).withPublicSeed(getPublicSeed()).build();
    }

    public byte[] sign(byte[] r100) {
        if (r100 == null) goto L6;
        XMSSSigner r101 = new XMSSSigner();
        r101.init(true, this.privateKey);
        byte[] r102 = r101.generateSignature(r100);
        XMSSPrivateKeyParameters r103 = (XMSSPrivateKeyParameters) r101.getUpdatedPrivateKey();
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
        XMSSSigner r103 = new XMSSSigner();
        r103.init(false, new XMSSPublicKeyParameters.Builder(getParams()).withPublicKey(r102).build());
        return r103.verifySignature(r100, r101);
    L8:
        throw new NullPointerException("publicKey == null");
    L10:
        throw new NullPointerException("signature == null");
    L12:
        throw new NullPointerException("message == null");
    }

    public WOTSPlusSignature wotsSign(byte[] r100, OTSHashAddress r101) {
        if (r100.length != this.params.getTreeDigestSize()) goto L10;
        if (r101 == null) goto L8;
        WOTSPlus r102 = this.wotsPlus;
        r102.importKeys(r102.getWOTSPlusSecretKey(this.privateKey.getSecretKeySeed(), r101), getPublicSeed());
        return this.wotsPlus.sign(r100, r101);
    L8:
        throw new NullPointerException("otsHashAddress == null");
    L10:
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }
}
