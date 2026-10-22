package xc3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final List<Object> a(JSONArray r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$toNestedList");
        ArrayList r0 = new ArrayList(r4.length());
        int r1 = r4.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(c(r4.opt(r2)));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static final Map<String, Object> b(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$toNestedMap");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r4.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        r0.put(r2, c(r4.opt(r2)));
        goto L4
    L6:
        return r0;
    }

    public static final Object c(Object r1) {
        if (Intrinsics.areEqual(r1, JSONObject.NULL) == false) goto L6;
        return null;
    L6:
        if ((r1 instanceof JSONObject) == false) goto L9;
        return b((JSONObject) r1);
    L9:
        if ((r1 instanceof JSONArray) == true) goto L11;
        return r1;
    L11:
        return a((JSONArray) r1);
    }
}
