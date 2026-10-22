package om7;

import android.util.Base64;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes22.dex */
public final class f {
    public static String a(byte[] r100) {
        String r101 = new String(Base64.decode(r100, 0));     // Catch: Exception -> L6
        int r102 = r101.lastIndexOf(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);     // Catch: Exception -> L6
        String r103 = r101.substring(0, r102);     // Catch: Exception -> L6
        String r104 = r101.substring(r102 + 1);     // Catch: Exception -> L6
        CRC32 r105 = new CRC32();     // Catch: Exception -> L6
        r105.update(r103.getBytes());     // Catch: Exception -> L6
        if (r104.equals(Long.toString(r105.getValue())) == false) goto L12;
        return r103;
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static byte[] b(String r100) {
        CRC32 r101 = new CRC32();
        r101.update(r100.getBytes());
        return Base64.encode((r100 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r101.getValue()).getBytes(), 0);
    }
}
