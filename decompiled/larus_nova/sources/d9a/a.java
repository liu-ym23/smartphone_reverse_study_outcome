package d9a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f467646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f467647b;

    public static PolarisFileWrapper a(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
        f467646a = true;
        f467647b = r101;
    L5:
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.getApplicationInfo().dataDir);
        String r103 = File.separator;
        r102.append(r103);
        r102.append("databases");
        String r104 = r102.toString();
        String r105 = r100.getApplicationInfo().dataDir + r103 + "dbFiles";
        String r106 = r105 + r103 + "/tmp";
        PolarisFileWrapper r107 = new PolarisFileWrapper(r104);
        if (r107.exists() == false) goto L32;
        File[] r108 = r107.listFiles();
        int r109 = r108.length;
        int r110 = 0;
    L8:
        if (r110 >= r109) goto L32;
        File r111 = r108[r110];
        String r112 = r111.getName();
        if (r112.endsWith(DBDefinition.DATABASE_SUBPROCESS_SUFFIX_NAME) == false) goto L17;
        if (f467646a == true) goto L17;
        if (com.monitor.cloudmessage.utils.a.c(r111.getAbsolutePath(), r106, r112) == true) goto L17;
        return null;
    L17:
        if (f467646a == false) goto L25;
        if (TextUtils.isEmpty(f467647b) == true) goto L25;
        if (f467647b.equals(r112) == false) goto L25;
        if (com.monitor.cloudmessage.utils.a.c(r111.getAbsolutePath(), r106, r112) == true) goto L25;
        return null;
    L25:
        r110 = r110 + 1;
    L32:
        StringBuilder r113 = new StringBuilder();     // Catch: Exception -> L29
        r113.append(r105);     // Catch: Exception -> L29
        String r114 = File.separator;     // Catch: Exception -> L29
        r113.append(r114);     // Catch: Exception -> L29
        r113.append("db.zip");     // Catch: Exception -> L29
        com.monitor.cloudmessage.utils.a.i(r106, r113.toString());     // Catch: Exception -> L29
        com.monitor.cloudmessage.utils.a.g(r106);
        return new PolarisFileWrapper(r105 + r114 + "db.zip");
    L29:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
