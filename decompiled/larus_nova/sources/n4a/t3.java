package n4a;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes32.dex */
public final class t3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f517754a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f517755b = null;

    static {
        f517754a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        f517755b = new byte[]{Base64.padSymbol, Base64.padSymbol, 81, 65, 65, 69, 119, 65, 67, 48, 74, 80, 115, 116, 54, 75, 104, 76, 122, 97, 88, 99, 53, 71, 49, 122, 68, 70, 79, 104, 113, 113, 65, 97, 76, 54, 65, 66, 87, 53, 103, 85, 84, 113, 71, 68, 69, 76, 80, 82, 106, 51, 66, 75, 75, 69, 98, 55, 84, 108, 115, 122, 51, 106, 76, 55, 88, 122, 70, 121, 73, 75, 52, 50, 43, 101, 70, 121, 56, 105, 115, 105, 89, 120, 117, 112, 53, 48, 76, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, 83, 119, 65, 119, 83, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, 75, 74, 89, 81, 68, 119, 119, 70, 77};
        new IvParameterSpec(new byte[]{0, 1, 1, 2, 3, 5, 8, HTTP.CR, 8, 7, 6, 5, 4, 3, 2, 1});
    }

    public static SecretKeySpec d(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        StringBuffer r101 = new StringBuffer(16);
    L5:
        r101.append(r100);
        if (r101.length() >= 16) goto L9;
        r100 = "0";
        goto L5
    L9:
        if (r101.length() <= 16) goto L17;
        r101.setLength(16);
    L17:
        byte[] r102 = r101.toString().getBytes("UTF-8");     // Catch: Throwable -> L13
    L16:
        return new SecretKeySpec(r102, CryptoConst.ALGORITHM_AES);
    L13:
        th = move-exception;
        c4.g(th, "Encrypt", "createKey");
        r102 = null;
        goto L16
    }

    public static byte[] b(byte[] r110) throws Exception {
        byte[] r100 = new StringBuilder(new String(f517755b)).reverse().toString().getBytes();
        int r101 = a3.f517133a;
        int r102 = r100.length;
        int r103 = (r102 * 3) / 4;
        byte[] r104 = new byte[r103];
        int[] r105 = a3.b.f517134a;
        int r106 = r102 + 0;
        int r107 = 0;
        int r108 = 0;
        int r109 = 0;
        int r111 = 0;
    L4:
        if (r107 >= r106) goto L50;
        if (r108 != 0) goto L12;
    L6:
        int r112 = r107 + 4;
        if (r112 > r106) goto L11;
        r109 = (((r105[r100[r107] & UByte.MAX_VALUE] << 18) | (r105[r100[r107 + 1] & UByte.MAX_VALUE] << 12)) | (r105[r100[r107 + 2] & UByte.MAX_VALUE] << 6)) | r105[r100[r107 + 3] & UByte.MAX_VALUE];
        if (r109 < 0) goto L11;
        r104[r111 + 2] = (byte) r109;
        r104[r111 + 1] = (byte) (r109 >> 8);
        r104[r111] = (byte) (r109 >> 16);
        r111 = r111 + 3;
        r107 = r112;
    L11:
        if (r107 >= r106) goto L50;
    L12:
        r107 = r107 + 1;
        int r113 = r105[r100[r107] & UByte.MAX_VALUE];
        if (r108 == 0) goto L45;
        if (r108 == 1) goto L40;
        if (r108 != 2) goto L18;
        if (r113 >= 0) goto L41;
        if (r113 != (-2)) goto L38;
        r104[r111] = (byte) (r109 >> 4);
        r111 = r111 + 1;
        r108 = 4;
        goto L4
    L38:
        if (r113 == (-1)) goto L4;
    L58:
        boolean r114 = false;
        r111 = 0;
    L59:
        if (r114 == false) goto L66;
        if (r111 == r103) goto L63;
        byte[] r115 = new byte[r111];
        System.arraycopy(r104, 0, r115, 0, r111);
        r104 = r115;
    L63:
        X509EncodedKeySpec r116 = new X509EncodedKeySpec(r104);
        PublicKey r117 = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(r116);
        Cipher r118 = Cipher.getInstance(f5.o("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
        r118.init(1, r117);
        return r118.doFinal(r110);
    L66:
        throw new IllegalArgumentException("bad base-64");
    L41:
        r109 = (r109 << 6) | r113;
    L42:
        r108 = r108 + 1;
        goto L4
    L18:
        if (r108 != 3) goto L19;
        if (r113 < 0) goto L30;
        r109 = (r109 << 6) | r113;
        r104[r111 + 2] = (byte) r109;
        r104[r111 + 1] = (byte) (r109 >> 8);
        r104[r111] = (byte) (r109 >> 16);
        r111 = r111 + 3;
        r108 = 0;
        goto L4
    L30:
        if (r113 != (-2)) goto L32;
        r104[r111 + 1] = (byte) (r109 >> 2);
        r104[r111] = (byte) (r109 >> 10);
        r111 = r111 + 2;
        r108 = 5;
        goto L4
    L32:
        if (r113 == (-1)) goto L4;
    L19:
        if (r108 == 4) goto L24;
        if (r108 != 5) goto L4;
        if (r113 == (-1)) goto L4;
    L24:
        if (r113 == (-2)) goto L42;
        if (r113 == (-1)) goto L4;
    L40:
        if (r113 >= 0) goto L41;
        if (r113 == (-1)) goto L4;
    L45:
        if (r113 < 0) goto L47;
        r108 = r108 + 1;
        r109 = r113;
        goto L4
    L47:
        if (r113 == (-1)) goto L4;
    L50:
        if (r108 == 1) goto L58;
        if (r108 == 2) goto L56;
        if (r108 == 3) goto L55;
        if (r108 == 4) goto L58;
    L57:
        r114 = true;
        goto L59
    L55:
        int r119 = r111 + 1;
        r104[r111] = (byte) (r109 >> 10);
        r111 = r119 + 1;
        r104[r119] = (byte) (r109 >> 2);
        goto L57
    L56:
        r104[r111] = (byte) (r109 >> 4);
        r111 = r111 + 1;
        goto L57
    }

    public static String a(String r100, String r101) {
        if (r101 != null) goto L20;
        return null;
    L20:
        byte[] r102 = r101.getBytes("UTF-8");     // Catch: Throwable -> L15
        MessageDigest r103 = MessageDigest.getInstance(r100);     // Catch: Throwable -> L8
        r103.update(r102);     // Catch: Throwable -> L8
        byte[] r104 = r103.digest();     // Catch: Throwable -> L8
    L10:
        int r105 = r104.length;     // Catch: Throwable -> L15
        StringBuilder r106 = new StringBuilder(r105 * 2);     // Catch: Throwable -> L15
        int r107 = 0;
    L11:
        if (r107 >= r105) goto L13;
        char[] r108 = f517754a;     // Catch: Throwable -> L15
        r106.append(r108[(r104[r107] >> 4) & 15]);     // Catch: Throwable -> L15
        r106.append(r108[r104[r107] & 15]);     // Catch: Throwable -> L15
        r107 = r107 + 1;     // Catch: Throwable -> L15
        goto L11
    L13:
        return r106.toString();
    L8:
        th = move-exception;
        n.a(th, "MD5", "gmb");     // Catch: Throwable -> L15
        r104 = null;
    L15:
        th = move-exception;
        c4.g(th, "Encrypt", "encode");
        return null;
    }

    public static byte[] c(byte[] r100, String r101) {
        SecretKeySpec r102 = d(r101);     // Catch: Throwable -> L4
        IvParameterSpec r103 = new IvParameterSpec(f5.p());     // Catch: Throwable -> L4
        Cipher r104 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Throwable -> L4
        r104.init(1, r102, r103);     // Catch: Throwable -> L4
        return r104.doFinal(r100);
    L4:
        th = move-exception;
        c4.g(th, "Encrypt", "aesEncrypt");
        return null;
    }

    public static byte[] e(byte[] r100, String r101) {
        SecretKeySpec r102 = d(r101);     // Catch: Throwable -> L4
        IvParameterSpec r103 = new IvParameterSpec(f5.p());     // Catch: Throwable -> L4
        Cipher r104 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Throwable -> L4
        r104.init(2, r102, r103);     // Catch: Throwable -> L4
        return r104.doFinal(r100);
    L4:
        th = move-exception;
        c4.g(th, "Encrypt", "aesDecrypt");
        return null;
    }
}
