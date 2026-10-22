package eu8;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes26.dex */
public final class c {
    public static g a(Context r100, JsonObject r101) {
        if (r100 == null) goto L43;
        if (r101 == null) goto L43;
        nu8.a.h("ExecutorBuilder", "createInner input ORIGINAL cmd : " + r101);
        JsonObject r102 = new JsonObject();     // Catch: Exception -> L18
        Iterator<String> r103 = r101.keySet().iterator();     // Catch: Exception -> L18
    L8:
        if (r103.hasNext() == false) goto L17;
        String r104 = r103.next();     // Catch: Exception -> L18
        JsonElement r105 = r101.get(r104);     // Catch: Exception -> L18
        if (r105 == null) goto L8;
        if (r105.isJsonNull() == true) goto L8;
        if (TextUtils.isEmpty(r105.getAsString()) == true) goto L8;
        r102.add(r104, r105);     // Catch: Exception -> L18
        goto L8
    L17:
        r101 = r102;
    L20:
        nu8.a.h("ExecutorBuilder", "createInner input CLEANED cmd : " + r101);
        String r106 = r101.get("cmd").getAsString();
        String[] r107 = r106.split(" ");
    L41:
        e = move-exception;
        StringWriter r108 = new StringWriter();
        e.printStackTrace(new PrintWriter(r108));
        nu8.a.c("ExecutorBuilder", "createInner failed: ", e);
        a r109 = new f(r100, r108.toString());
    L45:
        return new g(r109);
    L22:
        if (r106.startsWith("delete innerData") == false) goto L25;
        r109 = new b(r100, r101, b(r100, r107[2], false));     // Catch: Exception -> L41
    L48:
        goto L45
    L25:
        if (r106.startsWith("delete outerData") == false) goto L28;
        r109 = new b(r100, r101, b(r100, r107[2], true));     // Catch: Exception -> L41
        goto L48
    L28:
        if (r106.startsWith("set keva") == false) goto L30;
    L39:
        r109 = e.c(r100, r101);     // Catch: Exception -> L41
        goto L48
    L30:
        if (r106.startsWith("delete keva") == true) goto L39;
        if (r106.startsWith("set sp") == false) goto L35;
    L38:
        r109 = h.c(r100, r101);     // Catch: Exception -> L41
        goto L48
    L35:
        if (r106.startsWith("delete sp") == true) goto L38;
        r109 = new f(r100, "unsupport cmd");     // Catch: Exception -> L41
    L18:
        e = move-exception;
        nu8.a.c("ExecutorBuilder", "removeEmptyProperties failed: ", e);
    L43:
        r109 = new f(r100, "invalid params");
        goto L45
    }

    public static ArrayList<File> b(Context r100, String r101, boolean r102) {
        if (r102 == true) goto L5;
        String r103 = r100.getFilesDir().getParent();
    L9:
        ArrayList<File> r104 = new ArrayList();
        if (r103 == null) goto L28;
        List<File> r105 = lu8.b.b(r103, true);
        if (r105 == null) goto L28;
        Iterator r106 = ((ArrayList) r105).iterator();     // Catch: Exception -> L26
    L15:
        if (r106.hasNext() == false) goto L28;
        File r107 = (File) r106.next();     // Catch: Exception -> L26
        if (r107 == null) goto L15;
        if (r107.exists() == false) goto L15;
        if (r107.isFile() == false) goto L15;
        String r108 = r107.getAbsolutePath().substring((r107.getAbsolutePath().indexOf(r103) + r103.length()) + 1);     // Catch: Exception -> L26
        nu8.a.a("ExecutorBuilder", "subFilePath is " + r108 + " params is " + r101);     // Catch: Exception -> L26
        if (r108.matches(a.b(r101)) == false) goto L15;
        nu8.a.h("ExecutorBuilder", "match files success: " + r108);     // Catch: Exception -> L26
        r104.add(new PolarisFileWrapper(r103, r108));     // Catch: Exception -> L26
    L26:
        e = move-exception;
        nu8.a.b("ExecutorBuilder", "getMatchesFiles failed: " + e);
    L28:
        return r104;
    L5:
        if (r100.getExternalCacheDir() == null) goto L7;
        r103 = r100.getExternalCacheDir().getParent();
        goto L9
    L7:
        r103 = null;
        goto L9
    }
}
