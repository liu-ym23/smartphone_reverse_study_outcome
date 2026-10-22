package com.huawei.secure.android.common.encrypt.aes;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public class CipherUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277959a = "CipherUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f277960b = "AES/GCM/NoPadding";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f277961c = "AES/CBC/PKCS5Padding";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f277962d = "AES";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f277963e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f277964f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f277965g = 12;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f277966h = 16;

    public CipherUtil() {
    }

    public static Cipher getAesCbcEncryptCipher(byte[] r100) {
        return getAesCbcEncryptCipher(r100, EncryptUtil.generateSecureRandom(16));
    }

    public static Cipher getAesGcmEncryptCipher(byte[] r100) {
        byte[] r101 = EncryptUtil.generateSecureRandom(12);
        b.a(f277959a, "getEncryptCipher: iv is : " + HexUtil.byteArray2HexStr(r101));
        return getAesGcmEncryptCipher(r100, r101);
    }

    public static int getContent(CipherConfig r100) throws IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        if (r100 != null) goto L6;
        return -1;
    L6:
        return getContent(r100.getCipher(), r100.getInput(), r100.getInputOffset(), r100.getInputLen(), r100.getOutput(), r100.getOutputOffset());
    }

    private static int a(Cipher r100, byte[] r101) {
        if (r100 == null) goto L6;
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r100.getOutputSize(r101.length);
    L6:
        return -1;
    }

    public static Cipher getAesCbcDecryptCipher(byte[] r100, Cipher r101) {
        return getAesCbcDecryptCipher(r100, r101.getIV());
    }

    public static Cipher getAesCbcEncryptCipher(byte[] r100, byte[] r101) {
        return a(r100, r101, 1);
    }

    public static int getAesCbcEncryptContentLen(byte[] r100, byte[] r101) {
        return getAesCbcEncryptContentLen(r100, r101, EncryptUtil.generateSecureRandom(16));
    }

    public static Cipher getAesGcmDecryptCipher(byte[] r100, Cipher r101) {
        return getAesGcmDecryptCipher(r100, r101.getIV());
    }

    public static Cipher getAesGcmEncryptCipher(byte[] r100, byte[] r101) {
        return b(r100, r101, 1);
    }

    public static int getAesGcmEncryptContentLen(byte[] r100, byte[] r101) {
        return getAesGcmEncryptContentLen(r100, r101, EncryptUtil.generateSecureRandom(12));
    }

    public static byte[] getContent(Cipher r100, byte[] r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        return r100.doFinal(r101, 0, r101.length);
    L9:
        b.b(f277959a, "getContent: BadPaddingException");
    L11:
        return new byte[0];
    L8:
        b.b(f277959a, "getContent: IllegalBlockSizeException");
    L12:
        b.b(f277959a, "getEncryptCOntent: cipher is null or content is null");
        return new byte[0];
    }

    public static Cipher getAesCbcDecryptCipher(byte[] r100, byte[] r101) {
        return a(r100, r101, 2);
    }

    public static Cipher getAesGcmDecryptCipher(byte[] r100, byte[] r101) {
        return b(r100, r101, 2);
    }

    private static Cipher a(byte[] r100, byte[] r101, int r102) {
        if (r101 != null) goto L4;
    L8:
        b.b(f277959a, "cbc iv param is not right");
        return null;
    L4:
        if (r101.length < 16) goto L8;
        return a(r100, r101, r102, f277961c);
    }

    private static Cipher b(byte[] r100, byte[] r101, int r102) {
        if (r101 != null) goto L4;
    L8:
        b.b(f277959a, "gcm iv param is not right");
        return null;
    L4:
        if (r101.length < 12) goto L8;
        return a(r100, r101, r102, "AES/GCM/NoPadding");
    }

    public static int getAesCbcEncryptContentLen(byte[] r100, byte[] r101, byte[] r102) {
        return a(getAesCbcEncryptCipher(r101, r102), r100);
    }

    public static int getAesGcmEncryptContentLen(byte[] r100, byte[] r101, byte[] r102) {
        return a(getAesGcmEncryptCipher(r101, r102), r100);
    }

    public static int getContent(Cipher r100, byte[] r101, byte[] r102) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        return r100.doFinal(r101, 0, r101.length, r102);
    L10:
        b.b(f277959a, "getContent: BadPaddingException");
    L11:
        return -1;
    L9:
        b.b(f277959a, "getContent: IllegalBlockSizeException");
    L8:
        b.b(f277959a, "getContent: ShortBufferException");
    L12:
        b.b(f277959a, "getEncryptCOntent: cipher is null or content is null");
        return -1;
    }

    private static Cipher a(byte[] r100, byte[] r101, int r102, String r103) {
        if (r100 != null) goto L5;
    L18:
        b.b(f277959a, "gcm encrypt param is not right");
        return null;
    L5:
        if (r100.length < 16) goto L18;
        if (AesGcm.isBuildVersionHigherThan19() == false) goto L18;
        SecretKeySpec r104 = new SecretKeySpec(r100, "AES");     // Catch: GeneralSecurityException -> L15
        Cipher r105 = Cipher.getInstance(r103);     // Catch: GeneralSecurityException -> L15
        if ("AES/GCM/NoPadding".equals(r103) == false) goto L12;
        AlgorithmParameterSpec r106 = AesGcm.getGcmAlgorithmParams(r101);     // Catch: GeneralSecurityException -> L15
    L13:
        r105.init(r102, r104, r106);     // Catch: GeneralSecurityException -> L15
        return r105;
    L12:
        r106 = new IvParameterSpec(r101);     // Catch: GeneralSecurityException -> L15
    L15:
        e = move-exception;
        b.b(f277959a, "GCM encrypt data error" + e.getMessage());
        return null;
    }

    public static int getContent(Cipher r100, byte[] r101, int r102, int r103, byte[] r104, int r105) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        return r100.doFinal(r101, r102, r103, r104, r105);
    L7:
        b.b(f277959a, "getEncryptCOntent: cipher is null or content is null");
        return -1;
    }
}
