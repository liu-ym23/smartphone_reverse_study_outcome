package tr3;

import com.bytedance.apm.util.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class c {
    public static void b(String r100) {
        if (com.bytedance.apm.d.j() == false) goto L6;
        ps3.b.a(new String[]{r100, ""});
        return;
    }

    public static JSONObject a(boolean r100, int r101, Exception r102, JSONObject r103) {
        if (r103 != null) goto L11;
        r103 = new JSONObject();
    L11:
        r103.put("success", r100);     // Catch: Exception -> L8
        r103.put("code", r101);     // Catch: Exception -> L8
        if (r102 == null) goto L10;
        r103.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, r102.getMessage() + s.a(r102, 30));     // Catch: Exception -> L8
        r103.put("exception_object", r102);     // Catch: Exception -> L8
    L10:
        return r103;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
