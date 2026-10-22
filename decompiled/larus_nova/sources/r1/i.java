package r1;

import android.text.TextUtils;
import com.apm.lite.runtime.ConfigManager;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
public final class i {
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x004b */
    public static JSONArray a(String r100) {
        Closeable r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L31;
        return null;
    L31:
        JSONArray r102 = new JSONArray();     // Catch: Throwable -> L17 IOException -> L19
        BufferedReader r103 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L17 IOException -> L19
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100);     // Catch: IOException -> L15 Throwable -> L24
        if (r104.length() <= LynxResourceModule.DEFAULT_MEDIA_SIZE) goto L9;
        r103.skip(r104.length() - LynxResourceModule.DEFAULT_MEDIA_SIZE);     // Catch: IOException -> L15 Throwable -> L24
    L9:
        String r105 = r103.readLine();     // Catch: IOException -> L15 Throwable -> L24
        if (r105 == null) goto L13;
        r102.put(r105);     // Catch: IOException -> L15 Throwable -> L24
        goto L9
    L13:
        com.apm.lite.k.j.a(r103);
        return r102;
    L15:
        e = e;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L24
        com.apm.lite.k.j.a(r103);
        return null;
    L19:
        e = e;
        r103 = null;
    L17:
        th = th;
    L26:
        com.apm.lite.k.j.a(r101);
        throw th;
    L24:
        th = th;
        r101 = r2;
        goto L26
    }

    public static JSONArray b(String r100) {
        ConfigManager r101 = com.apm.lite.e.f29913e;
        return a(com.apm.lite.k.g.a(r100, r101.getLogcatDumpCount(), r101.getLogcatLevel()).getAbsolutePath());
    L5:
        com.apm.lite.c.a();
        return null;
    }
}
