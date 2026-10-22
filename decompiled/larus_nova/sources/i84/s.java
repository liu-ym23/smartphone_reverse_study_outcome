package i84;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f488640a;

    public static String d() {
        if (TextUtils.isEmpty(f488640a) == false) goto L6;
        f488640a = a("Ynl0ZWRhbmNl");
    L6:
        return f488640a;
    }

    public static String a(String r100) {
        return new String(Base64.decode(r100.getBytes("UTF-8"), 2));
    L4:
        return "";
    }

    public static String b(byte[] r100, String r101) throws Exception {
        byte[] r102 = Base64.decode(r100, 0);     // Catch: Exception -> L5
        Cipher r103 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: Exception -> L5
        r103.init(2, new SecretKeySpec(r101.getBytes(), CryptoConst.ALGORITHM_AES), new IvParameterSpec("NIfb&95GUY86Gfgh".getBytes()));     // Catch: Exception -> L5
        return new String(r103.doFinal(r102)).trim();
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static byte[] c(String r100, String r101) throws Exception {
        Cipher r102 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: Exception -> L7
        int r103 = r102.getBlockSize();     // Catch: Exception -> L7
        byte[] r104 = r100.getBytes();     // Catch: Exception -> L7
        int r105 = r104.length;     // Catch: Exception -> L7
        if ((r105 % r103) == 0) goto L5;
        r105 = r105 + (r103 - (r105 % r103));     // Catch: Exception -> L7
    L5:
        byte[] r106 = new byte[r105];     // Catch: Exception -> L7
        System.arraycopy(r104, 0, r106, 0, r104.length);     // Catch: Exception -> L7
        r102.init(1, new SecretKeySpec(r101.getBytes(), CryptoConst.ALGORITHM_AES), new IvParameterSpec("NIfb&95GUY86Gfgh".getBytes()));     // Catch: Exception -> L7
        return Base64.encode(r102.doFinal(r106), 0);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
