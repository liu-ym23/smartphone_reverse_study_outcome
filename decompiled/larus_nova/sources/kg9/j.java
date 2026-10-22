package kg9;

import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import ita.k;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f503397a = null;

    static {
        f503397a = Arrays.asList(new String[]{RomUtils.BRAND_HUAWEI, RomUtils.BRAND_HONOR});
    }

    public static void a(Context r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getDataDir().getAbsolutePath() + r101 + "/webview_data.lock");
        if (r102.exists() == true) goto L32;
        return;
    L32:
        FileLock r103 = new RandomAccessFile(r102, "rw").getChannel().tryLock();     // Catch: Exception -> L17
        if (r103 == null) goto L9;
        r103.close();     // Catch: Exception -> L17
    L31:
        return;
    L9:
        if (r102.delete() == false) goto L31;
        if (r102.exists() == true) goto L31;
        r102.createNewFile();     // Catch: IOException -> L14 Exception -> L17
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L17
    L18:
        if (r102.exists() == false) goto L20;
        boolean r104 = r102.delete();
    L21:
        if (r104 == true) goto L23;
        return;
    L23:
        if (r102.exists() == true) goto L38;
        r102.createNewFile();     // Catch: IOException -> L26
        return;
    L26:
        e = move-exception;
        e.printStackTrace();
        return;
    L38:
        return;
    L20:
        r104 = false;
        goto L21
    }

    public static void b(boolean r100, Context r101) {
        if (Build.VERSION.SDK_INT < 28) goto L16;
        if (r100 == false) goto L14;
        a(r101, "/app_webview");
        if (f503397a.contains(Build.BRAND.toLowerCase(Locale.getDefault())) == false) goto L17;
        a(r101, "/app_hws_webview");
        return;
    L17:
        return;
    L14:
        WebView.setDataDirectorySuffix(k.c(r101));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
