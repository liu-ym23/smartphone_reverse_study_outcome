package l17;

import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes21.dex */
public final class m {
    public static String a() {
        return f() + "/webview_bytedance/";
    }

    public static String f() {
        return TTWebContext.h().getContext().getFilesDir().getAbsolutePath();
    }

    public static String b(String r100) {
        return a() + r100 + "_md5/";
    }

    public static String c(String r100) {
        return b(r100) + r100 + "_compiled";
    }

    public static String d(String r100) {
        return b(r100) + "classes.dex";
    }

    public static String e(String r100) {
        return b(r100) + "feature.json";
    }

    public static String g(String r100) {
        return b(r100) + r100;
    }

    public static String h(String r100) {
        String r101 = a() + r100 + File.separator;
        new PolarisFileWrapper(r101).mkdirs();
        return r101;
    }

    public static String j(String r100) {
        return b(r100) + "ttwebview_res.apk";
    }

    public static String k(String r100) {
        return b(r100) + "libwebview.so";
    }

    public static String l(String r100) {
        return TTWebContext.h().getContext().getDir("dex", 0).getAbsolutePath() + '/' + r100 + "_md5/";
    }

    public static String m(String r100) {
        return b(r100) + "libbytedanceweb.apk";
    }

    public static String i(String r100, String r101) {
        String r102 = h(r100) + r101.substring(0, 7) + File.separator;
        new PolarisFileWrapper(r102).mkdirs();
        return r102;
    }
}
