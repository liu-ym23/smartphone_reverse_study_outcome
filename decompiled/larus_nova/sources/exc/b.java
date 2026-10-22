package exc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public abstract class b {

    public static class a {
        public static void a(Context r100) {
            StringBuilder r101 = new StringBuilder();
            int r102 = 0;
            if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L5;
        L8:
            boolean r103 = true;
        L9:
            String r104 = null;
            if (r103 == false) goto L16;
            File r105 = r100.getExternalFilesDir(null);
            if (r105 == null) goto L16;
            String r106 = r105.getCanonicalPath();     // Catch: IOException -> L15
        L17:
            r101.append(r106);
            r101.append("/Log/");
            String r107 = r101.toString();
            PolarisFileWrapper r108 = new PolarisFileWrapper(r107);
            if (r108.exists() == false) goto L20;
        L22:
            r104 = r107;
        L24:
            if (TextUtils.isEmpty(r104) == false) goto L26;
            return;
        L26:
            e.c("ILogX", "deleteOldLogFiles File");
            PolarisFileWrapper r109 = new PolarisFileWrapper(r104);
            if (r109.exists() == true) goto L29;
            return;
        L29:
            if (r109.isDirectory() == false) goto L49;
            File[] r110 = r109.listFiles();
            if (r110 == null) goto L50;
            int r111 = r110.length;
        L34:
            if (r102 >= r111) goto L51;
            File r112 = r110[r102];
            if (r112.getName().contains("apphnid.txt") == false) goto L38;
        L41:
            r112.delete();
        L42:
            r102 = r102 + 1;
            goto L34
        L38:
            if (r112.getName().contains("apphnid.txt.bak") == true) goto L41;
            if (r112.getName().contains("honorid_advanced_log.txt") == false) goto L42;
        L51:
            return;
        L50:
            return;
        L49:
            return;
        L20:
            if (r108.mkdirs() == true) goto L22;
        L15:
            e.c("ILogX", "Exception");
        L16:
            r106 = null;
            goto L17
        L5:
            if (Environment.isExternalStorageRemovable() == false) goto L8;
            r103 = false;
            goto L9
        }

        public static String b(Context r100) {
            StringBuilder r101 = new StringBuilder();
            String r102 = r100.getFilesDir().getCanonicalPath();     // Catch: IOException -> L5
        L6:
            r101.append(r102);
            r101.append("/Log/");
            String r103 = r101.toString();
            PolarisFileWrapper r104 = new PolarisFileWrapper(r103);
            if (r104.exists() == false) goto L9;
        L11:
            return r103;
        L9:
            if (r104.mkdirs() == true) goto L11;
            return null;
        L5:
            e.c("ILogX", "getCanonicalPath is IOException");
            r102 = null;
            goto L6
        }
    }

    public b() {
    }

    public static String a(Context r100) {
        if (r100 == null) goto L10;
        cxc.c.a(r100).getClass();
        if ("com.hihonor.id".equals(r100.getPackageName()) == false) goto L10;
        String r101 = "HONORID_APK_log[" + r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionName + "]:";     // Catch: PackageManager.NameNotFoundException -> L9
    L12:
        if (TextUtils.isEmpty(r101) == false) goto L17;
        return "HonorID_openSDK_log[8.0.1.351]";
    L17:
        return r101;
    L10:
        r101 = "";
        goto L12
    }
}
