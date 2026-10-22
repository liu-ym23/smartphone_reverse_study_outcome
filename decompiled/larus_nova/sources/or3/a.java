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

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f524932a = 0;

    static {
    }

    public static JSONObject a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = r100.keys();     // Catch: Exception -> L9
    L5:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();     // Catch: Exception -> L9
        r101.put(r103, b(r100.opt(r103)));     // Catch: Exception -> L9
    L8:
        return r101;
    }

    public static Object b(Object r100) {
        if ((r100 instanceof JSONObject) == false) goto L6;
        return a((JSONObject) r100);
    L6:
        if ((r100 instanceof JSONArray) == false) goto L14;
        JSONArray r101 = (JSONArray) r100;
        Intrinsics.checkNotNullParameter(r101, "jsonArr");
        JSONArray r102 = new JSONArray();
        int r103 = r101.length();     // Catch: Exception -> L22
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L27;
        r102.put(b(r101.opt(r104)));     // Catch: Exception -> L22
        r104 = r104 + 1;
    L27:
        return r102;
    L14:
        if ((r100 instanceof String) == false) goto L16;
        return r100;
    L16:
        if ((r100 instanceof Number) == false) goto L18;
        return r100;
    L18:
        if ((r100 instanceof Boolean) == true) goto L30;
        Object r105 = JSONObject.NULL;
        return r100;
    L30:
        return r100;
    }

    public static List d(JSONArray r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONObject) == false) goto L8;
        r104 = e((JSONObject) r104);
    L10:
        r101.add(r104);
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof JSONArray) == false) goto L10;
        r104 = d((JSONArray) r104);
        goto L10
    L11:
        return r101;
    }

    public static Map e(JSONObject r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONObject) == false) goto L9;
        r104 = e((JSONObject) r104);
    L11:
        r101.put(r103, r104);
        goto L4
    L9:
        if ((r104 instanceof JSONArray) == false) goto L11;
        r104 = d((JSONArray) r104);
        goto L11
    L12:
        return r101;
    }

    public static Long c(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = r100.opt(r101);
        if ((r102 instanceof Boolean) == true) goto L5;
        return Long.valueOf(JSONObjectProtectorUtils.getLong(r100, r101));
    L12:
        return null;
    L5:
        if (((Boolean) r102).booleanValue() == false) goto L7;
        long r103 = 1;
    L9:
        return Long.valueOf(r103);
    L7:
        r103 = 0;
        goto L9
    }
}
