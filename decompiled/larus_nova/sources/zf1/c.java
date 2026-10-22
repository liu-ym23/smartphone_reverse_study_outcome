package zf1;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f571645a = null;

    public c() {
    }

    static {
        f571645a = c.class.getSimpleName();
    }

    public static boolean a(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L9;
        if (r101.isDirectory() == false) goto L9;
        return true;
    L9:
        if (r101.exists() == false) goto L15;
        if (r101.delete() == true) goto L15;
        Logger.e(f571645a, "Can not delete file: " + r101.getAbsolutePath());
        return false;
    L15:
        return r101.mkdirs();
    }

    public static String b(Context r100) {
        if (r100 != null) goto L18;
    L4:
        String r101 = null;
    L9:
        if (r101 != null) goto L11;
        return null;
    L11:
        String r102 = r101 + File.separator + "backtrack";     // Catch: Exception -> L15
        if (a(r102) == true) goto L14;
        return null;
    L14:
        return r102;
    L15:
        e = move-exception;
        Logger.e(f571645a, "get backtrack cache file path error: " + e.toString());
        return null;
    L18:
        File r103 = r100.getExternalCacheDir();     // Catch: Exception -> L15
        if (r103 == null) goto L4;
        r101 = r103.getAbsolutePath();     // Catch: Exception -> L15
        goto L9
    }
}
