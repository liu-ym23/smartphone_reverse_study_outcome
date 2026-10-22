package e72;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f471166a = 0;

    static {
    }

    public static void a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "fileList");
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L12;
        a r101 = new a();
        String[][] r102 = new String[1][];
        Object[] r103 = r100.toArray(new String[0]);
        if (r103 == null) goto L11;
        r102[0] = (String[]) r103;
        r101.execute1(r102);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L12:
        ALogger.d("HighlightBacktrackUtil", "delete all temp file");
    }

    public static boolean b(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L9;
        if (r101.isDirectory() == false) goto L9;
        return true;
    L9:
        if (r101.exists() == false) goto L15;
        if (r101.delete() == true) goto L15;
        Logger.e("HighlightBacktrackUtil", "Can not delete file: " + r101.getAbsolutePath());
        return false;
    L15:
        return r101.mkdirs();
    }

    public static String c(Context r100) {
        if (r100 != null) goto L20;
    L10:
        String r101 = null;
    L11:
        if (r101 != null) goto L13;
        return null;
    L13:
        String r102 = r101 + File.separator + "highlight";     // Catch: Exception -> L17
        if (b(r102) == true) goto L16;
        return null;
    L16:
        return r102;
    L17:
        e = move-exception;
        Logger.e("HighlightBacktrackUtil", "get backtrack cache file path error: " + e.toString());
        return null;
    L20:
        File r103 = r100.getExternalCacheDir();     // Catch: Exception -> L17
        if (r103 != null) goto L8;
        r103 = r100.getCacheDir();     // Catch: Exception -> L17
    L8:
        if (r103 == null) goto L10;
        r101 = r103.getAbsolutePath();     // Catch: Exception -> L17
        goto L11
    }
}
