package com.bytedance.crypto.utils;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes6.dex */
public class CryptoUtils {
    public static final String TAG = "CryptoUtils";

    /* JADX INFO: renamed from: com.bytedance.crypto.utils.CryptoUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class LengthInfo {
        public int lengthBytes;
        public int valueLength;

        private LengthInfo() {
        }

        public /* synthetic */ LengthInfo(AnonymousClass1 r100) {
            this();
        }
    }

    public CryptoUtils() {
    }

    public static PublicKey byteArrayToECPublicKey(byte[] r100) {
        boolean r101 = false;
        if (r100.length == 65) goto L5;
    L16:
        KeyFactory r102 = KeyFactory.getInstance(CryptoConst.ALGORITHM_EC);     // Catch: Exception -> L13
        if (r101 == false) goto L12;
        AlgorithmParameters r103 = AlgorithmParameters.getInstance(CryptoConst.ALGORITHM_EC);     // Catch: Exception -> L13
        r103.init(new ECGenParameterSpec("secp256r1"));     // Catch: Exception -> L13
        return r102.generatePublic(new ECPublicKeySpec(new ECPoint(new BigInteger(1, Arrays.copyOfRange(r100, 1, 33)), new BigInteger(1, Arrays.copyOfRange(r100, 33, 65))), (ECParameterSpec) r103.getParameterSpec(ECParameterSpec.class)));
    L12:
        return r102.generatePublic(new X509EncodedKeySpec(r100));
    L13:
        e = move-exception;
        LogUtils.e(TAG, "Bytes to EC public key failed, error:" + e.getMessage());
        return null;
    L5:
        if (r100[0] != 4) goto L16;
        r101 = true;
        goto L16
    }

    public static String byteArrayToHexString(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.append(String.format("%02x", new Object[]{Byte.valueOf(r100[r103])}));
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public static int byteArrayToInt(byte[] r100) {
        int r101 = (((r100[0] & UByte.MAX_VALUE) << 24) | ((r100[1] & UByte.MAX_VALUE) << 16)) | ((r100[2] & UByte.MAX_VALUE) << 8);
        return (r100[3] & UByte.MAX_VALUE) | r101;
    }

    public static byte[] convertPEMToUncompressedECPubKey(String r100) {
        String r101 = r100.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s+", "");
        String r102 = TAG;
        LogUtils.d(r102, "base64PublicKey: " + r101);
        ECPoint r103 = ((ECPublicKey) KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(r101)))).getW();     // Catch: Exception -> L5
        byte[] r104 = convertToFixedECPoint(r103.getAffineX().toByteArray(), 32);     // Catch: Exception -> L5
        byte[] r105 = convertToFixedECPoint(r103.getAffineY().toByteArray(), 32);     // Catch: Exception -> L5
        byte[] r106 = new byte[65];     // Catch: Exception -> L5
        r106[0] = 4;     // Catch: Exception -> L5
        LogUtils.d(r102, "x.length: " + r104.length);     // Catch: Exception -> L5
        LogUtils.d(r102, "y.length: " + r105.length);     // Catch: Exception -> L5
        System.arraycopy(r104, 0, r106, 1, r104.length);     // Catch: Exception -> L5
        System.arraycopy(r105, 0, r106, r104.length + 1, r105.length);     // Catch: Exception -> L5
        LogUtils.d(r102, "uncompressedPublicKey: " + byteArrayToHexString(r106));     // Catch: Exception -> L5
        return r106;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "convertPEMToUncompressedECPubKey failed, exception: " + e.getMessage());
        return null;
    }

    private static byte[] convertToFixedECPoint(byte[] r100, int r101) {
        if (r100.length != r101) goto L5;
        return r100;
    L5:
        byte[] r102 = new byte[r101];
        if (r100.length <= r101) goto L8;
        System.arraycopy(r100, r100.length - r101, r102, 0, r101);
    L9:
        return r102;
    L8:
        System.arraycopy(r100, 0, r102, r101 - r100.length, r100.length);
        goto L9
    }

    public static String ecdsaSign(String r100, PrivateKey r101) {
        Signature r102 = Signature.getInstance("SHA256withECDSA");
        r102.initSign(r101);
        r102.update(r100.getBytes(StandardCharsets.UTF_8));
        byte[] r103 = r102.sign();
        return Base64.getEncoder().encodeToString(r103);
    }

    public static byte[] extractPrivateKey(byte[] r100) {
        if (r100[0] != 48) goto L17;
        int r101 = 1;
        int r102 = parseLengthEx(r100, 1).lengthBytes;
    L5:
        int r103 = r102 + r101;
        if (r103 >= r100.length) goto L15;
        int r104 = r100[r103] & UByte.MAX_VALUE;
        int r105 = r103 + 1;
        LengthInfo r106 = parseLengthEx(r100, r105);
        r102 = r105 + r106.lengthBytes;
        if (r104 != 4) goto L13;
        int r107 = r106.valueLength;
        if (r107 != 32) goto L13;
        byte[] r108 = new byte[r107];
        System.arraycopy(r100, r102, r108, 0, r107);
        return r108;
    L13:
        r101 = r106.valueLength;
        goto L5
    L15:
        throw new IllegalArgumentException("未找到私钥材料");
    L17:
        throw new IllegalArgumentException("不是有效的ASN.1序列");
    }

    public static KeyPair generateECCKeyPair() {
        KeyPairGenerator r100 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC);     // Catch: Exception -> L4
        r100.initialize(256);     // Catch: Exception -> L4
        return r100.generateKeyPair();
    L4:
        e = move-exception;
        LogUtils.e(TAG, "Generate ecc keypair failed, error:" + e.getMessage());
        return null;
    }

    public static byte[] generateSecureRandom(int r100) {
        byte[] r101 = new byte[r100];
        new SecureRandom().nextBytes(r101);
        return r101;
    }

    public static SecretKey generateSymmetricKey(String r100) {
        return KeyGenerator.getInstance(r100).generateKey();
    L4:
        e = move-exception;
        LogUtils.e(TAG, "Generate symmetric key failed,algorithm:" + r100 + " error:" + e.getMessage());
        return null;
    }

    public static SecretKey generateSymmetricKey(String r100, int r101) {
        return new SecretKeySpec(generateSecureRandom(r101), r100);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "Generate symmetric key failed,algorithm:" + r100 + " keyLen:" + r101 + " error:" + e.getMessage());
        return null;
    }

    public static byte[] hexStringToByteArray(String r100) {
        if ((r100.length() % 2) == 0) goto L7;
        String r101 = TAG;
        StringBuilder r102 = new StringBuilder("Invalid hex string length:");
        r102.append(r100.length());
    L5:
        LogUtils.e(r101, r102.toString());
        return new byte[0];
    L7:
        int r103 = r100.length() / 2;
        byte[] r104 = new byte[r103];
        int r105 = 0;
    L8:
        if (r105 >= r103) goto L14;
        int r106 = r105 * 2;
        r104[r105] = (byte) CastIntegerProtector.parseInt(r100.substring(r106, r106 + 2), 16);     // Catch: Exception -> L12
        r105 = r105 + 1;
    L12:
        e = move-exception;
        r101 = TAG;
        r102 = new StringBuilder("Hex string to byte array failed, error:");
        r102.append(e.getMessage());
        goto L5
    L14:
        return r104;
    }

    public static byte[] intToBytes(int r100) {
        return new byte[]{(byte) (r100 >> 24), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 8) & 255), (byte) (r100 & 255)};
    }

    public static byte[] longToBytes(long r100) {
        byte[] r101 = new byte[8];
        int r102 = 7;
    L3:
        if (r102 < 0) goto L5;
        r101[r102] = (byte) (255 & r100);
        r100 = r100 >> 8;
        r102 = r102 - 1;
        goto L3
    L5:
        return r101;
    }

    public static byte[] messageDigest(byte[] r100, String r101) {
        LogUtils.d(TAG, "digestAlgorithm: " + r101);
        MessageDigest r102 = MessageDigest.getInstance(r101);     // Catch: Exception -> L5
        r102.update(r100);     // Catch: Exception -> L5
        return r102.digest();
    L5:
        LogUtils.e(TAG, "SHA256 failed.");
        return new byte[0];
    }

    public static byte[] parseECCPublicKey(byte[] r100) {
        if (r100[0] != 48) goto L18;
        int r101 = parseLengthEx(r100, 1).lengthBytes + 1;
        if (r100[r101] != 48) goto L16;
        int r102 = r101 + 1;
        LengthInfo r103 = parseLengthEx(r100, r102);
        int r104 = r102 + (r103.lengthBytes + r103.valueLength);
        if (r100[r104] != 3) goto L14;
        int r105 = r104 + 1;
        LengthInfo r106 = parseLengthEx(r100, r105);
        int r107 = r106.valueLength;
        int r108 = r105 + r106.lengthBytes;
        if (r100[r108] != 0) goto L12;
        r108 = r108 + 1;
        r107 = r107 - 1;
    L12:
        return Arrays.copyOfRange(r100, r108, r107 + r108);
    L14:
        throw new IllegalArgumentException("Invalid BIT STRING tag");
    L16:
        throw new IllegalArgumentException("Invalid algorithm identifier");
    L18:
        throw new IllegalArgumentException("Invalid ASN.1 SEQUENCE tag");
    }

    public static byte[] parseEccPrivateKey(byte[] r100) {
        if (r100[0] != 48) goto L19;
        int r101 = parseLengthEx(r100, 1).lengthBytes + 1;
        if (r100[r101] != 2) goto L17;
        int r102 = r101 + 1;
        LengthInfo r103 = parseLengthEx(r100, r102);
        int r104 = r102 + (r103.lengthBytes + r103.valueLength);
        if (r100[r104] != 48) goto L15;
        int r105 = r104 + 1;
        LengthInfo r106 = parseLengthEx(r100, r105);
        int r107 = r105 + (r106.lengthBytes + r106.valueLength);
        if (r100[r107] != 4) goto L13;
        int r108 = r107 + 1;
        LengthInfo r109 = parseLengthEx(r100, r108);
        int r110 = r108 + r109.lengthBytes;
        return extractPrivateKey(Arrays.copyOfRange(r100, r110, r109.valueLength + r110));
    L13:
        throw new IllegalArgumentException("Invalid OCTET STRING tag");
    L15:
        throw new IllegalArgumentException("Invalid algorithm identifier");
    L17:
        throw new IllegalArgumentException("Invalid version tag");
    L19:
        throw new IllegalArgumentException("Invalid ASN.1 SEQUENCE tag");
    }

    private static LengthInfo parseLengthEx(byte[] r100, int r101) {
        int r102 = r100[r101] & 255;
        LengthInfo r103 = new LengthInfo(null);
        if ((r102 & 128) != 0) goto L5;
        r103.valueLength = r102;
        r103.lengthBytes = 1;
    L8:
        return r103;
    L5:
        int r104 = r102 & 127;
        r103.lengthBytes = r104 + 1;
        int r105 = 0;
        r103.valueLength = 0;
    L6:
        if (r105 >= r104) goto L8;
        r103.valueLength = (r103.valueLength << 8) | (r100[(r101 + 1) + r105] & UByte.MAX_VALUE);
        r105 = r105 + 1;
        goto L6
    }

    public static boolean verifyECDSASignature(PublicKey r100, byte[] r101, byte[] r102, String r103) {
        if ((r100 instanceof ECPublicKey) == true) goto L15;
        LogUtils.e(TAG, "Provided publicKey is not an EC public key");
        return false;
    L15:
        Signature r104 = Signature.getInstance(r103);     // Catch: SignatureException -> L8 Throwable -> L10 NoSuchAlgorithmException -> L12
        r104.initVerify(r100);     // Catch: SignatureException -> L8 Throwable -> L10 NoSuchAlgorithmException -> L12
        r104.update(r101);     // Catch: SignatureException -> L8 Throwable -> L10 NoSuchAlgorithmException -> L12
        return r104.verify(r102);
    L10:
        e = move-exception;
        LogUtils.e(TAG, "verifyECDSASignature failed, exception: " + e.getMessage());
        return false;
    }
}
