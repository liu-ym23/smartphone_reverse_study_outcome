package l17;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.r;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f506995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JSONObject f506996b;

    public static JSONObject a() {
        if (f506995a == true) goto L5;
        r.b("[DebugUtil] should never get here! erro get debug json object");
        return null;
    L5:
        if (f506996b != null) goto L43;
        Context r100 = TTWebContext.h().getContext();
        if (g.f(r100, "ttwebview.json") == true) goto L9;
        JSONObject r101 = null;
    L19:
        f506996b = r101;
        if (r101 != null) goto L49;
        return null;
    L49:
        r.d("[Settings] Get config from assets in debugMode. soVersion:" + f506996b.get("sdk_upto_so_versioncode"));     // Catch: Exception -> L24
    L24:
        e = move-exception;
        r.c("[Settings] Get config from assets. ", e);
        goto L43
    L9:
        AssetManager r102 = r100.getAssets();
        StringBuilder r103 = new StringBuilder();
        BufferedReader r104 = new BufferedReader(new InputStreamReader(r102.open("ttwebview.json")));     // Catch: Throwable -> L30 Exception -> L32
    L54:
        String r105 = r104.readLine();     // Catch: Throwable -> L26 Exception -> L28
        if (r105 == null) goto L14;
        r103.append(r105);     // Catch: Throwable -> L26 Exception -> L28
        goto L54
    L14:
        r101 = new JSONObject(r103.toString());     // Catch: Throwable -> L26 Exception -> L28
        r104.close();     // Catch: IOException -> L17
    L17:
        e = move-exception;
        k.b(new String[]{e.toString()});
        goto L19
    L28:
        e = e;
    L33:
        k.b(new String[]{"json error:" + e.toString()});     // Catch: Throwable -> L30
        throw new RuntimeException("ttwebview.json has error!", e);     // Catch: Throwable -> L30
    L26:
        th = th;
    L36:
        if (r104 != null) goto L46;
    L41:
        throw th;
    L46:
        r104.close();     // Catch: IOException -> L39
    L39:
        e = move-exception;
        k.b(new String[]{e.toString()});
    L30:
        th = th;
        r104 = null;
    L32:
        e = e;
    L43:
        return f506996b;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x005b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:16777307), block:B:28:0x005b */
    public static JSONObject b(String r100) {
        BufferedReader r101 = null;
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L16 Exception -> L18
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L14 Throwable -> L27
    L5:
        String r104 = r102.readLine();     // Catch: Exception -> L14 Throwable -> L27
        if (r104 == null) goto L8;
        r103.append(r104);     // Catch: Exception -> L14 Throwable -> L27
        goto L5
    L8:
        JSONObject r105 = new JSONObject(r103.toString());     // Catch: Exception -> L14 Throwable -> L27
        r102.close();     // Catch: IOException -> L11
    L13:
        return r105;
    L11:
        e = move-exception;
        k.b(new String[]{e.toString()});
    L14:
        e = e;
    L20:
        k.b(new String[]{e.toString()});     // Catch: Throwable -> L27
        if (r102 != null) goto L42;
    L26:
        return null;
    L42:
        r102.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        k.b(new String[]{e.toString()});
        goto L26
    L27:
        th = th;
        r101 = r3;
    L29:
        if (r101 != null) goto L37;
    L34:
        throw th;
    L37:
        r101.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        k.b(new String[]{e.toString()});
    L18:
        e = e;
        r102 = null;
    L16:
        th = th;
        goto L29
    }
}
