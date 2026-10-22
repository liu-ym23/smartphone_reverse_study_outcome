package dqc;

import android.app.Application;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.g;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PolarisFileWrapper f469730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static File f469731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PolarisFileWrapper f469732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile PolarisFileWrapper f469733d;

    public c() {
    }

    public static String j(boolean r100) {
        if (r100 == false) goto L4;
        return "preversion-";
    L4:
        return PluginDirHelper.VERSION_PREFIX;
    }

    public static void k() {
        if (f469730a != null) goto L6;
        File r100 = Zeus.getAppApplication().getFilesDir();
        String r101 = g.f462704a;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, "zeus_p");
        f469730a = r102;
        b(r102);
        return;
    }

    public static String d() {
        Application r100 = Zeus.getAppApplication();
        if (f469731b != null) goto L9;
        File r101 = GlobalParam.getInstance().getDownloadDir();
        if (r101 != null) goto L7;
        File r102 = r100.getFilesDir();
        String r103 = g.f462704a;
        r101 = new PolarisFileWrapper(r102, ".zeus_d");
    L7:
        f469731b = r101;
    L9:
        return b(f469731b);
    }

    public static String g() {
        Application r100 = Zeus.getAppApplication();
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L15;
        String r101 = g.f462704a;     // Catch: Exception -> L9
        File r102 = r100.getExternalFilesDir(".zeus_d");     // Catch: Exception -> L9
        if (r102 == null) goto L16;
        return b(r102);
    L16:
        return null;
    L15:
        return null;
    }

    public static String a(String... r100) {
        k();
        PolarisFileWrapper r101 = f469730a;
        if (r100.length <= 0) goto L11;
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L11;
        String r104 = r100[r103];
        if (TextUtils.isEmpty(r104) == true) goto L9;
        r101 = new PolarisFileWrapper(r101, r104);
    L9:
        r103 = r103 + 1;
    L11:
        return b(r101);
    }

    public static String b(File r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.exists() == true) goto L7;
        r100.mkdirs();
    L7:
        return r100.getPath();
    }

    public static String c(String r100, int r101) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        boolean r102 = true;
    L6:
        String r103 = j(false);
        if (r102 == false) goto L11;
        return a(new String[]{r100, r103 + r101, "apk", "oat", com.volcengine.zeus.oat.d.b()});
    L11:
        return a(new String[]{r100, r103 + r101, "dalvik-cache"});
    L5:
        r102 = false;
        goto L6
    }

    public static String i(String r100, int r101) {
        return new PolarisFileWrapper(a(new String[]{r100, j(false) + r101, "apk", "temp"}), "base-1.apk").getPath();
    }

    public static String e(String r100, int r101, boolean r102) {
        return a(new String[]{r100, j(r102) + r101, "lib"});
    }

    public static String f(String r100, int r101, boolean r102) {
        k();
        PolarisFileWrapper r103 = f469730a;
        int r104 = 0;
        String[] r105 = {r100, j(r102) + r101};
    L3:
        if (r104 >= 2) goto L8;
        String r106 = r105[r104];
        if (TextUtils.isEmpty(r106) == true) goto L7;
        r103 = new PolarisFileWrapper(r103, r106);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        if (r103 != null) goto L15;
        return null;
    L15:
        return r103.getPath();
    }

    public static String h(String r100, int r101, boolean r102) {
        return new PolarisFileWrapper(a(new String[]{r100, j(r102) + r101, "apk"}), "base-1.apk").getPath();
    }
}
