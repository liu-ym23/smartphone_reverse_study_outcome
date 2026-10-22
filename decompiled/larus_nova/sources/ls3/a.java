package ls3;

import android.text.TextUtils;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import ita.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f510531a = null;

    static {
        f510531a = new AtomicInteger(0);
    }

    public static List<JSONObject> d(byte[] r100) {
        String r101 = new String(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        JSONObject r103 = new JSONObject(r101);     // Catch: Exception -> L32
        int r104 = 0;
        if (r103.has("list") == false) goto L26;
        JSONArray r105 = r103.optJSONArray("list");     // Catch: Exception -> L32
        if (r105 != null) goto L12;
        return null;
    L12:
        int r106 = 0;
    L14:
        if (r106 >= r105.length()) goto L31;
        JSONObject r107 = JSONArrayProtectorUtils.getJSONObject(r105, r106);     // Catch: Exception -> L32
        if (r107 == null) goto L25;
        JSONArray r108 = r107.optJSONArray("data");     // Catch: Exception -> L32
        if (r108 == null) goto L25;
        int r109 = 0;
    L23:
        if (r109 >= r108.length()) goto L25;
        r102.add(JSONArrayProtectorUtils.getJSONObject(r108, r109));     // Catch: Exception -> L32
        r109 = r109 + 1;     // Catch: Exception -> L32
    L25:
        r106 = r106 + 1;     // Catch: Exception -> L32
        goto L14
    L26:
        JSONArray r110 = r103.optJSONArray("data");     // Catch: Exception -> L32
    L28:
        if (r104 >= r110.length()) goto L31;
        r102.add(JSONArrayProtectorUtils.getJSONObject(r110, r104));     // Catch: Exception -> L32
        r104 = r104 + 1;
    L31:
        return r102;
    }

    public static void b(JSONObject r100, String r101) {
        if (r100 != null) goto L7;
        return;
    L7:
        DoctorManager.getInstance().a(r101, r100);     // Catch: Exception -> L6
        return;
    }

    public static void c(byte[] r100, JSONObject r101) {
        Iterator r102 = ((ArrayList) d(r100)).iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        JSONObject r103 = (JSONObject) r102.next();
        JSONObject r104 = new JSONObject(r101.toString());     // Catch: JSONException -> L11
        JSONObject r105 = r103.optJSONObject("DATA_DOCTOR");     // Catch: JSONException -> L11
        if (r105 == null) goto L9;
        r104.put("DATA_DOCTOR", r105);     // Catch: JSONException -> L11
    L9:
        b(r104, "DATA_SEND_RESPONSE");     // Catch: JSONException -> L11
        b(r103.put("response", r104), "DATA_SEND_RESPONSE_NEW");     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public static void a(String r100, JSONObject r101, boolean r102) {
        JSONObject r103 = r101.optJSONObject("DATA_DOCTOR");
        if (r103 != null) goto L14;
        r103 = new JSONObject();
    L14:
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (r103.optInt("DATA_ID", -1) != (-1)) goto L9;
        r103.put("DATA_ID", f510531a.incrementAndGet());     // Catch: Exception -> L11
    L9:
        r103.put("DATA_PROCESS", k.c(xu3.a.getContext()));     // Catch: Exception -> L11
        r103.put("DATA_TYPE", r100);     // Catch: Exception -> L11
        r103.put("DATA_SAMPLE", r102);     // Catch: Exception -> L11
        r103.put("DATA_AID", du3.a.b());     // Catch: Exception -> L11
        r101.put("DATA_DOCTOR", r103);     // Catch: Exception -> L11
        JSONObject r104 = new JSONObject(r101.toString());     // Catch: Exception -> L11
        DoctorManager.getInstance().a("DATA_RECEIVE", r104);     // Catch: Exception -> L11
        DoctorManager.getInstance().a("DATA_CACHE", r104);     // Catch: Exception -> L11
    }
}
