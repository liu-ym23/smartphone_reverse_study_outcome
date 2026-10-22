package com.facebook.imagepipeline.cache;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public class ImageDiskEncryptUtils {
    private static final String CIPHER_ALGORITHM = "AES/GCM/NoPadding";
    private static final String KEY_ALGORITHM = "AES";
    private static String key = "79e93ec548d39875969ea47be01345cc794f55626fd116f9b6cf4e5c77d313e4";
    private static byte[] nonce;

    public ImageDiskEncryptUtils() {
    }

    static {
        nonce = new byte[]{1, 2, 3, 2, 1, 8, 1, 2, 4, 3, 1, 2};
    }

    public static byte[] decryptBytes(InputStream r100) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        byte[] r101 = readFromRawInput(r100);
        byte[] r102 = toByte(key);
        byte[] r103 = Arrays.copyOfRange(r101, 0, r101.length);
        IvParameterSpec r104 = new IvParameterSpec(nonce);
        SecretKeySpec r105 = new SecretKeySpec(r102, "AES");
        Cipher r106 = Cipher.getInstance("AES/GCM/NoPadding");
        r106.init(2, r105, r104);
        return r106.doFinal(r103);
    }

    public static byte[] encryptByte(InputStream r100) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        byte[] r101 = readFromRawInput(r100);
        byte[] r102 = toByte(key);
        byte[] r103 = Arrays.copyOfRange(r101, 0, r101.length);
        IvParameterSpec r104 = new IvParameterSpec(nonce);
        SecretKeySpec r105 = new SecretKeySpec(r102, "AES");
        Cipher r106 = Cipher.getInstance("AES/GCM/NoPadding");
        r106.init(1, r105, r104);
        return r106.doFinal(r103);
    }

    private static byte[] readFromRawInput(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[1024];
    L3:
        int r103 = r100.read(r102);
        if (r103 <= (-1)) goto L6;
        r101.write(r102, 0, r103);
        goto L3
    L6:
        r101.flush();
        r101.close();
        return r101.toByteArray();
    }

    private static byte[] toByte(String r100) {
        int r101 = r100.length() / 2;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        int r104 = r103 * 2;
        r102[r103] = Integer.valueOf(r100.substring(r104, r104 + 2), 16).byteValue();
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }
}
