package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.params.SkeinParameters;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.spec.AEADParameterSpec;
import org.bouncycastle.jcajce.spec.SkeinParameterSpec;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class BaseMac extends MacSpi implements PBE {
    private static final Class gcmSpecClass = null;
    private int keySize;
    private Mac macEngine;
    private int pbeHash;
    private int scheme;

    static {
        gcmSpecClass = ClassUtil.loadClass(BaseMac.class, "javax.crypto.spec.GCMParameterSpec");
    }

    public BaseMac(Mac r100) {
        this.scheme = 2;
        this.pbeHash = 1;
        this.keySize = 160;
        this.macEngine = r100;
    }

    public BaseMac(Mac r100, int r101, int r102, int r103) {
        this.macEngine = r100;
        this.scheme = r101;
        this.pbeHash = r102;
        this.keySize = r103;
    }

    private static Hashtable copyMap(Map r100) {
        Hashtable r101 = new Hashtable();
        Iterator r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Object r103 = r102.next();
        r101.put(r103, r100.get(r103));
        goto L4
    L6:
        return r101;
    }

    @Override // javax.crypto.MacSpi
    public byte[] engineDoFinal() {
        byte[] r100 = new byte[engineGetMacLength()];
        this.macEngine.doFinal(r100, 0);
        return r100;
    }

    @Override // javax.crypto.MacSpi
    public int engineGetMacLength() {
        return this.macEngine.getMacSize();
    }

    @Override // javax.crypto.MacSpi
    public void engineInit(Key r100, AlgorithmParameterSpec r101) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (r100 == null) goto L90;
        if ((r100 instanceof PKCS12Key) == false) goto L43;
        SecretKey r102 = (SecretKey) r100;     // Catch: Exception -> L40
        PBEParameterSpec r103 = (PBEParameterSpec) r101;     // Catch: Exception -> L38
        if ((r102 instanceof PBEKey) == false) goto L11;
        if (r103 != null) goto L11;
        PBEKey r104 = (PBEKey) r102;
        r103 = new PBEParameterSpec(r104.getSalt(), r104.getIterationCount());
    L11:
        int r105 = 256;
        if (this.macEngine.getAlgorithmName().startsWith("GOST") == false) goto L14;
        int r106 = 6;
    L37:
        CipherParameters r107 = PBE.Util.makePBEMacParameters(r102, 2, r106, r105, r103);
    L56:
        if ((r107 instanceof ParametersWithIV) == false) goto L58;
        KeyParameter r108 = (KeyParameter) ((ParametersWithIV) r107).getParameters();
    L60:
        if ((r101 instanceof AEADParameterSpec) == false) goto L63;
        AEADParameterSpec r109 = (AEADParameterSpec) r101;
        r107 = new AEADParameters(r108, r109.getMacSizeInBits(), r109.getNonce(), r109.getAssociatedData());
    L93:
        this.macEngine.init(r107);     // Catch: Exception -> L82
        return;
    L82:
        e = move-exception;
        throw new InvalidAlgorithmParameterException("cannot initialize MAC: " + e.getMessage());
    L63:
        if ((r101 instanceof IvParameterSpec) == false) goto L66;
        r107 = new ParametersWithIV(r108, ((IvParameterSpec) r101).getIV());
        goto L93
    L66:
        if ((r101 instanceof RC2ParameterSpec) == false) goto L69;
        RC2ParameterSpec r110 = (RC2ParameterSpec) r101;
        r107 = new ParametersWithIV(new RC2Parameters(r108.getKey(), r110.getEffectiveKeyBits()), r110.getIV());
        goto L93
    L69:
        if ((r101 instanceof SkeinParameterSpec) == false) goto L71;
        r107 = new SkeinParameters.Builder(copyMap(((SkeinParameterSpec) r101).getParameters())).setKey(r108.getKey()).build();
        goto L93
    L71:
        if (r101 != null) goto L73;
        r107 = new KeyParameter(r100.getEncoded());
        goto L93
    L73:
        Class r111 = gcmSpecClass;
        if (r111 == null) goto L79;
        if (r111.isAssignableFrom(r101.getClass()) == false) goto L79;
        r107 = GcmSpecUtil.extractAeadParameters(r108, r101);
    L79:
        if ((r101 instanceof PBEParameterSpec) == true) goto L93;
        throw new InvalidAlgorithmParameterException("unknown parameter type: ".concat(r101.getClass().getName()));
    L58:
        r108 = (KeyParameter) r107;
        goto L60
    L14:
        Mac r112 = this.macEngine;
        if ((r112 instanceof HMac) == true) goto L17;
    L35:
        r106 = 1;
    L36:
        r105 = 160;
        goto L37
    L17:
        if (r112.getAlgorithmName().startsWith("SHA-1") == true) goto L35;
        if (this.macEngine.getAlgorithmName().startsWith(McElieceCCA2KeyGenParameterSpec.SHA224) == false) goto L22;
        r106 = 7;
        r105 = 224;
        goto L37
    L22:
        if (this.macEngine.getAlgorithmName().startsWith("SHA-256") == false) goto L25;
        r106 = 4;
        goto L37
    L25:
        if (this.macEngine.getAlgorithmName().startsWith(McElieceCCA2KeyGenParameterSpec.SHA384) == false) goto L28;
        r106 = 8;
        r105 = 384;
        goto L37
    L28:
        if (this.macEngine.getAlgorithmName().startsWith("SHA-512") == false) goto L31;
        r106 = 9;
        r105 = 512;
        goto L37
    L31:
        if (this.macEngine.getAlgorithmName().startsWith("RIPEMD160") == false) goto L34;
        r106 = 2;
        goto L36
    L34:
        throw new InvalidAlgorithmParameterException("no PKCS12 mapping for HMAC: " + this.macEngine.getAlgorithmName());
    L39:
        throw new InvalidAlgorithmParameterException("PKCS12 requires a PBEParameterSpec");
    L41:
        throw new InvalidKeyException("PKCS12 requires a SecretKey/PBEKey");
    L43:
        if ((r100 instanceof BCPBEKey) == false) goto L53;
        BCPBEKey r113 = (BCPBEKey) r100;
        if (r113.getParam() == null) goto L48;
        r107 = r113.getParam();
        goto L56
    L48:
        if ((r101 instanceof PBEParameterSpec) == false) goto L51;
        r107 = PBE.Util.makePBEMacParameters(r113, r101);
        goto L56
    L51:
        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
    L53:
        if ((r101 instanceof PBEParameterSpec) == true) goto L88;
        r107 = new KeyParameter(r100.getEncoded());
        goto L56
    L88:
        throw new InvalidAlgorithmParameterException("inappropriate parameter type: ".concat(r101.getClass().getName()));
    L90:
        throw new InvalidKeyException("key is null");
    }

    @Override // javax.crypto.MacSpi
    public void engineReset() {
        this.macEngine.reset();
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte r100) {
        this.macEngine.update(r100);
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte[] r100, int r101, int r102) {
        this.macEngine.update(r100, r101, r102);
    }
}
