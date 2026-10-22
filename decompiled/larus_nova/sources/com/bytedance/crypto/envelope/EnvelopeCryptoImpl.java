package com.bytedance.crypto.envelope;

import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.engine.ECDHHelper;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.PublicKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes15.dex */
public class EnvelopeCryptoImpl {
    private static final int ENVELOPE_MAGIC = -57307;
    private static final int ENVELOPE_VERSION = 1;
    private static final int FILE_MAGIC = -57306;
    private static final int FILE_VERSION = 1;
    private static final String TAG = "EnvelopeCryptoImpl";
    private static volatile EnvelopeCryptoImpl instance;

    private EnvelopeCryptoImpl() {
    }

    private byte[] buildDEKEnvelope(byte[] r100, byte[] r101, byte[] r110) {
        StringBuilder r102 = new StringBuilder("buildDEKEnvelope enter, bizPubkeyLen: ");
        r102.append(r100.length);
        r102.append(", aadLen: ");
        if (r110 != null) goto L5;
        int r103 = 0;
    L6:
        r102.append(r103);
        LogUtils.i(TAG, r102.toString());
        KeyPair r104 = CryptoUtils.generateECCKeyPair();     // Catch: Exception -> L31
        if (r104 != null) goto L11;
        LogUtils.e(TAG, "Generate temp ECC keypair failed");     // Catch: Exception -> L31
        return null;
    L11:
        byte[] r105 = CryptoUtils.parseECCPublicKey(r104.getPublic().getEncoded());     // Catch: Exception -> L31
        PublicKey r106 = CryptoUtils.byteArrayToECPublicKey(r100);     // Catch: Exception -> L31
        if (r106 != null) goto L15;
        LogUtils.e(TAG, "Parse biz public key failed");     // Catch: Exception -> L31
        return null;
    L15:
        byte[] r107 = ECDHHelper.generateSharedSecret(r104.getPrivate(), r106);     // Catch: Exception -> L31
        if (r107 != null) goto L18;
    L29:
        LogUtils.e(TAG, "ECDH key agreement failed");     // Catch: Exception -> L31
        return null;
    L18:
        if (r107.length == 0) goto L29;
        LogUtils.d(TAG, "sharedKey length: " + r107.length);     // Catch: Exception -> L31
        byte[] r108 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L31
        byte[] r109 = AES.gcmXcrypt(1, r107, r110, r108, r101);     // Catch: Exception -> L31
        if (r109 != null) goto L23;
    L27:
        LogUtils.e(TAG, "AES-GCM encrypt DEK failed");     // Catch: Exception -> L31
        return null;
    L23:
        if (r109.length == 0) goto L27;
        ByteArrayOutputStream r111 = new ByteArrayOutputStream();     // Catch: Exception -> L31
        DataOutputStream r112 = new DataOutputStream(r111);     // Catch: Exception -> L31
        r112.writeInt(ENVELOPE_MAGIC);     // Catch: Exception -> L31
        r112.writeInt(1);     // Catch: Exception -> L31
        r112.writeInt(r105.length);     // Catch: Exception -> L31
        r112.write(r105);     // Catch: Exception -> L31
        r112.writeInt(r108.length);     // Catch: Exception -> L31
        r112.write(r108);     // Catch: Exception -> L31
        r112.writeLong(r109.length);     // Catch: Exception -> L31
        r112.write(r109);     // Catch: Exception -> L31
        r112.flush();     // Catch: Exception -> L31
        byte[] r113 = r111.toByteArray();     // Catch: Exception -> L31
        LogUtils.i(TAG, "buildDEKEnvelope success, envelopeLen: " + r113.length);     // Catch: Exception -> L31
        return r113;
    L31:
        e = move-exception;
        LogUtils.e(TAG, "Build DEK envelope failed, error: " + e.getMessage());
        return null;
    L5:
        r103 = r110.length;
        goto L6
    }

    public static EnvelopeCryptoImpl getInstance() {
        if (instance != null) goto L15;
        monitor-enter(EnvelopeCryptoImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new EnvelopeCryptoImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(EnvelopeCryptoImpl.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public int decrypt(byte[] r110, InputStream r111, OutputStream r210) {
        StringBuilder r100 = new StringBuilder("decrypt enter, dekLen: ");
        if (r110 != null) goto L5;
        int r112 = 0;
    L6:
        r100.append(r112);
        LogUtils.i(TAG, r100.toString());
        if (r110 != null) goto L9;
    L37:
        LogUtils.e(TAG, "Invalid input params");
        return -2;
    L9:
        if (r110.length != 32) goto L37;
        if (r111 == null) goto L37;
        if (r210 == null) goto L37;
        DataInputStream r101 = new DataInputStream(r111);     // Catch: IOException -> L34
        int r113 = r101.readInt();     // Catch: IOException -> L34
        if (r113 == FILE_MAGIC) goto L17;
        LogUtils.e(TAG, "File magic mismatch: 0x" + Integer.toHexString(r113));     // Catch: IOException -> L34
        return -10;
    L17:
        int r102 = r101.readInt();     // Catch: IOException -> L34
        if (r102 == 1) goto L21;
        LogUtils.e(TAG, "Unsupported file version: " + r102);     // Catch: IOException -> L34
        return -8;
    L21:
        int r103 = r101.readInt();     // Catch: IOException -> L34
        if (r103 > 0) goto L25;
        LogUtils.e(TAG, "Invalid DEK envelope length: " + r103);     // Catch: IOException -> L34
        return -8;
    L25:
        int r104 = r101.skipBytes(r103);     // Catch: IOException -> L34
        if (r104 == r103) goto L29;
        LogUtils.e(TAG, "Skip DEK envelope failed, expected: " + r103 + ", actual: " + r104);     // Catch: IOException -> L34
        return -8;
    L29:
        byte[] r105 = new byte[12];     // Catch: IOException -> L34
        r101.readFully(r105);     // Catch: IOException -> L34
        long r114 = r101.readLong();     // Catch: IOException -> L34
        long r106 = 4096;
        long r115 = ((r114 + r106) - 1) / r106;     // Catch: IOException -> L34
        long r107 = (16 * r115) + r114;     // Catch: IOException -> L34
        LogUtils.i(TAG, "decrypt stream, dataLen: " + r114 + ", cipherLen: " + r107 + ", numBlocks: " + r115);     // Catch: IOException -> L34
        int r108 = ChaCha20.decryptStreamWithPoly1305(new SecretKeySpec(r110, CryptoConst.ALGORITHM_CHACHA20_POLY1305), r105, 4096, r107, r111, r210);     // Catch: IOException -> L34
        if (r108 == 0) goto L32;
        LogUtils.e(TAG, "Decrypt stream failed, ret: " + r108);     // Catch: IOException -> L34
    L33:
        return r108;
    L32:
        LogUtils.i(TAG, "decrypt success, dataLen: " + r114);     // Catch: IOException -> L34
    L34:
        e = move-exception;
        LogUtils.e(TAG, "Decrypt failed, error: " + e.getMessage());
        return -4;
    L5:
        r112 = r110.length;
        goto L6
    }

    public int encrypt(byte[] r110, byte[] r111, long r112, InputStream r210, OutputStream r211) {
        StringBuilder r100 = new StringBuilder("encrypt enter, bizPubkeyLen: ");
        if (r110 != null) goto L5;
        int r101 = 0;
    L6:
        r100.append(r101);
        r100.append(", aadLen: ");
        if (r111 != null) goto L9;
        int r102 = 0;
    L10:
        r100.append(r102);
        r100.append(", dataLen: ");
        r100.append(r112);
        LogUtils.i(TAG, r100.toString());
        if (r110 != null) goto L13;
    L36:
        LogUtils.e(TAG, "Invalid input params");
        return -2;
    L13:
        if (r110.length == 0) goto L36;
        if (r210 == null) goto L36;
        if (r211 == null) goto L36;
        byte[] r103 = CryptoUtils.generateSecureRandom(32);     // Catch: Exception -> L32
        byte[] r113 = buildDEKEnvelope(r110, r103, r111);     // Catch: Exception -> L30
        if (r113 != null) goto L24;
        LogUtils.e(TAG, "Build DEK envelope failed");     // Catch: Exception -> L30
        return -4;
    L24:
        byte[] r104 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L30
        DataOutputStream r105 = new DataOutputStream(r211);     // Catch: Exception -> L30
        r105.writeInt(FILE_MAGIC);     // Catch: Exception -> L30
        r105.writeInt(1);     // Catch: Exception -> L30
        r105.writeInt(r113.length);     // Catch: Exception -> L30
        r105.write(r113);     // Catch: Exception -> L30
        r105.write(r104);     // Catch: Exception -> L30
        r105.writeLong(r112);     // Catch: Exception -> L30
        int r106 = ChaCha20.encryptStreamWithPoly1305(new SecretKeySpec(r103, CryptoConst.ALGORITHM_CHACHA20_POLY1305), r104, 4096, r112, r210, r211);     // Catch: Exception -> L30
        if (r106 == 0) goto L28;
        LogUtils.e(TAG, "Encrypt data stream failed, ret: " + r106);     // Catch: Exception -> L30
        return r106;
    L28:
        LogUtils.i(TAG, "encrypt success, dataLen: " + r112 + ", dekEnvelopeLen: " + r113.length);     // Catch: Exception -> L30
        return 0;
    L30:
        e = e;
    L34:
        LogUtils.e(TAG, "Encrypt failed, error: " + e.getMessage());
        return -4;
    L32:
        e = e;
        goto L34
    L9:
        r102 = r111.length;
        goto L10
    L5:
        r101 = r110.length;
        goto L6
    }

    public byte[] extractDEKCipher(InputStream r100) {
        LogUtils.i(TAG, "extractDEKCipher enter");
        if (r100 != null) goto L23;
        String r101 = "Invalid input params";
    L5:
        LogUtils.e(TAG, r101);
        return null;
    L23:
        DataInputStream r102 = new DataInputStream(r100);     // Catch: IOException -> L21
        int r103 = r102.readInt();     // Catch: IOException -> L21
        if (r103 == FILE_MAGIC) goto L11;
        LogUtils.e(TAG, "File magic mismatch: 0x" + Integer.toHexString(r103));     // Catch: IOException -> L21
        return null;
    L11:
        int r104 = r102.readInt();     // Catch: IOException -> L21
        if (r104 == 1) goto L15;
        LogUtils.e(TAG, "Unsupported file version: " + r104);     // Catch: IOException -> L21
        return null;
    L15:
        int r105 = r102.readInt();     // Catch: IOException -> L21
        if (r105 > 0) goto L19;
        LogUtils.e(TAG, "Invalid DEK envelope length: " + r105);     // Catch: IOException -> L21
        return null;
    L19:
        byte[] r106 = new byte[r105];     // Catch: IOException -> L21
        r102.readFully(r106);     // Catch: IOException -> L21
        LogUtils.i(TAG, "extractDEKCipher success, dekEnvelopeLen: " + r105);     // Catch: IOException -> L21
        return r106;
    L21:
        e = move-exception;
        r101 = "Extract DEK cipher failed, error: " + e.getMessage();
        goto L5
    }
}
