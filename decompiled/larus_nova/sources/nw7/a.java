package nw7;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import exc.e;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static String a(Context r110, String r111) {
        int r100 = CastIntegerProtector.parseInt(cxc.a.a(r110));     // Catch: Exception -> L5
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L51;
        if (r100 < 3) goto L51;
        String r112 = r110.getPackageName() + ".hnidsdk";
        if (r111 != null) goto L12;
        byte[] r113 = new byte[0];
    L40:
        if (r113.length > 16) goto L42;
        e.b("KeyStoreEncryptAndDecrypt", "Decrypt source data is invalid.");
    L50:
        String r114 = "";
    L53:
        if (TextUtils.isEmpty(r114) == false) goto L55;
        return "";
    L55:
        return r114;
    L42:
        byte[] r101 = new byte[0];
        SecretKey r115 = b.a(r112);     // Catch: Exception -> L45 RuntimeException -> L46
        byte[] r102 = Arrays.copyOf(r113, 16);     // Catch: Exception -> L45 RuntimeException -> L46
        Cipher r103 = Cipher.getInstance("AES/CBC/PKCS7Padding");     // Catch: Exception -> L45 RuntimeException -> L46
        r103.init(2, r115, new IvParameterSpec(r102));     // Catch: Exception -> L45 RuntimeException -> L46
        r101 = r103.doFinal(r113, 16, r113.length - 16);     // Catch: Exception -> L45 RuntimeException -> L46
    L56:
        r114 = new String(r101, "UTF-8");     // Catch: UnsupportedEncodingException -> L49
    L49:
        e.c("KeyStoreEncryptAndDecrypt", "unreachable UnsupportedEncodingException");
        goto L50
    L46:
        e.c("KeyStoreEncryptAndDecrypt", "RuntimeException");
    L45:
        e.b("KeyStoreEncryptAndDecrypt", "Decrypt exception");
        goto L56
    L12:
        int r104 = r111.length();
        if ((r104 % 2) == 0) goto L15;
        r113 = new byte[0];
        goto L40
    L15:
        String r116 = r111.toUpperCase(Locale.ENGLISH);
        int r105 = 0;
    L17:
        if (r105 >= r104) goto L27;
        char r106 = r116.charAt(r105);
        if ('0' <= r106) goto L21;
    L22:
        if ('A' > r106) goto L26;
        if (r106 > 'F') goto L26;
    L25:
        r105 = r105 + 1;
    L26:
        r113 = new byte[0];
        goto L40
    L21:
        if (r106 <= '9') goto L25;
    L27:
        int r107 = r104 / 2;
        byte[] r108 = new byte[r107];
        byte[] r109 = new byte[2];
        int r117 = 0;
        int r118 = 0;
    L28:
        if (r117 >= r107) goto L38;
        int r119 = r118 + 1;
        r109[0] = (byte) r116.charAt(r118);
        r118 = r119 + 1;
        r109[1] = (byte) r116.charAt(r119);
        int r120 = 0;
    L30:
        if (r120 >= 2) goto L37;
        byte r121 = r109[r120];
        if (65 > r121) goto L35;
        if (r121 > 70) goto L35;
        r109[r120] = (byte) (r121 - 55);
    L36:
        r120 = r120 + 1;
    L35:
        r109[r120] = (byte) (r121 - 48);
        goto L36
    L37:
        r108[r117] = (byte) ((r109[0] << 4) | r109[1]);
        r117 = r117 + 1;
        goto L28
    L38:
        r113 = r108;
    L51:
        r114 = null;
    L5:
        e.c("HnIdEncrypter", "get version of encrypted is null, use GRADE_VERSION_KEYSTORE directory");
        r100 = 3;
        goto L7
    }

    public static String b(Context r100, String r101) {
        if (Build.VERSION.SDK_INT < 23) goto L25;
        String r102 = r100.getPackageName() + ".hnidsdk";
        int r103 = 0;
        byte[] r104 = new byte[0];
        Cipher r105 = Cipher.getInstance("AES/CBC/PKCS7Padding");     // Catch: Exception -> L13 RuntimeException -> L14
        r105.init(1, b.a(r102));     // Catch: Exception -> L13 RuntimeException -> L14
        byte[] r106 = r105.doFinal(r101.getBytes("UTF-8"));     // Catch: Exception -> L13 RuntimeException -> L14
        byte[] r107 = r105.getIV();     // Catch: Exception -> L13 RuntimeException -> L14
        if (r107 != null) goto L8;
    L11:
        e.b("KeyStoreEncryptAndDecrypt", "IV is invalid.");     // Catch: Exception -> L13 RuntimeException -> L14
        goto L25
    L8:
        if (r107.length != 16) goto L11;
        r104 = Arrays.copyOf(r107, r107.length + r106.length);     // Catch: Exception -> L13 RuntimeException -> L14
        System.arraycopy(r106, 0, r104, r107.length, r106.length);     // Catch: Exception -> L13 RuntimeException -> L14
    L15:
        StringBuffer r108 = new StringBuffer();
        if (r104 != null) goto L18;
        return null;
    L18:
        int r109 = r104.length;
    L19:
        if (r103 >= r109) goto L32;
        String r110 = Integer.toHexString(r104[r103] & UByte.MAX_VALUE);
        if (r110.length() != 1) goto L23;
        r110 = "0".concat(r110);
    L23:
        r108.append(r110.toUpperCase(Locale.ENGLISH));
        r103 = r103 + 1;
        goto L19
    L32:
        return r108.toString();
    L14:
        e.c("KeyStoreEncryptAndDecrypt", "RuntimeException");
    L13:
        e.b("KeyStoreEncryptAndDecrypt", "Encrypt exception");
    L25:
        return "";
    }
}
