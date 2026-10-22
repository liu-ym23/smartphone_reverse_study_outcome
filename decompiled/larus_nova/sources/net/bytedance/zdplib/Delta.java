package net.bytedance.zdplib;

import com.larus.utils.logger.FLogger;
import java.security.MessageDigest;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public class Delta {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f518935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f518936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f518937c;

    public class a extends ThreadLocal<MessageDigest> {
        @Override // java.lang.ThreadLocal
        public final MessageDigest initialValue() {
            return MessageDigest.getInstance("SHA-256");
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public a() {
        }
    }

    private static native int decrypt(byte[] r100, byte[] r101, byte[] r102);

    private static native int encrypt(byte[] r100, byte[] r101, byte[] r102);

    private static native void free(long r100);

    private static native int generateAesKey(byte[] r100, long r101, long r102);

    private static native int generatePrivateKey(byte[] r100);

    private static native int getDecryptedLen(int r100);

    private static native int getEncryptedLen(int r100);

    private static native int getPublicKey(byte[] r100, long r101);

    private static native long initPrivateKey(byte[] r100);

    private static native long initPubKey(byte[] r100);

    static {
        Intrinsics.checkNotNullParameter("delta", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> delta");
        com.bytedance.librarian.a.c("delta");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> delta");
    }

    public final String c() throws Exception {
        byte[] r100 = new byte[33];
        int r101 = getPublicKey(r100, this.f518936b);
        if (r101 != 0) goto L7;
        return d(r100);
    L7:
        throw new Exception("getPublicKey error " + r101);
    }

    public static String d(byte[] r100) {
        char[] r101 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] r102 = new char[r100.length * 2];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L7;
        int r104 = r100[r103] & UByte.MAX_VALUE;
        int r105 = r103 * 2;
        r102[r105] = r101[r104 >>> 4];
        r102[r105 + 1] = r101[r104 & 15];
        r103 = r103 + 1;
        goto L4
    L7:
        return new String(r102);
    }

    public static byte[] e(String r100) {
        int r101 = r100.length();
        byte[] r102 = new byte[r101 / 2];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103 / 2] = (byte) ((Character.digit(r100.charAt(r103), 16) << 4) + Character.digit(r100.charAt(r103 + 1), 16));
        r103 = r103 + 2;
        goto L3
    L5:
        return r102;
    }

    public final byte[] a(byte[] r100) throws Exception {
        if (this.f518935a == null) goto L14;
        int r101 = getDecryptedLen(r100.length);
        if (r101 < 0) goto L12;
        byte[] r102 = new byte[r101];
        int r103 = decrypt(r102, r100, this.f518935a);
        if (r103 < 0) goto L10;
        return r102;
    L10:
        throw new Exception("decrypt error " + r103);
    L12:
        throw new Exception("encryptedMessage is too short");
    L14:
        throw new Exception("invalid aes key");
    }

    public final byte[] b(byte[] r100) throws Exception {
        if (this.f518935a == null) goto L13;
        int r101 = getEncryptedLen(r100.length);
        byte[] r102 = new byte[r101];
        int r103 = encrypt(r102, r100, this.f518935a);
        if (r103 < 0) goto L11;
        if (r103 != r101) goto L9;
        return r102;
    L9:
        throw new Exception("data length error");
    L11:
        throw new Exception("encrypt error " + r103);
    L13:
        throw new Exception("invalid aes key");
    }

    public Delta(byte[] r100, String r101) throws Exception {
        this.f518937c = new a();
        byte[] r102 = e(r101);
        if (r102.length != 33) goto L5;
    L9:
        long r103 = initPubKey(r102);
        if (r103 == 0) goto L17;
        long r104 = initPrivateKey(r100);
        this.f518936b = r104;
        byte[] r105 = new byte[32];
        this.f518935a = r105;
        int r106 = generateAesKey(r105, r104, r103);
        if (r106 != 0) goto L15;
        return;
    L15:
        throw new Exception("generateAesKey error " + r106);
    L17:
        throw new Exception("other public key invalid");
    L5:
        if (r102.length == 65) goto L9;
        throw new Exception("other public key length error");
    }
}
