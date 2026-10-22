package yk7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    static {
    }

    public static void a(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject("activity_info");
        if (r101 == null) goto L18;
        Iterator<String> r102 = r101.keys();
    L6:
        if (r102.hasNext() == false) goto L31;
        String r103 = r102.next();
        Object r104 = d(r101, r103 + ".activity_custom");
        if ((r104 instanceof String) == false) goto L17;
        JSONObject r105 = new JSONObject((String) r104);     // Catch: Exception -> L13
        JSONObject r106 = r101.optJSONObject(r103);     // Catch: Exception -> L13
        if (r106 == null) goto L6;
        r106.put("activity_custom", r105);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("JSONUtils", "exception when translate to json " + e);
        JSONObject r107 = r101.optJSONObject(r103);
        if (r107 == null) goto L6;
        r107.put("activity_custom", new JSONObject());
        goto L6
    L17:
        boolean r108 = r104 instanceof JSONObject;
        goto L6
    L31:
        return;
    }

    public static void b(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject("common_info");
        if (r101 == null) goto L24;
        Object r102 = d(r101, "extra");
        if ((r102 instanceof String) == false) goto L11;
        r101.put("extra", new JSONObject((String) r102));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("JSONUtils", "exception when convert extra string " + e);
        Unit r103 = Unit.INSTANCE;
        return;
    L11:
        if ((r102 instanceof JSONObject) == false) goto L35;
        Iterator<String> r104 = ((JSONObject) r102).keys();
    L14:
        if (r104.hasNext() == false) goto L37;
        String r105 = r104.next();
        Object r106 = ((JSONObject) r102).get(r105);     // Catch: Exception -> L22
        if (r106 == null) goto L19;
        String r107 = r106.toString();     // Catch: Exception -> L22
    L20:
        ((JSONObject) r102).put(r105, new JSONObject(r107));     // Catch: Exception -> L22
        goto L14
    L19:
        r107 = null;
    L22:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("JSONUtils", "Exception when convert extra value string " + e);
        goto L14
    L37:
        return;
    L35:
        return;
    }

    public static void c(JSONObject r100) {
        Object r101 = d(r100, "extra");
        if ((r101 instanceof String) == false) goto L11;
        r100.put("extra", new JSONObject((String) r101));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("JSONUtils", "exception when convert extra string " + e);
        return;
    }

    public static Object d(JSONObject r110, String r111) {
        int r100 = 0;
        if (StringsKt.contains$default(r111, ".", false, 2, null) == false) goto L31;
        List r101 = StringsKt.split$default(r111, new String[]{"."}, false, 0, 6, null);
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        if (((String) r104).length() <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L6;
        r102.add(r104);
        goto L6
    L10:
        r105 = false;
        goto L11
    L14:
        if (r102.isEmpty() == false) goto L17;
        com.bytedance.ug.sdk.luckydog.api.log.d.e("JSONUtils", "key error, check has correct key " + r111);
    L17:
        if (r102.size() <= 1) goto L27;
        int r112 = r102.size() - 1;
    L19:
        if (r100 >= r112) goto L24;
        if (r110 == null) goto L22;
        r110 = r110.optJSONObject((String) ListProtector.get(r102, r100));
    L23:
        r100 = r100 + 1;
        goto L19
    L22:
        r110 = null;
        goto L23
    L24:
        if (r110 != null) goto L46;
        return null;
    L46:
        return r110.opt((String) ListProtector.get(r102, r102.size() - 1));
    L27:
        if (r102.size() != 1) goto L48;
        return r110.opt((String) ListProtector.get(r102, 0));
    L48:
        return r110.opt(r111);
    L31:
        if (r111.length() <= 0) goto L33;
        r100 = 1;
    L33:
        if (r100 != 0) goto L35;
        return r110;
    L35:
        return r110.opt(r111);
    }
}
