package t17;

import android.text.TextUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static boolean b(String r100) {
        if (a("performance_modules", "memory", r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (q17.a.e().d() == true) goto L8;
        return false;
    }

    public static void c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return;
    L12:
        IApmAgent r101 = (IApmAgent) ServiceManager.getService(IApmAgent.class);     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put(r100, 1);     // Catch: Exception -> L9
        ff7.a.C5893a r103 = new ff7.a.C5893a();     // Catch: Exception -> L9
        r103.f476664a = "memory_dump_event";     // Catch: Exception -> L9
        r103.f476665b = r102;     // Catch: Exception -> L9
        r103.f476666c = true;     // Catch: Exception -> L9
        r101.monitorEvent(new ff7.a(r103));     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static void d(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return;
    L12:
        IApmAgent r102 = (IApmAgent) ServiceManager.getService(IApmAgent.class);     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put(r100, r101);     // Catch: Exception -> L9
        r102.monitorEvent("memory_dump_event", null, r103, null);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean a(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L22:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        if (TextUtils.isEmpty(r102) == true) goto L22;
        IConfigManager r103 = (IConfigManager) ServiceManager.getService(IConfigManager.class);     // Catch: Exception -> L20
        if (r103 == null) goto L25;
        JSONObject r104 = r103.getConfigJSON(r100);     // Catch: Exception -> L20
        if (r104 == null) goto L26;
        JSONObject r105 = r104.optJSONObject(r101);     // Catch: Exception -> L20
        if (r105 == null) goto L27;
        if (r105.optInt(r102, 0) != 1) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    L25:
        return false;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }
}
