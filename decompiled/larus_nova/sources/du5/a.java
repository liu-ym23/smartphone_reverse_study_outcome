package du5;

import com.bytedance.crypto.utils.CryptoConst;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static SecretKey c(char[] r100) {
        byte[] r101 = new byte[32];
        int r102 = 0;
    L3:
        if (r102 >= 32) goto L5;
        r101[r102] = (byte) ((r102 << 3) & (r102 << 1));
        r102 = r102 + 1;
        goto L3
    L5:
        PBEKeySpec r103 = new PBEKeySpec(r100, r101, 1000, 256);
        int r104 = 0;
    L7:
        if (r104 >= r100.length) goto L17;
        r100[r104] = 0;
        r104 = r104 + 1;
        goto L7
    L17:
        return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(r103).getEncoded(), CryptoConst.ALGORITHM_AES);
    L12:
        e = move-exception;
        tt5.a.e("AESUtils", "getKey error ", e, false);
        return null;
    }

    public static String a(byte[] r100, SecretKey r101) {
        Cipher r102 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L4
        r102.init(2, r101, new IvParameterSpec(new byte[r102.getBlockSize()]));     // Catch: Exception -> L4
        return new String(r102.doFinal(r100), StandardCharsets.UTF_8);
    L4:
        e = move-exception;
        tt5.a.e("AESUtils", "decrypt error ", e, false);
        return "";
    }

    public static byte[] b(String r100, SecretKey r101) {
        Cipher r102 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L4
        r102.init(1, r101, new IvParameterSpec(new byte[r102.getBlockSize()]));     // Catch: Exception -> L4
        return r102.doFinal(r100.getBytes(StandardCharsets.UTF_8));
    L4:
        e = move-exception;
        tt5.a.e("AESUtils", "encrypt error ", e, false);
        return new byte[0];
    }
}
