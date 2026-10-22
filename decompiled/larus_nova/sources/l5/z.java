package l5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class z {
    public static void a(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L11;
        Iterator<String> r102 = r101.keys();
    L6:
        if (r102.hasNext() == false) goto L17;
        String r103 = r102.next();
        if (r100.has(r103) == true) goto L6;
        r100.put(r103, r101.get(r103));
        goto L6
    L17:
        return;
    }

    public static final a0 b(Map<String, a0> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        LinkedHashMap r102 = (LinkedHashMap) r100;
        a0 r103 = (a0) r102.get(r101);
        if (r103 != null) goto L6;
        a0 r104 = new a0();
        r102.put(r101, r104);
        return r104;
    L6:
        return r103;
    }
}
