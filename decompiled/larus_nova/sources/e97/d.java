package e97;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class d {
    public static String a(String r100, String r101) {
        Mac r102 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L13
        r102.init(new SecretKeySpec(r101.getBytes(), "HmacSHA256"));     // Catch: Exception -> L13
        byte[] r103 = r102.doFinal(r100.getBytes());     // Catch: Exception -> L13
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L13
        int r105 = 0;
    L4:
        if (r103 == null) goto L11;
        if (r105 >= r103.length) goto L11;
        String r106 = Integer.toHexString(r103[r105] & UByte.MAX_VALUE);     // Catch: Exception -> L13
        if (r106.length() != 1) goto L10;
        r104.append('0');     // Catch: Exception -> L13
    L10:
        r104.append(r106);     // Catch: Exception -> L13
        r105 = r105 + 1;     // Catch: Exception -> L13
    L11:
        return r104.toString().toLowerCase();
    L13:
        return "";
    }
}
