package org.bouncycastle.jcajce.provider.symmetric.util;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.GCMParameters;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.DSTU7624Engine;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.AEADCipher;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.CTSBlockCipher;
import org.bouncycastle.crypto.modes.EAXBlockCipher;
import org.bouncycastle.crypto.modes.GCFBBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.GOFBBlockCipher;
import org.bouncycastle.crypto.modes.KCCMBlockCipher;
import org.bouncycastle.crypto.modes.KCTRBlockCipher;
import org.bouncycastle.crypto.modes.KGCMBlockCipher;
import org.bouncycastle.crypto.modes.OCBBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.bouncycastle.crypto.modes.PGPCFBBlockCipher;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.ISO10126d2Padding;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.TBCPadding;
import org.bouncycastle.crypto.paddings.X923Padding;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.params.RC5Parameters;
import org.bouncycastle.jcajce.PBKDF1Key;
import org.bouncycastle.jcajce.PBKDF1KeyWithParameters;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.jcajce.spec.AEADParameterSpec;
import org.bouncycastle.jcajce.spec.GOST28147ParameterSpec;
import org.bouncycastle.jcajce.spec.RepeatedSecretKeySpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class BaseBlockCipher extends BaseWrapCipher {
    private static final int BUF_SIZE = 512;
    private static final Class gcmSpecClass = null;
    private AEADParameters aeadParams;
    private Class[] availableSpecs;
    private BlockCipher baseEngine;
    private GenericBlockCipher cipher;
    private int digest;
    private BlockCipherProvider engineProvider;
    private boolean fixedIv;
    private int ivLength;
    private ParametersWithIV ivParam;
    private int keySizeInBits;
    private String modeName;
    private boolean padded;
    private String pbeAlgorithm;
    private PBEParameterSpec pbeSpec;
    private int scheme;

    public static class AEADGenericBlockCipher implements GenericBlockCipher {
        private static final Constructor aeadBadTagConstructor = null;
        private AEADCipher cipher;

        static {
            Class r100 = ClassUtil.loadClass(BaseBlockCipher.class, "javax.crypto.AEADBadTagException");
            if (r100 == null) goto L5;
            Constructor r101 = findExceptionConstructor(r100);
        L6:
            aeadBadTagConstructor = r101;
            return;
        L5:
            r101 = null;
            goto L6
        }

        public AEADGenericBlockCipher(AEADCipher r100) {
            this.cipher = r100;
        }

        public static /* synthetic */ AEADCipher access$000(AEADGenericBlockCipher r100) {
            return r100.cipher;
        }

        private static Constructor findExceptionConstructor(Class r100) {
            return r100.getConstructor(new Class[]{String.class});
        L5:
            return null;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int doFinal(byte[] r100, int r101) throws IllegalStateException, BadPaddingException {
            return this.cipher.doFinal(r100, r101);
        L4:
            e = move-exception;
            Constructor r102 = aeadBadTagConstructor;
            if (r102 == null) goto L14;
            BadPaddingException r103 = (BadPaddingException) r102.newInstance(new Object[]{e.getMessage()});     // Catch: Exception -> L10
        L11:
            if (r103 == null) goto L14;
            throw r103;
        L10:
            r103 = null;
        L14:
            throw new BadPaddingException(e.getMessage());
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public String getAlgorithmName() {
            AEADCipher r100 = this.cipher;
            if ((r100 instanceof AEADBlockCipher) == false) goto L7;
            return ((AEADBlockCipher) r100).getUnderlyingCipher().getAlgorithmName();
        L7:
            return r100.getAlgorithmName();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getOutputSize(int r100) {
            return this.cipher.getOutputSize(r100);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public BlockCipher getUnderlyingCipher() {
            AEADCipher r100 = this.cipher;
            if ((r100 instanceof AEADBlockCipher) == true) goto L5;
            return null;
        L5:
            return ((AEADBlockCipher) r100).getUnderlyingCipher();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getUpdateOutputSize(int r100) {
            return this.cipher.getUpdateOutputSize(r100);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
            this.cipher.init(r100, r101);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processByte(byte r100, byte[] r101, int r102) throws DataLengthException {
            return this.cipher.processByte(r100, r101, r102);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processBytes(byte[] r100, int r101, int r102, byte[] r110, int r111) throws DataLengthException {
            return this.cipher.processBytes(r100, r101, r102, r110, r111);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void updateAAD(byte[] r100, int r101, int r102) {
            this.cipher.processAADBytes(r100, r101, r102);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public boolean wrapOnNoPadding() {
            return false;
        }
    }

    public static class BufferedGenericBlockCipher implements GenericBlockCipher {
        private BufferedBlockCipher cipher;

        public BufferedGenericBlockCipher(BlockCipher r100) {
            this.cipher = new PaddedBufferedBlockCipher(r100);
        }

        public BufferedGenericBlockCipher(BlockCipher r100, BlockCipherPadding r101) {
            this.cipher = new PaddedBufferedBlockCipher(r100, r101);
        }

        public BufferedGenericBlockCipher(BufferedBlockCipher r100) {
            this.cipher = r100;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int doFinal(byte[] r100, int r101) throws IllegalStateException, BadPaddingException {
            return this.cipher.doFinal(r100, r101);
        L4:
            e = move-exception;
            throw new BadPaddingException(e.getMessage());
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getOutputSize(int r100) {
            return this.cipher.getOutputSize(r100);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getUpdateOutputSize(int r100) {
            return this.cipher.getUpdateOutputSize(r100);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
            this.cipher.init(r100, r101);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processByte(byte r100, byte[] r101, int r102) throws DataLengthException {
            return this.cipher.processByte(r100, r101, r102);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processBytes(byte[] r100, int r101, int r102, byte[] r110, int r111) throws DataLengthException {
            return this.cipher.processBytes(r100, r101, r102, r110, r111);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void updateAAD(byte[] r100, int r101, int r102) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public boolean wrapOnNoPadding() {
            return !(this.cipher instanceof CTSBlockCipher);
        }
    }

    public interface GenericBlockCipher {
        int doFinal(byte[] r100, int r101) throws IllegalStateException, BadPaddingException;

        String getAlgorithmName();

        int getOutputSize(int r100);

        BlockCipher getUnderlyingCipher();

        int getUpdateOutputSize(int r100);

        void init(boolean r100, CipherParameters r101) throws IllegalArgumentException;

        int processByte(byte r100, byte[] r101, int r102) throws DataLengthException;

        int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r104) throws DataLengthException;

        void updateAAD(byte[] r100, int r101, int r102);

        boolean wrapOnNoPadding();
    }

    static {
        gcmSpecClass = ClassUtil.loadClass(BaseBlockCipher.class, "javax.crypto.spec.GCMParameterSpec");
    }

    public BaseBlockCipher(BlockCipher r100) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = r100;
        this.cipher = new BufferedGenericBlockCipher(r100);
    }

    public BaseBlockCipher(BlockCipher r100, int r101) {
        this(r100, true, r101);
    }

    public BaseBlockCipher(BlockCipher r100, int r101, int r102, int r103, int r104) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = r100;
        this.scheme = r101;
        this.digest = r102;
        this.keySizeInBits = r103;
        this.ivLength = r104;
        this.cipher = new BufferedGenericBlockCipher(r100);
    }

    public BaseBlockCipher(BlockCipher r100, boolean r101, int r102) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = r100;
        this.fixedIv = r101;
        this.cipher = new BufferedGenericBlockCipher(r100);
        this.ivLength = r102 / 8;
    }

    public BaseBlockCipher(BufferedBlockCipher r100, int r101) {
        this(r100, true, r101);
    }

    public BaseBlockCipher(BufferedBlockCipher r100, boolean r101, int r102) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = r100.getUnderlyingCipher();
        this.cipher = new BufferedGenericBlockCipher(r100);
        this.fixedIv = r101;
        this.ivLength = r102 / 8;
    }

    public BaseBlockCipher(AEADBlockCipher r100) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        BlockCipher r101 = r100.getUnderlyingCipher();
        this.baseEngine = r101;
        this.ivLength = r101.getBlockSize();
        this.cipher = new AEADGenericBlockCipher(r100);
    }

    public BaseBlockCipher(AEADBlockCipher r100, boolean r101, int r102) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = r100.getUnderlyingCipher();
        this.fixedIv = r101;
        this.ivLength = r102;
        this.cipher = new AEADGenericBlockCipher(r100);
    }

    public BaseBlockCipher(AEADCipher r100, boolean r101, int r102) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = null;
        this.fixedIv = r101;
        this.ivLength = r102;
        this.cipher = new AEADGenericBlockCipher(r100);
    }

    public BaseBlockCipher(BlockCipherProvider r100) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = r100.get();
        this.engineProvider = r100;
        this.cipher = new BufferedGenericBlockCipher(r100.get());
    }

    private CipherParameters adjustParameters(AlgorithmParameterSpec r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithIV) == false) goto L17;
        CipherParameters r102 = ((ParametersWithIV) r101).getParameters();
        if ((r100 instanceof IvParameterSpec) == false) goto L9;
        ParametersWithIV r103 = new ParametersWithIV(r102, ((IvParameterSpec) r100).getIV());
    L7:
        this.ivParam = r103;
        return r103;
    L9:
        if ((r100 instanceof GOST28147ParameterSpec) == false) goto L29;
        GOST28147ParameterSpec r104 = (GOST28147ParameterSpec) r100;
        ParametersWithSBox r105 = new ParametersWithSBox(r101, r104.getSbox());
        if (r104.getIV() == null) goto L30;
        if (this.ivLength == 0) goto L30;
        r103 = new ParametersWithIV(r102, r104.getIV());
    L30:
        return r105;
    L29:
        return r101;
    L17:
        if ((r100 instanceof IvParameterSpec) == false) goto L21;
        ParametersWithIV r106 = new ParametersWithIV(r101, ((IvParameterSpec) r100).getIV());
        this.ivParam = r106;
        CipherParameters r107 = r106;
    L31:
        return r107;
    L21:
        if ((r100 instanceof GOST28147ParameterSpec) == false) goto L32;
        GOST28147ParameterSpec r108 = (GOST28147ParameterSpec) r100;
        ParametersWithSBox r109 = new ParametersWithSBox(r101, r108.getSbox());
        r107 = r109;
        if (r108.getIV() == null) goto L31;
        r107 = r109;
        if (this.ivLength == 0) goto L31;
        return new ParametersWithIV(r109, r108.getIV());
    L32:
        return r101;
    }

    private boolean isAEADModeName(String r100) {
        if ("CCM".equals(r100) == false) goto L5;
    L12:
        return true;
    L5:
        if ("EAX".equals(r100) == true) goto L12;
        if ("GCM".equals(r100) == true) goto L12;
        if ("OCB".equals(r100) == true) goto L12;
        return false;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] r100, int r110, int r111, byte[] r112, int r113) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        if ((engineGetOutputSize(r111) + r113) > r112.length) goto L17;
        if (r111 != 0) goto L18;
        int r101 = 0;
    L7:
    L13:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());
    L10:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());
    L9:
        return r101 + this.cipher.doFinal(r112, r113 + r101);
    L18:
        r101 = this.cipher.processBytes(r100, r110, r111, r112, r113);     // Catch: DataLengthException -> L10 OutputLengthException -> L13
        goto L7
    L17:
        throw new ShortBufferException("output buffer too short for input.");
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] r110, int r111, int r112) throws IllegalBlockSizeException, BadPaddingException {
        int r100 = engineGetOutputSize(r112);
        byte[] r101 = new byte[r100];
        if (r112 == 0) goto L5;
        int r113 = this.cipher.processBytes(r110, r111, r112, r101, 0);
    L18:
        int r114 = r113 + this.cipher.doFinal(r101, r113);
        if (r114 != r100) goto L10;
        return r101;
    L10:
        if (r114 > r100) goto L14;
        byte[] r115 = new byte[r114];
        System.arraycopy(r101, 0, r115, 0, r114);
        return r115;
    L14:
        throw new IllegalBlockSizeException("internal buffer overflow");
    L15:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());
    L5:
        r113 = 0;
        goto L18
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        BlockCipher r100 = this.baseEngine;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getBlockSize();
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        AEADParameters r100 = this.aeadParams;
        if (r100 != null) goto L5;
        ParametersWithIV r101 = this.ivParam;
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.getIV();
    L5:
        return r100.getNonce();
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetKeySize(Key r100) {
        return r100.getEncoded().length * 8;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetOutputSize(int r100) {
        return this.cipher.getOutputSize(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams != null) goto L35;
        if (this.pbeSpec == null) goto L11;
        AlgorithmParameters r100 = createParametersInstance(this.pbeAlgorithm);     // Catch: Exception -> L8
        this.engineParams = r100;     // Catch: Exception -> L8
        r100.init(this.pbeSpec);     // Catch: Exception -> L8
    L8:
        return null;
    L11:
        if (this.aeadParams == null) goto L25;
        if (this.baseEngine == null) goto L42;
        AlgorithmParameters r101 = createParametersInstance("GCM");     // Catch: Exception -> L21
        this.engineParams = r101;     // Catch: Exception -> L21
        r101.init(new GCMParameters(this.aeadParams.getNonce(), this.aeadParams.getMacSize() / 8).getEncoded());     // Catch: Exception -> L21
    L21:
        e = move-exception;
        throw new RuntimeException(e.toString());
    L42:
        AlgorithmParameters r102 = createParametersInstance(PKCSObjectIdentifiers.id_alg_AEADChaCha20Poly1305.getId());     // Catch: Exception -> L16
        this.engineParams = r102;     // Catch: Exception -> L16
        r102.init(new DEROctetString(this.aeadParams.getNonce()).getEncoded());     // Catch: Exception -> L16
    L16:
        e = move-exception;
        throw new RuntimeException(e.toString());
    L25:
        if (this.ivParam == null) goto L35;
        String r103 = this.cipher.getUnderlyingCipher().getAlgorithmName();
        if (r103.indexOf(47) < 0) goto L38;
        r103 = r103.substring(0, r103.indexOf(47));
    L38:
        AlgorithmParameters r104 = createParametersInstance(r103);     // Catch: Exception -> L31
        this.engineParams = r104;     // Catch: Exception -> L31
        r104.init(new IvParameterSpec(this.ivParam.getIV()));     // Catch: Exception -> L31
    L31:
        e = move-exception;
        throw new RuntimeException(e.toString());
    L35:
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher] */
    /* JADX WARN: Type inference failed for: r0v21, types: [org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v11, types: [org.bouncycastle.crypto.CipherParameters, org.bouncycastle.crypto.params.RC5Parameters] */
    /* JADX WARN: Type inference failed for: r6v14, types: [org.bouncycastle.crypto.CipherParameters, org.bouncycastle.crypto.params.RC2Parameters] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18, types: [org.bouncycastle.crypto.CipherParameters, org.bouncycastle.crypto.params.ParametersWithSBox] */
    /* JADX WARN: Type inference failed for: r6v21, types: [org.bouncycastle.crypto.params.ParametersWithIV] */
    /* JADX WARN: Type inference failed for: r6v24, types: [org.bouncycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r6v25, types: [org.bouncycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r6v26, types: [org.bouncycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29, types: [org.bouncycastle.crypto.params.AEADParameters] */
    /* JADX WARN: Type inference failed for: r6v56 */
    /* JADX WARN: Type inference failed for: r6v57 */
    /* JADX WARN: Type inference failed for: r6v58 */
    /* JADX WARN: Type inference failed for: r6v59 */
    /* JADX WARN: Type inference failed for: r6v60 */
    /* JADX WARN: Type inference failed for: r6v61 */
    /* JADX WARN: Type inference failed for: r6v62 */
    /* JADX WARN: Type inference failed for: r6v63 */
    /* JADX WARN: Type inference failed for: r6v64 */
    /* JADX WARN: Type inference failed for: r6v65 */
    /* JADX WARN: Type inference failed for: r6v66 */
    /* JADX WARN: Type inference failed for: r6v67 */
    /* JADX WARN: Type inference failed for: r6v8, types: [org.bouncycastle.crypto.CipherParameters] */
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
    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int r210, Key r211, AlgorithmParameterSpec r212, SecureRandom r213) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ?? r100 = 0;
        String r101 = null;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.engineParams = null;
        this.aeadParams = null;
        if ((r211 instanceof SecretKey) == true) goto L10;
        StringBuilder r102 = new StringBuilder("Key for algorithm ");
        if (r211 == null) goto L7;
        r101 = r211.getAlgorithm();
    L7:
        r102.append(r101);
        r102.append(" not suitable for symmetric enryption.");
        throw new InvalidKeyException(r102.toString());
    L10:
        if (r212 != null) goto L18;
        BlockCipher r103 = this.baseEngine;
        if (r103 == null) goto L18;
        if (r103.getAlgorithmName().startsWith("RC5-64") == false) goto L18;
        throw new InvalidAlgorithmParameterException("RC5 requires an RC5ParametersSpec to be passed in.");
    L18:
        int r104 = this.scheme;
        if (r104 != 2) goto L21;
    L261:
        SecretKey r105 = (SecretKey) r211;     // Catch: Exception -> L259
        if ((r212 instanceof PBEParameterSpec) == false) goto L76;
        this.pbeSpec = (PBEParameterSpec) r212;
    L76:
        boolean r106 = r105 instanceof PBEKey;
        if (r106 == false) goto L86;
        if (this.pbeSpec != null) goto L86;
        PBEKey r110 = (PBEKey) r105;
        if (r110.getSalt() == null) goto L84;
        this.pbeSpec = new PBEParameterSpec(r110.getSalt(), r110.getIterationCount());
        goto L86
    L84:
        throw new InvalidAlgorithmParameterException("PBEKey requires parameters to specify salt");
    L86:
        if (this.pbeSpec != null) goto L92;
        if (r106 == true) goto L92;
        throw new InvalidKeyException("Algorithm requires a PBE key");
    L92:
        if ((r211 instanceof BCPBEKey) == false) goto L101;
        CipherParameters r107 = ((BCPBEKey) r211).getParam();
        if ((r107 instanceof ParametersWithIV) == true) goto L98;
        if (r107 != null) goto L100;
        r107 = PBE.Util.makePBEParameters(r105.getEncoded(), 2, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
        goto L98
    L100:
        throw new InvalidKeyException("Algorithm requires a PBE key suitable for PKCS12");
    L98:
        CipherParameters r108 = r107;
    L102:
        boolean r109 = r108 instanceof ParametersWithIV;
        CipherParameters r111 = r108;
        r100 = r108;
        if (r109 == false) goto L106;
    L35:
        this.ivParam = (ParametersWithIV) r111;
        r100 = r111;
    L106:
        if ((r212 instanceof AEADParameterSpec) == false) goto L121;
        if (isAEADModeName(this.modeName) == false) goto L110;
    L114:
        AEADParameterSpec r112 = (AEADParameterSpec) r212;
        if ((r100 instanceof ParametersWithIV) == false) goto L117;
        KeyParameter r113 = (KeyParameter) ((ParametersWithIV) r100).getParameters();
    L118:
        r100 = new AEADParameters(r113, r112.getMacSizeInBits(), r112.getNonce(), r112.getAssociatedData());
    L119:
        this.aeadParams = r100;
    L216:
        ?? r114 = r100;
        if (this.ivLength == 0) goto L234;
        boolean r115 = r100 instanceof ParametersWithIV;
        r114 = r100;
        if (r115 == true) goto L234;
        boolean r116 = r100 instanceof AEADParameters;
        r114 = r100;
        if (r116 == true) goto L234;
        if (r213 != null) goto L224;
        SecureRandom r117 = CryptoServicesRegistrar.getSecureRandom();
    L225:
        if (r210 == 1) goto L233;
        if (r210 == 3) goto L233;
        r114 = r100;
        if (this.cipher.getUnderlyingCipher().getAlgorithmName().indexOf("PGPCFB") >= 0) goto L234;
        throw new InvalidAlgorithmParameterException("no IV set when one expected");
    L233:
        byte[] r118 = new byte[this.ivLength];
        r117.nextBytes(r118);
        ParametersWithIV r119 = new ParametersWithIV(r100, r118);
        this.ivParam = r119;
        r114 = r119;
        goto L234
    L224:
        r117 = r213;
    L234:
        if (r213 != null) goto L236;
    L263:
        if (r210 == 1) goto L246;
        if (r210 == 2) goto L245;
        if (r210 == 3) goto L246;
        if (r210 == 4) goto L245;
        throw new InvalidParameterException("unknown opmode " + r210 + " passed");     // Catch: Exception -> L253 IllegalArgumentException -> L256
    L245:
        this.cipher.init(false, r114);     // Catch: Exception -> L253 IllegalArgumentException -> L256
    L247:
        GenericBlockCipher r120 = this.cipher;     // Catch: Exception -> L253 IllegalArgumentException -> L256
        if ((r120 instanceof AEADGenericBlockCipher) == true) goto L250;
        return;
    L250:
        if (this.aeadParams != null) goto L265;
        this.aeadParams = new AEADParameters((KeyParameter) this.ivParam.getParameters(), AEADGenericBlockCipher.access$000((AEADGenericBlockCipher) r120).getMac().length * 8, this.ivParam.getIV());     // Catch: Exception -> L253 IllegalArgumentException -> L256
        return;
    L265:
        return;
    L246:
        this.cipher.init(true, r114);     // Catch: Exception -> L253 IllegalArgumentException -> L256
    L256:
        e = move-exception;
        throw new InvalidAlgorithmParameterException(e.getMessage(), e);
    L253:
        e = move-exception;
        throw new BaseWrapCipher.InvalidKeyOrParametersException(e.getMessage(), e);
    L236:
        if (this.padded == false) goto L263;
        r114 = new ParametersWithRandom(r114, r213);
        goto L263
    L117:
        r113 = (KeyParameter) r100;
        goto L118
    L110:
        if ((this.cipher instanceof AEADGenericBlockCipher) == true) goto L114;
        throw new InvalidAlgorithmParameterException("AEADParameterSpec can only be used with AEAD modes.");
    L121:
        if ((r212 instanceof IvParameterSpec) == false) goto L146;
        if (this.ivLength == 0) goto L138;
        IvParameterSpec r121 = (IvParameterSpec) r212;
        if (r121.getIV().length == this.ivLength) goto L134;
        if ((this.cipher instanceof AEADGenericBlockCipher) == true) goto L134;
        if (this.fixedIv == false) goto L134;
        throw new InvalidAlgorithmParameterException("IV must be " + this.ivLength + " bytes long.");
    L134:
        if ((r100 instanceof ParametersWithIV) == false) goto L136;
        ParametersWithIV r122 = new ParametersWithIV(((ParametersWithIV) r100).getParameters(), r121.getIV());
    L137:
        r100 = r122;
        this.ivParam = r100;
        goto L216
    L136:
        r122 = new ParametersWithIV(r100, r121.getIV());
        goto L137
    L138:
        String r123 = this.modeName;
        if (r123 == null) goto L216;
        if (r123.equals("ECB") == false) goto L216;
        throw new InvalidAlgorithmParameterException("ECB mode does not use an IV");
    L146:
        if ((r212 instanceof GOST28147ParameterSpec) == false) goto L157;
        GOST28147ParameterSpec r124 = (GOST28147ParameterSpec) r212;
        r100 = new ParametersWithSBox(new KeyParameter(r211.getEncoded()), r124.getSbox());
        if (r124.getIV() == null) goto L216;
        if (this.ivLength == 0) goto L216;
        if ((r100 instanceof ParametersWithIV) == false) goto L154;
        ParametersWithIV r125 = new ParametersWithIV(((ParametersWithIV) r100).getParameters(), r124.getIV());
    L155:
        this.ivParam = r125;
        r100 = r125;
        goto L216
    L154:
        r125 = new ParametersWithIV(r100, r124.getIV());
        goto L155
    L157:
        if ((r212 instanceof RC2ParameterSpec) == false) goto L167;
        RC2ParameterSpec r126 = (RC2ParameterSpec) r212;
        r100 = new RC2Parameters(r211.getEncoded(), r126.getEffectiveKeyBits());
        if (r126.getIV() == null) goto L216;
        if (this.ivLength == 0) goto L216;
        if ((r100 instanceof ParametersWithIV) == false) goto L165;
        r125 = new ParametersWithIV(((ParametersWithIV) r100).getParameters(), r126.getIV());
        goto L155
    L165:
        r125 = new ParametersWithIV(r100, r126.getIV());
        goto L155
    L167:
        if ((r212 instanceof RC5ParameterSpec) == false) goto L194;
        RC5ParameterSpec r127 = (RC5ParameterSpec) r212;
        r100 = new RC5Parameters(r211.getEncoded(), r127.getRounds());
        if (this.baseEngine.getAlgorithmName().startsWith("RC5") == false) goto L193;
        if (this.baseEngine.getAlgorithmName().equals("RC5-32") == false) goto L178;
        if (r127.getWordSize() == 32) goto L185;
        throw new InvalidAlgorithmParameterException("RC5 already set up for a word size of 32 not " + r127.getWordSize() + ".");
    L185:
        if (r127.getIV() == null) goto L216;
        if (this.ivLength == 0) goto L216;
        if ((r100 instanceof ParametersWithIV) == false) goto L191;
        r125 = new ParametersWithIV(((ParametersWithIV) r100).getParameters(), r127.getIV());
        goto L155
    L191:
        r125 = new ParametersWithIV(r100, r127.getIV());
        goto L155
    L178:
        if (this.baseEngine.getAlgorithmName().equals("RC5-64") == false) goto L185;
        if (r127.getWordSize() == 64) goto L185;
        throw new InvalidAlgorithmParameterException("RC5 already set up for a word size of 64 not " + r127.getWordSize() + ".");
    L193:
        throw new InvalidAlgorithmParameterException("RC5 parameters passed to a cipher that is not RC5.");
    L194:
        Class r128 = gcmSpecClass;
        if (r128 != null) goto L197;
    L210:
        if (r212 == null) goto L216;
        if ((r212 instanceof PBEParameterSpec) == true) goto L216;
        throw new InvalidAlgorithmParameterException("unknown parameter type.");
    L197:
        if (r128.isInstance(r212) == false) goto L210;
        if (isAEADModeName(this.modeName) == true) goto L206;
        if ((this.cipher instanceof AEADGenericBlockCipher) == true) goto L206;
        throw new InvalidAlgorithmParameterException("GCMParameterSpec can only be used with AEAD modes.");
    L206:
        if ((r100 instanceof ParametersWithIV) == false) goto L208;
        KeyParameter r129 = (KeyParameter) ((ParametersWithIV) r100).getParameters();
    L209:
        r100 = GcmSpecUtil.extractAeadParameters(r129, r212);
        goto L119
    L208:
        r129 = (KeyParameter) r100;
        goto L209
    L101:
        r108 = PBE.Util.makePBEParameters(r105.getEncoded(), 2, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
    L260:
        throw new InvalidKeyException("PKCS12 requires a SecretKey/PBEKey");
    L21:
        if ((r211 instanceof PKCS12Key) == true) goto L261;
        if ((r211 instanceof PBKDF1Key) == false) goto L37;
        PBKDF1Key r130 = (PBKDF1Key) r211;
        if ((r212 instanceof PBEParameterSpec) == false) goto L29;
        this.pbeSpec = (PBEParameterSpec) r212;
    L29:
        if ((r130 instanceof PBKDF1KeyWithParameters) == true) goto L31;
    L33:
        CipherParameters r131 = PBE.Util.makePBEParameters(r130.getEncoded(), 0, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
        boolean r132 = r131 instanceof ParametersWithIV;
        r111 = r131;
        r100 = r131;
        if (r132 == false) goto L106;
    L31:
        if (this.pbeSpec != null) goto L33;
        PBKDF1KeyWithParameters r133 = (PBKDF1KeyWithParameters) r130;
        this.pbeSpec = new PBEParameterSpec(r133.getSalt(), r133.getIterationCount());
        goto L33
    L37:
        if ((r211 instanceof BCPBEKey) == false) goto L54;
        BCPBEKey r134 = (BCPBEKey) r211;
        if (r134.getOID() == null) goto L41;
        String r135 = r134.getOID().getId();
    L42:
        this.pbeAlgorithm = r135;
        if (r134.getParam() == null) goto L46;
        CipherParameters r136 = adjustParameters(r212, r134.getParam());
    L48:
        boolean r137 = r136 instanceof ParametersWithIV;
        r111 = r136;
        r100 = r136;
        if (r137 == false) goto L106;
    L46:
        if ((r212 instanceof PBEParameterSpec) == false) goto L52;
        this.pbeSpec = (PBEParameterSpec) r212;
        r136 = PBE.Util.makePBEParameters(r134, r212, this.cipher.getUnderlyingCipher().getAlgorithmName());
        goto L48
    L52:
        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
    L41:
        r135 = r134.getAlgorithm();
        goto L42
    L54:
        if ((r211 instanceof PBEKey) == false) goto L63;
        PBEKey r138 = (PBEKey) r211;
        PBEParameterSpec r139 = (PBEParameterSpec) r212;
        this.pbeSpec = r139;
        if ((r138 instanceof PKCS12KeyWithParameters) == false) goto L59;
        if (r139 != null) goto L59;
        this.pbeSpec = new PBEParameterSpec(r138.getSalt(), r138.getIterationCount());
    L59:
        CipherParameters r140 = PBE.Util.makePBEParameters(r138.getEncoded(), this.scheme, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
        boolean r141 = r140 instanceof ParametersWithIV;
        r111 = r140;
        r100 = r140;
        if (r141 == false) goto L106;
    L63:
        if ((r211 instanceof RepeatedSecretKeySpec) == true) goto L106;
        if (r104 == 0) goto L71;
        if (r104 == 4) goto L71;
        if (r104 == 1) goto L71;
        if (r104 == 5) goto L71;
        r100 = new KeyParameter(r211.getEncoded());
    L71:
        throw new InvalidKeyException("Algorithm requires a PBE key");
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetMode(String r100) throws NoSuchAlgorithmException {
        if (this.baseEngine == null) goto L85;
        String r101 = Strings.toUpperCase(r100);
        this.modeName = r101;
        if (r101.equals("ECB") == false) goto L9;
        this.ivLength = 0;
        GenericBlockCipher r102 = new BufferedGenericBlockCipher(this.baseEngine);
    L7:
        this.cipher = r102;
        return;
    L9:
        if (this.modeName.equals("CBC") == false) goto L12;
        this.ivLength = this.baseEngine.getBlockSize();
        r102 = new BufferedGenericBlockCipher(new CBCBlockCipher(this.baseEngine));
        goto L7
    L12:
        if (this.modeName.startsWith("OFB") == false) goto L19;
        this.ivLength = this.baseEngine.getBlockSize();
        if (this.modeName.length() == 3) goto L17;
        BufferedGenericBlockCipher r103 = new BufferedGenericBlockCipher(new OFBBlockCipher(this.baseEngine, CastIntegerProtector.parseInt(this.modeName.substring(3))));
    L16:
        this.cipher = r103;
        return;
    L17:
        BlockCipher r104 = this.baseEngine;
        r102 = new BufferedGenericBlockCipher(new OFBBlockCipher(r104, r104.getBlockSize() * 8));
        goto L7
    L19:
        if (this.modeName.startsWith("CFB") == false) goto L25;
        this.ivLength = this.baseEngine.getBlockSize();
        if (this.modeName.length() == 3) goto L23;
        r103 = new BufferedGenericBlockCipher(new CFBBlockCipher(this.baseEngine, CastIntegerProtector.parseInt(this.modeName.substring(3))));
        goto L16
    L23:
        BlockCipher r105 = this.baseEngine;
        r102 = new BufferedGenericBlockCipher(new CFBBlockCipher(r105, r105.getBlockSize() * 8));
        goto L7
    L25:
        if (this.modeName.startsWith("PGPCFB") == false) goto L35;
        boolean r106 = this.modeName.equals("PGPCFBWITHIV");
        if (r106 == false) goto L29;
    L33:
        this.ivLength = this.baseEngine.getBlockSize();
        r103 = new BufferedGenericBlockCipher(new PGPCFBBlockCipher(this.baseEngine, r106));
        goto L16
    L29:
        if (this.modeName.length() == 6) goto L33;
        throw new NoSuchAlgorithmException("no mode support for " + this.modeName);
    L35:
        if (this.modeName.equals("OPENPGPCFB") == false) goto L38;
        this.ivLength = 0;
        r102 = new BufferedGenericBlockCipher(new OpenPGPCFBBlockCipher(this.baseEngine));
        goto L7
    L38:
        if (this.modeName.equals("SIC") == false) goto L45;
        int r107 = this.baseEngine.getBlockSize();
        this.ivLength = r107;
        if (r107 < 16) goto L43;
        this.fixedIv = false;
        r102 = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
        goto L7
    L43:
        throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
    L45:
        if (this.modeName.equals("CTR") == false) goto L51;
        this.ivLength = this.baseEngine.getBlockSize();
        this.fixedIv = false;
        BlockCipher r108 = this.baseEngine;
        if ((r108 instanceof DSTU7624Engine) == false) goto L49;
        r103 = new BufferedGenericBlockCipher(new BufferedBlockCipher(new KCTRBlockCipher(r108)));
        goto L16
    L49:
        r103 = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(r108)));
        goto L16
    L51:
        if (this.modeName.equals("GOFB") == false) goto L54;
        this.ivLength = this.baseEngine.getBlockSize();
        r102 = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(this.baseEngine)));
        goto L7
    L54:
        if (this.modeName.equals("GCFB") == false) goto L57;
        this.ivLength = this.baseEngine.getBlockSize();
        r102 = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GCFBBlockCipher(this.baseEngine)));
        goto L7
    L57:
        if (this.modeName.equals("CTS") == false) goto L60;
        this.ivLength = this.baseEngine.getBlockSize();
        r102 = new BufferedGenericBlockCipher(new CTSBlockCipher(new CBCBlockCipher(this.baseEngine)));
        goto L7
    L60:
        if (this.modeName.equals("CCM") == false) goto L66;
        this.ivLength = 12;
        if ((this.baseEngine instanceof DSTU7624Engine) == false) goto L64;
        r102 = new AEADGenericBlockCipher(new KCCMBlockCipher(this.baseEngine));
        goto L7
    L64:
        r102 = new AEADGenericBlockCipher(new CCMBlockCipher(this.baseEngine));
        goto L7
    L66:
        if (this.modeName.equals("OCB") == false) goto L73;
        if (this.engineProvider == null) goto L71;
        this.ivLength = 15;
        r102 = new AEADGenericBlockCipher(new OCBBlockCipher(this.baseEngine, this.engineProvider.get()));
        goto L7
    L71:
        throw new NoSuchAlgorithmException("can't support mode " + r100);
    L73:
        if (this.modeName.equals("EAX") == false) goto L76;
        this.ivLength = this.baseEngine.getBlockSize();
        r102 = new AEADGenericBlockCipher(new EAXBlockCipher(this.baseEngine));
        goto L7
    L76:
        if (this.modeName.equals("GCM") == false) goto L83;
        this.ivLength = this.baseEngine.getBlockSize();
        if ((this.baseEngine instanceof DSTU7624Engine) == false) goto L80;
        r102 = new AEADGenericBlockCipher(new KGCMBlockCipher(this.baseEngine));
        goto L7
    L80:
        r102 = new AEADGenericBlockCipher(new GCMBlockCipher(this.baseEngine));
        goto L7
    L83:
        throw new NoSuchAlgorithmException("can't support mode " + r100);
    L85:
        throw new NoSuchAlgorithmException("no mode supported for this algorithm");
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetPadding(String r100) throws NoSuchPaddingException {
        if (this.baseEngine == null) goto L56;
        String r101 = Strings.toUpperCase(r100);
        if (r101.equals("NOPADDING") == false) goto L10;
        if (this.cipher.wrapOnNoPadding() == false) goto L57;
        BufferedGenericBlockCipher r102 = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.cipher.getUnderlyingCipher()));
    L53:
        this.cipher = r102;
        return;
    L57:
        return;
    L10:
        if (r101.equals("WITHCTS") == false) goto L12;
    L52:
        r102 = new BufferedGenericBlockCipher(new CTSBlockCipher(this.cipher.getUnderlyingCipher()));
        goto L53
    L12:
        if (r101.equals("CTSPADDING") == true) goto L52;
        if (r101.equals("CS3PADDING") == true) goto L52;
        this.padded = true;
        if (isAEADModeName(this.modeName) == true) goto L51;
        if (r101.equals("PKCS5PADDING") == false) goto L21;
    L49:
        r102 = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher());
        goto L53
    L21:
        if (r101.equals("PKCS7PADDING") == true) goto L49;
        if (r101.equals("ZEROBYTEPADDING") == false) goto L27;
        r102 = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ZeroBytePadding());
        goto L53
    L27:
        if (r101.equals("ISO10126PADDING") == false) goto L29;
    L48:
        r102 = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO10126d2Padding());
        goto L53
    L29:
        if (r101.equals("ISO10126-2PADDING") == true) goto L48;
        if (r101.equals("X9.23PADDING") == false) goto L34;
    L47:
        r102 = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new X923Padding());
        goto L53
    L34:
        if (r101.equals("X923PADDING") == true) goto L47;
        if (r101.equals("ISO7816-4PADDING") == false) goto L39;
    L46:
        r102 = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO7816d4Padding());
        goto L53
    L39:
        if (r101.equals("ISO9797-1PADDING") == true) goto L46;
        if (r101.equals("TBCPADDING") == false) goto L45;
        r102 = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new TBCPadding());
        goto L53
    L45:
        throw new NoSuchPaddingException("Padding " + r100 + " unknown.");
    L51:
        throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
    L56:
        throw new NoSuchPaddingException("no padding supported for this algorithm");
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineUpdate(byte[] r100, int r110, int r111, byte[] r112, int r113) throws ShortBufferException {
        if ((this.cipher.getUpdateOutputSize(r111) + r113) > r112.length) goto L10;
        return this.cipher.processBytes(r100, r110, r111, r112, r113);
    L6:
        e = move-exception;
        throw new IllegalStateException(e.toString());
    L10:
        throw new ShortBufferException("output buffer too short for input.");
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] r110, int r111, int r112) {
        int r100 = this.cipher.getUpdateOutputSize(r112);
        if (r100 <= 0) goto L11;
        byte[] r101 = new byte[r100];
        int r113 = this.cipher.processBytes(r110, r111, r112, r101, 0);
        if (r113 != 0) goto L7;
        return null;
    L7:
        if (r113 == r100) goto L10;
        byte[] r114 = new byte[r113];
        System.arraycopy(r101, 0, r114, 0, r113);
        return r114;
    L10:
        return r101;
    L11:
        this.cipher.processBytes(r110, r111, r112, null, 0);
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(ByteBuffer r100) {
        int r101 = r100.remaining();
        if (r101 >= 1) goto L6;
        return;
    L6:
        if (r100.hasArray() == false) goto L9;
        engineUpdateAAD(r100.array(), r100.arrayOffset() + r100.position(), r101);
        r100.position(r100.limit());
        return;
    L9:
        if (r101 > 512) goto L11;
        byte[] r102 = new byte[r101];
        r100.get(r102);
        engineUpdateAAD(r102, 0, r101);
        Arrays.fill(r102, (byte) 0);
        return;
    L11:
        byte[] r103 = new byte[512];
    L12:
        int r104 = Math.min(512, r101);
        r100.get(r103, 0, r104);
        engineUpdateAAD(r103, 0, r104);
        r101 = r101 - r104;
        if (r101 > 0) goto L12;
        Arrays.fill(r103, (byte) 0);
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(byte[] r100, int r101, int r102) {
        this.cipher.updateAAD(r100, r101, r102);
    }
}
