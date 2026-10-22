package xc3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final List<Object> a(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toNestedList");
        ArrayList r101 = new ArrayList(r100.length());
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(c(r100.opt(r103)));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final Map<String, Object> b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toNestedMap");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, c(r100.opt(r103)));
        goto L4
    L6:
        return r101;
    }

    public static final Object c(Object r100) {
        if (Intrinsics.areEqual(r100, JSONObject.NULL) == false) goto L6;
        return null;
    L6:
        if ((r100 instanceof JSONObject) == false) goto L9;
        return b((JSONObject) r100);
    L9:
        if ((r100 instanceof JSONArray) == true) goto L11;
        return r100;
    L11:
        return a((JSONArray) r100);
    }
}
