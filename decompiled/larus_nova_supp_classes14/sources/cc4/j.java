package cc4;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public static Map<String, Long> a(long r14, JSONArray r16, String r17, String r18) {
        HashMap r3 = new HashMap();
        if (r16 != null) goto L5;
    L64:
        return r3;
    L5:
        if (r16.length() <= 0) goto L64;
        int r10 = 0;
        long r11 = -1;
        if ("nocaptcha".equals(r17) == false) goto L36;
        HashMap r1 = new HashMap();
        if ("pre_collect".equals(r18) == false) goto L22;
        long r2 = 0;
    L12:
        if (r10 >= r16.length()) goto L18;
        JSONObject r4 = r16.optJSONObject(r10);
        if (r4 == null) goto L16;
        r2 = r2 + r4.optLong("et");
    L16:
        r10 = r10 + 1;
        goto L12
    L18:
        if (r14 <= 0) goto L20;
        r11 = r2 / r14;
    L20:
        r1.put("zenith", Long.valueOf(r11));
    L34:
        return r1;
    L22:
        if ("async_collect".equals(r18) == false) goto L34;
        long r5 = 0;
    L25:
        if (r10 >= r16.length()) goto L31;
        JSONObject r6 = r16.optJSONObject(r10);
        if (r6 == null) goto L29;
        r5 = r5 + r6.optLong("t");
    L29:
        r10 = r10 + 1;
        goto L25
    L31:
        if (r14 <= 0) goto L33;
        r11 = r5 / r14;
    L33:
        r1.put("tranquility", Long.valueOf(r11));
        goto L34
    L36:
        if ("nocaptcha_collect".equals(r17) == false) goto L64;
        HashMap r7 = new HashMap();
        if ("pre_collect".equals(r18) == false) goto L51;
        long r8 = 0;
    L41:
        if (r10 >= r16.length()) goto L47;
        JSONObject r9 = r16.optJSONObject(r10);
        if (r9 == null) goto L45;
        r8 = r8 + r9.optLong("et");
    L45:
        r10 = r10 + 1;
        goto L41
    L47:
        if (r14 <= 0) goto L49;
        r11 = r8 % r14;
    L49:
        r7.put("renaissance", Long.valueOf(r11));
    L63:
        return r7;
    L51:
        if ("async_collect".equals(r18) == false) goto L63;
        long r12 = 0;
    L54:
        if (r10 >= r16.length()) goto L60;
        JSONObject r13 = r16.optJSONObject(r10);
        if (r13 == null) goto L58;
        r12 = r12 + r13.optLong("t");
    L58:
        r10 = r10 + 1;
        goto L54
    L60:
        if (r14 <= 0) goto L62;
        r11 = r12 % r14;
    L62:
        r7.put("miraculous", Long.valueOf(r11));
        goto L63
    }
}
