package or3;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static JSONObject a(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "jsonObj");
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r4.keys();     // Catch: Exception -> L9
    L5:
        if (r1.hasNext() == false) goto L8;
        String r2 = r1.next();     // Catch: Exception -> L9
        r0.put(r2, b(r4.opt(r2)));     // Catch: Exception -> L9
    L8:
        return r0;
    }

    public static Object b(Object r4) {
        if ((r4 instanceof JSONObject) == false) goto L6;
        return a((JSONObject) r4);
    L6:
        if ((r4 instanceof JSONArray) == false) goto L14;
        JSONArray r5 = (JSONArray) r4;
        Intrinsics.checkNotNullParameter(r5, "jsonArr");
        JSONArray r0 = new JSONArray();
        int r1 = r5.length();     // Catch: Exception -> L22
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L27;
        r0.put(b(r5.opt(r2)));     // Catch: Exception -> L22
        r2 = r2 + 1;
    L27:
        return r0;
    L14:
        if ((r4 instanceof String) == false) goto L16;
        return r4;
    L16:
        if ((r4 instanceof Number) == false) goto L18;
        return r4;
    L18:
        if ((r4 instanceof Boolean) == true) goto L30;
        Object r3 = JSONObject.NULL;
        return r4;
    L30:
        return r4;
    }

    public static List d(JSONArray r5) {
        ArrayList r0 = new ArrayList();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        Object r3 = r5.get(r2);
        if ((r3 instanceof JSONObject) == false) goto L8;
        r3 = e((JSONObject) r3);
    L10:
        r0.add(r3);
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r3 instanceof JSONArray) == false) goto L10;
        r3 = d((JSONArray) r3);
        goto L10
    L11:
        return r0;
    }

    public static Map e(JSONObject r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        Object r3 = r5.get(r2);
        if ((r3 instanceof JSONObject) == false) goto L9;
        r3 = e((JSONObject) r3);
    L11:
        r0.put(r2, r3);
        goto L4
    L9:
        if ((r3 instanceof JSONArray) == false) goto L11;
        r3 = d((JSONArray) r3);
        goto L11
    L12:
        return r0;
    }

    public static Long c(JSONObject r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "jsonObj");
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r0 = r2.opt(r3);
        if ((r0 instanceof Boolean) == true) goto L5;
        return Long.valueOf(JSONObjectProtectorUtils.getLong(r2, r3));
    L12:
        return null;
    L5:
        if (((Boolean) r0).booleanValue() == false) goto L7;
        long r4 = 1;
    L9:
        return Long.valueOf(r4);
    L7:
        r4 = 0;
        goto L9
    }
}
