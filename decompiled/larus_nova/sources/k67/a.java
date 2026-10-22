package k67;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.cert.Certificate;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public a() {
    }

    static {
    }

    public static String a(List<Certificate> r100, int r101) throws Exception {
        if (r100.isEmpty() == true) goto L24;
        if (r101 <= 0) goto L24;
        if (r101 > r100.size()) goto L24;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        Iterator<Certificate> r103 = r100.iterator();
        int r104 = 0;
    L9:
        if (r103.hasNext() == false) goto L22;
        Certificate r105 = r103.next();
        if (r104 >= r101) goto L22;
        if (r105 == null) goto L20;
        r102.write("-----BEGIN CERTIFICATE-----\\n".getBytes());
        String r106 = Base64.encodeToString(r105.getEncoded(), 2);
        int r107 = 0;
    L16:
        if (r107 >= r106.length()) goto L18;
        int r108 = r107 + 64;
        r102.write(r106.substring(r107, Math.min(r108, r106.length())).getBytes());
        r107 = r108;
        goto L16
    L18:
        r102.write("\\n".getBytes());
        r102.write("-----END CERTIFICATE-----\\n".getBytes());
        r104 = r104 + 1;
        goto L9
    L20:
        throw new IllegalArgumentException("Certificate is null at index " + r104);
    L22:
        return r102.toString();
    L24:
        throw new IllegalArgumentException("Certificate list is null, empty, or certNum is invalid");
    }
}
