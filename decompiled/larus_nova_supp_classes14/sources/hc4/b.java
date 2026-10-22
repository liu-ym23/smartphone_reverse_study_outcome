package hc4;

import android.util.Base64;
import android.util.Pair;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final byte[] a = null;

    static {
        a = new byte[]{116, 99, 6, 16, 0, 0};
    }

    public static String c(String r6) {
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r0.update(r6.getBytes());     // Catch: Exception -> L10
        byte[] r7 = r0.digest();     // Catch: Exception -> L10
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L10
        int r2 = r7.length;     // Catch: Exception -> L10
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        String r4 = Integer.toHexString(r7[r3] & 255);     // Catch: Exception -> L10
        if (r4.length() != 1) goto L7;
        r1.append('0');     // Catch: Exception -> L10
    L7:
        r1.append(r4);     // Catch: Exception -> L10
        r3 = r3 + 1;     // Catch: Exception -> L10
        goto L3
    L8:
        return r1.toString();
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String a(String r9, String r10) {
        char[] r1 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();     // Catch: Exception -> L13
        char[] r3 = new char[32];     // Catch: Exception -> L13
        int r4 = 0;
    L4:
        if (r4 >= 32) goto L6;
        r3[r4] = r1[Math.min((int) (Math.random() * ((double) r1.length)), r1.length - 1)];     // Catch: Exception -> L13
        r4 = r4 + 1;     // Catch: Exception -> L13
        goto L4
    L6:
        String r2 = new String(r3);     // Catch: Exception -> L13
        Pair<byte[], byte[]> r11 = b(r2, r10);     // Catch: Exception -> L13
        SecretKeySpec r5 = new SecretKeySpec((byte[]) r11.second, "AES");     // Catch: Exception -> L13
        GCMParameterSpec r6 = new GCMParameterSpec(128, (byte[]) r11.first);     // Catch: Exception -> L13
        Cipher r12 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L13
        r12.init(1, r5, r6);     // Catch: Exception -> L13
        byte[] r7 = MessageDigest.getInstance("SHA-512").digest(r9.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L9
    L11:
        byte[] r13 = r9.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L13
        ByteBuffer r8 = ByteBuffer.allocate(r7.length + r13.length);     // Catch: Exception -> L13
        r8.put(r7);     // Catch: Exception -> L13
        r8.put(r13);     // Catch: Exception -> L13
        byte[] r14 = r12.doFinal(r8.array());     // Catch: Exception -> L13
        byte[] r15 = r2.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L13
        byte[] r16 = a;     // Catch: Exception -> L13
        ByteBuffer r17 = ByteBuffer.allocate((r15.length + 6) + r14.length);     // Catch: Exception -> L13
        r17.put(r16);     // Catch: Exception -> L13
        r17.put(r15);     // Catch: Exception -> L13
        r17.put(r14);     // Catch: Exception -> L13
        return Base64.encodeToString(r17.array(), 2);
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        r7 = null;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Pair<byte[], byte[]> b(String r10, String r11) {
        byte[] r1 = null;
        byte[] r12 = MessageDigest.getInstance("SHA-512").digest(r10.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L5
    L7:
        int r2 = r11.length();
        if ((r2 % 2) != 1) goto L10;
        r2 = r2 + 1;
        byte[] r3 = new byte[r2 / 2];
        r11 = "0".concat(r11);
    L11:
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L12:
        if (r6 >= r2) goto L14;
        int r8 = r6 + 2;
        r3[r7] = (byte) CastIntegerProtector.parseInt(r11.substring(r6, r8), 16);
        r7 = r7 + 1;
        r6 = r8;
        goto L12
    L14:
        ByteBuffer r13 = ByteBuffer.allocate(r12.length + r3.length);
        r13.put(r12).put(r3);
        r1 = MessageDigest.getInstance("SHA-512").digest(r13.array());     // Catch: Exception -> L17
    L19:
        byte[] r14 = new byte[32];
        byte[] r0 = new byte[12];
    L21:
        if (r5 >= 44) goto L27;
        if (r5 >= 32) goto L24;
        r14[r5] = r1[r5];
    L25:
        r5 = r5 + 1;
        goto L21
    L24:
        r0[r5 - 32] = r1[r5];
        goto L25
    L27:
        return new Pair(r0, r14);
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L10:
        r3 = new byte[r2 / 2];
    L5:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
        goto L7
    }
}
