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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final AtomicInteger a = null;

    static {
        a = new AtomicInteger(0);
    }

    public static List<JSONObject> d(byte[] r7) {
        String r1 = new String(r7);
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return null;
    L5:
        ArrayList r8 = new ArrayList();
        JSONObject r3 = new JSONObject(r1);     // Catch: Exception -> L32
        int r4 = 0;
        if (r3.has("list") == false) goto L26;
        JSONArray r0 = r3.optJSONArray("list");     // Catch: Exception -> L32
        if (r0 != null) goto L12;
        return null;
    L12:
        int r2 = 0;
    L14:
        if (r2 >= r0.length()) goto L31;
        JSONObject r5 = JSONArrayProtectorUtils.getJSONObject(r0, r2);     // Catch: Exception -> L32
        if (r5 == null) goto L25;
        JSONArray r6 = r5.optJSONArray("data");     // Catch: Exception -> L32
        if (r6 == null) goto L25;
        int r9 = 0;
    L23:
        if (r9 >= r6.length()) goto L25;
        r8.add(JSONArrayProtectorUtils.getJSONObject(r6, r9));     // Catch: Exception -> L32
        r9 = r9 + 1;     // Catch: Exception -> L32
    L25:
        r2 = r2 + 1;     // Catch: Exception -> L32
        goto L14
    L26:
        JSONArray r10 = r3.optJSONArray("data");     // Catch: Exception -> L32
    L28:
        if (r4 >= r10.length()) goto L31;
        r8.add(JSONArrayProtectorUtils.getJSONObject(r10, r4));     // Catch: Exception -> L32
        r4 = r4 + 1;
    L31:
        return r8;
    }

    public static void b(JSONObject r1, String r2) {
        if (r1 != null) goto L7;
        return;
    L7:
        DoctorManager.getInstance().a(r2, r1);     // Catch: Exception -> L6
        return;
    }

    public static void c(byte[] r4, JSONObject r5) {
        Iterator r6 = ((ArrayList) d(r4)).iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        JSONObject r1 = (JSONObject) r6.next();
        JSONObject r2 = new JSONObject(r5.toString());     // Catch: JSONException -> L11
        JSONObject r3 = r1.optJSONObject("DATA_DOCTOR");     // Catch: JSONException -> L11
        if (r3 == null) goto L9;
        r2.put("DATA_DOCTOR", r3);     // Catch: JSONException -> L11
    L9:
        b(r2, "DATA_SEND_RESPONSE");     // Catch: JSONException -> L11
        b(r1.put("response", r2), "DATA_SEND_RESPONSE_NEW");     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public static void a(String r5, JSONObject r6, boolean r7) {
        JSONObject r2 = r6.optJSONObject("DATA_DOCTOR");
        if (r2 != null) goto L14;
        r2 = new JSONObject();
    L14:
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (r2.optInt("DATA_ID", -1) != (-1)) goto L9;
        r2.put("DATA_ID", a.incrementAndGet());     // Catch: Exception -> L11
    L9:
        r2.put("DATA_PROCESS", k.c(xu3.a.getContext()));     // Catch: Exception -> L11
        r2.put("DATA_TYPE", r5);     // Catch: Exception -> L11
        r2.put("DATA_SAMPLE", r7);     // Catch: Exception -> L11
        r2.put("DATA_AID", du3.a.b());     // Catch: Exception -> L11
        r6.put("DATA_DOCTOR", r2);     // Catch: Exception -> L11
        JSONObject r8 = new JSONObject(r6.toString());     // Catch: Exception -> L11
        DoctorManager.getInstance().a("DATA_RECEIVE", r8);     // Catch: Exception -> L11
        DoctorManager.getInstance().a("DATA_CACHE", r8);     // Catch: Exception -> L11
    }
}
