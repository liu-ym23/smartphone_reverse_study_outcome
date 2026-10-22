package isb;

import android.os.SystemClock;
import com.bytedance.apm.ApmAgent;
import com.bytedance.common.utility.NetworkUtils;
import com.ss.android.lark.appcontext.applifecycle.a0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static boolean b() {
        NetworkUtils.NetworkType r100 = NetworkUtils.getNetworkType(LarkContext.getApplication());
        if (r100 != NetworkUtils.NetworkType.MOBILE) goto L5;
    L13:
        return false;
    L5:
        if (r100 == NetworkUtils.NetworkType.MOBILE_2G) goto L13;
        if (r100 == NetworkUtils.NetworkType.MOBILE_3G) goto L13;
        if (r100 == NetworkUtils.NetworkType.MOBILE_4G) goto L13;
        if (r100 == NetworkUtils.NetworkType.MOBILE_5G) goto L13;
        return true;
    }

    public static void a(JSONObject r100, JSONObject r101) {
        if (r101 == null) goto L21;
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L11
    L6:
        if (r102.hasNext() == false) goto L22;
        String r103 = r102.next();     // Catch: Exception -> L11
        Object r104 = r101.opt(r103);     // Catch: Exception -> L11
        if (r104 == null) goto L6;
        r100.put("extra_" + r103, r104);     // Catch: Exception -> L11
        goto L6
    L22:
        return;
    L11:
        e = move-exception;
        Log.d("MonitorUtils", e);
        return;
    }

    public static void c(String r100, JSONObject r101) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L4
        int r103 = a0.f408823b;     // Catch: JSONException -> L4
        r102.put("since_latest_enter_foreground", SystemClock.elapsedRealtime() - a0.f408822a);     // Catch: JSONException -> L4
        r102.put("since_startup", SystemClock.elapsedRealtime() - 0);     // Catch: JSONException -> L4
        ApmAgent.monitorEvent(r100, null, r101, r102);     // Catch: JSONException -> L4
        return;
    }
}
