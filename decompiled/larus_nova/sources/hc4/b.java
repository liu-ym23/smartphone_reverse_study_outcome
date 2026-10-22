package hc4;

import android.util.Base64;
import android.util.Pair;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f484531a = null;

    static {
        f484531a = new byte[]{116, 99, 6, 16, 0, 0};
    }

    public static String c(String r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r101.update(r100.getBytes());     // Catch: Exception -> L10
        byte[] r102 = r101.digest();     // Catch: Exception -> L10
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L10
        int r104 = r102.length;     // Catch: Exception -> L10
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        String r106 = Integer.toHexString(r102[r105] & UByte.MAX_VALUE);     // Catch: Exception -> L10
        if (r106.length() != 1) goto L7;
        r103.append('0');     // Catch: Exception -> L10
    L7:
        r103.append(r106);     // Catch: Exception -> L10
        r105 = r105 + 1;     // Catch: Exception -> L10
        goto L3
    L8:
        return r103.toString();
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String a(String r100, String r110) {
        char[] r101 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();     // Catch: Exception -> L13
        char[] r102 = new char[32];     // Catch: Exception -> L13
        int r103 = 0;
    L4:
        if (r103 >= 32) goto L6;
        r102[r103] = r101[Math.min((int) (Math.random() * ((double) r101.length)), r101.length - 1)];     // Catch: Exception -> L13
        r103 = r103 + 1;     // Catch: Exception -> L13
        goto L4
    L6:
        String r104 = new String(r102);     // Catch: Exception -> L13
        Pair<byte[], byte[]> r111 = b(r104, r110);     // Catch: Exception -> L13
        SecretKeySpec r105 = new SecretKeySpec((byte[]) r111.second, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L13
        GCMParameterSpec r106 = new GCMParameterSpec(128, (byte[]) r111.first);     // Catch: Exception -> L13
        Cipher r112 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L13
        r112.init(1, r105, r106);     // Catch: Exception -> L13
        byte[] r107 = MessageDigest.getInstance("SHA-512").digest(r100.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L9
    L11:
        byte[] r108 = r100.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L13
        ByteBuffer r109 = ByteBuffer.allocate(r107.length + r108.length);     // Catch: Exception -> L13
        r109.put(r107);     // Catch: Exception -> L13
        r109.put(r108);     // Catch: Exception -> L13
        byte[] r113 = r112.doFinal(r109.array());     // Catch: Exception -> L13
        byte[] r114 = r104.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L13
        byte[] r115 = f484531a;     // Catch: Exception -> L13
        ByteBuffer r116 = ByteBuffer.allocate((r114.length + 6) + r113.length);     // Catch: Exception -> L13
        r116.put(r115);     // Catch: Exception -> L13
        r116.put(r114);     // Catch: Exception -> L13
        r116.put(r113);     // Catch: Exception -> L13
        return Base64.encodeToString(r116.array(), 2);
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        r107 = null;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Pair<byte[], byte[]> b(String r110, String r111) {
        byte[] r100 = null;
        byte[] r112 = MessageDigest.getInstance("SHA-512").digest(r110.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L5
    L7:
        int r101 = r111.length();
        if ((r101 % 2) != 1) goto L10;
        r101 = r101 + 1;
        byte[] r102 = new byte[r101 / 2];
        r111 = "0".concat(r111);
    L11:
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L12:
        if (r104 >= r101) goto L14;
        int r106 = r104 + 2;
        r102[r105] = (byte) CastIntegerProtector.parseInt(r111.substring(r104, r106), 16);
        r105 = r105 + 1;
        r104 = r106;
        goto L12
    L14:
        ByteBuffer r113 = ByteBuffer.allocate(r112.length + r102.length);
        r113.put(r112).put(r102);
        r100 = MessageDigest.getInstance("SHA-512").digest(r113.array());     // Catch: Exception -> L17
    L19:
        byte[] r114 = new byte[32];
        byte[] r107 = new byte[12];
    L21:
        if (r103 >= 44) goto L27;
        if (r103 >= 32) goto L24;
        r114[r103] = r100[r103];
    L25:
        r103 = r103 + 1;
        goto L21
    L24:
        r107[r103 - 32] = r100[r103];
        goto L25
    L27:
        return new Pair(r107, r114);
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L10:
        r102 = new byte[r101 / 2];
    L5:
        e = move-exception;
        e.printStackTrace();
        r112 = null;
        goto L7
    }
}
