package ur3;

import android.text.TextUtils;
import com.bytedance.apm.util.r;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.IHttpService;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.monitor.cloudmessage.consts.CloudControlInf;
import ff7.b;
import ff7.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import qu3.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f551373a = "https://mon.zijieapi.com/monitor/collect/c/logcollect";

    public static boolean a(String r100, String r101, String r102, List r110, String r111, JSONObject r112, tr3.a r113) {
        IHttpService r103 = (IHttpService) c.a(IHttpService.class);     // Catch: Exception -> L46 IOException -> L49
        HashMap r104 = new HashMap();     // Catch: Exception -> L46 IOException -> L49
        r104.put("scene", r111);     // Catch: Exception -> L46 IOException -> L49
        g r105 = r103.buildMultipartUpload(f551373a, "UTF-8", false, r104);     // Catch: Exception -> L46 IOException -> L49
        r105.a("aid", r100);     // Catch: Exception -> L46 IOException -> L49
        r105.a("verify_info", r.a());     // Catch: Exception -> L46 IOException -> L49
        r105.a("device_id", r101);     // Catch: Exception -> L46 IOException -> L49
        r105.a("os", "Android");     // Catch: Exception -> L46 IOException -> L49
        r105.a("process_name", r102);     // Catch: Exception -> L46 IOException -> L49
        Iterator r106 = r110.iterator();     // Catch: Exception -> L46 IOException -> L49
    L6:
        if (r106.hasNext() == false) goto L10;
        PolarisFileWrapper r107 = new PolarisFileWrapper((String) r106.next());     // Catch: Exception -> L46 IOException -> L49
        if (r107.exists() == false) goto L6;
        HashMap r108 = new HashMap();     // Catch: Exception -> L46 IOException -> L49
        r108.put("logtype", CloudControlInf.ALOG);     // Catch: Exception -> L46 IOException -> L49
        r108.put("scene", r111);     // Catch: Exception -> L46 IOException -> L49
        r108.put("env", "params.txt");     // Catch: Exception -> L46 IOException -> L49
        r105.b(r107.getName(), r107, null, r108);     // Catch: Exception -> L46 IOException -> L49
        goto L6
    L10:
        HashMap r109 = new HashMap();     // Catch: Exception -> L46 IOException -> L49
        r109.put("filetype", "common_params");     // Catch: Exception -> L46 IOException -> L49
        r109.put("logtype", "env");     // Catch: Exception -> L46 IOException -> L49
        if (r112 != null) goto L13;
        String r114 = null;
    L15:
        if (TextUtils.isEmpty(r114) == false) goto L19;
        JSONObject r115 = new JSONObject();     // Catch: Exception -> L46 IOException -> L49
        r115.put("defaultData", "none commonParams");     // Catch: JSONException -> L53 Exception -> L46 IOException -> L49
    L18:
        r114 = r115.toString();     // Catch: Exception -> L46 IOException -> L49
    L19:
        r105.c(r114, r109);     // Catch: Exception -> L46 IOException -> L49
        b r116 = r105.finish();     // Catch: Exception -> L46 IOException -> L49
    L41:
        e = move-exception;
        if (r113 != null) goto L44;
    L52:
        return false;
    L44:
        r113.a(false, 7, e, null);     // Catch: Exception -> L46 IOException -> L49
        goto L52
    L21:
        if (r116.f476669c != null) goto L25;
        if (r113 == null) goto L24;
        JSONObject r117 = new JSONObject();     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        r117.put("ALOG_UPLOAD_RESPONSE", "null");     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        r117.put("ALOG_UPLOAD_STATUS", r116.f476667a);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        r113.a(false, 11, null, r117);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
    L24:
        return false;
    L25:
        JSONObject r118 = new JSONObject(new String(r116.f476669c));     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        if (r118.optInt(LKBaseResponseModel.ERROR_NO_KEY, -1) != 200) goto L38;
        String r119 = r118.optString("message");     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        if ("long escape".equals(r119) == false) goto L30;
    L36:
        r113.a(false, 13, null, r118);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        return false;
    L30:
        if ("drop data".equals(r119) == true) goto L36;
        if (r113 == null) goto L35;
        r113.a(true, -1, null, r118);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
    L35:
        return true;
    L38:
        if (r113 == null) goto L52;
        r113.a(false, 6, null, r118);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        goto L52
    L13:
        r114 = r112.toString();     // Catch: Exception -> L46 IOException -> L49
    L49:
        e = move-exception;
        if (r113 == null) goto L52;
        r113.a(false, 8, e, null);
    L46:
        e = move-exception;
        if (r113 == null) goto L52;
        r113.a(false, 10, e, null);
        goto L52
    }
}
