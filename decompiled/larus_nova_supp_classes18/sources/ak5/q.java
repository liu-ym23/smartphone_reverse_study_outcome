package ak5;

import com.bytedance.ee.bear.net.RawServerResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements Function<p, RawServerResult> {
    public q() {
    }

    public final Object apply(Object r10) throws Exception {
        p r11 = (p) r10;
        String r5 = "";
        Object[] r2 = {0, "", ""};
        JSONObject r7 = new JSONObject(r11.b);     // Catch: Exception -> L7 JSONException -> L9
        int r1 = r7.optInt("code");     // Catch: Exception -> L7 JSONException -> L9
        String r8 = r7.optString("msg");     // Catch: Exception -> L7 JSONException -> L9
        r2[0] = Integer.valueOf(r1);     // Catch: Exception -> L7 JSONException -> L9
        r2[1] = r8;     // Catch: Exception -> L7 JSONException -> L9
        JSONObject r3 = r7.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L7 JSONException -> L9
        if (r3 == null) goto L11;
        r2[2] = r3.toString();     // Catch: Exception -> L7 JSONException -> L9
    L11:
        RawServerResult r4 = new RawServerResult();
        r4.setCode(((Integer) r2[0]).intValue());
        r4.setMsg((String) r2[1]);
        r4.setData((String) r2[2]);
        r4.setJson(r11.b);
        Map<String, List<String>> r6 = r11.c;
        if (r6 == null) goto L19;
        List<String> r9 = r6.get("x-tt-logid");
        if (r9 == null) goto L19;
        if (r9.size() <= 0) goto L19;
        r5 = (String) ListProtector.get(r9, 0);
    L19:
        r4.setLogId(r5);
        if (r4.getCode() == 0) goto L22;
        tt5.a.d("ParseCodeFun", "request error! url = " + r11.a + ", code = " + r4.getCode() + ", message = " + r4.getMsg() + ", logId = " + r4.getLogId());
    L22:
        return r4;
    L9:
        e = move-exception;
        tt5.a.e("ParseCodeFun", "parseBody JSONException", e, false);
    L7:
        e = move-exception;
        tt5.a.e("ParseCodeFun", "parseBody Exception", e, false);
        goto L11
    }
}
