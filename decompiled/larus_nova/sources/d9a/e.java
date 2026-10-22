package d9a;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes32.dex */
public final class e {
    public static PolarisFileWrapper a(Context r100) {
        String r101 = r100.getApplicationInfo().dataDir + "/shared_prefs";
        String r102 = r100.getApplicationInfo().dataDir + "/spFiles";
        String r103 = r102 + File.separator + "/tmp";
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);
        if (r104.exists() == false) goto L18;
        File[] r105 = r104.listFiles();
        int r106 = r105.length;
        int r107 = 0;
    L5:
        if (r107 >= r106) goto L18;
        File r108 = r105[r107];
        String r109 = r108.getName();
        if (r109.endsWith(".xml") == false) goto L11;
        if (com.monitor.cloudmessage.utils.a.c(r108.getAbsolutePath(), r103, r109) == true) goto L11;
        return null;
    L11:
        r107 = r107 + 1;
    L18:
        StringBuilder r110 = new StringBuilder();     // Catch: Exception -> L15
        r110.append(r102);     // Catch: Exception -> L15
        String r111 = File.separator;     // Catch: Exception -> L15
        r110.append(r111);     // Catch: Exception -> L15
        r110.append("sp.zip");     // Catch: Exception -> L15
        com.monitor.cloudmessage.utils.a.i(r103, r110.toString());     // Catch: Exception -> L15
        com.monitor.cloudmessage.utils.a.g(r103);
        return new PolarisFileWrapper(r102 + r111 + "sp.zip");
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
