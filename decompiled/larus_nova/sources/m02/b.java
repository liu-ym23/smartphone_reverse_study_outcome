package m02;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static String a(String r100) {
        String r101 = File.separator;
        if (r100.endsWith(r101) == false) goto L6;
        return r100.concat(ComposerHelper.CONFIG_FILE_NAME);
    L6:
        return r100 + r101 + ComposerHelper.CONFIG_FILE_NAME;
    }

    public static String b(String r100) {
        if (new PolarisFileWrapper(r100).exists() == true) goto L51;
    L42:
        return null;
    L51:
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L20 IOException -> L22
    L53:
        InputStreamReader r102 = new InputStreamReader(r101, "UTF-8");     // Catch: Throwable -> L16 IOException -> L18
        char[] r103 = new char[r101.available()];     // Catch: IOException -> L14 Throwable -> L32
        r102.read(r103);     // Catch: IOException -> L12 Throwable -> L32
        r102.close();     // Catch: IOException -> L12 Throwable -> L32
        r101.close();     // Catch: IOException -> L12 Throwable -> L32
        r102.close();     // Catch: IOException -> L10
        r101.close();     // Catch: IOException -> L10
    L29:
        if (r103 == null) goto L42;
        return new String(r103);
    L12:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L32
        if (r102 == null) goto L27;
        r102.close();     // Catch: IOException -> L10
    L27:
        if (r101 == null) goto L29;
        r101.close();     // Catch: IOException -> L10
    L14:
        e = e;
        r103 = null;
    L32:
        Throwable th10 = th;
    L33:
        if (r102 != null) goto L45;
    L37:
        if (r101 == null) goto L41;
        r101.close();     // Catch: IOException -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
    L41:
        throw th10;
    L45:
        r102.close();     // Catch: IOException -> L35
        goto L37
    L18:
        e = e;
        r102 = null;
        r103 = null;
    L16:
        th = move-exception;
        th10 = th;
        r102 = null;
    L22:
        e = e;
        r102 = null;
        r101 = null;
        r103 = null;
    L20:
        th = move-exception;
        r101 = null;
        th10 = th;
        r102 = null;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }
}
