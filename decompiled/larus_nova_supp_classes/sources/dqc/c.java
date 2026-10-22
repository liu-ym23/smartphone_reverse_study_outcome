package dqc;

import android.app.Application;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.g;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static PolarisFileWrapper a;
    public static File b;
    public static PolarisFileWrapper c;
    public static volatile PolarisFileWrapper d;

    public c() {
    }

    public static String j(boolean r0) {
        if (r0 == false) goto L4;
        return "preversion-";
    L4:
        return "version-";
    }

    public static void k() {
        if (a != null) goto L6;
        File r1 = Zeus.getAppApplication().getFilesDir();
        String r2 = g.a;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r1, "zeus_p");
        a = r0;
        b(r0);
        return;
    }

    public static String d() {
        Application r0 = Zeus.getAppApplication();
        if (b != null) goto L9;
        File r1 = GlobalParam.getInstance().getDownloadDir();
        if (r1 != null) goto L7;
        File r2 = r0.getFilesDir();
        String r3 = g.a;
        r1 = new PolarisFileWrapper(r2, ".zeus_d");
    L7:
        b = r1;
    L9:
        return b(b);
    }

    public static String g() {
        Application r0 = Zeus.getAppApplication();
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L15;
        String r1 = g.a;     // Catch: Exception -> L9
        File r2 = r0.getExternalFilesDir(".zeus_d");     // Catch: Exception -> L9
        if (r2 == null) goto L16;
        return b(r2);
    L16:
        return null;
    L15:
        return null;
    }

    public static String a(String... r5) {
        k();
        PolarisFileWrapper r0 = a;
        if (r5.length <= 0) goto L11;
        int r1 = r5.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        String r3 = r5[r2];
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r0 = new PolarisFileWrapper(r0, r3);
    L9:
        r2 = r2 + 1;
    L11:
        return b(r0);
    }

    public static String b(File r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.exists() == true) goto L7;
        r1.mkdirs();
    L7:
        return r1.getPath();
    }

    public static String c(String r6, int r7) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        boolean r0 = true;
    L6:
        String r1 = j(false);
        if (r0 == false) goto L11;
        return a(new String[]{r6, r1 + r7, "apk", "oat", com.volcengine.zeus.oat.d.b()});
    L11:
        return a(new String[]{r6, r1 + r7, "dalvik-cache"});
    L5:
        r0 = false;
        goto L6
    }

    public static String i(String r2, int r3) {
        return new PolarisFileWrapper(a(new String[]{r2, j(false) + r3, "apk", "temp"}), "base-1.apk").getPath();
    }

    public static String e(String r2, int r3, boolean r4) {
        return a(new String[]{r2, j(r4) + r3, "lib"});
    }

    public static String f(String r4, int r5, boolean r6) {
        k();
        PolarisFileWrapper r0 = a;
        int r3 = 0;
        String[] r2 = {r4, j(r6) + r5};
    L3:
        if (r3 >= 2) goto L8;
        String r7 = r2[r3];
        if (TextUtils.isEmpty(r7) == true) goto L7;
        r0 = new PolarisFileWrapper(r0, r7);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        if (r0 != null) goto L15;
        return null;
    L15:
        return r0.getPath();
    }

    public static String h(String r2, int r3, boolean r4) {
        return new PolarisFileWrapper(a(new String[]{r2, j(r4) + r3, "apk"}), "base-1.apk").getPath();
    }
}
