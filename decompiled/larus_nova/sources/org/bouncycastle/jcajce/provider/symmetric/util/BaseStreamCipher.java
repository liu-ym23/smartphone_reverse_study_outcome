package org.bouncycastle.jcajce.provider.symmetric.util;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;

/* JADX INFO: loaded from: classes42.dex */
public class BaseStreamCipher extends BaseWrapCipher {
    private Class[] availableSpecs;
    private StreamCipher cipher;
    private int digest;
    private int ivLength;
    private ParametersWithIV ivParam;
    private int keySizeInBits;
    private String pbeAlgorithm;
    private PBEParameterSpec pbeSpec;

    public BaseStreamCipher(StreamCipher r100, int r101) {
        this(r100, r101, -1, -1);
    }

    public BaseStreamCipher(StreamCipher r100, int r101, int r102) {
        this(r100, r101, r102, -1);
    }

    public BaseStreamCipher(StreamCipher r100, int r101, int r102, int r103) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.cipher = r100;
        this.ivLength = r101;
        this.keySizeInBits = r102;
        this.digest = r103;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] r100, int r110, int r111, byte[] r112, int r113) throws ShortBufferException {
        if ((r113 + r111) > r112.length) goto L9;
        if (r111 == 0) goto L6;
        this.cipher.processBytes(r100, r110, r111, r112, r113);
    L6:
        this.cipher.reset();
        return r111;
    L9:
        throw new ShortBufferException("output buffer too short for input.");
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] r100, int r101, int r102) {
        if (r102 == 0) goto L5;
        byte[] r103 = engineUpdate(r100, r101, r102);
        this.cipher.reset();
        return r103;
    L5:
        this.cipher.reset();
        return new byte[0];
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        ParametersWithIV r100 = this.ivParam;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getIV();
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetKeySize(Key r100) {
        return r100.getEncoded().length * 8;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetOutputSize(int r100) {
        return r100;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams != null) goto L30;
        if (this.pbeSpec == null) goto L11;
        AlgorithmParameters r100 = createParametersInstance(this.pbeAlgorithm);     // Catch: Exception -> L8
        r100.init(this.pbeSpec);     // Catch: Exception -> L8
        return r100;
    L8:
        return null;
    L11:
        if (this.ivParam == null) goto L30;
        String r101 = this.cipher.getAlgorithmName();
        if (r101.indexOf(47) < 0) goto L16;
        r101 = r101.substring(0, r101.indexOf(47));
    L16:
        if (r101.startsWith("ChaCha7539") == false) goto L19;
        r101 = "ChaCha7539";
    L33:
        AlgorithmParameters r102 = createParametersInstance(r101);     // Catch: Exception -> L26
        this.engineParams = r102;     // Catch: Exception -> L26
        r102.init(new IvParameterSpec(this.ivParam.getIV()));     // Catch: Exception -> L26
    L26:
        e = move-exception;
        throw new RuntimeException(e.toString());
    L19:
        if (r101.startsWith("Grain") == false) goto L22;
        r101 = "Grainv1";
        goto L33
    L22:
        if (r101.startsWith("HC") == false) goto L33;
        int r103 = r101.indexOf(45);
        r101 = r101.substring(0, r103) + r101.substring(r103 + 1);
    L30:
        return this.engineParams;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int r100, Key r101, AlgorithmParameters r102, SecureRandom r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (r102 == null) goto L8;
        AlgorithmParameterSpec r104 = SpecUtil.extractSpec(r102, this.availableSpecs);
        if (r104 == null) goto L7;
    L9:
        engineInit(r100, r101, r104, r103);
        this.engineParams = r102;
        return;
    L7:
        throw new InvalidAlgorithmParameterException("can't handle parameter " + r102.toString());
    L8:
        r104 = null;
        goto L9
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int r100, Key r101, SecureRandom r102) throws InvalidKeyException {
        engineInit(r100, r101, null, r102);     // Catch: InvalidAlgorithmParameterException -> L5
        return;
    L5:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int r110, Key r111, AlgorithmParameterSpec r112, SecureRandom r113) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.engineParams = null;
        if ((r111 instanceof SecretKey) == false) goto L68;
        if ((r111 instanceof PKCS12Key) == false) goto L12;
        PKCS12Key r114 = (PKCS12Key) r111;
        PBEParameterSpec r115 = (PBEParameterSpec) r112;
        this.pbeSpec = r115;
        if ((r114 instanceof PKCS12KeyWithParameters) == false) goto L10;
        if (r115 != null) goto L10;
        PKCS12KeyWithParameters r100 = (PKCS12KeyWithParameters) r114;
        this.pbeSpec = new PBEParameterSpec(r100.getSalt(), r100.getIterationCount());
    L10:
        CipherParameters r116 = PBE.Util.makePBEParameters(r114.getEncoded(), 2, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
    L39:
        if (this.ivLength != 0) goto L41;
    L69:
        if (r110 != 1) goto L52;
    L60:
        this.cipher.init(true, r116);     // Catch: Exception -> L62
        return;
    L52:
        if (r110 == 2) goto L59;
        if (r110 == 3) goto L60;
        if (r110 == 4) goto L59;
        throw new InvalidParameterException("unknown opmode " + r110 + " passed");     // Catch: Exception -> L62
    L59:
        this.cipher.init(false, r116);     // Catch: Exception -> L62
        return;
    L62:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    L41:
        if ((r116 instanceof ParametersWithIV) == true) goto L69;
        if (r113 != null) goto L44;
        r113 = CryptoServicesRegistrar.getSecureRandom();
    L44:
        if (r110 == 1) goto L49;
        if (r110 == 3) goto L49;
        throw new InvalidAlgorithmParameterException("no IV set when one expected");
    L49:
        byte[] r117 = new byte[this.ivLength];
        r113.nextBytes(r117);
        ParametersWithIV r118 = new ParametersWithIV(r116, r117);
        this.ivParam = r118;
        r116 = r118;
        goto L69
    L12:
        if ((r111 instanceof BCPBEKey) == false) goto L28;
        BCPBEKey r119 = (BCPBEKey) r111;
        if (r119.getOID() == null) goto L16;
        String r101 = r119.getOID().getId();
    L17:
        this.pbeAlgorithm = r101;
        if (r119.getParam() == null) goto L21;
        CipherParameters r120 = r119.getParam();
        this.pbeSpec = new PBEParameterSpec(r119.getSalt(), r119.getIterationCount());
    L24:
        if (r119.getIvSize() == 0) goto L32;
        this.ivParam = (ParametersWithIV) r120;
    L32:
        r116 = r120;
        goto L39
    L21:
        if ((r112 instanceof PBEParameterSpec) == false) goto L27;
        CipherParameters r102 = PBE.Util.makePBEParameters(r119, r112, this.cipher.getAlgorithmName());
        this.pbeSpec = (PBEParameterSpec) r112;
        r120 = r102;
        goto L24
    L27:
        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
    L16:
        r101 = r119.getAlgorithm();
        goto L17
    L28:
        if (r112 != null) goto L36;
        if (this.digest > 0) goto L34;
        r120 = new KeyParameter(r111.getEncoded());
        goto L32
    L34:
        throw new InvalidKeyException("Algorithm requires a PBE key");
    L36:
        if ((r112 instanceof IvParameterSpec) == false) goto L66;
        ParametersWithIV r103 = new ParametersWithIV(new KeyParameter(r111.getEncoded()), ((IvParameterSpec) r112).getIV());
        this.ivParam = r103;
        r116 = r103;
        goto L39
    L66:
        throw new InvalidAlgorithmParameterException("unknown parameter type.");
    L68:
        throw new InvalidKeyException("Key for algorithm " + r111.getAlgorithm() + " not suitable for symmetric enryption.");
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetMode(String r100) throws NoSuchAlgorithmException {
        if (r100.equalsIgnoreCase("ECB") == false) goto L5;
        return;
    L5:
        if (r100.equals(UserProfileEvent.POSITION_NONE) == false) goto L8;
        return;
    L8:
        throw new NoSuchAlgorithmException("can't support mode ".concat(r100));
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetPadding(String r100) throws NoSuchPaddingException {
        if (r100.equalsIgnoreCase("NoPadding") == false) goto L6;
        return;
    L6:
        throw new NoSuchPaddingException("Padding " + r100 + " unknown.");
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineUpdate(byte[] r100, int r110, int r111, byte[] r112, int r113) throws ShortBufferException {
        if ((r113 + r111) > r112.length) goto L10;
        this.cipher.processBytes(r100, r110, r111, r112, r113);     // Catch: DataLengthException -> L6
        return r111;
    L6:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());
    L10:
        throw new ShortBufferException("output buffer too short for input.");
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] r100, int r101, int r110) {
        byte[] r102 = new byte[r110];
        this.cipher.processBytes(r100, r101, r110, r102, 0);
        return r102;
    }
}
