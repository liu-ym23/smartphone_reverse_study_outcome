package jh4;

import com.bytedance.mira.Mira;
import com.bytedance.mira.plugin.Plugin;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements d.c {
    public a() {
    }

    public final JSONArray a() {
        JSONArray r100 = new JSONArray();
        Iterator<Plugin> r101 = Mira.listPlugins().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Plugin r102 = r101.next();
        JSONObject r103 = new JSONObject();
        r103.put("is_installed", r102.isInstalled());     // Catch: Throwable -> L9
        r103.put("is_installing", r102.isInstalling());     // Catch: Throwable -> L9
        r103.put("version_code", r102.mVersionCode);     // Catch: Throwable -> L9
        r103.put("package_name", r102.mPackageName);     // Catch: Throwable -> L9
        r103.put("release_build", r102.mReleaseBuild);     // Catch: Throwable -> L9
    L7:
        r100.put(r103);
        goto L4
    L8:
        return r100;
    }
}
