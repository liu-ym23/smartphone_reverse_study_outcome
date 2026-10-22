package com.facebook.net;

import cvc.c;
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
public class AESEncrypt {
    private static final String CIPHER_ALGORITHM = "AES/CFB/NoPadding";
    private static final String KEY_ALGORITHM = "AES";
    private static final int MAGIC_LENGTH = 16;
    private static final String TAG = "AESEncrypt";

    public AESEncrypt() {
    }

    public static SecretKeySpec getSecretKey(String r100) {
        return new SecretKeySpec(r100.getBytes(c.f465522j), "AES");
    }

    public static byte[] toByteArray(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[4096];
    L3:
        int r103 = r100.read(r102);
        if ((-1) == r103) goto L7;
        r101.write(r102, 0, r103);
        goto L3
    L7:
        return r101.toByteArray();
    }

    public static byte[] decrypt(byte[] r100, String r101) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        SecretKeySpec r102 = getSecretKey(r101);
        Cipher r103 = Cipher.getInstance(CIPHER_ALGORITHM);
        int r104 = r103.getBlockSize() + 16;
        IvParameterSpec r105 = new IvParameterSpec(Arrays.copyOfRange(r100, 16, r104));
        byte[] r106 = Arrays.copyOfRange(r100, r104, r100.length);
        r103.init(2, r102, r105);
        return r103.doFinal(r106);
    }
}
