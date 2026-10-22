package um7;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d {
    public static void a(String r100, String r101, Map<String, String> r102) {
        JSONObject r103 = new JSONObject();
        r103.put("luckydog_type", r100);     // Catch: Throwable -> L5
        r103.put("luckydog_path", r101);     // Catch: Throwable -> L5
        r103.put("luckydog_base", r102.get("luckydog_base"));     // Catch: Throwable -> L5
        r103.put("luckydog_data", r102.get("luckydog_data"));     // Catch: Throwable -> L5
        r103.put("luckydog_token", r102.get("luckydog_token"));     // Catch: Throwable -> L5
        e.b("luckydog_check_token_params:" + r103.toString());     // Catch: Throwable -> L5
        rm7.c.a.f538587a.e("luckydog_check_token_params", r103);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        e.b(th.getLocalizedMessage());
    }
}
