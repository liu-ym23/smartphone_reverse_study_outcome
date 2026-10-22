package nta;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f520542a;

    public static String[] c() {
        KeyGenerator r100 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L8
        SecureRandom r101 = new SecureRandom();     // Catch: Throwable -> L8
        r100.init(128, r101);     // Catch: Throwable -> L8
        byte[] r102 = new byte[8];     // Catch: Throwable -> L8
        r101.nextBytes(r102);     // Catch: Throwable -> L8
        String[] r103 = {b(r100.generateKey().getEncoded()), b(r102)};     // Catch: Throwable -> L8
        if (d(r103) == false) goto L6;
        return r103;
    L6:
        return null;
    L11:
        return null;
    }

    public static String a(String r100) {
        return new String(Base64.decode(r100.getBytes("UTF-8"), 2));
    L4:
        return "";
    }

    public static String b(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L3:
        if (r100 == null) goto L11;
        if (r102 >= r100.length) goto L11;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L9;
        r101.append('0');
    L9:
        r101.append(r103);
        r102 = r102 + 1;
    L11:
        return r101.toString();
    }

    public static boolean d(String[] r100) {
        if (r100 != null) goto L5;
    L16:
        return false;
    L5:
        if (r100.length != 2) goto L16;
        if (TextUtils.isEmpty(r100[0]) == true) goto L16;
        if (r100[0].length() != 32) goto L16;
        if (TextUtils.isEmpty(r100[1]) == true) goto L16;
        if (r100[1].length() != 16) goto L16;
        return true;
    }
}
