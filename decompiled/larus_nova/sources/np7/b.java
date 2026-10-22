package np7;

import android.text.TextUtils;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.pm.PluginPackageManager;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vp7.c;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("quick", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> quick");
        com.bytedance.librarian.a.c("quick");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> quick");
    }

    public static String c() {
        vp7.b r100 = (vp7.b) c.a.f556651a.a(vp7.b.class);
        if (r100 != null) goto L5;
        return "";
    L5:
        r100.a();
        return "com.ss.android.ugc.aweme.vmsdk_plugin";
    }

    public static boolean d() {
        vp7.b r100 = (vp7.b) c.a.f556651a.a(vp7.b.class);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        return r101;
    L5:
        if (r100.c() == false) goto L7;
        r101 = true;
        goto L9
    }

    public static boolean e(String r100) {
        if (d() == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        r100 = c();
    L8:
        String[] r101 = {"quick", "napi", ErrorType.WORKER};
        int r102 = 0;
    L10:
        if (r102 >= 3) goto L20;
        String r103 = b(r100, r101[r102]);
        if (TextUtils.isEmpty(r103) == true) goto L14;
        System.load(r103);     // Catch: Throwable -> L17
        r102 = r102 + 1;
    L17:
        th = move-exception;
        th.getMessage();
        return false;
    L14:
        return false;
    L20:
        return true;
    }

    public static String b(String r100, String r101) {
        if (d() == true) goto L13;
        return "";
    L13:
    L10:
        th = move-exception;
        th.getMessage();
        return "";
    L6:
        if (PatternProtector.compile("lib\\w+\\.so").matcher(r101).matches() == true) goto L8;
        r101 = System.mapLibraryName(r101);     // Catch: Throwable -> L10
    L8:
        return new PolarisFileWrapper(PluginDirHelper.getNativeLibraryDir(r100, PluginPackageManager.getInstalledPluginVersion(r100)), r101).getPath();
    }
}
