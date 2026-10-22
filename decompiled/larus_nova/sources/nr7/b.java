package nr7;

import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static String a(String r100) {
        StringBuffer r101 = new StringBuffer();
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Exception -> L17
    L19:
        String r103 = r102.readLine();     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        r101.append(r103);     // Catch: Throwable -> L11
    L8:
        r102.close();     // Catch: Exception -> L17
        return r101.toString();
    L11:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: Exception -> L17
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L17
    L17:
        return "";
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static boolean c(String r100) {
        return r100.matches("\\d+");
    }
}
