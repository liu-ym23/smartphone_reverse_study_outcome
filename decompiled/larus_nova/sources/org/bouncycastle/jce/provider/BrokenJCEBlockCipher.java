package org.bouncycastle.jce.provider;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.TwofishEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.CTSBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.params.RC5Parameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class BrokenJCEBlockCipher implements BrokenPBE {
    private Class[] availableSpecs;
    private BufferedBlockCipher cipher;
    private AlgorithmParameters engineParams;
    private int ivLength;
    private ParametersWithIV ivParam;
    private int pbeHash;
    private int pbeIvSize;
    private int pbeKeySize;
    private int pbeType;

    public static class BrokePBEWithMD5AndDES extends BrokenJCEBlockCipher {
        public BrokePBEWithMD5AndDES() {
            super(new CBCBlockCipher(new DESEngine()), 0, 0, 64, 64);
        }
    }

    public static class BrokePBEWithSHA1AndDES extends BrokenJCEBlockCipher {
        public BrokePBEWithSHA1AndDES() {
            super(new CBCBlockCipher(new DESEngine()), 0, 1, 64, 64);
        }
    }

    public static class BrokePBEWithSHAAndDES2Key extends BrokenJCEBlockCipher {
        public BrokePBEWithSHAAndDES2Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 128, 64);
        }
    }

    public static class BrokePBEWithSHAAndDES3Key extends BrokenJCEBlockCipher {
        public BrokePBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 192, 64);
        }
    }

    public static class OldPBEWithSHAAndDES3Key extends BrokenJCEBlockCipher {
        public OldPBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 3, 1, 192, 64);
        }
    }

    public static class OldPBEWithSHAAndTwofish extends BrokenJCEBlockCipher {
        public OldPBEWithSHAAndTwofish() {
            super(new CBCBlockCipher(new TwofishEngine()), 3, 1, 256, 128);
        }
    }

    public BrokenJCEBlockCipher(BlockCipher r100) {
        this.availableSpecs = new Class[]{IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.ivLength = 0;
        this.engineParams = null;
        this.cipher = new PaddedBufferedBlockCipher(r100);
    }

    public BrokenJCEBlockCipher(BlockCipher r100, int r101, int r102, int r110, int r111) {
        this.availableSpecs = new Class[]{IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.ivLength = 0;
        this.engineParams = null;
        this.cipher = new PaddedBufferedBlockCipher(r100);
        this.pbeType = r101;
        this.pbeHash = r102;
        this.pbeKeySize = r110;
        this.pbeIvSize = r111;
    }

    public int engineDoFinal(byte[] r100, int r101, int r102, byte[] r110, int r111) throws IllegalBlockSizeException, BadPaddingException {
        if (r102 == 0) goto L4;
        int r103 = this.cipher.processBytes(r100, r101, r102, r110, r111);
    L14:
    L7:
        return r103 + this.cipher.doFinal(r110, r111 + r103);
    L11:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());
    L8:
        e = move-exception;
        throw new BadPaddingException(e.getMessage());
    L4:
        r103 = 0;
        goto L14
    }

    public byte[] engineDoFinal(byte[] r100, int r110, int r111) throws IllegalBlockSizeException, BadPaddingException {
        byte[] r101 = new byte[engineGetOutputSize(r111)];
        if (r111 == 0) goto L5;
        int r102 = this.cipher.processBytes(r100, r110, r111, r101, 0);
    L15:
        int r103 = r102 + this.cipher.doFinal(r101, r102);
        byte[] r112 = new byte[r103];
        System.arraycopy(r101, 0, r112, 0, r103);
        return r112;
    L12:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());
    L9:
        e = move-exception;
        throw new BadPaddingException(e.getMessage());
    L5:
        r102 = 0;
        goto L15
    }

    public int engineGetBlockSize() {
        return this.cipher.getBlockSize();
    }

    public byte[] engineGetIV() {
        ParametersWithIV r100 = this.ivParam;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getIV();
    }

    public int engineGetKeySize(Key r100) {
        return r100.getEncoded().length;
    }

    public int engineGetOutputSize(int r100) {
        return this.cipher.getOutputSize(r100);
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams != null) goto L15;
        if (this.ivParam == null) goto L15;
        String r100 = this.cipher.getUnderlyingCipher().getAlgorithmName();
        if (r100.indexOf(47) < 0) goto L16;
        r100 = r100.substring(0, r100.indexOf(47));
    L16:
        AlgorithmParameters r101 = AlgorithmParameters.getInstance(r100, "BC");     // Catch: Exception -> L11
        this.engineParams = r101;     // Catch: Exception -> L11
        r101.init(this.ivParam.getIV());     // Catch: Exception -> L11
    L11:
        e = move-exception;
        throw new RuntimeException(e.toString());
    L15:
        return this.engineParams;
    }

    public void engineInit(int r100, Key r101, AlgorithmParameters r102, SecureRandom r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec r104 = null;
        if (r102 == null) goto L14;
        int r105 = 0;
    L5:
        Class[] r106 = this.availableSpecs;
        if (r105 == r106.length) goto L10;
        r104 = r102.getParameterSpec(r106[r105]);     // Catch: Exception -> L9
    L9:
        r105 = r105 + 1;
    L10:
        if (r104 != null) goto L14;
        throw new InvalidAlgorithmParameterException("can't handle parameter " + r102.toString());
    L14:
        this.engineParams = r102;
        engineInit(r100, r101, r104, r103);
    }

    public void engineInit(int r100, Key r101, SecureRandom r102) throws InvalidKeyException {
        engineInit(r100, r101, null, r102);     // Catch: InvalidAlgorithmParameterException -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void engineInit(int r100, Key r110, AlgorithmParameterSpec r111, SecureRandom r112) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if ((r110 instanceof BCPBEKey) == false) goto L7;
        CipherParameters r113 = BrokenPBE.Util.makePBEParameters((BCPBEKey) r110, r111, this.pbeType, this.pbeHash, this.cipher.getUnderlyingCipher().getAlgorithmName(), this.pbeKeySize, this.pbeIvSize);
        CipherParameters r114 = r113;
        if (this.pbeIvSize == 0) goto L34;
        this.ivParam = (ParametersWithIV) r113;
        r114 = r113;
    L34:
        CipherParameters r115 = r114;
        if (this.ivLength == 0) goto L46;
        boolean r116 = r114 instanceof ParametersWithIV;
        r115 = r114;
        if (r116 == true) goto L46;
        if (r112 != null) goto L40;
        r112 = CryptoServicesRegistrar.getSecureRandom();
    L40:
        if (r100 == 1) goto L45;
        if (r100 == 3) goto L45;
        throw new InvalidAlgorithmParameterException("no IV set when one expected");
    L45:
        byte[] r117 = new byte[this.ivLength];
        r112.nextBytes(r117);
        ParametersWithIV r118 = new ParametersWithIV(r114, r117);
        this.ivParam = r118;
        r115 = r118;
    L46:
        if (r100 != 1) goto L48;
    L54:
        this.cipher.init(true, r115);
        return;
    L48:
        if (r100 == 2) goto L53;
        if (r100 == 3) goto L54;
        if (r100 == 4) goto L53;
        System.out.println("eeek!");
        return;
    L53:
        this.cipher.init(false, r115);
        return;
    L7:
        if (r111 != null) goto L11;
        KeyParameter r119 = new KeyParameter(r110.getEncoded());
    L9:
        r114 = r119;
        goto L34
    L11:
        if ((r111 instanceof IvParameterSpec) == false) goto L18;
        if (this.ivLength == 0) goto L16;
        ParametersWithIV r101 = new ParametersWithIV(new KeyParameter(r110.getEncoded()), ((IvParameterSpec) r111).getIV());
        this.ivParam = r101;
        CipherParameters r102 = r101;
    L15:
        r114 = r102;
        goto L34
    L16:
        r119 = new KeyParameter(r110.getEncoded());
        goto L9
    L18:
        if ((r111 instanceof RC2ParameterSpec) == false) goto L26;
        RC2ParameterSpec r120 = (RC2ParameterSpec) r111;
        RC2Parameters r103 = new RC2Parameters(r110.getEncoded(), r120.getEffectiveKeyBits());
        r102 = r103;
        if (r120.getIV() == null) goto L15;
        r102 = r103;
        if (this.ivLength == 0) goto L15;
        ParametersWithIV r121 = new ParametersWithIV(r103, r120.getIV());
    L24:
        this.ivParam = r121;
        r114 = r121;
        goto L34
    L26:
        if ((r111 instanceof RC5ParameterSpec) == false) goto L59;
        RC5ParameterSpec r122 = (RC5ParameterSpec) r111;
        RC5Parameters r104 = new RC5Parameters(r110.getEncoded(), r122.getRounds());
        if (r122.getWordSize() != 32) goto L57;
        r102 = r104;
        if (r122.getIV() == null) goto L15;
        r102 = r104;
        if (this.ivLength == 0) goto L15;
        r121 = new ParametersWithIV(r104, r122.getIV());
        goto L24
    L57:
        throw new IllegalArgumentException("can only accept RC5 word size 32 (at the moment...)");
    L59:
        throw new InvalidAlgorithmParameterException("unknown parameter type.");
    }

    public void engineSetMode(String r100) {
        String r101 = Strings.toUpperCase(r100);
        if (r101.equals("ECB") == false) goto L7;
        this.ivLength = 0;
        PaddedBufferedBlockCipher r102 = new PaddedBufferedBlockCipher(this.cipher.getUnderlyingCipher());
    L5:
        this.cipher = r102;
        return;
    L7:
        if (r101.equals("CBC") == false) goto L10;
        this.ivLength = this.cipher.getUnderlyingCipher().getBlockSize();
        r102 = new PaddedBufferedBlockCipher(new CBCBlockCipher(this.cipher.getUnderlyingCipher()));
        goto L5
    L10:
        if (r101.startsWith("OFB") == false) goto L17;
        this.ivLength = this.cipher.getUnderlyingCipher().getBlockSize();
        if (r101.length() == 3) goto L15;
        PaddedBufferedBlockCipher r103 = new PaddedBufferedBlockCipher(new OFBBlockCipher(this.cipher.getUnderlyingCipher(), CastIntegerProtector.parseInt(r101.substring(3))));
    L14:
        this.cipher = r103;
        return;
    L15:
        r102 = new PaddedBufferedBlockCipher(new OFBBlockCipher(this.cipher.getUnderlyingCipher(), this.cipher.getBlockSize() * 8));
        goto L5
    L17:
        if (r101.startsWith("CFB") == false) goto L24;
        this.ivLength = this.cipher.getUnderlyingCipher().getBlockSize();
        if (r101.length() == 3) goto L21;
        r103 = new PaddedBufferedBlockCipher(new CFBBlockCipher(this.cipher.getUnderlyingCipher(), CastIntegerProtector.parseInt(r101.substring(3))));
        goto L14
    L21:
        r102 = new PaddedBufferedBlockCipher(new CFBBlockCipher(this.cipher.getUnderlyingCipher(), this.cipher.getBlockSize() * 8));
        goto L5
    L24:
        throw new IllegalArgumentException("can't support mode " + r100);
    }

    public void engineSetPadding(String r100) throws NoSuchPaddingException {
        String r101 = Strings.toUpperCase(r100);
        if (r101.equals("NOPADDING") == false) goto L7;
        BufferedBlockCipher r102 = new BufferedBlockCipher(this.cipher.getUnderlyingCipher());
    L5:
        this.cipher = r102;
        return;
    L7:
        if (r101.equals("PKCS5PADDING") == false) goto L9;
    L18:
        r102 = new PaddedBufferedBlockCipher(this.cipher.getUnderlyingCipher());
        goto L5
    L9:
        if (r101.equals("PKCS7PADDING") == true) goto L18;
        if (r101.equals("ISO10126PADDING") == true) goto L18;
        if (r101.equals("WITHCTS") == false) goto L17;
        r102 = new CTSBlockCipher(this.cipher.getUnderlyingCipher());
        goto L5
    L17:
        throw new NoSuchPaddingException("Padding " + r100 + " unknown.");
    }

    public Key engineUnwrap(byte[] r100, String r101, int r102) throws InvalidKeyException {
        byte[] r103 = engineDoFinal(r100, 0, r100.length);     // Catch: IllegalBlockSizeException -> L27 BadPaddingException -> L30
    L5:
        if (r102 == 3) goto L7;
        KeyFactory r104 = KeyFactory.getInstance(r101, "BC");     // Catch: InvalidKeySpecException -> L18 NoSuchAlgorithmException -> L21 NoSuchProviderException -> L24
        if (r102 != 1) goto L13;
        return r104.generatePublic(new X509EncodedKeySpec(r103));
    L13:
        if (r102 != 2) goto L17;
        return r104.generatePrivate(new PKCS8EncodedKeySpec(r103));
    L17:
        throw new InvalidKeyException("Unknown key type " + r102);
    L21:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L24:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L18:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L7:
        return new SecretKeySpec(r103, r101);
    L30:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    L27:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    }

    public int engineUpdate(byte[] r100, int r101, int r102, byte[] r110, int r111) {
        return this.cipher.processBytes(r100, r101, r102, r110, r111);
    }

    public byte[] engineUpdate(byte[] r100, int r101, int r110) {
        int r102 = this.cipher.getUpdateOutputSize(r110);
        if (r102 <= 0) goto L6;
        byte[] r103 = new byte[r102];
        this.cipher.processBytes(r100, r101, r110, r103, 0);
        return r103;
    L6:
        this.cipher.processBytes(r100, r101, r110, null, 0);
        return null;
    }

    public byte[] engineWrap(Key r100) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] r101 = r100.getEncoded();
        if (r101 == null) goto L10;
        return engineDoFinal(r101, 0, r101.length);
    L6:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());
    L10:
        throw new InvalidKeyException("Cannot wrap key, null encoding.");
    }
}
