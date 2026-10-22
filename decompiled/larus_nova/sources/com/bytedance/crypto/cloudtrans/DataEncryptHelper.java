package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.engine.HKDFHelper;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes6.dex */
class DataEncryptHelper {
    private static final String ALGORITHM_AES = "AES";
    private static final String ALGORITHM_TRANSFORMATION = "AES/GCM/NoPadding";
    private static final int GCM_TAG_LENGTH = 16;
    private static final String TAG = "DataEncryptHelper";

    public DataEncryptHelper() {
    }

    public static byte[] dataDecrypt(byte[] r110, SensitiveData r111) {
        int r112 = TransUtils.bytesToInt(Arrays.copyOfRange(r110, 0, 4));     // Catch: Exception -> L35
        if (r112 != 315433677) goto L34;
        int r100 = TransUtils.bytesToInt(Arrays.copyOfRange(r110, 4, 8));     // Catch: Exception -> L35
        if (r100 != 1) goto L32;
        if (Arrays.equals(r111.getExtraInfo(), Arrays.copyOfRange(r110, 8, r111.getExtraInfo().length + 8)) == false) goto L30;
        int r101 = r111.getExtraInfo().length + 8;     // Catch: Exception -> L35
        int r102 = r101 + 32;     // Catch: Exception -> L35
        byte[] r103 = Arrays.copyOfRange(r110, r101, r102);     // Catch: Exception -> L35
        int r104 = r102 + 4;     // Catch: Exception -> L35
        int r105 = TransUtils.bytesToInt(Arrays.copyOfRange(r110, r102, r104));     // Catch: Exception -> L35
        if (r105 != 317666031) goto L28;
        int r106 = r104 + 8;     // Catch: Exception -> L35
        long r107 = TransUtils.bytesToLong(Arrays.copyOfRange(r110, r104, r106));     // Catch: Exception -> L35
        if (r107 != r111.getKeyVersion()) goto L16;
        SecretKeySpec r108 = new SecretKeySpec(HKDFHelper.deriveKey(r111.getDeviceShareKey(), r103, r111.getHKDFInfo()), "AES");     // Catch: Exception -> L35
    L20:
        int r113 = r106 + 4;     // Catch: Exception -> L35
        int r109 = TransUtils.bytesToInt(Arrays.copyOfRange(r110, r106, r113));     // Catch: Exception -> L35
        int r114 = r113 + 12;     // Catch: Exception -> L35
        byte[] r115 = Arrays.copyOfRange(r110, r113, r114);     // Catch: Exception -> L35
        int r116 = r113 + r109;     // Catch: Exception -> L35
        byte[] r117 = decrypt(Arrays.copyOfRange(r110, r114, r116), r108, r115, CryptoConst.TRANS_AES_KEY_AAD.getBytes());     // Catch: Exception -> L35
        int r118 = r116 + 12;     // Catch: Exception -> L35
        byte[] r119 = decrypt(Arrays.copyOfRange(r110, r118, r110.length), new SecretKeySpec(r117, "AES"), Arrays.copyOfRange(r110, r116, r118), CryptoConst.TRANS_AES_DATA_AAD.getBytes());     // Catch: Exception -> L35
        byte[] r120 = Arrays.copyOfRange(r119, 0, r119.length - 32);     // Catch: Exception -> L35
        if (Arrays.equals(Arrays.copyOfRange(r119, r119.length - 32, r119.length), TransUtils.sha256(r120)) == false) goto L24;
        return r120;
    L24:
        throw new CloudTransException("data decrypt failed，sha256 is error");     // Catch: Exception -> L35
    L16:
        if (r111.isOlidKeyExist() == false) goto L26;
        if (r107 != r111.getOldKeyVersion()) goto L26;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r107);     // Catch: Exception -> L35
        r108 = new SecretKeySpec(HKDFHelper.deriveKey(r111.getOldDeviceShareKey(), r103, r111.getHKDFInfo()), "AES");     // Catch: Exception -> L35
    L26:
        throw new CloudTransException("key version is error, web version: " + r107 + ", current version: " + r111.getKeyVersion(), -22);     // Catch: Exception -> L35
    L28:
        throw new CloudTransException("key cipher magic num is error, web magic num: " + r105 + ", current magic num: 317666031");     // Catch: Exception -> L35
    L30:
        throw new CloudTransException("dId and appId is error, " + CryptoUtils.byteArrayToHexString(Arrays.copyOfRange(r110, 8, r111.getExtraInfo().length + 8)));     // Catch: Exception -> L35
    L32:
        throw new CloudTransException("cipher version is error, web version: " + r100);     // Catch: Exception -> L35
    L34:
        throw new CloudTransException("magic num is error, web num: " + r112 + ", current magic num: 315433677");     // Catch: Exception -> L35
    L35:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L41;
        throw ((CloudTransException) e);
    L41:
        throw new CloudTransException("data decrypt failed, error: " + e);
    }

    public static byte[] dataEncrypt(byte[] r110, SensitiveData r111) {
        byte[] r100 = generateAES256Key();
        SecretKeySpec r101 = new SecretKeySpec(r100, "AES");
        byte[] r102 = new byte[12];
        new SecureRandom().nextBytes(r102);
        byte[] r112 = encrypt(TransUtils.concatenate(new byte[][]{r110, TransUtils.sha256(r110)}), r101, r102, CryptoConst.TRANS_AES_DATA_AAD.getBytes());     // Catch: Exception -> L18
        byte[] r103 = new byte[12];
        new SecureRandom().nextBytes(r103);
        byte[] r104 = encrypt(r100, new SecretKeySpec(r111.getSessionEncryptKey(), "AES"), r103, CryptoConst.TRANS_AES_KEY_AAD.getBytes());     // Catch: Exception -> L15
        byte[] r113 = TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(CryptoConst.TRANS_DATA_MAGIC_NUM), TransUtils.intToByteArray(1), r111.getExtraInfo(), r111.getHKDFSalt(), TransUtils.intToByteArray(CryptoConst.TRANS_KEY_CIPHER_MAGIC_NUM), TransUtils.longToByteArray(r111.getKeyVersion()), TransUtils.intToByteArray(r104.length + 12), r103, r104, r102, r112});     // Catch: IOException -> L13
        if (r113.length == 0) goto L12;
        return r113;
    L12:
        throw new CloudTransException("data encrypt failed, cipher is empty.");
    L14:
        throw new CloudTransException("data encrypt failed, concatenate error.");
    L15:
        e = move-exception;
        throw new CloudTransException("key encrypt failed.", e);
    L18:
        e = move-exception;
        throw new CloudTransException("data encrypt failed", e);
    }

    public static byte[] decrypt(byte[] r100, SecretKey r101, byte[] r102, byte[] r103) {
        Cipher r104 = Cipher.getInstance("AES/GCM/NoPadding");
        r104.init(2, r101, new GCMParameterSpec(128, r102));
        if (r103 == null) goto L6;
        r104.updateAAD(r103);
    L6:
        return r104.doFinal(r100);
    }

    public static byte[] encrypt(byte[] r100, SecretKey r101, byte[] r102, byte[] r103) {
        Cipher r104 = Cipher.getInstance("AES/GCM/NoPadding");
        r104.init(1, r101, new GCMParameterSpec(128, r102));
        if (r103 == null) goto L6;
        r104.updateAAD(r103);
    L6:
        return r104.doFinal(r100);
    }

    public static void fullStreamDecrypt(Context r110, SensitiveData r111, boolean r112, InputStream r113, OutputStream r114) {
        if (r113 == null) goto L5;
        if (r114 == null) goto L5;
    L50:
        byte[] r100 = new byte[4];     // Catch: Exception -> L47
        if (r113.read(r100) == 4) goto L10;
        TransUtils.printErrorInfo(TAG, "Input stream read magicNumBytes failed!");     // Catch: Exception -> L47
    L10:
        int r101 = CryptoUtils.byteArrayToInt(r100);     // Catch: Exception -> L47
        if (r112 == true) goto L13;
    L15:
        if (r112 == false) goto L17;
    L19:
        byte[] r102 = new byte[4];     // Catch: Exception -> L47
        if (r113.read(r102) == 4) goto L22;
        TransUtils.printErrorInfo(TAG, "Input stream read cipherVersionBytes failed!");     // Catch: Exception -> L47
    L22:
        int r103 = CryptoUtils.byteArrayToInt(r102);     // Catch: Exception -> L47
        if (r103 == 1) goto L25;
        TransUtils.printErrorInfo(TAG, "Input full cipher data version is wrong! version:" + r103);     // Catch: Exception -> L47
    L25:
        int r104 = r111.getExtraInfo().length;     // Catch: Exception -> L47
        byte[] r105 = new byte[r104];     // Catch: Exception -> L47
        if (r113.read(r105) == r104) goto L29;
        TransUtils.printErrorInfo(TAG, "Input stream read extraInfo failed!");     // Catch: Exception -> L47
    L29:
        if (Arrays.equals(r111.getExtraInfo(), r105) == true) goto L31;
        TransUtils.printErrorInfo(TAG, "dId and appId is error, " + CryptoUtils.byteArrayToHexString(r105));     // Catch: Exception -> L47
    L31:
        byte[] r106 = new byte[32];     // Catch: Exception -> L47
        if (r113.read(r106) == 32) goto L34;
        TransUtils.printErrorInfo(TAG, "Input stream read hkdfSalt failed!");     // Catch: Exception -> L47
    L34:
        byte[] r107 = new byte[76];     // Catch: Exception -> L47
        if (r113.read(r107) == 76) goto L37;
        TransUtils.printErrorInfo(TAG, "Input stream read keyCipherBytes failed!");     // Catch: Exception -> L47
    L37:
        SecretKey r108 = initFullDecryptContext(r110, r105, r107, r112, r106, r111).getEncryptKey();     // Catch: Exception -> L47
        LogUtils.d(TAG, "data key len:" + r108.getEncoded().length);     // Catch: Exception -> L47
        byte[] r109 = new byte[12];     // Catch: Exception -> L47
        if (r113.read(r109) == 12) goto L40;
        TransUtils.printErrorInfo(TAG, "Input stream read ivBytes failed!");     // Catch: Exception -> L47
    L40:
        LogUtils.d(TAG, "ivBytes:" + CryptoUtils.byteArrayToHexString(r109));     // Catch: Exception -> L47
        if (r112 == false) goto L43;
        int r115 = ChaCha20.decryptStreamDynamic(r108, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r109, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r113, r114);     // Catch: Exception -> L47
    L44:
        if (r115 == 0) goto L52;
        TransUtils.printErrorInfo(TAG, "Full ChaCha20 decryptStreamDynamic failed! error:" + r115);     // Catch: Exception -> L47
        return;
    L52:
        return;
    L43:
        r115 = ChaCha20.decryptStreamDynamic(r108, CryptoConst.ALGORITHM_CHACHA20, r109, new byte[0], 32768, r113, r114);     // Catch: Exception -> L47
        goto L44
    L17:
        if (r101 == 305441707) goto L19;
        TransUtils.printErrorInfo(TAG, "Cannot parse input stream cipher data! magic:" + r101);     // Catch: Exception -> L47
        goto L19
    L13:
        if (r101 == 305424265) goto L15;
        TransUtils.printErrorInfo(TAG, "Cannot parse input full cipher data! magic:" + r101);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data full decrypt failed! exception:" + e.getMessage());
        return;
    L5:
        TransUtils.printErrorInfo(TAG, "Input full stream is null!!");
        goto L50
    }

    public static void fullStreamEncrypt(TransCryptoContext r100, SensitiveData r110, boolean r111, InputStream r112, OutputStream r113) {
        SecretKey r101 = r100.getEncryptKey();
        LogUtils.d(TAG, "data key len:" + r101.getEncoded().length);
        byte[] r102 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L14
        if (r111 == false) goto L6;
        int r103 = CryptoConst.TRANS_FILE_FULL_CIPHER_MAGIC_NUM;
    L7:
        r113.write(TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(r103), TransUtils.intToByteArray(1), r110.getExtraInfo(), r110.getHKDFSalt(), r100.getKeyCipher(), r102}));     // Catch: Exception -> L14
        if (r111 == false) goto L10;
        int r104 = ChaCha20.encryptStreamDynamic(r101, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r102, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r112, r113);     // Catch: Exception -> L14
    L11:
        if (r104 == 0) goto L19;
        TransUtils.printErrorInfo(TAG, "Full ChaCha20 encryptStreamDynamic failed! error:" + r104);     // Catch: Exception -> L14
        return;
    L19:
        return;
    L10:
        r104 = ChaCha20.encryptStreamDynamic(r101, CryptoConst.ALGORITHM_CHACHA20, r102, new byte[0], 32768, r112, r113);     // Catch: Exception -> L14
        goto L11
    L6:
        r103 = CryptoConst.STREAM_CIPHER_MAGIC_NUM;
    L14:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data full encrypt failed! exception:" + e.getMessage());
    }

    private static byte[] generateAES256Key() {
        byte[] r100 = new byte[32];
        new SecureRandom().nextBytes(r100);
        return new SecretKeySpec(r100, "AES").getEncoded();
    }

    public static TransCryptoContext initEncryptContextInner(Context r100, String r101, String r102, SensitiveData r103, boolean r104, boolean r105) {
        TransCryptoContext r106 = new TransCryptoContext(r100, r102, r101);
    L8:
        e = move-exception;
        throw new CloudTransException("initEncryptContextInner failed, error:" + e.getMessage());
    L4:
        if (r106.initEncryptKey(r103, r104, r105) == false) goto L7;
        return r106;
    L7:
        throw new CloudTransException("initEncryptContextInner failed, initEncryptKey failed");     // Catch: Exception -> L8
    }

    private static TransCryptoContext initFullDecryptContext(Context r100, byte[] r101, byte[] r102, boolean r103, byte[] r104, SensitiveData r110) {
        int r105 = (r101[0] & UByte.MAX_VALUE) + 1;
        String r106 = new String(Arrays.copyOfRange(r101, 1, r105), StandardCharsets.UTF_8);
        int r107 = r101[r105] & UByte.MAX_VALUE;
        int r108 = r105 + 1;
        String r109 = new String(Arrays.copyOfRange(r101, r108, r107 + r108), StandardCharsets.UTF_8);
        LogUtils.d(TAG, "did:" + r106 + " appid:" + r109);
        TransCryptoContext r111 = new TransCryptoContext(r100, r106, r109);
    L8:
        e = move-exception;
        throw new CloudTransException("initFullDecryptContext failed, error:" + e.getMessage());
    L4:
        if (r111.initFullDecryptKey(r102, r104, r103, r110) == false) goto L7;
        return r111;
    L7:
        throw new CloudTransException("initFullDecryptContext failed, initFullDecryptKey failed");     // Catch: Exception -> L8
    }

    public static void streamDecrypt(TransCryptoContext r110, InputStream r111, OutputStream r112) {
        byte[] r100 = new byte[4];     // Catch: Exception -> L22
        if (r111.read(r100) == 4) goto L6;
        TransUtils.printErrorInfo(TAG, "Input stream is empty!");     // Catch: Exception -> L22
    L6:
        int r101 = CryptoUtils.byteArrayToInt(r100);     // Catch: Exception -> L22
        if (r101 == 591755408) goto L9;
        TransUtils.printErrorInfo(TAG, "Cannot parse input page cipher data! magic:" + r101);     // Catch: Exception -> L22
    L9:
        int r102 = r111.read();     // Catch: Exception -> L22
        LogUtils.i(TAG, "Cipher Version:" + r102);     // Catch: Exception -> L22
        if (r102 == 1) goto L13;
        TransUtils.printErrorInfo(TAG, "Input page cipher data version is wrong! version:" + r102);     // Catch: Exception -> L22
    L13:
        if (r111.read(new byte[16]) == 16) goto L15;
        TransUtils.printErrorInfo(TAG, "Input stream read keyCipherHash failed!");     // Catch: Exception -> L22
    L15:
        byte[] r103 = new byte[12];     // Catch: Exception -> L22
        if (r111.read(r103) == 12) goto L18;
        TransUtils.printErrorInfo(TAG, "Input stream read ivBytes failed!");     // Catch: Exception -> L22
    L18:
        SecretKey r104 = r110.getEncryptKey();     // Catch: Exception -> L22
        LogUtils.d(TAG, "data key len:" + r104.getEncoded().length);     // Catch: Exception -> L22
        int r113 = ChaCha20.decryptStreamDynamic(r104, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r103, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r111, r112);     // Catch: Exception -> L22
        if (r113 == 0) goto L27;
        TransUtils.printErrorInfo(TAG, "Page ChaCha20 decryptStreamDynamic failed! error:" + r113);     // Catch: Exception -> L22
        return;
    L27:
        return;
    L22:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data page decrypt failed! exception:" + e.getMessage());
    }

    public static byte[] streamDecryptBytes(TransCryptoContext r100, byte[] r101) {
        byte[] r102 = ChaCha20.decryptStreamBytes(r100.getEncryptKey(), CryptoConst.ALGORITHM_CHACHA20, r100.getDataIv(), r101);
        if (r102 != null) goto L5;
        TransUtils.printErrorInfo(TAG, "streamDecryptBytes failed! cipherData len:" + r101.length);
    L5:
        return r102;
    }

    public static TransCryptoContext streamDecryptFirstBytes(Context r110, SensitiveData r111, byte[] r112) {
        int r100 = TransUtils.bytesToInt(Arrays.copyOfRange(r112, 0, 4));
        if (r100 == 305441707) goto L5;
        TransUtils.printErrorInfo(TAG, "Cannot parse input stream cipher data! magic:" + r100);
    L5:
        int r101 = TransUtils.bytesToInt(Arrays.copyOfRange(r112, 4, 8));
        if (r101 == 1) goto L8;
        TransUtils.printErrorInfo(TAG, "Input stream cipher data version is wrong! version:" + r101);
    L8:
        byte[] r102 = Arrays.copyOfRange(r112, 8, r111.getExtraInfo().length + 8);
        if (Arrays.equals(r111.getExtraInfo(), r102) == true) goto L11;
        TransUtils.printErrorInfo(TAG, "dId and appId is error, " + CryptoUtils.byteArrayToHexString(r102));
    L11:
        int r103 = 8 + r111.getExtraInfo().length;
        int r104 = r103 + 32;
        byte[] r105 = Arrays.copyOfRange(r112, r103, r104);
        int r106 = r104 + 76;
        TransCryptoContext r113 = initFullDecryptContext(r110, r102, Arrays.copyOfRange(r112, r104, r106), false, r105, r111);
        LogUtils.d(TAG, "data key len:" + r113.getEncryptKey().getEncoded().length);
        byte[] r114 = Arrays.copyOfRange(r112, r106, r106 + 12);
        LogUtils.d(TAG, "ivBytes:" + CryptoUtils.byteArrayToHexString(r114));
        r113.setDataIv(r114);
        return r113;
    }

    public static void streamEncrypt(TransCryptoContext r100, InputStream r110, OutputStream r111) {
        SecretKey r101 = r100.getEncryptKey();
        LogUtils.d(TAG, "data key len:" + r101.getEncoded().length);
        byte[] r102 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L7
        r111.write(CryptoUtils.intToBytes(CryptoConst.TRANS_FILE_PAGE_CIPHER_MAGIC_NUM));     // Catch: Exception -> L7
        r111.write(1);     // Catch: Exception -> L7
        r111.write(r100.getKeyCipherHash());     // Catch: Exception -> L7
        r111.write(r102);     // Catch: Exception -> L7
        int r103 = ChaCha20.encryptStreamDynamic(r101, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r102, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r110, r111);     // Catch: Exception -> L7
        if (r103 == 0) goto L12;
        TransUtils.printErrorInfo(TAG, "Page ChaCha20 encryptStreamDynamic failed! error:" + r103);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data page encrypt failed! exception:" + e.getMessage());
    }
}
