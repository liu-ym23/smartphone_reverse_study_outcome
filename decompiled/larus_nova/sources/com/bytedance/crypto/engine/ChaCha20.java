package com.bytedance.crypto.engine;

import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class ChaCha20 {
    public static final String TAG = "ChaCha20";

    public ChaCha20() {
    }

    public static int decryptStream(SecretKey r100, byte[] r101, InputStream r102, OutputStream r103) {
        return decryptStreamFull(r100, CryptoConst.ALGORITHM_CHACHA20, r101, r102, r103);
    }

    private static int decryptStreamBlock(SecretKey r100, String r101, byte[] r102, int r103, int r110, InputStream r111, OutputStream r112) {
        if (r103 <= 1048576) goto L7;
        String r104 = TAG;
        StringBuilder r105 = new StringBuilder("blockSize: ");
        r105.append(r103);
        r105.append(" exceeds the maximum:1048576");
    L5:
        LogUtils.e(r104, r105.toString());
        return -2;
    L7:
        if (r110 > 0) goto L9;
        r104 = TAG;
        r105 = new StringBuilder("input data length: ");
        r105.append(r110);
        goto L5
    L9:
        int r106 = r103 + 16;
        byte[] r107 = new byte[r106];     // Catch: Exception -> L17
        byte[] r108 = new byte[r103];     // Catch: Exception -> L17
        Cipher r109 = Cipher.getInstance(r101);     // Catch: Exception -> L17
        r109.init(2, r100, new IvParameterSpec(r102));     // Catch: Exception -> L17
    L12:
        if (r110 <= 0) goto L24;
        int r113 = r111.read(r107, 0, Math.min(r106, r110));     // Catch: Exception -> L17
        if (r113 <= 0) goto L25;
        int r114 = r109.doFinal(r107, 0, r113, r108);     // Catch: Exception -> L17
        LogUtils.d(TAG, "ChaCha20 decrypt stream, decryptedChunkLen:" + r114);     // Catch: Exception -> L17
        r112.write(r108, 0, r114);     // Catch: Exception -> L17
        r110 = r110 - r113;
        goto L12
    L25:
        return 0;
    L24:
        return 0;
    L17:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    private static int decryptStreamBlockDynamic(SecretKey r100, String r101, byte[] r102, byte[] r103, int r110, InputStream r111, OutputStream r112) {
        if (r110 <= 1048576) goto L6;
        LogUtils.e(TAG, "blockSize: " + r110 + " exceeds the maximum:1048576");
        return -2;
    L6:
        byte[] r104 = new byte[4];
        String r105 = TAG;     // Catch: Exception -> L28
        LogUtils.d(r105, "key:" + CryptoUtils.byteArrayToHexString(r100.getEncoded()));     // Catch: Exception -> L28
        LogUtils.d(r105, "iv:" + CryptoUtils.byteArrayToHexString(r102));     // Catch: Exception -> L28
        LogUtils.d(r105, "aad:".concat(new String(r103, StandardCharsets.UTF_8)));     // Catch: Exception -> L28
    L9:
        if (r111.read(r104) == (-1)) goto L26;
        int r106 = CryptoUtils.byteArrayToInt(r104);     // Catch: Exception -> L28
        String r107 = TAG;     // Catch: Exception -> L28
        LogUtils.d(r107, "readLen:" + r106);     // Catch: Exception -> L28
        if (r106 <= 0) goto L24;
        if (r106 > (r110 + 16)) goto L24;
        byte[] r108 = new byte[r106];     // Catch: Exception -> L28
        if (r111.read(r108) == (-1)) goto L23;
        Cipher r109 = Cipher.getInstance(r101);     // Catch: Exception -> L28
        r109.init(2, r100, new IvParameterSpec(r102));     // Catch: Exception -> L28
        if (r103 == null) goto L22;
        if (r103.length <= 0) goto L22;
        r109.updateAAD(r103);     // Catch: Exception -> L28
    L22:
        r112.write(r109.doFinal(r108));     // Catch: Exception -> L28
        goto L9
    L23:
        return -8;
    L24:
        LogUtils.e(r107, "read buffer len error, len:" + r106);     // Catch: Exception -> L28
        return -8;
    L26:
        r112.flush();     // Catch: Exception -> L28
        return 0;
    L28:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    private static int decryptStreamBlockLong(SecretKey r110, String r111, byte[] r112, int r113, long r210, InputStream r211, OutputStream r212) {
        long r100 = r210;
        if (r113 <= 1048576) goto L7;
        LogUtils.e(TAG, "blockSize: " + r113 + " exceeds the maximum:1048576");
        return -2;
    L7:
        if (r100 > 0) goto L10;
        LogUtils.e(TAG, "input data length: " + r100);
        return -2;
    L10:
        int r101 = r113 + 16;
        int r102 = -4;
        byte[] r103 = new byte[r101];     // Catch: Exception -> L22
        byte[] r104 = new byte[r113];     // Catch: Exception -> L22
        Cipher r105 = Cipher.getInstance(r111);     // Catch: Exception -> L22
        r105.init(2, r110, new IvParameterSpec(r112));     // Catch: Exception -> L22
    L13:
        if (r100 <= 0) goto L25;
        int r114 = r211.read(r103, 0, (int) Math.min(r101, r100));     // Catch: Exception -> L22
        if (r114 <= 0) goto L25;
        int r115 = r105.doFinal(r103, 0, r114, r104);     // Catch: Exception -> L22
        LogUtils.d(TAG, "ChaCha20 decrypt stream, decryptedChunkLen:" + r115);     // Catch: Exception -> L22
        r212.write(r104, 0, r115);     // Catch: Exception -> L22
        r100 = r100 - ((long) r114);
    L25:
        LogUtils.i(TAG, "ChaCha20 decrypt stream success, remaining: " + r100);     // Catch: Exception -> L20
        return 0;
    L20:
        e = e;
        r102 = 0;
    L23:
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return r102;
    L22:
        e = e;
        goto L23
    }

    public static byte[] decryptStreamBytes(SecretKey r100, String r101, byte[] r102, byte[] r110) {
        String r103 = TAG;     // Catch: Exception -> L9
        LogUtils.d(r103, "dataCipher len:" + r110.length);     // Catch: Exception -> L9
        LogUtils.d(r103, "dataCipher:" + CryptoUtils.byteArrayToHexString(r110));     // Catch: Exception -> L9
        LogUtils.d(r103, "ivBytes:" + CryptoUtils.byteArrayToHexString(r102));     // Catch: Exception -> L9
        Cipher r104 = Cipher.getInstance(r101);     // Catch: Exception -> L9
        r104.init(2, r100, new IvParameterSpec(r102));     // Catch: Exception -> L9
        int r105 = CryptoUtils.byteArrayToInt(Arrays.copyOfRange(r110, 0, 4));     // Catch: Exception -> L9
        if (r105 == (r110.length - 4)) goto L8;
        LogUtils.e(r103, "ChaCha20 decrypt init failed, dataCipher len:" + r110.length + " dataLen:" + r105);     // Catch: Exception -> L9
        return null;
    L8:
        return r104.doFinal(Arrays.copyOfRange(r110, 4, r110.length));
    L9:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt stream bytes failed, error:" + e.getMessage());
        return null;
    }

    public static int decryptStreamDynamic(SecretKey r100, String r101, byte[] r102, byte[] r103, int r104, InputStream r105, OutputStream r106) {
        if (CryptoConst.ALGORITHM_CHACHA20_POLY1305.equals(r101) == false) goto L7;
        return decryptStreamBlockDynamic(r100, r101, r102, r103, r104, r105, r106);
    L7:
        return decryptStreamFull(r100, r101, r102, r105, r106);
    }

    private static int decryptStreamFull(SecretKey r100, String r101, byte[] r102, InputStream r103, OutputStream r104) {
        int r105 = -4;
        LogUtils.i(TAG, "inputStream len:" + r103.available());     // Catch: Exception -> L25
        Cipher r106 = Cipher.getInstance(r101);     // Catch: Exception -> L25
        r106.init(2, r100, new IvParameterSpec(r102));     // Catch: Exception -> L25
        CipherOutputStream r107 = new CipherOutputStream(r104, r106);     // Catch: Exception -> L22
        byte[] r108 = new byte[4096];     // Catch: Throwable -> L16
        boolean r109 = false;
    L7:
        int r110 = r103.read(r108);     // Catch: Throwable -> L16
        if (r110 <= 0) goto L10;
        r107.write(r108, 0, r110);     // Catch: Throwable -> L16
        r109 = true;
        goto L7
    L10:
        if (r109 == false) goto L34;
        r107.flush();     // Catch: Throwable -> L16
    L34:
        r107.close();     // Catch: Exception -> L14
        return 0;
    L14:
        e = e;
        r105 = 0;
    L23:
        LogUtils.e(TAG, "ChaCha20 decrypt stream failed, error:" + e.getMessage());
        return r105;
    L16:
        th = move-exception;
        r107.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Exception -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L22
    L22:
        e = e;
    L25:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 decrypt init failed, error:" + e.getMessage());
        return -4;
    }

    public static int decryptStreamWithPoly1305(SecretKey r100, byte[] r101, int r102, int r110, InputStream r111, OutputStream r112) {
        return decryptStreamBlock(r100, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r101, r102, r110, r111, r112);
    }

    public static int decryptStreamWithPoly1305(SecretKey r100, byte[] r101, int r110, long r111, InputStream r112, OutputStream r113) {
        return decryptStreamBlockLong(r100, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r101, r110, r111, r112, r113);
    }

    public static int encryptStream(SecretKey r100, byte[] r101, InputStream r102, OutputStream r103) {
        return encryptStreamFull(r100, CryptoConst.ALGORITHM_CHACHA20, r101, r102, r103);
    }

    private static int encryptStreamBlock(SecretKey r100, String r101, byte[] r110, int r111, int r112, InputStream r113, OutputStream r114) {
        if (r111 <= 1048576) goto L7;
        String r102 = TAG;
        StringBuilder r103 = new StringBuilder("blockSize: ");
        r103.append(r111);
        r103.append(" exceeds the maximum:1048576");
    L5:
        LogUtils.e(r102, r103.toString());
        return -2;
    L7:
        if (r112 > 0) goto L19;
        r102 = TAG;
        r103 = new StringBuilder("input data length: ");
        r103.append(r112);
        goto L5
    L19:
        byte[] r104 = new byte[r111];     // Catch: Exception -> L16
        byte[] r105 = new byte[r111 + 16];     // Catch: Exception -> L16
    L11:
        if (r112 <= 0) goto L23;
        int r106 = r113.read(r104, 0, Math.min(r111, r112));     // Catch: Exception -> L16
        if (r106 <= 0) goto L24;
        Cipher r107 = Cipher.getInstance(r101);     // Catch: Exception -> L16
        r107.init(1, r100, new IvParameterSpec(r110));     // Catch: Exception -> L16
        int r108 = r107.doFinal(r104, 0, r106, r105);     // Catch: Exception -> L16
        LogUtils.d(TAG, "ChaCha20 encrypt stream, encryptedChunkLen:" + r108);     // Catch: Exception -> L16
        r114.write(r105, 0, r108);     // Catch: Exception -> L16
        r112 = r112 - r106;
        goto L11
    L24:
        return 0;
    L23:
        return 0;
    L16:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    private static int encryptStreamBlockDynamic(SecretKey r100, String r101, byte[] r102, byte[] r103, int r110, InputStream r111, OutputStream r112) {
        if (r110 <= 1048576) goto L23;
        LogUtils.e(TAG, "blockSize: " + r110 + " exceeds the maximum:1048576");
        return -2;
    L23:
        byte[] r104 = new byte[r110];     // Catch: Exception -> L20
    L7:
        int r105 = r111.read(r104);     // Catch: Exception -> L20
        if (r105 == (-1)) goto L9;
        Cipher r106 = Cipher.getInstance(r101);     // Catch: Exception -> L20
        r106.init(1, r100, new IvParameterSpec(r102));     // Catch: Exception -> L20
        if (r103 != null) goto L14;
    L16:
        if (r105 == r110) goto L17;
        byte[] r107 = r106.doFinal(r104, 0, r105);     // Catch: Exception -> L20
        r112.write(CryptoUtils.intToBytes(r107.length));     // Catch: Exception -> L20
        r112.write(r107);     // Catch: Exception -> L20
        goto L7
    L17:
        byte[] r108 = r106.doFinal(r104);     // Catch: Exception -> L20
        r112.write(CryptoUtils.intToBytes(r108.length));     // Catch: Exception -> L20
        r112.write(r108);     // Catch: Exception -> L20
        goto L7
    L14:
        if (r103.length <= 0) goto L16;
        r106.updateAAD(r103);     // Catch: Exception -> L20
        goto L16
    L9:
        r112.flush();     // Catch: Exception -> L20
        return 0;
    L20:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt stream dynamic failed, error:" + e.getMessage());
        return -4;
    }

    private static int encryptStreamBlockLong(SecretKey r110, String r111, byte[] r112, int r113, long r210, InputStream r211, OutputStream r212) {
        long r100 = r210;
        if (r113 <= 1048576) goto L7;
        LogUtils.e(TAG, "blockSize: " + r113 + " exceeds the maximum:1048576");
        return -2;
    L7:
        if (r100 > 0) goto L20;
        LogUtils.e(TAG, "input data length: " + r100);
        return -2;
    L20:
        byte[] r101 = new byte[r113];     // Catch: Exception -> L17
        byte[] r102 = new byte[r113 + 16];     // Catch: Exception -> L17
    L12:
        if (r100 <= 0) goto L24;
        int r103 = r211.read(r101, 0, (int) Math.min(r113, r100));     // Catch: Exception -> L17
        if (r103 <= 0) goto L25;
        Cipher r114 = Cipher.getInstance(r111);     // Catch: Exception -> L17
        r114.init(1, r110, new IvParameterSpec(r112));     // Catch: Exception -> L17
        int r115 = r114.doFinal(r101, 0, r103, r102);     // Catch: Exception -> L17
        LogUtils.d(TAG, "ChaCha20 encrypt stream, encryptedChunkLen:" + r115);     // Catch: Exception -> L17
        r212.write(r102, 0, r115);     // Catch: Exception -> L17
        r100 = r100 - ((long) r103);
        goto L12
    L25:
        return 0;
    L24:
        return 0;
    L17:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt stream failed, error:" + e.getMessage());
        return -4;
    }

    public static int encryptStreamDynamic(SecretKey r100, String r101, byte[] r102, byte[] r103, int r104, InputStream r105, OutputStream r106) {
        if (CryptoConst.ALGORITHM_CHACHA20_POLY1305.equals(r101) == false) goto L7;
        return encryptStreamBlockDynamic(r100, r101, r102, r103, r104, r105, r106);
    L7:
        return encryptStreamFull(r100, r101, r102, r105, r106);
    }

    private static int encryptStreamFull(SecretKey r100, String r101, byte[] r102, InputStream r103, OutputStream r104) {
        int r105 = -4;
        LogUtils.d(TAG, "inputStream len:" + r103.available());     // Catch: Exception -> L25
        Cipher r106 = Cipher.getInstance(r101);     // Catch: Exception -> L25
        r106.init(1, r100, new IvParameterSpec(r102));     // Catch: Exception -> L25
        CipherOutputStream r107 = new CipherOutputStream(r104, r106);     // Catch: Exception -> L22
        byte[] r108 = new byte[4096];     // Catch: Throwable -> L16
        boolean r109 = false;
    L7:
        int r110 = r103.read(r108);     // Catch: Throwable -> L16
        if (r110 <= 0) goto L10;
        r107.write(r108, 0, r110);     // Catch: Throwable -> L16
        r109 = true;
        goto L7
    L10:
        if (r109 == false) goto L34;
        r107.flush();     // Catch: Throwable -> L16
    L34:
        r107.close();     // Catch: Exception -> L14
        return 0;
    L14:
        e = e;
        r105 = 0;
    L23:
        LogUtils.e(TAG, "ChaCha20 encrypt stream failed, error:" + e.getMessage());
        return r105;
    L16:
        th = move-exception;
        r107.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Exception -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L22
    L22:
        e = e;
    L25:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 encrypt init failed, error:" + e.getMessage());
        return -4;
    }

    public static int encryptStreamWithPoly1305(SecretKey r100, byte[] r101, int r102, int r110, InputStream r111, OutputStream r112) {
        return encryptStreamBlock(r100, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r101, r102, r110, r111, r112);
    }

    public static int encryptStreamWithPoly1305(SecretKey r100, byte[] r101, int r110, long r111, InputStream r112, OutputStream r113) {
        return encryptStreamBlockLong(r100, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r101, r110, r111, r112, r113);
    }

    public static byte[] xcryptBytes(int r100, String r101, byte[] r102, byte[] r103, byte[] r104) {
        byte[] r105 = new byte[0];
        SecretKeySpec r106 = new SecretKeySpec(r102, r101);     // Catch: Exception -> L5
        Cipher r107 = Cipher.getInstance(r101);     // Catch: Exception -> L5
        r107.init(r100, r106, new IvParameterSpec(r103));     // Catch: Exception -> L5
        return r107.doFinal(r104);
    L5:
        e = move-exception;
        LogUtils.e(TAG, "ChaCha20 xcrypt bytes failed, mode:" + r100 + " error:" + e.getMessage());
        return r105;
    }
}
